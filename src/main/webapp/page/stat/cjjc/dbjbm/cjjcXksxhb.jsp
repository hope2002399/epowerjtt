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
<%-- 	<script src="${pageContext.request.contextPath}/themes/bootstrap3/js/bootstrap.min.js"></script> --%>
	<script src="${pageContext.request.contextPath}/themes/bootstrap3/js/mustache.js"></script>
	<!-- bootstrap日期控件 -->
<%-- 	<script src="${pageContext.request.contextPath}/themes/bootstrap3/js/bootstrap-datetimepicker.min.js"></script> --%>
<%-- 	<script src="${pageContext.request.contextPath}/themes/bootstrap3/js/bootstrap-datetimepicker.zh-CN.js"></script> --%>

	<!-- 树形表格js -->
<%-- 	<script src="${pageContext.request.contextPath}/scripts/jquery/jquery.treetable/jquery.treetable.js" type="text/javascript"></script> --%>
	
	<!-- 统计相关js -->
	<script src="${pageContext.request.contextPath}/scripts/stat/stat.js"></script>

<script type="text/javascript">
var average1 = 0, index1 = 0, average2 = 0 ,index2 = 0;
$($.STAT.id).find('tbody tr td:nth-child(4)').map(function() {
	return $(this).data('value');
}).each(function() {
	average1 += parseFloat(this);
	index1++;
});
$($.STAT.id).find('tbody tr td:nth-child(5)').map(function() {
	return $(this).data('value');
}).each(function() {
	average2 += parseFloat(this);
	index2++;
});
average1/=index1;
average2/=index2;

console.log(average1);
console.log(average2);

 $.STAT.addRenderTableCallback(function(tds, header, params) {
    var length = tds.length;
	var orgID = tds[0].data('value'), usercode = params.usercode, yearMonth = params.yearMonth;
	var year = yearMonth.split('-')[0], month = yearMonth.split('-')[1];
	
	for(var i=0;i<2;i++){		
		var qlyxTD = tds[length - 2-i], qlyxValue = parseFloat(qlyxTD.data('value')), isDB = false;
		
		// 督办
		var dbTD = tds[length - 1], superviseCode = dbTD.data('value');
		var average= 0 ;
		if(i==0){
			average=average2;
		}else{
			average=average1;
		}
		
		if (qlyxValue > average * 1.2) {
			qlyxTD.css({'color': 'red'});
			isDB = true;
		}
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

var BUTTONS_TEMPLATE_DB = '<a class="btn btn-primary btn-xs edit" href="${pageContext.request.contextPath }/jttsunzw/SupinfoBasic.do?action=addNewDep&isDoing=0&org_id={{orgID}}&usercode={{usercode}}&supervisionType=9&supervisionYear={{year}}&supervisionMonth={{month}}" target="navTab" rel="DuBanForm" title="督办"><i class="glyphicon glyphicon-bullhorn"></i></a>';
var BUTTONS_TEMPLATE_YDB = '<a class="btn btn-success btn-xs edit" href="${pageContext.request.contextPath }/jttsunzw/SupinfoBasic.do?action=showDepInfo&org_id={{orgID}}&usercode={{usercode}}&supervisionType=9&&superviseCode={{superviseCode}}" target="navTab" rel="DuBanForm" title="已督办"><i class="glyphicon glyphicon-eye-open"></i></a>';
 $.STAT.renderTable(); 
</script>
</body>


</html>