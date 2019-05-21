/*--------------------------------------------------|
| 本作品取得原作者授权修改自 support@tops.com.cn    |
| 的作品topflow                                     |
|                                                   |
| 本文件是CommitFlow的最核心文件，定义了设计器用到的|
| 各种对象类，以及各种类的方法、属性等，请勿更改此  |
| 文件！                                            |
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
//const
//[任务]类定义

function TProc(AFlow,id,st) {
	var idPerfix='';		//节点类型
	this.ObjType="Proc";
	this.Flow=AFlow;        //上一个的节点的对象
	this.ID=id;				//节点编号
	this.ShapeType=st;      //节点外形
//	if(st) {
//		this.ProcType=this.getProcType();           //根据节点外形获得节点类型
//	}
//	//编号前缀只有分3种 join,fork,proc
//	idPerfix=this.ProcType;
//	if(this.ProcType=='andjoin') {
//		idPerfix='join';
//	}
//	if(this.ProcType!='andjoin'&&this.ProcType!='fork') {
//		idPerfix='';
//	}
	if(this.ID==undefined) {
		this.ID=this.Flow.getMaxProcID(idPerfix);     //根据上一个节点对象来获得当前节点缺省的id
	}
	
	this.Text=""+this.ID;					//节点的标题 自动生成 不可以更改
	this.Width="50";
	this.Height="50";
	this.X="50";
	this.Y="50";
	this.TextWeight="9pt";
	this.StrokeWeight="1";
	this.zIndex=1;
	this.InnerObject=null;
	this.MoveType="";               //是鼠标选择的什么类型的图形
	this.Desc="";					//节点描述
	
	this.NodeCode="";
	
	this.NodeType="C";				//节点类别
	this.OptType= "A";				//节点操作类别  赋一个初值为A：一般
	this.OptCode="";				//操作代码
	this.RoleType="0";				//角色类别
	this.RoleCode="0";				//角色代码	
	this.SubWfcode="";				//子流程代码
	//this.TimeBaseNodeId="0";        //基准时间
	this.TimeLimit="";			//预期时间
	this.UnitExp="P";		//几个表达式
	this.PowerExp="";		//权限表达式
	this.ExpireOpt="";		//过期处理方法
	this.OptParam="";       //操作参数
	this.IsAccountTime="T";         //是否计时 T计时 、 F不计时
	this.OptBean="";        //节点事件bean,可选项
	this.FlowPhase="0";		//节点阶段
	this.TimeLimitType="I"; // I未设置（ignore 默认 ）、N 无 (无期限 none ) 、 F 每实例固定期限 fix 、C 节点固定期限  cycle
	this.InheritType="0"; // 0不继承（默认 ）、1继承上级节点 、2继承指定节点
	this.InheritNodeCode="";//继承节点代码
	this.isTrunkLine="F"; //T F 是否是主干节点
	this.Riskinfo=""; //风险点信息
}

//获取当前id的对象
TProc.prototype.getInnerObject=function () {
	if(this.InnerObject==null) {
		this.InnerObject=document.all(this.ID);    
	}
	return this.InnerObject;
};
TProc.prototype.setFocus=function () {
	this.getInnerObject.StrokeColor=this.Flow.Config.ProcFocusedStrokeColor;
};
TProc.prototype.lostFocus=function () {
	this.getInnerObject.StrokeColor=(this.ProcType=="NormalProc")?this.Flow.Config.ProcColor:this.Flow.Config._ProcColor;
};
TProc.prototype.doClick=function () {
	this.Flow.selectObject(this.ID,"Proc");
};
TProc.prototype.mouseDown=function () {
	var rightSide=(parseInt(this.X)+parseInt(this.Width)-event.x<=2);
	var bottomSide=(parseInt(this.Y)+parseInt(this.Height)-event.y<=2);
	if(rightSide&&bottomSide) {
		this.MoveType="nw";
	}
	else if(rightSide) {
		this.MoveType="e";
	}
	else if(bottomSide) {
		this.MoveType="n";
	}
	else {
		this.MoveType="m";
	}
	this.getInnerObject.setCapture();
	switch(this.MoveType) {
		case "m":
		this.CurrentX=event.x-this.InnerObject.offsetLeft;
		this.CurrentY=event.y-this.InnerObject.offsetTop;
		break;
		case "front":
		case "back":
		if(_TOOLTYPE=="front") {
			this.Flow.brintToFront(this);
		}
		else {
			this.Flow.sendToBack(this);
		}
		this.getInnerObject.style.zIndex=this.zIndex;
		break;
	}
};
TProc.prototype.mouseMove=function () {
	switch(this.MoveType) {
		case "m":
		this.X=event.x-this.CurrentX;
		this.Y=event.y-this.CurrentY;
		if(this.X<0) {
			this.X=0;
		}
		if(this.Y<30) {
			this.Y=30;
		}
		this.InnerObject.style.left=this.X;
		this.InnerObject.style.top=this.Y;
		break;
		case "n":
		this.Height=event.y-this.Y;
		if(this.Height<30) {
			this.Height=30;
		}
		this.InnerObject.style.height=this.Height;
		break;
		case "e":
		this.Width=event.x-this.X;
		if(this.Width<30) {
			this.Width=30;
		}
		this.InnerObject.style.width=this.Width;
		break;
		case "nw":
		this.Width=event.x-this.X;
		this.Height=event.y-this.Y;
		if(this.Width<30) {
			this.Width=30;
		}
		if(this.Height<30) {
			this.Height=30;
		}
		this.InnerObject.style.width=this.Width;
		this.InnerObject.style.height=this.Height;
		break;
		default://没有任何按键的情况下，计算位置并显示相应的操作鼠标
		var rightSide=(parseInt(this.X)+parseInt(this.Width)-event.x<=2);
		var bottomSide=(parseInt(this.Y)+parseInt(this.Height)-event.y<=2);
		if(rightSide&&bottomSide) {
			this.getInnerObject.style.cursor="NW-resize";
		}
		else if(rightSide) {
			this.getInnerObject.style.cursor="E-resize";
		}
		else if(bottomSide) {
			this.getInnerObject.style.cursor="N-resize";
		}
		else {
			this.getInnerObject.style.cursor="hand";
		}
		break;
	}
};
TProc.prototype.mouseUp=function () {
	if(this.MoveType!="") {
		this.getInnerObject.releaseCapture();
		if(this.MoveType=="nw") {
			if(parseInt(this.InnerObject.style.top)<-10) {
				alert("对象上边界超出，将自动调整.");
				this.InnerObject.style.top=30;
			}
			if(parseInt(this.InnerObject.style.left)<-10) {
				alert("对象左边界超出，将自动调整.");
				this.InnerObject.style.left=30;
			}
		}
	}
	this.MoveType="";
};


//类定义 
TProc.prototype.clone=function (AProc) {
	this.ID=AProc.ID;
	this.Text=AProc.Text;
	this.ShapeType=AProc.ShapeType;
	this.ProcType=AProc.ProcType;
	this.Width=AProc.Width;
	this.Height=AProc.Height;
	this.X=AProc.X;
	this.Y=AProc.Y;
	this.TextWeight=AProc.TextWeight;
	this.StrokeWeight=AProc.StrokeWeight;
	this.zIndex=AProc.zIndex;
	this.InnerObject=null;
	this.MoveType="";
	this.WarnType=AProc.WarnType;
	this.SelectExit=AProc.SelectExit;
	this.SameCredit=AProc.SameCredit;
	this.Desc=AProc.Desc;				//节点描述
	this.NodeType=AProc.NodeType;				//节点类别
	this.OptType=AProc.OptType;				//节点操作类别
	this.OptCode=AProc.OptCode;				//操作代码
	this.RoleType=AProc.RoleType;				//角色类别
	this.RoleCode=AProc.RoleCode;				//角色代码
	this.SubWfcode=AProc.SubWfcode;       		//子流程代码
	this.TimeLimitType=AProc.TimeLimitType;			//预期时间类型
	this.InheritType = AProc.InheritType;   //继承期限
	this.InheritNodeCode = AProc.InheritNodeCode; //继承节点代码
	this.TimeLimit=AProc.TimeLimit;			//预期时间
	this.UnitExp=AProc.UnitExp;		//几个表达式
	this.PowerExp=AProc.PowerExp;		//权限表达式
	this.ExpireOpt=AProc.ExpireOpt;		//过期处理方法
	this.OptParam=AProc.OptParam;     //操作参数
	this.IsAccountTime=Aproc.IsAccountTime;         //是否计时
	this.OptBean=Aproc.OptBean;               //节点事件bean
	this.FlowPhase=Aproc.FlowPhase;			//节点阶段
	this.isTrunkLine=Aproc.isTrunkLine;
	this.Riskinfo=Apro.Riskinfo;
	this.NodeCode=APro.NodeCode;
};
//当AProp=“ID”时设置节点名称
TProc.prototype.setPropValue=function (AProp,AValue) {
	switch(AProp) {
		case "ID":
		var oldID=this.ID;
		if(oldID==AValue) {
			return true;
		}
		if(this.Flow.IDExists(AValue)) {
			alert("编号["+AValue+"]已经存在！");
			return false;
		}
		this.InnerObject.all(oldID+"Text").id=AValue+"Text";
		this.ID=AValue;
		this.InnerObject.id=AValue;
		this.Flow.changeProcID(oldID,AValue);
		break;
		case "X":
		this.X=AValue;
		this.InnerObject.style.left=AValue;
		break;
		case "Y":
		this.Y=AValue;
		this.InnerObject.style.top=AValue;
		break;
		case "Width":
		this.Width=AValue;
		this.InnerObject.style.width=AValue;
		break;
		case "Height":
		this.Height=AValue;
		this.InnerObject.style.height=AValue;
		break;
	}
};
//[任务]字符串化函数
TProc.prototype.toString =function () {
	var cl=this.Flow.Config;
	var nStockeColor,nTextColor;
	if(this.NodeType=='A'||this.NodeType=='F') {
		nTextColor=cl._ProcTextColor;
		nStrokeColor=cl._ProcColor;
	}
	else {
		nTextColor=cl.ProcTextColor;
		nStrokeColor=cl.ProcColor;
	}
	var arrVal=new Array();
	arrVal["id"]=this.ID;
	//arrVal["title"] = this.ID + ':' + this.Text + "\n\nX-" + this.X + " Y-" + this.Y + " W-" + this.Width + " H-" + this.Height + " Z-" + this.zIndex;
	arrVal["title"]=this.Text;
	arrVal["sc"]=nStrokeColor;
	arrVal["st"]=this.NodeType;
	arrVal["l"]=this.X;
	arrVal["t"]=this.Y;
	arrVal["w"]=this.Width;
	arrVal["h"]=this.Height;
	arrVal["z"]=this.zIndex;
	arrVal["sw"]=this.StrokeWeight;
	arrVal["fsc"]=cl.ProcFocusedStrokeColor;
	arrVal["shadowenable"]=cl.IsProcShadow;
	arrVal["shadowcolor"]=cl.ProcShadowColor;
	arrVal["3denable"]=cl.IsProc3D;
	arrVal["3ddepth"]=cl.Proc3DDepth;
	arrVal["sc1"]=cl.ProcColor1;
	arrVal["sc2"]=cl.ProcColor2;
	arrVal["tc"]=nTextColor;
	arrVal["fs"]=this.TextWeight;
	arrVal["text"]=this.Text;
	//新增
	//arrVal["af"]=this.actFlag;
	//arrVal["wt"]=this.WaitTime;
	//arrVal["ist"]=this.SelectExit;
	//arrVal["isc"]=this.SameCredit;
	arrVal["desc"]=this.Desc;					//节点描述
	arrVal["nt"]=this.NodeType;				//节点类别
	arrVal["ot"]=this.OptType;				//节点操作类别
	arrVal["oc"]=this.OptCode;				//操作代码
	arrVal["rt"]=this.RoleType;				//角色类别
	arrVal["rc"]=this.RoleCode;				//角色代码
	arrVal["sw"]=this.SubWfcode;			//子流程代码
	arrVal["tp"]=this.TimeLimitType;		//预期时间
	arrVal["tl"]=this.TimeLimit;		//预期时间
	///arrVal["tb"]=this.TimeBaseNodeId;     //基准时间
	arrVal["ue"]=this.UnitExp;		//几个表达式
	arrVal["pe"]=this.PowerExp;		//权限表达式
	arrVal["eo"]=this.ExpireOpt;		//过期处理方法
	arrVal["param"]=this.OptParam;	      //操作参数
	arrVal["iat"]=this.IsAccountTime;     //是否计时
	arrVal["op"]=this.OptBean;            //节点事件bean
	arrVal["ph"]=this.FlowPhase;		//业务阶段
	arrVal["risk"]=this.Riskinfo;
	return stuffShape(getShapeVal(this.ShapeType),arrVal);
};









//[路径]类定义
function TStep(AFlow,id) {
	this.ObjType="Step";
	this.Flow=AFlow;
	this.ID=id;
	if(this.ID==undefined) {
		this.ID=this.Flow.getMaxStepID();
	}
	this.Text=""+this.ID;
	this.ShapeType="Line";
	this.FromProc="";
	//出发节点
	this.ToProc="";
	//到达节点
	this.Points="";
	//折线点
	this.StartArrow="none";
	//起点箭头
	this.EndArrow="Classic";
	//结束箭头
	this.TextWeight="9pt";
	//字体大小
	this.StrokeWeight="1";
	//线条粗细
	this.zIndex=0;
	this.InnerObject=null;
	//HTML对象
	//新增
	this.fromRelX=0;
	//出发节点x坐标
	this.fromRelY=0;
	//出发几点y坐标
	this.toRelX=0;
	//结束节点x坐标
	this.toRelY=0;
	//结束节点y坐标
	this.Label=new TLabel('lab'+this.ID);
	//标签
	this.Cond='1';
	//条件
	//this.Event='';
	//事件
	this.Desc='';
	//描述说明
	
	this.TimeLimitType="I"; //I未设置（ignore 默认 ）、N 无 (无期限 none ) 、 F 每实例固定期限 fix 、C 节点固定期限  cycle、H 继承上一个节点剩余时间 hierarchical。
	this.InheritType="0"; // 0不继承（默认 ）、1继承上级节点 、2继承指定节点
	this.InheritNodeCode="";//继承节点代码
	this.TimeLimit="";
	
}
TStep.prototype.clone=function (AStep) {        //相当于getObject()方法
	this.ID=AStep.ID;
	this.Text=AStep.Text;
	this.ShapeType=AStep.ShapeType;
	this.FromProc=AStep.FromProc;
	this.ToProc=AStep.ToProc;
	this.Points=AStep.Points;
	this.StartArrow=AStep.StartArrow;
	this.EndArrow=AStep.EndArrow;
	this.TextWeight=AStep.TextWeight;
	this.StrokeWeight=AStep.StrokeWeight;
	this.zIndex=AStep.zIndex;
	this.Points=AStep.Points;
	this.fromRelX=AStep.fromRelX;
	this.fromRelY=AStep.fromRelY;
	this.toRelX=AStep.toRelX;
	this.toRelY=AStep.toRelY;
	this.Label=AStep.Label;
	this.Cond=AStep.Cond;
	//this.Event=AStep.Event;
	this.Desc=AStep.Desc;
	this.TimeLimit=AStep.TimeLimit;
	this.TimeLimitType=AStep.TimeLimitType;
	this.InheritType = AStep.InheritType;
	this.InheritNodeCode = AStep.InheritNodeCode;
};
TStep.prototype.setPropValue=function (AProp,AValue) {
	switch(AProp) {
		case "ID":
		var oldID=this.ID;
		if(oldID==AValue) {
			return true;
		}
		if(this.Flow.IDExists(AValue)) {
			alert("编号["+AValue+"]已经存在！");
			return false;
		}
		this.InnerObject.all(oldID+"Text").id=AValue+"Text";
		this.InnerObject.all(oldID+"Arrow").id=AValue+"Arrow";
		this.ID=AValue;
		this.InnerObject.id=AValue;
		break;
		case "Points":
		this.Points=AValue;
		break;
		case "FromProc":
		this.FromProc=AValue;
		break;
		case "ToProc":
		this.ToProc=AValue;
		break;
	}
};
//[路径]字符串化函数
TStep.prototype.toString =function () {
	var StepHTML='';
	var cl=this.Flow.Config;
	var arrVal=new Array();
	arrVal["id"]=this.ID;
	arrVal["title"]=/*this.ID+':'+*/this.Text + "\n\n" + this.Cond;
	arrVal["sc"]=cl.StepColor;
	arrVal["pt"]=this.getPath();
	arrVal["z"]=this.zIndex;
	arrVal["sw"]=this.StrokeWeight;
	arrVal["fsc"]=cl.StepFocusedStrokeColor;
	arrVal["sa"]=this.StartArrow;
	arrVal["ea"]=this.EndArrow;
	arrVal["cond"]=this.Cond;
	arrVal["text"]=this.Text;
	//----------fxf add-----------
	arrVal["lid"]=this.Label.ID;
	arrVal["x"]=this.Label.X;
	arrVal["y"]=this.Label.Y;
	arrVal["w"]=this.Label.Width;
	arrVal["h"]=this.Label.Height;
	arrVal["desc"]=this.Desc;
	arrVal["type"]=this.TimeLimitType;
	arrVal["time"]=this.TimeLimit;
	//----------fxf add-----------
	return stuffShape(getShapeVal(this.ShapeType),arrVal);
};
TStep.prototype.getInnerObject=function () {
	if(this.InnerObject==null) {
		this.InnerObject=document.all(this.ID);
	}
	return this.InnerObject;
};
TStep.prototype.setFocus=function () {
	this.getInnerObject.StrokeColor=this.Flow.Config.StepFocusedStrokeColor;
};
TStep.prototype.lostFocus=function () {
	this.getInnerObject.StrokeColor=this.Flow.Config.StepColor;
};
TStep.prototype.doClick=function () {
	this.Flow.selectObject(this.ID,"Step");
};

