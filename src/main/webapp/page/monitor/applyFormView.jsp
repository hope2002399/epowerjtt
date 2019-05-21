<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 


<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="viewTable">
		<c:forEach items="${formList }" varStatus="i" var="form" >
		<tr>
		<c:choose>
		<c:when test="${form.name eq '申请者类型' }">
			<td class="addTd"><c:out value="${form.name}" /></td>
			<td align="left">${cp:MAPVALUE("PROPOSER_TYPE",form.value)}</td>
		</c:when>
		<c:when test="${form.name eq '办件申请方式' }">
			<td class="addTd"><c:out value="${form.name}" /></td>
			<td align="left">${cp:MAPVALUE("bjsqfs",form.value)}</td>
		</c:when>
		<c:when test="${form.name eq '申请者证件类型' }">
			<td class="addTd"><c:out value="${form.name}" /></td>
			<td align="left">${cp:MAPVALUE("PaperType",form.value)}</td>
		</c:when>
		<c:when test="${form.name eq '联系人/代理人证件类型' }">
			<td class="addTd"><c:out value="${form.name}" /></td>
			<td align="left">${cp:MAPVALUE("PaperType",form.value)}</td>
		</c:when>
		<c:when test="${form.name eq '承诺时限单位' }">
			<td class="addTd"><c:out value="${form.name}" /></td>
			<td align="left">${cp:MAPVALUE("Promise_Type",form.value)}</td>
		</c:when>
		<c:otherwise>
			<td class="addTd"><c:out value="${form.name}" /></td>
			<td align="left"><c:out value="${form.value}" /></td>
		</c:otherwise>
		</c:choose>
		</tr>
		
		</c:forEach>
	
		
	</table>

</body>
</html> 
