package com.yc.web.listeners;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.yc.bean.District;
import com.yc.bean.HouseType;
import com.yc.biz.DistrictBiz;
import com.yc.biz.HouseTypeBiz;

/**
 * 当servlet容器一启动就会加载这个类
 */
public class InitListener implements ServletContextListener {

	private ApplicationContext ac;
	
	public InitListener() {
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

	public void contextInitialized(ServletContextEvent sce) {
		//取application
		ServletContext application=sce.getServletContext();
		ac=WebApplicationContextUtils.getWebApplicationContext(application);
		HouseTypeBiz typeBiz=(HouseTypeBiz) ac.getBean("typeBizImpl");
		List<HouseType> houseType=typeBiz.getTypeList();
		application.setAttribute("houseTypeList", houseType);
		DistrictBiz districtBiz=(DistrictBiz) ac.getBean("districtBizImpl");
		List<District> districtList=districtBiz.getDistrictList();
		application.setAttribute("districtList", districtList);
		System.out.println("容器初始化: ");
		System.out.println(districtList);
		System.out.println(houseType);
	}
}
















