<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<html>
<head>
<title><c:out value="poapproveperson.edit.title" /></title>
<link href="<c:out value='${STYLE_PATH}'/>/css/am.css" type="text/css"
	rel="stylesheet">
<link href="<c:out value='${STYLE_PATH}'/>/css/messages.css" type="text/css"
	rel="stylesheet">

<script type="text/javascript"
	src="<c:url value='/page/common/validator.jsp'/>"></script>
<html:javascript formName="poapprovepersonForm" staticJavascript="false"
	dynamicJavascript="true" cdata="false" />
</head>

<body>
<p class="ctitle"><c:out value="poapproveperson.edit.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<html:form action="/punish/poapproveperson"  styleId="poapprovepersonForm" onsubmit="return validatepoapprovepersonForm(this);">
	<html:submit property="method_save" styleClass="btn" ><bean:message key="opt.btn.save" /></html:submit>
	<html:button styleClass="btn" onclick="window.history.back()" property="none"> <bean:message key="opt.btn.back" /> </html:button>
		
<table width="200" border="0" cellpadding="1" cellspacing="1">		
 
				<tr>
					<td class="TDTITLE">
						<c:out value="poapproveperson.operatorid" />
					</td>
					<td align="left">
	
  
							<html:text property="operatorid" readonly="${empty poapprovepersonForm.map.operatorid?'false':'true'}" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poapproveperson.stepworkid" />
					</td>
					<td align="left">
	
  
							<html:text property="stepworkid" readonly="${empty poapprovepersonForm.map.stepworkid?'false':'true'}" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poapproveperson.tachestepid" />
					</td>
					<td align="left">
	
  
							<html:text property="tachestepid" readonly="${empty poapprovepersonForm.map.tachestepid?'false':'true'}" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poapproveperson.punishobjectid" />
					</td>
					<td align="left">
	
  
							<html:text property="punishobjectid" readonly="${empty poapprovepersonForm.map.punishobjectid?'false':'true'}" size="40" />
	
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<c:out value="poapproveperson.depid" />
					</td>
					<td align="left">
	
  
						<html:text property="depid" rows="1" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<c:out value="poapproveperson.isappoint" />
					</td>
					<td align="left">
	
  
						<html:text property="isappoint" rows="1" size="40" />
	
					</td>
				</tr>

</table>


</html:form>
