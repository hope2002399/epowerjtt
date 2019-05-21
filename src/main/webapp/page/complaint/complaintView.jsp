<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<SCRIPT type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/scrolltop.js"></SCRIPT>
<LINK rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/default/css/lrtk.css">

<title>查看投诉详细信息</title>
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
	<p class="ctitle">查看投诉详细信息</p>

	<%@ include file="/page/common/messages.jsp"%>

	 <div align="right"><input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" /></div>
	<c:if test="${not empty object.apply.no or not empty object.punish.no}">
		<br>
		<p align="center" style="font-size: 20; color: #01A6E0;">
			关于
			<c:if test="${object.bjType=='1' or not empty object.apply.no}">${object.apply.transactAffairName}</c:if>
			<c:if test="${object.bjType=='2' or not empty object.punish.no}">${object.punish.content}</c:if>
			的投诉
		</p>
	</c:if>
	<fieldset style="display: block; padding: 10px;">
		<legend>
			<b>投诉信息</b>
		</legend>
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="viewTable">
			<%if(com.centit.sys.util.SysTypeUtils.sysType != 1){ %>
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
			<%} %>
			<tr>
				<td class="TDTITLE">投诉类型</td>
				<td align="left">
					${cp:MAPVALUE("COMPLAINTS_TYPE",object.complaintsType)}</td>

				<td class="TDTITLE">投诉来源</td>
				<td align="left">
					${cp:MAPVALUE("TS_SOURCE",object.complaintsSource)}</td>
			</tr>

			<tr>
				<td class="TDTITLE">投诉人</td>
				<td align="left"><s:property value="%{object.complaintman}" />
				</td>

				<td class="TDTITLE">联系电话</td>
				<td align="left"><s:property value="%{object.complaintphone}" />
				</td>
			</tr>

			<tr>
				<td class="TDTITLE">投诉时间</td>
				<td align="left"><s:date name="complaintdate"
						format="yyyy-MM-dd HH:mm" /></td>
				<td class="TDTITLE">主办部门</td>
				<td align="left">${cp:MAPVALUE("depno",object.graentOrgId)}</td>

			</tr>

			<tr>
				<td class="TDTITLE">登记人员</td>
				<td align="left">${cp:MAPVALUE("usercode",object.createUser)}</td>
				<td class="TDTITLE">登记时间</td>
				<td align="left"><s:date name="createDate"
						format="yyyy-MM-dd HH:mm" /></td>

			</tr>


			<tr>
				<td class="TDTITLE">投诉事由</td>
				<td align="left" colspan="3"><s:property
						value="%{object.complaintreason}" /></td>

			</tr>
			<tr>
				<td class="TDTITLE">投诉内容</td>
				<td align="left" colspan="3"><s:property
						value="%{object.complaintremark}" /></td>
			</tr>
			<tr>
				<td class="TDTITLE">状态</td>
				<td align="left" colspan="3">
					${cp:MAPVALUE("bizType",object.biztype)}</td>
			</tr>
		</table>
	</fieldset>

	<iframe id="processFrame" name="processFrame"
		src="complaint/complaintsprocess!viewList.do?complaintId=${object.complaintid}&flowInstId=${object.flowInstId}"
		width="100%" style="margin-bottom: 10px;" frameborder="no"
		scrolling="false" border="0" marginwidth="0"
		onload="this.height=window.frames['processFrame'].document.body.scrollHeight"></iframe>
	<%if(com.centit.sys.util.SysTypeUtils.sysType != 1){ %>
	<iframe id="staffFrame" name="staffFrame"
		src="<c:url value='/powerruntime/generalOperator!listStuffs.do?djId=${object.complaintid}'/>"
		width="100%" style="margin-bottom: 10px;" frameborder="no"
		scrolling="false" border="0" marginwidth="0"
		onload="this.height=window.frames['staffFrame'].document.body.scrollHeight"></iframe>
	<%} %>
	<c:if test="${!empty result.no}">
		<iframe id="resultFrame" name="resultFrame"
			src="complaint/complaintsresult!view.do?complaintid=${object.complaintid}"
			width="100%" style="margin-bottom: 10px;" frameborder="no"
			scrolling="false" border="0" marginwidth="0"
			onload="this.height=window.frames['resultFrame'].document.body.scrollHeight"></iframe>
	</c:if>
</body>
</html>
