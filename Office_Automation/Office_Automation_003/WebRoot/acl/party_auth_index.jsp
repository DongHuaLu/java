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
	<title>部门|岗位授权</title>
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
	
		$("#partyAuthTree").height(clientHeight);
		$("#partyAuthTree").width(150);
		$("#partyAuthTree").css("overflow","auto");
	
	
		$("#partyAuthTree").jstree({
			"json_data":{
				"ajax":{
					"url":"system/acl!partyAuthIndexTree.action"
				}				
			},
			"themes":{
					"theme":"classic"
				},
			"plugins" : [ "themes", "json_data" ,"ui" ]
		});
		$("#partyAuthTree").bind(
			"loaded.jstree",
			function(event){
				$("#partyAuthTree").jstree("open_all",-1);
			}
		);
		$("#partyAuthTree").bind(
			"select_node.jstree",
			function(event,data){
				//取li标记上的属性
				var principalId  = data.rslt.obj.attr("id");
				var partyType=data.rslt.obj.attr("partyType");
				var principalType;
				if(partyType=="department"){
					principalType="Department";
				}else if(partyType=="position"){
					principalType="Position";
				}else{
					alert("请选择部门或岗位!");
					return;
				}
				$("#rightFrame").attr("src","system/acl!allMenuReosurce.action?principalId="+principalId+"&principalType="+principalType);
			}
		);
		$("#partyAuthTree").css("font-size","12px");
	});
	
	function refresh(){
		$("#partyAuthTree").jstree("refresh","#partyAuthTree");
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
	<td width="150" valign="top"><div id="partyAuthTree"></div>	
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

