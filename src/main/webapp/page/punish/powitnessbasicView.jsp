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
				<b>听证</b>
			</legend>	
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="viewTable">		
				<tr>
					<td class="addTd" width="130">
						听证时间
					</td>
					<td align="left">
						<s:date name="powitnessdate" format="yyyy-MM-dd HH:mm:ss"/>
					</td>			
					<td class="addTd" width="130">
						听证方式
					</td>
					<td align="left">
					<c:if test="${object.powitnesstype==1}">不公开</c:if>
					<c:if test="${object.powitnesstype==0}">公开</c:if>
					</td>
				</tr>	

				<tr>
					<td class="addTd" width="130">
						听证地点
					</td>
					<td align="left" colspan="3">
						<c:out value="${object.powitnessadress}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd" width="130">
						主持人姓名
					</td>
					<td align="left">
						<c:out value="${object.powitnessemceename}" />
					</td>				
					<td class="addTd" width="130">
						记录人员姓名
					</td>
					<td align="left">
						<c:out value="${object.powitnessnotername}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd" width="130">
						调查人员姓名
					</td>
					<td align="left">
						<c:out value="${object.investigatename}" />
					</td>
			
					<td class="addTd" width="130">
						调查人员工作单位
					</td>
					<td align="left">
						<c:out value="${object.investigatedepname}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd" width="130">
						代理人姓名
					</td>
					<td align="left">
						<c:out value="${object.deputyname}" />
					</td>
			
					<td class="addTd" width="130">
					代理人职务
					</td>
					<td align="left">
						<c:out value="${object.deputybusiness}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd" width="130">
						代理人工作单位
					</td>
					<td align="left" colspan="3">
						<c:out value="${object.deputydepname}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd" width="130">
						列席人员
					</td>
					<td align="left" colspan="3">
						<c:out value="${object.delegatename}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd" width="130">
						听证意见
					</td>
					<td align="left" colspan="3">
						<c:out value="${object.powitnessmind}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd" width="130">
						当事人主要理由
					</td>
					<td align="left" colspan="3">
						<c:out value="${object.powitnessreason}" />
					</td>
				</tr>	

</table>



</body>
</html>
