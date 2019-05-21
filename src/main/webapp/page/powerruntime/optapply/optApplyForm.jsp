<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<meta name="decorator" content='${LAYOUT}'/>
<title><s:text name="srPermitApply.edit.title" /></title>
<sj:head locale="zh_CN" />
<script src="${pageContext.request.contextPath}/scripts/suggest.js" type="text/javascript"></script>
<script type="text/javascript">
	function openTemplate(val){
		if(val  == '' || val == null){
			return;
		}
		var curTemplateId = document.getElementById("curTemplateId").value;
		if (curTemplateId != "" && curTemplateId != null) {
			if(window.confirm("重新选择模板会生成新的文件，已保存的内容将被覆盖，是否确定？")){
				openDocEdit(val);
			}
		}else{
			openDocEdit(val);
		}
	}

	function submitItemFrame(subType){
		if(docheck()){
		/*
		//保存业务数据
		var itemType  = document.getElementById("applyItemType").value;
		
		if(itemType != null && itemType != ''){
			var frmObj = window.frames['itemFrame'];
			frmObj.document.forms[0].submit();
			
		}
		*/$
		.getJSON(
				"${pageContext.request.contextPath}/powerruntime/optApply!check.do?callback=?",
				{
					transAffairNo : $("#transAffairNo").val(),
					djId : '${object.djId}'
				},
				function(data) {
					if (data.result == "OK") {
						if (data.Flag == "true") {
							alert("此办件编号"
									+ $("#transAffairNo").val()
									+ "已经存在,请确认！");
							$("#transAffairNo")
									.val(
											'${object.optBaseInfo.transAffairNo}');
							$("#transAffairNo")
									.focus();
						}else{
							saveAndSubmits(subType);
						}
					}
				});
		}
	}
	function saveAndSubmits(subType){
		var srForm  = document.getElementById("srPermitApplyForm");
		if(subType == 'SAVE'){
			srForm.action = 'optApply!savePermitReg.do?itemType=${param.itemType}';
		}
		
		if(subType == 'SUB'){
			srForm.action = 'optApply!saveAndSubmitPermit.do?itemType=${param.itemType}';
		}
		srForm.submit();
	}
	//选择模版上传文档
	function openDocEdit(val){
		//document.getElementById("remark").focus();
		if(val==null || val==''){
			alert("操作失败，对应事项模版没有配置!");
		}else{
		var uri = "<%=request.getContextPath()%>/iWebOffice/DocumentEdit.jsp";
		var param = "flowStep=ZW_EDIT&archiveType=01&RecordID=${djId}&Template=" + val
		 			+"&NeedBookMark=1";
		openNewWindow(uri + "?"+ param,'editForm','');
		}
	}
</script>
</head>

<body onload="setIFrameVal('${object.optBaseInfo.riskType}');changPaperType();">
<%@ include file="/page/common/messages.jsp"%>
<s:form action="optApply"  method="post" namespace="/powerruntime" name="srPermitApplyForm" id="srPermitApplyForm" >
<input id="applyItemType" type="hidden" name="applyItemType" value="${object.applyItemType}" >

<%-- <input id="poweridq" type="hidden" name="powerid" value="${object.optBaseInfo.powerid}" > --%>
<center>
<!-- <input type="button" class="btn" onclick="submitItemFrame('SAVE');" value="保存"/>
<input type="button" class="btn" id="saveAndSubmit" onclick="submitItemFrame('SUB');" value="保存并提交"/>
 --><p align="left"><b>友情提醒：<font color="red">“* ”</font>为必填，<font color="green">“* ”</font>为至少填一项。</b></p>

<!-- 
<c:if test="${object.optBaseInfo.powerid ne null}">
<input type="button" value="生成文书" class="btn"  onclick="openDocEdit('${powerOptInfo.recordid}');"/>	
</c:if></center>
 -->
<%@ include file="/page/powerruntime/optcommon/optBaseInfoForm.jsp"%>
<%-- <c:if test="${!empty templetJsp }">
<fieldset style="padding: 10px; display: block; margin-bottom: 10px;">
		<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
				<tr>
					<td colspan="1">
						<div id="zdybd">
							<input type="hidden" name="templetId" value="${obj.templetId }" />
							<input type="hidden" name="version" value="${obj.version }" />
							<jsp:include page="/templets/jsp/${templetJsp }.jsp" />
						</div>
					</td>
				</tr>
		</table>
	</fieldset>
