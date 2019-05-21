<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>


<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="" method="post" id="pagerForm">
		<div class="searchBar">
			<ul class="searchContent">
				
				<li><label><c:out value="punishDoc.no" />:</label> <c:out value="${punishDoc.no}" /></li>  
				<li><label><c:out value="punishDoc.updateDate" />:</label> <c:out value="${punishDoc.updateDate}" /></li> 
				<li><label><c:out value="punishDoc.readDate" />:</label> <c:out value="${punishDoc.readDate}" /></li> 
				<li><label><c:out value="punishDoc.syncSign" />:</label> <c:out value="${punishDoc.syncSign}" /></li> 
				<li><label><c:out value="punishDoc.errorDesc" />:</label> <c:out value="${punishDoc.errorDesc}" /></li> 
				<li><label><c:out value="punishDoc.orgId" />:</label> <c:out value="${punishDoc.orgId}" /></li> 
				<li><label><c:out value="punishDoc.internalNo" />:</label> <c:out value="${punishDoc.internalNo}" /></li> 
				<li><label><c:out value="punishDoc.processNo" />:</label> <c:out value="${punishDoc.processNo}" /></li> 
				<li><label><c:out value="punishDoc.docNo" />:</label> <c:out value="${punishDoc.docNo}" /></li> 
				<li><label><c:out value="punishDoc.docType" />:</label> <c:out value="${punishDoc.docType}" /></li> 
				<li><label><c:out value="punishDoc.docSort" />:</label> <c:out value="${punishDoc.docSort}" /></li> 
				<li><label><c:out value="punishDoc.docName" />:</label> <c:out value="${punishDoc.docName}" /></li> 
				<li><label><c:out value="punishDoc.documentName" />:</label> <c:out value="${punishDoc.documentName}" /></li> 
				<li><label><c:out value="punishDoc.docFile" />:</label> <c:out value="${punishDoc.docFile}" /></li> 
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
<title><c:out value="punishDoc.view.title" /></title>
<link href="<c:out value='${STYLE_PATH}'/>/css/am.css" type="text/css" rel="stylesheet">

<link href="<c:out value='${STYLE_PATH}'/>/css/messages.css" type="text/css" rel="stylesheet">

</head>

<body>
	<p class="ctitle">
		<c:out value="punishDoc.view.title" />
	</p>

	<%@ include file="/page/common/messages.jsp"%>

	<html:button styleClass="btn" onclick="window.history.back()" property="none">
		<bean:message key="opt.btn.back" />
	</html:button>
	<p>
	<table width="200" border="0" cellpadding="1" cellspacing="1">
		
		<tr>
			<td class="TDTITLE"><c:out value="punishDoc.no" /></td>
			<td align="left"><c:out value="${punishDoc.no}" /></td>
		</tr>
		 
		<tr>
			<td class="TDTITLE"><c:out value="punishDoc.updateDate" /></td>
			<td align="left"><c:out value="${punishDoc.updateDate}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="punishDoc.readDate" /></td>
			<td align="left"><c:out value="${punishDoc.readDate}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="punishDoc.syncSign" /></td>
			<td align="left"><c:out value="${punishDoc.syncSign}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="punishDoc.errorDesc" /></td>
			<td align="left"><c:out value="${punishDoc.errorDesc}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="punishDoc.orgId" /></td>
			<td align="left"><c:out value="${punishDoc.orgId}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="punishDoc.internalNo" /></td>
			<td align="left"><c:out value="${punishDoc.internalNo}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="punishDoc.processNo" /></td>
			<td align="left"><c:out value="${punishDoc.processNo}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="punishDoc.docNo" /></td>
			<td align="left"><c:out value="${punishDoc.docNo}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="punishDoc.docType" /></td>
			<td align="left"><c:out value="${punishDoc.docType}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="punishDoc.docSort" /></td>
			<td align="left"><c:out value="${punishDoc.docSort}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="punishDoc.docName" /></td>
			<td align="left"><c:out value="${punishDoc.docName}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="punishDoc.documentName" /></td>
			<td align="left"><c:out value="${punishDoc.documentName}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="punishDoc.docFile" /></td>
			<td align="left"><c:out value="${punishDoc.docFile}" /></td>
		</tr>
		
	</table>

	

</body>
</html> --%>
