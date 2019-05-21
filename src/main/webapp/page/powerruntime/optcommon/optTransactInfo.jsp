<%@page import="com.goldgrid.weboffice.TemplateService"%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>办理信息</title>
<sj:head locale="zh_CN" />
<script type="text/javascript">
function checkForm(){
	if(trim(_get('ideacode').value).length==0){
		alert("请选择处理结果。");
		_get('ideacode').focus();
		return false;
	}
	if(trim(_get('transcontent').value).length==0){
		alert("意见不能为空。");
		_get('transcontent').focus();
		return false;
	}
	
	if(_get('bjCodes') != undefined && '${moduleParam.assignTeamRole}' == 'T'){
		if(trim(_get('bjCodes').value).length==0){
			alert("${moduleParam.teamRoleName}不能为空。");			
			return false;
		}
		
	}
	
	if(_get('curTemplateId') != undefined && '${moduleParam.hasDocument}' == 'T' ){
		if(trim(_get('curTemplateId').value).length==0){
			alert("${moduleParam.documentLabel}不能为空。");
			return false;
		}
	}
	<c:if test="${not(empty isSendEms) }">
	if($("#isSendEms").val()=="T"&&""==$("#emsordno").val()){
		alert("请填写EMS快递信息");
		return false;
	}
	</c:if>
	if($("#eIdPhotoIframe").contents().find("#mouldId").val() != '' && ($("#documentType").val() == 'jds'|| $("#documentType").val() == 'xkjds')){
		if(submitItemFrame()){
			submitBizData();
		}else{
			return false;
		}
	}else{
		submitBizData();
	}
	
	return true;
}
var submitItemFrame = function(){
	if($("#eIdPhotoIframe").contents().find("#zzBh").val().replace(/^\s+|\s+$/g,"") == ""){
		alert("证照编号不能为空");
		$("#eIdPhotoIframe").contents().find("#zzBh").focus();
		return false;
	}/* else if($("#bzDate").val().replace(/^\s+|\s+$/g,"") == ""){
		alert("颁证时间不能为空");
		$("#bzDate").focus();
		return;
	} */else if($("#eIdPhotoIframe").contents().find("#starTime").val().replace(/^\s+|\s+$/g,"") == ""){
		alert("有效期开始时间不能为空");
		$("#eIdPhotoIframe").contents().find("#starTime").focus();
		return false;
	}else if($("#eIdPhotoIframe").contents().find("#endTime").val().replace(/^\s+|\s+$/g,"") == ""){
		alert("有效期结束时间不能为空");
		$("#eIdPhotoIframe").contents().find("#endTime").focus();
		return false;
	}/* else if($("#deptName").val().replace(/^\s+|\s+$/g,"") == ""){
		alert("颁证单位不能为空");
		$("#deptName").focus();
		return;
	}else if($("#userName").val().replace(/^\s+|\s+$/g,"") == ""){
		alert("持证者不能为空");
		$("#userName").focus();
		return;
	}else if($("#userNo").val().replace(/^\s+|\s+$/g,"") == ""){
		alert("持证者号码不能为空");
		$("#userNo").focus();
		return;
	}else if($("#zzFile").val() == ""){
		alert("证照文件不能为空");
		$("#zzFile").focus();
		return;
	} */
	var columnName = "";
	var isOk = true;
	$("#eIdPhotoIframe").contents().find("#metadataBody").find("td").each(function(){
		if($(this).eq(0).children("span").length > 0){
			columnName = $(this).text().replace("*","");
		}else{
			if($(this).eq(0).children("input").val() == ""){
				alert(columnName + "不能为空");
				$(this).eq(0).children("input").focus();
				isOk = false;
				return false;
			}
		}
	});
	if(isOk){
		$("#eIdPhotoIframe").contents().find("#suppowerForm").submit();
	}
	return isOk;
}
var _get = function (id) {
	return document.getElementById(id);
};

//字符空格处理
var trim = function (str) {
	return str.replace(/^\s+|\s+$/g, "");
};
</script>
</head>
<script type="text/javascript">
//var optBaseInfoJson = ${optBaseInfoJson};
function _SelectItemByValue(objSelect, objItemText) {            
    //判断是否存在        
    //var isExit = false;        
    for (var i = 0; i < objSelect.options.length; i++) {        
        if (objSelect.options[i].value == objItemText) {        
            objSelect.options[i].selected = true;        
            //isExit = true;        
            break;        
        }        
    } 
}

