<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%> 
<html>
<head>
<title><s:text name="reconsiderresult.view.title" /></title>
</head>

<body>
<%@ include file="/page/common/messages.jsp"%>
<fieldset style="display: block; padding: 10px;">
	<legend> <b>行政复议结果</b></legend>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="viewTable">		
	
  
				<tr>
					<td class="addTd">
					办结类型
					</td>
					<td align="left">
						${cp:MAPVALUE("finishType",(object.finishType))}
					</td>				
					<td class="addTd">
					复议完成时间
					</td>
					<td align="left">
					<fmt:formatDate value='${object.reconsiderenddate}' pattern='yyyy-MM-dd hh:mm:ss' />
					</td>
				</tr>	

				<tr>
					<td class="addTd">
					复议结果
					</td>
					<td align="left">
						${cp:MAPVALUE("reconsiderResult",(object.reconsiderresult))}
					</td>
					<td class="addTd">
						处理人员
					</td>
					<td align="left">
						<s:property value="%{object.operatorName}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						备注
					</td>
					<td align="left"  colspan="3">
						<s:property value="%{object.reconsiderremark}" />
					</td>
				</tr>				


</table>
</fieldset>



</body>
</html>
