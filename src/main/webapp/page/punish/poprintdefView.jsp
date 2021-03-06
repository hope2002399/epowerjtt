<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<html>
<head>
<title><c:out value="poprintdef.view.title" /></title>
<link href="<c:out value='${STYLE_PATH}'/>/css/am.css" type="text/css"
	rel="stylesheet">

<link href="<c:out value='${STYLE_PATH}'/>/css/messages.css" type="text/css"
	rel="stylesheet">

</head>

<body>
<p class="ctitle"><c:out value="poprintdef.view.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<html:button styleClass="btn" onclick="window.history.back()" property="none">
	<bean:message key="opt.btn.back" />
</html:button>
<p>	
	
<table width="200" border="0" cellpadding="1" cellspacing="1">		
  
				<tr>
					<td class="TDTITLE">
						<c:out value="poprintdef.depid" />
					</td>
					<td align="left">
						<c:out value="${poprintdef.depid}" />
					</td>
				</tr>
  
				<tr>
					<td class="TDTITLE">
						<c:out value="poprintdef.printtype" />
					</td>
					<td align="left">
						<c:out value="${poprintdef.printtype}" />
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<c:out value="poprintdef.ioprintcode" />
					</td>
					<td align="left">
						<c:out value="${poprintdef.ioprintcode}" />
					</td>
				</tr>	

</table>



</body>
</html>
