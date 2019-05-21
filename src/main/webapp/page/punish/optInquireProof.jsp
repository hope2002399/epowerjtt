<%@page import="com.goldgrid.weboffice.TemplateService"%>
<%@ page contentType="text/html;charset=UTF-8"  import="java.util.*" %>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>办理信息</title>
<script type="text/javascript">
function checkForm(){
	if($("#confirmtruth").val()==''){
		alert("认定违法事不可为空！");
		$("#confirmtruth").focus();
		return false;
	}	
	return true;
}

</script>
</head>

<body>
<s:form action="poindagaterepbasic" method="post" namespace="/punish" id="poindagaterepbasicForm" target="_parent" onsubmit="return checkForm();">
<input type="hidden" id="flowInstId" name="flowInstId" value="${flowInstId}" />
<input type="hidden" id="djId" name="optProcInfo.djId"  value="${object.punishobjectid}" />
<input type="hidden" id="punishobjectid" name="punishobjectid"  value="${object.punishobjectid}" />
<input type="hidden" id="nodeInstId" name="nodeInstId" value="${nodeInstId}">
<input type="hidden" id="transidea" name="optProcInfo.transidea" value="同意" />
<input type="hidden" id="transcontent" name="optProcInfo.transcontent" value="提交调查取证" />
<s:hidden name="flowPhase" value="%{flowPhase}"/>


<fieldset style=" display: block; padding: 10px;">
			<legend>
				<b>${nodename}</b>
			</legend>
			<table border="0" cellpadding="0" cellspacing="0" id="tb" class="viewTable" style="margin-top: 20px;">	
					<td class="addTd">认定违法事实<font color="red">*</font></td>
					<td align="left" colspan="3">
						<s:textarea id="confirmtruth"
								name="confirmtruth" style="width:100%; height:40px;" value="%{object.confirmtruth}"/>
					</td>
				</tr>
				<tr>
					<td class="addTd">不认定违法事实</td>
					<td align="left" colspan="3">
						<s:textarea id="unconfirmtruth"
								name="unconfirmtruth" style="width:100%; height:40px;" value="%{object.unconfirmtruth}"/>
					</td>
				</tr>
				<tr>
					<td class="addTd">调查经过</td>
					<td align="left" colspan="3">
						<s:textarea id="poindagatereppassage"
								name="poindagatereppassage" style="width:100%; height:40px;" value="%{object.poindagatereppassage}"/>
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
			<s:submit id="submitBtn" name="saveAndSubmit" method="saveInquireProof" cssClass="btn" value="提 交" />
					</span>
			<span style="display:none;" >
			<s:submit id="saveBtn" name="save" method="saveOpt" cssClass="btn" value="保 存" />
					</span>
			<span style="display:none;" >
			<input id="backBtn" type="button" value="返回" class="btn"  onclick="window.history.go(-1);"/>	
					</span>
		</center>
		</s:form>
</body>
</html>