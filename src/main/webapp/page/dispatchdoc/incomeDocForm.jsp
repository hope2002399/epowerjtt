<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html>
<head>
<title><s:text name="OA系统收文信息" /></title>
<script src="${pageContext.request.contextPath}/scripts/common.js" type="text/javascript"></script>
</head>

<body>
	<p class="ctitle"><s:text name="OA系统收文信息" /></p>
	
	<%@ include file="/page/common/messages.jsp"%>
	
	<s:form action="incomeDoc" method="post" namespace="/dispatchdoc" id="incomeDocForm" >
		<input type="button" class="btn" id="save" value="保存"/>
		<input type="button" class="btn" id="saveAndSubmit" value="保存并提交"/>
		<%@ include file="/page/powerruntime/optcommon/optBaseInfoForm.jsp"%>
		<fieldset style="padding: 10px; display: block; margin-bottom: 10px;">
		<legend style="padding:4px 8px 3px;"><b>收文信息</b></legend>
			<table width="200" border="0" cellpadding="0" cellspacing="0" class="viewTable">
<!-- 				<tr> -->
<!-- 					<td align="right"> -->
<!-- 						权力编码 -->
<!-- 					</td> -->
<!-- 					<td align="left"> -->
<%-- 						<s:textfield id="itemId" name="itemId" size="40" length="50" /> --%>
<!-- 					</td> -->
<!-- 					<td class="addTd"> -->
<!-- 						部门内部事项编号 -->
<!-- 					</td> -->
<!-- 					<td align="left"> -->
<%-- 						<s:textfield id="internalNo" name="internalNo" size="40" length="50" /> --%>
<!-- 					</td> -->
<!-- 				</tr> -->
				<tr>
					<td class="addTd">
						收文编号
					</td>
					<td align="left">
						<s:textfield id="acceptNo" name="acceptNo" size="40" length="50" value="%{object.acceptNo}" />
					</td>
					<td class="addTd">
						来文文号
					</td>
					<td align="left">
						<s:textfield id="incomeDocNo" name="incomeDocNo" size="40" length="50" value="%{object.incomeDocNo}" />
					</td>
				</tr>	
<!-- 				<tr> -->
<!-- 					<td class="addTd" width="18%"> -->
<!-- 						部门内部事项编号 -->
<!-- 					</td> -->
<!-- 					<td align="left" width="32%"> -->
<%-- 						<s:textfield id="internalNo" name="internalNo" size="40"/> --%>
<!-- 					</td> -->
<!-- 					<td width="18%" align="right"> -->
<!-- 						权力编码 -->
<!-- 					</td> -->
<!-- 					<td align="left"> -->
<%-- 						<s:textfield id="itemId" name="itemId" size="40"/> --%>
<!-- 					</td> -->
<!-- 				</tr> -->
				
				<tr>
					<td align="right">
						来文机关
					</td>
					<td align="left" colspan="3">
						<s:textfield id="incomeDeptName" name="incomeDeptName" size="100" length="200" value="%{object.incomeDeptName}" />
					</td>
				</tr>
				<tr>
					<td class="addTd">
						来文标题
					</td>
					<td align="left" colspan="3">
						<s:textfield id="incomeDocTitle" name="incomeDocTitle" size="100" length="200" value="%{object.incomeDocTitle}" />
					</td>
				</tr>
				
			</table>
		</fieldset>
	</s:form>

	<fieldset>
		<legend>材料上传</legend>
		<iframe id="basicsj" name="sjfj" width="100%" height="" frameborder="no" scrolling="false" border="0" marginwidth="0" marginheight="0"
			src="<%=request.getContextPath()%>/powerruntime/generalOperator!gotosqcl.do?stuffInfo.djId=${object.djId}&stuffInfo.nodeInstId=0&stuffInfo.groupid=143">
		</iframe>
	</fieldset>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		function doSaveCheck() {
			if ("" == $.trim($("#powerid").val()) || "" == $.trim($("#powername").val()) || "" == $.trim($("#orgcode").val())
					|| "" == $.trim($("#orgname").val())) {
				alert("请选择权力事项");
				return false;
			}
			
			if ("" == $.trim($("#incomeDocForm_optBaseInfo_transAffairNo").val())) {
				alert("请输入办件编号");
				return false;
			}
			if ("" == $.trim($("#incomeDocForm_optBaseInfo_transaffairname").val())) {
				alert("请输入办件名称");
				return false;
			}
			if ("" == $.trim($("#incomeDocForm_optBaseInfo_content").val())) {
				alert("请输入办件摘要");
				return false;
			}
			if ("" == $.trim($("#incomeDocForm_optBaseInfo_transAffairQueryKey").val())) {
				alert("请输入办件查询密码");
				return false;
			}
			
			return true;
		}		
		
		function doSubmitCheck() {
			if ("" == $.trim($("#acceptNo").val())) {
				alert("请输入收文编号");
				return false;
			}
			if ("" == $.trim($("#incomeDocNo").val())) {
				alert("请输入来文文号");
				return false;
			}
			if ("" == $.trim($("#incomeDocTitle").val())) {
				alert("请输入来文标题");
				return false;
			}
			if ("" == $.trim($("#incomeDeptName").val())) {
				alert("请输入来文机关");
				return false;
			}
			
			return true;
		}
		
		
		$("#save,#saveAndSubmit").click(function() {
			var id = $(this).attr("id");
			if ("save" == id) { // 保存
				if (doSaveCheck()) {
					$("#incomeDocForm").attr("action", "incomeDoc!saveIncomeDoc.do");
					$("#incomeDocForm").submit();
				}
			} else if ('saveAndSubmit' == id) { // 提交
				if (doSaveCheck() && doSubmitCheck()) { // 校验通过
					$("#incomeDocForm").attr("action", "incomeDoc!saveAndSubmitIncomeDoc.do");
					$("#incomeDocForm").submit();
				}
			}
			
			return false;
		});
	});
</script>
</html>

