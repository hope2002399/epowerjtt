<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="suppower.list.title" /></title>
</head>

<body>
	<%@ include file="/page/common/messages.jsp"%>
	<div class="search">
			<div class="crumbs">
				权力列表
			</div>

		<s:form action="supPower" namespace="/powerbase"	style="margin-top:0;margin-bottom:5">
			<table cellpadding="0" cellspacing="0" align="center">
			<% if (request.getParameter("s_orgId") == null) { %>
				<input type="hidden" name="s_orgId" value="${session.SPRING_SECURITY_CONTEXT.authentication.principal.primaryUnit}">
			<% } else { %>
				<input type="hidden" name="s_orgId" value="${param.s_orgId}">
			<% } %>
			<input type="hidden" name="s_itemType" value="${param.s_itemType}">
			<input type="hidden" name="s_queryUnderUnit" value="${param.s_queryUnderUnit}">
				<tr>
					<td class="addTd">权力编号：</td>
					<td>
					<s:textfield name="s_itemId" style="width:180px" value="%{#parameters['s_itemId']}" /></td>
				</tr>		
				<tr>
					<td class="addTd">权力名称：</td>
					<td>
					<s:textfield name="s_itemName" style="width:180px" value="%{#parameters['s_itemName']}" /></td>
				</tr>

				<tr>
					<td align="center" colspan="2">
					<s:submit method="listSupPower" key="opt.btn.query" cssClass="btn" /> 
					<input type="button" class="btn" value="关闭" onclick="window.close();">
					</td>
				</tr>
			</table>
		</s:form>
	</div>

	<ec:table action="${pageContext.request.contextPath}/powerbase/supPower!listSupPower.do" items="selectPowerList" var="suppower"
		imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif"
		retrieveRowsCallback="limit">
		
		<input type="hidden" id="itemId${suppower.itemId}" name="itemId${suppower.itemId}" value="${suppower.itemId}">
		<input type="hidden" id="itemName${suppower.itemId}" name="itemName${suppower.itemId}" value="${suppower.itemName}">
		<input type="hidden" id="orgId${suppower.itemId}" name="orgId${suppower.itemId}" value="${suppower.orgId}">
		<input type="hidden" id="applyItemType${suppower.itemId}" name="applyItemType${suppower.itemId}" value="${suppower.applyItemType}">
		<input type="hidden" id="orgName${suppower.itemId}" name="orgName${suppower.itemId}" value='${cp:MAPVALUE("unitcode",suppower.orgId)}'>
		<input type="hidden" id="groupId${suppower.itemId}" name="groupId${suppower.itemId}" value='${suppower.groupId}'>
		<input type="hidden" id="riskType${suppower.itemId}"	name="riskType${suppower.itemId}" value='${suppower.riskType}'>
		<input type="hidden" id="riskTypes${suppower.itemId}"	name="riskTypes${suppower.itemId}" value='${cp:MAPVALUE("RISKTYPE",suppower.riskType)}'>
		<input type="hidden" id="riskDesc${suppower.itemId}"	name="riskDesc${suppower.itemId}" value='${suppower.riskDesc}'>
		<input type="hidden" id="riskResults${suppower.itemId}"	name="riskResults${suppower.itemId}" value='${suppower.riskResult}'>
		<ec:row>
			<%-- <ec:column property="itemId" title="权力编号"	style="text-align:center" sortable="false"/>
 --%>
			<ec:column property="itemName" title="权力名称"	style="text-align:center" sortable="false">	
				<c:choose>
					<c:when test="${fn:length(suppower.itemName) > 30}">
						<c:out value="${fn:substring(suppower.itemName, 0, 30)}..." />
					</c:when>
					<c:otherwise>
						<c:out value="${suppower.itemName}" />
					</c:otherwise>
				</c:choose>
			</ec:column>
			<ec:column property="opt" title="操作" sortable="false"
				style="text-align:center">
				<input type="radio" name="itemId"
					onclick="setParentVal('${suppower.itemId}')">
			</ec:column>
		</ec:row>
	</ec:table>

