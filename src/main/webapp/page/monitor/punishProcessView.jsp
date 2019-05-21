<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>

<html>
<head>
<title><s:text name="punishProcess.view.title" /></title>
</head>
<body>
	<p class="ctitle">
		<s:text name="punishProcess.view.title" />
	</p>
	<div align="right">
		<input type="button" name="" onclick="window.close();" class="btn"
			value="关闭">
	</div>
	<table width="100%" border="0" cellpadding="0" cellspacing="0"
		class="viewTable">
		<tr>
			<td class="addTd">部门名称</td>
			<td align="left">${cp:MAPVALUE("depno",punishProcess.orgId)}</td>

			<td class="addTd"><s:text name="punishProcess.internalNo" /></td>
			<td align="left"><c:out value="${punishProcess.internalNo}" /></td>
		</tr>

		<tr>
			<td class="addTd">权力名称</td>
			<td align="left">${cp:MAPVALUE("suppowerId",punishProcess.itemId)}</td>
			<td class="addTd"><s:text name="punishProcess.tacheName" /></td>
			<td align="left"><c:out value="${punishProcess.tacheName}" /></td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishProcess.department" /></td>
			<td align="left"><c:out value="${punishProcess.department}" /></td>
			<td class="addTd"><s:text name="punishProcess.userName" /></td>
			<td align="left"><c:out value="${punishProcess.userName}" /></td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishProcess.status" /></td>
			<td align="left">${cp:MAPVALUE("PUNISHSTATUS",punishProcess.status)}</td>
			<td class="addTd"><s:text name="punishProcess.promise" /></td>
			<td align="left"><c:if
					test="${not ('0' eq punishProcess.promise)}">
					<c:out value="${punishProcess.promise}" />${cp:MAPVALUE("Anticipate_Type", punishProcess.promiseType)}</c:if></td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishProcess.note" /></td>
			<td align="left"><c:out value="${punishProcess.note}" /></td>
			<td class="addTd"><s:text name="punishProcess.processDate" /></td>
			<td align="left"><fmt:formatDate
					value='${punishProcess.processDate}' pattern='yyyy-MM-dd HH:mm:ss' />
			</td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishProcess.nodeAttribute" /></td>
			<td align="left">${cp:MAPVALUE("NODE_ATTRIBUTE",punishProcess.nodeAttribute)}</td>
			<td class="addTd"><s:text name="punishProcess.createDate" /></td>
			<td align="left"><fmt:formatDate
					value='${punishProcess.createDate}' pattern='yyyy-MM-dd HH:mm:ss' /></td>
		</tr>
		<c:if test="${not (empty evidences) }">
			<tr>
				<td class="addTd"><s:text name="punishProcess.evidence" /></td>
				<td align="left" colspan="3"><c:forEach items="${evidences}"
						varStatus="i" var="doc">
						<a href="javascript:void(0);" id="evidence_${i.index}">《${doc.documentName}》</a>
						<c:if test="${not(i.last)}">、&nbsp;</c:if>
					</c:forEach></td>
			</tr>
		</c:if>
		<c:if test="${not (empty attachments) }">
			<tr>
				<td class="addTd"><s:text name="punishProcess.attachment" /></td>
				<td align="left" colspan="3"><c:forEach items="${attachments}"
						varStatus="i" var="doc">
						<a href="javascript:void(0);" id="attachment_${i.index}">《${doc.documentName}》</a>
						<c:if test="${not(i.last)}">、&nbsp;</c:if>
					</c:forEach></td>
			</tr>
		</c:if>
		<c:if test="${punishProcess.isrisk eq 1}">
			<tr>
				<td class="addTd"><s:text name="punishProcess.isrisk" /></td>
				<td align="left"><c:if test="${punishProcess.isrisk eq 1}">是</c:if>&nbsp;</td>

				<td class="addTd"><s:text name="punishProcess.risktype" /></td>
				<td align="left"><c:out value="${punishProcess.risktype}" /></td>
			</tr>

			<tr>
				<td class="addTd"><s:text name="punishProcess.riskdescription" /></td>
				<td align="left"><c:out
						value="${punishProcess.riskdescription}" /></td>
				<td class="addTd"><s:text name="punishProcess.riskresult" /></td>
				<td align="left"><c:out value="${punishProcess.riskresult}" /></td>
			</tr>
		</c:if>
	</table>
</body>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						<c:if test="${not(empty evidences)}">
						   <c:forEach items="${evidences}"	varStatus="i" var="doc">
						       $("#evidence_${i.index}").click(function(){
						    	   var url = "${pageContext.request.contextPath}/monitor/punishDoc!downloadAtt.do?style=evidence&orgId=${punishProcess.orgId}&type=2&punishdocno=${doc.no}&internal_no=${punishProcess.internalNo}&noord=${doc.processNo}";
						    	   window.location.href = url;
						       });
						  </c:forEach>
					   </c:if>
					   <c:if test="${not (empty attachments) }">
						  <c:forEach items="${attachments}"	varStatus="i" var="doc">
						    $("#attachment_${i.index}").click(function(){
					    	     var url = "${pageContext.request.contextPath}/monitor/punishDoc!downloadAtt.do?style=attachment&orgId=${punishProcess.orgId}&type=2&punishdocno=${doc.no}&internal_no=${punishProcess.internalNo}&noord=${doc.processNo}";
					    	     window.location.href = url;
					         });
						  </c:forEach>
					</c:if>
					});
</script>
</html>
