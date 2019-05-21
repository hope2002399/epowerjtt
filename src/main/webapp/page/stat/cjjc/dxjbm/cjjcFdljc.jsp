<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>${formNameFormat}</title>
<%@include file="/page/stat/childs/stat-css.jsp" %>

</head>
<body>
	<%-- 默认紧凑型 --%>
<%-- 	<c:if test="${isThLarge == 1 }"> --%>
<%-- 		<c:set var="thLargeDisplay" value=""></c:set> --%>
<%-- 		<c:set var="thLargeActive" value="active"></c:set> --%>
<%-- 		<c:set var="thSmallActive" value=""></c:set> --%>
<%-- 	</c:if> --%>
<%-- 	<c:if test="${isThLarge == 0 || empty isThLarge}"> --%>
<%-- 		<c:set var="thLargeDisplay" value="table-condensed"></c:set> --%>
<%-- 		<c:set var="thLargeActive" value=""></c:set> --%>
<%-- 		<c:set var="thSmallActive" value="active"></c:set> --%>
<%-- 	</c:if> --%>
	<div class="container" style="padding-top: 5px;">
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
$.STAT.addRenderTableCallback(function(tds, header, params) {
	var length = tds.length;
	
	// 否定率
	var fdTD = tds[length - 2], fdValue = parseFloat(fdTD.data('value')), isDB = false;
	
	// 督办
	var dbTD = tds[length - 1], superviseCode = dbTD.data('value');
	
	// 部门ID 用户ID 统计时间
	var orgID = tds[0].data('value'), usercode = params.usercode, yearMonth = params.yearMonth;
	var year = yearMonth.split('-')[0], month = yearMonth.split('-')[1];
			
	if (fdValue > 0.02) {
		fdTD.css({'color': 'red'});
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
var BUTTONS_TEMPLATE_DB = '<a class="btn btn-primary btn-xs edit" href="${pageContext.request.contextPath }/jttsunzw/SupinfoBasic.do?action=addNewDep&isDoing=0&org_id={{orgID}}&usercode={{usercode}}&supervisionType=7&supervisionYear={{year}}&supervisionMonth={{month}}" target="navTab" rel="DuBanForm" title="督办"><i class="glyphicon glyphicon-bullhorn"></i></a>';
var BUTTONS_TEMPLATE_YDB = '<a class="btn btn-success btn-xs edit" href="${pageContext.request.contextPath }/jttsunzw/SupinfoBasic.do?action=showDepInfo&org_id={{orgID}}&usercode={{usercode}}&supervisionType=7&superviseCode={{superviseCode}}" target="navTab" rel="DuBanForm" title="已督办"><i class="glyphicon glyphicon-eye-open"></i></a>';
$.STAT.renderTable();
</script>
</html>