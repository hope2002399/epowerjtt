<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>选择工作流</title>
</head>
<body>
	<fieldset style="padding:10px;display:block;margin-bottom:10px;">
		<legend style="padding:4px 8px 3px;"><b>收发文流程</b></legend>
		<c:if test="${not empty flowList}">
			<c:forEach var="flowDescribe" items="${flowList}">
				&nbsp;
				<c:if test="${fn:indexOf(flowDescribe.flowDesc,'收文') lt 0}">
					<a href="${pageContext.request.contextPath}/dispatchdoc/dispatchDoc!startDispatchDoc.do?flowCode=${flowDescribe.cid.flowCode}&object.optBaseInfo.optId=DISPATCH_DOC&version=${flowDescribe.cid.version}">
						<c:out value="${flowDescribe.flowName}"></c:out>
					</a>
				</c:if>
				<c:if test="${fn:indexOf(flowDescribe.flowDesc,'收文') gt -1}">
					<a href="${pageContext.request.contextPath}/dispatchdoc/incomeDoc!edit.do?flowCode=${flowDescribe.cid.flowCode}&object.optBaseInfo.optId=DISPATCH_DOC&version=${flowDescribe.cid.version}">
						<c:out value="${flowDescribe.flowName}"></c:out>
					</a>
				</c:if>
				<br><br>
			</c:forEach>
		</c:if>
	</fieldset>
	
</body>
</html>