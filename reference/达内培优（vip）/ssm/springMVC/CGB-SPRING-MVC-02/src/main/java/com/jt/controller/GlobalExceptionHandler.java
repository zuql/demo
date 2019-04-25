package com.jt.controller;
import java.io.IOException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/***
 * 使用此注解描述的类表示是一个全局异常处理类
 * @author ta
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(ArithmeticException.class)
	@ResponseBody
	public String doHandleArithmeticException(
			ArithmeticException e){
		return "Global Arithmetic Exception: "+e.getMessage();
	}
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public String doHandleRuntimeException(
			RuntimeException e){
		return "Global Runtime Exception: "+e.getMessage();
	}
	@ExceptionHandler(value={IllegalArgumentException.class,ClassCastException.class,IOException.class})
	@ResponseBody
	public String doHandleOtherException(Exception e){
		return "Exception "+e.getMessage();
	}
	
	
	
	
}
