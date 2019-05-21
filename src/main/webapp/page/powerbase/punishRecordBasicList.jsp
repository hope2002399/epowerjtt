<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>申报备案登记管理</title>
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
	<div class="search">
		<div class="crumbs">
			<s:text name="label.list.filter" />
		</div>
		<s:form action="punishRecordBasic" namespace="/powerbase"
			style="margin-top:0;margin-bottom:5" id="punishRecordBasicForm"
			method="post">
			<table cellpadding="0" cellspacing="0" align="center">
				<tr>
					<td class="addTd">业务编号：</td>
					<td><input type="text" id="s_internal_no" name="s_internal_no"
						value="${param.s_internal_no}"></td>
					<td class="addTd">部门名称：</td>
					<td><input type="text" id="s_orgName" name="s_orgName"
						value="${cp:MAPVALUE('depno',param.s_org_id)}" /> <input
						type="hidden" id="s_org_id" name="s_org_id"
						value="${param.s_org_id}" /> <s:checkbox label="包含下属机构"
							name="s_queryUnderUnit" id="s_queryUnderUnit"
							value="#parameters['s_queryUnderUnit']" fieldValue="true" />包含下属机构</td>
				</tr>
				<tr>
				<tr>
					<td class="addTd">处罚对象：</td>
					<td><input type="text" id="s_punish_target"
						name="s_punish_target" value="${param.s_punish_target}"></td>
					<td class="addTd">备案状态：</td>
					<td><select name="s_isRecord" style="width: 160px">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('BAZT')}">
								<option value="${row.key}"
									<c:if test="${parameters.s_isRecord[0] eq row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="addTd">时间范围：</td>
					<td width="400px" align="left" colspan="3"><sj:datepicker
							id="s_beginCreateDate" name="s_beginCreateDate" readonly="true"
							yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" />
						至 <sj:datepicker id="s_endCreateDate" name="s_endCreateDate"
							readonly="true" yearRange="2000:2020" displayFormat="yy-mm-dd"
							changeYear="true" /></td>
				</tr>
				<tr>
					<td class="addTd">处罚类别：</td>
					<td><select name="s_item_id">
							<option value="">--请选择--</option>
							<c:forEach items="${supPwoerList}" var="row">
								<option value="${row.itemId}"
									<c:if test="${parameters.s_item_id[0] eq row.itemId}">selected="selected"</c:if>>
									<c:choose>
										<c:when test="${fn:length(row.itemName) > 20}">
											<c:out value="${fn:substring(row.itemName, 0, 20)}..." />
										</c:when>
										<c:otherwise>
											<c:out value="${row.itemName}" />
										</c:otherwise>
									</c:choose>
								</option>
							</c:forEach>
					</select></td>
					<td class="addTd"></td>
					<td align="right"><s:submit method="PunishTemp"
							key="opt.btn.query" cssClass="btn" /></td>
				</tr>
			</table>
		</s:form>
	</div>
	<ec:table
		action="powerbase/punishRecordBasic!PunishTemp.do?usercode=${usercode}"
		items="punishList" var="info"
		imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif"
		retrieveRowsCallback="limit">
		<ec:row>
			<ec:column property="internal_no" title="业务编号"
				style="text-align:center">
				<a
					href="../monitor/punish!view.do?internalNo=${info.internal_no}&orgId=${info.org_id }">
					<c:choose>
						<c:when test="${fn:length(info.internal_no) > 20}">
							<c:out value="${fn:substring(info.internal_no, 0, 20)}..." />
						</c:when>
						<c:otherwise>
							<c:out value="${info.internal_no}" />
						</c:otherwise>
					</c:choose>
				</a>
			</ec:column>
			<ec:column property="punish_time" title="提交时间"
				style="text-align:center">
				<fmt:formatDate value="${info.punish_time}" pattern="yyyy-MM-dd" />
			</ec:column>
			<ec:column property="department" title="主办部门"
				style="text-align:center">
				<c:choose>
					<c:when test="${fn:length(cp:MAPVALUE('depno',info.org_id)) > 20}">
						<c:out
							value="${fn:substring(cp:MAPVALUE('depno',info.org_id), 0, 20)}..." />
					</c:when>
					<c:otherwise>
						<c:out value="${cp:MAPVALUE('depno',info.org_id)}" />
					</c:otherwise>
				</c:choose>
			</ec:column>
			<ec:column property="punish_target" title="处罚对象"
				style="text-align:center">
				<c:choose>
					<c:when test="${fn:length(info.punish_target) > 20}">
						<c:out value="${fn:substring(info.punish_target, 0, 20)}..." />
					</c:when>
					<c:otherwise>
						<c:out value="${info.punish_target}" />
					</c:otherwise>
				</c:choose>

			</ec:column>
			<ec:column property="punish_class" title="处罚种类"
				style="text-align:center">
				<c:forEach var="row" items="${cp:DICTIONARY('CFZL')}">
					<c:if test="${info.punish_class eq row.key}">
						<c:out value="${row.value}" />
					</c:if>
				</c:forEach>
			</ec:column>
			<ec:column property="punish_result_fine" title="罚款金额"
				style="text-align:center">
				${info.punish_result_fine }</ec:column>
			<ec:column property="recodeStyle" title="备案种类">
				<c:forEach items="${cp:DICTIONARY('BALX')}" var="row">
					<c:if test="${info.recodeStyle eq row.key}">
						<c:choose>
							<c:when test="${fn:length(row.value) > 20}">
								<c:out value="${fn:substring(row.value, 0, 20)}..." />
							</c:when>
							<c:otherwise>
								<c:out value="${row.value}" />
							</c:otherwise>
						</c:choose>
					</c:if>
				</c:forEach>
			</ec:column>
			<ec:column property="isRecord" title="备案状态">
				<c:forEach var="row" items="${cp:DICTIONARY('BAZT')}">
					<c:if test="${info.isRecord eq row.key}">
						<c:out value="${row.value}" />
					</c:if>
				</c:forEach>
			</ec:column>
			<ec:column property="opt" title="操作" sortable="false"
				style="text-align:center">
				<c:if test="${info.isRecord == 0}">
				<a
					href='powerbase/punishRecordBasic!RadioDetail.do?s_no=${info.no}&s_org_id=${info.org_id }&s_recodeStyle=${info.recodeStyle }'>备案</a>
					</c:if>
					<c:if test="${info.isRecord == 1}">
				<a
					href='powerbase/punishRecordBasic!RadioDetail.do?s_no=${info.no}&s_org_id=${info.org_id }&s_recodeStyle=${info.recodeStyle }'>修改备案</a>
					</c:if>
			</ec:column>
		</ec:row>

	</ec:table>

	<script type="text/javascript">
		$("#s_beginCreateDate").val('${beginCreateDate}');
		$("#s_endCreateDate").val('${endCreateDate}');
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