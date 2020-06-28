package com.vova.mrFlow;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author WangYang - vova
 * @version Create in 9:55 AM 2020/6/28
 */


public class FlowReducer extends Reducer<Text,FlowBean,Text,FlowBean> {

    private FlowBean out_value = new FlowBean(); 
    
    @Override
    protected void reduce(Text key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {

        long sumUP = 0;
        long sumDown = 0;
        
        for (FlowBean value : values) {
            long upFlow = value.getUpFlow();
            long downFlow = value.getDownFlow();

            sumUP+=upFlow;
            sumDown+=downFlow;
        }

        out_value.setUpFlow(sumUP);
        out_value.setDownFlow(sumDown);
        out_value.setTotalFlow(sumDown + sumUP);

        System.out.println(out_value);
        
        context.write(key,out_value);
    }
}
