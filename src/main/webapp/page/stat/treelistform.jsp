<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 

<html>
<head><meta name="decorator" content='${LAYOUT}'/>
<title>${formName}</title>
</head>
<body>
	<jsp:include page="childs/search.jsp"></jsp:include>

	<input type="hidden" name="statRows" value="${rowCount}"/> <!-- 不包含统计数据行 --> 
	<input type="hidden" name="isStatRow" value="${rowDrawChart}"/> <!-- 是否按行画统计图   T 画  F 不画 --> 
	<input type="hidden" name="statStartCol" value="${drawChartBeginCol}"/>  <!-- 按行画统计图  去数据起始列 --> 
	<input type="hidden" name="statEndCol" value="${drawChartEndCol}"/>  <!-- 按行画统计图  去数据借宿列 --> 
	
	<c:set var="rowInd" >0</c:set>
	<ec:tree identifier="col0" parentAttribute="col1" items="ListObjects_formData" 
		action="twodimenform!doStat.do" 
		view="org.extremecomponents.tree.TreeView" filterable="false"
		sortable="false"  var="optinfo" imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif">
		<ec:row>
			<c:forEach var="col" items="${columns}" varStatus="status">   
				<c:if  test="${rowInd == 2}">
					<ec:column property="${col.colProperty}" title="${col.colName}" style="text-align:left" cell="org.extremecomponents.tree.TreeCell" />
				</c:if>
				<c:if  test="${rowInd > 2}">
					<ec:column property="${col.colProperty}" title="${col.colName}" sortable="false"	style="text-align:left" />
				</c:if>
			<c:set var="rowInd" >${rowInd+1}</c:set>
			</c:forEach>
		</ec:row>
	</ec:tree>	

</body>
<script type="text/javascript">
$(function() {
	$.myChart.init('#ec', $.evalJSON('${jsonFormData}'), {
		defaultType:'column'
	});
});
</script>
</html>