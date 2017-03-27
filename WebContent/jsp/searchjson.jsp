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
//本地数据<JSON>  

//本地JSON实现自动补全
var datas = [  
  {stuName:'李四',age:23},  
  {stuName:'周周',age:26},  
  {stuName:'张新款',age:45},  
  {stuName:'李银',age:45},  
  {stuName:'周娟',age:45},  
  {stuName:'张丽',age:45},  
  {stuName:'张三',age:67}  
]; 

//开始  
$().ready(function ()  
{  
     $("#autoComplete").autocomplete(datas,  
    {  
        minChars: 0,  
        max: 5,  
        autoFill: true,  
        mustMatch: true,  
        matchContains: true,  
        formatItem: function (data, i, total) {  
          return "<I>" + data.stuName + "</I>"+data.age;  
        }, formatMatch: function (data, i, total) {  
          return data.stuName;  
        }, formatResult: function (data) {  
        	/*  return data.stuName+data.age;   */ 
          return  data.stuName; 
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