<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<html>
<head>
<title><c:out value="poenterprise.view.title" /></title>
<link href="<c:out value='${STYLE_PATH}'/>/css/am.css" type="text/css"
	rel="stylesheet">

<link href="<c:out value='${STYLE_PATH}'/>/css/messages.css" type="text/css"
	rel="stylesheet">

</head>

<body>
<p class="ctitle"><c:out value="poenterprise.view.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<html:button styleClass="btn" onclick="window.history.back()" property="none">
	<bean:message key="opt.btn.back" />
</html:button>
<p>	
	
<table width="200" border="0" cellpadding="1" cellspacing="1">		
  
				<tr>
					<td class="TDTITLE">
						<c:out value="poenterprise.punishobjectid" />
					</td>
					<td align="left">
						<c:out value="${poenterprise.punishobjectid}" />
					</td>
				</tr>
  
				<tr>
					<td class="TDTITLE">
						<c:out value="poenterprise.enterpriseid" />
					</td>
					<td align="left">
						<c:out value="${poenterprise.enterpriseid}" />
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<c:out value="poenterprise.enterprisename" />
					</td>
					<td align="left">
						<c:out value="${poenterprise.enterprisename}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poenterprise.enterprisecode" />
					</td>
					<td align="left">
						<c:out value="${poenterprise.enterprisecode}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poenterprise.enterpriseaddress" />
					</td>
					<td align="left">
						<c:out value="${poenterprise.enterpriseaddress}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poenterprise.unittype" />
					</td>
					<td align="left">
						<c:out value="${poenterprise.unittype}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poenterprise.corpdomain" />
					</td>
					<td align="left">
						<c:out value="${poenterprise.corpdomain}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poenterprise.regtype" />
					</td>
					<td align="left">
						<c:out value="${poenterprise.regtype}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poenterprise.mastername" />
					</td>
					<td align="left">
						<c:out value="${poenterprise.mastername}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poenterprise.postcode" />
					</td>
					<td align="left">
						<c:out value="${poenterprise.postcode}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poenterprise.phone" />
					</td>
					<td align="left">
						<c:out value="${poenterprise.phone}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poenterprise.linker" />
					</td>
					<td align="left">
						<c:out value="${poenterprise.linker}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poenterprise.fax" />
					</td>
					<td align="left">
						<c:out value="${poenterprise.fax}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poenterprise.email" />
					</td>
					<td align="left">
						<c:out value="${poenterprise.email}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<c:out value="poenterprise.isvip" />
					</td>
					<td align="left">
						<c:out value="${poenterprise.isvip}" />
					</td>
				</tr>	

</table>



</body>
</html>
