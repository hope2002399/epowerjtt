<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<html>
<head>
<title><c:out value="poundertakebasic.edit.title" /></title>
<link href="<c:out value='${STYLE_PATH}'/>/css/am.css" type="text/css"
	rel="stylesheet">
<link href="<c:out value='${STYLE_PATH}'/>/css/messages.css" type="text/css"
	rel="stylesheet">

<script type="text/javascript"
	src="<c:url value='/page/common/validator.jsp'/>"></script>
<html:javascript formName="poundertakebasicForm" staticJavascript="false"
	dynamicJavascript="true" cdata="false" />
</head>

<body>
<p class="ctitle"><c:out value="poundertakebasic.edit.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<html:form action="/punish/poundertakebasic"  styleId="poundertakebasicForm" onsubmit="return validatepoundertakebasicForm(this);">
	<html:submit property="method_save" styleClass="btn" ><bean:message key="opt.btn.save" /></html:submit>
	<html:button styleClass="btn" onclick="window.history.back()" property="none"> <bean:message key="opt.btn.back" /> </html:button>
		
<table width="200" border="0" cellpadding="1" cellspacing="1">		
 
				<tr>
					<td class="TDTITLE">
						<c:out value="poundertakebasic.punishobjectid" />
					</td>
					<td align="left">
	
  
							<html:text property="punishobjectid" readonly="${empty poundertakebasicForm.map.punishobjectid?'false':'true'}" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poundertakebasic.usercode" />
					</td>
					<td align="left">
	
  
							<html:text property="usercode" readonly="${empty poundertakebasicForm.map.usercode?'false':'true'}" size="40" />
	
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<c:out value="poundertakebasic.depid" />
					</td>
					<td align="left">
	
  
						<html:text property="depid" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poundertakebasic.sectionid" />
					</td>
					<td align="left">
	
  
						<html:text property="sectionid" rows="1" size="40" />
	
					</td>
				</tr>

</table>


</html:form>
