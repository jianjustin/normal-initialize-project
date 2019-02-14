package org.jerry.light4j.member.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.jerry.light4j.member.common.utils.StringUtils;

/**
 * sql工具集,用于sql注入组装
 * @author chenjianrui
 *
 */
public class SqlUtils {
	
	public static List<Object> paramValueList;
	public static final String initSql = "select t from modelName t where 1=1";
	public static final String databaseName = "test";
	
	/**
	 * 重置参数集
	 * @return
	 */
	public static List<Object> createParamValueList(){
		paramValueList = new ArrayList<Object>();
		return paramValueList;
	}
	
	/**
	 * 返回参数集
	 * @return
	 */
	public static List<Object> getParamValueList(){
		return paramValueList;
	}
	
	/**
	 * 根据表名称初始化jpql
	 * @return
	 */
	public static String getInitSql(String modelName){
		return StringUtils.replace(SqlUtils.initSql, "modelName", modelName);
	}
	
	/**
	 * 通过sql拼接获取andSql
	 * @param beforeSql
	 * @param paramValue
	 * @param paramName
	 * @param paramValueList
	 * @return
	 */
	public static String getNextAndSql(String beforeSql,Object paramValue,String paramName,List<Object> paramValueList){
		String sql = beforeSql + " and " + paramName + " = " + paramValue;
		if(null == paramValueList)paramValueList = new ArrayList<Object>();
		return sql;
	}
	
	/**
	 * 拼接like Sql
	 * @param beforeSql
	 * @param paramValue
	 * @param paramName
	 * @param paramValueList
	 * @return
	 */
	public static String getNextLikeSql(String beforeSql,Object paramValue,String paramName,List<Object> paramValueList){
		String sql = beforeSql + " like " + paramName + " = " + paramValue;
		if(null == paramValueList)paramValueList = new ArrayList<Object>();
		return sql;
	}
	
	/**
	 * 拼接or sql
	 * @param beforeSql
	 * @param paramValue
	 * @param paramName
	 * @param paramValueList
	 * @return
	 */
	public static String getNextOrSql(String beforeSql,Object paramValue,String paramName,List<Object> paramValueList){
		String sql = beforeSql + " or " + paramName + " = " + paramValue;
		if(null == paramValueList)paramValueList = new ArrayList<Object>();
		return sql;
	}

}
