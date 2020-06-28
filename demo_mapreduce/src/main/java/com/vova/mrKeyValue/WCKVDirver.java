package com.vova.mrKeyValue;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.NLineInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.apache.hadoop.mapreduce.MRJobConfig.INPUT_FORMAT_CLASS_ATTR;

/**
 * @author WangYang - vova
 * @version Create in 5:46 PM 2020/6/26
 * 
 * 1.一单启动这个县城，运行job
 */


public class WCKVDirver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException, URISyntaxException {

        Path inputPath = new Path("/Users/wangyang/Downloads/BAIDUDOWNLOAD/05-Hadoop，HadoopHA，Zookeeper/05-Mapreduce/mrinput/keyvalue");
        Path outputPath = new Path("/Users/wangyang/Downloads/BAIDUDOWNLOAD/05-Hadoop，HadoopHA，Zookeeper/05-Mapreduce/mrinput/keyvalue/out");
      

        Configuration conf = new Configuration();

        

        FileSystem fs=FileSystem.get(conf);
        if (fs.exists(outputPath)) {
            fs.delete(outputPath,true);
        }

        /**配置kv，通过conf的方式设置*/
//        conf.setClass(INPUT_FORMAT_CLASS_ATTR, KeyValueTextInputFormat.class, InputFormat.class);
        conf.set(INPUT_FORMAT_CLASS_ATTR,"org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat");
        
        
        /**这个分隔符，只会取值第一byte 为分隔符，不会取String*/
        conf.set("mapreduce.input.keyvaluelinerecordreader.key.value.separator", "***");
        
        /**创建job*/

        Job job = Job.getInstance(conf);
        job.setJobName("vova1");
        
        /**设置job*/
        job.setMapperClass(WCKVMapper.class);
        job.setReducerClass(WCKVReducer.class);
        
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        
        /**配置kv，这是一种输入格式的方式*/
//        job.setInputFormatClass(KeyValueTextInputFormat.class);

        FileInputFormat.setInputPaths(job,inputPath);
        FileOutputFormat.setOutputPath(job,outputPath);
        
        /**运行job*/

        job.waitForCompletion(true);
    }
}
