<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>${formNameFormat}</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<%@include file="/page/stat/childs/stat-css.jsp"%>
<style type="text/css">
thead td{background-color:#2D80D2;color:white;border: 1px solid #CACACA;text-align:center;
          cursor:pointer;font-size:12px;padding:5px;border-right: 1px solid #CACACA;line-height:16px;vertical-align: middle;}
table td {font-size:12px; padding:5px;border: 1px solid #CACACA;}
table#statTable td{border-right: 1px solid #CACACA;font-size:12px;line-height:16px;padding:5px;vertical-align: middle;}
table.viewTable{border: 1px solid #CACACA;}

</style>
</head>
<body style="width:100%;">
	<%-- 默认舒展型 --%>
	<c:if test="${isThLarge == 1 || empty isThLarge}">
		<c:set var="thLargeDisplay" value=""></c:set>
		<c:set var="thLargeActive" value="active"></c:set>
		<c:set var="thSmallActive" value=""></c:set>
	</c:if>
	<c:if test="${isThLarge == 0 }">
		<c:set var="thLargeDisplay" value="table-condensed"></c:set>
		<c:set var="thLargeActive" value=""></c:set>
		<c:set var="thSmallActive" value="active"></c:set>
	</c:if>

	<div class="container">
	
		<div class="">
	<div class="">
	<table class="" id="statTable" style="width:100%;" >
		<caption>${formNameFormat }</caption>
		<c:if test="${not empty tablePanel.thead }">
			<thead align="center">
				<c:forEach var="line" items="${tablePanel.thead.lines }">
					<tr align="center">
						<c:forEach var="cell" items="${line.cells }">
							${cell.html }
						</c:forEach>
					</tr>
				</c:forEach>
			</thead>
		</c:if>
		
		<c:if test="${not empty tablePanel.tbody }">
			<tbody align="center">
				<c:forEach var="line" items="${tablePanel.tbody.lines }" varStatus="a">
					<tr align="center" <c:if test="${a.index%2==0 }">style="background-color: #dfe4e8;" </c:if> 
					<c:if test="${a.index%2==1 }">style="background-color:#ffffff;" 
					</c:if> >
						<c:forEach var="cell" items="${line.cells }">
							${cell.html }					
						</c:forEach>
					</tr>
				</c:forEach>
			</tbody>
		</c:if>
	</table>




	
	</div>
</div>
	</div>

</body>

</html>