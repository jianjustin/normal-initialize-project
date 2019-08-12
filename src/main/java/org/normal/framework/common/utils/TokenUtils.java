package org.normal.framework.common.utils;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * token工具类
 * @author chenjianrui
 *
 */
public class TokenUtils {
	
	/**
	 * 根据用户信息获取token
	 * @param userDetails
	 * @return
	 */
	public static String saveToken(UserDetails userDetails) {
		String token = "";
		return token;
	}

	/**
	 * 根据token获取用户信息
	 * @param token
	 * @return
	 */
	public static UserDetails getUser(String token) {
		return null;
	}
	
	/**
	 * 移除用户token信息
	 * @param token
	 * @return
	 */
	public static UserDetails removeUser(String token) {
		return null;
	}
}
