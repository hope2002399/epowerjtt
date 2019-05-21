<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<style>
.container1 {
	padding: 5px;
	box-sizing: border-box;
	overflow: hidden;
}

.container1 .box {
	border: 1px solid #ddd;
	margin-bottom: 10px;
	box-sizing: border-box;
}

.container1 .box h1 {
	height: 25px;
	line-height: 25px;
	padding-left: 10px;
	color: #fff;
	font-size: 14px;
	background:
		url(${pageContext.request.contextPath}/themes/default/images/zhong.gif)
		repeat-x;
}


</style>
	<%-- <link href="${pageContext.request.contextPath}/media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/> --%>
	<link href="${pageContext.request.contextPath}/media/css/style.css" rel="stylesheet" type="text/css"/>

<div class="container1" style="background-color:black;">

	

	<div class="box" style="width: 50%; float: left;border:0px;">
			<iframe
				src="${pageContext.request.contextPath}/sys/mainFrame!showFirstPageMap.do"
				border="0" frameBorder="no" marginWidth="0" scrolling="no"
				width="100%" onload="autoHeight(this);"></iframe>
	</div>

	<div class="box" style="width: 50%; float: right;border:0px;">


			<iframe
				src="${pageContext.request.contextPath}/sys/mainFrame!showFirstPageLine2.do"
				border="0" frameBorder="no" marginWidth="0" scrolling="no"
				width="100%" onload="autoHeight(this);"></iframe>


			<iframe
				src="${pageContext.request.contextPath}/sys/mainFrame!showFirstPageBar.do"
				border="0" frameBorder="no" marginWidth="0" scrolling="no"
				width="100%" onload="autoHeight(this);"></iframe>


		</div>


</div>





</body>


<script>
	function autoHeight(iframe) {

		if (!iframe) {
			return false;
		}

		// chrome处理iframe上的onmousescroll和ff ie不同，可以支持nicescroll
	/* 	if ($.browser.chrome) {
			// iframe的高度
			var ih = iframe.contentDocument.body.offsetHeight;

		}
		// 其他浏览器只好固定iframe高度了
		else {

		} */

		if (iframe.Document) {//ie自有属性
			iframe.height = iframe.Document.body.scrollHeight;
		} else if (iframe.contentDocument) {//ie,firefox,chrome,opera,safari
			iframe.height = iframe.contentDocument.body.offsetHeight;
		}
	}
</script>
