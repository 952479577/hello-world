package com.yc.web.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yc.bean.User;
import com.yc.biz.UserBiz;
import com.yc.web.model.JsonModel;

@RestController  //类注解 同时使用@Controller 和 @ResponseBody
public class UserController {
	@Resource(name="userBizImpl")
	private UserBiz userBiz;
	
	@RequestMapping("/user_register.action")
	public JsonModel register(User user){
		JsonModel jm=new JsonModel();
		boolean result=userBiz.register(user);
		if(result){
			jm.setCode(1);
		}else{
			jm.setCode(0);
		}
		return jm;
	}				  
	@RequestMapping("/user_login.action")
	//因为登录后是要直接到 list.jsp页做显示，且login.jsp页是通过submit提交的，即不支持ajax,不用回送json数据，而是回送一个页面名字，这样springmvc的视图解析器就可以运行了
	public ModelAndView login(User user,HttpServletRequest request,HttpSession session){
		System.out.println(user.toString());
		ModelAndView mav=new ModelAndView();
		user=userBiz.login(user);
		if(user!=null){
			session.setAttribute("user", user);
			mav.setViewName("list");
			return mav;
		}else{
			request.setAttribute("errormsg", "用户名或密码错误");
		}
		mav.setViewName("login");
		return mav;
	}
	
}
