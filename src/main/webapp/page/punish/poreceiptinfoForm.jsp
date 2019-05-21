<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<html>
<head>
<title><c:out value="poreceiptinfo.edit.title" /></title>
<link href="<c:out value='${STYLE_PATH}'/>/css/am.css" type="text/css"
	rel="stylesheet">
<link href="<c:out value='${STYLE_PATH}'/>/css/messages.css" type="text/css"
	rel="stylesheet">

<script type="text/javascript"
	src="<c:url value='/page/common/validator.jsp'/>"></script>
<html:javascript formName="poreceiptinfoForm" staticJavascript="false"
	dynamicJavascript="true" cdata="false" />
</head>

<body>
<p class="ctitle"><c:out value="poreceiptinfo.edit.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<html:form action="/punish/poreceiptinfo"  styleId="poreceiptinfoForm" onsubmit="return validateporeceiptinfoForm(this);">
	<html:submit property="method_save" styleClass="btn" ><bean:message key="opt.btn.save" /></html:submit>
	<html:button styleClass="btn" onclick="window.history.back()" property="none"> <bean:message key="opt.btn.back" /> </html:button>
		
<table width="200" border="0" cellpadding="1" cellspacing="1">		
 
				<tr>
					<td class="TDTITLE">
						<c:out value="poreceiptinfo.poreceiptstate" />
					</td>
					<td align="left">
	
  
							<html:text property="poreceiptstate" readonly="${empty poreceiptinfoForm.map.poreceiptstate?'false':'true'}" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poreceiptinfo.punishobjectid" />
					</td>
					<td align="left">
	
  
							<html:text property="punishobjectid" readonly="${empty poreceiptinfoForm.map.punishobjectid?'false':'true'}" size="40" />
	
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<c:out value="poreceiptinfo.operatorname" />
					</td>
					<td align="left">
  
						<html:textarea property="operatorname" rows="1" cols="40" />
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poreceiptinfo.signinedname" />
					</td>
					<td align="left">
	
  
						<html:text property="signinedname" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poreceiptinfo.signineddate" />
					</td>
					<td align="left">
	
  
						<html:text property="signineddate" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poreceiptinfo.poreceiptname" />
					</td>
					<td align="left">
	
  
						<html:text property="poreceiptname" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poreceiptinfo.poreceiptdoc" />
					</td>
					<td align="left">
	
  
						<html:text property="poreceiptdoc" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poreceiptinfo.receiptmodel" />
					</td>
					<td align="left">
	
  
						<html:text property="receiptmodel" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poreceiptinfo.enregisterid" />
					</td>
					<td align="left">
	
  
						<html:text property="enregisterid" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poreceiptinfo.enregisterdate" />
					</td>
					<td align="left">
	
  
						<html:text property="enregisterdate" rows="1" size="40" />
	
					</td>
				</tr>

</table>


</html:form>
