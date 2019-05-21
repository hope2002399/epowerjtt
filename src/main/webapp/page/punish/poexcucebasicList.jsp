<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<html>
	<head>
		<title><c:out value="poexcucebasic.list.title" /></title>
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
			<html:form action="/punish/poexcucebasic.do" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr height="22">
						<td><c:out value="poexcucebasic.punishobjectid" />:</td>
						<td><html:text property="s_punishobjectid" /> </td>
					</tr>	


					<tr height="22">
						<td><c:out value="poexcucebasic.poexcucedate" />:</td>
						<td><html:text property="s_poexcucedate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poexcucebasic.poexcuceadress" />:</td>
						<td><html:text property="s_poexcuceadress" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poexcucebasic.undertakername" />:</td>
						<td><html:text property="s_undertakername" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poexcucebasic.undertakecertno" />:</td>
						<td><html:text property="s_undertakecertno" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poexcucebasic.registercertno" />:</td>
						<td><html:text property="s_registercertno" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poexcucebasic.registerid" />:</td>
						<td><html:text property="s_registerid" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poexcucebasic.deputyname" />:</td>
						<td><html:text property="s_deputyname" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poexcucebasic.excucedate" />:</td>
						<td><html:text property="s_excucedate" /> </td>
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

			<ec:table action="poexcucebasic.do" items="poexcucebasics" var="poexcucebasic"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="poexcucebasics.xls" ></ec:exportXls>
			<ec:exportPdf fileName="poexcucebasics.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>

				<c:set var="tpunishobjectid"><bean:message bundle='punishRes' key='poexcucebasic.punishobjectid' /></c:set>	
				<ec:column property="punishobjectid" title="${tpunishobjectid}" style="text-align:center" />


				<c:set var="tpoexcucedate"><bean:message bundle='punishRes' key='poexcucebasic.poexcucedate' /></c:set>	
				<ec:column property="poexcucedate" title="${tpoexcucedate}" style="text-align:center" />

				<c:set var="tpoexcuceadress"><bean:message bundle='punishRes' key='poexcucebasic.poexcuceadress' /></c:set>	
				<ec:column property="poexcuceadress" title="${tpoexcuceadress}" style="text-align:center" />

				<c:set var="tundertakername"><bean:message bundle='punishRes' key='poexcucebasic.undertakername' /></c:set>	
				<ec:column property="undertakername" title="${tundertakername}" style="text-align:center" />

				<c:set var="tundertakecertno"><bean:message bundle='punishRes' key='poexcucebasic.undertakecertno' /></c:set>	
				<ec:column property="undertakecertno" title="${tundertakecertno}" style="text-align:center" />

				<c:set var="tregistercertno"><bean:message bundle='punishRes' key='poexcucebasic.registercertno' /></c:set>	
				<ec:column property="registercertno" title="${tregistercertno}" style="text-align:center" />

				<c:set var="tregisterid"><bean:message bundle='punishRes' key='poexcucebasic.registerid' /></c:set>	
				<ec:column property="registerid" title="${tregisterid}" style="text-align:center" />

				<c:set var="tdeputyname"><bean:message bundle='punishRes' key='poexcucebasic.deputyname' /></c:set>	
				<ec:column property="deputyname" title="${tdeputyname}" style="text-align:center" />

				<c:set var="texcucedate"><bean:message bundle='punishRes' key='poexcucebasic.excucedate' /></c:set>	
				<ec:column property="excucedate" title="${texcucedate}" style="text-align:center" />
		
				<c:set var="optlabel"><bean:message key="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><bean:message key="label.delete.confirm"/></c:set>
					<a href='poexcucebasic.do?punishobjectid=${poexcucebasic.punishobjectid}&method=view'><bean:message key="opt.btn.view" /></a>
					<a href='poexcucebasic.do?punishobjectid=${poexcucebasic.punishobjectid}&method=edit'><bean:message key="opt.btn.edit" /></a>
					<a href='poexcucebasic.do?punishobjectid=${poexcucebasic.punishobjectid}&method=delete' 
							onclick='return confirm("${deletecofirm}poexcucebasic?");'><bean:message key="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
