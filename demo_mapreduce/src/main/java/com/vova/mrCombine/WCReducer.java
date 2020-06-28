package com.vova.mrCombine;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author WangYang - vova
 * @version Create in 5:32 PM 2020/6/26
 */


public class WCReducer extends Reducer<Text,IntWritable,Object,Object> {

    private IntWritable out_value = new IntWritable();


    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        
        int sum = 0;

        for (IntWritable value : values) {
            sum+=value.get();
        }
        
        out_value.set(sum);
        context.write(key, out_value);
        
//        super.reduce(key, values, context);
    }
}
