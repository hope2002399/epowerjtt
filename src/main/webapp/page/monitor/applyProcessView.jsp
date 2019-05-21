<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>

<html>
<head>
<title><s:text name="applyProcess.view.title" /></title>
</head>

<body>
	<p class="ctitle">
		<s:text name="applyProcess.view.title" />
	</p>
	<div align="right">
		<input type="button" name="" onclick="window.close();" class="btn"
			value="关闭">
	</div>
	<table width="100%" border="0" cellpadding="0" cellspacing="0"
		class="viewTable">



		<tr>
			<td class="addTd">部门名称</td>
			<td align="left">${cp:MAPVALUE("depno",applyProcess.orgId)}</td>

			<td class="addTd"><s:text name="applyProcess.internalNo" /></td>
			<td align="left"><c:out value="${applyProcess.internalNo}" /></td>
		</tr>

		<tr>
			<td class="addTd">权力名称</td>
			<td align="left">${cp:MAPVALUE("suppowerId",applyProcess.itemId)}</td>



			<td class="addTd"><s:text name="applyProcess.tacheName" /></td>
			<td align="left"><c:out value="${applyProcess.tacheName}" /></td>
		</tr>

		<tr>

			<td class="addTd"><s:text name="applyProcess.department" /></td>
			<td align="left"><c:out value="${applyProcess.department}" /></td>

			<td class="addTd"><s:text name="applyProcess.userStaffCode" /></td>
			<td align="left"><c:out value="${applyProcess.userStaffCode}" /></td>
		</tr>

		<tr>
			<td class="addTd"><s:text name="applyProcess.userName" /></td>
			<td align="left"><c:out value="${applyProcess.userName}" /></td>

			<td class="addTd"><s:text name="applyProcess.status" /></td>
			<td align="left">${cp:MAPVALUE("APPLYSTATUS",applyProcess.status)}</td>
		</tr>

		<tr>
			<td class="addTd"><s:text name="applyProcess.promise" /></td>
			<td align="left"><c:if
					test="${not ('0' eq applyProcess.promise)}">
					<c:out value="${applyProcess.promise}" />
				${cp:MAPVALUE("Anticipate_Type", applyProcess.promiseType)}</c:if></td>

			<td class="addTd"><s:text name="applyProcess.note" /></td>
			<td align="left"><c:out value="${applyProcess.note}" /></td>
		</tr>



		<tr>
			<td class="addTd"><s:text name="applyProcess.processDate" /></td>
			<td align="left"><fmt:formatDate
					value='${applyProcess.processDate}' pattern='yyyy-MM-dd HH:mm:ss' /></td>

			<td class="addTd"><s:text name="applyProcess.nodeId" /></td>
			<td align="left"><c:out value="${applyProcess.nodeId}" /></td>
		</tr>

		<tr>
			<td class="addTd"><s:text name="applyProcess.nodeAttribute" /></td>
			<td align="left">${cp:MAPVALUE("NODE_ATTRIBUTE",applyProcess.nodeAttribute)}</td>



			<td class="addTd"><s:text name="applyProcess.beginDate" /></td>
			<td align="left"><fmt:formatDate
					value='${applyProcess.beginDate}' pattern='yyyy-MM-dd HH:mm:ss' />
			</td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="applyProcess.attachment" /></td>
			<td align="left" colspan="3"><c:forEach items="${listStuff }"
					varStatus="i" var="doc">
					<a href="javascript:void(0);" id="doc_${i.index}">《${doc.documentName}》</a>
					<c:if test="${not(i.last)}">、&nbsp;</c:if>
				</c:forEach></td>
		</tr>
		<c:if test="${applyProcess.isrisk eq 1}">
			<tr>
				<td class="addTd"><s:text name="applyProcess.isrisk" /></td>
				<td align="left"><c:if test="${applyProcess.isrisk eq 1}">是</c:if>&nbsp;</td>

				<td class="addTd"><s:text name="applyProcess.risktype" /></td>
				<td align="left"><c:out value="${applyProcess.risktype}" /></td>
			</tr>

			<tr>
				<td class="addTd"><s:text name="applyProcess.riskdescription" /></td>
				<td align="left"><c:out value="${applyProcess.riskdescription}" /></td>

				<td class="addTd"><s:text name="applyProcess.riskresult" /></td>
				<td align="left"><c:out value="${applyProcess.riskresult}" /></td>
			</tr>
		</c:if>
	</table>
	<c:if test="${fn:length(applyProcess.outwaylist)>0}">
		<br>
		<br>
		<br>
		<br>
		<fieldset>
			<a name="outway"></a>
			<legend>
				<b>预报警信息</b>
			</legend>

			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				class="viewTable">
				<tr class="b_darkblue">
					<td style="text-align: center">异常类别</td>
					<td style="text-align: center">异常信息</td>
					<td style="text-align: center">进入时间</td>
					<td style="text-align: center">取消时间</td>

				</tr>
				<c:forEach items="${applyProcess.outwaylist}" varStatus="i"
					var="outway">

					<tr class="b_gray">
						<td style="text-align: center"><c:if
								test="${outway.monitorStyle eq 1}">
								<img align="middle" alt="预警"
									src="${pageContext.request.contextPath}/images/yellow.gif" />
							</c:if> <c:if test='${ outway.monitorStyle  eq 2}'>
								<img align="middle" alt="报警"
									src="${pageContext.request.contextPath}/images/red.gif" />
							</c:if> <c:if test='${ outway.monitorStyle eq 3}'>
								<img align="middle" alt="提醒"
									src="${pageContext.request.contextPath}/images/green.gif" />
							</c:if>
						<td style="text-align: center">${outway.monitorLogo}</td>
						<td style="text-align: center"><fmt:formatDate
								value='${outway.intime}' pattern='yyyy-MM-dd HH:mm:ss' /></td>
						<td style="text-align: center"><fmt:formatDate
								value='${outway.outtime}' pattern='yyyy-MM-dd HH:mm:ss' /></td>

					</tr>
				</c:forEach>
			</table>

		</fieldset>
	</c:if>
</body>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						<c:forEach items="${listStuff}" varStatus="i" var="doc">
						$("#doc_${i.index}")
								.click(
										function() {
											var url = "${pageContext.request.contextPath}/monitor/applyDoc!downloadAtt.do?itemId=${applyProcess.itemId}&type=2&applydocno=${doc.no}&internal_no=${applyProcess.internalNo}&noord=${doc.processNo}";
											window.location.href = url;
										})
						</c:forEach>
					});
</script>
</html>
