package com.zuql.consumerhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients            //开启feign
@EnableCircuitBreaker			//开启hystrix
public class ConsumerHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixApplication.class, args);
    }

}