</body>
<script type="text/javascript">	
	var parentDocument = window.opener.document;//获取父页面对象
	var templetJsp = null;
	var templetId = null;
	//设置返回值
	function setParentVal(itemId) {
		//alert("itemId="+itemId);
		if (window.confirm("确认选择此项权力吗？选择后窗口将自动关闭。")) {
				parentDocument.getElementById('powername').value = document.getElementById('itemName' + itemId).value;
				parentDocument.getElementById('powerid').value = document.getElementById('itemId' + itemId).value;

				if (parentDocument.getElementById('orgcode')){
					parentDocument.getElementById('orgcode').value = document.getElementById('orgId' + itemId).value;
					//alert(document.getElementById('orgId' + itemId).value);
				}
				if (parentDocument.getElementById('orgname')) {
					parentDocument.getElementById('orgname').value = document.getElementById('orgName' + itemId).value;
					//alert(document.getElementById('orgName' + itemId).value);
				}
				/*
				parentDocument.getElementById('groupId').value = document.getElementById('groupId' + itemId).value;				
				parentDocument.getElementById('riskType').value = document.getElementById('riskType' + itemId).value;
				parentDocument.getElementById('riskDesc').value = document.getElementById('riskDesc' + itemId).value;
				parentDocument.getElementById('riskTypes').value = document.getElementById('riskTypes' + itemId).value;//转化成风险类别名称
				parentDocument.getElementById('riskDescs').value = document.getElementById('riskDesc' + itemId).value;
				parentDocument.getElementById('riskResults').value = document.getElementById('riskResults' + itemId).value;				
				*/
				/*************************根据itemID查询POWER_OPT_INFO***************/	
				if (parentDocument.getElementById('djId'))
					var djid=parentDocument.getElementById('djId').value;
				var orgname =  document.getElementById('orgName' + itemId).value;
				$.ajax({
					type:"POST",
					url: "<%=request.getContextPath()%>/powerruntime/powerOptInfo!getGroupIDByItemid.do?itemId="+itemId,
					contentType:"text/html",					
					dataType:"json",
					processData:false,
					async: false,
					success:function(data){
						/* templetJsp = data.templetJsp;
						templetId = data.templetId; */
						//alert(data.groupidByitemid);
						//3200000000000140008100110011500001
						if (data.groupidByitemid == 'F')
							return;
						
						var obj=parentDocument.getElementById('slfieldset');
						obj.style.display="block";
						if(data.groupidByitemid != ''){
							var url2='<%=request.getContextPath()%>/powerruntime/generalOperator!gotosqcl.do?stuffInfo.djId='+djid+'&stuffInfo.nodeInstId=0&stuffInfo.groupid='+data.groupidByitemid;
						}else{
							var url2='<%=request.getContextPath()%>/powerruntime/generalOperator!gotosqcl.do?stuffInfo.djId='+djid+'&stuffInfo.nodeInstId=0&outItemId=3200000000000140008100110011500001';
						}
						
						var objfram=parentDocument.getElementById('basicsj');
						objfram.src = url2;
						//alert(window.opener.frames['sjfj'].document.body.scrollHeight);
						//objfram.onload = function(){
							//objfram.height = window.opener.frames['sjfj'].document.body.scrollHeight;
						//};
					},
					error:function(){
						alert("系统提交失败");
					}			
				});
				var type = document.getElementById('s_itemType').value;
				/* 父页面初始化参数 */
				//window.opener.location.href="${pageContext.request.contextPath}/powerruntime/optApply!edit.do?itemId="+itemId+"&itemType="+type+"&optId=HDJXZXK1&orgId="+${session.SPRING_SECURITY_CONTEXT.authentication.principal.primaryUnit};
				/* parent.$("#4thEditTable").load(window.parent.location.href="${pageContext.request.contextPath}/powerruntime/optApply!edit.do?itemId="+itemId+"&itemType="+type+"optId=HDJXZXK1"); */
				/*****************业务数据页面跳转begin*********/
				window.opener.document.getElementById('itemId').value=itemId;
				if(window.opener.document.getElementById('resultID')){
					//alert($("#riskType" + itemId).val());
					if($("#riskType" + itemId).val() !=''){//如果已经关联了风险点，则显示风险点信息
						window.opener.document.getElementById('resultID').style.display = 'block';
						window.opener.document.getElementById('riskDescID').style.display = 'block';
						window.opener.document.getElementById('riskTypeID').style.display ='block';
					}else{
						window.opener.document.getElementById('resultID').style.display = 'none';
						window.opener.document.getElementById('riskDescID').style.display = 'none';
						window.opener.document.getElementById('riskTypeID').style.display = 'none';
					}
				}
				//itemFrameObj.reload();
				window.close();
		}
		/*****************业务数据页面跳转end*********/
	}
</script>
</html>
