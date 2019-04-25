package com.test;

import org.junit.Assert;
import org.junit.Test;

import com.jt.common.utils.Container;

public class TestContainer01 extends TestBase{

	@Test
	public void testContainer(){
		Container container=
		ctx.getBean("container", Container.class);
		Assert.assertNotEquals(null, container);
		System.out.println(container.getList());
		System.out.println(container.getMap());
		System.out.println(container.getProps());
	}
	
	
	
	
	
}
