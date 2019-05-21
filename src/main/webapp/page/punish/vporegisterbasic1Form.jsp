<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
<head>
<title><s:text name="vporegisterbasic1.edit.title" /></title>
</head>

<body>
<p class="ctitle"><s:text name="vporegisterbasic1.edit.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<s:form action="vporegisterbasic1"  method="post" namespace="/punish" id="vporegisterbasic1Form" >
	<s:submit name="save"  method="save" cssClass="btn" key="opt.btn.save" />
	<s:submit type="button" name="back" cssClass="btn" key="opt.btn.back"/>
		
<table width="200" border="0" cellpadding="1" cellspacing="1">		
 
				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.punishobjectid" />
					</td>
					<td align="left">
	
  
							<s:textfield name="punishobjectid" size="40" />
	
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.poregisterindagate" />
					</td>
					<td align="left">
	
  
						<s:textfield name="poregisterindagate"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.poregisterbasis" />
					</td>
					<td align="left">
	
  
						<s:textfield name="poregisterbasis"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.jbrLa" />
					</td>
					<td align="left">
	
  
						<s:textfield name="jbrLa"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.ksLa" />
					</td>
					<td align="left">
	
  
						<s:textfield name="ksLa"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.fzrLa" />
					</td>
					<td align="left">
	
  
						<s:textfield name="fzrLa"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.jbroptionLa" />
					</td>
					<td align="left">
  
						<s:textarea name="jbroptionLa" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.ksoptionLa" />
					</td>
					<td align="left">
  
						<s:textarea name="ksoptionLa" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.fzroptionLa" />
					</td>
					<td align="left">
  
						<s:textarea name="fzroptionLa" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.jbroptionLatime" />
					</td>
					<td align="left">
  
						<s:textarea name="jbroptionLatime" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.ksoptionLatime" />
					</td>
					<td align="left">
  
						<s:textarea name="ksoptionLatime" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.fzroptionLatime" />
					</td>
					<td align="left">
  
						<s:textarea name="fzroptionLatime" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.punishobjectbrief" />
					</td>
					<td align="left">
  
						<s:textarea name="punishobjectbrief" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.pooccurstate" />
					</td>
					<td align="left">
	
  
						<s:textfield name="pooccurstate"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.poorigindate" />
					</td>
					<td align="left">
	
  
						<s:textfield name="poorigindate"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.enterprisename" />
					</td>
					<td align="left">
	
  
						<s:textfield name="enterprisename"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.enterpriseaddress" />
					</td>
					<td align="left">
  
						<s:textarea name="enterpriseaddress" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.mastername" />
					</td>
					<td align="left">
	
  
						<s:textfield name="mastername"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.enphone" />
					</td>
					<td align="left">
	
  
						<s:textfield name="enphone"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.individualname" />
					</td>
					<td align="left">
	
  
						<s:textfield name="individualname"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.individualcode" />
					</td>
					<td align="left">
	
  
						<s:textfield name="individualcode"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.sex" />
					</td>
					<td align="left">
	
  
						<s:textfield name="sex"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.age" />
					</td>
					<td align="left">
	
  
						<s:textfield name="age"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.individualadress" />
					</td>
					<td align="left">
  
						<s:textarea name="individualadress" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.inphone" />
					</td>
					<td align="left">
	
  
						<s:textfield name="inphone"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.pooriginstate" />
					</td>
					<td align="left">
  
						<s:textarea name="pooriginstate" cols="40" rows="2"/>
	
	
					</td>
				</tr>

</table>


</s:form>
