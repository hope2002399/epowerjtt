<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>


<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="" method="post" id="pagerForm">
		<div class="searchBar">
			<ul class="searchContent">
				
				<li><label><c:out value="outwayparam.paramNo" />:</label> <c:out value="${outwayparam.paramNo}" /></li>  
				<li><label><c:out value="outwayparam.paramName" />:</label> <c:out value="${outwayparam.paramName}" /></li> 
				<li><label><c:out value="outwayparam.defaultValue" />:</label> <c:out value="${outwayparam.defaultValue}" /></li> 
				<li><label><c:out value="outwayparam.paramValue" />:</label> <c:out value="${outwayparam.paramValue}" /></li> 
				<li><label><c:out value="outwayparam.paramDesc" />:</label> <c:out value="${outwayparam.paramDesc}" /></li> 
				<li><label><c:out value="outwayparam.paramType" />:</label> <c:out value="${outwayparam.paramType}" /></li> 
			</ul>

			<div class="subBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">�?��</button>
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
<title><c:out value="outwayparam.view.title" /></title>
<link href="<c:out value='${STYLE_PATH}'/>/css/am.css" type="text/css" rel="stylesheet">

<link href="<c:out value='${STYLE_PATH}'/>/css/messages.css" type="text/css" rel="stylesheet">

</head>

<body>
	<p class="ctitle">
		<c:out value="outwayparam.view.title" />
	</p>

	<%@ include file="/page/common/messages.jsp"%>

	<html:button styleClass="btn" onclick="window.history.back()" property="none">
		<bean:message key="opt.btn.back" />
	</html:button>
	<p>
	<table width="200" border="0" cellpadding="1" cellspacing="1">
		
		<tr>
			<td class="TDTITLE"><c:out value="outwayparam.paramNo" /></td>
			<td align="left"><c:out value="${outwayparam.paramNo}" /></td>
		</tr>
		 
		<tr>
			<td class="TDTITLE"><c:out value="outwayparam.paramName" /></td>
			<td align="left"><c:out value="${outwayparam.paramName}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="outwayparam.defaultValue" /></td>
			<td align="left"><c:out value="${outwayparam.defaultValue}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="outwayparam.paramValue" /></td>
			<td align="left"><c:out value="${outwayparam.paramValue}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="outwayparam.paramDesc" /></td>
			<td align="left"><c:out value="${outwayparam.paramDesc}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="outwayparam.paramType" /></td>
			<td align="left"><c:out value="${outwayparam.paramType}" /></td>
		</tr>
		
	</table>

	

</body>
</html> --%>
