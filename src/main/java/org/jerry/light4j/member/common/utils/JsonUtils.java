package org.jerry.light4j.member.common.utils;

import com.google.gson.Gson;

/**
 * 基于google的gson包的json工具包
 * @author jian
 *
 */
public class JsonUtils {

	/**
	 * 根据对象获取json字符串
	 * @param obj
	 * @return
	 */
	public static <T> String toJson(T obj){
		Gson gson = new Gson();
		return gson.toJson(obj);
	}
	
	/**
	 * 根据json字符串获取实体对象
	 * @param jsonStr
	 * @param clazz
	 * @return
	 */
	public static <T> T from(String jsonStr,Class<T> clazz){
		Gson gson = new Gson();
		return gson.fromJson(jsonStr, clazz);
	}
	
}
