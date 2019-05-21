<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title>办件列表</title>
		<sj:head locale="zh_CN" />
   
	<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
	<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />	
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset
			style="border: hidden 1px #000000; ">
			<legend>
				 ${param['title']} 
			</legend>
			<%
						String type = request.getParameter("type");
						String s_NP_result = request.getParameter("s_NP_result");
						String s_NP_process = request.getParameter("s_NP_process");
			%>
			<s:form action="apply" namespace="/monitor" style="margin-top:0;margin-bottom:5" id="applyForm" method="post" >
				<input type="hidden" id="title" name="title"  value="${param['title']}"/>
				<input type="hidden" id="type" name="type"  value="<%=type %>"/>
				<input type="hidden" id="s_NP_result" name="s_NP_result"   value="<%=s_NP_result%>"/>
				<input type="hidden" id="s_NP_process" name="s_NP_process"   value="<%=s_NP_process %>"/>
				<table cellpadding="0" cellspacing="0" align="center">
					<tr height="22">
						<td>部门名称:</td>
						<td>
						<input type="text" id="orgName" name="orgName"  value="${cp:MAPVALUE('depno',param.s_orgId)}"/>
					<input type="hidden" id="s_orgId" name="s_orgId" value="${param.s_orgId}"/>
							<s:checkbox label="包含下属机构" name="s_queryUnderUnit" value="#parameters['s_queryUnderUnit']" fieldValue="true" />包含下属机构		</td>
					</tr>
					
					<tr height="22">
						<td>办件编号:</td>
						<td><s:textfield name="s_internalNo"  value="%{#parameters['s_internalNo']}"/> </td>
						<td>当事人:</td>
						<td><s:textfield name="s_applicantName"  value="%{#parameters['s_applicantName']}"/> </td>
						<%-- <td>部门名称:</td>
						<td><select name="s_orgId">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${unitList }">
								<option value="${row.depno}"
									<c:if test="${parameters.s_orgId[0] eq row.depno}">selected="selected"</c:if>>
									<c:out value="${row.unitname}" />
								</option>
							</c:forEach>
					</select>
					 		<s:checkbox label="包含下属机构" name="s_queryUnderUnit" value="#parameters['s_queryUnderUnit']" fieldValue="true" />包含下属机构	
					 </td> --%>
					</tr>	
					

					
					<tr height="22">
						<td>权力类型:</td>
						<td>
					<select name="item_type" style="width: 180px"
						onchange="checkItemType();">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('ITEM_TYPE')}">
								<option value="${row.key}"
									<c:if test="${parameters.item_type[0] eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select>
					</td>
					<td>权力名称:</td>
						<td>
						<select name="s_itemId" style="width: 180px">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${itemList }">
								<option value="${row.itemId}"
									<c:if test="${parameters.s_itemId[0] eq row.itemId}">selected="selected"</c:if>>
									<c:out value="${row.itemName}" />
								</option>
							</c:forEach>
					</select>
					</td>
					</tr>
					<%
						if("result".equals(type)){
					%>
					<tr height="22">
						<td>开始时间:</td>
						<td><sj:datepicker name="s_begFinishTime" readonly="true" value="%{#parameters['s_begFinishTime']}" yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" /> </td>
					<td>结束时间:</td>
						<td><sj:datepicker name="s_endFinishTime" readonly="true" value="%{#parameters['s_endFinishTime']}" yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" /> </td>
					</tr>	
					<%
						}else{
					%>
					<tr height="22">
						<td>开始时间:</td>
						<td><sj:datepicker name="s_begTime" readonly="true" value="%{#parameters['s_begTime']}" yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" /> </td>
					<td>结束时间:</td>
						<td><sj:datepicker name="s_endTime" readonly="true" value="%{#parameters['s_endTime']}" yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" /> </td>
					</tr>	
					<%} %>
					

					<tr>
						<td>
							<s:submit method="list" key="opt.btn.query" cssClass="btn" />
						</td>
						
					</tr>
				</table>
			</s:form>
		</fieldset>

			<ec:table action="monitor/apply!list.do" items="applyList" var="apply"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif"  retrieveRowsCallback="limit">
			
			<ec:row>
				
					<ec:column property="isrisk" title="风险" style="text-align:center">
				<c:if test="${apply.isrisk eq 1}"><img align="middle" alt="重要权力" src="${pageContext.request.contextPath}/images/risk_point.gif" /></c:if><c:if
						test='${ apply.isrisk  eq 2}'><img align="middle" alt="关键环节" src="${pageContext.request.contextPath}/images/risk.gif" /></c:if>
						<c:if
						test='${ apply.isrisk eq 0}'>&nbsp;</c:if>
					</ec:column>
				<ec:column property="monitorStyle" title="预警" style="text-align:center">
				<c:if test="${apply.monitorStyle eq 1}"><img align="middle" alt="预警" src="${pageContext.request.contextPath}/images/yellow.gif" /></c:if><c:if
						test='${ apply.monitorStyle  eq 2}'><img align="middle" alt="报警" src="${pageContext.request.contextPath}/images/red.gif" /></c:if>
						<c:if
						test='${ apply.monitorStyle eq 3}'><img align="middle" alt="提醒" src="${pageContext.request.contextPath}/images/green.gif" /></c:if>
				</ec:column>
					<ec:column property="internalNo" title="办件编号" style="text-align:center">
					<a href='apply!view.do?internalNo=${apply.internalNo}&itemId=${apply.itemId }'>${apply.internalNo }</a>
					</ec:column>
				
					<ec:column property="orgId" title="主办部门" style="text-align:center">
					${cp:MAPVALUE("depno",apply.orgId)}
					</ec:column>
				<ec:column property="department" title="业务科室" style="text-align:center" />
				
					
					
					
					
					<ec:column property="itemId" title="办件名称" style="text-align:center">
					${cp:MAPVALUE("suppowerId",apply.itemId)}
					</ec:column>
				
					
				
					
					<ec:column property="applyDate" title="登记时间" style="text-align:center">
				<fmt:formatDate value='${apply.applyDate}' pattern='yyyy-MM-dd HH:mm:ss' />
				</ec:column>
					<ec:column property="ss" title="操作" style="text-align:center" width="7%">
						<a href="<%=request.getContextPath()%>/complaint/complaint!edit.do?object.bjNo=${apply.no}&object.bjType=1&object.optId=complaint" style="color: red">投诉</a>	
						<a href="<%=request.getContextPath()%>/supervise/superviseBasic!superviseinitiate.do?bjNo=${apply.no}&bjType=1&object.optId=supervise&fromsup=1&isOrg=T&monitorOrgId=${apply.orgId}" style="color: red">督办</a>				
					</ec:column>
				
				

			</ec:row>
		</ec:table>

	</body>
	<script type="text/javascript">
	//function doEditOpt(){
	//$("showMessage").show();	
	//}
	function checkItemType() {
		
		 var form=document.getElementById("applyForm");
	     form.action="apply!list.do";     
	     form.submit();
	}
</script>
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
		bindEvent($("#orgName"),$("#s_orgId"),$this);
		$("#lists span").die("click");
	});
});


</script>
</html>
