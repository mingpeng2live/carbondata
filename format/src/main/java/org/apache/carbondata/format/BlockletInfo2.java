/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.carbondata.format;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
/**
 * Information about a blocklet for V2 format
 */
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2019-12-05")
public class BlockletInfo2 implements org.apache.thrift.TBase<BlockletInfo2, BlockletInfo2._Fields>, java.io.Serializable, Cloneable, Comparable<BlockletInfo2> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("BlockletInfo2");

  private static final org.apache.thrift.protocol.TField NUM_ROWS_FIELD_DESC = new org.apache.thrift.protocol.TField("num_rows", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField COLUMN_DATA_CHUNKS_OFFSETS_FIELD_DESC = new org.apache.thrift.protocol.TField("column_data_chunks_offsets", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField COLUMN_DATA_CHUNKS_LENGTH_FIELD_DESC = new org.apache.thrift.protocol.TField("column_data_chunks_length", org.apache.thrift.protocol.TType.LIST, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new BlockletInfo2StandardSchemeFactory());
    schemes.put(TupleScheme.class, new BlockletInfo2TupleSchemeFactory());
  }

  public int num_rows; // required
  public List<Long> column_data_chunks_offsets; // required
  public List<Short> column_data_chunks_length; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NUM_ROWS((short)1, "num_rows"),
    COLUMN_DATA_CHUNKS_OFFSETS((short)2, "column_data_chunks_offsets"),
    COLUMN_DATA_CHUNKS_LENGTH((short)3, "column_data_chunks_length");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // NUM_ROWS
          return NUM_ROWS;
        case 2: // COLUMN_DATA_CHUNKS_OFFSETS
          return COLUMN_DATA_CHUNKS_OFFSETS;
        case 3: // COLUMN_DATA_CHUNKS_LENGTH
          return COLUMN_DATA_CHUNKS_LENGTH;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __NUM_ROWS_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NUM_ROWS, new org.apache.thrift.meta_data.FieldMetaData("num_rows", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.COLUMN_DATA_CHUNKS_OFFSETS, new org.apache.thrift.meta_data.FieldMetaData("column_data_chunks_offsets", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64))));
    tmpMap.put(_Fields.COLUMN_DATA_CHUNKS_LENGTH, new org.apache.thrift.meta_data.FieldMetaData("column_data_chunks_length", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I16))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(BlockletInfo2.class, metaDataMap);
  }

  public BlockletInfo2() {
  }

  public BlockletInfo2(
    int num_rows,
    List<Long> column_data_chunks_offsets,
    List<Short> column_data_chunks_length)
  {
    this();
    this.num_rows = num_rows;
    setNum_rowsIsSet(true);
    this.column_data_chunks_offsets = column_data_chunks_offsets;
    this.column_data_chunks_length = column_data_chunks_length;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public BlockletInfo2(BlockletInfo2 other) {
    __isset_bitfield = other.__isset_bitfield;
    this.num_rows = other.num_rows;
    if (other.isSetColumn_data_chunks_offsets()) {
      List<Long> __this__column_data_chunks_offsets = new ArrayList<Long>(other.column_data_chunks_offsets);
      this.column_data_chunks_offsets = __this__column_data_chunks_offsets;
    }
    if (other.isSetColumn_data_chunks_length()) {
      List<Short> __this__column_data_chunks_length = new ArrayList<Short>(other.column_data_chunks_length);
      this.column_data_chunks_length = __this__column_data_chunks_length;
    }
  }

  public BlockletInfo2 deepCopy() {
    return new BlockletInfo2(this);
  }

  @Override
  public void clear() {
    setNum_rowsIsSet(false);
    this.num_rows = 0;
    this.column_data_chunks_offsets = null;
    this.column_data_chunks_length = null;
  }

  public int getNum_rows() {
    return this.num_rows;
  }

  public BlockletInfo2 setNum_rows(int num_rows) {
    this.num_rows = num_rows;
    setNum_rowsIsSet(true);
    return this;
  }

  public void unsetNum_rows() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __NUM_ROWS_ISSET_ID);
  }

  /** Returns true if field num_rows is set (has been assigned a value) and false otherwise */
  public boolean isSetNum_rows() {
    return EncodingUtils.testBit(__isset_bitfield, __NUM_ROWS_ISSET_ID);
  }

  public void setNum_rowsIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __NUM_ROWS_ISSET_ID, value);
  }

  public int getColumn_data_chunks_offsetsSize() {
    return (this.column_data_chunks_offsets == null) ? 0 : this.column_data_chunks_offsets.size();
  }

  public java.util.Iterator<Long> getColumn_data_chunks_offsetsIterator() {
    return (this.column_data_chunks_offsets == null) ? null : this.column_data_chunks_offsets.iterator();
  }

  public void addToColumn_data_chunks_offsets(long elem) {
    if (this.column_data_chunks_offsets == null) {
      this.column_data_chunks_offsets = new ArrayList<Long>();
    }
    this.column_data_chunks_offsets.add(elem);
  }

  public List<Long> getColumn_data_chunks_offsets() {
    return this.column_data_chunks_offsets;
  }

  public BlockletInfo2 setColumn_data_chunks_offsets(List<Long> column_data_chunks_offsets) {
    this.column_data_chunks_offsets = column_data_chunks_offsets;
    return this;
  }

  public void unsetColumn_data_chunks_offsets() {
    this.column_data_chunks_offsets = null;
  }

  /** Returns true if field column_data_chunks_offsets is set (has been assigned a value) and false otherwise */
  public boolean isSetColumn_data_chunks_offsets() {
    return this.column_data_chunks_offsets != null;
  }

  public void setColumn_data_chunks_offsetsIsSet(boolean value) {
    if (!value) {
      this.column_data_chunks_offsets = null;
    }
  }

  public int getColumn_data_chunks_lengthSize() {
    return (this.column_data_chunks_length == null) ? 0 : this.column_data_chunks_length.size();
  }

  public java.util.Iterator<Short> getColumn_data_chunks_lengthIterator() {
    return (this.column_data_chunks_length == null) ? null : this.column_data_chunks_length.iterator();
  }

  public void addToColumn_data_chunks_length(short elem) {
    if (this.column_data_chunks_length == null) {
      this.column_data_chunks_length = new ArrayList<Short>();
    }
    this.column_data_chunks_length.add(elem);
  }

  public List<Short> getColumn_data_chunks_length() {
    return this.column_data_chunks_length;
  }

  public BlockletInfo2 setColumn_data_chunks_length(List<Short> column_data_chunks_length) {
    this.column_data_chunks_length = column_data_chunks_length;
    return this;
  }

  public void unsetColumn_data_chunks_length() {
    this.column_data_chunks_length = null;
  }

  /** Returns true if field column_data_chunks_length is set (has been assigned a value) and false otherwise */
  public boolean isSetColumn_data_chunks_length() {
    return this.column_data_chunks_length != null;
  }

  public void setColumn_data_chunks_lengthIsSet(boolean value) {
    if (!value) {
      this.column_data_chunks_length = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case NUM_ROWS:
      if (value == null) {
        unsetNum_rows();
      } else {
        setNum_rows((Integer)value);
      }
      break;

    case COLUMN_DATA_CHUNKS_OFFSETS:
      if (value == null) {
        unsetColumn_data_chunks_offsets();
      } else {
        setColumn_data_chunks_offsets((List<Long>)value);
      }
      break;

    case COLUMN_DATA_CHUNKS_LENGTH:
      if (value == null) {
        unsetColumn_data_chunks_length();
      } else {
        setColumn_data_chunks_length((List<Short>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case NUM_ROWS:
      return getNum_rows();

    case COLUMN_DATA_CHUNKS_OFFSETS:
      return getColumn_data_chunks_offsets();

    case COLUMN_DATA_CHUNKS_LENGTH:
      return getColumn_data_chunks_length();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case NUM_ROWS:
      return isSetNum_rows();
    case COLUMN_DATA_CHUNKS_OFFSETS:
      return isSetColumn_data_chunks_offsets();
    case COLUMN_DATA_CHUNKS_LENGTH:
      return isSetColumn_data_chunks_length();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof BlockletInfo2)
      return this.equals((BlockletInfo2)that);
    return false;
  }

  public boolean equals(BlockletInfo2 that) {
    if (that == null)
      return false;

    boolean this_present_num_rows = true;
    boolean that_present_num_rows = true;
    if (this_present_num_rows || that_present_num_rows) {
      if (!(this_present_num_rows && that_present_num_rows))
        return false;
      if (this.num_rows != that.num_rows)
        return false;
    }

    boolean this_present_column_data_chunks_offsets = true && this.isSetColumn_data_chunks_offsets();
    boolean that_present_column_data_chunks_offsets = true && that.isSetColumn_data_chunks_offsets();
    if (this_present_column_data_chunks_offsets || that_present_column_data_chunks_offsets) {
      if (!(this_present_column_data_chunks_offsets && that_present_column_data_chunks_offsets))
        return false;
      if (!this.column_data_chunks_offsets.equals(that.column_data_chunks_offsets))
        return false;
    }

    boolean this_present_column_data_chunks_length = true && this.isSetColumn_data_chunks_length();
    boolean that_present_column_data_chunks_length = true && that.isSetColumn_data_chunks_length();
    if (this_present_column_data_chunks_length || that_present_column_data_chunks_length) {
      if (!(this_present_column_data_chunks_length && that_present_column_data_chunks_length))
        return false;
      if (!this.column_data_chunks_length.equals(that.column_data_chunks_length))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_num_rows = true;
    list.add(present_num_rows);
    if (present_num_rows)
      list.add(num_rows);

    boolean present_column_data_chunks_offsets = true && (isSetColumn_data_chunks_offsets());
    list.add(present_column_data_chunks_offsets);
    if (present_column_data_chunks_offsets)
      list.add(column_data_chunks_offsets);

    boolean present_column_data_chunks_length = true && (isSetColumn_data_chunks_length());
    list.add(present_column_data_chunks_length);
    if (present_column_data_chunks_length)
      list.add(column_data_chunks_length);

    return list.hashCode();
  }

  @Override
  public int compareTo(BlockletInfo2 other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetNum_rows()).compareTo(other.isSetNum_rows());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNum_rows()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.num_rows, other.num_rows);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetColumn_data_chunks_offsets()).compareTo(other.isSetColumn_data_chunks_offsets());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetColumn_data_chunks_offsets()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.column_data_chunks_offsets, other.column_data_chunks_offsets);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetColumn_data_chunks_length()).compareTo(other.isSetColumn_data_chunks_length());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetColumn_data_chunks_length()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.column_data_chunks_length, other.column_data_chunks_length);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("BlockletInfo2(");
    boolean first = true;

    sb.append("num_rows:");
    sb.append(this.num_rows);
    first = false;
    if (!first) sb.append(", ");
    sb.append("column_data_chunks_offsets:");
    if (this.column_data_chunks_offsets == null) {
      sb.append("null");
    } else {
      sb.append(this.column_data_chunks_offsets);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("column_data_chunks_length:");
    if (this.column_data_chunks_length == null) {
      sb.append("null");
    } else {
      sb.append(this.column_data_chunks_length);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'num_rows' because it's a primitive and you chose the non-beans generator.
    if (column_data_chunks_offsets == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'column_data_chunks_offsets' was not present! Struct: " + toString());
    }
    if (column_data_chunks_length == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'column_data_chunks_length' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class BlockletInfo2StandardSchemeFactory implements SchemeFactory {
    public BlockletInfo2StandardScheme getScheme() {
      return new BlockletInfo2StandardScheme();
    }
  }

  private static class BlockletInfo2StandardScheme extends StandardScheme<BlockletInfo2> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, BlockletInfo2 struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // NUM_ROWS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.num_rows = iprot.readI32();
              struct.setNum_rowsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // COLUMN_DATA_CHUNKS_OFFSETS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list104 = iprot.readListBegin();
                struct.column_data_chunks_offsets = new ArrayList<Long>(_list104.size);
                long _elem105;
                for (int _i106 = 0; _i106 < _list104.size; ++_i106)
                {
                  _elem105 = iprot.readI64();
                  struct.column_data_chunks_offsets.add(_elem105);
                }
                iprot.readListEnd();
              }
              struct.setColumn_data_chunks_offsetsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // COLUMN_DATA_CHUNKS_LENGTH
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list107 = iprot.readListBegin();
                struct.column_data_chunks_length = new ArrayList<Short>(_list107.size);
                short _elem108;
                for (int _i109 = 0; _i109 < _list107.size; ++_i109)
                {
                  _elem108 = iprot.readI16();
                  struct.column_data_chunks_length.add(_elem108);
                }
                iprot.readListEnd();
              }
              struct.setColumn_data_chunks_lengthIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      if (!struct.isSetNum_rows()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'num_rows' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, BlockletInfo2 struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(NUM_ROWS_FIELD_DESC);
      oprot.writeI32(struct.num_rows);
      oprot.writeFieldEnd();
      if (struct.column_data_chunks_offsets != null) {
        oprot.writeFieldBegin(COLUMN_DATA_CHUNKS_OFFSETS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I64, struct.column_data_chunks_offsets.size()));
          for (long _iter110 : struct.column_data_chunks_offsets)
          {
            oprot.writeI64(_iter110);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.column_data_chunks_length != null) {
        oprot.writeFieldBegin(COLUMN_DATA_CHUNKS_LENGTH_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I16, struct.column_data_chunks_length.size()));
          for (short _iter111 : struct.column_data_chunks_length)
          {
            oprot.writeI16(_iter111);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class BlockletInfo2TupleSchemeFactory implements SchemeFactory {
    public BlockletInfo2TupleScheme getScheme() {
      return new BlockletInfo2TupleScheme();
    }
  }

  private static class BlockletInfo2TupleScheme extends TupleScheme<BlockletInfo2> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, BlockletInfo2 struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.num_rows);
      {
        oprot.writeI32(struct.column_data_chunks_offsets.size());
        for (long _iter112 : struct.column_data_chunks_offsets)
        {
          oprot.writeI64(_iter112);
        }
      }
      {
        oprot.writeI32(struct.column_data_chunks_length.size());
        for (short _iter113 : struct.column_data_chunks_length)
        {
          oprot.writeI16(_iter113);
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, BlockletInfo2 struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.num_rows = iprot.readI32();
      struct.setNum_rowsIsSet(true);
      {
        org.apache.thrift.protocol.TList _list114 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I64, iprot.readI32());
        struct.column_data_chunks_offsets = new ArrayList<Long>(_list114.size);
        long _elem115;
        for (int _i116 = 0; _i116 < _list114.size; ++_i116)
        {
          _elem115 = iprot.readI64();
          struct.column_data_chunks_offsets.add(_elem115);
        }
      }
      struct.setColumn_data_chunks_offsetsIsSet(true);
      {
        org.apache.thrift.protocol.TList _list117 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I16, iprot.readI32());
        struct.column_data_chunks_length = new ArrayList<Short>(_list117.size);
        short _elem118;
        for (int _i119 = 0; _i119 < _list117.size; ++_i119)
        {
          _elem118 = iprot.readI16();
          struct.column_data_chunks_length.add(_elem118);
        }
      }
      struct.setColumn_data_chunks_lengthIsSet(true);
    }
  }

}

