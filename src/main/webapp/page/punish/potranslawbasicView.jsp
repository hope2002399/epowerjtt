<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<html>
<head>
<title><c:out value="potranslawbasic.view.title" /></title>
<link href="<c:out value='${STYLE_PATH}'/>/css/am.css" type="text/css"
	rel="stylesheet">

<link href="<c:out value='${STYLE_PATH}'/>/css/messages.css" type="text/css"
	rel="stylesheet">

</head>

<body>
<p class="ctitle"><c:out value="potranslawbasic.view.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<html:button styleClass="btn" onclick="window.history.back()" property="none">
	<bean:message key="opt.btn.back" />
</html:button>
<p>	
	
<table width="200" border="0" cellpadding="1" cellspacing="1">		
  
				<tr>
					<td class="TDTITLE">
						<c:out value="potranslawbasic.punishclassid" />
					</td>
					<td align="left">
						<c:out value="${potranslawbasic.punishclassid}" />
					</td>
				</tr>
  
				<tr>
					<td class="TDTITLE">
						<c:out value="potranslawbasic.punishobjectid" />
					</td>
					<td align="left">
						<c:out value="${potranslawbasic.punishobjectid}" />
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<c:out value="potranslawbasic.degreeno" />
					</td>
					<td align="left">
						<c:out value="${potranslawbasic.degreeno}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="potranslawbasic.issurpass" />
					</td>
					<td align="left">
						<c:out value="${potranslawbasic.issurpass}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="potranslawbasic.translawdate" />
					</td>
					<td align="left">
						<c:out value="${potranslawbasic.translawdate}" />
					</td>
				</tr>	

</table>



</body>
</html>