function openNewWindow(winUrl,winName,winProps){
	if(winProps =='' || winProps == null){
		winProps = 'height='+(window.screen.availHeight-50) +',width='+window.screen.availWidth
		+',directories=false,location=false,top=0,left=0,menubar=false,Resizable=yes,scrollbars=yes,toolbar=false';
	}
	window.open(winUrl, winName, winProps);
}

function openTemplate(val,documentType){
	if(val  == '' || val == null){
		return;
	}
	if(document.getElementById("EDitBZ").style.display!='none'){
		openDocEdit(val,documentType);
	}else{
		var curTemplateId = document.getElementById("curTemplateId").value;
		if (curTemplateId != "" && curTemplateId != null) {
			if(window.confirm("重新选择模板会生成新的文件，已保存的内容将被覆盖，是否确定？")){
				openDocEdit(val,documentType);
			}
		}else{
			openDocEdit(val,documentType);
		}
	}
	
}

function getArchiveType(documentType){
	var archiveType=documentType;
	
	//受理步骤
	if(documentType == 'sl'){
		var doc = document.getElementById("recordId");
		var docText=doc.options[doc.selectedIndex].text;
		if(docText.indexOf('受理')>-1){
			archiveType='02';
		}
		
		if(docText.indexOf('补正')>-1){
			archiveType='03';
		}
	}
	
	//申请表
	if(documentType == 'zw'){
		archiveType='01';
	}
	
	//核查意见书
	if(documentType == 'hc'){
		archiveType='05';
	}
	
	//核查意见书附表
	if(documentType=='idea'){
		archiveType='06';
	}
	
	//审查意见书
	if(documentType == 'sc'||documentType=='SCYJS'){
		archiveType='07';
	}
	
	//许可决定书
	if(documentType == 'jds'||documentType == 'xkjds'){
		archiveType='08';
	}
	

	return archiveType;
}
//选择模版上传文档
function openDocEdit(val,documentType){
	var archiveType = getArchiveType(documentType);
	var uri = "${pageContext.request.contextPath}/iWebOffice/DocumentEdit.jsp";
	var param = "flowStep=ZW_EDIT&RecordID=${djId}&Template=" + val +"&archiveType="+archiveType
	 			+"&NeedBookMark=1";
	openNewWindow(uri + "?"+ param,'editForm','');
}

//从流程节点配置中加载文书模版 
function openDocNodeEdit(val,documentType){
	var archiveType =documentType;
	var uri = "<%=request.getContextPath()%>/iWebOffice/DocumentEdit.jsp";
	var param = "flowStep=WS_EDIT&RecordID=${djId}&Template=" + val +"&archiveType="+archiveType+"&nodeInstId=${nodeInstId}&nodeCode=${nodeCode}"
	 			+"&NeedBookMark=1";	
	openNewWindow(uri + "?"+ param,'editForm','');
}

//修改文档
function updtDoc(documentType){
	var archiveType = getArchiveType(documentType);
	var curTemplateId = document.getElementById("curTemplateId").value;
	if (curTemplateId != "" && curTemplateId != null) {
		var uri = "<%=request.getContextPath()%>/iWebOffice/DocumentEdit.jsp";
			var param = "flowStep=ZW_EDIT&RecordID=${djId}&EditType=2,1&ShowType=1&Template="
					+ curTemplateId + "&archiveType=" + archiveType;
			openNewWindow(uri + "?" + param, 'editForm', '');
		} else {
			alert("请生成您需要的文书！！");
		}
	}
	function delDoc(documentType) {
		if (window.confirm("确认删除当前正文？")) {
			var djId = $("#djId").val();
			var archiveType = getArchiveType(documentType);
			var nodeInstId = $("#nodeInstId").val();
			$.ajax({
				type : "POST",
				url : "generalOperator!deleteStuffByArchiveType.do?djId="
						+ djId + "&archiveType=" + getArchiveType(documentType)
						+ "&nodeInstId=" + nodeInstId,
				success : function(data) {
					alert("删除成功");
					window.parent.frames['stuffsFrame'].location.reload();
				},
				error : function() {
					alert("失败");
					window.parent.frames['stuffsFrame'].location.reload();
				}
			});
			$("#addDoc").show();
			$("#zwedit").hide();
			$("#recordId").attr("value", "");
			$("#curTemplateId").attr("value", "");
			if ('03' == archiveType) {
				$("#EDitBZ").hide();
			}
		}
	}
	//根据值设置select中的选项       
	function _getSelectedItemLabel(objSelect) {
		//判断是否存在        
		//var isExit = false;        
		for (var i = 0; i < objSelect.options.length; i++) {
			if (objSelect.options[i].selected) {
				document.getElementById("transidea").value = objSelect.options[i].label;
				if (document.getElementById("transcontent"))
					document.getElementById("transcontent").value = objSelect.options[i].label;
				break;
			}
		}
	}

	//保存业务数据，在提交办理的时候，同时提交
	function submitBizData() {
		window.parent.frames['viewFrame'].document.forms[0].submit();
	}
