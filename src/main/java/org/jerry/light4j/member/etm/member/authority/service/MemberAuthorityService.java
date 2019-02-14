package org.jerry.light4j.member.etm.member.authority.service;

import java.util.List;
import java.util.Map;

import org.jerry.light4j.member.etm.member.authority.domain.MemberAuthority;

/******************************************
 * 实体服务接口
 * @author janine
 *
 *******************************************/
public interface MemberAuthorityService {
     /**
      * 实体保存
      * @param memberAuthority
      * @return
      */
     public MemberAuthority save(MemberAuthority memberAuthority);
     /**
      * 实体更新
      * @param memberAuthority
      * @return
      */
     public MemberAuthority update(MemberAuthority memberAuthority);
     /**
      * 实体删除
      * @param memberAuthority
      * @return
      */
     public MemberAuthority delete(MemberAuthority memberAuthority);
     /**
 	 * 根据JPQL语句返回查询实体列表
 	 * @param jpql
 	 * @param paramValueList 参数列表,防止sql注入
 	 * @return
 	 */
 	public  List<MemberAuthority> queryAllByJPQL(String jpql,List<Object> paramValueList);
 	
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
 	public  List<MemberAuthority> queryAllBySQL(String sql,List<Object> paramValueList);
 	
 	/**
 	 * 根据sql语句查询键值对列表
 	 * @param sql
 	 * @param paramValueList
 	 * @return
 	 */
 	public List<Map<String,Object>> queryAllColumnBySQL(String sql,List<Object> paramValueList);
}
