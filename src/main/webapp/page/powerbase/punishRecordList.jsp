<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>重大行政处罚备案管理</title>
<script type="text/javascript">
	function resetForm() {
		$('#s_orgName').val('');
		$('#s_org_id').val('');
		$('#s_queryUnderUnit').val('');
	}
</script>
<sj:head locale="zh_CN" />
<script type="text/javascript"
	src="<s:url value="/scripts/colorbox/jquery.colorbox.js"/>"
	charset="utf-8"></script>
<link
	href="${pageContext.request.contextPath}/scripts/colorbox/colorbox.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/scripts/jquery-ui/jquery-ui-1.9.2.custom.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<s:url value="/scripts/addressBook.js"/>" charset="utf-8"></script>
<script type="text/javascript" src="<s:url value="/scripts/centit.js"/>"
	charset="utf-8"></script>
<script type="text/javascript"
	src="<s:url value="/scripts/jquery-ui/jquery-ui-1.9.2.custom.js"/>"
	charset="utf-8"></script>
<script type="text/javascript"
	src="<s:url value="/scripts/opendiv_Win.js"/>" charset="utf-8"></script>
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
			<s:text name="label.list.filter" />
		</div>
		<s:form action="punishRecord" namespace="/powerbase"
			style="margin-top:0;margin-bottom:5" id="punishRecordForm"
			method="post">
			<div>
				<table cellpadding="0" cellspacing="0" align="center">
					<tr>
						<td class="addTd">部门名称：</td>
						<td width="40%"><input type="text" id="s_orgName" name="s_orgName"
							value="${cp:MAPVALUE('depno',param.s_org_id)}" /> <input
							type="hidden" id="s_org_id" name="s_org_id"
							value="${param.s_org_id}" /> <s:checkbox label="包含下属机构"
								name="s_queryUnderUnit" id="s_queryUnderUnit"
								value="#parameters['s_queryUnderUnit']" fieldValue="true" />包含下属机构</td>
						<td class="addTd">部门类型：</td>
						<td width="20%"><select name="s_depKind" style="width: 100px">
								<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('BMLX')}">
									<option value="${row.key}"
										<c:if test="${parameters.s_depKind[0] eq row.key}">selected="selected"</c:if>>
										<c:out value="${row.value}" />
									</option>
								</c:forEach>
						</select></td>
						<td><s:submit method="PunishRecordTemp" key="opt.btn.query"
								cssClass="btn" /></td><td> <s:submit method="addPunishRecord"
								key="opt.btn.new" cssClass="btn" /></td>
					</tr>
				</table>
			</div>
		</s:form>
	</div>
	<ec:table
		action="powerbase/punishRecord!PunishRecordTemp.do?usercode=${usercode}"
		items="punishRecordList" var="info"
		imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif"
		retrieveRowsCallback="limit">
		<ec:row>
			<ec:column property="org_id" title="部门名称" style="text-align:center">
				${cp:MAPVALUE("depno",info.org_id)}
				</ec:column>
			<ec:column property="bookOperatorID" title="登记人员"
				style="text-align:center">
			${info.bookOperatorID}
			</ec:column>
			<ec:column property="modifyDate" title="更新时间"
				style="text-align:center">
				<fmt:formatDate value="${info.modifyDate}" pattern="yyyy-MM-dd" />
			</ec:column>
			<ec:column property="depKind" title="部门类型" style="text-align:center">
				<c:forEach var="row" items="${cp:DICTIONARY('BMLX')}">
					<c:if test="${info.depKind eq row.key}">
						<c:out value="${row.value}" />
					</c:if>
				</c:forEach>
				<%-- <c:if test="${info.depKind==0 }" >
					<c:out value="一般行政机关" />
				</c:if>
				<c:if test="${info.depKind==1 }">
					<c:out value="特殊行政机关" />
				</c:if> --%>
			</ec:column>
			<ec:column property="personNum" title="个人罚款限额"
				style="text-align:center" />
			<ec:column property="corpNum" title="组织机构限额"
				style="text-align:center" />
			<ec:column property="opt" title="操作" style="text-align:center"
				sortable="false">
				<a
					href='punishRecord!edit.do?s_org_id=${info.org_id }&s_modifyDate=${info.modifyDate}'>修改</a>
				<a
					href='punishRecord!delete.do?org_id=${info.org_id }&modifyDate=${info.modifyDate}'
					onclick='return confirm("确定删除该重大行政处罚备案信息?")'>删除</a>
			</ec:column>
		</ec:row>

	</ec:table>

	<script type="text/javascript">
		var menuList = ${unitsJson};
		function bindEvent(o1, o2, $this) {
			o1.val($this.html());
			var key = $this.attr("rel");
			for ( var i = 0; i < menuList.length; i++) {
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