package org.normal.framework.common.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService{

	/**
	 * 加载用户信息接口
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("加载用户数据");
		
		//根据用户名称获取用户信息
		
		//根据用户id获取用户权限信息
		return null;
	}

}
