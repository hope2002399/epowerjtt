<%@page import="com.goldgrid.weboffice.TemplateService"%>
<%@ page contentType="text/html;charset=UTF-8"  import="java.util.*" %>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>办理信息</title>
<sj:head locale="zh_CN" />
<script type="text/javascript">
function checkForm(){
	if(trim(_get('operatorResult').value).length==0){
		alert("请选择处理结果。");
		_get('operatorResult').focus();
		return false;
	}
	if(trim(_get('operatorOpinion').value).length==0){
		alert("意见不能为空。");
		_get('operatorOpinion').focus();
		return false;
	}
	if(_get('bjCodes') != undefined && '${moduleParam.assignTeamRole}' == 'T'){	
		if($("#bjUserNames").val()==''&&$("#bjUserNames").parent("td").parent("tr").css("display")=='block'){			
			alert("${moduleParam.teamRoleName}不能为空。");			
			return false;
		}	
	}
	return true;
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

//保存业务数据，在提交办理的时候，同时提交
function submitBizData(){
	window.parent.frames['viewFrame'].document.forms[0].submit();
}
</script>
<body>
<s:form action="%{actionName}" method="post" namespace="/complaint" id="complaintForm" target="_parent" onsubmit="return checkForm();">
<input type="hidden" id="flowInstId" name="flowInstId" value="${flowInstId}" />
<input type="hidden" id="complaintid" name="complaintid"  value="${complaintid}" />
<input type="hidden" id="complaintId" name="complaintId"  value="${complaintid}" />
<input type="hidden" id="nodeInstId" name="nodeInstId" value="${nodeInstId}">
<input type="hidden" id="transidea" name="transidea" value="">
			<c:if test="${not empty object.apply.no or not empty object.punish.no}">			
			<p align="center" style="font-size: 20; color: #01A6E0;">关于<c:if test="${object.bjType=='1'}">${object.apply.transactAffairName}</c:if><c:if test="${object.bjType=='2'}">${object.punish.content}</c:if>的投诉		
			</p>
			</c:if>
<fieldset style=" display: block; padding: 10px;">
			<legend>
				<b>${nodeName}</b>
			</legend>				
			<table border="0" cellpadding="0" cellspacing="0" id="tb" class="viewTable" style="margin-top: 20px;">
			<c:if test="${not empty moduleParam.ideaLabel}">
				<tr>
					<td class="addTd" width="13%">${moduleParam.ideaLabel}<font color="red">*</font></td>
					<td align="left" width="87%">
					
						<select id="operatorResult"  name="operatorResult" onchange="_getSelectedItemLabel(this)">
						<option VALUE="" >---请选择---</option>
							<c:forEach var="row" items="${cp:DICTIONARY(moduleParam.ideaCatalog)}">
								<option value="${row.key}" label="${row.value}" <c:if test="${operatorResult==row.value}">selected="selected"</c:if>>
									<c:out value="${row.datadesc}" />
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				</c:if>
				<c:if test="${not empty moduleParam.ideaContent}">
				<tr>
					<td class="addTd" width="140">${moduleParam.ideaContent}<font color="red">*</font></td>
					<td align="left">
						<s:textarea id="operatorOpinion"
								name="operatorOpinion" style="width:100%; height:40px;" value="%{operatorOpinion}"/>
					</td>
				</tr>
				</c:if>
						        <!-- 办件角色 -->
				<c:if test="${moduleParam.assignTeamRole eq 'T' }">
					<tr>
					<td class="addTd" width="140">${moduleParam.teamRoleName}<font color="red">*</font></td>
					<td align="left">
							<input type="text" id="bjUserNames" name="bjUserNames" style="width:100%;" value="${bjUserNames}"  readonly="readonly" />
							<input type="hidden" id="bjCodes" name="teamRoles" value="${teamUserCodes}" />
							<input type="hidden" id="roleCode" name="roleCode" value="${moduleParam.teamRoleCode}" />
										</td>
					</tr>
				</c:if>
			<c:if test="${moduleParam.hasStuff eq 'T' }">
					<tr>
					<td colspan="2" style="padding-bottom:8px;">
						<iframe id="basicsj"  name="sjfj"
								src="" width="100%" height=""
							frameborder="no" scrolling="false" border="0" marginwidth="0"
							marginheight="0"></iframe>
					</td></tr>
				
			</c:if>
			</table>
		</fieldset>
		
		<center style="margin-top: 10px;display:none;" >
			<s:submit id="submitBtn" name="submitBtn" method="%{submitOptURI}" cssClass="btn" value="发 送" />
			<c:if test="${moduleParam.canDefer eq 'T' }">
				<s:submit id="suspendBtn" name="suspendBtn" method="suspendNodeInstance" cssClass="btn" value="暂 缓" />
			</c:if>
			<c:if test="${moduleParam.canRollback eq 'T' }">
				<s:submit id="rollBackBtn" name="rollBackBtn" method="rollBackOpt" cssClass="btn" value="回 退" />
			</c:if>
			<c:if test="${moduleParam.canClose eq 'T' }">
				<s:submit id="endFlowBtn" name="endFlowBtn" method="endFlow" cssClass="btn" value="办 结" />
			</c:if>
			<s:submit id="saveBtn" name="saveBtn" method="%{saveOptURI}" cssClass="btn" value="保 存" />
			<input id="backBtn" name="backBtn" type="button" value="返回" class="btn"  onclick="window.history.go(-1);"/>	
		</center>
		</s:form>
	
</body>
<script type="text/javascript">
$("#bjUserNames").click(function(){
	var d = '${userjson}';
	if(d.trim().length){
		window.parent.selectPopWin(jQuery.parseJSON(d),$("#bjUserNames"),$("#bjCodes"));
	};
});
//取消保存功能
window.parent.hiddSaveBtn();

$("#operatorResult").change(function(e){
	if($("#operatorResult").val() == "D"){
		window.parent.location.href = "<%=request.getContextPath()%>/complaint/complaint!fromComplaint.do?optId=supervise&bjType=3&complaintid=${complaintid}&flowInstId=${flowInstId}&nodeInstId=${nodeInstId}&operatorResult=D&operatorOpinion=$('#operatorOpinion').val()";
	}
	
});
</script>
<c:if test="${moduleParam.hasStuff eq 'T' }">
<script type="text/javascript">
$("#bjUserNames").parent("td").parent("tr").attr("style","display:block");
$("#operatorResult").change(function(e){
	if($("#bjUserNames").length>0){
		if($("#operatorResult").val()!="T"){
			$("#bjUserNames").parent("td").parent("tr").attr("style","display:none");
		}else{
			$("#bjUserNames").parent("td").parent("tr").attr("style","display:block");
		}
	}
});
var url='<%=request.getContextPath()%>/powerruntime/generalOperator!gotosqcl.do?stuffInfo.djId=${djId}&stuffInfo.nodeInstId=${nodeInstId}&stuffInfo.groupid=${moduleParam.stuffGroupId}&nodeInstId=${nodeInstId}';
var obj = document.getElementById("basicsj");
obj.src = url;
obj.onload = function(){
	obj.style.height = window.frames['sjfj'].document.body.scrollHeight+"px";
};
</script>
</c:if>
</html>