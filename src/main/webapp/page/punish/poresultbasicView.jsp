<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<html>
<head>
<title><c:out value="poresultbasic.view.title" /></title>
<link href="<c:out value='${STYLE_PATH}'/>/css/am.css" type="text/css"
	rel="stylesheet">

<link href="<c:out value='${STYLE_PATH}'/>/css/messages.css" type="text/css"
	rel="stylesheet">

</head>

<body>
<p class="ctitle"><c:out value="poresultbasic.view.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<html:button styleClass="btn" onclick="window.history.back()" property="none">
	<bean:message key="opt.btn.back" />
</html:button>
<p>	
	
<table width="200" border="0" cellpadding="1" cellspacing="1">		
  
				<tr>
					<td class="TDTITLE">
						<c:out value="poresultbasic.punishobjectid" />
					</td>
					<td align="left">
						<c:out value="${poresultbasic.punishobjectid}" />
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<c:out value="poresultbasic.resulttype" />
					</td>
					<td align="left">
						<c:out value="${poresultbasic.resulttype}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poresultbasic.poneatencontent" />
					</td>
					<td align="left">
						<c:out value="${poresultbasic.poneatencontent}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poresultbasic.poarbitrationcontent" />
					</td>
					<td align="left">
						<c:out value="${poresultbasic.poarbitrationcontent}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poresultbasic.poquashreason" />
					</td>
					<td align="left">
						<c:out value="${poresultbasic.poquashreason}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poresultbasic.podeportationdepname" />
					</td>
					<td align="left">
						<c:out value="${poresultbasic.podeportationdepname}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poresultbasic.remark" />
					</td>
					<td align="left">
						<c:out value="${poresultbasic.remark}" />
					</td>
				</tr>	

</table>



</body>
</html>
