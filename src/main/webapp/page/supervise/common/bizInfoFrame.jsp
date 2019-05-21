<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%> 
<html>
<head>
<title></title>
</head>
<body>
<%@ include file="/page/common/messages.jsp"%>
<c:if test="${object.bjType=='3'}">
	<fieldset style=" display: block; padding: 10px;">
			<legend>
				<b>投诉信息</b>
			</legend>
<table cellpadding="0" cellspacing="0" class="viewTable">
				<tr>
					<td class="addTd">
						投诉人
					</td>
					<td align="left">
						<s:property value="%{object.complaint.complaintman}" />
					</td>			
					<td class="addTd">
						联系电话
					</td>
					<td align="left">
						<s:property value="%{object.complaint.complaintphone}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						投诉时间
					</td>
					<td align="left">
						<s:date name="object.complaint.complaintdate" format="yyyy-MM-dd HH:mm"/>
					</td>
				
					<td class="addTd">
						投诉方式
					</td>
					<td align="left">
						${cp:MAPVALUE("TS_SOURCE",object.complaint.complaintsSource)}
					</td>
				</tr>

				<tr>
					<td class="addTd">
						投诉事由
					</td>
					<td align="left" colspan="3">
						<s:property value="%{object.complaint.complaintreason}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						投诉内容
					</td>
					<td align="left" colspan="3">
						<s:property value="%{object.complaint.complaintremark}" />
					</td>
				</tr>	
</table>
</fieldset>
</c:if>
<c:if test="${object.bjType=='1' or (object.bjType=='3' and not empty object.apply.no)}">
		<fieldset style=" display: block; padding: 10px;">
		<legend>
			<b>办件基本信息</b>
		</legend>
			<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
			<tr>
				<td class="addTd" width="130">办件编号</td>
				<td ><a href="<%=request.getContextPath()%>/monitor/apply!view.do?internalNo=${object.apply.internalNo}&itemId=${object.apply.itemId}&fromsup=${requestScope.fromsup}" target="_self"><s:property value="%{object.apply.internalNo}" /></a></td>
				
				<td class="addTd" width="130">主办部门</td>
				<td >${cp:MAPVALUE("depno",object.apply.orgId)}</td>
				</tr>
				<tr>
				<td class="addTd" width="130">申请者名称</td>
				<td >${object.apply.applicantName}</td>
				 <td class="addTd" width="130">申请者类型</td>
				<td >${cp:MAPVALUE("PROPOSER_TYPE",(object.apply.applicantType))}</td> 
				</tr>
				<tr>
				<td class="addTd" width="130">登记时间</td>
				<td colspan="3"><fmt:formatDate value='${object.apply.applyDate}' pattern='yyyy-MM-dd hh:mm:ss' /></td>
				</tr>
				<tr>
				<td class="addTd" width="130">权力名称</td>
				<td colspan="3"><a href="${pageContext.request.contextPath}/powerbase/suppowerchglog!listVersion.do?itemId=${object.apply.itemId}&version=${object.vapply.version}">${cp:MAPVALUE("suppowerId",object.apply.itemId)}</a></td>
				</tr>
			</table>
		</fieldset>
		</c:if>
		<c:if test="${object.bjType=='2' or (object.bjType=='3' and not empty object.punish.no)}">
		<fieldset style=" display: block; padding: 10px;">
		<legend>
			<b>案件基本信息</b>
		</legend>
			<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
			<tr>
				<td class="addTd" width="130">案件编号</td>
				<td ><a href="<%=request.getContextPath()%>/monitor/punish!view.do?internalNo=${object.punish.internalNo}&orgId=${object.punish.orgId}&fromsup=${requestScope.fromsup}"><s:property value="%{object.punish.internalNo}" /></a></td>
				
				<td class="addTd" width="130">执法部门</td>
				<td >${cp:MAPVALUE("depno",object.punish.orgId)}</td>
				</tr>
				 <tr>
				 <td class="addTd" width="130">当事人</td>
				<td >${object.punish.punishTarget}</td> 
				<td class="addTd" width="130">当事人类型</td>
				<td >${cp:MAPVALUE("PROPOSER_TYPE",(object.punish.targetType))}</td>  
				</tr>
				<tr>
				<td class="addTd" width="130">登记时间</td>
				<td ><fmt:formatDate value='${object.punish.createDate}' pattern='yyyy-MM-dd hh:mm:ss' /></td>
				<td class="addTd" width="130">案件来源</td>
				<td >${cp:MAPVALUE("CASEORIGN",(object.punish.source))}</td>  
				</tr> 
				<tr>
				 <td class="addTd" width="130">确认事实</td>
				<td colspan="3">${object.punish.fact}</td> 
				
				</tr>
				<tr>
				<td class="addTd" width="130">权力名称</td>
				<td colspan="3"><a href='${pageContext.request.contextPath}/powerbase/suppowerchglog!listVersion.do?itemId=${object.punish.itemId}&version=${object.vpunish.version}'>${cp:MAPVALUE("suppowerId",object.punish.itemId)}</a></td>
				</tr>
			</table>
		</fieldset>
		</c:if>

		
</body>
</html>
