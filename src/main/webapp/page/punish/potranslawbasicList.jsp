<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<html>
	<head>
		<title><c:out value="potranslawbasic.list.title" /></title>
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
			<html:form action="/punish/potranslawbasic.do" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr height="22">
						<td><c:out value="potranslawbasic.punishclassid" />:</td>
						<td><html:text property="s_punishclassid" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="potranslawbasic.punishobjectid" />:</td>
						<td><html:text property="s_punishobjectid" /> </td>
					</tr>	


					<tr height="22">
						<td><c:out value="potranslawbasic.degreeno" />:</td>
						<td><html:text property="s_degreeno" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="potranslawbasic.issurpass" />:</td>
						<td><html:text property="s_issurpass" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="potranslawbasic.translawdate" />:</td>
						<td><html:text property="s_translawdate" /> </td>
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

			<ec:table action="potranslawbasic.do" items="potranslawbasics" var="potranslawbasic"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="potranslawbasics.xls" ></ec:exportXls>
			<ec:exportPdf fileName="potranslawbasics.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>

				<c:set var="tpunishclassid"><bean:message bundle='punishRes' key='potranslawbasic.punishclassid' /></c:set>	
				<ec:column property="punishclassid" title="${tpunishclassid}" style="text-align:center" />

				<c:set var="tpunishobjectid"><bean:message bundle='punishRes' key='potranslawbasic.punishobjectid' /></c:set>	
				<ec:column property="punishobjectid" title="${tpunishobjectid}" style="text-align:center" />


				<c:set var="tdegreeno"><bean:message bundle='punishRes' key='potranslawbasic.degreeno' /></c:set>	
				<ec:column property="degreeno" title="${tdegreeno}" style="text-align:center" />

				<c:set var="tissurpass"><bean:message bundle='punishRes' key='potranslawbasic.issurpass' /></c:set>	
				<ec:column property="issurpass" title="${tissurpass}" style="text-align:center" />

				<c:set var="ttranslawdate"><bean:message bundle='punishRes' key='potranslawbasic.translawdate' /></c:set>	
				<ec:column property="translawdate" title="${ttranslawdate}" style="text-align:center" />
		
				<c:set var="optlabel"><bean:message key="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><bean:message key="label.delete.confirm"/></c:set>
					<a href='potranslawbasic.do?punishclassid=${potranslawbasic.punishclassid}&punishobjectid=${potranslawbasic.punishobjectid}&method=view'><bean:message key="opt.btn.view" /></a>
					<a href='potranslawbasic.do?punishclassid=${potranslawbasic.punishclassid}&punishobjectid=${potranslawbasic.punishobjectid}&method=edit'><bean:message key="opt.btn.edit" /></a>
					<a href='potranslawbasic.do?punishclassid=${potranslawbasic.punishclassid}&punishobjectid=${potranslawbasic.punishobjectid}&method=delete' 
							onclick='return confirm("${deletecofirm}potranslawbasic?");'><bean:message key="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
