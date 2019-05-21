<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title>
			 督办过程信息
		</title>
	</head>

	<body style="width:100%;">
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset style="display: block; padding: 10px;">
			<legend>
				 <b>督办过程信息</b>
			</legend>
<div align="right"> <!-- <a href="#" onclick="showFlow('${flowInstId}');">查看流程图</a> --></div>
		<ec:table action="supervise/superviseReply!viewList.do" items="objList" var="obj"
			imagePath="${STYLE_PATH}/images/table/*.gif" showPagination="false" showStatusBar="false" showTitle="false" >
			<ec:row>

				<ec:column property="processName" title="环节名称" style="text-align:center" sortable="false" />
				<ec:column property="operatorName" title="处理人员姓名" style="text-align:center" sortable="false" />
				<ec:column property="processDate" title="处理时间" style="text-align:center" sortable="false">
				<fmt:formatDate value="${obj.processDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</ec:column>

				<ec:column property="operatorOpinion" title="处理意见" style="text-align:center" sortable="false"/>
				
			</ec:row>
		</ec:table>
	</fieldset>
	</body>
		<script type="text/javascript">
function showFlow(flowInstId){
	window.open("<%=request.getContextPath()%>/sampleflow/sampleFlowManager!viewxml.do?flowInstId="+flowInstId);
	
	
}
</script>
</html>
