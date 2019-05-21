<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html>
	<head><meta name="decorator" content='${LAYOUT}'/>
		<title>字典明细编辑</title>
	</head>

	<body>
		<fieldset style="padding:10px;">
			<legend class="ctitle" style="width:auto;margin-bottom:10px;">字典明细编辑</legend>
		
		<s:form theme="simple" action="dictionary" namespace="/sys"	>
			<s:hidden name="roid" />
			<s:submit name="method_saveDetail"  method="saveDetail"  cssClass="btn" value="保存" />
			<input type="button" value="返回" class="btn" onclick="window.history.go(-1)" />
			<br/><br/>
			<table cellpadding="0" cellspacing="0" class="viewTable">
				<tr>
					<td class="addTd">
						字典代码
					</td>
					<td align="left">
						<s:textfield name="datadictionary.id.catalogcode" value="%{datadictionary.catalogcode}"  rows="1" cols="40" />
					</td>
				</tr>
				<tr>
					<td class="addTd">
						<c:out value="${fdesc[0]}" />
					</td>
					<td align="left">
						<s:textfield name="datadictionary.id.datacode" rows="1"   value="%{datadictionary.datacode}"   cols="40" />
					</td>
				</tr>
				<tr>
					<td class="addTd">
						<c:out value="${fdesc[1]}" />
					</td>
					<td align="left">
						<s:textfield name="datadictionary.extracode"  value="%{datadictionary.extracode}"  rows="1" cols="40" />
					</td>
				</tr>				<tr>
					<td class="addTd">
						<c:out value="${fdesc[2]}" />
					</td>
					<td align="left">
						<s:textfield name="datadictionary.extracode2"  value="%{datadictionary.extracode2}"  rows="1" cols="40" />
					</td>
				</tr>				
				<tr>
					<td class="addTd">
						<c:out value="${fdesc[3]}" />
					</td>
					<td align="left">
						<s:textfield name="datadictionary.datatag"  value="%{datadictionary.datatag}"  rows="1" cols="40" />
					</td>
				</tr>
				<tr>
					<td class="addTd">
						<c:out value="${fdesc[4]}" />
					</td>
					<td align="left">
						<s:textfield name="datadictionary.datavalue"  value="%{datadictionary.datavalue}"  rows="1" cols="40" />
					</td>
				</tr>				
				
				<tr>
					<td class="addTd">
						<c:out value="${fdesc[5]}" />
					</td>
					<td align="left">
						<s:textfield name="datadictionary.datastyle"  value="%{datadictionary.datastyle}"  rows="1" cols="40" />
					</td>
				</tr>
				<tr>
					<td class="addTd">
						<c:out value="${fdesc[6]}" />
					</td>
					<td align="left">
						<s:textfield name="datadictionary.datadesc"  value="%{datadictionary.datadesc}"  rows="2" cols="40" />
					</td>
				</tr>

			</table>
		</s:form>
		</fieldset>
	</body>
</html>
