<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>

<html>
<head>
<title>流程工作小组</title>

</head>

<body>

<%@ include file="/page/common/messages.jsp"%>
	<fieldset style="padding:10px;">
		<legend style="margin-bottom:10px;">办件角色管理</legend>
		<a class="btnA" href="${pageContext.request.contextPath}/sampleflow/sampleFlowManager!preAssignWorkTeam.do?flowInstId=${flowInstId}"><span class="btn">分配办件角色</span></a><%-- <input type="button"  value="分配办件角色" class="btn" onclick="window.location.href='${pageContext.request.contextPath}/sampleflow/sampleFlowManager!preAssignWorkTeam.do?flowInstId=${flowInstId}';"/> --%>
		<input type="button"  value="返回" Class="btn"  onclick="window.history.back()"/>
			<table  cellpadding="0" cellspacing="0" class="viewTable">
			<thead>
				<tr>
				<td class="tableHeader">办件角色</td><td class="tableHeader">小组成员</td><td class="tableHeader">操作</td>
				</tr>
			</thead>
			<c:forEach var="team" items="${teamMap}">
				<tr>
					<td>${cp:MAPVALUE("WFTeamRole",team.key)}</td>
					<td>
						<c:forEach var="user" items="${team.value}">
							[ ${cp:MAPVALUE("usercode",user)} <a href="sampleFlowManager!deleteWorkTeamUser.do?flowInstId=${flowInstId}&roleCode=${team.key}&userCode=${user}">删除</a> ]
						</c:forEach>
					</td>
					<td>
					<a href="sampleFlowManager!deleteWorkTeam.do?flowInstId=${flowInstId}&roleCode=${team.key}">删除小组</a>&nbsp;&nbsp;
					<a href="sampleFlowManager!preAssignWorkTeam.do?flowInstId=${flowInstId}&roleCode=${team.key}">增加成员</a>
					</td>
				</tr>
			
			</c:forEach>
		</table>
</fieldset>
</body>
</html>
