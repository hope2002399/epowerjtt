
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html >
<head>
<title>置文号</title>
<sj:head locale="zh_CN" />
</head>
<body>
	<s:form action="ioDocArchiveNo" namespace="/dispatchdoc" method="post"
		id="ioDocArchiveNoForm" target="_parent" onsubmit="return checkForm();">
		<input type="hidden" id="flowInstId" name="flowInstId" value="${flowInstId}" />
		<input type="hidden" id="nodeInstId" name="nodeInstId" value="${nodeInstId}" />
 		<input type="hidden" id="orgCode" name="orgCode" value="${orgCode}" />
		<input type="hidden" id="djId" name="djId" value="${djId}" />
		<fieldset style="display: block; width: 96%; padding: 10px;">
			<legend>
				<b>办理信息</b>
			</legend>
			
			<table border="0" cellpadding="0" cellspacing="0" class="viewTable">

				<%-- 
				<c:if test="${moduleParam.hasIdea eq 'T' }"> --%>
				<tr>
					<td  width="13%">${moduleParam.ideaLabel}<font color="red">*</font></td>
					<td align="left" colspan="4">
						<input type="hidden" name="transidea" value="${obejct.transidea}" id="transidea">
						<select id="ideacode"  name="ideacode" onchange="_getSelectedItemLabel(this)">
						<option VALUE="" >---请选择---</option>
							<c:forEach var="row" items="${cp:LVB(moduleParam.ideaCatalog)}">
								<option value="${row.value}" label="${row.label}" <c:if test="${object.ideacode==row.value}">selected="selected"</c:if>>
									<c:out value="${row.label}" />
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
		<%-- 	</c:if> --%>
				
				<tr>
					<td >发文号<font color="red">*</font></td>
					<td style="width: 120px;">文件类型
						<div>
								<select id="wjlx" name="wjlx" onchange="changeFwh();">
									<option value="">--请选择--</option>
									<c:forEach var="row" items="${cp:LVB('WJLX')}">
										<option value="${row.value}"
											<c:if test="${row.value==wjlx}">selected</c:if>>
											<c:out value="${row.label}" /></option>
									</c:forEach>
								</select>
							<%-- <c:if test="${wjlx!=null}">
								<select id="wjlx" name="wjlx" onchange="changeFwh();">
									<option value="">--请选择--</option>
									<c:forEach var="row" items="${wjlxs}">
										<option value="${row.value}"
											<c:if test="${row.value==wjlx}">selected</c:if>>
											${cp:MAPVALUE("WJLX",row.value)}</option>
									</c:forEach>
								</select>
							</c:if> --%>
						</div>
					</td>
					<td style="width: 70px;">年份
						<div>
							<select id="lshyear" name="lshYear" onchange="changeFwh();"
								style="width: 65px;">
								<c:forEach var="year" items="${year}">
									<option value="${year.id}"
										<c:if test="${year.id==object.lshYear}">selected</c:if>>
										<c:out value="${year.name}" />
									</option>
								</c:forEach>
							</select>
						</div>
					</td>
					<td style="width: 80px;">流水号 
						<div>
							<input type="text" id="lsh" name="lsh" maxlength="6" value="${object.lsh}" style="width:100%"
								onkeyup="change();" />
						</div>
					</td>
					<td>文号<font color="red">（文号的数字部分请与流水号一致）</font>
						<div>
							<input type="text" id="fwh" name="fwh" style="width:50%" value="${fwh}"/>
