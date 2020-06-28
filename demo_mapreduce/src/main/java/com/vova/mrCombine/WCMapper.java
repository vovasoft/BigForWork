package com.vova.mrCombine;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author WangYang - vova
 * @version Create in 5:32 PM 2020/6/26
 */


public class WCMapper extends Mapper {

    private Text out_key = new Text();
    private IntWritable out_value = new IntWritable(1);

    @Override
    protected void map(Object key, Object value, Context context) throws IOException, InterruptedException {
        
        System.out.println("key="+key+",value="+value);

        String[] words = value.toString().split(" ");

        for (String word : words) {
            out_key.set(word);
            context.write(out_key, out_value);
            
        }
        
//        super.map(key, value, context);
    }
}
