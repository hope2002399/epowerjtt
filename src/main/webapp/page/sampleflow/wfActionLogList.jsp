<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html>
	<head>
		<title>
			<s:text name="wfActionLog.list.title" />
		</title>
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<input type="button"  value="返回" Class="btn"  onclick="window.history.back()"/>
		<ec:table action="../sampleflow/sampleFlowManager!listNodeInstLogs.do" items="logList" var="wfActionLog"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" showPagination="false">
			<ec:row>
				<c:set var="tusercode"><s:text name='wfActionLog.usercode' /></c:set>	
				<ec:column property="tusercode" title="${tusercode}" style="text-align:center" >
					${cp:MAPVALUE("usercode",wfActionLog.userCode)}
				</ec:column>
				<c:set var="tactiontype"><s:text name='wfActionLog.actiontype' /></c:set>	
				<ec:column property="actionType" title="${tactiontype}" style="text-align:center"  >
						${cp:MAPVALUE("WfActionType",wfActionLog.actionType)}
				</ec:column>
				<c:set var="tactiontime"><s:text name='wfActionLog.actiontime' /></c:set>	
				<ec:column property="actionTime" title="${tactiontime}" style="text-align:center" format="yyyy-MM-dd HH:mm:ss" cell="date"/>

				<c:set var="troletype"><s:text name='wfActionLog.roletype' /></c:set>	
				<ec:column property="roleType" title="${troletype}" style="text-align:center" >
					${cp:MAPVALUE("WFRoleType",wfActionLog.roleType)}
				</ec:column>
				
				<c:set var="trolecode"><s:text name='wfActionLog.rolecode' /></c:set>	
				<ec:column property="roleCode" title="${trolecode}" style="text-align:center"  >
					${cp:MAPVALUE("RankType",wfActionLog.roleCode)}
				</ec:column>
				<c:set var="optlabel"><s:text name="opt.btn.collection"/></c:set>	
			</ec:row>
		</ec:table>

	</body>
</html>
