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
	<title>添加菜单信息</title>
<link href="../common/common.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<div id="formwrapper">
	<h3>添加菜单信息</h3>
	<form action="system/menu.action" method="post">
	<input type="hidden" name="method:add">
	<input type="hidden" name="parent.id" value='<s:property value="parent.id"/>' >
	<fieldset>
		<legend>添加菜单
		</legend>
		<div>
			<label for="name">菜单名</label>
			<input type="text" name="name" id="name" value="${name }" size="60" /> 
			<br />	
		</div>		
		<div>
			<label for="href">链接</label>
			<input type="text" name="href" id="href" value="${href }" size="60" /> 
			<br />	
		</div>		
		<div>
			<label for="orderNumber">orderNumber</label>
			<input type="text" name="orderNumber" id="orderNumber" value="${orderNumber }" size="60" /> 
			<br />	
		</div>		
		<div>
			<label for="sn">sn</label>
			<input type="text" name="sn" id="sn" value="${sn }" size="60" /> 
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
</html>

