/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.sql.execution.command.schema

import org.apache.spark.sql.{CarbonEnv, SparkSession}
import org.apache.spark.sql.catalyst.TableIdentifier
import org.apache.spark.sql.catalyst.catalog.CatalogTablePartition
import org.apache.spark.sql.execution.command.{AlterTableRenameModel, MetadataCommand}
import org.apache.spark.sql.hive.{CarbonRelation, CarbonSessionCatalogUtil, MockClassForAlterRevertTests}
import org.apache.spark.util.AlterTableUtil
import org.apache.carbondata.common.exceptions.sql.MalformedCarbonCommandException
import org.apache.carbondata.common.logging.LogServiceFactory
import org.apache.carbondata.core.exception.ConcurrentOperationException
import org.apache.carbondata.core.features.TableOperation
import org.apache.carbondata.core.index.IndexStoreManager
import org.apache.carbondata.core.metadata.{AbsoluteTableIdentifier, CarbonTableIdentifier}
import org.apache.carbondata.core.metadata.schema.table.CarbonTable
import org.apache.carbondata.core.statusmanager.SegmentStatusManager
import org.apache.carbondata.events.{AlterTableRenamePostEvent, AlterTableRenamePreEvent, OperationContext, OperationListenerBus}
import org.apache.carbondata.format.SchemaEvolutionEntry
import org.apache.carbondata.view.MVManagerInSpark

