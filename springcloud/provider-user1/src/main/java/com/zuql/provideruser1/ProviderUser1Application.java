package com.zuql.provideruser1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderUser1Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderUser1Application.class, args);
    }

}
