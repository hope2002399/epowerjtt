<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>

<html>
	<head>
		<title>
			审批业务列表
		</title>
		<script
	src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js"
	type="text/javascript"></script>
<link
	href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css"
	rel="stylesheet" type="text/css" />
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<div class="search">
			<div class="crumbs">
				 审批业务列表
			</div>
			
			<s:form action="bpowerItem" namespace="/poweritem" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

				<!-- 有主项处理 -->
				<c:if test="${! (empty object.parentId) }">
				<tr>
						<td class="addTd"><span style="color: red">*</span>主项编码</td>
						<td align="left" colspan="3"><input type="text" name="itemMainId" id="itemMainId" value="${object.parentId }" readonly style="width:360px"/></td>
						
					</tr>
				<tr>
						<td class="addTd"><span style="color: red">*</span>主项名称</td>
						<td align="left" colspan="3">
						<input type="text" name="itemMainName" id="itemMainName" value="${object.parentName }" readonly style="width:360px"/>
						</td>
					
					</tr>
					<tr>
						<td class="addTd"><span style="color: red">*</span>子项编码</td>
						<td align="left" colspan="3"><input type="text" name="itemSubId" id="itemSubId" value="${object.itemId }" readonly style="width:360px"/></td>
						
					</tr>
				<tr>
						<td class="addTd"><span style="color: red">*</span>子项名称</td>
						<td align="left" colspan="3">
						<input type="text" name="itemSubName" id="itemSubName" value="${object.itemName }" readonly style="width:360px"/>
						</td>
					
					</tr>
				</c:if>
				
				
				<!-- 无主项处理 -->
				<c:if test="${(empty object.parentId) }">
					<tr>
						<td class="addTd"><span style="color: red">*</span>主项编码</td>
						<td align="left" colspan="3"><input type="text" name="itemMainId" id="itemMainId" value="${object.itemId }" readonly style="width:360px"/></td>
						
					</tr>
				<tr>
						<td class="addTd"><span style="color: red">*</span>主项名称</td>
						<td align="left" colspan="3">
						<input type="text" name="itemMainName" id="itemMainName" value="${object.itemName }" readonly style="width:360px"/>
						</td>
					
					</tr>
					<tr>
						<td class="addTd"><span style="color: red">*</span>子项编码</td>
						<td align="left" colspan="3"><input type="text" name="itemSubId" id="itemSubId" value="${object.itemId }" readonly style="width:360px"/></td>
						
					</tr>
				<tr>
						<td class="addTd"><span style="color: red">*</span>子项名称</td>
						<td align="left" colspan="3">
						<input type="text" name="itemSubName" id="itemSubName" value="${object.itemName }" readonly style="width:360px"/>
						</td>
					
					</tr>
			</c:if>
			<tr>
						<td class="addTd">&nbsp;</td>
						<td align="left" colspan="3">
						<input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" />
						</td>
					
					</tr>
				</table>
			</s:form>
		</div>

		<ec:table action="poweritem/bpowerItem!listBpowerItemQldy.do" items="list" var="qldy"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="rowCount" title="序号" style="text-align:center" cell="rowCount"/>

				<ec:column property="serviceId" title="业务编码" style="text-align:center" width="15%"/>

				<ec:column property="serviceName" title="业务名称" style="text-align:center" width="30%"/>

			
				
				<ec:column property="status" title="业务状态" style="text-align:center" width="15%">
					${cp:MAPVALUE("ITEM_STATUS_NEW",qldy.status)}
				</ec:column>
				
				
	
				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">
					<a href='<%=request.getContextPath()%>/poweritem/bpowerItem!viewBpowerItemQldy.do?serviceId=${qldy.serviceId}'>查看</a>
					<c:if test="${ qldy.status ne '4' }">
						&nbsp;&nbsp;<a href='<%=request.getContextPath()%>/poweritem/bpowerItem!editBpowerItemQldy.do?type=list&serviceId=${qldy.serviceId}'>修改</a> 
						&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/poweritem/bpowerItem!deleteBpowerItemQldy.do?type=list&serviceId=${qldy.serviceId}">删除</a>
					</c:if>
				</ec:column>
			</ec:row>
		</ec:table>
<script type="text/javascript">

	</script>
	</body>
</html>
