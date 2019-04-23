package com.pt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pt.member.entity.Member;

@Controller
@RequestMapping("/resp/")
public class ResponseHandleController {
      
	  @RequestMapping("doResponse01")
	  public void doResponse01(
	     HttpServletResponse response)
			throws IOException{
		  response.getWriter().write("<div>hello spring mvc</div>");
	  }
	  @RequestMapping("doResponse02")
	  public ModelAndView doResponse02(ModelAndView mv){
		  //ModelAndView mv=new ModelAndView();
		  mv.setViewName("response");
		  //系统底层会将数据存储到map，然后将内容存储到请求作用域
		  mv.addObject("msg", "hello spring mvc");
		  return mv;
	  }
	  @RequestMapping("doResponse03")
	  public String doResponse03(Model model){//一个接口，底层实现用于存储数据
		  model.addAttribute("msg", "hello spring mvc");
		  return "response";//viewname
	  }
	  //将响应数据封装到map (了解)
	  @RequestMapping("doResponse04")
	  public String doResponse04(Map<String,Object> map){
		   map.put("msg","hello tedu");
		   return "response";//请求转发
	  }//说明：假如参数使用@RequestParam注解修饰则不能再作为响应数据封装了
	  
	  //响应方式：
	  //spring mvc 中重定向的实现
	  //需要在返回的viewname前加上redirect前缀
	  @RequestMapping("doResponse05")
	  public String doResponse05(){
		  return "redirect:doResponse04.do";
	  }
	  
	  //将对象内容转换为json格式字符串，然后输出到客户端
	  @RequestMapping("doResponse06")
	  public void doResponse06(HttpServletResponse resp)
	  throws IOException{
		  //假设如下map中的数据来自数据库
		  Map<String,Object> map=new HashMap<>();
		  map.put("id", 100);
		  map.put("phone","12345657898");
		  //从map中获取数据,将数据转换为json格式字符串
		  Object id=map.get("id");
		  Object phone=map.get("phone");
		  String jsonStr="{\"id\":"+id+",\"phone\":"+phone+"}";
		  //将json格式字符串写到客户端
		  resp.getWriter().write(jsonStr);
	  }
	  
	  @RequestMapping("doResponse07")
	  @ResponseBody
	  public Map<String,Object> doResponse07(){
		  //假设如下map中的数据来自数据库
		  Map<String,Object> map=new HashMap<>();
		  map.put("id", 100);
		  map.put("phone","12345657898");
		  return map;
		  //底层会启动消息转换器将map对象转换为JSON格式的字符串
		  //前提:1)添加加依赖库 2)使用@ResponseBody注解修饰
	  }
	  @RequestMapping("doResponse08")
	  @ResponseBody
	  public List<Map<String,Object>> doResponse08(){
		  List<Map<String,Object>> list=
				  new ArrayList<>();
		  Map<String,Object> map=new HashMap<>();
		  map.put("id", 100);
		  map.put("phone","12345657898");
		  list.add(map);
		  map=new HashMap<>();
		  map.put("id", 200);
		  map.put("phone","13545657898");
		  list.add(map);
		  return list;
	  }
	  
	  @RequestMapping("doResponse09")
	  @ResponseBody
	  public Member doResponse09(){
		  Member m=new Member();
		  m.setNickname("guolin");
		  m.setEmail("guolin@t.com");
		  m.setPassword("123456");
		  m.setId(100);
		  ///....
		  return m;
	  }//底层可以将此对象转换为json格式字符串
	  //底层将对象转换为json串时会调用对象的get方法
}





