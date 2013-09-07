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
	<h3>添加操作信息</h3>
	<form action="system/resource.action" method="post">
	<input type="hidden" name="method:addOper">
	<input type="hidden" name="id" value="<s:property value="id"/>">
	<fieldset>
		<legend>添加操作
		</legend>
		<div>
			<label for="methodName">方法名</label>
			<input type="text" name="methodName" id="methodName" value="${methodName }" size="60" /> 
			<br />	
		</div>		
		<div>
			<label for="operIndex">operIndex</label>
			<input type="text" name="operIndex" id="operIndex" value="${operIndex }" size="60" /> 
			<br />	
		</div>		
		<div>
			<label for="operName">operName</label>
			<input type="text" name="operName" id="operName" value="${operName }" size="60" /> 
			<br />	
		</div>		
		<div>
			<label for="operSn">operSn</label>
			<input type="text" name="operSn" id="operSn" value="${operSn }" size="60" /> 
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

