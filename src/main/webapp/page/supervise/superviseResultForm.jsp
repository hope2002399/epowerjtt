<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
<head>
<title><s:text name="superviseResult.edit.title" /></title>
</head>

<body>
<p class="ctitle"><s:text name="superviseResult.edit.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<s:form action="superviseResult"  method="post" namespace="/supervise" id="superviseResultForm" >
	<s:submit name="save"  method="save" cssClass="btn" key="opt.btn.save" />
	<s:submit type="button" name="back" cssClass="btn" key="opt.btn.back"/>
		
<table width="200" border="0" cellpadding="1" cellspacing="1">		
 
				<tr>
					<td class="TDTITLE">
						<s:text name="superviseResult.no" />
					</td>
					<td align="left">
	
  
							<s:textfield name="no" size="40" />
	
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<s:text name="superviseResult.superviseNo" />
					</td>
					<td align="left">
	
  
						<s:textfield name="superviseNo"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="superviseResult.monitorNo" />
					</td>
					<td align="left">
	
  
						<s:textfield name="monitorNo"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="superviseResult.endDate" />
					</td>
					<td align="left">
	
  
						<s:textfield name="endDate"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="superviseResult.backOperatorId" />
					</td>
					<td align="left">
	
  
						<s:textfield name="backOperatorId"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="superviseResult.backOperatorName" />
					</td>
					<td align="left">
	
  
						<s:textfield name="backOperatorName"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="superviseResult.receiptDate" />
					</td>
					<td align="left">
	
  
						<s:textfield name="receiptDate"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="superviseResult.superviseBack" />
					</td>
					<td align="left">
  
						<s:textarea name="superviseBack" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="superviseResult.confirm" />
					</td>
					<td align="left">
	
  
						<s:textfield name="confirm"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="superviseResult.isExternal" />
					</td>
					<td align="left">
	
  
						<s:textfield name="isExternal"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="superviseResult.superviseResult" />
					</td>
					<td align="left">
  
						<s:textarea name="superviseResult" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="superviseResult.endoperatorid" />
					</td>
					<td align="left">
	
  
						<s:textfield name="endoperatorid"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="superviseResult.endOpinion" />
					</td>
					<td align="left">
  
						<s:textarea name="endOpinion" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="superviseResult.updateDate" />
					</td>
					<td align="left">
	
  
						<s:textfield name="updateDate"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="superviseResult.syncDate" />
					</td>
					<td align="left">
	
  
						<s:textfield name="syncDate"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="superviseResult.syncSign" />
					</td>
					<td align="left">
	
  
						<s:textfield name="syncSign"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="superviseResult.syncErrorDesc" />
					</td>
					<td align="left">
  
						<s:textarea name="syncErrorDesc" cols="40" rows="2"/>
	
	
					</td>
				</tr>

</table>


</s:form>
