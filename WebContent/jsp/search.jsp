<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>自动补全功能</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.autocomplete.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/jquery.autocomplete.css" />
<script type="text/javascript">
	//本地数据<数组>  
	var data = [ "java", "javaee", "jquery", "c++", "css", "html", "htm5","bb", "ejb", "c#" ];

	//开始  
	$().ready(function() {
		$("#autoComplete").autocomplete(data, {
			minChars : 1,
			max : 5,
			autoFill : true,
			mustMatch : true,
			matchContains : true,
			formatItem : function(data, i, total) {
				return "<I>" + data[0] + "</I>";
			},
			formatMatch : function(data, i, total) {
				return data[0];
			},
			formatResult : function(data) {
				return data[0];
			}

		});
	});

	//搜索数据  
	function onSearch() {
		var nickName = $("#autoComplete").val();
		alert(nickName);
	}
</script>
</head>

<body>
	<input type="text" id="autoComplete" placeHolder="请输入要搜索的内容!" />
	<input type="button" name="btnSearch" onclick="onSearch();" value="搜索" />
</body>
</html>