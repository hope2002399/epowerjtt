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
			<legend class="ctitle" style="width: auto; margin-bottom: 5px;"><b>取消跟踪</b></legend>
			<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
				<tr>
					<td class="addTd" ><span style="color: red">*</span>取消原因</td>
					<td align="left"><s:textarea name="untrackreason" cols="40" rows="2" style="width:98%;height:40px;" /></td>
				</tr>
				<tr align="center"><td ></td>
				<td align="center" colspan="2">
			<input type="button" class="btn" value="保存" onclick="save()"/>
			<input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" />
			</td>
			</tr>
			</table>
			</fieldset>
		</s:form>
</body>
<script type="text/javascript">
function save(){
	var form=document.getElementById("trackLogForm");
	var untrackreason=document.getElementById("untrackreason").value;
	if(""==untrackreason){
		alert("请填写取消原因");
		document.forms[0].untrackreason.focus();
		return false;
	}
	form.action="trackLog!trackLogCancelSaves.do?untrackreason="+untrackreason;
	form.submit();
	
}
</script>
</html>
