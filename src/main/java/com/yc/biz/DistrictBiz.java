package com.yc.biz;

import java.util.List;

import com.yc.bean.District;
import com.yc.bean.Street;

public interface DistrictBiz {
	/**
	 * ��ѯ���е���
	 * @return
	 */
	public List<District> getDistrictList();
	/**
	 * ������ID��ѯ���еĽֵ�
	 * @return
	 */
	public List<Street> getStreetByDistricId(Integer did);
	
}
