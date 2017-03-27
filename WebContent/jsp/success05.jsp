<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
	/success05.jsp
	<br /> 成功
	<br /> ${user.id}
	<br /> ${user.username}
	<br /> ${user.salary}
	<br />

	<fmt:formatDate value="${user.hiredate}" type="both" dateStyle="full"
		timeStyle="default" />

<br/>

</body>
</html>