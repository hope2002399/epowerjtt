<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>权力名称</title>
</head>

<body>
	<%@ include file="/page/common/messages.jsp"%>
	<div class="search">
		<div class="crumbs">
			权力表列表
		</div>

		<s:form action="supPower" namespace="/powerbase"	style="margin-top:0;margin-bottom:5">
			<table cellpadding="0" cellspacing="0" align="center">
			<input type="hidden" name="s_orgId" value="${session.SPRING_SECURITY_CONTEXT.authentication.principal.primaryUnit}">
			<input type="hidden" name="s_itemType" value="${itemType}">	
			<input type="hidden" name="itemType" value="${itemType}">
			<input type="hidden" name="s_subitemtype" value="${subitemtype}">
			<input type="hidden" name="subitemtype" value="${subitemtype}">
			<input type="hidden" name="documentTemplateIds" value="${documentTemplateIds}">
			<input type="hidden" name="isJD" value="${isJD}">
			<input type="hidden" name="punishobjectid" value="${punishobjectid}">
				<tr>
					<td class="addTd">权力编号：</td>
					<td>
					<s:textfield name="s_itemId" style="width:180px" value="%{#parameters['s_itemId']}" /></td>
				</tr>		
				<tr>
					<td class="addTd">权力名称:</td>
					<td>
					<s:textfield name="s_itemName" style="width:180px" value="%{#parameters['s_itemName']}" /></td>
				</tr>

				<tr>
					<td align="center" colspan="2">
					<input type="button" class="btn" value="关闭" onclick="window.close();">
						<s:submit method="listSupPower"  key="opt.btn.query" cssClass="btn"/>
					</td>
				</tr>
			</table>
		</s:form>
	</div>

	<ec:table action="powerbase/supPower!listSupPower_CF_faci.do" items="selectPowerList" var="suppower"
		imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif"
		retrieveRowsCallback="limit">
		
		<input type="hidden" id="itemId${suppower.itemId}" name="itemId${suppower.itemId}" value="${suppower.itemId}">
		<input type="hidden" id="itemName${suppower.itemId}" name="itemName${suppower.itemId}" value="${suppower.itemName}">
		<input type="hidden" id="poRegisterBasis${suppower.itemId}" name="poRegisterBasis${suppower.itemId}" value="${suppower.punishbasis}">
		
		<ec:row>
			<ec:column property="itemId" title="权力编号"	style="text-align:center" sortable="false">
			${suppower.itemId}</ec:column>

			<ec:column property="itemName" title="权力名称"	style="text-align:center" sortable="false">	
				<c:choose>
					<c:when test="${fn:length(suppower.itemName) > 20}">
						<c:out value="${fn:substring(suppower.itemName, 0, 20)}..." />
					</c:when>
					<c:otherwise>
						<c:out value="${suppower.itemName}" />
					</c:otherwise>
				</c:choose>
			</ec:column>
			<ec:column property="punishbasis" title="法律依据"
				style="text-align:center" sortable="false" >
					<c:choose>
					<c:when test="${fn:length(suppower.punishbasis) > 26}">
						<c:out value="${fn:substring(suppower.punishbasis, 0, 26)}..." />
					</c:when>
					<c:otherwise>
						<c:out value="${suppower.punishbasis}" />
					</c:otherwise>
				</c:choose>
				</ec:column>
		
			<%-- <ec:column property="punishobject" title="处罚对象"
				style="text-align:center" sortable="false">
				<c:if test="${suppower.punishobject==0}">个人</c:if>
				<c:if test="${suppower.punishobject==1}">机构</c:if>
				<c:if test="${suppower.punishobject==2}">个人、机构</c:if>
			</ec:column> --%>
			<ec:column property="opt" title="操作" sortable="false"
				style="text-align:center">
				<input type="radio" name="itemId" onclick="selectCF4XCCF('${suppower.itemId}')">
			</ec:column>
		</ec:row>
	</ec:table>

</body>
<script type="text/javascript">	
	var parentDocument = window.opener.document;//获取父页面对象

	//设置返回值
	function setParentVal(itemId) {
		if (window.confirm("确认选择此项权力吗？选择后窗口将自动关闭。")) {
				//parentDocument.getElementById('popunishObjectBrief').value = document.getElementById('itemName' + itemId).value;
				parentDocument.getElementById('itemName').value = document.getElementById('itemName' + itemId).value;
				parentDocument.getElementById('itemId').value = document.getElementById('itemId' + itemId).value;
				parentDocument.getElementById('poRegisterBasis').value = document.getElementById('poRegisterBasis' + itemId).value;
				window.close();
		}
		/*****************业务数据页面跳转end*********/
	}
	
	function selectCF4XCCF(itemId) {
		if (window.confirm("确认选择此处罚项目吗？选择后窗口将自动关闭。")) {
			var url ="<%=request.getContextPath()%>/punish/punishobjectbasic!createfacilitydes.do?item_id=" + itemId +"&object.punishobjectid=${punishobjectid}&object.punishobjectbrief=${subitemtype}&documentTemplateIds=${documentTemplateIds}&isJD=${isJD}";
			window.opener.location.href=url;
			window.close();
		}
		/*****************业务数据页面跳转end*********/
	}
</script>
</html>
