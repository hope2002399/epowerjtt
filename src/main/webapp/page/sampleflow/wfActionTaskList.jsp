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
		<%@ include file="/page/common/messages.jsp"%>
		<br>
		<input type="button"  value="分配任务" Class="btn"  onclick="window.location.target='dialog';window.location.href='../sampleflow/flowUserTask!preAssignTask.do?nodeInstId=${nodeInstId}'"/>
		<input type="button"  value="返回" Class="btn"  onclick="window.history.back()"/>
		
		<ec:table action="../sampleflow/sampleFlowManager!listNodeInstTasks.do" items="taskList" var="wfActionTask" showPagination="false"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif">
			<ec:row>

				<c:set var="ttaskid"><s:text name='wfActionTask.taskid' /></c:set>	
				<ec:column property="taskId" title="${ttaskid}" style="text-align:center" />

				<c:set var="tassigntime"><s:text name='wfActionTask.assigntime' /></c:set>	
				<ec:column property="assignTime" title="${tassigntime}" format="yyyy-MM-dd HH:mm:ss" style="text-align:center" cell="date" />

				<c:set var="texpiretime"><s:text name='wfActionTask.expiretime' /></c:set>	
				<ec:column property="expireTime" title="${texpiretime}" style="text-align:center" format="yyyy-MM-dd" cell="date"/>

				<c:set var="tusercode"><s:text name='wfActionTask.usercode' /></c:set>	
				<ec:column property="userCode" title="${tusercode}" style="text-align:center" >
						${cp:MAPVALUE("usercode",wfActionTask.userCode)}
				</ec:column>
				<c:set var="trolecode"><s:text name='wfActionTask.rolecode' /></c:set>	
				<ec:column property="roleCode" title="${trolecode}" style="text-align:center" >
				${cp:MAPVALUE("RankType",wfActionTask.roleCode)}
				</ec:column>

				<c:set var="ttaskstate"><s:text name='wfActionTask.taskstate' /></c:set>	
				<ec:column property="taskState" title="${ttaskstate}" style="text-align:center"  >
					${cp:MAPVALUE("WFTaskState",wfActionTask.taskState)}
				</ec:column>
		 
				<c:set var="optlabel"><s:text name="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:if test="${wfActionTask.isvalid eq 'F'}">已禁用</c:if>
					<c:if test="${wfActionTask.isvalid eq 'T'}"><a onclick="return confirm('确定要禁用此任务吗？');" href='flowUserTask!disableTask.do?taskId=${wfActionTask.taskId}&nodeInstId=${nodeInstId}'>禁用</a></c:if>
					<a href='flowUserTask!deleteTask.do?taskId=${wfActionTask.taskId}&nodeInstId=${nodeInstId}'>删除</a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
