<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
</head>
<sj:head locale="zh_CN" />
<script src="${pageContext.request.contextPath}/scripts/suggest.js"
	type="text/javascript"></script>
<script language="JavaScript"
	src="<%=request.getContextPath()%>/scripts/city-picker.data.js"
	type="text/javascript"></script>
<body>
	<input type="hidden" name="expressid" value="${object.expressid}"
		id="expressid" />
	<input type="hidden" name="djid" value="${object.djid}" id="djid" />
	<input type="hidden" name="isnetApply" value="${object.isnetApply}"
		id="isnetApply" />
	<input type="hidden" name="govtbname" id="govtbname"
		value="${object.govtbname}">
	<input type="hidden" name="issend" id="issend" value="${object.issend}">
	<input type="hidden" name="showmore" id="showmore"
		value="${object.showmore}">
	<fieldset
		style="padding: 10px; display: block; margin-bottom: 10px; width: 97%">
		<legend style="padding: 4px 8px 3px;">
			<b>快递信息编辑</b>
		</legend>
		<input type="button" onclick="saveEms();" class="btn" value="保存" />
		<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
			<tr>
				<td class="addTd" style="width: 15%"><h4>
						<span style="color: red">*</span>信封流水号
					</h4></td>
				<td align="left"><input type="text" id="emsordno"
					name="emsordno" value="${object.emsordno}" maxlength="30"
					onblur="chkems(this);" /><input type="hidden" name="govtbname"
					id="govtbname" value="${object.govtbname}"> <input
					type="hidden" name="issend" id="issend" value="${object.issend}"></td>
				<td class="addTd" style="width: 15%"><h4>
						<span style="color: red">*</span>快递单号
					</h4></td>
				<td align="left"><input type="text" name="mailnum" id="mailnum"
					value="${object.mailnum}" maxlength="20" /></td>
			</tr>
			<tr>
				<td class="addTd" style="width: 15%"><h4>
						<span style="color: red">*</span>受理台席名称（窗口号）
					</h4></td>
				<td align="left"><input type="text" id="govtbname"
					name="govtbname" value="${object.govtbname}" /><input
					type="hidden" name="issend" id="issend" value="${object.issend}"></td>
				<td class="addTd" style="width: 15%"><h4>
						<span style="color: red">*</span>取件验证码
					</h4></td>
				<td align="left"><input type="text" name="chkcode" id="chkcode"
					value="${object.chkcode}" maxlength="6" readonly="true" /></td>
			</tr>
			<tr>
				<td class="addTd" style="width: 15%"><h4>
						<span style="color: red">*</span>邮寄类型
					</h4></td>
				<td align="left"><select name="posttype" style="width: 160px"
					id="posttype">
						<c:forEach var="row" items="${cp:DICTIONARY('posttype')}">
							<option value="${row.key}"
								<c:if test="${object.posttype eq row.key}"> selected = "selected" </c:if>>
								<c:out value="${row.value}" />
							</option>
						</c:forEach>
				</select></td>
				<td class="addTd" style="width: 15%"><h4>
						<span style="color: red">*</span>寄件内容类型
					</h4></td>
				<td align="left"><select name="nettype" style="width: 160px"
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
				<td align="left"><select name="busstype" style="width: 160px"
					id="busstype">
						<c:forEach var="row" items="${cp:DICTIONARY('busstype')}">
							<option value="${row.key}"
								<c:if test="${object.busstype eq row.key}"> selected = "selected" </c:if>>
								<c:out value="${row.value}" /></option>
						</c:forEach>
				</select></td>
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
						style="width:95%;height: 60px;">
					</s:textarea></td>
			</tr>
		</table>
	</fieldset>
	<fieldset
		style="padding: 10px; display: block; margin-bottom: 10px; width: 97%">
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
					placeholder="长度不超过25个字符" maxlength="25"></td>
				<td class="addTd" style="width: 15%"><h4>
						<span style="color: red">*</span>发件人手机
					</h4></td>
				<td align="left" style="width: 35%"><input type="text"
					id="sendphone" name="sendphone" value="${object.sendphone}"
					placeholder="请输入11位合法手机号码" maxlength="11" /><input type="hidden"
					id="sendcall" namd="sendcall" value=""></td>
			</tr>
			<tr>
				<td class="addTd" style="width: 15%"><h4>
						<span style="color: red">*</span>发件人所在省/市/区县
					</h4></td>
				<td align="left" colspan="3"><select name="sendprovname"
					style="width: 160px" id="sendprovname"
					onchange="changeSelectRegion('sendprov')"></select>&nbsp;&nbsp;省&nbsp;&nbsp;<select
					name="sendcityname" style="width: 160px" id="sendcityname"
					onchange="changeSelectRegion('sendcity')"></select>&nbsp;&nbsp;市&nbsp;&nbsp;<select
					name="sendCountryname" style="width: 160px" id="sendCountryname"
					onchange="changeSelectRegion('sendCountry')"></select>&nbsp;&nbsp;区（县）<input
					type="hidden" id="sendprov" name="sendprov" /> <input
					type="hidden" id="sendcity" name="sendcity" /> <input
					type="hidden" id="sendCountry" name="sendCountry" /></td>
			</tr>
			<tr>
				<td class="addTd" style="width: 15%"><h4>
						<span style="color: red">*</span>发件地址
					</h4></td>
				<td align="left" colspan="3"><s:textarea name="sendstrect"
						placeholder="请输入详细收货地址如街道名称、门牌号、楼层和房间号等信息" maxlength="255"
						id="sendstrect" style="width:95%;height: 60px;"></s:textarea></td>
			</tr>
		</table>
	</fieldset>
	<fieldset
		style="padding: 10px; display: block; margin-bottom: 10px; width: 97%">
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
					placeholder="长度不超过25个字符" maxlength="25"></td>
				<td class="addTd" style="width: 15%"><h4>
						<span style="color: red">*</span>收件人手机
					</h4></td>
				<td align="left" style="width: 35%"><input type="text"
					id="rcvphone" name="rcvphone" value="${object.rcvphone}"
					placeholder="请输入11位合法手机号码" maxlength="11" /></td>
			</tr>
			<tr>
				<td class="addTd" style="width: 15%"><h4>
						<span style="color: red">*</span>收件人所在省/市/区县
					</h4></td>
				<td align="left" colspan="3"><select name="rcvprovname"
					onchange="changeSelectRegion('rcvprov')" style="width: 160px"
					id="rcvprovname"></select>&nbsp;&nbsp;省&nbsp;&nbsp;<select
					name="rcvcityname" style="width: 160px" id="rcvcityname"
					onchange="changeSelectRegion('rcvcity')"></select>&nbsp;&nbsp;市&nbsp;&nbsp;<select
					name="rcvcountryname" style="width: 160px" id="rcvcountryname"
					onchange="changeSelectRegion('rcvcountry')"></select>&nbsp;&nbsp;区（县）<input
					type="hidden" id="rcvprov" name="rcvprov" /> <input type="hidden"
					id="rcvcity" name="rcvcity" /> <input type="hidden"
					id="rcvcountry" name="rcvcountry" /></td>

			</tr>
			<tr>
				<td class="addTd" style="width: 15%"><h4>
						<span style="color: red">*</span>收件地址
					</h4></td>
				<td align="left" colspan="3"><s:textarea name="rcvstrect"
						placeholder="请输入详细收货地址如街道名称、门牌号、楼层和房间号等信息" maxlength="255"
						id="rcvstrect" style="width:95%;height: 60px;"></s:textarea></td>
			</tr>
			<tr>
				<td class="addTd" style="width: 15%"><h4>
						<span style="color: red">*</span>收件人邮编
					</h4></td>
				<td align="left"><input type="text" id="rcvpostcode"
					name="rcvpostcode" value="${object.rcvpostcode}"
					placeholder="如不清楚邮政编码，请填写000000" maxlength="6" /></td>
				<td class="addTd" style="width: 15%"><h4>收件人联系电话</h4></td>
				<td align="left"><input type="text" name="rcvcall" id="rcvcall"
					value="${object.rcvcall}" maxlength="30" /></td>
			</tr>
		</table>
	</fieldset>
