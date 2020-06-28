package com.vova.mrFlow;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author WangYang - vova
 * @version Create in 9:55 AM 2020/6/28
 * 
 * 3	13956435636	192.196.100.3			132	1512	200
    4	13966251146	192.168.100.1			240	0	404
 */


public class FlowMapper extends Mapper {

    private Text out_key = new Text();
    private FlowBean out_value = new FlowBean();

    
    
    
    
    @Override
    protected void map(Object key, Object value, Context context) throws IOException, InterruptedException {

        System.out.println("key="+key+",value="+value);

        String[] words = value.toString().split("\t");
        int length = words.length;


        out_key.set(words[1]);
        
        out_value.setUpFlow(Long.valueOf(words[length-3]));
        out_value.setDownFlow(Long.valueOf(words[length-2]));

        System.out.println(out_value.toString());
        
        context.write(out_key, out_value);
        

//        super.map(key, value, context);
    }
}
