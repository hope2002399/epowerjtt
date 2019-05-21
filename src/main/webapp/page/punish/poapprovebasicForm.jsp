<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<html>
<head>
<title><c:out value="poapprovebasic.edit.title" /></title>
<link href="<c:out value='${STYLE_PATH}'/>/css/am.css" type="text/css"
	rel="stylesheet">
<link href="<c:out value='${STYLE_PATH}'/>/css/messages.css" type="text/css"
	rel="stylesheet">

<script type="text/javascript"
	src="<c:url value='/page/common/validator.jsp'/>"></script>
<html:javascript formName="poapprovebasicForm" staticJavascript="false"
	dynamicJavascript="true" cdata="false" />
</head>

<body>
<p class="ctitle"><c:out value="poapprovebasic.edit.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<html:form action="/punish/poapprovebasic"  styleId="poapprovebasicForm" onsubmit="return validatepoapprovebasicForm(this);">
	<html:submit property="method_save" styleClass="btn" ><bean:message key="opt.btn.save" /></html:submit>
	<html:button styleClass="btn" onclick="window.history.back()" property="none"> <bean:message key="opt.btn.back" /> </html:button>
		
<table width="200" border="0" cellpadding="1" cellspacing="1">		
 
				<tr>
					<td class="TDTITLE">
						<c:out value="poapprovebasic.punishobjectid" />
					</td>
					<td align="left">
	
  
							<html:text property="punishobjectid" readonly="${empty poapprovebasicForm.map.punishobjectid?'false':'true'}" size="40" />
	
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<c:out value="poapprovebasic.poapprovestep" />
					</td>
					<td align="left">
	
  
						<html:text property="poapprovestep" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poapprovebasic.ispass" />
					</td>
					<td align="left">
	
  
						<html:text property="ispass" rows="1" size="40" />
	
					</td>
				</tr>

</table>


</html:form>
