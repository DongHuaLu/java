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
<title>菜单授权</title>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery.jstree.js"></script>
<script type="text/javascript" src="js/jquery.jstree.aclcheckbox.js"></script>
<script language="javascript">
	$(function() {
		function permit(node) {
			this.permit_node(node);
		}
		function deny(node) {
			this.deny_node(node);
		}
		function cancel(node) {
			this.cancel_node(node);
		}
		function extend(node) {
			this.extends_node(node);
		}
		function permitAll(node) {
			this.permit_all(node);
		}
		function denyAll(node) {
			this.deny_all(node);
		}
		function extendAll(node) {
			this.extends_all(node);
		}
		function cancelAll(node) {
			this.cancel_all(node);
		}

		var allMenuSize="<s:property value='#menuIds.size()'/>";
		var loadedMenu = 0;
		function initMenuTable() {
			loadedMenu++;
			if(loadedMenu >= allMenuSize){
			$.getJSON("system/acl!findMenuAcls.action?principalId=${principalId}&principalType=${principalType}",
					function(data) {					
						for(var i=0;i<data.length;i++){
							var authvo=data[i];
							var resourceId=authvo.resourceId;
							var permit=authvo.permit;
							var extend=authvo.extend;
							
							
							var node=$("#"+resourceId);
							if(permit){
								node.removeClass("jstree-deny jstree-normal jstree-extend").addClass("jstree-permit");
							}else{
								node.removeClass("jstree-permit jstree-normal jstree-extend").addClass("jstree-deny");								
							}
							if(extend){
								node.addClass("jstree-extend");								
							}	
						}});
						}
						}
					
		

		<s:iterator value="#menuIds">
		var contextmenus_items = function() {
			return {
				"permit" : {
					"label" : "允许",
					"action" : permit
				},
				"permitAll" : {
					"label" : "全部许可",
					"action" : permitAll,
					"separator_after" : true
				},
				"deny" : {
					"label" : "拒绝",
					"action" : deny
				},
				"denyAll" : {
					"label" : "全部拒绝",
					"action" : denyAll,
					"separator_after" : true
				},
				"extend" : {
					"label" : "继承",
					"action" : extend
				},
				"extendAll" : {
					"label" : "全部继承",
					"action" : extendAll,
					"separator_after" : true
				},
				"cancel" : {
					"label" : "取消",
					"action" : cancel
				},
				"cancelAll" : {
					"label" : "全部取消",
					"action" : cancelAll,
					"separator_after" : true
				}
			};
		};

		var clientHeight;
		if ($.browser.msie) {
			clientHeight = document.body.clientHeight;
		} else {
			clientHeight = self.innerHeight;
		}
		/*
			$("#menuTree_<s:property/>").height(clientHeight);
			$("#menuTree_<s:property/>").width(150);
			$("#menuTree_<s:property/>").css("overflow","auto");
		
		 */
		$("#menuTree_<s:property/>")
				.jstree(
						{
							"json_data" : {
								"ajax" : {
									"url" : "system/acl!allMenuReosurceTree.action?rootMenuId="
											+ <s:property/>
								}
							},
							"themes" : {
								"theme" : "classic"
							},
							"contextmenu" : {
								"items" : contextmenus_items

							},
							"plugins" : [ "themes", "json_data", "ui",
									"aclcheckbox", "contextmenu" ]
						});
		$("#menuTree_<s:property/>").bind("loaded.jstree", function(event) {
			$("#menuTree_<s:property/>").jstree("open_all", -1);
			initMenuTable();
		});
		$("#menuTree_<s:property/>").css("font-size", "12px");
		</s:iterator>
	});

	function auth() {
		var nodes = getAllCheckedNodes();
		var param = "principalType=${principalType}&principalId=${principalId}";
		for ( var i = 0; i < nodes.length; i++) {
			var resourceId = nodes[i].attr("id");
			var operIndex = 0;
			var permit;
			var extend;

			if (nodes[i].hasClass("jstree-permit")) {
				permit = true;
			} else if (nodes[i].hasClass("jstree-deny")) {
				permit = false;
			}
			if (nodes[i].hasClass("jstree-extend")) {
				extend = true;
			} else {
				extend = false;
			}
			param = param + "&authvos[" + i + "].resourceId=" + resourceId;
			param = param + "&authvos[" + i + "].operIndex=" + operIndex;
			param = param + "&authvos[" + i + "].permit=" + permit;
			param = param + "&authvos[" + i + "].extend=" + extend;

		}
		var url = "system/acl!authMenu.action";
		$.post(url, param, function() {
			alert("授权成功");
		});
	}

	function getAllCheckedNodes() {
		var nodes = new Array();
		<s:iterator value="#menuIds">
		var allCheckedNodes_<s:property/> = $("#menuTree_<s:property/>")
				.jstree("get_all_auths_node");
		for ( var i = 0; i < allCheckedNodes_<s:property/>.length; i++) {
			nodes.push($(allCheckedNodes_<s:property/>[i]));
		}
		</s:iterator>
		return nodes;
	}
	
	function permit_all(){
	<s:iterator value="#menuIds">
		$("#menuTree_<s:property/>").jstree("permit_all");
	</s:iterator>
	}
	
	function cancel_all(){
	<s:iterator value="#menuIds">
		$("#menuTree_<s:property/>").jstree("cancel_all");
	</s:iterator>
	}
	
	function extend_all(){
	<s:iterator value="#menuIds">
		$("#menuTree_<s:property/>").jstree("extends_all");
	</s:iterator>	
	}
	
	function deny_all(){
	<s:iterator value="#menuIds">
		$("#menuTree_<s:property/>").jstree("deny_all");
	</s:iterator>	
	}
</script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	font-size: 12px;
}

a:link {
color:blue;
text-decoration:none;
}
a:visited {
color:blue;
text-decoration:none;
}
a:hover {
color:blue;
text-decoration:none;
}
a:active {
color:blue;
text-decoration:none;
} 
-->
</style>
</head>
<body>
	<table width="100%" height="100%" border=0 cellspacing=0 cellpadding=0>
		<tr>
			<td colspan="<s:property value="#menuIds.size()" />"  style="font-size:13px" ><a
				href="system/acl!allMenuReosurce.action?principalType=${principalType}&principalId=${principalId}">菜单资源授权</a>
				<a href="system/acl!allActionResource.action?principalType=${principalType}&principalId=${principalId}">操作资源授权</a>
				| 
				<a href="javascript:auth()">保存授权</a> <a
				href="javascript:permit_all()">全部允许</a> <a
				href="javascript:deny_all()">全部拒绝</a> <a
				href="javascript:extend_all()">全部继承</a> <a
				href="javascript:cancel_all()">全部取消</a>
				<hr>
			</td>
		</tr>
		<tr>
			<s:iterator value="#menuIds">
				<td width="150" valign="top"><div id="menuTree_<s:property/>" ></div>
			</s:iterator>
		</tr>
	</table>

</body>
</html>


