package com.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class TestMember01 extends TestBase{

	@Test
	public void testDeleteObject(){
		SqlSessionFactory factory=
		ctx.getBean("sqlSessionFactory",SqlSessionFactory.class);
		SqlSession session=factory.openSession();
		String stmt="com.pt.member.dao.MemberDao.deleteObject";
		int rows=session.delete(stmt,1);
		System.out.println(rows);
		session.close();
	}
}
