package com.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class TestMyBatis01 extends TestBase{
  
	@Test
	public void testSqlSessionFactory(){
		SqlSessionFactory ssf=
		ctx.getBean("sqlSessionFactory",
		SqlSessionFactory.class);
		System.out.println(ssf);
	}
	
	
	@Test
	public void testDeleteObject(){
		SqlSessionFactory ssf=
		   ctx.getBean("sqlSessionFactory",
			    SqlSessionFactory.class);
		SqlSession session=ssf.openSession();
		String statement="com.pt.member.dao.MemberDao.deleteObject";
		int rows=session.delete(statement,7);
		System.out.println(rows);
		session.close();
	}
	
}









