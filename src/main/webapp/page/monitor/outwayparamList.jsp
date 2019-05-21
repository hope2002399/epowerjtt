<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>预报警参数设定</title>
<sj:head locale="zh_CN" />
</head>
<script type="text/javascript">
	
</script>
<body>
	<%@ include file="/page/common/messages.jsp"%>
	<div class="search">
		<div class="crumbs">预报警参数设定</div>
		<s:form action="outwayparam" namespace="/monitor" id="outwayparamForm"
			style="margin-top:0;margin-bottom:5">
			<input type="hidden" id="paramType" name="paramType"
				value="${param.paramType}" />
			<table>
				<tr>
					<td class="addTd">参数类别：</td>
					<td><select name="s_paramType" onchange="checkType();">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('MONITOR_TYPE')}">
								<option value="${row.key}"
									<c:if test="${parameters.s_paramType[0] eq row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
				</tr>
			</table>
		</s:form>
	</div>
	<ec:table action="outwayparam!list.do" items="outwayparamList"
		var="outwayparam"
		imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif"
		retrieveRowsCallback="limit">
		<ec:row>
			<ec:column property="paramNo" title="参数代码" style="text-align:center">
                    ${outwayparam.paramNo}
				</ec:column>
			<ec:column property="paramName" title="参数名称"
				style="text-align:center">
					${outwayparam.paramName}
				</ec:column>
			<ec:column property="defaultValue" title="参数默认值"
				style="text-align:center">
					${outwayparam.defaultValue}
				</ec:column>
			<ec:column property="paramType" title="参数类别"
				style="text-align:center">
					${cp:MAPVALUE("MONITOR_TYPE",outwayparam.paramType)}
				</ec:column>
			<ec:column property="paramValue" title="用户设定值"
				style="text-align:center">
				<input type="text" name="paramValue" id="${outwayparam.paramNo}"
					value="${outwayparam.paramValue}"
					onchange="updateParamValue('${outwayparam.paramNo}');" />
				<a
					href='monitor/outwayparam!outwayparamSave.do?paramNo=${outwayparam.paramNo}&paramValue=${outwayparam.defaultValue}'>设置为默认值</a>
			</ec:column>
		</ec:row>
	</ec:table>
	<div class="search">
		<div class="crumbs">手动计算预报警</div>
		<s:form action="outwayparam" namespace="/monitor"
			style="margin-top:0;margin-bottom:5">
			<table cellpadding="0" cellspacing="0" align="center">
				<tr>
					<td class="addTd">年：</td>
					<td align="left"><select name="s_countYear">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${yearList}">
								<option value="${row}"
									<c:if test="${parameters.s_countYear[0] eq row}">selected="selected"</c:if>>
									<c:out value="${row}" />
								</option>
							</c:forEach>
					</select>
					<td class="addTd">月：</td>
					<td><select name="s_countMonth">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${monthlist}">
								<option value="${row}"
									<c:if test="${parameters.s_countMonth[0] eq row}">selected="selected"</c:if>>
									<c:out value="${row}" />
								</option>
							</c:forEach>
					</select></td>
					<td align="center">&nbsp;&nbsp;<input type="button"
						value="手动计算" class="btn" onclick="submitT();" /></td>
				</tr>
			</table>
		</s:form>
	</div>
</body>
<script type="text/javascript">
	function checkType() {
		var form = document.getElementById("outwayparamForm");
		form.action = "outwayparam!list.do";
		form.submit();
	}
	function submitT() {
		var form = document.getElementById("outwayparamForm");
		var countYear = document.getElementById("s_countYear");
		var countMonth = document.getElementById("s_countMonth");
		if (countYear.value == '') {
			alert("请选择年份");
			return false;
		}
		if (countMonth.value == '') {
			alert("请选择月份");
			return false;
		}
		form.action = "outwayparam!callProcedure.do?s_countYear="
				+ countYear.value + "&s_countMonth=" + countMonth.value;
		form.submit();
	}
	function updateParamValue(paramNo) {
		var form = document.getElementById("outwayparamForm");
		var paramValue = document.getElementById(paramNo);
		form.action = "outwayparam!outwayparamSave.do?paramNo=" + paramNo
				+ "&paramValue=" + paramValue.value;
		form.submit();
	}
</script>
</html>
