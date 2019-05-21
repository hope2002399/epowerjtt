<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
<head>
<title><s:text name="VUserTaskListReconsider.view.title" /></title>
</head>

<body>
<p class="ctitle"><s:text name="VUserTaskListReconsider.view.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<a href='supervise/VUserTaskListReconsider!list.do?ec_p=${param.ec_p}&ec_crd=${param.ec_crd}' property="none">
	<s:text name="opt.btn.back" />
</a>
<p>	
	
<table width="200" border="0" cellpadding="1" cellspacing="1">		
  
				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.taskId" />
					</td>
					<td align="left">
						<s:property value="%{taskId}" />
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.nodeInstId" />
					</td>
					<td align="left">
						<s:property value="%{nodeInstId}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.unitCode" />
					</td>
					<td align="left">
						<s:property value="%{unitCode}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.userCode" />
					</td>
					<td align="left">
						<s:property value="%{userCode}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.roleType" />
					</td>
					<td align="left">
						<s:property value="%{roleType}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.roleCode" />
					</td>
					<td align="left">
						<s:property value="%{roleCode}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.optId" />
					</td>
					<td align="left">
						<s:property value="%{optId}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.flowOptName" />
					</td>
					<td align="left">
						<s:property value="%{flowOptName}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.flowOptTag" />
					</td>
					<td align="left">
						<s:property value="%{flowOptTag}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.authDesc" />
					</td>
					<td align="left">
						<s:property value="%{authDesc}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.nodeName" />
					</td>
					<td align="left">
						<s:property value="%{nodeName}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.nodeType" />
					</td>
					<td align="left">
						<s:property value="%{nodeType}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.nodeOptType" />
					</td>
					<td align="left">
						<s:property value="%{nodeOptType}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.optName" />
					</td>
					<td align="left">
						<s:property value="%{optName}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.methodName" />
					</td>
					<td align="left">
						<s:property value="%{methodName}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.optUrl" />
					</td>
					<td align="left">
						<s:property value="%{optUrl}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.optMethod" />
					</td>
					<td align="left">
						<s:property value="%{optMethod}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.optDesc" />
					</td>
					<td align="left">
						<s:property value="%{optDesc}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.optCode" />
					</td>
					<td align="left">
						<s:property value="%{optCode}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.optParam" />
					</td>
					<td align="left">
						<s:property value="%{optParam}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.inststate" />
					</td>
					<td align="left">
						<s:property value="%{inststate}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.nodeCreateTime" />
					</td>
					<td align="left">
						<s:property value="%{nodeCreateTime}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.expireOptSign" />
					</td>
					<td align="left">
						<s:property value="%{expireOptSign}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.expireOpt" />
					</td>
					<td align="left">
						<s:property value="%{expireOpt}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.grantor" />
					</td>
					<td align="left">
						<s:property value="%{grantor}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.grantOrgId" />
					</td>
					<td align="left">
						<s:property value="%{grantOrgId}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.timeLimit" />
					</td>
					<td align="left">
						<s:property value="%{timeLimit}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.lastUpdateUser" />
					</td>
					<td align="left">
						<s:property value="%{lastUpdateUser}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.lastUpdateTime" />
					</td>
					<td align="left">
						<s:property value="%{lastUpdateTime}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.flowPhase" />
					</td>
					<td align="left">
						<s:property value="%{flowPhase}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.reconsiderid" />
					</td>
					<td align="left">
						<s:property value="%{reconsiderid}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.reconsiderdate" />
					</td>
					<td align="left">
						<s:property value="%{reconsiderdate}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.reconsiderapply" />
					</td>
					<td align="left">
						<s:property value="%{reconsiderapply}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.applyphone" />
					</td>
					<td align="left">
						<s:property value="%{applyphone}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.applydate" />
					</td>
					<td align="left">
						<s:property value="%{applydate}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.applyreason" />
					</td>
					<td align="left">
						<s:property value="%{applyreason}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.applyremark" />
					</td>
					<td align="left">
						<s:property value="%{applyremark}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.reconsiderdep" />
					</td>
					<td align="left">
						<s:property value="%{reconsiderdep}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.bookoperator" />
					</td>
					<td align="left">
						<s:property value="%{bookoperator}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.bookdate" />
					</td>
					<td align="left">
						<s:property value="%{bookdate}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.flowInstId" />
					</td>
					<td align="left">
						<s:property value="%{flowInstId}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.bjType" />
					</td>
					<td align="left">
						<s:property value="%{bjType}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.bjNo" />
					</td>
					<td align="left">
						<s:property value="%{bjNo}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.itemId" />
					</td>
					<td align="left">
						<s:property value="%{itemId}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.internalNo" />
					</td>
					<td align="left">
						<s:property value="%{internalNo}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.orgId" />
					</td>
					<td align="left">
						<s:property value="%{orgId}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.optId" />
					</td>
					<td align="left">
						<s:property value="%{optId}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.biztype" />
					</td>
					<td align="left">
						<s:property value="%{biztype}" />
					</td>
				</tr>	

</table>



</body>
</html>
