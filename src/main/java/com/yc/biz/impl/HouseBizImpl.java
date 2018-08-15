package com.yc.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.House;
import com.yc.biz.HouseBiz;
import com.yc.dao.BaseDao;
import com.yc.web.model.JsonModel;
@Service
public class HouseBizImpl implements HouseBiz {

	@Resource(name="baseDao")
	private BaseDao baseDao;

	@Override
	public House getHouseBean(House hb) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("id", hb.getId()+"");
		List<House> list=(List<House>)this.baseDao.findAll(hb, "findHouseCondition");
		if(list!=null && list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public boolean addHouse(House hb) {
		baseDao.save(hb, "saveHouse");
		return true;
	}

	@Override
	public boolean updateHouse(House hb) {
		baseDao.update(hb, "updateHouse");
		return true;
	}

	@Override
	public boolean delHouse(int id) {
		baseDao.del(House.class,id+"", "delSingleHouse");
		return true;
	}

	@Override
	public boolean delHouses(List<Integer> ids) {
		baseDao.del(House.class, ids, "delMutilHouse");
		return true;
	}

	@Override
	public JsonModel<House> searchHouse(Map<String, Object> map) {
		List<House> list=baseDao.findList(House.class, map, "findHouseCondition", 0, 0);
		int total=baseDao.getCount(House.class,map, "findHouseConditionCount");
		
		JsonModel<House> jsonModel=new JsonModel<House>();
		jsonModel.setCode(1);
		jsonModel.setRows(list);
		jsonModel.setTotal(total);
		jsonModel.setPages(Integer.parseInt(map.get("start").toString()));
		jsonModel.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		return jsonModel;
	}

}
