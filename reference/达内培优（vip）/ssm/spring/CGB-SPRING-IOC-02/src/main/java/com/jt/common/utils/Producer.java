package com.jt.common.utils;

import java.util.Date;

/**
 * 生产者对象(负责向容器放数据)
 */
public class Producer {//IOC(工厂,容器)
	/**
	 * 生产者关联一个容器对象(目的是要向此容器放数据)
	 */
	private Container container;
	public void setContainer(Container container) {
		System.out.println("setContainer(...)");
		this.container = container;
	}
	public Container getContainer() {
		return container;
	}
}







