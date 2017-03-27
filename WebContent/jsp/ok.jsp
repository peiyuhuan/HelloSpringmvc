<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
	/ok.jsp
	<br /> 成功
	<br />

	<%-- ${username}<br/> 
${salary}<br/>  --%>
	${message}
	<br> names:${requestScope.names }

	<br> request user :${requestScope.user }

	<br> session user :${sessionScope.user }
	
	<br>
	<fmt:message key="i18n.username"></fmt:message>
	<br><br>
	<fmt:message key="i18n.password"></fmt:message>
	<br>


</body>
</html>