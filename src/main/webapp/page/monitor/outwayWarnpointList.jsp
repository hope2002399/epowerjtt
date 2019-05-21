<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html>
	<head>
		<title>预报警规则定义</title>
		<script type="text/javascript">
		  function resetForm(){
			  $('#s_wpExeType').val('');
			  $('#s_wpName').val('');
			  $('#s_wpLevelNo').val('');
			  $('#s_wpStatus').val('');
			  $('#s_wpSource').val('');
			  $('#s_wpRunning').val('');
			  $('#s_wpTypeNo').val('');
		  }
		</script>
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<div class="search">
			<div class="crumbs">
				预警报警规则管理
			</div>
			<s:form action="outwayWarnpoint" namespace="/monitor" style="margin-top:0;margin-bottom:5" id="outwayWarnpointForm">
				<table>
					<tr>
						<td class="addTd">预报警名称:</td>
						<td>
							<s:textfield name="s_wpName"  value="%{#parameters['s_wpName']}" style="width: 180px" />
						</td>
						<td class="addTd">执行方式:</td>
						<td>
							<select name="s_wpExeType" style="width: 180px">
								<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('ExeType')}">
									<option value="${row.key}"
										<c:if test="${parameters.s_wpExeType[0] eq row.key}">selected="selected"</c:if>>
										<c:out value="${row.value}" />
									</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					
					<tr>
						<td class="addTd">异常级别:</td>
						<td>
							<select name="s_wpLevelNo" style="width: 180px">
								<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('MONITOR_STYLE')}">
									<option value="${row.key}"
										<c:if test="${parameters.s_wpLevelNo[0] eq row.key}">selected="selected"</c:if>>
										<c:out value="${row.value}" />
									</option>
								</c:forEach>
							</select>
						</td>
						
						<td class="addTd">异常类型:</td>
						<td>
							<select name="s_wpTypeNo" style="width: 180px">
								<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('MONITOR_TYPE')}">
									<option value="${row.key}"
										<c:if test="${parameters.s_wpTypeNo[0] eq row.key}">selected="selected"</c:if>>
										<c:out value="${row.value}" />
									</option>
								</c:forEach>
							</select>
						</td>
					</tr>	

					<tr>
						<td class="addTd">是否启用:</td>
						<td>
							<select name="s_wpStatus" style="width: 180px">
								<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('TrueOrFalse')}">
									<option value="${row.key}"
										<c:if test="${parameters.s_wpStatus[0] eq row.key}">selected="selected"</c:if>>
										<c:out value="${row.value}" />
									</option>
								</c:forEach>
							</select>
						</td>
						<td class="addTd">异常源:</td>
						<td>
							<select name="s_wpSource" style="width: 180px">
								<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('OutwaySource')}">
									<option value="${row.key}"
										<c:if test="${parameters.s_wpSource[0] eq row.key}">selected="selected"</c:if>>
										<c:out value="${row.value}" />
									</option>
								</c:forEach>
							</select>
						</td>
					</tr>

					<tr>
						<td class="addTd">是否在运行:</td>
						<td>
							<select name="s_wpRunning" style="width: 180px">
								<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('TrueOrFalse')}">
									<option value="${row.key}"
										<c:if test="${parameters.s_wpRunning[0] eq row.key}">selected="selected"</c:if>>
										<c:out value="${row.value}" />
									</option>
								</c:forEach>
							</select>
						</td>
						<td  align="center" colspan="2">
							<s:submit method="list" key="opt.btn.query" cssClass="btn" />
							<input type="reset" value="重置" onclick="resetForm()" class="btn"/>
						</td>
					</tr>
				</table>
			</s:form>
		</div>

			<ec:table action="outwayWarnpoint!list.do" items="objList" var="outwayWarnpoint"
				imagePath="${contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="outwayWarnpoints.xls" tooltip="导出为Excel"></ec:exportXls>
			<%-- <ec:exportPdf fileName="outwayWarnpoints.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf> --%>
			<ec:row>

				<ec:column property="wpNo" title="规则编号" style="text-align:center" />
				
				<ec:column property="wpName" title="规则名称" style="text-align:center" />

				<ec:column property="wpType" title="异常类型" style="text-align:center" />

				<ec:column property="wpLevel" title="异常级别" style="text-align:center" />
				
				<ec:column property="wpStatus" title="是否启用" style="text-align:center">
					${cp:MAPVALUE('TrueOrFalse',outwayWarnpoint.wpStatus)}
				</ec:column>

				<ec:column property="wpSource" title="异常源" style="text-align:center">
					${cp:MAPVALUE('OutwaySource',outwayWarnpoint.wpSource)}
				</ec:column>

				<ec:column property="wpRunning" title="是否运行中" style="text-align:center">
					${cp:MAPVALUE('TrueOrFalse',outwayWarnpoint.wpRunning)}
				</ec:column>
					
				<ec:column property="wpExeType" title="执行方式" style="text-align:center">
					${cp:MAPVALUE('ExeType',outwayWarnpoint.wpExeType)}
				</ec:column>
		
				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">
					<c:if test="${outwayWarnpoint.wpRunning eq 'F'}">
						<a href='outwayWarnpoint!edit.do?wpNo=${outwayWarnpoint.wpNo}'>编辑</a>
					</c:if>
					<c:if test="${outwayWarnpoint.wpRunning eq 'T'}">
						<a href='outwayWarnpoint!view.do?wpNo=${outwayWarnpoint.wpNo}' title="规则正在运行,不能编辑">查看</a>
					</c:if>
					<c:if test="${outwayWarnpoint.wpExeType eq 'M'}">
						<a href='outwayWarnpoint!run.do?wpNo=${outwayWarnpoint.wpNo}'>运行</a>
					</c:if>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
