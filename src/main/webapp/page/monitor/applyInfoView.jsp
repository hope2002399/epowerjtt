<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 


<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="viewTable">
		<tr>
			<td class="addTd"><s:text name="apply.internalNo" /></td>
			<td align="left" colspan="3"><c:out value="${apply.internalNo}" /></td>
		</tr>
		<c:if test="${not empty apply.parentName}">
			<tr>
				<td class="addTd"><s:text name="主项名称" /></td>
				<td align="left" colspan="3"><c:out value="${apply.parentName}" /></td>
			</tr>
			<tr>
				<td class="addTd"><s:text name="子项名称" /></td>
				<td align="left" colspan="3"><c:out value="${apply.itemParName}" /></td>
			</tr>
		</c:if>
		<c:if test="${empty apply.parentName}">
			<tr>
				<td class="addTd"><s:text name="主项名称" /></td>
				<td align="left" colspan="3"><c:out value="${apply.itemParName}" /></td>
			</tr>
		</c:if>
		<tr>
			<td class="addTd"><s:text name="业务编码" /></td>
			<td align="left" colspan="3"><c:out value="${apply.itemId}" /></td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="业务名称" /></td>
			<c:if test="${fn:length(apply.itemId)<=33 }">
				<td align="left" colspan="3">${cp:MAPVALUE("suppowerId",apply.itemId)}</td>
			</c:if>
			<c:if test="${fn:length(apply.itemId)>33 }">
				<td align="left" colspan="3">${itemName }</td>
			</c:if>
		</tr>
		<tr>
			<td class="addTd"><s:text name="权力类型" /></td>
			<c:if test="${fn:length(apply.itemId)<=33 }">
				<td align="left" colspan="3"> ${cp:MAPVALUE("ITEM_TYPE",fn:substring(apply.itemId, 11,13))}</td>
			</c:if>
			<c:if test="${fn:length(apply.itemId)>33 }">
				<td align="left" colspan="3"> ${cp:MAPVALUE("POWER_TYPE",itemType)}</td>
			</c:if>
		</tr>
		<tr>
			<td class="addTd"><s:text name="apply.transactAffairName" /></td>
			<td align="left" colspan="3"><c:out value="${apply.transactAffairName}" /></td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="apply.content" /></td>
			<td align="left" colspan="3"><c:out value="${apply.content}" /></td>
		</tr>
		<tr>
			
			<td class="addTd"><s:text name="apply.department" /></td>
			<td align="left" colspan="3"><c:out value="${apply.department}" /></td>
		</tr>
		
		<tr>
		<td class="addTd"><s:text name="apply.applyDate" /></td>
			<td align="left"><fmt:formatDate value='${apply.applyDate}' pattern='yyyy-MM-dd HH:mm:ss' /></td>
			<td class="addTd">申请者类别</td>
			<td align="left">${cp:MAPVALUE("PROPOSER_TYPE",apply.applicantType)}</td>
			
		</tr>
		
		<tr>
		<td class="addTd"><s:text name="apply.applyWay" /></td>
			<td align="left">${cp:MAPVALUE("bjsqfs",apply.applyWay)}</td>
			<td class="addTd"><s:text name="apply.applicantCode" /></td>
			<td align="left"><c:out value="${apply.applicantCode}" /></td>
		</tr>
		
		<tr>
			<td class="addTd"><s:text name="apply.applicantName" /></td>
			<td align="left"><c:out value="${apply.applicantName}" /></td>
			<td class="addTd"><s:text name="apply.applicantAddress" /></td>
			<td align="left"><c:out value="${apply.applicantAddress}" /></td>
		</tr>
		
		<tr>
			<td class="addTd"><s:text name="apply.applicantPaperType" /></td>
			<td align="left">${cp:MAPVALUE("PaperType",apply.applicantPaperType)}</td>
				<td class="addTd"><s:text name="apply.applicantPaperCode" /></td>
			<td align="left"><c:out value="${apply.applicantPaperCode}" /></td>
		</tr>
		
		<tr>
			<td class="addTd"><s:text name="apply.applicantZipcode" /></td>
			<td align="left"><c:out value="${apply.applicantZipcode}" /></td>
			<td class="addTd"><s:text name="apply.applicantPhone" /></td>
			<td align="left"><c:out value="${apply.applicantPhone}" /></td>
		</tr>
		
		<tr>
			<td class="addTd"><s:text name="apply.applicantMobile" /></td>
			<td align="left"><c:out value="${apply.applicantMobile}" /></td>
			<td class="addTd"><s:text name="apply.applicantEmail" /></td>
			<td align="left"><c:out value="${apply.applicantEmail}" /></td>
		</tr>
		<c:if test="${not(('' eq apply.linkman)||(empty apply.linkman))}">
		<tr>
			<td class="addTd"><s:text name="apply.linkman" /></td>
			<td align="left"><c:out value="${apply.linkman}" /></td>
			<td class="addTd"><s:text name="apply.linkmanName" /></td>
			<td align="left"><c:out value="${apply.linkmanName}" /></td>
		</tr>
		
		<tr>
			<td class="addTd"><s:text name="apply.linkmanPaperType" /></td>
			<td align="left">${cp:MAPVALUE("PaperType",apply.linkmanPaperType)}</td>
			<td class="addTd"><s:text name="apply.linkmanPaperCode" /></td>
			<td align="left"><c:out value="${apply.linkmanPaperCode}" /></td>
		</tr>
		
		<tr>
			<td class="addTd"><s:text name="apply.linkmanPhone" /></td>
			<td align="left"><c:out value="${apply.linkmanPhone}" /></td>
			<td class="addTd"><s:text name="apply.linkmanMobile" /></td>
			<td align="left"><c:out value="${apply.linkmanMobile}" /></td>
		</tr>
		
		<tr>
			<td class="addTd"><s:text name="apply.linkmanAddress" /></td>
			<td align="left"><c:out value="${apply.linkmanAddress}" /></td>
			<td class="addTd"><s:text name="apply.linkmanZipcode" /></td>
			<td align="left"><c:out value="${apply.linkmanZipcode}" /></td>
		</tr>
		
		<tr>
			<td class="addTd"><s:text name="apply.linkmanEmail" /></td>
			<td align="left"><c:out value="${apply.linkmanEmail}" /></td>
			<td class="addTd"><s:text name="apply.promise" /></td>
			<td align="left"><c:out value="${apply.promise}" />${cp:MAPVALUE("Promise_Type",apply.promiseType)}</td>
		</tr>
		</c:if>
		<tr>
			<td class="addTd"><s:text name="apply.stuff" /></td>
			<td align="left" colspan="3"><c:forEach items="${listStuff}" varStatus="i" var="doc" ><a href='applyDoc!downloadAtt.do?document_id=${doc.document_id}&no=${apply.no}&type=1'>${doc.document_name}</a> </c:forEach></td>
		</tr>
		<c:if test="${apply.isrisk eq 1}">
		<tr>
			<td class="addTd"><s:text name="apply.isrisk" /></td>
			<td align="left"><c:if test="${apply.isrisk eq 1}">是</c:if>&nbsp;</td>
			<td class="addTd"><s:text name="apply.risktype" /></td>
			<td align="left"><c:out value="${apply.risktype}" /></td>
		</tr>
		
		<tr>
			<td class="addTd"><s:text name="apply.riskdescription" /></td>
			<td align="left"><c:out value="${apply.riskdescription}" /></td>
			<td class="addTd"><s:text name="apply.riskresult" /></td>
			<td align="left"><c:out value="${apply.riskresult}" /></td>
		</tr>
	
		</c:if>

	</table>

</body>
</html> 
