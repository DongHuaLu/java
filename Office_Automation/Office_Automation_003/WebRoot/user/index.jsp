<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户列表</title>
<link href="org/theme/party.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<style type="text/css" title="currentStyle">
@import "js/datatable/css/demo_page.css";

@import "js/datatable/css/demo_table.css";
</style>
<script type="text/javascript">
	$(function() {
		oTable = $("#userList")
				.dataTable(
						{
							"bProcessing" : true,// 加载数据时候是否显示进度条
							"bServerSide" : true,// 是否从服务加载数据
							"sAjaxSource" : "system/user!list.action",// 如果从服务器端加载数据,这个属性用于指定加载的路径
							"sPaginationType" : "full_numbers",
							"oLanguage" : { // 主要用于设置各种提示文本
								"sProcessing" : "正在处理...", // 设置进度条显示文本
								"sLengthMenu" : "每页_MENU_行<input type='button' value='添加用户' onclick='addUser()'/> <input type='button' value='删除用户' onclick='deleteUser()'/>  <input type='button' value='更新用户' onclick='updateUser()'/>",// 显示每页多少条记录
								"sEmptyTable" : "没有找到记录",// 没有记录时显示的文本
								"sZeroRecords" : "没有找到记录",// 没有记录时显示的文本
								"sInfo" : "总记录数 _TOTAL_ 当前显示从 _START_ 至 _END_",
								"sInfoEmpty" : "",// 没记录时,关于记录数的显示文本
								"sSearch" : "搜索:",// 搜索框前的文本设置
								"oPaginate" : {
									"sFirst" : "首页",
									"sLast" : "未页",
									"sNext" : "下页",
									"sPrevious" : "上页"
								}
							}
						});

		//点击时选中表行
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
		});

		oTable.css("font-size", "12px");
	});

	function addUser() {
		var anSelected = fnGetSelected(oTable);
		if (anSelected.length == 0) {
			alert("请选中要更新的用户!");
			return;
		}

		var personId = anSelected[0].children[0].innerHTML;

		window.location = "system/user!addInput.action?person.id="+personId;
	}

	function deleteUser() {
		var anSelected = fnGetSelected(oTable);
		if (anSelected.length == 0) {
			alert("请选中要删除的用户!");
			return;
		}

		if (!confirm("删除不可恢复,您是否确认要删除吗?")) {
			return;
		}

		var personId = anSelected[0].children[0].innerHTML;
		$.get("system/user!del.action?id=" + personId, function() {
			oTable.fnDeleteRow(anSelected[0]);
		});
	}
	function updateUser() {
		var anSelected = fnGetSelected(oTable);
		if (anSelected.length == 0) {
			alert("请选中要更新的用户!");
			return;
		}

		var personId = anSelected[0].children[0].innerHTML;

		window.location = "system/user!updateInput.action?id=" + personId;
	}
	//获得选中行集合的方法
	function fnGetSelected(oTab) {
		var aReturn = new Array();
		var aTrs = oTab.fnGetNodes();
		for ( var i = 0; i < aTrs.length; i++) {
			if ($(aTrs[i]).hasClass("row_selected")) {
				aReturn.push(aTrs[i]);
			}
		}
		return aReturn;
	}
</script>
</head>
<body>

	<table cellpadding="0" cellspacing="0" border="0" class="display"
		id="userList" width="100%">
		<thead>
			<tr>
				<th>ID</th>
				<th>name</th>
				<th>所属单位</th>
				<th>username</th>
			</tr>
		</thead>
		<tbody>
			<tr class="odd gradeX">
				<td colspan="4">目前暂时没有内容！</td>
			</tr>
		</tbody>
	</table>
</body>
</html>

