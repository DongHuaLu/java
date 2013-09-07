<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>更新人员账号信息</title>
<link href="../common/common.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<div id="formwrapper">
	<h3>更新账号信息</h3>
	<form action="system/user.action" method="post">
	<input type="hidden" name="method:update">
	<input type="hidden" name="person.id" value="<s:property value="person.id"/>">
	<input type="hidden" name="id" value="<s:property value="id"/>">
	<fieldset>
		<legend>更新账号
		</legend>
		<div>
			<label for="username">用户名</label>
			<input type="text" name="username" id="username" value="${username }" size="60" /> 
			<br />	
		</div>
		<div>
			<label for="password">密码</label>
			<input type="text" name="password" id="password" value="${password }" size="60" /> 
			<br />	
		</div>
		<div>
			<label for="roleIds">分配角色</label>
			<select name="roleIds" id="roleIds" multiple="multiple" >
			<s:iterator value="roles">
			
				<option value="<s:property value="id"/>" <s:property value="hasSelected(id,#selectedRoles)"/>> <s:property value="name"/></option>
			
			</s:iterator>
			 </select>
			<br />	
		</div>
		
		
		<div class="enter">
		    <input name="submit" type="submit" class="buttom" value="提交" />
		    <input name="reset" type="reset" class="buttom" value="重置" />
		</div>		
	</fieldset>
	</form>
</div>
</body>
<%-- <s:debug></s:debug> --%>
</html>

