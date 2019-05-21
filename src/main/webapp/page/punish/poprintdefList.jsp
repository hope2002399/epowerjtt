<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<html>
	<head>
		<title><c:out value="poprintdef.list.title" /></title>
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
			<html:form action="/punish/poprintdef.do" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr height="22">
						<td><c:out value="poprintdef.depid" />:</td>
						<td><html:text property="s_depid" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poprintdef.printtype" />:</td>
						<td><html:text property="s_printtype" /> </td>
					</tr>	


					<tr height="22">
						<td><c:out value="poprintdef.ioprintcode" />:</td>
						<td><html:text property="s_ioprintcode" /> </td>
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

			<ec:table action="poprintdef.do" items="poprintdefs" var="poprintdef"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="poprintdefs.xls" ></ec:exportXls>
			<ec:exportPdf fileName="poprintdefs.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>

				<c:set var="tdepid"><bean:message bundle='punishRes' key='poprintdef.depid' /></c:set>	
				<ec:column property="depid" title="${tdepid}" style="text-align:center" />

				<c:set var="tprinttype"><bean:message bundle='punishRes' key='poprintdef.printtype' /></c:set>	
				<ec:column property="printtype" title="${tprinttype}" style="text-align:center" />


				<c:set var="tioprintcode"><bean:message bundle='punishRes' key='poprintdef.ioprintcode' /></c:set>	
				<ec:column property="ioprintcode" title="${tioprintcode}" style="text-align:center" />
		
				<c:set var="optlabel"><bean:message key="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><bean:message key="label.delete.confirm"/></c:set>
					<a href='poprintdef.do?depid=${poprintdef.depid}&printtype=${poprintdef.printtype}&method=view'><bean:message key="opt.btn.view" /></a>
					<a href='poprintdef.do?depid=${poprintdef.depid}&printtype=${poprintdef.printtype}&method=edit'><bean:message key="opt.btn.edit" /></a>
					<a href='poprintdef.do?depid=${poprintdef.depid}&printtype=${poprintdef.printtype}&method=delete' 
							onclick='return confirm("${deletecofirm}poprintdef?");'><bean:message key="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
