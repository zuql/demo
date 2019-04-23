package com.beans;
/**定义一个池对象:假设为连接池*/
public class ConnectionPool {
	public ConnectionPool() {
		System.out.println("ConnectionPool()");
	}
	/**
	 * 此方法用于初始化池
	 */
	public void init(){
		System.out.println("init()");
	}
	/**
	 * 销毁池中资源
	 */
	public void close(){
		System.out.println("close()");
	}
}
