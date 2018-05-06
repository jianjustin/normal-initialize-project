package org.jerry.light4j.member.common.base.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

/*****************************************************
 * 基础查询接口(返回查询实体列表,返回Map结构实体列表)
 * 查询方式:JPQL，SQL
 * @author janine
 * @since 2017-12-12
 *
 *****************************************************/
public interface BaseQueryRepository<T,ID extends Serializable> {
	
	/**
	 * 根据JPQL语句返回查询实体列表
	 * @param jpql
	 * @param paramValueList 参数列表,防止sql注入
	 * @return
	 */
	@SuppressWarnings("hiding")
	public <T> List<T> queryAllByJPQL(String jpql,List<Object> paramValueList,Class<T> clazz);
	
	/**
	 * 根据JPQL语句返回查询实体列表
	 * @param jpql
	 * @param paramValueList 参数列表,防止sql注入
	 * @return
	 */
	@SuppressWarnings("hiding")
	public int queryCountByJPQL(String jpql,List<Object> paramValueList,Class<T> clazz);
	
	/**
	 * 根据JPQL语句返回查询实体列表
	 * @param jpql
	 * @param paramValueList 参数列表,防止sql注入
	 * @return
	 */
	@SuppressWarnings("hiding")
	public <T> List<T> queryByPageByJPQL(String jpql,List<Object> paramValueList,Class<T> clazz,int pageNo,int pageSize);
	
	/**
	 * 根据JPQL语句返回查询键值对列表
	 * @param jpql
	 * @param paramValueList
	 * @return
	 */
	public List<Map<String,Object>> queryAllColumnByJPQL(String jpql,List<Object> paramValueList,Class<T> clazz);
	
	/**
	 * 根据JPQL语句返回查询键值对列表
	 * @param jpql
	 * @param paramValueList
	 * @return
	 */
	public List<Map<String,Object>> queryByPageColumnByJPQL(String jpql,List<Object> paramValueList,Class<T> clazz,int pageNo,int pageSize);
	
	
	/**
	 * 根据sql语句查询实体列表
	 * @param sql
	 * @param paramValueList
	 * @return
	 */
	@SuppressWarnings("hiding")
	public <T> List<T> queryAllBySQL(String sql,List<Object> paramValueList,Class<T> clazz);
	
	/**
	 * 根据sql语句查询实体列表
	 * @param sql
	 * @param paramValueList
	 * @return
	 */
	@SuppressWarnings("hiding")
	public int queryCountBySQL(String sql,List<Object> paramValueList,Class<T> clazz);
	
	/**
	 * 根据sql语句查询实体列表
	 * @param sql
	 * @param paramValueList
	 * @return
	 */
	@SuppressWarnings("hiding")
	public <T> List<T> queryByPageBySQL(String sql,List<Object> paramValueList,Class<T> clazz,int pageNo,int pageSize);
	
	/**
	 * 根据sql语句查询键值对列表
	 * @param sql
	 * @param paramValueList
	 * @return
	 */
	public List<Map<String,Object>> queryAllColumnBySQL(String sql,List<Object> paramValueList,Class<T> clazz);
	
	/**
	 * 根据sql语句查询键值对列表
	 * @param sql
	 * @param paramValueList
	 * @return
	 */
	public List<Map<String,Object>> queryByPageColumnBySQL(String sql,List<Object> paramValueList,Class<T> clazz,int pageNo,int pageSize);

}
