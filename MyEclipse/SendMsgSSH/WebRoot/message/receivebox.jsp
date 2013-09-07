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
    
    <title>My JSP 'receivebox.jsp' starting page</title>
    
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
    收件箱
    <table border="1px">
    <tr><td>标题</td><td>接收时间</td><td>发送人</td><td>已读</td><td>删除</td></tr>
    <s:iterator value="receiveMessages">
    <tr>
    <td><a href="/SendMsgSSH/dolph/message!detail?detailId=<s:property value='id'/>"><s:property value="title"/></a></td>
    <td><s:property value="receiveTime"/></td>
    <td><s:property value="senderName"/></td> 
    <td><s:property value="isread"/></td> 
    <td><a href="/SendMsgSSH/dolph/message!deleteReceiveMessage?deleteId=<s:property value='id'/>">删除</a></td> 
    </tr>  
    </s:iterator>
    </table>
     <br>
  </body>
</html>
