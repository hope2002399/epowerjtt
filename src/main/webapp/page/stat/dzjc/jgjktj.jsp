<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/stat/childs/stat-css.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>${formNameFormat}</title>
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />

<!-- 统计修改样式 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/scripts/stat/stat.css">

<!-- 树形表格样式 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/scripts/jquery/jquery.treetable/stylesheets/jquery.treetable.css" />
</head>
<style>
.addbutton{
	width: 900px;
}
</style>
<body style="width: 99%;">

	<div class="container" style="padding-top: 5px;">
		<%@include file="/page/stat/childs/search-new.jsp"%>
		<%@include file="/page/stat/childs/treeTable-new.jsp"%>
	</div>

	<%@include file="/page/stat/childs/stat-tree-scripts2.jsp"%>

</body>

<script>
	$.STAT.addRenderTableCallback(function(tds, header, params) {
		var lastTD = tds[tds.length - 1], publishTD = tds[3];

		var publishLink = publishTD.find('a'), lastLink = lastTD.find('a');

		// 合计去除链接
		if (lastLink.length) {
			lastTD.html(lastLink.text());
		}

		lastTD.attr('width',80);
		// 处罚的链接不一样
		if (publishLink.length) {
			publishLink.attr('href', publishLink.attr('href').replace(
					"apply!fgList.do", "punish!list.do"));
		}

	});
	$.STAT.renderTable();
	
</script>

</html>