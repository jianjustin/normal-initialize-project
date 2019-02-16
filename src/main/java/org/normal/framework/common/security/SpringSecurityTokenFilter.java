package org.normal.framework.common.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.normal.framework.common.utils.BasicCacheUtils;
import org.normal.framework.common.utils.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

/**
 * token认证拦截器
 * @author chenjianrui
 *
 */
@Component
public class SpringSecurityTokenFilter extends GenericFilterBean{

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		String token = getToken(arg0);
		if (StringUtils.isNotBlank(token)) {
			SpringSecurityUserDetails securityUserDetails = (SpringSecurityUserDetails)BasicCacheUtils.getCache(token);
			if (securityUserDetails != null) {
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(securityUserDetails,
						null, securityUserDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}

		arg2.doFilter(arg0, arg1);
	}
	
	/**
	 * 根据参数或者header获取token
	 * 
	 * @param arg0
	 * @return
	 */
	public static String getToken(ServletRequest arg0) {
		String token = arg0.getParameter("token");
		return token;
	}


}
