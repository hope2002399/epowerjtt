<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<html>
<head>
<title><c:out value="popunishbasic.view.title" /></title>
<link href="<c:out value='${STYLE_PATH}'/>/css/am.css" type="text/css"
	rel="stylesheet">

<link href="<c:out value='${STYLE_PATH}'/>/css/messages.css" type="text/css"
	rel="stylesheet">

</head>

<body>
<p class="ctitle"><c:out value="popunishbasic.view.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<html:button styleClass="btn" onclick="window.history.back()" property="none">
	<bean:message key="opt.btn.back" />
</html:button>
<p>	
	
<table width="200" border="0" cellpadding="1" cellspacing="1">		
  
				<tr>
					<td class="TDTITLE">
						<c:out value="popunishbasic.punishobjectid" />
					</td>
					<td align="left">
						<c:out value="${popunishbasic.punishobjectid}" />
					</td>
				</tr>
  
				<tr>
					<td class="TDTITLE">
						<c:out value="popunishbasic.punishtypeid" />
					</td>
					<td align="left">
						<c:out value="${popunishbasic.punishtypeid}" />
					</td>
				</tr>
  
				<tr>
					<td class="TDTITLE">
						<c:out value="popunishbasic.punishclassid" />
					</td>
					<td align="left">
						<c:out value="${popunishbasic.punishclassid}" />
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<c:out value="popunishbasic.punishvalue" />
					</td>
					<td align="left">
						<c:out value="${popunishbasic.punishvalue}" />
					</td>
				</tr>	

</table>



</body>
</html>
