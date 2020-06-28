package com.vova.customInputFormat;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;

import java.io.IOException;


/**
 * @author WangYang - vova
 * @version Create in 6:10 PM 2020/6/28
 */


public class CustomDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Path inputPath = new Path("/Users/wangyang/Downloads/BAIDUDOWNLOAD/05-Hadoop，HadoopHA，Zookeeper/05-Mapreduce/mrinput/custom");
        Path outputPath = new Path("/Users/wangyang/Downloads/BAIDUDOWNLOAD/05-Hadoop，HadoopHA，Zookeeper/05-Mapreduce/mrinput/custom/out");


        Configuration conf = new Configuration();



        FileSystem fs=FileSystem.get(conf);
        if (fs.exists(outputPath)) {
            fs.delete(outputPath,true);
        }
        

        /**创建job*/

        Job job = Job.getInstance(conf);
        job.setJobName("vova1");

        /**设置job*/
        job.setMapperClass(CustomIFMapper.class);
        job.setReducerClass(CustomIFReducer.class);

        // Job需要根据Mapper和Reducer输出的Key-value类型准备序列化器，通过序列化器对输出的key-value进行序列化和反序列化
        // 如果Mapper和Reducer输出的Key-value类型一致，直接设置Job最终的输出类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(BytesWritable.class);


        job.setInputFormatClass(CustomInputFormat.class);
        job.setOutputFormatClass(SequenceFileOutputFormat.class);

        FileInputFormat.setInputPaths(job,inputPath);
        FileOutputFormat.setOutputPath(job,outputPath);

        /**运行job*/

        job.waitForCompletion(true);
        
        
    }
}
