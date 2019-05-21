<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title>
			 办件过程
		</title>
	</head>

	<body style="width:100%;">
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset style="display: block; padding: 10px;">
			<legend>
				 <b>办件过程信息</b>
			</legend>

		<ec:table action="powerruntime/generalOperator!listIdeaLogs.do" items="ideaLogs" var="optIdeaInfo"
			imagePath="${STYLE_PATH}/images/table/*.gif" showPagination="false" showStatusBar="false" showTitle="false" >
			<ec:row>
				<ec:column property="nodename" title="环节名称" style="text-align:center" sortable="false"/>
				<ec:column property="unitname" title="部门名称" style="text-align:center" sortable="false"/>
				<ec:column property="username" title="办理人员姓名" style="text-align:center" sortable="false" />
				<ec:column property="transdate" title="办理时间" style="text-align:center" sortable="false">
				<fmt:formatDate value="${optIdeaInfo.transdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</ec:column>
				<ec:column property="transidea" title="办理意见" style="text-align:center" sortable="false"/>
				<ec:column property="transcontent" title="办理内容" style="text-align:center" sortable="false"/>

			</ec:row>
		</ec:table>
	</fieldset>
	</body>
</html>
