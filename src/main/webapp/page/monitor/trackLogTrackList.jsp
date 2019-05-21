<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<sj:head locale="zh_CN" />
<title><s:text name="suppower.edit.title" /></title>
<script src="${pageContext.request.contextPath}/scripts/suggest.js" type="text/javascript"></script>
</head>

<body>

	<%@ include file="/page/common/messages.jsp"%>
		<s:form action="trackLog" method="trackLogSave" namespace="/monitor" id="trackLogForm" enctype="multipart/form-data">
		 	<input id="bjNos" type="hidden" name="bjNos" value="${bjNos}" />
		 	<input id="flag" type="hidden" name="flag" value="${flag}" />
			<fieldset>
			<legend class="ctitle" style="width: auto; margin-bottom: 5px;"><b>跟踪信息</b></legend>
			<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
				<tr>
					<td class="addTd"><span style="color: red">*</span>跟踪类型</td>
						<td colspan="3"><select name="tracktype">
						<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('track_type')}">
								<option value="${row.key}"
									<c:if test="${tracktype eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="addTd" width="130"><span style="color: red">*</span>跟踪原因</td>
					<td align="left" colspan="3">
					<s:textarea name="trackreason" cols="40" rows="2" style="width:98%;height:40px;" /></td>
				</tr>
				<tr align="center">
				<td align="center" colspan="4">
			<input type="button" class="btn" value="保存" onclick="trackLogSaves()"/>
			<input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" />
			</td>
			</tr>
			</table>
			</fieldset>
		</s:form>
</body>
<script type="text/javascript">
function trackLogSaves(){
	var form=document.getElementById("trackLogForm");
	var tracktype=document.getElementById("tracktype").value;
	if(""==tracktype){
		alert("请选择跟踪类型");
		document.forms[0].tracktype.focus();
		return false;
	}
	var trackreason=document.getElementById("trackreason").value;
	if(""==trackreason){
		alert("请填写跟踪原因");
		document.forms[0].trackreason.focus();
		return false;
	}
	form.action="trackLog!trackLogSaves.do?trackreason="+trackreason+"&tracktype="+tracktype;
	form.submit();
	
}
</script>
</html>
