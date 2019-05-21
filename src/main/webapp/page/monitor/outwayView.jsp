<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="outway.view.title" /></title>
</head>

<body>
<%@ include file="/page/common/messages.jsp"%>	
<fieldset style="padding:10px;">
		<legend style="margin-bottom:10px;"><s:text name="outway.view.title"/></legend>
		<c:if test="${empty param.noback }">
		<input type="button" value="返回" Class="btn" onclick="window.history.back()" /></c:if>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="viewTable">
				<tr>
					<td class="addTd"><s:text name="outway.bjType" /></td>
					<td align="left"><c:out value="${cp:MAPVALUE('bjType', bjType)}"></c:out></td>
				</tr>
				<tr>
					<td class="addTd"><s:text name="outway.orgId" /></td>
					<td align="left"><c:out value="${cp:MAPVALUE('depno', orgId) }"></c:out></td>
				</tr>
				<tr>
						<c:if test="${bjType eq '1'}">
						<td class="addTd"><s:text name="outway.internalNo" /></td>
						<td align="left">
						<s:property value="%{internalNo}" />&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="apply!view.do?noback=T&internalNo=${internalNo}&itemId=${itemId}&fromsup=${param.fromsup}" target="_blank">办件明细</a>
						</td>
						</c:if>
						<c:if test="${bjType eq '2'}">
						<td class="addTd"><s:text name="outway.internalNo" /></td>
						<td align="left">
						<s:property value="%{internalNo}" />&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="punish!view.do?noback=T&internalNo=${internalNo}&orgId=${orgId}&fromsup=${param.fromsup}" target="_blank">案件明细</a>
						</td>
						</c:if>
						<c:if test="${bjType eq '4'}">
						<td class="addTd">督办流水号</td>
						<td align="left">
						<s:property value="%{bjNo}" />&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="../supervise/superviseBasic!view.do?noback=T&superviseNo=${bjNo}&fromsup=1" target="_blank">督办明细</a>
						</td>
						</c:if>
						<c:if test="${bjType eq '7'}">
						<td class="addTd">预警流水号</td>
						<td align="left">
						<s:property value="%{bjNo}" />&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="outway!view.do?noback=T&outwayno=${bjNo}&fromsup=1" target="_blank">预警明细</a>
						</td>
						</c:if>
				</tr>	
				
				<c:if test="${bjType ne '4'}">
				<tr>
					<td class="addTd"><s:text name="outway.itemId" /></td>
					<td align="left"><s:property value="%{itemId}" /></td>
				</tr>					
				<tr>
					<td class="addTd">权力名称</td>
					<td align="left">
						<c:out value="${cp:MAPVALUE('suppowerId', itemId) }"></c:out>
					</td>
				</tr>
				</c:if>
				<tr>
					<td class="addTd"><s:text name="outway.monitorStyle" /></td>
					<td align="left">
						<c:out value="${cp:MAPVALUE('MONITOR_STYLE', monitorStyle) }"></c:out>
					</td>
				</tr>	
				<tr>
					<td class="addTd"><s:text name="outway.monitorType" /></td>
					<td align="left"><c:out value="${cp:MAPVALUE('MONITOR_TYPE', monitorType) }"></c:out></td>
				</tr>	
				<tr>
					<td class="addTd"><s:text name="outway.monitorLogo" /></td>
					<td align="left"><s:property value="%{monitorLogo}" /></td>
				</tr>	
				<tr>
					<td class="addTd"><s:text name="outway.intime" /></td>
					<td align="left"><fmt:formatDate value="${intime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>
                <c:if test="${not empty outtime}">
				<tr>
					<td class="addTd"><s:text name="outway.outtime" /></td>
					<td align="left"><fmt:formatDate value="${outtime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>	
				<tr>
					<td class="addTd"><s:text name="outway.outperson" /></td>
					<td align="left"><c:out value="${cp:MAPVALUE('usercode', outperson) }"></c:out></td>
				</tr>	
				<tr>
					<td class="addTd"><s:text name="outway.outreason" /></td>
					<td align="left"><s:property value="%{outreason}" /></td>
				</tr>	
				</c:if>
</table>
</fieldset>
</body>
</html>
