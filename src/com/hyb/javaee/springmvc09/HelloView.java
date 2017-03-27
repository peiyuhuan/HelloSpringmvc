package com.hyb.javaee.springmvc09;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;


/**
 * 视图的一个类
 * @author hyb
 *
 */
@Component  //注解  
public class HelloView  implements View{

	@Override
	public String getContentType() {
		return "text/html";
	}

	@Override
	public void render(Map<String, ?> arg0, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.getWriter().print("hello world,time:"+new Date());
	}

}
