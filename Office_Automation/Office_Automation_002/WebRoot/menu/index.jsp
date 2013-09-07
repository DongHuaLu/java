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
	<title>CMS 后台管理工作平台</title>
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
	
		$("#menuTree").height(clientHeight);
		$("#menuTree").width(150);
		$("#menuTree").css("overflow","auto");
		
	
	
		$("#menuTree").jstree({
			"json_data":{
				"ajax":{
					"url":"system/menu!tree.action"
				}
			},
			"plugins" : [ "themes", "json_data" ,"ui" ]
		});
		/*$("#partyTree").bind(
			"loaded.jstree",
			function(event){
				$("#partyTree").jstree("open_all",-1);
			}
		);*/
		$("#menuTree").bind(
			"select_node.jstree",
			function(event,data){
				//取li标记上的属性
				var menuId = data.rslt.obj.attr("id");				
				$("#rightFrame").attr("src","system/menu!updateInput.action?id=" + menuId);
			}
		);
		$("#menuTree").css("font-size","12px");
	});
	
	function refresh(){
		$("#menuTree").jstree("refresh","#menuTree");
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
	<td width="150" valign="top"><div><input type="button" value="添加根菜单" onclick=" window.location = 'system/menu!addInput.action' " /></div><div id="menuTree"></div> </td>
	<td width="8" bgcolor="#add2da">&nbsp;</td>
	<td>
		<iframe src="right.jsp"  width="100%" height="100%" frameborder="0" id="rightFrame" name="rightFrame"></iframe>
	</td>
	<td width="8" bgcolor="#add2da">&nbsp;</td>
</tr>
</table>

</body>
</html>

