<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>


<html>
<head>
<title><c:out value="punishResult.view.title" /></title>

</head>

<body>

<table width="200" border="0" cellpadding="1" cellspacing="1" class="viewTable">
		<tr>
			<td class="addTd"><s:text name="punishResultLog.itemId" /></td>
			<td align="left" colspan="3"><c:out value="${punishResultLog.itemId}" /></td>
			
		</tr>
	<tr>
			<td class="addTd"><s:text name="权力名称" /></td>
			<td align="left" colspan="3">${cp:MAPVALUE("suppowerId",punishResultLog.itemId)}</td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishResultLog.program" /></td>
			<td align="left">${cp:MAPVALUE("PROGRAM",punishResultLog.program)}</td>
			<td class="addTd"><s:text name="punishResultLog.finishDate" /></td>
			<td align="left"><fmt:formatDate value='${punishResultLog.finishDate}' pattern='yyyy-MM-dd HH:mm:ss' /></td>
			
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishResultLog.punishSort" /></td>
			<td align="left" colspan="3"><c:out value="${punishResultLog.punishSort}" /></td>
			
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishResultLog.standard" /></td>
			<td align="left" colspan="3"><c:out value="${punishResultLog.standard}" /></td>
			
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishResultLog.punishDeside" /></td>
			<td align="left" colspan="3">${cp:MAPVALUE("PUNISH_DESIDE",punishResultLog.punishDeside)}</td>
			
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishResultLog.punishClass" /></td>
			<td align="left">  ${cp:MAPEXPRESSION("punishType", punishResultLog.punishClass)}</td>

			<td class="addTd"><s:text name="punishResultLog.punishResult" /></td>
			<td align="left"><c:out value="${punishResultLog.punishResult}" /></td>
			
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishResultLog.punishResultFine" /></td>
			<td align="left"><c:out value="${punishResultLog.punishResultFine}" /></td>

			<td class="addTd"><s:text name="punishResultLog.punishResultFinePeople" /></td>
			<td align="left"><c:out value="${punishResultLog.punishResultFinePeople}" /></td>
			
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishResultLog.punishResultExpropriation" /></td>
			<td align="left"><c:out value="${punishResultLog.punishResultExpropriation}" /></td>

			<td class="addTd"><s:text name="punishResultLog.punishResultExpropriationV" /></td>
			<td align="left"><c:out value="${punishResultLog.punishResultExpropriationV}" /></td>
			
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishResultLog.punishResultBusiness" /></td>
			<td align="left"><c:out value="${punishResultLog.punishResultBusiness}" /></td>

			<td class="addTd"><s:text name="punishResultLog.punishResultPeople" /></td>
			<td align="left"><c:out value="${punishResultLog.punishResultPeople}" /></td>
			
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishResultLog.punishResultDetain" /></td>
			<td align="left"><c:out value="${punishResultLog.punishResultDetain}" /></td>

			<td class="addTd"><s:text name="punishResultLog.finishDate" /></td>
			<td align="left"><fmt:formatDate value='${punishResultLog.finishDate}' pattern='yyyy-MM-dd HH:mm:ss' /></td>
			
		</tr>
		<tr>
			<td class="addTd"><s:text name="punishResultLog.accordance" /></td>
			<td align="left" colspan="3"><c:out value="${punishResultLog.accordance}" /></td>
			
		</tr>
	</table>

	

</body>
</html> 
