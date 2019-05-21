<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title></title>


</head>

<body>

<%@ include file="/page/common/messages.jsp"%>

<html:button styleClass="btn" onclick="window.history.back()" property="none">
	<bean:message key="opt.btn.back" />
</html:button>
<p>	
		<fieldset style=" display: block; padding: 10px;">
			<legend>
				<b>不予以听证(申辩)</b>
			</legend>
<table width="100" border="0" cellpadding="0" cellspacing="0" class="viewTable">	
				<tr>
					<td class="addTd" width="130">
						理由
					</td>
					<td align="left">
						<c:out value="${object.pounwitnessreason}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd" width="130">
						办理时间
					</td>
					<td align="left">
						<s:date name="unwitnessdate" format="yyyy-MM-dd HH:mm:ss"/>
					</td>
				</tr>	

				<tr>
					<td class="addTd" width="130">
					办理人员
					</td>
					<td align="left">
						${cp:MAPVALUE("usercode",object.enregisterid)}
					</td>
				</tr>	

</table>



</body>
</html>
