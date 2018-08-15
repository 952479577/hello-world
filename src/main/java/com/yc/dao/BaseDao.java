package com.yc.dao;

import java.util.List;
import java.util.Map;


public interface BaseDao<T> {
	/**
	 * @param t:要保存的数据对象
	 * @param sqlId
	 */
	public void save(T t,String sqlId);
	
	public void save(Class<T> clazz, String sqlId, Map<String, Object> parameterMap);
	
	public void save(Class<T> clazz, String sqlId, List<T> list);
	
	/**更新对象
	 * @param t
	 * @param sqlId
	 */
	public void update(T t,String sqlId);
	
	public void update(Class<T> clazz, String sqlId);
	
	/**只根据ID删除一条数据
	 * @param 
	 */
	public void del(Class<T> clazz,String id,String sqlId);
	
	/**根据ids删除多条数据
	 * @param t:要保存的数据对象
	 */
	public void del(Class<T> clazz,List<Object> ids,String sqlId);
	
	
	/**查集合，没有条件属性
	 * @param clazz
	 * @param sqlId
	 * @return
	 */
	public List<T> findAll(Class<T> clazz,String sqlId);
	/**查集合，条件查询
	 * @param t
	 * @param sqlId :查询语句的id
	 * @return
	 */
	public List<T> findAll(T t,String sqlId);
	/**条件查询，查一条数据
	 * @param t
	 * @param sqlId
	 * @return
	 */
	public T findOne(T t,String sqlId);
	/**根据条件分页查询
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
	
	/**聚合查询
	 * @param clazz
	 * @param sqlId
	 * @return
	 */
	public int getCount(Class<T> clazz,String sqlId);
	
	/**聚合查询
	 * @param clazz
	 * @param sqlId
	 * @return
	 */
	public double getFunc(Class<T> clazz,String sqlId);
	/**根据条件聚合查询
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














