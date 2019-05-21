<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<html>
	<head>
		<title><c:out value="poreceiptinfo.list.title" /></title>
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
			<html:form action="/punish/poreceiptinfo.do" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr height="22">
						<td><c:out value="poreceiptinfo.poreceiptstate" />:</td>
						<td><html:text property="s_poreceiptstate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poreceiptinfo.punishobjectid" />:</td>
						<td><html:text property="s_punishobjectid" /> </td>
					</tr>	


					<tr height="22">
						<td><c:out value="poreceiptinfo.operatorname" />:</td>
						<td><html:text property="s_operatorname" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poreceiptinfo.signinedname" />:</td>
						<td><html:text property="s_signinedname" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poreceiptinfo.signineddate" />:</td>
						<td><html:text property="s_signineddate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poreceiptinfo.poreceiptname" />:</td>
						<td><html:text property="s_poreceiptname" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poreceiptinfo.poreceiptdoc" />:</td>
						<td><html:text property="s_poreceiptdoc" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poreceiptinfo.receiptmodel" />:</td>
						<td><html:text property="s_receiptmodel" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poreceiptinfo.enregisterid" />:</td>
						<td><html:text property="s_enregisterid" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poreceiptinfo.enregisterdate" />:</td>
						<td><html:text property="s_enregisterdate" /> </td>
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

			<ec:table action="poreceiptinfo.do" items="poreceiptinfos" var="poreceiptinfo"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="poreceiptinfos.xls" ></ec:exportXls>
			<ec:exportPdf fileName="poreceiptinfos.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>

				<c:set var="tporeceiptstate"><bean:message bundle='punishRes' key='poreceiptinfo.poreceiptstate' /></c:set>	
				<ec:column property="poreceiptstate" title="${tporeceiptstate}" style="text-align:center" />

				<c:set var="tpunishobjectid"><bean:message bundle='punishRes' key='poreceiptinfo.punishobjectid' /></c:set>	
				<ec:column property="punishobjectid" title="${tpunishobjectid}" style="text-align:center" />


				<c:set var="toperatorname"><bean:message bundle='punishRes' key='poreceiptinfo.operatorname' /></c:set>	
				<ec:column property="operatorname" title="${toperatorname}" style="text-align:center" />

				<c:set var="tsigninedname"><bean:message bundle='punishRes' key='poreceiptinfo.signinedname' /></c:set>	
				<ec:column property="signinedname" title="${tsigninedname}" style="text-align:center" />

				<c:set var="tsignineddate"><bean:message bundle='punishRes' key='poreceiptinfo.signineddate' /></c:set>	
				<ec:column property="signineddate" title="${tsignineddate}" style="text-align:center" />

				<c:set var="tporeceiptname"><bean:message bundle='punishRes' key='poreceiptinfo.poreceiptname' /></c:set>	
				<ec:column property="poreceiptname" title="${tporeceiptname}" style="text-align:center" />

				<c:set var="tporeceiptdoc"><bean:message bundle='punishRes' key='poreceiptinfo.poreceiptdoc' /></c:set>	
				<ec:column property="poreceiptdoc" title="${tporeceiptdoc}" style="text-align:center" />

				<c:set var="treceiptmodel"><bean:message bundle='punishRes' key='poreceiptinfo.receiptmodel' /></c:set>	
				<ec:column property="receiptmodel" title="${treceiptmodel}" style="text-align:center" />

				<c:set var="tenregisterid"><bean:message bundle='punishRes' key='poreceiptinfo.enregisterid' /></c:set>	
				<ec:column property="enregisterid" title="${tenregisterid}" style="text-align:center" />

				<c:set var="tenregisterdate"><bean:message bundle='punishRes' key='poreceiptinfo.enregisterdate' /></c:set>	
				<ec:column property="enregisterdate" title="${tenregisterdate}" style="text-align:center" />
		
				<c:set var="optlabel"><bean:message key="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><bean:message key="label.delete.confirm"/></c:set>
					<a href='poreceiptinfo.do?poreceiptstate=${poreceiptinfo.poreceiptstate}&punishobjectid=${poreceiptinfo.punishobjectid}&method=view'><bean:message key="opt.btn.view" /></a>
					<a href='poreceiptinfo.do?poreceiptstate=${poreceiptinfo.poreceiptstate}&punishobjectid=${poreceiptinfo.punishobjectid}&method=edit'><bean:message key="opt.btn.edit" /></a>
					<a href='poreceiptinfo.do?poreceiptstate=${poreceiptinfo.poreceiptstate}&punishobjectid=${poreceiptinfo.punishobjectid}&method=delete' 
							onclick='return confirm("${deletecofirm}poreceiptinfo?");'><bean:message key="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
