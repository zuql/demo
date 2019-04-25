package com.jt.common.aspect;
import java.util.Arrays;

import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import com.jt.common.util.IPUtils;
import com.jt.common.util.ShiroUtils;
import com.jt.sys.dao.SysLogDao;
import com.jt.sys.entity.SysLog;
import com.jt.sys.entity.SysUser;

import sun.net.util.IPAddressUtil;
/**
 * 日志横切面对象
 * @Aspect 用于描述此类为一个切面对象
 */
@Order(1)
@Aspect
@Service
public class SysLogAspect {
	@Autowired
	private SysLogDao sysLogDao;
	/**
	 * @Around 描述的方法为一个环绕通知
	 * 环绕通知：目标方法执行之前和之后都可以执行。
	 * 环绕通知内部的bean表达式为一个切入点表达式
	 * @param pjp 表示一个连接点对象(
	 * 封装了一个具体业务方法)
	 * @return
	 */
	@Around("bean(sysRoleServiceImpl)")
	public Object aroundMethod(ProceedingJoinPoint joinPoint)
			throws Throwable{
		//执行目标方法(result为目标方法执行的结果)
		long startTime=System.currentTimeMillis();
		Object result=joinPoint.proceed();
		long endTime=System.currentTimeMillis();
		//获取日志信息并存储到数据库
		saveObject(joinPoint,endTime-startTime);
		return result;
	}
	private void saveObject(ProceedingJoinPoint joinPoint,long time){
		//获取日志信息
		Class<?> targetCls=joinPoint.getTarget().getClass();
		Signature s=joinPoint.getSignature();//方法签名(封装了具体方法信息)
		String methodName=targetCls.getName()+"."+s.getName();
		Object[] params=joinPoint.getArgs();
		//封装日志信息
		SysLog log=new SysLog();
		log.setIp(IPUtils.getIpAddr());
		log.setMethod(methodName);
		log.setParams(Arrays.toString(params));
		//log.setOperation(operation);//自己结合1.06去实现。
		log.setTime(time);
		log.setUsername(ShiroUtils.getPrincipal().getUsername());
		//保存日志信息
		sysLogDao.insertObject(log);
	}
}//基于OCP原则进行功能扩展(例如日志处理)












