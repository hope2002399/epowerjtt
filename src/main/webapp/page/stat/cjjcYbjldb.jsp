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
</html>