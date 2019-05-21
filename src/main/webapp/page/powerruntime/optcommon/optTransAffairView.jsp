<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
	<link href="${pageContext.request.contextPath}/themes/css/alertDiv.css"
	rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/scripts/alertDiv.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/arrow.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/kjyj.js"
	type="text/javascript"></script>
<script type="text/javascript" src="jquery-1.6.min.js"></script>
<link href="${pageContext.request.contextPath}/themes/css/arrow.css" rel="stylesheet" type="text/css" />
		<title>
			${jspInfo.title}
		</title>
	</head>
<body>
	<%@ include file="/page/common/messages.jsp"%>
	<table>
	<tr>
	<td align="right">
		<!-- <input type="button" name="backFrame" class="btn" onclick="backEvent();" value="返 回" style=""> -->
		<c:if test="${(empty caozuo )}">
		<input type="button" name="backFrame" class="btn" onclick="showFlow('${flowInstId}');" value="查看流程图">
		</c:if>
</td>
</tr>
</table>
	<div class="flowTitle">${jspInfo.title}</div>	
	<c:forEach var="fInfo" items="${jspInfo.frameList}" >
		<iframe id="${fInfo.frameId}" name="${fInfo.frameId}" src="<c:url value='${fInfo.frameSrc}'/>" width="100%" style="margin-bottom:10px;"
			frameborder="no" scrolling="false" border="0" marginwidth="0" onload="iframeAutoFit(this);"></iframe>
	</c:forEach>
<script type="text/javascript">
	var sh = function(h){
		if(document.getElementById("viewStuffsFrame")){
			var t = document.getElementById("viewStuffsFrame");
			t.height = h;
		}
	};
	function showFlow(flowInstId){
		window.open("<%=request.getContextPath()%>/sampleflow/sampleFlowManager!viewxml.do?flowInstId="+flowInstId);
		
		
	}
	function backEvent(){
		getFormByFrame('viewFrame').backBtn.click();
	}
	//iframe自适应高度
	function iframeAutoFit(iframeObj){ 
	    setTimeout(function(){if(!iframeObj) return;iframeObj.height=(iframeObj.Document?iframeObj.Document.body.scrollHeight:iframeObj.contentDocument.body.offsetHeight)+10;},200) 
	}
</script>
</body>
</html>