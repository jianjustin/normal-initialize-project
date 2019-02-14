package org.jerry.light4j.member.etm.member.resource.service;

import java.util.List;
import java.util.Map;

import org.jerry.light4j.member.etm.member.resource.domain.MemberResource;

/******************************************
 * 实体服务接口
 * @author janine
 *
 *******************************************/
public interface MemberResourceService {
     /**
      * 实体保存
      * @param memberResource
      * @return
      */
     public MemberResource save(MemberResource memberResource);
     /**
      * 实体更新
      * @param memberResource
      * @return
      */
     public MemberResource update(MemberResource memberResource);
     /**
      * 实体删除
      * @param memberResource
      * @return
      */
     public MemberResource delete(MemberResource memberResource);
     /**
 	 * 根据JPQL语句返回查询实体列表
 	 * @param jpql
 	 * @param paramValueList 参数列表,防止sql注入
 	 * @return
 	 */
 	public  List<MemberResource> queryAllByJPQL(String jpql,List<Object> paramValueList);
 	
 	/**
 	 * 根据JPQL语句返回查询键值对列表
 	 * @param jpql
 	 * @param paramValueList
 	 * @return
 	 */
 	public List<Map<String,Object>> queryAllColumnByJPQL(String jpql,List<Object> paramValueList);
 	
 	/**
 	 * 根据sql语句查询实体列表
 	 * @param sql
 	 * @param paramValueList
 	 * @return
 	 */
 	public  List<MemberResource> queryAllBySQL(String sql,List<Object> paramValueList);
 	
 	/**
 	 * 根据sql语句查询键值对列表
 	 * @param sql
 	 * @param paramValueList
 	 * @return
 	 */
 	public List<Map<String,Object>> queryAllColumnBySQL(String sql,List<Object> paramValueList);
}
