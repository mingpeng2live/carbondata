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
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2019-12-05")
public class LocalDictionaryChunkMeta implements org.apache.thrift.TBase<LocalDictionaryChunkMeta, LocalDictionaryChunkMeta._Fields>, java.io.Serializable, Cloneable, Comparable<LocalDictionaryChunkMeta> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("LocalDictionaryChunkMeta");

  private static final org.apache.thrift.protocol.TField ENCODERS_FIELD_DESC = new org.apache.thrift.protocol.TField("encoders", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField ENCODER_META_FIELD_DESC = new org.apache.thrift.protocol.TField("encoder_meta", org.apache.thrift.protocol.TType.LIST, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new LocalDictionaryChunkMetaStandardSchemeFactory());
    schemes.put(TupleScheme.class, new LocalDictionaryChunkMetaTupleSchemeFactory());
  }

  public List<org.apache.carbondata.format.Encoding> encoders; // required
  public List<ByteBuffer> encoder_meta; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ENCODERS((short)1, "encoders"),
    ENCODER_META((short)2, "encoder_meta");

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
        case 1: // ENCODERS
          return ENCODERS;
        case 2: // ENCODER_META
          return ENCODER_META;
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
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ENCODERS, new org.apache.thrift.meta_data.FieldMetaData("encoders", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, org.apache.carbondata.format.Encoding.class))));
    tmpMap.put(_Fields.ENCODER_META, new org.apache.thrift.meta_data.FieldMetaData("encoder_meta", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING            , true))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(LocalDictionaryChunkMeta.class, metaDataMap);
  }

  public LocalDictionaryChunkMeta() {
  }

  public LocalDictionaryChunkMeta(
    List<org.apache.carbondata.format.Encoding> encoders,
    List<ByteBuffer> encoder_meta)
  {
    this();
    this.encoders = encoders;
    this.encoder_meta = encoder_meta;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public LocalDictionaryChunkMeta(LocalDictionaryChunkMeta other) {
    if (other.isSetEncoders()) {
      List<org.apache.carbondata.format.Encoding> __this__encoders = new ArrayList<org.apache.carbondata.format.Encoding>(other.encoders.size());
      for (org.apache.carbondata.format.Encoding other_element : other.encoders) {
        __this__encoders.add(other_element);
      }
      this.encoders = __this__encoders;
    }
    if (other.isSetEncoder_meta()) {
      List<ByteBuffer> __this__encoder_meta = new ArrayList<ByteBuffer>(other.encoder_meta);
      this.encoder_meta = __this__encoder_meta;
    }
  }

  public LocalDictionaryChunkMeta deepCopy() {
    return new LocalDictionaryChunkMeta(this);
  }

  @Override
  public void clear() {
    this.encoders = null;
    this.encoder_meta = null;
  }

  public int getEncodersSize() {
    return (this.encoders == null) ? 0 : this.encoders.size();
  }

  public java.util.Iterator<org.apache.carbondata.format.Encoding> getEncodersIterator() {
    return (this.encoders == null) ? null : this.encoders.iterator();
  }

  public void addToEncoders(org.apache.carbondata.format.Encoding elem) {
    if (this.encoders == null) {
      this.encoders = new ArrayList<org.apache.carbondata.format.Encoding>();
    }
    this.encoders.add(elem);
  }

  public List<org.apache.carbondata.format.Encoding> getEncoders() {
    return this.encoders;
  }

  public LocalDictionaryChunkMeta setEncoders(List<org.apache.carbondata.format.Encoding> encoders) {
    this.encoders = encoders;
    return this;
  }

  public void unsetEncoders() {
    this.encoders = null;
  }

  /** Returns true if field encoders is set (has been assigned a value) and false otherwise */
  public boolean isSetEncoders() {
    return this.encoders != null;
  }

  public void setEncodersIsSet(boolean value) {
    if (!value) {
      this.encoders = null;
    }
  }

  public int getEncoder_metaSize() {
    return (this.encoder_meta == null) ? 0 : this.encoder_meta.size();
  }

  public java.util.Iterator<ByteBuffer> getEncoder_metaIterator() {
    return (this.encoder_meta == null) ? null : this.encoder_meta.iterator();
  }

  public void addToEncoder_meta(ByteBuffer elem) {
    if (this.encoder_meta == null) {
      this.encoder_meta = new ArrayList<ByteBuffer>();
    }
    this.encoder_meta.add(elem);
  }

  public List<ByteBuffer> getEncoder_meta() {
    return this.encoder_meta;
  }

  public LocalDictionaryChunkMeta setEncoder_meta(List<ByteBuffer> encoder_meta) {
    this.encoder_meta = encoder_meta;
    return this;
  }

  public void unsetEncoder_meta() {
    this.encoder_meta = null;
  }

  /** Returns true if field encoder_meta is set (has been assigned a value) and false otherwise */
  public boolean isSetEncoder_meta() {
    return this.encoder_meta != null;
  }

  public void setEncoder_metaIsSet(boolean value) {
    if (!value) {
      this.encoder_meta = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ENCODERS:
      if (value == null) {
        unsetEncoders();
      } else {
        setEncoders((List<org.apache.carbondata.format.Encoding>)value);
      }
      break;

    case ENCODER_META:
      if (value == null) {
        unsetEncoder_meta();
      } else {
        setEncoder_meta((List<ByteBuffer>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ENCODERS:
      return getEncoders();

    case ENCODER_META:
      return getEncoder_meta();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ENCODERS:
      return isSetEncoders();
    case ENCODER_META:
      return isSetEncoder_meta();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof LocalDictionaryChunkMeta)
      return this.equals((LocalDictionaryChunkMeta)that);
    return false;
  }

  public boolean equals(LocalDictionaryChunkMeta that) {
    if (that == null)
      return false;

    boolean this_present_encoders = true && this.isSetEncoders();
    boolean that_present_encoders = true && that.isSetEncoders();
    if (this_present_encoders || that_present_encoders) {
      if (!(this_present_encoders && that_present_encoders))
        return false;
      if (!this.encoders.equals(that.encoders))
        return false;
    }

    boolean this_present_encoder_meta = true && this.isSetEncoder_meta();
    boolean that_present_encoder_meta = true && that.isSetEncoder_meta();
    if (this_present_encoder_meta || that_present_encoder_meta) {
      if (!(this_present_encoder_meta && that_present_encoder_meta))
        return false;
      if (!this.encoder_meta.equals(that.encoder_meta))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_encoders = true && (isSetEncoders());
    list.add(present_encoders);
    if (present_encoders)
      list.add(encoders);

    boolean present_encoder_meta = true && (isSetEncoder_meta());
    list.add(present_encoder_meta);
    if (present_encoder_meta)
      list.add(encoder_meta);

    return list.hashCode();
  }

  @Override
  public int compareTo(LocalDictionaryChunkMeta other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetEncoders()).compareTo(other.isSetEncoders());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEncoders()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.encoders, other.encoders);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetEncoder_meta()).compareTo(other.isSetEncoder_meta());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEncoder_meta()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.encoder_meta, other.encoder_meta);
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
    StringBuilder sb = new StringBuilder("LocalDictionaryChunkMeta(");
    boolean first = true;

    sb.append("encoders:");
    if (this.encoders == null) {
      sb.append("null");
    } else {
      sb.append(this.encoders);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("encoder_meta:");
    if (this.encoder_meta == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.encoder_meta, sb);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (encoders == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'encoders' was not present! Struct: " + toString());
    }
    if (encoder_meta == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'encoder_meta' was not present! Struct: " + toString());
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class LocalDictionaryChunkMetaStandardSchemeFactory implements SchemeFactory {
    public LocalDictionaryChunkMetaStandardScheme getScheme() {
      return new LocalDictionaryChunkMetaStandardScheme();
    }
  }

  private static class LocalDictionaryChunkMetaStandardScheme extends StandardScheme<LocalDictionaryChunkMeta> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, LocalDictionaryChunkMeta struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ENCODERS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list210 = iprot.readListBegin();
                struct.encoders = new ArrayList<org.apache.carbondata.format.Encoding>(_list210.size);
                org.apache.carbondata.format.Encoding _elem211;
                for (int _i212 = 0; _i212 < _list210.size; ++_i212)
                {
                  _elem211 = org.apache.carbondata.format.Encoding.findByValue(iprot.readI32());
                  struct.encoders.add(_elem211);
                }
                iprot.readListEnd();
              }
              struct.setEncodersIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // ENCODER_META
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list213 = iprot.readListBegin();
                struct.encoder_meta = new ArrayList<ByteBuffer>(_list213.size);
                ByteBuffer _elem214;
                for (int _i215 = 0; _i215 < _list213.size; ++_i215)
                {
                  _elem214 = iprot.readBinary();
                  struct.encoder_meta.add(_elem214);
                }
                iprot.readListEnd();
              }
              struct.setEncoder_metaIsSet(true);
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
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, LocalDictionaryChunkMeta struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.encoders != null) {
        oprot.writeFieldBegin(ENCODERS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, struct.encoders.size()));
          for (org.apache.carbondata.format.Encoding _iter216 : struct.encoders)
          {
            oprot.writeI32(_iter216.getValue());
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.encoder_meta != null) {
        oprot.writeFieldBegin(ENCODER_META_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.encoder_meta.size()));
          for (ByteBuffer _iter217 : struct.encoder_meta)
          {
            oprot.writeBinary(_iter217);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class LocalDictionaryChunkMetaTupleSchemeFactory implements SchemeFactory {
    public LocalDictionaryChunkMetaTupleScheme getScheme() {
      return new LocalDictionaryChunkMetaTupleScheme();
    }
  }

  private static class LocalDictionaryChunkMetaTupleScheme extends TupleScheme<LocalDictionaryChunkMeta> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, LocalDictionaryChunkMeta struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      {
        oprot.writeI32(struct.encoders.size());
        for (org.apache.carbondata.format.Encoding _iter218 : struct.encoders)
        {
          oprot.writeI32(_iter218.getValue());
        }
      }
      {
        oprot.writeI32(struct.encoder_meta.size());
        for (ByteBuffer _iter219 : struct.encoder_meta)
        {
          oprot.writeBinary(_iter219);
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, LocalDictionaryChunkMeta struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      {
        org.apache.thrift.protocol.TList _list220 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, iprot.readI32());
        struct.encoders = new ArrayList<org.apache.carbondata.format.Encoding>(_list220.size);
        org.apache.carbondata.format.Encoding _elem221;
        for (int _i222 = 0; _i222 < _list220.size; ++_i222)
        {
          _elem221 = org.apache.carbondata.format.Encoding.findByValue(iprot.readI32());
          struct.encoders.add(_elem221);
        }
      }
      struct.setEncodersIsSet(true);
      {
        org.apache.thrift.protocol.TList _list223 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
        struct.encoder_meta = new ArrayList<ByteBuffer>(_list223.size);
        ByteBuffer _elem224;
        for (int _i225 = 0; _i225 < _list223.size; ++_i225)
        {
          _elem224 = iprot.readBinary();
          struct.encoder_meta.add(_elem224);
        }
      }
      struct.setEncoder_metaIsSet(true);
    }
  }

}

