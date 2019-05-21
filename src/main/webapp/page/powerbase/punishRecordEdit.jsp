<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>新增</title>
<script src="<s:url value='/scripts/centit_validator.js'/>"
	type="text/javascript"></script>

<script type="text/javascript"
	src="<s:url value="/scripts/colorbox/jquery.colorbox.js"/>"
	charset="utf-8"></script>
<link
	href="${pageContext.request.contextPath}/scripts/colorbox/colorbox.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/scripts/jquery-ui/jquery-ui-1.9.2.custom.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<s:url value="/scripts/addressBook.js"/>" charset="utf-8"></script>
<script type="text/javascript" src="<s:url value="/scripts/centit.js"/>"
	charset="utf-8"></script>
<script type="text/javascript"
	src="<s:url value="/scripts/jquery-ui/jquery-ui-1.9.2.custom.js"/>"
	charset="utf-8"></script>
<script type="text/javascript"
	src="<s:url value="/scripts/opendiv_Win.js"/>" charset="utf-8"></script>
<script
	src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js"
	type="text/javascript"></script>
<link
	href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<fieldset style="padding: 10px;">
		<legend class="ctitle" style="width: auto; margin-bottom: 5px;">
			<s:text name="修改备案" />
		</legend>

		<s:form action="punishRecord" method="post" validator="true"
			namespace="/powerbase" id="punishRecordForm">
			<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
				<tr>
					<td class="addTd">*部门名称</td>
					<td><input type="hidden" id="org_id" name="org_id"
						value="${punishRecordList[0].org_id }" />
						${cp:MAPVALUE('depno',punishRecordList[0].org_id)}</td>
				</tr>
				<tr>
					<td class="addTd">*部门类型:</td>
					<td><select name="depKind" id=depKind " validator="input"
						min="1" errorshow="请选择部门类型">
							<c:forEach var="row" items="${cp:DICTIONARY('BMLX')}">
								<option value="${row.key}"
									<c:if test="${punishRecordList[0].depKind eq row.key||parameters.s_depKind[0] eq row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
					</td>
				</tr>
				<tr>
					<td class="addTd">*个人罚款限额</td>
					<td><input type="text" id="personNum" name="personNum"
						value="${punishRecordList[0].personNum }" validator="input" regexEnum="num1"
						min="1" errorshow="请输入个人罚款限额" />(元)</td>
				</tr>
				<tr>
					<td class="addTd">*组织机构限额</td>
					<td><input type="text" id="corpNum" name="corpNum"
						value="${punishRecordList[0].corpNum }" validator="input" regex="^[1-9]\\d*|0$"
						errorshow="请输入组织机构限额" />(元)</td>
				</tr>
				<tr>
					<td class="addTd">法律依据</td>
					<td><s:textarea name="lawbasic" /></td>
				</tr>
				<td class="addTd">备注</td>
				<td align="left"><s:textarea name="remark" /></td>
				</tr>
			</table>
			<s:submit name="save" method="updatePunishRecord" cssClass="btn"
				key="opt.btn.save" onclick="return checkInput();" />
			<input type="button" class="btn" value="返回"
				onclick="javascript:history.go(-1);" />
		</s:form>
		<script type="text/javascript">
		function checkInput() {

		

	
	if(isNaN($("#personNum").val())){
		alert("个人罚款限额必须为正确的数字。");
		$("#personNum").focus();
		return false;
	}else if ($("#personNum").val()<0){
		alert("个人罚款限额必须大于0。");
		$("#personNum").focus();
		return false;
	}
	if(isNaN($("#corpNum").val())){
		alert("组织机构限额必须为正确的数字。");
		$("#corpNum").focus();
		return false;
	}else if ($("#corpNum").val()<0){
		alert("组织机构限额必须大于0。");
		$("#corpNum").focus();
		return false;
	}
		

}

</script>
	</fieldset>


</body>
</html>