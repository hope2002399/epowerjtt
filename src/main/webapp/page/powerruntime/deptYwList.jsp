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
		<style type="text/css">
		a:link {
 text-decoration: none;
}
a:visited {
 text-decoration: none;
}
a:hover {
 text-decoration: none;
}
a:active {
 text-decoration: none;
}
		</style>
	</head>
	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<div class="search">
		<div class="crumbs">办件查询</div>
			<s:form action="deptStInf" namespace="/powerruntime">
			<input type="hidden" id="s_applyItemType" name="s_applyItemType" value="${param.s_applyItemType}" />
				<table cellpadding="0" cellspacing="0" align="center">
					<tr>
						<input type="hidden" id="flag" name="s_flag" value="${session.falg }"/>	
						<input type="hidden" id="area" name="s_area" value="${session.area }"/>	
						<input type="hidden" id="type" name="s_type" value="${session.type }"/>	
						<input type="hidden" id="orgcode" name="s_orgcode" value="${session.orgcode }"/>	
						<td class="addTd">业务名称：</td>
						<td><s:textfield id="s_ywName" name="s_ywName" value="%{#parameters['s_ywName']}"/> </td>
						 <td class="addTd">业务部门：</td>
						<td>
							<select name="s_xztype" id="s_xztype" style="width:160px">
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('xztype2')}">
									<option value="${row.key}">
									<c:out value="${row.value}" /></option>
								</c:forEach>
							</select>
						</td>  					</tr>	
					<tr>
						
						<td align="center" colspan="4">
							<s:submit method="qlmlyw"  key="opt.btn.query" cssClass="btn"/>&nbsp;&nbsp;&nbsp;
							<input type="button" name="reset" value="重置" class="btn" onclick="resetForm();"/>
						</td>
						</tr>
				</table>
			</s:form>
		</div>
		
		<ec:table action="powerruntime/deptStInf!qlmlyw.do" items="deptYwInfs" var="srPermitApply"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
				<%-- <ec:column property="ywName" title="业务名称" style="text-align:center" sortable="false"/> --%>
				<ec:column property="ywName" title="业务名称" style="text-align:center" sortable="false">
					<c:choose>
					<c:when test="${fn:length(srPermitApply.ywName) > 30}">
						<a href='powerruntime/deptYwInf!getywById.do?iddeptYwInf=${srPermitApply.iddeptYwInf }&userLevelC=${srPermitApply.useLevel}'><c:out value="${fn:substring(srPermitApply.ywName, 0, 30)}..." /></a>
					</c:when>
					<c:otherwise>
						<a href='powerruntime/deptYwInf!getywById.do?iddeptYwInf=${srPermitApply.iddeptYwInf }&userLevelC=${srPermitApply.useLevel}'><c:out value="${srPermitApply.ywName}" /></a>
					</c:otherwise>
				</c:choose>
				</ec:column>
				<ec:column property="shrotOrgName" title="办理机构" style="text-align:center" sortable="false"/>
				<ec:column property="orgname" title="业务部门" style="text-align:center" sortable="false"/>
				<%-- <c:if test="${!srPermitApply.qlKind eq '01' || srPermitApply.qlKind eq '04'||srPermitApply.qlKind eq '05' || srPermitApply.qlKind eq '07' || srPermitApply.qlKind eq '09' || srPermitApply.qlKind eq '10'}">
					<ec:column property="orgname" title="办理机构" style="text-align:center" sortable="false">
						<c:out value="${srPermitApply.orgname}" />
					</ec:column>
				</c:if> --%>
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
