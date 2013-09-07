<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'delete_success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台模板</title>

<style type="text/css">
 body{
  font-size:12px;	background-image: url(images/bg.gif);	background-repeat: repeat; padding:0px; margin: 5px;
 }
 ul,li,h2{margin:0;padding:0;}
 ul{list-style:none;}
 #top{
  width:1000px;	height:26px;	background-image: url(images/h2bg.gif);	margin-top: 0px;	margin-right: auto;	margin-bottom: 0;	margin-left: auto;	background-repeat: repeat-x; 
 }
 #top h2{
  width:150px;	height:24px;	float:left;	font-size:12px;	text-align:center;	line-height:20px;	color: #000;	font-weight: bold;	padding-top: 4px;border-right-width: 1px;	border-left-width: 1px;	border-right-style: solid;	border-left-style: solid;	border-right-color: #99BBE8;	border-left-color: #99BBE8;
 }
 #top .jg {
  width: 5px;	float: left;	background-color: #DCE6F5;	height: 26px;
 }
 #topTags{
  width:830px;	height:24px;	float:left;	margin-top: 0;	margin-right: auto;	margin-bottom: 0;	margin-left: auto;	padding-top: 2px;	border-right-width: 1px;	border-left-width: 1px;	border-right-style: solid;	border-left-style: solid;	border-right-color: #99BBE8;	border-left-color: #99BBE8;	padding-left: 10px;
 }
 #topTags ul li{
  float:left;	width:100px;	height:21px;	margin-right:4px;	display:block;
  text-align:center;	cursor:pointer;	padding-top: 3px;	color: #15428B;	font-size: 12px;
 }
 #main{
  clear:left; width:1000px;	height:540px;	background-color:#F5F7E6;	margin-top: 0;	margin-right: auto;	margin-bottom: 0;	margin-left: auto; 
 }
 #main .jg {
  width: 5px;	float: left;	background-color: #DFE8F6;	height: 540px;
 }
 #leftMenu{
  width:150px;	height:540px;	background-color:#DAE7F6;	float:left;	border-right-width: 1px;	border-left-width: 1px;	border-right-style: solid;	border-left-style: solid;	border-right-color: #99BBE8;	border-left-color: #99BBE8;
 }
 #leftMenu ul{margin:10px;}
 #leftMenu ul li{
  width:100px;	height:22px;	display:block;	cursor:pointer;	text-align:left;	margin-bottom:5px;	background-color: #D9E8FB;	background-image: url(images/tabbg01.gif);	background-repeat: no-repeat;	background-position: 0px 0px;	padding-top: 2px;	line-height: 20px; padding-left: 30px; overflow: hidden;
 }
 #leftMenu ul li a{
  color:#000000;	text-decoration:none;	background-image: url(images/tb-btn-sprite_03.gif);	background-repeat: repeat-x;
 }
 #content{
  width:840px;	height:540px;	float:left;	border-right-width: 1px;	border-left-width: 1px;	border-right-style: solid;	border-left-style: solid;	border-right-color: #99BBE8;	border-left-color: #99BBE8;	background-color: #DAE7F6; 
 }
 .content{
  width:830px;	height:530px;	display:none;	padding:5px;	overflow-y:auto;	line-height:30px;	background-color: #FFFFFF;
 }
 #footer{
  width:1000px;	height:23px;	background-color:#FFFFFF;	line-height:20px;	text-align:center;	margin-top: 0;	margin-right: auto;	margin-bottom: 0;	margin-left: auto;	border-right-width: 1px;	border-left-width: 1px;	border-right-style: solid;	border-left-style: solid;	border-right-color: #99BBE8;	border-left-color: #99BBE8;	background-image: url(images/h2bg.gif);
  background-repeat: repeat-x; padding-top: 3px; color:#f00;
 }
</style>

