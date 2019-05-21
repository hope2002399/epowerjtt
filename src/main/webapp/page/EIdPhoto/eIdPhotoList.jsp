<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title>
		电子证照查询
		</title>
		<sj:head locale="zh_CN" />
		<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset>
			<legend>
				 查询条件
			</legend>
			<s:form action="eIdPhoto" namespace="/powerruntime" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">
					<tr>
						<td class="addTd">电子证照编号:</td>
						<td><s:textfield name="s_dzzzNo" value="%{#parameters['s_dzzzNo']}"/> </td>
					</tr>
					<tr>
						<td colspan="4">
							<s:submit method="list"  key="opt.btn.query" cssClass="btn"/>
						</td>
					</tr>
				</table>
			</s:form>
		</fieldset>

		<ec:table action="powerruntime/eIdPhoto!list.do" items="srPerApplyList" var="srPermitApply"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="dzzzNo" title="电子证照编号" style="text-align:center" sortable="false" />
				<ec:column property="zzBh" title="纸质证照编号" style="text-align:center" sortable="false" />
				<ec:column property="bzDate" title="颁证时间" style="text-align:center" sortable="false" />
				<ec:column property="deptName" title="颁证单位" style="text-align:center" sortable="false" />
				<ec:column property="userName" title="持证者" style="text-align:center" sortable="false" />
			</ec:row>
		</ec:table>

	</body>
	<script type="text/javascript">
		
	</script>
</html>