</c:if> --%>
<fieldset style="padding:10px;display:block;margin-bottom:10px;">
<legend style="padding:4px 8px 3px;"><b>申请信息</b></legend>
<table border="0" id="4thEditTable" cellpadding="0" cellspacing="0" class="viewTable">
				<tr>
					<td class="addTd">
						申请方式
					</td>
					<td align="left" colspan="1">
						<select name="applyWay" style="width:180px">
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('bjsqfs')}">
									<option value="${row.key}"
									 <c:if test="${object.applyWay eq row.key}"> selected = "selected" </c:if> 
									<c:if test="${empty object.applyWay and row.key eq '0'}"> selected = "selected" </c:if>
									>
									<c:out value="${row.value}" /></option>
								</c:forEach>
						</select>
					</td>
					<td class="addTd">
						申请日期
					</td>
					<td>
					<input type="text" name="applyDate" id="applyDate" value="<fmt:formatDate value="${object.applyDate }" type="both"/> " readonly/> 
					 
					</td>
				</tr>
				<tr>
					<td class="addTd">
						申请原因
					</td>
					<td align="left" colspan="3">
						<s:textarea name="applyReason" style="width:100%;height:40px;" value="%{object.applyReason}"/>
					</td>					
				</tr>
				<tr>
				<td class="addTd">
						申请者类别
					</td>
					<td align="left">
					<select name="proposerType" id="proposerType" style="width:180px" onBlur="checkppType()" onchange="changPaperType();checkppType();">
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('PROPOSER_TYPE')}">
									<option value="${row.key}"
									<c:if test="${object.proposerType eq row.key}"> selected = "selected" </c:if>
									<c:if test="${empty object.proposerType and row.key eq '1'}"> selected = "selected" </c:if>
									>
									<c:out value="${row.value}" /></option>
								</c:forEach>
						</select>
						 <span style="color: red">*</span>
					</td>
					<td class="addTd">
						申请者名称
					</td>
									
						<td>
						<div id="userDiv" style="z-index:10000;">
						<input type="text" name="proposerName" id="proposerName" value="${object.proposerName}" > <span style="color: red">*</span>
						<ul id="list"></ul>
						</div>
						<script type="text/javascript">
						//$(function(){
							//initValue_($("input[name=proposerName]"),$("#list"),"${pageContext.request.contextPath}/powerruntime/optApply!getProposerNames.do",$("input[name=proposerName]"));
						//})
						</script>
						</td>
						
					
				</tr>
				<tr>
					
					<td class="addTd">
						申请者证件类型
					</td>
					<td align="left" >
					<input type="hidden" name="proposerPaperType" value="${object.proposerPaperType}" id="proposerPaperType"/>
					<div id="unitDiv" style="display:none;">
						<select name="PaperType_UNIT" style="width:180px" id="PaperType_UNIT" onchange="checkppC_unit();">
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('PaperType_unit')}">
									<option value="${row.key}" <c:if test="${object.proposerPaperType eq row.key}"> selected = "selected" </c:if>
									>
									<c:out value="${row.value}" /></option>
								</c:forEach>
						</select>
						<span style="color: red">*</span>
						</div>
					<div id="zrrDiv" style="display:none;">
						<select name="PaperType_ZRR" style="width:180px"  id="PaperType_ZRR" onchange="checkppC_zrr();" >
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('PaperType')}">
								
									<option value="${row.key}"
									<c:if test="${object.proposerPaperType eq row.key}"> selected = "selected" </c:if>
									
									>
									<c:out value="${row.value}" /></option>
								</c:forEach>
						</select>
						<span style="color: red">*</span>
						</div>
					</td>
				
					<td class="addTd">
						申请者证件号码
					</td>
					<td align="left">
						<s:textfield name="proposerPaperCode" id="proposerPaperCode" value="%{object.proposerPaperCode}" onblur="checkNum();"/>
					    <input style="color:red;border:none;font-weight:bold;font-size:12px;" readonly="readonly" name="remindppC" id="remindppC" value="请输入15或18位数字" onfocus="this.blur()" />
					    <span style="color: red">*</span>
					</td>
				</tr>
				<tr>
					
					<td class="addTd">
						申请者固定电话
					</td>
					<td align="left">
						<s:textfield type="test" id="proposerPhone" name="proposerPhone" value="%{object.proposerPhone}" onBlur="checkTel(this.id)"/> <span style="color: green">*</span>
						<input style="color:red;border:none;font-weight:bold;font-size:12px;" readonly="readonly" name="remindppP" id="remindppP" value="格式为“区号”-“号码”" onfocus="this.blur()" />
					</td>
				
					<td class="addTd">
						申请者移动电话
					</td>
					<td align="left">
						<s:textfield id="proposerMobile" name="proposerMobile" value="%{object.proposerMobile}" onBlur="checkTel(this.id)"/> <span style="color: green">*</span>
						<input style="color:red;border:none;font-weight:bold;font-size:12px;" readonly="readonly" name="remindppM" id="remindppM" value="请输入11位手机号码" onfocus="this.blur()" />
					</td>
					</tr>
				<tr>
					<td class="addTd">
						申请者电子邮箱
					</td>
					<td align="left">
						<s:textfield name="proposerEmail" value="%{object.proposerEmail}" />
					</td>
					<td class="addTd">
						申请者邮编
					</td>
					<td align="left">
						<s:textfield name="proposerZipcode" id="proposerZipcode" value="%{object.proposerZipcode}" />
					</td>
				</tr>
				<tr id="proposerUnitcode_tr">
				<td class="addTd">
						申请者组织机构代码
					</td>
					<td align="left" >
			<s:textfield name="proposerUnitcode" id="proposerUnitcode" value="%{object.proposerUnitcode}" />
					</td>
						<td class="addTd">
						法定代表人/负责人
					</td>
					<td align="left">
			<s:textfield name="legal_person" id="legal_person" value="%{object.legal_person}" />
					</td>
					</tr>
				<tr>
					<td class="addTd">
						申请者地址
					</td>
					<td align="left" colspan="3">
						<s:textarea name="proposerAddr" value="%{object.proposerAddr}" style="width:100%;height:40px;"/>
					</td>
					
				</tr>
				
				<tr>
					<td class="addTd">
						代理人姓名
					</td>
					<td align="left" colspan="3">
						<s:textfield name="agentName"  value="%{object.agentName}"/>
					</td>
				<%-- 	<td class="addTd">
						代理人机构代码
					</td>
					<td align="left">
						<s:textfield name="agentUnitcode" id="agentUnitcode" value="%{object.agentUnitcode}"/>
					</td> --%>
				</tr>

				<tr>
					<td class="addTd">
						代理人证件类型
					</td>
					<td align="left">
						<select name="agentPaperType" style="width:180px">
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('PaperType')}">
									<option value="${row.key}" <c:if test="${object.agentPaperType eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" /></option>
								</c:forEach>
						</select>
					</td>
					<td class="addTd">
						代理人证件号码
					</td>
					<td align="left">
						<s:textfield name="agentPaperCode"  value="%{object.agentPaperCode}"/>
					</td>
				</tr>

				<tr>
					<td class="addTd">
						代理人固定电话 
					</td>
					<td align="left">
						<s:textfield name="agentPhone"  value="%{object.agentPhone}"/>
					</td>
					<td class="addTd">
						代理人移动电话
					</td>
					<td align="left">
						<s:textfield name="agentMobile" value="%{object.agentMobile}"/>
					</td>
				</tr>

				<tr>
					<td class="addTd">
						代理人电子邮箱
					</td>
					<td align="left">
						<s:textfield name="agentEmail" value="%{object.agentEmail}"/>
					</td>
					<td class="addTd">
						代理人邮编
					</td>
					<td align="left">
						<s:textfield name="agentZipcode" id="agentZipcode" value="%{object.agentZipcode}"/>
					</td>
				</tr>
			
				<tr>
					<td class="addTd">
						代理人地址
					</td>
					<td align="left" colspan="3">
						<s:textarea name="agentAddr" style="width:100%;height:40px;" value="%{object.agentAddr}"/>
					</td>
					</tr>
				<tr>
					<td class="addTd">
						申请备注
					</td>
					<td align="left" colspan="3">
						<s:textarea name="applyMemo" value="%{object.applyMemo}" style="width:100%;height:40px;" />
					</td>
					</tr>
