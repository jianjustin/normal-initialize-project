package org.normal.framework.common.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.normal.framework.common.utils.BasicCacheUtils;
import org.normal.framework.common.utils.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * token认证拦截器
 * @author chenjianrui
 *
 */
@Component
public class SpringSecurityTokenFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	    //用于校验时加载权限信息
		String token = getToken(request);
		if (StringUtils.isNotBlank(token)) {
			SpringSecurityUserDetails securityUserDetails = (SpringSecurityUserDetails)BasicCacheUtils.getCache(token);
			if (securityUserDetails != null) {
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(securityUserDetails,
						null, securityUserDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}

		filterChain.doFilter(request, response);
	}

	/**
	 * 根据参数或者header获取token
	 * 
	 * @param request
	 * @return
	 */
	public static String getToken(HttpServletRequest request) {
		String token = request.getParameter("token");
		if (StringUtils.isBlank(token)) {
			token = request.getHeader("token");
		}
		return token;
	}


}
