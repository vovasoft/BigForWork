package com.vova.demo_kafka_redis.kafka;

import com.vova.demo_kafka_redis.RedisUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author WangYang - vova
 * @version Create in 5:23 下午 2020/10/27
 */


@Component
public class TestKafkaConsumer {
    @Autowired
    RedisUtils redisUtils;

    @KafkaListener(id= "vova2020" ,topics = {"vova-test"})
    public void onMessage(ConsumerRecord<String, String> record) {

        System.out.println("1:" + record.topic() + "topic-->" + record.value() + "\n\n");
        redisUtils.set(record.value(), "欧耶~",10000L);
    }



}
