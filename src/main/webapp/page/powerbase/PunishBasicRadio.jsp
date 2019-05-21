<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>权力编码详细信息</title>
<script src="<s:url value='/scripts/centit_validator.js'/>"
	type="text/javascript"></script>
</head>
<body>
	<fieldset style="padding: 10px;">
		<legend class="ctitle" style="width: auto; margin-bottom: 5px;">
			<s:text name="业务信息" />
		</legend>
		<table border="0" cellpadding="0" cellspacing="0" class="viewTable">

			<tr>
				<td class="addTd">业务编号</td>
				<td name="s_internal_no">${punishList[0].internal_no}</td>
				<td class="addTd">执法部门</td>
				<td>${cp:MAPVALUE('depno',punishList[0].org_id)}</td>
			</tr>
			<tr>
				<td class="addTd">当事人</td>
				<td>${punishList[0].punish_target}</td>
				<td class="addTd">当事人类型</td>
				<td><c:if test="${punishList[0].target_type==0}">
						<c:out value="自然人"></c:out>
					</c:if> <c:if test="${punishList[0].target_type==1}">
						<c:out value="法人"></c:out>
					</c:if> <c:if test="${punishList[0].target_type==2}">
						<c:out value="其他"></c:out>
					</c:if></td>
			</tr>
			<tr>
				<td class="addTd">确认事实</td>
				<td colspan="3">${punishList[0].fact}</td>
			</tr>
			<tr>
				<td class="addTd">权力事项名称</td>
				<td colspan="3">${punishList[0].itemName}</td>
			</tr>
			<tr>
				<td class="addTd">登记摘要</td>
				<td colspan="3">${punishList[0].content}</td>
			</tr>
			<tr>
				<td class="addTd">罚款限额</td>
				<td id="staPunishfine"></td>
				<td class="addTd">实际处罚金额</td>
				<td id="factPunishfine"></td>
			</tr>
			<tr>
				<td class="addTd">没收价值限额</td>
				<td width="40%" id="staExpropriattonv"></td>
				<td class="addTd">实际没收价值</td>
				<td id="factExpropriattonv"></td>
			</tr>
			<tr>
				<td class="addTd">处罚种类</td>
				<td colspan="3"><c:forEach var="row"
						items="${cp:DICTIONARY('CFZL')}">
						<c:if test="${punishList[0].punish_class eq row.key}">
							<c:out value="${row.value}" />
						</c:if>
					</c:forEach></td>
			</tr>
		</table>
	</fieldset>
	<fieldset style="padding: 10px;">
		<legend class="ctitle" style="width: auto; margin-bottom: 5px;">
			<s:text name="重大行政处罚备案基本信息" />
		</legend>
		<s:form action="punishRecordBasic" namespace="/powerbase"
			id="punishRecordBasicForm" name="punishRecordBasicForm" method="post"
			validator="true">
			<table cellpadding="0" cellspacing="0" border="0" class="viewTable">
				<c:choose>
					<c:when test="${isShow eq 'hidden'}">

					</c:when>
					<c:otherwise>
						<tr>
							<td class="addTd">备案人</td>
							<td name="s_operatorId" width="40%">${recordInfo[0].operatorId
						}</td>
							<td width="100px" align="center">&nbsp &nbsp &nbsp&nbsp
								&nbsp备案时间</td>
							<td name="bookDate">${recordInfo[0].bookDate}</td>
						</tr>
						<tr>
							<td class="addTd">备案来源</td>
							<td colspan="3" name="s_source"><c:choose>
									<c:when test="${punishList[0].source}==1">
										<c:out value="审查备案"></c:out>
									</c:when>
									<c:otherwise>
										<c:out value="申报备案"></c:out>
									</c:otherwise>
								</c:choose></td>
						</tr>
					</c:otherwise>
				</c:choose>
				<tr>
					<td class="addTd">*备案类型<input type="hidden" name="s_no"
						value="${punishList[0].no}"> <input type="hidden"
						name="s_org_id" value="${punishList[0].org_id}"> <input
						type="hidden" name="s_internal_no"
						value="${punishList[0].internal_no}">
					</td>
					<td colspan="3" name="s_recodeStyle"><select
						name="recodeStyle" id="recodeStyle" validator="input" min="1"
						errorshow="请选择备案类型">
							<c:forEach var="row" items="${cp:DICTIONARY('BALX')}">
								<option value="${row.key}"
									<c:if test="${punishList[0].recodeStyle eq row.key||parameters.s_recodeStyle[0] eq row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="addTd">备案申报材料</td>
					<td colspan="3" name="s_fileName"><input type="file"
						name="fileName" id="fileName" value="浏览" /> <input type="button"
						name="" value="查看"
						onclick="doLook('${recordInfo[0].no}','${recordInfo[0].fileName}');"
						class="btn" style="visibility: ${isShow};">&nbsp; <input
						type="button" name="" value="删除"
						onclick="doDelete('${recordInfo[0].no}','${recordInfo[0].fileName}');"
						class="btn" style="visibility: ${isShow};"></td>
				</tr>
				<tr>
					<td class="addTd">备注</td>
					<td align="left" colspan="3"><s:textarea name="remark"
							value="%{recordInfo[0].remark}" /></td>
				</tr>
			</table>
			<s:submit name="radioSave" method="RadioSave" cssClass="btn"
				key="opt.btn.save" />
			<input type="button" class="btn" value="返回"
				onclick="javascript:history.go(-1);" />


		</s:form>
	</fieldset>
</body>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$
								.getJSON(
										"${pageContext.request.contextPath}/powerbase/punishRecordBasic!Compare.do?callback=?",
										{
											org_id : '${punishList[0].org_id}',
											targerType : '${punishList[0].target_type}'
										},
										function(json) {
											var num = json.num;
											var business = json.business;
											if (num == 'null') {
												$("#staPunishfine").html("0元");
												$("#factPunishfine")
														.html(
																"${punishList[0].punish_result_fine}元");
											} else {
												$("#staPunishfine").html(
														num + "元");
												var fnum = '${punishList[0].punish_result_fine}';
												if (Math.abs(fnum)
														- Math.abs(num) > 0) {
													$("#factPunishfine")
															.html(
																	"<font color=\"red\">${punishList[0].punish_result_fine}元<\/font>");
												} else {
													$("#factPunishfine")
															.html(
																	"${punishList[0].punish_result_fine}元");
												}
											}
											if (business == 'null') {
												$("#staExpropriattonv").html(
														"0元");
												$("#factExpropriattonv")
														.html(
																"${punishList[0].punish_result_expropriatton_v}元");
											} else {
												$("#staExpropriattonv").html(
														business + "元");
												var fbusiness = '${punishList[0].punish_result_expropriatton_v}';
												if (Math.abs(fbusiness)
														- Math.abs(business) > 0) {
													$("#factExpropriattonv")
															.html(
																	"<font color=\"red\">${punishList[0].punish_result_expropriatton_v}元<\/font>");
												} else {
													$("#factExpropriattonv")
															.html(
																	"${punishList[0].punish_result_expropriatton_v}元");
												}
											}
										});
					});
	function doLook(no, fileName) {
		var url = "powerbase/punishRecordBasic!recordBasicDown.do?no=" + no
				+ "&fileName=" + fileName;
		document.location.href = url;
	}
	function doDelete(no, fileName) {
		if (window.confirm("确定删除备案申报材料信息?")) {
			var url = "powerbase/punishRecordBasic!recordBasicDelete.do?no="
					+ no + "&fileName=" + fileName;
			document.location.href = url;
		}
	}
</script>
</html>