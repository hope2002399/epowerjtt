<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
<head>
<title><s:text name="reconsiderresult.edit.title" /></title>
</head>

<body>
<p class="ctitle"><s:text name="reconsiderresult.edit.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<s:form action="reconsiderresult"  method="post" namespace="/supervise" id="reconsiderresultForm" >
	<s:submit name="save"  method="save" cssClass="btn" key="opt.btn.save" />
	<s:submit type="button" name="back" cssClass="btn" key="opt.btn.back"/>
		
<table width="200" border="0" cellpadding="1" cellspacing="1">		
 
				<tr>
					<td class="TDTITLE">
						<s:text name="reconsiderresult.reconsiderId" />
					</td>
					<td align="left">
	
  
							<s:textfield name="reconsiderId" size="40" />
	
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<s:text name="reconsiderresult.reconsiderenddate" />
					</td>
					<td align="left">
	
  
						<s:textfield name="reconsiderenddate"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="reconsiderresult.reconsiderresult" />
					</td>
					<td align="left">
	
  
						<s:textfield name="reconsiderresult"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="reconsiderresult.reconsiderremark" />
					</td>
					<td align="left">
  
						<s:textarea name="reconsiderremark" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="reconsiderresult.operatorId" />
					</td>
					<td align="left">
	
  
						<s:textfield name="operatorId"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="reconsiderresult.operatorName" />
					</td>
					<td align="left">
	
  
						<s:textfield name="operatorName"  size="40"/>
	
					</td>
				</tr>

</table>


</s:form>
