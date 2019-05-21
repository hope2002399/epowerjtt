<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>


<html>
<head>
<title><c:out value="punishResult.view.title" /></title>

</head>

<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="viewTable">
	
		<tr>
			<td class="addTd"><s:text name="punishResult.itemId" /></td>
			<td align="left" colspan="3"><c:out value="${result.itemId}" /></td>
			
		</tr>
	<tr>
			<td class="addTd"><s:text name="权力名称" /></td>
			<td align="left" colspan="3">${cp:MAPVALUE("suppowerId",result.itemId)}</td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishResult.program" /></td>
			<td align="left">${cp:MAPVALUE("PROGRAM",result.program)}</td>
			<td class="addTd"><s:text name="punishResult.finishDate" /></td>
			<td align="left"><fmt:formatDate value='${result.finishDate}' pattern='yyyy-MM-dd HH:mm:ss' /></td>
			
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishResult.standard" /></td>
			<td align="left" colspan="3"><c:out value="${result.standard}" /></td>
			
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishResult.punishDeside" /></td>
			<td align="left" colspan="3">${cp:MAPVALUE("PUNISH_DESIDE",result.punishDeside)}</td>
			
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishResult.punishClass" /></td>
			<td align="left">  ${cp:MAPEXPRESSION("punishType", result.punishClass)}</td>

			<td class="addTd"><s:text name="punishResult.punishResult" /></td>
			<td align="left"><c:out value="${result.punishResult}" /></td>
			
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishResult.punishResultFine" /></td>
			<td align="left"><c:out value="${result.punishResultFine}" /></td>

			<td class="addTd"><s:text name="punishResult.punishResultFinePeople" /></td>
			<td align="left"><c:out value="${result.punishResultFinePeople}" /></td>
			
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishResult.punishResultExpropriation" /></td>
			<td align="left"><c:out value="${result.punishResultExpropriation}" /></td>

			<td class="addTd"><s:text name="punishResult.punishResultExpropriationV" /></td>
			<td align="left"><c:out value="${result.punishResultExpropriationV}" /></td>
			
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishResult.punishResultBusiness" /></td>
			<td align="left"><c:out value="${result.punishResultBusiness}" /></td>

			<td class="addTd"><s:text name="punishResult.punishResultPeople" /></td>
			<td align="left"><c:out value="${result.punishResultPeople}" /></td>
			
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishResult.punishResultDetain" /></td>
			<td align="left" colspan="3"><c:out value="${result.punishResultDetain}" /></td>

			
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishResult.accordance" /></td>
			<td align="left" colspan="3"><c:out value="${result.accordance}" /></td>
			
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishResult.attachment" /></td>
			<td align="left" colspan="3"><c:forEach items="${listStuff }" varStatus="i" var="doc" ><a href='punishDoc!downloadAtt.do?document_id=${doc.document_id}&no=${result.no}&type=3'>${doc.document_name}</a> </c:forEach></td>
		</tr>
	</table>

	

</body>
</html> 
