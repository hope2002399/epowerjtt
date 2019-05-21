<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<html>
	<head>
		<title><c:out value="popunishbasic.list.title" /></title>
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
			<html:form action="/punish/popunishbasic.do" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr height="22">
						<td><c:out value="popunishbasic.punishobjectid" />:</td>
						<td><html:text property="s_punishobjectid" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="popunishbasic.punishtypeid" />:</td>
						<td><html:text property="s_punishtypeid" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="popunishbasic.punishclassid" />:</td>
						<td><html:text property="s_punishclassid" /> </td>
					</tr>	


					<tr height="22">
						<td><c:out value="popunishbasic.punishvalue" />:</td>
						<td><html:text property="s_punishvalue" /> </td>
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

			<ec:table action="popunishbasic.do" items="popunishbasics" var="popunishbasic"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="popunishbasics.xls" ></ec:exportXls>
			<ec:exportPdf fileName="popunishbasics.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>

				<c:set var="tpunishobjectid"><bean:message bundle='punishRes' key='popunishbasic.punishobjectid' /></c:set>	
				<ec:column property="punishobjectid" title="${tpunishobjectid}" style="text-align:center" />

				<c:set var="tpunishtypeid"><bean:message bundle='punishRes' key='popunishbasic.punishtypeid' /></c:set>	
				<ec:column property="punishtypeid" title="${tpunishtypeid}" style="text-align:center" />

				<c:set var="tpunishclassid"><bean:message bundle='punishRes' key='popunishbasic.punishclassid' /></c:set>	
				<ec:column property="punishclassid" title="${tpunishclassid}" style="text-align:center" />


				<c:set var="tpunishvalue"><bean:message bundle='punishRes' key='popunishbasic.punishvalue' /></c:set>	
				<ec:column property="punishvalue" title="${tpunishvalue}" style="text-align:center" />
		
				<c:set var="optlabel"><bean:message key="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><bean:message key="label.delete.confirm"/></c:set>
					<a href='popunishbasic.do?punishobjectid=${popunishbasic.punishobjectid}&punishtypeid=${popunishbasic.punishtypeid}&punishclassid=${popunishbasic.punishclassid}&method=view'><bean:message key="opt.btn.view" /></a>
					<a href='popunishbasic.do?punishobjectid=${popunishbasic.punishobjectid}&punishtypeid=${popunishbasic.punishtypeid}&punishclassid=${popunishbasic.punishclassid}&method=edit'><bean:message key="opt.btn.edit" /></a>
					<a href='popunishbasic.do?punishobjectid=${popunishbasic.punishobjectid}&punishtypeid=${popunishbasic.punishtypeid}&punishclassid=${popunishbasic.punishclassid}&method=delete' 
							onclick='return confirm("${deletecofirm}popunishbasic?");'><bean:message key="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
