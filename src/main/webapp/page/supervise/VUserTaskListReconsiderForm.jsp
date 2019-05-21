<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
<head>
<title><s:text name="VUserTaskListReconsider.edit.title" /></title>
</head>

<body>
<p class="ctitle"><s:text name="VUserTaskListReconsider.edit.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<s:form action="VUserTaskListReconsider"  method="post" namespace="/supervise" id="VUserTaskListReconsiderForm" >
	<s:submit name="save"  method="save" cssClass="btn" key="opt.btn.save" />
	<s:submit type="button" name="back" cssClass="btn" key="opt.btn.back"/>
		
<table width="200" border="0" cellpadding="1" cellspacing="1">		
 
				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.taskId" />
					</td>
					<td align="left">
	
  
							<s:textfield name="taskId" size="40" />
	
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.nodeInstId" />
					</td>
					<td align="left">
	
  
						<s:textfield name="nodeInstId"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.unitCode" />
					</td>
					<td align="left">
	
  
						<s:textfield name="unitCode"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.userCode" />
					</td>
					<td align="left">
	
  
						<s:textfield name="userCode"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.roleType" />
					</td>
					<td align="left">
	
  
						<s:textfield name="roleType"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.roleCode" />
					</td>
					<td align="left">
	
  
						<s:textfield name="roleCode"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.optId" />
					</td>
					<td align="left">
	
  
						<s:textfield name="optId"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.flowOptName" />
					</td>
					<td align="left">
  
						<s:textarea name="flowOptName" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.flowOptTag" />
					</td>
					<td align="left">
  
						<s:textarea name="flowOptTag" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.authDesc" />
					</td>
					<td align="left">
  
						<s:textarea name="authDesc" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.nodeName" />
					</td>
					<td align="left">
  
						<s:textarea name="nodeName" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.nodeType" />
					</td>
					<td align="left">
	
  
						<s:textfield name="nodeType"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.nodeOptType" />
					</td>
					<td align="left">
	
  
						<s:textfield name="nodeOptType"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.optName" />
					</td>
					<td align="left">
	
  
						<s:textfield name="optName"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.methodName" />
					</td>
					<td align="left">
	
  
						<s:textfield name="methodName"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.optUrl" />
					</td>
					<td align="left">
  
						<s:textarea name="optUrl" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.optMethod" />
					</td>
					<td align="left">
	
  
						<s:textfield name="optMethod"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.optDesc" />
					</td>
					<td align="left">
  
						<s:textarea name="optDesc" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.optCode" />
					</td>
					<td align="left">
	
  
						<s:textfield name="optCode"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.optParam" />
					</td>
					<td align="left">
  
						<s:textarea name="optParam" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.inststate" />
					</td>
					<td align="left">
	
  
						<s:textfield name="inststate"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.nodeCreateTime" />
					</td>
					<td align="left">
	
  
						<s:textfield name="nodeCreateTime"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.expireOptSign" />
					</td>
					<td align="left">
	
  
						<s:textfield name="expireOptSign"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.expireOpt" />
					</td>
					<td align="left">
	
  
						<s:textfield name="expireOpt"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.grantor" />
					</td>
					<td align="left">
	
  
						<s:textfield name="grantor"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.grantOrgId" />
					</td>
					<td align="left">
	
  
						<s:textfield name="grantOrgId"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.timeLimit" />
					</td>
					<td align="left">
	
  
						<s:textfield name="timeLimit"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.lastUpdateUser" />
					</td>
					<td align="left">
	
  
						<s:textfield name="lastUpdateUser"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.lastUpdateTime" />
					</td>
					<td align="left">
	
  
						<s:textfield name="lastUpdateTime"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.flowPhase" />
					</td>
					<td align="left">
	
  
						<s:textfield name="flowPhase"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.reconsiderid" />
					</td>
					<td align="left">
	
  
						<s:textfield name="reconsiderid"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.reconsiderdate" />
					</td>
					<td align="left">
	
  
						<s:textfield name="reconsiderdate"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.reconsiderapply" />
					</td>
					<td align="left">
  
						<s:textarea name="reconsiderapply" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.applyphone" />
					</td>
					<td align="left">
  
						<s:textarea name="applyphone" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.applydate" />
					</td>
					<td align="left">
	
  
						<s:textfield name="applydate"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.applyreason" />
					</td>
					<td align="left">
  
						<s:textarea name="applyreason" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.applyremark" />
					</td>
					<td align="left">
  
						<s:textarea name="applyremark" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.reconsiderdep" />
					</td>
					<td align="left">
  
						<s:textarea name="reconsiderdep" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.bookoperator" />
					</td>
					<td align="left">
	
  
						<s:textfield name="bookoperator"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.bookdate" />
					</td>
					<td align="left">
	
  
						<s:textfield name="bookdate"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.flowInstId" />
					</td>
					<td align="left">
	
  
						<s:textfield name="flowInstId"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.bjType" />
					</td>
					<td align="left">
	
  
						<s:textfield name="bjType"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.bjNo" />
					</td>
					<td align="left">
	
  
						<s:textfield name="bjNo"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.itemId" />
					</td>
					<td align="left">
  
						<s:textarea name="itemId" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.internalNo" />
					</td>
					<td align="left">
  
						<s:textarea name="internalNo" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.orgId" />
					</td>
					<td align="left">
	
  
						<s:textfield name="orgId"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.optId" />
					</td>
					<td align="left">
	
  
						<s:textfield name="optId"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VUserTaskListReconsider.biztype" />
					</td>
					<td align="left">
	
  
						<s:textfield name="biztype"  size="40"/>
	
					</td>
				</tr>

</table>


</s:form>
