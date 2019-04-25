package com.test;

import org.junit.Test;

public class TestVarArgs01 {
	
  /*public void doMethod(int a){}
	public void doMethod(int a,int b){}
	public void doMethod(int a,int b,int c){}
    */
	//可变参数可以简化同类中参数类型相同，个数不同的重载方法的定义
	public void doMethod(int... args){
		System.out.println(args.length);
		for(int i=0;i<args.length;i++){
			System.out.println(args[i]);
		}
	}
	@Test
	public void testVarArgs01(){
		doMethod();
		doMethod(0);
		doMethod(1,2,3,4);
	}
}
