<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="发件人信息查看" /></title>
</head>
<body>
	<%@ include file="/page/common/messages.jsp"%>
	<input type="button" name="reset" value="返回" class="btn"
		onclick="goback();" />
	<fieldset style="padding: 10px; display: block; margin-bottom: 10px;">
		<legend style="padding: 4px 8px 3px;">
			<b>发件人信息</b>
		</legend>
		<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
			<tr>
				<td class="addTd" style="width: 15%"><h4>发件人</h4></td>
				<td align="left" style="width: 35%"><c:out
						value="${object.sendname}" /></td>
				<td class="addTd" style="width: 15%"><h4>发件人省</h4></td>
				<td align="left"><c:out value="${object.sendprov}" />
					</div></td>
			</tr>
			<tr>
				<td class="addTd" style="width: 15%"><h4>发件人市</h4></td>
				<td align="left" style="width: 35%"><c:out
						value="${object.sendcity}" />
					</div></td>
				<td class="addTd" style="width: 15%"><h4>发件人区县</h4></td>
				<td align="left"><c:out value="${object.sendCountry}" /></td>
			</tr>
			<tr>
				<td class="addTd" style="width: 15%"><h4>发件人手机</h4></td>
				<td align="left" style="width: 35%"><c:out
						value="${object.sendphone}" /></td>
				<td class="addTd" style="width: 15%"><h4>发件人联系电话</h4></td>
				<td align="left"><c:out value="${object.sendcall}" /></td>
			</tr>
			<tr>
				<td class="addTd" style="width: 15%"><h4>发件地址</h4></td>
				<td align="left" colspan="3"><c:out
						value="${object.sendstrect}" /></td>
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