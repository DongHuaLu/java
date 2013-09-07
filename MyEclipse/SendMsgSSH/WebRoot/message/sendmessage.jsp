<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
   <font color="green" size="14">发送消息</font><br>
   <form action="/SendMsgSSH/dolph/message!send" method="post">
   消息标题:<input type="text" name="title"/><br>
   消息内容:<textarea rows="7" cols="25" name="content"></textarea><br>
   选择组:<select name="groupId">
   <s:iterator value="#groups">
   		<option value="<s:property value="id"/>"> <s:property value="name"/></option>
   </s:iterator>
   </select><br>
 选择接受用户:<select name="receiverIds" multiple="multiple" size="5"><br>
 <s:iterator value="#users">
 	<option value="<s:property value="id"/>"><s:property value="username"/></option> 
 </s:iterator> 
 </select>
   <input type="submit" value="发送">
   </form>
   <s:debug></s:debug>
  </body>
</html>
