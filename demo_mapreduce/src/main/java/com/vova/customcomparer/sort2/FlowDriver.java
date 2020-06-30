package com.vova.customcomparer.sort2;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * 统计手机号，上行、下行、流量
 * Bean
 * 
 * @author WangYang - vova
 * @version Create in 9:55 AM 2020/6/28
 */


public class FlowDriver {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Path inputPath = new Path("/Users/wangyang/Downloads/BAIDUDOWNLOAD/05-Hadoop，HadoopHA，Zookeeper/05-Mapreduce/mrinput/flowbean/out");
        Path outputPath = new Path("/Users/wangyang/Downloads/BAIDUDOWNLOAD/05-Hadoop，HadoopHA，Zookeeper/05-Mapreduce/mrinput/flowbean/sort2");


        Configuration conf = new Configuration();
        

        FileSystem fs=FileSystem.get(conf);
        if (fs.exists(outputPath)) {
            fs.delete(outputPath,true);
        }
        /**创建job*/

        Job job = Job.getInstance(conf);
        job.setJobName("vova2");

        /**设置job*/
        job.setMapperClass(FlowMapper.class);
        job.setReducerClass(FlowReducer.class);

        // Job需要根据Mapper和Reducer输出的Key-value类型准备序列化器，通过序列化器对输出的key-value进行序列化和反序列化
        // 如果Mapper和Reducer输出的Key-value类型一致，直接设置Job最终的输出类型
        
        /**如果不设置setMapOutputKeyClass,则会默认选择OutputKeyClass*/
        job.setMapOutputKeyClass(FlowBean.class);
        /**如果不设置setMapOutputValueClass,则会默认选择OutputValueClass*/
        job.setMapOutputValueClass(Text.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);

        FileInputFormat.setInputPaths(job,inputPath);
        FileOutputFormat.setOutputPath(job,outputPath);

        /**运行job*/

        job.waitForCompletion(true);
    }
}
