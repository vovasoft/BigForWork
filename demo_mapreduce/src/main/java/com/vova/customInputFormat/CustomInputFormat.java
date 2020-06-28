package com.vova.customInputFormat;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

import java.io.IOException;
import java.util.List;

/**
 * 
 * 需求，将文件通过mr，变为二进制
 * @author WangYang - vova
 * @version Create in 4:30 PM 2020/6/28
 */


public class CustomInputFormat extends FileInputFormat {


    @Override
    public RecordReader createRecordReader(InputSplit split, TaskAttemptContext context) throws IOException, InterruptedException {
        return new CustomRecordReader();
    }

    @Override
    protected boolean isSplitable(JobContext context, Path filename) {
        return false;
    }
}
