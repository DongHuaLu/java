<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>����ɼ�</title>
    
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
   ����ɼ�
   
   <form action="/StudentMS2/servlet/Marksser" method="post">
   �Ծ��:<input type="text" name="examNo">like 'E200507[0-9][0-9][0-9][0-9]<br/> 
   ѧ����:<select name="stuNo">
   <c:forEach items="${applicationScope.students}"  var="students">
   <option value="${students.stuNo}">${students.stuNo}</option>
   </c:forEach>
   </select>
  <br/>
   ���Գɼ�:<input type="text" name="writtenExam"><br/>
   ���Գɼ�:<input type="text" name="labExam" ><br/> 
   <input type="submit" value="�ύ">
   <input type="hidden" name="status" value="saveMarks">   
   </form>
     <a href="/StudentMS2/logined/index.jsp">�ص���ҳ</a>
  </body>
</html>
