<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
<head>
<title><s:text name="vporegisterbasic1.view.title" /></title>
</head>

<body>
<p class="ctitle"><s:text name="vporegisterbasic1.view.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<a href='punish/vporegisterbasic1!list.do?ec_p=${param.ec_p}&ec_crd=${param.ec_crd}' property="none">
	<s:text name="opt.btn.back" />
</a>
<p>	
	
<table width="200" border="0" cellpadding="1" cellspacing="1">		
  
				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.punishobjectid" />
					</td>
					<td align="left">
						<s:property value="%{punishobjectid}" />
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.poregisterindagate" />
					</td>
					<td align="left">
						<s:property value="%{poregisterindagate}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.poregisterbasis" />
					</td>
					<td align="left">
						<s:property value="%{poregisterbasis}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.jbrLa" />
					</td>
					<td align="left">
						<s:property value="%{jbrLa}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.ksLa" />
					</td>
					<td align="left">
						<s:property value="%{ksLa}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.fzrLa" />
					</td>
					<td align="left">
						<s:property value="%{fzrLa}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.jbroptionLa" />
					</td>
					<td align="left">
						<s:property value="%{jbroptionLa}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.ksoptionLa" />
					</td>
					<td align="left">
						<s:property value="%{ksoptionLa}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.fzroptionLa" />
					</td>
					<td align="left">
						<s:property value="%{fzroptionLa}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.jbroptionLatime" />
					</td>
					<td align="left">
						<s:property value="%{jbroptionLatime}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.ksoptionLatime" />
					</td>
					<td align="left">
						<s:property value="%{ksoptionLatime}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.fzroptionLatime" />
					</td>
					<td align="left">
						<s:property value="%{fzroptionLatime}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.punishobjectbrief" />
					</td>
					<td align="left">
						<s:property value="%{punishobjectbrief}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.pooccurstate" />
					</td>
					<td align="left">
						<s:property value="%{pooccurstate}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.poorigindate" />
					</td>
					<td align="left">
						<s:property value="%{poorigindate}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.enterprisename" />
					</td>
					<td align="left">
						<s:property value="%{enterprisename}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.enterpriseaddress" />
					</td>
					<td align="left">
						<s:property value="%{enterpriseaddress}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.mastername" />
					</td>
					<td align="left">
						<s:property value="%{mastername}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.enphone" />
					</td>
					<td align="left">
						<s:property value="%{enphone}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.individualname" />
					</td>
					<td align="left">
						<s:property value="%{individualname}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.individualcode" />
					</td>
					<td align="left">
						<s:property value="%{individualcode}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.sex" />
					</td>
					<td align="left">
						<s:property value="%{sex}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.age" />
					</td>
					<td align="left">
						<s:property value="%{age}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.individualadress" />
					</td>
					<td align="left">
						<s:property value="%{individualadress}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.inphone" />
					</td>
					<td align="left">
						<s:property value="%{inphone}" />
					</td>
				</tr>	

				<tr>
					<td class="TDTITLE">
						<s:text name="vporegisterbasic1.pooriginstate" />
					</td>
					<td align="left">
						<s:property value="%{pooriginstate}" />
					</td>
				</tr>	

</table>



</body>
</html>
