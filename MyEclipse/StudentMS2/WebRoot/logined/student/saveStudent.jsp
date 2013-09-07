<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>插入新学生</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>插入新学生
  <form action="/StudentMS2/servlet/Studentser" method="post">
	学生姓名:<input type="text" name="stuName"/><br>
 	学生学号:<input type="text" name="stuNo"/>:stu<><><><><> <>=0-9<br>
 	学生年龄:<input type="text" name="stuAge" />:15-35<br>
	学生性别:<input type="radio" name="stuSex" VALUE="男" />男
			<input type="radio" name="stuSex" VALUE="女" />女<br>
	学生住址:<input type="test" name="stuAddress"/><br>
	<input type="submit" Value="提交"/>  
	<input type="hidden" name="status" value="saveStudent"/>
	</form>
	<a href="/StudentMS2/logined/index.jsp">回到首页</a>
  </body>
</html>
