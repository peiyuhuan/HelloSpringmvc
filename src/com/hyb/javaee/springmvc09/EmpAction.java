package com.hyb.javaee.springmvc09;

import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 
 * 下面的的测试都是  09bean2json.jsp这个页面
 * 
 * 单例 控制器(程序员) 在业务控制方法中写入模型变量收集参数，且使用@InitBind来解决字符串转日期类型
 * 
 * @author hyb
 * 
 */
@SessionAttributes(value={"user"})
@RequestMapping(value = "/emp")
@Controller
public class EmpAction {

	/**
	 * @ResponseBody Emp 表示让springmvc 将emp对象转成json文本
	 */
	@RequestMapping(value = "/bean2json")
	public @ResponseBody
	Emp bean2json() throws Exception {
		Emp emp = new Emp();
		emp.setId(1);
		emp.setName("hyb");
		emp.setSalary(7000D);
		emp.setDate(new Date());
		return emp;
	}

	/**
	 * 测试请求头和请求参数，参数是username和age,age不能是10
	 * 
	 * @return
	 */
	@RequestMapping(value = "/testParamsAndHeaders", params = { "username",
			"age!=10" })
	public String testParamsAndHeaders(Model model) {
		System.out.println("testParamsAndHeaders");
		model.addAttribute("message", "测试请求头和请求参数成功");
		return "/jsp/ok.jsp";
	}

	/**
	 * 测试请占位符 http://localhost:8081/helloweb/emp/testPathVariable/22.action
	 * 
	 * @return
	 */
	@RequestMapping(value = "/testPathVariable/{id}")
	public String testPathVariable(Model model, @PathVariable("id") Integer id) {
		System.out.println("testVariable:" + id);
		model.addAttribute("message", "测试占位符成功");
		return "/jsp/ok.jsp";
	}

	/**
	 * @RequestParam获取参数值 ,required=false 不是必须的,defaultValue请求参数的默认值
	 * @param name
	 * @param age
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/testRequestParam")
	public String testRequestParam(
			@RequestParam(value = "username") String name,
			@RequestParam(value = "age", required = false, defaultValue = "0") int age,
			Model model) {
		System.out.println("testRequestParam,username:" + name + ",age:" + age);
		model.addAttribute("message", "testRequestParam获取参数值 :  " + name + ":"
				+ age);

		return "/jsp/ok.jsp";
	}

	/**
	 * 获取cookie的值
	 * 
	 * @param sessionid
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/testCookieValue")
	public String testCookieValue(@CookieValue("JSESSIONID") String sessionid,
			Model model) {
		System.out.println("testCookieValue:" + sessionid);
		model.addAttribute("message", "获取的sessionid::" + sessionid);
		return "/jsp/ok.jsp";
	}

	/**使用pojo作为参数，类似于javabean
	 * 
	 * 获取级联属性，常用，页面里面写address.province，address.city
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/testPojo")
	public String testPojo(User user,Model model) {
		System.out.println("User::" + user);
		model.addAttribute("message","获取的用户："+user);
		return "/jsp/ok.jsp";
	}
	
	@RequestMapping(value="testServlet")
	public void testServlet(HttpServletRequest req,HttpServletResponse resp,Writer out) throws Exception{
		System.out.println("测试原生的servlet::"+req+"===="+resp);
		out.write("测试原生的servlet");
	}
	
	
	
	@RequestMapping(value="/testMap")
	public String testMap(Map<String,Object> map){
		
		System.out.println("Map的类名：："+map.getClass().getName());
		map.put("names", Arrays.asList("hyb","tom","hahah"));
		return "/jsp/ok.jsp";
	}
	
	
	/**
	 * @SessionAttributes 除了可以通过属性名指定需要的会话到属性外，  
	 * 还可以通过模型属性的对象类型指定哪些属性需要放到会话中（实际上使用的Types属性值）
	 * 注意点：改注解只能放在类的上面 ，不能修饰方法
	 * @param map
	 * @return
	 * 
	 * 测试页面是09bean2json.jsp
	 */
	@RequestMapping(value="/testSessionAttributes")   
	public String testSessionAttributes(Map<String,Object> map){
		User user=new User("hyb","12344",15);
		map.put("user",user);
		return "/jsp/ok.jsp";
	}
	
	/**
	 *    @ModelAttribute标注的方法，每个目标方法都会先执行
	 * @param name
	 * @param map
	 */
	@ModelAttribute
	public void getUser(Map<String,Object> map){
		System.out.println("@ModelAttribute Method");
			//模拟从数据库中取出数据
			User user=new User("hyb","123456",24);
			System.out.println("模拟从数据库中取出一个对象："+user);
			map.put("user", user);
		
	}
	
	/**
	 *  先是上面的getUser方法数据库取出数据到map里面，然后springmvc在把表单数据给map
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/testModelAttribute")
	public String testModelAttribute(@ModelAttribute("user") User user){
		System.out.println("修改："+user);
		return "/jsp/ok.jsp";
	}

	@RequestMapping(value="/testview")
	public String testView(){
		System.out.println("testview");
		return "/helloView";
	}
	

}
