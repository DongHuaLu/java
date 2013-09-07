<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>更新</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>

  
  <body>
    更新
 <form action="/StudentMS2/servlet/Studentser" method="post">
 座位号:<input type="text" name="stuSeat" readonly  value="${param.stuSeat}"><br>
 姓名:<input type="text" name="stuName" value="${param.stuName}" ><br>
 学号:<input type="text" name="stuNo" value="${param.stuNo}" ><br>
  年龄:<input type="text" name="stuAge" value="${param.stuAge}" ><br>
  性别:<input type="text" name="stuSex" value="${param.stuSex}" ><br>
 地址:<input type="text" name="stuAddress" value="${param.stuAddress}"><br>
<input type="submit" value="提交" >
<input type="hidden" name="status" value="updateStudent">
 </form>
   <a href="/StudentMS2/logined/index.jsp">回到首页</a>
  </body>
 
</html>
