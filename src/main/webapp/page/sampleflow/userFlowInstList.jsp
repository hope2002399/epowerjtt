<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html>
	<head>
	<meta name="decorator" content='${LAYOUT}'/>
		<title>
			业务流程管理
		</title>
		<sj:head locale="zh_CN" />
		<script src="${pageContext.request.contextPath}/scripts/suggest.js" type="text/javascript"></script>
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset>
			<legend>
				 流程查询
			</legend>
					<s:form action="sampleFlowManager" namespace="/sampleflow">
					<s:hidden name="s_flowPhase" value="%{#parameters['s_flowPhase']}" />
				<table cellpadding="0" cellspacing="0" align="left">
					<tr >
						<td class="addTd">办件名称:</td>
						<td width="300">
						<s:textfield name="s_flowOptName" value="%{#parameters['s_flowOptName']}" style="width:180px"/>
						 </td>
						<td class="addTd">收文号:</td>
						<td>
							<s:textfield name="s_flowOptTag" value="%{#parameters['s_flowOptTag']}" style="width:180px"/>
						</td>
					</tr>
					<tr >
						<td class="addTd">业务状态:</td>
						<td width="300">
							<select name="s_inststate" style="width:180px">
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('WFInstType')}">
									<option value="${row.key}" <c:if test="${s_inststate==row.key}">selected="selected"</c:if>>
									
									<c:out value="${row.value}" /></option>
								</c:forEach>
							</select>
						</td>
						<td class="addTd" >创建时间:</td>
						<td>
						<sj:datepicker id="s_createtime" style="width:180px"
							name="s_createtime" value="%{#parameters['s_createtime']}"
							yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" />
						
						 </td>
					</tr>
					<tr >
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
						</td>
						
						<td class="addTd">完成时间:</td>
						<td>
						<sj:datepicker id="finishtime" style="width:180px"
							name="s_lastUpdateTime" value="%{#parameters['s_lastUpdateTime']}"
							yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" />
						
						 </td>
					</tr>
					<tr >
					<!-- 
						<td class="addTd">创建用户:</td>
						<td><div id="userDiv" class="userDiv">
						<input type="text" name="userName" value="${cp:MAPVALUE('usercode',param.s_usercode)}"/>
						<s:hidden name="s_usercode" value="%{#parameters['s_usercode']}"/>
						<ul id="list" class="ulList"></ul>
						</div>
						<script type="text/javascript">
						$(function(){
							initValue($("#userDiv input[name=userName]"),$("#list"),"${pageContext.request.contextPath}/sys/userDef!getUsers.do",$("#userDiv input[name=s_usercode]"));
						})
						</script>
						</td>
					 -->
	<%-- 				 <td class="addTd">参与用户:</td>
						<td><div id="userDiv1" class="userDiv">
						<input type="text" name="attachUserName" value="${cp:MAPVALUE('usercode',s_attachuser)}" style="width:180px"/>
						<input type="hidden" name="s_attachuser" value="${s_attachuser}"/>
						<ul id="list1" class="ulList"></ul>
						</div>
						<script type="text/javascript">
						$(function(){
							initValue($("#userDiv1 input[name=attachUserName]"),$("#list1"),"${pageContext.request.contextPath}/sys/userDef!getUsers.do",$("#userDiv1 input[name=s_attachuser]"));
						})
						</script>
						</td>	  
						<td class="addTd">操作方法:</td>
						<td>
						<select name="s_optcode" style="width:180px">   
							<option value="">   
									<c:out value="-- 请选择 --"/>   
							</option>    
							<c:forEach var="opt" items="${cp:IS_FLOWOPTDEF('T')}">
								<option value="${opt.optcode}" <c:if test="${param.s_optcode==opt.optcode}">selected="selected"</c:if> >   
									<c:out value="${opt.optname}"/>   
								</option>
							</c:forEach> 
						</select>
					</td> --%>
					</tr>
<%-- 					<tr>
						<td class="addTd">包含节点:</td>
						<td><s:textfield name="s_nodeid" style="width:180px"/> </td>
						<td class="addTd">包含完成:</td>
						<td>
							<s:checkbox name="s_isAll" value="#parameters['s_isAll']" fieldValue="true" />
						</td>
					</tr> --%>
					<tr>
						<td colspan="8" >
							<s:submit method="listUserFlow"  value="查询" cssClass="btn"/>&nbsp;
							<s:reset name="reset" cssClass="btn" value="重置"></s:reset> &nbsp;
						</td>
					</tr>
				</table>
			</s:form>
		</fieldset>
		<ec:table action="sampleFlowManager!listUserFlow.do" items="objList" var="wfFlowInstance"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="flowOptName" title="办件名称" style="text-align:left" width="250px;" />
				<ec:column property="flowOptTag" title="收文号" style="text-align:center" />
				<ec:column property="createTime" title="创建时间" style="text-align:center" >
					<fmt:formatDate value="${wfFlowInstance.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</ec:column>
				<ec:column property="curStep" title="当前步骤" style="text-align:center" />
				<%--
				<ec:column property="timeLimitStr" title="剩余时间" style="text-align:center" />
				<ec:column property="subFlow" title="是否是子流程" style="text-align:center" />
				 --%>
				<ec:column property="unitCode" title="办理处室" style="text-align:left">
				${cp:MAPVALUE("unitcode",wfFlowInstance.unitCode)}
				</ec:column>
				<ec:column property="opt" title="操作" sortable="false" width="180px;"
					style="text-align:center">
					<a href="<c:url value='/yxxk/qlyxDj!viewBjInfo.do?flowInstId=${wfFlowInstance.flowInstId}'/>">办件信息查看</a>
					<%-- <a href='sampleFlowManager!viewFlowInstNodes.do?flowInstId=${wfFlowInstance.flowInstId}'>节点查看</a> --%>
					<a href='sampleFlowManager!viewxml.do?flowInstId=${wfFlowInstance.flowInstId}'>查看流程图</a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
