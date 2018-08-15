package com.yc.biz;

import java.util.List;
import java.util.Map;

import com.yc.bean.House;
import com.yc.web.model.JsonModel;

public interface HouseBiz {
	/**根据ID查某个房子的信息
	 * @param hb
	 * @return
	 */
	public House getHouseBean(House hb);
	
	public boolean addHouse(House hb);
	
	public boolean updateHouse(House hb);
	
	public boolean delHouse(int id);
	
	public boolean delHouses(List<Integer> ids);
	/**分页查询
	 * @param map
	 * @return
	 */
	public JsonModel<House> searchHouse(Map<String,Object> map);
}
