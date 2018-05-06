package org.jerry.light4j.member.etm.member.user.service;

import java.util.List;
import java.util.Map;

import org.jerry.light4j.member.etm.member.user.domain.MemberUser;

/******************************************
 * 实体服务接口
 * @author janine
 *
 *******************************************/
public interface MemberUserService {
     /**
      * 实体保存
      * @param memberUser
      * @return
      */
     public MemberUser save(MemberUser memberUser);
     /**
      * 实体更新
      * @param memberUser
      * @return
      */
     public MemberUser update(MemberUser memberUser);
     /**
      * 实体删除
      * @param memberUser
      * @return
      */
     public MemberUser delete(MemberUser memberUser);
     /**
 	 * 根据JPQL语句返回查询实体列表
 	 * @param jpql
 	 * @param paramValueList 参数列表,防止sql注入
 	 * @return
 	 */
 	public  List<MemberUser> queryAllByJPQL(String jpql,List<Object> paramValueList);
 	
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
 	public  List<MemberUser> queryAllBySQL(String sql,List<Object> paramValueList);
 	
 	/**
 	 * 根据sql语句查询键值对列表
 	 * @param sql
 	 * @param paramValueList
 	 * @return
 	 */
 	public List<Map<String,Object>> queryAllColumnBySQL(String sql,List<Object> paramValueList);
}
