<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<html>
<head>
<title><c:out value="poenterprise.edit.title" /></title>
<link href="<c:out value='${STYLE_PATH}'/>/css/am.css" type="text/css"
	rel="stylesheet">
<link href="<c:out value='${STYLE_PATH}'/>/css/messages.css" type="text/css"
	rel="stylesheet">

<script type="text/javascript"
	src="<c:url value='/page/common/validator.jsp'/>"></script>
<html:javascript formName="poenterpriseForm" staticJavascript="false"
	dynamicJavascript="true" cdata="false" />
</head>

<body>
<p class="ctitle"><c:out value="poenterprise.edit.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<html:form action="/punish/poenterprise"  styleId="poenterpriseForm" onsubmit="return validatepoenterpriseForm(this);">
	<html:submit property="method_save" styleClass="btn" ><bean:message key="opt.btn.save" /></html:submit>
	<html:button styleClass="btn" onclick="window.history.back()" property="none"> <bean:message key="opt.btn.back" /> </html:button>
		
<table width="200" border="0" cellpadding="1" cellspacing="1">		
 
				<tr>
					<td class="TDTITLE">
						<c:out value="poenterprise.punishobjectid" />
					</td>
					<td align="left">
	
  
							<html:text property="punishobjectid" readonly="${empty poenterpriseForm.map.punishobjectid?'false':'true'}" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poenterprise.enterpriseid" />
					</td>
					<td align="left">
	
  
							<html:text property="enterpriseid" readonly="${empty poenterpriseForm.map.enterpriseid?'false':'true'}" size="40" />
	
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<c:out value="poenterprise.enterprisename" />
					</td>
					<td align="left">
	
  
						<html:text property="enterprisename" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poenterprise.enterprisecode" />
					</td>
					<td align="left">
	
  
						<html:text property="enterprisecode" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poenterprise.enterpriseaddress" />
					</td>
					<td align="left">
  
						<html:textarea property="enterpriseaddress" rows="1" cols="40" />
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poenterprise.unittype" />
					</td>
					<td align="left">
	
  
						<html:text property="unittype" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poenterprise.corpdomain" />
					</td>
					<td align="left">
	
  
						<html:text property="corpdomain" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poenterprise.regtype" />
					</td>
					<td align="left">
	
  
						<html:text property="regtype" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poenterprise.mastername" />
					</td>
					<td align="left">
	
  
						<html:text property="mastername" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poenterprise.postcode" />
					</td>
					<td align="left">
	
  
						<html:text property="postcode" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poenterprise.phone" />
					</td>
					<td align="left">
	
  
						<html:text property="phone" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poenterprise.linker" />
					</td>
					<td align="left">
	
  
						<html:text property="linker" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poenterprise.fax" />
					</td>
					<td align="left">
	
  
						<html:text property="fax" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poenterprise.email" />
					</td>
					<td align="left">
	
  
						<html:text property="email" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poenterprise.isvip" />
					</td>
					<td align="left">
	
  
						<html:text property="isvip" rows="1" size="40" />
	
					</td>
				</tr>

</table>


</html:form>
