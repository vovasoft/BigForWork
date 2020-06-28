package com.vova.customInputFormat;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author WangYang - vova
 * @version Create in 5:45 PM 2020/6/28
 */


public class CustomRecordReader extends RecordReader{

    private Text key;
    private BytesWritable value;
    
    private FileSystem fs = null;
    private FSDataInputStream fsDataInputStream;
    private Path path;
    
    private boolean flag = false;
    private int length = 0;
    private String name;


    // MyRecordReader在创建后，在进入Mapper的run()之前，自动调用
    // 文件的所有内容设置为1个切片，切片的长度等于文件的长度
    @Override
    public void initialize(InputSplit split, TaskAttemptContext context) throws IOException, InterruptedException {
        FileSplit fileSplit = (FileSplit) split;

        name = fileSplit.getPath().getName();
        path = fileSplit.getPath();
        length = (int) fileSplit.getLength();

        Configuration configuration = context.getConfiguration();
        fs = FileSystem.get(configuration);
        fsDataInputStream = fs.open(path);
        
    }


    // 读取一组输入的key-value，读到返回true,否则返回false
    // 将文件的名称封装为key，将文件的内容封装为BytesWritable类型的value，返回true
    // 第二次调用nextKeyValue()返回false
    @Override
    public boolean nextKeyValue() throws IOException, InterruptedException {

        if (flag == false) {

            if (key == null) {
                key = new Text();
            }
            if (value == null) {
                value = new BytesWritable();
            }
            
            /**赋值*/
            key.set(name);
            byte [] content=new byte[length];

            IOUtils.readFully(fsDataInputStream, content, 0, length);

            value.set(content, 0, length);
            flag = true;
            
            return true;
        }
        
        return false;
    }

    @Override
    public Object getCurrentKey() throws IOException, InterruptedException {
        return key;
    }

    @Override
    public Object getCurrentValue() throws IOException, InterruptedException {
        return value;
    }

    @Override
    public float getProgress() throws IOException, InterruptedException {
        return 0;
    }

    @Override
    public void close() throws IOException {

        if (fs != null) {
            fs.close();
        }
        if (fsDataInputStream != null) {
            fsDataInputStream.close();
        }
        
    }
}
