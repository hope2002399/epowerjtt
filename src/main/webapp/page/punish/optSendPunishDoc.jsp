<%@page import="com.goldgrid.weboffice.TemplateService"%>
<%@ page contentType="text/html;charset=UTF-8"  import="java.util.*" %>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>办理信息</title>
<sj:head locale="zh_CN" />
<script type="text/javascript">
function checkForm(){
	//alert($("#bjUserNames").val());
	if($("#curTemplateId").val()==''){
		alert("文书不能为空!");
		return false;
	}
	if($("#bjUserNames").val()==''){
		alert("送达人员不可为空！");
		$('#bjUserNames').focus();
		return false;
	}
	
	if($("#bjUserNames").val()!=''){
		var opertator=$("#bjUserNames").val().split(",");
		//alert(opertator.length);
		if(opertator.length<2){
			alert("送达人员至少选择两位！");
			$('#bjUserNames').focus();
			return false;	
		}		
	}
	
	if($("#signinedname").val()==''){
		alert("签收人员姓名不可为空！");
		$('#signinedname').focus();
		return false;
	}
	
	if($("#poreceiptdoc_").val()==''){
		alert("请上传送达回执扫描件！");
		$('#poreceiptdoc_').focus();
		return false;
	}
	
	return true;
}
</script>
</head>
<script type="text/javascript">
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
</script>
<body>
<s:form action="poreceiptinfo" method="post" namespace="/punish" id="generalOperatorForm" target="_parent"  onsubmit="return checkForm();" enctype="multipart/form-data">
<input type="hidden" id="flowInstId" name="flowInstId" value="${flowInstId}" />
<input type="hidden" id="djId" name="djId"  value="${object.punishobjectid}" />
<input type="hidden" id="punishobjectid" name="punishobjectid"  value="${object.punishobjectid}" />
<input type="hidden" id="nodeInstId" name="nodeInstId" value="${nodeInstId}">
<input type="hidden" id="poreceiptstate" name="poreceiptstate" value="${object.poreceiptstate}">
<s:hidden name="flowPhase" value="%{flowPhase}"/>

<fieldset style=" display: block; padding: 10px;">
			<legend>
				<b>${nodeName }</b>
			</legend>
			<table border="0" cellpadding="0" cellspacing="0" id="tb" class="viewTable" style="margin-top: 20px;">			
						<input type="hidden" name="optProcInfo.transidea" value="同意" id="transidea">
						<input type="hidden" name="optProcInfo.transcontent" value="发放文书回执" id="transcontent">
						<!-- <input type="hidden" id="ideacode"  name="ideacode" value="1">	 -->				
				<tr>
				<td colspan="4">
				<div align="center">
				<input type="hidden" id="curTemplateId" name="curTemplateId"  value="" />
