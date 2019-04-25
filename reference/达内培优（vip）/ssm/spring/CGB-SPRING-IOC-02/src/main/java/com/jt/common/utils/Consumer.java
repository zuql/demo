package com.jt.common.utils;
/**
 * 消费者对象
 * @author ta
 */
public class Consumer {
    /**容器对象:(消费者负责从容器取数据)*/
	private Container container;
	/**可以采用构造注入方式对属性赋值*/
	public Consumer(Container container) {
		this.container=container;
	}
	public Container getContainer() {
		return container;
	}
}
