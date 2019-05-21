<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>


<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0"
		class="viewTable">
		<tr>
			<td class="addTd"><s:text name="punish.internalNo" /></td>
			<td align="left" colspan="3"><c:out value="${punish.internalNo}" /></td>
		</tr>
		<%-- <c:if test="${not empty punish.parentName}">
			<tr>
				<td class="addTd"><s:text name="主项名称" /></td>
				<td align="left" colspan="3"><c:out value="${punish.parentName}" /></td>
			</tr>
			<tr>
				<td class="addTd"><s:text name="子项名称" /></td>
				<td align="left" colspan="3"><c:out value="${punish.itemParName}" /></td>
			</tr>
		</c:if>
		<c:if test="${empty punish.parentName}">
			<tr>
				<td class="addTd"><s:text name="主项名称" /></td>
				<td align="left" colspan="3"><c:out value="${punish.itemParName}" /></td>
			</tr>
		</c:if> --%>
		<tr>
			<td class="addTd"><s:text name="业务编码" /></td>
			<td align="left" colspan="3"><c:out value="${punish.itemId}" /></td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="业务名称" /></td>
			<td align="left" colspan="3">${cp:MAPVALUE("suppowerId",punish.itemId)}</td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="处罚名称" /></td>
			<td align="left" colspan="3"><c:out value="${punish.content}" /></td>
		</tr>
		<tr>

			<td class="addTd"><s:text name="punish.source" /></td>
			<td align="left" colspan="3">${cp:MAPVALUE("CASEORIGN",punish.source)}</td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="punish.fact" /></td>
			<td align="left" colspan="3">${punish.fact}</td>
		</tr>

		<tr>
			<td class="addTd"><s:text name="punish.orgId" /></td>
			<td align="left">${cp:MAPVALUE("depno",punish.orgId)}</td>
			<td class="addTd"><s:text name="punish.department" /></td>
			<td align="left"><c:out value="${punish.department}" /></td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="punish.ajOccurDate" /></td>
			<td align="left"><fmt:formatDate value='${punish.ajOccurDate }'
					pattern='yyyy-MM-dd HH:mm:ss' /></td>
			<td class="addTd"><s:text name="punish.ajAddr" /></td>
			<td align="left"><c:out value="${punish.ajAddr}" /></td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="punish.createDate" /></td>
			<td align="left" colspan="3"><fmt:formatDate
					value='${punish.createDate}' pattern='yyyy-MM-dd HH:mm:ss' /></td>

		</tr>
		<tr>
			<td class="addTd"><s:text name="punish.punishTarget" /></td>
			<td align="left">${punish.punishTarget }</td>
			<td class="addTd"><s:text name="punish.targetType" /></td>
			<td align="left">${cp:MAPVALUE("PROPOSER_TYPE",punish.targetType)}</td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="punish.targetCode" /></td>
			<td align="left" colspan="3">${punish.targetCode}</td>

		</tr>
		<tr>
			<td class="addTd"><s:text name="punish.targetPaperType" /></td>
			<td align="left">${cp:MAPVALUE("PaperType",punish.targetPaperType)}</td>
			<td class="addTd"><s:text name="punish.targetPaperNumber" /></td>
			<td align="left"><c:out value="${punish.targetPaperNumber}" /></td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="punish.targetPhone" /></td>
			<td align="left">${punish.targetPhone }</td>
			<td class="addTd"><s:text name="punish.targetMobile" /></td>
			<td align="left"><c:out value="${punish.targetMobile}" /></td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="punish.targetZipCode" /></td>
			<td align="left">${punish.targetZipCode }</td>
			<td class="addTd"><s:text name="punish.targetAddress" /></td>
			<td align="left"><c:out value="${punish.targetAddress}" /></td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="punish.targetEmail" /></td>
			<td align="left">${punish.targetEmail }</td>
			<td class="addTd"><s:text name="punish.promise" /></td>
			<td align="left"><c:if test="${not ('0' eq punish.promise)}">
					<c:out value="${punish.promise}" />${cp:MAPVALUE("Promise_Type",punish.promiseType)}</c:if></td>
		</tr>
		<c:if test="${!empty  punish.reporter}">
			<tr>
				<td class="addTd"><s:text name="punish.reporter" /></td>
				<td align="left">${punish.reporter }</td>
				<td class="addTd"><s:text name="punish.reporterDate" /></td>
				<td align="left"><fmt:formatDate value='${punish.reporterDate}'
						pattern='yyyy-MM-dd HH:mm:ss' /></td>
			</tr>
			<tr>
				<td class="addTd"><s:text name="punish.reporterPaperType" /></td>
				<td align="left">${cp:MAPVALUE("PaperType",punish.reporterPaperType)}</td>
				<td class="addTd"><s:text name="punish.reporterAperCode" /></td>
				<td align="left"><c:out value="${punish.reporterAperCode}" /></td>
			</tr>
			<tr>
				<td class="addTd"><s:text name="punish.reporterPhone" /></td>
				<td align="left">${punish.reporterPhone }</td>
				<td class="addTd"><s:text name="punish.reporterMobile" /></td>
				<td align="left"><c:out value="${punish.reporterMobile}" /></td>
			</tr>
			<tr>
				<td class="addTd"><s:text name="punish.reporterZipcode" /></td>
				<td align="left">${punish.reporterZipcode }</td>
				<td class="addTd"><s:text name="punish.reporterEmail" /></td>
				<td align="left"><c:out value="${punish.reporterEmail}" /></td>
			</tr>
			<tr>
				<td class="addTd"><s:text name="punish.reporterAddress" /></td>
				<td align="left" colspan="3">${punish.reporterAddress}</td>

			</tr>
		</c:if>
		<c:if test="${not (empty attachments) }">
			<tr>
				<td class="addTd">办理附件</td>
				<td align="left" colspan="3"><c:forEach
						items="${attachments}" varStatus="i" var="doc">
						<a href="#">${doc.docName}</a>
					</c:forEach></td>
			</tr>
		</c:if>
		<c:if test="${not (empty evidences) }">
			<tr>
				<td class="addTd">办理附件</td>
				<td align="left" colspan="3"><c:forEach
						items="${evidences}" varStatus="i" var="doc">
						<a href='punishDoc!downloadStuff.do?no=${doc.no}'>${doc.docName}</a>
					</c:forEach></td>
			</tr>
		</c:if>
		<c:if test="${punish.isrisk eq 1}">
			<tr>
				<td class="addTd"><s:text name="punish.isrisk" /></td>
				<td align="left"><c:if test="${punish.isrisk eq 1}">是</c:if>&nbsp;</td>
				<td class="addTd"><s:text name="punish.risktype" /></td>
				<td align="left"><c:out value="${punish.risktype}" /></td>
			</tr>

			<tr>
				<td class="addTd"><s:text name="punish.riskdescription" /></td>
				<td align="left"><c:out value="${punish.riskdescription}" /></td>
				<td class="addTd"><s:text name="punish.riskresult" /></td>
				<td align="left"><c:out value="${punish.riskresult}" /></td>
			</tr>

		</c:if>



	</table>

</body>
</html>
