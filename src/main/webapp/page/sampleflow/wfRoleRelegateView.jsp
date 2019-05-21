<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
<head>
<title><s:text name="wfRoleRelegate.view.title" /></title>
</head>

<body>
<p class="ctitle"><s:text name="wfRoleRelegate.view.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<a href='sampleflow/wfRoleRelegate!list.do?ec_p=${param.ec_p}&ec_crd=${param.ec_crd}' property="none">
	<s:text name="opt.btn.back" />
</a>
<p>	
	
<table width="200" border="0" cellpadding="1" cellspacing="1">		
  
				<tr>
					<td class="TDTITLE">
						<s:text name="wfRoleRelegate.relegateno" />
					</td>
					<td align="left">
						<s:property value="%{relegateno}" />
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<s:text name="wfRoleRelegate.grantor" />
					</td>
					<td align="left">
						<s:property value="%{grantor}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="wfRoleRelegate.grantee" />
					</td>
					<td align="left">
						<s:property value="%{grantee}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="wfRoleRelegate.isvalid" />
					</td>
					<td align="left">
						<s:property value="%{isvalid}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="wfRoleRelegate.relegatetime" />
					</td>
					<td align="left">
						<s:property value="%{relegatetime}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="wfRoleRelegate.expiretime" />
					</td>
					<td align="left">
						<s:property value="%{expiretime}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="wfRoleRelegate.unitcode" />
					</td>
					<td align="left">
						<s:property value="%{unitcode}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="wfRoleRelegate.roletype" />
					</td>
					<td align="left">
						<s:property value="%{roletype}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="wfRoleRelegate.rolecode" />
					</td>
					<td align="left">
						<s:property value="%{rolecode}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="wfRoleRelegate.grantdesc" />
					</td>
					<td align="left">
						<s:property value="%{grantdesc}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="wfRoleRelegate.recorder" />
					</td>
					<td align="left">
						<s:property value="%{recorder}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="wfRoleRelegate.recorddate" />
					</td>
					<td align="left">
						<s:property value="%{recorddate}" />
					</td>
				</tr>	

</table>



</body>
</html>
