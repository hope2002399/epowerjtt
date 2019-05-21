<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/stat/childs/stat-css.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>${formNameFormat}</title>
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<!-- 统计修改样式 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/stat/stat.css">

<!-- 树形表格样式 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/jquery/jquery.treetable/stylesheets/jquery.treetable.css" />

</head>
<body>
	<div class="container" style="padding-top: 5px;">
		<%@include file="/page/stat/childs/search-new.jsp"%>

	<%-- 	<%@include file="/page/stat/childs/toolbar-new.jsp"%> --%>

		<%@include file="/page/stat/childs/newtable.jsp"%>
	</div>
	<%@include file="/page/stat/childs/stat-tree-scripts2.jsp"%>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<%-- <script src="${pageContext.request.contextPath}/themes/bootstrap3/js/jquery.1.10.1.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${pageContext.request.contextPath}/themes/bootstrap3/js/mustache.js"></script>
	<!-- bootstrap日期控件 -->
	<script src="${pageContext.request.contextPath}/themes/bootstrap3/js/bootstrap-datetimepicker.min.js"></script>
	<script src="${pageContext.request.contextPath}/themes/bootstrap3/js/bootstrap-datetimepicker.zh-CN.js"></script>

	<!-- 树形表格js -->
	<script src="${pageContext.request.contextPath}/scripts/jquery/jquery.treetable/jquery.treetable.js" type="text/javascript"></script>
	
	<!-- 统计相关js -->
	<script src="${pageContext.request.contextPath}/scripts/stat/stat.js"></script>
 --%>
</body>
<script type="text/javascript">
	$.STAT.addRenderTableCallback(function(tds, headers, params) {
		var td, href, qlstate = params['qlstate'], link;
		
		if ('N' === qlstate) return;
		
		for (var i=2; i<tds.length; i++) {
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
			}
			else if ('X' === qlstate) {
				href = href.replace('isSuspend=1', 'isSuspend=0');
			}
			else if ('T' === qlstate) {
				href = href.replace('isDisuse=1', 'isDisuse=0');
			}
			
			link.attr('href', href);
		}
	});
	
	$.STAT.renderTable();
</script>
</html>