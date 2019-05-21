<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html>
<head>
<title></title>

</head>

<body>
<p align="center" class="title">
		<c:out value="${dispatchDoc.dispatchDocRed}" />
	</p>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="viewTable">
			
				<tr>
			<td class="addTd"><s:text name="dispatchDoc.dispatchDocNo" /></td>
			<td align="left"><c:out value="${dispatchDoc.dispatchDocNo}" /></td>
	
			<td class="addTd"><s:text name="dispatchDoc.dispatchDocTitle" /></td>
			<td align="left"><c:out value="${dispatchDoc.dispatchDocTitle}" /></td>
		</tr>
		
			<tr>
			<td class="addTd"><s:text name="dispatchDoc.printDate" /></td>
			<td align="left"><fmt:formatDate value='${dispatchDoc.printDate}' pattern='yyyy-MM-dd HH:mm:ss' /></td>
	
			<td class="addTd"><s:text name="dispatchDoc.criticalLevel" /></td>
			<td align="left">${cp:MAPVALUE("critical_level", dispatchDoc.criticalLevel)}</td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="dispatchDoc.dispatchFileType" /></td>
			<td align="left">${cp:MAPVALUE("dis_file_type", dispatchDoc.dispatchFileType)}</td>
	
			<td class="addTd"><s:text name="dispatchDoc.dispatchDocType" /></td>
			<td align="left">${cp:MAPVALUE("dis_doc_type", dispatchDoc.dispatchDocType)}</td>
		</tr>
		
		<tr>
			<td class="addTd"><s:text name="dispatchDoc.dispatchCanOpen" /></td>
			<td align="left">${cp:MAPVALUE("isPass", dispatchDoc.dispatchCanOpen)}</td>
		
			<td class="addTd"><s:text name="dispatchDoc.dispatchOpenType" /></td>
			<td align="left">${cp:MAPVALUE("dis_open_type", dispatchDoc.dispatchOpenType)}</td>
		</tr>
		
		<tr>
			<td class="addTd"><s:text name="dispatchDoc.notOpenReason" /></td>
			<td align="left"><c:out value="${dispatchDoc.notOpenReason}" /></td>
	
			<td class="addTd"><s:text name="dispatchDoc.isUnionDispatch" /></td>
			<td align="left">${cp:MAPVALUE("isPass", dispatchDoc.isUnionDispatch)}</td>
		</tr>
		
		<tr>
			<td class="addTd"><s:text name="dispatchDoc.unionOthers" /></td>
			<td align="left"><c:out value="${dispatchDoc.unionOthers}" /></td>
		
			<td class="addTd"><s:text name="dispatchDoc.isCountersign" /></td>
			<td align="left">${cp:MAPVALUE("isPass", dispatchDoc.isCountersign)}</td>
		</tr>
		
		<tr>
			<td class="addTd"><s:text name="dispatchDoc.dispatchDocSummary" /></td>
			<td align="left"><c:out value="${dispatchDoc.dispatchDocSummary}" /></td>
		
			<td class="addTd"><s:text name="dispatchDoc.draftDate" /></td>
			<td align="left"><fmt:formatDate value='${dispatchDoc.draftDate}' pattern='yyyy-MM-dd HH:mm:ss' /></td>
		</tr>
		
		<tr>
			<td class="addTd"><s:text name="dispatchDoc.optUnitName" /></td>
			<td align="left"><c:out value="${dispatchDoc.optUnitName}" /></td>
		
			<td class="addTd"><s:text name="dispatchDoc.draftUserName" /></td>
			<td align="left"><c:out value="${dispatchDoc.draftUserName}" /></td>
		</tr>
		
		<tr>
			<td class="addTd"><s:text name="dispatchDoc.secretsDegree" /></td>
			<td align="left">${cp:MAPVALUE("secretsDegree", dispatchDoc.secretsDegree)}</td>
		
			<td class="addTd"><s:text name="dispatchDoc.copies" /></td>
			<td align="left"><c:out value="${dispatchDoc.copies}" /></td>
		</tr>
		
		<tr>
			<td class="addTd"><s:text name="dispatchDoc.mainNotifyUnit" /></td>
			<td align="left"><c:out value="${dispatchDoc.mainNotifyUnit}" /></td>
	
			<td class="addTd"><s:text name="dispatchDoc.otherUnits" /></td>
			<td align="left"><c:out value="${dispatchDoc.otherUnits}" /></td>
		</tr>
		
		<tr>
			<td class="addTd"><s:text name="dispatchDoc.retentionPeriod" /></td>
			<td align="left"><fmt:formatDate value='${dispatchDoc.retentionPeriod}' pattern='yyyy-MM-dd HH:mm:ss' /></td>
	
			<td class="addTd"><s:text name="dispatchDoc.checkUserName" /></td>
			<td align="left"><c:out value="${dispatchDoc.checkUserName}" /></td>
		</tr>
		
		<tr>
			<td class="addTd"><s:text name="dispatchDoc.dispatchDocFile" /></td>
			<td align="left"><a href='dispatchDoc!downloadStuff.do?no=${dispatchDoc.no}'><c:out value="${dispatchDoc.dispatchDocFileName}" /></a></td>
	
			<td class="addTd"><s:text name="dispatchDoc.createDate" /></td>
			<td align="left"><fmt:formatDate value='${dispatchDoc.createDate}' pattern='yyyy-MM-dd HH:mm:ss' /></td>
		</tr>
		
	
		
		
	</table>

	

</body>
</html> 