<%-- 	<c:if test="${object.poreceiptstate eq 2}">
	<a href="javascript:void(0);" onclick="openTemplate('1365315532906','cf_jds');" class="btnA"><span class="btn">处罚决定书</span></a>
	<a href="javascript:void(0);" onclick="openTemplate('1365392543937','cf_cfjdshz');" class="btnA"><span class="btn">处罚决定书回执</span></a>
	</c:if>
	<c:if test="${object.poreceiptstate eq 1}">
	<a href="javascript:void(0);" onclick="openTemplate('1365298102001','cf_yxgz');" class="btnA"><span class="btn">预先告知书</span></a>
	<a href="javascript:void(0);" onclick="openTemplate('1365298164797','cf_yxgzshz');" class="btnA"><span class="btn">预先告知书回执</span></a>
		
	</c:if> --%>
		<!-- 从流程节点配置中加载文书模版 -->
			<c:if test="${templateFromNode eq 'TRUE'}">
						<c:forEach var="temp" items="${templateFileList}">	
						<input type="hidden" id="archivetypes" name="archivetypes"  value="${temp.tempType}" />
									<a href="javascript:void(0);" onclick="openTemplate('${temp.recordId}','${temp.tempType}');" class="btnA">
									<span id="ws" class="btn">
									<c:choose>
					<c:when test="${fn:length(temp.descript) > 10}">
						<c:out value="${fn:substring(temp.descript, 0, 10)}..." />
					</c:when>
					<c:otherwise>
						<c:out value="${temp.descript}" />
					</c:otherwise>
				</c:choose>
									</span></a>
								</c:forEach>
		</c:if>			
	</div>
				</td>
				</tr>
					<tr>
					<td class="addTd" width="140">送达方式</td>
					<td align="left" colspan="3">
						<select id="receiptmodel"  name="receiptmodel">
							<c:forEach var="row" items="${cp:DICTIONARY('receiptModel')}">
								<option value="${row.key}" label="${row.value}"  
								<c:if test="${object.receiptmodel eq row.key}"> selected = "selected" </c:if>
								>
								<c:out value="${row.value}" /></option>
							</c:forEach>
							</select>
					</td>
				</tr>
					<tr id="JBR">
					<td class="addTd">送达人员<font color="red">*</font></td>
					<td align="left" colspan="3" >
							<input type="text" id="bjUserNames" name="operatorname" style="width:60%;height:30px;" value="${bjUserNames}"  readonly="readonly" />
							<input type="hidden" id="bjCodes" name="teamRoles" value="${teamRoleCode}" />							
					</td>
					</tr>		
				<tr>
					<td class="addTd">签收人员姓名<font color="red">*</font></td>
					<td align="left" colspan="3">
						<s:textarea id="signinedname"
								name="signinedname" style="width:100%; height:40px;" value="%{object.signinedname}"/>
					</td>
				</tr>
				<tr>
					<td class="addTd">签收时间</td>
					<td align="left" colspan="3">
							<sj:datepicker id="signineddate" value="%{object.signineddate}"
							name="signineddate"  style="width:120px"
							yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" readonly="true"/>
					</td>
				</tr>
			<tr>
				<td class="addTd" width="130">上传送达回执扫描件<font color="red">*</font></td>
				<td align="left" colspan="3"><s:file id="poreceiptdoc_" name="poreceiptdoc_" style="width:60%;"/> 
			</td>
			</tr>
				<tr>
						<td class="addTd" width="130">是否风险点</td>
				<td align="left"><s:radio name="optProcInfo.isrisk"
						list="#{'T':'是','F':'否'}" value="%{optProcInfo.isrisk}" listKey="key" listValue="value"/></td>
					<td class="addTd" width="130">
						风险类别
					</td>
					<td align="left">
					<s:textfield name="optProcInfo.risktype"
						size="60" value="%{optProcInfo.risktype}"/>
					</td>
				</tr>	
				<tr>
					<td class="addTd" width="130">
						风险描述
					</td>
					<td align="left" colspan="3">
					<s:textarea name="optProcInfo.riskdesc"
						style="width:100%;height:40px;" value="%{optProcInfo.riskdesc}"/>
					</td>
				</tr>
				<tr>
					<td class="addTd">
						风险内控手段与结果	
					</td>
					<td align="left" colspan="3">
						<s:textarea name="optProcInfo.riskresult"  value="%{optProcInfo.riskresult}" style="width:100%;height:40px;" />
					</td>
				</tr>	
		       		
			</table>
		</fieldset>
		
		<center style="margin-top: 10px;">
		<span style="display:none;" >
			<s:submit name="saveAndSubmit" method="receiptModelSubmitOpt" cssClass="btn" value="提 交" id="submitBtn"/>
			</span>
			<span style="display:none;" >
			<s:submit name="save" method="saveOpt" cssClass="btn" value="保 存" id="saveBtn"/>
			</span>
			<span style="display:none;" >	
			<input type="button" value="返回" class="btn"  onclick="window.history.go(-1);" id="backBtn"/>
			</span>	
		</center>
		</s:form>	
</body>
<script type="text/javascript">
//从流程节点配置中加载文书模版
function openTemplate(recordId,tempType){
		openDocEdit(recordId,tempType);
}

//选择模版上传文档
function openDocEdit(val,documentType){	
	var archiveType =documentType;
	var uri = "<%=request.getContextPath()%>/iWebOffice/DocumentEdit.jsp";
	var param = "flowStep=ZW_EDIT&RecordID=${object.punishobjectid}&Template=" + val +"&archiveType="+archiveType
	 			+"&NeedBookMark=1";
	openNewWindow(uri + "?"+ param,'editForm','');
}

$("#bjUserNames").click(function(){
	var s = '${userjson}';
	if(s.trim().length){
		window.parent.selectPopWin(jQuery.parseJSON(s),$("#bjUserNames"),$("#bjCodes"));
	};
});
</script>
<script type="text/javascript">
	window.parent.hiddSaveBtn();
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