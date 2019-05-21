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
			  $('#s_proposer_Name').val('');
			  //$('#s_proposer_Unitcode').val('');
			  $('#s_transaffairname').val('');
			  //$('#s_apply_Way').val('');
			  $('#orgName').val('');
			  $('#s_orgcode').val('');
			  $('#s_biztype').val('');
			  document.forms[0].s_queryUnderUnit.checked=false;
		  }
		</script>
		<sj:head locale="zh_CN" />
		<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<div class="search">
		<div class="crumbs">办件查询</div>
			<s:form action="optApply" namespace="/powerruntime">
			<input type="hidden" id="s_applyItemType" name="s_applyItemType" value="${param.s_applyItemType}" />
				<table cellpadding="0" cellspacing="0" align="center">
					<tr>
						<td class="addTd">申请者：</td>
						<td><s:textfield id="s_proposer_Name" name="s_proposer_Name" value="%{#parameters['s_proposer_Name']}"/> </td>
						<%-- <td class="addTd">申请者机构代码：</td>
						<td><s:textfield name="s_proposer_Unitcode" id="s_proposer_Unitcode" value="%{#parameters['s_proposer_Unitcode']}"/> </td> --%>
						<td class="addTd">办理部门：</td>
						<td>						
							<input type="text" id="orgName" name="orgName" value="${cp:MAPVALUE('unitcode',param.s_orgcode)}"/>
							<input type="hidden" id="s_orgcode" name="s_orgcode" value="${param.s_orgcode}"/>	
							<s:checkbox cssClass="checkbox" label="包含下属机构" name="s_queryUnderUnit" id="s_queryUnderUnit" value="#parameters['s_queryUnderUnit']" fieldValue="true" />包含下属机构	
						</td>
					</tr>	
					<tr>
						<td class="addTd">办件名称：</td>
						<td><s:textfield name="s_transaffairname" id="s_transaffairname" value="%{#parameters['s_transaffairname']}"/> </td>
						<%-- <td class="addTd">申请方式：</td>
						<td>
							<select name="s_apply_Way" id="s_apply_Way" style="width:160px">
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('bjsqfs')}">
									<option value="${row.key}" <c:if test="${param.s_apply_Way eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" /></option>
								</c:forEach>
							</select>
						</td> --%>
						 <td class="addTd">办理状态：</td>
						<td>
							<select name="s_biztype" id="s_biztype" style="width:160px">
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('bizType')}">
									<option value="${row.key}" <c:if test="${param.s_biztype eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" /></option>
								</c:forEach>
							</select>
						</td>  
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
		
		<ec:table action="powerruntime/optApply!list.do" items="srPermitApplyList" var="srPermitApply"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="transAffairNo" title="办件编号" style="text-align:center" sortable="false"/>
				<ec:column property="transaffairname" title="办件名称" style="text-align:center" sortable="false">
					<c:choose>
					<c:when test="${fn:length(srPermitApply.transaffairname) > 20}">
						<c:out value="${fn:substring(srPermitApply.transaffairname, 0, 20)}..." />
					</c:when>
					<c:otherwise>
						<c:out value="${srPermitApply.transaffairname}" />
					</c:otherwise>
				</c:choose>
				</ec:column>
				
				<ec:column property="applyDate" title="申请日期" style="text-align:center" sortable="false" >
				<fmt:formatDate value="${srPermitApply.applyDate}" type="both"/>
				</ec:column>
				<ec:column property="proposerName" title="申请者" style="text-align:center" sortable="false"/>
				<ec:column property="applyItemType" title="权力名称" style="text-align:center" sortable="false">
				${cp:MAPVALUE("ITEM_TYPE",srPermitApply.powername)}
				</ec:column>
				<ec:column property="proposerType" title="办件状态" style="text-align:center" sortable="false">
				${cp:MAPVALUE("bizType",srPermitApply.biztype)}
				</ec:column>
				<%-- <ec:column property="proposerType" title="申请者类别" style="text-align:center" sortable="false">
				${cp:MAPVALUE("PROPOSER_TYPE",srPermitApply.proposerType)}
				</ec:column>
				<ec:column property="proposerUnitcode" title="申请者机构代码" style="text-align:center" sortable="false">
				</ec:column>
				<ec:column property="applyWay" title="申请方式" style="text-align:center" sortable="false">
				${cp:MAPVALUE("bjsqfs",srPermitApply.applyWay)}
				</ec:column> --%>
				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><s:text name="label.delete.confirm"/></c:set>
					<c:if test="${srPermitApply.biztype eq 'F' }">
						<a href='powerruntime/optApply!edit.do?djId=${srPermitApply.djId}'>编辑</a>
						<a href='powerruntime/optApply!delete.do?djId=${srPermitApply.djId}' 
							onclick='return confirm("${deletecofirm}办件：${srPermitApply.transAffairNo}?");'>删除</a>
					</c:if>
					
				<a href="powerruntime/optApply!generalOptView.do?djId=${srPermitApply.djId}">查看办件</a>
				<c:if test="${!(empty srPermitApply.flowinstid)  }">
						<a href='<%=request.getContextPath()%>/sampleflow/sampleFlowManager!viewxml.do?flowInstId=${srPermitApply.flowinstid}' target="_blank">查看流程图</a>
					</c:if>
				</ec:column>
			</ec:row>
		</ec:table>

	</body>
	<script type="text/javascript">
function bindEvent(o1,o2,$this){
	o1.val($this.html());
	o2.val($this.attr("rel"));
	if(getID("shadow")){
		$("#shadow").hide();
		$("#boxContent").hide();
	}
}
$("#orgName").bind('click',function(){
	var menuList = ${unitsJson};
	var shadow = "<div id='shadow'></div><div id='boxContent'><div class='listShadow'></div><div id='lists' class='getTree'>Loader</div><div id='close'>×</div></div>";
	if(getID("shadow")){
		$("#shadow").show();
		$("#boxContent").show();
	}else{
		$("body").append(shadow);
		$("#shadow").height(document.body.scrollHeight);
		setTimeout(function(){
			menuDisplay(menuList,"${parentunit}");	
		},0);
	};
	$("#lists span").live('click',function(){
		var $this = $(this);
		bindEvent($("#orgName"),$("#s_orgcode"),$this);
		$("#lists span").die("click");
	});
});


</script>
</html>
