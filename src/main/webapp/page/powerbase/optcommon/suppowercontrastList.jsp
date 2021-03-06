<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html>
	<head>
		<title>
			权力事项对比
		</title>
		<sj:head locale="zh_CN" />
<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<div class="search">
			<div class="crumbs">
				 权力事项对比
			</div>
			
			<s:form action="supPower" namespace="/powerbase" style="margin-top:0;margin-bottom:5">
			
				<table cellpadding="0" cellspacing="0" align="center">
					<tr>
					<td class="addTd">权力编号：</td>
					<td><s:textfield name="s_item_id"  
							value="%{#parameters['s_itemId']}"></s:textfield></td>
				
					<td class="addTd">权力名称：</td>
					<td><s:textfield name="s_itemName"  
							value="%{#parameters['s_itemName']}" /></td>
				</tr>
				<tr>
					<td class="addTd">行使部门：</td>
					<td>
						<input type="text" id="orgName" name="orgName"  value="${cp:MAPVALUE('depno',param.s_orgId)}" />
					<input type="hidden" id="s_orgId" name="s_orgId" value="${param.s_orgId}"/>
					</td>
				
					<td class="addTd">权力类型：</td>
					<td>
							<select name="s_itemType"  
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
				
						<td class="addTd"><s:text name="suppower.qlState" />：</td>
					<td>
							<select name="s_qlState" >
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('QL_State')}">
								<option value="${row.key}"
									<c:if test="${parameters.s_qlState[0] eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select>
					</td>
					
					<td colspan="2" align="center">
							<s:submit method="contrastlist"  key="opt.btn.query" cssClass="btn"/>
							<input type="button" class="btn" value="对比" name="doZP" id="doZP" />
						</td>
					</tr>
				</table>
			</s:form>
		</div>

		<ec:table action="powerbase/supPower!contrastlist.do" items="supPowerWithoutLobList" var="suppower"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="bj"
					title='<button name="quanxuan" target="false" id="btnXZ">全选</button>'
					style="text-align:center" sortable="false">
					<input type="checkbox" class="delWarn" name="delWarn"
						value="${suppower.itemId };${suppower.version}" />
				</ec:column>
				<ec:column property="itemId" title="权力编号" style="text-align:center">
				<a href='powerbase/suppowerchglog!listVersion.do?itemId=${suppower.itemId}&version=${suppower.version}'>${suppower.itemId}</a>
				</ec:column>
				<ec:column property="version" title="版本号" style="text-align:center" />
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
	$("#btnXZ").bind('click', function() {
		if ($("#btnXZ").attr("target") == "false") {
			$("#btnXZ").attr("target", "true");
			$(".delWarn").attr("checked", "true");
			$("#btnXZ").text("取消");
		} else {
			$("#btnXZ").attr("target", "false");
			$(".delWarn").removeAttr("checked");
			$("#btnXZ").text("全选");
		}
	});
	$("#doZP")
	.bind(
			'click',
			function() {
				var itemId = "";
				var items = $('.delWarn:checkbox:checked');
				for ( var i = 0; i < items.length; i++) {
					itemId = itemId + items.get(i).value + ',';
				}
				
				if (items.length >= 2) {
					itemId = itemId.substring(0, itemId.length -1);
					if (confirm("确定对选择的权力事项进行对比 ？")) {
						/* var form = document.getElementById("outwayForm");
						form.action = "monitor/outway!editPLZP.do?outwayno="+warnNos;
						form.outwayno = warnNos;
						form.submit(); */
						window.location.href = "supPower!editContrast.do?itemId=" + itemId + "&${cxparam}";
						
						//JqueryDialog.Open('预报警批量摘牌 ', "monitor/outway!editPLZP.do?warnNos=" + warnNos + "&${cxparam}", 500, 200);
						
						//$.pdialog.open("monitor/outway!edit.do?outwarnno=37", "zpDialog", "预报警摘牌");
					}
				} else {
					alert("请选择两个以上的权力实现进行对比！");
				}
			});
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
