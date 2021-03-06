<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>材料上传</title> <script type="text/javascript">
		function setTab(tab) {
			var id = tab.id;
			$("li").removeClass("select");
			$(tab).addClass("select");
			$("tr[name='filetr']").hide();
			$("tr[class='" + id + "']").show();
		}
		function setAll() {
			$("tr[name='filetr']").show();
			$("li").removeClass("select");
			$("#suoyou").addClass("select");
		}
	</script>
	<style type="text/css">
#heads ul {
	height: 25px;
	border-bottom: 1px solid #bbb;
}

#heads li {
	float: left;
	position: relative;
	width: 80px;
	margin: 10px 6px 0;
	height: 24px;
	line-height: 24px;
	border: 1px solid #bbb;
	text-align: center;
	border-bottom: none;
	top: 1px;
}

#heads li.select {
	background: #ddd;
}
</style>
</head>
<body>
	<fieldset style="display: block; padding: 10px;">
		<legend>
			<b>已上传材料列表</b>
		</legend>
		<div>
			<div id="heads">
				<ul>
					<c:forEach var="row" items="${cp:DICTIONARY('FILETYPE')}">
						<li class="li" onclick="setTab(this);" id="${row.key}"
							style="display: none;">${row.value}</li>
					</c:forEach>
					<li id="suoyou" class="li select" onclick="setAll();">所有</li>
				</ul>
			</div>

			<div class="tabList">
				<div>
					<table border="0" cellspacing="0" cellpadding="0" class="viewTable"
						width="100%">
						<tr>
							<td class="tableHeader">类别</td>
							<td class="tableHeader">材料名称</td>
							<td class="tableHeader">文件名称</td>
							<td class="tableHeader">节点名称</td>
							<td class="tableHeader">材料上传人</td>
						</tr>
						<c:forEach var="stuff" items="${optStuffs}">
							<script type="text/javascript">
								var id = '${stuff.filetype}';
								if (id != '')
									document.getElementById(id).style.display = "";
							</script>
							<tr name="filetr" class="${stuff.filetype}" align="center">
								<td>${cp:MAPVALUE("FILETYPE",stuff.filetype)}</td>
								<td>${stuff.stuffname}</td>
								<td><c:if test="${stuff.iszhi=='1'}">${stuff.filename}</c:if>
									<c:if test="${stuff.iszhi !='1'}">
										<a style="text-decoration: none; color: blue;"
											href="<%=request.getContextPath()%>/powerruntime/generalOperator!downStuffInfo.do?stuffid=${stuff.stuffid}&netid=${stuff.netId}">${stuff.filename}</a>
									</c:if></td>
								<td>${stuff.nodename}</td>
								<td>${cp:MAPVALUE("usercode",stuff.uploadusercode)}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>

	</fieldset>


</body>
</html>