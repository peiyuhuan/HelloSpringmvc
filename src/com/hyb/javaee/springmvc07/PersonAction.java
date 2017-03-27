package com.hyb.javaee.springmvc07;

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
@RequestMapping(value = "/person")
// 模块路径
public class PersonAction {

	/*
	 * 自定义类型转换器
	 */
	@InitBinder
	public void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	// 请求映射
	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public String registerMethod(Model model) throws Exception {
		
		return "/06Emp.jsp";
	}

}
