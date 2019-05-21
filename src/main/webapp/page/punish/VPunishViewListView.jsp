<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
<head>
<title><s:text name="VPunishViewList.view.title" /></title>
</head>

<body>
<p class="ctitle"><s:text name="VPunishViewList.view.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<a href='punish/VPunishViewList!list.do?ec_p=${param.ec_p}&ec_crd=${param.ec_crd}' property="none">
	<s:text name="opt.btn.back" />
</a>
<p>	
	
<table width="200" border="0" cellpadding="1" cellspacing="1">		
  
				<tr>
					<td class="TDTITLE">
						<s:text name="VPunishViewList.punishobjectid" />
					</td>
					<td align="left">
						<s:property value="%{punishobjectid}" />
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<s:text name="VPunishViewList.wfoptname" />
					</td>
					<td align="left">
						<s:property value="%{wfoptname}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VPunishViewList.unitCode" />
					</td>
					<td align="left">
						<s:property value="%{unitCode}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VPunishViewList.nodeName" />
					</td>
					<td align="left">
						<s:property value="%{nodeName}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VPunishViewList.createtime" />
					</td>
					<td align="left">
						<s:property value="%{createtime}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VPunishViewList.punishobjectno" />
					</td>
					<td align="left">
						<s:property value="%{punishobjectno}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VPunishViewList.punishobjecttype" />
					</td>
					<td align="left">
						<s:property value="%{punishobjecttype}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VPunishViewList.managedepid" />
					</td>
					<td align="left">
						<s:property value="%{managedepid}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VPunishViewList.poregisterdate" />
					</td>
					<td align="left">
						<s:property value="%{poregisterdate}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VPunishViewList.pooccurstate" />
					</td>
					<td align="left">
						<s:property value="%{pooccurstate}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VPunishViewList.punishobjectstate" />
					</td>
					<td align="left">
						<s:property value="%{punishobjectstate}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VPunishViewList.pooccurdate" />
					</td>
					<td align="left">
						<s:property value="%{pooccurdate}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VPunishViewList.poregistedate" />
					</td>
					<td align="left">
						<s:property value="%{poregistedate}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VPunishViewList.pooriginstate" />
					</td>
					<td align="left">
						<s:property value="%{pooriginstate}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VPunishViewList.flowInstId" />
					</td>
					<td align="left">
						<s:property value="%{flowInstId}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="VPunishViewList.optId" />
					</td>
					<td align="left">
						<s:property value="%{optId}" />
					</td>
				</tr>	

</table>



</body>
</html>
