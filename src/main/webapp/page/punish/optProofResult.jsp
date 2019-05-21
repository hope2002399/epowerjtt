<%@page import="com.goldgrid.weboffice.TemplateService"%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>

<html>

<head>

<title>办理信息</title>
<link href="${pageContext.request.contextPath}/themes/css/alertDiv.css"
	rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/scripts/alertDiv.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/arrow.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/kjyj.js"
	type="text/javascript"></script>
<script type="text/javascript" src="jquery-1.6.min.js"></script>
<%-- <link href="${pageContext.request.contextPath}/themes/css/arrow.css" rel="stylesheet" type="text/css" /> --%>
<sj:head locale="zh_CN" />
<style type="text/css">
a.title:link, a.title:visited, a.title:hover {
	display: block;
	color: #385065;
	font-weight: bold;
	line-height: 23px;
	text-decoration: none;
}

a.title {
	float: left;
	width: 90%;
}

.tableHeader {
	position: relative;
	border: 0 !important;
}

.del {
	position: absolute;
	right: 10px;
	top: 8px;
}

.item {
	margin: 5px 0px;;
	padding: 0px;;
	list-style: none
}

.icc {
	width: 20px;
	height: 20px;
	background:
		url(${pageContext.request.contextPath}/themes/default/images/panel/panel_icon.gif)
		no-repeat 0 2px;
}

.icc.c {
	background:
		url(${pageContext.request.contextPath}/themes/default/images/panel/panel_icon.gif)
		no-repeat 0 -98px;
}
</style>
<script type="text/javascript">
$(document).ready(
function(){
	HideAll("${serial}");
}
);

function setH(h){
	window.parent.document.getElementById("transFrame").style.height = h+"px";
}

function showpunishui(value){
	var ideacode=_get("ideacode").value;
	var href="punish/poindagaterepbasic!isProofResult.do?optProcInfo.ideacode="+ideacode+"&nodeInstId="+nodeinstid+"&punishobjectid="+punishobjectid+"&flowInstId="+flowinstid+"&poindagaterepstate="+value;
	window.location.href=href;
}
function savedegree(serial,degreeno,item_id,version){
    if(degreeno==""){
        alert("请选择自由裁量标准");
        return;
      }
	var href="punish/poindagaterepbasic!saveDegree.do?optProcInfo.ideacode=T&nodeInstId="+nodeinstid+"&punishobjectid="+punishobjectid+"&flowInstId="+flowinstid+"&serial="+serial+"&item_id="+item_id+"&version="+version+"&degreeno="+degreeno+"&poindagaterepstate=${poindagaterepstate}";
	window.location.href=href;
	
}


function furl(i) {
	var items = document.getElementsByName("title");
	var state = document.getElementById("opt_" + i).style.display;
	//HideAll(-1);
	
	for (var j=0; j<items.length; j++) {
	    if(j==i){
	       var o = document.getElementById("opt_" + j);
	       if (state == "block") {
	         o.style.display = "none";
	         items[j].getElementsByTagName("span")[0].className = "icc";
	       }else{
	          o.style.display = "block";
	          items[j].getElementsByTagName("span")[0].className = "icc c";
	       }
	    }
	}
	setH( parseInt(_get("getHeight").offsetHeight) );
}
function HideAll(serial) {
   var ideacode="${optProcInfo.ideacode}";
   if(ideacode==null||ideacode==""){
	   _get('punishdecision').style.display="none";
	   _get('backtranscontent').style.display="none";
	   
   }else{
	   _get('punishdecision').style.display="block";
   }
   if(ideacode=="T"){
	   _get('backtranscontent').style.display="none";
   }
	var length=$("td.optiton").length;
	for (var j=0; j<length; j++) {
		$("td.optiton")[j].style.display = "none";
	}
	if(Number(serial)>-1&&serial!=""){
	   document.getElementById("opt_" + serial).style.display = "block";
	}
	
	
}

