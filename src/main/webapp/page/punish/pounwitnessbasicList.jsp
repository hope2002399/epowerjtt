<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<html>
	<head>
		<title><c:out value="pounwitnessbasic.list.title" /></title>
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
			<html:form action="/punish/pounwitnessbasic.do" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr height="22">
						<td><c:out value="pounwitnessbasic.punishobjectid" />:</td>
						<td><html:text property="s_punishobjectid" /> </td>
					</tr>	


					<tr height="22">
						<td><c:out value="pounwitnessbasic.pounwitnessreason" />:</td>
						<td><html:text property="s_pounwitnessreason" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="pounwitnessbasic.unwitnessdate" />:</td>
						<td><html:text property="s_unwitnessdate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="pounwitnessbasic.enregisterid" />:</td>
						<td><html:text property="s_enregisterid" /> </td>
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

			<ec:table action="pounwitnessbasic.do" items="pounwitnessbasics" var="pounwitnessbasic"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="pounwitnessbasics.xls" ></ec:exportXls>
			<ec:exportPdf fileName="pounwitnessbasics.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>

				<c:set var="tpunishobjectid"><bean:message bundle='punishRes' key='pounwitnessbasic.punishobjectid' /></c:set>	
				<ec:column property="punishobjectid" title="${tpunishobjectid}" style="text-align:center" />


				<c:set var="tpounwitnessreason"><bean:message bundle='punishRes' key='pounwitnessbasic.pounwitnessreason' /></c:set>	
				<ec:column property="pounwitnessreason" title="${tpounwitnessreason}" style="text-align:center" />

				<c:set var="tunwitnessdate"><bean:message bundle='punishRes' key='pounwitnessbasic.unwitnessdate' /></c:set>	
				<ec:column property="unwitnessdate" title="${tunwitnessdate}" style="text-align:center" />

				<c:set var="tenregisterid"><bean:message bundle='punishRes' key='pounwitnessbasic.enregisterid' /></c:set>	
				<ec:column property="enregisterid" title="${tenregisterid}" style="text-align:center" />
		
				<c:set var="optlabel"><bean:message key="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><bean:message key="label.delete.confirm"/></c:set>
					<a href='pounwitnessbasic.do?punishobjectid=${pounwitnessbasic.punishobjectid}&method=view'><bean:message key="opt.btn.view" /></a>
					<a href='pounwitnessbasic.do?punishobjectid=${pounwitnessbasic.punishobjectid}&method=edit'><bean:message key="opt.btn.edit" /></a>
					<a href='pounwitnessbasic.do?punishobjectid=${pounwitnessbasic.punishobjectid}&method=delete' 
							onclick='return confirm("${deletecofirm}pounwitnessbasic?");'><bean:message key="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