private[sql] case class CarbonAlterTableRenameCommand(
    alterTableRenameModel: AlterTableRenameModel)
  extends MetadataCommand {

  val LOGGER = LogServiceFactory.getLogService(this.getClass.getCanonicalName)

  override def processMetadata(sparkSession: SparkSession): Seq[Nothing] = {
    val oldTableName = alterTableRenameModel.oldTableIdentifier.table.toLowerCase
    val newTableName = alterTableRenameModel.newTableIdentifier.table.toLowerCase
    val oldDatabaseName = alterTableRenameModel.oldTableIdentifier.database
      .getOrElse(sparkSession.catalog.currentDatabase)
    val oldTableIdentifier = TableIdentifier(oldTableName, Some(oldDatabaseName))
    val newTableIdentifier = TableIdentifier(newTableName, Some(oldDatabaseName))
    setAuditTable(oldDatabaseName, oldTableIdentifier.table)
    setAuditInfo(Map("newName" -> alterTableRenameModel.newTableIdentifier.table))
    val newDatabaseName = newTableIdentifier.database
      .getOrElse(sparkSession.catalog.currentDatabase)
    if (!oldDatabaseName.equalsIgnoreCase(newDatabaseName)) {
      throw new MalformedCarbonCommandException("Database name should be same for both tables")
    }
    val tableExists = sparkSession.catalog.tableExists(oldDatabaseName, newTableIdentifier.table)
    if (tableExists) {
      throw new MalformedCarbonCommandException(s"Table with name $newTableIdentifier " +
                                                s"already exists")
    }
    LOGGER.info(s"Rename table request has been received for $oldDatabaseName.$oldTableName")
    val metastore = CarbonEnv.getInstance(sparkSession).carbonMetaStore

    val oldRelation: CarbonRelation = metastore.lookupRelation(oldTableIdentifier)(sparkSession)
        .asInstanceOf[CarbonRelation]
    if (oldRelation == null) {
      throwMetadataException(oldDatabaseName, oldTableName, "Table does not exist")
    }

    val oldCarbonTable: CarbonTable = oldRelation.carbonTable
    if (!oldCarbonTable.getTableInfo.isTransactionalTable) {
      throw new MalformedCarbonCommandException("Unsupported operation on non transactional table")
    }

    if (!oldCarbonTable.canAllow(oldCarbonTable, TableOperation.ALTER_RENAME)) {
      throw new MalformedCarbonCommandException("alter rename is not supported for this table")
    }
    // if table have created MV, not support table rename
    if (MVManagerInSpark.get(sparkSession).hasSchemaOnTable(oldCarbonTable) ||
        oldCarbonTable.isMV) {
      throw new MalformedCarbonCommandException(
        "alter rename is not supported for MV table or for tables which have child MV")
    }

    var timeStamp = 0L
    var hiveRenameSuccess = false
    // lock file path to release locks after operation
//    var carbonTableLockFilePath: String = null
    try {
      // if any load is in progress for table, do not allow rename table
      if (SegmentStatusManager.isLoadInProgressInTable(oldCarbonTable)) {
        throw new ConcurrentOperationException(oldCarbonTable, "loading", "alter table rename")
      }
      // invalid index for the old table, see CARBON-1690
      val oldAbsoluteTableIdentifier = oldCarbonTable.getAbsoluteTableIdentifier
      IndexStoreManager.getInstance().clearIndex(oldAbsoluteTableIdentifier)

      // get the latest carbon table and check for column existence
      val operationContext = new OperationContext
      // TODO: Pass new Table Path in pre-event.
      val alterTableRenamePreEvent: AlterTableRenamePreEvent = AlterTableRenamePreEvent(
        oldCarbonTable,
        alterTableRenameModel,
        "",
        sparkSession)
      OperationListenerBus.getInstance().fireEvent(alterTableRenamePreEvent, operationContext)

      sparkSession.sessionState.catalog.renameTable(oldTableIdentifier, newTableIdentifier)
      val newCarbonTable = metastore.lookupRelation(newTableIdentifier)(sparkSession)
        .asInstanceOf[CarbonRelation].carbonTable
      // update tablepath properties
      CarbonSessionCatalogUtil.alterTablePath(newTableIdentifier, newCarbonTable.getTablePath, sparkSession)
      hiveRenameSuccess = true

      val tableInfo: org.apache.carbondata.format.TableInfo =
        metastore.getThriftTableInfo(newCarbonTable)
      val schemaEvolutionEntry = new SchemaEvolutionEntry(System.currentTimeMillis)
      schemaEvolutionEntry.setTableName(newTableName)
      timeStamp = System.currentTimeMillis()
      schemaEvolutionEntry.setTime_stamp(timeStamp)
      val newCarbonTableIdentifier = new CarbonTableIdentifier(newDatabaseName,
        newTableName, newCarbonTable.getCarbonTableIdentifier.getTableId)
      metastore.removeTableFromMetadata(oldDatabaseName, oldTableName)
      var partitions: Seq[CatalogTablePartition] = Seq.empty
      if (newCarbonTable.isHivePartitionTable) {
        partitions = sparkSession.sessionState.catalog.listPartitions(newTableIdentifier)
      }

      metastore.updateTableSchemaForAlter(
        newCarbonTableIdentifier,
        newCarbonTable.getCarbonTableIdentifier,
        tableInfo,
        schemaEvolutionEntry,
        newCarbonTable.getTablePath)(sparkSession)

      val alterTableRenamePostEvent: AlterTableRenamePostEvent = AlterTableRenamePostEvent(
        newCarbonTable,
        alterTableRenameModel,
        newCarbonTable.getTablePath,
        sparkSession)
      OperationListenerBus.getInstance().fireEvent(alterTableRenamePostEvent, operationContext)

      sparkSession.catalog.refreshTable(newTableIdentifier.quotedString)
      LOGGER.info(s"Table $oldTableName has been successfully renamed to $newTableName")
    } catch {
      case e: ConcurrentOperationException =>
        LOGGER.error("",e)
        throw e
      case e: Exception =>
        LOGGER.error("hiveRenameSuccess: " + hiveRenameSuccess + " carbonTable: " + oldCarbonTable, e)
        if (hiveRenameSuccess) {
          sparkSession.sessionState.catalog.renameTable(newTableIdentifier, oldTableIdentifier)
          CarbonSessionCatalogUtil.alterTablePath(newTableIdentifier, oldCarbonTable.getTablePath, sparkSession)
        }
        if (oldCarbonTable != null) {
          AlterTableUtil.revertRenameTableChanges(
            newTableName,
            oldCarbonTable,
            timeStamp)(
            sparkSession)
        }
        throwMetadataException(oldDatabaseName, oldTableName,
          opName + " operation failed: " + e.getMessage)
    }
    Seq.empty
  }

  override protected def opName: String = "ALTER TABLE RENAME TABLE"
}
