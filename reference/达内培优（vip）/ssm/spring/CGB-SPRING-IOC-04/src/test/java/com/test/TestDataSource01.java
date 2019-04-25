package com.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;

public class TestDataSource01 extends TestBase{
     @Test
	 public void testDataSource() throws SQLException{
		 DataSource ds=
		 ctx.getBean("dataSource",DataSource.class);
		 System.out.println(ds);
		 System.out.println(ds.getConnection());
	 }
}
