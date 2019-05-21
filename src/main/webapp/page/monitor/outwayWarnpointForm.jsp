<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>预报警规则编辑</title>

<s:include value="/page/common/formValidator.jsp"></s:include>
<script type="text/javascript">
$(document).ready(function() {
	$.formValidator.initConfig({
		formid : "outwayWarnpointForm",
		onerror : function(msg, obj, errorlist) {
			alert(msg);
		}
	});
	$('#wpNo').formValidator({
		onShow : "请填写 规则编号"
	}).inputValidator({
		min:1,
		onerror : "规则编号 是必填项"
	});
	
	$('#wpName').formValidator({
		onShow : "请填写 规则名称"
	}).inputValidator({
		min:1,
		onerror : "规则名称 是必填项"
	});
	
	$('#wpSource').formValidator({
		onShow : "请选择 异常源"
	}).inputValidator({
		min:1,
		onerror : "异常源 是必选项"
	});
	
	$('#wpTypeNo').formValidator({
		onShow : "请选择 异常类型"
	}).inputValidator({
		min:1,
		onerror : "异常类型 是必选项"
	});
	
	$('#wpLevelNo').formValidator({
		onShow : "请选择 异常级别"
	}).inputValidator({
		min:1,
		onerror : "异常级别 是必选项"
	});
	
	$('#wpStatus').formValidator({
		onShow : "请选择 是否启用"
	}).inputValidator({
		min:1,
		onerror : "是否启用 是必选项"
	});
	
	$('#wpExeType').formValidator({
		onShow : "请选择 执行方式"
	}).inputValidator({
		min:1,
		onerror : "执行方式 是必选项"
	});
	
	$('#wpExeRule').formValidator({
		onShow : "请选择 执行规则"
	}).inputValidator({
		min:1,
		onerror : "执行规则 是必选项"
	});
	
	$('#wpOracle').formValidator({
		onShow : "请填写 存错过程"
	}).inputValidator({
		min:1,
		onerror : "存错过程 是必填项"
	});
	
});
</script>
</head>

