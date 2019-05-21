<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>

<html>
<head>
<title>事项新增</title>

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
			事项新增
		</legend>
			<s:form action="bpowerItem" namespace="/poweritem" style="margin-top:0;margin-bottom:5">
				<s:submit method="saveBpowerItem"  key="opt.btn.save" cssClass="btn" onclick="return checkInput();"/>
				<input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" />
				<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
				<!-- 拆分子项处理 -->
				<c:if test="${type eq 'cfzx' }">
				<tr>
						<td class="addTd"><span style="color: red">*</span>主项编码</td>
						<td align="left" colspan="3"><input type="text" name="parentId" id="parentId" value="${object.itemId }" readonly style="width:360px"/></td>
						
					</tr>
				<tr>
						<td class="addTd"><span style="color: red">*</span>主项名称</td>
						<td align="left" colspan="3">
						<input type="text" name="parentName" id="parentName" value="${object.itemName }" readonly style="width:360px"/>
						</td>
					
					</tr>
				</c:if>
				<tr>
						<td class="addTd"><span style="color: red">*</span>事项编码</td>
						<td align="left" colspan="3"><input type="text" name="itemId" id="itemId" value="" style="width:360px" onchange="checkitemid();"/></td>
						
					</tr>
				<tr>
						<td class="addTd"><span style="color: red">*</span>事项名称</td>
						<td align="left" colspan="3">
						<input type="text" name="itemName" id="itemName" value="" style="width:360px"/>
						<input name="itemStatus" type="hidden" value="2" />
						</td>
					
					</tr>
				<!-- 拆分子项处理 -->
				<c:if test="${type eq 'cfzx' }">
					<tr>
						
					<td class="addTd"><span style="color: red">*</span>事项类型</td>
				<td align="left"  colspan="3">
					<select name="itemType" id="itemType" style="width: 180px" onchange="changeItemType();">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('ITEM_TYPE_NEW')}">
								<option value="${row.key}" <c:if test="${object.itemType eq row.key}"> selected = "selected" </c:if> > 
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select>
				</td>
					</tr>
				</c:if>
				<!-- 新增主项处理 -->
				<c:if test="${type ne 'cfzx' }">
					<tr>
						<td class="addTd">是否包含子项</td>
						<td align="left" >
							<select name="isContainSub" id="isContainSub" style="width: 180px" onchange="changeItemType();">
								<option value="1">
									是
								</option>
								<option value="2">
									否
								</option>
							
					</select>
						</td>
					<td class="addTd"><span style="color: red">*</span>事项类型</td>
				<td align="left" >
					<select name="itemType" id="itemType" style="width: 180px" onchange="changeItemType();">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('ITEM_TYPE_NEW')}">
								<option value="${row.key}"> 
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select>
				</td>
					</tr>
			</c:if>
			<tr>
				<td class="addTd"><span style="color: red">*</span>所属单位</td>
				<td align="left" >
					<input type="text" id="orgName" name="orgName"  value="${cp:MAPVALUE('depno',object.orgId)}" style="width: 180px" />
					<input type="hidden" id="orgId" name="orgId" value="${object.orgId }"/>
				</td>
				<td class="addTd">网上公示</td>
				<td align="left" >
				
				<select name="isNetwork" id="isNetwork" style="width: 180px">
								<option value="1" <c:if test="${object.isNetwork eq '1'}"> selected = "selected" </c:if> >
									是
								</option>
								<option value="2" <c:if test="${object.isNetwork eq '2'}"> selected = "selected" </c:if> >
									否
								</option>
				</select>
				</td>
			</tr>
		
			<tr>
				<td class="addTd">审批对象</td>
				<td align="left" >
				<input type="text" id="spObject" name="spObject"  value="${object.spObject }" style="width: 180px"/>
				</td>
				<td class="addTd">行使层级</td>
				<td align="left" >
					<input type="text" id="useLevel" name="useLevel"  value="${object.useLevel }" style="width: 180px"/>
				</td>
			</tr>
			<tr>
				<td class="addTd"><span style="color: red">*</span>办理处室</td>
				<td align="left" >
				<input type="text" id="useUnit" name="useUnit"  value="${object.useUnit }" style="width: 180px"/>
				</td>
				<td class="addTd"><span style="color: red">*</span>办理地点</td>
				<td align="left" >
				<input type="text" id="dealAddress" name="dealAddress"  value="${object.dealAddress }" style="width: 180px"/>
				</td>
			</tr>
			<tr>
				<td class="addTd"><span style="color: red">*</span>联系电话</td>
				<td align="left" >
					<input type="text" id="linkPhone" name="linkPhone" value="${object.linkPhone }"  style="width: 180px"/>
				</td>
				<td class="addTd"><span style="color: red">*</span>监督电话</td>
				<td align="left" >
				<input type="text" id="monitorPhone" name="monitorPhone"  value="${object.monitorPhone }" style="width: 180px"/>
				</td>
			</tr>
		
			<tr>
				<td class="addTd">网上链接</td>
				<td align="left" >
				<input type="text" id="httpUrl" name="httpUrl" value="${object.httpUrl }" style="width: 180px"/>
				</td>
				<td class="addTd">办理时间</td>
				<td align="left" >
				<input type="text" id="dealTime" name="dealTime"  value="${object.dealTime }" style="width: 180px"/>
				</td>
			</tr>
				<tr id="qldy">
						<td class="addTd"><!-- <span style="color: red">*</span> -->对应原权力表编码</td>
						<td align="left" colspan="3">
						<input type="text" name="itemQldyItemId" id="itemQldyItemId" readonly value="${object.itemQldyItemId }" style="width:360px"/>
						<%-- <input
					type="button" class='btn' name="powerBtn"
					onClick="openNewWindow('<%=request.getContextPath()%>/powerbase/supPower!listSupPowerForPowerItemQldy.do?s_itemType=${itemType}&s_orgId=${session.SPRING_SECURITY_CONTEXT.authentication.principal.primaryUnit}','powerWindow',null);"
					value="选择"> --%>
					<input
					type="button" class='btn' name="powerBtn"
					onClick="openPowerList();"
					value="选择">
						</td>
					
				</tr>
	
			<tr>
				<td class="addTd">设定依据</td>
				<td align="left"  colspan="3">
				<textarea rows="2" cols="40" style="width:100%;height:40px;" name="lawAccording"  >${object.lawAccording }</textarea>
				
				</td>

			</tr>
			<tr>
				<td class="addTd">备注</td>
				<td align="left"  colspan="3">
				<textarea rows="2" cols="40" style="width:100%;height:40px;" name="remark">${object.remark }</textarea></td>

			</tr>
			</table>
	</s:form>
	</fieldset>
