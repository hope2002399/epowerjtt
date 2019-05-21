<%@page import="com.centit.support.utils.DatetimeOpt"%>
<%@page import="org.springframework.security.core.context.SecurityContext"%>
<%@page import="org.springframework.security.core.userdetails.UserDetails"%>
<%@page import="DBstep.iMsgServer2000"%>
<%@page import="com.goldgrid.weboffice.iDBManager2000"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.text.*,java.util.*,java.sql.*,java.util.Date,javax.servlet.*,javax.servlet.http.*" %><!-- ,com.centit.support.utils.NumberBaseOpt -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/page/common/css.jsp"%>
<title>文档在线编辑</title>
<%
  ResultSet result=null;
  String mSubject=null;
  String mStatus=null;
  String mFileName=null;
  String mFileDate=null;
  String mHTMLPath="";
  String mDisabled="";
  String mDisabledSave="";
  String mWord="";
  String mExcel="";

  //流程步骤或者模块简写(保留属性，以后将逐渐取消，或者用flowPhase代替)
  String flowStep = request.getParameter("flowStep");
  flowStep = (flowStep == null ? "" : flowStep);
  
  /**
   * 格式文书类别archiveType：<br>
   * ************************************************<br>
   * 登记—— 01: 申请表<br>
   * 受理—— 02: 受理通知书、 03: 补正通知书<br>
   * 审核（第二步）—— 04: 审核意见书、 05: 审核意见书附表  <br>
   * 审查（上报后的第一步）—— 06: 审查意见书<br>    
   * 发证—— 07: 许可决定书<br>
   * ************************************************ <br> 
   */
  String archiveType = request.getParameter("archiveType");
  
  //自动获取OfficeServer和OCX文件完整URL路径
  String mHttpUrlName=request.getRequestURI();
  String mScriptName=request.getServletPath();
  
  //参数描述 ：fileType 文件分类-默认1 ---- 1：格式文书 2：申请附件 3：办理附件 4：证据（处罚平台用）
  String mServerName="/OfficeServer?fileType=1&archiveType="+archiveType+"&flowStep="+flowStep;
  String serverURI = "http://"+request.getServerName()+":"+request.getServerPort()+mHttpUrlName.substring(0,mHttpUrlName.lastIndexOf(mScriptName))+"/";
  String mServerUrl= serverURI + mServerName;//取得OfficeServer文件的完整URL
  String mHttpUrl="http://"+request.getServerName()+":"+request.getServerPort()+mHttpUrlName.substring(0,mHttpUrlName.lastIndexOf(mScriptName))+"/";
  
  String mRecordID=request.getParameter("RecordID");
  /*
  *模版编号
  */
  String mTemplate=request.getParameter("Template");
  
  //强行制定.doc类型
  String mFileType=".doc";
  String mEditType=request.getParameter("EditType");
  String mShowType=request.getParameter("ShowType");
  String mNeedBookMark=request.getParameter("NeedBookMark");

  //设置编号初始值
  if (mRecordID==null){
     mRecordID="";
  }

  //设置编辑状态初始值
  if (mEditType==null || mEditType==""){
    mEditType="1,1";
  }

  //设置显示模式初始值
  if (mShowType==null || mShowType==""){
    mShowType="1";
  }

  //设置文档类型初始值
  if (mFileType==null || mFileType==""){
    mFileType=".doc";
  }

  //设置模板初始值
  if (mTemplate==null || mTemplate.trim().equals("")){
    mTemplate="OLD_DOC";//领导要求默认OLD_DOC
  }

  String fileName = "";
  //打开数据库
  iDBManager2000 DbaObj=new iDBManager2000();
  if (DbaObj.OpenConnection()){
	  
    String mSql="Select * From Document Where RecordID='"+ mRecordID + "'";
    
    if(mTemplate.length() != 0){
    	mSql += " and TEMPLATE='"+mTemplate+"'";
    }
    
    try{
    	
      result=DbaObj.ExecuteQuery(mSql);
      if (result.next()){
        mRecordID=result.getString("RecordID");
        mTemplate=result.getString("Template");
        mSubject=result.getString("Subject");
        mFileDate=result.getString("FileDate");
        mStatus=result.getString("Status");
        //mx 2012-7-25 强行制定.doc类型
        //mFileType=result.getString("FileType");
        mFileType=".doc";
        mHTMLPath=result.getString("HTMLPath");
      }
      else{
        //取得唯一值(mRecordID)
        //java.util.Date dt=new java.util.Date();
       // long lg=dt.getTime();
       // Long ld=new Long(lg);
        //初始化值
       // mRecordID=ld.toString();//保存的是文档的编号，通过该编号，可以在里找到所有属于这条纪录的文档
        mTemplate=mTemplate;
        mSubject="请输入主题";
        mFileDate=DbaObj.GetDateTime();
        mStatus="DERF";
        mFileType=mFileType;
        mHTMLPath="";
      }

      String TemplateSql = "SELECT FILETYPE,FILENAME,TEMPTYPE,DESCRIPT FROM Template_File WHERE RECORDID='" + mTemplate + "'";
      result = DbaObj.ExecuteQuery(TemplateSql);
      if (result.next()) {
    		  fileName = result.getString("DESCRIPT") + result.getString("FILETYPE");
      }else{
      	fileName = "正文_"+ mRecordID +"_"+ mTemplate+".doc";
      }
      
      result.close();
    }
    catch(SQLException e){
      System.out.println(e.toString());
    }
    DbaObj.CloseConnection() ;
  }

  if (mEditType=="0,0"){
    mDisabled="disabled";
    mDisabledSave="disabled";
  }
  else{
    mDisabled="";
  }

  mFileName=mRecordID + mFileType;  //取得完整的文档名称
  if (mFileType.equalsIgnoreCase(".doc") || mFileType.equalsIgnoreCase(".wps")){
    mWord="";
    mExcel="disabled";
  }
  else if (mFileType==".xls"){
    mWord="disabled";
    mExcel="";
  }
  else{
    mDisabled="disabled";
  }
  
