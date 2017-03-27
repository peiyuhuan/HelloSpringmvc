package com.hyb.javaee.springmvc10.curd.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hyb.javaee.springmvc10.curd.entity.Department;
import com.hyb.javaee.springmvc10.curd.entity.Employee;

@Repository
public class EmployeeDao {
	private static Map<Integer,Employee>  employees=null;

	@Autowired
	private DepartmentDao departmentDao;
	/**
	 * 靜態加載的數據
	 */
	static {
		employees=new HashMap<Integer,Employee>();
		employees.put(1001,new Employee(1001,"E-aa","11@qq.com",1,new Department(101,"D-aa")));
		employees.put(1002,new Employee(1002,"E-bb","22@qq.com",0,new Department(102,"D-bb")));
		employees.put(1003,new Employee(1003,"E-cc","33@qq.com",1,new Department(103,"D-cc")));
		employees.put(1004,new Employee(1004,"E-dd","44@qq.com",1,new Department(104,"D-dd")));
		employees.put(1005,new Employee(1005,"E-ee","55@qq.com",0,new Department(102,"D-bb")));
		employees.put(1006,new Employee(1006,"E-ff","66@qq.com",0,new Department(101,"D-aa")));
	}
	
	private static Integer initId=1001;
	
	public void save(Employee employee){
		if(employee.getId() == null){
			employee.setId(initId++);
		}
		employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
		employees.put(employee.getId(),employee);
	}
	
	public Collection<Employee> getAll(){
		return employees.values();
	}
	
	public Employee get(Integer id){
		return employees.get(id);
	}
	
	public void delete(Integer id){
		 employees.remove(id);
	}
	

	
}
