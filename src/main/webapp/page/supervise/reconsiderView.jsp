<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html>
<head>
<SCRIPT type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/scrolltop.js"></SCRIPT>
<LINK rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/default/css/lrtk.css">
<title>查看复议详细信息</title>
</head>

<body>
	<div id="myDiv" class="tt" style="display: none">
		<A HREF="javascript: window.scrollTo(0, 0); void 0"
			ONMOUSEOVER="window.status = 'top'; return true;"
			ONMOUSEOUT="window.status = ''; return true;"> <img
			align="middle" alt="返回顶部"
			src="${pageContext.request.contextPath}/styles/default/images/lanren_top.jpg"
			border="0" />
		</A>
	</div>
	<p class="ctitle">查看复议详细信息</p>
<%@ include file="/page/common/messages.jsp"%>
<input type="button" value="返回" Class="btn" onclick="window.history.back()" />
	<c:if test="${not empty object.apply.no or not empty object.punish.no}">
		<br>
		<p align="center" style="font-size: 20; color: #01A6E0;">
			关于
			<c:if test="${object.bjType=='1' or not empty object.apply.no}">${object.apply.transactAffairName}</c:if>
			<c:if test="${object.bjType=='2' or not empty object.punish.no}">${object.punish.content}</c:if>
			的复议
		</p>
	</c:if>
	
		<fieldset style="display: block; padding: 10px;">
		<legend>
			<b>复议信息</b>
		</legend>
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="viewTable">
			<tr>
				<td class="TDTITLE">办件名称</td>
				<td align="left"
					title="<c:if test="${object.bjType=='1' }">${object.apply.transactAffairName}</c:if> <c:if test="${object.bjType=='2' }">${object.punish.content}</c:if>">
					<c:if test="${object.bjType=='1' }">
						<a
							href="<%=request.getContextPath()%>/monitor/apply!view.do?no=${object.apply.no}"
							target="_self"> <c:choose>
								<c:when test="${fn:length(object.apply.transactAffairName) >39}">
									<c:out
										value="${fn:substring(object.apply.transactAffairName, 0, 39)}..." />
								</c:when>
								<c:otherwise>
									<c:out value="${object.apply.transactAffairName}" />
								</c:otherwise>
							</c:choose></a>
					</c:if> <c:if test="${object.bjType=='2' }">
						<a
							href="<%=request.getContextPath()%>/monitor/punish!view.do?no=${object.punish.no}"
							target="_self"> <c:choose>
								<c:when test="${fn:length(object.punish.content) >39}">
									<c:out value="${fn:substring(object.punish.content, 0, 39)}..." />
								</c:when>
								<c:otherwise>
									<c:out value="${object.punish.content}" />
								</c:otherwise>
							</c:choose></a>
					</c:if>
				</td>
				<td class="TDTITLE">办件编号</td>
				<td align="left"><s:property value="%{object.internalNo}" /></td>

			</tr>
			<tr>
				<td class="TDTITLE">权力编码</td>
				<td align="left"><s:property value="%{object.itemId}" /></td>
				<td class="TDTITLE">办件类型</td>
				<td align="left">${cp:MAPVALUE("bjType",object.bjType)}</td>

			</tr>

			<tr>
				<td class="TDTITLE">申请复议单位</td>
				<td align="left">${cp:MAPVALUE("depno",object.reconsiderapply)}
				</td>

				<td class="TDTITLE">申请复议单位联系电话</td>
				<td align="left"><s:property value="%{object.applyphone}" />
				</td>
			</tr>

			<tr>
				<td class="TDTITLE">申请复议时间</td>
				<td align="left"><s:date name="applydate"
						format="yyyy-MM-dd" /></td>
				<td class="TDTITLE">复议办理单位</td>
				<td align="left">${cp:MAPVALUE("unitCode",object.reconsiderdep)}</td>

			</tr>

			<tr>
				<td class="TDTITLE">登记人员</td>
				<td align="left">${cp:MAPVALUE("usercode",object.bookoperator)}</td>
				<td class="TDTITLE">登记时间</td>
				<td align="left"><s:date name="bookdate"
						format="yyyy-MM-dd HH:mm" /></td>

			</tr>


			<tr>
				<td class="TDTITLE">申请复议事由</td>
				<td align="left" colspan="3"><s:property
						value="%{object.applyreason}" /></td>

			</tr>
			<tr>
				<td class="TDTITLE">申请复议内容</td>
				<td align="left" colspan="3"><s:property
						value="%{object.applyremark}" /></td>
			</tr>
			<tr>
				<td class="TDTITLE">状态</td>
				<td align="left" colspan="3">
					${cp:MAPVALUE("bizType",object.biztype)}</td>
			</tr>
		</table>
	</fieldset>
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
				<td class="addTd" width="130">案件编号</td>
				<td ><a href="<%=request.getContextPath()%>/monitor/punish!view.do?internalNo=${object.punish.internalNo}&orgId=${object.punish.orgId}"><s:property value="%{object.punish.internalNo}" /></a></td>
				
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
				<td >${cp:MAPVALUE("PROPOSER_TYPE",(object.punish.source))}</td>  
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
	<iframe id="processFrame" name="processFrame"
		src="supervise/reconsiderprocess!viewList.do?reconsiderId=${object.reconsiderid}&flowInstId=${object.flowInstId}"
		width="100%" style="margin-bottom: 10px;" frameborder="no"
		scrolling="false" border="0" marginwidth="0"
		onload="this.height=window.frames['processFrame'].document.body.scrollHeight"></iframe>

	<iframe id="staffFrame" name="staffFrame"
		src="<c:url value='/powerruntime/generalOperator!listStuffs.do?djId=${object.reconsiderid}'/>"
		width="100%" style="margin-bottom: 10px;" frameborder="no"
		scrolling="false" border="0" marginwidth="0"
		onload="this.height=window.frames['staffFrame'].document.body.scrollHeight"></iframe>
	<c:if test="${object.biztype =='C' }">
		<iframe id="resultFrame" name="resultFrame"
			src="supervise/reconsiderresult!view.do?reconsiderId=${object.reconsiderid}"
			width="100%" style="margin-bottom: 10px;" frameborder="no"
			scrolling="false" border="0" marginwidth="0"
			onload="this.height=window.frames['resultFrame'].document.body.scrollHeight"></iframe>
	</c:if>
	</body>
	</html>
