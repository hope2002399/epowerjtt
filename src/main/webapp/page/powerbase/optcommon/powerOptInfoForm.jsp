<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>编辑权力流程、风险</title>
</head>
<script type="text/javascript">
	/**
	 * common window dialogs
	 */
	function openNewWindow(winUrl, winName, winProps) {
		if (winProps == '' || winProps == null) {
			winProps = 'height=600px,width=700px,directories=false,location=false,top=100,left=500,menubar=false,Resizable=yes,scrollbars=yes,toolbar=false';
		}
		window.open(winUrl, winName, winProps);
	}
	var _get = function(id) {
		return document.getElementById(id);
	};
	//置空风险点信息
	function doclear() {
		_get('riskId').value = 0;
		_get('riskdes').value = '';
	}
	function doBackPower(url){
		document.location.href = url;
		
	}
</script>
<body>


	<%@ include file="/page/common/messages.jsp"%>

	<s:form action="powerOptInfo" method="post" namespace="/powerbase"
		id="powerOptInfoForm">
		<s:submit name="save" method="save" cssClass="btn" key="opt.btn.save" />
	<input type="button"  value="返回" Class="btn" onclick="window.history.back()" />
<fieldset style="padding:10px;display:block;margin-bottom:10px;">
	<legend class="ctitle" style="width:auto;padding:4px 8px 3px;"><b>编辑权力流程、风险</b></legend>
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="viewTable">
<input type="hidden" id="itemId" name="itemId" value="${object.itemId}" />
			<tr>
				<td class="addTd" width="130">流程代码</td>
				<td align="left"><select name="wfcode" style="width: 200px">

						<c:forEach var="row" items="${flowDescribesList}">
							<option value="${row.value}"
								<c:if test="${object.wfcode eq row.value}"> selected = "selected" </c:if>>
								<c:out value="${row.label}" />
							</option>
						</c:forEach>
				</select> <span style="color: red">*</span></td>
			</tr>

			<tr>
				<td class="addTd" width="130">风险点</td>
				<td align="left"><input type="hidden" id="riskId" name="riskid"
					value="${object.riskInfo.riskid}"> <input type="text"
					id="riskdes" name="object.riskInfo.riskdes"
					value="${object.riskInfo.riskdes}" style="width: 400px;"
					readonly="readonly"> <input type="button" class='btn'
					name="powerBtn"
					onClick="openNewWindow('<%=request.getContextPath()%>/powerruntime/riskInfo!listSelect.do?riskid=${object.riskid}','powerWindow',null);"
					value="选择"> <input type="button" class='btn'
					name="powerBtn" onClick="doclear();" value="清除"></td>
			</tr>
			<tr>
				<td class="addTd" width="130">材料分组</td>
				<td align="left"><select name="group_id" style="width: 200px">
						<option value="">--请选择--</option>
						<c:forEach var="row" items="${groupList}">
							<option value="${row.value}"
								<c:if test="${object.group_id eq row.value}"> selected = "selected" </c:if>>
								<c:out value="${row.label}" />
							</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="addTd" width="130">申请事项类别</td>
				<td align="left"><select name="applyItemType"
					style="width: 200px">
						<option value="">--请选择--</option>
						<c:forEach var="row" items="${cp:DICTIONARY('APPLYITEM')}">
							<option value="${row.key}"
								<c:if test="${object.applyItemType eq row.key}"> selected = "selected" </c:if>>
								<c:out value="${row.value}" />
							</option>
						</c:forEach>
				</select></td>
			</tr>
	<tr>
				<td class="addTd" width="130">模版名称</td>
				<td align="left"><select name="recordid"
					style="width: 200px">
						<option value="">--请选择--</option>
						<c:forEach var="row" items="${templatelist}">
							<option value="${row.value}"
								<c:if test="${object.recordid eq row.value}"> selected = "selected" </c:if>>
								<c:out value="${row.label}" />
							</option>
						</c:forEach>
				</select></td>
			</tr>
		</table>
</fieldset>

	</s:form>