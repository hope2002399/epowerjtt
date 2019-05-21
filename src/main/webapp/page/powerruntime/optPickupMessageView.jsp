<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="收件人信息查看" /></title>
</head>
<body>
	<%@ include file="/page/common/messages.jsp"%>
	<input type="button" name="reset" value="返回" class="btn"
		onclick="goback();" />
	<fieldset style="padding: 10px; display: block; margin-bottom: 10px;">
		<legend style="padding: 4px 8px 3px;">
			<b>收件人信息</b>
		</legend>
		<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
			<tr>
				<td class="addTd" style="width: 15%"><h4>收件人姓名</h4></td>
				<td align="left" style="width: 35%"><c:out
						value="${object.rcvname}" /></td>
				<td class="addTd" style="width: 15%"><h4>收件人省</h4></td>
				<td align="left"><c:out value="${object.rcvprov}" /></td>
			</tr>
			<tr>
				<td class="addTd" style="width: 15%"><h4>收件人市</h4></td>
				<td align="left" style="width: 35%"><c:out
						value="${object.rcvcity}" /></td>
				<td class="addTd" style="width: 15%"><h4>收件人区县</h4></td>
				<td align="left"><c:out value="${object.rcvcountry}" /></td>
			</tr>
			<tr>
				<td class="addTd" style="width: 15%"><h4>收件人手机</h4></td>
				<td align="left" style="width: 35%"><c:out
						value="${object.rcvphone}" /></td>
				<td class="addTd" style="width: 15%"><h4>收件人联系电话</h4></td>
				<td align="left"><c:out value="${object.rcvcall}" /></td>
			</tr>
			<tr>
				<td class="addTd" style="width: 15%"><h4>收件人邮编</h4></td>
				<td align="left" colspan="3"><c:out
						value="${object.rcvpostcode}" /></td>
			</tr>
			<tr>
				<td class="addTd" style="width: 15%"><h4>收件地址</h4></td>
				<td align="left" colspan="3"><c:out
						value="${object.rcvstrect }" /></td>
			</tr>
		</table>
	</fieldset>
</body>
<script type="text/javascript">
	function goback() {
		return history.go(-1);
	}
</script>
</html>