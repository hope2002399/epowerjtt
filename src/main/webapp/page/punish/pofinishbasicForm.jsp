<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<html>
<head>
<title><c:out value="pofinishbasic.edit.title" /></title>
<link href="<c:out value='${STYLE_PATH}'/>/css/am.css" type="text/css"
	rel="stylesheet">
<link href="<c:out value='${STYLE_PATH}'/>/css/messages.css" type="text/css"
	rel="stylesheet">

<script type="text/javascript"
	src="<c:url value='/page/common/validator.jsp'/>"></script>
<html:javascript formName="pofinishbasicForm" staticJavascript="false"
	dynamicJavascript="true" cdata="false" />
</head>

<body>
<p class="ctitle"><c:out value="pofinishbasic.edit.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<html:form action="/punish/pofinishbasic"  styleId="pofinishbasicForm" onsubmit="return validatepofinishbasicForm(this);">
	<html:submit property="method_save" styleClass="btn" ><bean:message key="opt.btn.save" /></html:submit>
	<html:button styleClass="btn" onclick="window.history.back()" property="none"> <bean:message key="opt.btn.back" /> </html:button>
		
<table width="200" border="0" cellpadding="1" cellspacing="1">		
 
				<tr>
					<td class="TDTITLE">
						<c:out value="pofinishbasic.punishobjectid" />
					</td>
					<td align="left">
	
  
							<html:text property="punishobjectid" readonly="${empty pofinishbasicForm.map.punishobjectid?'false':'true'}" size="40" />
	
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<c:out value="pofinishbasic.disobeyitem" />
					</td>
					<td align="left">
	
  
						<html:text property="disobeyitem" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="pofinishbasic.confirmtruth" />
					</td>
					<td align="left">
	
  
						<html:text property="confirmtruth" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="pofinishbasic.podiscussresult" />
					</td>
					<td align="left">
	
  
						<html:text property="podiscussresult" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="pofinishbasic.punishamout" />
					</td>
					<td align="left">
	
  
						<html:text property="punishamout" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="pofinishbasic.otherpunish" />
					</td>
					<td align="left">
  
						<html:textarea property="otherpunish" rows="1" cols="40" />
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="pofinishbasic.punishamoutpeople" />
					</td>
					<td align="left">
	
  
						<html:text property="punishamoutpeople" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="pofinishbasic.punishseizure" />
					</td>
					<td align="left">
	
  
						<html:text property="punishseizure" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="pofinishbasic.punishseizurevalue" />
					</td>
					<td align="left">
	
  
						<html:text property="punishseizurevalue" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="pofinishbasic.punishshoutont" />
					</td>
					<td align="left">
	
  
						<html:text property="punishshoutont" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="pofinishbasic.punishdetentionpeople" />
					</td>
					<td align="left">
	
  
						<html:text property="punishdetentionpeople" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="pofinishbasic.punishdetention" />
					</td>
					<td align="left">
	
  
						<html:text property="punishdetention" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="pofinishbasic.isfinish" />
					</td>
					<td align="left">
	
  
						<html:text property="isfinish" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="pofinishbasic.punishaffixname" />
					</td>
					<td align="left">
	
  
						<html:text property="punishaffixname" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="pofinishbasic.punishaffixdoc" />
					</td>
					<td align="left">
	
  
						<html:text property="punishaffixdoc" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="pofinishbasic.punishaffixcode" />
					</td>
					<td align="left">
	
  
						<html:text property="punishaffixcode" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="pofinishbasic.pofinishstep" />
					</td>
					<td align="left">
	
  
						<html:text property="pofinishstep" rows="1" size="40" />
	
					</td>
				</tr>

</table>


</html:form>