//名称:xml替换转义符
//说明:替换一些xml中的非法字符
//作者:xc
//时间:2012-02-1
function replacetoxml(str)
{
	var str2;
	str2=str.replace(/&/g,"&amp;");
	str2=str2.replace(/</g,"&lt;");
	str2=str2.replace(/>/g,"&gt;");
	str2=str2.replace(/"/g,"&quot;");
	str2=str2.replace(/'/g,"&apos;");
	return str2;
}


//流程图类定义
function TTopFlow(AName) {
	this.name=AName;
	this.code="";
	this.type="";
	this.desc="";
	//this.FormID="";
	this.Modified=false;
	this.Steps=[];
	this.Procs=[];
	this.Labels=[];
	this.SelectedObject=null;
	//this.Password="";
	this.Config={
		_ProcColor:"#FF0000",//开始/结束
		_ProcTextColor:"#FF0000",//开始/结束
		ProcColor:"#0000FF",
		ProcTextColor:"#0000FF",
		ProcFocusedStrokeColor:"#00AA00",
		IsProcShadow:"T",
		ProcShadowColor:"#B3B3B3",
		ProcColor1:"#FFFFFF",
		ProcColor2:"#FFFFFF",
		JoinColor:"#f0f0f0",
		IsProc3D:"F",
		Proc3DDepth:"20",
		StepFocusedStrokeColor:"#00AA00",
		StepColor:"#0000FF"
	};
}
//
TTopFlow.prototype.getInnerObject=function () {
	for(var i=0;i<this.Procs.length;i++) {
		this.Procs[i].getInnerObject();
	}
	for(i=0;i<this.Steps.length;i++) {
		this.Steps[i].getInnerObject();
	}
};
//选中某个对象
TTopFlow.prototype.selectObject=function (aID,aType) {
	this.unSelectObject();
	this.SelectedObject=(aType=="Proc")?this.getProcByID(aID):this.getStepByID(aID);
	this.SelectedObject.setFocus();
};
//取消选中某个对象
TTopFlow.prototype.unSelectObject=function () {
	if(this.SelectedObject!=null) {
		this.SelectedObject.lostFocus();
	}
	this.SelectedObject=null;
};
//清除流程图的内容
TTopFlow.prototype.clear=function () {
	this.FileName='';
	this.Steps.length=0;
	this.Procs.length=0;
};

//添加流程图的[任务]元素对象
TTopFlow.prototype.addProc=function (AProc) {
	if(this.Procs.length>100) {
		alert("最多不允许超过100个任务!");
		return false;
	}
	this.Modified=true;
	this.Procs[this.Procs.length]=AProc;
};
//添加流程图的[路径]元素对象
TTopFlow.prototype.addStep=function (AStep) {
	this.Steps[this.Steps.length]=AStep;
	this.Modified=true;
};
TTopFlow.prototype.changeProcID=function (OldID,NewID) {
	//alert("changeProcID");
	var Step;
	for(var i=0;i<this.Steps.length;i++) {
		Step=this.Steps[i];
		if(Step.FromProc==OldID) {
			Step.FromProc=NewID;
		}
		if(Step.ToProc==OldID) {
			Step.ToProc=NewID;
		}
	}
};
//获取一个[任务]的二维数据集视图
TTopFlow.prototype.getProcDataView=function (AProcID) {
	var arr=[],Step;
	for(var i=0;i<this.Steps.length;i++) {
		Step=this.Steps[i];
		if(Step.ToProc==AProcID) {
			S=this.getProcByID(Step.FromProc).Text;
			arr[arr.length]=new Array(Step.ID,S,Step.Cond);
		}
	}
	return arr;
};
//获取整个[流程图]的二维数据集视图
TTopFlow.prototype.DataView=function () {
	var Proc;
	arrDataView=[],arr=[];
	var i,j,u,k=0;
	for(i=0;i<this.Procs.length;i++) {
		Proc=this.Procs[i];
		arr.length=0;
		arr=this.getProcDataView(Proc.ID);
		u=arr.length;
		if(u!=undefined&&u!=null&&u>0) {
			for(j=0;j<arr.length;j++) {
				arrDataView[k++]={
					"ProcID":Proc.ID,
					"ProcText":Proc.Text,
					"Idx":j+1,
					"PreProcID":arr[j][0],
					"PreProcText":arr[j][1],
					"Cond":arr[j][2]
				};
			}
		}
	}
	return arrDataView;
};

//返回节点的入度
TTopFlow.prototype.hasPriorProc=function (AProcID) {
	var j=0;
	for(var i=0;i<this.Steps.length;i++) {
		if(this.Steps[i].ToProc==AProcID) {
			j++;
		}
	}
	return j;
};
//计算节点的出度
TTopFlow.prototype.hasNextProc=function (AProcID) {
	var j=0;
	for(var i=0;i<this.Steps.length;i++) {
		if(this.Steps[i].FromProc==AProcID) {
			j++;
		}
	}
	return j;
};
//名称:validate
//说明:检测流程图合法性
//作者:fxf
//修改时间:2009-06-26
TTopFlow.prototype.validate=function () {
	var ErrMsg=[];
	WarnMsg=[];
	var Proc,PType;
	var iFork=0,iJoin=0;
	for(var i=0;i<this.Procs.length;i++) {
		Proc=this.Procs[i];
		PType=(Proc.ProcType=="A"?"开始节点":(Proc.ProcType=="F"?"结束节点":(Proc.ProcType=="fork"?"分支节点":((Proc.ProcType=="andjoin"||Proc.ProcType=="unandjoin")?"汇聚节点":"任务节点"))));
		if(Proc.ID!="begin") {
			if(!this.hasPriorProc(Proc.ID)) {
				ErrMsg.push("["+Proc.Text+"] - "+PType+"必须有输入路径");
			}
		}
	}
		/*
	//	if(Proc.ID!="end") {
	//		if(!this.hasNextProc(Proc.ID)) {
	//			ErrMsg.push("["+Proc.Text+"] - "+PType+"必须有输出路径");
	//		}
	//	}
		if(Proc.ProcType=='andjoin'||Proc.ProcType=='unandjoin') {
			iJoin++;
		}
		if(Proc.ProcType=='fork') {
			iFork++;
		}
	}
	if(iJoin!=iFork) {
		ErrMsg.push("[分支节点]和[汇聚节点]需要一一对应");
	}
×*/	
	return ErrMsg.join("\n")+WarnMsg.join("\n");
};

//名称:addProcXML
//说明:根据节点追加xml
//作者:fxf
//时间:2009-06-20
TTopFlow.prototype.addProcXML=function (xmlDoc,jxml,oProc) {
	var procNode=null;
	//节点
	var stepNode=null;
	//联线
	var taskNode=null;
	//执行人任务节点
	var helpNode=null;
	//协助人任务节点
	var eventNode=null;
	//事件节点
	switch(oProc.ProcType)
	{
		case 'begin':
		procNode=xmlDoc.createNode(1,"start-state","");
		break;
		case 'first':
		procNode=xmlDoc.createNode(1,"task-node","");
		this.createTaskNode(xmlDoc,procNode,oProc);
		break;
		case 'andsign':
		procNode=xmlDoc.createNode(1,"task-node","");
		this.createTaskNode(xmlDoc,procNode,oProc);
		break;
		case 'unandsign':
		procNode=xmlDoc.createNode(1,"task-node","");
		this.createTaskNode(xmlDoc,procNode,oProc);
		break;
		case 'connectsign':
		procNode=xmlDoc.createNode(1,"task-node","");
		this.createTaskNode(xmlDoc,procNode,oProc);
		break;
		case 'fork':
		procNode=xmlDoc.createNode(1,"fork","");
		break;
		case 'andjoin':
		procNode=xmlDoc.createNode(1,"join","");
		break;
		case 'unandjoin':
		procNode=xmlDoc.createNode(1,"join","");
		break;
		case 'end':
		procNode=xmlDoc.createNode(1,"end-state","");
		break;
		default:
		break;
	}
	if(procNode)
	{
		//如果是分支，会聚和结束节点，节点名字取节点ID
		if(oProc.ProcType=='fork'||oProc.ProcType=='andjoin'||oProc.ProcType=='unandjoin'||oProc.ProcType=='end') {
			procNode.setAttribute("name",oProc.ID);
		}
		else {
			procNode.setAttribute("name",oProc.Text);
		}
		var outSteps=this.getOutSteps(oProc.ID);
		//此节点所有出口联线
		for(var i=0;i<outSteps.length;i++)
		{
			stepNode=xmlDoc.createNode(1,"transition","");
			stepNode.setAttribute("name",outSteps[i].Text);
			var toProc=this.getProcByID(outSteps[i].ToProc);
			var toProcType=toProc.ProcType;
			//如果是分支，会聚和结束节点，联线to属性值取节点ID
			if(toProcType=='fork'||toProcType=='andjoin'||toProcType=='unandjoin'||toProcType=='end') {
				stepNode.setAttribute("to",toProc.ID);
			}else {
				stepNode.setAttribute("to",toProc.Text);
			}
			if(outSteps[i].Cond&&outSteps[i].Cond!='') {
				stepNode.setAttribute("condition",outSteps[i].Cond);
			}
			procNode.appendChild(stepNode);
		}
		jxml.appendChild(procNode);
	}
};
//名称:createTaskNode
//说明:创建jbpmXML任务节点
//作者:fxf
//时间:2009-06-20
TTopFlow.prototype.createTaskNode=function (xmlDoc,procNode,oProc) {
	var taskNode=null;
	//执行人任务节点
	var helpNode=null;
	//协助人任务节点
	var personNode=null;
	var eventNode=null;
	//事件节点
	var eventAction=null;
	//事件action
	//添加task节点
	taskNode=xmlDoc.createNode(1,"task","");
	taskNode.setAttribute("name",oProc.Text+'任务');
	//执行人节点
	personNode=xmlDoc.createNode('Element',"assignment","");
	personNode.setAttribute("actor-id",oProc.Executer);
	taskNode.appendChild(personNode);
	//如果有协助人，添加协助人任务节点
	if(oProc.Aidancer&&oProc.Aidancer!='') {
		//添加task节点
		helpNode=xmlDoc.createNode(1,"task","");
		helpNode.setAttribute("name",oProc.Text+"协助任务");
		helpNode.setAttribute("signalling","false");
		//执行人节点
		personNode=xmlDoc.createNode('Element',"assignment","");
		personNode.setAttribute("actor-id",oProc.Aidancer);
		helpNode.appendChild(personNode);
	}
	//串签节点执行人任务中加事件
	if(oProc.ProcType=='connectsign') {
		eventNode=xmlDoc.createNode(1,"event","");
		eventNode.setAttribute("type","task-end");
		eventAction=xmlDoc.createNode(1,"action","");
		eventAction.setAttribute("class","com.xx.handler.ChuanTaskEnd");
		eventNode.appendChild(eventAction);
		taskNode.appendChild(eventNode);
	}
	procNode.appendChild(taskNode);
	if(helpNode) {
		procNode.appendChild(helpNode);
	}
	if(oProc.ProcType!='first') {
		procNode.setAttribute("create-tasks","false");
		if(oProc.ProcType=='connectsign'||oProc.ProcType=='andsign') {
			procNode.setAttribute("end-tasks","true");
		}
		if(oProc.ProcType=='unjoinsign') {
			procNode.setAttribute("signal","first-wait");
		}
		else {
			procNode.setAttribute("signal","last-wait");
		}
		eventNode=xmlDoc.createNode(1,"event","");
		eventNode.setAttribute("type","node-enter");
		eventAction=xmlDoc.createNode(1,"action","");
		eventAction.setAttribute("name","createInstance");
		if(oProc.ProcType=='connectsign') {
			//串签
			eventAction.setAttribute("class","com.xx.handler.CreateChuan");
		}else {
			//会签,非会签
			eventAction.setAttribute("class","com.xx.handler.CreateTaskInstanceConsign");
		}
		eventNode.appendChild(eventAction);
	}
	if(eventNode) {
		procNode.appendChild(eventNode);
	}
	//非会签节点添加task-end事件
	if(oProc.ProcType=='unandsign') {
		eventNode=xmlDoc.createNode(1,"event","");
		eventNode.setAttribute("type","task-end");
		eventAction=xmlDoc.createNode(1,"action","");
		eventAction.setAttribute("name","endTaskInstance");
		eventAction.setAttribute("class","com.xx.handler.TaskEndConsign");
		eventNode.appendChild(eventAction);
	}
	if(eventNode) {
		procNode.appendChild(eventNode);
	}
};
//根据[任务]的ID获取[任务]对象
TTopFlow.prototype.getProcByID=function (id) {
	for(var i=0;i<this.Procs.length;i++) {
		if(this.Procs[i].ID==id) {
			return this.Procs[i];
		}
	}
	return null;
};
//根据[路径]的ID获取[路径]对象
TTopFlow.prototype.getStepByID=function (id) {
	for(var i=0;i<this.Steps.length;i++) {
		if(this.Steps[i].ID==id) {
			return this.Steps[i];
		}
	}
	return null;
};
TTopFlow.prototype.getProcAtXY=function (x,y) {
	var Proc;
	for(var i=0;i<this.Procs.length;i++) {
		Proc=this.Procs[i];
		if(x>=parseInt(Proc.X)&&x<=parseInt(Proc.X)+parseInt(Proc.Width)&&y>=parseInt(Proc.Y)&&y<=parseInt(Proc.Y)+parseInt(Proc.Height)) {
			return Proc;
		}
	}
	return null;
};
TTopFlow.prototype.IDExists=function (id) {
	var obj=_FLOW.getProcByID(id);
	if(obj!=null) {
		return true;
	}
	var obj=_FLOW.getStepByID(id);
	return (obj!=null);
};
TTopFlow.prototype.StepPathExists=function (FromProc,ToProc) {
	var Step;
	for(var i=0;i<this.Steps.length;i++) {
		Step=this.Steps[i];
		if(Step.FromProc==FromProc&&Step.ToProc==ToProc) {
			return Step;
		}
	}
	return null;
};
//根据[任务]的ID删除[任务]对象
TTopFlow.prototype.deleteProcByID=function (id) {
	this.Modified=true;
	for(var i=0;i<this.Procs.length;i++) {
		if(this.Procs[i].ID==id) {
			this.Procs.splice(i,1);
		}
	}
	//删除与些Proc关联的Step
	for(i=this.Steps.length-1;i>=0;i--) {
		if(this.Steps[i].FromProc==id||this.Steps[i].ToProc==id) {
			this.Steps.splice(i,1);
		}
	}
};
//根据[路径]的ID删除[路径]对象
TTopFlow.prototype.deleteStepByID=function (id) {
	this.Modified=true;
	for(var i=0;i<this.Steps.length;i++) {
		if(this.Steps[i].ID==id) {
			this.Steps.splice(i,1);
		}
	}
};
//获取流程图最顶层的Z轴值
TTopFlow.prototype.getMaxZIndex=function () {
	var m=0;
	for(var i=0;i<this.Procs.length;i++) {
		m=Math.max(m,this.Procs[i].zIndex);
	}
	for(i=0;i<this.Steps.length;i++) {
		m=Math.max(m,this.Steps[i].zIndex);
	}
	return m;
};
//获取流程图最底层的Z轴值
TTopFlow.prototype.getMinZIndex=function () {
	var m=0;
	for(var i=0;i<this.Procs.length;i++) {
		m=Math.min(m,this.Procs[i].zIndex);
	}
	for(i=0;i<this.Steps.length;i++) {
		m=Math.min(m,this.Steps[i].zIndex);
	}
	return m;
};
//将一个流程图元素对象移至最上层
TTopFlow.prototype.brintToFront=function (obj) {
	this.Modified=true;
	obj.zIndex=this.getMaxZIndex()+1;
};
//将一个流程图元素对象移至最底层
TTopFlow.prototype.sendToBack=function (obj) {
	this.Modified=true;
	obj.zIndex=this.getMinZIndex()-1;
};
//获取流程图下一个[任务]的缺省ID
TTopFlow.prototype.getMaxProcID=function (st) {
	if(!st) {
		st='proc';
	}
	var s="";
	var i,j,u=this.Procs.length;
	for(i=0;i<=u;i++) {
		s=st+i;
		for(j=0;j<u;j++) {
			if(this.Procs[j].ID==s) {
				break;
			}
		}
		if(j==u) {
			break;
		}
	}
	return s;
};
//获取流程图下一个[路径]的缺省ID
TTopFlow.prototype.getMaxStepID=function () {
	var s="";
	var i,j,u=this.Steps.length;
	for(i=0;i<=u;i++) {
		s="step"+i;
		for(j=0;j<u;j++) {
			if(this.Steps[j].ID==s) {
				break;
			}
		}
		if(j==u) {
			break;
		}
	}
	return s;
};
//流程图内全部[任务]的字符串化函数
TTopFlow.prototype.ProcString=function () {
	var S="",i;
	for(i=0;i<this.Procs.length;i++) {
		S+=this.Procs[i];
	}
	return S;
};
//流程图内全部[路径]的字符串化函数
TTopFlow.prototype.StepString=function () {
	var S="",i;
	for(i=0;i<this.Steps.length;i++) {
		S+=this.Steps[i];
	}
	return S;
};
//流程图字符串化函数
TTopFlow.prototype.toString =function () {
	return this.ProcString()+this.StepString();
};
//获取[路径]的划线结点路径
TStep.prototype.getPath=function () {
	if(this.Points!=null&&this.Points!="") {
		return this.Points;
	}
	var fromProc=document.getElementById(this.FromProc),toProc=document.getElementById(this.ToProc);
	if(fromProc==null||toProc==null) {
		return '';
	}
	var fromW=parseInt(fromProc.style.width);
	var fromH=parseInt(fromProc.style.height);
	var toW=parseInt(toProc.style.width);
	var toH=parseInt(toProc.style.height);
	var fromX=parseInt(fromProc.style.left);
	var fromY=parseInt(fromProc.style.top);
	var toX=parseInt(toProc.style.left);
	var toY=parseInt(toProc.style.top);
	if(this.FromProc==this.ToProc) {
		return this.getSelfPath(fromX,fromY,fromW,fromH);
	}
	if(ifRepeatProc(fromX,fromY,fromW,fromH,toX,toY,toW,toH)) {
		return "";
	}
	else if(this.ShapeType=="PolyLine")
	{
		return this.getLinePath(fromX,fromY,fromW,fromH,toX,toY,toW,toH);
	}
	else
	return this.Points;
	//    return this.getPolyLinePath(fromX, fromY, fromW, fromH, toX, toY, toW, toH);
};
//重新获取[路径]的划线结点路径
TStep.prototype.reGetPath=function () {
	var fromProc=document.getElementById(this.FromProc),toProc=document.getElementById(this.ToProc);
	if(fromProc==null||toProc==null) {
		return '';
	}
	var fromW=parseInt(fromProc.style.width);
	var fromH=parseInt(fromProc.style.height);
	var toW=parseInt(toProc.style.width);
	var toH=parseInt(toProc.style.height);
	var fromX=parseInt(fromProc.style.left);
	var fromY=parseInt(fromProc.style.top);
	var toX=parseInt(toProc.style.left);
	var toY=parseInt(toProc.style.top);
	if(this.FromProc==this.ToProc) {
		return this.getSelfPath(fromX,fromY,fromW,fromH);
	}
	if(ifRepeatProc(fromX,fromY,fromW,fromH,toX,toY,toW,toH)) {
		return "";
	}
	else if(this.ShapeType=="PolyLine")
	{
		return this.getLinePath(fromX,fromY,fromW,fromH,toX,toY,toW,toH);
	}
	else {
		return this.Points;
	}
	//    return this.getPolyLinePath(fromX, fromY, fromW, fromH, toX, toY, toW, toH);
};
//获取当[路径]指向自身时的划线结点路径
TStep.prototype.getSelfPath=function (ProcX,ProcY,ProcW,ProcH) {
	var constLength=10;
	point0X=ProcX+ProcW-constLength;
	point0Y=ProcY+ProcH;
	point1X=point0X;
	point1Y=point0Y+constLength;
	point2X=ProcX+ProcW+constLength;
	point2Y=point1Y;
	point3X=point2X;
	point3Y=point0Y-constLength;
	point4X=ProcX+ProcW;
	point4Y=point3Y;
	return point0X+','+point0Y+' '+point1X+','+point1Y+' '+point2X+','+point2Y+' '+point3X+','+point3Y+' '+point4X+','+point4Y;
};
//获取当[路径]线型为直线时的划线结点路径
TStep.prototype.getLinePath=function (fromProcX,fromProcY,fromProcW,fromProcH,toProcX,toProcY,toProcW,toProcH) {
	var fromX,fromY,toX,toY,fromRelX,fromRelY,toRelX,toRelY;
	if(fromProcY+fromProcH<toProcY) {
		//FromProc完全在ToProc上方
		if(fromProcX+fromProcW<toProcX) {
			//FromProc完全在ToProc左方
			fromX=fromProcX+fromProcW;
			//取FromProc右下角
			fromY=fromProcY+fromProcH;
			toX=toProcX;
			//取ToProc左上角
			toY=toProcY;
			fromRelX=1;
			fromRelY=1;
			toRelX=0;
			toRelY=0;
		}
		else if(fromProcX>toProcX+toProcW) {
			//FromProc完全在ToProc右方
			fromX=fromProcX;
			//取FromProc左下角
			fromY=fromProcY+fromProcH;
			toX=toProcX+toProcW;
			toY=toProcY;
			fromRelX=0;
			fromRelY=1;
			toRelX=1;
			toRelY=0;
		}
		else {
			//取FromProc下中结点
			fromX=fromProcX+parseInt(fromProcW/2);
			fromY=fromProcY+fromProcH;
			toX=toProcX+parseInt(toProcW/2);
			toY=toProcY;
			fromRelX=0.5;
			fromRelY=1;
			toRelX=0.5;
			toRelY=0;
		}
	}
	else if(fromProcY>toProcY+toProcH) {
		//FromProc完全在ToProc下方
		if(fromProcX+fromProcW<toProcX) {
			//FromProc完全在ToProc左方
			fromX=fromProcX+fromProcW;
			//取FromProc右上角
			fromY=fromProcY;
			toX=toProcX;
			//取ToProc左下角
			toY=toProcY+toProcH;
			fromRelX=1;
			fromRelY=0;
			toRelX=0;
			toRelY=1;
		}
		else if(fromProcX>toProcX+toProcW) {
			//FromProc完全在ToProc右方
			fromX=fromProcX;
			//取FromProc左上角
			fromY=fromProcY;
			toX=toProcX+toProcW;
			//取ToProc右下角
			toY=toProcY+toProcH;
			fromRelX=0;
			fromRelY=0;
			toRelX=1;
			toRelY=1;
		}
		else {
			//取FromProc下中结点
			fromX=fromProcX+parseInt(fromProcW/2);
			fromY=fromProcY;
			toX=toProcX+parseInt(toProcW/2);
			toY=toProcY+toProcH;
			fromRelX=0.5;
			fromRelY=0;
			toRelX=0.5;
			toRelY=1;
		}
	}
	else if(fromProcX+fromProcW<toProcX) {
		//FromProc在toProc左方
		fromX=fromProcX+fromProcW;
		fromY=fromProcY+parseInt(fromProcH/2);
		toX=toProcX;
		toY=toProcY+parseInt(toProcH/2);
		fromRelX=1;
		fromRelY=0.5;
		toRelX=0;
		toRelY=0.5;
	}
	else {
		//在右方
		fromX=fromProcX;
		fromY=fromProcY+parseInt(fromProcH/2);
		toX=toProcX+toProcW;
		toY=toProcY+parseInt(toProcH/2);
		fromRelX=0;
		fromRelY=0.5;
		toRelX=1;
		toRelY=0.5;
	}
	this.fromRelX=fromRelX;
	this.fromRelY=fromRelY;
	this.toRelX=toRelX;
	this.toRelY=toRelY;
	this.Points=fromX/4*3+'pt,'+fromY/4*3+'pt,'+toX/4*3+'pt,'+toY/4*3+'pt';
	return this.Points;
};
//获取当[路径]线型为折线线时的划线结点路径
TStep.prototype.getPolyLinePath=function (fromProcX,fromProcY,fromProcW,fromProcH,toProcX,toProcY,toProcW,toProcH) {
	//fromProc Center X,Y
	var fromCenterX=fromProcX+parseInt(fromProcW/2);
	var fromCenterY=fromProcY+parseInt(fromProcH/2);
	//toProc Center X,Y
	var toCenterX=toProcX+parseInt(toProcW/2);
	var toCenterY=toProcY+parseInt(toProcH/2);
	//
	point2X=fromCenterX;
	point2Y=toCenterY;
	if(toCenterX>fromCenterX) {
		//ToProc在FromProc的右边
		absY=toCenterY>=fromCenterY?toCenterY-fromCenterY:fromCenterY-toCenterY;
		//计算两个对象中心点的距离
		if(parseInt(fromProcH/2)>=absY) {
			//ToProc的顶部在FromProc的底部之上
			point1X=fromProcX+fromProcW;
			point1Y=toCenterY;
			point2X=point1X;
			point2Y=point1Y;
		}
		else {
			point1X=fromCenterX;
			point1Y=fromCenterY<toCenterY?fromProcY+fromProcH:fromProcY;
		}
		absX=toCenterX-fromCenterX;
		if(parseInt(fromProcW/2)>=absX) {
			point3X=fromCenterX;
			point3Y=fromCenterY<toCenterY?toProcY:toProcY+toProcH;
			point2X=point3X;
			point2Y=point3Y;
		}
		else {
			point3X=toProcX;
			point3Y=toCenterY;
		}
	}
	if(toCenterX<fromCenterX) {
		absY=toCenterY>=fromCenterY?toCenterY-fromCenterY:fromCenterY-toCenterY;
		if(parseInt(fromProcH/2)>=absY) {
			point1X=fromProcX;
			point1Y=toCenterY;
			point2X=point1X;
			point2Y=point1Y;
		}else {
			point1X=fromCenterX;
			point1Y=fromCenterY<toCenterY?fromProcY+fromProcH:fromProcY;
		}
		absX=fromCenterX-toCenterX;
		if(parseInt(fromProcW/2)>=absX) {
			point3X=fromCenterX;
			point3Y=fromCenterY<toCenterY?toProcY:toProcY+toProcH;
			point2X=point3X;
			point2Y=point3Y;
		}
		else {
			point3X=toProcX+toProcW;
			point3Y=toCenterY;
		}
	}
	if(toCenterX==fromCenterX) {
		point1X=fromCenterX;
		point1Y=fromCenterY>toCenterY?fromProcY:fromProcY+fromProcH;
		point3X=fromCenterX;
		point3Y=fromCenterY>toCenterY?toProcY+toProcH:toProcY;
		point2X=point3X;
		point2Y=point3Y;
	}
	if(toCenterY==fromCenterY) {
		point1X=fromCenterX>toCenterX?fromProcX:fromProcX+fromProcW;
		point1Y=fromCenterY;
		point3Y=fromCenterY;
		point3X=fromCenterX>toCenterX?toProcX+toProcW:toProcX;
		point2X=point3X;
		point2Y=point3Y;
	}
	return point1X+','+point1Y+' '+point2X+','+point2Y+' '+point3X+','+point3Y;
};
//判断两个[任务]的位置是否有重叠
function ifRepeatProc(fromX,fromY,fromW,fromH,toX,toY,toW,toH) {
	return (fromX+fromW>=toX)&&(fromY+fromH>=toY)&&(toX+toW>=fromX)&&(toY+toH>=fromY);
}
//名称:TLabel
//说明:标签类定义
//作者:fxf
//时间:2009-06-20
function TLabel(id) {
	this.ID=id;
	this.Text="";
	this.Desc="";
	this.Step=null;
	this.X=0;
	this.Y=0;
	this.Width="40px";
	this.Height="20px";
	this.bgColor="#ffffff";
}
//名称:getProcType
//说明:获取节点类型
//作者:fxf
//时间:2009-06-20
TProc.prototype.getProcType=function () {
	switch(this.ShapeType) {
		case "rect":
		return 'andjoin';
		break;
		case "roundrect":
		return 'andsign';
		break;
		case "diamond":
		return 'fork';
		break;
		default:
		break;
	}
};
//名称:toStringWithoutLabel
//说明:[路径]字符串化函数不包含标签，用于拖动联线字符串化，使标签不重新生成
//作者:fxf
//时间:2009-06-20
TStep.prototype.toStringWithoutLabel=function () {
	var StepHTML='';
	var cl=this.Flow.Config;
	var arrVal=new Array();
	arrVal["id"]=this.ID;
	arrVal["title"]=/* this.ID+':'+*/ this.Text;
	arrVal["sc"]=cl.StepColor;
	arrVal["pt"]=this.getPath();
	arrVal["z"]=this.zIndex;
	arrVal["sw"]=this.StrokeWeight;
	arrVal["fsc"]=cl.StepFocusedStrokeColor;
	arrVal["sa"]=this.StartArrow;
	arrVal["ea"]=this.EndArrow;
	arrVal["cond"]=this.Cond;
	arrVal["text"]=this.Text;
	return stuffShape(getShapeVal('polylinenolabel'),arrVal);
};
//名称:getOutSteps
//说明:获取节点出口联线,生成jbpmXML使用
//作者:fxf
//时间:2009-06-20
TTopFlow.prototype.getOutSteps=function (AProcID) {
	var Steps=[];
	for(var i=0;i<this.Steps.length;i++)
	{
		if(this.Steps[i].FromProc==AProcID) {
			Steps[Steps.length]=this.Steps[i];
		}
	}
	return Steps;
};
//名称:isExitName
//说明:是否有重名节点或联线
//作者:fxf
//时间:2009-06-20
TTopFlow.prototype.isExitName=function (val) {
	var isExit=false;
	for(var i=0;i<this.Steps.length;i++)
	{
		if(this.Steps[i].Text.toLowerCase()==val.toLowerCase()) {
			isExit=true;
		}
	}
	for(var i=0;i<this.Procs.length;i++)
	{
		if(this.Procs[i].Text.toLowerCase()==val.toLowerCase()) {
			isExit=true;
		}
	}
	return isExit;
};

//-------------------以下与java版本差异-------------------------------------------------------
//新建流程图
TTopFlow.prototype.createNew=function (AName) {
	this.ID=AName;
	this.clear();
	//增加开始结点
	Proc=new TProc(this,"begin");
	Proc.Text="开始";
	Proc.ShapeType="Oval";
	Proc.ProcType="begin";
	Proc.Width="40";
	Proc.Height="40";
	Proc.X="60";
	Proc.Y="160";
	this.addProc(Proc);
	//增加结束结点
	Proc=new TProc(this,"end");
	Proc.Text="结束";
	Proc.ShapeType="Oval";
	Proc.ProcType="end";
	Proc.Width="40";
	Proc.Height="40";
	Proc.X="210";
	Proc.Y="260";
	this.addProc(Proc);
//	Proc=new TProc(this,"first");
//	Proc.Text="第一个节点";
//	Proc.ShapeType="roundrect";
//	Proc.ProcType="first";
//	Proc.Executer="#{starter}";
//	Proc.X="180";
//	Proc.Y="160";
//	Proc.Width="100";
//	Proc.Height="40";
//	this.addProc(Proc);
	/*Step=new TStep(this,"step0");
	Step.Text="流程开始";
	Step.FromProc="begin";
	Step.ToProc="first";
	Step.ShapeType="PolyLine";
	Step.fromRelX=1;
	//出发节点x坐标
	Step.fromRelY=0.5;
	//出发几点y坐标
	Step.toRelX=0;
	//结束节点x坐标
	Step.toRelY=0.5;
	//结束节点y坐标
	Step.Points="75pt,135pt,135pt,135pt";
	Step.Label.X="120";
	Step.Label.Y="190";
	Step.Label.Width="60";
	this.addStep(Step);*/
};

//从XML文件中载入流程图
TTopFlow.prototype.loadFromXML=function (xml) {
	this.clear();
	//this.FileName=AFileName;
	//alert(xml);
	var xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
//	xmlDoc.async=false;
	//var flag=
		xmlDoc.loadXML(xml);
	//alert(xmlDoc.xml);
//	if(!flag) {
//		alert('文件['+AFileName+'载入失败！');
//		this.createNew(AFileName);
//		return false;
//	}
	var xmlRoot=xmlDoc.documentElement.getElementsByTagName("Flow").item(0);
	this.code=xmlRoot.getAttribute("code");
	this.name=xmlRoot.getAttribute("name");
	this.desc=xmlRoot.getAttribute("desc");
	this.type=xmlRoot.getAttribute("type");
	
	//Load Proc
	var Procs=xmlRoot.getElementsByTagName("Nodes").item(0);
	var id,oNode,Prop;
	for(i=0;i<Procs.childNodes.length;i++) {
		var Proc=Procs.childNodes.item(i);
		Prop=Proc.getElementsByTagName("BaseProperties").item(0);
		id=Prop.getAttribute("id");
		oNode=new TProc(this,id);
		oNode.Text=Prop.getAttribute("name");
		oNode.NodeType=Prop.getAttribute("nodetype");
		oNode.OptType=Prop.getAttribute("opttype");	
		oNode.OptCode=Prop.getAttribute("optcode");
		oNode.FlowPhase=Prop.getAttribute("flowphase");
		oNode.RoleType=Prop.getAttribute("roletype");
		oNode.RoleCode=Prop.getAttribute("rolecode");
		
		//oNode.TimeBaseNodeId=Prop.getAttribute("timebasenodeid");
		oNode.Riskinfo=Prop.getAttribute("riskinfo")==null?"":Prop.getAttribute("riskinfo");
		oNode.NodeCode=Prop.getAttribute("nodecode")==null?"":Prop.getAttribute("nodecode");
		oNode.TimeLimit=Prop.getAttribute("timeLimit")==null?"":Prop.getAttribute("timeLimit");
		oNode.TimeLimitType=Prop.getAttribute("timeLimitType")?Prop.getAttribute("timeLimitType"):"I";
		oNode.InheritType=Prop.getAttribute("inheritType")==null?"0":Prop.getAttribute("inheritType");
		oNode.InheritNodeCode = Prop.getAttribute("inheritNodeCode")?Prop.getAttribute("inheritNodeCode"):"";
		oNode.isTrunkLine=Prop.getAttribute("isTrunkLine");
		oNode.UnitExp=Prop.getAttribute("unitexp");
		//alert(oNode.UnitExp);
		oNode.PowerExp=Prop.getAttribute("powerexp");
		oNode.ExpireOpt=Prop.getAttribute("expireopt");
		oNode.OptBean=Prop.getAttribute("optbean");
		oNode.OptParam=Prop.getAttribute("optparam");
		oNode.IsAccountTime=Prop.getAttribute("isaccounttime");
		if(oNode.OptBean==null){
			oNode.OptBean="";
		}
		if(oNode.OptParam==null){
			oNode.OptParam="";
		}
		if(oNode.IsAccountTime==null){
			oNode.IsAccountTime="";
		}
	
		oNode.Desc=Prop.getAttribute("desc");
		//alert(oNode.Text);
		//alert(oNode.Desc);
		oNode.SubWfcode=Prop.getAttribute("subwfcode");		
		Prop=Proc.getElementsByTagName("VMLProperties").item(0);
		var nodeType = oNode.NodeType;
		var shapeType = Prop.getAttribute("shapetype");
		if(nodeType=="H"){
			shapeType = "bing";
		}
		if(nodeType=="E"){
			shapeType = "ju";
		}
		if(nodeType=="G"){
			shapeType = "multi";
		}
		oNode.ShapeType=shapeType;
		oNode.Width=Prop.getAttribute("width");
		oNode.Height=Prop.getAttribute("height");
		oNode.X=Prop.getAttribute("x");
		oNode.Y=Prop.getAttribute("y");
		oNode.TextWeight=Prop.getAttribute("textWeight");
		oNode.StrokeWeight=Prop.getAttribute("strokeWeight");
		oNode.zIndex=Prop.getAttribute("zIndex");
		oNode.SameCredit=Prop.getAttribute("SameCredit");
		if(oNode.zIndex=='') {
			oNode.zIndex=this.getMinZIndex()-1;
		}
		this.addProc(oNode);
	}
	//Load Step
	var Steps=xmlRoot.getElementsByTagName("Transitions").item(0);
	for(i=0;i<Steps.childNodes.length;i++) {
		var Step=Steps.childNodes.item(i);
		Prop=Step.getElementsByTagName("BaseProperties").item(0);
		id=Prop.getAttribute("id");
		oNode=new TStep(this,id);
		oNode.Text=Prop.getAttribute("name");
		oNode.FromProc=Prop.getAttribute("from");
		oNode.ToProc=Prop.getAttribute("to");
		oNode.TimeLimitType=Prop.getAttribute("timeLimitType");
		oNode.InheritType=Prop.getAttribute("inheritType")==null?"0":Prop.getAttribute("inheritType");
		oNode.InheritNodeCode = Prop.getAttribute("inheritNodeCode")?Prop.getAttribute("inheritNodeCode"):"";
		oNode.TimeLimit=Prop.getAttribute("timeLimit")==null?"":Prop.getAttribute("timeLimit");
		oNode.Cond=Prop.getAttribute("cond");
		//alert(oNode.Cond);
		oNode.Desc=Prop.getAttribute("desc");
		Prop=Step.getElementsByTagName("VMLProperties").item(0);
		oNode.Points=Prop.getAttribute("points");
		oNode.fromRelX=Prop.getAttribute("fromRelX");
		oNode.fromRelY=Prop.getAttribute("fromRelY");
		oNode.toRelX=Prop.getAttribute("toRelX");
		oNode.toRelY=Prop.getAttribute("toRelY");
		oNode.ShapeType=Prop.getAttribute("shapetype");
		oNode.StartArrow=Prop.getAttribute("startArrow");
		oNode.EndArrow=Prop.getAttribute("endArrow");
		oNode.StrokeWeight=Prop.getAttribute("strokeWeight");
		oNode.zIndex=Prop.getAttribute("zIndex");
		var LabProp=Step.getElementsByTagName("LabelProperties").item(0);
		if(LabProp)
		{
			id=LabProp.getAttribute("id");
			oLabel=new TLabel(id);
			oLabel.Text=Prop.getAttribute("text");
			oLabel.Desc=Prop.getAttribute("desc");
			oLabel.X=LabProp.getAttribute("x");
			oLabel.Y=LabProp.getAttribute("y");
			oLabel.Width=LabProp.getAttribute("width");
			oLabel.Height=LabProp.getAttribute("height");
			oNode.Label=oLabel;
		}
		if(oNode.zIndex=='') {
			oNode.zIndex=this.getMinZIndex()-1;
		}
		this.addStep(oNode);
	}
	//加载Label
	/* var Labels = xmlRoot.getElementsByTagName("Labels").item(0);
				  for (i = 0;i < Labels.childNodes.length;i++) {
					var Label = Labels.childNodes.item(i);
					Prop = Label.getElementsByTagName("BaseProperties").item(0);
					id = Prop.getAttribute("id");
					oNode = new TLabel(this,id);
					oNode.Text = Prop.getAttribute("text");
					var oStep = this.getStepByID(Prop.getAttribute("stepid"));
					oNode.Step = oStep;
					oStep.Label = oNode;
					oNode.Desc = Prop.getAttribute("desc");
					oNode.X = Prop.getAttribute("x");
					oNode.Y = Prop.getAttribute("y");
					oNode.Width = Prop.getAttribute("width");
				    oNode.Height = Prop.getAttribute("height");
					this.addLabel(oNode);
				  }*/
	this.Modified=false;
	return true;
};
//验证流程图
TTopFlow.prototype.validationFlow=function (){
	var flog=true;
	var myerrors=new Array();
	var  bxs=0;      //并行个数
	var hjs=0;		//汇聚个数
	var hd = 0;    //首节点个数
	for(var i=0;i<this.Procs.length;i++){
		Proc=this.Procs[i];
		
		if(Proc.NodeType!='A'&&Proc.NodeType!='F'){
			//
			if(Proc.OptType=='D')
				{
				if(Proc.OptBean==''){
					myerrors.push(Proc.Text+"为自动执行节点，但是没有配置业务bean，请检查后保存。");
					flog=false;}
				}
			else if(Proc.OptType=='S')
			{
				if(Proc.SubWfcode==''||Proc.SubWfcode=='0'){
					myerrors.push(Proc.Text+"为子流程节点，但是没有配置子流程，请检查后保存。");
					
					flog= false;}
			}else if(Proc.OptType!='E')
				{
				if(Proc.OptCode==''||Proc.OptCode=='0'){
					myerrors.push(Proc.Text+"没有配置业务代码，请检查后保存");
					flog=false;
					}
			}
			//
			if(Proc.RoleType=='en')	{
				if(Proc.PowerExp==''){
					myerrors.push(Proc.Text+"的角色类别为权限引擎，但是没有设置权限表达式，请检查后保存");
					flog=false;
				}
			}
			else{
				if(Proc.RoleCode==''||Proc.RoleCode=='0'&&Proc.OptType!='D'&&Proc.OptType!='E'){
					myerrors.push(Proc.Text+"没有设置角色代码，请检查后保存");
					flog=false;
				}				
			}		
		//计算并行节点的个数
			if(Proc.NodeType=="H")
				bxs++;
		//计算汇聚节点的个数
			if(Proc.NodeType=="E")
				hjs++;
			//计算首节点的个数
			if(Proc.NodeType=="B")
				hd++;
		//判断节点的入度 			
			if(this.hasPriorProc(Proc.ID)=="0") {
				myerrors.push(Proc.Text+"没有输入路径");				
				}
			else if(Proc.NodeType=="E"&&this.hasPriorProc(Proc.ID)=="1")
				myerrors.push(Proc.Text+"为汇聚节点，但是只有一条输入路径");
		//判断节点的出度
			if(Proc.NodeType=="H"&&this.hasNextProc(Proc.ID)<2)
				myerrors.push(Proc.Text+"为并行节点，应该有二条以上的输出路径");
			if(Proc.NodeType=="D"&&this.hasNextProc(Proc.ID)<2)
				myerrors.push(Proc.Text+"为分支节点，应该有二条以上的输出路径");
			if(Proc.NodeType=="C"&&this.hasNextProc(Proc.ID)>1)
				myerrors.push(Proc.Text+"为一般节点，应只有一条输出路径");
		}	
	}
	 if(hd>1)
		 myerrors.push("首节点应只有一个，实际为"+hd+"个");
	//判断并行和汇聚个数
	if(hjs>bxs)
		myerrors.push("并行节点有"+bxs+"个，汇聚节点有"+hjs+"个，汇聚节点个数不应超过并行节点个数");
		
	var errors="";
	for(var m=0;m<myerrors.length;m++){	
		errors=errors+myerrors[m]+"\n";		
	}
//	if(errors!=""){
	//alert(errors);}
	//return flog;
	return errors;
	
};

//将流程图保存至服务器上的XML文件中
TTopFlow.prototype.SaveToXML=function () {
	//var xmlDoc=new ActiveXObject('MSXML2.DOMDocument');
	var xmlDoc=new ActiveXObject('Microsoft.XMLDOM');
	xmlDoc.async=false;
		
	//xmlDoc.loadXML('<?xml version="1.0" encoding="GBK"?><CommitFlow/>');	
	xmlDoc.loadXML('<CommitFlow/>');	
	
	var xmlRoot=xmlDoc.documentElement;
	var xmlNodeGrp,xmlNode,xmlNode2,xmlCommitFlow,xmlJbpm;
	//添加CommitFlow流程图xml节点
	xmlCommitFlow=xmlDoc.createNode(1,"Flow","");
	xmlRoot.appendChild(xmlCommitFlow);
	
	xmlCommitFlow.setAttribute("code",this.code);        //????????????????
	//xmlCommitFlow.setAttribute("formid",this.FormID);
	xmlCommitFlow.setAttribute("name",this.name);
	xmlCommitFlow.setAttribute("type",this.type);
	xmlCommitFlow.setAttribute("desc",this.desc);
	//Save Proc
	xmlNodeGrp=xmlDoc.createNode(1,"Nodes","");
	xmlCommitFlow.appendChild(xmlNodeGrp);
	for(var i=0;i<this.Procs.length;i++) {
		Proc=this.Procs[i];
		xmlNode=xmlDoc.createNode(1,"Node","");
		xmlNode2=xmlDoc.createNode(1,"BaseProperties","");
		xmlNode2.setAttribute("id",Proc.ID);
		xmlNode2.setAttribute("name",replacetoxml(Proc.Text));
		//alert(Proc.ID);
		//alert(Proc.ExpireOpt);
		//alert(Proc.Desc);
		xmlNode2.setAttribute("flowphase",Proc.FlowPhase);
		xmlNode2.setAttribute("nodedesc",replacetoxml(Proc.Desc));	
		xmlNode2.setAttribute("nodetype",Proc.NodeType);
		xmlNode2.setAttribute("opttype",Proc.OptType);
		xmlNode2.setAttribute("optcode",replacetoxml(Proc.OptCode));
		xmlNode2.setAttribute("optbean",replacetoxml(Proc.OptBean));
		//alert(Proc.OptParam);
		xmlNode2.setAttribute("optparam",replacetoxml(Proc.OptParam));
		xmlNode2.setAttribute("subwfcode",Proc.SubWfcode);
		xmlNode2.setAttribute("roletype",Proc.RoleType);
		xmlNode2.setAttribute("rolecode",Proc.RoleCode);
		//alert(Proc.IsAccountTime);
		xmlNode2.setAttribute("isaccounttime",Proc.IsAccountTime);
	//	xmlNode2.setAttribute("timebasenodeid", Proc.TimeBaseNodeId);
		xmlNode2.setAttribute("inheritType",Proc.InheritType);
		xmlNode2.setAttribute("inheritNodeCode",replacetoxml(Proc.InheritNodeCode));
		xmlNode2.setAttribute("timeLimit",replacetoxml(Proc.TimeLimit));
		xmlNode2.setAttribute("timeLimitType",replacetoxml(Proc.TimeLimitType));
		xmlNode2.setAttribute("riskinfo",replacetoxml(Proc.Riskinfo));
		xmlNode2.setAttribute("nodecode",replacetoxml(Proc.NodeCode));
	//	alert(Proc.isTrunkLine);
	/*	if(Proc.isTrunkLine==null)
			{alert("xxxx");
			xmlNode2.setAttribute("isTrunkLine", "");	
			}
		else*/
		xmlNode2.setAttribute("isTrunkLine", Proc.isTrunkLine);
		xmlNode2.setAttribute("unitexp",replacetoxml(Proc.UnitExp));
		xmlNode2.setAttribute("powerexp",replacetoxml(Proc.PowerExp));
		xmlNode2.setAttribute("expireopt",replacetoxml(Proc.ExpireOpt));
		//alert(Proc.ExpireOpt);
		xmlNode2.setAttribute("desc",replacetoxml(Proc.Desc));
		
		//添加节点形状 ，位置 ，大小
		xmlNode.appendChild(xmlNode2);
		xmlNode2=xmlDoc.createNode(1,"VMLProperties","");
		xmlNode2.setAttribute("shapetype",Proc.ShapeType);
		xmlNode2.setAttribute("width",Proc.Width);
		xmlNode2.setAttribute("height",Proc.Height);
		xmlNode2.setAttribute("x",Proc.X);
		xmlNode2.setAttribute("y",Proc.Y);
		xmlNode2.setAttribute("textWeight",Proc.TextWeight);
		xmlNode2.setAttribute("strokeWeight",Proc.StrokeWeight);
		xmlNode2.setAttribute("zIndex",Proc.zIndex);
		xmlNode.appendChild(xmlNode2);
		xmlNodeGrp.appendChild(xmlNode);
		
	}
	//Save Step
	xmlNodeGrp=xmlDoc.createNode(1,"Transitions","");
	xmlCommitFlow.appendChild(xmlNodeGrp);
	for(i=0;i<this.Steps.length;i++) {
		Step=this.Steps[i];
		xmlNode=xmlDoc.createNode(1,"Transition","");
		xmlNode2=xmlDoc.createNode(1,"BaseProperties","");
		xmlNode2.setAttribute("id",Step.ID);
		xmlNode2.setAttribute("name",replacetoxml(Step.Text));
		xmlNode2.setAttribute("from",Step.FromProc);
		xmlNode2.setAttribute("to",Step.ToProc);
		var str3=replacetoxml(Step.Cond);
		//alert(Step.Text);
		//alert(str3);
		xmlNode2.setAttribute("cond",replacetoxml(Step.Cond));//replacetoxml(Step.Cond));
		//alert(Step.Cond);
		//alert(xmlNode2);
		xmlNode2.setAttribute("timeLimit",replacetoxml(Step.TimeLimit));
		xmlNode2.setAttribute("timeLimitType",Step.TimeLimitType);
		xmlNode2.setAttribute("inheritType",Step.InheritType);
		xmlNode2.setAttribute("inheritNodeCode",replacetoxml(Step.InheritNodeCode));
		xmlNode2.setAttribute("desc",replacetoxml(Step.Desc));
		xmlNode.appendChild(xmlNode2);
		xmlNode2=xmlDoc.createNode(1,"VMLProperties","");
		xmlNode2.setAttribute("points",Step.Points);
		xmlNode2.setAttribute("fromRelX",Step.fromRelX);
		xmlNode2.setAttribute("fromRelY",Step.fromRelY);
		xmlNode2.setAttribute("toRelX",Step.toRelX);
		xmlNode2.setAttribute("toRelY",Step.toRelY);
		xmlNode2.setAttribute("shapetype",Step.ShapeType);
		xmlNode2.setAttribute("startArrow",Step.StartArrow);
		xmlNode2.setAttribute("endArrow",Step.EndArrow);
		xmlNode2.setAttribute("strokeWeight",Step.StrokeWeight);
		xmlNode2.setAttribute("zIndex",Step.zIndex);
		xmlNode.appendChild(xmlNode2);
		xmlNode2=xmlDoc.createNode(1,"LabelProperties","");
		xmlNode2.setAttribute("id",Step.Label.ID);
		xmlNode2.setAttribute("width",Step.Label.Width);
		xmlNode2.setAttribute("height",Step.Label.Height);
		xmlNode2.setAttribute("x",Step.Label.X);
		xmlNode2.setAttribute("y",Step.Label.Y);
		xmlNode.appendChild(xmlNode2);
		xmlNodeGrp.appendChild(xmlNode);
	}




	var xmlHttp=new ActiveXObject("MSXML2.XMLHTTP");
				
		// 设置用来从请求对象接收回调通知的句柄函数				
		var handlerFunction = getHandler(xmlHttp);			
		xmlHttp.onreadystatechange = handlerFunction;
		xmlHttp.open("POST","sampleFlowDefine!saveFlow.do?flowCode="+flowCode+"&version="+version,true);
		xmlHttp.setRequestHeader("Content-Type","text/html");
		//alert(xmlDoc.xml);
		xmlHttp.send(xmlDoc.xml);		
		setTimeout("", 3000);		
	};


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