<body>

	<%@ include file="/page/common/messages.jsp"%>
	<fieldset style="padding: 10px;">
	<legend class="ctitle" style="width: auto; margin-bottom: 10px;">预报警规则信息</legend>
	<s:form action="outwayWarnpoint" method="post" namespace="/monitor" id="outwayWarnpointForm">
		<s:submit name="save" method="save" cssClass="btn" key="opt.btn.save" />
		<input type="button" name="back" Class="btn" onclick="history.back(-1);" value="返回"/>

		<table border="0" cellpadding="0" cellspacing="0" class="viewTable">

			<tr>
				<td class="TDTITLE">规则编号<span style="color: red">*</span></td>
				<td align="left">
					<input type="text" name="wpNo" id="wpNo" value="${object.wpNo}" size="40" readonly="${empty object.wpNo?'false':'true'}">
				</td>
			</tr>
			
			<tr>
				<td class="TDTITLE">规则名称<span style="color: red">*</span></td>
				<td align="left">
					<s:textfield name="wpName" size="40" id="wpName"/>
				</td>
			</tr>
			
			<tr>
				<td class="TDTITLE">异常源<span style="color: red">*</span></td>
				<td align="left">
					<select name="wpSource" id="wpSource">
						<option value="">--请选择--</option>
						<c:forEach var="row" items="${cp:DICTIONARY('OutwaySource')}">
							<option value="${row.key}"
								<c:if test="${object.wpSource eq row.key}">selected="selected"</c:if>>
								<c:out value="${row.value}" />
							</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			
			<tr>
				<td class="TDTITLE">异常类型<span style="color: red">*</span></td>
				<td align="left">
					<select name="wpTypeNo" id="wpTypeNo" onchange="outwayWarnpointForm.wpType.value=this.options[this.selectedIndex].text">
						<option value="">--请选择--</option>
						<c:forEach var="row" items="${cp:DICTIONARY('MONITOR_TYPE')}">
							<option value="${row.key}"
								<c:if test="${object.wpTypeNo eq row.key}">selected="selected"</c:if>>
								<c:out value="${row.value}" />
							</option>
						</c:forEach>
					</select>
					<s:hidden name="wpType" id="wpType"/>
				</td>
			</tr>

			<tr>
				<td class="TDTITLE">异常级别<span style="color: red">*</span></td>
				<td align="left">
					<select name="wpLevelNo" id="wpLevelNo" onchange="outwayWarnpointForm.wpLevel.value=this.options[this.selectedIndex].text">
						<option value="">--请选择--</option>
						<c:forEach var="row" items="${cp:DICTIONARY('MONITOR_STYLE')}">
							<option value="${row.key}"
								<c:if test="${object.wpLevelNo eq row.key}">selected="selected"</c:if>>
								<c:out value="${row.value}" />
							</option>
						</c:forEach>
					</select>
					<s:hidden name="wpLevel" id="wpLevel"/>
				</td>
			</tr>

			<tr>
				<td class="TDTITLE">规则描述</td>
				<td align="left">
					<s:textarea name="wpDesc" id="wpDesc" style="width: 500;"/>
				</td>
			</tr>

			<tr>
				<td class="TDTITLE">是否启用<span style="color: red">*</span></td>
				<td align="left">
					<select name="wpStatus" id="wpStatus">
						<option value="">--请选择--</option>
						<c:forEach var="row" items="${cp:DICTIONARY('TrueOrFalse')}">
							<option value="${row.key}"
								<c:if test="${object.wpStatus eq row.key}">selected="selected"</c:if>>
								<c:out value="${row.value}" />
							</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			
			<tr>
				<td class="TDTITLE">执行方式<span style="color: red">*</span></td>
				<td align="left">
					<select name="wpExeType" id="wpStatus">
						<option value="">--请选择--</option>
						<c:forEach var="row" items="${cp:DICTIONARY('ExeType')}">
							<option value="${row.key}"
								<c:if test="${object.wpExeType eq row.key}">selected="selected"</c:if>>
								<c:out value="${row.value}" />
							</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			
			<tr>
				<td class="TDTITLE">执行规则<span style="color: red">*</span></td>
				<td align="left">
					<select name="wpExeRule" id="wpExeRule">
						<option value="">--请选择--</option>
						<option value="D" <c:if test="${object.wpExeRule eq 'D'}">selected="selected"</c:if>>每天</option>
						<option value="M" <c:if test="${object.wpExeRule eq 'M'}">selected="selected"</c:if>>每月</option>
					</select>
				</td>
			</tr>
			
			<!--
			<tr>
				<td class="TDTITLE">自动执行规则</td>
				<td align="left">
					<s:textfield name="wpExeRule" id="wpExeRule" size="40" />
					<input type="button" value="生成表达式向导" onclick="window.open('<c:url value='/page/expression/cron.jsp?txtCallback=wpExeRule'/>')">

				</td>
			</tr>
			-->
			<tr>
				<td class="TDTITLE">存储过程<span style="color: red">*</span></td>
				<td align="left">
					<s:textfield name="wpOracle" size="40" id="wpOracle"/>
				</td>
			</tr>
			<!--
			<tr>
				<td class="TDTITLE">存储过程</td>
				<td align="left">
					--calcNo 计算序列号
					<br>
					--V_Warning_Code 异常编号
					<br>
					--V_MONITOR_LOGO 异常名称
					<br>
					--V_MONITOR_SOURCE 异常源
					<br>
					--V_MONITOR_TYPE 异常类型
					<br>
					--V_MONITOR_STYLE 异常级别
					<br>
					create or replace procedure&nbsp;<input type="text" name="wpOracle" value="<c:if test="${empty object.wpOracle}">P_WarnPoint_${object.wpNo}</c:if><c:if test="${not empty object.wpOracle}">${object.wpOracle}</c:if>">
					(calcNo in number,V_MONITOR_STYLE in varchar2,V_MONITOR_TYPE in varchar2,V_Warning_Code in varchar2,V_MONITOR_LOGO in varchar2,V_MONITOR_SOURCE in varchar2)
					<br>
					is
					<br>
					<textarea style="width: 800;height: 200" name="wpOracleSql"><c:if test="${empty object.wpOracleSql}">
begin
null;
end;</c:if><c:if test="${not empty object.wpOracleSql}">${object.wpOracleSql}</c:if></textarea>
				</td>
			</tr>
			-->
		</table>
	</s:form>
	</fieldset>
</body>
</html>