<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="物流信息" /></title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/scripts/stat/stat.css">
</head>
<body>
	<div class="search">
		<div class="crumbs">物流信息查询</div>
	</div>
	<div class="container">
		<table class="" id="statTable" style="width: 100%;">
			<thead align="center">
				<tr>
					<th class="addTh" style="text-align: center;">信封流水号</th>
					<th class="addTh" style="text-align: center;">快递单号</th>
					<th class="addTh" style="text-align: center;">物流状态</th>
					<th class="addTh" style="text-align: center;">物流状态说明</th>
					<th class="addTh" style="text-align: center;">状态补充信息</th>
					<th class="addTh" style="text-align: center;">物流状态时间</th>
				</tr>
			</thead>
			<tbody align="center">
				<c:if test="${empty ticslists}">
					<tr>
						<td colspan="6" style="text-align: center;">${resultmessage}</td>
					</tr>
				</c:if>
				<c:if test="${not empty ticslists }">
					<c:forEach var="tics" items="${ticslists}" varStatus="status">
						<tr
							<c:if test="${status.index%2==1}">style='background: rgb(223, 228, 232);'</c:if>>
							<td style="text-align: center;">${tics.emsordno }</td>
							<td style="text-align: center;">${tics.mailnum }</td>
							<td style="text-align: center;">${cp:MAPVALUE("status",tics.status)}</td>
							<td style="text-align: center;">${tics.stsinfo }</td>
							<td style="text-align: center;">${tics.stsdesc }</td>
							<td style="text-align: center;"><fmt:formatDate
									value="${tics.ststime}" pattern="yyyy年MM月dd日" /></td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>

	</div>
</body>
</html>