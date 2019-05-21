<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>

<html>
<head>
<title>业务修改</title>

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
			业务修改
		</legend>
			<s:form action="bpowerItem" namespace="/poweritem" style="margin-top:0;margin-bottom:5">
				<input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" />
				<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
				
				<tr>
						<td class="addTd"><span style="color: red">*</span>主项编码</td>
						<td align="left" colspan="3">${qldy.itemMainId }"</td>
						
					</tr>
				<tr>
						<td class="addTd"><span style="color: red">*</span>主项名称</td>
						<td align="left" colspan="3">
						${qldy.itemMainName }
						</td>
					
					</tr>
					<tr>
						<td class="addTd"><span style="color: red">*</span>子项编码</td>
						<td align="left" colspan="3">${qldy.itemSubId }</td>
						
					</tr>
				<tr>
						<td class="addTd"><span style="color: red">*</span>子项名称</td>
						<td align="left" colspan="3">
						${qldy.itemSubName }
						</td>
					
					</tr>
			
				
				
				
				<tr>
						<td class="addTd"><span style="color: red">*</span>业务编码</td>
						<td align="left" colspan="3">${qldy.serviceId }</td>
						
					</tr>
				<tr>
						<td class="addTd"><span style="color: red">*</span>业务名称</td>
						<td align="left" colspan="3">
						${qldy.serviceName }
						<input name="status" type="hidden" value="2" />
						</td>
					
					</tr>
					<tr>
						<td class="addTd"><!-- <span style="color: red">*</span> -->对应原权力表编码</td>
						<td align="left" colspan="3">
						${qldy.itemQldyItemId }
						<c:if test="${ qldy.status ne '4' }">
						<c:if test="${!(empty qldy.itemQldyItemId)  }">
						<input type="button" class="btn" value="权力变更申请" onclick="qlbgsq('${qldy.itemQldyItemId }');" />
						</c:if>
						</c:if>
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
	/* if(!(serviceId.indexOf($("#itemSubId").val())>=0)){
		alert("业务编码应包含子项的编码");
		$("#serviceId").val('');
		$("#serviceId").focus();
		return false;
	} */
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
function qlbgsq(itemId){
	window.location.href="<%=request.getContextPath()%>/powerbase/supPower!listSupPowerSQ.do?s_itemId="+itemId;
}
	</script>
</body>
</html>
