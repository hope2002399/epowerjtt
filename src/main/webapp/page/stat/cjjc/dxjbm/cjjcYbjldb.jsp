<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>${formNameFormat}</title>
<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->

<!-- <!-- Bootstrap --> -->
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/themes/bootstrap3/css/bootstrap.min.css"> --%>
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/themes/bootstrap3/css/bootstrap-datetimepicker.min.css"> --%>

<!-- 统计修改样式 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/stat/stat.css">

</head>
<body>
	<%-- 默认舒展型 --%>

	<div class="container">
		<%@include file="/page/stat/childs/search-new.jsp"%>

		<%@include file="/page/stat/childs/toolbar-new.jsp"%>

		<%@include file="/page/stat/childs/normalTable-new.jsp"%>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${pageContext.request.contextPath}/themes/bootstrap3/js/jquery.1.10.1.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
<%-- 	<script src="${pageContext.request.contextPath}/themes/bootstrap3/js/bootstrap.min.js"></script> --%>
	<script src="${pageContext.request.contextPath}/themes/bootstrap3/js/mustache.js"></script>
	<!-- bootstrap日期控件 -->
<%-- 	<script src="${pageContext.request.contextPath}/themes/bootstrap3/js/bootstrap-datetimepicker.min.js"></script> --%>
<%-- 	<script src="${pageContext.request.contextPath}/themes/bootstrap3/js/bootstrap-datetimepicker.zh-CN.js"></script> --%>

	<!-- 统计相关js -->
	<script src="${pageContext.request.contextPath}/scripts/stat/stat.js"></script>
</body>
<script type="text/javascript">
var average = 0, index = 0;
$($.STAT.id).find('tbody tr td:nth-child(5)').map(function() {
	return $(this).data('value');
}).each(function() {
	average += parseFloat(this);
	index++;
});
average/=index;

$.STAT.addRenderTableCallback(function(tds, header, params) {
	var length = tds.length;
	
	// 权利运行率
	var ybjlTD = tds[length - 2], ybjlValue = parseFloat(ybjlTD.data('value')), isDB = false;
	
	// 督办
	var dbTD = tds[length - 1], superviseCode = dbTD.data('value');
	
	// 部门ID 用户ID 统计时间
	var orgID = tds[0].data('value'), usercode = params.usercode, yearMonth = params.yearMonth;
	var year = yearMonth.split('-')[0], month = yearMonth.split('-')[1];
	
	// 报警率>报警率平均值×120%，红灯报警
	if (ybjlValue > average * 1.2) {
		ybjlTD.css({'color': 'red'});
		isDB = true;
	}
	
	if (isDB) {
		
		if (superviseCode) {
			dbTD.html(Mustache.render(BUTTONS_TEMPLATE_YDB, {
				orgID: orgID,
				usercode: usercode,
				superviseCode: superviseCode
			}));
		}
		else {
			dbTD.html(Mustache.render(BUTTONS_TEMPLATE_DB, {
				orgID: orgID,
				usercode: usercode,
				year: year,
				month: month
			}));
		}
	}
	
});
var BUTTONS_TEMPLATE_DB = '<a class="btn btn-primary btn-xs edit" href="${pageContext.request.contextPath }/jttsunzw/SupinfoBasic.do?action=addNewDep&isDoing=0&org_id={{orgID}}&usercode={{usercode}}&supervisionType=4&supervisionYear={{year}}&supervisionMonth={{month}}" target="navTab" rel="DuBanForm" title="督办"><i class="glyphicon glyphicon-bullhorn"></i></a>';
var BUTTONS_TEMPLATE_YDB = '<a class="btn btn-success btn-xs edit" href="${pageContext.request.contextPath }/jttsunzw/SupinfoBasic.do?action=showDepInfo&org_id={{orgID}}&usercode={{usercode}}&supervisionType=4&superviseCode={{superviseCode}}" target="navTab" rel="DuBanForm" title="已督办"><i class="glyphicon glyphicon-eye-open"></i></a>';
$.STAT.renderTable();
</script>
</html>