package com.hyb.javaee.springmvc10;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hyb.javaee.springmvc10.curd.dao.DepartmentDao;
import com.hyb.javaee.springmvc10.curd.dao.EmployeeDao;
import com.hyb.javaee.springmvc10.curd.entity.Employee;

@RequestMapping(value="/emps")
@Controller
public class EmployeeHandler {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	
	//页面展示
	@RequestMapping(value="/empslist")
	public String list(Map<String,Object> map){
		map.put("employees", employeeDao.getAll());
		return "/10jsp/10list.jsp";  //返回/views/list.jsp頁面
	}
	
	
	//增加員工頁面
	@RequestMapping(value="/addEmp",method=RequestMethod.GET)
	public String addEmp(Map<String,Object> map){
		map.put("departments", departmentDao.getDepartments());
		map.put("employee", new Employee());
		return "/10jsp/10add.jsp";
	}
	
	//增加之后回显list页面
		@RequestMapping(value="/addEmp",method=RequestMethod.POST)
		public String save(Employee employee){
			employeeDao.save(employee);
			//return "/10jsp/10list.jsp";
			return "redirect:/emps/empslist.action";
		}
	
	
	
}
