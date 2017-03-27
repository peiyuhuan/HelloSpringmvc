package com.hyb.javaee.springmvc05;

import java.util.Date;

public class User {
	private int id;
	private String username;
	private Double salary;
	private Date hiredate;
	User(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	@Override
	public String toString() {
		return this.id+":"+this.username+":"+this.salary+":"+this.hiredate.toLocaleString();
	}

}
