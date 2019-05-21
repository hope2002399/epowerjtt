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
				<b>陈述申辩</b>
			</legend>	
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="viewTable">		
  				<tr>
					<td class="addTd" width="130">
						陈述申辩时间
					</td>
					<td align="left" colspan="3">
							<s:date name="poexcucedate" format="yyyy-MM-dd HH:mm:ss"/>
					</td>
				</tr>	

				<tr>
					<td class="addTd" width="130">
						陈述申辩地点
					</td>
					<td align="left" colspan="3">
						<c:out value="${object.poexcuceadress}" />
					</td>
				</tr>	
			<tr>
							<td class="addTd" width="130" rowspan="2">承办人姓名</td>
							<td><c:out value="${object.undertakername}" />&nbsp;</td>
							<td class="addTd" width="130" rowspan="2"> 承办人执法证号</td>
							<td><c:out value="${object.undertakecertno}" />&nbsp;</td>
						</tr>
						<tr>
						<td><c:out value="${object.undertakername2}" />&nbsp;</td>
						<td><c:out value="${object.undertakecertno2}" />&nbsp;</td>
						</tr>				
	<tr>
					<td class="addTd" width="130">
						记录人员姓名
					</td>
					<td align="left">
							${cp:MAPVALUE("usercode",object.registerid)}
					</td>				
					<td class="addTd" width="130">
						记录人执法证号
					</td>
					<td align="left">
						<c:out value="${object.registercertno}" />
					</td>
				</tr>	

			

				<tr>
					<td class="addTd" width="130">
						委托代理人姓名
					</td>
					<td align="left" colspan="3">
						<c:out value="${object.deputyname}" />
					</td>
				</tr>	
</table>
</fieldset>


</body>
</html>
