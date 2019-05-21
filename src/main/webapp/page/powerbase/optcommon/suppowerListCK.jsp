<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html>
	<head>
		<title>
			权力库管理
		</title>
		<script type="text/javascript">
		  function resetForm(){
			  $('#orgName').val('');
			  $('#s_orgId').val('');
			  $('#s_itemType').val('');
			  $('#s_item_id').val('');
			  $('#s_itemName').val('');
			  $('#s_qlState').val('');
			  $('#s_begTime').val('');
		  }
		</script>
		<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
		<sj:head locale="zh_CN" />
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<div class="search">
			<div class="crumbs">
				${title}
			</div>
			
			<s:form action="supPower" namespace="/powerbase" style="margin-top:0;margin-bottom:5">
			
				<table cellpadding="0" cellspacing="0" align="center">
					<tr>
					<td class="addTd">权力编码：</td>
					<td><s:textfield name="s_item_id" id="s_item_id" style="width:195px"
							value="%{#parameters['s_item_id']}"></s:textfield></td>
				
					<td class="addTd">权力名称：</td>
					<td><s:textfield name="s_itemName" id="s_itemName" style="width:180px"
							value="%{#parameters['s_itemName']}" /></td>
				</tr>
				<tr>
					<td class="addTd">行使部门：</td>
					<td>
					<input type="text" id="orgName" name="orgName"  value="${cp:MAPVALUE('depno',param.s_orgId)}" style="width: 195px"/>
					<input type="hidden" id="s_orgId" name="s_orgId" value="${param.s_orgId}"/>
					</td>
				
					<td class="addTd">权力类型：</td>
					<td>
							<select name="s_itemType" id="s_itemType" style="width: 180px"
						onchange="checkItemType();">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('ITEM_TYPE')}">
								<option value="${row.key}"
									<c:if test="${parameters.s_itemType[0] eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select>
					</td>
				</tr>
				
					<tr>
						<td class="addTd">查询时间：</td>
						<td>
							<sj:datepicker name="s_begTime" id="s_begTime" readonly="true" value="%{#parameters['s_begTime']}" yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" style="width:195px" />
						</td>
						<td class="addTd"><s:text name="suppower.qlState" />：</td>
					<td>
							<select name="s_qlState" id="s_qlState" style="width: 180px">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('QL_State')}">
								<option value="${row.key}"
									<c:if test="${parameters.s_qlState[0] eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select>
					</td>
					<td>&nbsp;&nbsp;
							<s:submit method="listCK"  key="opt.btn.query" cssClass="btn"/>
							<input type="button" value="重置" class="btn" onclick="resetForm()"/>	
						</td>
					</tr>
					
				</table>
			</s:form>
		</div>

		<ec:table action="powerbase/supPower!listCK.do" items="supPowerWithoutLobList" var="suppower"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="itemId" title="权力编码" style="text-align:center">
				<a href='powerbase/suppowerchglog!listVersion.do?itemId=${suppower.itemId}&version=${suppower.version}'>${suppower.itemId}</a>
				</ec:column>

				<ec:column property="itemName" title="权力名称" style="text-align:center">
				<c:choose>
					<c:when test="${fn:length(suppower.itemName) > 30}">
						<c:out value="${fn:substring(suppower.itemName, 0, 30)}..." />
					</c:when>
					<c:otherwise>
						<c:out value="${suppower.itemName}" />
					</c:otherwise>
				</c:choose>
				</ec:column>

				<ec:column property="orgId" title="所属部门" style="text-align:center" >
					${cp:MAPVALUE("depno",suppower.orgId)}
				</ec:column>
				<ec:column property="itemType" title="权力类型" style="text-align:center" >
					${cp:MAPVALUE("ITEM_TYPE",suppower.itemType)}
				</ec:column>
				
			</ec:row>
		</ec:table>
	</body>
	<script type="text/javascript">
	var menuList = ${unitsJson};
	function bindEvent(o1,o2,$this){
		o1.val($this.html());
		var key = $this.attr("rel");
		for (var i=0; i<menuList.length; i++) {
			if (key == menuList[i].MID) {
				o2.val(menuList[i].depno);
			}
		}
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
