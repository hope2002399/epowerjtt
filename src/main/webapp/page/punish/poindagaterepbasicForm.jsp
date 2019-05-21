<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<html>
<head>
<title><c:out value="poindagaterepbasic.edit.title" /></title>
<link href="<c:out value='${STYLE_PATH}'/>/css/am.css" type="text/css"
	rel="stylesheet">
<link href="<c:out value='${STYLE_PATH}'/>/css/messages.css" type="text/css"
	rel="stylesheet">

<script type="text/javascript"
	src="<c:url value='/page/common/validator.jsp'/>"></script>
<html:javascript formName="poindagaterepbasicForm" staticJavascript="false"
	dynamicJavascript="true" cdata="false" />
</head>

<body>
<p class="ctitle"><c:out value="poindagaterepbasic.edit.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<html:form action="/punish/poindagaterepbasic"  styleId="poindagaterepbasicForm" onsubmit="return validatepoindagaterepbasicForm(this);">
	<html:submit property="method_save" styleClass="btn" ><bean:message key="opt.btn.save" /></html:submit>
	<html:button styleClass="btn" onclick="window.history.back()" property="none"> <bean:message key="opt.btn.back" /> </html:button>
		
<table width="200" border="0" cellpadding="1" cellspacing="1">		
 
				<tr>
					<td class="TDTITLE">
						<c:out value="poindagaterepbasic.punishobjectid" />
					</td>
					<td align="left">
	
  
							<html:text property="punishobjectid" readonly="${empty poindagaterepbasicForm.map.punishobjectid?'false':'true'}" size="40" />
	
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<c:out value="poindagaterepbasic.confirmtruth" />
					</td>
					<td align="left">
	
  
						<html:text property="confirmtruth" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poindagaterepbasic.unconfirmtruth" />
					</td>
					<td align="left">
	
  
						<html:text property="unconfirmtruth" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poindagaterepbasic.poindagatereppassage" />
					</td>
					<td align="left">
	
  
						<html:text property="poindagatereppassage" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poindagaterepbasic.disobeyitem" />
					</td>
					<td align="left">
	
  
						<html:text property="disobeyitem" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poindagaterepbasic.poindagaterepresult" />
					</td>
					<td align="left">
  
						<html:textarea property="poindagaterepresult" rows="1" cols="40" />
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poindagaterepbasic.isdiscuss" />
					</td>
					<td align="left">
	
  
						<html:text property="isdiscuss" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poindagaterepbasic.poindagaterepreportdoc" />
					</td>
					<td align="left">
	
  
						<html:text property="poindagaterepreportdoc" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poindagaterepbasic.poindagaterepreportdocname" />
					</td>
					<td align="left">
  
						<html:textarea property="poindagaterepreportdocname" rows="1" cols="40" />
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poindagaterepbasic.poindagaterepstate" />
					</td>
					<td align="left">
	
  
						<html:text property="poindagaterepstate" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poindagaterepbasic.poindagaterepstep" />
					</td>
					<td align="left">
	
  
						<html:text property="poindagaterepstep" rows="1" size="40" />
	
					</td>
				</tr>

</table>


</html:form>
