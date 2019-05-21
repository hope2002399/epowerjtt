<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
<head>
<title><s:text name="VPunishViewList.edit.title" /></title>
</head>

<body>
<p class="ctitle"><s:text name="VPunishViewList.edit.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<s:form action="VPunishViewList"  method="post" namespace="/punish" id="VPunishViewListForm" >
	<s:submit name="save"  method="save" cssClass="btn" key="opt.btn.save" />
	<s:submit type="button" name="back" cssClass="btn" key="opt.btn.back"/>
		
<table width="200" border="0" cellpadding="1" cellspacing="1">		
 
				<tr>
					<td class="TDTITLE">
						<s:text name="VPunishViewList.punishobjectid" />
					</td>
					<td align="left">
	
  
							<s:textfield name="punishobjectid" size="40" />
	
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<s:text name="VPunishViewList.wfoptname" />
					</td>
					<td align="left">
  
						<s:textarea name="wfoptname" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VPunishViewList.unitCode" />
					</td>
					<td align="left">
	
  
						<s:textfield name="unitCode"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VPunishViewList.nodeName" />
					</td>
					<td align="left">
  
						<s:textarea name="nodeName" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VPunishViewList.createtime" />
					</td>
					<td align="left">
	
  
						<s:textfield name="createtime"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VPunishViewList.punishobjectno" />
					</td>
					<td align="left">
	
  
						<s:textfield name="punishobjectno"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VPunishViewList.punishobjecttype" />
					</td>
					<td align="left">
	
  
						<s:textfield name="punishobjecttype"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VPunishViewList.managedepid" />
					</td>
					<td align="left">
	
  
						<s:textfield name="managedepid"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VPunishViewList.poregisterdate" />
					</td>
					<td align="left">
	
  
						<s:textfield name="poregisterdate"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VPunishViewList.pooccurstate" />
					</td>
					<td align="left">
	
  
						<s:textfield name="pooccurstate"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VPunishViewList.punishobjectstate" />
					</td>
					<td align="left">
	
  
						<s:textfield name="punishobjectstate"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VPunishViewList.pooccurdate" />
					</td>
					<td align="left">
	
  
						<s:textfield name="pooccurdate"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VPunishViewList.poregistedate" />
					</td>
					<td align="left">
	
  
						<s:textfield name="poregistedate"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VPunishViewList.pooriginstate" />
					</td>
					<td align="left">
	
  
						<s:textfield name="pooriginstate"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VPunishViewList.flowInstId" />
					</td>
					<td align="left">
	
  
						<s:textfield name="flowInstId"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="VPunishViewList.optId" />
					</td>
					<td align="left">
	
  
						<s:textfield name="optId"  size="40"/>
	
					</td>
				</tr>

</table>


</s:form>
