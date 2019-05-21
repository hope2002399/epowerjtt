<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>办件基础信息</title>
</head>

<body>
	<input type="hidden" id="flowInstId" name="flowInstId"
		value="${flowInstId}" />
	<input type="hidden" id="djId" name="djId" value="${djId}" />
	<input type="hidden" name="nodeInstId" value="${nodeInstId}">
	<input type="hidden" id="flowCode" name="flowCode" value="${flowCode}" />
	<fieldset style="display: block; padding: 10px; margin-bottom: 10px;">
		<legend>
			<b>办件信息</b>
		</legend>
		<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
			<tr>
				<td class="addTd" width="130">办件名称</td>
				<td align="left"><input type="hidden" id="transaffairname"
					name="optBaseInfo.transaffairname">${object.optBaseInfo.transaffairname}</td>
			</tr>
			<tr>
				<td class="addTd">权力事项</td>
				<td align="left"><input type="hidden" id="powername"
					name="optBaseInfo.powername">
					${object.optBaseInfo.powername}</td>
			</tr>
			<tr>
				<td class="addTd">
						权力类型
					</td>
					<td align="left">
					${cp:MAPVALUE("ITEM_TYPE",object.applyItemType)}
						<%-- <s:textfield name="applyItem"  value="%{object.applyItem}" readonly="true" /> --%>
					</td>
			</tr>
			<tr>
				<td class="addTd">办理单位</td>
				<td align="left"><input type="hidden"
					name="optBaseInfo.orgcode"> ${object.optBaseInfo.orgname}</td>
			</tr>
			<tr>
				<td class="addTd">办件摘要</td>
				<td align="left">${object.optBaseInfo.content}</td>
			</tr>
		</table>
	</fieldset>
</body>
</html>