<script type="text/javascript">
window.onload=function(){
  function $(id){return document.getElementById(id)}
  var menu=$("topTags").getElementsByTagName("ul")[0];//顶部菜单容器
  var tags=menu.getElementsByTagName("li");//顶部菜单
  var ck=$("leftMenu").getElementsByTagName("ul")[0].getElementsByTagName("li");//左侧菜单
  var j;
  var t = document.getElementById('content');
  var tt= t.getElementsByTagName('div');
 //点击左侧菜单增加新标签
  for(i=0;i<ck.length;i++){
    ck[i].onclick=function(){
       $("welcome").style.display="none"//欢迎内容隐藏
       clearMenu();
       this.style.background='url(images/tabbg02.gif)'
       //循环取得当前索引
       for(j=0;j<tt.length-1;j++){
          if(this==ck[j]){
            if($("p"+j)==null && j != 8){
              openNew(j,this.innerHTML);//设置标签显示文字
              writeFile(j);
            }
            if(j != 8) {
               clearStyle();
               $("p"+j).style.background='url(images/tabbg1.gif)';
               clearContent();
               $("c"+j).style.display="block";
            }else{
               ck[j].style.background = 'url() #369';
            }
            
          }
       }
      return false;
    }
  }
 //增加或删除标签
   function openNew(id,name){
       var tagMenu=document.createElement("li");
       tagMenu.id="p"+id;
       tagMenu.innerHTML=name+"&nbsp;&nbsp;"+"<img src='images/off.gif' style='vertical-align:middle'/>";

      //标签点击事件
      tagMenu.ondblclick=function(evt){
         var cc=tags[tags.length-1].id.split("p");
         reloadframe(cc[1]);
         /* evt=(evt)?evt:((window.event)?window.event:null);
         if(evt.stopPropagation){evt.stopPropagation()} //取消opera和Safari冒泡行为;
         this.parentNode.removeChild(tagMenu);//删除当前标签
         var color=tagMenu.style.backgroundColor;
         //设置如果关闭一个标签时，让最后一个标签得到焦点
         if(color=="#ffff00"||color=="yellow"){//区别浏览器对颜色解释
            if(tags.length-1>=0){
               clearStyle();
               tags[tags.length-1].style.background='url(images/tabbg1.gif)';
               clearContent();
               var cc=tags[tags.length-1].id.split("p");
               $("c"+cc[1]).style.display="block";
               clearMenu();
               ck[cc[1]].style.background='url(images/tabbg1.gif)';
            }else{
               clearContent();
               clearMenu();
               $("welcome").style.display="block";
            }
         }
         clearMenu();*/
      }

      tagMenu.onclick=function(evt){
        clearMenu();
        ck[id].style.background='url(images/tabbg02.gif)'
        clearStyle();
        tagMenu.style.background='url(images/tabbg1.gif)';
        clearContent();
        $("c"+id).style.display="block";
        //reloadframe(id);  //点击标签回到原始链接页面
      }
      //标签内关闭图片点击事件
      tagMenu.getElementsByTagName("img")[0].onclick=function(evt){
         evt=(evt)?evt:((window.event)?window.event:null);
         if(evt.stopPropagation){evt.stopPropagation()} //取消opera和Safari冒泡行为;
         if(tags.length >1) {
           this.parentNode.parentNode.removeChild(tagMenu);//删除当前标签
         }
         var color=tagMenu.style.backgroundColor;
         //设置如果关闭一个标签时，让最后一个标签得到焦点
         if(color=="#ffff00"||color=="yellow"){//区别浏览器对颜色解释
            if(tags.length-1>=0){
               clearStyle();
               tags[tags.length-1].style.background='url(images/tabbg1.gif)';
               clearContent();
               var cc=tags[tags.length-1].id.split("p");
               $("c"+cc[1]).style.display="block";
               clearMenu();
               ck[cc[1]].style.background='url(images/tabbg1.gif)';
            }else{
               clearContent();
               clearMenu();
               $("welcome").style.display="block";
            }
         }
      }
      menu.appendChild(tagMenu);
   }
   //清除菜单样式
   function clearMenu(){
       for(i=0;i<ck.length;i++){
         if(i != 8)
           ck[i].style.background='url(images/tabbg01.gif)';
         else
           ck[i].style.background = 'url() #369';
       }
   }
   //清除标签样式
   function clearStyle(){
      for(i=0;i<tags.length;i++){
         menu.getElementsByTagName("li")[i].style.background='url(images/tabbg2.gif)';
      }
   }
   //清除内容
   function clearContent(){
      var t = document.getElementById('content');
      var tt= t.getElementsByTagName('div');
      for(i=0;i<tt.length-1;i++){
         $("c"+i).style.display="none";
      }
    }
}
</script>
</head>
<body>
<div id="top">
   <h2>邮箱 [<a href='#' target='_self'>首页</a>][<a href='#' target='_self'>退出</a>]</h2>
   <div class=jg></div>
   <div id="topTags">
      <ul></ul>
   </div>
