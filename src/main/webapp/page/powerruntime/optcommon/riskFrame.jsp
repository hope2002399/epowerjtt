<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>风险点信息</title>
</head>

<body>
<div id="ss"></div>
<s:form action="srPermitApply!saveBaseInfoOfRisk.do"  method="post" namespace="/wwd" target="_self" id="risks">
<input type="hidden" id="riskType" name="riskType"  value="${object.optBaseInfo.riskType}" />
<input type="hidden" id="riskDesc" name="riskDesc"  value="${object.optBaseInfo.riskDesc}" />
<input type="hidden" id="djId" name="djId"  value="${object.djId}" />


<table border="0" cellpadding="0" cellspacing="0" class="viewTable">	
					<tr>
					<td class="addTd" width="130">
						风险类别
					</td>
					<td align="left">
						    ${cp:MAPVALUE("RISKTYPE",object.optBaseInfo.riskType)}
					</td>
				</tr>	
				<tr>
					<td class="addTd" width="130">
						风险描述
					</td>
					<td align="left">${object.optBaseInfo.riskDesc}
					</td>
				</tr>
				
				<tr>
					<td class="addTd">
						风险内控手段与结果	
					</td>
					<td align="left">
						<s:textarea name="riskResult" id="riskResult" value="%{object.optBaseInfo.riskResult}" style="width:100%;height:40px;" />
					</td>
				</tr>			
</table>
</s:form>
</body>
</html>
