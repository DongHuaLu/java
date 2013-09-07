<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录页面</title>
    
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
   <form action="/StudentMS2/servlet/Loginser" method="post">  
   用户名:<input type="text" name="uName" value="${requestScope.cookieuName}"><br/>
   密码:<input type="password" name="uPassword" value="${requestScope.cookieuPassword}"><br>
   
   <input type="hidden" name="status" value="login"><br>
   记住我:<select name="cookieAge">
   	<option value="0">不保存</option>
   	<c:choose>
   		<c:when test="${requestScope.cookieuName!=null}">
   		<option value="7" selected="selected">再保存7天</option>   		
   		</c:when>
   		<c:otherwise>
   		<option value="7">保存7天</option>
   		</c:otherwise> 
   	</c:choose>
   	
   </select>
   <br>
   <input type="submit" value="登录">
   <br><br><br>
  ${requestScope.error}
   
   
   
   </form>
  </body>
</html>
