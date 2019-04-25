package com.test;
import java.util.List;

import org.junit.Test;

import com.jt.sys.dao.SysLogDao;
import com.jt.sys.entity.SysLog;

public class TestSysLogDao extends TestBase {
	@Test
	public void testFindPageObjects(){
		SysLogDao dao=ctx.getBean("sysLogDao", SysLogDao.class);
		List<SysLog> list=
		dao.findPageObjects("admin",0, 3);
		for(SysLog log:list){
		 System.out.println(log.getIp());
		}
	}
	@Test
	public void testGetRowCount(){
		SysLogDao dao=ctx.getBean("sysLogDao", SysLogDao.class);
		int rowCount=dao.getRowCount("admin");
		System.out.println(rowCount);
	}
	@Test
	public void testDeleteObject(){
		SysLogDao dao=ctx.getBean("sysLogDao", SysLogDao.class);
		int rowCount=dao.deleteObjects(37,38);
		System.out.println(rowCount);
	}
}
//解决问题：W(When),W(What),W(Where),W(Why)+H(How)
//回答问题：W(What),W(When),W(Why),How








