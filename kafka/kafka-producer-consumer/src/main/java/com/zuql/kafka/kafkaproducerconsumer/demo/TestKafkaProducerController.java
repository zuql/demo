package com.zuql.kafka.kafkaproducerconsumer.demo;/**
 * @Auther: zuql
 * @Date: 2019/4/25 21:46
 * @Description:
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zuql
 * @create 2019-04-25 21:46
 * @desc 生产者
 **/
@RestController
@RequestMapping("kafka")
public class TestKafkaProducerController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @RequestMapping("send")
    public String send(String msg){
        kafkaTemplate.send("test_topic", msg);
        return "success add ";
    }


}
