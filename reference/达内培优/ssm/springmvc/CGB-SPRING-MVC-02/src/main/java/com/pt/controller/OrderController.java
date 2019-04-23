package com.pt.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/order/")
public class OrderController{
	public OrderController() {
		System.out.println("OrderController()");
	}
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public String doDeleteObject(String id)
	throws Exception{
		if(id==null||"".equals(id))
		throw new Exception("id can not be null");
		Integer code=Integer.parseInt(id);
		//.....delete ....
		return "delete ok,code="+code;
	}
    @RequestMapping("doSaveObject")
	@ResponseBody
	public String doSaveObject(){
    	System.out.println("doSaveObject()");
		return "save order ok";
	}
    /**@ExceptionHandler
     * 注解修饰的方法为异常处理方法*/
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public String doHandleRuntimeException(
    		RuntimeException e){
    	System.err.println("OrderController.doHandleRuntimeException");
    	return e.getMessage();
    }
    
    
}