<script type="text/javascript">

	 var menuList = ${unitsJson};
		function bindEvent(o1,o2,$this){
			o1.val($this.html());
			var key = $this.attr("rel");
			for (var i=0; i<menuList.length; i++) {
				if (key == menuList[i].MID) {
					o2.val(menuList[i].depno);
				}
			}
			if(getID("shadow")){
				$("#shadow").hide();
				$("#boxContent").hide();
			}
		}
$("#orgName").bind('click',function(){
	var menuList = ${unitsJson};
	var shadow = "<div id='shadow'></div><div id='boxContent'><div class='listShadow'></div><div id='lists' class='getTree'>Loader</div><div id='close'>×</div></div>";
	if(getID("shadow")){
		$("#shadow").show();
		$("#boxContent").show();
	}else{
		$("body").append(shadow);
		$("#shadow").height(document.body.scrollHeight);
		setTimeout(function(){
			menuDisplay(menuList,"${parentunit}");	
		},0);
	};
	$("#lists span").live('click',function(){
		var $this = $(this);
		bindEvent($("#orgName"),$("#orgId"),$this);
		$("#lists span").die("click");
	});
});

function checkInput(){
	
	if($("#itemId").val()==''){
		alert("事项编码不可为空");
		return false;
	}
	if(! (/^\d{32}$/.test($("#itemId").val())) ){
		alert("事项编码不正确");
		return false;
	}
	if($("#itemName").val()==''){
		alert("事项名称不可为空");
		return false;
	}
	if($("#itemType").val()==''){
		alert("事项类型不可为空");
		return false;
	}
	if($("#orgId").val()==''){
		alert("所属单位不可为空");
		return false;
	}
	if($("#useUnit").val()==''){
		alert("办理处室不可为空");
		return false;
	}
	if($("#dealAddress").val()==''){
		alert("办理地点不可为空");
		return false;
	}
	if($("#linkPhone").val()==''){
		alert("联系电话不可为空");
		return false;
	}
	if($("#monitorPhone").val()==''){
		alert("监督电话不可为空");
		return false;
	}
	if($("#itemQldyItemId")){
		if($("#itemQldyItemId").val()!=''){
			return checkqldyitemid();
		}
	}
	return true;
}
function checkitemid(){
	var itemId=$("#itemId").val();
	if($("#itemId").val()==''){
		alert("事项编码不可为空");
		return false;
	}
	if(! (/^\d{32}$/.test($("#itemId").val())) ){
		alert("事项编码不正确");
		$("#itemId").val('');
		$("#itemId").focus();
		return false;
	}
	$.ajax({
		type:"POST",
		url: "<%=request.getContextPath()%>/poweritem/bpowerItem!checkItemId.do?type=${type}&itemId="+itemId,
		contentType:"text/html",					
		dataType:"json",
		processData:false,
		async: false,
		success:function(data){
			if (data.message == 'USED'){
				alert("该编码已使用");
				$("#itemId").val('');
				$("#itemId").focus();
				return;
			}
			if (data.message == 'ERROR'){
				alert("该编码不正确");
				$("#itemId").val('');
				$("#itemId").focus();
				return;
			}
			if (data.message == 'UNUSE'){
				alert("该编码可以使用");
				return;
			}
				
			
		},
		error:function(){
			alert("验证事项编码失败");
		}			
	});
}
function changeItemType(){
	if($("#itemType").val()=='01'||$("#itemType").val()==''){
		$("#itemQldyItemId").attr("disabled","disabled");
		$("#qldy").hide();
	}else{
		if($("#isContainSub").length>0){
			if($("#isContainSub").val()=='2'){
				$("#itemQldyItemId").removeAttr("disabled");
				$("#qldy").show();
			}else{
				$("#itemQldyItemId").attr("disabled","disabled");
				$("#qldy").hide();
			}
		}else{
			$("#itemQldyItemId").removeAttr("disabled");
			$("#qldy").show();
		}
	}
}
changeItemType();
function openPowerList(){
	var itemType=$("#itemType").val();
	if(itemType=='01'){
		itemType='XK';
	}else if(itemType=='02'){
		itemType='CF';
	}else if(itemType=='03'){
		itemType='QZ';
	}else if(itemType=='04'){
		itemType='ZS';
	}else if(itemType=='05'){
		itemType='GF';
	}else if(itemType=='06'){
		itemType='JL';
	}else if(itemType=='07'){
		itemType='QR';
	}else if(itemType=='08'){
		itemType='CJ';
	}else if(itemType=='09'){
		itemType='ZY';
	}else if(itemType=='10'){
		itemType='QT';
	}
	openNewWindow('<%=request.getContextPath()%>/powerbase/supPower!listSupPowerForPowerItemQldy.do?s_itemType='+itemType,'powerWindow',null);
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
