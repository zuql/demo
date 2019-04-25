package com.jt.sys.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import com.jt.sys.service.SysLogService;

@Controller
public class SysLogController {
	@Autowired
	@Qualifier("sysLogService")
	private SysLogService sysLogService;
	
}
