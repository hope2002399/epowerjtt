<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>

<html>
<head><meta name="decorator" content='${LAYOUT}'/>
<title>流程所有版本</title>

</head>

<body>

<%@ include file="/page/common/messages.jsp"%>
	<fieldset style="padding:10px;">
		<legend class="ctitle" style="width:auto;">流程所有版本</legend>
			<table cellpadding="0" cellspacing="0">
				<tr>
					<td align="right">
						<input type="button"  value="返回" Class="btn"  onclick="window.history.back()"/>
					</td>
				</tr>
			</table>
		<ec:table action="sampleFlowDefine!getMyAllVersions.do" items="objList" var="wfFlow"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" rowsDisplayed="15" 
			filterRowsCallback="limit" 
			retrieveRowsCallback="limit"
			sortRowsCallback="limit"
			>
			<ec:row>
				<ec:column property="flowCode" title="流程代码" style="text-align:center" />
				
				<ec:column property="flowName" title="流程名称" style="text-align:center" />
				
				<ec:column property="version" title="流程版本" style="text-align:center" />
				
				<ec:column property="flowDesc" title="描述" style="text-align:center" />
				
				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">
					<a href='sampleFlowDefine!getworkflowxml.do?flowCode=${wfFlow.flowCode}&version=${wfFlow.version}'>从当前版本编辑流程图</a>
				<c:if test="${wfFlow.flowState ne 'D' && wfFlow.version ne '0' }">
					<a onclick='return confirm("确定要禁用此流程?");' href='sampleFlowDefine!disableFlow.do?flowCode=${wfFlow.flowCode}&version=${wfFlow.version}&flowState=D'>禁用</a>
				</c:if>
				<c:if test="${wfFlow.flowState eq 'D' }">
					<a href='sampleFlowDefine!enableFlow.do?flowCode=${wfFlow.flowCode}&version=${wfFlow.version}&flowState=B'>启用</a>
				</c:if>
				</ec:column>
			</ec:row>
			
		</ec:table>
</fieldset>
</body>
</html>
