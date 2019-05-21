<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title>
		行政许可查询
		</title>
		<script type="text/javascript">
		  function resetForm(){
			  $('#s_applicantName').val('');
			  $('#s_transactAffairName').val('');
			  $('#s_internalNo').val('');
			  $('#finishBeginTime').val('');
			  $('#finishEndTime').val('');
			  $('#s_sendWay').val('');
			  $('#applyBeginTime').val('');
			  $('#applyEndTime').val('');
			  $('#s_servicetype').val('');
			  document.forms[0].s_queryUnderUnit.checked=false;
		  }
		</script>
		<sj:head locale="zh_CN" />
		<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/scripts/plugin/My97DatePicker/myWdatePicker.js"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<div class="search">
		<div class="crumbs">文书送达查询</div>
			<s:form action="optApplyResult" namespace="/powerruntime">
						<%
							String startTime = (String)request.getAttribute("startTime");
							String endTime   = (String)request.getAttribute("endTime");
							String startDate = (String)request.getAttribute("startDate");
							String endDate   = (String)request.getAttribute("endDate");
						%>
				<table cellpadding="0" cellspacing="0" align="center">
					<tr>
						<td class="addTd">申请者：</td>
						<td><s:textfield id="s_applicantName" name="s_applicantName" value="%{#parameters['s_applicantName']}"/> </td>
						<td class="addTd">送达方式：</td>
						<td>
							<select name="s_sendWay" id="s_sendWay" style="width:160px">
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('SDFS')}">
									<option value="${row.key}" <c:if test="${param.s_sendWay eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" /></option>
								</c:forEach>
							</select>
						</td>  
					</tr>	
					<tr>
						<td class="addTd">办件名称：</td>
						<td><s:textfield name="s_transactAffairName" id="s_transactAffairName" value="%{#parameters['s_transactAffairName']}"/> </td>
						 <td class="addTd">办件编号：</td>
						<td><s:textfield name="s_internalNo" id="s_internalNo" value="%{#parameters['s_internalNo']}"/> </td>
					</tr>
					<tr>
						<td class="addTd">办结开始时间：</td>
						<td>
							<input type="text" class="Wdate" style="height: 28px; border-radius: 3px; border: 1px solid #cccccc;" id="finishBeginTime" 
							 value="<%=startTime%>" name="s_finishBeginTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="选择日期">
						 </td>
						 <td class="addTd">办结结束时间：</td>
						<td>
							<input type="text" class="Wdate" style="height: 28px; border-radius: 3px; border: 1px solid #cccccc;" id="finishEndTime" 
							 value="<%=endTime%>" name="s_finishEndTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="选择日期">
						</td>
					</tr>
					<tr>
						<td class="addTd">申请开始时间：</td>
						<td>
							<input type="text" class="Wdate" style="height: 28px; border-radius: 3px; border: 1px solid #cccccc;" id="applyBeginTime" 
							 value="<%=startDate%>" name="s_applyBeginTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="选择日期">
						 </td>
						 <td class="addTd">申请结束时间：</td>
						<td>
							<input type="text" class="Wdate" style="height: 28px; border-radius: 3px; border: 1px solid #cccccc;" id="applyEndTime" 
							 value="<%=endDate%>" name="s_applyEndTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="选择日期">
						</td>
					</tr>
					<tr>
						<td class="addTd">服务类别：</td>
						<td>
							<select name="s_servicetype" id="s_servicetype" style="width:160px">
								<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('FWLB')}">
									<option value="${row.key}" <c:if test="${param.s_servicetype eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" /></option>
								</c:forEach>
							</select>
						</td> 
						<td class="addTd"></td>
						<td></td>
					</tr>
					<tr>
						
						<td align="center" colspan="4">
							<s:submit method="list"  key="opt.btn.query" cssClass="btn"/>&nbsp;&nbsp;&nbsp;
							<input type="button" name="reset" value="重置" class="btn" onclick="resetForm();"/>
						</td>
						</tr>
				</table>
			</s:form>
		</div>
		
		<ec:table action="powerruntime/optApplyResult!list.do" items="srPermitApplyList" var="srPermitApply"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="internalNo" title="办件编号" style="text-align:center" sortable="false"/>
				<ec:column property="transactAffairName" title="办件名称" style="text-align:center" sortable="false">
					<c:choose>
					<c:when test="${fn:length(srPermitApply.transactAffairName) > 20}">
						<c:out value="${fn:substring(srPermitApply.transactAffairName, 0, 20)}..." />
					</c:when>
					<c:otherwise>
						<c:out value="${srPermitApply.transactAffairName}" />
					</c:otherwise>
				</c:choose>
				</ec:column>
				
				<ec:column property="applyDate" title="申请日期" style="text-align:center" sortable="false" >
				<fmt:formatDate value="${srPermitApply.applyDate}" type="both"/>
				</ec:column>
				<ec:column property="applicantName" title="申请者" style="text-align:center" sortable="false"/>
				<ec:column property="content" title="申请事项" style="text-align:center" sortable="false"/>
				<ec:column property="finishTime" title="办结日期" style="text-align:center" sortable="false" >
				<fmt:formatDate value="${srPermitApply.finishTime}" type="both"/>
				</ec:column>
				<ec:column property="sendway" title="送达方式" style="text-align:center" sortable="false">
				${cp:MAPVALUE("SDFS",srPermitApply.sendway)}
				</ec:column>
				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><s:text name="label.delete.confirm"/></c:set>
					
				<a href="powerruntime/optApplyResult!view.do?internalNo=${srPermitApply.internalNo}">查看详情</a>
				<a href="javascript:void(0);" onclick="openNewWindow('<%=request.getContextPath()%>/powerruntime/optRelevancyResult!edit.do?internalNo=${srPermitApply.internalNo}','powerWindow',null);">送达方式</a>
				</ec:column>
			</ec:row>
		</ec:table>

	</body>
	<script type="text/javascript">
	/**
	 * common window dialogs
	 */
	 
	function openNewWindow(winUrl, winName, winProps) {
		 if (winProps == '' || winProps == null) {
			winProps = 'height=300px,width=750px,directories=false,location=false,top=100,left=500,menubar=false,Resizable=yes,scrollbars=yes,toolbar=false';
		} 
		window.open(winUrl, winName, winProps);
	}
</script>
</html>
