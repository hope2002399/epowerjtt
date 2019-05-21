<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>修改</title>
	<script language="JavaScript" src="${pageContext.request.contextPath}/page/powerbase/lhgdialog/lhgcore.min.js" type="text/JavaScript"></script>
    <script language="JavaScript" src="${pageContext.request.contextPath}/page/powerbase/lhgdialog/lhgdialog.js" type="text/JavaScript"></script>
</head>

<body >

	<%@ include file="/page/common/messages.jsp"%>
	<fieldset style="padding: 10px;">
		<legend class="ctitle" style="width: auto; margin-bottom: 5px;">
			<b>用户设定值修改</b>
		</legend>
		<s:form action="outwayparam" method="post" namespace="/monitor" id="outwayparamForm" enctype="multipart/form-data">
			<input type="button" class="btn" value="保存" onclick="save();"/>
			<input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" />
			<input type="hidden" name="paramNo" value="${object.paramNo}"/>
			<input type="hidden" name="paramName" value="${object.paramName}"/>
			<input type="hidden" name="defaultValue" value="${object.defaultValue}"/>
			<input type="hidden" name="paramType" value="${object.paramType}"/>
			<input type="hidden" name="paramDesc" value="${object.paramDesc}"/>
				<table border="0" cellpadding="1" cellspacing="1" class="viewTable">
				<tr>
				<td class="addTd" width="20%"><s:text name="outwayparam.paramNo" /></td>
				<td align="left" colspan="3" width="80%">
					${object.paramNo}
				</td>
				</tr>
				<tr>
					<td class="addTd" width="20%"><s:text name="outwayparam.paramName" /></td>
					<td align="left" colspan="3" width="80%">
							${object.paramName}
					 </td>
				</tr>
				<tr>
					<td class="addTd" width="20%"><s:text name="outwayparam.defaultValue" /></td>
					<td align="left" colspan="3">${object.defaultValue}" />
				</tr>
				<tr>
					<td class="addTd" width="20%"><s:text name="outwayparam.paramValue" /></td>
					<td align="left" colspan="3"><s:textfield name="paramValue"
							size="40" value="%{object.paramValue}"/><span
						style="color: red">*</span></td>
				</tr>
				<tr>
					<td class="addTd" width="20%"><s:text name="outwayparam.paramType" /></td>
					<td align="left">${cp:MAPVALUE("paramType",outwayparam.paramType)}</td>
				</tr>
				<tr>
				<td class="addTd" width="20%"><s:text name="outwayparam.paramDesc" /></td>
				<td align="left">${cp:MAPVALUE("paramDesc",outwayparam.paramDesc)}</td>
				</tr>
			</table>

		</s:form>
	</fieldset>
	<script type="text/javascript">
	function save(){
		 var paramNo=document.getElementById("paramNo").value;
	     var paramName=document.getElementById("paramName").value;
	     var defaultValue=document.getElementById("defaultValue").value;
	     var paramValue=document.getElementById("paramValue").value;
	     var paramType=document.getElementById("paramType").value;
	     if(""==paramValue){
	    	 alert("请填写用户设定值");
	    	 document.forms[0].paramValue.focus();
	    	 return;
	     }
	     var form=document.getElementById("outwayparamForm");
	     form.action="outwayparam!outwayparamSave.do";     
	     form.submit();
	     
	}
	</script>
</body>
</html>
