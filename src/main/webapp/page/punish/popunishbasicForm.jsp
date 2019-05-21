<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<html>
<head>
<title><c:out value="popunishbasic.edit.title" /></title>
<link href="<c:out value='${STYLE_PATH}'/>/css/am.css" type="text/css"
	rel="stylesheet">
<link href="<c:out value='${STYLE_PATH}'/>/css/messages.css" type="text/css"
	rel="stylesheet">

<script type="text/javascript"
	src="<c:url value='/page/common/validator.jsp'/>"></script>
<html:javascript formName="popunishbasicForm" staticJavascript="false"
	dynamicJavascript="true" cdata="false" />
</head>

<body>
<p class="ctitle"><c:out value="popunishbasic.edit.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<html:form action="/punish/popunishbasic"  styleId="popunishbasicForm" onsubmit="return validatepopunishbasicForm(this);">
	<html:submit property="method_save" styleClass="btn" ><bean:message key="opt.btn.save" /></html:submit>
	<html:button styleClass="btn" onclick="window.history.back()" property="none"> <bean:message key="opt.btn.back" /> </html:button>
		
<table width="200" border="0" cellpadding="1" cellspacing="1">		
 
				<tr>
					<td class="TDTITLE">
						<c:out value="popunishbasic.punishobjectid" />
					</td>
					<td align="left">
	
  
							<html:text property="punishobjectid" readonly="${empty popunishbasicForm.map.punishobjectid?'false':'true'}" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="popunishbasic.punishtypeid" />
					</td>
					<td align="left">
	
  
							<html:text property="punishtypeid" readonly="${empty popunishbasicForm.map.punishtypeid?'false':'true'}" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="popunishbasic.punishclassid" />
					</td>
					<td align="left">
	
  
							<html:text property="punishclassid" readonly="${empty popunishbasicForm.map.punishclassid?'false':'true'}" size="40" />
	
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<c:out value="popunishbasic.punishvalue" />
					</td>
					<td align="left">
	
  
						<html:text property="punishvalue" rows="1" size="40" />
	
					</td>
				</tr>

</table>


</html:form>
