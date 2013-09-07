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
    
    <title>成绩更新</title>
    
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
   成绩更新<br>
   <form name="form1" action="/StudentMS2/servlet/Marksser" method="post">
   考试号:<input type="text" name="examNo" value="${param.examNo}" readOnly }><br>
   学生号:<select name="stuNo">
   			<c:forEach items="${applicationScope.students}"  var="students">
   				<c:choose>
   					<c:when test="${students.stuNo==param.stuNo}">
						<option value="${param.stuNo}" selected="selected">${param.stuNo}</option>
  					</c:when>
   					<c:otherwise>
   						<option value="${students.stuNo}">${students.stuNo}</option>
   					</c:otherwise>
   				</c:choose>
   			</c:forEach>   		
   		</select><br>
   笔试成绩:<input type="text" name="writtenExam" value="${param.writtenExam}"><br>
   机试成绩:<input type="text" name="labExam" value="${param.labExam}"><br>
   <input type="submit" value="提交">
   <input type="hidden" name="status" value="updateMarks">
   </form>
   <a href="/StudentMS2/logined/index.jsp">回到首页</a>
  </body>
</html>