</script>
<body>
	<s:form action="generalOperator" method="post"
		namespace="/powerruntime" id="generalOperatorForm" target="_parent"
		onsubmit="return checkForm();">
		<input type="hidden" id="flowInstId" name="flowInstId"
			value="${flowInstId}" />
		<input type="hidden" id="djId" name="djId" value="${djId}" />
		<input type="hidden" id="nodeInstId" name="nodeInstId"
			value="${nodeInstId}">
		<c:if test="${moduleParam.hasStuff eq 'T' }">
			<tr>
				<td colspan="2" style="padding-bottom: 8px;"><iframe
						id="basicsj" name="sjfj" src="" width="100%" height=""
						frameborder="no" scrolling="false" border="0" marginwidth="0"
						marginheight="0"></iframe></td>
			</tr>

		</c:if>
		<fieldset style="display: block; padding: 10px;">
			<legend>
				<b>办理信息</b>
			</legend>
			<table border="0" cellpadding="0" cellspacing="0" id="tb"
				class="viewTable" style="margin-top: 20px;">
				<tr>
					<td class="addTd" width="13%">${moduleParam.ideaLabel}<font
						color="red">*</font></td>
					<td align="left" width="87%"><input type="hidden"
						name="transidea" value="${object.transidea}" id="transidea">
						<select id="ideacode" name="ideacode"
						onchange="_getSelectedItemLabel(this)">
							<option VALUE="">---请选择---</option>
							<c:forEach var="row" items="${cp:LVB(moduleParam.ideaCatalog)}">
								<option value="${row.value}" label="${row.label}"
									<c:if test="${object.ideacode==row.value}">selected="selected"</c:if>>
									<c:out value="${row.label}" />
								</option>
							</c:forEach>
					</select></td>
				</tr>

				<tr>
					<td class="addTd" width="140">${moduleParam.ideaContent}<font
						color="red">*</font></td>
					<td align="left"><s:textarea id="transcontent"
							name="transcontent" style="width:100%; height:40px;"
							value="%{object.transcontent}" /></td>
				</tr>
				<c:if test="${moduleParam.hasAttention eq 'T' }">
					<tr>
						<td class="addTd" width="140">${moduleParam.attentionLabel}</td>
						<td align="left"><input type="text" id="attUserNames"
							name="attUserNames" readonly="readonly" style="width: 100%;"
							value="${attUserNames}" /> <input type="hidden"
							id="attUserCodes" name="attUserCodes" value="${attUserCodes}" />
							<input type="hidden" id="attType" name="optProcAttention.attType"
							value="1" /></td>
					</tr>
				</c:if>
				<!-- 办件角色 -->
				<c:if test="${moduleParam.assignTeamRole eq 'T' }">
					<tr>
						<td class="addTd" width="140">${moduleParam.teamRoleName}<font
							color="red">*</font></td>
						<td align="left"><input type="text" id="bjUserNames"
							name="bjUserNames" style="width: 100%;" value="${bjUserNames}"
							readonly="readonly" /> <input type="hidden" id="bjCodes"
							name="teamUserCodes" value="${teamUserCodes}" /> <input
							type="hidden" id="roleCode" name="teamRoleCode"
							value="${moduleParam.teamRoleCode}" /> <!-- <input type="hidden" id="attType" name="optProcAttention.attType" value="1" /> -->
						</td>
					</tr>
				</c:if>
				<input type="hidden" id="curTemplateId" name="curTemplateId"
					value="${recordId}" />
				<c:if test="${moduleParam.hasDocument eq 'T' }">
					<tr>
						<td class="addTd" width="140">${moduleParam.documentLabel}</td>
						<td align="left"><span id="addDoc"> <select
								id="recordId" name="recordId"
								onchange="openTemplate(this.value,'${moduleParam.documentType}');">
									<option value="">--请选择--</option>
									<c:forEach var="temp" items="${templateList}">
										<option value="${temp.recordId}"
											<c:if test="${object.recordId==temp.recordId}">selected="selected"</c:if>>
											<c:out value="${temp.descript}" /></option>
									</c:forEach>
							</select> <span id="EDitBZ" style="display: none;">
									&nbsp;&nbsp;&nbsp;&nbsp; <input type="button" id="editdc"
									onclick="updtDoc('${moduleParam.documentType}');" value="修改正文"
									class="btn processBtn" /><input type="button" id="deletedc"
									onclick="delDoc('${moduleParam.documentType}');" value="删除正文"
									class="btn flowBtn" />
							</span>
						</span> <span id="zwedit" style="display: none;"> <span
								id="fwname"></span>&nbsp;&nbsp;&nbsp;&nbsp; <input type="button"
								id="editdc" onclick="updtDoc('${moduleParam.documentType}');"
								value="修改正文" class="btn processBtn" /> <input type="button"
								id="deletedc" onclick="delDoc('${moduleParam.documentType}');"
								value="删除正文" class="btn flowBtn" />

						</span> <script type="text/javascript">
							var curTemplateId = document
									.getElementById("curTemplateId").value;
							if (curTemplateId != null && curTemplateId != '') {
								if (getArchiveType('${moduleParam.documentType}') == '03') {
									document.getElementById("EDitBZ").style.display = "";
								} else {
									document.getElementById("zwedit").style.display = "";
									document.getElementById("addDoc").style.display = "none";
									var indexx = document
											.getElementById('recordId').selectedIndex;
									var textt = document
											.getElementById("recordId").options[indexx].text;
									document.getElementById("fwname").innerHTML = ""
											+ textt + ".doc";
								}
							}
						</script></td>
					</tr>
				</c:if>

				<!-- 从流程节点配置中加载文书模版 -->
				<c:if test="${templateFromNode eq 'TRUE'}">
					<tr>
						<td class="addTd" width="140">文书</td>
						<td align="left"><c:forEach var="temp"
								items="${templateFileList}">
								<input type="hidden" id="templateFile-${temp.recordId}"
									name="templateFile-${temp.recordId}" />
								<script type="text/javascript">
									templateFileIds[++fileIndex] = "${temp.recordId}";
									templateFileNames[fileIndex] = "${temp.descript}";
								</script>
								<button
									onclick="openDocNodeEdit('${temp.recordId}','${temp.tempType}');"
									id="ws-${temp.recordId}" value="${temp.descript}"
									class="btn processBtn">
									<c:choose>
										<c:when test="${fn:length(temp.descript) > 8}">
											<c:out value="${fn:substring(temp.descript, 0, 8)}..." />
										</c:when>
										<c:otherwise>
											<c:out value="${temp.descript}" />
										</c:otherwise>
									</c:choose>
								</button>
								<%-- <a href="javascript:void(0);" onclick="openDocNodeEdit('${temp.recordId}','${temp.tempType}');" id="ws-${temp.recordId}" class="btnA">
									<span id="ws" class="btn">
									<c:choose>
										<c:when test="${fn:length(temp.descript) > 8}">
											<c:out value="${fn:substring(temp.descript, 0, 8)}..." />
										</c:when>
										<c:otherwise>
											<c:out value="${temp.descript}" />
										</c:otherwise>
									</c:choose>
									</span></a> --%>
							</c:forEach></td>
					</tr>
				</c:if>
				<!-- 添加发送ems模块 -->
				<c:if test="${not(empty isSendEms) }">
					<tr>
						<input type="hidden" id="expressid" name="expressid"
							value="${emsinfo.expressid}" />
						<input type="hidden" id="emsordno" name="emsordno"
							value="${emsinfo.emsordno}" />
						<input type="hidden" id="isnetApply" name="isnetApply"
							value="${emsinfo.isnetApply}" />
						<td class="addTd" width="140">是否发送EMS快递</td>
						<td align="left"><select id="isSendEms" name="isSendEms"
							onchange="openEms(this.value);">
								<c:forEach var="row" items="${cp:DICTIONARY('TrueOrFalse')}">
									<option value="${row.key}"
										<c:if test="${isSendEms eq row.key}"> selected = "selected" </c:if>>
										<c:out value="${row.value}" /></option>
								</c:forEach>
						</select> <span id="EMSHAVING" style="display: none">
								&nbsp;&nbsp;&nbsp;&nbsp; <input type="button" id="editems"
								onclick="updateEms('${emsinfo.expressid}');" value="修改EMS快递信息"
								class="btn processBtn" /><input type="button" id="deleteems"
								onclick="deleteEms('${emsinfo.expressid}');" value="删除EMS快递信息"
								class="btn flowBtn" /> <script type="text/javascript">
									<c:if test="${isSendEms eq 'F'}">$(
											"#EMSHAVING").hide();
									</c:if>
									<c:if test="${isSendEms eq 'T'}">$(
											"#EMSHAVING").show();
									</c:if>
								</script>
						</span></td>
					</tr>
				</c:if>
				<c:if test="${moduleParam.riskId !=null && moduleParam.riskId !=0}">
					<%@ include file="/page/powerruntime/optcommon/optRiskInfoForm.jsp"%>
				</c:if>
			</table>
		</fieldset>
		<center style="margin-top: 10px; display: none;">
			<s:submit id="submitBtn" name="submitBtn" method="submitOpt"
				cssClass="btn" value="发 送" />
			<c:if test="${moduleParam.canDefer eq 'T' }">
				<s:submit id="suspendBtn" name="suspendBtn"
					method="suspendNodeInstance" cssClass="btn" value="暂 缓" />
			</c:if>
			<c:if test="${moduleParam.canRollback eq 'T' }">
				<s:submit id="rollBackBtn" name="rollBackBtn" method="rollBackOpt"
					cssClass="btn" value="回 退" />
			</c:if>
			<c:if test="${moduleParam.canClose eq 'T' }">
				<s:submit id="endFlowBtn" name="endFlowBtn" method="endFlow"
					cssClass="btn" value="办 结" />
			</c:if>
			<s:submit id="saveBtn" name="saveBtn" method="saveOpt" cssClass="btn"
				value="保 存" />
			<input id="backBtn" name="backBtn" type="button" value="返回"
				class="btn" onclick="window.history.go(-1);" />
		</center>
	</s:form>
	<input type="hidden" value="${moduleParam.documentType }" id="documentType" />
	<c:if test="${moduleParam.documentType == 'jds' || moduleParam.documentType ==  'xkjds'}">
		<iframe id="eIdPhotoIframe" src="${pageContext.request.contextPath}/powerruntime/eIdPhoto!toPhoto.do?djId=${djId }" width="100%" style="margin-bottom:10px;" frameborder="no" scrolling="false" marginwidth="0" border="0" onload="iframeAutoFit(this);" height="218"></iframe>
	</c:if>
