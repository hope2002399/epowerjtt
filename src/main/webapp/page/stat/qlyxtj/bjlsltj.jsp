<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>${formNameFormat}</title>
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />

<%@include file="/page/stat/childs/stat-css.jsp" %>
</head>
<body>
	<div class="container" style="padding-top: 5px;">
		<%@include file="/page/stat/childs/search-new.jsp"%>

		<%@include file="/page/stat/childs/treeTable-new.jsp"%>
	</div>

	<%@include file="/page/stat/childs/stat-tree-scripts2.jsp" %>

</body>
<script type="text/javascript">
$.STAT.addRenderTableCallback(function(tds, headers, params) {
	var td, href, link, text, length = tds.length;
	
	for (var i=2; i<length; i++) {
		td = tds[i];
		
		link = td.find('a');
		if (link.length) {
			href = link.attr('href');
		}
		// 没有链接，跳过
		else {
			continue;
		}
		
		// 第三列行政处罚特殊链接
		if (3 === i) {
			href = href.replace('Apply','Punish');
			//href = href.replace('s_orgId','seaOrg_id');
			href = href.replace('s_begFinishTime','s_begTime');
			href = href.replace('s_endFinishTime','s_endTime');
			link.attr('href', href);
		} 
		// 去除合计链接
		else if (i === length - 1) {
			text = link.text();
			td.html(text);
		}
	}
});

$.STAT.renderTable();
</script>
</html>