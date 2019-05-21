<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
<head>
<title><s:text name="complaintsResult.edit.title" /></title>
</head>

<body>
<p class="ctitle"><s:text name="complaintsResult.edit.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<s:form action="complaintsResult"  method="post" namespace="/complaint" id="complaintsResultForm" >
	<s:submit name="save"  method="save" cssClass="btn" key="opt.btn.save" />
	<s:submit type="button" name="back" cssClass="btn" key="opt.btn.back"/>
		
<table width="200" border="0" cellpadding="1" cellspacing="1">		
 
				<tr>
					<td class="TDTITLE">
						<s:text name="complaintsResult.no" />
					</td>
					<td align="left">
	
  
							<s:textfield name="no" size="40" />
	
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<s:text name="complaintsResult.complaintid" />
					</td>
					<td align="left">
	
  
						<s:textfield name="complaintid"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="complaintsResult.type" />
					</td>
					<td align="left">
	
  
						<s:textfield name="type"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="complaintsResult.detail" />
					</td>
					<td align="left">
	
  
						<s:textfield name="detail"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="complaintsResult.operatorId" />
					</td>
					<td align="left">
	
  
						<s:textfield name="operatorId"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="complaintsResult.operatorName" />
					</td>
					<td align="left">
	
  
						<s:textfield name="operatorName"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="complaintsResult.resultDate" />
					</td>
					<td align="left">
	
  
						<s:textfield name="resultDate"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="complaintsResult.opinion" />
					</td>
					<td align="left">
  
						<s:textarea name="opinion" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="complaintsResult.updateDate" />
					</td>
					<td align="left">
	
  
						<s:textfield name="updateDate"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="complaintsResult.syncDate" />
					</td>
					<td align="left">
	
  
						<s:textfield name="syncDate"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="complaintsResult.syncSign" />
					</td>
					<td align="left">
	
  
						<s:textfield name="syncSign"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="complaintsResult.syncErrorDesc" />
					</td>
					<td align="left">
  
						<s:textarea name="syncErrorDesc" cols="40" rows="2"/>
	
	
					</td>
				</tr>

</table>


</s:form>
