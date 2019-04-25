package com.jt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exp/")
public class ExceptionController {
	@RequestMapping("doHandleRequest")
	@ResponseBody
	public String doHandleRequest(
			Integer a,Integer b){
		int result=a/b;
		return "result is "+result;
	}//此方法假如没有处理异常，此异常会抛出到客户端
	
	//@ExceptionHandler 描述的方法为异常处理方法
	/*@ExceptionHandler(ArithmeticException.class)
	@ResponseBody
	public String doHandleArithmeticException(
			ArithmeticException e){
		return "Arithmetic Exception: "+e.getMessage();
	}*/
	
	/*@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public String doHandleRuntimeException(
			RuntimeException e){
		return "Runtime Exception: "+e.getMessage();
	}*/
}






