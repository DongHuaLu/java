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
    
    <title>��¼ҳ��</title>
    
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
   �û���:<input type="text" name="uName" value="${requestScope.cookieuName}"><br/>
   ����:<input type="password" name="uPassword" value="${requestScope.cookieuPassword}"><br>
   
   <input type="hidden" name="status" value="login"><br>
   ��ס��:<select name="cookieAge">
   	<option value="0">������</option>
   	<c:choose>
   		<c:when test="${requestScope.cookieuName!=null}">
   		<option value="7" selected="selected">�ٱ���7��</option>   		
   		</c:when>
   		<c:otherwise>
   		<option value="7">����7��</option>
   		</c:otherwise> 
   	</c:choose>
   	
   </select>
   <br>
   <input type="submit" value="��¼">
   <br><br><br>
  ${requestScope.error}
   
   
   
   </form>
  </body>
</html>
