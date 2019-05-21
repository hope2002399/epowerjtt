<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>

<html>
	<head>
		<title>
			权力对应关系
		</title>
		<script
	src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js"
	type="text/javascript"></script>
<link
	href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css"
	rel="stylesheet" type="text/css" />
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<div class="search">
			<div class="crumbs">
				 权力对应关系
			</div>
			
			<s:form action="powerQldy" namespace="/powerbase" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr >
						<td class="addTd">部门名称：</td>
						
						<td>
							<input type="text" id="s_orgName" name="s_orgName"
						value="${cp:MAPVALUE('depno',param.s_org_id)}" /> <input
						type="hidden" id="s_org_id" name="s_org_id"
						value="${param.s_org_id}" />
						</td>
						<td class="addTd">事项类型：</td>
						<td>
							<select name="s_item_type" id="s_item_type" style ="width:160">
								<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('ITEM_TYPE')}">
								<option value="${row.key}"
									<c:if test="${param.s_item_type eq row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
							</select>
						</td>
					</tr>	
					<tr >
					<td class="addTd">事项编码：</td>
						
						<td>
							<input type="text" id="s_item_id" name="s_item_id"
						value="${param.s_item_id}" /> 
						</td>
						<td class="addTd">事项名称：</td>
						
						<td>
							<input type="text" id="s_item_name" name="s_item_name"
						value="${param.s_item_name}" /> 
						</td>
						
					</tr>	

					<tr >
						
						<td colspan="4" align="center"><s:submit method="list"  key="opt.btn.query" cssClass="btn"/>
					</tr>
				</table>
			</s:form>
		</div>

		<ec:table action="powerbase/powerQldy!list.do" items="list" var="powerQldy"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="rowCount" title="序号" style="text-align:center" cell="rowCount"/>

				<ec:column property="itemId" title="事项编码" style="text-align:center" width="15%"/>

				<ec:column property="itemName" title="事项名称" style="text-align:center" width="30%"/>

			
				
				<ec:column property="otherItemId" title="对应事项编码" style="text-align:center" width="15%"/>
				
				<ec:column property="otherItemId" title="对应事项名称" style="text-align:center" width="30%">
					${cp:MAPVALUE("zf_powerid",powerQldy.otherItemId)}
				</ec:column>
				
	
				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">
						<c:if test="${powerQldy.otherItemId == null }">
					<a href='powerbase/powerQldy!addOrModify.do?itemId=${powerQldy.itemId}'>添加</a>
					</c:if>
						<c:if test="${powerQldy.otherItemId != null }">
					<a href='powerbase/powerQldy!addOrModify.do?itemId=${powerQldy.itemId}'>修改</a>
					</c:if>
					
				</ec:column>
			</ec:row>
		</ec:table>
<script type="text/javascript">
var menuList = ${unitsJson};
function bindEvent(o1, o2, $this) {
	o1.val($this.html());
	var key = $this.attr("rel");
	for (var i = 0; i < menuList.length; i++) {
		if (key == menuList[i].MID) {
			o2.val(menuList[i].depno);
		}
	}
	if (getID("shadow")) {
		$("#shadow").hide();
		$("#boxContent").hide();
	}
}
$("#s_orgName")
		.bind(
				'click',
				function() {
					var menuList = ${unitsJson};
					var shadow = "<div id='shadow'></div><div id='boxContent'><div class='listShadow'></div><div id='lists' class='getTree'>Loader</div><div id='close'>×</div></div>";
					if (getID("shadow")) {
						$("#shadow").show();
						$("#boxContent").show();
					} else {
						$("body").append(shadow);
						$("#shadow").height(document.body.scrollHeight);
						setTimeout(function() {
							menuDisplay(menuList, "${parentUnit}");
						}, 0);
					}
					;
					$("#lists span").live(
							'click',
							function() {
								var $this = $(this);
								bindEvent($("#s_orgName"),
										$("#s_org_id"), $this);
								$("#lists span").die("click");
							});
				});
	</script>
	</body>
</html>
