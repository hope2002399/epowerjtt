<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title>
			 投诉过程信息
		</title>
	</head>

	<body style="width:100%;">
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset style="display: block; padding: 10px;">
			<legend>
				 <b>投诉过程信息</b>
			</legend>
			<%if(com.centit.sys.util.SysTypeUtils.sysType != 1){ %>
			<c:if test="${isworkflowFlag !='F'}">
			<div align="right"> <a href="#" onclick="showFlow('${flowInstId}');">查看流程图</a></div>
			</c:if>
			<%} %>
		<ec:table action="complaint/complaintsprocess!viewList.do" items="objList" var="obj"
			imagePath="${STYLE_PATH}/images/table/*.gif" showPagination="false" showStatusBar="false" showTitle="false" >
			<ec:row>
				<ec:column property="processName" title="环节名称" style="text-align:center" sortable="false"/>
				<%-- <ec:column property="unitname" title="部门名称" style="text-align:center" sortable="false"/> --%>
				<ec:column property="operatorName" title="处理人员姓名" style="text-align:center" sortable="false" />
				<ec:column property="processDate" title="处理时间" style="text-align:center" sortable="false">
				<fmt:formatDate value="${obj.processDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</ec:column>
				<ec:column property="operatorResult" title="处理内容" style="text-align:center" sortable="false"/>
				<ec:column property="operatorOpinion" title="处理意见" style="text-align:center" sortable="false"/>				
				<ec:column property="operatorOpinion" title="操作" style="text-align:center" sortable="false">
				<c:if test="${cp:CHECKUSEROPTPOWER('DBFQ', 'superviseinitiate') }"><input type="button" value="督办发起" onclick="dbfq('${obj.operatorName}','${obj.operatorId}','${obj.complaintId}');"/></c:if>
				</ec:column>
				
			</ec:row>
		</ec:table>
	</fieldset>
	</body>
	<script type="text/javascript">
function showFlow(flowInstId){
	window.open("<%=request.getContextPath()%>/sampleflow/sampleFlowManager!viewxml.do?flowInstId="+flowInstId);
	
	
}
function dbfq(userName,userStaffCode,bjno){
	var url = "<%=request.getContextPath()%>/supervise/superviseBasic!superviseinitiate.do?bjNo="+bjno+"&complaintid="+bjno+"&bjType=3&object.optId=supervise&fromsup=1&isOrg=F&monitorOperatorId="+userStaffCode+"&monitorOperatorName="+encodeURI(encodeURI(userName));	
	window.parent.location.href = url;
}
</script>
</html>
