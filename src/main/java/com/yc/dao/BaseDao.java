package com.yc.dao;

import java.util.List;
import java.util.Map;


public interface BaseDao<T> {
	/**
	 * @param t:Ҫ��������ݶ���
	 * @param sqlId
	 */
	public void save(T t,String sqlId);
	
	public void save(Class<T> clazz, String sqlId, Map<String, Object> parameterMap);
	
	public void save(Class<T> clazz, String sqlId, List<T> list);
	
	/**���¶���
	 * @param t
	 * @param sqlId
	 */
	public void update(T t,String sqlId);
	
	public void update(Class<T> clazz, String sqlId);
	
	/**ֻ����IDɾ��һ������
	 * @param 
	 */
	public void del(Class<T> clazz,String id,String sqlId);
	
	/**����idsɾ����������
	 * @param t:Ҫ��������ݶ���
	 */
	public void del(Class<T> clazz,List<Object> ids,String sqlId);
	
	
	/**�鼯�ϣ�û����������
	 * @param clazz
	 * @param sqlId
	 * @return
	 */
	public List<T> findAll(Class<T> clazz,String sqlId);
	/**�鼯�ϣ�������ѯ
	 * @param t
	 * @param sqlId :��ѯ����id
	 * @return
	 */
	public List<T> findAll(T t,String sqlId);
	/**������ѯ����һ������
	 * @param t
	 * @param sqlId
	 * @return
	 */
	public T findOne(T t,String sqlId);
	/**����������ҳ��ѯ
	 * @param clazz
	 * @param map
	 * @param sqlId
	 * @param offset
	 * @param sizePage
	 * @return
	 */
	public List<T> findList(Class<T> clazz,
			Map<String,Object> map,String sqlId,int offset,
			int sizePage);
	
	/**�ۺϲ�ѯ
	 * @param clazz
	 * @param sqlId
	 * @return
	 */
	public int getCount(Class<T> clazz,String sqlId);
	
	/**�ۺϲ�ѯ
	 * @param clazz
	 * @param sqlId
	 * @return
	 */
	public double getFunc(Class<T> clazz,String sqlId);
	/**���������ۺϲ�ѯ
	 * @param clazz
	 * @param map
	 * @param sqlID
	 * @return
	 */
	public int getCount(Class<T> clazz,Map<String,Object> map,String sqlID);

	public void del(T t, String sqlId);

	public void del(Class<T> clazz, Map<String, Object> ids, String sqlId);

	public List<T> findAll(Class<T> clazz, String sqlId, Map<String, Object> parameterMap);

	public T findOne(Class<T> clazz, String sqlId);

	public T findOne(Class<T> clazz, String sqlId, Map<String, Object> parameterMap);

	
	public double getFunc(T t, String sqlId);

	public double getFunc(Class<T> clazz, String sqlId, Map<String, Object> map);
	
	
	
	
	
	
}














