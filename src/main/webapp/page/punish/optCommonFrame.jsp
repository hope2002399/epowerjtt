<%@page import="com.goldgrid.weboffice.TemplateService"%>
<%@ page contentType="text/html;charset=UTF-8"  import="java.util.*" %>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>办理信息</title>
<script type="text/javascript">
function checkForm(){
	if(trim(_get('ideacode').value).length==0){
		alert("请选择处理结果。");
		_get('ideacode').focus();
		return false;
	}
	if(trim(_get('transcontent').value).length==0){
		alert("意见不能为空。");
		_get('transcontent').focus();
		return false;
	}
	
	if(_get('bjCodes') != undefined && '${moduleParam.assignTeamRole}' == 'T'){
		if($("#ideacode").val()== 'T' || $("#ideacode")==undefined){
		if($("#bjUserNames").val()==''){
			alert("${moduleParam.teamRoleName}不能为空。");			
			return false;
		}
		if($("#bjUserNames").val()!=''){
			var opertator=$("#bjUserNames").val().split(",");
			if(opertator.length<2){
				alert("${moduleParam.teamRoleName}至少选择两位！");
				$('#bjUserNames').focus();
				return false;	
			}		
		}
		}
		
		
	}
	
	if(_get('curTemplateId') != undefined && '${moduleParam.hasDocument}' == 'T' ){
		if($("#ideacode").val()== 'T' || $("#ideacode")==undefined){
		if(trim(_get('curTemplateId').value).length==0){
			alert("${moduleParam.documentLabel}不能为空。");
			return false;
		}
	}
	}
	return true;
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
//var optBaseInfoJson = ${optBaseInfoJson};
function _SelectItemByValue(objSelect, objItemText) {            
    //判断是否存在        
    //var isExit = false;        
    for (var i = 0; i < objSelect.options.length; i++) {        
        if (objSelect.options[i].value == objItemText) {        
            objSelect.options[i].selected = true;        
            //isExit = true;        
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

function openTemplate(val,documentType){
	if(val  == '' || val == null){
		return;
	}
	/* alert(val); */
	var tempArr =val.split(',');
	var recordId=tempArr[0];
	var tempType=tempArr[1];
	
	/* alert(recordId);
	alert(tempType); */
	var curTemplateId = document.getElementById("curTemplateId").value;
	if (curTemplateId != "" && curTemplateId != null) {
		if(window.confirm("重新选择模板会生成新的文件，已保存的内容将被覆盖，是否确定？")){
			openDocEdit(recordId,tempType);
		}
	}else{
		openDocEdit(recordId,tempType);
	}
}


//选择模版上传文档
function openDocEdit(val,documentType){
	var archiveType =documentType;
	var uri = "<%=request.getContextPath()%>/iWebOffice/DocumentEdit.jsp";
	var param = "flowStep=ZW_EDIT&RecordID=${object.punishobjectid}&Template=" + val +"&archiveType="+archiveType
	 			+"&NeedBookMark=1";
	openNewWindow(uri + "?"+ param,'editForm','');
}

//修改文档
function updtDoc(documentType){
	var archiveType =documentType;
	var curTemplateId = document.getElementById("curTemplateId").value;
	if (curTemplateId != "" && curTemplateId != null) {
		var uri = "<%=request.getContextPath()%>/iWebOffice/DocumentEdit.jsp";
		var param = "flowStep=ZW_EDIT&RecordID=${object.punishobjectid}&EditType=2,1&ShowType=1&Template=" + curTemplateId+"&archiveType="+documentType;
		openNewWindow(uri + "?"+ param,'editForm','');
	} else {
		alert("请生成您需要的文书！！");
	}
}

//根据值设置select中的选项       
function _getSelectedItemLabel(objSelect) {            
    //判断是否存在        
    //var isExit = false;        
	   for (var i = 0; i < objSelect.options.length; i++) {        
	        if ( objSelect.options[i].selected) {        	
	        	if(objSelect.options[i].value==''){
	        		document.forms[0].transcontent.value='';
	        		alert("请选择受理意见!");
	        		_get('ideacode').focus();	        		
	        	}else{
	        		document.forms[0].transcontent.value=objSelect.options[i].id;
	        		if(_get('JBR') != undefined && '${moduleParam.assignTeamRole}' == 'T' ){
	        		if(objSelect.options[i].value=='T'){
	            		document.getElementById("JBR").style.display = "block";
	            	}else{
	            		document.getElementById("JBR").style.display = "none";	            		
	            	}
	        		}
	        		
	        		if(_get('documentID') != undefined && '${moduleParam.hasDocument}' == 'T' ){
		        		if(objSelect.options[i].value=='B'){
		            		document.getElementById("documentID").style.display = "none";
		            	}else{
		            		document.getElementById("documentID").style.display = "block";	            		
		            	}
		        		}
	        	}
	        	document.getElementById("transidea").value=objSelect.options[i].label;
	        	document.getElementById("opiIdeacode").value=objSelect.options[i].value;
	        	//alert('transidea'+objSelect.options[i].id);
	        	//alert('opiIdeacode'+objSelect.options[i].value);
	            break;        
	        }        
	    }  
}

//从流程节点配置中加载文书模版 
function openDocNodeEdit(val,documentType){
	var archiveType =documentType;
	var uri = "<%=request.getContextPath()%>/iWebOffice/DocumentEdit.jsp";
	var param = "flowStep=ZW_EDIT&RecordID=${djId}&Template=" + val +"&archiveType="+archiveType
	 			+"&NeedBookMark=1";	
	openNewWindow(uri + "?"+ param,'editForm','');
}
</script>
<body>
<s:form action="%{actionName}" method="post" namespace="/punish" target="_parent" onsubmit="return checkForm();">
<input type="hidden" id="flowInstId" name="flowInstId" value="${flowInstId}" />
<input type="hidden" id="djId" name="djId"  value="${object.punishobjectid}" />
<input type="hidden" id="punishobjectid" name="punishobjectid"  value="${object.punishobjectid}" />
<input type="hidden" id="nodeInstId" name="nodeInstId" value="${nodeInstId}">
<input type="hidden" name="optProcInfo.transidea" value="${optProcInfo.transidea}" id="transidea">
<input type="hidden" name="optProcInfo.cfType" value="${optProcInfo.cfType}">
<input type="hidden" name="cfType" value="${optProcInfo.cfType}">
<input type="hidden" id="flowPhase" name="flowPhase" value="${flowPhase}" />

<fieldset style=" display: block; padding: 10px;">
			<legend>
				<b>办理信息- ${nodeName}</b>
			</legend>
			<table border="0" cellpadding="0" cellspacing="0" id="tb" class="viewTable" style="margin-top: 20px;">
				<tr>
					<td class="addTd" width="140">${moduleParam.ideaLabel}<font color="red">*</font></td>
					<td align="left">
						<input type="hidden" name="optProcInfo.ideacode" id="opiIdeacode" value="${optProcInfo.ideacode}">
						<select id="ideacode"  name="ideacode" onchange="_getSelectedItemLabel(this)">
						<option VALUE="" >---请选择---</option>
							<c:forEach var="row" items="${cp:DICTIONARY(moduleParam.ideaCatalog)}">
								<option value="${row.key}" label="${row.value}" id="${row.datadesc}" <c:if test="${optProcInfo.ideacode==row.key}">selected="selected"</c:if>>
									<c:out value="${row.datadesc}" />
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				
				<tr>
					<td class="addTd">${moduleParam.ideaContent}<font color="red">*</font></td>
					<td align="left">
						<s:textarea id="transcontent"
								name="optProcInfo.transcontent" style="width:100%; height:40px;" value="%{optProcInfo.transcontent}"/>
					</td>
				</tr>
				<c:if test="${moduleParam.hasAttention eq 'T' }">
					<tr>
					<td class="addTd">${moduleParam.attentionLabel}</td>
					<td align="left">
							<input type="text" id="attUserNames" name="attUserNames" readonly="readonly" style="width:100%;" value="${attUserNames}"  />
							<input type="hidden" id="attUserCodes" name="attUserCodes" value="${attUserCodes}" />
							<input type="hidden" id="attType" name="optProcAttention.attType" value="1" />
					</td>
					</tr>
				</c:if>
		        <!-- 办件角色 -->
				<c:if test="${moduleParam.assignTeamRole eq 'T' }">
					<tr id="JBR">
					<td class="addTd">${moduleParam.teamRoleName}<font color="red">*</font></td>
					<td align="left">
							<input type="text" id="bjUserNames" name="bjUserNames" style="width:60%;height:30px;" value="${bjUserNames}"  readonly="readonly" />
							<input type="hidden" id="bjCodes" name="teamRoles" value="${teamUserCodes}" />
							<input type="hidden" id="roleCode" name="roleCode" value="${moduleParam.teamRoleCode}" />
					</td>
					</tr>
				</c:if>
				
				<c:if test="${moduleParam.hasDocument eq 'T' }">
					<tr id="documentID">
						<td class="addTd">${moduleParam.documentLabel}</td>
						<td align="left">
							<select id="recordId" name="recordId" onchange="openTemplate(this.value,'${moduleParam.documentType}');">
							 	<option value="">--请选择--</option>
								<c:forEach var="temp" items="${templateList}">
									<option value="${temp.recordId},${temp.tempType}">
									<c:out value="${temp.descript}" /></option>
								</c:forEach>
							</select>
							&nbsp;&nbsp;<input type="button" id="modifyDoc" onclick="updtDoc('${moduleParam.documentType}');" value="修改正文" class="btn processBtn" />
							<input type="hidden" id="curTemplateId" name="curTemplateId"  value="" />
					   </td>
					</tr>
				</c:if>
				<!-- 从流程节点配置中加载文书模版 -->
				<c:if test="${ templateFromNode eq 'TRUE'}">
					<tr>
						<td class="addTd" width="140">文书</td>
						<td align="left">			
								<c:forEach var="temp" items="${templateFileList}">							
									<a href="javascript:void(0);" onclick="openDocNodeEdit('${temp.recordId}','${temp.tempType}');" class="btnA">
									<span id="ws" class="btn">
									<c:choose>
					<c:when test="${fn:length(temp.descript) > 8}">
						<c:out value="${fn:substring(temp.descript, 0, 8)}..." />
					</c:when>
					<c:otherwise>
						<c:out value="${temp.descript}" />
					</c:otherwise>
				</c:choose>
									</span></a>
								</c:forEach>				
					   </td>
					</tr>
				</c:if>
				<c:if test="${moduleParam.riskId !=null && moduleParam.riskId !=0}">
				<input type="hidden" id="risktype" name="optProcInfo.risktype"  value="${moduleParam.riskInfo.risktype}" />
				<input type="hidden" id="riskdesc" name="optProcInfo.riskdesc"  value="${moduleParam.riskInfo.riskdes}" />
			<tr>
					<td class="addTd" width="130">
						风险类别
					</td>
					<td align="left">
						    ${cp:MAPVALUE("RISKTYPE",moduleParam.riskInfo.risktype)}
					</td>
				</tr>	
				<tr>
					<td class="addTd" width="130">
						风险描述
					</td>
					<td align="left">${moduleParam.riskInfo.riskdes}
					</td>
				</tr>
				
				<tr>
					<td class="addTd">
						风险内控手段与结果	
					</td>
					<td align="left">
						<s:textarea name="optProcInfo.riskresult"  value="%{moduleParam.riskInfo.riskdeal}" style="width:100%;height:40px;" />
					</td>
				</tr>			
				
				</c:if>
				
			<c:if test="${moduleParam.hasStuff eq 'T' }">
					<tr>
					<td colspan="2" style="padding-bottom:8px;">
						<iframe id="basicsj"  name="sjfj"
								src="" width="100%" height=""
							frameborder="no" scrolling="false" border="0" marginwidth="0"
							marginheight="0"></iframe>
					</td></tr>
				
			</c:if>
			</table>
		</fieldset>
		<center style="margin-top: 10px;">
		<span style="display:none;" >
			<s:submit id="submitBtn" name="saveAndSubmit" method="%{submitOptURI}" cssClass="btn" value="提 交" />
			</span>
		<span style="display:none;" >	
			<s:submit id="saveBtn" name="save" method="%{saveOptURI}" cssClass="btn" value="保 存" />
		</span>
		<span style="display:none;" >	
			<input id="backBtn" type="button" value="返回" class="btn"  onclick="window.history.go(-1);"/>	
		</span>
		</center>
		</s:form>
</body>

<!-- <script type="text/javascript">
var url='powerruntime/generalOperator!gotosqcl.do?stuffInfo.djId=${djId}&stuffInfo.nodeInstId=${nodeInstId}&stuffInfo.groupid=${moduleParam.stuffGroupId}';
var obj = document.getElementById("basicsj");
obj.src = url;
obj.onload = function(){
	obj.style.height = window.frames['sjfj'].document.body.scrollHeight+"px";
};
</script> -->
<script type="text/javascript">


$("#attUserNames").click(function(){
	var s = '${attentionJson}';
	if(s.trim().length){
		window.parent.selectPopWin(jQuery.parseJSON(s),$("#attUserNames"),$("#attUserCodes"));
	}
});

$("#bjUserNames").click(function(){
	var d = '${userjson}';
	if(d.trim().length){
		window.parent.selectPopWin(jQuery.parseJSON(d),$("#bjUserNames"),$("#bjCodes"));
	};
});

</script>

<script type="text/javascript">

function getOptBaseInfoJson(){	
	return getOptCommonBizJson();
}

function getOptCommonBizJson(){
	return ${optCommonBizJson};
}
</script>
</html>