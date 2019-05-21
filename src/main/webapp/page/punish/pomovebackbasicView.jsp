<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<html>
<head>
<title><c:out value="pomovebackbasic.view.title" /></title>
<link href="<c:out value='${STYLE_PATH}'/>/css/am.css" type="text/css"
	rel="stylesheet">

<link href="<c:out value='${STYLE_PATH}'/>/css/messages.css" type="text/css"
	rel="stylesheet">

</head>

<body>
<p class="ctitle"><c:out value="pomovebackbasic.view.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<html:button styleClass="btn" onclick="window.history.back()" property="none">
	<bean:message key="opt.btn.back" />
</html:button>
<p>	
	
<table width="200" border="0" cellpadding="1" cellspacing="1">		
  
				<tr>
					<td class="TDTITLE">
						<c:out value="pomovebackbasic.sortno" />
					</td>
					<td align="left">
						<c:out value="${pomovebackbasic.sortno}" />
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<c:out value="pomovebackbasic.punishobjectid" />
					</td>
					<td align="left">
						<c:out value="${pomovebackbasic.punishobjectid}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="pomovebackbasic.stepworkid" />
					</td>
					<td align="left">
						<c:out value="${pomovebackbasic.stepworkid}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="pomovebackbasic.beginapprovecode" />
					</td>
					<td align="left">
						<c:out value="${pomovebackbasic.beginapprovecode}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="pomovebackbasic.endapprovecode" />
					</td>
					<td align="left">
						<c:out value="${pomovebackbasic.endapprovecode}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="pomovebackbasic.movebackdate" />
					</td>
					<td align="left">
						<c:out value="${pomovebackbasic.movebackdate}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="pomovebackbasic.operatorid" />
					</td>
					<td align="left">
						<c:out value="${pomovebackbasic.operatorid}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="pomovebackbasic.movebackcontent" />
					</td>
					<td align="left">
						<c:out value="${pomovebackbasic.movebackcontent}" />
					</td>
				</tr>	

</table>



</body>
</html>
