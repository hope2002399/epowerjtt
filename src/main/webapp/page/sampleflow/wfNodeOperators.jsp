<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%> 
<html>
	<head>
		<title>
			<s:text name="wfActionTask.list.title" />
		</title>
	</head>
	<body>
	<input type="button"  value="返回" Class="btn"  onclick="window.history.go(-1)"/>
		<ec:table action="${pageContext.request.contextPath}/sampleflow/flowUserTask!listNodeOpers.do" items="userTaskList" var="userTask"  showPagination="false"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="optName" title="业务名称" style="text-align:center" sortable="false" />
				<ec:column property="userCode" title="用户代码" style="text-align:center" sortable="false"/>
				<ec:column property="userCode" title="用户" style="text-align:center" sortable="false">
					${cp:MAPVALUE("usercode",userTask.userCode)}
				</ec:column>
				<ec:column property="roleCode" title="角色名称" style="text-align:center" sortable="false">
				<c:if test="${cp:MAPVALUE('WFTeamRole',userTask.roleCode)!=userTask.roleCode}">${cp:MAPVALUE("WFTeamRole",userTask.roleCode)}</c:if>
				<c:if test="${cp:MAPVALUE('StationType',userTask.roleCode)!=userTask.roleCode&&cp:MAPVALUE('WFTeamRole',userTask.roleCode)!=cp:MAPVALUE('StationType',userTask.roleCode)}">${cp:MAPVALUE("StationType",userTask.roleCode)}</c:if>
				</ec:column>
				<ec:column property="roleType" title="角色类别" style="text-align:center" sortable="false">
				${cp:MAPVALUE("WFRoleType",userTask.roleType)}
				</ec:column>
				<ec:column property="grantor" title="委托人" style="text-align:center" sortable="false">
					${cp:MAPVALUE("usercode",userTask.grantor)}
				</ec:column>
		</ec:row>
		</ec:table>

	</body>
</html>