</div>
<div id="main"> 
   <div id="leftMenu">
     <ul>
       <li style='background:none green;color:#fff;font-weight: bold;'>发送消息</li><li>1．收件箱</li><li>2．发件箱</li><li> 3．垃圾箱</li><!--<li>4．HTML页面管理</li> <li>6．批量移动</li><li>7．搜索</li><li>8．相关</li>

       <li style='background:none #369;color:#fff;font-weight: bold;'>其它管理</li>

       <li>1．资源回收</li><li>2．友情链接</li><li>3．广告管理</li><li>4．用户管理</li><li>5．META管理</li><li>6．评论管理</li>-->
     </ul>
   </div>
   <div class=jg></div>
   <div id="content">
      <div id="welcome" class="content" style="display:block;">
         <iframe width='100%' id='iframe' height='100%' src='welcome.jsp' frameborder='0' vspace='0'></iframe> 
      </div>
      <script>
         function writeFile($id) {
           var arr = [];
           arr[0]  = '/SendMsgSSH/dolph/message!showSendMessage' ; 
           arr[1]  = '/SendMsgSSH/dolph/message!showReceivebox'; 
           arr[2]  = '/SendMsgSSH/dolph/message!showSendbox'; 
           arr[3]  = '/SendMsgSSH/dolph/message!showDeletebox'; 
           arr[4]  = ''; 
           arr[5]  = ''; 
           arr[6]  = ''; 
           arr[7]  = ''; 
           arr[8]  = '------'; 
           arr[9]  = ''; 
           arr[10] = ''; 
           arr[11] = ''; 
           arr[12] = ''; 
           arr[13] = ''; 
           arr[14] = 'Demo.php'; 
           var filename = arr[$id];
           var iframe = '<iframe width="100%" height="100%" name="i'+$id+'" id="i'+$id+'" src="'+filename+'" frameborder="0" vspace="0"></iframe>' ;
           document.getElementById('c'+$id).innerHTML = iframe;
         }
      </script>
      <div id="c0" class="content"></div>

      <div id="c1" class="content"></div>

      <div id="c2" class="content"></div>

      <div id="c3" class="content"></div>

      <div id="c4" class="content"></div>

      <div id="c5" class="content"></div>

      <div id="c6" class="content"></div>

      <div id="c7" class="content"></div>

      <div id="c8" class="content">------</div>

      <div id="c9" class="content"></div>

      <div id="c10" class="content"></div>

      <div id="c11" class="content"></div>

      <div id="c12" class="content"></div>

      <div id="c13" class="content"></div>

      <div id="c14" class="content"></div>
   </div>
</div>
<div id="footer">dolph</div>
<script>
   function reloadframe($i) {
      var $src = document.getElementById('i'+$i).src;
      document.getElementById('i'+$i).src = $src;
   }
</script>

</body>
</html>