<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 
	Springmvc 处理静态 的资源
	1：为什么不好处理静态资源？
	REST风格的资源URL，不希望带  .html 或.do等后缀
	
	若将DispatcherServlet将请求映射配置 为/
	则springmvc 将捕获web容器的所有请求，包括静态的资源，springmvc将他们作为普通的请求处理，因此找不到资源
	
	2：解决：
	在springmvc的配置<mvc：default-servlet-handler>处理静态的资源问题，
 -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
	$(function(){
	//alert("hello jquery");
		$(".delete").click(function(){
			var href=$(this).attr("href");
			$("form").attr("action",href).submit();
			return false;
		});
});

</script>
</head>
<body>
	<form action="" method="POST">
		<input type="hidden" name="_method" value="DELETE"/>   <!-- 通过隐藏域将post请求转为delete请求 -->
	</form>

	<c:if test="${empty requestScope.employees }">
		没有任何员工信息.
	</c:if>
	<c:if test="${!empty requestScope.employees }">
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<th>ID</th>
				<th>LastName</th>
				<th>Email</th>
				<th>Gender</th>
				<th>Department</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>

			<c:forEach items="${requestScope.employees }" var="emp">
				<tr>
					<td>${emp.id }</td>
					<td>${emp.lastName }</td>
					<td>${emp.email }</td>
					<td>${emp.gender == 0 ? 'Female' : 'Male' }</td>
					<td>${emp.department.departmentName }</td>
					<td><a href="<%=request.getContextPath()%>/emps/editEmp/${emp.id}">Edit</a></td>
					<td><a class="delete" href="<%=request.getContextPath()%>/emps/delete/${emp.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br><br>
	<a href="<%=request.getContextPath()%>/emps/addEmp.action">Add New Employee</a>
</body>
</html>