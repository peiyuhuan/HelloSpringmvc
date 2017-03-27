<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
	<form action="${pageContext.request.contextPath}/user/register.action" method="POST">
		<table border="2" align="center">
			<caption>用户注册</caption>
			<tr>
				<th>姓名：</th>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<th>薪水：</th>
				<td><input type="text" name="salary" value="7000"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="注册"
					style=""></td>
			</tr>

		</table>
	</form>
	</hr>

	
	<form action="${pageContext.request.contextPath}/user/login.action" method="POST">
		<table border="2" align="center">
			<caption>用户登录</caption>
			<tr>
				<th>姓名：</th>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="登录"
					style=""></td>
			</tr>

		</table>
	</form>

</body>
</html>