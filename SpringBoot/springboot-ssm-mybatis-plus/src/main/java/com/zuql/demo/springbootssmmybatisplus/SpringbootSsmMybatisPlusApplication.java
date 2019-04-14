package com.zuql.demo.springbootssmmybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.zuql.demo.springbootssmmybatisplus.user.mapper")     //扫描Mybatis接口文件
public class SpringbootSsmMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSsmMybatisPlusApplication.class, args);
    }

}
