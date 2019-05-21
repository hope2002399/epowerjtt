<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<html>
<head>
<title><c:out value="poindividual.view.title" /></title>
<link href="<c:out value='${STYLE_PATH}'/>/css/am.css" type="text/css"
	rel="stylesheet">

<link href="<c:out value='${STYLE_PATH}'/>/css/messages.css" type="text/css"
	rel="stylesheet">

</head>

<body>
<p class="ctitle"><c:out value="poindividual.view.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<html:button styleClass="btn" onclick="window.history.back()" property="none">
	<bean:message key="opt.btn.back" />
</html:button>
<p>	
	
<table width="200" border="0" cellpadding="1" cellspacing="1">		
  
				<tr>
					<td class="TDTITLE">
						<c:out value="poindividual.punishobjectid" />
					</td>
					<td align="left">
						<c:out value="${poindividual.punishobjectid}" />
					</td>
				</tr>
  
				<tr>
					<td class="TDTITLE">
						<c:out value="poindividual.individualid" />
					</td>
					<td align="left">
						<c:out value="${poindividual.individualid}" />
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<c:out value="poindividual.individualname" />
					</td>
					<td align="left">
						<c:out value="${poindividual.individualname}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poindividual.individualcode" />
					</td>
					<td align="left">
						<c:out value="${poindividual.individualcode}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poindividual.sex" />
					</td>
					<td align="left">
						<c:out value="${poindividual.sex}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poindividual.age" />
					</td>
					<td align="left">
						<c:out value="${poindividual.age}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poindividual.individualadress" />
					</td>
					<td align="left">
						<c:out value="${poindividual.individualadress}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poindividual.workunit" />
					</td>
					<td align="left">
						<c:out value="${poindividual.workunit}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poindividual.postcode" />
					</td>
					<td align="left">
						<c:out value="${poindividual.postcode}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poindividual.phone" />
					</td>
					<td align="left">
						<c:out value="${poindividual.phone}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poindividual.email" />
					</td>
					<td align="left">
						<c:out value="${poindividual.email}" />
					</td>
				</tr>	

</table>



</body>
</html>