function checkForm(){



	if(_get("ideacode").value=="T"){	
	var poindagaterepstate="${poindagaterepstate}";
	if(poindagaterepstate==""||poindagaterepstate==null){
		alert("请选择处理决定");
		return false;
	}
	
	if(poindagaterepstate==0){
	 var size=${fn:length(listtranslaw)};	
	 if(size==1){
	 document.poindagaterepbasicForm.poindagaterepresult.value=document.poindagaterepbasicForm.result.value;
	}	
	if(document.poindagaterepbasicForm.poindagaterepresult.value==""){
		     alert("请选择处罚意见");
		     return false;
	}
	
	 if(document.poindagaterepbasicForm.poindagaterepresult.value.indexOf('(')>-1){
		     alert("罚款为具体数目，请重新做出处罚意见");
		     return false;
	 }

	}


	if(poindagaterepstate==1){
		if(trim(_get('poneatencontent').value).length==0){
			alert("请输入整改内容");
			_get('poneatencontent').focus();
			return false;
	}
	}
	if(poindagaterepstate==2){
		if(trim(_get('podeportationdepname').value).length==0){
			alert("请输入移交部门名称");
			_get('podeportationdepname').focus();
			return false;
	}
	}
	
	if(poindagaterepstate==3){
    if(!_get('poquashreason').checked){
	alert("请选择撤案理由");
	return false;
	}
}
	/** 
	if($("#poindagaterepreportdoc_").val()==''){
		alert("请上传调查终结报告书");
		$('#poindagaterepreportdoc_').focus();
		return false;
	}
	**/
	}

	if(trim(_get('ideacode').value).length==0){
		alert("请选择处理结果");
		_get('ideacode').focus();
		return false;
	}
	if(trim(_get('transcontent').value).length==0){
		alert("意见不能为空");
		_get('transcontent').focus();
		return false;
	}	

	return true;
}
function delPunish(item_id){
	 var size=${fn:length(listtranslaw)};	
	 if(size==1){
		 alert("当前有且只有一个处罚种类，不能直接删除，若需要重新选择处罚种类，请先添加新处罚种类，再删除！");
		 return false;
	 }else{
		 var href="punish/poindagaterepbasic!deletePunishClass.do?optProcInfo.ideacode=T&nodeInstId="+nodeinstid+"&punishobjectid="+punishobjectid+"&flowInstId="+flowinstid+"&item_id="+item_id+"&poindagaterepstate=0";
	     if(window.confirm("确定删除该处罚种类吗")){
		   window.location.href=href;
	     }
	 }
	
	
}

var _get = function (id) {
	return document.getElementById(id);
};

//字符空格处理
var trim = function (str) {
	return str.replace(/^\s+|\s+$/g, "");
};
</script>
</head>
<script type="text/javascript">
function _SelectItemByValue(objSelect, objItemText) {            
    //判断是否存在        
    //var isExit = false;        
    
  
    for (var i = 0; i < objSelect.options.length; i++) {        
        if (objSelect.options[i].value == objItemText) {        
            objSelect.options[i].selected = true;        
            //isExit = true;        0
            break;        
        }        
    } 
} 

function openNewWindow(winUrl,winName,winProps){
	if(winProps =='' || winProps == null){
		winProps = 'height='+(window.screen.availHeight-50) +',width='+window.screen.availWidth
		+',directories=false,location=false,top=0,left=0,menubar=false,Resizable=yes,scrollbars=yes,toolbar=false';
	}
	window.open(winUrl, winName, winProps);
}




//根据值设置select中的选项       
function _getSelectedItemLabel(objSelect) { 
	  if( objSelect.value=="B"){
		    _get('punishdecision').style.display="none";
		    _get('cfxmlb').style.display="none";   
		    _get('backtranscontent').style.display="block";
	  }
		    else if( objSelect.value=="T"){
		    	 _get('punishdecision').style.display="block";
		    	 _get('backtranscontent').style.display="none";
		    }
	  for (var i = 0; i < objSelect.options.length; i++) {  
		   if ( objSelect.options[i].selected) {  
		    document.getElementById("opiIdeacode").value=objSelect.options[i].value;
		    document.getElementById("transidea").value=objSelect.options[i].label;
		    break;
		  }
	  }
	  setH( parseInt(_get("getHeight").offsetHeight) );
}

function loadPunishTypeAjax(a,b){
	alert(a+b);
}

function zkp(){
	var punishobjectid="${object.punishobjectid}";
	var url="../punish/podetainwpbasicinfo!list.do?punishobjectid="+punishobjectid+"&s_punishobjectid="+punishobjectid;
	window.open(url, 'zkp', '');
}

