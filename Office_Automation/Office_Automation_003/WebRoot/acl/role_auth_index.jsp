<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>角色授权</title>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery.jstree.js"></script>
<script language="javascript">
	$(function(){
		var clientHeight;
		if($.browser.msie){
			clientHeight = document.body.clientHeight;
		} else {
			clientHeight = self.innerHeight;
		}
	
		$("#roleAuthTree").height(clientHeight);
		$("#roleAuthTree").width(150);
		$("#roleAuthTree").css("overflow","auto");
	
	
		$("#roleAuthTree").jstree({
			"json_data":{
				"ajax":{
					"url":"system/acl!roleAuthIndexTree.action"
				}				
			},
			"themes":{
					"theme":"classic"
				},
			"plugins" : [ "themes", "json_data" ,"ui" ]
		});
		$("#roleAuthTree").bind(
			"select_node.jstree",
			function(event,data){
				//取li标记上的属性
				var principalId  = data.rslt.obj.attr("id");
				var principalType = data.rslt.obj.attr("principalType");
				$("#rightFrame").attr("src","system/acl!allMenuReosurce.action?principalId="+principalId+"&principalType="+principalType);
			}
		);
		$("#roleAuthTree").css("font-size","12px");
	});
	
	function refresh(){
		$("#roleAuthTree").jstree("refresh","#roleAuthTree");
	}
</script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	font-size:12px;
}
	
-->
</style>
</head>
<body>
<table width="100%" height="100%" border=0 cellspacing=0 cellpadding=0>
<tr>
	<td width="150" valign="top"><div id="roleAuthTree"></div>	
	</td>
	<td width="8" bgcolor="#add2da">&nbsp;</td>
	<td>
		<iframe src="right.jsp"  width="100%" height="100%" frameborder="0" id="rightFrame" name="rightFrame"></iframe>
	</td>
	<td width="8" bgcolor="#add2da">&nbsp;</td>
</tr>
</table>

</body>
</html>

