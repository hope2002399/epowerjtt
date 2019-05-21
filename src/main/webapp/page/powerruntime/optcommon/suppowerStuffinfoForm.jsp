<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>权力材料信息</title>
<script type="text/javascript">
function check(){
	var stufftype=document.getElementById("stuffType").value;
	if(stufftype.length>4){
		alert("材料类型长度不可超过4");
		document.getElementById("stuffType").focus();
		return false;
	}
	return true;
}
</script>
</head>

<body >
	<p class="ctitle">
			编辑权力材料信息
	</p>

	<%@ include file="/page/common/messages.jsp"%>

	<s:form action="generalOperator" namespace="/powerruntime"	onsubmit="return check();" >
		<s:submit name="save" method="saveStuffinfo" cssClass="btn" value="保存"></s:submit>
		<s:hidden name="suppowerstuffinfo.sortId" value="%{suppowerstuffinfo.sortId}"></s:hidden>
		<s:hidden name="suppowerstuffinfo.groupId" value="%{suppowerstuffinfo.groupId}"></s:hidden>
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="viewTable">
		<tr>
		<td>材料类别</td>
		<td><s:textfield name="suppowerstuffinfo.stuffType" id="stuffType" value="%{suppowerstuffinfo.stuffType}" ></s:textfield>   </td>
		<tr>
		<tr>
		<td>材料名称</td>
		<td><s:textfield name="suppowerstuffinfo.stuffName" value="%{suppowerstuffinfo.stuffName}" ></s:textfield>   </td>
		<tr>
		<tr>
		<td>是否必须</td>
		<td><s:radio name="suppowerstuffinfo.isNeed" value="%{suppowerstuffinfo.isNeed}" listKey="key" listValue="value"  list="#{'1':'是','0':'否'}"></s:radio> </td>
		<tr>
		<tr>
		<td>是否必须电子</td>
		<td><s:radio name="suppowerstuffinfo.isElectron" value="%{suppowerstuffinfo.isElectron}" listKey="key" listValue="value"  list="#{'1':'是','0':'否'}"></s:radio> </td>
		<tr>

		</table>
	</s:form>


</body>
</html>
