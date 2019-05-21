<link
	href="${pageContext.request.contextPath}/themes/css/extremecomponents.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/themes/css/am.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/themes/default/style.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/themes/css/calendar.css"
	rel="stylesheet" type="text/css" />
<script
	src="${pageContext.request.contextPath}/scripts/jquery-1.6.min.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/highcharts.js"
	type="text/javascript"></script>
<%-- <script src="${pageContext.request.contextPath}/scripts/charts/centit.charts.js" type="text/javascript"></script> --%>
<script
	src="${pageContext.request.contextPath}/scripts/jquery.json-2.3.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/scripts/centitui/core.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/centitui/ui.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/scripts/centitui/datepicker.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/scripts/centitui/util.date.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/scripts/Mztreeview1.0/MzTreeView10.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/print.js"
	type="text/javascript"></script>
<link
	href="${pageContext.request.contextPath}/styles/default/css/oldindex.css"
	rel="stylesheet" type="text/css" />

<script type="text/javascript">
	//open new window by defined properties
	function openNewWindow(winUrl, winName, winProps) {
		if (winProps == '' || winProps == null) {
			winProps = 'height='
					+ (window.screen.availHeight - 50)
					+ ',width='
					+ window.screen.availWidth
					+ ',directories=false,location=false,top=0,left=0,menubar=false,Resizable=yes,scrollbars=yes,toolbar=false';
		}
		window.open(winUrl, winName, winProps);
	}
	function openNewWindow(winUrl, winName, iWidth, iHeight) {
		var iTop = (window.screen.height - 30 - iHeight) / 2; //获得窗口的垂直位置;  
		var iLeft = (window.screen.width - 10 - iWidth) / 2; //获得窗口的水平位置;  
		alert("iTop is " + iTop + " and iLeft=" + iLeft);
		var winProps = 'height='
				+ iHeight
				+ ',width='
				+ iWidth
				+ ',top='
				+ iTop
				+ ',left='
				+ iLeft
				+ ',directories=false,location=false,menubar=false,resizable=yes,scrollbars=yes,toolbar=falsestatus=no';
		window.open(winUrl, winName, winProps);
	}
</script>