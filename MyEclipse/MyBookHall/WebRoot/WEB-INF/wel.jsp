<%@ page language="java" import="java.util.*,domain.Book" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Welcome</title>
    
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
   <h1>Welcome</h1> <%=request.getAttribute("uid") %> <br>
   <table border="1">
   	<tr><td>ID</td><td>书名</td><td>价格</td><td>出版社</td><td>作者</td><td>数量</td><td>购买</td></tr>
   <%
   		ArrayList al=(ArrayList)request.getAttribute("books");
   		for (int i=0;i<al.size();i++){
   			Book book=(Book)al.get(i);
   		%>
			<tr>
				<td><%=book.getBookId()%></td>
				<td><%=book.getBookName() %></td>
				<td><%=book.getPrice() %></td>
				<td><%=book.getPublishhouse() %></td>
				<td><%=book.getAutor() %></td>
				<td><%=book.getNumber() %></td>
				<td><a href="/MyBookHall/CartServlet?id=<%=book.getBookId()%>&status=add">购买</a></td>
			</tr>   		
   		<%   		   		
   		}     
    %>
   </table>
   <%=request.getAttribute("result") %>
   <form action="/MyBookHall/CartServlet" method="post">
   	<input type="submit" value="查看购物车"/>
   	<input type="hidden" name="status" value="showcart">   
   </form>
  </body>
</html>
