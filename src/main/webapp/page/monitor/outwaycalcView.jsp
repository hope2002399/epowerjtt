<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>


<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="" method="post" id="pagerForm">
		<div class="searchBar">
			<ul class="searchContent">
				
				<li><label><c:out value="outwaycalc.calcNo" />:</label> <c:out value="${outwaycalc.calcNo}" /></li>  
				<li><label><c:out value="outwaycalc.calcTime" />:</label> <c:out value="${outwaycalc.calcTime}" /></li> 
				<li><label><c:out value="outwaycalc.callType" />:</label> <c:out value="${outwaycalc.callType}" /></li> 
				<li><label><c:out value="outwaycalc.caller" />:</label> <c:out value="${outwaycalc.caller}" /></li> 
				<li><label><c:out value="outwaycalc.scopeBegin" />:</label> <c:out value="${outwaycalc.scopeBegin}" /></li> 
				<li><label><c:out value="outwaycalc.scopeEnd" />:</label> <c:out value="${outwaycalc.scopeEnd}" /></li> 
				<li><label><c:out value="outwaycalc.alertPieces" />:</label> <c:out value="${outwaycalc.alertPieces}" /></li> 
				<li><label><c:out value="outwaycalc.alarmPieces" />:</label> <c:out value="${outwaycalc.alarmPieces}" /></li> 
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
<title><c:out value="outwaycalc.view.title" /></title>
<link href="<c:out value='${STYLE_PATH}'/>/css/am.css" type="text/css" rel="stylesheet">

<link href="<c:out value='${STYLE_PATH}'/>/css/messages.css" type="text/css" rel="stylesheet">

</head>

<body>
	<p class="ctitle">
		<c:out value="outwaycalc.view.title" />
	</p>

	<%@ include file="/page/common/messages.jsp"%>

	<html:button styleClass="btn" onclick="window.history.back()" property="none">
		<bean:message key="opt.btn.back" />
	</html:button>
	<p>
	<table width="200" border="0" cellpadding="1" cellspacing="1">
		
		<tr>
			<td class="TDTITLE"><c:out value="outwaycalc.calcNo" /></td>
			<td align="left"><c:out value="${outwaycalc.calcNo}" /></td>
		</tr>
		 
		<tr>
			<td class="TDTITLE"><c:out value="outwaycalc.calcTime" /></td>
			<td align="left"><c:out value="${outwaycalc.calcTime}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="outwaycalc.callType" /></td>
			<td align="left"><c:out value="${outwaycalc.callType}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="outwaycalc.caller" /></td>
			<td align="left"><c:out value="${outwaycalc.caller}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="outwaycalc.scopeBegin" /></td>
			<td align="left"><c:out value="${outwaycalc.scopeBegin}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="outwaycalc.scopeEnd" /></td>
			<td align="left"><c:out value="${outwaycalc.scopeEnd}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="outwaycalc.alertPieces" /></td>
			<td align="left"><c:out value="${outwaycalc.alertPieces}" /></td>
		</tr>
		
		<tr>
			<td class="TDTITLE"><c:out value="outwaycalc.alarmPieces" /></td>
			<td align="left"><c:out value="${outwaycalc.alarmPieces}" /></td>
		</tr>
		
	</table>

	

</body>
</html> --%>
