<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="发件人信息编辑" /></title>
</head>
<body>
	<%@ include file="/page/common/messages.jsp"%>
	<s:form action="optSendMessage" method="post" namespace="/powerruntime"
		name="optSendMessage" id="optSendMessageForm"
		enctype="multipart/form-data">
		<input type="hidden" name="sendid" value="${object.sendid}"
			id="sendid" />
		<fieldset style="padding: 10px; display: block; margin-bottom: 10px;">
			<legend style="padding: 4px 8px 3px;">
				<b>发件人信息编辑</b>
			</legend>
			<s:submit id="save" method="save" onclick="return docheck();"
				cssClass="btn" value="保存并提交" />
			<input type="button" name="reset" value="返回" class="btn"
				onclick="goback();" />
			<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
				<tr>
					<td class="addTd" style="width: 15%"><h4>
							<span style="color: red">*</span>发件人
						</h4></td>
					<td align="left" style="width: 35%"><input type="text"
						name="sendname" id="sendname" value="${object.sendname}"
						maxlength="20"></td>
					<td class="addTd" style="width: 15%"><h4>
							<span style="color: red">*</span>发件人省
						</h4></td>
					<td align="left"><input type="text" id="sendprov"
						name="sendprov" value="${object.sendprov}" maxlength="5" /></td>
				</tr>
				<tr>
					<td class="addTd" style="width: 15%"><h4>
							<span style="color: red">*</span>发件人市
						</h4></td>
					<td align="left" style="width: 35%"><input type="text"
						id="sendcity" name="sendcity" value="${object.sendcity}"
						maxlength="5" /></td>
					<td class="addTd" style="width: 15%"><h4>
							<span style="color: red">*</span>发件人区县
						</h4></td>
					<td align="left"><input type="text" id="sendCountry"
						name="sendCountry" value="${object.sendCountry}" maxlength="5" />
					</td>
				</tr>
				<tr>
					<td class="addTd" style="width: 15%"><h4>
							<span style="color: red">*</span>发件人手机
						</h4></td>
					<td align="left" style="width: 35%"><input type="text"
						id="sendphone" name="sendphone" value="${object.sendphone}"
						maxlength="15" /></td>
					<td class="addTd" style="width: 15%"><h4>发件人联系电话</h4></td>
					<td align="left"><input type="text" id="sendcall"
						name="sendcall" value="${object.sendcall}" maxlength="30" /></td>
				</tr>
				<tr>
					<td class="addTd" style="width: 15%"><h4>
							<span style="color: red">*</span>发件地址
						</h4></td>
					<td align="left" colspan="3"><s:textarea name="sendstrect"
							id="sendstrect" style="width:85%;height: 60px;"></s:textarea></td>
				</tr>
			</table>
		</fieldset>
	</s:form>
</body>
<script type="text/javascript">
	function goback() {
		return history.go(-1);
	}
	function docheck() {
		if ($('#sendname').val() == "") {
			alert("发件人不能为空");
			return false;
		}
		if ($('#sendprov').val() == "") {
			alert("发件人省不能为空");
			return false;
		}
		if ($('#sendcity').val() == "") {
			alert("发件人市不能为空");
			return false;
		}
		if ($('#sendCountry').val() == "") {
			alert("发件人区县不能为空");
			return false;
		}
		if ($('#sendphone').val() == "") {
			alert("发件人手机不能为空");
			return false;
		}
		if ($('#sendstrect').val() == "") {
			alert("发件地址不能为空");
			return false;
		}
	}
</script>
</html>