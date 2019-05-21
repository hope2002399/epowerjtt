<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>

<html>
<head>
<title>业务拆分</title>

<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
		<sj:head locale="zh_CN" />
		<script src="${pageContext.request.contextPath}/scripts/suggest.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/themes/css/alertDiv.css" rel="stylesheet" type="text/css" />

</head>

<body >

	<%@ include file="/page/common/messages.jsp"%>
	<fieldset style="padding: 10px;">
		<legend class="ctitle" style="width: auto; margin-bottom: 5px;">
			业务拆分
		</legend>
			<s:form action="bpowerItem" namespace="/poweritem" style="margin-top:0;margin-bottom:5">
				<s:submit method="saveBpowerItemQldy"  key="opt.btn.save" cssClass="btn" onclick="return checkInput();"/>
				<input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" />
				<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
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
						<td class="addTd"><span style="color: red">*</span>业务编码</td>
						<td align="left" colspan="3"><input type="text" name="serviceId" id="serviceId" value="${qldy.serviceId }"  onchange="checkserviceid();" style="width:360px"/></td>
						
					</tr>
				<tr>
						<td class="addTd"><span style="color: red">*</span>业务名称</td>
						<td align="left" colspan="3">
						<input type="text" name="serviceName" id="serviceName" value="${qldy.serviceName }"  style="width:360px"/>
						<input name="status" type="hidden" value="2" />
						<input name="type" type="hidden" value="${type }" />
						</td>
					
					</tr>
					<tr>
						<td class="addTd"><!-- <span style="color: red">*</span> -->对应原权力表编码</td>
						<td align="left" colspan="3">
						<input type="text" name="itemQldyItemId" id="itemQldyItemId" readonly value="${qldy.itemQldyItemId }" onchange="checkqldyitemid();" style="width:360px"/>
						<%-- <input
					type="button" class='btn' name="powerBtn"
					onClick="openNewWindow('<%=request.getContextPath()%>/powerbase/supPower!listSupPowerForPowerItemQldy.do?s_itemType=${itemType}&s_orgId=${session.SPRING_SECURITY_CONTEXT.authentication.principal.primaryUnit}','powerWindow',null);"
					value="选择"> --%>
					<input
					type="button" class='btn' name="powerBtn"
					onClick="openNewWindow('<%=request.getContextPath()%>/powerbase/supPower!listSupPowerForPowerItemQldy.do?s_itemType=${itemType}','powerWindow',null);"
					value="选择">
						</td>
					
					</tr>
			</table>
	</s:form>
	</fieldset>
<script type="text/javascript">



function checkInput(){
	
	if($("#serviceId").val()==''){
		alert("业务编码不可为空");
		return false;
	}
	if(! (/^\d{34}$/.test($("#serviceId").val())) ){
		alert("业务编码不正确");
		return false;
	}
	if($("#serviceName").val()==''){
		alert("业务名称不可为空");
		return false;
	}
	if($("#itemQldyItemId").val()!=''){
		return checkqldyitemid();
	}
	
	return true;
}
function checkserviceid(){
	var serviceId=$("#serviceId").val();
	if($("#serviceId").val()==''){
		alert("业务编码不可为空");
		return false;
	}
	if(! (/^\d{34}$/.test($("#serviceId").val())) ){
		alert("业务编码应为34位数字编码");
		$("#serviceId").val('');
		$("#serviceId").focus();
		return false;
	}
	 if(!(serviceId.indexOf($("#itemSubId").val())>=0)){
		alert("业务编码应包含子项的编码");
		$("#serviceId").val('');
		$("#serviceId").focus();
		return false;
	} 
	$.ajax({
		type:"POST",
		url: "<%=request.getContextPath()%>/poweritem/bpowerItem!checkServiceId.do?serviceId="+serviceId,
		contentType:"text/html",					
		dataType:"json",
		processData:false,
		async: false,
		success:function(data){
			if (data.message == 'USED'){
				alert("该编码已使用");
				$("#serviceId").val('');
				$("#serviceId").focus();
				return;
			}
			
			if (data.message == 'UNUSE'){
				alert("该编码可以使用");
				return;
			}
				
			
		},
		error:function(){
			alert("验证业务编码失败");
		}			
	});
}
function checkqldyitemid(){
	var itemQldyItemId=$("#itemQldyItemId").val();
	var b=true;
	
	$.ajax({
		type:"POST",
		url: "<%=request.getContextPath()%>/poweritem/bpowerItem!checkItemQldyItemId.do?itemQldyItemId="+itemQldyItemId,
		contentType:"text/html",					
		dataType:"json",
		processData:false,
		async: false,
		success:function(data){
			if (data.message == 'USED'){
				alert("该编码已对应");
				$("#itemQldyItemId").val('');
				$("#itemQldyItemId").focus();
				b=false;
			}
			
			if (data.message == 'UNUSE'){
				alert("该编码可以对应");
				//return true;
			}
				
			
		},
		error:function(){
			alert("验证编码失败");
			b= false;
		}			
	});
	return b;
}
	</script>
</body>
</html>
