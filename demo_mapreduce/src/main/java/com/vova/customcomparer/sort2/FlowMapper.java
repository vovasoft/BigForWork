package com.vova.customcomparer.sort2;

import com.alibaba.fastjson.JSONObject;
import org.apache.hadoop.io.LongWritable;
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


public class FlowMapper extends Mapper<LongWritable,Text,FlowBean,Text> {

    private Text out_value = new Text();

    
    
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {


        String[] words = value.toString().split("\t");
        
        FlowBean flowBean = JSONObject.parseObject(words[1], FlowBean.class);
        
        out_value=value;
        
        context.write(flowBean, out_value);
    }
}
