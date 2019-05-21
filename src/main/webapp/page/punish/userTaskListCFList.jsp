<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%> 
<html>
	<head>
		<title>
			行政处罚办理
		</title>
		<script type="text/javascript">
		  function resetForm(){
			  $('#s_wfOptTag').val('');
			  $('#s_wfOptName').val('');
		  }
		</script>
	</head>
	<body>
		<div class="search">
			<div class="crumbs">
				案件办理
			</div>
			<s:form action="userTaskListCF" namespace="/punish">
			<table cellpadding="0" cellspacing="0" align="center">
				<tr>
				<td class="addTd">办件编号：</td>
				<td width="30%"><s:textfield id="s_wfOptTag" name="s_wfOptTag"
							value="%{#parameters['s_wfOptTag']}" />
							</td>
					<td class="addTd">办件名称：</td>
					<td width="180"><s:textfield id="s_wfOptName"
							name="s_wfOptName" value="%{#parameters['s_wfOptName']}"/> </td>
					<td style="width: 5%"><s:submit method="list" key="opt.btn.query"
							cssClass="btn" /></td><td>
							<input type="button" name="reset" value="重置" class="btn" onclick="resetForm();"/></td>
				</tr>
			</table>
		</s:form>
	</div>
	
	
		<ec:table action="../punish/userTaskListCF!list.do" items="objList" var="userTask"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="nodeInstId"  title="编号" style="text-align:center" />
				<ec:column property="flowOptTag" title="办件编号" style="text-align:center" />
				<ec:column property="flowOptName" title="办件名称" style="text-align:center" />
				
				<ec:column property="nodeCreateTime" title="更新时间"
						style="text-align:center" format="yyyy-MM-dd HH:mm:ss" cell="date" />
				<ec:column property="inststate" title="流程状态"
				style="text-align:center">
					${cp:MAPVALUE("WFInstType",userTask.inststate)}
				</ec:column>
				<ec:column property="nodeName" title="当前步骤" style="text-align:left" >
				${userTask.nodeName}
				<c:if test="${userTask.grantor ne null }">
					 (委托)
				</c:if>
			</ec:column>
				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">
					<a href="<c:url value='${userTask.nodeOptUrl}' />" >办理</a>
					<a href='<%=request.getContextPath()%>/sampleflow/sampleFlowManager!viewxml.do?flowInstId=${userTask.flowInstId}'>查看流程图</a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
