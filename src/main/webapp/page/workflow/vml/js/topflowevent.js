/*--------------------------------------------------|
s| 本作品取得原作者授权修改自 support@tops.com.cn    |
| 的作品topflow                                     |
|                                                   |
| 本文件是CommitFlow的事件处理文件                  |
|                                                   |
| 版权归上海雪线信息技术有限公司所有，              |
| 技术支持：sales@shcommit.com （仅对付费用户）     |
| 网    站：www.shcommit.com                        |
|                                                   |
| 请勿私自拷贝、修改或用于商业用途                  |
| 敬请保留本注释.                                   |
|                                                   |
| Updated: 20090620                                 |
|--------------------------------------------------*/
//global variable
var _FLOW=new TTopFlow("");
var _TOOLTYPE="point";
var _CURRENTX=_CURRENTY=0;
var _FOCUSTEDOBJ=null;
var _ZOOM=1;
var _MOVEOBJ=null;
var _MOVETYPE="";
var _DOLOG=[];
var _DOLOGINDEX=-1;
//-------------------------
var _strPt1="";
var _strPt2="";
var _strSltPt="";
var _strLine1="";
var _strLine2="";
var _strSltLine="";
var _PointOrLine;
var isSelectPoint=0;
var isSelectLine=0;
var _clkPx=0;
var _clkPy=0;
var ptMoveType="";
var oOval=null;
var _logMoveType="";
var _MOVELINEOBJ=null;
var Data=null;

//选中流程图元素对象，显示选中效果
function objFocusedOn(objId) {
	//清除原来选中的对象
	objFocusedOff();
	_FOCUSTEDOBJ=document.getElementById(objId);         //注意这里 根据id取对象
	if(_FOCUSTEDOBJ!=null)
	{
		_FOCUSTEDOBJ.StrokeColor=_FOCUSTEDOBJ.fsc;
		_FOCUSTEDOBJ.StrokeWeight=1.2;
		if(document.getElementById("h-"+objId)){
			var _FOCUS_HR = document.getElementById("h-"+objId);
			var obj=_FLOW.getProcByID(_FOCUSTEDOBJ.id);		
			_FOCUS_HR.style.color = _FOCUSTEDOBJ.fsc;
			_FOCUS_HR.style.height = "2px";	
				if(obj.ShapeType=="multi"){
					_FOCUS_HR.style.border = "2px dashed "+_FOCUSTEDOBJ.fsc;
				}
		}
		
	}
	var x=(event.x+document.body.scrollLeft)/_ZOOM;
	var y=(event.y+document.body.scrollTop)/_ZOOM;
	_clkPx=x/4*3+"pt";
	_clkPy=y/4*3+"pt";
	//如果是折线则修改折线形状
	if(_FOCUSTEDOBJ.tagName=="PolyLine")
	{
		modifyStepShape(_FOCUSTEDOBJ,x,y);
	}
	stuffProp();
}
//名称:createOval
//说明:创建小圆点
//作者:fxf
//时间:2009-06-20
function createOval(x,y)
{
	oOval=document.createElement("v:oval");
	oOval.style.position="absolute";
	oOval.style.width="6px";
	oOval.style.height="6px";
	oOval.style.left=x;
	oOval.style.top=y;
	oOval.fillcolor="red";
	oOval.strokecolor="red";
	document.body.appendChild(oOval);
}
//名称:getMinMod
//说明:获取和c差值最小的可以被m整除的整数
//作者:fxf
//时间:2009-06-20
function getMinMod(c,m)
{
	var iMin=0;
	var k=0;
	c=Math.round(c);
	for(var i=c-m/2;i<c+m/2;i++)
	{
		if(i%m==0)
		{
			if(k==0)
			{
				iMin=i;
			}
			else
			{
				if(Math.abs(i-c)<Math.abs(iMin-c))
				{
					iMin=i;
				}
			}
			k++;
		}
	}
	return iMin;
}
//名称:getNearPt
//说明:获取当前点到当前对象的8个点中最近的点
//作者:fxf
//时间:2009-06-20
function getNearPt(oProc,x,y)
{
	var objProc=document.getElementById(oProc.ID);
	var fromW=parseInt(objProc.style.width);
	var fromH=parseInt(objProc.style.height);
	var fromX=parseInt(objProc.style.left);
	var fromY=parseInt(objProc.style.top);
	var arrX=new Array();
	var arrY=new Array();
	var arrPos=new Array(0,0.25,0.5,0.75,1);
	var nX,nY,m,n,nearPt,poX,poY;
	arrX[0]=fromX;
	arrX[1]=fromX+fromW/4;
	arrX[2]=fromX+fromW/2;
	arrX[3]=fromX+fromW*3/4;
	arrX[4]=fromX+fromW;
	arrY[0]=fromY;
	arrY[1]=fromY+fromH/4;
	arrY[2]=fromY+fromH/2;
	arrY[3]=fromY+fromH*3/4;
	arrY[4]=fromY+fromH;
	m=0;
	n=0;
	for(var i=0;i<4;i++)
	{
		Math.abs(x-arrX[i])<Math.abs(x-arrX[i+1])?m=m:m=i+1;
		Math.abs(y-arrY[i])<Math.abs(y-arrY[i+1])?n=n:n=i+1;
	}
	if(m>0&&m<4&&n>0&&n<4)
	{
		if(m==3) {
			m=4;
		}
		else {
			m=0;
		}
		if(n==3) {
			n=4;
		}
		else {
			n=0;
		}
	}
	nX=arrX[m];
	nY=arrY[n];
	poX=arrPos[m];
	poY=arrPos[n];
	nearPt=nX*3/4+"pt,"+nY*3/4+"pt|~|"+poX+","+poY;
	//nearPt = nX + "," + nY;
	return nearPt;
}
function alertPro(obj)
{
	for(var i in obj)
	{
		alert(i+'\n'+obj[i]);
	}
}
//名称:modifyStepShape
//说明:修改折线形状
//作者:fxf
//时间:2009-06-20
function modifyStepShape(objstep,x,y) {
	_MOVEOBJ=document.getElementById(objstep.id);
	_MOVELINEOBJ=new TStep(_FLOW);
	_MOVELINEOBJ.clone(_FLOW.getStepByID(objstep.id));
	_MOVEOBJ=_FLOW.getStepByID(objstep.id);
	if(_MOVEOBJ.Label) {
		document.getElementById(_MOVEOBJ.Label.ID).style.backgroundColor='#dddddd';
	}
	var strPt=_MOVEOBJ.Points;
	var aryPt=strPt.split(',');
	var nPt=aryPt.length-1;
	_strPt2="";
	_strPt1="";
	_strLine2="";
	_strLine1="";
	for(i=0;i<=nPt;i=i+2)
	{
		var m=aryPt[i].substr(0,aryPt[i].length-2)*4/3;
		var n=aryPt[i+1].substr(0,aryPt[i+1].length-2)*4/3;
		var sqrta=Math.sqrt((x-m)*(x-m)+(y-n)*(y-n));
		if(isSelectPoint==0&&sqrta<=10)
		{
			_PointOrLine=0;
			isSelectPoint=1;
			_MOVETYPE="line_m";
			_strSltPt=aryPt[i]+','+aryPt[i+1];
			_clkPx=aryPt[i];
			_clkPy=aryPt[i+1];
			if(i==0) {
				ptMoveType="from";
			}
			if(i==nPt-1) {
				ptMoveType="to";
			}
		}
		else
		{
			if(isSelectPoint==1) {
				_strPt2=_strPt2+','+aryPt[i]+','+aryPt[i+1];
			}
			else {
				_strPt1=_strPt1+','+aryPt[i]+','+aryPt[i+1];
			}
		}
		if(i<=nPt-3)
		{
			var r=aryPt[i+2].substr(0,aryPt[i+2].length-2)*4/3;
			var s=aryPt[i+3].substr(0,aryPt[i+3].length-2)*4/3;
			if((Math.abs(x*(n-s)+y*(r-m)+(m*s-n*r))/Math.sqrt((n-s)*(n-s)+(r-m)*(r-m))<=5)&&(isSelectLine==0)&&sqrta>10&&isSelectPoint==0)
			{
				_PointOrLine=1;
				_MOVETYPE="line_m";
				isSelectLine=1;
				_strSltLine=aryPt[i]+','+aryPt[i+1]+','+aryPt[i+2]+','+aryPt[i+3];
				_clkPx=x/4*3+"pt";
				_clkPy=y/4*3+"pt";
				//if(oOval==null)createOval(x*_ZOOM,y*_ZOOM);
			}
			else
			{
				if(isSelectLine==1)
				{
					if(i<=nPt-3)
					{
						_strLine2=_strLine2+','+aryPt[i+2]+','+aryPt[i+3];
						//if (oOval==null)createOval(x*_ZOOM,y*_ZOOM);
					}
				}
				else
				{
					_strLine1=_strLine1+","+aryPt[i]+','+aryPt[i+1];
					//if (oOval==null)createOval(x*_ZOOM,y*_ZOOM);
				}
			}
			/*if(oOval&&_PointOrLine==0)
									{
										oOval.fillcolor="blue";
										oOval.strokecolor="blue";
									}*/
		}
	}
	if(_strPt1!='') {
		_strPt1=_strPt1.substr(1)+',';
	}
	if(_strLine1!='') {
		_strLine1=_strLine1.substr(1)+",";
	}
}
//放弃选择流程图元素对象，显示未选中效果
function objFocusedOff() {
	if(_FOCUSTEDOBJ!=null)
	{
		_FOCUSTEDOBJ.StrokeColor=_FOCUSTEDOBJ.sc;
		//恢复原来的颜色
		_FOCUSTEDOBJ.StrokeWeight=1;
			if(document.getElementById("h-"+_FOCUSTEDOBJ.id)){
				var _OFFHR = document.getElementById("h-"+_FOCUSTEDOBJ.id);
				var obj=_FLOW.getProcByID(_FOCUSTEDOBJ.id);
				_OFFHR.style.color = _FOCUSTEDOBJ.sc;
				_OFFHR.style.height = "1px";
				if(obj.ShapeType=="multi"){
					_OFFHR.style.border = "1px dashed "+_FOCUSTEDOBJ.sc;
				}
			}
		var oLabel=document.getElementById('lab'+_FOCUSTEDOBJ.id);
		if(oLabel)
		{
			oLabel.style.backgroundColor='';
		}
	}
	_FOCUSTEDOBJ=null;
	isSelectPoint=0;
	isSelectLine=0;
	ptMoveType="";
	oOval=null;
	return ;
}
//删除流程图元素对象
function deleteObj(ObjId) {
	var obj=document.getElementById(ObjId);
	if(obj==null) {
		return false;
	}
	if(obj.typ!="Proc"&&obj.typ!="Step") {
		return false;
	}
	if(obj.typ=="Proc"&&(obj.st=="begin"||obj.st=="end")) {
		alert("不能删除！一个流程图中，[开始节点],[第一个节点],[结束结点]是必需的");
		return false;
	}
	var objVML=obj.typ=="Proc"?_FLOW.getProcByID(_FOCUSTEDOBJ.id):_FLOW.getStepByID(_FOCUSTEDOBJ.id);
	/*if(obj.typ=="Step"&&objVML.FromProc=='begin')
	{
		alert('不能删除开始节点联线！');
		return false;
	}*/
	if(confirm("确定要删除["+objVML.Text+"]吗？")) {
		objFocusedOff();
		if(obj.typ=="Proc") {
			var Proc=_FLOW.getProcByID(ObjId);
			_FLOW.deleteProcByID(ObjId);
			pushLog("delproc",Proc);
		}
		else {
			var Step=_FLOW.getStepByID(ObjId);
			_FLOW.deleteStepByID(ObjId);
			pushLog("delstep",Step);
		}
		_FLOW.Modified=true;
		DrawAll();
	}
}
//更改[任务]的ID值，将原路径重新指定到新ID
function changeProcID(OldID,NewID) {
	var Step;
	for(var i=0;i<_FLOW.Steps.length;i++) {
		Step=_FLOW.Steps[i];
		if(Step.FromProc==OldID) {
			Step.FromProc=NewID;
		}
		if(Step.ToProc==OldID) {
			Step.ToProc=NewID;
		}
	}
}
//名称:saveStepsToProc
//说明:修改折线形状
//作者:fxf
//时间:2009-06-20
function saveStepsToProc(obj)
{
	for(var i=0;i<_FLOW.Steps.length;i++) {
		var oStep=_FLOW.Steps[i];
		if(oStep.FromProc==obj.id||oStep.ToProc==obj.id) {
			//updateFlow(document.getElementById(oStep.ID));
		}
	}
}
//更改Proc的位置
function changeProcPos(obj) {
	for(var i=0;i<_FLOW.Steps.length;i++) {
		Step=_FLOW.Steps[i];
		if(Step.FromProc==obj.id||Step.ToProc==obj.id) {
			objStepHTML=document.getElementById(Step.ID);
			if(Step.ShapeType=="Line") {
				Step.getPath();
				objStepHTML.from=Step.FromPoint;
				objStepHTML.to=Step.ToPoint;
			}
			else if(Step.ShapeType=="PolyLine") {
				var strPt="";
				var arrPt=Step.Points.split(",");
				var objWidth=obj.style.width;
				var objHeight=obj.style.height;
				var objX=obj.style.left;
				var objY=obj.style.top;
				var strMoveType=_MOVETYPE;
				objWidth=objWidth.substr(0,objWidth.length-2);
				objHeight=objHeight.substr(0,objHeight.length-2);
				objX=objX.substr(0,objX.length-2)*1;
				objY=objY.substr(0,objY.length-2)*1;
				if(_MOVETYPE=="") {
					strMoveType=_logMoveType;
				}
				if(Step.FromProc==obj.id)
				{
					strPt=(objX+objWidth*Step.fromRelX)*3/4+"pt,"+(objY+objHeight*Step.fromRelY)*3/4+"pt";
					for(var j=2;j<arrPt.length;j++)
					{
						strPt=strPt+","+arrPt[j];
					}
				}
				if(Step.ToProc==obj.id)
				{
					for(var j=0;j<arrPt.length-2;j++)
					{
						strPt=strPt+arrPt[j]+",";
					}
					strPt=strPt+(objX+objWidth*Step.toRelX)*3/4+"pt,"+(objY+objHeight*Step.toRelY)*3/4+"pt";
				}
				Step.Points=strPt;
				objStepHTML.outerHTML=Step.toStringWithoutLabel();
			}
		}
	}// End For
	_logMoveType="";
}
//修改[任务]
function editProc(objId) {
}
//名称:saveStepsToProc
//说明:修改[路径],双击删除折线拐点
//作者:fxf
//时间:2009-06-20
function editStep(objId) {
	var oldobj=new TStep(_FLOW),newobj=new TStep(_FLOW);
	var step=_FLOW.getStepByID(objId);
	oldobj.clone(step);
	/*if(vmlOpenWin("step.htm", step, 450,350)) {
				_FLOW.Modified = true;
				DrawAll();
				objFocusedOn(step.ID);
				newobj.clone(step);
				pushLog("editstep", {"_old":oldobj,"_new":newobj});
				}*/
	var x=(event.x+document.body.scrollLeft)/_ZOOM;
	var y=(event.y+document.body.scrollTop)/_ZOOM;
	var strPt=step.Points;
	var aryPt=strPt.split(',');
	var nPt=aryPt.length-1;
	isSelectPoint=0;
	_strPt2="";
	_strPt1="";
	for(i=0;i<=nPt;i=i+2) {
		var m=aryPt[i].substr(0,aryPt[i].length-2)*1.333;
		var n=aryPt[i+1].substr(0,aryPt[i+1].length-2)*1.333;
		var sqrta=Math.sqrt((x-m)*(x-m)+(y-n)*(y-n));
		if(isSelectPoint==0&&sqrta<=10) {
			_strSltPt=aryPt[i]+','+aryPt[i+1];
		}
		else if(isSelectPoint==1) {
			_strPt2=_strPt2+','+aryPt[i]+','+aryPt[i+1];
		}
		else {
			_strPt1=_strPt1+','+aryPt[i]+','+aryPt[i+1];
		}
	}
	if(_strPt1!='') {
		_strPt1=_strPt1.substr(1);
	}
	step.Points=_strPt1+_strPt2;
	//updateFlow(document.getElementById(step.ID));
	document.getElementById(step.ID).outerHTML=step.toStringWithoutLabel();
	objFocusedOn(objId);
	//stuffProp();
	_FLOW.Modified=true;
}
//需要特点检查的属性
function beforePropChange(oItem) {
	if("rule" in oItem) {
		r=new RegExp(oItem.rule);
		if(!r.test(oItem.value)) {
			alert(oItem.msg);
			oItem.focus();
			if(oItem.tagName.toLowerCase()=="input") {
				oItem.select();
			}
			return false;
		}
	}
	return true;
}
//设置编号
function setPropID(oItem) {
	var obj=null,obj2=null;
	obj=_FOCUSTEDOBJ.typ=="Proc"?_FLOW.getProcByID(_FOCUSTEDOBJ.id):_FLOW.getStepByID(_FOCUSTEDOBJ.id);
	var oldID=obj.ID;
	if(oldID==oItem.value) {
		return ;
	}
	obj2=_FLOW.getProcByID(oItem.value);
	if(obj2==null) {
		obj2=_FLOW.getStepByID(oItem.value);
	}
	if(obj2!=null) {
		alert("编号["+oItem.value+"-"+obj2.Text+"]已经存在！请重新输入！");
		oItem.focus();
		oItem.select();
		return ;
	}
	document.all(_FOCUSTEDOBJ.id+"Text").id=oItem.value+"Text";
	obj.ID=oItem.value;
	_FOCUSTEDOBJ.id=oItem.value;
	if(_FOCUSTEDOBJ.typ=="Proc") {
		changeProcID(oldID,obj.ID);
	}
	pushLog("editprop",{
		"obj":obj,"prop":"ID","_old":oldID,"_new":obj.ID
	});
}
//设置名称
function setPropText(oItem) {
	var obj=_FOCUSTEDOBJ.typ=="Proc"?_FLOW.getProcByID(_FOCUSTEDOBJ.id):_FLOW.getStepByID(_FOCUSTEDOBJ.id);
	if(obj.Text==oItem.value) {
		return ;
	}
	/*if(_FOCUSTEDOBJ.typ=="Proc"){
	if(_FLOW.isExitName(oItem.value)) {
		alert('节点名称不允许重复！');
		oItem.value=obj.Text;
		return ;
	}
	}*/
	var oldValue=obj.Text;
	obj.Text=oItem.value;
	if(obj.ObjType=="Proc") {
		DrawAll();
	}
	else {
		//DrawTree();
		//修改联线标签显示值
		document.getElementById('lab'+_FOCUSTEDOBJ.id).innerHTML=oItem.value;
	}
	objFocusedOn(obj.ID);
	pushLog("editprop",{
		"obj":obj,"prop":"Text","_old":oldValue,"_new":obj.Text
	});
}
/* //设置条件
function setPropCond(oItem) {
	var obj=_FLOW.getStepByID(_FOCUSTEDOBJ.id);
	if(obj.Cond==oItem.value) {
		return ;
	}
	var oldValue=obj.Cond;
	obj.Cond=oItem.value;
	document.all(_FOCUSTEDOBJ.id+"Text").innerHTML=oItem.value;
	pushLog("editprop",{
		"obj":obj,"prop":"Cond","_old":oldValue,"_new":obj.Cond
	});
}
//名称:setProcType
//说明:设置节点类型
//作者:fxf
//时间:2009-06-20
function setProcType(oItem) {                  //这个地方需要改<!--nodetype  节点类别 A:开始 B:首节点 C:一般 D:分支 E:汇聚 F结束 -->
	var obj=_FLOW.getProcByID(_FOCUSTEDOBJ.id);
	if(obj.ProcType==oItem.value) {
		return ;
	}
	var oldValue=obj.ProcType;
	var oldShape=obj.ShapeType;
	obj.ProcType=oItem.value;
	var strImageType='';
	switch(oItem.value) {
		case 'andsign':
		case 'unandsign':   
		case 'connectsign':   
		strImageType='roundrect';
		break;
		case 'D':                     //D分支  老版本fork
		strImageType='diamond';
		break;
		case 'E':					//E汇聚 替代andjoin
		//case 'unandjoin':
		strImageType='rect';
		break;
		default:
		break;
	}
	obj.ShapeType=strImageType;
	DrawAll();
	objFocusedOn(obj.ID);
	pushLog("editprop",{
		"obj":obj,"prop":"ProcType","_old":oldValue,"_new":obj.ProcType,"_oldShape":oldShape,"_newShape":obj.ShapeType
	});
} */

