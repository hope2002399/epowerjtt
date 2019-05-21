<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="收件人信息查询" /></title>
</head>
<body>
	<div class="search">
		<div class="crumbs">收件人信息查询</div>
		<s:form action="optPickupMessage" namespace="/powerruntime">
			<table cellpadding="0" cellspacing="0" align="left">
				<tr>
					<td class="addTd"><h4>收件人姓名:</h4></td>
					<td><s:textfield name="s_sendname" id="s_rcvname"
							value="%{#parameters['s_rcvname']}" /></td>
					<td class="addTd"><h4>收件人手机:</h4></td>
					<td><s:textfield name="s_sendphone" id="s_rcvphone"
							value="%{#parameters['s_rcvphone']}" />&nbsp;&nbsp;&nbsp;&nbsp;<s:submit
							method="list" key="opt.btn.query" cssClass="btn" />&nbsp;&nbsp;&nbsp;&nbsp;<s:submit
							method="add" key="新增" cssClass="btn" />&nbsp;&nbsp;&nbsp;&nbsp;<input
						type="button" name="reset" value="重置" class="btn"
						onclick="resetForm();" /></td>
					</td>
				</tr>
			</table>
		</s:form>
	</div>
	<ec:table action="powerruntime/optPickupMessage!list.do"
		items="pickupMessagelist" var="pickupMessage"
		imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif"
		retrieveRowsCallback="limit">
		<ec:row>
			<ec:column property="rcvname" title="收件人姓名" style="text-align:center"
				sortable="false" />
			<ec:column property="rcvprov" title="收件人省" style="text-align:center"
				sortable="false" />
			<ec:column property="rcvcity" title="收件人市" style="text-align:center"
				sortable="false" />
			<ec:column property="rcvcountry" title="收件人区县"
				style="text-align:center" sortable="false" />
			<ec:column property="rcvphone" title="收件人手机"
				style="text-align:center" sortable="false" />
			<ec:column property="opt" title="操作" sortable="false"
				style="text-align:center">
				<a
					href='powerruntime/optPickupMessage!edit.do?pickupid=${pickupMessage.pickupid}'>编辑</a>
				<a
					onclick="javascript:deletePickupMessage('${pickupMessage.pickupid}')">删除</a>
				<a
					href='powerruntime/optPickupMessage!view.do?pickupid=${pickupMessage.pickupid}'>查看</a>
			</ec:column>
		</ec:row>
	</ec:table>
</body>
<script type="text/javascript">
	function resetForm() {
		$("#s_rcvname").val("");
		$("#s_rcvphone").val("");
	}
	function deletePickupMessage(pickupid) {
		if (window.confirm("确实要删除吗？")) {
			window.location.href = "${pageContext.request.contextPath}/powerruntime/optPickupMessage!delete.do?pickupid="
					+ pickupid;
		} else {
			return;
		}
	}
</script>
</html>