</table>
</fieldset>
<div id="slfieldset" style="display: none;">
				<fieldset  style="padding:10px;display:block;margin-bottom:10px;">
					<legend style="padding:4px 8px 3px;"><b>材料上传</b></legend>
					<input type="hidden" id="groupId" name="groupId" value="" /> 					
					<iframe id="basicsj"  name="sjfj" onload="iframeAutoFit(this);"
								src="" width="100%"  style="overflow:hidden;"
							frameborder="no" scrolling="false" border="0" marginwidth="0"
							marginheight="0"></iframe>
				</fieldset>
				</div>
				
<input type="button" class="btn" onclick="submitItemFrame('SAVE');" value="保存"/>
<input type="button" class="btn"  id="saveAndSubmit"  onclick="submitItemFrame('SUB');" value="保存并提交"/> 
<!-- 
<c:if test="${object.optBaseInfo.powerid ne null}">
<input type="button" value="生成文书" class="btn"  onclick="openDocEdit('${powerOptInfo.recordid}');"/>	
</c:if>
 -->
</s:form>
</body>
<script type="text/javascript">
//iframe自适应高度
function iframeAutoFit(iframeObj){ 
    setTimeout(function(){if(!iframeObj) return;iframeObj.height=(iframeObj.Document?iframeObj.Document.body.scrollHeight:iframeObj.contentDocument.body.offsetHeight)+10;},200) 
}
</script>
<script type="text/javascript">
var _get = function (id) {
	return document.getElementById(id);
};
function setIFrameVal(riskType){	
	if(riskType!=''){
		document.getElementById('resultID').style.display = 'block';
		document.getElementById('riskDescID').style.display = 'block';
		document.getElementById('riskTypeID').style.display = 'block';		
	}
}
	//申请者证件类别：区别自然人和法人
	
	function changPaperType() {
		var proposerType = document.getElementById("proposerType");
		var proposerUnitcode_tr = document.getElementById("proposerUnitcode_tr");
		var _get = function (id) {
			return document.getElementById(id);
		};
		if (proposerType.value =="0") { //自然人
			_get("zrrDiv").style.display = "block";
			_get("unitDiv").style.display = "none";
			proposerUnitcode_tr.style.display = "none";		
		} 
		else if(proposerType.value ==""){     //初始
			_get("zrrDiv").style.display = "none";
			_get("unitDiv").style.display = "none";
			proposerUnitcode_tr.style.display = "block";
			$("#remindppC").val("");
		}
		else {//法人和其他
			_get("zrrDiv").style.display = "none";
			_get("unitDiv").style.display = "block";
			proposerUnitcode_tr.style.display = "block";		
		}
	}

	
	function docheck() {
		
		if($("#powerid").val()==''){
			alert("请选择权力事项！");
			$('#powerid').focus();
			return false;
		}	
		
		if($("#transaffairname").val()==''){
			alert("办件名称不可为空！");
			$('#transaffairname').focus();
			return false;
		}	
		if($("#proposerType").val()==''){
			alert("申请者类别不可为空！");
			$('#proposerType').focus();
			return false;
		}
		if($("#proposerName").val()==''){
			alert("申请者名称不可为空！");
			$('#proposerName').focus();
			return false;
		}	
		if($("#proposerPhone").val()=='' && $("#proposerMobile").val()==''){
		if($("#proposerPhone").val()==''){
			alert("申请者电话或手机不可为空！");
			$('#proposerPhone').focus();
			return false;
		}
		if($("#proposerMobile").val()==''){
			alert("申请者电话或手机不可为空！");
			$('#proposerMobile').focus();
			return false;
		}
		}
		
		if($("#proposerZipcode").val() !='' &&  getStringLen($("#proposerZipcode").val())>6){
			alert("邮编长度不可超过6位！");
			$('#proposerZipcode').focus();
			return false;
		}
		
		if($("#agentZipcode").val() !='' &&  getStringLen($("#agentZipcode").val())>6){
			alert("邮编长度不可超过6位！");
			$('#agentZipcode').focus();
			return false;
		}
		
		if($("#proposerType").val() == '0'){
			if($("#PaperType_ZRR").val() == ''){
				alert("请选择申请者证件类型！");
				$('#PaperType_ZRR').focus();
				return false;
			}
		}else{
			if($("#PaperType_UNIT").val() == ''){
				alert("请选择申请者证件类型！");
				$('#PaperType_UNIT').focus();
				return false;
			}
		}
		
		if($("#proposerPaperCode").val() == ''){
			alert("申请者证件号码不能为空！");
			$('#proposerPaperCode').focus();
			return false;
		}
		/* if($("#agentUnitcode").val() !='' &&  getStringLen($("#agentUnitcode").val())>6){
			alert("代理人机构代码 长度不可超过6位！");
			$('#agentUnitcode').focus();
			return false;
		} */
		return true;
	}
	
   
	
	function checkTel(number_id) {
		var nubmer = $("#" + number_id).val();
		if (nubmer != "") {
			if (number_id == "proposerPhone") {
				var regular = /^0\d{2,3}-\d{7,8}$/; //固话
				if (!regular.test(nubmer)) {
					alert("请输入正确的电话号码!");
					$("#" + number_id).val('');
					$("#remindppP").val("格式为“区号”-“号码”");
					return;
				}
				else{
					$("#remindppP").val("");
					return;
				}
			} 
			
			else {
				var regular = /^1[3|4|5|7|8]\d\d{8}$/; //手机号码rep
				if (!regular.test(nubmer)) {
					alert("请输入正确的手机号码!");
					//document.getElementById("proposerPhone").value="";
					$("#" + number_id).val('');
					$("#remindppM").val("请输入11位手机号码");
					return;
				}
				else{
					$("#remindppM").val("");
					return;
				}
			}
		}
		else  {
			if (number_id == "proposerPhone") {
				$("#remindppP").val("格式为“区号”-“号码”");	
			}
			else {
				$("#remindppM").val("请输入11位手机号码");	
		  }
		}
	}

	function checkNum() {
		var id_number = $("#proposerPaperCode").val();
		if (id_number != "") {
			if ($("#PaperType_UNIT").val() == "2" || $("#PaperType_ZRR").val() == "0" ) {
				if (id_number.length != 15 && id_number.length != 18) {
					alert("请正确的身份证号码！");
					$("#proposerPaperCode").val("");
					$("#remindppC").val("请输入15或18位数字");
					return;
				}
				else{
					$("#remindppC").val("");
					return;
				}
			}
		}
		else{
			if ($("#PaperType_UNIT").val() == "2" || $("#PaperType_ZRR").val() == "0" ) {
			$("#remindppC").val("请输入15或18位数字");
		}
			}
		
	}
	
	function checkppC_zrr() {
			if ($("#PaperType_ZRR").val() == "0") {
					$("#remindppC").val("请输入15或18位数字");
					//return;
				}
				else{
					$("#proposerPaperCode").val("");
					$("#remindppC").val("");
				}
			$("#proposerPaperType").val($("#PaperType_ZRR").val());
			//alert($("#proposerPaperType").val());
			}
	
	function checkppC_unit() {
		if ($("#PaperType_UNIT").val() == "2") {
				$("#remindppC").val("请输入15或18位数字");
				//return;
			}
			else{
				$("#proposerPaperCode").val("");
				$("#remindppC").val("");
			}
		$("#proposerPaperType").val($("#PaperType_UNIT").val());
		//alert($("#proposerPaperType").val());
		}
			 

	function checkppType() {
		var type = $("#proposerType").val();
		if (type == "") {
			$("#PaperType_UNIT").val("");
			$("#PaperType_ZRR").val("");
			$("#remindppC").val("");
			//$("#proposerUnitcode").val("无");
			//$("#legal_person").val("无");
			//document.getElementById("proposerUnitcode").disabled = true;
			//document.getElementById("legal_person").disabled = true;
		} else if(type == "0"){
			$("#PaperType_UNIT").val("");
			$("#remindppC").val("");
			//$("#proposerUnitcode").val("");
			//$("#legal_person").val("");
			//document.getElementById("proposerUnitcode").disabled = false;
			//document.getElementById("legal_person").disabled = false;
		}
		else{
			$("#PaperType_ZRR").val("");
			$("#remindppC").val("");
		}
		return;
	}

	function getStringLen(Str) {
		var i, len, code;
		if (Str == null || Str == "")
			return 0;
		len = Str.length;
		for (i = 0; i < Str.length; i++) {
			code = Str.charCodeAt(i);
			if (code > 255) {
				len++;
			}
		}
		return len;
	}
