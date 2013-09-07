function ListNode(){}
var ListNode=new ListNode();

var str="";

function listNode(node,level){
	printInfo(node,level);
	level++;
	var nodes = node.childNodes;
	for (var i=0;i<nodes.length;i++){
		if(node.hasChildNodes)
			listNode(nodes[i],level);
		else
			printInfo(nodes[i],level);
	}
}

function getSpace(level){
	var s="";
	for (var i=0;i<level;i++){
		if (i==0)
			s += "|--";
		else
			s += "--";
	}
	return s;

}

function printInfo(node,level){
	str += getSpace(level)+ "name:"+node.nodeName+/*"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;type:"+node.nodeType+*/"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;value:"+node.nodeValue+"<br />";
}

function doList(fristNode){
	listNode(fristNode,0);
	document.write(str);
}

ListNode.doList=doList;


