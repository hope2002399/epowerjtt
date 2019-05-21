<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="incomeDoc.view.title" /></title>
</head>

<body>
	<%@ include file="/page/common/messages.jsp"%>
	
	<p>	
	<fieldset style="padding: 10px; display: block; margin-bottom: 10px;">
		<legend style="padding:4px 8px 3px;"><b>收文信息查看</b></legend>
		<table width="200" border="0" cellpadding="0" cellspacing="0" class="viewTable">
<!-- 			<tr> -->
<!-- 				<td class="addTd"> -->
<!-- 					权力编码 -->
<!-- 				</td> -->
<!-- 				<td align="left"> -->
<%-- 					<s:property value="%{object.itemId}" /> --%>
<!-- 				</td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td class="addTd"> -->
<!-- 					部门内部事项编号 -->
<!-- 				</td> -->
<!-- 				<td align="left"> -->
<%-- 					<s:property value="%{object.internalNo}" /> --%>
<!-- 				</td> -->
<!-- 			</tr> -->
			<tr>
				<td class="addTd">
					收文编号
				</td>
				<td align="left">
					<s:property value="%{object.acceptNo}" />
				</td>
			</tr>
			<tr>
				<td class="addTd">
					来文文号
				</td>
				<td align="left">
					<s:property value="%{object.incomeDocNo}" />
				</td>
			</tr>
			<tr>
				<td class="addTd">
					来文标题
				</td>
				<td align="left">
					<s:property value="%{object.incomeDocTitle}" />
				</td>
			</tr>
			<tr>
				<td class="addTd">
					来文机关
				</td>
				<td align="left">
					<s:property value="%{object.incomeDeptName}" />
				</td>
			</tr>
<!-- 			<tr> -->
<!-- 				<td class="addTd"> -->
<!-- 					正文文件类型 -->
<!-- 				</td> -->
<!-- 				<td align="left"> -->
<%-- 					<s:property value="%{object.incomeDocFileName}" /> --%>
<!-- 				</td> -->
<!-- 			</tr> -->
		</table>
	</fieldset>
</body>
</html>
