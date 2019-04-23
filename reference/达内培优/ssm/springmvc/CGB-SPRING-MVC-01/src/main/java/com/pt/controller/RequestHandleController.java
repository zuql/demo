package com.pt.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pt.vo.SqlOrderCommand;

@Controller
@RequestMapping("/req/")
public class RequestHandleController {
    //=========请求路径映射============
	
	@RequestMapping("doRequestPath01")
	@ResponseBody
	public String doRequestPath01(){
		return "doRequestPath01()";
	}//@ResponseBody注解修饰方法时假如返回的是一个字符串，
	//就以普通串的形式进行返回
	
	//如何实现多个url映射为同一个资源
	@RequestMapping({"doRequestPath02","doReqPath02"})
	@ResponseBody
	public String doRequestPath02(){
		return "doRequestPath02()";
	}
	//rest风格的url映射
	@RequestMapping("doRestRequest/{path}")
	@ResponseBody
	public String doRequestPath03(){
		return "doRequestPath03()";
	}
	//rest风格的url中参数的获取(借助@PathVariable注解修饰)
	@RequestMapping("doRestDelete/{id}")
	@ResponseBody
	public String doRequestPath04(
			@PathVariable("id") Integer ids){
		return "doRequestPath04(),id="+ids;
	}
	//=============请求方式映射==============
	
	//指定方法只处理Get和Post请求
	@RequestMapping(value="doRequestMethod01",
			        method={RequestMethod.GET
			        	,RequestMethod.POST})
	@ResponseBody
	public String doRequestMethod01(){
		return "doRequestMethod01()";
	}
	//执行方法只处理Get请求
	@ResponseBody
	@GetMapping(value="doRequestMethod02")
	public String doRequestMethod02(){
		return "doRequestMethod02()";
	}
	//执行方法只处理Post请求
	@ResponseBody
	@PostMapping(value="doRequestMethod03")
	public String doRequestMethod03(){
		return "doRequestMethod03()";
	}
	//==========请求参数映射=========
	//1.借助原生servlet API获取数据
	@GetMapping("doRequestParam01")
	@ResponseBody
	public String doRequestParam01(
		HttpServletRequest request){
		String page=
		request.getParameter("page");
		HttpSession session=request.getSession();
		System.out.println(session.getId());
		return "param's value "+page;
	}

	//2.直接量方式获取请求参数数据
	/**
	 * @RequestParam 用于修饰方法参数
	 * 1)value属性用于指定要获取请求中哪个参数的值
	 * 2)required属性表示请求是否允许没有这个参数，默认是必须有(true)
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping("doRequestParam02")
	@ResponseBody
	public String doRequestParam02(
			@RequestParam(value="username",required=false)
			String name){
		return "param's value "+name;
	}
	@RequestMapping("doRequestParam03")
	@ResponseBody
	public String doRequestParam03(
			String name,
			Integer page){
		return "param's name value "+name+",page value "+page;
	}
	
	@RequestMapping("doRequestParam04")
	@ResponseBody
	public String doRequestParam04(//?ids=1,2,3,4
			Integer... ids){//请求中的ids参数数据需要以","作为分隔符
		String result=Arrays.toString(ids);
		System.out.println(result);//[]
		return "param's ids value "+result;
	}//说明:可变参数也可以写成Integer[] ids
	
	
	@ResponseBody
	@RequestMapping("doRequestParam05")
	public String doRequestParam05(
			//@DateTimeFormat 注解用于指定日期格式
			@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
			Date beginDate){//spring mvc 默认只支持yyyy/MM/dd
		return "param's begindate value "+beginDate;
	}
	//使用值对象封装请求参数数据
	//方法被调用时会构建参数对象，
	//然后基于参数名找对应set方法，实现值的封装。
	@RequestMapping("doRequestParam06")
	@ResponseBody
	public String doRequestParam06(
			SqlOrderCommand cmd){
		return "param's cmd value "+cmd;
	}
	//当使用map封装请求参数数据时，必须使用
	//@RequestParam注解修饰，然后参数会以
	//key/value的形式存储到map
	@RequestMapping("doRequestParam07")
	@ResponseBody
	public String doRequestParam07(
			@RequestParam Map<String,Object> map){
		System.out.println(map.getClass().getName());
		return "param's map value "+map;
	}
	//通过@RequestHeader 注解修饰参数
	//表示参数的值来自于请求头
	@RequestMapping("doRequestParam08")
	@ResponseBody
	public String doRequestParam08(@RequestHeader("Accept-Encoding") String AcceptEncoding){
		return "param's AcceptEncoding value "+AcceptEncoding;
	}
	//借助@CookieValue注解修饰参数以获取请求中cookie的值
	@RequestMapping("doRequestParam09")
	@ResponseBody
	public String doRequestParam09(
	    @CookieValue("JSESSIONID") String JSESSIONID){
		return "param's JSESSIONID value "+JSESSIONID;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}









