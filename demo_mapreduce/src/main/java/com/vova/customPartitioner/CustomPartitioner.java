package com.vova.customPartitioner;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * @author WangYang - vova
 * @version Create in 3:07 PM 2020/6/30
 */


public class CustomPartitioner extends Partitioner {
    @Override
    public int getPartition(Object o, Object o2, int numPartitions) {
        
        System.out.println("o = "+o+" , o2 = "+o2);
        
        String mobile  = o.toString();
        String substring = mobile.substring(0, 3);
        if ("136".equals(substring)) {
            return 0;
        } else if ("137".equals(substring)) {
            return 1;
        } else {
            return 2;
        }
    }
}