//名称:任务分配机制
//说明:设置任务分配机制
//作者:xc
//时间:2011.11.11
function setOptType(oItem) {
	var obj=_FLOW.getProcByID(_FOCUSTEDOBJ.id);
	var oldValue=obj.OptType;
	//alert(obj.OptType);
	if(obj.OptType==oItem.value) {
		return ;
	}
	
	obj.OptType=oItem.value;
	//alert(obj.OptType);
	pushLog("editprop",{
		"obj":obj,"prop":"OptType","_old":oldValue,"_new":obj.OptType
	});
	

	//由操作类别引起的判断
	if(obj.OptType=="D"){     //自动流程节点的时候
		$("#OptCode").hide();
		$("#Subwfcode").hide();
		//$("#OptBean").show();
	}
	else if(obj.OptType=="S"){     //选择为子流程的时候
		$("#OptCode").hide();
		//$("#OptBean").hide();
		$("#Subwfcode").show();
	}
	else{					//正常的时候
		$("#Subwfcode").hide();
		//$("#OptBean").hide();
		$("#OptCode").show();
	}
}

//名称:节点类型
//说明:设置节点类型
//作者:xc
//时间:2012.1.10
function setNodeType(oItem) {
	var obj=_FLOW.getProcByID(_FOCUSTEDOBJ.id);
	var oldValue=obj.NodeType;
	var oldShape=obj.ShapeType;
	//alert(obj.OptType);
	if(obj.NodeType==oItem.value) {
		return ;
	}
	obj.NodeType=oItem.value;
	//alert(oItem.value);
	
	var strImageType='';	
	switch(oItem.value) {
		case 'B':
			strImageType = 'roundrect';
			break;
		case 'H':
		strImageType='bing';  //并行
		break;
		case 'C':
			strImageType = 'roundrect';
			break;
		case 'G':
		strImageType='multi';  //多实例节点
		break;
		case 'D':
		strImageType='diamond';    //分支
		break;
		case 'E':
		strImageType='ju';        //汇聚
		break;
		case 'R':
			strImageType='R';        //游离分支
		break;
		default:
		break;
	}
	
	obj.ShapeType=strImageType;
	DrawAll();
	objFocusedOn(obj.ID);
	pushLog("editprop",{
		"obj":obj,"prop":"NodeType","_old":oldValue,"_new":obj.NodeType,"_oldShape":oldShape,"_newShape":obj.ShapeType
	});
}          

//说明:设置角色类别
//作者:xc
//时间:2011.11.15
function setRoleType(oItem) {
	var obj=_FLOW.getProcByID(_FOCUSTEDOBJ.id);
	var oldValue=obj.RoleType;
	if(obj.RoleType==oItem.value) {
		return ;
	}
	obj.RoleType=oItem.value;
	pushLog("editprop",{
		"obj":obj,"prop":"RoleType","_old":oldValue,"_new":obj.RoleType
	});
	//alert(obj.RoleType);
	$("#RoleCode").hide().empty().show();
		if(obj.RoleType!="en"){
			$("#PowerExpText").replaceWith('<span id="RoleCodeText">角色代码</span>');
			$("#PowerExp").replaceWith('<select id="RoleCode"  onchange="setRoleCode(this);"  style="width:100%;">');
			if(obj.RoleType=="bj")
			{
				obj.RoleCode='0';
			for(var k in Data.bj)
				{	
					//alert(Data.bj[k]);
					$("#RoleCode").append($("<option  value='"+k+"'>"+Data.bj[k]+"</option>"));
					
				}
			}
			if(obj.RoleType=="gw")
			{
			for(var k in Data.gw)
				{	
				obj.RoleCode='0';
					//alert(Data.gw[k]);
					$("#RoleCode").append($("<option  value='"+k+"'>"+Data.gw[k]+"</option>"));
					
				}
			}		
			if(obj.RoleType=="xz")
			{
				obj.RoleCode='0';
				for(var k in Data.xz)
					{	
						//alert(Data.xz[k]);
						$("#RoleCode").append($("<option  value='"+k+"'>"+Data.xz[k]+"</option>"));
						
					}
				}
			if(obj.RoleCode='0'){
				$("#RoleCode").append($("<option  value='0' selected='selected'>请选择</option>"));
			}
		}
			else
			{	
				$("#RoleCodeText").replaceWith('<span id="PowerExpText">权限表达式</span>');
				$("#RoleCode").replaceWith('<input type="text" maxlength="50" id="PowerExp" onchange="setPowerExp(this);" value="'+obj.PowerExp+'"style="width:100%;" >');
			}
	
}
//说明:设置角色代码
//作者:xc
//时间:2011.11.15
function setRoleCode(oItem) {
	var obj=_FLOW.getProcByID(_FOCUSTEDOBJ.id);
	var oldValue=obj.RoleCode;
	if(obj.RoleCode==oItem.value) {
		return ;
	}
	obj.RoleCode=oItem.value;
	pushLog("editprop",{
		"obj":obj,"prop":"RoleCode","_old":oldValue,"_new":obj.RoleCode
	});
	//alert(obj.RoleCode);
}

