package org.jerry.light4j.member.etm.member.role.service;

import java.util.List;
import java.util.Map;

import org.jerry.light4j.member.etm.member.role.domain.MemberRole;

/******************************************
 * 实体服务接口
 * @author janine
 *
 *******************************************/
public interface MemberRoleService {
     /**
      * 实体保存
      * @param memberRole
      * @return
      */
     public MemberRole save(MemberRole memberRole);
     /**
      * 实体更新
      * @param memberRole
      * @return
      */
     public MemberRole update(MemberRole memberRole);
     /**
      * 实体删除
      * @param memberRole
      * @return
      */
     public MemberRole delete(MemberRole memberRole);
     /**
 	 * 根据JPQL语句返回查询实体列表
 	 * @param jpql
 	 * @param paramValueList 参数列表,防止sql注入
 	 * @return
 	 */
 	public  List<MemberRole> queryAllByJPQL(String jpql,List<Object> paramValueList);
 	
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
 	public  List<MemberRole> queryAllBySQL(String sql,List<Object> paramValueList);
 	
 	/**
 	 * 根据sql语句查询键值对列表
 	 * @param sql
 	 * @param paramValueList
 	 * @return
 	 */
 	public List<Map<String,Object>> queryAllColumnBySQL(String sql,List<Object> paramValueList);
}