%>
<script type="text/javascript">

	var step = '<%=flowStep%>';
	

	//父页面文档对象
	var parentDocument = window.opener.document;
	
	var flowInstId = _getParentElementValue("flowInstId");
	var nodeInstId = _getParentElementValue("nodeInstId");
	
	/*TODO最好直接做成保存清稿版本 */
	function clearRevisions(){
		webform.WebOffice.ClearRevisions();
	}
	
	function savePDFDocument(){
		if(!webform.WebOffice.WebSavePDF()){
			  alert("PDF保存失败！");
		 }
	}
	//作用：保存文档
	function SaveDocument(){
	  //webform.WebOffice.WebSetMsgByName("MyDefine1","自定义变量值1");  //设置变量MyDefine1="自定义变量值1"，变量可以设置多个  在WebSave()时，一起提交到OfficeServer中
	  if (!webform.WebOffice.WebSave(true)){    //交互OfficeServer的OPTION="SAVEFILE"  注：WebSave()是保存复合格式文件，包括OFFICE内容和手写批注文档；如只保存成OFFICE文档格式，那么就设WebSave(true)
	     StatusMsg(webform.WebOffice.Status);
	     return false;
	  }else{
		  
		  
		  /* step的含义：
		  	ZW_EDIT：	正文编辑；
		  	SL_UP：	受理通知书上传；
		  	NSL_UP：不受理通知书上传；
		  	BZ_UP：	补正材料上传；
		  	PRINT_EDIT:印刷编辑
		  	PDF_UP：PDF文件上传
		  	VIEW：查看功能，不可任何编辑
		  */
		  if(step == 'ZW_EDIT' || step == 'ZW_ADD'){
			  if(parentDocument.getElementById("curTemplateId") != undefined){
				  parentDocument.getElementById("curTemplateId").value = '<%=mTemplate%>';
			  }
			  
			  if(parentDocument.getElementById("archiveType") != undefined){
				  parentDocument.getElementById("archiveType").value = '<%=archiveType%>';
			  }
			  
			  if(parentDocument.getElementById('recordId') != undefined){
				  var indexx=parentDocument.getElementById('recordId').selectedIndex ;
		          var textt=parentDocument.getElementById("recordId").options[indexx].text;
		          parentDocument.getElementById("fwname").innerHTML="" + textt + ".doc";
			  }
	          
			  if(parentDocument.getElementById("addDoc") != undefined){
				  if("03"=='<%=archiveType%>'){
					  parentDocument.getElementById("EDitBZ").style.display = "";
				  }else{
					  parentDocument.getElementById("addDoc").style.display="none";
					  parentDocument.getElementById("zwedit").style.display="";
				  }
				 
			  }
		  }
		
		  
		  if(step == 'PRINT_EDIT'){
			  
			  <%
			  	//清稿阶段设置
			  	String clearServerUrl= serverURI +  "/OfficeServer?flowStep=CLEAR";
			  %>
			  var userid = '${SPRING_SECURITY_CONTEXT.authentication.principal.usercode}';
			  var clearWebURL = "<%=clearServerUrl%>&usercode="+userid +"&flowInstId="+flowInstId+"&nodeInstId="+nodeInstId;
				
			  webform.WebOffice.WebUrl = clearWebURL;
			  //清稿
			  clearRevisions();
			  //保存清稿
			  webform.WebOffice.WebSave(true);
		  }
		 if("08"=='<%=archiveType%>'){
			//保存PDF
			savePDFDocument();
		 }
	     StatusMsg(webform.WebOffice.Status);
	     //webform.WebOffice.WebMkDirectory("C:\\centitwordbak");
	     //webform.WebOffice.WebSaveLocalFile("C:/centitwordbak/" + getCurDate() + "_" + "<%=fileName%>");
	     return true;
	  }
	}

	//获取系统时间
	function getCurDate()
	{
		 var d = new Date();
		 var years = d.getYear();
		 var month = add_zero(d.getMonth()+1);
		 var days = add_zero(d.getDate());
		 var hours = add_zero(d.getHours());
		 var minutes = add_zero(d.getMinutes());
		 var seconds=add_zero(d.getSeconds());
		 var ndate = years+"年"+month+"月"+days+"日"/* +hours+minutes+seconds */;
		 return ndate;
	}

	//时间和日期补0
	function add_zero(temp)
	{
	 if(temp<10) return "0"+temp;
	 else return temp;
	}

	//作用：载入iWebOffice
	function Load(){
		
		var userName = '${SPRING_SECURITY_CONTEXT.authentication.principal.username}';
		var userid = '${SPRING_SECURITY_CONTEXT.authentication.principal.usercode}';
		var webURL = "<%=mServerUrl%>&usercode="+userid + "&flowInstId=" +flowInstId + "&nodeInstId=" +nodeInstId;
		
		var webObj = webform.WebOffice;
		try{
			
		  	//以下属性必须设置，实始化iWebOffice
		    webObj.WebUrl= webURL ;             //WebUrl:系统服务器路径，与服务器文件交互操作，如保存、打开文档，重要文件
		    webObj.RecordID="<%=mRecordID%>";            //RecordID:本文档记录编号
		    webObj.Template="<%=mTemplate%>";            //Template:模板编号
		    webObj.FileName="<%=fileName%>";            //FileName:文档名称
		    webObj.FileType="<%=mFileType%>";            //FileType:文档类型  .doc  .xls  .wps  .et(wps的电子表格)
		    webObj.UserName = userName;            //UserName:操作用户名，痕迹保留需要
		    webObj.EditType="<%=mEditType%>";            //EditType:编辑类型  方式一、方式二  <参考技术文档>
		                                                          //第一位可以为0,1,2,3 其中:0不可编辑;1可以编辑,无痕迹;2可以编辑,有痕迹,不能修订;3可以编辑,有痕迹,能修订；
		                                                          //第二位可以为0,1 其中:0不可批注,1可以批注。可以参考iWebOffice2009的EditType属性，详细参考技术白皮书
			webObj.MaxFileSize = 4 * 1024;               //最大的文档大小控制，默认是8M，现在设置成4M。
			webObj.Language="CH";                        //Language:多语言支持显示选择   CH简体 TW繁体 EN英文
			//webObj.ShowWindow = true;                  //控制显示打开或保存文档的进度窗口，默认不显示
			webObj.PenColor="#FF0000";                   //PenColor:默认批注颜色
			webObj.PenWidth="1";                         //PenWidth:默认批注笔宽
			webObj.Print="1";                            //Print:默认是否可以打印:1可以打印批注,0不可以打印批注
			webObj.ShowMenu="1";                         //控制整体菜单显示
			webObj.ShowToolBar="1";
			
			//初始化快捷键、
			webObj.DisableKey("CTRL+P");
			webObj.ShortCutKey="CTRL+S;CTRL+P;F12";
			//WebSetRibbonUIXML();                                  //控制OFFICE2007的选项卡显示

			webObj.WebOpen();                            //打开该文档    交互OfficeServer  调出文档OPTION="LOADFILE"    调出模板OPTION="LOADTEMPLATE"     <参考技术文档>
  
			if(step == "ZW_EDIT"){//拟文或主动发文
				//webObj.ShowToolBar="1";                      //ShowToolBar:是否显示工具栏:1显示,0不显示
				webObj.WebObject.ShowRevisions=0;			//不显示修订
				webObj.WebObject.PrintRevisions=0;
				//隐藏几个自定义工具栏的按钮
				webObj.VisibleTools("重新批注,新建文件,打开文件,保存文件,文字批注,手写批注,文档清稿",false);
				//自定义按钮，按钮响应事件在onToolsclick
				webObj.AppendTools("90","显示修订",99);
				webObj.AppendTools("91","隐藏修订",99);
				webObj.AppendTools("92","显示红头",99);
				webObj.AppendTools("93","隐藏红头",99);
			}
			webObj.AppendTools("94","打印文档",99);
			webObj.AppendTools("95","退出编辑",99);
			webObj.AppendTools("96","本地保存",99);
			
			if(step != null && step != "VIEW"){
				webObj.AppendTools("97","保存文档",99);
			}else{
				webObj.VisibleTools("重新批注,新建文件,打开文件,保存文件,文字批注,手写批注,文档清稿",false);
				webObj.WebObject.ShowRevisions=0;
				webObj.WebObject.PrintRevisions=0;
			}
			transBookMark(webObj);
					
			webObj.WebObject.ActiveWindow.View.TableGridlines=0;
		}catch(e){
		  alert(e.description);                                   //显示出错误信息
		}
	}

	function _getParentElementValue(id){
		if(parentDocument.getElementsByName(id)[0] == undefined){
			return '';
		}
		return parentDocument.getElementsByName(id)[0].value;
	}
	
	//设置文书标签
	function transBookMark(webObj){
		//alert(window.opener.parent.getOptBaseInfoJson());
		//alert($.parseJSON(window.opener.parent.getOptBaseInfoJson()));
		var jsonArr = window.opener.getOptBaseInfoJson();
	
		var obj = new Array();
		for(var able in jsonArr){		
			obj.push(able);
		}	
		for(var i=0,len=obj.length;i<len;i++){
			webObj.WebSetBookMarks(obj[i],jsonArr[obj[i]]);
			//alert(jsonArr[obj[i]]);
		} 
		var userName = '${SPRING_SECURITY_CONTEXT.authentication.principal.username}';
		var docmentType = window.opener.getDocumentType();
		var archive=window.opener.getArchiveType(window.opener.getDocumentType());
		var curOptProInfo = window.opener.getCurNodenisid()+"|"+window.opener.getTranscontent()+"|"+userName+"|"+getCurDate()+"|"+window.opener.getNodeName();
		if(archive=='07'){
			var optInfo=window.opener.getOptInfo();
			if(""==optInfo||null==optInfo){
				setTransContents(webObj,0,curOptProInfo);
			}else{
				if(optInfo.indexOf(";")<0){
					if(optInfo.split("|")[0]==curOptProInfo.split("|")[0]){
						setTransContents(webObj,0,curOptProInfo);
					}else{
						setTransContents(webObj,1,curOptProInfo);
					}
				}else{
					for(var i = 0;i<optInfo.split(";").length;i++){
						
							if(optInfo.split(";")[i].split("|")[0]==curOptProInfo.split("|")[0]||optInfo.split(";")[i].split("|")[4]==curOptProInfo.split("|")[4]){
								setTransContents(webObj,i,curOptProInfo);
								break;
							}else{
								if(i==optInfo.split(";").length-1){
								setTransContents(webObj,i+1,curOptProInfo);
								}
							}
						
					}
				}
			} 
		}
		if(archive=='08'){
			webObj.WebSetBookMarks("transcontent_0",window.opener.getTranscontent());
		}
	}
	function setTransContents(webObj,i,optInfo){
		webObj.WebSetBookMarks("transcontent_"+i,optInfo.split("|")[1]);
		webObj.WebSetBookMarks("loginuserName_"+i,optInfo.split("|")[2]);
		webObj.WebSetBookMarks("date_"+i,optInfo.split("|")[3]);
	}
	/**************************************************** 
	* 
	* 受理通知书,书签插值 
	* 
	****************************************************/ 
	function SLTZBookMark(webObj){ 
		try{ 
			webObj.WebSetBookMarks("title","受理通知书");//受理环节的办理结果，原来代码中判断应无误 
			webObj.WebSetBookMarks("AppName",_getParentElementValue("AppName"));//公文信息中的来文单位，原来代码中取值有问题 
			webObj.WebSetBookMarks("LoginDate",_getParentElementValue("LoginDate"));//公文信息中的收文日期，原来代码中取值正确，但格式未处理 
			webObj.WebSetBookMarks("ItemClassName",_getParentElementValue("ItemClassName"));//公文信息中的文件标题，原来代码中取值不对 
			webObj.WebSetBookMarks("ZBCS",_getParentElementValue("ZBCS"));//主办处室，新增的标签，原来代码中没有 
			//webObj.WebSetBookMarks("today",NumberBaseOpt.Capitalization(_getParentElementValue("today")),true);//当前日期，注意处理格式，原来代码中取值正确，但格式未处理
			webObj.WebObject.BookMarks.Item("today").Range.InsertDateTime("EEEE年O月A日",false,false,2052,0);//当前日期
			webObj.WebSetBookMarks("operatorName",_getParentElementValue("operatorName"));//当前用户姓名 
			webObj.WebSetBookMarks("depPhone",_getParentElementValue("depPhone"));//当前用户的办公室电话 
		}catch(e){ 
			alert("异常\r\nError:"+e+"\r\nError Code:"+e.number+"\r\nError Des:"+e.description); 
		} 
	} 

	/**************************************************** 
	* 
	* 不予受理通知书,书签插值 
	* 
	****************************************************/ 
	function BYSLTZBookMark(webObj){ 
		try{ 
			webObj.WebSetBookMarks("title","不予受理通知书");//受理环节的办理结果，原来代码中判断应无误 
			webObj.WebSetBookMarks("AppName",_getParentElementValue("AppName"));//公文信息中的来文单位，原来代码中取值有问题 
			webObj.WebSetBookMarks("LoginDate",_getParentElementValue("LoginDate"));//公文信息中的收文日期，原来代码中取值正确，但格式未处理 
			webObj.WebSetBookMarks("ItemClassName",_getParentElementValue("ItemClassName"));//公文信息中的文件标题，原来代码中取值不对 
			//webObj.WebSetBookMarks("today",_getParentElementValue("today"));//当前日期，注意处理格式，原来代码中取值正确，但格式未处理
			webObj.WebObject.BookMarks.Item("today").Range.InsertDateTime("EEEE年O月A日",false,false,2052,0);//当前日期
			webObj.WebSetBookMarks("operatorName",_getParentElementValue("operatorName"));//当前用户姓名 
			webObj.WebSetBookMarks("depPhone",_getParentElementValue("depPhone"));//当前用户的办公室电话 
		}catch(e){ 
			alert("异常\r\nError:"+e+"\r\nError Code:"+e.number+"\r\nError Des:"+e.description); 
		} 
	} 

	/**************************************************** 
	* 
	* 补正通知书,书签插值
	* 
	****************************************************/ 
	function BZTZBookMark(webObj){ 
		try{ 
			webObj.WebSetBookMarks("title","补正通知书");//受理环节的办理结果，原来代码中判断应无误 
			webObj.WebSetBookMarks("AppName",_getParentElementValue("AppName"));//公文信息中的来文单位，原来代码中取值有问题 
			webObj.WebSetBookMarks("LoginDate",_getParentElementValue("LoginDate"));//公文信息中的收文日期，原来代码中取值正确，但格式未处理 
			webObj.WebSetBookMarks("ItemClassName",_getParentElementValue("ItemClassName"));//公文信息中的文件标题，原来代码中取值不对 
			webObj.WebSetBookMarks("idea",_getParentElementValue("dealcontent"));//当前步骤的意见，原来代码中可能没有 
			//webObj.WebSetBookMarks("today",_getParentElementValue("today"));//当前日期，注意处理格式，原来代码中取值正确，但格式未处理
			webObj.WebObject.BookMarks.Item("today").Range.InsertDateTime("EEEE年O月A日",false,false,2052,0);
			webObj.WebSetBookMarks("operatorName",_getParentElementValue("operatorName"));//当前用户姓名 
			webObj.WebSetBookMarks("depPhone",_getParentElementValue("depPhone"));//当前用户的办公室电话 
		}catch(e){ 
			alert("异常\r\nError:"+e+"\r\nError Code:"+e.number+"\r\nError Des:"+e.description); 
		} 
	}

	
