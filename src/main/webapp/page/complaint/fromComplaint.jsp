<%@ page contentType="text/html;charset=UTF-8" import="java.util.*"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<SCRIPT type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/scrolltop.js"></SCRIPT>
<LINK rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/default/css/lrtk.css">
<script
	src="${pageContext.request.contextPath}/scripts/centitui/datepicker.js"
	type="text/javascript"></script>
<script language="javascript"
	src="<s:url value="/scripts/selectUser.js"/>" type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/scripts/centitui/util.date.js"
	type="text/javascript"></script>
<title>督办发起</title>
<sj:head locale="zh_CN" />
</head>
<body>
	<div id="myDiv" class="tt" style="display: none">

		<A HREF="javascript: window.scrollTo(0, 0); void 0"
			ONMOUSEOVER="window.status = 'top'; return true;"
			ONMOUSEOUT="window.status = ''; return true;"> <img
			align="middle" alt="返回顶部"
			src="${pageContext.request.contextPath}/styles/default/images/lanren_top.jpg"
			border="0" />
		</A>
	</div>
	<p class="ctitle">投诉流程-督办发起11</p>
	<s:form action="complaintTasksExecute" namespace="/complaint"
		theme="simple" validator="true">
		<s:submit method="submitIsAcceptComplaint" id="saveAndSubmit"
			cssClass="btn" value="提交" />
		<input type="button" value="返回" Class="btn"
			onclick="window.history.back()" />
		<input type="button" name="backFrame" class="btn"
			onclick="showFlow('${flowInstId}');" value="查看流程图">
		<s:hidden name="bjType" value="3" />
		<input type="hidden" id="flowInstId" name="flowInstId"
			value="${flowInstId}" />
		<input type="hidden" id="complaintid" name="complaintid"
			value="${complaintid}" />
		<input type="hidden" id="complaintId" name="complaintId"
			value="${complaintid}" />
		<input type="hidden" id="nodeInstId" name="nodeInstId"
			value="${nodeInstId}">
		<input type="hidden" id="operatorResult" name="operatorResult"
			value="D">
		<input type="hidden" id="optId" name="optId" value="${optId}">

		<c:if
			test="${not empty object.apply.no or not empty object.punish.no}">
			<p align="center" style="font-size: 20; color: #01A6E0;">
				关于对
				<c:if
					test="${object.bjType=='1' or (object.bjType=='3' and not empty object.apply.no)}">${object.apply.transactAffairName}办件</c:if>
				<c:if
					test="${object.bjType=='2' or (object.bjType=='3' and not empty object.punish.no)}">${object.punish.content}处罚</c:if>
				的督办
			</p>
		</c:if>
		<fieldset style="display: block; padding: 10px;">
			<legend>
				<b>督办发起</b>
			</legend>
			<table cellpadding="0" cellspacing="0" class="viewTable">
				<tr>
					<td class="addTd">督办反馈时限<span style="color: red">*</span></td>
					<td align="left" colspan="3"><sj:datepicker id="promisedate"
							name="promisedate" style="width:140px" yearRange="2000:2020"
							timepickerFormat="hh:mm:ss" displayFormat="yy-mm-dd"
							changeYear="true" timepicker="true" value="%{object.promisedate}" /></td>
				</tr>
				<tr>
					<td class="addTd">督办对象<span style="color: red">*</span></td>
					<td align="left"><s:radio id="isOrg" name="isOrg"
							list="#{'F':'人员','T':'单位'}" listKey="key" listValue="value"
							value="F" /></td>
				</tr>
				<tr>
					<td class="addTd">督办意见<span style="color: red">*</span></td>
					<td align="left" colspan="3"><s:textarea
							name="operatorOpinion" value="%{object.operatorOpinion}"
							style="width:100%;" /></td>
				</tr>
				<tr>
					<td class="addTd">督办详细描述</td>
					<td align="left" colspan="3"><s:textarea
							name="superviseDetail" value="%{superviseDetail}"
							style="width:100%;" /></td>
				</tr>
			</table>

		</fieldset>
	</s:form>
	<iframe id="viewFrame" name="viewFrame"
		src="<%=request.getContextPath()%>/complaint/complaint!viewBizInfo.do?complaintid=${complaintid}"
		width="100%" style="margin-bottom: 10px;" frameborder="no"
		scrolling="false" border="0" marginwidth="0"
		onload="this.height=window.frames['viewFrame'].document.body.scrollHeight"></iframe>
	<iframe id="procFrame" name="procFrame"
		src="<%=request.getContextPath()%>/complaint/complaintsprocess!viewList.do?complaintId=${complaintid}&flowInstId=${flowInstId}"
		width="100%" style="margin-bottom: 10px;" frameborder="no"
		scrolling="false" border="0" marginwidth="0"
		onload="this.height=window.frames['procFrame'].document.body.scrollHeight"></iframe>
	<iframe id="stuffsFrame" name="stuffsFrame"
		src="<%=request.getContextPath()%>/powerruntime/generalOperator!listStuffs.do?djId=${complaintid}"
		width="100%" style="margin-bottom: 10px;" frameborder="no"
		scrolling="false" border="0" marginwidth="0"
		onload="this.height=window.frames['stuffsFrame'].document.body.scrollHeight"></iframe>

</body>
<script type="text/javascript">
function showFlow(flowInstId){
	window.open("<%=request.getContextPath()%>/sampleflow/sampleFlowManager!viewxml.do?flowInstId="+ flowInstId);
	}
</script>
</ html>