<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<sj:head locale="zh_CN" />
</head>
<body>
<%@ include file="/page/common/messages.jsp"%>
<s:form name="podetainwptransinfoForm" action="podetainwptransinfo" method="post" namespace="/punish" id="podetainwptransinfoForm" target="_self">
		<s:submit name="save" method="save" cssClass="btn" key="保存" />
		<s:submit name="back" method="list" cssClass="btn" key="返回"/>
		<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
	<tr>
		<td class="addTd" width="130">物品名称</td>
		<td align="left"><s:text  name="wpinfo.wpname" /></td>
	</tr>
	<tr>
		<td class="addTd" width="130">所属办件</td>
		<td align="left"><s:text  name="wpinfo.punishobjectid" /></td>
	</tr>
	
	<tr>
		<td class="addTd" width="130">当前位置</td>
		<td align="left"><s:text  name="wpinfo.wpcurrentlocation" /></td>
	</tr>
	
	<tr>
		<td class="addTd" width="130">${keyword}地点</td>
		<td align="left"><s:textfield  name="translocation" size="32" maxlength="100" /></td>
	</tr>
	
	<tr>
		<td class="addTd" width="130">${keyword}时间</td>
		<td align="left">
			<sj:datepicker id="receivedate" 
			name="receivedate"  style="width:140px"
			yearRange="2000:2020" timepickerFormat="hh:mm:ss" displayFormat="yy-mm-dd" changeYear="true"  timepicker="true"
			value="%{object.receivedate}"/>
	</tr>
	
	<tr>
		<td class="addTd" width="130">${keyword}人员</td>
		<td align="left">
		<input maxlength="32" type="text" name="transperson" size="32" value="${cp:MAPVALUE('usercode',object.transperson)}"/>
		</td>
	</tr>
	<c:if test="${keyword =='移交' or keyword=='归还'}">
	<tr>
		<td class="addTd" width="130">接收人员</td>
		<td align="left">
		<input maxlength="32" type="text" name="receiveperson"  size="32"/>
		</td>
	</tr>
	</c:if>	
			<tr>
		<td class="addTd" width="130">备注</td>
		<td align="left"> <s:textarea value="%{object.remark}" name="remark" style="width:230;height:80px;" /></td>
		</tr>
		</table>
</s:form>
</body>
</html>