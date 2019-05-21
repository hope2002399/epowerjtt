<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 


<html>
<head>
<title><c:out value="applyResult.view.title" /></title>

</head>

<body>

	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="viewTable">
		<tr>
			<td class="addTd" width="20%"><s:text name="applyResult.status" /></td>
			<td align="left" width="30%">${cp:MAPVALUE("STATUS",result.status)}</td>
			<td class="addTd" width="20%"><s:text name="applyResult.finishTime" /></td>
			<td align="left" width="30%"><fmt:formatDate value='${result.finishTime}' pattern='yyyy-MM-dd HH:mm:ss' /></td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="applyResult.note" /></td>
			<td align="left" colspan="3"><c:out value="${result.note}" /></td>
			
		</tr>
		<tr>
			<td class="addTd"><s:text name="applyResult.attachment" /></td>
			<td align="left" colspan="3"><c:forEach items="${listStuff }" varStatus="i" var="doc" ><a href='applyDoc!downloadAtt.do?document_id=${doc.document_id}&no=${result.no}&type=3'>${doc.document_name}</a> </c:forEach></td>
		</tr>
	</table>

	

</body>
</html> 
