<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'deletebox.jsp' starting page</title>
    
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
    垃圾箱. <br>
        <table border="1px">
    <tr><td>标题</td><td>删除时间</td><td>收件人</td><td>发送人</td></tr>
    <s:iterator value="deleteMessages">
    <tr>
    <td><s:property value="title"/></td>
    <td><s:property value="deleteTime"/></td>
    <td><s:property value="receiverName"/></td> 
    <td><s:property value="senderName"/></td>   
    
    </tr>  
    </s:iterator>
    </table>
  
  </body>
</html>
