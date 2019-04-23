package com.jt.sys.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.JsonResult;
import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysUser;
import com.jt.sys.service.SysUserService;
import com.jt.sys.vo.SysUserDeptResult;

@Controller
@RequestMapping("/user/")
public class SysUserController {
	@Autowired
	private SysUserService sysUserService;
	@RequestMapping("doUserListUI")
	public String doUserListUI(){
		return "sys/user_list";
	}
	@RequestMapping("doUserEditUI")
	public String doUserEditUI(){
		return "sys/user_edit";
	}
	@RequestMapping("doLogin")
	@ResponseBody
	public JsonResult doLogin(String username,
			String password){
		//1.对用户信息进行封装
		UsernamePasswordToken token=
		new UsernamePasswordToken(username,
				password);
		//2.提交用户信息到SecurityManager
		//2.1获取用户主体对象
		Subject subject=SecurityUtils.getSubject();
		//2.2提交用户信息(执行登录认证操作)
		subject.login(token);//AuthenticationToken 
		return new JsonResult("login ok");
	}
	
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer id){
		return new JsonResult(sysUserService.findObjectById(id));
	}
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysUser entity,
			Integer[] roleIds){
		sysUserService.saveObject(entity,
				roleIds);
		return new JsonResult("save ok");
	}
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SysUser entity,
			Integer[] roleIds){
		sysUserService.updateObject(entity,
				roleIds);
		return new JsonResult("update ok");
	}
	
	/**禁用启用操作*/
	@RequestMapping("doValidById")
	@ResponseBody
	public JsonResult doValidById(Integer id,
			Integer valid){
		SysUser user=(SysUser)
		SecurityUtils.getSubject().getPrincipal();
		sysUserService.validById(id, valid,
				user.getUsername());//假数据
		System.out.println("sysUserService="+sysUserService.getClass().getName());
		return new JsonResult("update ok");
	}
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(
			String username,Integer pageCurrent){
		System.out.println("SysUserController.SysUserService="+sysUserService.getClass().getName());
		PageObject<SysUserDeptResult> pageObject=
		sysUserService.findPageObjects(username,
				pageCurrent);
		return new JsonResult(pageObject);
	}
	
}



