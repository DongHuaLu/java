<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
	window.onload=init;
	function init(){
		var select=document.getElementById("select");
		select.onchange=getPerson;
		
	}
	
	
	function getPerson(){
	var dtd=this.value;
	//1.获取XMLHttpRequest
	var xhr=createXMLHttpRequest();
	//2.通过xhr来打开页面
	xhr.open("POST","person.do",true);
	//3.处理请求
	xhr.onreadystatechange = function(){
		alert("!");
		if(xhr.readyState==4&&xhr.status==200){
			var XMLDoc=xhr.resopnseXML;
			
			var pns=XMLDoc.getElementsByTagName("persons");
			alert(pns.length);
			for(var i=0;i<pns.length;i++){
				alert(pns[i].getElementsByTagName("id")[0].innerHTML);
			}
		}
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send("dtd="+dtd);
	}
	
	
	//4.传递参数
	}
	
	
	
	function createXMLHttpRequest(){
		if(window.XMLHttpRequest){
			return new XMLHttpRequest();
		}else if(window.ActiveXObject){
			return new ActiveXObject("Miresoft.XMLHTTP");
		}
	}
	
	
	</script>
  </head>
  
  <body>
    <select id="select">
    	<option value="1">人</option>
    	<option value="2">吃</option>
    	<option value="3">德克士</option>
    </select>
  </body>
</html>
