package com.vova.customcomparer.sort2;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author WangYang - vova
 * @version Create in 9:57 AM 2020/6/28
 */


@Data
public class FlowBean implements WritableComparable<FlowBean> {
    private long upFlow;
    private long downFlow;
    private Long totalFlow;

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeLong(upFlow);
        out.writeLong(downFlow);
        out.writeLong(totalFlow);


    }

    @Override
    public void readFields(DataInput in) throws IOException {
        upFlow=in.readLong();
        downFlow=in.readLong();
        totalFlow=in.readLong();
    }
    
    

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    
    /**比较器*/
    @Override
    public int compareTo(FlowBean o) {
        return this.getTotalFlow().compareTo(o.getTotalFlow());
    }
}
