package com.vova.customcomparer.sort3;

import org.apache.hadoop.io.DataInputBuffer;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.RawComparator;

import java.io.IOException;

/**
 * @author WangYang - vova
 * @version Create in 5:55 PM 2020/6/30
 */


public class MyRawComparator implements RawComparator<LongWritable> {

    LongWritable key1 = new LongWritable();
    LongWritable key2 = new LongWritable();
    DataInputBuffer buffer = new DataInputBuffer();
    @Override
    public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2) {
        try {
            buffer.reset(b1, s1, l1);                   // parse key1
            key1.readFields(buffer);

            buffer.reset(b2, s2, l2);                   // parse key2
            key2.readFields(buffer);

            buffer.reset(null, 0, 0);                   // clean up reference
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return compare(key1, key2);                   // compare them
        
    }

   

    @Override
    public int compare(LongWritable o1, LongWritable o2) {

        return -o1.compareTo(o2);
    }
}
