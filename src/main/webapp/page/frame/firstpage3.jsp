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
<script src="${pageContext.request.contextPath}/scripts/jquery-1.7.2.min.js" type="text/javascript"></script>

<body>


<div id="firstPage" class="navTab-panel tabsPageContent layoutBox"> 
					<div class="page unitBox" style="overflow:hidden;">
						<div class="pageFormContent" layoutH="10" >

<iframe
				src="${pageContext.request.contextPath}/sys/mainFrame!showNewFirstPage.do"
				border="0" frameBorder="no" marginWidth="0" scrolling="no"
				width="99%" onload="autoHeight(this);"></iframe>
</div>
					</div>
				</div>





</body>


<script>
	function autoHeight(iframe) {

		if (!iframe) {
			return false;
		}

		// chrome处理iframe上的onmousescroll和ff ie不同，可以支持nicescroll
		if ($.browser.chrome) {
			// iframe的高度
			var ih = iframe.contentDocument.body.offsetHeight;

		}
		// 其他浏览器只好固定iframe高度了
		else {

		}

		if (iframe.Document) {//ie自有属性
			iframe.height = iframe.Document.body.scrollHeight;
		} else if (iframe.contentDocument) {//ie,firefox,chrome,opera,safari
			iframe.height = iframe.contentDocument.body.offsetHeight;
		}
	}
</script>
