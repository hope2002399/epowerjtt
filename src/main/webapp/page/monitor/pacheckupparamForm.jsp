<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>新增参数</title>
	<script language="JavaScript" src="${pageContext.request.contextPath}/page/powerbase/lhgdialog/lhgcore.min.js" type="text/JavaScript"></script>
    <script language="JavaScript" src="${pageContext.request.contextPath}/page/powerbase/lhgdialog/lhgdialog.js" type="text/JavaScript"></script>
</head>

<body >

	<%@ include file="/page/common/messages.jsp"%>
	<fieldset style="padding: 10px;">
		<legend class="ctitle" style="width: auto; margin-bottom: 5px;">
			新增参数
		</legend>
		<s:form action="pacheckupparam" method="post" namespace="/monitor" id="pacheckupparamForm" enctype="multipart/form-data">
		
			<input type="button" class="btn" value="保存" onclick="save();"/>
			<input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" />
				<table border="0" cellpadding="1" cellspacing="1" class="viewTable">
				<tr>
				<td class="addTd" width="20%"><s:text name="pacheckupparam.paramNo" /></td>
					<td align="left" colspan="3" width="80%">
							<s:textfield name="paramNo" size="40" value="%{object.paramNo}" />
							<span style="color: red">*</span>
						 </td>
						</tr>
				<tr>
					<td class="addTd" width="20%"><s:text name="pacheckupparam.paramName" /></td>
					<td align="left" colspan="3" width="80%">
							<s:textfield name="paramName" size="40" value="%{object.paramName}" />
							<span style="color: red">*</span>
						 </td>
				</tr>
				<tr>
					<td class="addTd" width="20%"><s:text name="pacheckupparam.defaultValue" /></td>
					<td align="left" colspan="3"><s:textfield name="defaultValue"
							size="40" value="%{object.defaultValue}" /><span
						style="color: red">*</span></td>
				</tr>


				<tr>
					<td class="addTd" width="20%"><s:text
							name="pacheckupparam.paramValue" /></td>
					<td align="left" colspan="3"><s:textfield name="paramValue"
							size="40" value="%{object.paramValue}"/><span
						style="color: red">*</span></td>
				</tr>
				<tr>
					<td class="addTd" width="20%"><s:text
							name="pacheckupparam.paramType" /></td>
				
						<td align="left"><select name="paramType" style="width: 180px">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('paramType')}">
								<option value="${row.key}"
									<c:if test="${object.paramType eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select><span style="color: red">*</span>
					</td>
				</tr>
				<tr>
				<td class="addTd" width="20%"><s:text name="pacheckupparam.paramDesc" /></td>
				<td align="left"><select name="paramDesc" style="width: 180px">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('paramDesc')}">
								<option value="${row.key}"
									<c:if test="${object.paramDesc eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select><span style="color: red">*</span>
					</td></tr>
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
	     if(""==paramNo){
	    	 alert("请填写参数代码");
	    	 document.forms[0].paramNo.focus();
	    	 return;
	     }
	     if(""==paramName){
	    	 alert("请填写参数名称");
	    	 document.forms[0].paramName.focus();
	    	 return;
	     }
	     if(""==defaultValue){
	    	 alert("请填写参数默认值");
	    	 document.forms[0].defaultValue.focus();
	    	 return;
	     }
	     if(""==paramValue){
	    	 alert("请填写用户设定值");
	    	 document.forms[0].paramValue.focus();
	    	 return;
	     }
	     if(""==paramType){
	    	 alert("请选择参数类别");
	    	 document.forms[0].birth.focus();
	    	 return;
	     }
	     if(""==paramType){
	    	 alert("请选择参数说明");
	    	 document.forms[0].birth.focus();
	    	 return;
	     }
	     var form=document.getElementById("pacheckupparamForm");
	     form.action="pacheckupparam!pacheckupparamSave.do";     
	     form.submit();
	     
	}
	</script>
</body>
</html>
