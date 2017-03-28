package com.hyb.javaee.springmvc10;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hyb.javaee.springmvc10.curd.dao.DepartmentDao;
import com.hyb.javaee.springmvc10.curd.dao.EmployeeDao;
import com.hyb.javaee.springmvc10.curd.entity.Employee;

@RequestMapping(value = "/emps")
@Controller
public class EmployeeHandler {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private DepartmentDao departmentDao;

	// 页面展示
	@RequestMapping(value = "/empslist")
	public String list(Map<String, Object> map) {
		map.put("employees", employeeDao.getAll());
		return "/10jsp/10list.jsp"; // 返回/views/list.jsp頁面
	}

	// 增加員工頁面
	@RequestMapping(value = "/addEmp", method = RequestMethod.GET)
	public String addEmp(Map<String, Object> map) {
		map.put("departments", departmentDao.getDepartments());
		map.put("employee", new Employee());
		return "/10jsp/10add.jsp";
	}
	
	
	

	// 增加之后回显list页面
	@RequestMapping(value = "/addEmp", method = RequestMethod.POST)
	public String save(Employee employee) {
		employeeDao.save(employee);
		return "redirect:/emps/empslist.action";
	}

	/**
	 * 删除操作  ，占位符{id},请求方式：DELETE
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id) {
			employeeDao.delete(id);
			return "redirect:/emps/empslist.action";
	}
	
	
	
	/**
	 * 修改操作(添加和修改用的一个页面)
	 * 1：显示修改页面，  请求GET   uri:emps/edit/${emp.id}   类似于到添加页面
	 * 	lastName设置为不可修改
	 * 2：修改员工信息，然后提交  请求方式PUT，  uri:emps/update
	 * 3：修改完成，重定向到list页面
	 */
	//回显的
	@RequestMapping(value = "/editEmp/{id}", method = RequestMethod.GET)
	public String editEmp(@PathVariable("id") Integer id,Map<String, Object> map) {
		map.put("departments", departmentDao.getDepartments());
		map.put("employee", employeeDao.get(id));   //在添加页面的的form表单里面的ModelAttribute对应 的employee
		return "/10jsp/10add.jsp";
	}
	
	//获取的数据(没有的修改的数据LastName)
	@ModelAttribute
	public void getEmployee(@RequestParam(value="id",required=false) Integer id,Map<String,Object> map){
		if(id!=null){
			map.put("employee", employeeDao.get(id));
		}
	}
	
	//修改后回显到10list.jsp
	@RequestMapping(value="/addEmp",method=RequestMethod.PUT)
	public String update(Employee employee){
		employeeDao.save(employee);
		return "redirect:/emps/empslist.action";
	}

}
