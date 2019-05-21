<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
<head>
<title><s:text name="poacceptinfo.edit.title" /></title>
</head>

<body>
<p class="ctitle"><s:text name="poacceptinfo.edit.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<s:form action="poacceptinfo"  method="post" namespace="/punish" id="poacceptinfoForm" >
	<s:submit name="save"  method="save" cssClass="btn" key="opt.btn.save" />
	<s:submit type="button" name="back" cssClass="btn" key="opt.btn.back"/>
		
<table width="200" border="0" cellpadding="1" cellspacing="1">		
 
				<tr>
					<td class="TDTITLE">
						<s:text name="poacceptinfo.punishobjectid" />
					</td>
					<td align="left">
	
  
							<s:textfield name="punishobjectid" size="40" />
	
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<s:text name="poacceptinfo.jbrSl" />
					</td>
					<td align="left">
	
  
						<s:textfield name="jbrSl"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="poacceptinfo.ksrSl" />
					</td>
					<td align="left">
	
  
						<s:textfield name="ksrSl"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="poacceptinfo.fzrSl" />
					</td>
					<td align="left">
	
  
						<s:textfield name="fzrSl"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="poacceptinfo.jbroptionSl" />
					</td>
					<td align="left">
  
						<s:textarea name="jbroptionSl" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="poacceptinfo.ksoptionSl" />
					</td>
					<td align="left">
  
						<s:textarea name="ksoptionSl" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="poacceptinfo.fzroptionSl" />
					</td>
					<td align="left">
  
						<s:textarea name="fzroptionSl" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="poacceptinfo.jbroptionSltime" />
					</td>
					<td align="left">
	
  
						<s:textfield name="jbroptionSltime"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="poacceptinfo.ksoptionSltime" />
					</td>
					<td align="left">
	
  
						<s:textfield name="ksoptionSltime"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="poacceptinfo.fzroptionSltime" />
					</td>
					<td align="left">
	
  
						<s:textfield name="fzroptionSltime"  size="40"/>
	
					</td>
				</tr>

</table>


</s:form>
