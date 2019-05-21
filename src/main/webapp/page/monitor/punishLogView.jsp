<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>


<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0"
		class="viewTable">
		<tr>
			<td class="addTd"><s:text name="punishLog.internalNo" /></td>
			<td align="left" colspan="3"><c:out
					value="${punishLog.internalNo}" /></td>
		</tr>

		<tr>
			<td class="addTd"><s:text name="punishLog.itemId" /></td>
			<td align="left" colspan="3"><c:out value="${punishLog.itemId}" /></td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="权力名称" /></td>
			<td align="left" colspan="3">${cp:MAPVALUE("suppowerId",punishLog.itemId)}</td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="处罚名称" /></td>
			<td align="left" colspan="3"><c:out value="${punishLog.content}" /></td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishLog.source" /></td>
			<td align="left" colspan="3">${cp:MAPVALUE("CASEORIGN",punishLog.source)}</td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishLog.fact" /></td>
			<td align="left" colspan="3">${punishLog.fact}</td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishLog.orgId" /></td>
			<td align="left">${cp:MAPVALUE("depno",punishLog.orgId)}</td>
			<td class="addTd"><s:text name="punishLog.department" /></td>
			<td align="left"><c:out value="${punishLog.department}" /></td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishLog.ajOccurDate" /></td>
			<td align="left"><fmt:formatDate
					value='${punishLog.ajOccurDate }' pattern='yyyy-MM-dd HH:mm:ss' /></td>
			<td class="addTd"><s:text name="punishLog.ajAddr" /></td>
			<td align="left"><c:out value="${punishLog.ajAddr}" /></td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishLog.createDate" /></td>
			<td align="left" colspan="3"><fmt:formatDate
					value='${punishLog.createDate}' pattern='yyyy-MM-dd HH:mm:ss' /></td>

		</tr>
		<tr>
			<td class="addTd"><s:text name="punishLog.punishTarget" /></td>
			<td align="left">${punishLog.punishTarget }</td>
			<td class="addTd"><s:text name="punishLog.targetType" /></td>
			<td align="left">${cp:MAPVALUE("PROPOSER_TYPE",punishLog.targetType)}</td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishLog.targetCode" /></td>
			<td align="left" colspan="3">${punishLog.targetCode}</td>

		</tr>
		<tr>
			<td class="addTd"><s:text name="punishLog.targetPaperType" /></td>
			<td align="left">${cp:MAPVALUE("PaperType",punishLog.targetPaperType)}</td>
			<td class="addTd"><s:text name="punishLog.targetPaperNumber" /></td>
			<td align="left"><c:out value="${punishLog.targetPaperNumber}" /></td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishLog.targetPhone" /></td>
			<td align="left">${punishLog.targetPhone }</td>
			<td class="addTd"><s:text name="punishLog.targetMobile" /></td>
			<td align="left"><c:out value="${punishLog.targetMobile}" /></td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishLog.targetZipCode" /></td>
			<td align="left">${punishLog.targetZipCode }</td>
			<td class="addTd"><s:text name="punishLog.targetAddress" /></td>
			<td align="left"><c:out value="${punishLog.targetAddress}" /></td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishLog.targetEmail" /></td>
			<td align="left">${punishLog.targetEmail }</td>
			<td class="addTd"><s:text name="punishLog.promise" /></td>
			<td align="left"><c:if test="${not ('0' eq punishLog.promise)}">
					<c:out value="${punishLog.promise}" />${cp:MAPVALUE("Promise_Type",punishLog.promiseType)}</c:if></td>
		</tr>
		<c:if test="${!empty  punishLog.reporter}">
			<tr>
				<td class="addTd"><s:text name="punishLog.reporter" /></td>
				<td align="left">${punishLog.reporter }</td>
				<td class="addTd"><s:text name="punishLog.reporterDate" /></td>
				<td align="left"><fmt:formatDate
						value='${punishLog.reporterDate}' pattern='yyyy-MM-dd HH:mm:ss' /></td>
			</tr>
			<tr>
				<td class="addTd"><s:text name="punishLog.reporterPaperType" /></td>
				<td align="left">${cp:MAPVALUE("PaperType",punishLog.reporterPaperType)}</td>
				<td class="addTd"><s:text name="punishLog.reporterAperCode" /></td>
				<td align="left"><c:out value="${punishLog.reporterAperCode}" /></td>
			</tr>
			<tr>
				<td class="addTd"><s:text name="punishLog.reporterPhone" /></td>
				<td align="left">${punishLog.reporterPhone }</td>
				<td class="addTd"><s:text name="punishLog.reporterMobile" /></td>
				<td align="left"><c:out value="${punishLog.reporterMobile}" /></td>
			</tr>
			<tr>
				<td class="addTd"><s:text name="punishLog.reporterZipcode" /></td>
				<td align="left">${punishLog.reporterZipcode }</td>
				<td class="addTd"><s:text name="punishLog.reporterEmail" /></td>
				<td align="left"><c:out value="${punishLog.reporterEmail}" /></td>
			</tr>
			<tr>
				<td class="addTd"><s:text name="punishLog.reporterAddress" /></td>
				<td align="left" colspan="3">${punishLog.reporterAddress}</td>

			</tr>
		</c:if>
		<c:if test="${punishLog.isrisk eq 1}">
			<tr>
				<td class="addTd"><s:text name="punishLog.isrisk" /></td>
				<td align="left"><c:if test="${punishLog.isrisk eq 1}">是</c:if>&nbsp;</td>
				<td class="addTd"><s:text name="punishLog.risktype" /></td>
				<td align="left"><c:out value="${punishLog.risktype}" /></td>
			</tr>

			<tr>
				<td class="addTd"><s:text name="punishLog.riskdescription" /></td>
				<td align="left"><c:out value="${punishLog.riskdescription}" /></td>
				<td class="addTd"><s:text name="punishLog.riskresult" /></td>
				<td align="left"><c:out value="${punishLog.riskresult}" /></td>
			</tr>

		</c:if>



	</table>

</body>
</html>
