package com.example.demo_xxljob.xxljob;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author WangYang - vova
 * @version Create in 8:56 上午 2020/7/17
 */

@Service
public class DemoJob {


    private Logger logger = LoggerFactory.getLogger(getClass());
    @Value("${example.job.sleep:5}")
    private long second;
    private final SimpleDateFormat miSecond=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");

    @XxlJob("demoJobHandler")
    public ReturnT<String> execute(String s) throws Exception {
        try {
            logger.info("vvvvvvvv");
            logger.info("vvvvvvvv");
            logger.info("vvvvvvvv");
            logger.info("vvvvvvvv");
            System.out.println(Thread.currentThread()+":开始执行,"+miSecond.format(new Date()));
            Thread.sleep(3 * 1000);
            System.out.println(Thread.currentThread()+":执行完成,"+miSecond.format(new Date()));
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread() + ": being interrupted,使用策略：[覆盖之前调度]," + miSecond.format(new Date()));
        }
        return ReturnT.SUCCESS;
    }
}
