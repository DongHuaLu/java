<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>操作授权</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	
	<link rel="stylesheet" type="text/css" href="acl/treeTable/stylesheets/jquery.treeTable.css">
	<link rel="stylesheet" type="text/css" href="acl/treeTable/stylesheets/master.css">
	
	<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="acl/treeTable/javascripts/jquery.treeTable.min.js"></script>
	
	<script type="text/javascript">
		$(function(){
			$(".treeTable").treeTable({
				initialState : "expanded",
				//expandable:true,
				clickableNodeNames:true
			});
			$(".treeTable").css("font-size","12px");
			
			
		$("a.123").click(
		function initActionTreeTable() {
			$.getJSON("system/acl!findActionAcls.action?principalId=${principalId}&principalType=${principalType}",
					function(data) {
						for(var i=0;i<data.length;i++){
							var authvo=data[i];
							var resourceId=authvo.resourceId;
							var permit=authvo.permit;
							var extend=authvo.extend;
							
							var node=$("ins[resourceId="+resourceId+"]");
							if(permit){
								node.removeClass("jstree-deny jstree-normal jstree-extend").addClass("jstree-permit");
							}else{
								node.removeClass("jstree-permit jstree-normal jstree-extend").addClass("jstree-deny");								
							}
							if(extend){
								node.addClass("jstree-extend");								
							}	
						}});
		})
	
						
			
			
			
			var flag=false;
			
			$("a.oper,ins").toggle(
				function (){	//允许
					if($(this).is("ins")){
						//$(this).parent().removeClass("jstree-extend");
						$(this).removeClass("jstree-normal jstree-deny").addClass("jstree-permit");
					}else{
						//$(this).removeClass("jstree-extend");
						$(this).children("ins").removeClass("jstree-normal jstree-deny").addClass("jstree-permit");
					}
				},
				function (){	//拒绝
					if($(this).is("ins")){
						//$(this).parent().removeClass("jstree-extend");
						$(this).removeClass("jstree-noraml jstree-permit").addClass("jstree-deny");
					}else{
						//$(this).removeClass("jstree-extend");
						$(this).children("ins").removeClass("jstree-normal jstree-permit").addClass("jstree-deny");
					}
				},
				function (){	//取消
					if($(this).is("ins")){
						$(this).parent().removeClass("jstree-extend");
						$(this).removeClass("jstree-permit jstree-deny").addClass("jstree-normal");
					}else{
						$(this).removeClass("jstree-extend");
						$(this).children("ins").removeClass("jstree-permit jstree-deny").addClass("jstree-normal");
					}
				},
				
				function (){	//继承
				if(flag==false){
					if($(this).is("ins")){
					$(this).parent().addClass("jstree-extend");
					}else{
					$(this).addClass("jstree-extend");
					}
					flag=true;
				}else{
					if($(this).is("ins")){
					$(this).parent().removeClass("jstree-extend");
					}else{
					$(this).removeClass("jstree-extend");
					}
					flag=false;
				}
				}			
			);	
		});
		/********************************************************************/
	function permit_all(){
	$("a.oper").removeClass("jstree-extend");
	$("ins").removeClass("jstree-normal jstree-deny").addClass("jstree-permit");
	}
	
	function cancel_all(){
	$("a.oper").removeClass("jstree-extend");
	$("ins").removeClass("jstree-permit jstree-deny").addClass("jstree-normal");
	}
	
	function extend_all(){
	$("a.oper").addClass("jstree-extend");
	}
	
	function deny_all(){
	$("a.oper").removeClass("jstree-extend");
	$("ins").removeClass("jstree-normal jstree-permit").addClass("jstree-deny");
	}
	/***************************************************************/
	function auth() {
		var nodes = $("ins.jstree-permit,ins.jstree-deny,a.extend >ins");
		 
		var param = "principalType=${principalType}&principalId=${principalId}";
		for ( var i = 0; i < nodes.length; i++) {
			var node=$(nodes[i]);
			var resourceId = node.attr("resourceId");
			var operIndex = node.attr("operIndex");
			var permit;
			var extend;
			
			if (node.hasClass("jstree-permit")) {
				permit = true;
			} else if (node.hasClass("jstree-deny")) {
				permit = false;
			}
			if (node.parent().hasClass("jstree-extend")) {
				extend = true;
			} else {
				extend = false;
			}
			param = param + "&authvos[" + i + "].resourceId=" + resourceId;
			param = param + "&authvos[" + i + "].operIndex=" + operIndex;
			param = param + "&authvos[" + i + "].permit=" + permit;
			param = param + "&authvos[" + i + "].extend=" + extend;

		}
		var url = "system/acl!authActionResource.action";
		$.post(url, param, function() {
			alert("授权成功");
		});
	}
	$(
		function(){
			$.getJSON("system/acl!findActionAcls?principalId=${principalId}&principalType=${principalType}",
				function(data){
					for(var i=0;i<data.length;i++){
						var authvo=data[i];
						var resourceId=authvo.resourceId;
						var permit=authvo.permit;
						var extend=authvo.extend;
						var operIndex=authvo.operIndex;
						var node=$("ins[resourceId="+resourceId+"][operIndex="+operIndex+"]");
							if(permit){
								node.removeClass("jstree-deny jstree-normal jstree-extend").addClass("jstree-permit");
							}else{
								node.removeClass("jstree-permit jstree-normal jstree-extend").addClass("jstree-deny");								
							}
							if(extend){
								node.parent().addClass("jstree-extend");							
						}
						
					}
				}
			)
		
		}
	)
	

	
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

-->
</style>
  </head>
  
  <body>
   	<table width="100%" height="100%" border=0 cellspacing=0 cellpadding=0>
		<tr>
			<td style="font-size:13px">
				<a href="system/acl!allMenuReosurce.action?principalType=${principalType}&principalId=${principalId}">菜单资源授权</a>
				<a href="system/acl!allActionResource.action?principalType=${principalType}&principalId=${principalId}">操作资源授权</a>
					| 
				<a href="javascript:auth()">保存授权</a> 
				<a href="javascript:permit_all()">全部允许</a> 
				<a href="javascript:deny_all()">全部拒绝</a> 
				<a href="javascript:extend_all()">全部继承</a>
				<a href="javascript:cancel_all()">全部取消</a>
				<a href="javascript:initActionTreeTable()" class="123">123</a>
				<hr>
			</td>
		</tr>
		<tr>
			<td valign="top">
				<table class="treeTable">
					<thead>
						<tr>
							<td>操作资源名称</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody> 
						<s:iterator value="#actionResources" var="res">
							<tr id="res-<s:property value="#res.id"/>"  class="<s:if test="#res.parent != null"> child-of-res-<s:property value="#res.parent.id"/></s:if>" > 
							<td><span class="<s:if test="#res.children.size() == 0">file</s:if><s:else>folder</s:else>"><s:property value="#res.name"/></span></td>
								<td>
									<s:iterator value="opers">
									
									<a class="oper">
										<ins class="jstree-normal" operIndex="<s:property value="value.operIndex"/>"  resourceId="<s:property value="#res.id"/>">&nbsp;&nbsp;&nbsp;&nbsp;</ins>
										<s:property value="value.operName"/>
									</a>
									</s:iterator>
								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</td>
		</tr>
	</table>
   
   
   <br><s:debug></s:debug>
  </body>
</html>
