package com.beans;

import org.springframework.beans.factory.FactoryBean;
/**
 * 一个工厂Bean类型(必须复合spring中FactoryBean规范)
 * 说明:工厂bean一般用于创建工厂对象,例如ObjectFactory
 * @author Administrator
 */
public class ObjectFactoryBean 
       implements FactoryBean<ObjectFactory> {
	public ObjectFactoryBean() {
		System.out.println("ObjectFactoryBean()");
	}
	/**
	 * 作用:创建工厂对象
	 */
	@Override
	public ObjectFactory getObject() throws Exception {
		System.out.println("getObject()");
		//读取配置文件
		//构建对象,初始化对象配置
		ObjectFactory factory=
		new ObjectFactory();
		//返回对象
		//factory.setXXX(来自配置文件中内容);
		return factory;
	}
	/**
	 * 此方法用于返回创建的工厂对象的类型.
	 * 此方法在何时调用?
	 * 
	 * 1)容器销毁并且类中的isSingleton方法返回值为
	 * true时,系统底层会调用此方法获取对象
	 * 类型,然后依据类型销毁对象.
	 * 2)当按照对象类型,从spring容器中获取ObjectFactory
	 * 工厂对象时.
	 */
	@Override
	public Class<?> getObjectType() {
		System.out.println("getObjectType()");
		return ObjectFactory.class;
	}
	/**
	 * 此方法返回值决定工厂对象的创建次数
	 * 1)返回值为true,表示工厂对象在内存只能有一份
	 * 2)返回值为false,表示工厂对象每次获取都会产生
	 * 一个新的对象,也就是说在内存中可以多份.
	 * 问题:此方法会在何时调用?
	 * 1)对象创建之前(getObject()方法执行之前)
	 * 2)对象在销毁之前(spring只负责销毁单例对象)
	 */
	@Override
	public boolean isSingleton() {
		System.out.println("isSingleton()");
		return true;
	}

}
