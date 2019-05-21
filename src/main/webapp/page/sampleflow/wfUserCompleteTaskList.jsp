<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title>
			已办事项
		</title>
		<sj:head locale="zh_CN" />
		<script src="${pageContext.request.contextPath}/scripts/suggest.js" type="text/javascript"></script>
	</head>
	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset>
			<legend>
				 我的已办事项
			</legend>
			<s:form action="flowUserTask" namespace="/sampleflow">
				<table cellpadding="0" cellspacing="0" align="left">
					<tr >
						<td  class="addTd">所属机构:</td>
						<td>
							 <select name="s_unitcode" style="width:180px">
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:SUBUNITS('d00001','YW,NY')}">
									<option value="${row.unitcode}"  <c:if test="${param.s_unitcode==row.unitcode}">selected="selected"</c:if>>
									<c:out value="${row.unitname}" />
									</option>
								</c:forEach>
							</select>
						</td>
						<td class="addTd" >创建时间:</td>
						<td>
						<sj:datepicker id="s_createtime" style="width:180px"
							name="s_createtime" value="%{#parameters['s_createtime']}"
							yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" />
						
						 </td>
						<td class="addTd">完成时间:</td>
						<td>
						<sj:datepicker id="lastUpdateTime" style="width:180px"
							name="s_lastUpdateTime" value="%{#parameters['s_lastUpdateTime']}"
							yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" />
						
						 </td>
						<td colspan="5" >
							<s:submit method="listUserCompTask"  value="查询" cssClass="btn"/>&nbsp;
						</td>
					</tr>
				</table>
			</s:form>
			</fieldset>
		<ec:table action="../sampleflow/flowUserTask!listUserCompTask.do" items="userCompNodesList" var="wfNodeInstance"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit"> 
			<ec:row>
				<ec:column property="flowOptName" title="办件名称" style="text-align:center" />
				<ec:column property="flowOptTag" title="业务标记" style="text-align:center" />
				<ec:column property="createTime" title="创建时间" style="text-align:center" >
					<fmt:formatDate value="${wfNodeInstance.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</ec:column>
				<ec:column property="lastUpdateTime" title="完成时间" style="text-align:center" >
					<fmt:formatDate value="${wfNodeInstance.lastUpdateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</ec:column>
				<ec:column property="unitCode" title="所属机构" style="text-align:center" >
				${cp:MAPVALUE("unitcode",wfNodeInstance.unitCode)}
				</ec:column>
				<ec:column property="nodeName" title="当前步骤" style="text-align:left" />
				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">
					<c:if test="${wfNodeInstance.isRecycle eq 'yes'}">
					&nbsp;<a title="${wfNodeInstance.nodeName}:${wfNodeInstance.nodeInstId}"  onclick='return confirm("确定要回收任务?");' href='../sampleflow/flowUserTask!reclaimUserTask.do?nodeInstId=${wfNodeInstance.nodeInstId}'>回收任务</a>
					</c:if>
					&nbsp;<a title="${wfNodeInstance.nodeName}:${wfNodeInstance.nodeInstId}"  href='../sampleflow/sampleFlowManager!listNodeInstLogs.do?nodeInstId=${wfNodeInstance.nodeInstId}'>节点日志</a>
				</ec:column>

			</ec:row>
		</ec:table>
		
	</body>
</html>
