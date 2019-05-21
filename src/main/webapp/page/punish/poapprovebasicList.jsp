<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<html>
	<head>
		<title><c:out value="poapprovebasic.list.title" /></title>
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
			<html:form action="/punish/poapprovebasic.do" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr height="22">
						<td><c:out value="poapprovebasic.punishobjectid" />:</td>
						<td><html:text property="s_punishobjectid" /> </td>
					</tr>	


					<tr height="22">
						<td><c:out value="poapprovebasic.poapprovestep" />:</td>
						<td><html:text property="s_poapprovestep" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poapprovebasic.ispass" />:</td>
						<td><html:text property="s_ispass" /> </td>
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

			<ec:table action="poapprovebasic.do" items="poapprovebasics" var="poapprovebasic"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="poapprovebasics.xls" ></ec:exportXls>
			<ec:exportPdf fileName="poapprovebasics.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>

				<c:set var="tpunishobjectid"><bean:message bundle='punishRes' key='poapprovebasic.punishobjectid' /></c:set>	
				<ec:column property="punishobjectid" title="${tpunishobjectid}" style="text-align:center" />


				<c:set var="tpoapprovestep"><bean:message bundle='punishRes' key='poapprovebasic.poapprovestep' /></c:set>	
				<ec:column property="poapprovestep" title="${tpoapprovestep}" style="text-align:center" />

				<c:set var="tispass"><bean:message bundle='punishRes' key='poapprovebasic.ispass' /></c:set>	
				<ec:column property="ispass" title="${tispass}" style="text-align:center" />
		
				<c:set var="optlabel"><bean:message key="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><bean:message key="label.delete.confirm"/></c:set>
					<a href='poapprovebasic.do?punishobjectid=${poapprovebasic.punishobjectid}&method=view'><bean:message key="opt.btn.view" /></a>
					<a href='poapprovebasic.do?punishobjectid=${poapprovebasic.punishobjectid}&method=edit'><bean:message key="opt.btn.edit" /></a>
					<a href='poapprovebasic.do?punishobjectid=${poapprovebasic.punishobjectid}&method=delete' 
							onclick='return confirm("${deletecofirm}poapprovebasic?");'><bean:message key="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
