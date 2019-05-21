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
	<div class="container">
		<%@include file="/page/stat/childs/normalTable-new.jsp"%>
	</div>

	<%@include file="/page/stat/childs/stat-scripts2.jsp" %>
</body>

<script type="text/javascript">
$(function() {
	 $('#statTable').css({
		 position:'absolute',
		 left:-9999
	 });
	
	 $('#statTable th:last').remove(); 
	 $('#statTable>tbody>tr>td:last-child').remove(); 
	 $('#statTable>tbody>tr>td:first').text('');
	 
	 setTimeout(function() {
		 
		 $.myChart.init('#statTable', '${formNameFormat}' ,{
		 	button: false,
		 	height:290,
		 	stat: [{
		 		chartType: 'column',
		 		type: 'line',
		 		td: '合计',
		 		show:true
		 	}]
		 });
	 }, 20);
});

</script>

</html>