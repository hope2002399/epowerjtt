<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html>
<head>
<title></title>

</head>

<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="viewTable">
		<tr>
			<td class="addTd"><s:text name="incomeDoc.incomeDocTitle" /></td>
			<td align="left" colspan="5"><c:out value="${incomeDoc.incomeDocTitle}" /></td>
		</tr>
		<tr>
			<td class="addTd"><s:text name="incomeDoc.acceptNo" /></td>
			<td align="left"  colspan="5"><c:out value="${incomeDoc.acceptNo}" /></td>
		</tr>
		
		<tr>
			<td class="addTd"><s:text name="incomeDoc.incomeDocNo" /></td>
			<td align="left"><c:out value="${incomeDoc.incomeDocNo}" /></td>
		
			<td class="addTd"><s:text name="incomeDoc.incomeDeptName" /></td>
			<td align="left" colspan="3"><c:out value="${incomeDoc.incomeDeptName}" /></td>
		</tr>
		<tr>
			<td class="addTd">申报人员姓名</td>
			<td align="left"><c:out value="${incomeDoc.applicantPeopleName}" /></td>
		
			<td class="addTd">申报时间</td>
			<td align="left"><fmt:formatDate value='${incomeDoc.applyDate}' pattern='yyyy-MM-dd HH:mm:ss' /></td>
		<td class="addTd">申报人员手机</td>
			<td align="left"><c:out value="${incomeDoc.applicantMobile}" /></td>
		
		</tr>
		
		<tr>
			<td class="addTd"><s:text name="incomeDoc.incomeDocFile" /></td>
			<td align="left"  colspan="5"><a href='incomeDoc!downloadStuff.do?no=${incomeDoc.no}'><c:out value="${incomeDoc.incomeDocFileName}" /></a></td>
		</tr>
		
	
		
		<tr>
			<td class="addTd">附件材料</td>
			<td align="left"  colspan="5"><c:forEach items="${incomeDoc.docList }" varStatus="i" var="doc" ><a href='applyDoc!downloadStuff.do?no=${doc.no}'>${doc.docName}</a> </c:forEach></td>
		</tr>
		<tr>
			<td class="addTd">申报单位名称</td>
			<td align="left"><c:out value="${incomeDoc.applicantName}" /></td>
		
			<td class="addTd">申报单位联系人</td>
			<td align="left" colspan="3"><c:out value="${incomeDoc.linkmanName}" /></td>
		
		</tr>
		<tr>
			<td class="addTd">申报单位电话</td>
			<td align="left"><c:out value="${incomeDoc.applicantPhone}" /></td>
		
			<td class="addTd">申报单位邮件</td>
			<td align="left" colspan="3"><c:out value="${incomeDoc.applicantEmail}" /></td>
		
		</tr>
		
	</table>

	

</body>
</html> 
