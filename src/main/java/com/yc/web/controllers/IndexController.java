package com.yc.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	@RequestMapping(value="/index.action",method=RequestMethod.GET)
	public String index(){
		return "login";
		//return "/WEB-INF/pages/login.jsp"  //没有视图解析器 InternalResourceViewResolver
	}
	
	@RequestMapping(value="/toRegister.action",method=RequestMethod.GET)
	public String toRegister(){
		return "register";
		//return "/WEB-INF/pages/register.jsp"  //没有视图解析器 InternalResourceViewResolver
	}
	
}
