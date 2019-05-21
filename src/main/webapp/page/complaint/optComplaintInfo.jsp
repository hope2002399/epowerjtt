<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title></title>
</head>

<body>
<%@ include file="/page/common/messages.jsp"%>

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
						<s:property value="%{object.complaintman}" />
					</td>			
					<td class="addTd">
						联系电话
					</td>
					<td align="left">
						<s:property value="%{object.complaintphone}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						投诉时间
					</td>
					<td align="left">
						<s:date name="object.complaintdate" format="yyyy-MM-dd HH:mm"/>
					</td>
				
					<td class="addTd">
						投诉方式
					</td>
					<td align="left">
						${cp:MAPVALUE("TS_SOURCE",object.complaintsSource)}
					</td>
				</tr>
				<c:if test="${object.promise_Date !=null }">
				<tr>
					<td class="addTd">
						投诉反馈时限
					</td>
					<td align="left" colspan="3">
						<s:date name="object.promise_Date" format="yyyy-MM-dd"/>
					</td>
				</tr>
				</c:if>
				<tr>
					<td class="addTd">
						投诉事由
					</td>
					<td align="left" colspan="3">
						<s:property value="%{object.complaintreason}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						投诉内容
					</td>
					<td align="left" colspan="3">
						<s:property value="%{object.complaintremark}" />
					</td>
				</tr>	
</table>
</fieldset>

<c:if test="${not empty object.apply.no}">
<fieldset style=" display: block; padding: 10px;">
			<legend>
				<b>办件信息</b>
			</legend>
<table cellpadding="0" cellspacing="0" class="viewTable">
				<tr>
					<td class="addTd">
						部门内部事项编号
					</td>
					<td align="left">
						<s:property value="%{object.apply.internalNo}" />			
					</td>			
				
					
					<td class="addTd">
						办件名称
					</td>
					<td align="left">					
			<c:if test="${object.bjType=='1' }"><a href="<%=request.getContextPath()%>/monitor/apply!view.do?no=${object.apply.no}" target="_self">${object.apply.transactAffairName}</a></c:if>
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						申请者名称
					</td>
					<td align="left">
						<s:property value="%{object.apply.applicantName}" />
					</td>
				
					<td class="addTd">
						申请者类型
					</td>
					<td align="left">
						${cp:MAPVALUE("PaperType",object.apply.applicantPaperType)}
					</td>
				</tr>

				<tr>
					<td class="addTd">
						登记时间
					</td>
					<td align="left">
						<s:date name="object.apply.createDate" format="yyyy-MM-dd HH:mm"/>
					</td>
						<td class="addTd">
						主办部门
					</td>
					<td align="left">
					${cp:MAPVALUE("depno",object.apply.orgId)}
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						权力名称
					</td>
					<td align="left" colspan="3">
					${cp:MAPVALUE("suppowerId",object.apply.itemId)}
					</td>
				</tr>	
</table>
</fieldset>
</c:if>
<c:if test="${not empty object.punish.no}">
<fieldset style=" display: block; padding: 10px;">
			<legend>
				<b>案件信息</b>
			</legend>
<table cellpadding="0" cellspacing="0" class="viewTable">
				<tr>
					<td class="addTd">
						部门内部事项编号
					</td>
					<td align="left">
						<s:property value="%{object.punish.internalNo}" />
					</td>			
					<td class="addTd">
						主办部门
					</td>
					<td align="left">
					${cp:MAPVALUE("depno",object.punish.orgId)}
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						处罚当事人
					</td>
					<td align="left">
						<s:property value="%{object.punish.punishTarget}" />
					</td>
				
					<td class="addTd">
						当事人类型
					</td>
					<td align="left">
						${cp:MAPVALUE("targetType",object.punish.targetType)}
					</td>
				</tr>

				<tr>
					<td class="addTd">
						登记时间
					</td>
					<td align="left">
						<s:date name="object.punish.createDate" format="yyyy-MM-dd HH:mm"/>
					</td>
					<td class="addTd">
						处罚名称
					</td>
					<td align="left" title="${object.punish.content}">					
			<c:if test="${object.bjType=='2' }"><a href="<%=request.getContextPath()%>/monitor/punish!view.do?no=${object.punish.no}" target="_self">
					<c:choose>
					<c:when test="${fn:length(object.punish.content) >39}">
						<c:out value="${fn:substring(object.punish.content, 0, 39)}..." />
					</c:when>
					<c:otherwise>
						<c:out value="${object.punish.content}" />
					</c:otherwise>
				</c:choose></a></c:if>
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						权力名称
					</td>
					<td align="left" colspan="3">
					${cp:MAPVALUE("suppowerId",object.punish.itemId)}
					</td>
				</tr>	
</table>
</fieldset>
</c:if>
</body>
</html>
