<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>����</title>
    
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
    ����
 <form action="/StudentMS2/servlet/Studentser" method="post">
 ��λ��:<input type="text" name="stuSeat" readonly  value="${param.stuSeat}"><br>
 ����:<input type="text" name="stuName" value="${param.stuName}" ><br>
 ѧ��:<input type="text" name="stuNo" value="${param.stuNo}" ><br>
  ����:<input type="text" name="stuAge" value="${param.stuAge}" ><br>
  �Ա�:<input type="text" name="stuSex" value="${param.stuSex}" ><br>
 ��ַ:<input type="text" name="stuAddress" value="${param.stuAddress}"><br>
<input type="submit" value="�ύ" >
<input type="hidden" name="status" value="updateStudent">
 </form>
   <a href="/StudentMS2/logined/index.jsp">�ص���ҳ</a>
  </body>
 
</html>
