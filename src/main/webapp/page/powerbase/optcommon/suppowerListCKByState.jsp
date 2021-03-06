<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html>
	<head>
		<title>
			权力库管理
		</title>
		<sj:head locale="zh_CN" />
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset style="padding:10px;">
			<legend>
				 查询条件
			</legend>
			
			<s:form action="supPower" namespace="/powerbase" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">
<input id="qlState" type="hidden" name="qlState"
			value="${object.qlState}" />
					<tr>
					<td class="addTd">权力编号:</td>
					<td><s:textfield name="s_itemId" style="width:195px"
							value="%{#parameters['s_itemId']}"></s:textfield></td>
				
					<td class="addTd">权力名称:</td>
					<td><s:textfield name="s_itemName" style="width:180px"
							value="%{#parameters['s_itemName']}" /></td>
				</tr>
				<tr>
					<td class="addTd">行使部门:</td>
					<td>
					<select name="s_orgId">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:LVB('unitcode')}">
								<option value="${row.value}"
									<c:if test="${parameters.s_orgId[0] eq row.value}">selected="selected"</c:if>>
									<c:out value="${row.label}" />
								</option>
							</c:forEach>
					</select></td>
				
					<td class="addTd">权力类型:</td>
					<td>
							<select name="s_itemType" style="width: 180px"
						onchange="checkItemType();">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('ITEM_TYPE')}">
								<option value="${row.key}"
									<c:if test="${parameters.s_itemType[0] eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
				</tr>
				
					<tr>
						<td></td>
						<td>
							<s:submit method="listCKByState"  key="opt.btn.query" cssClass="btn"/>
						</td>
					</tr>
				</table>
			</s:form>
		</fieldset>

		<ec:table action="powerbase/supPower!listCK.do" items="subPowerList" var="suppower"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="itemId" title="权力编号" style="text-align:center">
					<a href='powerbase/suppowerchglog!listVersion.do?itemId=${suppower.itemId}&version=${suppower.version}'>${suppower.itemId}</a>
				</ec:column>

				<ec:column property="itemName" title="权力名称" style="text-align:center">
				<c:choose>
					<c:when test="${fn:length(suppower.itemName) > 30}">
						<c:out value="${fn:substring(suppower.itemName, 0, 30)}..." />
					</c:when>
					<c:otherwise>
						<c:out value="${suppower.itemName}" />
					</c:otherwise>
				</c:choose>
				</ec:column>

				<ec:column property="orgId" title="所属部门" style="text-align:center" >
					${cp:MAPVALUE("unitcode",suppower.orgId)}
				</ec:column>
				<ec:column property="itemType" title="权力类型" style="text-align:center" >
					${cp:MAPVALUE("ITEM_TYPE",suppower.itemType)}
				</ec:column>
				
			</ec:row>
		</ec:table>
	</body>
	<script type="text/javascript">
	</script>
</html>
