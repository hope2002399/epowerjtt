<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="发件人信息编辑" /></title>
</head>
<body>
	<%@ include file="/page/common/messages.jsp"%>
	<s:form action="optPickupMessage" method="post"
		namespace="/powerruntime" name="optPickupMessage"
		id="optPickupMessageForm" enctype="multipart/form-data">
		<input type="hidden" name="pickupid" value="${object.pickupid}"
			id="pickupid" />
		<fieldset style="padding: 10px; display: block; margin-bottom: 10px;">
			<legend style="padding: 4px 8px 3px;">
				<b>收件人信息编辑 </b>
			</legend>
			<s:submit id="save" method="save" onclick="return docheck();"
				cssClass="btn" value="保存并提交" />
			<input type="button" name="reset" value="返回" class="btn"
				onclick="goback();" />
			<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
				<tr>
					<td class="addTd" style="width: 15%"><h4>
							<span style="color: red">*</span>收件人姓名
						</h4></td>
					<td align="left" style="width: 35%"><input type="text"
						name="rcvname" id="rcvname" value="${object.rcvname}"
						maxlength="20"></td>
					<td class="addTd" style="width: 15%"><h4>
							<span style="color: red">*</span>收件人省
						</h4></td>
					<td align="left"><input type="text" id="rcvprov"
						name="rcvprov" value="${object.rcvprov}" maxlength="5" /></td>
				</tr>
				<tr>
					<td class="addTd" style="width: 15%"><h4>
							<span style="color: red">*</span>收件人市
						</h4></td>
					<td align="left" style="width: 35%"><input type="text"
						id="rcvcity" name="rcvcity" value="${object.rcvcity}"
						maxlength="5" /></td>
					<td class="addTd" style="width: 15%"><h4>
							<span style="color: red">*</span>收件人区县
						</h4></td>
					<td align="left"><input type="text" id="rcvcountry"
						name="rcvcountry" value="${object.rcvcountry}" maxlength="5" /></td>
				</tr>
				<tr>
					<td class="addTd" style="width: 15%"><h4>
							<span style="color: red">*</span>收件人手机
						</h4></td>
					<td align="left" style="width: 35%"><input type="text"
						id="rcvphone" name="rcvphone" value="${object.rcvphone}"
						maxlength="15" /></td>
					<td class="addTd" style="width: 15%"><h4>收件人联系电话</h4></td>
					<td align="left"><input type="text" name="rcvcall"
						id="rcvcall" value="${object.rcvcall}" maxlength="30" /></td>
				</tr>
				<tr>
					<td class="addTd" style="width: 15%"><h4>
							<span style="color: red">*</span>收件人邮编
						</h4></td>
					<td align="left" colspan="3"><input type="text"
						id="rcvpostcode" name="rcvpostcode" value="${object.rcvpostcode}"
						maxlength="6" /></td>
				</tr>
				<tr>
					<td class="addTd" style="width: 15%"><h4>
							<span style="color: red">*</span>收件地址
						</h4></td>
					<td align="left" colspan="3"><s:textarea name="rcvstrect"
							id="rcvstrect" style="width:85%;height: 60px;"></s:textarea></td>
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
		if ($('#rcvname').val() == "") {
			alert("收件人不能为空");
			return false;
		}
		if ($('#rcvprov').val() == "") {
			alert("收件人省不能为空");
			return false;
		}
		if ($('#rcvcity').val() == "") {
			alert("收件人市不能为空");
			return false;
		}
		if ($('#rcvcountry').val() == "") {
			alert("收件人区县不能为空");
			return false;
		}
		if ($('#rcvphone').val() == "") {
			alert("收件人手机不能为空");
			return false;
		}
		if ($('#rcvstrect').val() == "") {
			alert("收件地址不能为空");
			return false;
		}
		if ($('#rcvpostcode').val() == "") {
			alert("收件人邮编不能为空");
			return false;
		}
	}
</script>
</html>