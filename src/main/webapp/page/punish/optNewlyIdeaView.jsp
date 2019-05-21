<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
<head>
<title><s:text name="optNewlyIdea.view.title" /></title>
</head>

<body>
<p class="ctitle"><s:text name="optNewlyIdea.view.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<a href='punish/optNewlyIdea!list.do?ec_p=${param.ec_p}&ec_crd=${param.ec_crd}' property="none">
	<s:text name="opt.btn.back" />
</a>
<p>	
	
<table width="200" border="0" cellpadding="1" cellspacing="1">		
  
				<tr>
					<td class="TDTITLE">
						<s:text name="optNewlyIdea.punishobjectid" />
					</td>
					<td align="left">
						<s:property value="%{punishobjectid}" />
					</td>
				</tr>
  
				<tr>
					<td class="TDTITLE">
						<s:text name="optNewlyIdea.nodeid" />
					</td>
					<td align="left">
						<s:property value="%{nodeid}" />
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<s:text name="optNewlyIdea.nodeinstid" />
					</td>
					<td align="left">
						<s:property value="%{nodeinstid}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="optNewlyIdea.nodename" />
					</td>
					<td align="left">
						<s:property value="%{nodename}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="optNewlyIdea.isdisplay" />
					</td>
					<td align="left">
						<s:property value="%{isdisplay}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="optNewlyIdea.orderno" />
					</td>
					<td align="left">
						<s:property value="%{orderno}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="optNewlyIdea.url" />
					</td>
					<td align="left">
						<s:property value="%{url}" />
					</td>
				</tr>	

</table>



</body>
</html>
