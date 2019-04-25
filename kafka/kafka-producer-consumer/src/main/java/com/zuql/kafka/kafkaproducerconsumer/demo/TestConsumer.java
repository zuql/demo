package com.zuql.kafka.kafkaproducerconsumer.demo;/**
 * @Auther: zuql
 * @Date: 2019/4/25 21:50
 * @Description:
 */

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author zuql
 * @create 2019-04-25 21:50
 * @desc 消费者
 **/
@Component
public class TestConsumer {

    @KafkaListener(topics = "test_topic")
    public void listen (ConsumerRecord<?, ?> record) throws Exception {
        //控制台打印send进来的信息
        System.out.printf("topic = %s, offset = %d, value = %s \n", record.topic(), record.offset(), record.value());
    }
}