<%-- 							<font color="red" id="err">${fwherror}</font> --%>
						</div>
					</td>
				</tr>
				<tr>
					<td >办理附件<font>&nbsp;&nbsp;</font></td>
					<td colspan="4">
						<iframe
							id="basicsj" name="sjfj" width="100%" height="100" frameborder="no"
							scrolling="false" border="0" marginwidth="0" marginheight="0"
							src="<%=request.getContextPath()%>/powerruntime/generalOperator!gotosqcl.do?stuffInfo.djId=${djId}&stuffInfo.nodeInstId=0&stuffInfo.groupid=143">
						</iframe>
					</td>
				</tr>
			</table>
		</fieldset>   
		<center style="margin-top: 10px;display:none;" >
			<s:submit id="submitBtn" name="submitBtn" method="submitOpt" cssClass="btn" value="发 送" />
			<c:if test="${moduleParam.canDefer eq 'T' }">
				<s:submit id="suspendBtn" name="suspendBtn" method="suspendNodeInstance" cssClass="btn" value="暂 缓" />
			</c:if>
			<c:if test="${moduleParam.canRollback eq 'T' }">
				<s:submit id="rollBackBtn" name="rollBackBtn" method="rollBackOpt" cssClass="btn" value="回 退" />
			</c:if>
			<c:if test="${moduleParam.canClose eq 'T' }">
				<s:submit id="endFlowBtn" name="endFlowBtn" method="endFlow" cssClass="btn" value="办 结" />
			</c:if>
			<s:submit id="saveBtn" name="saveBtn" method="saveIODocArchiveNoInfo" cssClass="btn" value="保 存" />
			<input id="backBtn" name="backBtn" type="button" value="返回" class="btn"  onclick="window.history.go(-1);"/>	
		</center>    
		</s:form>
</body>
<script type="text/javascript">

//根据值设置select中的选项       
function _getSelectedItemLabel(objSelect) {
    //判断是否存在        
    //var isExit = false;        
    for (var i = 0; i < objSelect.options.length; i++) {
        if ( objSelect.options[i].selected) {
        	document.getElementById("transidea").value=objSelect.options[i].label;
            break;
        }
    }
}


function changeFwh() {
	var wjlx = document.getElementById("wjlx").value;
	var flowinstid = document.getElementById("flowInstId").value;
	var lshyear = document.getElementById("lshyear").value;
	var lsh = document.getElementById("lsh").value;
	var orgCode = $("#orgCode").val();
	$.ajax({
		type : "POST",
		url : "ioDocArchiveNo!change.do?wjlx=" + wjlx+"&flowInstId="+flowinstid+"&lshYear=" + lshyear + "&lsh=" + lsh+"&orgCode="+orgCode,
		dataType : "json",
		success : function(data) {
			//alert(data.wh);
			document.getElementById("fwh").value = data.wh;
			document.getElementById("lsh").value = data.newlsh;
		},
		error : function() {
			alert("失败");
		}

	});
}

function change() {
	var wjlx = document.getElementById("wjlx").value;
	var flowinstid = document.getElementById("flowInstId").value;
	var lshyear = document.getElementById("lshyear").value;
	var lsh = document.getElementById("lsh").value;
	var orgCode = $("#orgCode").val();
	$.ajax({
		type : "POST",
		url : "ioDocArchiveNo!changeFwh.do?wjlx=" + wjlx +"&flowInstId="+flowinstid+"&lshYear=" + lshyear + "&lsh=" + lsh+"&orgCode="+orgCode,
		dataType : "json",
		success : function(data) {
			//alert(data.wh);
			document.getElementById("fwh").value = data.wh;
		},
		error : function() {
			alert("失败");
		}

	});
}



function checkForm(){
	
	
	
	if(trim(_get('ideacode').value).length==0){
		alert("请选择处理结果。");
		_get('ideacode').focus();
		return false;
	}
	/* if(trim(_get('transcontent').value).length==0){
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
		if($("#ideacode").val()== 'T' || $("#ideacode")==undefined){
			if(trim(_get('curTemplateId').value).length==0){
				alert("${moduleParam.documentLabel}不能为空。");
				return false;
			}
		}
	} */

	submitBizData();
	return true;
}
//保存业务数据，在提交办理的时候，同时提交
function submitBizData(){
	
	if(window.parent.frames['viewFrame'].document.forms[0] != undefined){
		
		window.parent.frames['viewFrame'].document.forms[0].submit();
	}
}

var _get = function (id) {
	return document.getElementById(id);
};

//字符空格处理
var trim = function (str) {
	return str.replace(/^\s+|\s+$/g, "");
};
</script>
</html>