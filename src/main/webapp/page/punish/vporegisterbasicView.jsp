<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
<head>
<title><s:text name="vporegisterbasic.view.title" /></title>
</head>

<body>
<p class="ctitle"><s:text name="vporegisterbasic.view.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<a href='punish/vporegisterbasic!list.do?ec_p=${param.ec_p}&ec_crd=${param.ec_crd}' property="none">
	<s:text name="opt.btn.back" />
</a>
<p>	
	
<table width="200" border="0" cellpadding="1" cellspacing="1">		
  
				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic.punishobjectid" />
					</td>
					<td align="left">
						<s:property value="%{punishobjectid}" />
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic.poregisterindagate" />
					</td>
					<td align="left">
						<s:property value="%{poregisterindagate}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic.poregisterbasis" />
					</td>
					<td align="left">
						<s:property value="%{poregisterbasis}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic.jbrLa" />
					</td>
					<td align="left">
						<s:property value="%{jbrLa}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic.ksLa" />
					</td>
					<td align="left">
						<s:property value="%{ksLa}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic.fzrLa" />
					</td>
					<td align="left">
						<s:property value="%{fzrLa}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic.jbroptionLa" />
					</td>
					<td align="left">
						<s:property value="%{jbroptionLa}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic.ksoptionLa" />
					</td>
					<td align="left">
						<s:property value="%{ksoptionLa}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic.fzroptionLa" />
					</td>
					<td align="left">
						<s:property value="%{fzroptionLa}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic.jbroptionLatime" />
					</td>
					<td align="left">
						<s:property value="%{jbroptionLatime}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic.ksoptionLatime" />
					</td>
					<td align="left">
						<s:property value="%{ksoptionLatime}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic.fzroptionLatime" />
					</td>
					<td align="left">
						<s:property value="%{fzroptionLatime}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic.punishobjectbrief" />
					</td>
					<td align="left">
						<s:property value="%{punishobjectbrief}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic.pooccurstate" />
					</td>
					<td align="left">
						<s:property value="%{pooccurstate}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic.poorigindate" />
					</td>
					<td align="left">
						<s:property value="%{poorigindate}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic.enterprisename" />
					</td>
					<td align="left">
						<s:property value="%{enterprisename}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic.enterpriseaddress" />
					</td>
					<td align="left">
						<s:property value="%{enterpriseaddress}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic.mastername" />
					</td>
					<td align="left">
						<s:property value="%{mastername}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic.enphone" />
					</td>
					<td align="left">
						<s:property value="%{enphone}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic.individualname" />
					</td>
					<td align="left">
						<s:property value="%{individualname}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic.individualcode" />
					</td>
					<td align="left">
						<s:property value="%{individualcode}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic.sex" />
					</td>
					<td align="left">
						<s:property value="%{sex}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic.age" />
					</td>
					<td align="left">
						<s:property value="%{age}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic.individualadress" />
					</td>
					<td align="left">
						<s:property value="%{individualadress}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic.inphone" />
					</td>
					<td align="left">
						<s:property value="%{inphone}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic.pooriginstate" />
					</td>
					<td align="left">
						<s:property value="%{pooriginstate}" />
					</td>
				</tr>	

</table>



</body>
</html>
