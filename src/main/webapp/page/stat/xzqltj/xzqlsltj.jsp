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
<body style="width: 99%;">
	<div class="container" style="padding-top: 5px;">
		<%@include file="/page/stat/childs/search-new.jsp"%>
		<c:choose>
			<c:when
				test="${('DZYXCFTJ' eq modelName)||('DZYXXKTJ' eq modelName )}">
				<%@include file="/page/stat/childs/normalTable-new.jsp"%>
				<%-- <%@include file="/page/stat/echar/qlswqk.jsp"%> --%>
			</c:when>
			<c:otherwise>
				<%@include file="/page/stat/childs/treeTable-new.jsp"%>
			</c:otherwise>
		</c:choose>
	</div>

	<%@include file="/page/stat/childs/stat-tree-scripts2.jsp"%>

</body>
<script type="text/javascript">
	$.STAT.addRenderTableCallback(function(tds, headers, params) {
		var td, href, qlstate = params['qlstate'], link;
		
		var lastTD = tds[tds.length - 1];
		var lastLink = lastTD.find('a');
		// 合计去除链接
		if (lastLink.length) {
			//lastTD.html(lastLink.text());
			lastLink.attr('href', lastLink.attr('href').replace('合计',''));
			
		}
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
	var ADD_BUTTON = '<a class="btn btn-primary btn-sm add" href="javascript:;" title="展开" onclick="expandAll()"><i class="glyphicon glyphicon-plus"></i>展开</a>';
	;
	$.STAT.addButtonOnToolBar(ADD_BUTTON);

	function expandAll() {
		$("#statTable").treetable("expandAll");
	}
	$(document).ready(function() {
		<c:if test="${('DZYXCFTJ' eq modelName)||('DZYXXKTJ' eq modelName )||('xzqlslxjtj' eq modelName)}">
		$("#spancess").removeClass("addTd");
		$("#spancess").addClass("addbutton");
		</c:if>
	});
</script>
</html>