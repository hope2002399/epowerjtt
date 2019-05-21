<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="发件人信息列表" /></title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/scripts/stat/stat.css">
</head>
<body>
	<div class="search">
		<div class="crumbs">发件人信息查询</div>
		<s:form action="optPickupMessage" namespace="/powerruntime">
			<table cellpadding="0" cellspacing="0" align="left">
				<tr>
					<td class="addTd"><h4>发件人姓名:</h4></td>
					<td><s:textfield name="s_sendname" id="s_sendname"
							value="%{#parameters['s_sendname']}" /></td>
					<td class="addTd"><h4>发件人手机:</h4></td>
					<td><s:textfield name="s_sendphone" id="s_sendphone"
							value="%{#parameters['s_sendphone']}" />&nbsp;&nbsp;&nbsp;&nbsp;<s:submit
							method="selectlist" key="opt.btn.query" cssClass="btn" />&nbsp;&nbsp;<input
						type="button" class="btn" value="关闭" onclick="window.close();"
						style="float: none;"></td>
					</td>
				</tr>
			</table>
		</s:form>
	</div>
	<br />
	<div class="container">
		<table class="" id="statTable" style="width: 100%;">
			<thead align="center">
				<tr>
					<th class="addTh" style="text-align: center;">操作</th>
					<th class="addTh" style="text-align: center;">发件人姓名</th>
					<th class="addTh" style="text-align: center;">发件人省</th>
					<th class="addTh" style="text-align: center;">发件人市</th>
					<th class="addTh" style="text-align: center;">发件人区县</th>
					<th class="addTh" style="text-align: center;">发件人手机</th>
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach var="sendMessage" items="${sendMessagelist}"
					varStatus="status">
					<tr
						<c:if test="${status.index%2==1}">style='background: rgb(223, 228, 232);'</c:if>>
						<td style="text-align: center;"><input type="radio"
							onclick="setParentVal('${status.index}')"></td>
						<td style="text-align: center;"><input type="hidden"
							id="sendname${status.index}" name="sendname${status.index}"
							value="${sendMessage.sendname}"> <input type="hidden"
							id="sendprov${status.index}" name="sendprov${status.index}"
							value="${sendMessage.sendprov}"> <input type="hidden"
							id="sendcity${status.index}" name="sendcity${status.index}"
							value="${sendMessage.sendcity}"> <input type="hidden"
							id="sendCountry${status.index}" name="sendCountry${status.index}"
							value="${sendMessage.sendCountry}"> <input type="hidden"
							id="sendstrect${status.index}" name="sendstrect${status.index}"
							value="${sendMessage.sendstrect}"> <input type="hidden"
							id="sendphone${status.index}" name="sendphone${status.index}"
							value="${sendMessage.sendphone}"> <input type="hidden"
							id="sendcall${status.index}" name="sendcall${status.index}"
							value="${sendMessage.sendcall}"> ${sendMessage.sendname }
						</td>
						<td style="text-align: center;">${sendMessage.sendprov }</td>
						<td style="text-align: center;">${sendMessage.sendcity }</td>
						<td style="text-align: center;">${sendMessage.sendCountry }</td>
						<td style="text-align: center;">${sendMessage.sendphone }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
<script type="text/javascript">
	var parentDocument = window.opener.document;//获取父页面对象
	//设置返回值
	function setParentVal(djId) {
		if (window.confirm("确认选择这个发件人吗？选择后窗口将自动关闭。")) {
			parentDocument.getElementById('sendname').value = document
					.getElementById('sendname' + djId).value;
			parentDocument.getElementById('sendprov').value = document
					.getElementById('sendprov' + djId).value;
			parentDocument.getElementById('sendcity').value = document
					.getElementById('sendcity' + djId).value;
			parentDocument.getElementById('sendCountry').value = document
					.getElementById('sendCountry' + djId).value;
			parentDocument.getElementById('sendstrect').value = document
					.getElementById('sendstrect' + djId).value;
			parentDocument.getElementById('sendphone').value = document
					.getElementById('sendphone' + djId).value;
			parentDocument.getElementById('sendcall').value = document
					.getElementById('sendcall' + djId).value;

			window.close();
		}

	}
</script>
</html>