package com.test;
import org.junit.Test;

import com.beans.Consumer;
import com.beans.Producer;
public class TestProducerConsumer01 extends TestBase{
	@Test
	public void testProducerConsumer(){
		//1.获取生产者对象
		Producer pro=
		ctx.getBean("producer", Producer.class);
		//2.通过生产者像容器放数据
		pro.add("A");
		pro.add("B");
		//3.获取消费者对象
		Consumer con=
		ctx.getBean("consumer",Consumer.class);
		//4.通过消费者从容器取数据，然后输出
		Object obj1=con.get();
		Object obj2=con.get();
		System.out.println(obj1);
		System.out.println(obj2);
		
	}
}




