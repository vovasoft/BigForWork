package com.vova.mrYarn;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author WangYang - vova
 * @version Create in 5:46 PM 2020/6/26
 * 
 * 1.一单启动这个县城，运行job
 */


public class WCDirver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException, URISyntaxException {
        Path inputPath = new Path("/wordcount");
        Path outputPath = new Path("/mroutput_yarn");

        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://h11:9000");
        
        //配置yarn
        conf.set("mapreduce.framework.name","yarn");
//        conf.set("mapreduce.jobhistory.address","h11:10020");
        conf.set("yarn.resourcemanager.hostname","h12");
        

        FileSystem fs=FileSystem.get(conf);
        if (fs.exists(outputPath)) {
            fs.delete(outputPath,true);
        }
        /**创建job*/

        Job job = Job.getInstance(conf);
        job.setJar("demo_mapreduce-1.0-SNAPSHOT.jar");
        job.setJobName("vova1");
        
        /**设置job*/
        job.setMapperClass(WCMapperYarn.class);
        job.setReducerClass(WCReducerYarn.class);
        
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        
        

        FileInputFormat.setInputPaths(job,inputPath);
        FileOutputFormat.setOutputPath(job,outputPath);
        
        /**运行job*/

        job.waitForCompletion(true);
    }
}
