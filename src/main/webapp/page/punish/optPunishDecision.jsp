<%@page import="com.goldgrid.weboffice.TemplateService"%>
<%@ page contentType="text/html;charset=UTF-8"  import="java.util.*" %>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>办理信息</title>
<script type="text/javascript">
function checkForm(){
	if($("#transcontent").val()==''){
		alert("意见不能为空");
		$('#transcontent').focus();
		return false;
	}	
	
/* 	if($("#bjUserNames").val()==''){
		alert("审批人员不可为空！");
		$('#bjUserNames').focus();
		return false;
	}
	
	if($("#bjUserNames").val()!=''){
		var opertator=$("#bjUserNames").val().split(",");
		if(opertator.length<2){
			alert("审批人员至少选择两位！");
			$('#bjUserNames').focus();
			return false;	
		}		
	} */
	return true;
}
</script>
</head>
<script type="text/javascript">
function openNewWindow(winUrl,winName,winProps){
	if(winProps =='' || winProps == null){
		winProps = 'height='+(window.screen.availHeight-50) +',width='+window.screen.availWidth
		+',directories=false,location=false,top=0,left=0,menubar=false,Resizable=yes,scrollbars=yes,toolbar=false';
	}
	window.open(winUrl, winName, winProps);
}
</script>
<body>
<s:form action="punishobjectbasic" method="post" namespace="/punish" id="generalOperatorForm" target="_parent" onsubmit="return checkForm();">
<input type="hidden" id="flowInstId" name="flowInstId" value="${flowInstId}" />
<input type="hidden" id="djId" name="djId"  value="${object.punishobjectid}" />
<input type="hidden" id="punishobjectid" name="punishobjectid"  value="${object.punishobjectid}" />
<input type="hidden" id="nodeInstId" name="nodeInstId" value="${nodeInstId}">
<s:hidden name="flowPhase" value="%{flowPhase}"/>

<fieldset style=" display: block; padding: 10px;">
			<legend>
				<b>处罚决定经办人意见</b>
			</legend>
			<table border="0" cellpadding="0" cellspacing="0" id="tb" class="viewTable" style="margin-top: 20px;">			
						<input type="hidden" name="optProcInfo.transidea" value="同意" id="transidea">
						<!-- <input type="hidden" id="ideacode"  name="ideacode" value="1">	 -->				
				<tr>
					<td class="addTd">经办人意见<font color="red">*</font></td>
					<td align="left" colspan="3">
						<s:textarea id="transcontent"
								name="optProcInfo.transcontent" style="width:100%; height:40px;" value="%{optProcInfo.transcontent}"/>
					</td>
				</tr>
				<tr id="JBR">
					<td class="addTd">下一步办理人员</td>
					<td align="left" colspan="3" >
					${nextOperaters}
							<%-- <input type="text" id="bjUserNames" name="bjUserNames" style="width:60%;height:30px;" value="${bjUserNames}"  readonly="readonly" />
							<input type="hidden" id="bjCodes" name="teamRoles" value="${teamRoleCode}" />
							<input type="hidden" id="roleCode" name="roleCode" value="${roleCode}" /> --%>
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
			<s:submit name="saveAndSubmit" method="submitPunishDecisionOpt" cssClass="btn" value="提 交" id="submitBtn"/></span><span style="display:none;" >
			<s:submit name="save" method="saveOpt" cssClass="btn" value="保 存" id="saveBtn"/></span><span style="display:none;" >		
			<input type="button" value="返回" class="btn"  onclick="window.history.go(-1);" id="backBtn"/>	</span>
		</center>
		</s:form>	
</body>
<script type="text/javascript">

$("#bjUserNames").click(function(){
	var s = '${userjson}';
	if(s.trim().length){
		window.parent.selectPopWin(jQuery.parseJSON(s),$("#bjUserNames"),$("#bjCodes"));
	};
});

</script>
</html>