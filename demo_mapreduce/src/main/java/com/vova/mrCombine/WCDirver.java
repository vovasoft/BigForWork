package com.vova.mrCombine;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.CombineFileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.CombineTextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.NLineInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.apache.hadoop.mapreduce.lib.input.FileInputFormat.SPLIT_MAXSIZE;
import static org.apache.hadoop.mapreduce.lib.input.FileInputFormat.SPLIT_MINSIZE;

/**
 * @author WangYang - vova
 * @version Create in 5:46 PM 2020/6/26
 * 
 * 1.一单启动这个县城，运行job
 */


public class WCDirver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException, URISyntaxException {

        Path inputPath = new Path("/Users/wangyang/Downloads/BAIDUDOWNLOAD/05-Hadoop，HadoopHA，Zookeeper/05-Mapreduce/mrinput/combine");
        Path outputPath = new Path("/Users/wangyang/Downloads/BAIDUDOWNLOAD/05-Hadoop，HadoopHA，Zookeeper/05-Mapreduce/mrinput/combine/out");


        Configuration conf = new Configuration();



        FileSystem fs=FileSystem.get(conf);
        if (fs.exists(outputPath)) {
            fs.delete(outputPath,true);
        }

        /**配置combine，通过conf的方式设置*/
//        conf.setClass(INPUT_FORMAT_CLASS_ATTR, KeyValueTextInputFormat.class, InputFormat.class);
//        conf.set(INPUT_FORMAT_CLASS_ATTR,"org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat");


        conf.set(SPLIT_MINSIZE, "100");
        conf.set(SPLIT_MAXSIZE, "18000");

        /**创建job*/

        Job job = Job.getInstance(conf);
        job.setJobName("vova1");

        /**设置job*/
        job.setMapperClass(WCMapper.class);
        job.setReducerClass(WCReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        /**配置combine，这是一种输入格式的方式*/
        job.setInputFormatClass(CombineTextInputFormat.class);

        FileInputFormat.setInputPaths(job,inputPath);
        FileOutputFormat.setOutputPath(job,outputPath);

        /**运行job*/

        job.waitForCompletion(true);
    }
}
