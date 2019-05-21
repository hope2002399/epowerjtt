<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title>
		督查待办列表
		</title>
		<script type="text/javascript">
		 function resetForm(){
			 $('#s_bjType').val('');
			 $('#s_internalNo').val('');
			 $('#s_orgId').val('');
			 $('#s_superviseNo').val('');
		 }
		
		</script>
<style type="text/css">
		.search td{padding:0px 10px 0px 10px;}
</style>
		<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<div class="search">
			<div class="crumbs">
				预警报警
			</div>
			
			<s:form action="VUserTaskListSupervise" namespace="/supervise" style="margin-top:0;margin-bottom:5">
				<input name="s_monitorSource" type="hidden" value="${param.s_monitorSource}"/>
				<input type="hidden" name="s_NP_monitorSource" value="${param.s_NP_monitorSource}" />
				<table cellpadding="0" cellspacing="0" align="center">
			

					<tr >
						<td>督办件类型:</td>
						<td>
						<select id="s_bjType" name="s_bjType" id="s_bjType" style="width: 160px">
				<option value="">--请选择--</option>
					<c:forEach var="row" items="${cp:DICTIONARY('bjType')}">
						<option value="${row.key}"
						<c:if test="${param.s_bjType eq row.key}"> selected = "selected" </c:if> 
						>
						<c:out value="${row.value}"/></option>
					</c:forEach>
			</select>
						</td>
						<td>办件编号:</td>
						<td><s:textfield name="s_internalNo" id="s_internalNo" value="%{#parameters['s_internalNo']}"/> </td>
					</tr>
					<tr >
						<td>督办发起部门:</td>
						<%-- <td><s:textfield name="s_orgId" id="s_orgId" value="%{#parameters['s_orgId']}"/> </td> --%>
						<td>
						<input type="text" id="orgName" name="orgName"  value="${cp:MAPVALUE('unitcode',param.s_unitCode)}" style="width: 160px"/>
						<input type="hidden" id="s_unitCode" name="s_unitCode" value="${param.s_unitCode}"/>	
						<s:checkbox label="包含下属机构" name="s_queryUnderUnit" value="#parameters['s_queryUnderUnit']" fieldValue="true" />包含下属机构	
						</td>
					<td>督办流水号:</td>
						<td><s:textfield name="s_superviseNo"id="s_superviseNo" value="%{#parameters['s_superviseNo']}"/> </td>
					</tr>

					<tr>
						<td colspan="4" align="center">
							<s:submit method="list"  key="opt.btn.query" cssClass="btn"/>
						   <input type="button" name="reset" value="重置" class="btn" onclick="resetForm();"/>
						</td>
					</tr>
				</table>
			</s:form>
		</div>

		<ec:table action="supervise/VUserTaskListSupervise!list.do" items="objList" var="VUserTaskListSupervise"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
			<ec:column property="superviseNo" title="督办流水号" style="text-align:center" sortable="true"/>
			<ec:column property="bjType" title="督办件类别" style="text-align:center" sortable="false">
			${cp:MAPVALUE("bjType",VUserTaskListSupervise.bjType)}
			</ec:column>
				<c:if test="${VUserTaskListSupervise.monitorSource ne C}">	
				<ec:column property="internalNo" title="办件编号" style="text-align:center" sortable="true"/>
				<ec:column property="bjname" title="办件名称" style="text-align:center" sortable="true">
				<c:choose>
					<c:when test="${fn:length(VUserTaskListSupervise.bjname) >20}">
						<c:out value="${fn:substring(VUserTaskListSupervise.bjname, 0, 20)}..." />
					</c:when>
					<c:otherwise>
						<c:out value="${VUserTaskListSupervise.bjname}" />
					</c:otherwise>
				</c:choose>
				</ec:column>
				</c:if>
				<ec:column property="unitCode" title="主办部门" style="text-align:center" sortable="true">
				${cp:MAPVALUE("unitcode",VUserTaskListSupervise.unitCode)}
				</ec:column>
				<ec:column property="nodeCreateTime" title="更新时间" style="text-align:center" format="yyyy-MM-dd HH:mm:ss" cell="date" sortable="true"/>
				
				<ec:column property="nodeName" title="当前步骤" style="text-align:center" sortable="false">
				${VUserTaskListSupervise.nodeName}
				<c:if test="${VUserTaskListSupervise.grantor ne null }">
					 (委托)
				</c:if>
			</ec:column>
				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">
						<a href="<c:url value='${VUserTaskListSupervise.nodeOptUrl}' />" >办理</a>
					<a href='<%=request.getContextPath()%>/sampleflow/sampleFlowManager!viewxml.do?flowInstId=${VUserTaskListSupervise.flowInstId}'>查看流程图</a>
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
			bindEvent($("#orgName"),$("#s_unitCode"),$this);
			$("#lists span").die("click");
		});
	});
</script>
</html>
