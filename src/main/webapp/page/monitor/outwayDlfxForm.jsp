<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title>部门督办发起</title>
		<sj:head locale="zh_CN" />
   		<script type="text/javascript" src="<s:url value="/scripts/colorbox/jquery.colorbox.js"/>" charset="utf-8"></script>
        <link href="${pageContext.request.contextPath}/scripts/colorbox/colorbox.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/scripts/jquery-ui/jquery-ui-1.9.2.custom.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="<s:url value="/scripts/addressBook.js"/>" charset="utf-8"></script>
		<script type="text/javascript" src="<s:url value="/scripts/centit.js"/>" charset="utf-8"></script>
		<script type="text/javascript" src="<s:url value="/scripts/jquery-ui/jquery-ui-1.9.2.custom.js"/>" charset="utf-8"></script>
		<script type="text/javascript" src="<s:url value="/scripts/opendiv_Win.js"/>" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
			<fieldset style="padding:10px;">
		<legend class="ctitle" style="width:auto;font:·16px">预报警信息</legend>
		<table cellpadding="0" cellspacing="0" class="viewTable">
			<tr>
				<td align="center">&nbsp;</td>
				<td align="center">部门名称</td>
				<td align="center">报警类别</td>
				<td align="center">说明</td>
				<td align="center">预报警时间</td>
				<td align="center">摘牌时间</td>
			</tr>
			<tr>
				<td align="center"><c:if test="${object.monitorStyle eq 1}">
						<img align="middle" alt="预警" src="${pageContext.request.contextPath}/images/yellow.gif" />
					</c:if> 
					<c:if test='${object.monitorStyle  eq 2}'>
						<img align="middle" alt="报警" src="${pageContext.request.contextPath}/images/red.gif" />
					</c:if> <c:if test='${object.monitorStyle eq 3}'>
						<img align="middle" alt="提醒" src="${pageContext.request.contextPath}/images/green.gif" />
					</c:if></td>
				<td align="center" style="10%">${cp:MAPVALUE("depno",object.orgId)}</td>
				<td align="center">${cp:MAPVALUE("Warnpointname",object.monitorType)}</td>
				<td align="center">${object.monitorDesc}</td>
				<td align="center"><fmt:formatDate value='${object.intime}' pattern='yyyy-MM-dd' /></td>
				<td align="center"><fmt:formatDate value='${object.outtime}' pattern='yyyy-MM-dd' /></td>
			</tr>
		</table>
			</fieldset>
			
			<fieldset style="padding:10px;">
		<legend class="ctitle" style="width:auto;font:·16px">预报警摘牌</legend>
			<s:form action="outway"  method="post" namespace="/monitor" id="outwayForm" theme="simple"  validator="true">
			<input type="hidden" name="s_orgId" value='${param.s_orgId}'/>
		<input type="hidden" name="s_bjType" value='${param.s_bjType }'/>
		<input type="hidden" name="s_queryUnderUnit" value='${param.s_queryUnderUnit}'/>
		<input type="hidden" name="s_monitorStyle" value='${param.s_monitorStyle}'/>
		<input type="hidden" name="s_monitorType" value='${param.s_monitorType}'/>
		<input type="hidden" name="s_begTime" value='${param.s_begTime}'/>
		<input type="hidden" name="s_endTime" value='${param.s_endTime}'/>
		<input type="hidden" name="s_NP_outWayZC" value='<s:property value="s_NP_outWayZC" />'/>
		<input type="hidden" name="s_NP_outWayQX" value='<s:property value="s_NP_outWayQX" />'/>
		<input type="hidden" name="s_monitorSource" value='C'/>
		<input type="hidden" name="warnNos" value='<s:property value="warnNos" />' />
		<input type="hidden" name="outwayno" value='<s:property value="outwayno" />' />
			<table cellpadding="0" cellspacing="0" class="viewTable">
				<tr>
			<td class="addTd" >摘牌理由说明 <span style="color: red">*</span></td>
				<td align="left" colspan="3"><s:textarea  cssStyle="overflow:visible"  name="outreason"  
					validator="input" min="1" errorshow="请输入摘牌理由说明" value="%{object.outreason}"></s:textarea></td>
			</tr>
				<tr><td colspan="4" align="center"><s:submit method="DlfxSave"  cssClass="btn" value="保存" onclick="return confirm('确定要进行摘牌吗？');" />
				<input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" /></td></tr>
			</table>
			</s:form>
			</fieldset>
	</body>
</html>