</body>
<script type="text/javascript">
	$(document).ready(
			function() {
				if ("" != $("#expressid").val()) {
					$("#item").val('${object.item}');
					$("#sendstrect").val('${object.sendstrect}');
					$("#rcvstrect").val('${object.rcvstrect}');
				}
				initAllSelect();
				if ('' == '${object.sendprov}') {
					$("#sendprov").val("江苏省");
					$("#sendprovname").val("320000");
					addAddSelectOption("sendcity", "320000");
				} else {
					var sendprovcode = getLableValueByName(
							'${object.sendprov}', "86");
					$("#sendprovname").val(sendprovcode);
					$("#sendprov").val('${object.sendprov}');
					addAddSelectOption("sendcity", sendprovcode);
					var sendcitycode = getLableValueByName(
							'${object.sendcity}', sendprovcode);
					$("#sendcityname").val(sendcitycode);
					addAddSelectOption("sendCountry", sendcitycode);
					$("#sendcity").val('${object.sendcity}');
					var sendcountrycode = getLableValueByName(
							'${object.sendCountry}', sendcitycode);
					$("#sendCountryname").val(sendcountrycode);
					$("#sendCountry").val('${object.sendCountry}');
				}
				if ('' == '${object.rcvprov}') {
					$("#rcvprov").val("江苏省");
					$("#rcvprovname").val("320000");
					addAddSelectOption("rcvcity", "320000");
				} else {
					var rcvprovcode = getLableValueByName('${object.rcvprov}',
							"86");
					$("#rcvprovname").val(rcvprovcode);
					$("#rcvprov").val('${object.rcvprov}');
					addAddSelectOption("rcvcity", rcvprovcode);
					var rcvcitycode = getLableValueByName('${object.rcvcity}',
							rcvprovcode);
					$("#rcvcityname").val(rcvcitycode);
					addAddSelectOption("rcvcountry", rcvcitycode);
					$("#rcvcity").val('${object.rcvcity}');
					var rcvcountrycode = getLableValueByName(
							'${object.rcvcountry}', rcvcitycode);
					$("#rcvcountryname").val(rcvcountrycode);
					$("#rcvcountry").val('${object.rcvcountry}');
				}
			})
	var initAllSelect = function() {
		addAddSelectOption("sendprov", "86");
		addAddSelectOption("sendcity", "");
		addAddSelectOption("sendCountry", "");
		addAddSelectOption("rcvprov", "86");
		addAddSelectOption("rcvcity", "");
		addAddSelectOption("rcvcountry", "");
	}
	var addAddSelectOption = function(idvalue, key) {
		$("#" + idvalue).val("");
		var selectObject = $("#" + idvalue + "name");
		selectObject.empty();
		selectObject
				.append("<option value='-1'>----------请选择----------</option>");
		if ("" != key) {
			$.each(ChineseDistricts[key], function(code, value) {
				selectObject.append("<option value='"+code+"'>" + value
						+ "</option>");
			})
		}
	}
	var getLableValueByName = function(lablevalue, key) {
		var codevalue = "-1";
		$.each(ChineseDistricts[key], function(code, value) {
			if (lablevalue == value) {
				codevalue = code;
			}
		})
		return codevalue;
	}
	var changeSelectRegion = function(regionType) {
		var value = $("#" + regionType + "name").val();
		if ("-1" != value) {
			if ("rcvprov" == regionType || "sendprov" == regionType) {
				if ("rcvprov" == regionType) {
					addAddSelectOption("rcvcity", value);
					addAddSelectOption("rcvcountry", "");
				}
				if ("sendprov" == regionType) {
					addAddSelectOption("sendcity", value);
					addAddSelectOption("sendCountry", "");
				}
			} else if ("rcvcity" == regionType || "sendcity" == regionType) {
				if ("rcvcity" == regionType)
					addAddSelectOption("rcvcountry", value);
				if ("sendcity" == regionType)
					addAddSelectOption("sendCountry", value);
			}
			$("#" + regionType)
					.val(
							$("#" + regionType + "name")
									.find('option:selected').text());
		} else {
			if ("rcvprov" == regionType || "sendprov" == regionType) {
				if ("rcvprov" == regionType) {
					addAddSelectOption("rcvcity", "");
					addAddSelectOption("rcvcountry", "");
				}
				if ("sendprov" == regionType) {
					addAddSelectOption("sendcity", "");
					addAddSelectOption("sendCountry", "");
				}
			} else if ("rcvcity" == regionType || "sendcity" == regionType) {
				if ("rcvcity" == regionType)
					addAddSelectOption("rcvcountry", "");
				if ("sendcity" == regionType)
					addAddSelectOption("sendCountry", "");
			}
		}
	}
	function docheck() {
		if ($("#emsordno").val() == "") {
			alert("信封流水号不能为空");
			return false;
		}
		if ($("#mailnum").val() == "") {
			alert("快递单号不能为空");
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
		return true;
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
	var saveEms = function() {
		if (!docheck()) {
			return false;
		} else {
			var returnvalue = saveEmsInfo();
			var expressid = "", editType = "", resuleValue = "";
			for (var i = 0; i < returnvalue.split(",").length; i++) {
				var index = returnvalue.split(",")[i].indexOf(":");
				var key = "", value = "";
				if (i == 0) {
					key = returnvalue.split(",")[i].substring(1, index);
					value = returnvalue.split(",")[i].substring(index + 1);
				} else if (i == returnvalue.split(",").length - 1) {
					key = returnvalue.split(",")[i].substring(0, index);
					value = returnvalue.split(",")[i].substring(index + 1,
							returnvalue.split(",")[i].length - 1);
				} else {
					key = returnvalue.split(",")[i].substring(0, index);
					value = returnvalue.split(",")[i].substring(index + 1);
				}
				if ("expressid" == key.substring(1, key.length - 1)) {
					expressid = value.substring(1, value.length - 1);
				}
				if ("editType" == key.substring(1, key.length - 1)) {
					editType = value.substring(1, value.length - 1);
				}
				if ("resuleValue" == key.substring(1, key.length - 1)) {
					resuleValue = value.substring(1, value.length - 1);
				}
			}
			if ("" == expressid) {
				alert("保存/修改Ems信息失败！原因：" + resuleValue);
			} else {
				alert(resuleValue);
				var parentDocument = window.opener.document;//获取父页面对象
				parentDocument.getElementById('emsordno').value = $("#emsordno")
						.val();
				parentDocument.getElementById('EMSHAVING').style.display = "inline";
				if ("A" == editType && "0" == $("#isnetApply").val()) {
					parentDocument.getElementById('expressid').value = expressid;
				}
				window.close();
			}
		}
	}
	var saveEmsInfo = function() {
		var xmlhttp;
		var url = "${pageContext.request.contextPath}/powerruntime/optExpressMessage!saveBjEmsInfo.do?emsInfo="
				+ encodeURI(encodeURI(getEmsInfo()));
		if (xmlhttp == null) {
			if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
				xmlhttp = new XMLHttpRequest();
			} else {// code for IE6, IE5
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
		}
		xmlhttp.open("GET", url, false);
		xmlhttp.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		xmlhttp.send();
		return xmlhttp.responseText;
	}
	var getEmsInfo = function() {
		var emsinfo = "mailnum:" + $("#mailnum").val() + ";showmore:"
				+ $("#showmore").val() + ";emsordno:" + $("#emsordno").val()
				+ ";govtbname:" + $("#govtbname").val() + ";posttype:"
				+ $("#posttype").val() + ";nettype:" + $("#nettype").val()
				+ ";busstype:" + $("#busstype").val() + ";issend:"
				+ $("#issend").val() + ";chkcode:" + $("#chkcode").val()
				+ ";expresstime:" + $("#expresstime").val() + ";isnetApply:"
				+ $("#isnetApply").val();
		if ("" != $("#item").val()) {
			emsinfo = emsinfo + ";item:" + $("#item").val();
		}
		emsinfo = emsinfo + ";sendname:" + $("#sendname").val() + ";sendprov:"
				+ $("#sendprov").val() + ";sendcity:" + $("#sendcity").val()
				+ ";sendCountry:" + $("#sendCountry").val() + ";sendphone:"
				+ $("#sendphone").val() + ";sendstrect:"
				+ $("#sendstrect").val();
		if ($("#sendcall").val() != "") {
			emsinfo = emsinfo + ";sendcall:" + $("#sendcall").val();
		}
		emsinfo = emsinfo + ";rcvname:" + $("#rcvname").val() + ";rcvprov:"
				+ $("#rcvprov").val() + ";rcvcity:" + $("#rcvcity").val()
				+ ";rcvcountry:" + $("#rcvcountry").val() + ";rcvphone:"
				+ $("#rcvphone").val() + ";rcvstrect:" + $("#rcvstrect").val()
				+ ";rcvpostcode:" + $("#rcvpostcode").val();
		if ("" != $("#rcvcall").val()) {
			emsinfo = emsinfo + ";rcvcall:" + $("#rcvcall").val();
		}
		if ("" != $("#expressid").val()) {
			emsinfo = emsinfo + ";expressid:" + $("#expressid").val();
		}
		return emsinfo + ";djid:" + $("#djid").val();
	}
	window.onbeforeunload = function() {
		var parentDocument = window.opener.document;//获取父页面对象
		if ("" == $("#emsordno").val()
				&& parentDocument.getElementById('EMSHAVING').style.display == "none") {
			parentDocument.getElementById('isSendEms').value = "F";
		}
	}
</script>
</html>