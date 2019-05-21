<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<html>
<head>
<title><c:out value="outwayWarnpoint.view.title" /></title>
<link href="<c:out value='${STYLE_PATH}'/>/css/am.css" type="text/css"
	rel="stylesheet">

<link href="<c:out value='${STYLE_PATH}'/>/css/messages.css" type="text/css"
	rel="stylesheet">

</head>

<body>
<p class="ctitle"><c:out value="outwayWarnpoint.view.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<html:button styleClass="btn" onclick="window.history.back()" property="none">
	<bean:message key="opt.btn.back" />
</html:button>
<p>	
	
<table width="200" border="0" cellpadding="1" cellspacing="1">		
  
				<tr>
					<td class="TDTITLE">
						<c:out value="outwayWarnpoint.wpNo" />
					</td>
					<td align="left">
						<c:out value="${outwayWarnpoint.wpNo}" />
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<c:out value="outwayWarnpoint.wpType" />
					</td>
					<td align="left">
						<c:out value="${outwayWarnpoint.wpType}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="outwayWarnpoint.wpLevel" />
					</td>
					<td align="left">
						<c:out value="${outwayWarnpoint.wpLevel}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="outwayWarnpoint.wpLevelNo" />
					</td>
					<td align="left">
						<c:out value="${outwayWarnpoint.wpLevelNo}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="outwayWarnpoint.wpDesc" />
					</td>
					<td align="left">
						<c:out value="${outwayWarnpoint.wpDesc}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="outwayWarnpoint.wpTypeNo" />
					</td>
					<td align="left">
						<c:out value="${outwayWarnpoint.wpTypeNo}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="outwayWarnpoint.wpStatus" />
					</td>
					<td align="left">
						<c:out value="${outwayWarnpoint.wpStatus}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="outwayWarnpoint.wpSource" />
					</td>
					<td align="left">
						<c:out value="${outwayWarnpoint.wpSource}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="outwayWarnpoint.wpOracle" />
					</td>
					<td align="left">
						<c:out value="${outwayWarnpoint.wpOracle}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="outwayWarnpoint.wpOracleSql" />
					</td>
					<td align="left">
						<c:out value="${outwayWarnpoint.wpOracleSql}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="outwayWarnpoint.wpRuning" />
					</td>
					<td align="left">
						<c:out value="${outwayWarnpoint.wpRuning}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="outwayWarnpoint.wpExeType" />
					</td>
					<td align="left">
						<c:out value="${outwayWarnpoint.wpExeType}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="outwayWarnpoint.wpExeRule" />
					</td>
					<td align="left">
						<c:out value="${outwayWarnpoint.wpExeRule}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="outwayWarnpoint.wpName" />
					</td>
					<td align="left">
						<c:out value="${outwayWarnpoint.wpName}" />
					</td>
				</tr>	

</table>



</body>
</html>