//说明:设置节点阶段
//作者:xc
//时间:2011.11.15
function setFlowPhase(oItem) {
	var obj=_FLOW.getProcByID(_FOCUSTEDOBJ.id);
	var oldValue=obj.FlowPhase;
	//alert(oItem.value);
	if(obj.FlowPhase==oItem.value) {
		return ;
	}
	obj.FlowPhase=oItem.value;
	pushLog("editprop",{
		"obj":obj,"prop":"FlowPhase","_old":oldValue,"_new":obj.FlowPhase
	});
	//alert(obj.RoleCode);
}
//说明:设置业务代码
//作者:xc
//时间:2011.11.15
function setOptCode(oItem){

	var obj=_FLOW.getProcByID(_FOCUSTEDOBJ.id);
	var oldValue=obj.OptCode;
	if(obj.OptCode==oItem.value){
		return ;
	}
	obj.OptCode=oItem.value;
	
	pushLog("editprop",{
		"obj":obj,"prop":"OptCode","_old":oldValue,"_new":obj.OptCode
	});	
	//alert(obj.OptCode);
}

//说明:设置子流程
//作者:xc
//时间:2011.11.15
function setSubWfcode(oItem){

	var obj=_FLOW.getProcByID(_FOCUSTEDOBJ.id);
	var oldValue=obj.SubWfcode;
	if(obj.SubWfcode==oItem.value){
		return ;
	}
	obj.SubWfcode=oItem.value;
	
	pushLog("editprop",{
		"obj":obj,"prop":"SubWfcode","_old":oldValue,"_new":obj.SubWfcode
	});	
}

//说明：设置操作参数
//作者:xc
//时间:2012.4.5
function setOptParam(oItem){
	var obj=_FLOW.getProcByID(_FOCUSTEDOBJ.id);
	var oldValue=obj.OptParam;
	if(obj.OptParam==oItem.value){
		return ;
	}
	obj.OptParam=oItem.value;
	
	pushLog("editprop",{
		"obj":obj,"prop":"OptParam","_old":oldValue,"_new":obj.OptParam
	});	
	//alert(obj.OptParam);
}
//说明：设置业务Bean
//作者:xc
//时间:2012.4.6
function setOptBean(oItem){
	var obj=_FLOW.getProcByID(_FOCUSTEDOBJ.id);
	var oldValue=obj.OptBean;
	if(obj.OptBean==oItem.value){
		return ;
	}
	obj.OptBean=oItem.value;
	
	pushLog("editprop",{
		"obj":obj,"prop":"OptBean","_old":oldValue,"_new":obj.OptBean
	});		
}

/*//说明:设置权限表达式
//作者:xc
//时间:2011.1.16
function setPowerExp(oItem){
	
	var obj=_FLOW.getProcByID(_FOCUSTEDOBJ.id);
	var oldValue=obj.PowerExp;
	if(obj.PowerExp==oItem.value){
		return ;
	}
	obj.PowerExp=oItem.value;
	
	pushLog("editprop",{
		"obj":obj,"prop":"PowerExp","_old":oldValue,"_new":obj.PowerExp
	});	
	//alert(obj.OptCode);
}*/


/* 
//名称:节点类型
//说明:设置节点类别
//作者:xc
//时间:2011.11.4
function setNodeType(oItem) {
	var obj=_FLOW.getProcByID(_FOCUSTEDOBJ.id);
	
	var oldValue=obj.NodeType;
	alert(oItem.value);
	if(obj.NodeType==oItem.value) {
		return ;
	}
	
	obj.NodeType=oItem.value;
	pushLog("editprop",{
		"obj":obj,"prop":"NodeType","_old":oldValue,"_new":obj.NodeType
	});
} */



//名称:setDesc
//说明:节点设置说明
//作者:fxf
//时间:2009-06-20
function setDesc(oItem) {
	var obj=_FLOW.getProcByID(_FOCUSTEDOBJ.id);
	var oldValue=obj.Desc;
	if(obj.Desc==oItem.value) {
		return ;
	}
	obj.Desc=oItem.value;
	
	pushLog("editprop",{
		"obj":obj,"prop":"Desc","_old":oldValue,"_new":obj.Desc});
	//alert(obj.Desc);
}
//名称：setIsAccountTime
//说明：设置机构表达式
//作者：xc
//时间：2012.4.5
function setIsAccountTime(oItem){
	var obj=_FLOW.getProcByID(_FOCUSTEDOBJ.id);
	var oldValue=obj.IsAccountTime;
	//alert(oItem.value);
	if(obj.IsAccountTime==oItem.value) {
		return ;
	}
	obj.IsAccountTime=oItem.value;
	pushLog("editprop",{
		"obj":obj,"prop":"IsAccountTime","_old":oldValue,"_new":obj.IsAccountTime
	});	
	//alert(obj.IsAccountTime);
	/*if(obj.IsAccountTime=='T'||obj.IsAccountTime=='R'){
		$("#timeBase").show();
		$("#timelimit").show();
	}
	else{
		$("#timeBase").hide();
		$("#timelimit").hide();
	}*/
}
//名称：setUintExp
//说明：设置机构表达式
//作者：xc
//时间：2012.12.16
function setUnitExp(oItem){
	var isT="F";
	if(oItem.value!=''){
	$.ajax({
		type:"POST",
		url: path+"/sampleflow/sampleFlowDefine!checkUnitsExp.do",
		contentType:"text/html",
		data:oItem.value,
		dataType:"json",
		processData:false,
		async: false,
		success:function(data){	
			//alert(data);
			isT=data;
		},
		error:function(){
			alert("系统提交失败，重启系统");
		}
		
	});
	}
	//alert(isT);
	if(isT=="T"||oItem.value==''){
	
	var obj=_FLOW.getProcByID(_FOCUSTEDOBJ.id);
	var oldValue=obj.UnitExp;
	if(obj.UnitExp==oItem.value){
		return ;
	}
	obj.UnitExp=oItem.value;
	pushLog("editprop",{
		"obj":obj,"prop":"UnitExp","_old":oldValue,"_new":obj.UnitExp
	});
	//alert(obj.UnitExp);
	}

	else{
		alert("表达式编写错误,请重新填写\n"+isT);
	}
	
}
//名称：setInheritNodeCode
//说明：设置预期时间
//作者：gyr
//时间：2014-06-04
function setInheritNodeCode(oItem){
	var obj=_FLOW.getProcByID(_FOCUSTEDOBJ.id);
	var oldValue=obj.InheritNodeCode;
	obj.InheritNodeCode=oItem.value;
	pushLog("editprop",{
		"obj":obj,"prop":"InheritNodeCode","_old":oldValue,"_new":obj.InheritNodeCode
	});
}

//名称：setTimeLimit
//说明：设置预期时间
//作者：xc
//时间：2011.1.16
function setTimeLimit(oItem){
	var obj=_FLOW.getProcByID(_FOCUSTEDOBJ.id);
	var oldValue=obj.TimeLimit;
	if(obj.TimeLimit==oItem.value){
		return ;
	}
	obj.TimeLimit=oItem.value;
	pushLog("editprop",{
		"obj":obj,"prop":"TimeLimit","_old":oldValue,"_new":obj.TimeLimit
	});
}
//名称：setIsTrunkLine
//说明：设置主干节点
//作者：xc
//时间：2011.1.16

function setIsTrunkLine(oItem){
	var obj=_FLOW.getProcByID(_FOCUSTEDOBJ.id);
	var oldValue=obj.isTrunkLine;
	if(obj.isTrunkLine==oItem.value){
		return ;
	}
	obj.isTrunkLine=oItem.value;
	pushLog("editprop",{
		"obj":obj,"prop":"isTrunkLine","_old":oldValue,"_new":obj.isTrunkLine
	});
}

/*//名称：setTimeBaseNodeId
//说明:设置时间基准点
//作者:xc
//时间:2012.3.16
function setTimeBaseNodeId(oItem){
	var obj=_FLOW.getProcByID(_FOCUSTEDOBJ.id);
	var oldValue=obj.TimeBaseNodeId;
	if(obj.TimeBaseNodeId==oItem.value){
		return ;
	}
	obj.TimeBaseNodeId=oItem.value;
	pushLog("editprop",{
		"obj":obj,"prop":"TimeBaseNodeId","_old":oldValue,"_new":obj.TimeBaseNodeId
	});
}*/

//名称:setStepInheritNodeCode
//说明:设置继承节点代码
//作者：gyr
//时间:2014-06-04
function setStepInheritNodeCode(oItem) {
	//alert("asda");
	var obj=_FLOW.getStepByID(_FOCUSTEDOBJ.id);
	var oldValue=obj.InheritNodeCode;
	obj.InheritNodeCode=oItem.value;
	pushLog("editprop",{
		"obj":obj,"prop":"InheritNodeCode","_old":oldValue,"_new":obj.InheritNodeCode
	});
}

//名称:setTimeLimitType
//说明:设置期限类别
//作者：xc
//时间:2009-06-20
function setTimeLimitType(oItem) {
	//alert("asda");
	var obj=_FLOW.getProcByID(_FOCUSTEDOBJ.id);
	var oldValue=obj.TimeLimitType;
	if(obj.TimeLimitType==oItem.value) {
		return ;
	}
	obj.TimeLimitType=oItem.value;
	pushLog("editprop",{
		"obj":obj,"prop":"type","_old":oldValue,"_new":obj.TimeLimitType
	});
	//alert(obj.Desc);
}

//名称:setInheritType
//说明:设置继承期限
//作者：gyr
//时间:2014-06-04
function setInheritType(oItem) {
	var obj=_FLOW.getProcByID(_FOCUSTEDOBJ.id);
	var oldValue=obj.InheritType;
	if(obj.InheritType==oItem.value) {
		return ;
	}
	obj.InheritType=oItem.value;
	if(oItem.value=='2'){
		$("#inheritNodeCode").show();
	}
	else{
		$("#inheritNodeCode").hide();
	}
	pushLog("editprop",{
		"obj":obj,"prop":"InheritType","_old":oldValue,"_new":obj.InheritType
	});
}

//名称：setPowerExp
//说明：设置机构表达式
//作者：xc
//时间：2011.1.16
function setPowerExp(oItem){
	var isT="F";
	if(oItem.value!=''){
	$.ajax({
		type:"POST",
		url: path+"/sampleflow/sampleFlowDefine!checkRolesExp.do",
		contentType:"text/html",
		data:oItem.value,
		dataType:"json",
		processData:false,
		async: false,
		success:function(data){	
			//alert(data);
			isT=data;
		},
		error:function(){
			alert("系统提交失败，重启系统");
		}
		
	});
	}
	var obj=_FLOW.getProcByID(_FOCUSTEDOBJ.id);
	var oldValue=obj.PowerExp;
	if(isT=="T"){

	if(obj.PowerExp==oItem.value){
		return ;
	}
	obj.PowerExp=oItem.value;
	pushLog("editprop",{
		"obj":obj,"prop":"PowerExp","_old":oldValue,"_new":obj.PowerExp
	});
	alert(obj.PowerExp);
	}	
}


