<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/jquery-1.8.2.js">
	
</script>
</head>

<body>


	<a href="emp/testPathVariable/22.action">测试占位符</a>
	<p>
		<a href="emp/testParamsAndHeaders.action?username=ak">测试请求头和参数</a>
	<p>
		<a href="emp/testRequestParam.action?username=hyb&age=13">测试RequestParam</a>
	<p>
		<a href="emp/testCookieValue.action">获取cookieValue</a>
	<p>
	<form action="emp/testPojo.action" method="post">
		姓名：<input type="text" name="name"/><br> 
		密码：<input type="password" name="password" style="width: 154px; "/><br> 
		年龄：<input type="text" name="age"/><br> 
 		省会：<input type="text" name="address.province"/><br>
		城市：<input type="text" name="address.city"/><br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="注册"/><br>
	</form>
	<br>
	<br>
	<a href="emp/testServlet.action">测试Spingmvc的原生Servlet的API方法</a>
	<p>
	<a href="emp/testMap.action">处理模型数据之Map</a>
	<p>
	
	<a href="emp/testSessionAttributes.action">处理模型数据之SessionAttributes</a>
	<p>
	
	<!-- testview -->
	<a href="emp/testView.action">测试Spingmvc自定义试图</a><br>
	
	
	<!-- 模拟数据的修改
	1：原始数据，tom,123456,12
	2:密码不能改，
	3：表单回显，模拟操作直接在表单填写对应的属性值
	 -->
	<br>
	学习ModelAttribute
	<form action="emp/testModelAttribute.action" method="post">
	姓名：<input type="text" name="name" /><br>
	年纪：<input type="text" name="age" /><br>
	<input type="submit" value="submit" />
	</form>
	<p>
	
	


	<input type="button" value="Emp转json" />
	<p>
		<input type="button" value="List<Emp>转json" />
	<p>
		<input type="button" value="Map<String, Object>转json"/>
	<p>

		<script type="text/javascript">
			$(":button:first")
					.click(
							function() {
								var url = "${pageContext.request.contextPath}/emp/bean2json.action";
								var sendData = null;
								$.post(url, sendData, function(backData,
										textStaut, ajax) {
									alert(ajax.responseText);
								});
							});
		</script>
</body>
</html>