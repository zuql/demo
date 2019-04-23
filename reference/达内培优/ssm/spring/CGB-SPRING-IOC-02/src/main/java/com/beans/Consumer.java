package com.beans;

/**消费者对象*/
public class Consumer {
     /**关联容器对象*/
	 private Container container;
	 /**通过set方法为容器属性赋值*/
	 public void setContainer(Container container) {
		this.container = container;
	 }
	 /**从容器获取数据*/
	 public Object get(){
		 return container.remove();//0
	 }
}
