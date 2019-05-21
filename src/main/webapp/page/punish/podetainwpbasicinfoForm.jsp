<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<sj:head locale="zh_CN" />
</head>
<body>
<%@ include file="/page/common/messages.jsp"%>
<s:form name="podetainwpbasicinfoForm" action="podetainwpbasicinfo" method="post" namespace="/punish" id="podetainwpbasicinfoForm" target="_self">
		<input type="hidden" name="s_punishobjectid" value="${object.punishobjectid}"/>
		<s:submit name="save" method="save" cssClass="btn" key="保存" />
		<s:submit name="back" method="list" cssClass="btn" key="返回"/>
		<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
		
		<tr>
		<td class="addTd" width="130">处罚办件编号</td>
		<td align="left"><s:textfield  value="%{object.punishobjectid}" size="10"  name="punishobjectid" maxLength="10"/></td>
		</tr>
		
		<tr>
		<td class="addTd" width="130">物品名称</td>
		<td align="left"><s:textfield size="32" name="wpname" maxLength="32"/></td>
		</tr>
		
		<tr>
		<td class="addTd" width="130">物品类别</td>
		<td align="left">
		<select id="wptype" name="wptype">			
					<c:forEach var="row" items="${cp:DICTIONARY('wptype')}">
						<option value="${row.key}"
						<c:if test="${object.wptype eq row.key}"> selected = "selected" </c:if> 
						
						>
						<c:out value="${row.value}" /></option>
					</c:forEach>
		</select>
		</td>
		</tr>
		
		<tr>
		<td class="addTd" width="130">接收时间</td>
		<td align="left">
			<sj:datepicker id="receivedate" 
			name="receivedate"  style="width:140px"
			yearRange="2000:2020" timepickerFormat="hh:mm:ss" displayFormat="yy-mm-dd" changeYear="true"  timepicker="true"
			value="%{object.receivedate}"/>
		</tr>
		
		<tr>
		<td class="addTd" width="130">接收地点</td>
		<td align="left"><s:textfield size="32" name="receivelocation" maxlength="32"/></td>
		</tr>
		
		<tr>
		<td class="addTd" width="130">接收人员</td>
		<td align="left">
		<input maxlength="32" type="text" name="receiveperson" value="${cp:MAPVALUE('usercode',object.receiveperson)}" size="32"/>
		</td>
		</tr>
		
		<tr>
		<td class="addTd" width="130">对方确认人</td>
		<td align="left"><s:textfield size="32" name="confirmperson" maxlength="32"/></td>
		</tr>
		
		<tr>
		<td class="addTd" width="130">物品当前位置</td>
		<td align="left"><s:textfield size="32" name="wpcurrentlocation" maxlength="32"/></td>
		</tr>
		
		<tr>
		<td class="addTd" width="130">备注</td>
		<td align="left"> <s:textarea value="%{object.remark}" name="remark" style="width:230;height:80px;" /></td>
		</tr>
		</table>
</s:form>
</body>
</html>