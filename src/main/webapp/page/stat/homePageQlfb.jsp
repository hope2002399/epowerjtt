<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<!DOCTYPE html>
<html style="overflow: hidden;">
<head>
<title>${formNameFormat}</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />

<style>
table caption {font-size: 16px; padding: 5px 0;}
</style>
<%@include file="/page/stat/childs/stat-css.jsp" %>

</head>
<body style="overflow: hidden;">
	<div class="container" style="overflow:hidden;">
			<table id="statTable" style="width:49%; float:left; margin:0 0 10px 10px;" cellpadding="0" border="0" cellspacing="0">
				<caption>行政权力分类统计</caption>
				<c:if test="${not empty tablePanel.thead }">
					<thead align="center">
						<c:forEach var="line" items="${tablePanel.thead.lines }">
							<tr>
								<c:forEach var="cell" items="${line.cells }">
									${cell.html }
								</c:forEach>
							</tr>
						</c:forEach>
					</thead>
				</c:if>
				
				<c:if test="${not empty tablePanel.tbody }">
					<tbody align="center">
						<c:forEach var="line" items="${tablePanel.tbody.lines }">
							<tr>
								<c:forEach var="cell" items="${line.cells }">
									${cell.html }					
								</c:forEach>
							</tr>
						</c:forEach>
					</tbody>
				</c:if>
			</table>
			
			<div style="float:right; width:49%; overflow:hidden" id="chart"></div>
	</div>	

	<%@include file="/page/stat/childs/stat-scripts2.jsp" %>
</body>

<script type="text/javascript">
$(function() {
	 
	 setTimeout(function() {
		 $('#statTable th:last').remove(); 
		 $('#statTable>tbody>tr>td:last-child').remove();
		 
		 $.myChart.init('#statTable', '${formNameFormat}' ,{
		 	button: false,
		 	height:300,
		 	stat: [{
		 		chartType: 'pie',
		 		type: 'line',
		 		td: '合计',
		 		show:true
		 	}]
		 });
		 parent.document.getElementById("xzqlhyfb").style.height= document.body.scrollHeight+"px";
	 }, 20);
	 	 
});

</script>

</html>