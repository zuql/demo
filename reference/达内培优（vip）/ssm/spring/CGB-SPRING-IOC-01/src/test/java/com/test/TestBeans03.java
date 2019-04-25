package com.test;
import org.junit.Assert;
import org.junit.Test;
import beans.ObjectFactory;
import beans.ObjectFactoryBean;

public class TestBeans03 extends TestBase {

	@Test
	public void testObjectFactory(){
		//1.获取ObjectFactory类型的对象
		ObjectFactory obj1=
		//基于这个key获取的时通过ObjectFactoryBean创建那个工厂对象
		ctx.getBean("objectFactory",ObjectFactory.class);
		ObjectFactory obj2=
		ctx.getBean("objectFactory",ObjectFactory.class);
		//System.out.println(obj.getClass().getName());
		//思考：为什么我们配置的是ObjectFactoryBean对象
		//但是获取对象时我们要写ObjectFactory类型呢？
		//2.测试这个对象的值是否为空
		//断言测试(Assert类的方法返回值为false时则到此停止)
		Assert.assertEquals(obj2, obj1);
		System.out.println("测试结束了");
	}
	/**
	 * 当我们需要获取由spring管理的某个
	 * FactoryBean对象时，可以在声明的
	 * bean的id值之前添加"&"作为
	 * FactoryBean对象的key进行对象获取。
	 */
	@Test
	public void testObjectFactoryBean(){
		ObjectFactoryBean ofb=
		ctx.getBean("&objectFactory",
				     ObjectFactoryBean.class);
		Assert.assertNotEquals(
				null,//unexpected
				ofb);//actual
	}	
	
}













