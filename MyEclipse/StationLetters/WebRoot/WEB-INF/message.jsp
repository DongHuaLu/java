<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'message.jsp' starting page</title>
    
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
  ${info}<br/>
  <table border="1px">
  <tr><td>发件人</td><td>发送时间</td><td>标题</td><td>内容</td><td>附件</td></tr>
  <c:forEach items="${messages}" var="message">
  	<tr>
  	<td>${message.sendfromusername}</td>
  	<td>${message.senddate}</td>
  	<td>${message.messagehead}</td>
  	<td>${message.messagetext}</td>
  	<td><a href="/StationLetters/sendMessage.do?flag=downloadFile&fileuuid=${message.fileuuid}"">${message.filename}</a></td>
  	</tr>  
  </c:forEach>
  </table>
  
    <a href="/StationLetters/sendMessage.do?flag=gosendmessage">发短信</a>
  </body>
</html>
