package com.twitter.elephantbird.mapreduce.input;

import java.io.IOException;
import java.io.InputStream;

import com.twitter.elephantbird.mapreduce.io.BinaryBlockReader;
import com.twitter.elephantbird.mapreduce.io.BinaryWritable;
import com.twitter.elephantbird.util.HadoopUtils;
import com.twitter.elephantbird.util.TypeRef;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Counter;
import org.apache.hadoop.mapred.InputSplit;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A reader for LZO-encoded protobuf blocks, generally written by
 * a ProtobufBlockWriter or similar.
 *
 * <p>
 * A small fraction of bad records are tolerated. See {@link LzoRecordReader}
 * for more information on error handling.
 */
public class LzoBinaryBlockRecordReader<M, W extends BinaryWritable<M>> extends LzoRecordReader<LongWritable, W> {
  private static final Logger LOG = LoggerFactory.getLogger(LzoBinaryBlockRecordReader.class);

  private final LongWritable key_;
  private final W value_;
  private final TypeRef<M> typeRef_;

  private final BinaryBlockReader<M> reader_;

  // private Counter recordsReadCounter;
  // private Counter recordErrorsCounter;

  public LzoBinaryBlockRecordReader(TypeRef<M> typeRef, BinaryBlockReader<M> reader, W binaryWritable) {
    key_ = new LongWritable();
    value_ = binaryWritable;
    reader_ = reader;
    typeRef_ = typeRef;
  }

  @Override
  public synchronized void close() throws IOException {
    if (reader_ != null) {
      reader_.close();
    }
  }

  @Override
  public LongWritable createKey() {
    return key_;
  }

  @Override
  public W createValue() {
    return value_;
  }

  @Override
  protected void createInputReader(InputStream input, Configuration conf) throws IOException {
    reader_.setInputStream(input);
  }

  @Override
  public void initialize(InputSplit genericSplit, Configuration job) throws IOException {
    // String group = "LzoBlocks of " + typeRef_.getRawClass().getName();
    // recordsReadCounter = HadoopUtils.getCounter(context, group, "Records Read");
    // recordErrorsCounter = HadoopUtils.getCounter(context, group, "Errors");

    super.initialize(genericSplit, job);
  }

  @Override
  protected void skipToNextSyncPoint(boolean atFirstRecord) throws IOException {
    // No need to skip to the sync point here; the block reader will do it for us.
    LOG.debug("LzoProtobufBlockRecordReader.skipToNextSyncPoint called with atFirstRecord = " + atFirstRecord);
  }

  /**
   * Read the next key, value pair.
   * <p>
   * A small fraction of bad records in input are tolerated.
   * See  {@link LzoRecordReader} for more information on error handling.
   *
   * @return true if a key/value pair was read
   * @throws IOException
   */
  @Override
  public boolean next(LongWritable key, W value) throws IOException {
    // If we are past the end of the file split, tell the reader not to read any more new blocks.
    // Then continue reading until the last of the reader's already-parsed values are used up.
    // The next split will start at the next sync point and no records will be missed.
    while (true) { // loop to skip over bad records
      if (pos_ > end_) {
        reader_.markNoMoreNewBlocks();
      }
      value_.set(null);
      errorTracker.incRecords();
      Throwable decodeException = null;

      try {
        if (!reader_.readNext(value_)) {
          return false; // EOF
        }
      } catch (IOException e) {
        throw e;
      } catch (Throwable e) {
        decodeException = e;
      }

      key_.set(pos_);
      pos_ = getLzoFilePos();
      if (value_.get() != null) {
        // recordsReadCounter.increment(1);
        return true;
      }
      errorTracker.incErrors(decodeException);
      // recordErrorsCounter.increment(1);
      // continue
    }
  }
}
