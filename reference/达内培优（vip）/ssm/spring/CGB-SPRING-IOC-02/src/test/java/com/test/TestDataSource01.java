package com.test;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSource;
import com.jt.common.utils.OpenDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestDataSource01 extends TestBase{

	 @Test
	 public void testOpenDataSource(){
		 //1.获取Bean对象
		 OpenDataSource ds=
		 ctx.getBean(OpenDataSource.class);
		 //2.测试对象值是否为空
		 Assert.assertNotEquals(null, ds);
		 //3.获取对象属性的值
		 System.out.println(ds);
	 }
	 @Test
	 public void testC3P0DataSource()
	 throws Exception{
		 //1.获取bean对象(C3P0)
		 DataSource ds=
		 ctx.getBean("c3p0",ComboPooledDataSource.class);
		 //2.测试Bean对象的值是否为空
		 Assert.assertNotEquals(null, ds);
		 //3.通过bean对象获取与数据库的连接
		 //javax.sql.Connection
		 Connection conn=ds.getConnection();
		 System.out.println(conn);
	 }
	 
	 @Test
	 public void testDruidDataSource()
			 throws Exception{
		 //1.获取bean对象(C3P0)
		 DataSource ds=ctx.getBean("druid",DruidDataSource.class);
		 //2.测试Bean对象的值是否为空
		 Assert.assertNotEquals(null, ds);
		 //3.通过bean对象获取与数据库的连接
		 //javax.sql.Connection
		 Connection conn=ds.getConnection();
		 System.out.println(conn);
	 }
	 
	 
	 
	 
	 
	 
}









