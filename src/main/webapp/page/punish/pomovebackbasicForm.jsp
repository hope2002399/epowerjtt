<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<html>
<head>
<title><c:out value="pomovebackbasic.edit.title" /></title>
<link href="<c:out value='${STYLE_PATH}'/>/css/am.css" type="text/css"
	rel="stylesheet">
<link href="<c:out value='${STYLE_PATH}'/>/css/messages.css" type="text/css"
	rel="stylesheet">

<script type="text/javascript"
	src="<c:url value='/page/common/validator.jsp'/>"></script>
<html:javascript formName="pomovebackbasicForm" staticJavascript="false"
	dynamicJavascript="true" cdata="false" />
</head>

<body>
<p class="ctitle"><c:out value="pomovebackbasic.edit.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<html:form action="/punish/pomovebackbasic"  styleId="pomovebackbasicForm" onsubmit="return validatepomovebackbasicForm(this);">
	<html:submit property="method_save" styleClass="btn" ><bean:message key="opt.btn.save" /></html:submit>
	<html:button styleClass="btn" onclick="window.history.back()" property="none"> <bean:message key="opt.btn.back" /> </html:button>
		
<table width="200" border="0" cellpadding="1" cellspacing="1">		
 
				<tr>
					<td class="TDTITLE">
						<c:out value="pomovebackbasic.sortno" />
					</td>
					<td align="left">
	
  
							<html:text property="sortno" readonly="${empty pomovebackbasicForm.map.sortno?'false':'true'}" size="40" />
	
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<c:out value="pomovebackbasic.punishobjectid" />
					</td>
					<td align="left">
	
  
						<html:text property="punishobjectid" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="pomovebackbasic.stepworkid" />
					</td>
					<td align="left">
	
  
						<html:text property="stepworkid" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="pomovebackbasic.beginapprovecode" />
					</td>
					<td align="left">
	
  
						<html:text property="beginapprovecode" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="pomovebackbasic.endapprovecode" />
					</td>
					<td align="left">
	
  
						<html:text property="endapprovecode" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="pomovebackbasic.movebackdate" />
					</td>
					<td align="left">
	
  
						<html:text property="movebackdate" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="pomovebackbasic.operatorid" />
					</td>
					<td align="left">
	
  
						<html:text property="operatorid" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="pomovebackbasic.movebackcontent" />
					</td>
					<td align="left">
	
  
						<html:text property="movebackcontent" rows="1" size="40" />
	
					</td>
				</tr>

</table>


</html:form>
