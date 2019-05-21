<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<html>
<head>
<title><c:out value="poundertakebasic.view.title" /></title>
<link href="<c:out value='${STYLE_PATH}'/>/css/am.css" type="text/css"
	rel="stylesheet">

<link href="<c:out value='${STYLE_PATH}'/>/css/messages.css" type="text/css"
	rel="stylesheet">

</head>

<body>
<p class="ctitle"><c:out value="poundertakebasic.view.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<html:button styleClass="btn" onclick="window.history.back()" property="none">
	<bean:message key="opt.btn.back" />
</html:button>
<p>	
	
<table width="200" border="0" cellpadding="1" cellspacing="1">		
  
				<tr>
					<td class="TDTITLE">
						<c:out value="poundertakebasic.punishobjectid" />
					</td>
					<td align="left">
						<c:out value="${poundertakebasic.punishobjectid}" />
					</td>
				</tr>
  
				<tr>
					<td class="TDTITLE">
						<c:out value="poundertakebasic.usercode" />
					</td>
					<td align="left">
						<c:out value="${poundertakebasic.usercode}" />
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<c:out value="poundertakebasic.depid" />
					</td>
					<td align="left">
						<c:out value="${poundertakebasic.depid}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poundertakebasic.sectionid" />
					</td>
					<td align="left">
						<c:out value="${poundertakebasic.sectionid}" />
					</td>
				</tr>	

</table>



</body>
</html>
