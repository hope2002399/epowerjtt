<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
<head>
<title><s:text name="superviselog.edit.title" /></title>
</head>

<body>
<p class="ctitle"><s:text name="superviselog.edit.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<s:form action="superviselog"  method="post" namespace="/monitor" id="superviselogForm" >
	<s:submit name="save"  method="save" cssClass="btn" key="opt.btn.save" />
	<s:submit type="button" name="back" cssClass="btn" key="opt.btn.back"/>
		
<table width="200" border="0" cellpadding="1" cellspacing="1">		
 
				<tr>
					<td class="TDTITLE">
						<s:text name="superviselog.logid" />
					</td>
					<td align="left">
	
  
							<s:textfield name="logid" size="40" />
	
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<s:text name="superviselog.loglevel" />
					</td>
					<td align="left">
	
  
						<s:textfield name="loglevel"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="superviselog.usercode" />
					</td>
					<td align="left">
	
  
						<s:textfield name="usercode"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="superviselog.opttime" />
					</td>
					<td align="left">
	
  
						<s:textfield name="opttime"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="superviselog.optid" />
					</td>
					<td align="left">
	
  
						<s:textfield name="optid"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="superviselog.optmethod" />
					</td>
					<td align="left">
	
  
						<s:textfield name="optmethod"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="superviselog.optcontent" />
					</td>
					<td align="left">
  
						<s:textarea name="optcontent" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="superviselog.oldvalue" />
					</td>
					<td align="left">
  
						<s:textarea name="oldvalue" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="superviselog.tagid" />
					</td>
					<td align="left">
	
  
						<s:textfield name="tagid"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="superviselog.bjType" />
					</td>
					<td align="left">
	
  
						<s:textfield name="bjType"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="superviselog.bjNo" />
					</td>
					<td align="left">
	
  
						<s:textfield name="bjNo"  size="40"/>
	
					</td>
				</tr>

</table>


</s:form>
