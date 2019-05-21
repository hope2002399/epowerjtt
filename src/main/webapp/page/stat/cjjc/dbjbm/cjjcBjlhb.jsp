<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>${formNameFormat}</title>


<%@include file="/page/stat/childs/stat-css.jsp" %>

</head>
<body>
	<div class="container" style="padding-top: 5px;">
		<%@include file="/page/stat/childs/search-new.jsp"%>

		<%@include file="/page/stat/childs/toolbar-new.jsp"%>

		<%@include file="/page/stat/childs/normalTable-new.jsp"%>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${pageContext.request.contextPath}/themes/bootstrap3/js/jquery.1.10.1.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${pageContext.request.contextPath}/themes/bootstrap3/js/mustache.js"></script>

	<!-- 树形表格js -->
	<%-- <script src="${pageContext.request.contextPath}/scripts/jquery/jquery.treetable/jquery.treetable.js" type="text/javascript"></script> --%>
	
	<!-- 统计相关js -->
	<script src="${pageContext.request.contextPath}/scripts/stat/stat.js"></script>

<script type="text/javascript">


$.STAT.addRenderTableCallback(function(tds, header, params) {
	var length = tds.length;
    var orgID = tds[0].data('value'), usercode = params.usercode, yearMonth = params.year;
	var year = yearMonth.split('-')[0], month = yearMonth.split('-')[1];
	
	for(var i=2;i<length-1;i++){
		
	// 超期率
		var cqlTD = tds[i], cqlValue = parseFloat(cqlTD.data('value')), isDB = false;
		
		// 督办
		var dbTD = tds[length - 1], alreadyDB = dbTD.data('value');
		
		// 部门ID 用户ID 统计时间
				
		if (cqlValue < 0.8) {
			cqlTD.css({'color': 'red'});
			isDB = true;
		}
	}	
	if (isDB) {
		
		if (alreadyDB) {
			dbTD.html(Mustache.render(BUTTONS_TEMPLATE_YDB, {
				orgID: orgID,
				usercode: usercode,
				alreadyDB: alreadyDB
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

var BUTTONS_TEMPLATE_DB = '<a class="btn btn-primary btn-xs edit" href="${pageContext.request.contextPath }/jttsunzw/SupinfoBasic.do?action=addNewDep&isDoing=0&org_id={{orgID}}&usercode={{usercode}}&supervisionType=8&supervisionYear={{year}}&supervisionMonth={{month}}" target="navTab" rel="DuBanForm" title="督办"><i class="glyphicon glyphicon-bullhorn"></i></a>';
var BUTTONS_TEMPLATE_YDB = '<a class="btn btn-success btn-xs edit" href="${pageContext.request.contextPath }/jttsunzw/SupinfoBasic.do?action=showDepInfo&org_id={{orgID}}&usercode={{usercode}}&supervisionType=8&&superviseCode={{alreadyDB}}" target="navTab" rel="DuBanForm" title="已督办"><i class="glyphicon glyphicon-eye-open"></i></a>';
$.STAT.renderTable();
</script>
</body>


</html>