<%@ page language="java" import="java.util.*,pojo.Student" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>��ѯ</title>
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
  <form action="/StudentMS2/servlet/Studentser" method="post">  
  ��ѯ<br>
   �ؼ���:<input type="text" name="keyword" value="${sessionScope.keyword }"/>
 <input type="submit" value="�ύ" /> 
 <input type="hidden" name="status" value="queryStudent" /> 
  </form>

     ================================================================
     <table border="1">
     <tr>
			<td>����</td>
			<td>�Ա�</td>
			<td>ѧ��</td>
			<td>����</td>
			<td>��λ</td>
			<td>��ַ</td>
			<td>����</td>
			<td>ɾ��</td>
			<td>�ɼ�</td>
     </tr>
     <c:forEach items="${requestScope.students}" var="students">
     <tr>
     	<td>${students.stuName}</td>
     	<td>${students.stuSex}</td> 
     	<td>${students.stuNo}</td> 
     	<td>${students.stuAge}</td> 
     	<td>${students.stuSeat}</td> 
     	<td>${students.stuAddress}</td>
     	<td><c:url value="/logined/student/updateStudent.jsp" var="update">
				<c:param name="stuSeat" value="${students.stuSeat}"></c:param>
     			<c:param name="stuSex" value="${students.stuSex}"></c:param>
     			<c:param name="stuNo" value="${students.stuNo}"></c:param>
     			<c:param name="stuAge" value="${students.stuAge}"></c:param>
     			<c:param name="stuName" value="${students.stuName}"></c:param>
     			<c:param name="stuAddress" value="${students.stuAddress}"></c:param>
     		</c:url>
     		<a href="${update}">����</a>
     	</td>
     	<td><c:url value="servlet/Studentser" var="delete">
     			<c:param name="stuSeat" value="${students.stuSeat}"></c:param>
     			<c:param name="status" value="deleteStudent"></c:param>
     		</c:url>
     	<a href="${delete}">ɾ��</a>
     	</td>
     </tr>         
     </c:forEach>    
     </table>
     <a href="/StudentMS2/servlet/Studentser?status=splitPage&studentscurrentPage=1">��ҳ</a>
     <c:choose>
     	<c:when test="${sessionScope.studentscurrentPage==1}">
     	��һҳ
     	</c:when>
     	<c:otherwise>
     	<a href="/StudentMS2/servlet/Studentser?status=splitPage&studentscurrentPage=${sessionScope.studentscurrentPage-1}">��һҳ</a>
     	</c:otherwise>
     </c:choose>
     
     <c:choose>
     	<c:when test="${sessionScope.studentscurrentPage==sessionScope.studentstotalPage}">
     	��һҳ
     	</c:when>
     	<c:otherwise>
     	 <a href="/StudentMS2/servlet/Studentser?status=splitPage&studentscurrentPage=${sessionScope.studentscurrentPage+1}">��һҳ</a>
     	</c:otherwise>
     </c:choose>
      <a href="/StudentMS2/servlet/Studentser?status=splitPage&studentscurrentPage=${sessionScope.studentstotalPage}">βҳ</a>
     
    <form action="/StudentMS2/servlet/Studentser" method="post">
    <select name="studentscurrentPage">
		<c:forEach begin="1" end="${sessionScope.studentstotalPage}" var="i" step="1">
			<c:choose>
				<c:when test="${sessionScope.studentscurrentPage==i}">
				<option  value="${i}" selected="selected" >${i}</option>
				</c:when>
				<c:otherwise>
				<option  value="${i}">${i}</option>
				</c:otherwise>
			</c:choose>
			
				
		</c:forEach> 
    </select>
    <input type="hidden" name="status" value="splitPage">
    <input type="submit" value="go">    
    </form>
     
     
     <br>
     <a href="/StudentMS2/logined/index.jsp">�ص���ҳ</a>
  </body>
</html>
