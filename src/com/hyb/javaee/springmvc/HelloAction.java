package com.hyb.javaee.springmvc;

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
public class HelloAction{
	/**
	 * 业务方法,可带参数，可不带参数
	 * 只要是/hello.action的请求，都交由HelloAction对象的hello（）来处理
	 */
	
	@RequestMapping(value="/hello.action")  //请求映射  
	public String hello(Model model) throws Exception{
		System.out.println("HelloAction:hello()");
		model.addAttribute("message","你好，这是我的一个springmvc的程序 ");
//		return "/success.jsp";  //物理url
		return "/success";
	}
	

	@RequestMapping(value="/bye.action")  //请求映射  
	public String bye(Model model) throws Exception{
		System.out.println("HelloAction:bye()");
		model.addAttribute("message","再见，这是我的一个springmvc的程序 ");
//		return "/success.jsp";
		return "/success";
	}

}
