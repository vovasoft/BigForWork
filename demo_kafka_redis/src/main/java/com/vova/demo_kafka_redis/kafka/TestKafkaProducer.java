package com.vova.demo_kafka_redis.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author WangYang - vova
 * @version Create in 5:23 下午 2020/10/27
 */


@Service
public class TestKafkaProducer {


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void test(String json) {
        // serviceKafkaTemplate.send("test", json);

        kafkaTemplate.send("vova-test", json);
    }
}