//名称:setStepDesc
//说明:设置说明
//作者:fxf
//时间:2009-06-20
function setStepDesc(oItem) {
	//alert("asda");
	var obj=_FLOW.getStepByID(_FOCUSTEDOBJ.id);
	var oldValue=obj.Desc;
	if(obj.Desc==oItem.value) {
		return ;
	}
	obj.Desc=oItem.value;
	pushLog("editprop",{
		"obj":obj,"prop":"Desc","_old":oldValue,"_new":obj.Desc
	});
	//alert(obj.Desc);
}




//名称:setStepTimeLimitType
//说明:设置期限类别
//作者：xc
//时间:2009-06-20
function setStepTimeLimitType(oItem) {
	//alert("asda");
	var obj=_FLOW.getStepByID(_FOCUSTEDOBJ.id);
	var oldValue=obj.TimeLimitType;
	if(obj.TimeLimitType==oItem.value) {
		return ;
	}
	obj.TimeLimitType=oItem.value;
	pushLog("editprop",{
		"obj":obj,"prop":"type","_old":oldValue,"_new":obj.TimeLimitType
	});
	//alert(obj.Desc);
}

//名称:setStepInheritType
//说明:设置继承期限
//作者：gyr
//时间:2014-06-04
function setStepInheritType(oItem) {
	var obj=_FLOW.getStepByID(_FOCUSTEDOBJ.id);
	var oldValue=obj.InheritType;
	if(obj.InheritType==oItem.value) {
		return ;
	}
	obj.InheritType=oItem.value;
	if(oItem.value=='2'){
		$("#stepInheritNodeCode").show();
	}
	else{
		$("#stepInheritNodeCode").hide();
	}
	pushLog("editprop",{
		"obj":obj,"prop":"InheritType","_old":oldValue,"_new":obj.InheritType
	});
}

//名称:setTimeLimitType
//说明:设置期限类别
//作者：xc
//时间:2009-06-20
function setStepTimeLimit(oItem) {
	//alert("asda");
	var obj=_FLOW.getStepByID(_FOCUSTEDOBJ.id);
	var oldValue=obj.TimeLimit;
	if(obj.TimeLimit==oItem.value) {
		return ;
	}
	obj.TimeLimit=oItem.value;
	pushLog("editprop",{
		"obj":obj,"prop":"time","_old":oldValue,"_new":obj.TimeLimit
	});
	//alert(obj.Desc);
}



//名称:setCond
//说明:设置条件
//作者:xc
//时间:2009-06-20
function setCond(oItem) {
	//alert("asda");
	var obj=_FLOW.getStepByID(_FOCUSTEDOBJ.id);
	var oldValue=obj.Cond;
	if(obj.Cond==oItem.value) {
		return ;
	}
	obj.Cond=oItem.value;
	pushLog("editprop",{
		"obj":obj,"prop":"Cond","_old":oldValue,"_new":obj.Cond
	});
	alert(obj.Cond);
}


function setNodeCode(oItem){
	var obj=_FLOW.getProcByID(_FOCUSTEDOBJ.id);
	
	var oldValue=obj.NodeCode;
	if(obj.NodeCode==oItem.value) {
		return ;
	}
	obj.NodeCode=oItem.value;
	pushLog("editprop",{
		"obj":obj,"prop":"Cond","_old":oldValue,"_new":obj.NodeCode
	});
	
}