//作用：显示操作状态
function StatusMsg(mString){
	//alert(mString);
  //webform.StatusBar.value=mString;
}

//作用：退出iWebOffice
function UnLoad(){
	try{
	  webform.WebOffice.WebClose();
	  }catch(e){
	  alert(e.description);
	}
}

//作用，将正在编辑的文档保存为本地文件
function SaveAsLocalFile(){
	webform.WebOffice.WebSaveLocal();
}

//打印份数控制
function WebCopysCtrlPrint(webObj){
  var mCopies,objPrint;
  objPrint = webObj.WebObject.Application.Dialogs(88);     //打印设置对话框
  if (objPrint.Display==-1){
    mCopies=objPrint.NumCopies;    //取得需要打印份数
    webObj.WebSetMsgByName("COMMAND","COPIES");
    webObj.WebSetMsgByName("OFFICEPRINTS",mCopies.toString());   //设置变量OFFICEPRINTS的值，在WebSendMessage()时，一起提交到OfficeServer中
    webObj.WebSendMessage();                               //交互OfficeServer的OPTION="SENDMESSAGE"
    if (webObj.Status=="1") {
      alert("可以允许打印，注：该实例设置总文档打印份数2份");
      objPrint.Execute;
    }else{
      alert("已超出允许的打印份数");
      return false;
    }
  }
}

