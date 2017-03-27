package com.hyb.javaee.springmvc10.curd.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hyb.javaee.springmvc10.curd.entity.Department;

@Repository
public class DepartmentDao {
	private static Map<Integer,Department>  department=null;

	/**
	 * 靜態加載的數據
	 */
	static {
		department=new HashMap<Integer,Department>();
		department.put(101,new Department(101,"D-aa"));
		department.put(102,new Department(102,"D-bb"));
		department.put(103,new Department(103,"D-cc"));
		department.put(104,new Department(104,"D-dd"));
		department.put(105,new Department(105,"D-ee"));
	}
	
	public Collection<Department> getDepartments(){
		return department.values();
	}
	
	public Department getDepartment(Integer id){
		return department.get(id);
	}
	
	
	
}
