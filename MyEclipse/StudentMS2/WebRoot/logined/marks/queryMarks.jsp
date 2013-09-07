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
    
    <title>��ѯ�ɼ�</title>
    
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
  <form action="/StudentMS2/servlet/Marksser" method="post">
  �ؼ���:<input type="text" name="keyword">�Ծ�Ż�ѧ��
  <input type="submit" value="�ύ">
  <input type="hidden" name="status" value="queryMarks">  
  </form>
  
  <table border="1">
  <tr>
  	<td>�Ծ��</td>
  	<td>������</td>
  	<td>���Գɼ�</td>
  	<td>���Գɼ�</td>
  	<td>ѧ������</td>
  	<td>ѧ����λ</td>
  	<td>�Ա�</td>
  	<td>סַ</td>
  	<td>����</td>
  	<td>ɾ��</td>	
  </tr>
  
  <c:forEach items="${requestScope.marks}" var="marks">
  <tr>
  	<td>${marks.examNo}</td>
  	<td>${marks.stuNo}</td>
  	<td>${marks.writtenExam}</td>
  	<td>${marks.labExam}</td>
  	<td>${marks.student.stuName}</td>
  	<td>${marks.student.stuSeat}</td>
  	<td>${marks.student.stuSex}</td>
  	<td>${marks.student.stuAddress}</td> 
  	<td>
  		<c:url value="/logined/marks/updateMarks.jsp" var="updateMarks">
  			<c:param name="examNo" value="${marks.examNo}"></c:param>
  			<c:param name="stuNo" value="${marks.stuNo}"></c:param>
  			<c:param name="writtenExam" value="${marks.writtenExam}"></c:param>
  			<c:param name="labExam" value="${marks.labExam}"></c:param> 	
  		</c:url>
  		<a href="${updateMarks}">����</a>
  	</td>
  	
  	<td>
  		<c:url value="/servlet/Marksser" var="deleteMarks">
  			<c:param name="status" value="deleteMarks"></c:param>
  			<c:param name="examNo" value="${marks.examNo}"></c:param>  		
  		</c:url>
  		<a href="${deleteMarks}">ɾ��</a> 
	</td>
  </tr>  
  </c:forEach>
  </table>
  <a href="/StudentMS2/servlet/Marksser?status=splitPage&markscurrentPage=1">��ҳ</a>
  <c:choose>
  	<c:when test="${sessionScope.markscurrentPage==1}">
  		��һҳ
  	</c:when>
  	<c:otherwise>
  		<a href="/StudentMS2/servlet/Marksser?status=splitPage&markscurrentPage=${sessionScope.markscurrentPage-1}">��һҳ</a>
  	</c:otherwise>
  </c:choose>
  
  <c:choose>
  	<c:when test="${sessionScope.markscurrentPage==sessionScope.markstotalPage}">
  		��һҳ
  	</c:when>
  	<c:otherwise>
  	 	<a href="/StudentMS2/servlet/Marksser?status=splitPage&markscurrentPage=${sessionScope.markscurrentPage+1}">��һҳ</a>
  	</c:otherwise>  
  </c:choose>
   <a href="/StudentMS2/servlet/Marksser?status=splitPage&markscurrentPage=${sessionScope.markstotalPage}">βҳ</a>
   
   
   <form action="/StudentMS2/servlet/Marksser" method="post">
   <select name="markscurrentPage">   
   		<c:forEach begin="1" end="${sessionScope.markstotalPage}" var="i" step="1">
   			<c:choose>
   				<c:when test="${sessionScope.markscurrentPage==i}">
   					<option  value="${i}" selected="selected" >${i}</option>
   				</c:when>
   				<c:otherwise>
   					<option  value="${i}">${i}</option>
   				</c:otherwise>
   			</c:choose>   			 		
   		</c:forEach>
   </select>
   <input type="submit" value="go">
   <input type="hidden" name="status" value="splitPage">
   </form>
  	
 	
   
   
    
    <br>
     <a href="/StudentMS2/logined/index.jsp">�ص���ҳ</a>
  </body>
</html>
