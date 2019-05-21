<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="generalModuleParam.edit.title" /></title>
</head>

<body onload="doInitial();">
	<p class="ctitle">
		<s:text name="generalModuleParam.edit.title" />
	</p>

	<%@ include file="/page/common/messages.jsp"%>

	<s:form action="generalModuleParam" method="post"
		namespace="/powerruntime" id="generalModuleParamForm" onsubmit="return docheck();">
		<s:submit name="save" method="save" cssClass="btn" key="opt.btn.save" />
		<input type="button"  value="返回" Class="btn" onclick="window.history.back()" />

		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="viewTable">
			<tr>
				<td class="addTd" width="130">环节名称</td>
			<td align="left" colspan="3"><s:textfield name="nodeName" size="40"
						value="%{object.nodeName}" /><span style="color: red">*</span></td>
			</tr>
			<tr>
				<td class="addTd" width="130">模块代码</td>
				<td align="left" colspan="3">
				<c:if test="${empty object.moduleCode}">
				<s:textfield name="moduleCode"	size="40" value="%{object.moduleCode}"/> <span style="color: red">*</span>
				</c:if>
				<c:if test="${not empty object.moduleCode}">
				<input type="hidden" id="moduleCode" name="moduleCode"  value="${object.moduleCode}" />
				<s:property value="%{object.moduleCode}" />
				</c:if>
			</tr>

			<tr>
			</td>

				<td class="addTd" width="130">结果标签</td>
				<td align="left" colspan="3"><s:textfield name="ideaLabel" size="40"
						value="%{object.ideaLabel}" /></td>
			</tr>

			<tr>
				<td class="addTd" width="130">结果代码</td>
				<td align="left" colspan="3">
					<s:textfield name="ideaCatalog" size="40" value="%{object.ideaCatalog}" />&nbsp;&nbsp;
				<input type="checkbox"  name="hasIdea" value="F"
				<c:if test="${object.hasIdea eq 'F' }">checked="checked"</c:if> onclick="doInitial();"/>屏蔽
					&nbsp;&nbsp;<font color="red" size="2">(*勾选后，该步骤办理界面将不显示办理结果信息)</font>
				</td>
			</tr>
			
			<tr>
				<td class="addTd" width="130">内容标签</td>
				<td align="left" colspan="3"><s:textfield name="ideaContent" size="40"
						value="%{object.ideaContent}" /></td>
			</tr>
