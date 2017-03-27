package com.hyb.javaee.springmvc05;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 单例 控制器(程序员) 在业务控制方法中写入模型变量收集参数，且使用@InitBind来解决字符串转日期类型
 * 
 * @author hyb
 * 
 */

// 说明是控制器
@Controller
@RequestMapping(value = "/user")  //模块路径
public class UserAction {

	/*
	 * 自定义类型转换器
	 */
	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}

	@RequestMapping(method = RequestMethod.POST, value = "/register")
	// 请求映射
	public String registerMethod(User user, Model model) throws Exception {
		System.out.println("用户注册：" + user.toString());
		// 将user绑定到model对象中
		model.addAttribute("user", user);
		// 转发
		return "/jsp/success05.jsp";
	}

}
