package com.zuql.springbootssm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.zuql.springbootssm.mapper")     //扫描Mybatis接口文件
public class SpringbootSsmApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootSsmApplication.class, args);
    }

}
