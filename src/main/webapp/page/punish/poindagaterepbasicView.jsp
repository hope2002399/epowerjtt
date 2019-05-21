<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<html>
<head>
<title><c:out value="poindagaterepbasic.view.title" /></title>
<link href="<c:out value='${STYLE_PATH}'/>/css/am.css" type="text/css"
	rel="stylesheet">

<link href="<c:out value='${STYLE_PATH}'/>/css/messages.css" type="text/css"
	rel="stylesheet">

</head>

<body>
<p class="ctitle"><c:out value="poindagaterepbasic.view.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<html:button styleClass="btn" onclick="window.history.back()" property="none">
	<bean:message key="opt.btn.back" />
</html:button>
<p>	
	
<table width="200" border="0" cellpadding="1" cellspacing="1">		
  
				<tr>
					<td class="TDTITLE">
						<c:out value="poindagaterepbasic.punishobjectid" />
					</td>
					<td align="left">
						<c:out value="${poindagaterepbasic.punishobjectid}" />
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<c:out value="poindagaterepbasic.confirmtruth" />
					</td>
					<td align="left">
						<c:out value="${poindagaterepbasic.confirmtruth}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poindagaterepbasic.unconfirmtruth" />
					</td>
					<td align="left">
						<c:out value="${poindagaterepbasic.unconfirmtruth}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poindagaterepbasic.poindagatereppassage" />
					</td>
					<td align="left">
						<c:out value="${poindagaterepbasic.poindagatereppassage}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poindagaterepbasic.disobeyitem" />
					</td>
					<td align="left">
						<c:out value="${poindagaterepbasic.disobeyitem}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poindagaterepbasic.poindagaterepresult" />
					</td>
					<td align="left">
						<c:out value="${poindagaterepbasic.poindagaterepresult}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poindagaterepbasic.isdiscuss" />
					</td>
					<td align="left">
						<c:out value="${poindagaterepbasic.isdiscuss}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poindagaterepbasic.poindagaterepreportdoc" />
					</td>
					<td align="left">
						<c:out value="${poindagaterepbasic.poindagaterepreportdoc}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poindagaterepbasic.poindagaterepreportdocname" />
					</td>
					<td align="left">
						<c:out value="${poindagaterepbasic.poindagaterepreportdocname}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poindagaterepbasic.poindagaterepstate" />
					</td>
					<td align="left">
						<c:out value="${poindagaterepbasic.poindagaterepstate}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poindagaterepbasic.poindagaterepstep" />
					</td>
					<td align="left">
						<c:out value="${poindagaterepbasic.poindagaterepstep}" />
					</td>
				</tr>	

</table>



</body>
</html>
