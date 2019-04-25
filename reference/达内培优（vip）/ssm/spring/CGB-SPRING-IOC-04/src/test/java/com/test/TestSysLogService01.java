package com.test;

import org.junit.Test;

import com.jt.sys.service.impl.SysLogServiceImpl;

public class TestSysLogService01 extends TestBase{

	@Test
	public void testSysLogService(){
		SysLogServiceImpl service=
		ctx.getBean("sysLogService",
		SysLogServiceImpl.class);
		System.out.println(service.getSysLogDao());
	}
}
