<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html>
<head>
<title><s:text name="incomeDocTask.list.title" /></title>
</head>


<body>
   <%@ include file="/page/common/messages.jsp"%>
	<div class="search">
		<div class="crumbs">收文待办</div>

		<s:form action="ioDocTasks" namespace="/dispatchdoc">
			<table cellpadding="0" cellspacing="0" align="left">
				<tr>
					    <td class="addTd">办件编号：</td>
						<td width="180"><s:textfield id="s_taskId" name="s_taskId" value="" /> </td>
						<td class="addTd">办件名称：</td>
						<td width="180"><s:textfield id="s_wfOptName" name="s_wfOptName" value="" /></td>
						<td align="center"><s:submit method="listIncomeDocTasks" key="opt.btn.query" cssClass="btn"/>&nbsp;</td>
					</tr>	
                 </table>
             </s:form>
	</div>

	<ec:table action="dispatchdoc/ioDocTasks!listIncomeDocTasks.do" items="incomeDocList" var="userTask"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="dispatchDocTasks.xls" ></ec:exportXls>
			<ec:exportPdf fileName="dispatchDocTasks.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
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
		
				<c:set var="optlabel"><s:text name="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<a href="<c:url value='${userTask.nodeOptUrl}' />" >办理</a>
					<a href='<%=request.getContextPath()%>/sampleflow/sampleFlowManager!viewxml.do?flowInstId=${userTask.flowInstId}'>查看流程图</a>
				</ec:column>

			</ec:row>
	</ec:table>

</body>
</html>