<tr>
				<td class="addTd" width="130">风险类别</td>
				<td align="left" colspan="3"><input type="hidden" id="riskId" name="riskId"
					value="${object.riskInfo.riskid}"> 
					<input type="text" id="riskdes" name="object.riskInfo.riskdes"
					value="${object.riskInfo.riskdes}" style="width: 400px;"
					readonly="readonly"> 
					<input type="button" class='btn' name="powerBtn"
					onClick="openNewWindow('<%=request.getContextPath()%>/powerruntime/riskInfo!listSelect.do?riskid=${object.riskInfo.riskid}','powerWindow',null);"
					value="选择"> 
					<input type="button" class='btn' name="powerBtn" onClick="doclear();" value="清除"></td>
			</tr>
		<%-- 	<tr>
				<td class="addTd" width="130">提交方法名</td>
				<td align="left"><s:textfield name="submitOptURI" size="40"
						value="%{object.submitOptURI}" /></td>
			</tr>
			<tr>
				<td class="addTd" width="130">保存方法名</td>
				<td align="left"><s:textfield name="saveOptURI" size="40"
						value="%{object.saveOptURI}" /></td>
			</tr> --%>
			<tr>
				<td class="addTd" width="130">节点操作配置</td>
				<td align="left" colspan="3">			
				<input type="checkbox"  name="canDefer" value="T"
				<c:if test="${object.canDefer eq 'T' }">checked="checked"</c:if>/>是否可以暂缓
				<input type="checkbox"  name="canRollback" value="T"
				<c:if test="${object.canRollback eq 'T' }">checked="checked"</c:if>/>是否可以回退
				<input type="checkbox"  name="canClose" value="T"
				<c:if test="${object.canClose eq 'T' }">checked="checked"</c:if>/>是否可以结束流程
				</td>
			</tr>
			<tr>
				<td class="addTd" width="130">分块配置</td>
				<td align="left" colspan="3">
				<input type="checkbox"  name="hasAttention" value="T"
				<c:if test="${object.hasAttention eq 'T' }">checked="checked"</c:if> onclick="doInitial();"/>是否有关注
				<input type="checkbox"  name="hasDocument" value="T"
				<c:if test="${object.hasDocument eq 'T' }">checked="checked"</c:if> onclick="doInitial();"/>是否有文书
				<input type="checkbox"  name="assignTeamRole" value="T"
				<c:if test="${object.assignTeamRole eq 'T' }">checked="checked"</c:if> onclick="doInitial();"/>是否指定办件角色
				<input type="checkbox"  name="hasStuff" value="T"
				<c:if test="${object.hasStuff eq 'T' }">checked="checked"</c:if> onclick="doInitial();"/>是否有附件
			</td>
			</tr>
			<tr id="hasAttention_tr">
				<td class="addTd" width="130">关注标签</td>
				<td align="left"><s:textfield name="attentionLabel" size="40"
						value="%{object.attentionLabel}" /></td>
			</tr>
		
			<tr id="hasAttention_tr_1">
				<td class="addTd" width="130">人员筛选表达式</td>
				<td align="left"><s:textfield name="attentionFilter"  value="%{object.attentionFilter}" size="40"/></td>
			</tr>
		
			<tr id="hasDocument_tr_1">
				<td class="addTd" width="130">文书标签</td>
				<td align="left"><s:textfield name="documentLabel" size="40"
						value="%{object.documentLabel}" /></td>
			</tr>

			<tr id="hasDocument_tr_2">
				<td class="addTd" width="130">文书类别</td>
				<td align="left">
						<select id="documentType" name="documentType">
						<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('TEMPLATE_TYPE')}">
								<option value="${row.key}" label="${row.value}"  <c:if test="${object.documentType eq row.key}"> selected = "selected" </c:if>>
								<c:out value="${row.value}" /></option>
							</c:forEach>
							</select>
						</td>
			</tr>

			<tr id="hasDocument_tr_3">
				<td class="addTd" width="130">文书模板</td>
				<td align="left" colspan="3"><s:hidden id="documentTemplateIds" name="documentTemplateIds"  value="%{object.documentTemplateIds}" />
						<textarea id="documentTemplateNames" name="documentTemplateNames" cols="80" readonly="true"
						rows="2" style="width: 400px;;height:40px;">${object.documentTemplateNames}</textarea>
			<input type="button" class='btn' name="powerBtn"
					onClick="openNewWindow('<%=request.getContextPath()%>/powerruntime/templateFile!listSelect.do','powerWindow',null);"
					value="选择">
					<input type="button" class='btn' name="powerBtn" onClick="clearTemplate();" value="清除"></td>
				</td>
			</tr>		

		
			<tr id="assignTeamRole_tr_1">
				<td class="addTd" width="130">办件角色代码</td>
				<td align="left">
				<select name="teamRoleCode" style="width:180px">
							 	<option value=""></option>
								<c:forEach var="row" items="${cp:DICTIONARY('WFTeamRole')}">
									<option value="${row.key}" <c:if test="${object.teamRoleCode eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" /></option>
								</c:forEach>
						</select>		
						</td>	
			</tr>
		
			<tr id="assignTeamRole_tr_2">
			<td class="addTd" width="130">办件角色名称</td>
				<td align="left"><s:textfield name="teamRoleName" size="40"
						value="%{object.teamRoleName}" /></td>
			</tr>		

		
			<tr id="assignTeamRole_tr_3">				
				<td class="addTd" width="130">办件角色筛选表达式</td>
				<td align="left" colspan="3"><s:textfield name="teamRoleFilter" value="%{object.teamRoleFilter}" size="40"/></td>
			</tr>
		<tr id="hasStuff_tr">
				<td class="TDTITLE">附件材料分组</td>
				<td align="left" colspan="3"><s:textfield name="stuffGroupName" size="40" id="stuffGroupName" value="%{stuffGroupName}"
						readonly="true"/>
						<s:hidden name="stuffGroupId" value="%{object.stuffGroupId}" id="stuffGroupId"> </s:hidden><input type="button" class='btn' name="powerBtn"
					onClick="openNewWindow('<%=request.getContextPath()%>/powerruntime/generalOperator!selectstuffGroup.do',null,null);"
					value="选择"> </td>				
			</tr>
		</table>
	</s:form>
