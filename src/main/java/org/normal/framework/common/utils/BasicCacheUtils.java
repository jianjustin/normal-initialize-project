package org.normal.framework.common.utils;

import java.util.HashMap;
import java.util.Map;

public class BasicCacheUtils {

	public static Map<String,Object> cacheMap = new HashMap<String,Object>();
	
	public static void addCache(String key,Object value) {
		cacheMap.put(key, value);
	}
	
    public static Object getCache(String key) {
		return cacheMap.get(key);
	}

    public static Object removeCache(String key) {
    	return cacheMap.remove(key);
    }
	
}
