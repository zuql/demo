package com.jt.common.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Aspect
@Service
public class DataFilterAspect {
	 @Pointcut("@annotation(com.jt.common.anno.DataFilter)")
	 public void doFilterPointCut(){}
	 /***
	  * 目标方法执行之前
	  * @param jp
	  * @throws Throwable
	  */
	 @Before("doFilterPointCut()")
	 public void beforeMethod(JoinPoint jp)
	 throws Throwable{
		 Object[] args=jp.getArgs();
		 System.out.println("datafilter.args="+ Arrays.toString(args));
		 if(args[0]==null||(Integer)args[0]<1)
		 throw new IllegalArgumentException("参数不合法");
	 }
}





