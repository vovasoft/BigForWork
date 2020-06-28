package com.vova.mrNline;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.NLineInputFormat;
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

        Path inputPath = new Path("/Users/wangyang/Downloads/BAIDUDOWNLOAD/05-Hadoop，HadoopHA，Zookeeper/05-Mapreduce/mrinput/nline");
        Path outputPath = new Path("/Users/wangyang/Downloads/BAIDUDOWNLOAD/05-Hadoop，HadoopHA，Zookeeper/05-Mapreduce/mrinput/nline/out");
      

        Configuration conf = new Configuration();

        

        
//        conf.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
//        conf.set("fs.defaultFS", "hdfs://h11:9000");

        FileSystem fs=FileSystem.get(conf);
        if (fs.exists(outputPath)) {
            fs.delete(outputPath,true);
        }

        conf.set("mapreduce.input.lineinputformat.linespermap", "2");
        /**创建job*/

        Job job = Job.getInstance(conf);
        job.setJobName("vova1");
        
        /**设置job*/
        job.setMapperClass(WCMapper.class);
        job.setReducerClass(WCReducer.class);
        
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        
        /**配置nline*/
        job.setInputFormatClass(NLineInputFormat.class);

        FileInputFormat.setInputPaths(job,inputPath);
        FileOutputFormat.setOutputPath(job,outputPath);
        
        /**运行job*/

        job.waitForCompletion(true);
    }
}
