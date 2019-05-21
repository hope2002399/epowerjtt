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
	if(_get('operatorResult') != undefined){
	if(trim(_get('operatorResult').value).length==0){
		alert("请选择处理结果。");
		_get('operatorResult').focus();
		return false;
	}
	}
	
	
	if(_get('bjCodes') != undefined && '${moduleParam.assignTeamRole}' == 'T'){	
		if($("#bjUserNames").val()==''&& $("#bjUserNames").parent("td").parent("tr").css("display")=='block'){			
			alert("${moduleParam.teamRoleName}不能为空。");			
			return false;
		}	
	}
	
	if(_get('hasIdea') != undefined && '${moduleParam.hasIdea}' == 'T'){	
		if($("#isconfirm").val()==''){			
			alert("请选择反馈是否属实!");			
			return false;
		}
		
		if($("#isExternal_").val()==''){			
			alert("请选择是否客观!");			
			return false;
		}
	}
	
	if(trim(_get('operatorOpinion').value).length==0){
		alert("意见不能为空。");
		_get('operatorOpinion').focus();
		return false;
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
           	if(objSelect.options[i].value==''){
        		document.forms[0].operatorOpinion.value='';
        		alert("请选择${moduleParam.ideaLabel}!");
        		_get('operatorResult').focus();	        		
        	}else{        	
        		if(objSelect.options[i].value=='T'){
            		document.getElementById("isExternal").style.display = "block";
            		document.getElementById("confirm").style.display = "block";
            	}else{
            		document.getElementById("isExternal").style.display = "none";
            		document.getElementById("confirm").style.display = "none";
            	}        		     
        	}        	
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
	<s:form action="%{actionName}" method="post" namespace="/supervise"
		id="superviseForm" target="_parent" onsubmit="return checkForm();">
		<input type="hidden" id="flowInstId" name="flowInstId"
			value="${flowInstId}" />
		<input type="hidden" id="superviseNo" name="superviseNo"
			value="${superviseNo}" />
		<input type="hidden" id="nodeInstId" name="nodeInstId"
			value="${nodeInstId}">
		<input type="hidden" id="transidea" name="transidea" value="">
		<input type="hidden" id="isOrg" name="isOrg" value="${object.isOrg}">
		<c:if
			test="${not empty object.apply.no or not empty object.punish.no}">
			<p align="center" style="font-size: 20; color: #01A6E0;">
				关于对
				<c:if
					test="${object.bjType=='1' or (object.bjType=='3' and not empty object.apply.no)}">${object.apply.transactAffairName}办件</c:if>
				<c:if
					test="${object.bjType=='2' or (object.bjType=='3' and not empty object.punish.no)}">${object.punish.content}处罚</c:if>
				的督办
			</p>
		</c:if>
		<fieldset style="display: block; padding: 10px;">
			<legend>
				<b>${nodeName}</b>
			</legend>
			<table border="0" cellpadding="0" cellspacing="0" id="tb"
				class="viewTable" style="margin-top: 20px;">

				<c:if test="${moduleParam.hasIdea eq 'T' }">
					<tr>
						<td class="addTd" width="13%">${moduleParam.ideaLabel}<font
							color="red">*</font></td>
						<td align="left" width="87%"><select id="operatorResult"
							name="operatorResult" onchange="_getSelectedItemLabel(this)">
								<option VALUE="">---请选择---</option>
								<c:forEach var="row" items="${cp:LVB(moduleParam.ideaCatalog)}">
									<option value="${row.value}" label="${row.label}"
										<c:if test="${operatorResult==row.value}">selected="selected"</c:if>>
										<c:out value="${row.label}" />
									</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr id="confirm">
						<td class="addTd" width="13%">反馈是否属实<font color="red">*</font></td>
						<td align="left" width="87%"><select id="isconfirm"
							name="confirm">
								<c:forEach var="row" items="${cp:LVB('CONFIRM')}">
									<option value="${row.value}" label="${row.label}"
										<c:if test="${confirm==row.value}">selected="selected"</c:if>>
										<c:out value="${row.label}" />
									</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr id="isExternal">
						<td class="addTd" width="13%">是否客观<font color="red">*</font></td>
						<td align="left" width="87%"><select id="isExternal_"
							name="isExternal">
								<c:forEach var="row" items="${cp:LVB('isExternal')}">
									<option value="${row.value}" label="${row.label}"
										<c:if test="${isExternal==row.value}">selected="selected"</c:if>>
										<c:out value="${row.label}" />
									</option>
								</c:forEach>
						</select></td>
					</tr>
				</c:if>
				<tr>
					<td class="addTd" width="140" id="ideacontent">${moduleParam.ideaContent}<font
						color="red">*</font></td>
					<td align="left"><s:textarea id="operatorOpinion"
							name="operatorOpinion" style="width:100%; height:40px;"
							value="%{object.operatorOpinion}" /></td>
				</tr>
				<!-- 办件角色 -->
				<c:if test="${moduleParam.assignTeamRole eq 'T' }">
					<tr>
						<td class="addTd" width="140">${moduleParam.teamRoleName}<font
							color="red">*</font></td>
						<td align="left"><input type="text" id="bjUserNames"
							name="bjUserNames" style="width: 100%;" value="${bjUserNames}"
							readonly="readonly" /> <input type="hidden" id="bjCodes"
							name="teamRoles" value="${teamUserCodes}" /> <input
							type="hidden" id="roleCode" name="roleCode"
							value="${moduleParam.teamRoleCode}" /> <!-- <input type="hidden" id="attType" name="optProcAttention.attType" value="1" /> -->
						</td>
					</tr>
				</c:if>
				<c:if test="${moduleParam.hasStuff eq 'T' }">
					<tr>
						<td colspan="2" style="padding-bottom: 8px;"><iframe
								id="basicsj" name="sjfj" src="" width="100%" height=""
								frameborder="no" scrolling="false" border="0" marginwidth="0"
								marginheight="0"></iframe></td>
					</tr>

				</c:if>
			</table>
		</fieldset>

		<center style="margin-top: 10px; display: none;">
			<s:submit id="submitBtn" name="submitBtn" method="%{submitOptURI}"
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
			<s:submit id="saveBtn" name="saveBtn" method="%{saveOptURI}"
				cssClass="btn" value="保 存" />
			<input id="backBtn" name="backBtn" type="button" value="返回"
				class="btn" onclick="window.history.go(-1);" />
		</center>
	</s:form>

</body>
<c:if test="${moduleParam.moduleCode eq 'db_dbjl' }">
	<script type="text/javascript">
$("#operatorResult").change(function(e){	
		if($("#operatorResult").val()!="T"){
			$("#ideacontent").html("备注"+"<font color='red'>*</font>");
		}else{
			$("#ideacontent").html("${moduleParam.ideaContent}"+"<font color='red'>*</font>");
		}	
});
</script>
</c:if>
<script type="text/javascript">
$("#bjUserNames").click(function(){
	var d = '${userjson}';
	if(d.trim().length){
		window.parent.selectPopWin(jQuery.parseJSON(d),$("#bjUserNames"),$("#bjCodes"));
	};
});
//取消保存功能
window.parent.hiddSaveBtn();
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
var url='<%=request.getContextPath()%>
		/powerruntime/generalOperator!gotosqcl.do?stuffInfo.djId=${djId}&stuffInfo.nodeInstId=${nodeInstId}&stuffInfo.groupid=${moduleParam.stuffGroupId}';
		var obj = document.getElementById("basicsj");
		obj.src = url;
		obj.onload = function() {
			obj.style.height = window.frames['sjfj'].document.body.scrollHeight
					+ "px";
		};
	</script>
</c:if>
</html>