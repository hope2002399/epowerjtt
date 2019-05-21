<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%> 
<html>
<head>
<title>预报警摘牌</title>
<script src="<s:url value='/scripts/centit_validator.js'/>" type="text/javascript" ></script>	
</head>
<script type="text/javascript">
<!--
function Ok(){
	document.getElementById("outwayForm").action="monitor/outway!savePL.do";    
	document.getElementById("outwayForm").method="post";   
	document.getElementById("outwayForm").submit();  
	window.parent.JqueryDialog.SubmitCompleted("", true, true);
	//return false;
}
//-->
</script>
<body>
<%@ include file="/page/common/messages.jsp"%>
<fieldset style="padding:10px;">
	<legend style="margin-bottom:10px;">预报警摘牌</legend>
	<s:form action="outway"  method="post" namespace="/monitor" id="outwayForm" theme="simple"  validator="true">
	<%-- <c:if test="${empty warnNos }"> --%>
		<s:submit method="save"  cssClass="btn" value="保存" onclick="return confirm('确定要进行摘牌吗？');" />
		<%-- <s:submit method="saveAndSubmit"  cssClass="btn" value="提交" /> --%>
		<input type="button" value="返回" Class="btn" onclick="window.history.back()" /><%-- </c:if> --%>
		<input type="hidden" name="s_orgId" value='<s:property value="s_orgId" />'/>
		<input type="hidden" name="s_bjType" value='${s_bjType}'/>
		<input type="hidden" name="s_internalNo" value='<s:property value="s_internalNo" />'/>
		<input type="hidden" name="s_monitorStyle" value='<s:property value="s_monitorStyle" />'/>
		<input type="hidden" name="s_monitorType" value='<s:property value="s_monitorType" />'/>
		<input type="hidden" name="s_begTime" value='<s:property value="s_begTime" />'/>
		<input type="hidden" name="s_endTime" value='<s:property value="s_endTime" />'/>
		<input type="hidden" name="s_NP_outWayZC" value='<s:property value="s_NP_outWayZC" />'/>
		<input type="hidden" name="s_NP_outWayQX" value='<s:property value="s_NP_outWayQX" />'/>
		<input type="hidden" name="warnNos" value='<s:property value="warnNos" />' />
		<input type="hidden" name="outwayno" value='<s:property value="outwayno" />' />
		<input type="hidden" name="s_queryUnderUnit" value='<s:property value="s_queryUnderUnit" />'/>
		
		<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
		<tr>
			<td class="addTd" >摘牌理由说明 <span style="color: red">*</span></td>
				<td align="left" colspan="3"><s:textarea  cssStyle="overflow:visible"  name="outreason"  
					validator="input" min="1" errorshow="请输入摘牌理由说明" value="%{object.outreason}"></s:textarea></td>
			</tr>
		</table>
	</s:form>	
</fieldset>
<c:if test="${empty warnNos }">
<fieldset style="padding:10px;">
		<legend style="margin-bottom:10px;">预报警详细信息</legend>
			<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
				<tr>
					<td class="addTd"><s:text name="outway.bjType" /></td>
					<td align="left"><c:out value="${cp:MAPVALUE('bjType', bjType)}"></c:out></td>
				</tr>
				<tr>
					<td class="addTd"><s:text name="outway.orgId" /></td>
					<td align="left"><c:out value="${cp:MAPVALUE('depno', orgId) }"></c:out></td>
				</tr>
				<tr>
					<td class="addTd"><s:text name="outway.internalNo"/></td>
					<td align="left">
						<s:property value="outway.internalNo" />&nbsp;&nbsp;&nbsp;&nbsp;
						<c:if test="${bjType eq '1' }">
						<a href="apply!view.do?internalNo=${internalNo}&itemId=${itemId }" target="_self">办件明细</a>
						</c:if>
						<c:if test="${bjType eq '2' }">
						<a href="punish!view.do?internalNo=${internalNo}&orgId=${orgId}" target="_self">案件明细</a>
						</c:if>
						<c:if test="${bjType eq '3' }">督办信息</c:if>
						<c:if test="${bjType eq '4' }">投诉信息</c:if>
					</td>
				</tr>	
				<tr>
					<td class="addTd"><s:text name="outway.itemId" /></td>
					<td align="left"><s:property value="outway.itemId" />&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="${pageContext.request.contextPath}/powerbase/suppowerchglog!listVersion.do?itemId=${itemId}&version=1" target="_self">权力明细</a></td>
				</tr>					
				<tr>
					<td class="addTd">权力名称</td>
					<td align="left">
						<c:out value="${cp:MAPVALUE('suppowerId', itemId) }"></c:out>
					</td>
				</tr>
				<tr>
					<td class="addTd"><s:text name="outway.monitorStyle" /></td>
					<td align="left">
						<c:out value="${cp:MAPVALUE('MONITOR_STYLE', monitorStyle) }"></c:out>
					</td>
				</tr>	
				<tr>
					<td class="addTd"><s:text name="outway.monitorType" /></td>
					<td align="left"><c:out value="${cp:MAPVALUE('MONITOR_TYPE', monitorType) }"></c:out></td>
				</tr>	
				<tr>
					<td class="addTd"><s:text name="outway.monitorLogo" /></td>
					<td align="left"><s:property value="%{monitorLogo}" /></td>
				</tr>	
				<tr>
					<td class="addTd"><s:text name="outway.intime" /></td>
					<td align="left"><fmt:formatDate value="${intime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>
                <c:if test="${not empty outtime}">
				<tr>
					<td class="addTd"><s:text name="outway.outtime" /></td>
					<td align="left"><fmt:formatDate value="${outtime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>	
				<tr>
					<td class="addTd"><s:text name="outway.outperson" /></td>
					<td align="left"><c:out value="${cp:MAPVALUE('usercode', outperson) }"></c:out></td>
				</tr>	
				<tr>
					<td class="addTd"><s:text name="outway.outreason" /></td>
					<td align="left"><s:property value="%{outreason}" /></td>
				</tr>	
				</c:if>
</table>
</fieldset>
</c:if>
</body>
</html>
