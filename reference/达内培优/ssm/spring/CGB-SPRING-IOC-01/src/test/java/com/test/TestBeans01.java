package com.test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.beans.HelloService;
public class TestBeans01 {
	public static void main(String[] args) {
		//1.初始化spring容器
		String cfg="spring-configs.xml";
		ClassPathXmlApplicationContext ctx=
		new ClassPathXmlApplicationContext(cfg);
		//2.获取bean对象(由谁提供)
		HelloService hService=
		ctx.getBean("helloService",HelloService.class);//Class
		//3.使用bean对象
		hService.sayHello();
		//4.释放资源
		ctx.close();
	}
}
