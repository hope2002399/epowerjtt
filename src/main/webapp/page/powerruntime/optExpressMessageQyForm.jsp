<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="快递信息查询" /></title>
<sj:head locale="zh_CN" />
<script src="${pageContext.request.contextPath}/scripts/suggest.js"
	type="text/javascript"></script>
<body>
	<%@ include file="/page/common/messages.jsp"%>
	<s:form action="optExpressMessage" method="post"
		namespace="/powerruntime" name="optExpressMessage"
		id="optExpressMessageForm" enctype="multipart/form-data">
		<input type="hidden" name="expressid" value="${object.expressid}"
			id="expressid" />
		<fieldset style="padding: 10px; display: block; margin-bottom: 10px;">
			<legend style="padding: 4px 8px 3px;">
				<b>快递信息编辑</b>
			</legend>
			<s:submit id="saveAndSubmit" method="qysaveAndSubmit"
				onclick="return check();" cssClass="btn" value="保存并提交" />
			<input type="button" name="reset" value="返回" class="btn"
				onclick="goback();" />
			<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
				<tr>
					<td class="addTd" style="width: 15%">
						<h4>办件编号</h4>
					</td>
					<td align="left" colspan="3"><c:out value="${object.showmore}"></c:out></td>
				</tr>
				<tr>
					<td class="addTd" style="width: 15%"><h4>
							<span style="color: red">*</span>信封流水号
						</h4></td>
					<td align="left"><input type="text" id="emsordno"
						name="emsordno" value="${object.emsordno}" maxlength="30"
						onblur="chkems(this);" /></td>
					<td class="addTd" style="width: 15%"><h4>
							<span style="color: red">*</span>受理台席名称（窗口号）
						</h4></td>
					<td align="left"><input type="text" name="govtbname"
						value="${object.govtbname}" maxlength="30" /></td>
				</tr>
				<tr>
					<td class="addTd" style="width: 15%"><h4>
							<span style="color: red">*</span>邮寄类型
						</h4></td>
					<td align="left"><select name="posttype" style="width: 180px"
						id="posttype">
							<c:forEach var="row" items="${cp:DICTIONARY('posttype')}">
								<option value="${row.key}"
									<c:if test="${object.posttype eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" /></option>
							</c:forEach>
					</select></td>
					<td class="addTd" style="width: 15%"><h4>
							<span style="color: red">*</span>寄件内容类型
						</h4></td>
					<td align="left"><select name="nettype" style="width: 180px"
						id="nettype">
							<c:forEach var="row" items="${cp:DICTIONARY('nettype')}">
								<option value="${row.key}"
									<c:if test="${object.nettype eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" /></option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="addTd" style="width: 15%"><h4>
							<span style="color: red">*</span>收费类型
						</h4></td>
					<td align="left"><select name="busstype" style="width: 180px"
						id="busstype">
							<c:forEach var="row" items="${cp:DICTIONARY('busstype')}">
								<option value="${row.key}"
									<c:if test="${object.busstype eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" /></option>
							</c:forEach>
					</select></td>
					<td class="addTd" style="width: 15%"><h4>
							<span style="color: red">*</span>是否已经寄送
						</h4></td>
					<td align="left"><select name="issend" style="width: 180px"
						id="issend">
							<c:forEach var="row" items="${cp:DICTIONARY('TrueOrFalse')}">
								<option value="${row.key}"
									<c:if test="${object.issend eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" /></option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="addTd" style="width: 15%"><h4>
							<span style="color: red">*</span>取件验证码
						</h4></td>
					<td align="left"><input type="text" name="chkcode"
						value="${object.chkcode}" maxlength="6" readonly="true" /></td>
					<td class="addTd" style="width: 15%"><h4>
							<span style="color: red">*</span>邮寄日期
						</h4></td>
					<td align="left"><sj:datepicker id="expresstime"
							name="expresstime" style="width:140px" yearRange="2000:2020"
							displayFormat="yy-mm-dd" changeYear="true" timepicker="false"
							value="%{object.expresstime}" /></td>
				</tr>
				<tr>
					<td class="addTd" style="width: 15%"><h4>邮寄材料说明</h4></td>
					<td align="left" colspan="3"><s:textarea name="item" id="item"
							style="width:85%;height: 60px;"></s:textarea></td>
				</tr>
			</table>
		</fieldset>
		<fieldset style="padding: 10px; display: block; margin-bottom: 10px;">
			<legend style="padding: 4px 8px 3px;">
				<b>发件人信息编辑</b>
			</legend>
			<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
				<tr>
					<td class="addTd" style="width: 15%"><h4>
							<span style="color: red">*</span>发件人
						</h4></td>
					<td align="left" style="width: 35%"><input type="text"
						name="sendname" id="sendname" value="${object.sendname}"
						maxlength="20">&nbsp;&nbsp;&nbsp;&nbsp;<input
						type="button" class='btn' name="senderBtn"
						onClick="opensendmessage();" value="选择"></td>
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
		<fieldset style="padding: 10px; display: block; margin-bottom: 10px;">
			<legend style="padding: 4px 8px 3px;">
				<b>收件人信息编辑 </b>
			</legend>
			<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
				<tr>
					<td class="addTd" style="width: 15%"><h4>
							<span style="color: red">*</span>收件人姓名
						</h4></td>
					<td align="left" style="width: 35%"><input type="text"
						name="rcvname" id="rcvname" value="${object.rcvname}"
						maxlength="20"> &nbsp;&nbsp;&nbsp;&nbsp;<input
						type="button" class='btn' name="pickupBtn"
						onClick="openpickupmessage();" value="选择"> </span></td>
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
		if ($("#showmore").val() == "") {
			alert("请选择相关办件");
			return false;
		}
		if ($("#emsordno").val() == "") {
			alert("信封流水号");
			return false;
		}
		if ($("#govtbname").val() == "") {
			alert("受理台席名称（窗口号）");
			return false;
		}
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
	function openselect() {
		var bjnumber = $("#bjnumber").val();
		var expressid = $("#expressid").val();
		var showmore = encodeURI(encodeURI($("#showmore").val()));
		var winUrl = "${pageContext.request.contextPath}/powerruntime/applyTask!selectlist.do?bjnumber="
				+ bjnumber
				+ '&expressid='
				+ expressid
				+ '&showmore='
				+ showmore;
		var iWidth = 1000;
		var iHeight = 600;
		openNewWindow(winUrl, "办件列表", iWidth, iHeight);
	}
	function opensendmessage() {
		var winUrl = "${pageContext.request.contextPath}/powerruntime/optSendMessage!selectlist.do?s_state=1";
		var iWidth = 800;
		var iHeight = 600;
		openNewWindow(winUrl, "发件人列表", iWidth, iHeight);
	}

	function openpickupmessage() {
		var winUrl = "${pageContext.request.contextPath}/powerruntime/optPickupMessage!selectlist.do?s_state=1";
		var iWidth = 800;
		var iHeight = 600;
		openNewWindow(winUrl, "收件人列表", iWidth, iHeight);
	}
	function chkems(ems) {
		var expressid = document.getElementById('expressid').value;
		var emsordno = ems.value;

		$
				.ajax({
					type : "POST",
					url : "${pageContext.request.contextPath}/powerruntime/optExpressMessage!checkems.do?emsordno="
							+ emsordno + "&expressid=" + expressid,
					contentType : "text/html",
					dataType : "json",
					processData : false,
					async : false,
					success : function(data) {
						if (data.cades == 'F') {
							document.getElementById('emsordno').value = "";
							alert("违反信封流水号唯一性！");
						}
					}
				});
	}
</script>
</html>