</body>
<c:if test="${moduleParam.hasStuff eq 'T' }">
	<script type="text/javascript">
		var url = 'powerruntime/generalOperator!gotosqcl.do?stuffInfo.djId=${djId}&stuffInfo.nodeInstId=${nodeInstId}&stuffInfo.groupid=${moduleParam.stuffGroupId}';
		var obj = document.getElementById("basicsj");
		obj.src = url;
		obj.onload = function() {
			obj.style.height = window.frames['sjfj'].document.body.scrollHeight
					+ "px";
		};
	</script>
</c:if>
<c:if test="${not(empty isSendEms) }">
	<script type="text/javascript">
		var openEms = function(value) {
			if (value == 'T') {
				var winUrl = "${pageContext.request.contextPath}/powerruntime/optExpressMessage!bjAddAndEdit.do?djId="
						+ $("#djId").val();
				if(""!=$("#expressid").val()){
					winUrl =winUrl+"&expressid="+$("#expressid").val();
				}
				var iWidth = 820;
				var iHeight = 600;
				var iTop = (window.screen.height - 30 - iHeight) / 2; //获得窗口的垂直位置;  
				var iLeft = (window.screen.width - 10 - iWidth) / 2; //获得窗口的水平位置;  
				var winProps = 'height='
						+ iHeight
						+ ',width='
						+ iWidth
						+ ',top='
						+ iTop
						+ ',left='
						+ iLeft
						+ ',directories=false,location=false,menubar=false,resizable=yes,scrollbars=yes,toolbar=falsestatus=no';
				window.open(winUrl, "填写EMS快递信息", winProps);
			} else {
				$("#EMSHAVING").hide();
				var expressid = $("#expressid").val();
				if("1"!=$("#isnetApply").val()){
					$("#expressid").val("");
				}
				if(""!=$("#emsordno").val()){
					$("#emsordno").val("");
					var xmlhttp;
					var url = "${pageContext.request.contextPath}/powerruntime/optExpressMessage!delteBjEmsInfo.do";
					if (xmlhttp == null) {
						if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
							xmlhttp = new XMLHttpRequest();
						} else {// code for IE6, IE5
							xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
						}
					}
					xmlhttp.open("POST", url, false);
					xmlhttp.setRequestHeader("Content-type",
							"application/x-www-form-urlencoded");
					xmlhttp.send("expressid=" + expressid);
				}
			}
		}
		var updateEms = function(expressid) {
			if(typeof(expressid)=="undefined"||""==expressid){
				expressid = $("#expressid").val();
			}
			var winUrl = "${pageContext.request.contextPath}/powerruntime/optExpressMessage!bjAddAndEdit.do?expressid="
					+ $("#expressid").val();
			var iWidth = 820;
			var iHeight = 600;
			var iTop = (window.screen.height - 30 - iHeight) / 2; //获得窗口的垂直位置;  
			var iLeft = (window.screen.width - 10 - iWidth) / 2; //获得窗口的水平位置;  
			var winProps = 'height='
					+ iHeight
					+ ',width='
					+ iWidth
					+ ',top='
					+ iTop
					+ ',left='
					+ iLeft
					+ ',directories=false,location=false,menubar=false,resizable=yes,scrollbars=yes,toolbar=falsestatus=no';
			window.open(winUrl, "修改EMS快递信息", winProps);
		}
		var deleteEms = function(expressid) {
			if(typeof(expressid)=="undefined"||""==expressid){
				expressid = $("#expressid").val();
			}
			if (window.confirm("确定需要删除此Ems信息吗？")) {
				var xmlhttp;
				var url = "${pageContext.request.contextPath}/powerruntime/optExpressMessage!delteBjEmsInfo.do";
				if (xmlhttp == null) {
					if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
						xmlhttp = new XMLHttpRequest();
					} else {// code for IE6, IE5
						xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
					}
				}
				xmlhttp.open("POST", url, false);
				xmlhttp.setRequestHeader("Content-type",
						"application/x-www-form-urlencoded");
				xmlhttp.send("expressid=" + expressid);
				var returnvalue = xmlhttp.responseText;
				var result = "";
				for (var i = 0; i < returnvalue.split(",").length; i++) {
					var index = returnvalue.split(",")[i].indexOf(":");
					var key = "", value = "";
					if (i == 0) {
						key = returnvalue.split(",")[i].substring(1, index);
						value = returnvalue.split(",")[i].substring(index + 1);
					} else if (i == returnvalue.split(",").length - 1) {
						key = returnvalue.split(",")[i].substring(0, index);
						value = returnvalue.split(",")[i].substring(index + 1,
								returnvalue.split(",")[i].length - 1);
					} else {
						key = returnvalue.split(",")[i].substring(0, index);
						value = returnvalue.split(",")[i].substring(index + 1);
					}
					if ("result" == key.substring(1, key.length - 1)) {
						result = value.substring(1, value.length - 2);
					}
				}
				if("OK"==result){
					$("#expressid").val("");
					$("#EMSHAVING").hide();
					$("#emsordno").val("");
					$("#isSendEms").val("F");
					alert("删除Ems信息成功！");
				}else{
					alert("删除Ems信息失败！原因："+result);
				}
				return xmlhttp.responseText;
			} else {
				return false;
			}
		}
	</script>
</c:if>
<script type="text/javascript">
	$("#attUserNames").click(
			function() {
				var s = '${attentionJson}';
				if (s.trim().length) {
					window.parent.selectPopWin(jQuery.parseJSON(s),
							$("#attUserNames"), $("#attUserCodes"));
				}
			});

	$("#bjUserNames").click(
			function() {
				var d = '${userjson}';
				if (d.trim().length) {
					window.parent.selectPopWin(jQuery.parseJSON(d),
							$("#bjUserNames"), $("#bjCodes"));
				}
				;
			});
</script>

<script type="text/javascript">
	//var optBaseInfoJson=window.parent.optBaseInfoJson;
	function getOptBaseInfoJson() {
		return window.parent.getOptBaseInfoJson();
	}
	function getTranscontent() {
		return $("#transcontent").val();
	}
	function getDocumentType() {
		return '${moduleParam.documentType}';
	}
	function getCurNodenisid() {
		return $("#nodeInstId").val();
	}
	function getOptInfo() {
		return '${optProInfo}';
	}
	function getNodeName() {
		return '${nowNodeName}';
	}
</script>
</html>