//名称:setAspect
//说明:设置汇聚节点横纵向
//作者:fxf
//时间:2009-06-20
function setAspect(val)
{
	var obj=_FLOW.getProcByID(_FOCUSTEDOBJ.id);
	var strRadioVal='';
	if(Math.abs(obj.Width.replace('px',''))<Math.abs(obj.Height.replace('px',''))) {
		strRadioVal='v';
	}
	else {
		strRadioVal='h';
	}
	if(val==strRadioVal) {
		return ;
	}
	var w=obj.Width;
	var h=obj.Height;
	var oldVal={
		"X":obj.X,"Y":obj.Y,"Width":w,"Height":h
	};
	var d=(Math.abs(h.replace('px',''))-Math.abs(w.replace('px','')))/2;
	//高度和宽度差的一半
	//alert(d)
	obj.Width=h;
	obj.Height=w;
	obj.X=Math.abs(obj.X.replace('px',''))-d+'px';
	//移动位置
	obj.Y=Math.abs(obj.Y.replace('px',''))+d+'px';
	//移动位置
	//修改宽度，高度后重画界面 节点获取焦点后 才能修改线的位置
	DrawAll();
	//重画界面
	objFocusedOn(obj.ID);
	//先获取焦点
	changeProcPos(_FOCUSTEDOBJ);
	//修改线的位置
	pushLog("moveproc",{
		"objID":obj.ID,"moveType":"proc_nw","_old":oldVal,"_new":{
			"X":obj.X,"Y":obj.Y,"Width":obj.Width,"Height":obj.Height
		}
	});
}
function stuffProp() {
	
	for(var i=propview.rows.length-1;i>0;i--) {
		propview.deleteRow(i);
	}
	if(_FOCUSTEDOBJ==null) {
		return ;
	}
	var obj=_FOCUSTEDOBJ.typ=="Proc"?_FLOW.getProcByID(_FOCUSTEDOBJ.id):_FLOW.getStepByID(_FOCUSTEDOBJ.id);
	var idTR,idTD,htmlContent;

	//ID
/*	idTR=propview.insertRow();
	idTR.height="22";
	idTD=idTR.insertCell();
	idTD.noWrap=true;
	idTD.innerHTML="编 &nbsp; &nbsp;号";
	idTD.align='right';
	idTD=idTR.insertCell();
	idTD.innerHTML=obj.ID;*/
	//Text
	idTR=propview.insertRow();
	idTR.height="22";
	idTD=idTR.insertCell();
	idTD.noWrap=true;
	idTD.innerHTML="名 &nbsp; &nbsp;称";
	idTD.align='right';
	idTD=idTR.insertCell();
	idTD.innerHTML='<input type="text" rule="^\\S+$" msg="[名称]不能为空或包含空字符！" onchange="if(beforePropChange(this)) { setPropText(this);}" name="pText" maxlength="50" value="'+obj.Text+'" style="width:100%;">';
	if(_FOCUSTEDOBJ.typ=="Proc") {	
		idTR=propview.insertRow();
		idTR.height="22";
		idTD=idTR.insertCell();
		idTD.noWrap=true;
		idTD.innerHTML="环节代码";
		//	idTD.innerHTML="流转代码";
		idTD.align='right';
		idTD=idTR.insertCell();
		idTD.innerHTML='<input type="text" value="'+obj.NodeCode+'" onchange="setNodeCode(this);" maxlength="50" style="width:100%;">';
	}//如果类型是节点的话
	
	
	
	//如果类型是节点的话
	
	//alert(_FOCUSTEDOBJ.typ);
	if(_FOCUSTEDOBJ.typ=="Proc") {
			if(obj.ID=='begin')
			{
			obj.NodeType='A';
			}
			if(obj.ID=="end")
			{
			obj.NodeType='F';
			}	
			
		var typeData=jQuery.parseJSON('{"B":"首节点","C":"一般","D":"分支","E":"汇聚","H":"并行","G":"多实例节点","R":"游离分支"}');
			if(obj.ID!='begin'&&obj.ID!='end')
			{
				//节点阶段
				idTR=propview.insertRow();
				idTR.height="22";
				idTR.id="FlowPhase";
				idTD=idTR.insertCell();
				idTD.align='right';
				idTD.noWrap=true;		
				idTD.innerHTML='流程节点阶段';
				idTD=idTR.insertCell();
				//idTD.innerHTML='<input type="text"   value="'+obj.FlowPhase+'" onchange="setFlowPhase(this);" style="width:100%;">';
				
				idTD.innerHTML='<select id="FlowPhaseSelect" onchange="setFlowPhase(this);" style="width:100%;"></select>';
				$("#FlowPhaseSelect").append("<option value='' selected='selected'>请选择</option>");
				htmlContent = "";
				for (var k in Data.FlowPhase) {	
					if(obj.FlowPhase==k)
						{
						$("#FlowPhaseSelect").append("<option  value='"+k+"' selected='selected'>"+Data.FlowPhase[k]+"</option>");
						}
					else
						{
						//htmlContent += "<option  value='"+k+"' selected='selected'>"+Data.FlowPhase[k]+"</option>";
						$("#FlowPhaseSelect").append("<option  value='"+k+"'>"+Data.FlowPhase[k]+"</option>");
						}
					}
				//$("#FlowPhaseSelect").append(htmlContent);
				
				
				
				//操作类别
				idTR=propview.insertRow();
				idTR.height="22";
				idTD=idTR.insertCell();
				idTD.align='right';
				idTD.noWrap=true;
				idTD.innerHTML="节点类型";
				idTD=idTR.insertCell();
				idTD.innerHTML='<select id="NodeType"  onchange="setNodeType(this);"  style="width:100%;">';
				htmlContent = "";
				for(var k in typeData){
					if(obj.NodeType==k)
						{
						$("#NodeType").append("<option value='"+k+"' selected='selected'>"+typeData[k]+"</option>");
						}
					else
						{
						//$("#NodeType").append("<option value='"+k+"'>"+typeData[k]+"</option>");
						htmlContent += "<option value='"+k+"'>"+typeData[k]+"</option>";
						}
					}
				$("#NodeType").append(htmlContent);
				
				//操作类别
				idTR=propview.insertRow();
				idTR.height="22";
				idTD=idTR.insertCell();
				idTD.align='right';
				idTD.noWrap=true;				
				idTD.innerHTML='<span id="OptTypeText">任务分配机制</span>';
				idTD=idTR.insertCell();
				idTD.innerHTML='<select id="OptType"  onchange="setOptType(this);"  style="width:100%;">';
				htmlContent = "";
				for (var k in Data.OptType) {		
					if(obj.OptType==k)
						{
					 $("#OptType").append("<option  value='"+k+"' selected='selected'>"+Data.OptType[k]+"</option>");						 
						}
					else
						{
						htmlContent += "<option  value='"+k+"' >"+Data.OptType[k]+"</option>";
						//$("#OptType").append("<option  value='"+k+"' >"+Data.OptType[k]+"</option>");	
						}
				}
				$("#OptType").append(htmlContent);
				
				//操作定义
				idTR=propview.insertRow();
				idTR.height="22";
				idTR.id="OptCode";
				idTD=idTR.insertCell();
				idTD.align='right';
				idTD.noWrap=true;			
				idTD.innerHTML='<span id="OptCodeText">业务代码</span>';
				idTD=idTR.insertCell();
				idTD.innerHTML='<select id="OptCodeSelect"  onchange="setOptCode(this);"  style="width:100%;">';
				//if(obj.OptCode=='0'||obj.OptCode==''){
					$("#OptCodeSelect").append("<option  value='0' selected='selected'>请选择</option>");	
				//}					
					htmlContent = "";	
				for (var k in Data.OptCode) {	
						if(obj.OptCode==k)
						{
						$("#OptCodeSelect").append("<option  value='"+k+"' selected='selected'>"+Data.OptCode[k]+"</option>");						 
						}
					else 
						{
						htmlContent += "<option  value='"+k+"' >"+Data.OptCode[k]+"</option>";
						//$("#OptCodeSelect").append("<option  value='"+k+"' >"+Data.OptCode[k]+"</option>");							
					}
				}
				$("#OptCodeSelect").append(htmlContent);
					
				//子流程定义
				idTR=propview.insertRow();
				idTR.height="22";
				idTR.id="Subwfcode";
				idTD=idTR.insertCell();
				idTD.align='right';
				idTD.noWrap=true;		
				idTD.innerHTML='<span id="SubwfcodeText">添加子流程</span>';
				idTD=idTR.insertCell();
				idTD.innerHTML='<select id="SubWfcode"  onchange="setSubWfcode(this);"  style="width:100%;">';
				if(obj.SubWfcode==''||obj.SubWfcode=='0'){
					$("#SubWfcode").append("<option  value='0' selected='selected'>请选择</option>");
				}
			    htmlContent ="";
				for (var k in Data.SubWfcode) {	
					if(obj.SubWfcode==k)
						{
						//htmlContent = "<option  value='"+k+"' selected='selected'>"+Data.SubWfcode[k]+"</option>";
						$("#SubWfcode").append("<option  value='"+k+"' selected='selected'>"+Data.SubWfcode[k]+"</option>");
						}
					else
						{
						htmlContent += "<option  value='"+k+"'>"+Data.SubWfcode[k]+"</option>";
						//$("#SubWfcode").append("<option  value='"+k+"'>"+Data.SubWfcode[k]+"</option>");
						}
					}
				$("#SubWfcode").append(htmlContent);
				//节点事件bean
				idTR=propview.insertRow();
				idTR.height="22";
				idTR.id="OptBean";
				idTD=idTR.insertCell();
				idTD.align='right';
				idTD.noWrap=true;		
				idTD.innerHTML='节点事件qqBean';
				idTD=idTR.insertCell();
				idTD.innerHTML='<input type="text" maxlength="50" value="'+obj.OptBean+'" onchange="setOptBean(this);" style="width:100%;">';
				
				
				//由操作类别引起的判断
				if(obj.OptType=="D"){     //自动流程节点的时候
					$("#OptCode").hide();
					$("#Subwfcode").hide();
				}
				else if(obj.OptType=="S"){     //选择为子流程的时候
					$("#OptCode").hide();
					//$("#OptBean").hide();
				}
				else{					//正常的时候
					$("#Subwfcode").hide();
					//$("#OptBean").hide();
				}
								
				//操作参数
				idTR=propview.insertRow();
				idTR.height="22";
				idTD=idTR.insertCell();
				idTD.align='right';
				idTD.noWrap=true;
				idTD.innerHTML="操作参数";
				idTD=idTR.insertCell();
				idTD.innerHTML='<input type="text" maxlength="100" value="'+obj.OptParam+'" onchange="setOptParam(this);" style="width:100%;">';
				
				//机构表达式
				idTR=propview.insertRow();
				idTR.height="22";
				idTD=idTR.insertCell();
				idTD.align='right';
				idTD.noWrap=true;
				idTD.innerHTML="机构表达式";
				idTD=idTR.insertCell();
				idTD.innerHTML='<input type="text" maxlength="50" value="'+obj.UnitExp+'" onchange="setUnitExp(this);" style="width:100%;">';
			
			
				//角色类别
				idTR=propview.insertRow();
				idTR.height="22";
				idTD=idTR.insertCell();
				idTD.align='right';
				idTD.noWrap=true;
				idTD.innerHTML="角色类别";
				idTD=idTR.insertCell();
				idTD.innerHTML='<select id="RoleType"  onchange="setRoleType(this);"   style="width:100%;">';
				
				var RoleTypelist=jQuery.parseJSON('{"bj":"办件角色","gw":"岗位角色","xz":"行政角色","en":"权限引擎"}');
				//alert(RoleTypelist.bj);
				//alert(obj.RoleType);
				if(obj.RoleType=='0'){
					$("#RoleType").append("<option  value='0' selected='selected'>请选择</option>");	
				}
				htmlContent = "";
				for(var k in RoleTypelist){
					if(obj.RoleType==k)
						{						
						$("#RoleType").append("<option  value='"+k+"' selected='selected'>"+RoleTypelist[k]+"</option>");	
					}
					else{
						htmlContent += "<option  value='"+k+"' >"+RoleTypelist[k]+"</option>";
						//$("#RoleType").append("<option  value='"+k+"' >"+RoleTypelist[k]+"</option>");	
					}				
				}
				$("#RoleType").append(htmlContent);
				
				//角色代码
				
				idTR=propview.insertRow();
				idTR.height="22";
				idTR.id="rolecodetr";
				idTD=idTR.insertCell();
				idTD.align='right';
				idTD.noWrap=true;
				idTD.id="RoleCodetd1";
				if(obj.RoleType!="en"){
				idTD.innerHTML='<span id="RoleCodeText">角色代码</span>';
				idTD=idTR.insertCell();				
				idTD.innerHTML='<select id="RoleCode"  onchange="setRoleCode(this);"  style="width:100%;">';				
				//$("#RoleCode").append("<option  value='"+obj.RoleCode+"'selected='selected'>"+Data[obj.RoleType][obj.RoleCode]+"</option>");
				if(obj.RoleCode=='0'){
					$("#RoleCode").append("<option  value='0' selected='selected' >请选择</option>");
				}
				htmlContent = "";
				if(obj.RoleType!='0'){
					for(var k in Data[obj.RoleType] )
						{
						
							if(obj.RoleCode==k)
								{
								$("#RoleCode").append("<option  value='"+k+"' selected='selected' >"+Data[obj.RoleType][k]+"</option>");
								}							
							else
								{
								htmlContent += "<option  value='"+k+"'>"+Data[obj.RoleType][k]+"</option>";
								//$("#RoleCode").append("<option  value='"+k+"'>"+Data[obj.RoleType][k]+"</option>");
								}							
						}
					}
				$("#RoleCode").append(htmlContent);
				}
				else{					
					idTD.innerHTML='<span id="PowerExpText">权限表达式</span>';
					idTD=idTR.insertCell();
					idTD.innerHTML='<input type="text" maxlength="50" id="PowerExp" onchange="setPowerExp(this);" value="'+obj.PowerExp+'"style="width:100%;" >';
				};
				
				//风险点设置
				idTR=propview.insertRow();
				idTR.height="22";
				idTD=idTR.insertCell();
				idTD.align='right';
				idTD.noWrap=true;
				idTD.innerHTML="风险点设置";
				idTD=idTR.insertCell();
				idTD.innerHTML='<input type="text" maxlength="50" id="riskinfo" value="'+obj.Riskinfo+'" onchange="setRiskinfo(this);" style="width:50%;" readonly="readonly"/><input type="button" onclick="addriskinfo();" value="选择"/>';
				
				var typeTime=jQuery.parseJSON('{"H":"仅环节计时","F":"不计时","T":"计时"}');
				//是否计时
				idTR=propview.insertRow();
				idTR.height="22";
				idTD=idTR.insertCell();
				idTD.align='right';
				idTD.noWrap=true;
				idTD.innerHTML="是否计时";
				idTD=idTR.insertCell();
				idTD.innerHTML='<select id="IsAccountTime"  onchange="setIsAccountTime(this);"  style="width:100%;">';
				htmlContent = "";
				for(var k in typeTime){
					if(obj.IsAccountTime==k){
						$("#IsAccountTime").append("<option  value='"+k+"' selected='selected' >"+typeTime[k]+"</option>");
					}
					else{
						htmlContent += "<option  value='"+k+"' >"+typeTime[k]+"</option>";
						//$("#IsAccountTime").append("<option  value='"+k+"' >"+typeTime[k]+"</option>");
					}
				}
				$("#IsAccountTime").append(htmlContent);
				
				var Typelist=jQuery.parseJSON('{"I":"默认","N":"无期限","F":"每实例固定期限","C":"节点固定期限"}');
				idTR=propview.insertRow();
				idTR.height="22";
				idTD=idTR.insertCell();
				idTD.align='right';
				idTD.noWrap=true;
				idTD.innerHTML="期限类别";
				idTD=idTR.insertCell();
				idTD.innerHTML='<select id="timeLimitType"  onchange="setTimeLimitType(this);"  style="width:100%;">';
				htmlContent = "";
				for(var k in Typelist)
				{
				if(obj.TimeLimitType==k)
					{
					$("#timeLimitType").append("<option  value='"+k+"' selected='selected'>"+Typelist[k]+"</option>");
					}
				else{
					htmlContent += "<option  value='"+k+"'>"+Typelist[k]+"</option>";
					//$("#timeLimitType").append("<option  value='"+k+"'>"+Typelist[k]+"</option>");
				}
				
				}
				$("#timeLimitType").append(htmlContent);
				
				//继承期限
				var inheritType=jQuery.parseJSON('{"0":"不继承","1":"继承前节点","2":"继承指定节点"}');
				idTR=propview.insertRow();
				idTR.height="22";
				idTD=idTR.insertCell();
				idTD.align='right';
				idTD.noWrap=true;
				idTD.innerHTML="继承期限";
				idTD=idTR.insertCell();
				idTD.innerHTML='<select id="inheritType"  onchange="setInheritType(this);"  style="width:100%;">';
				htmlContent = "";
				for(var k in inheritType)
				{
				if(obj.InheritType==k)
					{
					$("#inheritType").append("<option  value='"+k+"' selected='selected'>"+inheritType[k]+"</option>");
					}
				else{
					htmlContent += "<option  value='"+k+"'>"+inheritType[k]+"</option>";
					//$("#timeLimitType").append("<option  value='"+k+"'>"+Typelist[k]+"</option>");
				}
				
				}
				$("#inheritType").append(htmlContent);
				
				//继承节点代码
				idTR=propview.insertRow();
				idTR.height="22";
				idTR.id="inheritNodeCode";
				idTD=idTR.insertCell();
				idTD.align='right';
				idTD.noWrap=true;
				idTD.innerHTML="继承节点代码";
				idTD=idTR.insertCell();
				idTD.innerHTML='<input type="text" maxlength="50" value="'+obj.InheritNodeCode+'" onchange="setInheritNodeCode(this);" style="width:100%;">';
				if(obj.InheritType=='2'){
					$("#inheritNodeCode").show();
				}
				else{
					$("#inheritNodeCode").hide();
				}
				
				//预期时间
				idTR=propview.insertRow();
				idTR.height="22";
				idTR.id="timelimit";
				idTD=idTR.insertCell();
				idTD.align='right';
				idTD.noWrap=true;
				idTD.innerHTML="期限设定";
				idTD=idTR.insertCell();
				idTD.innerHTML='<input type="text" maxlength="50" value="'+obj.TimeLimit+'" onchange="setTimeLimit(this);" style="width:100%;">';
				
				//预期处理方法
				var ExpireOptlist=jQuery.parseJSON('{"N":"通知","O":"不处理","S":"挂起","E":"终止","C":"完成"}');
				idTR=propview.insertRow();
				idTR.height="22";
				idTD=idTR.insertCell();
				idTD.align='right';
				idTD.noWrap=true;
				idTD.innerHTML="过期处理方法";
				idTD=idTR.insertCell();
				idTD.innerHTML='<select id="ExpireOpt"  onchange="setExpireOpt(this);"  style="width:100%;">';
				htmlContent = "";
				for(var k in ExpireOptlist)
					{
					if(obj.ExpireOpt==k)
						{
						$("#ExpireOpt").append("<option  value='"+k+"' selected='selected'>"+ExpireOptlist[k]+"</option>");
						}
					else{
						htmlContent += "<option  value='"+k+"'>"+ExpireOptlist[k]+"</option>";
						//$("#ExpireOpt").append("<option  value='"+k+"'>"+ExpireOptlist[k]+"</option>");
					}
					
					}
				$("#ExpireOpt").append(htmlContent);
			
				 //节点是否主干节点
				var isTrunkLinelist=jQuery.parseJSON('{"T":"是","F":"否"}');
				idTR=propview.insertRow();
				idTR.height="22";
				idTD=idTR.insertCell();
				idTD.align='right';
				idTD.noWrap=true;
				idTD.innerHTML="是否主干节点";
				idTD=idTR.insertCell();
				idTD.innerHTML='<select id="isTrunkLine"  onchange="setIsTrunkLine(this);"  style="width:100%;">'; 
				for(var k in isTrunkLinelist)
				{
				if(obj.isTrunkLine==k)
					{
					$("#isTrunkLine").append("<option  value='"+k+"' selected='selected'>"+isTrunkLinelist[k]+"</option>");
					}
				else{
					$("#isTrunkLine").append("<option  value='"+k+"'>"+isTrunkLinelist[k]+"</option>");
				}
				
				}
				 //节点描述说明
				idTR=propview.insertRow();
				idTR.height="22";
				idTD=idTR.insertCell();
				idTD.align='right';
				idTD.noWrap=true;
				idTD.innerHTML="说 &nbsp; &nbsp;明";
				idTD=idTR.insertCell();
				idTD.innerHTML='<textarea name="Desc" onchange="setDesc(this);" style="width:100%;height:45px;">'+obj.Desc+'</textarea>'; 
		
				
			}//end 不是开始节点
		}// end 节点其他属性
	//end 节点属性
	else {
		//begin 联线属性
		//条件		
		idTR=propview.insertRow();
		idTR.height="22";
		idTD=idTR.insertCell();
		idTD.align='right';
		idTD.noWrap=true;
		idTD.innerHTML="条 &nbsp; &nbsp;件";
		idTD=idTR.insertCell();
		idTD.innerHTML='<textarea id="Cond" onchange="setCond(this)" value="'+obj.Cond+'" style="height:50;width:100%;">'+obj.Cond+'</textarea>'+'<br><button type="button" onclick="addCond();" style="text-align:center">编辑条件</button>';
		
		//timelimitType  未设置（ignore 默认 ）、N 无 (无期限 none ) 、 F 每实例固定期限 fix 、C 节点固定期限  cycle、H 继承上一个节点剩余时间 hierarchical。
		var Typelist=jQuery.parseJSON('{"I":"默认","N":"无期限","F":"每实例固定期限","C":"节点固定期限"}');
		idTR=propview.insertRow();
		idTR.height="22";
		idTD=idTR.insertCell();
		idTD.align='right';
		idTD.noWrap=true;
		idTD.innerHTML="期限类别";
		idTD=idTR.insertCell();
		idTD.innerHTML='<select id="timeLimitType"  onchange="setStepTimeLimitType(this);"  style="width:100%;">';
		for(var k in Typelist)
		{
		if(obj.TimeLimitType==k)
			{
			$("#timeLimitType").append("<option  value='"+k+"' selected='selected'>"+Typelist[k]+"</option>");
			}
		else{
			$("#timeLimitType").append("<option  value='"+k+"'>"+Typelist[k]+"</option>");
		}
		}
		
		//继承期限
		var inheritType=jQuery.parseJSON('{"0":"不继承","1":"继承前节点","2":"继承指定节点"}');
		idTR=propview.insertRow();
		idTR.height="22";
		idTD=idTR.insertCell();
		idTD.align='right';
		idTD.noWrap=true;
		idTD.innerHTML="继承期限";
		idTD=idTR.insertCell();
		idTD.innerHTML='<select id="inheritType"  onchange="setStepInheritType(this);"  style="width:100%;">';
		htmlContent = "";
		for(var k in inheritType)
		{
		if(obj.InheritType==k)
			{
			$("#inheritType").append("<option  value='"+k+"' selected='selected'>"+inheritType[k]+"</option>");
			}
		else{
			htmlContent += "<option  value='"+k+"'>"+inheritType[k]+"</option>";
			//$("#timeLimitType").append("<option  value='"+k+"'>"+Typelist[k]+"</option>");
		}
		
		}
		$("#inheritType").append(htmlContent);
		
		//继承节点代码
		idTR=propview.insertRow();
		idTR.height="22";
		idTR.id="stepInheritNodeCode";
		idTD=idTR.insertCell();
		idTD.align='right';
		idTD.noWrap=true;
		idTD.innerHTML="继承节点代码";
		idTD=idTR.insertCell();
		idTD.innerHTML='<input type="text" maxlength="50" value="'+obj.InheritNodeCode+'" onchange="setStepInheritNodeCode(this);" style="width:100%;">';
		
		if(obj.InheritType=='2'){
			$("#stepInheritNodeCode").show();
		}
		else{
			$("#stepInheritNodeCode").hide();
		}
		
		//TimeLimit  
		idTR=propview.insertRow();
		idTR.height="22";
		idTD=idTR.insertCell();
		idTD.align='right';
		idTD.noWrap=true;
		idTD.innerHTML="期限设定";
		idTD=idTR.insertCell();
		idTD.innerHTML='<input type="text" maxlength="50" value="'+obj.TimeLimit+'" onchange="setStepTimeLimit(this);" style="width:100%;">';
		
		//说明
		idTR=propview.insertRow();
		idTR.height="22";
		idTD=idTR.insertCell();
		idTD.align='right';
		idTD.noWrap=true;
		idTD.innerHTML="流转描述";
		idTD=idTR.insertCell();
		idTD.innerHTML='<textarea name="Desc" onchange="setStepDesc(this);" style="width:100%;height:45px;">'+obj.Desc+'</textarea>';
	
	
	
	
	
	
	
	}//end 联线属性
	}


