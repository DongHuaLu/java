<%@ page language="java" import="java.util.*,domain.Book" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cart.jsp' starting page</title>
    
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
  <table border="1">
  <tr><td>ID</td><td>书名</td><td>价格</td><td>数量</td></tr>
    <%
  		ArrayList al=(ArrayList)request.getAttribute("cartlist");
  		for(int i=0;i<al.size();i++){
  			Book book=(Book)al.get(i); 		
  		%>
  		<tr>
  		<td><%=book.getBookId()%></td>
  		<td><%=book.getBookName()%></td>
  		<td><%=book.getPrice() %></td>
  		<td><input type="text" value=<%=book.getShoppingNum() %>></td>
  		<td>删除</td>  		
  		</tr>
  		
  		
  		
  		<%
  		
  	
  		}
  	
  
  
  
   %>
   <tr><td>总价=<%=request.getAttribute("totalPrice") %></td></tr>
  
  </table>

    
  </body>
</html>
