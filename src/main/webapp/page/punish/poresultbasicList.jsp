<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<html>
	<head>
		<title><c:out value="poresultbasic.list.title" /></title>
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
			<html:form action="/punish/poresultbasic.do" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr height="22">
						<td><c:out value="poresultbasic.punishobjectid" />:</td>
						<td><html:text property="s_punishobjectid" /> </td>
					</tr>	


					<tr height="22">
						<td><c:out value="poresultbasic.resulttype" />:</td>
						<td><html:text property="s_resulttype" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poresultbasic.poneatencontent" />:</td>
						<td><html:text property="s_poneatencontent" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poresultbasic.poarbitrationcontent" />:</td>
						<td><html:text property="s_poarbitrationcontent" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poresultbasic.poquashreason" />:</td>
						<td><html:text property="s_poquashreason" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poresultbasic.podeportationdepname" />:</td>
						<td><html:text property="s_podeportationdepname" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poresultbasic.remark" />:</td>
						<td><html:text property="s_remark" /> </td>
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

			<ec:table action="poresultbasic.do" items="poresultbasics" var="poresultbasic"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="poresultbasics.xls" ></ec:exportXls>
			<ec:exportPdf fileName="poresultbasics.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>

				<c:set var="tpunishobjectid"><bean:message bundle='punishRes' key='poresultbasic.punishobjectid' /></c:set>	
				<ec:column property="punishobjectid" title="${tpunishobjectid}" style="text-align:center" />


				<c:set var="tresulttype"><bean:message bundle='punishRes' key='poresultbasic.resulttype' /></c:set>	
				<ec:column property="resulttype" title="${tresulttype}" style="text-align:center" />

				<c:set var="tponeatencontent"><bean:message bundle='punishRes' key='poresultbasic.poneatencontent' /></c:set>	
				<ec:column property="poneatencontent" title="${tponeatencontent}" style="text-align:center" />

				<c:set var="tpoarbitrationcontent"><bean:message bundle='punishRes' key='poresultbasic.poarbitrationcontent' /></c:set>	
				<ec:column property="poarbitrationcontent" title="${tpoarbitrationcontent}" style="text-align:center" />

				<c:set var="tpoquashreason"><bean:message bundle='punishRes' key='poresultbasic.poquashreason' /></c:set>	
				<ec:column property="poquashreason" title="${tpoquashreason}" style="text-align:center" />

				<c:set var="tpodeportationdepname"><bean:message bundle='punishRes' key='poresultbasic.podeportationdepname' /></c:set>	
				<ec:column property="podeportationdepname" title="${tpodeportationdepname}" style="text-align:center" />

				<c:set var="tremark"><bean:message bundle='punishRes' key='poresultbasic.remark' /></c:set>	
				<ec:column property="remark" title="${tremark}" style="text-align:center" />
		
				<c:set var="optlabel"><bean:message key="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><bean:message key="label.delete.confirm"/></c:set>
					<a href='poresultbasic.do?punishobjectid=${poresultbasic.punishobjectid}&method=view'><bean:message key="opt.btn.view" /></a>
					<a href='poresultbasic.do?punishobjectid=${poresultbasic.punishobjectid}&method=edit'><bean:message key="opt.btn.edit" /></a>
					<a href='poresultbasic.do?punishobjectid=${poresultbasic.punishobjectid}&method=delete' 
							onclick='return confirm("${deletecofirm}poresultbasic?");'><bean:message key="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