</script>


<script type="text/javascript">

/* var url='powerruntime/generalOperator!gotosqcl.do?stuffInfo.djId=${djId}&stuffInfo.nodeInstId=0&stuffInfo.groupid=${moduleParam.stuffGroupId}';
var obj = document.getElementById("basicsj");
obj.src = url;
obj.onload = function(){
	obj.style.height = window.frames['sjfj'].document.body.scrollHeight+"px";
}; */

var powerid='${object.optBaseInfo.powerid}';
var djid='${object.djId}';
if(powerid!=''){
	$.ajax({
	type:"POST",
	url: "<%=request.getContextPath()%>/powerruntime/powerOptInfo!getGroupIDByItemid.do?object.itemId="+powerid,
	contentType:"text/html",					
	dataType:"json",
	processData:false,
	async: false,
	success:function(data){
		var obj = document.getElementById("slfieldset");
		obj.style.display="block";
		var url2='<%=request.getContextPath()%>/powerruntime/generalOperator!gotosqcl.do?stuffInfo.djId='+djid+'&stuffInfo.nodeInstId=0&stuffInfo.groupid='+data.groupidByitemid;
		var objfram=document.getElementById('basicsj');
		objfram.src=url2;
	},
	error:function(){
		alert("系统提交失败");
	}			
});
}
//var optBaseInfoJson='${optBaseInfoJson}';
function getOptBaseInfoJson(){
	return ${optBaseInfoJson};
}
</script> 
</html>