//名称:getCond()
//说明:生成新页面选择条件
//参数:无
//作者:xc
//时间:2011-11-17
function addCond(){
	var condvalue=$("#Cond").attr("value");
	var myCond=window.showModalDialog(path+"/page/workflow/addCond.jsp?optid="+optid,condvalue,"dialogHeight:   500px;   dialogWidth:   600px;   edge:   Raised;   center:   Yes;   help:   No;   resizable:   no;   status:   no; ");	
	if(myCond)
		{
		$("#Cond").attr("value",myCond.cond);
	
		var obj=_FLOW.getStepByID(_FOCUSTEDOBJ.id);
		var oldValue=obj.Cond;
		var mcond=myCond.cond;

		if(obj.Cond==mcond) {
			return ;
		}
		obj.Cond=mcond;
		//alert(obj.Cond);
		pushLog("editprop",{
			"obj":obj,"prop":"Cond","_old":oldValue,"_new":obj.Cond
		});
		
		}
	
}
//名称:getCond()
//说明:生成新页面选择风险点
//参数:无
//作者:xc
//时间:2011-11-17
function addriskinfo(){
	var riskinfo=$("#riskinfo").attr("value");
	var myriskinfo=window.showModalDialog(path+"/powerruntime/riskInfo!listSelect.do?riskid="+riskinfo+"&fromjs=1",null,"dialogHeight:   700px;   dialogWidth:   700px;   edge:   Raised;   center:   Yes;   help:   No;   resizable:   no;   status:   no; ");
	if(myriskinfo){
		$("#riskinfo").attr("value",myriskinfo.riskid);
		var obj=_FLOW.getProcByID(_FOCUSTEDOBJ.id);
		var oldValue=obj.Riskinfo;
		if(obj.Riskinfo==myriskinfo.riskid) {
			return ;
		}
		obj.Riskinfo=myriskinfo.riskid;
		//alert(obj.Cond);
		pushLog("editprop",{
			"obj":obj,"prop":"risk","_old":oldValue,"_new":myriskinfo.riskid
		});
		
	}
}