function checkLeave(){
	var n = window.event.screenX - window.screenLeft;
    var b = n > document.documentElement.scrollWidth - 20;
    if(b && window.event.clientY < 0 || window.event.altKey)
    {
		window.event.returnValue = "提醒：关闭窗口前请保存文档。";
    }
}
</script>

<!-- 穆欣 2012-7-7 金格控件自定义工具按钮的事件响应函数 -->
<script language=javascript for="WebOffice" event=OnToolsClick(vIndex,vCaption)>
	var webObj = webform.WebOffice;
	var rev;
	if(vIndex==-1){//对全屏操作的响应
	
		if(vCaption== "全屏_BEGIN"){
			rev = webObj.WebObject.ShowRevisions;
			if(rev){
				webform.revision.value = '1';
			}else{
				webform.revision.value  = '0';
			}
		}
	
		if(vCaption=="返回"){
			rev = webform.revision.value;
			if(rev=='1'){
				webObj.WebObject.ShowRevisions=true;     //重新设置为默认
			    webObj.WebObject.PrintRevisions=true;
				
			}
			if(rev=='0'){
				webObj.WebObject.ShowRevisions=false;     //重新设置为默认
			    webObj.WebObject.PrintRevisions=false;
			}
		}
		
		if(vCaption=="返回_BEGIN"){                      //退出全屏操作之前
			rev = webObj.WebObject.ShowRevisions;        //获取痕迹状态
			if(rev){
				webform.revision.value = '1';
			}else{
				webform.revision.value  = '0';
			}
		}
		if(vCaption=="全屏"){                            //退出全屏操作之后
		    rev = webform.revision.value;
			if(rev=='1'){
				webObj.WebObject.ShowRevisions=true;     //重新设置为默认
			    webObj.WebObject.PrintRevisions=true;
				
			}
			if(rev=='0'){
				webObj.WebObject.ShowRevisions=false;     //重新设置为默认
			    webObj.WebObject.PrintRevisions=false;
			}
		}
	}else if(vIndex==90){//显示痕迹
		webObj.WebObject.ShowRevisions=1;
		webObj.WebObject.PrintRevisions=1;
	}else if(vIndex==91){//隐藏痕迹，但继续保留痕迹（虽然不可见）
		webObj.WebObject.ShowRevisions=0;
		webObj.WebObject.PrintRevisions=0;
	}else if(vIndex==92){//显示红头
		webObj.EditType="1,0";
		try{
			var viewtype=webObj.WebObject.ActiveWindow.View.Type;
			webObj.WebObject.ActiveWindow.view.Type=3;
			webObj.WebObject.Application.Selection.HomeKey(6,0);
			try{
				webObj.WebObject.Styles.Item("文头").Font.Color=255;
			}
			catch(e){}
			webObj.WebObject.Shapes.SelectAll();
			if(webObj.WebObject.Application.Selection.Count>=1){
				webObj.WebObject.Application.Selection.ShapeRange.Visible=-1;
			}
			webObj.WebObject.ActiveWindow.View.SeekView=9;
			webObj.WebObject.Application.Selection.HeaderFooter.Shapes.SelectAll();
			if(webObj.WebObject.Application.Selection.Count>=1){
				webObj.WebObject.Application.Selection.ShapeRange.Visible=-1;
			}
			webObj.WebObject.Application.Selection.HomeKey(6,0);
			webObj.WebObject.Application.Selection.GoTo(9,2,1,"Word.Picture.8");
			webObj.WebObject.Application.Selection.MoveRight(1,1,1);
			if(webObj.WebObject.Application.Selection.Type==7){
				webObj.WebObject.Application.Selection.Range.InlineShapes(1).PictureFormat.Brightness=0.5;
			}
			webObj.WebObject.ActiveWindow.View.SeekView=10;
			webObj.WebObject.Application.Selection.MoveRight(1,1,1);
			if(webObj.WebObject.Application.Selection.Type==7){
				webObj.WebObject.Application.Selection.Range.InlineShapes(1).PictureFormat.Brightness=0.5;
			}
			webObj.WebObject.ActiveWindow.View.SeekView=0;
			webObj.WebObject.Application.Selection.GoTo(9,2,1,"Word.Document.8");
			webObj.WebObject.Application.Selection.MoveRight(1,1,1);
			if(webObj.WebObject.Application.Selection.Type==7){
				webObj.WebObject.Application.Selection.Range.InlineShapes(1).PictureFormat.Brightness=0.5;
			}
			webObj.WebObject.Application.Selection.MoveRight(1,1);
			webObj.WebObject.Application.Selection.HomeKey(6,0);
			webObj.WebObject.ActiveWindow.view.Type=viewtype;
		}catch(e){
			alert("异常\r\nError:"+e+"\r\nError Code:"+e.number+"\r\nError Des:"+e.description);
		}
	
		webObj.EditType="<%=mEditType%>";
		webObj.WebObject.ShowRevisions=0;
		webObj.WebObject.PrintRevisions=0;
	}else if(vIndex==93){//隐藏红头
		webObj.EditType="1,0";
		try{
			var viewtype=webObj.WebObject.ActiveWindow.View.Type;
			webObj.WebObject.ActiveWindow.view.Type=3;
			webObj.WebObject.Application.Selection.HomeKey(6,0);
			try{
				webObj.WebObject.Styles.Item("文头").Font.Color=16777215;
			}
			catch(e){}
			webObj.WebObject.Shapes.SelectAll();
			if(webObj.WebObject.Application.Selection.Count>=1){
				webObj.WebObject.Application.Selection.ShapeRange.Visible=0;
			}
			webObj.WebObject.ActiveWindow.View.SeekView=9;
			webObj.WebObject.Application.Selection.HeaderFooter.Shapes.SelectAll();
			if(webObj.WebObject.Application.Selection.Count>=1){
				webObj.WebObject.Application.Selection.ShapeRange.Visible=0;
			}			
			webObj.WebObject.Application.Selection.HomeKey(6,0);
			webObj.WebObject.Application.Selection.GoTo(9,2,1,"Word.Picture.8");
			webObj.WebObject.Application.Selection.MoveRight(1,1,1);
			if(webObj.WebObject.Application.Selection.Type==7){
				webObj.WebObject.Application.Selection.Range.InlineShapes(1).PictureFormat.Brightness=1;
			}
			webObj.WebObject.ActiveWindow.View.SeekView=10;
			webObj.WebObject.Application.Selection.MoveRight(1,1,1);
			if(webObj.WebObject.Application.Selection.Type==7){
				webObj.WebObject.Application.Selection.Range.InlineShapes(1).PictureFormat.Brightness=1;
			}
			webObj.WebObject.ActiveWindow.View.SeekView=0;
			webObj.WebObject.Application.Selection.GoTo(9,2,1,"Word.Document.8");
			webObj.WebObject.Application.Selection.MoveRight(1,1,1);
			if(webObj.WebObject.Application.Selection.Type==7){
				webObj.WebObject.Application.Selection.Range.InlineShapes(1).PictureFormat.Brightness=1;
			}
			
			webObj.WebObject.Application.Selection.MoveRight(1,1);
			webObj.WebObject.Application.Selection.HomeKey(6,0);
			webObj.WebObject.ActiveWindow.view.Type=viewtype;
			
		}catch(e){
			alert("异常\r\nError:"+e+"\r\nError Code:"+e.number+"\r\nError Des:"+e.description);
		}
		webObj.EditType="<%=mEditType%>";
		webObj.WebObject.ShowRevisions=0;
		webObj.WebObject.PrintRevisions=0;
	}/* else if(vIndex==99){
		if(confirm("确认接受所有修订吗？")){
			document.getElementById("WebOffice").ClearRevisions();
		}
	} */
	
	else if (vIndex==94){
		webObj.WebOpenPrint();     //打印文档
	}
	else if (vIndex==95){
		if(window.confirm("确定退出文档编辑？")){
			window.close();     //退出文档
		}
		
	}
	else if (vIndex==96){  
		SaveAsLocalFile();     //保存本地
	}
	else if (vIndex==97){ //保存提交
		if(SaveDocument()){
			document.webform.submit();   
			window.opener.parent.frames['stuffsFrame'].location.reload(); 
		}
	}
	
	if(vIndex==-2){ 
		if(vCaption=="CTRL+S"){ 
			if(SaveDocument()){
				document.webform.submit();   
			}
		}else if(vCaption=="CTRL+P"){ 
			webObj.WebOpenPrint();     //打印文档
		}else if(vCaption=="F12"){ 
			SaveAsLocalFile();
		} 
	}
	
