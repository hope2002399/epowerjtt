<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html>
<head>
<sj:head locale="zh_CN" />
			<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
<title></title>
</head>
<body>
<%@ include file="/page/common/messages.jsp"%>
	<fieldset style="padding:10px;">
<legend style="padding:4px 8px 3px;"><b>重大许可案件修改</b></legend>
<s:form action="powerRisk" method="post" namespace="/powerbase" id="powerRiskForm" enctype="multipart/form-data">
		<s:submit  method="powerRiskSave" cssClass="btn" key="opt.btn.save"/>
		<input type="button" class="btn" value="返回" onClick="javascript:history.go(-1);"/>
			<table  class="viewTable">
			<tr>
				<td class="addTd" width="130">
				权力编码
				</td>
				<td align="left" colspan="1">
					${object.itemId}
				</td>
			</tr>
			<tr>
				<td class="addTd" width="130">风险点类别</td>
				<td align="left" colspan="1">
					<s:textfield name="riskType" value="%{object.riskType}"/>
				</td>
			</tr>
			<tr>
				<td class="addTd" width="130">风险点描述</td>
				<td align="left" colspan="1">
				<s:textarea name="riskDescrib" value="%{object.riskDescrib}" style="width:300px;"/>
				<!--  <input type="text" name="riskDescrib" value="${object.riskDescrib}" style="width:300px;" > -->	
				</td>
			</tr>
			<tr>
				<td class="addTd" width="130">风险内控的手段</td>
				<td align="left" colspan="1">
				<s:textarea name="riskControlWay" value="%{object.riskControlWay}" style="width:300px;"/>
				<!-- 	<input type="text"  name="riskControlWay" value="${object.riskControlWay}" style="width:300px;" >-->
				</td>
			</tr>
			<tr>
				<td class="addTd" width="130">备注</td>
				<td align="left" colspan="1">
				<s:textarea name="remark" value="%{object.remark}" style="width:300px;"/>
				
				<!-- 	<input type="text"  name="remark" value="${object.remark}" style="width:300px;">-->
				</td>
			</tr>
			<%-- <tr>
				<td class="addTd" width="130">权力事项名称</td>
				<td align="left" colspan="1">
				<s:textarea name="itemName" value="%{object.itemName}" style="width:300px;"/>
				<!-- 	<input type="text"  name="riskControlWay" value="${object.riskControlWay}" style="width:300px;" >-->
				</td>
			</tr>
			<tr>
				<td class="addTd" width="130">权力类型</td>
				<td align="left" colspan="1">
				<s:textarea name="itemType" value="%{object.itemType}" style="width:300px;"/>
				<!-- 	<input type="text"  name="riskControlWay" value="${object.riskControlWay}" style="width:300px;" >-->
				</td>
			</tr>
			<tr>
				<td class="addTd" width="130">主办部门</td>
				<td align="left" colspan="1">
				<s:textarea name="orgId" value="%{object.orgId}" style="width:300px;"/>
				<!-- 	<input type="text"  name="riskControlWay" value="${object.riskControlWay}" style="width:300px;" >-->
				</td>
			</tr> --%>
			</table>
</s:form>
</fieldset>

</body>
</html>