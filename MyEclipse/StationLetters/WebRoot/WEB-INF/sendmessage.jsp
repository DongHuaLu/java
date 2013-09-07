<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'sendmessage.jsp' starting page</title>
    
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
  <form  action="/StationLetters/sendMessage.do?flag=sendmessage" enctype="multipart/form-data" method="post">
    发行人:<input type="text" name="sendfrom" value="${user.username}" readonly="readonly"/>
   收信人:<input type="text" name="sendto"/><br/>
 标题:<input type="text" name="messagehead"/><br/> 
 内容:<input type="text" name="messagetext" /><br/>
 附件:<input type="file"/ name="myfile"><br/>
 <input type="submit" value="发送"/>  
  
  </form>
 
 </body>
</html>
