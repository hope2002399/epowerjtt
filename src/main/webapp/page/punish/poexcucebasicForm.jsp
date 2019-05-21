<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<html>
<head>
<title><c:out value="poexcucebasic.edit.title" /></title>
<link href="<c:out value='${STYLE_PATH}'/>/css/am.css" type="text/css"
	rel="stylesheet">
<link href="<c:out value='${STYLE_PATH}'/>/css/messages.css" type="text/css"
	rel="stylesheet">

<script type="text/javascript"
	src="<c:url value='/page/common/validator.jsp'/>"></script>
<html:javascript formName="poexcucebasicForm" staticJavascript="false"
	dynamicJavascript="true" cdata="false" />
</head>

<body>
<p class="ctitle"><c:out value="poexcucebasic.edit.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<html:form action="/punish/poexcucebasic"  styleId="poexcucebasicForm" onsubmit="return validatepoexcucebasicForm(this);">
	<html:submit property="method_save" styleClass="btn" ><bean:message key="opt.btn.save" /></html:submit>
	<html:button styleClass="btn" onclick="window.history.back()" property="none"> <bean:message key="opt.btn.back" /> </html:button>
		
<table width="200" border="0" cellpadding="1" cellspacing="1">		
 
				<tr>
					<td class="TDTITLE">
						<c:out value="poexcucebasic.punishobjectid" />
					</td>
					<td align="left">
	
  
							<html:text property="punishobjectid" readonly="${empty poexcucebasicForm.map.punishobjectid?'false':'true'}" size="40" />
	
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<c:out value="poexcucebasic.poexcucedate" />
					</td>
					<td align="left">
	
  
						<html:text property="poexcucedate" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poexcucebasic.poexcuceadress" />
					</td>
					<td align="left">
  
						<html:textarea property="poexcuceadress" rows="1" cols="40" />
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poexcucebasic.undertakername" />
					</td>
					<td align="left">
	
  
						<html:text property="undertakername" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poexcucebasic.undertakecertno" />
					</td>
					<td align="left">
	
  
						<html:text property="undertakecertno" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poexcucebasic.registercertno" />
					</td>
					<td align="left">
	
  
						<html:text property="registercertno" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poexcucebasic.registerid" />
					</td>
					<td align="left">
	
  
						<html:text property="registerid" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poexcucebasic.deputyname" />
					</td>
					<td align="left">
	
  
						<html:text property="deputyname" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poexcucebasic.excucedate" />
					</td>
					<td align="left">
	
  
						<html:text property="excucedate" rows="1" size="40" />
	
					</td>
				</tr>

</table>


</html:form>
