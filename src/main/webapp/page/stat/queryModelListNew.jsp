<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>${formNameFormat}</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />

<%@include file="/page/stat/childs/stat-css.jsp" %>
</head>
<body>
		<%@include file="/page/stat/childs/search-new.jsp"%>

		<%@include file="/page/stat/childs/toolbar-new.jsp"%>

		<%@include file="/page/stat/childs/treeTable-new.jsp"%>

	<%@include file="/page/stat/childs/stat-tree-scripts2.jsp" %>

</body>
<script type="text/javascript">
	$.STAT.addRenderTableCallback(function(tds, header, params) {
		var td = tds[tds.length - 1], value = tds[0].data('value'), name = tds[2].data('value'), type = tds[5].data('value');
				
		// 如果是报表，添加按钮
		if ('R' === type) {
			td.html(Mustache.render(BUTTONS_TEMPLATE, {
				modelName: value,
				name: name
			}));
		}
		
		// 如果有查询条件，去除TR中的tt-parent-id值，防止树形表格生产时找不到父节点报错
		if (params.modelCode || params.modelNamer) {
			this.data('ttParentId', null);
		}
	});
	
	var BUTTONS_TEMPLATE = '<a class="btn btn-success btn-xs edit" href="${pageContext.request.contextPath }/stat/queryModel!edit.do?modelName={{modelName}}" target="navTab" rel="statDefForm" title="编辑{{name}}"><font color="black">编   辑</font></a>';
	BUTTONS_TEMPLATE += '<a class="btn btn-info btn-xs copy" href="${pageContext.request.contextPath}/stat/queryModel!toCopy.do?modelName={{modelName}}" title="复制为新模板"><font color="black">复   制</font></a>';
	BUTTONS_TEMPLATE += '<a class="btn btn-info btn-xs link" href="${pageContext.request.contextPath}/stat/twodimenform!doStat.do?modelName={{modelName}}" title="查看{{name}}" target="navTab" rel="statShow" external="true"><font color="black">查   看</font></a>';
	BUTTONS_TEMPLATE += '<a class="btn btn-danger btn-xs delete" href="${pageContext.request.contextPath }/stat/queryModel!delete.do?modelName={{modelName}}" title="删除{{name}}" target="ajaxTodo"><font color="black">删   除</font></a>';
	
	var ADD_BUTTON = '<a class="btn btn-primary btn-sm add" href="${pageContext.request.contextPath }/stat/queryModel!built.do" target="navTab" rel="statDefForm" title="新建统计模板"><i class="glyphicon glyphicon-plus"></i> 新   建</a>';;
	
	$.STAT.addButtonOnToolBar(ADD_BUTTON);
	$.STAT.removeButtonOnToolBar('button.excel');
	$.STAT.renderTable();
</script>
</html>