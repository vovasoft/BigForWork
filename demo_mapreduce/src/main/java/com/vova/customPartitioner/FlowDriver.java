package com.vova.customPartitioner;


import com.vova.mrFlow.FlowBean;
import com.vova.mrFlow.FlowMapper;
import com.vova.mrFlow.FlowReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
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
        Path inputPath = new Path("/Users/wangyang/Downloads/BAIDUDOWNLOAD/05-Hadoop，HadoopHA，Zookeeper/05-Mapreduce/mrinput/flowbean");
        Path outputPath = new Path("/Users/wangyang/Downloads/BAIDUDOWNLOAD/05-Hadoop，HadoopHA，Zookeeper/05-Mapreduce/mrinput/flowbean/out");


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

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);
        
        
        /**定义reduceTask个数*/
        job.setNumReduceTasks(3);
        
        /**设置自定义分区器*/
        job.setPartitionerClass(CustomPartitioner.class);

        FileInputFormat.setInputPaths(job,inputPath);
        FileOutputFormat.setOutputPath(job,outputPath);

        /**运行job*/

        job.waitForCompletion(true);
    }
}
