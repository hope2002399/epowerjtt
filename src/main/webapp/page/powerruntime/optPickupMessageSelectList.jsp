<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="收件人信息列表" /></title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/scripts/stat/stat.css">
</head>
<body>
	<div class="search">
		<div class="crumbs">收件人信息查询</div>
		<s:form action="optPickupMessage" namespace="/powerruntime">
			<table cellpadding="0" cellspacing="0" align="left">
				<tr>
					<td class="addTd"><h4>收件人姓名:</h4></td>
					<td><s:textfield name="s_rcvname" id="s_rcvname"
							value="%{#parameters['s_rcvname']}" /></td>
					<td class="addTd"><h4>收件人手机:</h4></td>
					<td><s:textfield name="s_rcvphone" id="s_rcvphone"
							value="%{#parameters['s_rcvphone']}" />&nbsp;&nbsp;&nbsp;&nbsp;<s:submit
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
					<th style="text-align: center;">操作</th>
					<th style="text-align: center;">收件人姓名</th>
					<th style="text-align: center;">收件人省</th>
					<th style="text-align: center;">收件人市</th>
					<th style="text-align: center;">收件人区县</th>
					<th style="text-align: center;">收件人手机</th>
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach var="pickupMessage" items="${pickupMessagelist}"
					varStatus="status">
					<tr
						<c:if test="${status.index%2==1}">style='background: rgb(223, 228, 232);'</c:if>>
						<td style="text-align: center;"><input type="radio"
							onclick="setParentVal('${status.index}')"></td>
						<td style="text-align: center;"><input type="hidden"
							id="rcvname${status.index}" name="rcvname${status.index}"
							value="${pickupMessage.rcvname}"> <input type="hidden"
							id="rcvprov${status.index}" name="rcvprov${status.index}"
							value="${pickupMessage.rcvprov}"> <input type="hidden"
							id="rcvcity${status.index}" name="rcvcity${status.index}"
							value="${pickupMessage.rcvcity}"> <input type="hidden"
							id="rcvcountry${status.index}" name="rcvcountry${status.index}"
							value="${pickupMessage.rcvcountry}"> <input type="hidden"
							id="rcvstrect${status.index}" name="rcvstrect${status.index}"
							value="${pickupMessage.rcvstrect}"> <input type="hidden"
							id="rcvphone${status.index}" name="rcvphone${status.index}"
							value="${pickupMessage.rcvphone}"> <input type="hidden"
							id="rcvcall${status.index}" name="rcvcall${status.index}"
							value="${pickupMessage.rcvcall}"> <input type="hidden"
							id="rcvpostcode${status.index}" name="rcvpostcode${status.index}"
							value="${pickupMessage.rcvpostcode}">
							${pickupMessage.rcvname }</td>
						<td style="text-align: center;">${pickupMessage.rcvprov }</td>
						<td style="text-align: center;">${pickupMessage.rcvcity }</td>
						<td style="text-align: center;">${pickupMessage.rcvcountry }</td>
						<td style="text-align: center;">${pickupMessage.rcvphone }</td>

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
		if (window.confirm("确认选择这个收件人吗？选择后窗口将自动关闭。")) {
			parentDocument.getElementById('rcvname').value = document
					.getElementById('rcvname' + djId).value;
			parentDocument.getElementById('rcvprov').value = document
					.getElementById('rcvprov' + djId).value;
			parentDocument.getElementById('rcvcity').value = document
					.getElementById('rcvcity' + djId).value;
			parentDocument.getElementById('rcvcountry').value = document
					.getElementById('rcvcountry' + djId).value;
			parentDocument.getElementById('rcvstrect').value = document
					.getElementById('rcvstrect' + djId).value;
			parentDocument.getElementById('rcvphone').value = document
					.getElementById('rcvphone' + djId).value;
			parentDocument.getElementById('rcvcall').value = document
					.getElementById('rcvcall' + djId).value;
			parentDocument.getElementById('rcvpostcode').value = document
					.getElementById('rcvpostcode' + djId).value;
			window.close();
		}
	}
</script>
</html>