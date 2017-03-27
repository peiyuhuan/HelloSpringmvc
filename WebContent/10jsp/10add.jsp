<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--
	1:使用form标签可以快速的 开发出表单页面，可以方便的回显表单数据
	2： 注意:
	 可以通过modelAttribute属性指定绑定 的模型属性，
	 如果没有改属性 ，则默认从request 域对象中读取command的表单bean
	 如果属性值也不存在，则报错
		
	  -->
	<form:form action="${pageContext.request.contextPath}/emps/addEmp.action"
		 method="POST" modelAttribute="employee">
		<!-- path属性对应的html表单标签的name属性值 
		 	form：radiobuttons 单选框标签，用于构造多个单选框
		 	items： 可以是list,数组，或者map
		-->
		
	  LastName:<form:input path="lastName" />
		<br>
	  Email:<form:input path="email" />
		<br>
		<%
			Map<String, String> genders = new HashMap<String, String>();
			genders.put("1", "Male");
			genders.put("0", "Female");
			request.setAttribute("genders", genders);
		%>
		Genders:<form:radiobuttons path="gender" items="${genders}"/>
		<br>
		Department:<form:select path="department.id" items="${departments}"
			itemLabel="departmentName" itemValue="id"></form:select>

		<br>
		<input type="submit" value="Submit">

	</form:form>
</body>
</html>