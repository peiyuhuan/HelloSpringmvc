package com.hyb.javaee.springmvc04;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 单例 控制器(程序员)
 * 
 * @author hyb
 * 
 */

// 说明是控制器
@Controller
@RequestMapping(value = "/user")
public class UserAction {
	/**
	 * 业务方法,可带参数，可不带参数 只要是/hello.action的请求，都交由HelloAction对象的hello（）来处理
	 */

	@RequestMapping(method = RequestMethod.POST, value = "/register")
	// 请求映射
	public String registerMethod(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//
		String username = request.getParameter("username");
		String salary = request.getParameter("salary");
		System.out.println("用户注册:" + username + ":" + salary);

		// 绑定到session域对象中
		request.getSession().setAttribute("username", username);
		request.getSession().setAttribute("salary", salary);

		// 重定向到 /jsp/success.jsp
		// response.sendRedirect(request.getContextPath()+"/jsp/success.jsp");

		// 转发
		request.getRequestDispatcher("/jsp/ok.jsp").forward(request, response);

		// 转发(提倡)
		return "/jsp/success.jsp";

	}

	@RequestMapping(value = "/login")
	// 请求映射
	public String loginMethod(Model model) throws Exception {
		model.addAttribute("message", "登录成功 ");
		return "/jsp/success.jsp";
	}

}
