package com.hyb.javaee.springmvc08;

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
@RequestMapping(value = "/emp")
// 模块路径
public class EditAction {

	// 请求映射
	@RequestMapping(value = "/find")
	public String FindEmpById(int id) throws Exception {
		System.out.println("查询员工"+id+"信息");
		return "forward:/emp/update.action";
	}
	
	// 请求映射
		@RequestMapping(value = "/update")
		public String UpdateEmpById(int id ,Model model) throws Exception {
			System.out.println("更新员工"+id+"信息");
			model.addAttribute("message","更新员工信息成功");
			return "/jsp/ok.jsp";
		}

}
