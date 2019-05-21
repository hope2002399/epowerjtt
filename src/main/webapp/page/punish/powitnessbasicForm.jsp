<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<html>
<head>
<title><c:out value="powitnessbasic.edit.title" /></title>
<link href="<c:out value='${STYLE_PATH}'/>/css/am.css" type="text/css"
	rel="stylesheet">
<link href="<c:out value='${STYLE_PATH}'/>/css/messages.css" type="text/css"
	rel="stylesheet">

<script type="text/javascript"
	src="<c:url value='/page/common/validator.jsp'/>"></script>
<html:javascript formName="powitnessbasicForm" staticJavascript="false"
	dynamicJavascript="true" cdata="false" />
</head>

<body>
<p class="ctitle"><c:out value="powitnessbasic.edit.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<html:form action="/punish/powitnessbasic"  styleId="powitnessbasicForm" onsubmit="return validatepowitnessbasicForm(this);">
	<html:submit property="method_save" styleClass="btn" ><bean:message key="opt.btn.save" /></html:submit>
	<html:button styleClass="btn" onclick="window.history.back()" property="none"> <bean:message key="opt.btn.back" /> </html:button>
		
<table width="200" border="0" cellpadding="1" cellspacing="1">		
 
				<tr>
					<td class="TDTITLE">
						<c:out value="powitnessbasic.punishobjectid" />
					</td>
					<td align="left">
	
  
							<html:text property="punishobjectid" readonly="${empty powitnessbasicForm.map.punishobjectid?'false':'true'}" size="40" />
	
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<c:out value="powitnessbasic.powitnessdate" />
					</td>
					<td align="left">
	
  
						<html:text property="powitnessdate" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="powitnessbasic.powitnesstype" />
					</td>
					<td align="left">
	
  
						<html:text property="powitnesstype" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="powitnessbasic.powitnessadress" />
					</td>
					<td align="left">
  
						<html:textarea property="powitnessadress" rows="1" cols="40" />
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="powitnessbasic.powitnessemceename" />
					</td>
					<td align="left">
	
  
						<html:text property="powitnessemceename" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="powitnessbasic.powitnessnotername" />
					</td>
					<td align="left">
	
  
						<html:text property="powitnessnotername" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="powitnessbasic.investigatename" />
					</td>
					<td align="left">
	
  
						<html:text property="investigatename" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="powitnessbasic.investigatedepname" />
					</td>
					<td align="left">
  
						<html:textarea property="investigatedepname" rows="1" cols="40" />
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="powitnessbasic.deputyname" />
					</td>
					<td align="left">
	
  
						<html:text property="deputyname" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="powitnessbasic.deputybusiness" />
					</td>
					<td align="left">
	
  
						<html:text property="deputybusiness" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="powitnessbasic.deputydepname" />
					</td>
					<td align="left">
  
						<html:textarea property="deputydepname" rows="1" cols="40" />
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="powitnessbasic.delegatename" />
					</td>
					<td align="left">
  
						<html:textarea property="delegatename" rows="1" cols="40" />
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="powitnessbasic.powitnessmind" />
					</td>
					<td align="left">
	
  
						<html:text property="powitnessmind" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="powitnessbasic.powitnessreason" />
					</td>
					<td align="left">
	
  
						<html:text property="powitnessreason" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="powitnessbasic.witnessdate" />
					</td>
					<td align="left">
	
  
						<html:text property="witnessdate" rows="1" size="40" />
	
					</td>
				</tr>

</table>


</html:form>
