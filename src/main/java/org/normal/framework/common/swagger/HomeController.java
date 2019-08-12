package org.normal.framework.common.swagger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 页面重定向--默认跳转swagger页面
 * @author chenjianrui
 *
 */
@Controller
public class HomeController {
	
	@GetMapping(value = "/login")
	public String index() {
		return "redirect:login.html";
	}
	
}
