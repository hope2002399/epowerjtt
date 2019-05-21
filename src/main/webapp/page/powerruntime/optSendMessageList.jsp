<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="发件人信息查询" /></title>
</head>
<body>
	<div class="search">
		<div class="crumbs">发件人信息查询</div>
		<s:form action="optSendMessage" namespace="/powerruntime">
			<table cellpadding="0" cellspacing="0" align="left">
				<tr>
					<td class="addTd"><h4>发件人姓名:</h4></td>
					<td><s:textfield name="s_sendname" id="s_sendname"
							value="%{#parameters['s_sendname']}" /></td>
					<td class="addTd"><h4>发件人手机:</h4></td>
					<td><s:textfield name="s_sendphone" id="s_sendphone"
							value="%{#parameters['s_sendphone']}" />&nbsp;&nbsp;<s:submit
							method="selectlist" key="opt.btn.query" cssClass="btn" />&nbsp;&nbsp;<s:submit
							method="add" key="新增" cssClass="btn" />&nbsp;&nbsp;<input
						type="button" name="reset" value="重置" class="btn"
						onclick="resetForm();" /></td>
					</td>
				</tr>
			</table>
		</s:form>
	</div>
	<ec:table action="powerruntime/optSendMessage!list.do"
		items="sendMessagelist" var="sendMessage"
		imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif"
		retrieveRowsCallback="limit">
		<ec:row>
			<ec:column property="sendname" title="发件人姓名"
				style="text-align:center" sortable="false" />
			<ec:column property="sendprov" title="发件人省" style="text-align:center"
				sortable="false" />
			<ec:column property="sendcity" title="发件人市" style="text-align:center"
				sortable="false" />
			<ec:column property="sendCountry" title="发件人区县"
				style="text-align:center" sortable="false" />
			<ec:column property="sendphone" title="发件人手机"
				style="text-align:center" sortable="false" />
			<ec:column property="opt" title="操作" sortable="false"
				style="text-align:center">
				<a
					href='powerruntime/optSendMessage!edit.do?sendid=${sendMessage.sendid}'>编辑</a>
				<a onclick="javascript:deleteSendMessage('${sendMessage.sendid}')">删除</a>
				<a
					href='powerruntime/optSendMessage!view.do?sendid=${sendMessage.sendid}'>查看</a>
			</ec:column>
		</ec:row>
	</ec:table>
</body>
<script type="text/javascript">
	function deleteSendMessage(sendid) {
		if (window.confirm("确实要删除吗？")) {
			window.location.href = "${pageContext.request.contextPath}/powerruntime/optSendMessage!delete.do?sendid="
					+ sendid;
		} else {
			return;
		}
	}
	function resetForm() {
		$("#s_sendname").val("");
		$("#s_sendphone").val("");
	}
</script>
</html>