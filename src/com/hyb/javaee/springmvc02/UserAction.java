package com.hyb.javaee.springmvc02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * 单例
 * 控制器(程序员)
 * @author hyb
 *
 */


//说明是控制器
@Controller
@RequestMapping(value="/user")
public class UserAction{
	/**
	 * 业务方法,可带参数，可不带参数
	 */
	
	@RequestMapping(value="/register")  //请求映射  
	public String registerMethod(Model model) throws Exception{
		model.addAttribute("message","注册成功 ");
		return "/jsp/success.jsp";
	}
	

	@RequestMapping(value="/login")  //请求映射  
	public String loginMethod(Model model) throws Exception{
		model.addAttribute("message","登录成功 ");
		return "/jsp/success.jsp";
	}

}
