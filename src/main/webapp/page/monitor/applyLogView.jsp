<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 



<html>
<head>
<title><c:out value="applyLog.view.title" /></title>
</head>

<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="viewTable">
		<tr>
			<td class="addTd"><s:text name="applyLog.internalNo" /></td>
			<td align="left" colspan="3"><c:out value="${applyLog.internalNo}" /></td>
		</tr>
		
		<tr>
			<td class="addTd"><s:text name="applyLog.itemId" /></td>
			<td align="left" colspan="3"><c:out value="${applyLog.itemId}" /></td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="权力名称" /></td>
			<td align="left" colspan="3">${cp:MAPVALUE("suppowerId",applyLog.itemId)}</td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="权力类型" /></td>
			<td align="left" colspan="3">${cp:MAPVALUE("ITEM_TYPE",applyLog.itemType)}</td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="applyLog.transactAffairName" /></td>
			<td align="left" colspan="3"><c:out value="${applyLog.transactAffairName}" /></td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="applyLog.content" /></td>
			<td align="left" colspan="3"><c:out value="${applyLog.content}" /></td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="applyLog.orgId" /></td>
			<td align="left">${cp:MAPVALUE("depno",applyLog.orgId)}</td>
			<td class="addTd"><s:text name="applyLog.department" /></td>
			<td align="left"><c:out value="${applyLog.department}" /></td>
		</tr>
		
		
		
	
		
		<tr>
		<td class="addTd"><s:text name="applyLog.applyDate" /></td>
			<td align="left"><fmt:formatDate value='${apply.applyDate}' pattern='yyyy-MM-dd HH:mm:ss' /></td>
			<td class="addTd"><s:text name="applyLog.applicantType" /></td>
			<td align="left">${cp:MAPVALUE("PROPOSER_TYPE",applyLog.applicantType)}</td>
			
		</tr>
		
		
		
		<tr>
		<td class="addTd"><s:text name="applyLog.applyWay" /></td>
			<td align="left">${cp:MAPVALUE("bjsqfs",applyLog.applyWay)}</td>
			<td class="addTd"><s:text name="applyLog.applicantCode" /></td>
			<td align="left"><c:out value="${applyLog.applicantCode}" /></td>
		</tr>
		
		
		<tr>
			<td class="addTd"><s:text name="applyLog.applicantName" /></td>
			<td align="left"><c:out value="${applyLog.applicantName}" /></td>
			<td class="addTd"><s:text name="applyLog.applicantAddress" /></td>
			<td align="left"><c:out value="${applyLog.applicantAddress}" /></td>
		</tr>
		
		<tr>
			<td class="addTd"><s:text name="applyLog.applicantPaperType" /></td>
			<td align="left">${cp:MAPVALUE("PaperType",applyLog.applicantPaperType)}</td>
				<td class="addTd"><s:text name="applyLog.applicantPaperCode" /></td>
			<td align="left"><c:out value="${applyLog.applicantPaperCode}" /></td>
		</tr>
		
		
		
		<tr>
			<td class="addTd"><s:text name="applyLog.applicantZipcode" /></td>
			<td align="left"><c:out value="${applyLog.applicantZipcode}" /></td>
			<td class="addTd"><s:text name="applyLog.applicantPhone" /></td>
			<td align="left"><c:out value="${applyLog.applicantPhone}" /></td>
		</tr>
		
		<tr>
			<td class="addTd"><s:text name="applyLog.applicantMobile" /></td>
			<td align="left"><c:out value="${applyLog.applicantMobile}" /></td>
			<td class="addTd"><s:text name="applyLog.applicantEmail" /></td>
			<td align="left"><c:out value="${applyLog.applicantEmail}" /></td>
		</tr>
		
		
		<tr>
			<td class="addTd"><s:text name="applyLog.linkman" /></td>
			<td align="left"><c:out value="${applyLog.linkman}" /></td>
			<td class="addTd"><s:text name="applyLog.linkmanName" /></td>
			<td align="left"><c:out value="${applyLog.linkmanName}" /></td>
		</tr>
		

		
		<tr>
			<td class="addTd"><s:text name="applyLog.linkmanPaperType" /></td>
			<td align="left">${cp:MAPVALUE("PaperType",applyLog.linkmanPaperType)}</td>
			<td class="addTd"><s:text name="applyLog.linkmanPaperCode" /></td>
			<td align="left"><c:out value="${applyLog.linkmanPaperCode}" /></td>
		</tr>
		
	
		
		<tr>
			<td class="addTd"><s:text name="applyLog.linkmanPhone" /></td>
			<td align="left"><c:out value="${applyLog.linkmanPhone}" /></td>
			<td class="addTd"><s:text name="applyLog.linkmanMobile" /></td>
			<td align="left"><c:out value="${applyLog.linkmanMobile}" /></td>
		</tr>
		
		<tr>
			<td class="addTd"><s:text name="applyLog.linkmanAddress" /></td>
			<td align="left"><c:out value="${applyLog.linkmanAddress}" /></td>
			<td class="addTd"><s:text name="applyLog.linkmanZipcode" /></td>
			<td align="left"><c:out value="${applyLog.linkmanZipcode}" /></td>
		</tr>
		
		<tr>
			<td class="addTd"><s:text name="applyLog.linkmanEmail" /></td>
			<td align="left"><c:out value="${applyLog.linkmanEmail}" /></td>
			<td class="addTd"><s:text name="applyLog.promise" /></td>
			<td align="left"><c:out value="${applyLog.promise}" />${cp:MAPVALUE("Promise_Type",applyLog.promiseType)}</td>
		</tr>
		<c:if test="${applyLog.isrisk eq 1}">
		<tr>
			<td class="addTd"><s:text name="applyLog.isrisk" /></td>
			<td align="left"><c:if test="${applyLog.isrisk eq 1}">是</c:if>&nbsp;</td>
			<td class="addTd"><s:text name="applyLog.risktype" /></td>
			<td align="left"><c:out value="${applyLog.risktype}" /></td>
		</tr>
		
		<tr>
			<td class="addTd"><s:text name="applyLog.riskdescription" /></td>
			<td align="left"><c:out value="${applyLog.riskdescription}" /></td>
			<td class="addTd"><s:text name="applyLog.riskresult" /></td>
			<td align="left"><c:out value="${applyLog.riskresult}" /></td>
		</tr>
	
		</c:if>

	
		
	</table>
</body>
</html> 
