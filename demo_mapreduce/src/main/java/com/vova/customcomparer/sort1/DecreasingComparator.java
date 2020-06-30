package com.vova.customcomparer.sort1;

import org.apache.hadoop.io.*;

/**
 * @author WangYang - vova
 * @version Create in 4:38 PM 2020/6/30
 */


public class DecreasingComparator extends WritableComparator {
    @Override
    public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2) {
        Long o1 = readLong(b1, s1);                   // parse key1
        Long o2 = readLong(b2, s2);                   // parse key1
        // clean up reference


        return o1.compareTo(o2);
        
    }
}
