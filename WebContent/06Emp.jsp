<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
	<form action="${pageContext.request.contextPath}/person/register.action"
		method="POST">
		<table border="2" align="center">
			<caption>普通用户注册</caption>
			<tr>
				<th>姓名：</th>
				<td><input type="text" name="user.username"  value="${user.username} "></td>
			</tr>
			<tr>
				<th>薪水：</th>
				<td><input type="text" name="user.salary" value="${user.salary}"></td>
			</tr>
			<tr>
				<th>入职时间：</th>
				<td><input type="text" name="user.hiredate"
					value='<fmt:formatDate value="${user.hiredate}" type="date" dateStyle="default" />'/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="注册"/></td>
			</tr>

		</table>
	</form>

	<form action="${pageContext.request.contextPath}/person/register.action"
		method="POST">
		<table border="2" align="center">
			<caption>管理员注册</caption>
			<tr>
				<th>姓名：</th>
				<td><input type="text" name="admin.username" value="${admin.username}"></td>
			</tr>
			<tr>
				<th>薪水：</th>
				<td><input type="text" name="admin.salary" value="${admin.salary}"></td>
			</tr>

			<tr>
				<th>入职时间：</th>
				<td><input type="text" name="admin.hiredate"
					value='<fmt:formatDate value="${admin.hiredate}" type="date" dateStyle="default" />'/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="管理员注册" /></td>
			</tr>
		</table>
	</form>

</body>
</html>