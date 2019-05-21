<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>


<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="" method="post" id="pagerForm">
		<div class="searchBar">
			<ul class="searchContent">
				
				<li><label><c:out value="applyDoc.no" />:</label> <c:out value="${applyDoc.no}" /></li>  
				<li><label><c:out value="applyDoc.updateDate" />:</label> <c:out value="${applyDoc.updateDate}" /></li> 
				<li><label><c:out value="applyDoc.readDate" />:</label> <c:out value="${applyDoc.readDate}" /></li> 
				<li><label><c:out value="applyDoc.syncSign" />:</label> <c:out value="${applyDoc.syncSign}" /></li> 
				<li><label><c:out value="applyDoc.errorDesc" />:</label> <c:out value="${applyDoc.errorDesc}" /></li> 
				<li><label><c:out value="applyDoc.itemId" />:</label> <c:out value="${applyDoc.itemId}" /></li> 
				<li><label><c:out value="applyDoc.internalNo" />:</label> <c:out value="${applyDoc.internalNo}" /></li> 
				<li><label><c:out value="applyDoc.processNo" />:</label> <c:out value="${applyDoc.processNo}" /></li> 
				<li><label><c:out value="applyDoc.docNo" />:</label> <c:out value="${applyDoc.docNo}" /></li> 
				<li><label><c:out value="applyDoc.docType" />:</label> <c:out value="${applyDoc.docType}" /></li> 
				<li><label><c:out value="applyDoc.docSort" />:</label> <c:out value="${applyDoc.docSort}" /></li> 
				<li><label><c:out value="applyDoc.docName" />:</label> <c:out value="${applyDoc.docName}" /></li> 
				<li><label><c:out value="applyDoc.documentName" />:</label> <c:out value="${applyDoc.documentName}" /></li> 
				<li><label><c:out value="applyDoc.docFile" />:</label> <c:out value="${applyDoc.docFile}" /></li> 
			</ul>

			<div class="subBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">检索</button>
							</div>
						</div></li>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<!-- 参数 navTabId 根据实际情况填写 -->
								<button type="button" onclick="javascript:navTabAjaxDone({'statusCode' : 200, 'callbackType' : 'closeCurrent', 'navTabId' : ''});">返回</button>
							</div>
						</div></li>
				</ul>
			</div>
		</div>
	</form>
</div>

<div class="pageContent">
	<div class="panelBar">
	</div>

	
</div>



<%-- 
<html>
<head>
<title><c:out value="applyDoc.view.title" /></title>
<link href="<c:out value='${STYLE_PATH}'/>/css/am.css" type="text/css" rel="stylesheet">

<link href="<c:out value='${STYLE_PATH}'/>/css/messages.css" type="text/css" rel="stylesheet">

</head>

<body>
	<p class="ctitle">
		<c:out value="applyDoc.view.title" />
	</p>

	<%@ include file="/page/common/messages.jsp"%>

	<html:button styleClass="btn" onclick="window.history.back()" property="none">
		<bean:message key="opt.btn.back" />
	</html:button>
	<p>
	<table width="200" border="0" cellpadding="1" cellspacing="1">
		
		<tr>
			<td class="TDTITLE"><c:out value="applyDoc.no" /></td>
			<td align="left"><c:out value="${applyDoc.no}" /></td>
		</tr>
		 
		<tr>
			<td class="TDTITLE"><c:out value="applyDoc.updateDate" /></td>
			<td align="left"><c:out value="${applyDoc.updateDate}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="applyDoc.readDate" /></td>
			<td align="left"><c:out value="${applyDoc.readDate}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="applyDoc.syncSign" /></td>
			<td align="left"><c:out value="${applyDoc.syncSign}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="applyDoc.errorDesc" /></td>
			<td align="left"><c:out value="${applyDoc.errorDesc}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="applyDoc.itemId" /></td>
			<td align="left"><c:out value="${applyDoc.itemId}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="applyDoc.internalNo" /></td>
			<td align="left"><c:out value="${applyDoc.internalNo}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="applyDoc.processNo" /></td>
			<td align="left"><c:out value="${applyDoc.processNo}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="applyDoc.docNo" /></td>
			<td align="left"><c:out value="${applyDoc.docNo}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="applyDoc.docType" /></td>
			<td align="left"><c:out value="${applyDoc.docType}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="applyDoc.docSort" /></td>
			<td align="left"><c:out value="${applyDoc.docSort}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="applyDoc.docName" /></td>
			<td align="left"><c:out value="${applyDoc.docName}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="applyDoc.documentName" /></td>
			<td align="left"><c:out value="${applyDoc.documentName}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="applyDoc.docFile" /></td>
			<td align="left"><c:out value="${applyDoc.docFile}" /></td>
		</tr>
		
	</table>

	

</body>
</html> --%>
