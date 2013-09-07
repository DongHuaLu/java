<%@ page language="java" import="java.util.*,domain.Rat" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'c_foreach.jsp' starting page</title>
    
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
   <%
   		Map map=new HashMap();
   		Rat rat1=new Rat();
   		rat1.setAge(10);
   		rat1.setName("1");
   		Rat rat2=new Rat();
   		rat2.setAge(20);
   		rat2.setName("2");
   		map.put("rat1",rat1);
   		map.put("rat2",rat2);
   		request.setAttribute("rats",map);   		
    %>
    
    
    <c:forEach items="${rats}" var="rat">
    ${rat.key} +++${rat.value.name }
    
    </c:forEach>
  </body>
</html>
