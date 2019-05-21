<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<html>
<head>
<title><c:out value="poprintdef.edit.title" /></title>
<link href="<c:out value='${STYLE_PATH}'/>/css/am.css" type="text/css"
	rel="stylesheet">
<link href="<c:out value='${STYLE_PATH}'/>/css/messages.css" type="text/css"
	rel="stylesheet">

<script type="text/javascript"
	src="<c:url value='/page/common/validator.jsp'/>"></script>
<html:javascript formName="poprintdefForm" staticJavascript="false"
	dynamicJavascript="true" cdata="false" />
</head>

<body>
<p class="ctitle"><c:out value="poprintdef.edit.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<html:form action="/punish/poprintdef"  styleId="poprintdefForm" onsubmit="return validatepoprintdefForm(this);">
	<html:submit property="method_save" styleClass="btn" ><bean:message key="opt.btn.save" /></html:submit>
	<html:button styleClass="btn" onclick="window.history.back()" property="none"> <bean:message key="opt.btn.back" /> </html:button>
		
<table width="200" border="0" cellpadding="1" cellspacing="1">		
 
				<tr>
					<td class="TDTITLE">
						<c:out value="poprintdef.depid" />
					</td>
					<td align="left">
	
  
							<html:text property="depid" readonly="${empty poprintdefForm.map.depid?'false':'true'}" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poprintdef.printtype" />
					</td>
					<td align="left">
	
  
							<html:text property="printtype" readonly="${empty poprintdefForm.map.printtype?'false':'true'}" size="40" />
	
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<c:out value="poprintdef.ioprintcode" />
					</td>
					<td align="left">
	
  
						<html:text property="ioprintcode" rows="1" size="40" />
	
					</td>
				</tr>

</table>


</html:form>
