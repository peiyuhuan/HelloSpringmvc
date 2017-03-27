<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <script type="text/javascript" src="<%=request.getContextPath()%>js/jquery-1.4.2.min.js"></script>  
 <script type="text/javascript" src="<%=request.getContextPath()%>js/jquery.autocomplete.js"></script>
 <link href="<%=request.getContextPath()%>css/css.css" rel="stylesheet" type="text/css" />  
</head>
<body>
 <!-- 一个查询按钮触发ajax -->
	<input type="button" value="查询" onclick="query()" />
	<br />
	<table>
		<thead>
			<tr>
				<td>菜名</td>
				<td>价格</td>
			</tr>
		</thead>

		<!-- 用一个id就可以用Jquery操作表体 -->
		<tbody id="t_body"></tbody>
	</table>
</body>

<script type="text/javascript">
	/* 点击按钮触发 */
	function query() {
		//执行ajax
		ajaxFun();
	}

	/* ajax代码部分，从jquery帮助文档可直接拷贝 */
	function ajaxFun() {
		//ajax执行体
		$.ajax({
			//提交方式
			type : "POST",
			//访问servleturl
			url : "query.do",
			//服务器成功返回结果后，会把结果保存到data中
			success : function(data) {
				//先把表体部分清空
				$("#t_body").empty();
				//eval获取返回的JSON对象集合
				var d = eval('(' + data + ')');
				//把数据显示到页面的方法
				showData(d);
			}
		});
	}
	/* 显示数据 */
	function showData(d) {
		//循环遍历一边d
		for ( var i = 0; i < d.length; i++) {
			var html = "<tr><td>" + d[i].name + "</td><td>" + d[i].price
					+ "</td></tr>";
			//通过表体id把显示文本显示到网页中
			$("#t_body").append(html);
		}
	}
</script>
</html>