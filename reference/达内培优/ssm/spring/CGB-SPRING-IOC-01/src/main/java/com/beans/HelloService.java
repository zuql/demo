package com.beans;
//1.一个非常普通的类
//2.将将此类的对象交给spring去创建，该如何配置
public class HelloService {
	private HelloService() {
		System.out.println("HelloService()");
	}
	public void sayHello(){
		System.out.println("hello world");
	}
}
