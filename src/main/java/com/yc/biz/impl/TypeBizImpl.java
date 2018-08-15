package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.HouseType;
import com.yc.biz.HouseTypeBiz;
import com.yc.dao.BaseDao;
@Service
public class TypeBizImpl implements HouseTypeBiz {

	@Resource(name="baseDao")
	private BaseDao baseDao;
	
	@Override
	public List<HouseType> getTypeList() {
		List<HouseType> type=null;
		type=baseDao.findAll(HouseType.class, "getAllType");
		return type;
	}

}
