package com.yc.web.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yc.bean.House;
import com.yc.bean.User;
import com.yc.biz.HouseBiz;
import com.yc.web.model.JsonModel;

@Controller
public class HouseController {
	@Resource(name="houseBizImpl")
	private HouseBiz houseBiz;
	
	@RequestMapping("house_list.action")
	public String houseList(HttpServletRequest request,
			@RequestParam(name="pages") Integer pages,
			@RequestParam(name="pageSize") Integer pagesize){
		System.out.println("≤È—Ø");
		Map<String,Object> map=new HashMap<String,Object>();
		int start=(pages-1)*pagesize;
		map.put("start", start);
		map.put("pageSize", pagesize);
		JsonModel jsonModel=houseBiz.searchHouse(map);
		System.out.println(jsonModel);
		request.setAttribute("jsonModel", jsonModel);
		return "showList";
	}
	
	@RequestMapping("/user/house_toAdd.action")
	public String houseAdd(){
		return "add";
	}
	@RequestMapping("/user/house_doAdd.action")
	public String houseDoAdd(House house,HttpSession session){
		User user=(User) session.getAttribute("user");
		house.setUser_id(user.getId());
		boolean result=houseBiz.addHouse(house);
		return "list";
	}
}
