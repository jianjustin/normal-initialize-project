package org.jerry.light4j.member.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * bean工具集
 * @author jian
 *
 */
public class BeanUtils {

	/**
	 * 属性获取
	 * @param obj
	 * @param propertyName
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static <T> Object getPropertyByName(T obj,String propertyName) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		return PropertyUtils.getProperty(obj, propertyName);
	}
	
	/**
	 * 属性设置
	 * @param obj
	 * @param propertyName
	 * @param propertyValue
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static <T> void setPropertyByName(T obj,String propertyName,Object propertyValue){
		try {
			PropertyUtils.setProperty(obj, propertyName, propertyValue);
		} catch (Exception e) {
			return;
		}
	}
	
	/**
	 * copy非空属性
	 * @param source
	 * @param target
	 */
	public static void copyPropertiesOfNotNull(Object source,Object target) throws Exception{
		Field[] fields = source.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			String fieldName = field.getName();
			Object fieldValue = field.get(source);
			if(null == fieldValue)continue;
			setPropertyByName(target, fieldName, fieldValue);
		}
	}
	
}
