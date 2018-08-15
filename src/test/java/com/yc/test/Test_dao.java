package com.yc.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.bean.District;
import com.yc.bean.House;
import com.yc.bean.HouseType;
import com.yc.bean.User;
import com.yc.biz.DistrictBiz;
import com.yc.biz.HouseBiz;
import com.yc.biz.HouseTypeBiz;
import com.yc.biz.UserBiz;
import com.yc.dao.BaseDao;
import com.yc.web.model.JsonModel;
//junit����ʱ���ͻ��Զ���: ApplicationContext ac=new
//ClassPathXmlApplicationContext("classpath:beans.xml");
//���������Զ�����.
@RunWith(SpringJUnit4ClassRunner.class) // ֵ: SpringJUnit4ClassRunner ��ʾʹ��spring
										// junit���� -> �����Զ������ ioc,di
										// JUnit ��ʾʹ��ԭ���� junit����
@ContextConfiguration({ "classpath:beans.xml","classpath:beans-dao.xml" }) // ��������,
public class Test_dao {
	@Resource(name="districtBizImpl")
	private DistrictBiz districtBizImpl;

	@Resource(name="typeBizImpl")
	private HouseTypeBiz typeBizImpl;
	
	@Resource(name="houseBizImpl")
	private HouseBiz houseBiz;
	
	@Resource(name="userBizImpl")
	private UserBiz userBiz;
	
	@Resource(name="baseDao")
	private BaseDao baseDao;

	@Test
	public void test() {
		List<District> list=districtBizImpl.getDistrictList();
		System.out.println( list);
	}
	
	@Test
	public void test2() {
		List<HouseType> houseType=typeBizImpl.getTypeList();
		System.out.println(houseType);
	}
	
	
	
	@Test
	public void test3() {
		User u=new User();
		u.setUsername("a");
		u.setPassword("a");
		User u2=userBiz.login(u);
		System.out.println(u2);
	}
	
	
	
	@Test//������������ͳ�Ʋ�ѯand 
	public void test4() {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("start", "0");
		map.put("pagesize", "10");
		//JsonModel jsonModel=houseBiz.searchHouse(map);
		//int total=baseDao.getCount(House.class,map, "findHouseConditionCount");
		List<House> list=baseDao.findList(House.class, map, "findHouseCondition", 0, 0);
		//System.out.println(total);
		System.out.println(list);
		
	}
	
	
	

}

//1
//Caused by: org.springframework.beans.factory.xml.XmlBeanDefinitionStoreException: Line 16 in XML document from class path resource [beans-dao.xml] is invalid; nested exception is org.xml.sax.SAXParseException; lineNumber: 16; columnNumber: 68; cvc-elt.1: �Ҳ���Ԫ�� 'beans' ��������
//
//Caused by: org.xml.sax.SAXParseException; lineNumber: 16; columnNumber: 68; cvc-elt.1: �Ҳ���Ԫ�� 'beans' ��������
//2
//org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.exceptions.PersistenceException: 
//### Error querying database.  Cause: java.lang.IllegalArgumentException: Mapped Statements collection does not contain value for com.yc.bean.DistrictMapperfindAllDistrict
//### Cause: java.lang.IllegalArgumentException: Mapped Statements collection does not contain value for com.yc.bean.DistrictMapperfindAllDistrict
//	
//Caused by: org.apache.ibatis.exceptions.PersistenceException: 
//### Error querying database.  Cause: java.lang.IllegalArgumentException: Mapped Statements collection does not contain value for com.yc.bean.DistrictMapperfindAllDistrict
//### Cause: java.lang.IllegalArgumentException: Mapped Statements collection does not contain value for com.yc.bean.DistrictMapperfindAllDistrict
//	
//Caused by: java.lang.IllegalArgumentException: Mapped Statements collection does not contain value for com.yc.bean.DistrictMapperfindAllDistrict
//
//3
//org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.builder.IncompleteElementException: Could not find result map com.yc.bean.HouseMapper.HouseMap
//Caused by: org.apache.ibatis.builder.IncompleteElementException: Could not find result map com.yc.bean.HouseMapper.HouseMap
//Caused by: java.lang.IllegalArgumentException: Result Maps collection does not contain value for com.yc.bean.HouseMapper.HouseMap


