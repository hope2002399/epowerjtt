<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>

<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
<meta name="decorator" content="noneWorkFlow"/>

<% String path = request.getContextPath(); %>

<title>${ wfname }-在线工作流设计</title>

<style type="text/css">
* { margin:0; padding:0; font-size:12px; -moz-user-select:none; }
body { background:url(<%=path %>/page/workflow/svgworkflow/images/canvasbg.gif) repeat; }
li { list-style:none; }
table { border-collapse:collapse; background:#fff; }
table td { border:1px solid #ccc;padding:2 2 0 0;}
table td div { padding:4px; text-align:right; line-height:20px; background:buttonface;}
table td span { padding:4px;}
table td label { padding-left:2px; }
#tool { position:fixed; left:0; top:0; width:355px; height:24px; padding:0px 0px 6px 2px; background:buttonface; z-index:120;BORDER-BOTTOM: gray 2px solid;BORDER-right: gray 2px solid;BORDER-TOP: #eeeeee 2px solid;BORDER-LEFT: #eeeeee 2px solid; }
#tool div { position:relative; z-index:10; float:left; height:24px;margin-top:4px;padding-right:2px;background:buttonface;width:24px;text-align:center;}
#tool div:hover { background:#ccccff;border:black 1px solid; }
#tool img { cursor:pointer;margin-top:4px;}
#argumentTool { position:fixed; right:100px; top:0px; width:255px;border-top:gray 2px solid;border-bottom:gray 2px solid;border-left:black 1px solid;border-right:gray 2px solid; z-index:120;background:buttonface;}
.argumentTitle {  cursor:move; padding:4px 0; height:20px; background:#0066ff;color:white;line-height:20px; text-indent:10px; }
.argumentContent { width:99%;border-right:black 1px solid;border-bottom:black 1px solid;margin-bottom:3px;}
 #tool .move { cursor:move; background:url(<%=path %>/page/workflow/image/tb_title.gif);width:4px; } 
#tool .move:hover{background:buttonface;border:0 solid;}
#c { float:left; width:100%; min-height:800px; }
#ispro { display:none;height:100%;overflow:auto;}
#isline,#iscircle { display:none;}
#canvas { width:100%;height:1000px;min-height:1000px;position:absolute;}
#lineCon { position:absolute; left:0; top:0;z-index:100; }
.step { position:absolute; left:0; top:0; text-align:center; white-space:nowrap;padding:0 4px; height:24px;line-height:24px; cursor:pointer;z-index:100; }
</style>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onselectstart="return false;">
<input id="xml" type="hidden" value='${flowXmlDesc}'></input>
<div id="tool">
<div id="move" class="move"></div>
<div id="toxml"><img src="<%=path %>/page/workflow/svgworkflow/images/save.png" title="保存流程图" /></div>
    <div id="validate" onclick="onValidate();"><img src="<%=path %>/page/workflow/svgworkflow/images/validate.gif" title="校验流程图"/></div>
    <div style="background:url(<%=path %>/page/workflow/image/split.gif);width:2px;height:30px;margin-top:0px;"></div>
    <div id="delete"><img src="<%=path %>/page/workflow/image/del_obj.gif" title="删除选中对象" /></div>
    <div class="opt" id="cursor" style="background:#888;"><img id="default" src="<%=path %>/page/workflow/svgworkflow/images/default.png" title="修改选中对象" /></div> 
    <div class="opt"><img id="rect" src="<%=path %>/page/workflow/svgworkflow/images/rect.png" border="none" title="点击画圆矩形" /></div>
    <%-- <div class="opt"><img id="polygon" src="<%=path %>/page/workflow/svgworkflow/images/leng.png" title="点击画菱形" /></div> --%>
    <div class="opt"><img id="line" src="<%=path %>/page/workflow/svgworkflow/images/polyline.png" title="点击画折线" /></div>
    <div style="background:url(<%=path %>/page/workflow/image/split.gif);width:2px;height:30px;margin-top:0px;"></div>
    <%-- <div id="un" style="background:url(<%=path %>/page/workflow/image/split.gif);"></div> --%>
    <div  onclick="setZoom('big');" ><img src="<%=path %>/page/workflow/image/zoomin.gif" title="放大显示比例 " /></div>
    <div style="width:45px;"><select id="zoomshow" onchange="changeZoom(this.value);" style="width:50px;margin-top:2px;" ><option value="0.2">20%</option><option value="0.4">40%</option><option value="0.6">60%</option><option value="0.8">80%</option><option value="1" selected>100%</option><option value="1.2">120%</option><option value="1.4">140%</option><option value="1.6">160%</option><option value="1.8">180%</option><option value="2">200%</option></select></div>
    <div  onclick="setZoom('small');" ><img src="<%=path %>/page/workflow/image/zoomout.gif" title="缩小显示比例 " /></div>      
	<div id="undo" onclick="undoLog();" ><img src="<%=path %>/page/workflow/image/undo.gif" title="撤消最后一次操作" /></div>
	<div id="redo" onclick="redoLog();"><img src="<%=path %>/page/workflow/image/redo.gif" title="恢复最后一次取消的操作" /></div>
	<div style="background:url(<%=path %>/page/workflow/image/split.gif);width:2px;height:30px;margin-top:0px;"></div>
	<div id="close" onclick="closeWindow();"><img src="<%=path %>/page/workflow/image/exit.gif" title="返回" /></div>
    <!--<div id="save"><img src="images/save.png" alt="保存xml" /></div>-->
</div>
<div id="argumentTool" >
	<div id="argumentTitle" class="argumentTitle">属性
	<img width="14" height="14" title="单击收缩工具栏" id="hideImg" style="cursor:pointer;float:right;" src="<%=path %>/page/workflow/image/up.gif" onclick="hideTool();"></img>
	</div>
	<div style="background:#ccf;height:22px;" id="argumentNoUse"><div style="width:38%;float:left;height:22px;margin-left:2px;">属性</div><div style="width:60%;float:left;height:22px;">值</div></div>
    <div id="argumentContent" class="argumentContent">
		<!-- 流程图属性 -->
		<div id="ispro">
			<table width="100%" cellpadding="0" cellspacing="10" >
				<tr>
					<td width="37%" ><div>名称</div></td>
					<td width="63%" ><div><input type="text" id="nodename" value=""  style="width:99%;" onchange="changeValue(this,'nodename')" /></div></td>
				</tr>
				<tr>
					<td><div>环节代码</div></td>
					<td><div><input type="text" id="nodecode" value="" style="width:99%;" onchange="changeValue(this,'nodecode')"/></div></td>
				</tr>
				<tr>
					<td><div>流程节点阶段</div></td>
					<td><div> <select style="width:99%;" id="flowphase" onchange="changeValue(this,'flowphase')"><option value="0">请选择</option></div></td>
				</tr>
				<tr>
					<td><div>节点类型</div></td>
					<td><div> <select style="width:99%;" id="nodetype" onchange="changeValue(this,'nodetype')"><option value="B">首节点</option><option selected value="C">一般</option><option value="D">分支</option><option value="E">汇聚</option><option value="H">并行</option><option value="G">多实例节点</option><option value="R">游离分支</option></select></div></td>
				</tr>
				<tr>
					<td><div>任务分配机制</div></td>
					<td width="67%"><div> <select style="width:99%;" id="opttype" onchange="setOptType(this)"><option value="D">自动执行</option><option value="E">哑元</option><option value="A" selected>一般</option><option value="S">子流程</option><option value="B">抢先机制</option><option value="C">多人操作</option></div></td>
				</tr>
				<tr id="business" style="display:none;">
					<td><div>业务代码</div></td>
					<td><div><select style="width:99%;" id="optcode" onchange="changeValue(this,'optcode')"><option selected='selected'>请选择</option></select></div></td>
				</tr>
				<tr id="childNode" style="display:none;">
					<td><div>子节点流程</div></td>
					<td><div><select style="width:99%;" id="subwfcode" onchange="changeValue(this,'subwfcode')"><option>请选择</option></select></div></td>
				</tr>
				<tr id="nodeEvent">
					<td><div>节点事件Bean</div></td>
					<td><div><input type="text" id="optbean" value="" style="width:99%;" onchange="changeValue(this,'optbean')"/></div></td>
				</tr>				
				<tr>
					<td><div>操作参数</div></td>
					<td><div><input type="text" id="optparam" value="" style="width:99%;" onchange="changeValue(this,'optparam')"/></div></td>
				</tr>
				<tr>
					<td><div>机构表达式</div></td>
					<td><div><input type="text" id="unitexp" value="P" style="width:99%;" onchange="changeValue(this,'unitexp')"/></div></td>
				</tr>
				<tr>
					<td><div>角色类别</div></td>
					<td><div><select style="width:99%;" id="roletype" onchange="setRoleType(this)"><option value="">请选择</option><option value="bj">办件角色</option><option value="gw">岗位角色</option><option value="xz">行政角色</option><option value="en">权限引擎</option></select></div></td>
				</tr>
				<tr>
					<td><div id="roleName" >角色代码</div></td>
					<td><div><select style="width:99%;" id="rolecode" onchange="changeValue(this,'rolecode')"><option value="">请选择</option></select></div></td>
				</tr>
				<tr>
					<td><div>风险点设置</div></td>
					<td><div><input type="text" value="" id="riskinfo" onchange="changeValue(this,'riskinfo')" style="width:70%;" /><input name="" type="button" value="选择" onclick="addRiskInfo()" style="width:40px;height:20px;line-height:20px;" /></div></td>
				</tr>
				<tr>
					<td><div>是否计时</div></td>
					<td><div><select style="width:99%;" id="isaccounttime" onchange="changeValue(this,'isaccounttime')"><option value="H">仅环节计时</option><option value="F">不计时</option><option selected value="T">计时</option></select></div></td>
				</tr>
				<tr>
					<td><div>期限类别</div></td>
					<td><div><select style="width:99%;" id="timeLimitType" onchange="changeValue(this,'timeLimitType')"><option value="I">默认</option><option value="N">无期限</option><option value="F">每实例固定期限</option><option value="C">节点固定期限</option></select></div></td>
				</tr>
				<tr>
					<td><div>继承期限</div></td>
					<td><div><select style="width:99%;" id="inheritType" onchange="setInheritType(this)"><option value="0" selected>不继承</option><option value="1">继承前节点</option><option value="2">继承指定节点</option></select></div></td>
				</tr>
				<tr style="display:none;" id="inheritCode">
					<td><div>继承节点代码</div></td>
					<td><div><input type="text" id="inheritNodeCode" value="" style="width:99%;" onchange="changeValue(this,'inheritNodeCode')"/></div></td>
				</tr>
				<tr>
					<td><div>期限设定</div></td>
					<td><div><input type="text" id="timelimit" value="" style="width:99%;" onchange="changeValue(this,'timeLimit')"/></div></td>
				</tr>
				<tr>
					<td><div>过期处理方法</div></td>
					<td><div><select style="width:99%;"  id="expireopt" onchange="changeValue(this,'expireopt')"><option value="N">通知</option><option value="O">不处理</option><option value="S">挂起</option><option value="E">终止</option><option value="C">完成</option></select></div></td>
				</tr>
				<tr>
					<td><div>是否主干节点</div></td>
					<td><div><select style="width:99%;" id="isTrunkLine" onchange="changeValue(this,'isTrunkLine')"><option value="T">是</option><option selected value="F">否</option></select></div></td>
				</tr>
				<tr>
					<td><div style="height:43px;line-height:43px;">说明</div></td>
					<td><div><textarea id="desc" onchange="changeValue(this,'desc')" style="height:40px; width:99%;margin-top:4px;padding:3px 0 3px 3px;"></textarea></div></td>
				</tr>
			</table>
        </div>
		<!-- 线属性 -->
        <div id="isline">
			<table width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td width="32%"><div>名称</div></td>
					<td width="67%"><div><input id="linename" onchange="changeValue(this,'linename')" type="text" value="" style="width:99%;"  /></div></td>
				</tr>
				<tr>
					<td><div style="height:68px;line-height:68px;">条件</div></td>
					<td><div><textarea id="cond" onchange="changeValue(this,'cond')" style="height:40px; width:99%;margin-top:4px;padding:3px 0 3px 3px;"></textarea><input type="button" style="padding:2px 6px 2px 6px;" value="编辑条件" onclick="addCond();"/></div></td>
				</tr>
				<tr>
					<td><div>期限类别</div></td>
					<td><div><select style="width:99%;" id="linetimeLimitType" onchange="changeValue(this,'timeLimitType')"><option value="I">默认</option><option value="N">无期限</option><option value="F">每实例固定期限</option><option value="C">节点固定期限</option></select></div></td>
				</tr>
				<tr>
					<td><div>继承期限</div></td>
					<td><div><select style="width:99%;" id="lineinheritType" onchange="setInheritType(this)"><option value="0" selected>不继承</option><option value="1">继承前节点</option><option value="2">继承指定节点</option></select></div></td>
				</tr>
				<tr style="display:none;" id="lineinheritCode">
					<td><div>继承节点代码</div></td>
					<td><div><input type="text" id="lineinheritNodeCode" value="" style="width:99%;" onchange="changeValue(this,'inheritNodeCode')"/></div></td>
				</tr>
				<tr>
					<td><div>期限设定</div></td>
					<td><div><input type="text" id="linetimeLimit" value="" style="width:99%;" onchange="changeValue(this,'timeLimit')" /></div></td>
				</tr>
				<tr>
					<td><div style="height:43px;line-height:43px;">流转描述</div></td>
					<td><div><textarea id="linedesc" onchange="changeValue(this,'desc')" style="height:40px; width:99%;margin-top:4px;padding:3px 0 3px 3px;"></textarea></div></td>
				</tr>
			</table>
        </div>
        <!-- 圆属性 -->
        <div id="iscircle">
			<table width="100%" cellpadding="0" cellspacing="0" style="BORDER-COLLAPSE:collapse;">
				<tr>
					<td width="32%"><div>名称</div></td>
					<td width="67%"><div><input id="circle_nodename" onchange="changeCirValue(this,'circle_nodename')" type="text" value="" style="width:99%;"  /></div></td>
				</tr>
				<tr>
					<td><div>环节代码</div></td>
					<td><div><input type="text" id="circle_nodecode" value="" style="width:99%;" onchange="changeCirValue(this,'circle_nodecode')"/></div></td>
				</tr>
			</table>
        </div>
    </div>
</div>
<div id="canvas"></div>
<div id="lineCon"></div>
<script type="text/javascript" src="<%=path %>/page/workflow/svgworkflow/svg.js"></script>
<script type="text/javascript" src="<%=path %>/page/workflow/svgworkflow/drag.js"></script>
<script type="text/javascript" src="<%=path %>/page/workflow/svgworkflow/moveTip.js"></script>
<script type="text/javascript" src="<%=path %>/page/workflow/svgworkflow/moveCircle.js"></script>
<script type="text/javascript" src="<%=path %>/page/workflow/svgworkflow/addPointMove.js"></script>
<script type="text/javascript" src="<%=path %>/page/workflow/svgworkflow/redo_undo.js"></script>
<script type="text/javascript" src="<%=path%>/scripts/jquery-1.6.min.js" ></script>
<script type="text/javascript">
//startup
var _TREE,_ZOOM = 1;
var Data,changeflag = false;
var xml = $("#xml").attr("value");
var path='<%=path%>';
var flowCode='${flowCode}';
var version='${version}';
var optid='${object.optId}';
var rectWidth = 100;
var rectHeight = 50;
//退出编辑
	function closeWindow() {
		if(confirm("确定要退出本次编辑吗？")) {
			//window.opener=null;
			parent.$.history.back(window.frameElement);
			//window.history.go(-1);
		}
	}

//流程图校验
function onValidate() {
	var obj = g("s3").childNodes;
	var s = validate(obj);
	if(s=="")
	alert("校验完成，这是一个合法的流程图！");                                                
	else
	alert(s);
}

//设置节点属性内容
function changeValue(item,id){
	if(changeflag){
		return false;
	}
	if(id=="nodename"){
		var _old = g(o).getAttribute("title");
		SVG.get(o).attr({"title":item.value});
		setValue(g(SVG.get(o).attr("textID")),dealStr(SVG.get(o).attr("title"),rectWidth));
		g(o).setAttribute("title",SVG.get(o).attr("title"));
	}
	else if(id=="linename"){
		var _old = g(o).getAttribute("title");
		g("lab"+o).innerHTML = item.value;
		g(o).setAttribute("title",item.value);
	}
	else{
	   var _old = g(o).getAttribute(id);
	   g(o).setAttribute(id,item.value);	  		
	}
	pushLog("editproc",{"ID":o,"param":id,"_new":item.value,"_old":_old});
	changeflag = false;
}

//设置圆节点属性内容
function changeCirValue(item,id){
	if(changeflag){
		return false;
	}
	if(id=="circle_nodename"){
		SVG.get(o).attr({"title":item.value});
		setValue(g(SVG.get(o).attr("textID")),dealStr(SVG.get(o).attr("title"),rectWidth));
		g(o).setAttribute("title",SVG.get(o).attr("title"));
	}
	else{
	   g(o).setAttribute("nodecode",item.value);	  		
	}
	changeflag = false;
}

 function setInheritType(item){
	 if(SVG.get(o).attr("inheritType")==item.value){
			return;
		}
	 pushLog("editproc",{"ID":o,"param":"inheritType","_new":item.value,"_old":g(o).getAttribute("inheritType")});
	 g(o).setAttribute("inheritType",item.value);
	 if(item.value=='2'){
		 if(g(o).nodeName=='polyline'){
			 $('#lineinheritCode').show();
		 }
		 else{
		     $('#inheritCode').show();			 
		 }
	 }
	 else{
		 if(g(o).nodeName=='polyline'){
			 $('#lineinheritCode').hide();
		 }
		 else{
		    $('#inheritCode').hide();			 
		 }
	 }
 }
 
//设置角色类别并实现值改变引起的联动效果
function setRoleType(item){
	if(SVG.get(o).attr("roletype")==item.value){
		return;
	}

	//清空角色代码下拉列表中的内容
	 $("#rolecode").empty();
	pushLog("editproc",{"ID":o,"param":"roletype","_new":item.value,"_old":g(o).getAttribute("roletype")});
	g(o).setAttribute("roletype",item.value);
	//从DATA中取值重新生成下拉列表
	if(item.value!="en"){
	   
		$("#roleName").replaceWith("<div id='roleName'>角色代码</div>");
		$("#PowerExp").replaceWith('<select id="rolecode"  onchange="changeValue(this,\'rolecode\');"  style="width:86%;">');
		$("#rolecode").append($("<option  value='0' selected='selected'>请选择</option>"));
	if(item.value=="gw"){
		for(var k in Data.gw)
		{	
			$("#rolecode").append($("<option  value='"+k+"'>"+Data.gw[k]+"</option>"));	
		}
	}
	if(item.value=="xz"){
		for(var k in Data.xz)
		{	
			$("#rolecode").append($("<option  value='"+k+"'>"+Data.xz[k]+"</option>"));	
		}
	}
   if(item.value=="bj"){
		for(var k in Data.bj)
		{	
			$("#rolecode").append($("<option  value='"+k+"'>"+Data.bj[k]+"</option>"));	
		}
	}
   g(o).setAttribute("rolecode","0");   
  }
	else{
		$("#roleName").replaceWith("<div id='roleName'>权限表达式</div>");
		$("#rolecode").replaceWith('<input type="text" id="PowerExp" onchange="changeValue(this,\'powerexp\');" value="'+SVG.get(o).attr("powerexp")+'"style="width:86%;" >');
	}
}

//设置任务分配机制并实现值改变时引起的联动效果
function setOptType(item){
	if(SVG.get(o).attr("opttype")==item.value){
		return;
	}
	pushLog("editproc",{"ID":o,"param":"opttype","_new":item.value,"_old":g(o).getAttribute("opttype")});
	g(o).setAttribute("opttype",item.value);
	//由操作类型引起的判断
	if(item.value=="D"){//自动流程节点的时候
		$("#business").hide();
		$("#childNode").hide();
		//$("#nodeEvent").show();
	}
	else if(item.value=="S"){//子流程节点的时候
		$("#business").hide();
		//$("#nodeEvent").hide();
		$("#childNode").show();
	}
	else{//正常的时候
		$("#business").show();
		//$("#nodeEvent").hide();
		$("#childNode").hide();
	}
}

//线节点属性栏编辑条件选择框
function addCond(){
	var condvalue=$("#cond").attr("value");
	var myCond=window.showModalDialog(path+"/page/workflow/addCond.jsp?optid="+optid,condvalue,"dialogHeight:   500px;   dialogWidth:   600px;   edge:   Raised;   center:   Yes;   help:   No;   resizable:   no;   status:   no; ");
	if(myCond){
		g("cond").value=myCond.cond;
		pushLog("editproc",{"ID":o,"param":"cond","_new":myCond.cond,"_old":g(o).getAttribute("cond")});
		g(o).setAttribute("cond",myCond.cond);
	}
}

//风险点设置
function addRiskInfo(){
	var riskinfo=$("#riskinfo").attr("value");
	var myriskinfo=window.showModalDialog(path+"/powerruntime/riskInfo!listSelect.do?riskid="+riskinfo+"&fromjs=1",null,"dialogHeight:   700px;   dialogWidth:   700px;   edge:   Raised;   center:   Yes;   help:   No;   resizable:   no;   status:   no; ");	
	if(myriskinfo){	
		$("#riskinfo").attr("value",myriskinfo.riskid);
		pushLog("editproc",{"ID":o,"param":"riskinfo","_new":myriskinfo.riskid,"_old":g(o).getAttribute("riskinfo")==null?"":g(o).getAttribute("riskinfo")});
		g(o).setAttribute("riskinfo",myriskinfo.riskid);
	}
}

//获取节点内容
function nodeValue(o,nodeName){
	if(o.getElementsByTagName(nodeName)[0]){
		if(o.getElementsByTagName(nodeName)[0].textContent){
			return o.getElementsByTagName(nodeName)[0].textContent;
		}else{
			return o.getElementsByTagName(nodeName)[0].text;	
		}
	}
}
//px pt 转换
function changePt(p){
	var point = p.split(","),s;
	
	for( var i=0;i<point.length;i++ ){
		if(i!=0 && i%2==0){ 
			s = s+" "+Math.round(parseFloat(point[i])*1.333);
		}else if(i==0){
			s = Math.round(parseFloat(point[i])*1.333);
		}else{
			s = s+","+Math.round(parseFloat(point[i])*1.333);
		}
	}
	return s;
}
//px pt 转换
function changePx(p){
	var point = p.split(/[ ,]+/),s = "";
	
	for( var i=0;i<point.length;i++ ){
		if(s=="")
			{
			s = Math.round(parseFloat(point[i])/1.33)+"pt";
			}
		else
			{
			s = s+","+Math.round(parseFloat(point[i])/1.33)+"pt";			
			}
	}
	return s;
}
//获取节点内容
function getValue(o,nodeName){
	if(o.text!=undefined){
		return o.text;
	}else{
		return o.textContent;
	}
}
//获取节点属性内容
function attrValue(o,nodeName,attrName){
	return o.getElementsByTagName(nodeName)[0].getAttribute(attrName);	
}
//添加样式集合
var addStyle = function(o,obj){
	if(!o) return false;
	if( (typeof obj) != "object" ) return false;
	for( var able in obj ){
		o.style[able] = obj[able];
	}
}

//给节点添加内容，这里兼容了IE9  和chrome
function setValue(o,content){
	if(o.text){
		o.text = content;
	}else{
		o.textContent = content;	
	}
}

//名称:createProcTypeOption
//说明:ajax与后台交互取数据
//参数:无
//作者:xc
//时间:2011-11-9

function getData(){

	
	$.ajax({
		type:"POST",
		url:"<%=path%>/sampleflow/sampleFlowDefine!getdataMap.do?flowCode=${flowCode}",
		//data:params,
		dataType:"json",
		async: false,
		success:function(data){	
			//alert(data);
			Data=jQuery.parseJSON(data);
			//alert(Data.OptType.A);
		},
		error:function(){
			alert("失败");
		}
	});
	

}

//给节点添加属性
var addNode = function(o,obj){
	if(!o) return false;
	if( (typeof obj) != "object" ) return false;
	for( var able in obj ){
		o.setAttribute(able,obj[able]);
	}
}

//获取连线开始过程的四个坐标
function getPoint(pro){
	var x,y,w,h,left,right,top,bottom,pointArray = new Array, points;
	if(pro.type=="rect"){
		x = pro.x(),y=pro.y();
		w = pro.attr("width");
		h = pro.attr("height");
		left = [x,y+h/2];
		right = [x+w,y+h/2];
		top = [x+w/2,y];
		bottom = [x+w/2,y+h];
	}else if(pro.type=="polygon"){
		points = pro.attr("points").split(" ");
		
		for( var i=0,len=points.length;i<len;i++ ){
			var cp = points[i].split(",");
			pointArray.push([cp[0],cp[1]]);	
		}
		top = pointArray[2];
		right = pointArray[1];
		bottom = pointArray[0];
		left = pointArray[3];
	}else{
		x = pro.x(),y=pro.y();
		w = h = parseInt(pro.attr("rx"))*2;
		left = [x,y+h/2];
		right = [x+w,y+h/2];
		top = [x+w/2,y];
		bottom = [x+w/2,y+h];
	}
	return {L:left,T:top,R:right,B:bottom};
}

//获取连线末过程的四个坐标
function getEndPoint(pro){
	var x,y,w,h,left,right,top,bottom,pointArray = new Array, points;
	if(pro.type=="rect"){
		x = pro.x(),y=pro.y(),
		w = pro.attr("width"),
		h = pro.attr("height"),
		left = [x-9,y+h/2],
		right = [x+w+9,y+h/2],
		top = [x+w/2,y-9],
		bottom = [x+w/2,y+h+9];
	}else if( pro.type=="polygon" ){
		points = pro.attr("points").split(" ");
		
		for( var i=0,len=points.length;i<len;i++ ){
			var cp = points[i].split(",");
			pointArray.push([cp[0],cp[1]]);	
		}
		top = pointArray[2];
		right = pointArray[1];
		bottom = pointArray[0];
		left = pointArray[3];
	}else{
		x = pro.x(),y=pro.y();
		w = h = parseInt(pro.attr("rx"))*2;
		left = [x-9,y+h/2],
		right = [x+w+9,y+h/2],
		top = [x+w/2,y-9],
		bottom = [x+w/2,y+h+9];	
	}
	return {L:left,T:top,R:right,B:bottom};
}

//矩形中心点
function getRectCenter(o){
	var x,y,w,h;
	x = o.x();
	y = o.y();
	w = parseInt(o.attr("width"));
	h = parseInt(o.attr("height"));
	return {x:x+(w/2),y:y+(h/2)};
}

//处理字串方法
String.prototype.trim = function(){
	return this.replace(/(^\s*)|(\s*$)/g,"");	
}
//截取多余的字串
function dealStr(str,wid){
	var length;
	if(!wid){
		length = 5;
	}
	else{
		length = parseInt(wid)/15;
	}
	if(str.length==0){ return ""; }
	else{
		if(str.trim().length>length){
			return str.substr(0,length)+"...";
		}else{
			return 	str;
		}
	}
}

// 画菱形的4个点
function drawPolygon(point){
	var p = new Array;
	p[0] = [point[0],point[1]+(rectHeight/2)];
	p[1] = [point[0]+(rectWidth/2),point[1]];
	p[2] = [point[0],point[1]-(rectHeight/2)];
	p[3] = [point[0]-(rectWidth/2),point[1]];
	return p.join(" ");
}

//使线的末点坐标和鼠标的末点坐标不重合，便于获取鼠标按在某个过程上，以便获取过程的一些参数
function p(x1,y1,x2,y2){
	if( x1<x2 ){
		x2 = x2-1;
	}else if(x1>x2){
		x2 = x2+1;
	}
	if( y1<y2 ){
		y2 = y2-1;
	}else if(y1>y2){
		y2 = y2+1;
	}
	return {x:x2,y:y2};
}

//格式化线的位置 此方法适合于只有两个点的直线，如果是多点就不合适
function formatLine(pocBegin,pocEnd){
	var F1 = getPoint(pocBegin),
		F2 = getEndPoint(pocEnd),
		w = 100,
		h = 50,
		p1,p2,x1,x2,y1,y2;
	
	if( pocBegin.type=="rect" || pocBegin.type=="ellipse" ){
		x1 = pocBegin.x();
		y1 = pocBegin.y();
	}else if( pocBegin.type=="polygon" ){
		x1 = parseInt(pocBegin.attr("getX"))-50;
		y1 = parseInt(pocBegin.attr("getY"))-25;
	}
	
	if( pocEnd.type=="rect" || pocEnd.type=="ellipse" ){
		x2 = pocEnd.x();
		y2 = pocEnd.y();
	}else if( pocEnd.type=="polygon" ){
		x2 = parseInt(pocEnd.attr("getX"))-50;
		y2 = parseInt(pocEnd.attr("getY"))-25;
	}
		
	if(x1+w+50<x2){
		if(y1+h+50<y2){
			p1 = F1.R;
			p2 = F2.T;
		}else if(y1-h-50>y2){
			p1 = F1.R;
			p2 = F2.B;
		}else{
			p1 = F1.R;
			p2 = F2.L;
		}
	}else if(x1-w-50>x2){
		if(y1+h+50<y2){
			p1 = F1.L;
			p2 = F2.T;
		}else if(y1-h-50>y2){
			p1 = F1.L;
			p2 = F2.B;
		}else{
			p1 = F1.L;
			p2 = F2.R;
		}
	}else{
		if(y1+h<y2){
			p1 = F1.B;
			p2 = F2.T;
		}else if(y1-h>y2){
			p1 = F1.T;
			p2 = F2.B;
		}
	}
	return {p1:p1,p2:p2};
}

//折线工具 添加节点 
function addPolylinePoint(line,newPoint){
	var pointArray = new Array, points = line.getAttribute("points").split(" "),
		flagX,flagY,newPosition,extraPoint,newPointArray=new Array;
	
	for( var i=0,len=points.length;i<len;i++ ){
		var cp = points[i].split(",");
		pointArray.push([cp[0],cp[1]]);	
	}
	
	for( var j=0,jLen=pointArray.length;j<jLen-1;j++ ){
		flagX = (( newPoint[0]>=pointArray[j][0] && newPoint[0]<=pointArray[j+1][0] ) || ( newPoint[0]<=pointArray[j][0] && newPoint[0]>=pointArray[j+1][0] ) || (pointArray[j][0]==pointArray[j+1][0]&&Math.abs(newPoint[0]-pointArray[j][0])<5) );
		flagY = (( newPoint[1]>=pointArray[j][1] && newPoint[1]<=pointArray[j+1][1] ) || ( newPoint[1]<=pointArray[j][1] && newPoint[1]>=pointArray[j+1][1] ) || (pointArray[j][1]==pointArray[j+1][1]&&Math.abs(newPoint[1]-pointArray[j][1])<5) );
		if( flagX && flagY ){
			newPosition=j+1;
			break;
		}
	}
	
	for( var h=0,hLen=pointArray.length;h<hLen;h++ ){
		if(h==newPosition) newPointArray.push(newPoint[0]+","+newPoint[1]);
		newPointArray.push(pointArray[h][0]+","+pointArray[h][1]);
	}
	
	line.setAttribute("points",newPointArray.join(" "));
	return newPointArray.join(" ");
	
}

//拖动某一节点变化位置 n为变化的第几个节点【重要】
function changePolylinePoint(line,point,n,points){
	var pointArray = new Array,newPointArray = new Array;
	var ps = points.split(" ");
	for( var i=0,len=ps.length;i<len;i++ ){
		var cp = ps[i].split(",");
		pointArray.push([cp[0],cp[1]]);	
	}
	for( var h=0,hLen=pointArray.length;h<hLen;h++ ){
		if(h==n) newPointArray.push(point[0]+","+point[1]);
		newPointArray.push(pointArray[h][0]+","+pointArray[h][1]);
	}
	//pointArray[n]=point[0]+","+point[1];
	line.setAttribute("points",newPointArray.join(" "));
	line.removeAttribute("marker-end");
}

//拖动某一节点变化位置 n为变化的第几个节点【重要】
function dragPolylinePoint(line,point,n,points){
	var pointArray = new Array;
	var ps = points.split(" ");
	for( var i=0,len=ps.length;i<len;i++ ){
		var cp = ps[i].split(",");
		pointArray.push([cp[0],cp[1]]);	
	}
	pointArray[n]=point[0]+","+point[1];
	line.setAttribute("points",pointArray.join(" "));
	line.removeAttribute("marker-end");
}

//删除线上指定节点
function deletePoint(line,n){
	//var n = getcurPoint(line,point,line.getAttribute("points")),
	var	pointArray = new Array,
		points = line.getAttribute("points").split(" ");		
	for( var i=0,len=points.length;i<len;i++ ){
		var cp = points[i].split(",");
		pointArray.push([cp[0],cp[1]]);	
	}	
	pointArray.splice(n,1);
	line.setAttribute("points",pointArray.join(" "));
}

//删除选中添加的节点
function deleteP(line,point){
	var pointArray = new Array,
		points = line.getAttribute("points").split(" ");
		
	for( var i=0,len=points.length;i<len;i++ ){
		var cp = points[i].split(",");
		pointArray.push([cp[0],cp[1]]);	
	}
	for(var h=0,hLen=pointArray.length;h<hLen;h++ ){
		if(Math.abs(point[0]-pointArray[h][0])<10&&Math.abs(point[1]-pointArray[h][1])<10){
			var circle = gCircle.circle(8).cx(Number(pointArray[h][0])-6).cy(Number(pointArray[h][1])-6).stroke({color:"blue"}).fill("blue").attr({"lineID":line.getAttribute("id")});	
			//if(line.getAttribute("cricleID")){
				//var cricleID = line.getAttribute("cricleID");
				//line.setAttribute("cricleID",cricleID+","+circle.attr("id"));
			//}else{
				line.setAttribute("cricleID",circle.attr("id"));
			//}
			return false;
		}
	}
	return true;
}

//得到上一方法的 n
function getcurPoint(line,point,newPoints){
	var pointArray = new Array, ps = newPoints.split(" ");
	
	for( var i=0,len=ps.length;i<len;i++ ){
		var cp = ps[i].split(",");
		pointArray.push([cp[0],cp[1]]);	
	}
	
	for( var h=0,hLen=pointArray.length;h<hLen;h++ ){
		if( Math.abs(parseInt(pointArray[h][0])-parseInt(point[0]))<2 && Math.abs(parseInt(pointArray[h][1])-parseInt(point[1]))<2 ){
			return h;
			break;
		}
	}
}

//初始化svg 和一些全局参数
if (SVG.supported) {
	var c = SVG("canvas"),
	    gLine = c.group(),
		gShape = c.group(),
		gCircle = c.group(),
		gText = c.group(),
		gInnerLine = c.group(),
		marker = c.marker(),
		markerGreenElse = c.marker(),
		markerBlue = c.marker(),
		markerGreen = c.marker();
	var o_filter = document.createElementNS(SVG.ns, "filter");
	var o_feOffset = document.createElementNS(SVG.ns, "feOffset");
	var o_feGaussianBlur = document.createElementNS(SVG.ns, "feGaussianBlur");
	var o_feBlend = document.createElementNS(SVG.ns, "feBlend");
	o_feOffset.setAttribute("result","offOut");
	o_feOffset.setAttribute("in","SourceAlpha");
	o_feOffset.setAttribute("dx",6);
	o_feOffset.setAttribute("dy",6);
	o_feGaussianBlur.setAttribute("result","blurOut");
	o_feGaussianBlur.setAttribute("in","offOut");
	o_feGaussianBlur.setAttribute("stdDeviation",4);
	o_feBlend.setAttribute("in","SourceGraphic");
	o_feBlend.setAttribute("in2","blurOut");
	o_feBlend.setAttribute("mode","normal");
	o_filter.setAttribute("x",0);
	o_filter.setAttribute("y",0);
	o_filter.setAttribute("width","200%");
	o_filter.setAttribute("height","200%");
	o_filter.setAttribute("id","filter");
	o_filter.appendChild(o_feOffset);
	o_filter.appendChild(o_feGaussianBlur);
	o_filter.appendChild(o_feBlend);
	g("s1").appendChild(o_filter);
	//箭头的三种颜色  可能有更好的方式来做箭头，这个只是一个简单额三角
	marker.attr({"viewBox":"0 0 8 8","refX":6,"refY":4,"markerUnits":"strokeWidth","markerWidth":5,"markerHeight":5,"orient":"auto"});
	marker.path().attr({"d":"m 0 0 L 7 4 L 0 7 z"}).fill("#0000ff");
	
	markerGreenElse.attr({"viewBox":"0 0 8 8","refX":0,"refY":4,"markerUnits":"strokeWidth","markerWidth":5,"markerHeight":5,"orient":"auto"});
	markerGreenElse.path().attr({"d":"M 0 0 L 7 4 L 0 7 z"}).fill("#18b216");
	
	markerBlue.attr({"viewBox":"0 0 8 8","refX":0,"refY":4,"markerUnits":"strokeWidth","markerWidth":5,"markerHeight":5,"orient":"auto"});
	markerBlue.path().attr({"d":"M 0 0 L 7 4 L 0 7 z"}).fill("#0000fe");
	
	markerGreen.attr({"viewBox":"0 0 8 8","refX":6,"refY":4,"markerUnits":"strokeWidth","markerWidth":5,"markerHeight":5,"orient":"auto"});
	markerGreen.path().attr({"d":"M 0 0 L 7 4 L 0 7 z"}).fill("#18b217");
	
	var canvas = g("canvas"),o,flag=1,linePoint,image="default",selectTag,moveflag =1;
}

//画线工具栏操作
function drawLine(e){
	if(e.button!=0){
		return;
	}
	var e = window.event || e, target = e.srcElement || e.target, pL1,p1,targetEnd;
    if(target.nodeName=="text"){
    	target = g(target.getAttribute("shapeID"));
    }
	function lineMove(e){
		var e = window.event || e;
		var pL2 = [(e.clientX+document.body.scrollLeft)/_ZOOM,(e.clientY+document.body.scrollTop)/_ZOOM];
			//newPoint = p( pL1[0],pL1[1],pL2[0],pL2[1] );
		pl.attr({points:pL1[0]+","+pL1[1]+" "+pL2[0]+","+pL2[1]});
		g(pl.attr("id")).removeAttribute("marker-end");			

	}
	
	function lineStop(e){
		var e = window.event || e, targetE = e.srcElement || e.target;
		if(targetE.nodeName=="text"){
	    	targetE = g(targetE.getAttribute("shapeID"));
	    }
		removeEvent(document,"mouseup",lineStop);
		removeEvent(document,"mousemove",lineMove);
		if( target.nodeName=="ellipse" && target.getAttribute("from") ){
			alert("错误原因：\n\n此过程已经作为一次起始过程连线！");
			pl.remove();
			pl=null;
			return false;
		}
		
		if(target.nodeName=="ellipse"&&target.getAttribute("id")=="end"){
			alert("错误原因：\n\n结束过程不可以作为起始过程！");
			pl.remove();
			pl=null;
			return false;
		}
		
		if(targetE.nodeName=="ellipse"&&targetE.getAttribute("id")=="begin"){
			alert("错误原因：\n\n开始过程不可以作为回流过程！");
			pl.remove();
			pl=null;
			return false;
		}
		
		if( target.nodeName=="ellipse" && targetE.nodeName=="ellipse"&&target.getAttribute("id") ){
			alert("错误原因：\n\n流程不符合逻辑！");
			pl.remove();
			pl=null;
			return false;
		}
		
		if( targetE.nodeName!="rect" && targetE.nodeName!="polygon" && targetE.nodeName!="ellipse"){
			alert("错误原因：\n\n末点必须是过程！");
			pl.remove();
			pl=null;
			return false;
		}
		
		if(targetE.id == target.id ){
			alert("错误原因：\n\n起末不能是同一个过程！");
			pl.remove();
			pl=null;
			return false;
		}
		
		if(SVG.get(target.id).attr("from")){
			SVG.get(target.id).attr({"from":SVG.get(target.id).attr("from")+','+pl.attr("id")});
		}else{
			SVG.get(target.id).attr({"from":pl.attr("id")});
		}
		if(SVG.get(targetE.id).attr("to")){
			SVG.get(targetE.id).attr({"to":SVG.get(targetE.id).attr("to")+','+pl.attr("id")});
		}else{
			SVG.get(targetE.id).attr({"to":pl.attr("id")});
		}
		var FP = formatLine(SVG.get(target.id),SVG.get(targetE.id));
		if(FP["p1"]){
		      pl.attr({points:FP["p1"][0]+","+FP["p1"][1]+" "+FP["p2"][0]+","+FP["p2"][1],"from":target.id,"to":targetE.id});			
		}
		SVG.get(targetE.id).attr({"line":pl.id});
		
		//线条的文字说明
		g("lineCon").innerHTML += "<div class='step' id='lab"+pl.attr("id")+"'>流程step</div>";
		addStyle(g("lab"+pl.attr("id")),{"left":pL1[0]+"px","top":pL1[1]+"px"});
		pl.attr({"title":g("lab"+pl.attr("id")).innerHTML,"labID":"lab"+pl.attr("id")});			
	    pl.attr({"marker-end":"url(#"+marker.attr("id")+")"});

		pushLog("addproc",{"ID":pl.attr("id"),"shapetype":"polyline","labID":"lab"+pl.attr("id"),"points":FP["p1"][0]+","+FP["p1"][1]+" "+FP["p2"][0]+","+FP["p2"][1],"left":pL1[0],"top":pL1[1],"from":target.id,"to":targetE.id,
			"timeLimitType":"","inheritType":"0","inheritNodeCode":"","timeLimit":"","cond":"","desc":"","title":"流程step"});
		if(e.stopPropagation){
			e.stopPropagation();
		}else{
			return false;	
		}
		
	}
	
	function lineDisplay(){
		if( flag==0 ){
			pL1 = [(e.clientX+document.body.scrollLeft)/_ZOOM,(e.clientY+document.body.scrollTop)/_ZOOM];	
			pl = gLine.polyline().stroke({ color:"#0000ff",width: 1.3 }).fill("none").attr({'transform':"","points":"0,0 0,0","marker-end":"url(#"+marker.attr("id")+")","title":"","cond":"","desc":"","timelimit":"","timeLimitType":"","inheritType":"0","inheritNodeCode":"","shapetype":"polyline"});
			addEvent(document,"mousemove",lineMove);
			addEvent(document,"mouseup",lineStop);
		}
	}
	return lineDisplay();
}

function drawRect(e){
	var e = window.event || e,target = e.srcElement || e.target,initP,rect;
	function rectMove(e){
		var e = window.event || e;
		var moveP = [(e.clientX+document.body.scrollLeft)/_ZOOM,(e.clientY+document.body.scrollTop)/_ZOOM];
		var deltaX = parseInt(moveP[0]-initP[0]);
		var deltaY = parseInt(moveP[1]-initP[1]);
		rect.attr({"width":deltaX});
		rect.attr({"height":deltaY});
	}
	function rectStop(e){
		var e = window.event || e;
		//removeEvent(canvas,"mousedown",drawRect);
		removeEvent(document,"mouseup",rectStop);
		removeEvent(document,"mousemove",rectMove);
		rectWidth = parseInt(rect.attr("width"));
		rectHeight = parseInt(rect.attr("height"));
		if(rectWidth<2){
			rect.remove();
			return false;
		}
		var text = gText.text("过程").x(rect.x()+5).y(rect.y()+rectHeight/2+6).attr({dx:rect.x()+rectWidth/2,"title":"过程","textWeight":"9pt", "strokeWeight":"1", "zIndex":"1","shapeID":rect.attr("id")}).font({family:"Arial",size:14,"text-anchor":"middle"}).fill("#00f");
		rect.attr({"textID":text.attr("id"),"title":"过程","filter":"url(#filter)"});
		if((e.clientY+document.body.scrollTop+20)>document.body.scrollHeight){
			$("#canvas").height(document.body.scrollHeight+20*_ZOOM);
		}
		pushLog("addproc",{"ID":rect.attr("id"),"textID":text.attr("id"),"text":"proc","shapetype":"roundrect","flowphase":"0","nodedesc":"", "nodetype":"C", "opttype":"A", "optcode":"", "optbean":"", "optparam":"", "subwfcode":"", "roletype":"0", "rolecode":"0", "isaccounttime":"F", "timeLimitType":"I","inheritType":"0","inheritNodeCode":"","timeLimit":"","isTrunkLine":"", "unitexp":"P", "powerexp":"", "expireopt":"", "desc":"","title":"过程",
			   "X":rect.attr("x"),"Y":rect.attr("y"),"width":rectWidth,"height":rectHeight});
		if(e.stopPropagation){
			e.stopPropagation();
		}else{
			return false;	
		}
	}
	function rectDisplay(){
		if(flag==2&&target.nodeName=="svg"){
		   initP = [(e.clientX+document.body.scrollLeft)/_ZOOM,(e.clientY+document.body.scrollTop)/_ZOOM];	
		   rect = gShape.rect(0,0).attr({rx:2,ry:2,"shapetype":"roundrect","flowphase":"0","nodedesc":"", "nodetype":"C", "opttype":"A", "optcode":"", "optbean":"", "optparam":"", "subwfcode":"", "roletype":"0", "rolecode":"0", "isaccounttime":"F", "timeLimitType":"I","inheritType":"0","inheritNodeCode":"","timeLimit":"","isTrunkLine":"", "unitexp":"P", "powerexp":"", "expireopt":"", "desc":""}).stroke({color:"#0000ff",width:1}).fill("#fff").x(initP[0]).y(initP[1]);
		   addEvent(document,"mousemove",rectMove);
		   addEvent(document,"mouseup",rectStop);			
		}
	}
	return rectDisplay();
}

//选择所画图形
function selectImage(e){
	var e = window.event || e, target = e.srcElement || e.target;
	switch(image){
		case "rect":
			if( target.nodeName == "svg" ){
				/* var rect = gShape.rect(100,40).attr({rx:2,ry:2,"shapetype":"roundrect","flowphase":"0","nodedesc":"", "nodetype":"C", "opttype":"A", "optcode":"", "optbean":"", "optparam":"", "subwfcode":"", "roletype":"0", "rolecode":"0", "isaccounttime":"F", "timeLimitType":"I", "timeLimit":"","isTrunkLine":"", "unitexp":"P", "powerexp":"", "expireopt":"", "desc":""}).stroke({color:"#0000ff",width:1}).fill("#fff").x(e.clientX+document.body.scrollLeft-50).y(e.clientY+document.body.scrollTop-20);
				var text = gText.text("过程").x(rect.x()+5).y(rect.y()+20+6).attr({dx:rect.x()+50,"title":"过程","textWeight":"9pt", "strokeWeight":"1", "zIndex":"1","shapeID":rect.attr("id")}).font({family:"Arial",size:14,"text-anchor":"middle"}).fill("#00f");
				rect.attr({"textID":text.attr("id"),"title":"过程"});
				if((e.clientY+document.body.scrollTop+20)>document.body.scrollHeight){
					$("#canvas").height(document.body.scrollHeight+20);
				} */
			   addEvent(target,"mousedown",drawRect);
			}
			break;
			
		case "line":	
				addEvent(target,"mousedown",drawLine);
			break;
/* 		case "polygon":
			if( target.nodeName == "svg" ){
				var pp = drawPolygon([e.clientX+document.body.scrollLeft,e.clientY+document.body.scrollTop]);
				var polygon = gShape.polygon(pp).fill("#fff").stroke({color:"#00f",width:1}).style({"fill-opacity":0}).attr({'transform':"",getX:e.clientX+document.body.scrollLeft,getY:e.clientY+document.body.scrollTop,"shapetype":"diamond","flowphase":"0","nodedesc":"", "nodetype":"C", "opttype":"A", "optcode":"", "optbean":"", "optparam":"", "subwfcode":"", "roletype":"0", "rolecode":"0", "isaccounttime":"F", "timeLimitType":"I", "timelimit":"","isTrunkLine":"", "unitexp":"P", "powerexp":"", "expireopt":"", "desc":""});
				var pText = gText.text("proc").x(e.clientX+document.body.scrollLeft).y(e.clientY+document.body.scrollTop+3).attr({dx:e.clientX+document.body.scrollLeft}).font({family:"Arial",size:14,"text-anchor":"middle"}).fill("#00f");
				polygon.attr({"textID":pText.attr("id"),"title":"过程","textWeight":"9pt", "strokeWeight":"1", "zIndex":"1"});
			}
			break; */
		
		default:break;
	}	
	
	
}
//画图的初始化操作
function init(e){
	var e = window.event || e, target = e.srcElement || e.target;
	if(target.nodeName=="text"){
		target = g(target.getAttribute("shapeID"));
	}
	if( (target.nodeName == "ellipse" && target.getAttribute("type")) || target.nodeName=="polygon" ){
		changeflag = true;
		if(g(o)){
			if( g(o).nodeName=="polyline" ){
				SVG.get(o).stroke({color:"#00f",width:1.3}).fill("none");
				SVG.get(o).attr({"marker-end":"url(#"+marker.attr("id")+")"});
			}
			else if(g(o).nodeName=="polygon" || g(o).nodeName=="rect"){
				if(target.nodeName == "ellipse"){
				}
				SVG.get(o).stroke({color:"#00f",width:1.3});
				if(g(o).getAttribute("lineID")){
					SVG.get(g(o).getAttribute("lineID")).stroke({color:"#00f",width:1.3});
				}
			}             
			else{
				if(g(o).nodeName=="ellipse"&&g(o).getAttribute("type")){
				    SVG.get(o).stroke({color:"#f00",width:1.3});
				    if(target.nodeName=="polygon"){
				    }
				}
				else{
					SVG.get(o).stroke({color:"#000",width:1.3}).fill("#fff");
				}
			}
			if(g("lab"+o)){
               g("lab"+o).style.background = "";				
			}
		}
		SVG.get(target.id).stroke({color:"#18b217",width:1.3});
		o = target.id;
		
		if(target.nodeName=="polygon"){
			rectWidth = g(target.id).getAttribute("width");
			rectHeight = g(target.id).getAttribute("height");
			//移动
			moveCircle(g(o));
			$("#iscircle").hide();
			g("ispro").style.display = "block";	
			bindToolBar();
		}else{
			$("#ispro").hide();
			$("#iscircle").show();
			bindCircle();
		}
		g("isline").style.display = "none";	
		if(target.nodeName == "ellipse"){
		  moveCircle(g(o));
		}
	}
	
	else if(target.nodeName == "rect"){
		changeflag = true;
		rectWidth = g(target.id).getAttribute("width");
		rectHeight = g(target.id).getAttribute("height");		
		if(g(o)){
			lastID = o;
			if( g(o).nodeName=="polyline" ){
				SVG.get(o).stroke({color:"#00f",width:1.3}).fill("none");
				SVG.get(o).attr({"marker-end":"url(#"+marker.attr("id")+")"});
			}
			else if(g(o).nodeName=="polygon" || g(o).nodeName=="rect"){
				SVG.get(o).stroke({color:"#00f",width:1.3});
				if(g(o).getAttribute("lineID")){
					SVG.get(g(o).getAttribute("lineID")).stroke({color:"#00f",width:1.3});
				}
			}
			else{
				if(g(o).nodeName=="ellipse"&&g(o).getAttribute("type")){
				    SVG.get(o).stroke({color:"#f00",width:1.3});				   
				}
				else{
					SVG.get(o).stroke({color:"#000",width:1.3}).fill("#fff");
				}
			}
			if(g("lab"+o)){
	               g("lab"+o).style.background = "";				
				}
		}
		
		SVG.get(target.id).stroke({color:"#18b217",width:1.3});
		if(g(target.id).getAttribute("lineID")){
			SVG.get(g(target.id).getAttribute("lineID")).stroke({color:"#18b217",width:1.3});
		}
		o = target.id;
		$("#iscircle").hide();
		g("ispro").style.display = "block";
		g("isline").style.display = "none";
		bindToolBar();
		//移动
		drag(g(o));	
	}
	
	else if( (target.nodeName == "polyline" || target.nodeName == "ellipse") && image != "line" && !target.getAttribute("type")){
		g("isline").style.display = "block";
		$("#iscircle").hide();
		g("ispro").style.display = "none";
		changeflag = true;
		if(g(o)){
			if( g(o).nodeName=="polyline" ){
				SVG.get(o).stroke({color:"#00f",width:1}).fill("none");
				SVG.get(o).attr({"marker-end":"url(#"+marker.attr("id")+")"});
			}
			else if(g(o).nodeName=="polygon" || g(o).nodeName=="rect"){
				SVG.get(o).stroke({color:"#00f",width:1.3});
				if(g(o).getAttribute("lineID")){
					SVG.get(g(o).getAttribute("lineID")).stroke({color:"#00f",width:1.3});
				}
			}
			else if(g(o).nodeName=="ellipse" && !target.getAttribute("type")){
				SVG.get(o).stroke({color:"#f00",width:1.3}).fill("#fff");
			}
			else{
				SVG.get(o).stroke({color:"#f00",width:1.3});
			}
			if(g("lab"+o)){
	               g("lab"+o).style.background = "";				
				}
		}
		o = target.id;
		if(g(o).nodeName=="ellipse"){
			SVG.get(o).stroke({color:"#f00",width:1.3}).fill("#ff0000");
			//drag(g(o));
		}
		else{			
			SVG.get(o).stroke({color:"#18b217",width:1.3});	
				SVG.get(o).attr({"marker-end":"url(#"+markerGreen.attr("id")+")"});
				g("lab"+o).style.background = "#ddd";
				bindLine();
				addPointMove(g(o));
		}		
	}
	
	else if(target.className=="step"){
		changeflag = true;
		target.style.background = "#ddd";
		if(g(o)){
			SVG.get(o).stroke({"color":"#00f",width:1.3});
			if(g(o).getAttribute("lineID")){
				SVG.get(g(o).getAttribute("lineID")).stroke({color:"#00f",width:1.3});
			}
			if(g(o).nodeName=="ellipse"){
				if(g(o).nodeName=="ellipse"&&g(o).getAttribute("type")){
				    SVG.get(o).stroke({color:"#f00",width:1.3});
				}
				else{					
					SVG.get(o).stroke({color:"#000",width:1.3}).fill("#fff");
				}
			}
			if(g(o).nodeName=="polyline"){
				SVG.get(o).attr({"marker-end":"url(#"+marker.attr("id")+")"});
			}
			if(g("lab"+o)&&g("lab"+o).style.background!=""&& target.id!=("lab"+o)){
				g("lab"+o).style.background = "";
			}
		}
		o=target.id.replace("lab",""); 
		SVG.get(o).stroke({"color":"#18b217",width:1.3}).attr({"marker-end":"url(#"+markerGreen.attr("id")+")"});
		moveTip( target,target );
		g("ispro").style.display = "none";
		g("isline").style.display = "block";
		$("#iscircle").hide();
		bindLine();
	}
	else{
		changeflag = false;
	}
}

//过程属性栏目 所有的操作属性都在这个方法里面
function bindToolBar(){
	//说明g(o)是选中的对象，o为全局变量
	g("nodename").value = SVG.get(o).attr("title");
	setValue(g(SVG.get(o).attr("textID")),dealStr(SVG.get(o).attr("title"),rectWidth));
	g(o).setAttribute("title",SVG.get(o).attr("title"));
	//节点类型转换
	var selectObj = g("nodetype");
	for(var i=0,len=selectObj.options.length;i<len;i++){
		if(selectObj.options[i].value==g(o).getAttribute("nodetype")){
			selectObj.options[i].selected = true;	
		}	
	}
	if (SVG.get(o).attr("nodecode")){
		g("nodecode").value = SVG.get(o).attr("nodecode")=="null"?"":SVG.get(o).attr("nodecode");
	}
	else{
		g("nodecode").value = "";
	}
	
	$('#flowphase').empty();
	$("#flowphase").append("<option  value='' selected='selected'>请选择</option>");
	for (var k in Data.FlowPhase) {	
		if(SVG.get(o).attr("flowphase")==k)
		{
		$("#flowphase").append("<option  value='"+k+"' selected='selected'>"+Data.FlowPhase[k]+"</option>");						 
		}
	else 
		{
		
		$("#flowphase").append("<option  value='"+k+"' >"+Data.FlowPhase[k]+"</option>");			
	   }
   }
	for(var i = 0;i < g("opttype").options.length;i++){
		if(g("opttype").options[i].value == SVG.get(o).attr("opttype")){
			g("opttype").options[i].selected = "selected";
			//由操作类型引起的判断
			if(SVG.get(o).attr("opttype")=="D"){//自动流程节点的时候
				$("#business").hide();
				$("#childNode").hide();
				//$("#nodeEvent").show();
			}
			else if(SVG.get(o).attr("opttype")=="S"){//子流程节点的时候
				$("#business").hide();
				//$("#nodeEvent").hide();
				$("#childNode").show();
			}
			else{//正常的时候
				$("#business").show();
				//$("#nodeEvent").show();
				$("#childNode").hide();
			}
		}
	}
	
	for(var i = 0;i < g("optcode").options.length;i++){
		g("optcode").remove(i);
	}
	$("#optcode").append("<option  value='' selected='selected'>请选择</option>");
	for (var k in Data.OptCode) {	
			if(SVG.get(o).attr("optcode")==k)
			{
			$("#optcode").append("<option  value='"+k+"' selected='selected'>"+Data.OptCode[k]+"</option>");						 
			}
		else 
			{
			
			$("#optcode").append("<option  value='"+k+"' >"+Data.OptCode[k]+"</option>");	
			
		}
	}
	g("optbean").value = SVG.get(o).attr("optbean");
	$("#subwfcode").empty();
	for (var k in Data.SubWfcode) {	
		if(SVG.get(o).attr("subwfcode")==k)
		{
		$("#subwfcode").append("<option  value='"+k+"' selected='selected'>"+Data.SubWfcode[k]+"</option>");						 
		}
	else 
		{	
		$("#subwfcode").append("<option  value='"+k+"' >"+Data.SubWfcode[k]+"</option>");		
        }
     } 
	g("optparam").value = SVG.get(o).attr("optparam");
	g("unitexp").value = SVG.get(o).attr("unitexp");
	g("riskinfo").value = SVG.get(o).attr("riskinfo")==undefined?"":SVG.get(o).attr("riskinfo");
	
	for(var i = 0;i < g("roletype").options.length;i++){
		if(g("roletype").options[i].value == SVG.get(o).attr("roletype")){
			g("roletype").options[i].selected = "selected";			
		}
	}
	
	$("#roleName").replaceWith("<div id='roleName'>角色代码</div>");
	$("#PowerExp").replaceWith('<select id="rolecode"  onchange="changeValue(this,\'rolecode\');"  style="width:86%;">');
	$("#rolecode").append($("<option  value='0' selected='selected'>请选择</option>"));
	if(SVG.get(o).attr("roletype")=="en"){
		$("#roleName").replaceWith("<div id='roleName'>权限表达式</div>");
		$("#rolecode").replaceWith('<input type="text" id="PowerExp" onchange="changeValue(this,\'powerexp\');" value="'+SVG.get(o).attr("powerexp")+'"style="width:86%;" >');
	}
	else{
		$("#rolecode").empty();
		for(var k in Data[SVG.get(o).attr("roletype")] )
		{
		
			if(SVG.get(o).attr("rolecode")==k)
				{
				$("#rolecode").append("<option  value='"+k+"' selected='selected' >"+Data[SVG.get(o).attr("roletype")][k]+"</option>");
				}							
			else
				{
				$("#rolecode").append("<option  value='"+k+"'>"+Data[SVG.get(o).attr("roletype")][k]+"</option>");
				}							
		}
	}
	
	
	for(var i = 0;i < g("isaccounttime").options.length;i++){
		if(g("isaccounttime").options[i].value == SVG.get(o).attr("isaccounttime")){
			g("isaccounttime").options[i].selected = "selected";
		}
	}
	
	for(var i = 0;i < g("timeLimitType").options.length;i++){
		if(g("timeLimitType").options[i].value == SVG.get(o).attr("timeLimitType")){
			g("timeLimitType").options[i].selected = "selected";
		}
	}
	
	for(var i = 0;i < g("inheritType").options.length;i++){
		if(g("inheritType").options[i].value == SVG.get(o).attr("inheritType")){
			g("inheritType").options[i].selected = "selected";
		}
	}
	if(SVG.get(o).attr("inheritType")=='2'){
		$('#inheritCode').show();
	}
	g("inheritNodeCode").value = SVG.get(o).attr("inheritNodeCode");
	g("timelimit").value = SVG.get(o).attr("timeLimit")==undefined?"":SVG.get(o).attr("timeLimit");
	
	for(var i = 0;i < g("expireopt").options.length;i++){
		if(g("expireopt").options[i].value == SVG.get(o).attr("expireopt")){
			g("expireopt").options[i].selected = "selected";
		}
	}
	
	for(var i = 0;i < g("isTrunkLine").options.length;i++){
		if(g("isTrunkLine").options[i].value == SVG.get(o).attr("isTrunkLine")){
			g("isTrunkLine").options[i].selected = "selected";
		}
	}
	
	g("desc").value = SVG.get(o).attr("desc");
	selectObj.onchange = function(){
		debugger;
		if(selectObj.value.toLowerCase()=="d"){
			var center = getRectCenter(SVG.get(o));
			var polygonCenter = drawPolygon([center.x,center.y]);
			var polygon = gShape.polygon(polygonCenter).fill("#fff").stroke({color:"#18b217",width:1.3})
							.attr({'transform':"",
							"getX":center.x,
							"getY":center.y,
							"filter":"url(#filter)",
							"textID":SVG.get(o).attr("textID"),
							"shapetype":"diamond",
						    "flowphase":SVG.get(o).attr("flowphase"),
						    "nodedesc":SVG.get(o).attr("nodedesc"),
						    "nodetype":SVG.get(o).attr("nodetype"),
						    "nodecode":SVG.get(o).attr("nodecode"),
						    "opttype":SVG.get(o).attr("opttype"),
						    "optcode":SVG.get(o).attr("optcode"),
						    "optbean":SVG.get(o).attr("optbean"),
						    "optparam":SVG.get(o).attr("optparam"),
						    "subwfcode":SVG.get(o).attr("subwfcode"),
						    "roletype":SVG.get(o).attr("roletype"),
						    "rolecode":SVG.get(o).attr("rolecode"),
						    "riskinfo":SVG.get(o).attr("riskinfo"),
						    "isaccounttime":SVG.get(o).attr("isaccounttime"),
						    "timeLimitType":SVG.get(o).attr("timeLimitType"),
						    "inheritType":SVG.get(o).attr("inheritType"),
						    "inheritNodeCode":SVG.get(o).attr("inheritNodeCode"),
						    "timeLimit":SVG.get(o).attr("timeLimit"),
						    "isTrunkLine":SVG.get(o).attr("isTrunkLine"),
						    "unitexp":SVG.get(o).attr("unitexp"),
						    "powerexp":SVG.get(o).attr("powerexp"),
						    "expireopt":SVG.get(o).attr("expireopt"),
						    "desc":SVG.get(o).attr("desc"),
							"title":SVG.get(o).attr("title"),
							"width":rectWidth,
							"height":rectHeight,
							"to":SVG.get(o).attr("to"),
							"from":SVG.get(o).attr("from")});
			if(g(o).getAttribute("lineID")){
				SVG.get(g(o).getAttribute("lineID")).remove();
			}
			SVG.get(o).remove();
			polygon.attr({"id":o});
		}else if(selectObj.value.toLowerCase()=="r"){
			var rect = gShape.rect(rectWidth,rectHeight).stroke({color:"#18b217",width:1.3}).fill("skyblue")
			 .attr({rx:10,ry:10,
				   "shapetype":"R",
				   "filter":"url(#filter)",
				   "flowphase":SVG.get(o).attr("flowphase"),
				   "nodedesc":SVG.get(o).attr("nodedesc"),
				   "nodetype":SVG.get(o).attr("nodetype"),
				   "nodecode":SVG.get(o).attr("nodecode"),
				   "opttype":SVG.get(o).attr("opttype"),
				   "optcode":SVG.get(o).attr("optcode"),
				   "optbean":SVG.get(o).attr("optbean"),
				   "optparam":SVG.get(o).attr("optparam"),
				   "subwfcode":SVG.get(o).attr("subwfcode"),
				   "roletype":SVG.get(o).attr("roletype"),
				   "rolecode":SVG.get(o).attr("rolecode"),
				   "riskinfo":SVG.get(o).attr("riskinfo"),
			       "isaccounttime":SVG.get(o).attr("isaccounttime"),
				   "timeLimitType":SVG.get(o).attr("timeLimitType"),
				   "inheritType":SVG.get(o).attr("inheritType"),
				   "inheritNodeCode":SVG.get(o).attr("inheritNodeCode"),
				   "timeLimit":SVG.get(o).attr("timeLimit"),
				   "isTrunkLine":SVG.get(o).attr("isTrunkLine"),
				   "unitexp":SVG.get(o).attr("unitexp"),
				   "powerexp":SVG.get(o).attr("powerexp"),
				   "expireopt":SVG.get(o).attr("expireopt"),
				   "desc":SVG.get(o).attr("desc"),
				   "textID":SVG.get(o).attr("textID"),
				   "title":SVG.get(o).attr("title"),
				   "width":rectWidth,
				   "height":rectHeight,
				   "to":SVG.get(o).attr("to"),
			       "from":SVG.get(o).attr("from"),
				   "x":parseInt(SVG.get(o).attr("x")),
				   "y":parseInt(SVG.get(o).attr("y")) 
				   });
			if(g(o).nodeName=="polygon"){
				rect.attr({"x":parseInt(SVG.get(o).attr("getX"))-(rectWidth/2),
					 "y":parseInt(SVG.get(o).attr("getY"))-(rectHeight/2)
				});
			}
			if(g(o).getAttribute("lineID")){
				SVG.get(g(o).getAttribute("lineID")).remove();
			}
			SVG.get(o).remove();
			rect.attr({"id":o});
		}else{
			var rect = gShape.rect(rectWidth,rectHeight).stroke({color:"#18b217",width:1.3}).fill("#fff")
							 .attr({rx:2,ry:2,
								   "shapetype":"roundrect",
								   "filter":"url(#filter)",
								   "flowphase":SVG.get(o).attr("flowphase"),
								   "nodedesc":SVG.get(o).attr("nodedesc"),
								   "nodetype":SVG.get(o).attr("nodetype"),
								   "nodecode":SVG.get(o).attr("nodecode"),
								   "opttype":SVG.get(o).attr("opttype"),
								   "optcode":SVG.get(o).attr("optcode"),
								   "optbean":SVG.get(o).attr("optbean"),
								   "optparam":SVG.get(o).attr("optparam"),
								   "subwfcode":SVG.get(o).attr("subwfcode"),
								   "roletype":SVG.get(o).attr("roletype"),
								   "rolecode":SVG.get(o).attr("rolecode"),
								   "riskinfo":SVG.get(o).attr("riskinfo"),
							       "isaccounttime":SVG.get(o).attr("isaccounttime"),
								   "timeLimitType":SVG.get(o).attr("timeLimitType"),
								   "inheritType":SVG.get(o).attr("inheritType"),
								   "inheritNodeCode":SVG.get(o).attr("inheritNodeCode"),
								   "timeLimit":SVG.get(o).attr("timeLimit"),
								   "isTrunkLine":SVG.get(o).attr("isTrunkLine"),
								   "unitexp":SVG.get(o).attr("unitexp"),
								   "powerexp":SVG.get(o).attr("powerexp"),
								   "expireopt":SVG.get(o).attr("expireopt"),
								   "desc":SVG.get(o).attr("desc"),
								   "textID":SVG.get(o).attr("textID"),
								   "title":SVG.get(o).attr("title"),
								   "width":rectWidth,
								   "height":rectHeight,
								   "to":SVG.get(o).attr("to"),
							       "from":SVG.get(o).attr("from"),
								   "x":parseInt(SVG.get(o).attr("x")),
								   "y":parseInt(SVG.get(o).attr("y")) 
								   });
			if(g(o).nodeName=="polygon"){
				rect.attr({"x":parseInt(SVG.get(o).attr("getX"))-(rectWidth/2),
					 "y":parseInt(SVG.get(o).attr("getY"))-(rectHeight/2)
				});
			}
			if(selectObj.value.toLowerCase()=="h"){
				var points = parseInt(rect.attr("x"))+","+(parseInt(rect.attr("y"))+parseInt(rectHeight)-parseInt(rectHeight/6))+" "+(parseInt(rect.attr("x"))+parseInt(rectWidth))+","+(parseInt(rect.attr("y"))+parseInt(rectHeight)-parseInt(rectHeight/6));
				var bingLine = gInnerLine.polyline().stroke({ color:"#18b217",width: 1.3 }).fill("none")
				                    .attr({"points":points,
				                    	    'transform':"",
				                    	    "shapetype":"PolyLine",
				                    	    "id":"line_"+rect.attr("id")}); 
				rect.attr({"lineID":bingLine.attr("id"),"shapetype":"bing"});			
			}
			if(selectObj.value.toLowerCase()=="e"){
				var points = parseInt(rect.attr("x"))+","+(parseInt(rect.attr("y"))+parseInt(rectHeight/6))+" "+(parseInt(rect.attr("x"))+parseInt(rectWidth))+","+(parseInt(rect.attr("y"))+parseInt(rectHeight/6));
				var juLine = gInnerLine.polyline().stroke({ color:"#18b217",width: 1.3 }).fill("none")
				                    .attr({"points":points,
				                    	    'transform':"",
				                    	    "shapetype":"PolyLine",
				                    	    "id":"line_"+rect.attr("id")}); 
				rect.attr({"lineID":juLine.attr("id"),"shapetype":"ju"});
				
			}
			if(selectObj.value.toLowerCase()=="g"){
				var points = parseInt(rect.attr("x"))+","+(parseInt(rect.attr("y"))+parseInt(rectHeight)-parseInt(rectHeight/6))+" "+(parseInt(rect.attr("x"))+parseInt(rectWidth))+","+(parseInt(rect.attr("y"))+parseInt(rectHeight)-parseInt(rectHeight/6));
				var juLine = gInnerLine.polyline().stroke({ color:"#18b217",width: 1.3 }).fill("none")
				                    .attr({"points":points,
				                    	    'transform':"",
				                    	    'stroke-dasharray':4,
				                    	    "shapetype":"PolyLine",
				                    	    "id":"line_"+rect.attr("id")}); 
				rect.attr({"lineID":juLine.attr("id"),"shapetype":"multi"});
				
			}
			if(g(o).getAttribute("lineID")){
				SVG.get(g(o).getAttribute("lineID")).remove();
			}
			SVG.get(o).remove();			
			rect.attr({"id":o});
		}
		g(o).setAttribute("nodetype",selectObj.value);
	}
}

//连线的参数栏目
function bindLine(){
	//线条绑定name
	g("linename").value = g("lab"+o).innerHTML;					
	g("cond").value = SVG.get(o).attr("cond");
	g("linetimeLimit").value = SVG.get(o).attr("timeLimit")==undefined?"":SVG.get(o).attr("timeLimit");
	if(SVG.get(o).attr("timeLimit")=="null"){
		g("linetimeLimit").value = "";
	}
	g("linedesc").value = SVG.get(o).attr("desc");
	for(var i = 0;i < g("linetimeLimitType").options.length;i++){
		if(g("linetimeLimitType").options[i].value == SVG.get(o).attr("timeLimitType")){
			g("linetimeLimitType").options[i].selected = "selected";
		}
	}
	for(var i = 0;i < g("lineinheritType").options.length;i++){
		if(g("lineinheritType").options[i].value == SVG.get(o).attr("inheritType")){
			g("lineinheritType").options[i].selected = "selected";
		}
	}
	if(SVG.get(o).attr("inheritType")=='2'){
		$('#lineinheritCode').show();
	}
	g("lineinheritNodeCode").value = SVG.get(o).attr("inheritNodeCode");
}
//圆绑定
function bindCircle(){
	g("circle_nodename").value = SVG.get(o).attr("title");
	setValue(g(SVG.get(o).attr("textID")),dealStr(SVG.get(o).attr("title"),rectWidth));
	g(o).setAttribute("title",SVG.get(o).attr("title"));
	if (SVG.get(o).attr("nodecode")){
		g("circle_nodecode").value = SVG.get(o).attr("nodecode");
	}
	else{
		g("circle_nodecode").value = "";
	}
}

//删除过程 ==> 当选中每个过程元件的时候可以点击删除按钮进行删除，删除前先要接触连线关系
function deletePro(o){
	if(!o){ return false; }
	else{ var pro = g(o); }
	if(pro){
		switch(pro.nodeName){
			case "rect":
				if( pro.getAttribute("from") || pro.getAttribute("to") ){ alert("有连线关联过程，请删除关联线，孤立过程！"); }
				else{ 
					var shapeType = pro.getAttribute("shapetype"),lineID = "",linePoints = "";					 
					if(pro.getAttribute("lineID")){
						lineID = pro.getAttribute("lineID");
						linePoints = g(pro.getAttribute("lineID")).getAttribute("points");
						SVG.get(pro.getAttribute("lineID")).remove();
					}
					pushLog("delproc",{"ID":o,"textID":pro.getAttribute("textID"),"shapetype":shapeType,"flowphase":pro.getAttribute("flowphase"),"nodedesc":pro.getAttribute("nodedesc"), "nodetype":pro.getAttribute("nodetype"), "opttype":pro.getAttribute("opttype"), "optcode":pro.getAttribute("optcode"), "optbean":pro.getAttribute("optbean"), "optparam":pro.getAttribute("optparam"), "subwfcode":pro.getAttribute("subwfcode"), "roletype":pro.getAttribute("roletype"), "rolecode":pro.getAttribute("rolecode"), "isaccounttime":pro.getAttribute("isaccounttime"), "timeLimitType":pro.getAttribute("timeLimitType"),
						   "inheritType":pro.getAttribute("inheritType"),"inheritNodeCode":pro.getAttribute("inheritNodeCode"),"timeLimit":pro.getAttribute("timeLimit"),"isTrunkLine":pro.getAttribute("isTrunkLine"), "unitexp":pro.getAttribute("unitexp"), "powerexp":pro.getAttribute("powerexp"), "expireopt":pro.getAttribute("expireopt"), "desc":pro.getAttribute("desc"),"title":pro.getAttribute("title"),
						   "X":pro.getAttribute("x"),"Y":pro.getAttribute("y"),"width":pro.getAttribute("width"),"height":pro.getAttribute("height"),"lineID":lineID,"linePoints":linePoints});
					SVG.get(o).remove();
					SVG.get(pro.getAttribute("textID")).remove();
				}
				break;
				
			case "polygon":
				if( pro.getAttribute("from") || pro.getAttribute("to") ){ alert("有连线关联过程，请删除关联线，孤立过程！"); }
				else{ 
					pushLog("delproc",{"ID":o,"textID":pro.getAttribute("textID"),"shapetype":"diamond","flowphase":pro.getAttribute("flowphase"),"nodedesc":pro.getAttribute("nodedesc"), "nodetype":pro.getAttribute("nodetype"), "opttype":pro.getAttribute("opttype"), "optcode":pro.getAttribute("optcode"), "optbean":pro.getAttribute("optbean"), "optparam":pro.getAttribute("optparam"), "subwfcode":pro.getAttribute("subwfcode"), "roletype":pro.getAttribute("roletype"), "rolecode":pro.getAttribute("rolecode"), "isaccounttime":pro.getAttribute("isaccounttime"), "timeLimitType":pro.getAttribute("timeLimitType"),
						"inheritType":pro.getAttribute("inheritType"),"inheritNodeCode":pro.getAttribute("inheritNodeCode"),"timeLimit":pro.getAttribute("timeLimit"),"isTrunkLine":pro.getAttribute("isTrunkLine"), "unitexp":pro.getAttribute("unitexp"), "powerexp":pro.getAttribute("powerexp"), "expireopt":pro.getAttribute("expireopt"), "desc":pro.getAttribute("desc"),"title":pro.getAttribute("title"),
						   "getX":pro.getAttribute("getX"),"getY":pro.getAttribute("getY"),"width":pro.getAttribute("width"),"height":pro.getAttribute("height")});
					SVG.get(o).remove();
					SVG.get(pro.getAttribute("textID")).remove();
				}
				break;
			
			case "polyline":
				var fromPro = g( pro.getAttribute("from") ),
					toPro = g( pro.getAttribute("to") ),
					lenFrom = fromPro.getAttribute("from").split(","),
					lenTo = toPro.getAttribute("to").split(","),
					fromArray = new Array,toArray = new Array;
				pushLog("delproc",{"ID":o,"labID":pro.getAttribute("labID"),"title":pro.getAttribute("title"),"shapetype":"polyline", "timeLimitType":pro.getAttribute("timeLimitType"),"inheritType":pro.getAttribute("inheritType"),"inheritNodeCode":pro.getAttribute("inheritNodeCode"),
					   "timeLimit":pro.getAttribute("timeLimit"),"points":pro.getAttribute("points"),"desc":pro.getAttribute("desc"),"cond":pro.getAttribute("cond"),
					   "from":pro.getAttribute("from"),"to":pro.getAttribute("to"),"left":parseInt(g("lab"+o).style.left),"top":parseInt(g("lab"+o).style.top)}); 
				if(pro.getAttribute("cricleID")){
					var cricleIDArray = pro.getAttribute("cricleID").split(",");
					
					for( var i=0,len=cricleIDArray.length;i<len;i++ ){
						SVG.get(cricleIDArray[i]).remove();
					}
				}
				
				for(var i=0,len=lenFrom.length;i<len;i++){
					if( lenFrom[i]!=o ){
						fromArray.push(lenFrom[i]);
					}
				}
				fromPro.setAttribute("from",fromArray.join(","));
				
				for(var i=0,len=lenTo.length;i<len;i++){
					if( lenTo[i]!=o ){
						toArray.push(lenTo[i]);
					}
				}
				toPro.setAttribute("to",toArray.join(","));
				SVG.get(o).remove();
				g("lineCon").removeChild(g("lab"+o));
				break;
				
			case "ellipse":
				alert("不能删除起始过程！");
				/* if(!pro.getAttribute("type")){
					if( g(g(o).getAttribute("lineID")).getAttribute("judgeLine") ){}
					else{
						SVG.get( SVG.get(o).attr("lineID") ).stroke({color:"#00f",width:1.3}).attr({"marker-end":"url(#"+marker.attr("id")+")"});
					}
					var _old =g(pro.getAttribute("lineID")).getAttribute("points");
					var lineID = pro.getAttribute("lineID");
					deletePoint( g(pro.getAttribute("lineID")),[pro.getAttribute("cx"),pro.getAttribute("cy")],o);
					pushLog("delCircle",{"lineID":lineID,"_old":_old,"_new":g(lineID).getAttribute("points")});
					SVG.get(o).remove();
				} */
				break;
			
			default:break;
		}
		g("ispro").style.display = "none";
		g("isline").style.display = "none";
	}
}


//生成xml空文档  此方法在getXml()方法中会具体实现，就是实现一个空的xml文档，getXml()方法实现具体的节点内容
function createNewXml(){ 
	var xmlDom = null;   
  	if (window.ActiveXObject){   
   		xmlDom = new ActiveXObject("Microsoft.XMLDOM");   
   		xmlDom.async=false;   
  	} 
  	else if(document.implementation && document.implementation.createDocument){   
  		xmlDom = document.implementation.createDocument("", "", null); 
  	}else{   
		xmlDom = null;   
  	}
  	return xmlDom;   
}

//给xml添加具体的节点属性，生成所需要的xml字串  xml如果变化，生成的节点根据新的xml来修改
function getXml(){

	var xmlDoc = createNewXml(),
		xmlSer=new XMLSerializer(),
	    newPI=xmlDoc.createProcessingInstruction("xml","version=\"1.0\" encoding=\"utf-8\""),
		obj = g("s3").childNodes,lineObj = g("s2").childNodes,
		xmlString,commitFlow,flow,nodes,node,baseProperties,VMLProperties,transitions,transition,LabelProperties,LbaseProperties,LVMLProperties;
	
	
	commitFlow = xmlDoc.createElement("CommitFlow");//根节点
	flow = xmlDoc.createElement("Flow");//流程开始
	flow.setAttribute("code",this.code);
	flow.setAttribute("name",this.name);
	flow.setAttribute("type",this.type);
	flow.setAttribute("desc",this.desc);
	nodes = xmlDoc.createElement("Nodes");//过程节点集合
	transitions = xmlDoc.createElement("Transitions");//线条集合
	
	xmlDoc.appendChild(newPI);
	xmlDoc.appendChild(commitFlow);
	commitFlow.appendChild(flow);
	flow.appendChild(nodes);
	flow.appendChild(transitions);	
	var s = validate(obj);
	if(s!=""){
		if(!confirm(s+"\n\n是否要继续保存该流程？"))
			return; 
	 	}
	for( var i=0,len=obj.length;i<len;i++ ){
		var textID = obj[i].getAttribute("textID");
		node = xmlDoc.createElement("Node");
		baseProperties = xmlDoc.createElement("BaseProperties");
		VMLProperties = xmlDoc.createElement("VMLProperties");
		debugger;
		addNode(baseProperties,{
							"id":obj[i].getAttribute("id"),
							"name":replacetoxml(obj[i].getAttribute("title")),
							"flowphase":obj[i].getAttribute("flowphase"),
							"nodedesc":replacetoxml(obj[i].getAttribute("nodedesc")),
							"nodetype":obj[i].getAttribute("nodetype"),
							"nodecode":replacetoxml(obj[i].getAttribute("nodecode")),
							"opttype":obj[i].getAttribute("opttype"),
							"optcode":replacetoxml(obj[i].getAttribute("optcode")),
							"optbean":replacetoxml(obj[i].getAttribute("optbean")),
							"optparam":replacetoxml(obj[i].getAttribute("optparam")),
							"subwfcode":obj[i].getAttribute("subwfcode"),
							"roletype":obj[i].getAttribute("roletype"),
							"rolecode":obj[i].getAttribute("rolecode"),
							"isaccounttime":obj[i].getAttribute("isaccounttime"),
							"timeLimitType":obj[i].getAttribute("timeLimitType"),
							"inheritType":obj[i].getAttribute("inheritType"),
							"inheritNodeCode":obj[i].getAttribute("inheritNodeCode"),
							"timeLimit":replacetoxml(obj[i].getAttribute("timeLimit")),
							"isTrunkLine":obj[i].getAttribute("isTrunkLine"),
							"unitexp":replacetoxml(obj[i].getAttribute("unitexp")),
							"powerexp":replacetoxml(obj[i].getAttribute("powerexp")),
							"expireopt":replacetoxml(obj[i].getAttribute("expireopt")),
							"desc":replacetoxml(obj[i].getAttribute("desc")),
							"riskinfo":replacetoxml(obj[i].getAttribute("riskinfo"))
						});
						
		addNode(VMLProperties,{
							"shapetype":obj[i].getAttribute("shapetype"),
							"textWeight":g(textID).getAttribute("textWeight"),
							"strokeWeight":g(textID).getAttribute("strokeWeight"),
							"zIndex":g(textID).getAttribute("zIndex")
						});
		
		switch(obj[i].nodeName){
			case "ellipse":
				addNode(VMLProperties,{
							"width":obj[i].getAttribute("width"),
							"height":obj[i].getAttribute("height"),
							"x":obj[i].getAttribute("cx")-(obj[i].getAttribute("width")/2)+"px",
							"y":obj[i].getAttribute("cy")-(obj[i].getAttribute("height")/2)+"px"
						});
				break;
				
			case "rect":
				addNode(VMLProperties,{
							"width":obj[i].getAttribute("width"),
							"height":obj[i].getAttribute("height"),
							"x":obj[i].getAttribute("x")+"px",
							"y":obj[i].getAttribute("y")+"px"
						});
				break;
				
			case "polygon":
				addNode(VMLProperties,{
							"width":obj[i].getAttribute("width")+"px",
							"height":obj[i].getAttribute("height")+"px",
							"x":obj[i].getAttribute("getX")-(obj[i].getAttribute("width")/2)+"px",
							"y":obj[i].getAttribute("getY")-(obj[i].getAttribute("height")/2)+"px"
						});
				break;
		}
					
		nodes.appendChild(node);
		node.appendChild(baseProperties);
		node.appendChild(VMLProperties);
	}
	
	for(var j=0,jLen=lineObj.length;j<jLen;j++){
		if(lineObj[j].getAttribute("id").indexOf("line_")<0){ //排除汇聚、并行、多实例节点矩形框内的画线
		transition = xmlDoc.createElement("Transition");
		LbaseProperties = xmlDoc.createElement("BaseProperties");
		LVMLProperties = xmlDoc.createElement("VMLProperties");
		LabelProperties = xmlDoc.createElement("LabelProperties");
		addNode(LbaseProperties,{
							"id":lineObj[j].getAttribute("id"),
							"name":replacetoxml(lineObj[j].getAttribute("title")),
							"from":lineObj[j].getAttribute("from"),
							"to":lineObj[j].getAttribute("to"),
							"cond":replacetoxml(lineObj[j].getAttribute("cond")),
							"desc":replacetoxml(lineObj[j].getAttribute("desc")),
							"timeLimit":replacetoxml(lineObj[j].getAttribute("timeLimit")),
							"timeLimitType":lineObj[j].getAttribute("timeLimitType"),
							"inheritType":lineObj[j].getAttribute("inheritType"),
							"inheritNodeCode":lineObj[j].getAttribute("inheritNodeCode")
						});
		addNode(LVMLProperties,{
							"points":changePx(lineObj[j].getAttribute("points")),
							"shapetype":"PolyLine",
							"startArrow":"none",
							"endArrow":"Classic",
							"strokeWeight":"1",
							"zIndex":"2",
							"fromRelX":"1",
							"fromRelY":"0.5",
							"toRelX":"0",
							"toRelY":"0"
						});
		addNode(LabelProperties,{
							"id":lineObj[j].getAttribute("labID"),
							"width":g(lineObj[j].getAttribute("labID")).offsetWidth+"px",
							"height":"24px",
							"x":g(lineObj[j].getAttribute("labID")).style.left,
							"y":g(lineObj[j].getAttribute("labID")).style.top
						});
		
		transitions.appendChild(transition);
		transition.appendChild(LbaseProperties);
		transition.appendChild(LVMLProperties);
		transition.appendChild(LabelProperties);
		}
	}
	
	if(xmlDoc.xml){
		xmlString = xmlDoc.xml;
	}else{
		xmlString = xmlSer.serializeToString(xmlDoc);
	}
	var xmlHttp=new XMLHttpRequest();
	var handlerFunction = getHandler(xmlHttp);			
	xmlHttp.onreadystatechange = handlerFunction;
	xmlHttp.open("POST","sampleFlowDefine!saveFlow.do?flowCode="+flowCode+"&version="+version,true);
	xmlHttp.setRequestHeader("Content-Type","text/html");
	xmlHttp.send(xmlString);		
	setTimeout("", 3000);
	
}
  function validate(obj){
	 var flog=true;
		var myerrors=new Array();
		var  bxs=0;      //并行个数
		var hjs=0;		//汇聚个数
		var hd=0;		//首节点个数
		 for(var i=0;i<obj.length;i++){
			if(obj[i].getAttribute("nodetype")!='A'&&obj[i].getAttribute("nodetype")!='F'){
				//
				if(obj[i].getAttribute("opttype")=='D')
					{
					if(obj[i].getAttribute("optbean")==''){
						myerrors.push(obj[i].getAttribute("title")+"为自动执行节点，但是没有配置业务bean，请检查后保存。");
						flog=false;}
					}
				else if(obj[i].getAttribute("opttype")=='S')
				{
					if(obj[i].getAttribute("subwfcode")==''||obj[i].getAttribute("subwfcode")=='0'){
						myerrors.push(obj[i].getAttribute("title")+"为子流程节点，但是没有配置子流程，请检查后保存。");
						
						flog= false;}
				}else if(obj[i].getAttribute("opttype")!='E')
					{
					if(obj[i].getAttribute("optcode")==''||obj[i].getAttribute("optcode")=='0'){
						myerrors.push(obj[i].getAttribute("title")+"没有配置业务代码，请检查后保存");
						flog=false;
						}
				}
				//
				if(obj[i].getAttribute("roletype")=='en')	{
					if(obj[i].getAttribute("powerexp")==''){
						myerrors.push(obj[i].getAttribute("title")+"的角色类别为权限引擎，但是没有设置权限表达式，请检查后保存");
						flog=false;
					}
				}
				else{
					if(obj[i].getAttribute("rolecode")==''||obj[i].getAttribute("rolecode")=='0'&&obj[i].getAttribute("opttype")!='D'&&obj[i].getAttribute("opttype")!='E'){
						myerrors.push(obj[i].getAttribute("title")+"没有设置角色代码，请检查后保存");
						flog=false;
					}				
				}		
			//计算并行节点的个数
				if(obj[i].getAttribute("nodetype")=="H")
					bxs++;
			//计算汇聚节点的个数
				if(obj[i].getAttribute("nodetype")=="E")
					hjs++;
				//计算首节点的个数
				if(obj[i].getAttribute("nodetype")=="B")
					hd++;
			//判断节点的入度 				
				if(!obj[i].getAttribute("to") && !obj[i].getAttribute("from")) {
					myerrors.push(obj[i].getAttribute("title")+"没有输入路径");				
					}
			//判断节点的出度
			if(obj[i].getAttribute("from")){
			     if(obj[i].getAttribute("nodetype")=="H"&&obj[i].getAttribute("from").split(",").length<2){
			        myerrors.push(obj[i].getAttribute("title")+"为并行节点,应该有二条以上的输出路径");
		            }
			    if(obj[i].getAttribute("nodetype")=="D"&&obj[i].getAttribute("from").split(",").length<2){
			        myerrors.push(obj[i].getAttribute("title")+"为分支节点,应该有二条以上的输出路径");
		            }
			    if(obj[i].getAttribute("nodetype")=="C"&&obj[i].getAttribute("from").split(",").length>1){
			        myerrors.push(obj[i].getAttribute("title")+"为一般节点,应只有一条输出路径");
		            }				
			  }
		   }
		}
		//判断首节点个数
		 if(hd>1)
			 myerrors.push("首节点应只有一个，实际为"+hd+"个");
		//判断并行和汇聚个数
		 if(hjs>bxs){
			myerrors.push("并行节点有"+bxs+"个，汇聚节点有"+hjs+"个，汇聚节点个数不应超过并行节点个数");
		} 
		var errors="";
		for(var m=0;m<myerrors.length;m++){	
			errors=errors+myerrors[m]+"\n";		
		} 
		return errors;
 } 
  
  function getHandler(req) {

		// 返回一个监听XMLHttpRequest实例的匿名函数		
		return function() {
			// 如果请求的状态是“完成”		
			if (req.readyState == 4) {
				// 检查是否成功接收了服务器响应			
				if (req.status == 200) {
					// 将载有响应信息的XML传递到处理函数
					var reqStr = req.responseText.trim();
					//alert("接收到的字符a：     "+reqStr);	
					//document.getElementById("").innerHTML = reqStr;
					
					this.Modified=(reqStr!="");
					
					if(reqStr==""){	
						alert("[保存失败]");
					}
					else{
						alert("保存成功！");
					}
					return reqStr;

				} else {
					// 有HTTP问题发生					
					//alert("HTTP error: "+req.status);
					//document.all.ContentLiner.focus();
					alert("[保存失败]");
				}
			}
		};
	}
 
//操作工具栏,点击画线，过程 等等一些具体操作。
addEvent(g("tool"),"mousedown",function(e){
	var e = window.event || e, target = e.srcElement || e.target;
	if(target.nodeName.toLowerCase()=="img" && target.parentNode.className=="opt"){
		flag = 1;
		if(selectTag){
			selectTag.style.backgroundColor = "buttonface";
		}else{
			g("default").parentNode.style.backgroundColor = "buttonface";
		}
		target.parentNode.style.backgroundColor = "#888";
		selectTag = target.parentNode;
		switch(target.id){
			case "rect":
				document.all.canvas.style.cursor = "crosshair";
				image="rect";
				flag =2;
				break;
			case "line":
				document.all.canvas.style.cursor = "crosshair";
				image="line";
				flag=0;
				break;
			case "polygon":
				document.all.canvas.style.cursor = "crosshair";
				image="polygon";
				break;
			case "default":
				document.all.canvas.style.cursor = "default";
				image="default";
				break;
			default:
				break;
		}
	}
});

//根据现有的xml生成，流程图，可操作    /* 如果xml的格式变化，这边需要重新修改 */
function loadXml(xml,canvas){
	var xmlDoc;
	if(window.ActiveXObject){
		xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.loadXML(xml);
	}else if(window.DOMParser){
		parser=new DOMParser();
		xmlDoc=parser.parseFromString(xml,"text/xml");
	}  
	
	var getShape = xmlDoc.getElementsByTagName("Node"),
		getLine = xmlDoc.getElementsByTagName("Transition");
	for( var i=0,len=getShape.length;i<len;i++ ){
		var shap = attrValue(getShape[i],"VMLProperties","shapetype");
		var nodeType =attrValue(getShape[i],"BaseProperties","nodetype");
		if(nodeType=="H"){
			shap = "bing";
		}
		if(nodeType=="E"){
			shap = "ju";
		}
		if(nodeType=="G"){
			shap = "multi";
		}
		var width = parseInt(attrValue(getShape[i],"VMLProperties","width"));
		var height = parseInt(attrValue(getShape[i],"VMLProperties","height"));
		switch( shap ){
			case "Oval":
				var c = gShape.ellipse(width,height).cx(parseInt(attrValue(getShape[i],"VMLProperties","x"))+(width/2)).cy(parseInt(attrValue(getShape[i],"VMLProperties","y"))+(height/2))
				 .attr({"id":attrValue(getShape[i],"BaseProperties","id"),
					    "filter":"url(#filter)",
					    "type":"circle",
						"shapetype":"Oval",
						"title":attrValue(getShape[i],"BaseProperties","name"),
						"flowphase":attrValue(getShape[i],"BaseProperties","flowphase"),
						"nodedesc":attrValue(getShape[i],"BaseProperties","nodedesc"),
						"nodetype":attrValue(getShape[i],"BaseProperties","nodetype"),
						"nodecode":attrValue(getShape[i],"BaseProperties","nodecode"),
						"opttype":attrValue(getShape[i],"BaseProperties","opttype"),
						"optcode":attrValue(getShape[i],"BaseProperties","optcode"),
						"optbean":attrValue(getShape[i],"BaseProperties","optbean"),
						"optparam":attrValue(getShape[i],"BaseProperties","optparam"),
						"subwfcode":attrValue(getShape[i],"BaseProperties","subwfcode"),
						"roletype":attrValue(getShape[i],"BaseProperties","roletype"),
						"rolecode":attrValue(getShape[i],"BaseProperties","rolecode"),
						"isaccounttime":attrValue(getShape[i],"BaseProperties","isaccounttime"),
						"timeLimitType":attrValue(getShape[i],"BaseProperties","timeLimitType"),
						"inheritType":"0",
						"inheritNodeCode":"",
						"timeLimit":attrValue(getShape[i],"BaseProperties","timeLimit"),
						"isTrunkLine":attrValue(getShape[i],"BaseProperties","isTrunkLine"),
						"unitexp":attrValue(getShape[i],"BaseProperties","unitexp"),
						"powerexp":attrValue(getShape[i],"BaseProperties","powerexp"),
						"expireopt":attrValue(getShape[i],"BaseProperties","expireopt"),
						"desc":attrValue(getShape[i],"BaseProperties","desc"),
						"to":"",
						"from":"",
						"width":width,
						"height":height
						 
				  }).stroke({width:1.3,color:"#ff0000"}).fill("#fff");
			    
				var t = gText.text( dealStr(attrValue(getShape[i],"BaseProperties","name"),width)).fill("#ff0000")
					 .x(parseInt(attrValue(getShape[i],"VMLProperties","x")))
					 .y(parseInt(attrValue(getShape[i],"VMLProperties","y"))+(height/2)+6)
					 .attr({dx:parseInt(attrValue(getShape[i],"VMLProperties","x"))+(width/2),"shapeID":c.attr("id")})
					 .font({family:"Arial",size:14,"text-anchor":"middle"});
				c.attr({"textID":t.attr("id")});
				break;
				
			case "roundrect":
				rectWidth = width;
				rectHeight = height;
				var r = gShape.rect(width,height).x(parseInt(attrValue(getShape[i],"VMLProperties","x"))).y(parseInt(attrValue(getShape[i],"VMLProperties","y")))
					  .stroke({color:"#0000ff",width:1.3}).fill("#fff")
					  .attr({rx:2,ry:2, "shapetype":"roundrect",
						                "filter":"url(#filter)",
									    "id":attrValue(getShape[i],"BaseProperties","id"),
									    "title":attrValue(getShape[i],"BaseProperties","name"),
										"flowphase":attrValue(getShape[i],"BaseProperties","flowphase"),
										"nodedesc":attrValue(getShape[i],"BaseProperties","nodedesc"),
										"nodetype":attrValue(getShape[i],"BaseProperties","nodetype"),
										"nodecode":attrValue(getShape[i],"BaseProperties","nodecode"),
										"opttype":attrValue(getShape[i],"BaseProperties","opttype"),
										"optcode":attrValue(getShape[i],"BaseProperties","optcode"),
										"optbean":attrValue(getShape[i],"BaseProperties","optbean"),
										"optparam":attrValue(getShape[i],"BaseProperties","optparam"),
										"subwfcode":attrValue(getShape[i],"BaseProperties","subwfcode"),
										"roletype":attrValue(getShape[i],"BaseProperties","roletype"),
										"rolecode":attrValue(getShape[i],"BaseProperties","rolecode"),
										"riskinfo":attrValue(getShape[i],"BaseProperties","riskinfo"),
										"isaccounttime":attrValue(getShape[i],"BaseProperties","isaccounttime"),
										"timeLimitType":attrValue(getShape[i],"BaseProperties","timeLimitType"),
										"inheritType":attrValue(getShape[i],"BaseProperties","inheritType")?attrValue(getShape[i],"BaseProperties","inheritType"):"0",
									    "inheritNodeCode":attrValue(getShape[i],"BaseProperties","inheritNodeCode")?attrValue(getShape[i],"BaseProperties","inheritNodeCode"):"",
										"timeLimit":attrValue(getShape[i],"BaseProperties","timeLimit"),
										"isTrunkLine":attrValue(getShape[i],"BaseProperties","isTrunkLine"),
										"unitexp":attrValue(getShape[i],"BaseProperties","unitexp"),
										"powerexp":attrValue(getShape[i],"BaseProperties","powerexp"),
										"expireopt":attrValue(getShape[i],"BaseProperties","expireopt"),
										"desc":attrValue(getShape[i],"BaseProperties","desc"),
										"to":"",
										"from":"",
										"width":width,
										"height":height
							});

				var t = gText.text( dealStr(attrValue(getShape[i],"BaseProperties","name"),width) ).fill("#0000ff")
					 .x(parseInt(attrValue(getShape[i],"VMLProperties","x"))+5)
					 .y(parseInt(attrValue(getShape[i],"VMLProperties","y"))+(height/2)+6)
					 .attr({dx:parseInt(attrValue(getShape[i],"VMLProperties","x"))+(width/2),"shapeID":r.attr("id")})
					 .font({family:"Arial",size:14,"text-anchor":"middle"});
				r.attr({"textID":t.attr("id")});
				break;
				
			case "diamond":
				rectWidth = width;
				rectHeight = height;
				var p = gShape.polygon(drawPolygon([parseInt(attrValue(getShape[i],"VMLProperties","x"))+(width/2),parseInt(attrValue(getShape[i],"VMLProperties","y"))+(height/2)])).fill("#fff")
					  .stroke({color:"#0000ff",width:1.3})
					  .attr({'transform':"","shapetype":"diamond",
											"id":attrValue(getShape[i],"BaseProperties","id"),
											"filter":"url(#filter)",
											"title":attrValue(getShape[i],"BaseProperties","name"),
											"flowphase":attrValue(getShape[i],"BaseProperties","flowphase"),
											"nodedesc":attrValue(getShape[i],"BaseProperties","nodedesc"),
											"nodetype":attrValue(getShape[i],"BaseProperties","nodetype"),
											"nodecode":attrValue(getShape[i],"BaseProperties","nodecode"),
											"opttype":attrValue(getShape[i],"BaseProperties","opttype"),
											"optcode":attrValue(getShape[i],"BaseProperties","optcode"),
											"optbean":attrValue(getShape[i],"BaseProperties","optbean"),
											"optparam":attrValue(getShape[i],"BaseProperties","optparam"),
											"subwfcode":attrValue(getShape[i],"BaseProperties","subwfcode"),
											"roletype":attrValue(getShape[i],"BaseProperties","roletype"),
											"rolecode":attrValue(getShape[i],"BaseProperties","rolecode"),
											"riskinfo":attrValue(getShape[i],"BaseProperties","riskinfo"),
											"isaccounttime":attrValue(getShape[i],"BaseProperties","isaccounttime"),
											"timeLimitType":attrValue(getShape[i],"BaseProperties","timeLimitType"),
											"inheritType":attrValue(getShape[i],"BaseProperties","inheritType")?attrValue(getShape[i],"BaseProperties","inheritType"):"0",
											"inheritNodeCode":attrValue(getShape[i],"BaseProperties","inheritNodeCode")?attrValue(getShape[i],"BaseProperties","inheritNodeCode"):"",
											"timeLimit":attrValue(getShape[i],"BaseProperties","timeLimit"),
											"isTrunkLine":attrValue(getShape[i],"BaseProperties","isTrunkLine"),
											"unitexp":attrValue(getShape[i],"BaseProperties","unitexp"),
											"powerexp":attrValue(getShape[i],"BaseProperties","powerexp"),
											"expireopt":attrValue(getShape[i],"BaseProperties","expireopt"),
											"desc":attrValue(getShape[i],"BaseProperties","desc"),
											"to":"",
											"from":"",
											"width":width,
											"height":height,
											"getX":parseInt(attrValue(getShape[i],"VMLProperties","x"))+(width/2),
											"getY":parseInt(attrValue(getShape[i],"VMLProperties","y"))+(height/2)
					  });
				var t = gText.text( dealStr(attrValue(getShape[i],"BaseProperties","name"),width) ).fill("#0000ff")
					 .x(parseInt(attrValue(getShape[i],"VMLProperties","x")))
					 .y(parseInt(attrValue(getShape[i],"VMLProperties","y"))+6+(height/2))
					 .attr({dx:parseInt(attrValue(getShape[i],"VMLProperties","x"))+(width/2),"shapeID":p.attr("id")})
					 .font({family:"Arial",size:14,"text-anchor":"middle"});
				p.attr({"textID":t.attr("id")});
				break;
			case "ju":
				rectWidth = width;
				rectHeight = height;
				var r = gShape.rect(width,height).x(parseInt(attrValue(getShape[i],"VMLProperties","x"))).y(parseInt(attrValue(getShape[i],"VMLProperties","y")))
					  .stroke({color:"#0000ff",width:1.3}).fill("#fff")
					  .attr({rx:2,ry:2, "shapetype":"ju",
									    "id":attrValue(getShape[i],"BaseProperties","id"),
									    "filter":"url(#filter)",
									    "title":attrValue(getShape[i],"BaseProperties","name"),
										"flowphase":attrValue(getShape[i],"BaseProperties","flowphase"),
										"nodedesc":attrValue(getShape[i],"BaseProperties","nodedesc"),
										"nodetype":attrValue(getShape[i],"BaseProperties","nodetype"),
										"nodecode":attrValue(getShape[i],"BaseProperties","nodecode"),
										"opttype":attrValue(getShape[i],"BaseProperties","opttype"),
										"optcode":attrValue(getShape[i],"BaseProperties","optcode"),
										"optbean":attrValue(getShape[i],"BaseProperties","optbean"),
										"optparam":attrValue(getShape[i],"BaseProperties","optparam"),
										"subwfcode":attrValue(getShape[i],"BaseProperties","subwfcode"),
										"roletype":attrValue(getShape[i],"BaseProperties","roletype"),
										"rolecode":attrValue(getShape[i],"BaseProperties","rolecode"),
										"riskinfo":attrValue(getShape[i],"BaseProperties","riskinfo"),
										"isaccounttime":attrValue(getShape[i],"BaseProperties","isaccounttime"),
										"timeLimitType":attrValue(getShape[i],"BaseProperties","timeLimitType"),
										"inheritType":attrValue(getShape[i],"BaseProperties","inheritType")?attrValue(getShape[i],"BaseProperties","inheritType"):"0",
									    "inheritNodeCode":attrValue(getShape[i],"BaseProperties","inheritNodeCode")?attrValue(getShape[i],"BaseProperties","inheritNodeCode"):"",
										"timeLimit":attrValue(getShape[i],"BaseProperties","timeLimit"),
										"isTrunkLine":attrValue(getShape[i],"BaseProperties","isTrunkLine"),
										"unitexp":attrValue(getShape[i],"BaseProperties","unitexp"),
										"powerexp":attrValue(getShape[i],"BaseProperties","powerexp"),
										"expireopt":attrValue(getShape[i],"BaseProperties","expireopt"),
										"desc":attrValue(getShape[i],"BaseProperties","desc"),
										"to":"",
										"from":"",
										"width":width,
										"height":height
							});

				var t = gText.text( dealStr(attrValue(getShape[i],"BaseProperties","name"),width) ).fill("#0000ff")
					 .x(parseInt(attrValue(getShape[i],"VMLProperties","x"))+5)
					 .y(parseInt(attrValue(getShape[i],"VMLProperties","y"))+(height/2)+6)
					 .attr({dx:parseInt(attrValue(getShape[i],"VMLProperties","x"))+(width/2),"shapeID":r.attr("id")})
					 .font({family:"Arial",size:14,"text-anchor":"middle"});
				r.attr({"textID":t.attr("id")});
				var points = parseInt(attrValue(getShape[i],"VMLProperties","x"))+","+(parseInt(attrValue(getShape[i],"VMLProperties","y"))+height/6)+" "+(parseInt(attrValue(getShape[i],"VMLProperties","x"))+width)+","+(parseInt(attrValue(getShape[i],"VMLProperties","y"))+height/6);
				var juLine = gInnerLine.polyline().stroke({ color:"#0000ff",width: 1.3 }).fill("none")
				                    .attr({"points":points,
				                    	    'transform':"",
				                    	    "shapetype":"PolyLine",
				                    	    "id":"line_"+r.attr("id")}); 
				r.attr({"lineID":juLine.attr("id")});
				break;
			case "bing":
				rectWidth = width;
				rectHeight = height;
				var r = gShape.rect(width,height).x(parseInt(attrValue(getShape[i],"VMLProperties","x"))).y(parseInt(attrValue(getShape[i],"VMLProperties","y")))
					  .stroke({color:"#0000ff",width:1.3}).fill("#fff")
					  .attr({rx:2,ry:2, "shapetype":"bing",
									    "id":attrValue(getShape[i],"BaseProperties","id"),
									    "filter":"url(#filter)",
									    "title":attrValue(getShape[i],"BaseProperties","name"),
										"flowphase":attrValue(getShape[i],"BaseProperties","flowphase"),
										"nodedesc":attrValue(getShape[i],"BaseProperties","nodedesc"),
										"nodetype":attrValue(getShape[i],"BaseProperties","nodetype"),
										"nodecode":attrValue(getShape[i],"BaseProperties","nodecode"),
										"opttype":attrValue(getShape[i],"BaseProperties","opttype"),
										"optcode":attrValue(getShape[i],"BaseProperties","optcode"),
										"optbean":attrValue(getShape[i],"BaseProperties","optbean"),
										"optparam":attrValue(getShape[i],"BaseProperties","optparam"),
										"subwfcode":attrValue(getShape[i],"BaseProperties","subwfcode"),
										"roletype":attrValue(getShape[i],"BaseProperties","roletype"),
										"rolecode":attrValue(getShape[i],"BaseProperties","rolecode"),
										"riskinfo":attrValue(getShape[i],"BaseProperties","riskinfo"),
										"isaccounttime":attrValue(getShape[i],"BaseProperties","isaccounttime"),
										"timeLimitType":attrValue(getShape[i],"BaseProperties","timeLimitType"),
										"inheritType":attrValue(getShape[i],"BaseProperties","inheritType")?attrValue(getShape[i],"BaseProperties","inheritType"):"0",
										"inheritNodeCode":attrValue(getShape[i],"BaseProperties","inheritNodeCode")?attrValue(getShape[i],"BaseProperties","inheritNodeCode"):"",
										"timeLimit":attrValue(getShape[i],"BaseProperties","timeLimit"),
										"isTrunkLine":attrValue(getShape[i],"BaseProperties","isTrunkLine"),
										"unitexp":attrValue(getShape[i],"BaseProperties","unitexp"),
										"powerexp":attrValue(getShape[i],"BaseProperties","powerexp"),
										"expireopt":attrValue(getShape[i],"BaseProperties","expireopt"),
										"desc":attrValue(getShape[i],"BaseProperties","desc"),
										"to":"",
										"from":"",
										"width":width,
										"height":height
							});

				var t = gText.text( dealStr(attrValue(getShape[i],"BaseProperties","name"),width) ).fill("#0000ff")
					 .x(parseInt(attrValue(getShape[i],"VMLProperties","x"))+5)
					 .y(parseInt(attrValue(getShape[i],"VMLProperties","y"))+(height/2)+6)
					 .attr({dx:parseInt(attrValue(getShape[i],"VMLProperties","x"))+(width/2),"shapeID":r.attr("id")})
					 .font({family:"Arial",size:14,"text-anchor":"middle"});
				r.attr({"textID":t.attr("id")});
				var points = parseInt(attrValue(getShape[i],"VMLProperties","x"))+","+(parseInt(attrValue(getShape[i],"VMLProperties","y"))+height-height/6)+" "+(parseInt(attrValue(getShape[i],"VMLProperties","x"))+width)+","+(parseInt(attrValue(getShape[i],"VMLProperties","y"))+height-height/6);
				var bingLine = gInnerLine.polyline().stroke({ color:"#0000ff",width: 1.3 }).fill("none")
				                    .attr({"points":points,
				                    	    'transform':"",
				                    	    "shapetype":"PolyLine",
				                    	    "id":"line_"+r.attr("id")}); 
				r.attr({"lineID":bingLine.attr("id")});
				break;
			case "multi":
					rectWidth = width;
					rectHeight = height;
					var r = gShape.rect(width,height).x(parseInt(attrValue(getShape[i],"VMLProperties","x"))).y(parseInt(attrValue(getShape[i],"VMLProperties","y")))
						  .stroke({color:"#0000ff",width:1.3}).fill("#fff")
						  .attr({rx:2,ry:2, "shapetype":"multi",
							                "filter":"url(#filter)",
										    "id":attrValue(getShape[i],"BaseProperties","id"),
										    "title":attrValue(getShape[i],"BaseProperties","name"),
											"flowphase":attrValue(getShape[i],"BaseProperties","flowphase"),
											"nodedesc":attrValue(getShape[i],"BaseProperties","nodedesc"),
											"nodetype":attrValue(getShape[i],"BaseProperties","nodetype"),
											"nodecode":attrValue(getShape[i],"BaseProperties","nodecode"),
											"opttype":attrValue(getShape[i],"BaseProperties","opttype"),
											"optcode":attrValue(getShape[i],"BaseProperties","optcode"),
											"optbean":attrValue(getShape[i],"BaseProperties","optbean"),
											"optparam":attrValue(getShape[i],"BaseProperties","optparam"),
											"subwfcode":attrValue(getShape[i],"BaseProperties","subwfcode"),
											"roletype":attrValue(getShape[i],"BaseProperties","roletype"),
											"rolecode":attrValue(getShape[i],"BaseProperties","rolecode"),
											"riskinfo":attrValue(getShape[i],"BaseProperties","riskinfo"),
											"isaccounttime":attrValue(getShape[i],"BaseProperties","isaccounttime"),
											"timeLimitType":attrValue(getShape[i],"BaseProperties","timeLimitType"),
											"inheritType":attrValue(getShape[i],"BaseProperties","inheritType")?attrValue(getShape[i],"BaseProperties","inheritType"):"0",
											"inheritNodeCode":attrValue(getShape[i],"BaseProperties","inheritNodeCode")?attrValue(getShape[i],"BaseProperties","inheritNodeCode"):"",
											"timeLimit":attrValue(getShape[i],"BaseProperties","timeLimit"),
											"isTrunkLine":attrValue(getShape[i],"BaseProperties","isTrunkLine"),
											"unitexp":attrValue(getShape[i],"BaseProperties","unitexp"),
											"powerexp":attrValue(getShape[i],"BaseProperties","powerexp"),
											"expireopt":attrValue(getShape[i],"BaseProperties","expireopt"),
											"desc":attrValue(getShape[i],"BaseProperties","desc"),
											"to":"",
											"from":"",
											"width":width,
											"height":height
								});

					var t = gText.text( dealStr(attrValue(getShape[i],"BaseProperties","name"),width) ).fill("#0000ff")
						 .x(parseInt(attrValue(getShape[i],"VMLProperties","x"))+5)
						 .y(parseInt(attrValue(getShape[i],"VMLProperties","y"))+(height/2)+6)
						 .attr({dx:parseInt(attrValue(getShape[i],"VMLProperties","x"))+(width/2),"shapeID":r.attr("id")})
						 .font({family:"Arial",size:14,"text-anchor":"middle"});
					r.attr({"textID":t.attr("id")});
					var points = parseInt(attrValue(getShape[i],"VMLProperties","x"))+","+(parseInt(attrValue(getShape[i],"VMLProperties","y"))+height-height/6)+" "+(parseInt(attrValue(getShape[i],"VMLProperties","x"))+width)+","+(parseInt(attrValue(getShape[i],"VMLProperties","y"))+height-height/6);
					var bingLine = gInnerLine.polyline().stroke({ color:"#0000ff",width: 1.3 }).fill("none")
					                    .attr({"points":points,
					                    	    'transform':"",
					                    	    'stroke-dasharray':4,
					                    	    "shapetype":"PolyLine",
					                    	    "id":"line_"+r.attr("id")}); 
					r.attr({"lineID":bingLine.attr("id")});
					break;
			case "R":
				rectWidth = width;
				rectHeight = height;
				var r = gShape.rect(width,height).x(parseInt(attrValue(getShape[i],"VMLProperties","x"))).y(parseInt(attrValue(getShape[i],"VMLProperties","y")))
					  .stroke({color:"#0000ff",width:1.3}).fill("skyblue")
					  .attr({rx:10,ry:10, "shapetype":"R",
						                "filter":"url(#filter)",
									    "id":attrValue(getShape[i],"BaseProperties","id"),
									    "title":attrValue(getShape[i],"BaseProperties","name"),
										"flowphase":attrValue(getShape[i],"BaseProperties","flowphase"),
										"nodedesc":attrValue(getShape[i],"BaseProperties","nodedesc"),
										"nodetype":attrValue(getShape[i],"BaseProperties","nodetype"),
										"nodecode":attrValue(getShape[i],"BaseProperties","nodecode"),
										"opttype":attrValue(getShape[i],"BaseProperties","opttype"),
										"optcode":attrValue(getShape[i],"BaseProperties","optcode"),
										"optbean":attrValue(getShape[i],"BaseProperties","optbean"),
										"optparam":attrValue(getShape[i],"BaseProperties","optparam"),
										"subwfcode":attrValue(getShape[i],"BaseProperties","subwfcode"),
										"roletype":attrValue(getShape[i],"BaseProperties","roletype"),
										"rolecode":attrValue(getShape[i],"BaseProperties","rolecode"),
										"riskinfo":attrValue(getShape[i],"BaseProperties","riskinfo"),
										"isaccounttime":attrValue(getShape[i],"BaseProperties","isaccounttime"),
										"timeLimitType":attrValue(getShape[i],"BaseProperties","timeLimitType"),
										"inheritType":attrValue(getShape[i],"BaseProperties","inheritType")?attrValue(getShape[i],"BaseProperties","inheritType"):"0",
									    "inheritNodeCode":attrValue(getShape[i],"BaseProperties","inheritNodeCode")?attrValue(getShape[i],"BaseProperties","inheritNodeCode"):"",
										"timeLimit":attrValue(getShape[i],"BaseProperties","timeLimit"),
										"isTrunkLine":attrValue(getShape[i],"BaseProperties","isTrunkLine"),
										"unitexp":attrValue(getShape[i],"BaseProperties","unitexp"),
										"powerexp":attrValue(getShape[i],"BaseProperties","powerexp"),
										"expireopt":attrValue(getShape[i],"BaseProperties","expireopt"),
										"desc":attrValue(getShape[i],"BaseProperties","desc"),
										"to":"",
										"from":"",
										"width":width,
										"height":height
							});

				var t = gText.text( dealStr(attrValue(getShape[i],"BaseProperties","name"),width) ).fill("#0000ff")
					 .x(parseInt(attrValue(getShape[i],"VMLProperties","x"))+5)
					 .y(parseInt(attrValue(getShape[i],"VMLProperties","y"))+(height/2)+6)
					 .attr({dx:parseInt(attrValue(getShape[i],"VMLProperties","x"))+(width/2),"shapeID":r.attr("id")})
					 .font({family:"Arial",size:14,"text-anchor":"middle"});
				r.attr({"textID":t.attr("id")});
				break;
					default:break;
		}
	}
	
	for( var j=0,jLen=getLine.length;j<jLen;j++ ){
		var line = gLine.polyline().stroke({ color:"#0000ff",width: 1.3 }).fill("none")
						.attr({'transform':"","marker-end":"url(#"+marker.attr("id")+")",
								"id":attrValue(getLine[j],"BaseProperties","id"),
								"title":attrValue(getLine[j],"BaseProperties","name"),
								"timeLimitType":attrValue(getLine[j],"BaseProperties","timeLimitType"),
								"inheritType":attrValue(getLine[j],"BaseProperties","inheritType")?attrValue(getLine[j],"BaseProperties","inheritType"):"0",
								"inheritNodeCode":attrValue(getLine[j],"BaseProperties","inheritNodeCode")?attrValue(getLine[j],"BaseProperties","inheritNodeCode"):"",		
								"timeLimit":attrValue(getLine[j],"BaseProperties","timeLimit"),
								"cond":attrValue(getLine[j],"BaseProperties","cond"),
								"desc":attrValue(getLine[j],"BaseProperties","desc"),
								"shapetype":"polyline",
								"points":changePt(attrValue(getLine[j],"VMLProperties","points")),
								"from":attrValue(getLine[j],"BaseProperties","from"),
								"to":attrValue(getLine[j],"BaseProperties","to"),
								"labID":attrValue(getLine[j],"LabelProperties","id")
							  });
		var f = SVG.get(attrValue(getLine[j],"BaseProperties","from")),		
			t = SVG.get(attrValue(getLine[j],"BaseProperties","to"));
		f.attr("from",f.attr("from").length==0?attrValue(getLine[j],"BaseProperties","id"):f.attr("from")+","+attrValue(getLine[j],"BaseProperties","id"));
		t.attr("to",t.attr("to").length==0?attrValue(getLine[j],"BaseProperties","id"):t.attr("to")+","+attrValue(getLine[j],"BaseProperties","id"));
		g("lineCon").innerHTML+=("<div class='step' style='left:"+attrValue(getLine[j],"LabelProperties","x")+";top:"+attrValue(getLine[j],"LabelProperties","y")+";' id='"+attrValue(getLine[j],"LabelProperties","id")+"'>"+attrValue(getLine[j],"BaseProperties","name")+"</div>");
	}
	$("#canvas").height(document.body.scrollHeight+50);//高度适应
	//$("#argumentTool").height(parseInt($("body").height())-50);
	$("#argumentContent").height(parseInt($("body").height())-100);
	SVG.get("s3").attr({"flow_id":nodeValue(xmlDoc,"flow_id"),
						"flow_code":nodeValue(xmlDoc,"flow_code"),
						"flow_title":nodeValue(xmlDoc,"flow_title")});
}

//初始化，如果存在xml则生成流程图，如果没有，则初始化开始画流程图
function initDraw(xml){
	if(xml){
		loadXml(xml,canvas);
	}else{
		var begin = gShape.circle(50).cx(400).cy(100).stroke({width:1,color:"#0000ff"}).fill("#fff").attr({"type":"circle","shapetype":"Oval","flowphase":"0","nodedesc":"", "nodetype":"A", "opttype":"A", "optcode":"", "optbean":"", "optparam":"", "subwfcode":"", "roletype":"0", "rolecode":"0", "isaccounttime":"F", "timeLimitType":"I", "timelimit":"","isTrunkLine":"", "unitexp":"P", "powerexp":"", "expireopt":"", "desc":"","width":50,"height":50});
		var beginText = gText.text("开始").x(400).y(106).attr({dx:400,"textWeight":"9pt", "strokeWeight":"1", "zIndex":"1","shapeID":begin.attr("id")}).font({family:"Arial",size:14,"text-anchor":"middle"});
		var end = gShape.circle(50).cx(400).cy(300).stroke({width:1,color:"#0000ff"}).fill("#fff").attr({"type":"circle","shapetype":"Oval","flowphase":"0","nodedesc":"", "nodetype":"F", "opttype":"A", "optcode":"", "optbean":"", "optparam":"", "subwfcode":"", "roletype":"0", "rolecode":"0", "isaccounttime":"F", "timeLimitType":"I", "timelimit":"","isTrunkLine":"", "unitexp":"P", "powerexp":"", "expireopt":"", "desc":"","width":50,"height":50});
		var endText = gText.text("结束").x(400).y(306).attr({dx:400,"textWeight":"9pt", "strokeWeight":"1", "zIndex":"1","shapeID":end.attr("id")}).font({family:"Arial",size:14,"text-anchor":"middle"});
		begin.attr({"textID":beginText.attr("id"),"title":"开始","name":"begin"});
		end.attr({"textID":endText.attr("id"),"title":"结束","name":"end"});
		
	}
}

//改变鼠标指针样式，以便进行拉伸
function zoomScale(e){
	  var e = e || window.event;
	  var target = e.target || e.srcElement;
	  if(target.nodeName=="polyline"||target.nodeName=="ellipse"||target.nodeName=="rect"||target.nodeName=="polygon"||target.nodeName=="text"){
		  g(target.id).style.cursor = "pointer";
		  /* if($.browser.mozilla && $.browser.version=="11.0"&&target.nodeName=="polyline"){
			  target.setAttribute("marker-end","url(#"+markerBlue.attr("id")+")");
		  } */
	  }
	  if(target.nodeName=="rect"){
		var obj = g(target.id);
		var rightSide=(parseInt(obj.getAttribute("x"))+parseInt(obj.getAttribute("width"))-(e.clientX+document.body.scrollLeft)/_ZOOM<=2*_ZOOM);
		var bottomSide=(parseInt(obj.getAttribute("y"))+parseInt(obj.getAttribute("height"))-(e.clientY+document.body.scrollTop)/_ZOOM<=2*_ZOOM);
		if(rightSide&&bottomSide) {
			obj.style.cursor="nw-resize";
			moveflag = 0;
		}
		else if(rightSide) {
			obj.style.cursor="e-resize";
			moveflag = 0;
		}
		else if(bottomSide) {
			obj.style.cursor="n-resize";
			moveflag = 0;
		}
		else{
			obj.style.cursor="pointer";
			moveflag = 1;
		}
	  }
	  else{
		  moveflag = 1;
	  }
}

//
   function removePoint(e){
	var e = e || window.event;
	var target = e.target || e.srcElement;
	if(target.nodeName!="polyline"){
		return;
	}
	var pointArray = new Array,
	points = target.getAttribute("points").split(" ");
	
    for( var i=0,len=points.length;i<len;i++ ){
	  var cp = points[i].split(",");
	  pointArray.push([cp[0],cp[1]]);	
      }
    for(var h=1,hLen=pointArray.length;h<hLen-1;h++ ){
	    if(Math.abs((e.clientX+document.body.scrollLeft)/_ZOOM-pointArray[h][0])<10&&Math.abs((e.clientY+document.body.scrollTop)/_ZOOM-pointArray[h][1])<10){
		   //var circle = gCircle.circle(8).cx(pointArray[h][0]+3).cy(pointArray[h][1]+3).stroke({color:"blue"}).fill("blue").attr({"lineID":line.getAttribute("id")});
		   //target.removeAttribute("marker-end");
		   deletePoint(target,h);
		   target.setAttribute("marker-end","url(#"+markerGreenElse.attr("id")+")");
		   pushLog("moveproc",{"ID":target.id,"beginX":pointArray[h][0],"beginY":pointArray[h][1],"nPoint":h,"type":"delete"});
		   //circle.remove();
	      }
      }
}

   function hideTool(){
	   if($("#argumentContent").is(":hidden")){
		   $("#argumentTitle").css("background","#0066ff");		   
		   $("#argumentNoUse").show();
		   $("#argumentContent").show();
		   document.all("hideImg").src = path+ "/page/workflow/image/up.gif";
		   document.all("hideImg").title = "单击收缩工具栏";
	   }
	   else{
		   $("#argumentNoUse").hide();
		   $("#argumentContent").hide();
		   $("#argumentTitle").css("background","#D4D0C8");
		   document.all("hideImg").src = path+ "/page/workflow/image/down.gif";
		   document.all("hideImg").title = "单击展开工具栏";
	   }
   }
   
   function setZoom(act){
	    var rate=act=="big"?0.2:-0.2;
		var newzoom=_ZOOM+rate;
		if(newzoom>2)return ;
		if(newzoom<0.2)return ;
		_ZOOM=parseFloat(parseFloat(newzoom).toFixed(2));
		canvas.style.zoom=_ZOOM;
		g("lineCon").style.zoom = _ZOOM;
		document.all("zoomshow").value=_ZOOM;
   }
   
   function changeZoom(act){
	   _ZOOM=parseFloat(parseFloat(act).toFixed(2));
		canvas.style.zoom=_ZOOM;
		g("lineCon").style.zoom = _ZOOM;
		document.all("zoomshow").value=_ZOOM;
   }
   
   function replacetoxml(str)
   {
   	if (str){
   	var str2;
   	str2=str.replace(/&/g,"&amp;");
   	str2=str2.replace(/</g,"&lt;");
   	str2=str2.replace(/>/g,"&gt;");
   	str2=str2.replace(/"/g,"&quot;");
   	str2=str2.replace(/'/g,"&apos;");
   	return str2;		
   	}
   	else{
   		return "";
   	}
   }
   
   function rightEvent(e){
	   var e = e || window.event;
	   if(selectTag){
			selectTag.style.backgroundColor = "buttonface";
		}
	   //g("default").style.backgroundColor = "buttonface";
	   g("default").parentNode.style.backgroundColor = "#888";
	   selectTag = g("default").parentNode;
	   document.all.canvas.style.cursor = "default";
	   flag =1;
	   image="default";
	   return false;
   }
   

//移动操作工具栏
moveTip( g("tool"),g("move") );
moveTip( g("argumentTool"),g("argumentTitle") );
//改变鼠标指针样式，以便进行拉伸
addEvent(canvas,"mousemove",zoomScale);

//删除过程
addEvent(g("delete"),"click",function(){deletePro(o)});

//绑定初始化
addEvent(document.body,"mousedown",init);
addEvent(canvas,"mousedown",selectImage);
document.ondblclick = removePoint;
document.oncontextmenu=rightEvent;
//xml的生成
addEvent(g("toxml"),"mousedown",getXml);
getData();
initDraw(xml);
</script>
</body>
</html>

