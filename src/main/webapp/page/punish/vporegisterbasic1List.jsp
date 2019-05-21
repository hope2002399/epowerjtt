<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
	<head>
		<title>
			<s:text name="vporegisterbasic1.list.title" />
		</title>
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset
			style="border: hidden 1px #000000; ">
			<legend>
				 <s:text name="label.list.filter" />
			</legend>
			
			<s:form action="vporegisterbasic1" namespace="/punish" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr >
						<td><s:text name="vporegisterbasic1.punishobjectid" />:</td>
						<td><s:textfield name="s_punishobjectid" /> </td>
					</tr>	


					<tr >
						<td><s:text name="vporegisterbasic1.poregisterindagate" />:</td>
						<td><s:textfield name="s_poregisterindagate" /> </td>
					</tr>	

					<tr >
						<td><s:text name="vporegisterbasic1.poregisterbasis" />:</td>
						<td><s:textfield name="s_poregisterbasis" /> </td>
					</tr>	

					<tr >
						<td><s:text name="vporegisterbasic1.jbrLa" />:</td>
						<td><s:textfield name="s_jbrLa" /> </td>
					</tr>	

					<tr >
						<td><s:text name="vporegisterbasic1.ksLa" />:</td>
						<td><s:textfield name="s_ksLa" /> </td>
					</tr>	

					<tr >
						<td><s:text name="vporegisterbasic1.fzrLa" />:</td>
						<td><s:textfield name="s_fzrLa" /> </td>
					</tr>	

					<tr >
						<td><s:text name="vporegisterbasic1.jbroptionLa" />:</td>
						<td><s:textfield name="s_jbroptionLa" /> </td>
					</tr>	

					<tr >
						<td><s:text name="vporegisterbasic1.ksoptionLa" />:</td>
						<td><s:textfield name="s_ksoptionLa" /> </td>
					</tr>	

					<tr >
						<td><s:text name="vporegisterbasic1.fzroptionLa" />:</td>
						<td><s:textfield name="s_fzroptionLa" /> </td>
					</tr>	

					<tr >
						<td><s:text name="vporegisterbasic1.jbroptionLatime" />:</td>
						<td><s:textfield name="s_jbroptionLatime" /> </td>
					</tr>	

					<tr >
						<td><s:text name="vporegisterbasic1.ksoptionLatime" />:</td>
						<td><s:textfield name="s_ksoptionLatime" /> </td>
					</tr>	

					<tr >
						<td><s:text name="vporegisterbasic1.fzroptionLatime" />:</td>
						<td><s:textfield name="s_fzroptionLatime" /> </td>
					</tr>	

					<tr >
						<td><s:text name="vporegisterbasic1.punishobjectbrief" />:</td>
						<td><s:textfield name="s_punishobjectbrief" /> </td>
					</tr>	

					<tr >
						<td><s:text name="vporegisterbasic1.pooccurstate" />:</td>
						<td><s:textfield name="s_pooccurstate" /> </td>
					</tr>	

					<tr >
						<td><s:text name="vporegisterbasic1.poorigindate" />:</td>
						<td><s:textfield name="s_poorigindate" /> </td>
					</tr>	

					<tr >
						<td><s:text name="vporegisterbasic1.enterprisename" />:</td>
						<td><s:textfield name="s_enterprisename" /> </td>
					</tr>	

					<tr >
						<td><s:text name="vporegisterbasic1.enterpriseaddress" />:</td>
						<td><s:textfield name="s_enterpriseaddress" /> </td>
					</tr>	

					<tr >
						<td><s:text name="vporegisterbasic1.mastername" />:</td>
						<td><s:textfield name="s_mastername" /> </td>
					</tr>	

					<tr >
						<td><s:text name="vporegisterbasic1.enphone" />:</td>
						<td><s:textfield name="s_enphone" /> </td>
					</tr>	

					<tr >
						<td><s:text name="vporegisterbasic1.individualname" />:</td>
						<td><s:textfield name="s_individualname" /> </td>
					</tr>	

					<tr >
						<td><s:text name="vporegisterbasic1.individualcode" />:</td>
						<td><s:textfield name="s_individualcode" /> </td>
					</tr>	

					<tr >
						<td><s:text name="vporegisterbasic1.sex" />:</td>
						<td><s:textfield name="s_sex" /> </td>
					</tr>	

					<tr >
						<td><s:text name="vporegisterbasic1.age" />:</td>
						<td><s:textfield name="s_age" /> </td>
					</tr>	

					<tr >
						<td><s:text name="vporegisterbasic1.individualadress" />:</td>
						<td><s:textfield name="s_individualadress" /> </td>
					</tr>	

					<tr >
						<td><s:text name="vporegisterbasic1.inphone" />:</td>
						<td><s:textfield name="s_inphone" /> </td>
					</tr>	

					<tr >
						<td><s:text name="vporegisterbasic1.pooriginstate" />:</td>
						<td><s:textfield name="s_pooriginstate" /> </td>
					</tr>	

					<tr>
						<td>
							<s:submit method="list"  key="opt.btn.query" cssClass="btn"/>
						</td>
						<td>
							<s:submit method="built"  key="opt.btn.new" cssClass="btn"/>
						</td>
					</tr>
				</table>
			</s:form>
		</fieldset>

		<ec:table action="punish/vporegisterbasic1!list.do" items="objList" var="vporegisterbasic1"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="vporegisterbasic1s.xls" ></ec:exportXls>
			<ec:exportPdf fileName="vporegisterbasic1s.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>

				<c:set var="tpunishobjectid"><s:text name='vporegisterbasic1.punishobjectid' /></c:set>	
				<ec:column property="punishobjectid" title="${tpunishobjectid}" style="text-align:center" />


				<c:set var="tporegisterindagate"><s:text name='vporegisterbasic1.poregisterindagate' /></c:set>	
				<ec:column property="poregisterindagate" title="${tporegisterindagate}" style="text-align:center" />

				<c:set var="tporegisterbasis"><s:text name='vporegisterbasic1.poregisterbasis' /></c:set>	
				<ec:column property="poregisterbasis" title="${tporegisterbasis}" style="text-align:center" />

				<c:set var="tjbrLa"><s:text name='vporegisterbasic1.jbrLa' /></c:set>	
				<ec:column property="jbrLa" title="${tjbrLa}" style="text-align:center" />

				<c:set var="tksLa"><s:text name='vporegisterbasic1.ksLa' /></c:set>	
				<ec:column property="ksLa" title="${tksLa}" style="text-align:center" />

				<c:set var="tfzrLa"><s:text name='vporegisterbasic1.fzrLa' /></c:set>	
				<ec:column property="fzrLa" title="${tfzrLa}" style="text-align:center" />

				<c:set var="tjbroptionLa"><s:text name='vporegisterbasic1.jbroptionLa' /></c:set>	
				<ec:column property="jbroptionLa" title="${tjbroptionLa}" style="text-align:center" />

				<c:set var="tksoptionLa"><s:text name='vporegisterbasic1.ksoptionLa' /></c:set>	
				<ec:column property="ksoptionLa" title="${tksoptionLa}" style="text-align:center" />

				<c:set var="tfzroptionLa"><s:text name='vporegisterbasic1.fzroptionLa' /></c:set>	
				<ec:column property="fzroptionLa" title="${tfzroptionLa}" style="text-align:center" />

				<c:set var="tjbroptionLatime"><s:text name='vporegisterbasic1.jbroptionLatime' /></c:set>	
				<ec:column property="jbroptionLatime" title="${tjbroptionLatime}" style="text-align:center" />

				<c:set var="tksoptionLatime"><s:text name='vporegisterbasic1.ksoptionLatime' /></c:set>	
				<ec:column property="ksoptionLatime" title="${tksoptionLatime}" style="text-align:center" />

				<c:set var="tfzroptionLatime"><s:text name='vporegisterbasic1.fzroptionLatime' /></c:set>	
				<ec:column property="fzroptionLatime" title="${tfzroptionLatime}" style="text-align:center" />

				<c:set var="tpunishobjectbrief"><s:text name='vporegisterbasic1.punishobjectbrief' /></c:set>	
				<ec:column property="punishobjectbrief" title="${tpunishobjectbrief}" style="text-align:center" />

				<c:set var="tpooccurstate"><s:text name='vporegisterbasic1.pooccurstate' /></c:set>	
				<ec:column property="pooccurstate" title="${tpooccurstate}" style="text-align:center" />

				<c:set var="tpoorigindate"><s:text name='vporegisterbasic1.poorigindate' /></c:set>	
				<ec:column property="poorigindate" title="${tpoorigindate}" style="text-align:center" />

				<c:set var="tenterprisename"><s:text name='vporegisterbasic1.enterprisename' /></c:set>	
				<ec:column property="enterprisename" title="${tenterprisename}" style="text-align:center" />

				<c:set var="tenterpriseaddress"><s:text name='vporegisterbasic1.enterpriseaddress' /></c:set>	
				<ec:column property="enterpriseaddress" title="${tenterpriseaddress}" style="text-align:center" />

				<c:set var="tmastername"><s:text name='vporegisterbasic1.mastername' /></c:set>	
				<ec:column property="mastername" title="${tmastername}" style="text-align:center" />

				<c:set var="tenphone"><s:text name='vporegisterbasic1.enphone' /></c:set>	
				<ec:column property="enphone" title="${tenphone}" style="text-align:center" />

				<c:set var="tindividualname"><s:text name='vporegisterbasic1.individualname' /></c:set>	
				<ec:column property="individualname" title="${tindividualname}" style="text-align:center" />

				<c:set var="tindividualcode"><s:text name='vporegisterbasic1.individualcode' /></c:set>	
				<ec:column property="individualcode" title="${tindividualcode}" style="text-align:center" />

				<c:set var="tsex"><s:text name='vporegisterbasic1.sex' /></c:set>	
				<ec:column property="sex" title="${tsex}" style="text-align:center" />

				<c:set var="tage"><s:text name='vporegisterbasic1.age' /></c:set>	
				<ec:column property="age" title="${tage}" style="text-align:center" />

				<c:set var="tindividualadress"><s:text name='vporegisterbasic1.individualadress' /></c:set>	
				<ec:column property="individualadress" title="${tindividualadress}" style="text-align:center" />

				<c:set var="tinphone"><s:text name='vporegisterbasic1.inphone' /></c:set>	
				<ec:column property="inphone" title="${tinphone}" style="text-align:center" />

				<c:set var="tpooriginstate"><s:text name='vporegisterbasic1.pooriginstate' /></c:set>	
				<ec:column property="pooriginstate" title="${tpooriginstate}" style="text-align:center" />
		
				<c:set var="optlabel"><s:text name="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><s:text name="label.delete.confirm"/></c:set>
					<a href='punish/vporegisterbasic1!view.do?punishobjectid=${vporegisterbasic1.punishobjectid}&ec_p=${ec_p}&ec_crd=${ec_crd}'><s:text name="opt.btn.view" /></a>
					<a href='punish/vporegisterbasic1!edit.do?punishobjectid=${vporegisterbasic1.punishobjectid}'><s:text name="opt.btn.edit" /></a>
					<a href='punish/vporegisterbasic1!delete.do?punishobjectid=${vporegisterbasic1.punishobjectid}' 
							onclick='return confirm("${deletecofirm}vporegisterbasic1?");'><s:text name="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
