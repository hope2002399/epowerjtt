<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
<head>
<title><s:text name="podecisioninfo.edit.title" /></title>
</head>

<body>
<p class="ctitle"><s:text name="podecisioninfo.edit.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<s:form action="podecisioninfo"  method="post" namespace="/punish" id="podecisioninfoForm" >
	<s:submit name="save"  method="save" cssClass="btn" key="opt.btn.save" />
	<s:submit type="button" name="back" cssClass="btn" key="opt.btn.back"/>
		
<table width="200" border="0" cellpadding="1" cellspacing="1">		
 
				<tr>
					<td class="TDTITLE">
						<s:text name="podecisioninfo.punishobjectid" />
					</td>
					<td align="left">
	
  
							<s:textfield name="punishobjectid" size="40" />
	
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<s:text name="podecisioninfo.jbrCfjd" />
					</td>
					<td align="left">
	
  
						<s:textfield name="jbrCfjd"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="podecisioninfo.ksrCfjd" />
					</td>
					<td align="left">
	
  
						<s:textfield name="ksrCfjd"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="podecisioninfo.fzrCfjd" />
					</td>
					<td align="left">
	
  
						<s:textfield name="fzrCfjd"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="podecisioninfo.jbroptionCfjd" />
					</td>
					<td align="left">
  
						<s:textarea name="jbroptionCfjd" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="podecisioninfo.ksoptionCfjd" />
					</td>
					<td align="left">
  
						<s:textarea name="ksoptionCfjd" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="podecisioninfo.fzroptionCfjd" />
					</td>
					<td align="left">
  
						<s:textarea name="fzroptionCfjd" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="podecisioninfo.jbroptionCfjdtime" />
					</td>
					<td align="left">
	
  
						<s:textfield name="jbroptionCfjdtime"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="podecisioninfo.ksoptionCfjdtime" />
					</td>
					<td align="left">
	
  
						<s:textfield name="ksoptionCfjdtime"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="podecisioninfo.fzroptionCfjdtime" />
					</td>
					<td align="left">
	
  
						<s:textfield name="fzroptionCfjdtime"  size="40"/>
	
					</td>
				</tr>

</table>


</s:form>
