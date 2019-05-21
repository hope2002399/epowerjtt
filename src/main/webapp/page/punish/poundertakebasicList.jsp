<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<html>
	<head>
		<title><c:out value="poundertakebasic.list.title" /></title>
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
			<html:form action="/punish/poundertakebasic.do" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr height="22">
						<td><c:out value="poundertakebasic.punishobjectid" />:</td>
						<td><html:text property="s_punishobjectid" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poundertakebasic.usercode" />:</td>
						<td><html:text property="s_usercode" /> </td>
					</tr>	


					<tr height="22">
						<td><c:out value="poundertakebasic.depid" />:</td>
						<td><html:text property="s_depid" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poundertakebasic.sectionid" />:</td>
						<td><html:text property="s_sectionid" /> </td>
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

			<ec:table action="poundertakebasic.do" items="poundertakebasics" var="poundertakebasic"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="poundertakebasics.xls" ></ec:exportXls>
			<ec:exportPdf fileName="poundertakebasics.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>

				<c:set var="tpunishobjectid"><bean:message bundle='punishRes' key='poundertakebasic.punishobjectid' /></c:set>	
				<ec:column property="punishobjectid" title="${tpunishobjectid}" style="text-align:center" />

				<c:set var="tusercode"><bean:message bundle='punishRes' key='poundertakebasic.usercode' /></c:set>	
				<ec:column property="usercode" title="${tusercode}" style="text-align:center" />


				<c:set var="tdepid"><bean:message bundle='punishRes' key='poundertakebasic.depid' /></c:set>	
				<ec:column property="depid" title="${tdepid}" style="text-align:center" />

				<c:set var="tsectionid"><bean:message bundle='punishRes' key='poundertakebasic.sectionid' /></c:set>	
				<ec:column property="sectionid" title="${tsectionid}" style="text-align:center" />
		
				<c:set var="optlabel"><bean:message key="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><bean:message key="label.delete.confirm"/></c:set>
					<a href='poundertakebasic.do?punishobjectid=${poundertakebasic.punishobjectid}&usercode=${poundertakebasic.usercode}&method=view'><bean:message key="opt.btn.view" /></a>
					<a href='poundertakebasic.do?punishobjectid=${poundertakebasic.punishobjectid}&usercode=${poundertakebasic.usercode}&method=edit'><bean:message key="opt.btn.edit" /></a>
					<a href='poundertakebasic.do?punishobjectid=${poundertakebasic.punishobjectid}&usercode=${poundertakebasic.usercode}&method=delete' 
							onclick='return confirm("${deletecofirm}poundertakebasic?");'><bean:message key="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
