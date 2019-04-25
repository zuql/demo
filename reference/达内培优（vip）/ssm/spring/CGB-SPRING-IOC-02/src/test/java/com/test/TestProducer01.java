package com.test;
import org.junit.Assert;
import org.junit.Test;

import com.jt.common.utils.Consumer;
import com.jt.common.utils.Container;
import com.jt.common.utils.Producer;
public class TestProducer01 extends TestBase{
	@Test
	public void testProducer(){
		//1.获取生产者对象
		Producer pro=ctx.getBean("producer",Producer.class);
		Assert.assertNotEquals(null, pro);
		//2.获取生产者关联的容器对象
		Container container=pro.getContainer();
		Assert.assertNotEquals(null, container);
		//3.向容器放数据
		container.getMap().put("mysql", 100);
		container.getList().add("皮皮霞");
	}
	@Test
	public void testProducerConsumer(){
		//1.获取生产者对象
		Producer pro=ctx.getBean("producer",Producer.class);
		Assert.assertNotEquals(null, pro);
		//2.获取生产者关联的容器对象
		Container container=pro.getContainer();
		Assert.assertNotEquals(null, container);
		//3.向容器放数据
		container.getMap().put("mysql", 100);
		container.getList().add("皮皮霞");
		//4.获取消费者对象
		Consumer con=ctx.getBean("consumer",Consumer.class);
		Assert.assertNotEquals(null, con);
		//5.从容器获取数据
		Object value=container.getMap().get("mysql");
		System.out.println(value);
		
	}
}







