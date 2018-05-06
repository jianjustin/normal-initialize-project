package org.jerry.light4j.member.common.base.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.transform.Transformers;
import org.jerry.light4j.member.common.base.repository.BaseQueryRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
@Repository
public class BaseQueryRepositoryImpl<T, ID extends Serializable> implements BaseQueryRepository<T, ID> {

    @PersistenceContext
	private  EntityManager entityManager;
	
	@SuppressWarnings({ "hiding", "unchecked" })
	public <T> List<T> queryAllByJPQL(String jpql, List<Object> paramValueList,Class<T> clazz) {
		if(null == paramValueList)paramValueList  = new ArrayList<Object>();
		Query query = this.entityManager.createQuery(jpql,clazz);
		/**参数设置*/
		for (int i = 0; i < paramValueList.size(); i++) {
			query.setParameter(i+1, paramValueList.get(i));
		}
		List<T> list = query.getResultList();
		return list;
	}
	
	@SuppressWarnings({ "hiding", "unchecked" })
	public <T> List<T> queryByPageByJPQL(String jpql, List<Object> paramValueList,Class<T> clazz,int pageNo,int pageSize) {
		if(null == paramValueList)paramValueList  = new ArrayList<Object>();
		Query query = this.entityManager.createQuery(jpql,clazz);
		/**参数设置*/
		for (int i = 0; i < paramValueList.size(); i++) {
			query.setParameter(i+1, paramValueList.get(i));
		}
		List<T> list = query.setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).getResultList();
		return list;
	}
	
	@SuppressWarnings({ "hiding", "unchecked" })
	public int queryCountByJPQL(String jpql, List<Object> paramValueList,Class<T> clazz) {
		if(null == paramValueList)paramValueList  = new ArrayList<Object>();
		Query query = this.entityManager.createQuery(jpql,clazz);
		/**参数设置*/
		for (int i = 0; i < paramValueList.size(); i++) {
			query.setParameter(i+1, paramValueList.get(i));
		}
		return query.getResultList().size();
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> queryAllColumnByJPQL(String jpql,List<Object> paramValueList,Class<T> clazz) {
		if(null == paramValueList)paramValueList  = new ArrayList<Object>();
		Query query = this.entityManager.createQuery(jpql);
		/**参数设置*/
		for (int i = 0; i < paramValueList.size(); i++) {
			query.setParameter(i, paramValueList.get(i));
		}
		query.unwrap(org.hibernate.Query.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map<String, Object>> list = query.getResultList();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> queryByPageColumnByJPQL(String jpql,List<Object> paramValueList,Class<T> clazz,int pageNo,int pageSize) {
		if(null == paramValueList)paramValueList  = new ArrayList<Object>();
		Query query = this.entityManager.createQuery(jpql);
		/**参数设置*/
		for (int i = 0; i < paramValueList.size(); i++) {
			query.setParameter(i, paramValueList.get(i));
		}
		query.unwrap(org.hibernate.Query.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map<String, Object>> list = query.setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).getResultList();
		return list;
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	public <T> List<T> queryAllBySQL(String sql, List<Object> paramValueList,Class<T> clazz) {
		if(null==paramValueList)paramValueList = new ArrayList<Object>();
		Query query = this.entityManager.createNativeQuery(sql,clazz);
		for(int i=0;i<paramValueList.size();i++){
			query.setParameter(i, paramValueList.get(i));
		}
		List<T> list = query.getResultList();
		return list;
	}
	
	@SuppressWarnings({ "unchecked", "hiding" })
	public int queryCountBySQL(String sql, List<Object> paramValueList,Class<T> clazz) {
		if(null==paramValueList)paramValueList = new ArrayList<Object>();
		Query query = this.entityManager.createNativeQuery(sql,clazz);
		for(int i=0;i<paramValueList.size();i++){
			query.setParameter(i, paramValueList.get(i));
		}
		return query.getResultList().size();
	}
	
	@SuppressWarnings({ "unchecked", "hiding" })
	public <T> List<T> queryByPageBySQL(String sql, List<Object> paramValueList,Class<T> clazz,int pageNo,int pageSize) {
		if(null==paramValueList)paramValueList = new ArrayList<Object>();
		Query query = this.entityManager.createNativeQuery(sql,clazz);
		for(int i=0;i<paramValueList.size();i++){
			query.setParameter(i, paramValueList.get(i));
		}
		List<T> list = query.setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> queryAllColumnBySQL(String sql,List<Object> paramValueList,Class<T> clazz) {
		if(null == paramValueList)paramValueList = new ArrayList<Object>();
		Query query = this.entityManager.createNativeQuery(sql);
		/**参数设置*/
		for (int i = 0; i < paramValueList.size(); i++) {
			query.setParameter(i, paramValueList.get(i));
		}
		query.unwrap(org.hibernate.Query.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map<String, Object>> list = query.getResultList();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> queryByPageColumnBySQL(String sql,List<Object> paramValueList,Class<T> clazz,int pageNo,int pageSize) {
		if(null == paramValueList)paramValueList = new ArrayList<Object>();
		Query query = this.entityManager.createNativeQuery(sql);
		/**参数设置*/
		for (int i = 0; i < paramValueList.size(); i++) {
			query.setParameter(i, paramValueList.get(i));
		}
		query.unwrap(org.hibernate.Query.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map<String, Object>> list = query.setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).getResultList();
		return list;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