</body>
<script type="text/javascript">
	function openNewWindow(winUrl, winName, winProps) {
		if (winProps == '' || winProps == null) {
			winProps = 'height=600px,width=700px,directories=false,location=false,top=100,left=500,menubar=false,Resizable=yes,scrollbars=yes,toolbar=false';
		}
		window.open(winUrl, winName, winProps);
	}
	function docheck() {
		if (trim(_get('nodeName').value).length == 0) {
			alert("环节名称不可为空！");
			_get('nodeName').focus();
			return false;
		}	
		if (trim(_get('moduleCode').value).length == 0) {
			alert("模块代码不可为空！");
			_get('moduleCode').focus();
			return false;
		}		
		return true;
	}

	var _get = function(id) {
		return document.getElementById(id);
	};

	//字符空格处理
	var trim = function(str) {
		return str.replace(/^\s+|\s+$/g, "");
	};

	function doInitial() {
		var hasAttention_tr = _get('hasAttention_tr');
		var hasAttention_tr_1 = _get('hasAttention_tr_1');
		
		var hasDocument_tr_1 = _get('hasDocument_tr_1');
		var hasDocument_tr_2 = _get('hasDocument_tr_2');
		var hasDocument_tr_3 = _get('hasDocument_tr_3');
		
		var assignTeamRole_tr_1 = _get('assignTeamRole_tr_1');
		var assignTeamRole_tr_2 = _get('assignTeamRole_tr_2');
		var assignTeamRole_tr_3 = _get('assignTeamRole_tr_3');
		
		var hasStuff_tr=_get('hasStuff_tr');
		//关注
		//alert(_get('hasAttention').checked);
		if(_get('hasAttention').checked){
			hasAttention_tr.style.display = "block";	
			hasAttention_tr_1.style.display = "block";
		}else{
			hasAttention_tr.style.display = "none";
			hasAttention_tr_1.style.display = "none";
		}
		//文书
		if(_get('hasDocument').checked){
			hasDocument_tr_1.style.display = "block";
			hasDocument_tr_2.style.display = "block";	
			hasDocument_tr_3.style.display = "block";
		}else{
			hasDocument_tr_1.style.display = "none";
			hasDocument_tr_2.style.display = "none";
			hasDocument_tr_3.style.display = "none";
		}
		//办件角色
		if(_get('assignTeamRole').checked){
			assignTeamRole_tr_1.style.display = "block";
			assignTeamRole_tr_2.style.display = "block";	
			assignTeamRole_tr_3.style.display = "block";
		}else{
			assignTeamRole_tr_1.style.display = "none";
			assignTeamRole_tr_2.style.display = "none";
			assignTeamRole_tr_3.style.display = "none";
		}			
		//附件材料
		if(_get('hasStuff').checked){
			hasStuff_tr.style.display = "block";
		}else{
			hasStuff_tr.style.display = "none";
		}
	}
	
	//置空风险点信息
	function doclear(){
		_get('riskId').value=0;
		_get('riskdes').value='';
	}
	
	function clearTemplate(){
		_get('documentTemplateIds').value='';
		_get('documentTemplateNames').value='';
	}
	
	//根据值设置select中的选项       
	function _getSelectedItemLabel(objSelect) {            
	    //判断是否存在        
	    //var isExit = false;        
	    for (var i = 0; i < objSelect.options.length; i++) {        
	        if ( objSelect.options[i].selected) { 	        	
	        	document.getElementById("teamRoleName").value=objSelect.options[i].label;
	            break;        
	        }        
	    } 
	}
	
</script>
</html>