<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<html>
	<head>
		<title><c:out value="pomovebackbasic.list.title" /></title>
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
			<html:form action="/punish/pomovebackbasic.do" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr height="22">
						<td><c:out value="pomovebackbasic.sortno" />:</td>
						<td><html:text property="s_sortno" /> </td>
					</tr>	


					<tr height="22">
						<td><c:out value="pomovebackbasic.punishobjectid" />:</td>
						<td><html:text property="s_punishobjectid" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="pomovebackbasic.stepworkid" />:</td>
						<td><html:text property="s_stepworkid" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="pomovebackbasic.beginapprovecode" />:</td>
						<td><html:text property="s_beginapprovecode" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="pomovebackbasic.endapprovecode" />:</td>
						<td><html:text property="s_endapprovecode" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="pomovebackbasic.movebackdate" />:</td>
						<td><html:text property="s_movebackdate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="pomovebackbasic.operatorid" />:</td>
						<td><html:text property="s_operatorid" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="pomovebackbasic.movebackcontent" />:</td>
						<td><html:text property="s_movebackcontent" /> </td>
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

			<ec:table action="pomovebackbasic.do" items="pomovebackbasics" var="pomovebackbasic"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="pomovebackbasics.xls" ></ec:exportXls>
			<ec:exportPdf fileName="pomovebackbasics.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>

				<c:set var="tsortno"><bean:message bundle='punishRes' key='pomovebackbasic.sortno' /></c:set>	
				<ec:column property="sortno" title="${tsortno}" style="text-align:center" />


				<c:set var="tpunishobjectid"><bean:message bundle='punishRes' key='pomovebackbasic.punishobjectid' /></c:set>	
				<ec:column property="punishobjectid" title="${tpunishobjectid}" style="text-align:center" />

				<c:set var="tstepworkid"><bean:message bundle='punishRes' key='pomovebackbasic.stepworkid' /></c:set>	
				<ec:column property="stepworkid" title="${tstepworkid}" style="text-align:center" />

				<c:set var="tbeginapprovecode"><bean:message bundle='punishRes' key='pomovebackbasic.beginapprovecode' /></c:set>	
				<ec:column property="beginapprovecode" title="${tbeginapprovecode}" style="text-align:center" />

				<c:set var="tendapprovecode"><bean:message bundle='punishRes' key='pomovebackbasic.endapprovecode' /></c:set>	
				<ec:column property="endapprovecode" title="${tendapprovecode}" style="text-align:center" />

				<c:set var="tmovebackdate"><bean:message bundle='punishRes' key='pomovebackbasic.movebackdate' /></c:set>	
				<ec:column property="movebackdate" title="${tmovebackdate}" style="text-align:center" />

				<c:set var="toperatorid"><bean:message bundle='punishRes' key='pomovebackbasic.operatorid' /></c:set>	
				<ec:column property="operatorid" title="${toperatorid}" style="text-align:center" />

				<c:set var="tmovebackcontent"><bean:message bundle='punishRes' key='pomovebackbasic.movebackcontent' /></c:set>	
				<ec:column property="movebackcontent" title="${tmovebackcontent}" style="text-align:center" />
		
				<c:set var="optlabel"><bean:message key="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><bean:message key="label.delete.confirm"/></c:set>
					<a href='pomovebackbasic.do?sortno=${pomovebackbasic.sortno}&method=view'><bean:message key="opt.btn.view" /></a>
					<a href='pomovebackbasic.do?sortno=${pomovebackbasic.sortno}&method=edit'><bean:message key="opt.btn.edit" /></a>
					<a href='pomovebackbasic.do?sortno=${pomovebackbasic.sortno}&method=delete' 
							onclick='return confirm("${deletecofirm}pomovebackbasic?");'><bean:message key="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
