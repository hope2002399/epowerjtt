<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="srPermitApply.view.title" /></title>
</head>

<body>
<%-- <p class="ctitle"><s:text name="srPermitApply.view.title" /></p> --%>

<%@ include file="/page/common/messages.jsp"%>

<input type="button" value="返回" Class="btn" onclick="window.history.back()" />

	
<table border="0" cellpadding="0" cellspacing="0" class="viewTable">	
  				<tr>
					<td class="addTd">
						申请日期
					</td>
					<td align="left">
						<s:property value="%{applyDate}" />
					</td>				
					<td class="addTd">
						申请者
					</td>
					<td align="left">
						<s:property value="%{proposerName}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						申请事项
					</td>
					<td align="left" colspan="3">
						<s:property value="%{applyItem}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						申请理由
					</td>
					<td align="left" colspan="3">
						<s:property value="%{applyReason}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						申请方式
					</td>
					<td align="left">
						${cp:MAPEXPRESSION("bjsqfs", applyWay)}
					</td>
				
					<td class="addTd">
						申请者类别 
					</td>
					<td align="left">
						${cp:MAPEXPRESSION("PROPOSER_TYPE", proposerType)}
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						申请者证件类型
					</td>
					<td align="left">
						${cp:MAPEXPRESSION("PaperType", proposerPaperType)}
					</td>
					<td class="addTd">
						申请者证件号码
					</td>
					<td align="left">
						<s:property value="%{proposerPaperCode}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						申请者电话
					</td>
					<td align="left">
						<s:property value="%{proposerPhone}" />
					</td>
					<td class="addTd">
						申请者手机
					</td>
					<td align="left">
						<s:property value="%{proposerMobile}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						申请者地址
					</td>
					<td align="left" colspan="3">
						<s:property value="%{proposerAddr}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						申请者邮编
					</td>
					<td align="left">
						<s:property value="%{proposerZipcode}" />
					</td>
					<td class="addTd">
						申请者电子邮箱
					</td>
					<td align="left">
						<s:property value="%{proposerEmail}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						申请者机构代码
					</td>
					<td align="left">
						<s:property value="%{proposerUnitcode}" />
					</td>
					<td class="addTd">
						代理人姓名
					</td>
					<td align="left">
						<s:property value="%{agentName}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						代理人证件类型
					</td>
					<td align="left">
						${cp:MAPEXPRESSION("PaperType", agentPaperType)}
					</td>
					<td class="addTd">
						代理人证件号码
					</td>
					<td align="left">
						<s:property value="%{agentPaperCode}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						代理人电话
					</td>
					<td align="left">
						<s:property value="%{agentPhone}" />
					</td>
					<td class="addTd">
						代理人手机
					</td>
					<td align="left">
						<s:property value="%{agentMobile}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						代理人地址 
					</td>
					<td align="left" colspan="3">
						<s:property value="%{agentAddr}" />
					</td>
				</tr>	

				<tr>
					<td class="addTd">
						代理人邮编
					</td>
					<td align="left">
						<s:property value="%{agentZipcode}" />
					</td>
					<td class="addTd">
						代理人电子邮箱
					</td>
					<td align="left">
						<s:property value="%{agentEmail}" />
					</td>
				</tr>	

			<%-- 	<tr>
					<td class="addTd">
						代理人机构代码
					</td>
					<td align="left" colspan="3">
						<s:property value="%{agentUnitcode}" />
					</td>
				</tr>	 --%>

				<tr>
					<td class="addTd">
						申请备注 
					</td>
					<td align="left" colspan="3">
						<s:property value="%{applyMemo}" />
					</td>
				</tr>	
</table>
</body>
</html>
