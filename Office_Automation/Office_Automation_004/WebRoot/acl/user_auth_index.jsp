<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'user_auth_index.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<style type="text/css" title="currentStyle">
@import "js/datatable/css/demo_page.css";

@import "js/datatable/css/demo_table.css";

.dataTables_filter {
	width: 50%;
	float: left;
	text-align: left;
	font-size: 12px
}

.dataTables_filter input {
	width: 60%;
	float: rigth;
}
</style>
<script type="text/javascript">
	var oTable;
	$(function() {
		oTable = $("#userList").dataTable({
			"bProcessing" : true,// 加载数据时候是否显示进度条
			"bServerSide" : true,// 是否从服务加载数据
			"bPaginate" : false,
			"bInfo" : false,
			"bSort" : false,
			"aoColumnDefs" : [ {
				"bVisible" : false,
				"aTargets" : [ 0 ]
			} ],
			"sAjaxSource" : "system/acl!userAuthIndexTree.action",// 如果从服务器端加载数据,这个属性用于指定加载的路径
			"sPaginationType" : "full_numbers",
			"oLanguage" : { // 主要用于设置各种提示文本
				"sProcessing" : "正在处理...", // 设置进度条显示文本
				"sEmptyTable" : "没有找到记录",// 没有记录时显示的文本
				"sZeroRecords" : "没有找到记录",// 没有记录时显示的文本
				"sInfoEmpty" : "",// 没记录时,关于记录数的显示文本
				"sSearch" : "搜索:",// 搜索框前的文本设置
			}
		});

		$("#userList tbody").click(function(event) {
			var ons = oTable.fnGetNodes();
			for ( var i = 0; i < ons.length; i++) {
				$(ons[i]).removeClass("row_selected");
			}
			/*
			$(oTable.fnSettings().aoData).each(
				function(){
					$(this.nTr).removeClass("row_selected");
				}
			);
			 */
			$(event.target.parentNode).addClass("row_selected");
			openAuth();
		});

	});

	function openAuth() {
		var principalId;
		$(oTable.fnSettings().aoData).each(function() {
			if($(this.nTr).hasClass("row_selected")){
			principalId=this._aData[0];
			}
		});	
		if(principalId){													
			$("#rightFrame").attr("src","system/acl!allMenuReosurce.action?principalId="+principalId+"&principalType=User");
		}
	}
</script>
</head>

<body>
	<table width="100%" height="100%" border=0 cellspacing=0 cellpadding=0>
		<tr>
			<td width="160" valign="top">
				<table cellpadding="0" cellspacing="0" border="0" class="display"
					id="userList" width="100%">
					<thead>
						<tr>
							<th>ID</th>
							<th>选择用户授权</th>
						</tr>
					</thead>
					<tbody>
						<tr class="odd gradeX">
							<td colspan="2">目前暂时没有内容！</td>
						</tr>
					</tbody>
				</table></td>
			<td width="8" bgcolor="#add2da">&nbsp;</td>
			<td><iframe src="right.jsp" width="100%" height="100%"
					frameborder="0" id="rightFrame" name="rightFrame"></iframe>
			</td>
			<td width="8" bgcolor="#add2da">&nbsp;</td>
		</tr>
	</table>
</body>
</html>
