<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%> 
<html>
<head>
<title>督办结果信息</title>
</head>
<body>
<%@ include file="/page/common/messages.jsp"%>
<fieldset style="display: block; padding: 10px;">
			<legend>
				<b>督办结果信息</b>
			</legend>	
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="viewTable">	


	
				<c:if test="${not empty object.confirm}">
				<tr>
					<td class="addTd">
						反馈是否属实
					</td>
					<td align="left">
						${cp:MAPVALUE("CONFIRM",object.confirm)}
					</td>
			
					<td class="addTd">
				是否客观
					</td>
					<td align="left">
						${cp:MAPVALUE("isExternal",object.isExternal)}
					</td>
				</tr>	
			</c:if>
			<c:if test="${not empty object.superviseResult}">
				<tr>

					<td class="addTd">
						督办结论
					</td>
					<td align="left">
						<s:property value="%{object.superviseResult}" />
					</td>
				
					<td class="addTd">
					督办结论办理人
					</td>
					<td align="left">
						${cp:MAPVALUE("userCode",object.endoperatorid)}
					</td>
				</tr>	
			</c:if>
			<c:if test="${not empty object.endOpinion}">
				<tr>
					<td class="addTd">
					办结意见
					</td>
					<td align="left">
						<s:property value="%{object.endOpinion}" />
					</td>

					<td class="addTd">
						办结时间
					</td>
					<td align="left">
						<s:date name="object.endDate" format="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>				
		</c:if>
</table>



</body>
</html>
