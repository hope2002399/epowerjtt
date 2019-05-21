<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
<head>
<title><s:text name="podecisioninfo.view.title" /></title>
</head>

<body>
<p class="ctitle"><s:text name="podecisioninfo.view.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<a href='punish/podecisioninfo!list.do?ec_p=${param.ec_p}&ec_crd=${param.ec_crd}' property="none">
	<s:text name="opt.btn.back" />
</a>
<p>	
	
<table width="200" border="0" cellpadding="1" cellspacing="1">		
  
				<tr>
					<td class="TDTITLE">
						<s:text name="podecisioninfo.punishobjectid" />
					</td>
					<td align="left">
						<s:property value="%{punishobjectid}" />
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<s:text name="podecisioninfo.jbrCfjd" />
					</td>
					<td align="left">
						<s:property value="%{jbrCfjd}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="podecisioninfo.ksrCfjd" />
					</td>
					<td align="left">
						<s:property value="%{ksrCfjd}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="podecisioninfo.fzrCfjd" />
					</td>
					<td align="left">
						<s:property value="%{fzrCfjd}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="podecisioninfo.jbroptionCfjd" />
					</td>
					<td align="left">
						<s:property value="%{jbroptionCfjd}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="podecisioninfo.ksoptionCfjd" />
					</td>
					<td align="left">
						<s:property value="%{ksoptionCfjd}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="podecisioninfo.fzroptionCfjd" />
					</td>
					<td align="left">
						<s:property value="%{fzroptionCfjd}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="podecisioninfo.jbroptionCfjdtime" />
					</td>
					<td align="left">
						<s:property value="%{jbroptionCfjdtime}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="podecisioninfo.ksoptionCfjdtime" />
					</td>
					<td align="left">
						<s:property value="%{ksoptionCfjdtime}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="podecisioninfo.fzroptionCfjdtime" />
					</td>
					<td align="left">
						<s:property value="%{fzroptionCfjdtime}" />
					</td>
				</tr>	

</table>



</body>
</html>
