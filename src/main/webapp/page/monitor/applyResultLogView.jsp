<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 


<html>
<head>
<title><c:out value="applyResultLog.view.title" /></title>

</head>

<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="viewTable">
		<tr>
			<td class="addTd" width="20%"><s:text name="applyResult.status" /></td>
			<td align="left" width="30%">${cp:MAPVALUE("STATUS",applyResultLog.status)}</td>
			<td class="addTd" width="20%"><s:text name="applyResult.finishTime" /></td>
			<td align="left" width="30%"><fmt:formatDate value='${applyResultLog.finishTime}' pattern='yyyy-MM-dd HH:mm:ss' /></td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="applyResult.note" /></td>
			<td align="left" colspan="3"><c:out value="${applyResultLog.note}" /></td>
			
		</tr>
	</table>


</body>
</html> 