</script>
<body>
	<s:form name="poindagaterepbasicForm" action="poindagaterepbasic"
		method="post" namespace="/punish" id="poindagaterepbasicForm"
		target="_parent" onsubmit="return checkForm();"
		enctype="multipart/form-data">
		<input type="hidden" id="flowInstId" name="flowInstId"
			value="${flowInstId}" />
		<input type="hidden" id="djId" name="optideainfo.djId"
			value="${object.punishobjectid}" />
		<input type="hidden" id="djId1" name="djId"
			value="${object.punishobjectid}" />
		<input type="hidden" id="punishobjectid" name="punishobjectid"
			value="${object.punishobjectid}" />
		<input type="hidden" id="nodeInstId" name="nodeInstId"
			value="${nodeInstId}">
		<input type="hidden" name="flag" value="2">
		<input type="hidden" name="nodename" value="${nodename}">
		<input type="hidden" name="makePCID">
		<input type="hidden" name="serial">
		<input type="hidden" name="selFreeUmpire">
		<input type="hidden" name="optideainfo.flowPhase" value="proof">

		<div id="getHeight">
			<fieldset style="display: block; padding: 10px;">
				<legend>
					<b>作出决定内容</b>
				</legend>
				<table cellpadding="0" cellspacing="0" class="viewTable">
					<tr>
						<td class="addTd" width="140">是否同意<font color="red">*</font></td>
						<td align="left"><input type="hidden"
							name="optProcInfo.transidea" value="${optProcInfo.transidea}"
							id="transidea"> <input type="hidden"
							name="optProcInfo.ideacode" id="opiIdeacode"
							value="${optProcInfo.ideacode}"> <select id="ideacode"
							name="ideacode" onchange="_getSelectedItemLabel(this)">
								<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('HDJXZCF_DCQZSH')}">
									<option value="${row.key}" label="${row.value}"
										<c:if test="${optProcInfo.ideacode eq row.key}"> selected = "selected" </c:if>>
										<c:out value="${row.value}" /></option>
								</c:forEach>
						</select></td>
					</tr>
					<tr height="20" id="punishdecision" style="display: none;">
						<td class="addTd" width="140">处罚决定</td>
						<td><s:radio listKey="key"
								cssStyle="margin-left:10px; border:0;"
								value="%{object.poindagaterepstate}" listValue="value"
								onclick="showpunishui(this.value)" id="poindagaterepstate"
								name="poindagaterepstate"
								list="#{'0':'行政处罚','1':'行政处理(整改)','2':'移交处理','3':'撤销立案'}" /></td>
					</tr>
					<tr height="20" id="backtranscontent">
						<td class="addTd" width="130">退回原因</td>
						<td><s:textarea name="optProcInfo.transcontent"
								style="width:100%;height:40px;"
								value="%{optProcInfo.transcontent}" /></td>
					</tr>
				</table>
				<table cellpadding="0" cellspacing="0">
				</table>
			</fieldset>
			<div id="cfxmlb">

				<!-- 处罚决定 -->
				<c:if test="${object.poindagaterepstate eq 0}">
					<fieldset style="padding: 10px">
						<legend>
							<b>处罚项目列表</b>
						</legend>
						<table cellpadding="0" cellspacing="0" class="">
							<c:forEach var="translaw" items="${listtranslaw}"
								varStatus="status">
								<input type="hidden" name="item_id"
									value="${translaw.vOrgSupPower.itemId}">
								<input type="hidden" id="version" name="version"
									value="${translaw.vOrgSupPower.version}">
								<input type="hidden" name="itemName"
									value="${translaw.vOrgSupPower.itemName}">
								<tr>
									<td colspan="4">
										<table cellpadding="0" cellspacing="0" class="viewTable">
											<tr>
												<td class="tableHeader" style="text-align: left;"><a
													href="javascript:furl(${status.index})" class="title"
													id="${status.index}" name="title">${translaw.vOrgSupPower.itemName}<span
														class="icc"></span></a> <img class="del"
													src="${pageContext.request.contextPath}/images/del.gif"
													alt="删除此项目"
													onclick="javascript:delPunish('${translaw.vOrgSupPower.itemId}');">
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td id="opt_${status.index}" style="display: none"
										name="optiton" class="optiton">
										<table cellpadding="0" cellspacing="0" class="viewTable">

											<tr>
												<td class="addTd">处罚项目代码</td>
												<td width="39%">
													&nbsp;&nbsp;${translaw.vOrgSupPower.itemId}</td>
												<td width="120" class="addTd">执法部门</td>
												<td width="39%">
													&nbsp;&nbsp;${cp:MAPVALUE("unitCode",translaw.vOrgSupPower.orgId)}</td>
											</tr>
											<tr>
												<td class="addTd">违反法律条款</td>
												<td colspan="3">${translaw.vOrgSupPower.punishbasis}
													<div align="right">
														<input type="hidden" id="punishbasis${status.index}"
															name="punishbasis"
															value="${translaw.vOrgSupPower.punishbasis}"> <input
															type="button" class="btn" value="法律依据"
															onclick="alertbasis(${status.index})" />
													</div>
												</td>
											</tr>
											<tr>
												<td class="addTd">*自由裁量列表</td>
												<td colspan="3"><select name="degreeNo"
													onchange="javascript:savedegree(${status.index},this.value,'${translaw.cid.item_id}','${translaw.vOrgSupPower.version}');">
														<option value="-1">--请选择违法程度--</option>
														<c:forEach var="degree" items="${translaw.degreelist}">
															<option value="${degree.cid.degreeno}"
																<c:if test="${translaw.degreeno eq degree.cid.degreeno}"> selected = "selected" </c:if>>
																<c:out value="${degree.punishfactgrade}" /></option>
														</c:forEach>
												</select></td>
											</tr>
											<tr>
												<td class="addTd">*处罚意见</td>
												<td colspan="3"><c:if test="${translaw.issurpass eq 1}">
														<input size="100" name="result" value="${translaw.result}">
													</c:if> <c:if test="${translaw.issurpass ne 1}">
														<input size="100" name="result" value="${translaw.result}">
													</c:if> &nbsp;&nbsp; <input type="button" class="btn" value="..."
													onClick="showFreeUmpireList(${status.index})" /></td>
											</tr>
										</table>
							</c:forEach>
						</table>

						<div align="center">
							<input type="button" valign="center" class='btn'
								name="addPunishItem"
								onClick="openNewWindow('<%=request.getContextPath()%>/punish/poindagaterepbasic!addpunishlist.do?punishobjectid=${object.punishobjectid}&nodeInstId=${nodeInstId}&flowInstId=${flowInstId}&itemType=CF&s_itemType=CF&s_orgId=${session.SPRING_SECURITY_CONTEXT.authentication.principal.primaryUnit}','powerWindow',null);"
								value="添加">
						</div>

					</fieldset>
					<fieldset style="padding: 10px">
						<legend>
							<b>最终处罚信息</b>
						</legend>
						<table cellpadding="0" cellspacing="0" align="center"
							class="viewTable">
							<tr>
								<td class="addTd">其他违法条款</td>
								<td align="left"><s:textarea name="disobeyitem" cols="80"
										rows="3" style="width:100%;" /></td>
							</tr>

							<tr
								<c:if test="${fn:length(listtranslaw)<2}">style="display:none"</c:if>>
								<td class="addTd">最终处罚信息</td>
								<td align="left"><input type="text" size="100"
									name="poindagaterepresult"
									value="${object.poindagaterepresult}"
									style="width: 90%; height: 24px" /> <input type="button"
									class='btn' value="..."
									onclick="javascript:showFreeUmpireList('${fn:length(listtranslaw)}');" />
								</td>
							</tr>
							<!-- 
		<tr>
					<td class="addTd">调查终结报告书<font color="red">*</font></td>
					<td align="left">
					<s:file id="poindagaterepreportdoc_" name="poindagaterepreportdoc_" style="width:60%;height:30px;"/></td>
					
				</tr>
				 -->
							</c:if>
							<!-- 行政处理(整改) -->
							<c:if test="${object.poindagaterepstate eq 1}">
								<fieldset style="padding: 10px">
									<legend>
										<b>行政处理(整改)信息</b>
									</legend>
									<table cellpadding="0" cellspacing="0" class="table_b">
										<tr height="20">
											<td class="addTd">*整改内容</td>
											<td><s:textarea id="poneatencontent"
													name="poneatencontent" style="width:80%;height:50px;" /></td>
										</tr>

										</c:if>
										<!-- 移交处理-->
										<c:if test="${object.poindagaterepstate eq 2}">

											<fieldset style="padding: 10px">
												<legend>
													<b>移交处理信息</b>
												</legend>
												<table cellpadding="0" cellspacing="0" class="table_b">
													<tr height="20">
														<td class="addTd">*移交部门名称</td>
														<td><input type="text" id="podeportationdepname"
															name="podeportationdepname" size="80" /></td>
													</tr>
													<tr height="20">
														<td class="addTd">备注</td>
														<td><s:textarea name="remark"
																style="width:80%;height:50px;" /></td>
													</tr>

													</c:if>

													<!-- 撤销立案-->
													<c:if test="${object.poindagaterepstate eq 3}">
														<fieldset style="padding: 10px">
															<legend>
																<b>撤销立案</b>
															</legend>
															<table cellpadding="0" cellspacing="0" align="center"
																class="table_b">
																<tr>
																	<td class="addTd">撤销立案原因</td>
																	<td><s:checkboxlist
																			list="#{'1':'情节轻微且已改正','2':'违法事实不能成立'}"
																			id="poquashreason" name="poquashreason"></s:checkboxlist>
																	</td>
																<tr>
																<tr>
																	<td class="addTd">其他原因</td>
																	<td><s:textarea name="otherreason"
																			style="width:80%;height:50px;" /></td>
																</tr>


																</c:if>

																<c:if test="${!empty object.poindagaterepstate }">
																	<tr>
																		<td class="addTd" width="130">是否风险点</td>
																		<td align="left"><s:radio
																				name="optProcInfo.isrisk" list="#{'T':'是','F':'否'}"
																				value="%{optProcInfo.isrisk}" listKey="key"
																				listValue="value" /></td>
																	<tr>
																		<td class="addTd" width="130">风险类别</td>
																		<td align="left"><s:textfield
																				name="optProcInfo.risktype" size="60"
																				value="%{optProcInfo.risktype}" /></td>
																	</tr>
																	<tr>
																		<td class="addTd" width="130">风险描述</td>
																		<td align="left" colspan="3"><s:textarea
																				name="optProcInfo.riskdesc"
																				style="width:100%;height:40px;"
																				value="%{optProcInfo.riskdesc}" /></td>
																	</tr>
																	<tr>
																		<td class="addTd">风险内控手段与结果</td>
																		<td align="left" colspan="3"><s:textarea
																				name="optProcInfo.riskresult"
																				value="%{optProcInfo.riskresult}"
																				style="width:100%;height:40px;" /></td>
																	</tr>
															</table>
														</fieldset>
													</c:if>
													</div>
													<center style="margin-top: 10px;">
														<span style="display: none;"> <s:submit
																id="submitBtn" name="saveAndSubmit"
																method="saveProofResult" cssClass="btn" value="提 交" />
														</span> <span style="display: none;"> <input id="backBtn"
															type="button" value="返回" class="btn"
															onclick="window.history.go(-1);" />
														</span>
													</center>
													</s:form>
													</div>
