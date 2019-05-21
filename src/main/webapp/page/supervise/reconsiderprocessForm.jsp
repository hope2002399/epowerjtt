<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
<head>
<title><s:text name="reconsiderprocess.edit.title" /></title>
</head>

<body>
<p class="ctitle"><s:text name="reconsiderprocess.edit.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<s:form action="reconsiderprocess"  method="post" namespace="/supervise" id="reconsiderprocessForm" >
	<s:submit name="save"  method="save" cssClass="btn" key="opt.btn.save" />
	<s:submit type="button" name="back" cssClass="btn" key="opt.btn.back"/>
		
<table width="200" border="0" cellpadding="1" cellspacing="1">		
 
				<tr>
					<td class="TDTITLE">
						<s:text name="reconsiderprocess.processno" />
					</td>
					<td align="left">
	
  
							<s:textfield name="processno" size="40" />
	
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<s:text name="reconsiderprocess.nodeinstid" />
					</td>
					<td align="left">
	
  
						<s:textfield name="nodeinstid"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="reconsiderprocess.reconsiderId" />
					</td>
					<td align="left">
	
  
						<s:textfield name="reconsiderId"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="reconsiderprocess.processCode" />
					</td>
					<td align="left">
	
  
						<s:textfield name="processCode"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="reconsiderprocess.processName" />
					</td>
					<td align="left">
  
						<s:textarea name="processName" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="reconsiderprocess.processDate" />
					</td>
					<td align="left">
	
  
						<s:textfield name="processDate"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="reconsiderprocess.operatorId" />
					</td>
					<td align="left">
	
  
						<s:textfield name="operatorId"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="reconsiderprocess.operatorName" />
					</td>
					<td align="left">
	
  
						<s:textfield name="operatorName"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="reconsiderprocess.operatorResult" />
					</td>
					<td align="left">
	
  
						<s:textfield name="operatorResult"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="reconsiderprocess.operatorOpinion" />
					</td>
					<td align="left">
  
						<s:textarea name="operatorOpinion" cols="40" rows="2"/>
	
	
					</td>
				</tr>

</table>


</s:form>
