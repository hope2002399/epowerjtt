<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title>
		许可预受理查询
		</title>
		<sj:head locale="zh_CN" />
		<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset>
			<legend>
				 查询条件
			</legend>
			<s:form action="optApplyNet" namespace="/powerruntime" style="margin-top:0;margin-bottom:5">
				<s:hidden id="s_item_Type" name="s_item_Type" type="hidden" value="%{#parameters['s_item_Type']}" />
				<table cellpadding="0" cellspacing="0" align="center">
					<tr >
						<td class="addTd">申请者:</td>
						<td width="250"><s:textfield name="s_proposer_Name" value="%{#parameters['s_proposer_Name']}"/> </td>
						<td class="addTd">申请者机构代码:</td>
						<td><s:textfield name="s_proposer_Unitcode" value="%{#parameters['s_proposer_Unitcode']}"/> </td>
					</tr>	
					<tr>
						<td class="addTd">办件名称:</td>
						<td><s:textfield name="s_transaffairname" value="%{#parameters['s_transaffairname']}"/> </td>
						<%-- <td class="addTd">申请方式:</td>
						<td>
							<select name="s_apply_Way" style="width:154px">
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('bjsqfs')}">
									<option value="${row.key}" <c:if test="${param.s_apply_Way eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" /></option>
								</c:forEach>
							</select>
						</td> --%>
					</tr>
						<tr>
						<td class="addTd">预受理部门：</td>
						<td>						
				<input type="text" id="orgName" name="orgName" style="width:58%;height:25px;" value="${cp:MAPVALUE('unitcode',param.s_orgcode)}"/>
				<input type="hidden" id="s_orgcode" name="s_orgcode" value="${param.s_orgcode}"/>	
						<s:checkbox label="包含下属机构" name="s_queryUnderUnit" value="#parameters['s_queryUnderUnit']" fieldValue="true" />包含下属机构	
						</td>	
						<td>
						<s:checkbox label="包含已删除" name="s_NP_delete" value="#parameters['s_NP_delete']" fieldValue="true" />包含已删除				
					</td>	
						<td colspan="1">
							<s:submit method="showlist"  key="opt.btn.query" cssClass="btn"/>
						</td>
					</tr>
				</table>
			</s:form>
		</fieldset>

		<ec:table action="powerruntime/optApplyNet!list.do" items="srPermitApplyList" var="srPermitApply"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="netId" title="外网登记编号" style="text-align:center" sortable="false"/>
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
				<ec:column property="powername" title="申请事项"  style="text-align:center">
					<c:choose>
					<c:when test="${fn:length(srPermitApply.powername) > 20}">
						<c:out value="${fn:substring(srPermitApply.powername, 0, 20)}..." />
					</c:when>
					<c:otherwise>
						<c:out value="${srPermitApply.powername}" />
					</c:otherwise>
				</c:choose>
				</ec:column>
				<ec:column property="proposerType" title="申请者类别" style="text-align:center" sortable="false">
				${cp:MAPVALUE("PROPOSER_TYPE",srPermitApply.proposerType)}
				</ec:column>

				<ec:column property="applyWay" title="申请方式" style="text-align:center" sortable="false">
				${cp:MAPVALUE("bjsqfs",srPermitApply.applyWay)}
				</ec:column>
				<ec:column property="bizstate" title="预受理状态" style="text-align:center" sortable="false">
				${cp:MAPVALUE("YSLBIZSTATE",srPermitApply.bizstate)}
				</ec:column>
				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">
					<%-- <c:set var="deletecofirm"><s:text name="label.delete.confirm"/></c:set> --%>
					<c:if test="${srPermitApply.bizstate eq 'F' }"><%-- 
					<a href='powerruntime/optApply!edit.do?djId=${srPermitApply.djId}'>编辑</a>
					<a href='powerruntime/optApply!delete.do?djId=${srPermitApply.djId}' 
							onclick='return confirm("${deletecofirm}srPermitApply?");'>删除</a> --%>
				<a href="powerruntime/optApplyNet!generalOptView.do?netId=${srPermitApply.netId}&caozuo=shencha">预受理审查</a>
				</c:if>
				<%-- <a href="powerruntime/optApplyNet!generalOptView.do?netId=${srPermitApply.netId}&caozuo=chakan">查看预受理办件</a> --%>
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
