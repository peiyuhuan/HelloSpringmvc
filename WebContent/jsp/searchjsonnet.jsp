<%@ page language="java" import="java.util.*"  charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>自动补全功能</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.autocomplete.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/jquery.autocomplete.css" />
<script type="text/javascript">
//<JSON>  
//服务器端JSON实现自动补全
var names ; //定义数据  
      //开始函数  
      $(document).ready(function(){  
        $.ajax({  
          type:'POST',  
          contentType: "application/json",  
          url: "getAutoComplteList.action?1=1",  
          dataType: "json",  
          success:function(data){  
            names = data;  
            alert(data);  
            autocompleteFn(data);  
          }  
        });  
      });  
       //自动 补全方法  
       function autocompleteFn(names){  
         $("#autocomplete").autocomplete(names,{  
           minChars:1,  
           max: 10,  
           dataType:"json",  
           autoFill: true,  
           mustMatch: true,  
           matchContains: true,  
           scrollHeight: 220,  
           formatItem: function(data, i, total) {  
             return "<I>"+data.NICKNAME+"</I>";  
           },  
           formatMatch: function(data, i, total) {  
             return data.NICKNAME;  
           },  
           formatResult: function(data) {  
             return data.NICKNAME;  
           }  
         });  
       }  
         
       //搜索数据  
       function onSearch()  
       {  
          var nickName =$("#autocomplete").val();   
           alert(nickName);  
           $.ajax({  
                  type:'POST',  
                  contentType: "application/json",  
                  url: "getAutoComplteListByName.action?nickName="+encodeURI(encodeURI(nickName)),  
                  dataType: "json",  
                  success:function(data){  
                    names = data;  
                    alert(data);  
                  }  
                });  
       }  
</script>
</head>

<body>
	<input type="text" id="autoComplete" placeHolder="请输入要搜索的内容!" />
	<input type="button" name="btnSearch" onclick="onSearch();" value="搜索" />
</body>
</html>