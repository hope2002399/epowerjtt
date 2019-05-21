<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html>
<head>
		<title>重大许可备案管理</title>
</head>
<body>
<%@ include file="/page/common/messages.jsp"%>
<fieldset style="padding:10px;">
<legend style="padding:4px 8px 3px;"><b>行政许可备案管理</b></legend>
<s:form action="powerRisk" method="post" namespace="/powerbase" enctype="multipart/form-data" id="powerRiskForm" onsubmit="return checkItemId();">
		<s:submit name="save" method="powerRiskSave" cssClass="btn" key="opt.btn.save" />
		<!-- <input type="button" class="btn" value="提交" onClick="javascript:checkItemId();"/> -->
		<input type="button" class="btn" value="返回" onClick="javascript:history.go(-1);"/>
		<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
				<tr>
					<td class="addTd" width="20%"><s:text name="权力编码" /></td>
					<td align="left" colspan="3" width="80%">
							<input type="text"  name="itemId" style="width:300px;" onblur="checkItemId();"/>
							<s:submit key="验证" method="checkExist" cssClass="btn"/>
							<div id="itemIdDiv" style="color:red"></div>
							
					</td>
				</tr>
				<tr>
					<td class="addTd" width="20%"><s:text name="风险点类别" /></td>
					<td align="left" colspan="3" width="80%">
							<input type="text" name="riskType" style="width:300px;"/>
					</td>
				</tr>
				<tr>
					<td class="addTd" width="20%"><s:text name="风险点描述" /></td>
					<td align="left" colspan="3" width="80%">
							<input type="text" name="riskDescrib" style="width:300px;"/>
					</td>
				</tr>
				<tr>
					<td class="addTd" width="20%"><s:text name="风险内控的手段" /></td>
					<td align="left" colspan="3" width="80%">
							<input type="text"  name="riskControlWay" style="width:300px;" />
					</td>
				</tr>
				<tr>
					<td class="addTd" width="20%"><s:text name="备注" /></td>
					<td align="left" colspan="3" width="80%">
							<input type="text" name="remark" style="width:300px;"/>
					</td>
				</tr>
		</table>
</s:form>
</fieldset>
<script type="text/javascript">
function checkItemId(){
	var itemId = document.getElementById("itemId");
	var itemIdDiv = document.getElementById("itemIdDiv");
	var str=itemId.value;
	var regexp = new RegExp(/^JS[0-9]{6}JT-XK-[0-9]{4}$/);
	if(str==null||str==""){
		itemIdDiv.innerHTML="*权力编码为必填项";
		return false ;
	}else if(regexp.test(str)){
		itemIdDiv.innerHTML="";
		return true;
	}else{
		itemIdDiv.innerHTML="该权力非许可权力！";
		return false;
	}
}
<%--function checkExist(){
	var itemId = document.getElementById("itemId");
	var url = "powerbase/powerRisk!checkExist.do?itemId="+itemId.value;
	var xhr=window.XMLHttpRequest ? new XMLHttpRequest():new ActiveXObject("microsoft.xmlhttp");
	xhr.open("get",url,true);
	xhr.send(null);
//	alert(xhr.responseText);
}
--%>
</script>
</body>
</html>