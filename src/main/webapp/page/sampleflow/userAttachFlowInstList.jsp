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
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset>
			<legend>
				 我参与的流程
			</legend>
					<s:form action="sampleFlowManager" namespace="/sampleflow">
				<table cellpadding="0" cellspacing="0" align="left">
					<tr >
						<td class="addTd">办件名称:</td>
						<td width="300">
						<s:textfield name="s_flowOptName" value="%{#parameters['s_flowOptName']}" />
						 </td>
						<td class="addTd">收文号:</td>
						<td>
							<s:textfield name="s_flowOptTag" value="%{#parameters['s_flowOptTag']}" />
						</td>
					</tr>
					<tr >
						<td class="addTd">业务状态:</td>
						<td width="300">
							<select name="s_inststate">
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('WFInstType')}">
									<option value="${row.key}" <c:if test="${param.s_inststate==row.key}">selected="selected"</c:if>>
									
									<c:out value="${row.value}" /></option>
								</c:forEach>
							</select>
						</td>
						<td  class="addTd">办理处室:</td>
						<td>
							 <select name="s_unitcode">
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:SUBUNITS('d00001','YW,NY')}">
									<option value="${row.unitcode}"  <c:if test="${param.s_unitcode==row.unitcode}">selected="selected"</c:if>>
									<c:out value="${row.unitname}" />
									</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr >
						<td class="addTd" >创建时间:</td>
						<td>
						<sj:datepicker id="s_createtime"
							name="s_createtime" value="%{#parameters['s_createtime']}"
							yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" />
						
						 </td>
						<td class="addTd">完成时间:</td>
						<td>
						<sj:datepicker id="lastUpdateTime"
							name="s_lastUpdateTime" value="%{#parameters['s_lastUpdateTime']}"
							yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" />
						
						 </td>
					</tr>
					<%-- <tr >
						<td class="addTd">创建用户:</td>
						<td><div class="userDiv">
						<input type="text" name="userName" value="${cp:MAPVALUE('usercode',param.s_usercode)}"/>
						<s:hidden name="s_usercode" value="%{#parameters['s_usercode']}"/>
						<ul id="list"></ul>
						</div>
						<script type="text/javascript">
						$(function(){
							initValue($("input[name=userName]"),$("#list"),"${pageContext.request.contextPath}/sys/userDef!getUsers.do",$("input[name=s_usercode]"));
						})
						</script>
						</td>
						  
						<td class="addTd">操作方法:</td>
						<td>
						<select name="s_optcode">   
							<option value="">   
									<c:out value="-- 请选择 --"/>   
							</option>    
							<c:forEach var="opt" items="${cp:IS_FLOWOPTDEF('T')}">
								<option value="${opt.optcode}" <c:if test="${param.s_optcode==opt.optcode}">selected="selected"</c:if> >   
									<c:out value="${opt.optname}"/>   
								</option>
							</c:forEach> 
						</select>
					</td>
					</tr> --%>
					<tr>
<%-- 						<td class="addTd">包含节点:</td>
						<td><s:textfield name="s_nodeid" /> </td>
 --%>					<td class="addTd">包含完成:</td>
						<td>
							<s:checkbox name="s_isAll" value="#parameters['s_isAll']" fieldValue="true" />
						</td>
					</tr>
<%-- 					<tr>
					
					<td class="addTd">参与用户:</td>
						<td><div class="userDiv">
						<input type="text" name="attachUserName" value="${cp:MAPVALUE('usercode',param.s_attachuser)}"/>
						<s:hidden name="s_attachuser" value="%{#parameters['s_attachuser']}"/>
						<ul id="list1"></ul>
						</div>
						<script type="text/javascript">
						$(function(){
							initValue($("input[name=attachUserName]"),$("#list1"),"${pageContext.request.contextPath}/sys/userDef!getUsers.do",$("input[name=s_attachuser]"));
						})
						</script>
						</td>
					</tr> --%>
					<tr>
						<td colspan="8" >
							<s:submit method="listUserAttach"  value="查询" cssClass="btn"/>&nbsp;
							<s:reset name="reset" cssClass="btn" value="重置"></s:reset> &nbsp;
						</td>
					</tr>
				</table>
			</s:form>
		</fieldset>
		<ec:table action="sampleFlowManager!listUserAttach.do" items="objList" var="wfFlowInstance"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="flowInstId" title="流程实例编号" style="text-align:center" />
				<ec:column property="flowName" title="业务名称" style="text-align:center"/>
				<ec:column property="version" title="流程版本" style="text-align:center"/>
				<ec:column property="flowOptName" title="办件名称" style="text-align:center" />
				<ec:column property="flowOptTag" title="收文号" style="text-align:center" />
				<ec:column property="createTime" title="创建时间" style="text-align:center" />
				<ec:column property="instState" title="流程状态" style="text-align:center">
				${cp:MAPVALUE("WFInstType",wfFlowInstance.instState)}
				</ec:column>
				<ec:column property="subFlow" title="是否是子流程" style="text-align:center" />
				<ec:column property="unitCode" title="办理处室" style="text-align:center">
				${cp:MAPVALUE("unitcode",wfFlowInstance.unitCode)}
				</ec:column>
				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">
					<a href='sampleFlowManager!listFlowInstNodes.do?flowInstId=${wfFlowInstance.flowInstId}'>流程管理</a>
					<a href='sampleFlowManager!viewxml.do?flowInstId=${wfFlowInstance.flowInstId}'>查看流程图</a>
				</ec:column>
			</ec:row>
		</ec:table>

	</body>
</html>
