<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>权力库管理</title>
<sj:head locale="zh_CN" />
<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="search">
		<div class="crumbs">权力库管理 </div>

		<s:form action="supPower" namespace="/powerbase"
			style="margin-top:0;margin-bottom:5">
			<table cellpadding="0" cellspacing="0" align="center">
				<input id="qlState" type="hidden" name="qlState"
					value="${object.qlState}" />
				<tr>
					<td class="addTd">权力编号：</td>
					<td><s:textfield name="s_item_id" 
							value="%{#parameters['s_item_id']}"></s:textfield></td>

					<td class="addTd">权力名称：</td>
					<td><s:textfield name="s_itemName" 
							value="%{#parameters['s_itemName']}" /></td>
					<td width="150"></td>
				</tr>
				<tr>
					<td class="addTd">行使部门：</td>
					<td>
						<input type="text" id="orgName" name="orgName"  value="${cp:MAPVALUE('depno',param.s_orgId)}" />
						<input type="hidden" id="s_orgId" name="s_orgId" value="${param.s_orgId}"/>
					</td>

					<td class="addTd">权力类型：</td>
					<td><select name="s_itemType" 
						onchange="checkItemType();">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('ITEM_TYPE')}">
								<option value="${row.key}"
									<c:if test="${parameters.s_itemType[0] eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
					<td align="center"><s:submit method="list" key="opt.btn.query" cssClass="btn" />
						<s:submit method="editInitial" key="opt.btn.new" cssClass="btn" />
					</td>
				</tr>
			</table>
		</s:form>
	</div>

	<ec:table action="powerbase/supPower!list.do" items="supPowerWithoutLobList"
		var="suppower"
		imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif"
		retrieveRowsCallback="limit">
		<ec:row>
			<ec:column property="itemId" title="权力编号" style="text-align:center" />

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

			<ec:column property="orgId" title="行使部门" style="text-align:center">
					${cp:MAPVALUE("depno",suppower.orgId)}
				</ec:column>
			<ec:column property="opt" title="操作" sortable="false"
				style="text-align:center">
				<a
					href='powerbase/suppowerchglog!listVersion.do?itemId=${suppower.itemId}&version=${suppower.version}'><s:text
						name="opt.btn.view" /></a>
				<a
					href='supPower!edit.do?itemId=${suppower.itemId}&version=${suppower.version}'>编辑</a>
				<!-- <a
					href='powerruntime/powerOptInfo!edit.do?itemId=${suppower.itemId}&version=${suppower.version}'>编辑业务</a>
				<a
					href='powerruntime/powerOrgInfo!edit.do?itemId=${suppower.itemId}&version=${suppower.version}'>关联部门</a>
			 -->
				<c:if test="${suppower.qlState eq 'A'}">
					<a
						href='supPower!upDateQlState.do?itemId=${suppower.itemId}&version=${suppower.version}&qlState=T'
						onclick='return confirm("是否挂起该权力事项?");'>挂起</a>
					<a
						href='supPower!upDateQlState.do?itemId=${suppower.itemId}&version=${suppower.version}&qlState=X'
						onclick='return confirm("是否废止该权力事项?");'>废止</a>
				</c:if>
				<c:if test="${suppower.qlState eq 'T'}">
					<a
						href='supPower!upDateQlState.do?itemId=${suppower.itemId}&version=${suppower.version}&qlState=A'>启用</a>
				</c:if>
				<c:if test="${suppower.qlState eq 'X'}">
					<a
						href='supPower!upDateQlState.do?itemId=${suppower.itemId}&version=${suppower.version}&qlState=A'>启用</a>
				</c:if>
			</ec:column>

		</ec:row>
	</ec:table>
</body>
<script type="text/javascript">
	//function doEditOpt(){
	//$("showMessage").show();	
	//}
	function openNewWindow(winUrl, winName, winProps) {
		if (winProps == '' || winProps == null) {
			winProps = 'height=500px,width=790px,directories=false,location=false,top=100,left=500,menubar=false,Resizable=yes,scrollbars=yes,toolbar=false';
		}
		window.open(winUrl, winName, winProps);
	}
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
