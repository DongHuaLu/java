<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>������ѧ��</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>������ѧ��
  <form action="/StudentMS2/servlet/Studentser" method="post">
	ѧ������:<input type="text" name="stuName"/><br>
 	ѧ��ѧ��:<input type="text" name="stuNo"/>:stu<><><><><> <>=0-9<br>
 	ѧ������:<input type="text" name="stuAge" />:15-35<br>
	ѧ���Ա�:<input type="radio" name="stuSex" VALUE="��" />��
			<input type="radio" name="stuSex" VALUE="Ů" />Ů<br>
	ѧ��סַ:<input type="test" name="stuAddress"/><br>
	<input type="submit" Value="�ύ"/>  
	<input type="hidden" name="status" value="saveStudent"/>
	</form>
	<a href="/StudentMS2/logined/index.jsp">�ص���ҳ</a>
  </body>
</html>
