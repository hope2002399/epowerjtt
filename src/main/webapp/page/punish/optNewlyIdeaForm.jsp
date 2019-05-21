<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
<head>
<title><s:text name="optNewlyIdea.edit.title" /></title>
</head>

<body>
<p class="ctitle"><s:text name="optNewlyIdea.edit.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<s:form action="optNewlyIdea"  method="post" namespace="/punish" id="optNewlyIdeaForm" >
	<s:submit name="save"  method="save" cssClass="btn" key="opt.btn.save" />
	<s:submit type="button" name="back" cssClass="btn" key="opt.btn.back"/>
		
<table width="200" border="0" cellpadding="1" cellspacing="1">		
 
				<tr>
					<td class="TDTITLE">
						<s:text name="optNewlyIdea.punishobjectid" />
					</td>
					<td align="left">
	
  
							<s:textfield name="punishobjectid" size="40" />
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="optNewlyIdea.nodeid" />
					</td>
					<td align="left">
	
  
							<s:textfield name="nodeid" size="40" />
	
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<s:text name="optNewlyIdea.nodeinstid" />
					</td>
					<td align="left">
	
  
						<s:textfield name="nodeinstid"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="optNewlyIdea.nodename" />
					</td>
					<td align="left">
	
  
						<s:textfield name="nodename"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="optNewlyIdea.isdisplay" />
					</td>
					<td align="left">
	
  
						<s:textfield name="isdisplay"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="optNewlyIdea.orderno" />
					</td>
					<td align="left">
	
  
						<s:textfield name="orderno"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="optNewlyIdea.url" />
					</td>
					<td align="left">
  
						<s:textarea name="url" cols="40" rows="2"/>
	
	
					</td>
				</tr>

</table>


</s:form>
