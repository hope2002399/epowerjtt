<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns:v="urn:schemas-microsoft-com:vml">
<HEAD>

<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
<meta name="decorator" content="noneWorkFlow"/>

<% String path = request.getContextPath(); %>

<TITLE>${ wfname }-在线工作流设计</TITLE>

<link href="<%=path%>/page/workflow/css/style.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="<%=path%>/page/workflow/vml/js/common.js"></script>
<script type="text/javascript" src="<%=path%>/page/workflow/vml/js/dtree.js"></script>
<script type="text/javascript" src="<%=path%>/page/workflow/vml/js/shape.js"></script>
<script type="text/javascript" src="<%=path%>/page/workflow/vml/js/toppanel.js"></script>
<script type="text/javascript" src="<%=path%>/page/workflow/vml/js/topflow.js"></script>
<script type="text/javascript" src="<%=path%>/page/workflow/vml/js/topflowevent.js"></script>
<script type="text/javascript" src="<%=path%>/page/workflow/vml/js/contextmenu.js"></script>
<script language="javascript" src="<%=path%>/scripts/jquery-1.6.min.js" ></script>

<SCRIPT type="text/javascript">

if(!(navigator.userAgent.toLowerCase().indexOf("msie")>0))
alert('本流程图设计使用VML,只能在IE下使用！');
//startup
var _TREE;
var Data;
var xml;
var path='<%=path%>';
var flowCode='${flowCode}';
var version='${version}';
var optid='${object.optId}';


//function
function DrawTree() {
	_TREE=new dTree('_TREE','<%=path%>/page/workflow/image/');
	var num=3,obj,i;
	var FocusColor=_FLOW.Config.ProcFocusedStrokeColor;
	_TREE.add(0,-1,' '+_FLOW.Text+'','javascript:','',_FLOW.ID);
	_TREE.add(1,0,'任务','javascript:','','Procs','','<%=path%>/page/workflow/image/task.gif','<%=path%>/page/workflow/image/task.gif');
	_TREE.add(2,0,'路径','javascript:','','Steps','','<%=path%>/page/workflow/image/step.gif','<%=path%>/page/workflow/image/step.gif');
	for(i=0;i<_FLOW.Procs.length;i++) {
		obj=_FLOW.Procs[i];
		_TREE.add(num++,1,obj.Text,'javascript:objFocusedOn("'+obj.ID+'");','',obj.ID,'','<%=path%>/page/workflow/image/obj4.gif','<%=path%>/page/workflow/image/obj4.gif');
	}
	for(i=0;i<_FLOW.Steps.length;i++) {
		obj=_FLOW.Steps[i];
		_TREE.add(num++,2,obj.Text,'javascript:objFocusedOn("'+obj.ID+'");','',obj.ID,'','<%=path%>/page/workflow/image/obj4.gif','<%=path%>/page/workflow/image/obj4.gif');
	}
	treeview.innerHTML=_TREE;
}
function DrawDataView() {
	var idTR,idTD,arr=_FLOW.DataView();
	for(var i=dataview.rows.length-1;i>0;i--)
	dataview.deleteRow(i);
	for(var i=0,u=1;i<arr.length;i++) {
		idTR=dataview.insertRow();
		idTR.onmouseover=new Function("this.className=\"focusLine\";");
		idTR.onmouseout=new Function("this.className=\"normalLine\";");
		idTR.height="22";
		idTD=idTR.insertCell();
		idTD.innerHTML=arr[i].ProcID+"("+arr[i].ProcText+")";
		idTD=idTR.insertCell();
		idTD.innerHTML=arr[i].Idx;
		idTD=idTR.insertCell();
		idTD.innerHTML=arr[i].PreProcID+"("+arr[i].PreProcText+")";
		idTD=idTR.insertCell();
		idTD.innerHTML=arr[i].Cond+"&nbsp;";
	}
	mergecell(dataview);
}
function DrawVML() {
	Canvas.innerHTML=_FLOW.ProcString();
	Canvas.innerHTML+=_FLOW.StepString();
	_FLOW.getInnerObject();
	_FOCUSTEDOBJ=null;
	
	stuffProp();
}
function DrawAll() {
	//DrawTree();
	DrawVML();
	//DrawDataView();
}

