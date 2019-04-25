package com.test;

import java.lang.reflect.Constructor;

import org.junit.Test;

public class TestReflect01 {
	@Test
	public void testObj01()throws Exception{
	  //1.获取类对象
	   String clsName="com.jt.common.utils.OpenDataSource";
	  //泛型中用？代表任意的一种类型
	   Class<?> c=Class.forName(clsName);
	  //2.获取构造方法对象
	   Constructor<?> con=
	   c.getDeclaredConstructor();
	  //3.设置构造方法对象可访问(假如是private可以修改为public)
	   System.out.println(con.isAccessible());
	   con.setAccessible(true);
	  //4.执行构造方法构建类的对象
	   Object obj=con.newInstance();
	  //5.输出对象信息
	   System.out.println(obj);
	}
	@Test
	public void testObj02()throws Exception{
		//1.获取类对象
		String clsName="com.jt.common.utils.OpenDataSource";
		//泛型中用？代表任意的一种类型
		Class<?> c=Class.forName(clsName);
		//2.获取构造方法对象
		Constructor<?> con=
		c.getDeclaredConstructor(int.class,int.class);
		//3.设置构造方法对象可访问(假如是private可以修改为public)
		con.setAccessible(true);
		//4.执行构造方法构建类的对象(类的实例)
		Object obj=con.newInstance(10,100);
		//5.输出对象信息
		System.out.println(obj);
	}
}


