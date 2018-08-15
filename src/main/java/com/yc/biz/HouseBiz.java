package com.yc.biz;

import java.util.List;
import java.util.Map;

import com.yc.bean.House;
import com.yc.web.model.JsonModel;

public interface HouseBiz {
	/**����ID��ĳ�����ӵ���Ϣ
	 * @param hb
	 * @return
	 */
	public House getHouseBean(House hb);
	
	public boolean addHouse(House hb);
	
	public boolean updateHouse(House hb);
	
	public boolean delHouse(int id);
	
	public boolean delHouses(List<Integer> ids);
	/**��ҳ��ѯ
	 * @param map
	 * @return
	 */
	public JsonModel<House> searchHouse(Map<String,Object> map);
}