//CACHE
function emptyLog() {
	_DOLOG=[];
	_DOLOGINDEX=-1;
}
function pushLog(act,obj) {
	var newLog=_DOLOG.slice(0,_DOLOGINDEX+1);
	_DOLOG=newLog;
	_DOLOGINDEX=_DOLOG.push({
		"act":act,"val":obj
	})-1;
}
function getLog() {
	return _DOLOG[_DOLOGINDEX];
}
function undoLog() {
	if(_DOLOGINDEX==-1) {
		alert("没有操作记录可以撤消.");
		return ;
	}
	if(doLog("undo")) {
		_DOLOGINDEX--;
	}
}
function redoLog() {
	if(_DOLOGINDEX==_DOLOG.length-1) {
		alert("没有操作记录可以恢复.");
		return ;
	}
	_DOLOGINDEX++;
	doLog("redo");
}
function doLog(act) {
	var log=getLog();
	/*TODO 是否要进行提醒
			if(!confirm("确定要*"+(act == "undo"?"撤消":"恢复")+"*最后一次操作[" + log.act + "]吗？")) {
			    if(act == "redo") _DOLOGINDEX --;
			    return false;
			  }*/
	switch(log.act) {
		case "addproc":
		act=="undo"?_FLOW.deleteProcByID(log.val.ID):_FLOW.addProc(log.val);
		DrawAll();
		break;
		case "addstep":
		act=="undo"?_FLOW.deleteStepByID(log.val.ID):_FLOW.addStep(log.val);
		DrawAll();
		break;
		case "delproc":
		act=="undo"?_FLOW.addProc(log.val):_FLOW.deleteProcByID(log.val.ID);
		DrawAll();
		break;
		case "delstep":
		act=="undo"?_FLOW.addStep(log.val):_FLOW.deleteStepByID(log.val.ID);
		DrawAll();
		break;
		case "editproc":
		if(act=="undo") {
			var Proc=_FLOW.getProcByID(log.val._new.ID);
			Proc.clone(log.val._old);
			if(log.val._new.ID!=log.val._old.ID) {
				changeProcID(log.val._new.ID,log.val._old.ID);
			}
		}
		else {
			var Proc=_FLOW.getProcByID(log.val._old.ID);
			Proc.clone(log.val._new);
			if(log.val._new.ID!=log.val._old.ID) {
				changeProcID(log.val._old.ID,log.val._new.ID);
			}
		}
		DrawAll();
		objFocusedOn(act=="undo"?log.val._old.ID:log.val._new.ID);
		break;
		case "editstep":
		if(act=="undo") {
			var Step=_FLOW.getStepByID(log.val._new.ID);
			Step.clone(log.val._old);
		}
		else {
			var Step=_FLOW.getStepByID(log.val._old.ID);
			Step.clone(log.val._new);
		}
		DrawVML();
		objFocusedOn(act=="undo"?log.val._old.ID:log.val._new.ID);
		break;
		case "moveproc":
		var obj=_FLOW.getProcByID(log.val.objID);
		if(act=="undo") {
			obj.setPropValue("X",log.val._old.X);
			obj.setPropValue("Y",log.val._old.Y);
			obj.setPropValue("Width",log.val._old.Width);
			obj.setPropValue("Height",log.val._old.Height);
		}
		else {
			obj.setPropValue("X",log.val._new.X);
			obj.setPropValue("Y",log.val._new.Y);
			obj.setPropValue("Width",log.val._new.Width);
			obj.setPropValue("Height",log.val._new.Height);
		}
		changeProcPos(obj.InnerObject);
		DrawAll();
		break;
		case "editprop":
		var CurrentProp=(act=="undo"?log.val._old:log.val._new);
		if(log.val.obj[log.val.prop]||log.val.obj[log.val.prop]=="")//如果存在属性则修改
		{
			log.val.obj[log.val.prop]=CurrentProp;
		}
		switch(log.val.prop) {
			case "ID":
			if(log.val.obj.ObjType=="Proc") {
				act=="undo"?changeProcID(log.val._new,log.val._old):changeProcID(log.val._old,log.val._new);
			}
			DrawVML();
			objFocusedOn(log.val.obj.ID);
			break;
			case "Text":
			DrawAll();
			objFocusedOn(log.val.obj.ID);
			break;
			case "ProcType":
			var _shapeType=(act=="undo"?log.val._oldShape:log.val._newShape);
			log.val.obj.ShapeType=_shapeType;
			DrawVML();
			objFocusedOn(log.val.obj.ID);
			break;
			case "TextWeight":
			document.all(log.val.obj.ID+"Text").style.fontSize=CurrentProp;
			break;
			case "zIndex":
			log.val.obj.InnerObject.style.zIndex=CurrentProp;
			break;
			case "StrokeWeight":
			log.val.obj.InnerObject.strokeweight=CurrentProp;
			break;
			case "X":
			log.val.obj.InnerObject.style.left=CurrentProp;
			changeProcPos(log.val.obj.InnerObject);
			break;
			case "Y":
			log.val.obj.InnerObject.style.top=CurrentProp;
			changeProcPos(log.val.obj.InnerObject);
			break;
			case "Width":
			log.val.obj.InnerObject.style.width=CurrentProp;
			changeProcPos(log.val.obj.InnerObject);
			break;
			case "Height":
			log.val.obj.InnerObject.style.height=CurrentProp;
			changeProcPos(log.val.obj.InnerObject);
			break;
			case "Cond":
			document.all(log.val.obj.ID+"Text").innerHTML=CurrentProp;
			break;
			case "StartArrow":
			document.all(log.val.obj.ID+"Arrow").startarrow=CurrentProp;
			break;
			case "EndArrow":
			document.all(log.val.obj.ID+"Arrow").endarrow=CurrentProp;
			break;
			case "FromProc":
			case "ToProc":
			if(log.val.obj.ShapeType=="Line") {
				log.val.obj.getPath();
				log.val.obj.InnerObject.from=log.val.obj.FromPoint;
				log.val.obj.InnerObject.to=log.val.obj.ToPoint;
			}
			else if(log.val.ShapeType=="PolyLine") {
				log.val.obj.InnerObject.points.value=log.val.obj.getPath();
			}
			DrawDataView();
			break;
		}
		break;
	}
	stuffProp();
	return true;
}
function doProcMouseDown(obj,x,y) {
	//判断是否是画线
	if(_TOOLTYPE=="line"||_TOOLTYPE=="polyline") {
		_CURRENTX=x;
		_CURRENTY=y;
		_MOVEOBJ=document.all("_lineui");
		_MOVEOBJ.from = _CURRENTX + "," + _CURRENTY;
		//_MOVEOBJ.from=(_CURRENTX-document.body.scrollLeft)+","+(_CURRENTY-document.body.scrollTop);
		//原代码
		_MOVEOBJ.to=_MOVEOBJ.from;
		_MOVEOBJ.style.display="block";
		_MOVETYPE=_TOOLTYPE;
	}
	else {
		var rightSide=(parseInt(obj.style.left)+parseInt(obj.style.width)-x<=2);
		var bottomSide=(parseInt(obj.style.top)+parseInt(obj.style.height)-y<=2);
		if(rightSide&&bottomSide) {
			_MOVETYPE="proc_nw";
		}
		else if(rightSide) {
			_MOVETYPE="proc_e";
		}
		else if(bottomSide) {
			_MOVETYPE="proc_n";
		}
		else {
			_MOVETYPE="proc_m";
			_CURRENTX=x-obj.offsetLeft;
			_CURRENTY=y-obj.offsetTop;
		}
		_MOVEOBJ=obj;
	}
	window.event.cancelBubble=true;
}
// 这里的x,y是换算过的值(/ZOOM)
function fireProcMouseDown(x,y) {
	var curProc=null;
	//遍历节点
	for(var i=0;i<_FLOW.Procs.length;i++) {
		Proc=_FLOW.Procs[i];
		if(x>=parseInt(Proc.X)&&x<=(parseInt(Proc.X)+parseInt(Proc.Width))
		&&y>=parseInt(Proc.Y)&&y<=(parseInt(Proc.Y)+parseInt(Proc.Height))) {
			//if(curProc==null||Proc.zIndex>=curProc.zIndex)// 重叠的情况下取上面那个
			curProc=Proc;
		}
	}
	//遍历标签
	for(var i=0;i<_FLOW.Steps.length;i++) {
		Proc=_FLOW.Steps[i].Label;
		if(x>=parseInt(Proc.X)&&x<=(parseInt(Proc.X)+parseInt(Proc.Width))
		&&y>=parseInt(Proc.Y)&&y<=(parseInt(Proc.Y)+parseInt(Proc.Height))) {
			//if(curProc==null||Proc.zIndex>=curProc.zIndex)// 重叠的情况下取上面那个
			curProc=Proc;
		}
	}
	if(curProc!=null) {
		obj=document.getElementById(curProc.ID);
		if(obj.tagName!='DIV') {
			document.body.focus();
			objFocusedOn(obj.id);
		}
		doProcMouseDown(obj,x,y);
		return true;
	}
	return false;
}
// 这里的x,y是换算过的值(/ZOOM)
function doProcMouseMove(obj,x,y) {
	if(_TOOLTYPE=="line"||_TOOLTYPE=="polyline") {
		document.all.Canvas.style.cursor="crosshair";
	}
	else {
		var rightSide=(parseInt(obj.style.left)+parseInt(obj.style.width)-x<=2);
		var bottomSide=(parseInt(obj.style.top)+parseInt(obj.style.height)-y<=2);
		if(rightSide&&bottomSide) {
			document.all.Canvas.style.cursor="NW-resize";
		}
		else if(rightSide) {
			document.all.Canvas.style.cursor="E-resize";
		}
		else if(bottomSide) {
			document.all.Canvas.style.cursor="N-resize";
		}
		else {
			document.all.Canvas.style.cursor="hand";
		}
	}
	//show(document.all.Canvas.style.cursor)
}
// 这里的x,y是换算过的值(/ZOOM)
function fireProcMouseMove(x,y) {
	if(document.all.Canvas==null) {
		return ;
	}
	for(var i=0;i<_FLOW.Procs.length;i++) {
		Proc=_FLOW.Procs[i];
		obj=document.getElementById(Proc.ID);
		if(x>=parseInt(Proc.X)&&x<=(parseInt(Proc.X)+parseInt(Proc.Width))
		&&y>=parseInt(Proc.Y)&&y<=(parseInt(Proc.Y)+parseInt(Proc.Height))) {
			doProcMouseMove(obj,x,y);
			return true;
		}
	}
	for(var i=0;i<_FLOW.Steps.length;i++) {
		Proc=_FLOW.Steps[i].Label;
		obj=document.getElementById(Proc.ID);
		if(x>=parseInt(Proc.X)&&x<=(parseInt(Proc.X)+parseInt(Proc.Width))
		&&y>=parseInt(Proc.Y)&&y<=(parseInt(Proc.Y)+parseInt(Proc.Height))) {
			doProcMouseMove(obj,x,y);
			return true;
		}
	}
	/*if(oOval)
					document.body.removeChild(oOval);
			  for(var i = 0; i< _FLOW.Steps.length; i ++) {
			    Step = _FLOW.Steps[i];
				var strPt =Step.Points;
				var aryPt = strPt.split(',');
				var nPt=aryPt.length-1;
				for(i=0;i<=nPt;i=i+2)
				{
					var m = aryPt[i].substr(0,aryPt[i].length-2)*4/3;
					var n = aryPt[i+1].substr(0,aryPt[i+1].length-2)*4/3;
					var sqrta = Math.sqrt((x-m)*(x-m)+(y-n)*(y-n));
					if(isSelectPoint==0&&sqrta<=10)
					{
						_PointOrLine = 0;
						isSelectPoint=1;
						createOval(m,n)
					}
				}
			  }*/
	if(i>=_FLOW.Procs.length) {
		document.all.Canvas.style.cursor=(_TOOLTYPE=="point"?"default":"crosshair");
	}
	if(i>=_FLOW.Labels.length) {
		document.all.Canvas.style.cursor=(_TOOLTYPE=="point"?"default":"crosshair");
	}
	return false;
}
function doDocMouseDown() {
	//document.body.focus();
	if(event.button==2) {
		return false;
	}
	var x=(event.x+document.body.scrollLeft)/_ZOOM;
	var y=(event.y+document.body.scrollTop)/_ZOOM;
	var oEvt=event.srcElement;
	if(oEvt.id=="tableContainer"||oEvt.id=="") {
		return ;
	}
	// 过滤数据视图/对象视图上的事件
	if(oEvt.typ=="Step")
	{
		document.body.focus();
		document.all.Canvas.style.cursor="default";
		return ;
	}
	if(fireProcMouseDown(x,y)) {
		return ;
	}
	// 过滤图元上的事件
	switch(_TOOLTYPE) {
		case "rect":
		case "roundrect":
		case "diamond":
		case "oval":
		case "fillrect":
		if(oEvt.tagName!="DIV") {
			return ;
		}
		if(oEvt.id!="Canvas") {
			return ;
		}
		var obj=document.all("_"+_TOOLTYPE+"ui");
		_CURRENTX=x;
		_CURRENTY=y;
		obj.style.left=_CURRENTX;
		obj.style.top=_CURRENTY;
		obj.style.width=0;
		obj.style.height=0;
		obj.style.display="block";
		_MOVETYPE=_TOOLTYPE;
		break;
	}
}
function doDocMouseMove() {
	var x=(event.x+document.body.scrollLeft)/_ZOOM;
	var y=(event.y+document.body.scrollTop)/_ZOOM;
	var m,n,aryPt,_movePt,sqrta,_moveLine;
	switch(_MOVETYPE) {
		case "line":
		case "polyline":
		_MOVEOBJ.to = x + "," + y;
		//_MOVEOBJ.to=(x-document.body.scrollLeft)+","+(y-document.body.scrollTop);
		//原代码
		break;
		case "line_m":
		var zx=x*_ZOOM;
		var zy=y*_ZOOM;
		if(oOval==null)
		{
			createOval(x*_ZOOM,y*_ZOOM);
			if(_PointOrLine==0)
			{
				oOval.fillcolor="blue";
				oOval.strokecolor="blue";
			}
		}
		m=_clkPx.substr(0,_clkPx.length-2)*4/3;
		n=_clkPy.substr(0,_clkPy.length-2)*4/3;
		sqrta=Math.sqrt((x-m)*(x-m)+(y-n)*(y-n));
		var _arySltLine=_strSltLine.split(',');
		if(sqrta>10)
		{
			if(oOval)
			{
				oOval.style.left=zx-3;
				oOval.style.top=zy-3;
			}
			if(_PointOrLine==0) {
				_movePt=(x*3/4)+'pt,'+(y*3/4)+"pt";
				_MOVEOBJ.Points=_strPt1+""+_movePt+""+_strPt2;
			}
			else {
				_moveLine=_arySltLine[0]+','+_arySltLine[1]+','+x*3/4+'pt,'+y*3/4+'pt,'+_arySltLine[2]+','+_arySltLine[3];
				_MOVEOBJ.Points=_strLine1+_moveLine+_strLine2;
			}
			document.getElementById(_MOVEOBJ.ID).outerHTML=_MOVEOBJ.toStringWithoutLabel();
			_FLOW.Modified=true;
		}
		break;
		case "proc_m":
		m=_clkPx.substr(0,_clkPx.length-2)*4/3;
		n=_clkPy.substr(0,_clkPy.length-2)*4/3;
		sqrta=Math.sqrt((x-m)*(x-m)+(y-n)*(y-n));
		if(_MOVEOBJ.tagName=='DIV')
		{
			var newX=x-_CURRENTX;
			var newY=y-_CURRENTY;
			_MOVEOBJ.style.left=newX+2;
			//修正两个像素
			_MOVEOBJ.style.top=newY+2;
		}
		else
		{
			if(sqrta>10)
			{
				var newX=x-_CURRENTX;
				var newY=y-_CURRENTY;
				if(newX<0) {
					newX=0;
				}
				if(newY<30) {
					newY=30;
				}
				_MOVEOBJ.style.left=getMinMod(newX,10);
				//对齐网格
				_MOVEOBJ.style.top=getMinMod(newY,10);
				if(_MOVEOBJ.tagName!='DIV') {
					changeProcPos(_MOVEOBJ);
				}
			}
		}
		break;
		case "proc_n":
		var newH=y-parseInt(_MOVEOBJ.style.top);
		if(newH<30) {
			newH=30;
		}
		_MOVEOBJ.style.height=getMinMod(newH,10);
		if(_MOVEOBJ.tagName!='DIV') {
			changeProcPos(_MOVEOBJ);
		}
		break;
		case "proc_e":
		var newW=x-parseInt(_MOVEOBJ.style.left);
		if(newW<35) {
			newW=35;
		}
		_MOVEOBJ.style.width=getMinMod(newW,10);
		if(_MOVEOBJ.tagName!='DIV') {
			changeProcPos(_MOVEOBJ);
		}
		break;
		case "proc_nw":
		var newW=x-parseInt(_MOVEOBJ.style.left);
		var newH=y-parseInt(_MOVEOBJ.style.top);
		if(newW<30) {
			newW=30;
		}
		if(newH<30) {
			newH=30;
		}
		_MOVEOBJ.style.width=getMinMod(newW,10);
		_MOVEOBJ.style.height=getMinMod(newH,10);
		if(_MOVEOBJ.tagName!='DIV') {
			changeProcPos(_MOVEOBJ);
		}
		break;
		case "rect":
		case "roundrect":
		case "diamond":
		case "oval":
		case "fillrect":
		var newX=x;
		var newY=y;
		var obj=document.all("_"+_MOVETYPE+"ui");
		if(newX<_CURRENTX) {
			obj.style.left=newX;
		}
		obj.style.width=Math.abs(newX-_CURRENTX);
		if(newY<_CURRENTY) {
			obj.style.top=newY;
		}
		obj.style.height=Math.abs(newY-_CURRENTY);
		break;
		default:// 不是在移动状态下，将鼠标移动消息交给图元
		fireProcMouseMove(x,y);
	}//End Switch
}
function doDocMouseUp() {
	
	if(event.button==2) {
		return false;
	}
	var x=(event.x+document.body.scrollLeft)/_ZOOM;
	var y=(event.y+document.body.scrollTop)/_ZOOM;
	if(oOval) {
		document.body.removeChild(oOval);
	}
	oOval=null;
	var test = _MOVETYPE;
	switch(_MOVETYPE) {
		case "line_m":
		//var Step = _FLOW.getStepByID(_MOVEOBJ.ID);
		var ProcTo="";
		ProcTo=_FLOW.getProcAtXY(x,y);
		if(ProcTo==null)
		{
			if(ptMoveType=="from"||ptMoveType=="to")
			{
				_MOVEOBJ.Points=_strPt1+_strSltPt+_strPt2;
				document.getElementById(_MOVEOBJ.ID).outerHTML=_MOVEOBJ.toStringWithoutLabel();
			}
		}
		else
		{
			if(ptMoveType=="from"||ptMoveType=="to")
			{
				var Proc1,Proc2;
				Proc1=_FLOW.getProcAtXY(_CURRENTX,_CURRENTY);
				Proc2=_FLOW.getProcAtXY(x,y);
				var nearPt=getNearPt(ProcTo,x,y);
				var strPt=nearPt.split("|~|")[0];
				var arrPt=strPt.split(",");
				var strPos=nearPt.split("|~|")[1];
				var nX=arrPt[0].substr(0,arrPt[0].length-2);
				var nY=arrPt[1].substr(0,arrPt[1].length-2);
				var relX=strPos.split(",")[0];
				var relY=strPos.split(",")[1];
				if(ptMoveType=="from")
				{
					Proc1=ProcTo;
					Proc2=_FLOW.getProcByID(_MOVEOBJ.ToProc);
				}
				if(ptMoveType=="to")
				{
					Proc1=_FLOW.getProcByID(_MOVEOBJ.FromProc);
					Proc2=ProcTo;
				}
				var existProc=_FLOW.StepPathExists(Proc1.ID,Proc2.ID);
				if((Proc1.ID==Proc2.ID)||(existProc!=null&&existProc.ID!=_MOVEOBJ.ID)
				||(Proc1.ProcType=="end"||Proc2.ProcType=="begin")
				||(_MOVEOBJ.FromProc=="begin"&&ptMoveType=="from"&&ProcTo.ID!=_MOVEOBJ.FromProc)
				||(_MOVEOBJ.FromProc=="begin"&&ptMoveType=="to"&&ProcTo.ID!=_MOVEOBJ.ToProc)
				||(_MOVEOBJ.FromProc!="begin"&&ProcTo.ID=="begin")) {
					if(existProc!=null&&existProc.ID!=_MOVEOBJ.ID) {
						alert("已经有一个路径从["+_FLOW.getProcByID(Proc1.ID).Text+"]至["+_FLOW.getProcByID(Proc2.ID).Text+"]，操作不成功");
					}
					if(Proc1.ProcType=="end"||Proc2.ProcType=="begin") {
						alert("路径必须符合“起点不能是结束结点，终点不能是开始结点”的规则！");
					}
					if(Proc1.ID==Proc2.ID) {
						alert("不能指向本身！");
					}
					//FromProc是开始节点的联线
					//if (ptMoveType=="from"&&ProcTo.ID!=_MOVEOBJ.FromProc)alert(_MOVEOBJ.FromProc);
					//if (ptMoveType=="to"&&ProcTo.ID!=_MOVEOBJ.ToProc)alert(_MOVEOBJ.FromProc);
					_MOVEOBJ.Points=_strPt1+_strSltPt+_strPt2;
					document.getElementById(_MOVEOBJ.ID).outerHTML=_MOVEOBJ.toStringWithoutLabel();
				}
				else
				{
					if(ptMoveType=="from")
					{
						_MOVEOBJ.setPropValue("FromProc",ProcTo.ID);
						_MOVEOBJ.fromRelX=relX;
						_MOVEOBJ.fromRelY=relY;
					}
					if(ptMoveType=="to")
					{
						_MOVEOBJ.setPropValue("ToProc",ProcTo.ID);
						_MOVEOBJ.toRelX=relX;
						_MOVEOBJ.toRelY=relY;
					}
					_MOVEOBJ.Points=_strPt1+strPt+_strPt2;
					document.getElementById(_MOVEOBJ.ID).outerHTML=_MOVEOBJ.toStringWithoutLabel();
					//stuffProp();
					_FLOW.Modified=true;
				}
			}
		}
		var newobj=new TStep(_FLOW);
		newobj.clone(_MOVEOBJ);
		pushLog("editstep",{
			"_old":_MOVELINEOBJ,"_new":newobj
		});
		////updateFlow(document.getElementById(_MOVEOBJ.ID));
		if(oOval) {
			document.body.removeChild(oOval);
		}
		oOval=null;
		//DrawAll();//重画界面,防止同一条联线出现2个相同的标签
		//当前联线获取焦点
		document.getElementById(_MOVEOBJ.ID).StrokeColor=document.getElementById(_MOVEOBJ.ID).fsc;
		_FOCUSTEDOBJ=document.getElementById(_MOVEOBJ.ID);
		//填充联线标签背景颜色
		document.getElementById(_MOVEOBJ.Label.ID).style.backgroundColor='#dddddd';
		break;
		case "proc_m":
		case "proc_n":
		case "proc_e":
		case "proc_nw":
		//节点移动
		if(_MOVEOBJ.tagName!='DIV')
		{
			var Proc=_FLOW.getProcByID(_MOVEOBJ.id);
			var oldVal={
				"X":Proc.X,"Y":Proc.Y,"Width":Proc.Width,"Height":Proc.Height
			};
			if(_MOVETYPE=="proc_m")
			{
				Proc.setPropValue("X",_MOVEOBJ.style.left);
				Proc.setPropValue("Y",_MOVEOBJ.style.top);
			}
			else
			{
				Proc.setPropValue("Width",_MOVEOBJ.style.width);
				Proc.setPropValue("Height",_MOVEOBJ.style.height);
			}
			//如果只是细小的调节，不记录历史操作
			if(Math.abs(parseInt(oldVal.X)-parseInt(Proc.X))>2||Math.abs(parseInt(oldVal.Y)-parseInt(Proc.Y))>2
			||Math.abs(parseInt(oldVal.Width)-parseInt(Proc.Width))>2||Math.abs(parseInt(oldVal.Height)-parseInt(Proc.Height))>2)
			{
				pushLog("moveproc",{
					"objID":Proc.ID,"moveType":_MOVETYPE,"_old":oldVal,"_new":{
						"X":Proc.X,"Y":Proc.Y,"Width":Proc.Width,"Height":Proc.Height
					}
				});
			}
			stuffProp();
			_FLOW.Modified=true;
			//updateFlow(_MOVEOBJ);
			saveStepsToProc(_MOVEOBJ);
			//DrawAll();//重画界面,防止同一条联线出现2个相同的标签
			//objFocusedOn(_MOVEOBJ.id);
		}
		else //标签移动
		{
			var stepid=_MOVEOBJ.id.replace('lab','');
			var Label=_FLOW.getStepByID(stepid).Label;
			if(_MOVETYPE=="proc_m")
			{
				Label.X=_MOVEOBJ.style.left;
				Label.Y=_MOVEOBJ.style.top;
			}
			else
			{
				Label.Width=_MOVEOBJ.style.width;
				Label.Height=_MOVEOBJ.style.height;
			}
		}
		if(oOval) {
			document.body.removeChild(oOval);
		}
		oOval=null;
		break;
		case "rect":
		case "roundrect":
		case "diamond":
		case "oval":
		case "fillrect":
		case "line":
		case "polyline":
		var obj=document.all("_"+(_MOVETYPE=="polyline"?"line":_MOVETYPE)+"ui");
		obj.style.display="none";
		if(_MOVETYPE=="line"||_MOVETYPE=="polyline") {
			var Proc1,Proc2,Step;
			Proc1=_FLOW.getProcAtXY(_CURRENTX,_CURRENTY);
			Proc2=_FLOW.getProcAtXY(x,y);
			if(Proc1==null||Proc2==null) {
				alert("起点或终点不是[任务]，请在[任务]图形上按住鼠标并拖动到某[任务]图形上松开.");
				break;
			}
			if(_FLOW.StepPathExists(Proc1.ID,Proc2.ID)!=null) {
				alert("已经有一个路径从["+_FLOW.getProcByID(Proc1.ID).Text+"]至["+_FLOW.getProcByID(Proc2.ID).Text+"]，请更改！");
				break;
			}
			if(Proc1.ID==Proc2.ID) {
				alert("不能指向本身！");
				break;
			}
			/* if(Proc1.ProcType=="begin")
			{
				alert("开始节点不允许手动联线!");
				break;
			} */
			if(Proc1.ProcType=="end"||Proc2.ProcType=="begin") {
				alert("路径必须符合“起点不能是结束结点，终点不能是开始结点”的规则！");
				break;
			}
			Step=new TStep(_FLOW);
			Step.FromProc=Proc1.ID;
			Step.ToProc=Proc2.ID;
			//Step.Cond = Step.Text
			Step.zIndex=2;
			Step.ShapeType="PolyLine";
			Step.Label.X=(_CURRENTX+x)/2;
			Step.Label.Y=(_CURRENTY+y)/2;
			_FLOW.addStep(Step);
			pushLog("addstep",Step);
			DrawAll();
		}
		else {
			var Proc=new TProc(_FLOW,null,_MOVETYPE);
			//Proc.ShapeType = (_MOVETYPE == "rect"?"Rect":(_MOVETYPE == "roundrect"?"RoundRect":(_MOVETYPE == "oval"?"Oval":"Diamond")));
			//Proc.ShapeType = (_MOVETYPE == "rect"?"Rect":(_MOVETYPE == "roundrect"?"RoundRect":(_MOVETYPE=="fillrect"?"FillRect":(_MOVETYPE == "oval"?"Oval":"Diamond"))));
			Proc.X=parseInt(obj.style.left);
			Proc.Y=parseInt(obj.style.top);
			Proc.Width=parseInt(obj.style.width)+'px';
			Proc.Height=parseInt(obj.style.height)+'px';
			if(parseInt(obj.style.width)<20||parseInt(obj.style.height)<20) {
				//alert("图形长宽小于最小值，将采用默认大小");
				switch(_MOVETYPE) {
					case 'rect':
					Proc.Width='35px';
					Proc.Height='100px';
					break;
					case 'diamond':
					Proc.Width='100px';
					Proc.Height='60px';
					break;
					default:
					Proc.Width='100px';
					Proc.Height='40px';
					break;
				}
			}
			_FLOW.addProc(Proc);
			pushLog("addproc",Proc);
			DrawAll();
		}
		break;
	}//End Switch
	_MOVETYPE="";
	_MOVELINEOBJ=null;
	_MOVEOBJ=null;
	return true;
}
function doDocSelectStart() {
	var oEvt=event.srcElement.tagName;
	if(oEvt!="INPUT") {
		return false;
	}
}
function doDocKeyDown() {
	switch(event.keyCode) {
		case 46://Del
		if(_FOCUSTEDOBJ!=null&&event.srcElement.tagName!="INPUT"&&event.srcElement.tagName!="SELECT") {
			mnuDelObj();
		}
		break;
		/*case 90://z
						if(event.ctrlKey&&event.shiftKey)
						redoLog();
						else if(event.ctrlKey)
						undoLog();
						break;
						case 89://y
						if(event.ctrlKey)redoLog();
						break;
						case 112://F1
						mnuAbout();
						break;
						case 187://+
						if(event.ctrlKey)mnuSetZoom('in');
						break;
						case 189://-
						if(event.ctrlKey)mnuSetZoom('out');
						break;
						case 83://s
						if(event.ctrlKey)mnuSaveFlow();
						break;
						case 79://o
						if(event.ctrlKey)mnuOpenFlow();
						break;
						case 78://n
						if(event.ctrlKey)mnuNewFlow();
						break;
						//case 67://C
						//if(event.ctrlKey)mnuCopyProc();
						//break;
						case 13://enter
						document.all.Canvas.focus();
						break;*/
	}
}
//名称:changeToSelectBtn
//说明:点击右键将操作方式交给选择对象按钮
//作者:fxf
//时间:2009-06-20
function changeToSelectBtn() {
	//清除所有的ButtonClass
	var obj=document.getElementById('tbxToolbox_select');
	var objs=document.all("tbxToolbox_btn");
	for(var i=0;i<objs.length;i++) {
		objs[i].className="bon2";
	}
	obj.className="bon1";
	_TOOLTYPE=obj.cType;
	document.all.Canvas.style.cursor="default";
	return false;
}
document.onselectstart=doDocSelectStart;
document.onmousedown=doDocMouseDown;
document.onmousemove=doDocMouseMove;
document.onmouseup=doDocMouseUp;
document.onkeydown=doDocKeyDown;
document.onerror=new Function("return false;");
document.oncontextmenu=changeToSelectBtn;

