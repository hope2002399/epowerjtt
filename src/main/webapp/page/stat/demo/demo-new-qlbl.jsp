<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>${formNameFormat}</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<%@include file="/page/stat/childs/stat-css.jsp"%>
</head>
<body>
	<%-- 默认舒展型 --%>
	<c:if test="${isThLarge == 1 || empty isThLarge}">
		<c:set var="thLargeDisplay" value=""></c:set>
		<c:set var="thLargeActive" value="active"></c:set>
		<c:set var="thSmallActive" value=""></c:set>
	</c:if>
	<c:if test="${isThLarge == 0 }">
		<c:set var="thLargeDisplay" value="table-condensed"></c:set>
		<c:set var="thLargeActive" value=""></c:set>
		<c:set var="thSmallActive" value="active"></c:set>
	</c:if>

	<div class="container">
		<%@include file="/page/stat/childs/search-new.jsp"%>

		<%@include file="/page/stat/childs/toolbar-new.jsp"%>

		<%@include file="/page/stat/childs/normalTable-new.jsp"%>
	</div>
	<%@include file="/page/stat/childs/stat-tree-scripts2.jsp"%>
	<!-- 统计相关js -->
	<script src="${pageContext.request.contextPath}/scripts/stat/stat.js"></script>
</body>
<script type="text/javascript">
$.STAT.addRenderTableCallback(function(tds, headers, params) {
	var td, href, qlstate = params['qlstate'], link;
	
	//alert(tds);
	var lastTD = tds[tds.length - 1];
	var sTD = tds[1];
	var lastLink = lastTD.find('a');
	// 合计去除链接
	if (lastLink.length) {
		lastTD.html(lastLink.text());
		
		
	}
	sTD.attr('width',500);
	lastTD.attr('width',80);
	
	if ('N' === qlstate)
		return;

	for (var i = 2; i < tds.length; i++) {
		td = tds[i];

		link = td.find('a');
		if (link.length) {
			href = link.attr('href');
		}
		// 没有链接，跳过
		else {
			continue;
		}

		// 根据qlstate值，改变链接中参数
		if (!qlstate || 'A' === qlstate) {
			href = href.replace('isSuspend=1', 'isSuspend=0');
			href = href.replace('isDisuse=1', 'isDisuse=0');
		} else if ('X' === qlstate) {
			href = href.replace('isSuspend=1', 'isSuspend=0');
		} else if ('T' === qlstate) {
			href = href.replace('isDisuse=1', 'isDisuse=0');
		}

		link.attr('href', href);
	}
});
$.STAT.renderTable();

function expandAll() {
	$("#statTable").treetable("expandAll");
}
	
</script>
</html>