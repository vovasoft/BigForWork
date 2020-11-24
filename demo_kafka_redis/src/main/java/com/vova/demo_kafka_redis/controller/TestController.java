package com.vova.demo_kafka_redis.controller;

import com.vova.demo_kafka_redis.RedisUtils;
import com.vova.demo_kafka_redis.kafka.TestKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangYang - vova
 * @version Create in 5:22 下午 2020/10/27
 */


@RestController
public class TestController {
    @Autowired
    RedisUtils redisUtils;

    @Autowired
    TestKafkaProducer producer;

    @GetMapping("/sendKafka")
    public String sendKafka(@RequestParam("key") String key) {
        long l1 = System.currentTimeMillis();
        producer.test("" + key);


        while (!redisUtils.hasKey(key)) {
            ;
        }
        long l2 = System.currentTimeMillis();
        return "key = " + redisUtils.get(key) + ",用时" + (l2 - l1);
    }

    @GetMapping("/redisTest")
    String redisTest() {
        long l1 = System.currentTimeMillis();
        redisUtils.set("vova-l1", "" + l1);

        return "" + redisUtils.get("vova-l1");

    }
}