//名称:createProcTypeOption
//说明:ajax与后台交互取数据
//参数:无
//作者:xc
//时间:2011-11-9

function getData(){

	
	$.ajax({
		type:"POST",
		url:"<%=path%>/sampleflow/sampleFlowDefine!getdataMap.do?flowCode=${object.flowCode}",
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

function LoadFlow(xml) {
	if(xml=="")
	_FLOW.createNew("");
	else
	_FLOW.loadFromXML(xml);
	DrawAll();
	emptyLog();
}
function ObjSelected() {
	if(_FOCUSTEDOBJ==null) {
		alert("当前没有选中对象！--用鼠标单击流程图上的对象可以选中它");
		return false;
	}
	return true;
}


function mnuNewFlow() {
	if(_FLOW.Modified)
	if(!confirm("当前流程图尚未保存，新建新文件将会放弃所有修改，继续新建吗？"))return ;
	var flow=new TTopFlow("");
	flow.FileName="untitled.xml";
	if(openWin("flow.htm",flow,350,200)) {
		LoadFlow("");
		_FLOW.FileName=flow.FileName;
		_FLOW.Text=flow.Text;
		_FLOW.Password=flow.Password;
		DrawTree();
		delete flow;
	}
} 
function mnuEditFlow() {
	if(openWin("flow.htm",_FLOW,350,200)) {
		DrawTree();
	}
}
function mnuValidateFlow() {
	var s=_FLOW.validate();
	if(s=="")
	alert("校验完成，这是一个合法的流程图！");                                                
	else
	alert(s);
}
function mnuOpenFlow() {                     
	if(_FLOW.Modified)
	if(!confirm("当前流程图尚未保存，打开新文件将会放弃所有修改，继续打开吗？"))return ;
	if(openWin("filelist.jsp",_FLOW,450,400))
	LoadFlow(_FLOW.FileName);
}
function mnuSaveFlow() {
	/* if(!confirm("确定要保存当前流程图["+_FLOW.FileName+"]吗？"))return ; */
	
	//var s=_FLOW.validate();
	//if(s!="")
	//if(!confirm("当前有效性检查有误\n\n"+s+"\n\n是否要继续保存？"))return ;
	
 	var s=_FLOW.validationFlow();
 	if(s!=""){
	if(!confirm(s+"\n\n是否要继续保存该流程？"))
		return; 
 	}
	try{
		//var c=
		_FLOW.validationFlow();
		//alert(c);
		//if(c){
		var s=_FLOW.SaveToXML();
		//}
	}
	catch(e) {
		alert(e);
	}
}
function mnuReloadFlow() {
	if(_FLOW.Modified)
	if(!confirm("当前流程图尚未保存，重新载入将会放弃所有修改，继续重载吗？"))return ;
	LoadFlow(xml);
}
//[流程图对象]菜单处理事件
function mnuAddProc() {
	var Proc=new TProc(_FLOW);
	if(openWin("proc.htm",Proc,450,350)) {
		_FLOW.addProc(Proc);
		pushLog("addproc",Proc);
		DrawAll();
	}
}
function mnuAddStep() {
	var Step=new TStep(_FLOW);
	if(openWin("step.htm",Step,500,350)) {
		_FLOW.addStep(Step);
		pushLog("addstep",Step);
		DrawAll();
	}
}
function mnuCopyProc() {
	if(!ObjSelected())return ;
	if(_FOCUSTEDOBJ.typ!="Proc") {
		alert("只有任务可以复制！");
		return ;
	}
	var curProc=_FLOW.getProcByID(_FOCUSTEDOBJ.id);
	if(!confirm("确定要复制任务["+curProc.Text+"]吗？"))return ;
	var Proc=new TProc(_FLOW);
	var iID=Proc.ID;
	Proc.clone(curProc);
	Proc.ID=iID;
	Proc.X=parseInt(curProc.X)+10;
	Proc.Y=parseInt(curProc.Y)+10;
	_FLOW.addProc(Proc);
	pushLog("addproc",Proc);
	DrawAll();
	objFocusedOn(iID);
	mnuSetZIndex("F");
}
function mnuEditObj() {
	if(!ObjSelected())return ;
	if(_FOCUSTEDOBJ.typ!="Proc"&&_FOCUSTEDOBJ.typ!="Step")return ;
	if(_FOCUSTEDOBJ.typ=="Proc")
	editProc(_FOCUSTEDOBJ.id);
	else
	editStep(_FOCUSTEDOBJ.id);
}
function mnuDelObj() {
	if(ObjSelected())deleteObj(_FOCUSTEDOBJ.id);
}
function mnuSetZIndex(Act) {
	if(!ObjSelected())return ;
	if(_FOCUSTEDOBJ.typ!="Proc"&&_FOCUSTEDOBJ.typ!="Step")return ;
	if(_FOCUSTEDOBJ.typ=="Proc")
	var obj=_FLOW.getProcByID(_FOCUSTEDOBJ.id);
	else
	var obj=_FLOW.getStepByID(_FOCUSTEDOBJ.id);
	var oldValue=obj.zIndex;
	if(Act=="F")
	_FLOW.brintToFront(obj);
	else
	_FLOW.sendToBack(obj);
	_FOCUSTEDOBJ.style.zIndex=obj.zIndex;
	pushLog("editprop",{
		"obj":obj,"prop":"zIndex","_old":oldValue,"_new":obj.zIndex
	});
}
//[系统菜单]处理事件
function mnuOption() {
	if(openWin("option.htm",_FLOW.Config,510,510)) {
		DrawAll();
	}
}
function mnuDemo() {
	var tmpwin=window.open("demo.htm");
	tmpwin.focus();
}

function mnuFileMgr() {
	openWin("filemgr.jsp","",450,400);
}
function mnuAbout() {
	openWin("about.htm","",480,460);
}
function mnuExit() {
	if(confirm("确定要退出本次编辑吗？")) {
		window.opener=null;
		//parent.$.history.back(window.frameElement);
		window.history.go(-1);
	}
}
function mnuSetZoom(Act) {
	var rate=Act=="in"?0.2:-0.2;
	var newzoom=_ZOOM+rate;
	if(newzoom>2)return ;
	if(newzoom<0.2)return ;
	changeZoom(newzoom);
	document.all("zoomshow").value=_ZOOM;
}
function changeZoom(v) {
	_ZOOM=parseFloat(parseFloat(v).toFixed(2));
	Canvas.style.zoom=_ZOOM;
}
function mnuTurnToolbox() {
	tbxToolbox.VisibleEx=!tbxToolbox.VisibleEx;
	tbxToolbox.InnerObject.style.display=tbxToolbox.VisibleEx?"block":"none";
	document.all.mnu_win_toolbox.innerHTML=(tbxToolbox.VisibleEx?"隐藏":"显示")+"工具箱";
}
function mnuTurnPropbox() {
	tbxPropbox.VisibleEx=!tbxPropbox.VisibleEx;
	tbxPropbox.InnerObject.style.display=tbxPropbox.VisibleEx?"block":"none";
	document.all.mnu_win_propbox.innerHTML=(tbxPropbox.VisibleEx?"隐藏":"显示")+"属性框";
}
function mnuTurnObjView() {
	tbxObjView.VisibleEx=!tbxObjView.VisibleEx;
	tbxObjView.InnerObject.style.display=tbxObjView.VisibleEx?"block":"none";
	document.all.mnu_win_objview.innerHTML=(tbxObjView.VisibleEx?"隐藏":"显示")+"对象视图";
}
function mnuTurnDataView() {
	tbxDataView.VisibleEx=!tbxDataView.VisibleEx;
	tbxDataView.InnerObject.style.display=tbxDataView.VisibleEx?"block":"none";
	document.all.mnu_win_dataview.innerHTML=(tbxDataView.VisibleEx?"隐藏":"显示")+"数据视图";
}

   
</SCRIPT>
<style type="text/css">
	#tbxPropbox { position:fix; }
</style>
</HEAD>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" style='background-image: url(<%=path%>/page/workflow/image/canvasbg.gif);'>
<input id="xml" type="hidden" value='${flowXmlDesc}'></input>
<input id="path" type="hidden" value="<%=path%>">

<div style='left:0px;top:0px;width:100%;position:absolute;z-index:-1000' id="Canvas">
</div>
<v:rect class="toolui" style="display:none" id="_rectui">
<v:Stroke dashstyle="dashdot"/>
</v:rect>
<v:roundrect class="toolui" style="display:none;left:0px;top:0px;width:60px;height:50px;" id="_roundrectui">
<v:Stroke dashstyle="dashdot"/>
</v:roundrect>
<v:shape type="#diamond" class="toolui" style="display:none;left:0px;top:0px;width:60px;height:50px;" strokeweight="1px" id="_diamondui">
<v:Stroke dashstyle="dashdot"/>
</v:shape>
<v:oval class="toolui" style="display:none;left:0px;top:0px;width:60px;height:50px;" id="_ovalui">
<v:Stroke dashstyle="dashdot"/>
</v:oval>
<v:line class="toolui" style="display:none" from="0,0" to="100,0" id="_lineui">
<v:Stroke dashstyle="dashdot" StartArrow="" EndArrow="Classic"/>
</v:line>
<div id=msg></div>
<SCRIPT type="text/javascript">

var bodyHeight = $('body').height();
function NavBrush_onClick(obj) {
	//清除所有的ButtonClass
	var objs=document.all("tbxToolbox_btn");
	for(var i=0;i<objs.length;i++)
	objs[i].className="bon2";
	obj.className="bon1";
	_TOOLTYPE=obj.cType;
	
}
	S='<table width="100%" height="100%" cellspacing="0" cellpadding="0">'+
	'<tr>'+
	'<td bgcolor="buttonface" valign="top" align="center">'+
	'<div id="tableContainer2" class="tableContainer">'+
	'<table id="propview" border="0" cellpadding="0" cellspacing="0" width="100%" class="scrollTable"> '+
	'<thead class="fixedHeader2"> '+
	'<tr height="22" bgcolor="#CCCCFF">'+
	'<td width="90">属性</td><td>值</td>'+
	'</tr>'+
	'</thead> '+
	'<tbody class="scrollContent"> '+
	'</tbody> '+
	'</table> '+
	'</div> '+
	'</td>'+
	'</tr>'+
	'</table>';
	var tbxPropbox=new TToolBox("tbxPropbox","属性",document.body.offsetWidth-350,0,255,bodyHeight,S,"down",true);
	var S='<table cellspacing="0" cellpadding="0" border="0">'+
	'<tr height="25"><td width="2"></td>'+
	
	
	'<td width="20" align="center" title="保存流程图 Ctrl+S"><BUTTON class="normalBtn" onmouseover="this.className=\'focusBtn\'" onmouseout=\"this.className=\'normalBtn\'" HIDEFOCUS="true" onclick="mnuSaveFlow();"><img src="<%=path%>/page/workflow/image/save.gif" border="0"></BUTTON></td>'+
	'<td width="20" align="center" title="校验流程图"><BUTTON class="normalBtn" onmouseover="this.className=\'focusBtn\'" onmouseout=\"this.className=\'normalBtn\'" HIDEFOCUS="true" onclick="mnuValidateFlow();"><img src="<%=path%>/page/workflow/image/validate.gif" border="0"></BUTTON></td>'+
	'<td width="4" background="<%=path%>/page/workflow/image/split.gif"></td>'+
	'<td width="23" align="center" title="删除选中对象 Del"><BUTTON class="normalBtn" onmouseover="this.className=\'focusBtn\'" onmouseout=\"this.className=\'normalBtn\'" HIDEFOCUS="true" onclick="mnuDelObj();"><img src="<%=path%>/page/workflow/image/del_obj.gif" border="0"></BUTTON></td>' +
	//'<td width="23" align="center" title="修改选中对象"><BUTTON class="normalBtn" onmouseover="this.className=\'focusBtn\'" onmouseout=\"this.className=\'normalBtn\'" HIDEFOCUS="true" onclick="mnuEditObj();"><img src="<%=path%>/page/workflow/image/edit_obj.gif" border="0"></BUTTON></td>' +
	
	
	
	
	'<td width="2" align="center" title="选择对象\n\n1.单击本按钮\n2.在工作区(画布)上单击[任务]或[路径]的图形"><BUTTON cType="point" class="bon1" id="tbxToolbox_select" name="tbxToolbox_btn" HIDEFOCUS="true" onclick="NavBrush_onClick(this);"><v:PolyLine filled="false" Points="0,0 0,16 5,12 9,20 12,18 8,10 12,8 0,0" style="position:relative;" strokeweight="1"/></BUTTON></td>'+
	'<td align="center"></td>'+
	''+
	'<td align="center" title="新增[任务](圆角形)\n\n1.单击本按钮\n2.在工作区(画布)上空白位置按住左键\n3.拉动鼠标\n4.松开鼠标左键"><BUTTON cType="roundrect" class="bon2" name="tbxToolbox_btn"  HIDEFOCUS="true" onclick="NavBrush_onClick(this);"><v:RoundRect style="position:relative;left:1px;top:1px;width:20px;height:20px;" strokeweight="1" filled="F"></v:RoundRect></BUTTON></td>'+
	//'<td width="20" align="center" title="新增[分支节点](菱形)\n\n1.单击本按钮\n2.在工作区(画布)上空白位置按住左键\n3.拉动鼠标\n4.松开鼠标左键"><BUTTON cType="diamond" class="bon2" name="tbxToolbox_btn"  HIDEFOCUS="true" onclick="NavBrush_onClick(this);"><v:shape type="#diamond" style="position:relative;width:20;height:20;left:0;top:0;" strokeweight="1px" filled="F"></v:shape></BUTTON></td>'+
	//'<td width="20" align="center" title="新增[汇聚节点](方形)\n\n1.单击本按钮\n2.在工作区(画布)上空白位置按住左键\n3.拉动鼠标\n4.松开鼠标左键"><BUTTON cType="rect" class="bon2" name="tbxToolbox_btn"  HIDEFOCUS="true" onclick="NavBrush_onClick(this);"><v:rect filled="F" style="position:relative;left:1px;top:1px;width:10px;height:20px;background-color:#cccccc;" strokeweight="1px"/></BUTTON></td>'+
	'<td width="20" align="center" title="新增[路径](折角线)\n\n1.单击本按钮\n2.在[任务]图形(起点)上按住鼠标左键\n3.拉动鼠标至某[任务]图形(终点)中间位置\n4.松开鼠标左键"><BUTTON cType="polyline" class="bon2" name="tbxToolbox_btn"  HIDEFOCUS="true" onclick="NavBrush_onClick(this);"><v:PolyLine filled="false" Points="0,20 10,5 20,20" style="position:relative;" strokeweight="1"><v:stroke EndArrow="Classic"/></v:PolyLine></BUTTON></td>'+
	
	
	'<td width="4" background="<%=path%>/page/workflow/image/split.gif"></td>'+
	'<td width="23" align="center" title="放大显示比例 Ctrl++"><BUTTON class="normalBtn" onmouseover="this.className=\'focusBtn\'" onmouseout=\"this.className=\'normalBtn\'" HIDEFOCUS="true" onclick="mnuSetZoom(\'in\');"><img src="<%=path%>/page/workflow/image/zoomin.gif" border="0"></BUTTON></td>'+
	
	
	
	'<td width="35" align="center" title="显示比例"><select id="zoomshow" style="width:50px;" onchange="changeZoom(this.value);"><option value="0.2">20%</option><option value="0.4">40%</option><option value="0.6">60%</option><option value="0.8">80%</option><option value="1" selected>100%</option><option value="1.2">120%</option><option value="1.4">140%</option><option value="1.6">160%</option><option value="1.8">180%</option><option value="2">200%</option></select></td>'+
	
	
	
	
	'<td width="23" align="center" title="缩小显示比例 Ctrl+-"><BUTTON class="normalBtn" onmouseover="this.className=\'focusBtn\'" onmouseout=\"this.className=\'normalBtn\'" HIDEFOCUS="true" onclick="mnuSetZoom(\'out\');"><img src="<%=path%>/page/workflow/image/zoomout.gif" border="0"></BUTTON></td>'+
	<%-- '<td width="23" align="center" title="将选中对象置于最顶层"><BUTTON class="normalBtn" onmouseover="this.className=\'focusBtn\'" onmouseout=\"this.className=\'normalBtn\'" HIDEFOCUS="true" onclick="mnuSetZIndex(\'F\');"><img src="<%=path%>/page/workflow/image/front.gif" border="0"></BUTTON></td>'+
	'<td width="23" align="center" title="将选中对象置于最底层"><BUTTON class="normalBtn" onmouseover="this.className=\'focusBtn\'" onmouseout=\"this.className=\'normalBtn\'" HIDEFOCUS="true" onclick="mnuSetZIndex(\'B\');"><img src="<%=path%>/page/workflow/image/back.gif" border="0"></BUTTON></td>'+ --%>
	'<td width="23" align="center" title="撤消最后一次操作 Ctrl+Z"><BUTTON class="normalBtn" onmouseover="this.className=\'focusBtn\'" onmouseout=\"this.className=\'normalBtn\'" HIDEFOCUS="true" onclick="undoLog();"><img src="<%=path%>/page/workflow/image/undo.gif" border="0"></BUTTON></td>'+
	'<td width="23" align="center" title="恢复最后一次取消的操作 Ctrl+Y/Ctrl+Shift+Z"><BUTTON class="normalBtn" onmouseover="this.className=\'focusBtn\'" onmouseout=\"this.className=\'normalBtn\'" HIDEFOCUS="true" onclick="redoLog();"><img src="<%=path%>/page/workflow/image/redo.gif" border="0"></BUTTON></td>'+
	'<td width="4" background="<%=path%>/page/workflow/image/split.gif"></td>'+
	//'<td width="23" align="center" title="关于"><BUTTON class="normalBtn" onmouseover="this.className=\'focusBtn\'" onmouseout=\"this.className=\'normalBtn\'" HIDEFOCUS="true" onclick="mnuAbout();"><img src="<%=path%>/page/workflow/image/qa.gif" border="0"></BUTTON></td>'+
	'<td width="23" align="center" title="返回"><BUTTON class="normalBtn" onmouseover="this.className=\'focusBtn\'" onmouseout=\"this.className=\'normalBtn\'" HIDEFOCUS="true" onclick="mnuExit();"><img src="<%=path%>/page/workflow/image/exit.gif" border="0"></BUTTON></td>'+
	'<td width="2"></td></tr>'+
	'</table>';

	var tbxToolbar = new TToolPanel("tbxToolbar", 0, 0, 350, 25, S);

	xml=$("#xml").attr("value");
	
	//alert(path);
	//alert(xml);
	//tbxObjView.showBox();
	getData();
	LoadFlow(xml);
	document.all("zoomshow").value = _ZOOM;
    /* var timer;
    
    $(window).resize(function(event){
    	
	   	 if(timer){
			 clearTimeout(timer);
		 }
		 timer = setTimeout(function(){
			window.location.reload();
		 },50);
	 }); */
    
var msg = document.all('msg');
$("#Canvas").height(document.body.scrollHeight);
function show(str)
{
  
  msg.innerHTML='<br>'+str;
}
 $(function(){
	$(window).bind('scroll',function(){
		$("#tbxPropbox").css({'top':document.body.scrollTop});
		$("#tbxToolbar").css({'top':document.body.scrollTop});
	});
}); 
</script>

</BODY>
</HTML>

