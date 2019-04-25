package com.jt.common.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.druid.pool.DruidDataSource;
/**
 * 使用此配置类替换spring-configs.xml文件
 * @Configuration 修饰的类一般认为是一个配置类
 * @ComponentScan 用于定义要扫描的具体包
 */
@Configuration
@PropertySource("classpath:configs.properties")//<util:properties ...>
@ComponentScan("com.jt")//由spring扫描本包以及子中的类
public class AppRootConfig {
   /**说明：当需要整合第三方的bean对象时需要采用如下方式实现*/
    //@Bean注解用于描述这个方法创建的对象由spring管理
	@Bean(value="dataSource",initMethod="init",destroyMethod="close")//假如这个bean没有指定名字，默认为方法名
	//@Value注解用于读取properties文件中的内容
    public DataSource newDataSource(
		@Value("${jdbcDriver}")String driver,
		@Value("${jdbcUrl}")String url,
		@Value("${jdbcUser}")String user,
		@Value("${jdbcPassword}")String password){
    	DruidDataSource ds=new DruidDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(user);
		ds.setPassword(password);
    	return ds;
	}
}













