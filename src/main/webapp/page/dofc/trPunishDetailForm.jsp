<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
<head>
<title><s:text name="trPunishDetail.edit.title" /></title>
</head>

<body>
<p class="ctitle"><s:text name="trPunishDetail.edit.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<s:form action="trPunishDetail"  method="post" namespace="/dofc" id="trPunishDetailForm" >
	<s:submit name="save"  method="save" cssClass="btn" key="opt.btn.save" />
	<s:submit type="button" name="back" cssClass="btn" key="opt.btn.back"/>
		
<table width="200" border="0" cellpadding="1" cellspacing="1">		
 
				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishDetail.djId" />
					</td>
					<td align="left">
	
  
							<s:textfield name="djId" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishDetail.punishItem" />
					</td>
					<td align="left">
	
  
							<s:textfield name="punishItem" size="40" />
	
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishDetail.punishName" />
					</td>
					<td align="left">
  
						<s:textarea name="punishName" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishDetail.isreal" />
					</td>
					<td align="left">
	
  
						<s:textfield name="isreal"  size="40"/>
	
					</td>
				</tr>

</table>


</s:form>
