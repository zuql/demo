package com.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.HelloService;

public class TestBeans01 {
	public static void main(String[] args) {
		//doMethod01();
		//doMethod02();
		doMethod03();
	}
	static void doMethod01(){
		HelloService hService=new HelloService();
		hService.sayHello();
	}
	static void doMethod02(){
		HelloService hService=new HelloService();
		hService.sayHello();
	}
    //快捷键：alt+shift+m (快速提取方法)
	private static void doMethod03() {
		//1.初始化spring框架容器(IOC)对象
		//1.1读取xml文件中的配置信息(xml解析)
		//1.2存储配置信息
		ClassPathXmlApplicationContext ctx=
		new ClassPathXmlApplicationContext(
				"spring-configs.xml");
		//2.获取bean对象(例如helloService)
		//2.1何时创建的？(要配置，是否配置了延迟加载)
		//2.2如何创建的？(通过反射技术：Class.forName("beans.HelloService"))
		//2.3此对象从哪里获取？(IOC容器->底层map)
		HelloService hService=
		ctx.getBean("helloService",HelloService.class);
		//3.应用bean对象(例如访问对象的方法)
		hService.sayHello();
		//4.释放资源(一般会发生在服务器关闭或重启过程中)
		ctx.close();
	}
}
