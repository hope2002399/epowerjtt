<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<html>
	<head>
		<title><c:out value="powitnessbasic.list.title" /></title>
		<link href="<c:out value='${STYLE_PATH}'/>/css/am.css" type="text/css"
			rel="stylesheet">
		<link href="<c:out value='${STYLE_PATH}'/>/css/extremecomponents.css"
			type="text/css" rel="stylesheet">
		<link href="<c:out value='${STYLE_PATH}'/>/css/messages.css"
			type="text/css" rel="stylesheet">
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset
			style="border: hidden 1px #000000; ">
			<legend>
				 <s:text name="label.list.filter" />
			</legend>
			<html:form action="/punish/powitnessbasic.do" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr height="22">
						<td><c:out value="powitnessbasic.punishobjectid" />:</td>
						<td><html:text property="s_punishobjectid" /> </td>
					</tr>	


					<tr height="22">
						<td><c:out value="powitnessbasic.powitnessdate" />:</td>
						<td><html:text property="s_powitnessdate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="powitnessbasic.powitnesstype" />:</td>
						<td><html:text property="s_powitnesstype" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="powitnessbasic.powitnessadress" />:</td>
						<td><html:text property="s_powitnessadress" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="powitnessbasic.powitnessemceename" />:</td>
						<td><html:text property="s_powitnessemceename" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="powitnessbasic.powitnessnotername" />:</td>
						<td><html:text property="s_powitnessnotername" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="powitnessbasic.investigatename" />:</td>
						<td><html:text property="s_investigatename" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="powitnessbasic.investigatedepname" />:</td>
						<td><html:text property="s_investigatedepname" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="powitnessbasic.deputyname" />:</td>
						<td><html:text property="s_deputyname" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="powitnessbasic.deputybusiness" />:</td>
						<td><html:text property="s_deputybusiness" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="powitnessbasic.deputydepname" />:</td>
						<td><html:text property="s_deputydepname" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="powitnessbasic.delegatename" />:</td>
						<td><html:text property="s_delegatename" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="powitnessbasic.powitnessmind" />:</td>
						<td><html:text property="s_powitnessmind" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="powitnessbasic.powitnessreason" />:</td>
						<td><html:text property="s_powitnessreason" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="powitnessbasic.witnessdate" />:</td>
						<td><html:text property="s_witnessdate" /> </td>
					</tr>	

					<tr>
						<td>
							<html:submit property="method_list" styleClass="btn" > <bean:message key="opt.btn.query" /></html:submit>
						</td>
						<td>
							<html:submit property="method_edit" styleClass="btn" > <bean:message key="opt.btn.new" /> </html:submit>
						</td>
					</tr>
				</table>
			</html:form>
		</fieldset>

			<ec:table action="powitnessbasic.do" items="powitnessbasics" var="powitnessbasic"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="powitnessbasics.xls" ></ec:exportXls>
			<ec:exportPdf fileName="powitnessbasics.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>

				<c:set var="tpunishobjectid"><bean:message bundle='punishRes' key='powitnessbasic.punishobjectid' /></c:set>	
				<ec:column property="punishobjectid" title="${tpunishobjectid}" style="text-align:center" />


				<c:set var="tpowitnessdate"><bean:message bundle='punishRes' key='powitnessbasic.powitnessdate' /></c:set>	
				<ec:column property="powitnessdate" title="${tpowitnessdate}" style="text-align:center" />

				<c:set var="tpowitnesstype"><bean:message bundle='punishRes' key='powitnessbasic.powitnesstype' /></c:set>	
				<ec:column property="powitnesstype" title="${tpowitnesstype}" style="text-align:center" />

				<c:set var="tpowitnessadress"><bean:message bundle='punishRes' key='powitnessbasic.powitnessadress' /></c:set>	
				<ec:column property="powitnessadress" title="${tpowitnessadress}" style="text-align:center" />

				<c:set var="tpowitnessemceename"><bean:message bundle='punishRes' key='powitnessbasic.powitnessemceename' /></c:set>	
				<ec:column property="powitnessemceename" title="${tpowitnessemceename}" style="text-align:center" />

				<c:set var="tpowitnessnotername"><bean:message bundle='punishRes' key='powitnessbasic.powitnessnotername' /></c:set>	
				<ec:column property="powitnessnotername" title="${tpowitnessnotername}" style="text-align:center" />

				<c:set var="tinvestigatename"><bean:message bundle='punishRes' key='powitnessbasic.investigatename' /></c:set>	
				<ec:column property="investigatename" title="${tinvestigatename}" style="text-align:center" />

				<c:set var="tinvestigatedepname"><bean:message bundle='punishRes' key='powitnessbasic.investigatedepname' /></c:set>	
				<ec:column property="investigatedepname" title="${tinvestigatedepname}" style="text-align:center" />

				<c:set var="tdeputyname"><bean:message bundle='punishRes' key='powitnessbasic.deputyname' /></c:set>	
				<ec:column property="deputyname" title="${tdeputyname}" style="text-align:center" />

				<c:set var="tdeputybusiness"><bean:message bundle='punishRes' key='powitnessbasic.deputybusiness' /></c:set>	
				<ec:column property="deputybusiness" title="${tdeputybusiness}" style="text-align:center" />

				<c:set var="tdeputydepname"><bean:message bundle='punishRes' key='powitnessbasic.deputydepname' /></c:set>	
				<ec:column property="deputydepname" title="${tdeputydepname}" style="text-align:center" />

				<c:set var="tdelegatename"><bean:message bundle='punishRes' key='powitnessbasic.delegatename' /></c:set>	
				<ec:column property="delegatename" title="${tdelegatename}" style="text-align:center" />

				<c:set var="tpowitnessmind"><bean:message bundle='punishRes' key='powitnessbasic.powitnessmind' /></c:set>	
				<ec:column property="powitnessmind" title="${tpowitnessmind}" style="text-align:center" />

				<c:set var="tpowitnessreason"><bean:message bundle='punishRes' key='powitnessbasic.powitnessreason' /></c:set>	
				<ec:column property="powitnessreason" title="${tpowitnessreason}" style="text-align:center" />

				<c:set var="twitnessdate"><bean:message bundle='punishRes' key='powitnessbasic.witnessdate' /></c:set>	
				<ec:column property="witnessdate" title="${twitnessdate}" style="text-align:center" />
		
				<c:set var="optlabel"><bean:message key="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><bean:message key="label.delete.confirm"/></c:set>
					<a href='powitnessbasic.do?punishobjectid=${powitnessbasic.punishobjectid}&method=view'><bean:message key="opt.btn.view" /></a>
					<a href='powitnessbasic.do?punishobjectid=${powitnessbasic.punishobjectid}&method=edit'><bean:message key="opt.btn.edit" /></a>
					<a href='powitnessbasic.do?punishobjectid=${powitnessbasic.punishobjectid}&method=delete' 
							onclick='return confirm("${deletecofirm}powitnessbasic?");'><bean:message key="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
