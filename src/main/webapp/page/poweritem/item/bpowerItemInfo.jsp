<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>

<html>
<head>
<title>执法案例查看</title>
</head>

<body >

	<%@ include file="/page/common/messages.jsp"%>
	<fieldset style="padding: 10px;">
		<legend class="ctitle" style="width: auto; margin-bottom: 5px;">
			事项查看
		</legend>
			
			<input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" />
				<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
		
		<c:if test="${!empty object.parentId }">
					<tr>
						<td class="addTd">主项编码</td>
						<td align="left" colspan="3">${object.parentId }</td>
						
					</tr>
				<tr>
						<td class="addTd">主项名称</td>
						<td align="left" colspan="3">${object.parentName }</td>
					
					</tr>
				
			</c:if>
				<tr>
						<td class="addTd">事项编码</td>
						<td align="left" colspan="3">${object.itemId }</td>
						
					</tr>
				<tr>
						<td class="addTd">事项名称</td>
						<td align="left" colspan="3">${object.itemName }</td></td>
					
					</tr>
					<c:if test="${!empty object.isContainSub}">
					<tr>
						<td class="addTd">是否包含子项</td>
						<td align="left" colspan="3">
							<c:if test="${object.isContainSub eq '1' }">是</c:if>
							<c:if test="${object.isContainSub eq '2' }">否</c:if>
						</td>
					
					</tr>
					</c:if>
			<tr>
				<td class="addTd">所属单位</td>
				<td align="left" >${cp:MAPVALUE("depno",object.orgId)}</td>
				<td class="addTd">网上公示</td>
				<td align="left" >
				<c:if test="${object.isNetwork eq '1' }">是</c:if>
				<c:if test="${object.isNetwork eq '2' }">否</c:if>
				</td>
			</tr>
			<tr>
				<td class="addTd">事项类型</td>
				<td align="left" >${cp:MAPVALUE("ITEM_TYPE_NEW",object.itemType)}</td>
				<td class="addTd">事项状态</td>
				<td align="left" >${cp:MAPVALUE("ITEM_STATUS_NEW",object.itemStatus)}</td>
			</tr>
			<tr>
				<td class="addTd">审批对象</td>
				<td align="left" >${object.spObject }</td>
				<td class="addTd">行使层级</td>
				<td align="left" >${object.useLevel }</td>
			</tr>
			<tr>
				<td class="addTd">办理处室</td>
				<td align="left" >${object.useUnit }</td>
				<td class="addTd">办理地点</td>
				<td align="left" >${object.dealAddress }</td>
			</tr>
			
			<tr>
				<td class="addTd">联系电话</td>
				<td align="left" >${object.linkPhone }</td>
				<td class="addTd">监督电话</td>
				<td align="left" >${object.monitorPhone }</td>
			</tr>
			<tr>
				<td class="addTd">网上链接</td>
				<td align="left" >${object.httpUrl }</td>
				<td class="addTd">办理时间</td>
				<td align="left" >${object.dealTime }</td>
			</tr>
			<tr>
				<td class="addTd">创建时间</td>
				<td><fmt:formatDate value="${object.createTime }" type="both"/></td>
				<td class="addTd">最后修改时间</td>
				<td align="left" ><fmt:formatDate value="${object.modifyTime }" type="both"/></td>
			</tr>
			
			<c:if test="${empty object.itemQldyItemId  }">
				<c:if test="${(!empty object.isContainSub and object.isContainSub eq '2') or (empty object.isContainSub)}">
				<tr>
				<td colspan="4">
				<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
				<tr><td colspan="4" align="center">审批服务业务列表</td></tr>
				
				<c:if test="${!empty ywlist  }">
				
					<c:forEach var="bpowerqldy" items="${ywlist }"
							varStatus="bpowerqldyStatus" >
						<tr>
							
							<td align="center" style="width:25%;">${bpowerqldy.serviceId }</td>
							<td align="center" >${bpowerqldy.serviceName }</td>
							<td align="center" >${cp:MAPVALUE("ITEM_STATUS_NEW",bpowerqldy.status)}</td>
							<td align="center" >
							<a href='<%=request.getContextPath()%>/poweritem/bpowerItem!viewBpowerItemQldy.do?serviceId=${bpowerqldy.serviceId}'>查看</a>
							<c:if test="${bpowerqldy.status ne '4' }">
							&nbsp;&nbsp;<a href='<%=request.getContextPath()%>/poweritem/bpowerItem!editBpowerItemQldy.do?serviceId=${bpowerqldy.serviceId}'>修改</a> 
							&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/poweritem/bpowerItem!deleteBpowerItemQldy.do?serviceId=${bpowerqldy.serviceId}">删除</a>
							</c:if></td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${object.itemStatus ne '4'  }">
				<tr><td colspan="4" align="center"><input type="button" class="btn" value="添加业务项" onclick="cfspyw('${object.itemId}');"/></td></tr>
				</c:if>
				</table>
				
				</td>
				</tr>
				</c:if>
				<c:if test="${(!empty object.isContainSub and object.isContainSub eq '1')}">
				<tr>
				<td colspan="4">
				<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
				<tr><td colspan="3" align="center">子项事项列表</td></tr>
				<c:if test="${!empty sublist  }">
				
					<c:forEach var="bpower" items="${sublist }"
							varStatus="bpowerStatus" >
						<tr>
							
							<td align="center" style="width:33%;">${bpower.itemId }</td>
							<td align="center" >${bpower.itemName }</td>
							<td align="center" >${cp:MAPVALUE("ITEM_STATUS_NEW",bpower.itemStatus)}</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${object.itemStatus ne '4'  }">
				<tr><td colspan="3" align="center"><input type="button" class="btn" value="添加子项" onclick="cfzx('${object.itemId}');"/></td></tr>
				</c:if>
				</table>
				
				</td>
				</tr>
				</c:if>
			</c:if>
			<c:if test="${!(empty object.itemQldyItemId)  }">
				<tr>
							<td class="addTd"><!-- <span style="color: red">*</span> -->对应原权力表编码</td>
							<td align="left" colspan="3">
							${object.itemQldyItemId }
							<c:if test="${ object.itemStatus ne '4' }">
							<c:if test="${!(empty object.itemQldyItemId)  }">
							<input type="button" class="btn" value="权力变更申请" onclick="qlbgsq('${object.itemQldyItemId }');" />
							</c:if>
							</c:if>
							</td>
						
				</tr>
			</c:if>
			<tr>
				<td class="addTd">设定依据</td>
				<td align="left"  colspan="3">${object.lawAccording }</td>

			</tr>
			<tr>
				<td class="addTd">备注</td>
				<td align="left"  colspan="3">${object.remark }</td>

			</tr>
			</table>
	
	</fieldset>
<script type="text/javascript">
function cfzx(itemId){
	window.location.href="<%=request.getContextPath()%>/poweritem/bpowerItem!addBpowerItem.do?type=cfzx&itemId="+itemId;
}
function cfspyw(itemId){
	//window.location.href="<%=request.getContextPath()%>/poweritem/bpowerItemService!SuppowerQlbgSqXz.do?itemId="+itemId;
	window.location.href="<%=request.getContextPath()%>/poweritem/bpowerItem!addBpowerItemQldy.do?itemSubId="+itemId;
}
function qlbgsq(itemId){
	window.location.href="<%=request.getContextPath()%>/powerbase/supPower!listSupPowerSQ.do?s_itemId="+itemId;
}
</script>
</body>
</html>
