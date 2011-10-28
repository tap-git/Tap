// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tap/samples/src/proto/CountRec.proto

package tap.sample;

public final class Protos {
  private Protos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public static final class CountRec extends
      com.google.protobuf.GeneratedMessage {
    // Use CountRec.newBuilder() to construct.
    private CountRec() {
      initFields();
    }
    private CountRec(boolean noInit) {}
    
    private static final CountRec defaultInstance;
    public static CountRec getDefaultInstance() {
      return defaultInstance;
    }
    
    public CountRec getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return tap.sample.Protos.internal_static_tap_sample_CountRec_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return tap.sample.Protos.internal_static_tap_sample_CountRec_fieldAccessorTable;
    }
    
    // required string word = 1;
    public static final int WORD_FIELD_NUMBER = 1;
    private boolean hasWord;
    private java.lang.String word_ = "";
    public boolean hasWord() { return hasWord; }
    public java.lang.String getWord() { return word_; }
    
    // required int32 count = 2;
    public static final int COUNT_FIELD_NUMBER = 2;
    private boolean hasCount;
    private int count_ = 0;
    public boolean hasCount() { return hasCount; }
    public int getCount() { return count_; }
    
    private void initFields() {
    }
    public final boolean isInitialized() {
      if (!hasWord) return false;
      if (!hasCount) return false;
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (hasWord()) {
        output.writeString(1, getWord());
      }
      if (hasCount()) {
        output.writeInt32(2, getCount());
      }
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (hasWord()) {
        size += com.google.protobuf.CodedOutputStream
          .computeStringSize(1, getWord());
      }
      if (hasCount()) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, getCount());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    public static tap.sample.Protos.CountRec parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static tap.sample.Protos.CountRec parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static tap.sample.Protos.CountRec parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static tap.sample.Protos.CountRec parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static tap.sample.Protos.CountRec parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static tap.sample.Protos.CountRec parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static tap.sample.Protos.CountRec parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static tap.sample.Protos.CountRec parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static tap.sample.Protos.CountRec parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static tap.sample.Protos.CountRec parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(tap.sample.Protos.CountRec prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> {
      private tap.sample.Protos.CountRec result;
      
      // Construct using tap.sample.Protos.CountRec.newBuilder()
      private Builder() {}
      
      private static Builder create() {
        Builder builder = new Builder();
        builder.result = new tap.sample.Protos.CountRec();
        return builder;
      }
      
      protected tap.sample.Protos.CountRec internalGetResult() {
        return result;
      }
      
      public Builder clear() {
        if (result == null) {
          throw new IllegalStateException(
            "Cannot call clear() after build().");
        }
        result = new tap.sample.Protos.CountRec();
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(result);
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return tap.sample.Protos.CountRec.getDescriptor();
      }
      
      public tap.sample.Protos.CountRec getDefaultInstanceForType() {
        return tap.sample.Protos.CountRec.getDefaultInstance();
      }
      
      public boolean isInitialized() {
        return result.isInitialized();
      }
      public tap.sample.Protos.CountRec build() {
        if (result != null && !isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return buildPartial();
      }
      
      private tap.sample.Protos.CountRec buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        if (!isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      public tap.sample.Protos.CountRec buildPartial() {
        if (result == null) {
          throw new IllegalStateException(
            "build() has already been called on this Builder.");
        }
        tap.sample.Protos.CountRec returnMe = result;
        result = null;
        return returnMe;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof tap.sample.Protos.CountRec) {
          return mergeFrom((tap.sample.Protos.CountRec)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(tap.sample.Protos.CountRec other) {
        if (other == tap.sample.Protos.CountRec.getDefaultInstance()) return this;
        if (other.hasWord()) {
          setWord(other.getWord());
        }
        if (other.hasCount()) {
          setCount(other.getCount());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder(
            this.getUnknownFields());
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              this.setUnknownFields(unknownFields.build());
              return this;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                this.setUnknownFields(unknownFields.build());
                return this;
              }
              break;
            }
            case 10: {
              setWord(input.readString());
              break;
            }
            case 16: {
              setCount(input.readInt32());
              break;
            }
          }
        }
      }
      
      
      // required string word = 1;
      public boolean hasWord() {
        return result.hasWord();
      }
      public java.lang.String getWord() {
        return result.getWord();
      }
      public Builder setWord(java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  result.hasWord = true;
        result.word_ = value;
        return this;
      }
      public Builder clearWord() {
        result.hasWord = false;
        result.word_ = getDefaultInstance().getWord();
        return this;
      }
      
      // required int32 count = 2;
      public boolean hasCount() {
        return result.hasCount();
      }
      public int getCount() {
        return result.getCount();
      }
      public Builder setCount(int value) {
        result.hasCount = true;
        result.count_ = value;
        return this;
      }
      public Builder clearCount() {
        result.hasCount = false;
        result.count_ = 0;
        return this;
      }
      
      // @@protoc_insertion_point(builder_scope:tap.sample.CountRec)
    }
    
    static {
      defaultInstance = new CountRec(true);
      tap.sample.Protos.internalForceInit();
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:tap.sample.CountRec)
  }
  
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_tap_sample_CountRec_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_tap_sample_CountRec_fieldAccessorTable;
  
  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n$tap/samples/src/proto/CountRec.proto\022\n" +
      "tap.sample\"\'\n\010CountRec\022\014\n\004word\030\001 \002(\t\022\r\n\005" +
      "count\030\002 \002(\005B\010B\006Protos"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_tap_sample_CountRec_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_tap_sample_CountRec_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_tap_sample_CountRec_descriptor,
              new java.lang.String[] { "Word", "Count", },
              tap.sample.Protos.CountRec.class,
              tap.sample.Protos.CountRec.Builder.class);
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }
  
  public static void internalForceInit() {}
  
  // @@protoc_insertion_point(outer_class_scope)
}