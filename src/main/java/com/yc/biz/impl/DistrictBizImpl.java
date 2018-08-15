package com.yc.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.District;
import com.yc.bean.Street;
import com.yc.biz.DistrictBiz;
import com.yc.dao.BaseDao;
@Service
public class DistrictBizImpl implements DistrictBiz {

	@Resource(name="baseDao")
	private BaseDao baseDao;
	
	@Override
	public List<District> getDistrictList() {
		List<District> list=baseDao.findAll(District.class, "findAllDistrict");
		return list;
	}

	@Override
	public List<Street> getStreetByDistricId(Integer did) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("district_id", did);
		List<Street> list=baseDao.findAll(Street.class, "getStreetByDistrict",map);
		return list;
	}

}
