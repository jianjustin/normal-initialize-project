package org.normal.framework.common.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.normal.framework.common.response.ResponseManager;
import org.normal.framework.common.utils.BasicCacheUtils;
import org.normal.framework.common.utils.MD5Utils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;


/**
 * spring security处理器
 * 
 * @author jian
 *
 *         2017年10月16日
 */
@Configuration
public class SpringSecurityHandlerConfig {

	/**
	 * 登陆成功，返回Token
	 */
	@Bean
	public AuthenticationSuccessHandler loginSuccessHandler() {
		return new AuthenticationSuccessHandler() {

			@Override
			public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
					Authentication authentication) throws IOException, ServletException {
				Date date = new Date();
				SpringSecurityUserDetails userDetails = (SpringSecurityUserDetails)authentication.getPrincipal();
				String value = userDetails.getMemberUserCode()+""+date.getTime();//使用MD5替换token实现
				String md5Value = MD5Utils.crypt(value);
				BasicCacheUtils.addCache(md5Value, userDetails);
				System.out.println("信息验证成功");
			}
		};
	}

	//登录失败
	@Bean
	public AuthenticationFailureHandler loginFailureHandler() {
		return new AuthenticationFailureHandler() {
			@Override
			public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
					AuthenticationException exception) throws IOException, ServletException {
				ResponseManager.handerJsonResponse(response, HttpStatus.UNAUTHORIZED.value(), "登录失败");
			}
		};

	}

	/**
	 * 未登录，返回401
	 * 
	 * @return
	 */
	@Bean
	public AuthenticationEntryPoint authenticationEntryPoint() {
		return new AuthenticationEntryPoint() {

			@Override
			public void commence(HttpServletRequest request, HttpServletResponse response,
					AuthenticationException authException) throws IOException, ServletException {
				ResponseManager.handerJsonResponse(response, HttpStatus.UNAUTHORIZED.value(), "请登录后操作");
			}
		};
	}

	/**
	 * 退出处理
	 */
	@Bean
	public LogoutSuccessHandler logoutSussHandler() {
		return new LogoutSuccessHandler() {

			@Override
			public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
					Authentication authentication) throws IOException, ServletException {
				//删除会话token
				ResponseManager.handerJsonResponse(response, HttpStatus.OK.value(), "退出登录成功");
			}
		};

	}
	
	public static void main(String[] args) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = passwordEncoder.encode("admin");
        System.out.println(password);
	}

}
