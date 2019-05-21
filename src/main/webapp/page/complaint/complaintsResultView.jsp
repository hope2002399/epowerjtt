<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>投诉结果信息</title>
</head>

<body>
<%@ include file="/page/common/messages.jsp"%>	
	<fieldset style="display: block; padding: 10px;">
			<legend>
				<b>投诉办理结果信息</b>
			</legend>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="viewTable">
				<tr>
					<td class="TDTITLE">
						办结类型
					</td>
					<td align="left">
					${cp:MAPVALUE("TSDCJG", result.type)}
						
					</td>
					<td class="TDTITLE">
						办结时间
					</td>
					<td align="left">
						<c:out value="${result.resultDate}" />
					</td>
				</tr>	
					<tr>
					<td class="TDTITLE">
						处理人员编码
					</td>
					<td align="left">
						<c:out value="${result.operatorId}" />
					</td>			
					<td class="TDTITLE">
						处理人员
					</td>
					<td align="left">
						<c:out value="${result.operatorName}" />
					</td>
				</tr>	
				<tr>
					<td class="TDTITLE">
						办结意见
					</td>
					<td align="left" colspan="3">
					
						<c:out value="${result.opinion}" />
					</td>
				</tr>
				<tr>
					<td class="TDTITLE">
						属实投诉类型
					</td>
					<td align="left" colspan="3">
					${cp:MAPVALUE("COMPLAINTS_TYPE", result.detail)}
						
					</td>
				</tr>	

			
</table>
</fieldset>


</body>
</html>
