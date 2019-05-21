<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%> 
<html>
<head>
<title></title>
</head>
<body>


<%@ include file="/page/common/messages.jsp"%>
<fieldset style="display: block; padding: 10px;">
		<legend>
			<b>复议基本信息</b>
		</legend>
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="viewTable">
			<tr>
				<td class="addTd">办件类型</td>
				<td align="left">${cp:MAPVALUE("DBTYPE",object.bjType)}</td>

				<td class="addTd">申请复议单位</td>
				<td align="left">${cp:MAPVALUE("depno",object.reconsiderapply)}</td>
			</tr>
			<tr>
				<td class="addTd">申请复议单位联系电话</td>
				<td align="left"><s:property value="%{object.applyphone}" />
				</td>

				<td class="addTd">申请复议时间</td>
				<td align="left"><s:date name="applydate"
						format="yyyy-MM-dd"/></td>
			</tr>		
			<tr>
				<td class="addTd">申请复议事由</td>
				<td align="left" colspan="3"><s:property
						value="%{object.applyreason}" /></td>
			</tr>
			<tr>
				<td class="addTd">申请复议内容</td>
				<td align="left" colspan="3"><s:property
						value="%{object.applyremark}" /></td>
			</tr>
			<c:if test="${not empty object.reconsiderdate}">
				<td class="addTd">复议办理单位</td>
				<td align="left">${cp:MAPVALUE("unitCode",object.reconsiderdep)}
				</td>

				<td class="addTd">复议时间</td>
				<td align="left"><s:date name="reconsiderdate"
						format="yyyy-MM-dd HH:mm" /></td>
			
			</c:if>
			<tr>
			<td class="addTd">复议状态</td>
				<td align="left" colspan="3">${cp:MAPVALUE("bizType",object.biztype)}
				</td>		
			</tr>
			
		</table>
	</fieldset>
	<c:if test="${not empty object.reconsiderresult.reconsiderId}">
	<iframe id="resultFrame" name="resultFrame" src="<%=request.getContextPath()%>/supervise/reconsiderresult!viewResult.do?reconsiderId=${object.reconsiderid}" width="100%" style="margin-bottom:10px;"
			frameborder="no" scrolling="false" border="0" marginwidth="0" onload="this.height=window.frames['resultFrame'].document.body.scrollHeight"></iframe>
	</c:if>
	

<c:if test="${object.bjType=='1' or  not empty object.apply.no}">
		<fieldset style=" display: block; padding: 10px;">
		<legend>
			<b>办件基本信息</b>
		</legend>
			<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
			<tr>
				<td class="addTd" width="130">办件编号</td>
				<td ><a href="<%=request.getContextPath()%>/monitor/apply!view.do?internalNo=${object.apply.internalNo}&itemId=${object.apply.itemId}" target="_self"><s:property value="%{object.apply.internalNo}" /></a></td>
				
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
		<c:if test="${object.bjType=='2' or  not empty object.punish.no}">
		<fieldset style=" display: block; padding: 10px;">
		<legend>
			<b>案件基本信息</b>
		</legend>
			<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
			<tr>
				<td class="addTd">案件编号</td>
				<td ><a href="<%=request.getContextPath()%>/monitor/punish!view.do?internalNo=${object.punish.internalNo}&orgId=${object.punish.orgId}"><s:property value="%{object.punish.internalNo}" /></a></td>
				
				<td class="addTd">执法部门</td>
				<td >${cp:MAPVALUE("depno",object.punish.orgId)}</td>
				</tr>
				 <tr>
				 <td class="addTd">当事人</td>
				<td >${object.punish.punishTarget}</td> 
				<td class="addTd">当事人类型</td>
				<td >${cp:MAPVALUE("PROPOSER_TYPE",(object.punish.targetType))}</td>  
				</tr>
				<tr>
				<td class="addTd">登记时间</td>
				<td ><fmt:formatDate value='${object.punish.createDate}' pattern='yyyy-MM-dd hh:mm:ss' /></td>
				<td class="addTd" >案件来源</td>
				<td >${cp:MAPVALUE("PROPOSER_TYPE",(object.punish.source))}</td>  
				</tr> 
				<tr>
				 <td class="addTd">确认事实</td>
				<td colspan="3">${object.punish.fact}</td> 
				
				</tr>
				<tr>
				<td class="addTd">权力名称</td>
				<td colspan="3"><a href='${pageContext.request.contextPath}/powerbase/suppowerchglog!listVersion.do?itemId=${object.punish.itemId}&version=${object.vpunish.version}'>${cp:MAPVALUE("suppowerId",object.punish.itemId)}</a></td>
				</tr>
			</table>
		</fieldset>
		</c:if>

		
</body>
</html>
