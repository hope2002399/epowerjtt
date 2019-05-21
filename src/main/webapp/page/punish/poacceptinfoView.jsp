<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
<head>
<title><s:text name="poacceptinfo.view.title" /></title>
</head>

<body>
<p class="ctitle"><s:text name="poacceptinfo.view.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<a href='punish/poacceptinfo!list.do?ec_p=${param.ec_p}&ec_crd=${param.ec_crd}' property="none">
	<s:text name="opt.btn.back" />
</a>
<p>	
	
<table width="200" border="0" cellpadding="1" cellspacing="1">		
  
				<tr>
					<td class="TDTITLE">
						<s:text name="poacceptinfo.punishobjectid" />
					</td>
					<td align="left">
						<s:property value="%{punishobjectid}" />
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<s:text name="poacceptinfo.jbrSl" />
					</td>
					<td align="left">
						<s:property value="%{jbrSl}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="poacceptinfo.ksrSl" />
					</td>
					<td align="left">
						<s:property value="%{ksrSl}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="poacceptinfo.fzrSl" />
					</td>
					<td align="left">
						<s:property value="%{fzrSl}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="poacceptinfo.jbroptionSl" />
					</td>
					<td align="left">
						<s:property value="%{jbroptionSl}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="poacceptinfo.ksoptionSl" />
					</td>
					<td align="left">
						<s:property value="%{ksoptionSl}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="poacceptinfo.fzroptionSl" />
					</td>
					<td align="left">
						<s:property value="%{fzroptionSl}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="poacceptinfo.jbroptionSltime" />
					</td>
					<td align="left">
						<s:property value="%{jbroptionSltime}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="poacceptinfo.ksoptionSltime" />
					</td>
					<td align="left">
						<s:property value="%{ksoptionSltime}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="poacceptinfo.fzroptionSltime" />
					</td>
					<td align="left">
						<s:property value="%{fzroptionSltime}" />
					</td>
				</tr>	

</table>



</body>
</html>