</body>
<script type="text/javascript">

window.parent.hiddSaveBtn();
var nodeinstid=_get("nodeInstId").value;
var punishobjectid=_get("djId").value;
var flowinstid=_get("flowInstId").value;
function selectPopWin(json,o1,o2 ){
	new person(json,o1,o2).init();
	setAlertStyle("attAlert");
}
function openNewWindow(winUrl,winName,winProps){
	if(winProps =='' || winProps == null){
		winProps = 'height=600px,width=700px,directories=false,location=false,top=100,left=500,menubar=false,Resizable=yes,scrollbars=yes,toolbar=false';
	}
	window.open(winUrl, winName, winProps);
}

function showFreeUmpireList(i){	
	  var item_id;
	  var id;
	  var degreeNo;
	  var size=${fn:length(listtranslaw)};	  
	  if(size==i){
	    item_id="00000000";
	    document.poindagaterepbasicForm.serial.value="-1";
	    degreeNo="-2";
	  }else{
	    document.poindagaterepbasicForm.serial.value=i;
	    if(size==1){
	       item_id=document.poindagaterepbasicForm.item_id.value;
	       degreeNo=document.poindagaterepbasicForm.degreeNo.value;
	     }else{
	       item_id=document.poindagaterepbasicForm.item_id[i].value;
	       degreeNo=document.poindagaterepbasicForm.degreeNo[i].value;
	     }
	  }
	
	      if(item_id=="00000000"){
	       if(isAll("degreeNo","-1")!=-1){
	          if(size==1){
	            alert("\""+document.poindagaterepbasicForm.itemName.value+"\"项目没有选择自由裁量，不能做出最终处罚意见");
	          }else{
	            var lock=isAll("degreeNo","-1");
	            alert("\""+document.poindagaterepbasicForm.itemName[lock].value+"\"项目没有选择自由裁量，不能做出最终处罚意见");
	          }
	          return;
	       }
	       
	       if(isAll("result","")!=-1){
	          if(size==1){
	            alert("\""+document.poindagaterepbasicForm.itemName.value+"\"项目没有做出相应的处罚意见，不能做出最终处罚意见");
	          }else{
	            var lock=isAll("result","");
	            alert("\""+document.poindagaterepbasicForm.itemName[lock].value+"\"项目没有做出相应的处罚意见，不能做出最终处罚意见");
	          }
	          return;
	       }	       
	       if(size==1){
	          if(document.poindagaterepbasicForm.result.value.indexOf('(')>-1){
	            alert("\""+document.poindagaterepbasicForm.itemName.value+"\"项目的罚款为具体数目，请重新做出该项目处罚意见，不能做出最终处罚意见");
	            return;
	          }
	        }else{
	          var x=0;
	          for(;x<document.poindagaterepbasicForm.result.length;){
	            if(document.poindagaterepbasicForm.result[x].value.indexOf('(')>-1){
	               alert("\""+document.poindagaterepbasicForm.itemName[x].value+"\"项目的罚款为具体数目，请重新做出该项目处罚意见，不能做出最终处罚意见");
	               break;
	            }
	            x++;
	          }
	          if(size!=x){
	             return;
	          }
	       }
	    }else{	    	
	     if(degreeNo=="-1"){
	      alert("您还没有选择该项目的自由裁量，不能确定处罚意见");
	      return;
	     }_get
	   }
	  
	      var punishobjectid="${object.punishobjectid}";    	      
	      var url="${pageContext.request.contextPath}/punish/poindagaterepbasic!gavePunishOpinion.do?optProcInfo.ideacode=T&punishobjectid="+punishobjectid+"&item_id="+item_id+"&degreeno="+degreeNo+"&serial="+i;	
	    //openNewWindow(url,'powerWindow',null);
	     id=window.showModalDialog(url,window,"dialogHeight:450px;dialogWidth:850px;center:yes;help:yes;scroll:yes;status:yes;edge:raised");
	 
	   if(id!=""){
		    document.poindagaterepbasicForm.selFreeUmpire.value=id;
		    if(id!=null){
		    id= id.replaceAll ("&","@");
		    }
		   }
		   
		   if(document.poindagaterepbasicForm.selFreeUmpire.value=="undefined"){
		      return;
		   }

	   var poindagaterepstate =_get("poindagaterepstate").value;
	    var version =_get("version").value;
	    var href="";
	   // alert(degreeNo);
	    if(degreeNo!='-2'){
	    href="${pageContext.request.contextPath}/punish/poindagaterepbasic!savepunishinfo.do?optProcInfo.ideacode=T&nodeInstId=${nodeInstId}&flowInstId=${flowInstId}&punishobjectid="+punishobjectid+"&item_id="+item_id+"&version="+parseInt(version)+"&degreeno="+degreeNo+"&serial="+i+"&poindagaterepstate="+poindagaterepstate+"&selFreeUmpire="+id;
	    }else{
	    href="${pageContext.request.contextPath}/punish/poindagaterepbasic!savepunishinfo.do?optProcInfo.ideacode=T&nodeInstId=${nodeInstId}&flowInstId=${flowInstId}&punishobjectid="+punishobjectid+"&item_id="+item_id+"&degreeno="+degreeNo+"&serial="+i+"&selFreeUmpire="+id+"&poindagaterepstate="+poindagaterepstate;
	    }
	    //alert(href);
		window.location.href=href;
	}
	
	
	function alertbasis(i){
		var id="punishbasis"+i;
		alert(document.getElementById(id).value);
	}
	
function isAll(type,value){
	  var i=-1;
	  var obj = eval("document.poindagaterepbasicForm." + type);
	  var size=${fn:length(listtranslaw)};	  
	  if(size==1){
	     var val = obj.value;
	     if(val==value){
	        i=0;
	     }
	  }else{
	    for(var j=0;j<obj.length;j++){
	      var val = obj[j].value;
	      if(val==value){
	        i=j;
	        break;
	     }
	    }
	  }
	  return i;
	}
String.prototype.replaceAll = function(s1,s2) {

    return this.replace(new RegExp(s1,"gm"),s2);
};
window.onload = function(){
	setH( parseInt(_get("getHeight").offsetHeight)+10 );
};
</script>
</html>