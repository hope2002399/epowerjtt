<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
<head>
<title><s:text name="trPunishDetail.view.title" /></title>
</head>

<body>
<p class="ctitle"><s:text name="trPunishDetail.view.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<a href='powerruntime/trPunishDetail!list.do?ec_p=${param.ec_p}&ec_crd=${param.ec_crd}' property="none">
	<s:text name="opt.btn.back" />
</a>
<p>	
	
<table width="200" border="0" cellpadding="1" cellspacing="1">		
  
				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishDetail.djId" />
					</td>
					<td align="left">
						<s:property value="%{djId}" />
					</td>
				</tr>
  
				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishDetail.punishItem" />
					</td>
					<td align="left">
						<s:property value="%{punishItem}" />
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishDetail.punishName" />
					</td>
					<td align="left">
						<s:property value="%{punishName}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishDetail.isreal" />
					</td>
					<td align="left">
						<s:property value="%{isreal}" />
					</td>
				</tr>	

</table>



</body>
</html>
