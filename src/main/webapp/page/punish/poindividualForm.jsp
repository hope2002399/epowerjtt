<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<html>
<head>
<title><c:out value="poindividual.edit.title" /></title>
<link href="<c:out value='${STYLE_PATH}'/>/css/am.css" type="text/css"
	rel="stylesheet">
<link href="<c:out value='${STYLE_PATH}'/>/css/messages.css" type="text/css"
	rel="stylesheet">

<script type="text/javascript"
	src="<c:url value='/page/common/validator.jsp'/>"></script>
<html:javascript formName="poindividualForm" staticJavascript="false"
	dynamicJavascript="true" cdata="false" />
</head>

<body>
<p class="ctitle"><c:out value="poindividual.edit.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<html:form action="/punish/poindividual"  styleId="poindividualForm" onsubmit="return validatepoindividualForm(this);">
	<html:submit property="method_save" styleClass="btn" ><bean:message key="opt.btn.save" /></html:submit>
	<html:button styleClass="btn" onclick="window.history.back()" property="none"> <bean:message key="opt.btn.back" /> </html:button>
		
<table width="200" border="0" cellpadding="1" cellspacing="1">		
 
				<tr>
					<td class="TDTITLE">
						<c:out value="poindividual.punishobjectid" />
					</td>
					<td align="left">
	
  
							<html:text property="punishobjectid" readonly="${empty poindividualForm.map.punishobjectid?'false':'true'}" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poindividual.individualid" />
					</td>
					<td align="left">
	
  
							<html:text property="individualid" readonly="${empty poindividualForm.map.individualid?'false':'true'}" size="40" />
	
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<c:out value="poindividual.individualname" />
					</td>
					<td align="left">
	
  
						<html:text property="individualname" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poindividual.individualcode" />
					</td>
					<td align="left">
	
  
						<html:text property="individualcode" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poindividual.sex" />
					</td>
					<td align="left">
	
  
						<html:text property="sex" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poindividual.age" />
					</td>
					<td align="left">
	
  
						<html:text property="age" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poindividual.individualadress" />
					</td>
					<td align="left">
  
						<html:textarea property="individualadress" rows="1" cols="40" />
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poindividual.workunit" />
					</td>
					<td align="left">
  
						<html:textarea property="workunit" rows="1" cols="40" />
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poindividual.postcode" />
					</td>
					<td align="left">
	
  
						<html:text property="postcode" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poindividual.phone" />
					</td>
					<td align="left">
	
  
						<html:text property="phone" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poindividual.email" />
					</td>
					<td align="left">
	
  
						<html:text property="email" rows="1" size="40" />
	
					</td>
				</tr>

</table>


</html:form>
