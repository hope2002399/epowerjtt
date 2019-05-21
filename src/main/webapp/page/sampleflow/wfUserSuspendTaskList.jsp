<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title>
			挂起事项
		</title>
		<sj:head locale="zh_CN" />
		<script src="${pageContext.request.contextPath}/scripts/suggest.js" type="text/javascript"></script>
	</head>
	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset>
			<legend>
				 暂缓处理文件
			</legend>
			<s:form action="flowUserTask" namespace="/sampleflow">
				<table cellpadding="0" cellspacing="0" align="left">
					<tr >
					<td class="addTd">办件名称:</td>
						<td width="180">
						<s:textfield name="s_flowOptName" value="%{#parameters['s_flowOptName']}" style="width:180px"/>
						 </td>
						<td  class="addTd">办理处室:</td>
						<td>
							 <select name="s_unitcode" style="width:180px">
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:SUBUNITS('d00001','YW,NY')}">
									<option value="${row.unitcode}"  <c:if test="${param.s_unitcode==row.unitcode}">selected="selected"</c:if>>
									<c:out value="${row.unitname}" />
									</option>
								</c:forEach>
							</select>
						</td></tr><tr>
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
							<s:submit method="listUserSuspendTask"  value="查询" cssClass="btn"/>&nbsp;
						</td>
					</tr>
				</table>
			</s:form>
			</fieldset>
		<ec:table action="../sampleflow/flowUserTask!listUserSuspendTask.do" items="userCompNodesList" var="wfNodeInstance"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit"> 
			<ec:row>
				<ec:column property="flowOptName" title="办件名称" style="text-align:left">
				<a class="tastName" rel="${wfNodeInstance.timeLimit}" title="${wfNodeInstance.nodeName}:${wfNodeInstance.nodeInstId}"  href='${pageContext.request.contextPath}/yxxk/qlyxDj!viewBjInfo.do?flowInstId=${wfNodeInstance.flowInstId}'>
				${wfNodeInstance.flowOptName}
				</a>
				</ec:column>
				<ec:column property="flowOptTag" title="收文号" style="text-align:center" />
				<ec:column property="createTime" title="申报时间" style="text-align:center" >
					<fmt:formatDate value="${wfNodeInstance.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</ec:column>
				<ec:column property="lastUpdateTime" title="暂缓时间" style="text-align:center" >
					<fmt:formatDate value="${wfNodeInstance.lastUpdateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</ec:column>				
				<%-- <ec:column property="unitCode" title="所属机构" style="text-align:center" >
				${cp:MAPVALUE("unitcode",wfNodeInstance.unitCode)}
				</ec:column> --%>
				<ec:column property="nodeName" title="当前步骤" style="text-align:left" />
				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">
						&nbsp;<a title="${wfNodeInstance.nodeName}:${wfNodeInstance.nodeInstId}"  onclick='return confirm("确定要唤醒任务?");' href='../sampleflow/flowUserTask!activeAndToNextStep.do?nodeInstId=${wfNodeInstance.nodeInstId}&nodeOptUrl=${wfNodeInstance.nodeOptUrl}'>唤醒</a>
				</ec:column>

			</ec:row>
		</ec:table>
	<script type="text/javascript">
	$(function(){
		var list = $(".tastName");
		list.each(function(){
			var $this = $(this),
				time = $this.attr("rel");
			if(time === undefined) return; 
			if(time.trim()!="" && parseInt(time)<=240 && parseInt(time)>0){
				$this.parent().parent().css({"background":"#fdcaca"});
			}
		});
	});
</script>	
	</body>
</html>
