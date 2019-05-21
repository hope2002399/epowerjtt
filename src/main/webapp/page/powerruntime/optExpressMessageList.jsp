<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="快递信息查询" /></title>
</head>
<body>
	<div class="search">
		<div class="crumbs">快递信息查询</div>
		<s:form action="optExpressMessage" namespace="/powerruntime">
			<table cellpadding="0" cellspacing="0" align="left">
				<tr>
					<td class="addTd"><h4>信封流水号:</h4></td>
					<td><s:textfield name="s_emsordno"
							value="%{#parameters['s_emsordno']}" /></td>
					<td class="addTd"><h4>受理台席名称:</h4></td>
					<td><s:textfield name="s_govtbname"
							value="%{#parameters['s_govtbname']}" /></td>
				</tr>
				<tr>
					<td class="addTd"><h4>收件人姓名:</h4></td>
					<td><s:textfield name="s_rcvname"
							value="%{#parameters['s_rcvname']}" /></td>
					<td class="addTd"><h4>发件人姓名:</h4></td>
					<td><s:textfield name="s_sendname"
							value="%{#parameters['s_sendname']}" />&nbsp;&nbsp;&nbsp;&nbsp;<s:submit
							method="list" key="opt.btn.query" cssClass="btn" />&nbsp;&nbsp;&nbsp;&nbsp;<s:submit
							method="add" key="新增" cssClass="btn" />&nbsp;&nbsp;&nbsp;&nbsp;<input
						type="button" name="reset" value="重置" class="btn"
						onclick="resetForm();" /></td>
					</td>
				</tr>
				<tr>
			</table>
		</s:form>
	</div>
	<ec:table action="powerruntime/optExpressMessage!list.do"
		items="expressMessagelist" var="expressMessage"
		imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif"
		retrieveRowsCallback="limit">
		<ec:row>
			<ec:column title="序号" property="rowcount" cell="rowCount"
				sortable="true" />
			<ec:column property="emsordno" title="信封流水号"
				style="text-align:center" sortable="false" />
			<ec:column property="govtbname" title="受理台席名称"
				style="text-align:center" sortable="false" />
			<ec:column property="sendname" title="发件人姓名"
				style="text-align:center" sortable="false" />
			<ec:column property="rcvname" title="收件人姓名" style="text-align:center"
				sortable="false" />
			<ec:column property="expresstime" title="邮寄日期"
				style="text-align:center;" sortable="false">
				<fmt:formatDate value="${expressMessage.expresstime}"
					pattern="yyyy年MM月dd日" />
			</ec:column>
			<ec:column property="state" title="上报状态" style="text-align:center;"
				sortable="false">
				<c:if test="${empty expressMessage.state}">未上报</c:if>
				<c:if test="${not(empty expressMessage.state)}">${cp:MAPVALUE("reportstate",expressMessage.state)}</c:if>
			</ec:column>
			<ec:column property="issend" title="是否已经寄送" style="text-align:center"
				sortable="false">
						${cp:MAPVALUE("TrueOrFalse",expressMessage.issend)}
					</ec:column>
			<ec:column property="opt" title="操作" sortable="false"
				style="text-align:center">
				<a
					href='powerruntime/optExpressMessage!view.do?expressid=${expressMessage.expressid}'>查看</a>
				<c:if test="${expressMessage.state ne '0'}">
					<c:if test="${expressMessage.djid ne null}">
						<a
							href='powerruntime/optExpressMessage!qyedit.do?expressid=${expressMessage.expressid}'>编辑</a>
					</c:if>
					<c:if test="${expressMessage.djid eq null}">
						<a
							href='powerruntime/optExpressMessage!edit.do?expressid=${expressMessage.expressid}'>编辑</a>
					</c:if>
					<a href="javascript:;"
						onclick="javascript:deleteExpressMessage('${expressMessage.expressid}')">删除</a>
					<a href="javascript:;"
						onclick="javascript:sendExpressMessage('${expressMessage.expressid}')">上报</a>
				</c:if>
				<c:if test="${expressMessage.state eq '0'}">
					<a
						href='powerruntime/optExpressMessage!logistics.do?expressid=${expressMessage.expressid}'>物流</a>
				</c:if>
			</ec:column>

		</ec:row>
	</ec:table>
</body>
<script type="text/javascript">
	function resetForm() {
		$('#s_emsordno').val('');
		$('#s_govtbname').val('');
		$('#s_rcvname').val('');
		$('#s_sendname').val('');
	}
	function deleteExpressMessage(expressid) {
		if (window.confirm("确实要删除吗？")) {
			window.location.href = "${pageContext.request.contextPath}/powerruntime/optExpressMessage!delete.do?expressid="
					+ expressid;
		} else {
			return;
		}
	}
	function sendExpressMessage(expressid) {
		if (window.confirm("确实要上报么吗？")) {
			window.location.href = "${pageContext.request.contextPath}/powerruntime/optExpressMessage!send.do?expressid="
					+ expressid;
		} else {
			return;
		}
	}
</script>
</html>