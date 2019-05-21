<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="快递信息查看" /></title>
</head>
<body>
	<%@ include file="/page/common/messages.jsp"%>
	<input type="button" name="reset" value="返回" class="btn"
		onclick="goback();" />
	<fieldset style="padding: 10px; display: block; margin-bottom: 10px;">
		<legend style="padding: 4px 8px 3px;">
			<b>快递信息编辑</b>
		</legend>
		<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
			<tr>
				<td class="addTd" style="width: 15%">
					<h4>办件编号</h4>
				</td>
				<td align="left" colspan="3"><c:out value="${object.showmore}"></c:out></td>
			</tr>
			<tr>
				<td class="addTd" style="width: 15%"><h4>信封流水号</h4></td>
				<td align="left"><c:out value="${object.emsordno}" /></td>
				<td class="addTd" style="width: 15%"><h4>受理台席名称（窗口号）</h4></td>
				<td align="left"><c:out value="${object.govtbname}" /></td>
			</tr>
			<tr>
				<td class="addTd" style="width: 15%"><h4>邮寄类型</h4></td>
				<td align="left">${cp:MAPVALUE("posttype",object.posttype)}</td>
				<td class="addTd" style="width: 15%"><h4>寄件内容类型</h4></td>
				<td align="left">${cp:MAPVALUE("nettype",object.nettype)}</td>
			</tr>
			<tr>
				<td class="addTd" style="width: 15%"><h4>收费类型</h4></td>
				<td align="left">${cp:MAPVALUE("busstype",object.busstype)}</td>
				<td class="addTd" style="width: 15%"><h4>是否已经寄送</h4></td>
				<td align="left">${cp:MAPVALUE("TrueOrFalse",object.issend)}</td>
			</tr>
			<tr>
				<td class="addTd" style="width: 15%"><h4>取件验证码</h4></td>
				<td align="left"><c:out value="${object.chkcode}" /></td>
				<td class="addTd" style="width: 15%"><h4>邮寄日期</h4></td>
				<td align="left"><fmt:formatDate value="${object.expresstime}"
						pattern="yyyy年MM月dd日" /></td>
			</tr>
			<tr>
				<td class="addTd" style="width: 15%"><h4>邮寄材料说明</h4></td>
				<td align="left" colspan="3"><c:out value="${object.item}"></c:out></td>
			</tr>
		</table>
	</fieldset>
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