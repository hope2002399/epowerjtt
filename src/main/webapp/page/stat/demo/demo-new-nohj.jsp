<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>${formNameFormat}</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<%@include file="/page/stat/childs/stat-css.jsp"%>
</head>
<body>
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
		<%@include file="/page/stat/childs/search-new.jsp"%>

		<%@include file="/page/stat/childs/toolbar-new.jsp"%>

		<%@include file="/page/stat/childs/normalTable-new-nohj.jsp"%>
	</div>
	<%@include file="/page/stat/childs/stat-tree-scripts2.jsp"%>
	<!-- 统计相关js -->
	<script src="${pageContext.request.contextPath}/scripts/stat/stat.js"></script>

</body>
</html>