</script>

</head>
<body bgcolor="#ffffff" onload="Load()"  onbeforeunload="checkLeave()" onunload="UnLoad()">
<p/>
<form name="webform" method="post" action="DocumentSave.jsp" target="frame_save" onsubmit="return SaveDocument();">
    <input type="hidden" name="revision" value="">
    <input type="hidden" name="RecordID" value="<%=mRecordID%>">
    <input type="hidden" name="Template" value="<%=mTemplate%>">
    <input type="hidden" name="FileType" value="<%=mFileType%>">
    <input type="hidden" name="EditType" value="<%=mEditType%>">
    <input type="hidden" name="Subject" value="">
    <input type="hidden" name="Author" value="${SPRING_SECURITY_CONTEXT.authentication.principal.usercode}">
    <input type="hidden" name="FileDate" value="<%=mFileDate%>">
<table border=0 cellspacing='0' cellpadding='0' width=100% height="100%" align=center class=TBStyle>
		<td height="100%" colspan="2" rowspan="12" align="right" valign="top" class="TDStyle" hegith="90%">
          <table border="0" cellspacing="0" cellpadding="0" width="100%" height="100%">
            <tr>
              <td bgcolor="menu" height="98%" valign="top">
	              <OBJECT name="WebOffice"
					classid="clsid:8B23EA28-2009-402F-92C4-59BE0E063499"
					codebase="iWebOffice2009.cab#version=10,7,2,8"
					  width="100%"  height="100%">
				</OBJECT>
              </td>
            </tr>
          </table>
        </td>
      </tr>
      </table>
      <iframe width="0px" height="0px" frameborder="no" scrolling="no" src="" name="frame_save"></iframe>
</form>
</body>
</html>