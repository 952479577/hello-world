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

@RestController  //��ע�� ͬʱʹ��@Controller �� @ResponseBody
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
	//��Ϊ��¼����Ҫֱ�ӵ� list.jspҳ����ʾ����login.jspҳ��ͨ��submit�ύ�ģ�����֧��ajax,���û���json���ݣ����ǻ���һ��ҳ�����֣�����springmvc����ͼ�������Ϳ���������
	public ModelAndView login(User user,HttpServletRequest request,HttpSession session){
		System.out.println(user.toString());
		ModelAndView mav=new ModelAndView();
		user=userBiz.login(user);
		if(user!=null){
			session.setAttribute("user", user);
			mav.setViewName("list");
			return mav;
		}else{
			request.setAttribute("errormsg", "�û������������");
		}
		mav.setViewName("login");
		return mav;
	}
	
}
