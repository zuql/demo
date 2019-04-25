package com.test;

import org.junit.Test;

import beans.HelloService;

public class TestBeans02 extends TestBase {
	@Test
	public void testJunit(){
		System.out.println("test junit");
	}
	@Test
	public void testHelloService(){
		doMethod01();
		doMethod02();
	}
    //假如希望将某段代码提取为一个方法：
	//1)选中代码
	//2)快捷键 alt+shift+m 打开一个窗口
	//3)窗口中输入方法名
	private void doMethod01() {
		//1.获取HelloServiceBean对象
		HelloService hService=
		(HelloService)ctx.getBean("helloService");
	    //2.使用Bean对象
		hService.sayHello();
	}
	private void doMethod02() {
		//1.获取HelloServiceBean对象
		HelloService hService=
		ctx.getBean(HelloService.class);
		//2.使用Bean对象
		hService.sayHello();
	}
}






