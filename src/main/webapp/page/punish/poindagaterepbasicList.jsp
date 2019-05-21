<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<html>
	<head>
		<title><c:out value="poindagaterepbasic.list.title" /></title>
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
			<html:form action="/punish/poindagaterepbasic.do" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr height="22">
						<td><c:out value="poindagaterepbasic.punishobjectid" />:</td>
						<td><html:text property="s_punishobjectid" /> </td>
					</tr>	


					<tr height="22">
						<td><c:out value="poindagaterepbasic.confirmtruth" />:</td>
						<td><html:text property="s_confirmtruth" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poindagaterepbasic.unconfirmtruth" />:</td>
						<td><html:text property="s_unconfirmtruth" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poindagaterepbasic.poindagatereppassage" />:</td>
						<td><html:text property="s_poindagatereppassage" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poindagaterepbasic.disobeyitem" />:</td>
						<td><html:text property="s_disobeyitem" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poindagaterepbasic.poindagaterepresult" />:</td>
						<td><html:text property="s_poindagaterepresult" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poindagaterepbasic.isdiscuss" />:</td>
						<td><html:text property="s_isdiscuss" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poindagaterepbasic.poindagaterepreportdoc" />:</td>
						<td><html:text property="s_poindagaterepreportdoc" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poindagaterepbasic.poindagaterepreportdocname" />:</td>
						<td><html:text property="s_poindagaterepreportdocname" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poindagaterepbasic.poindagaterepstate" />:</td>
						<td><html:text property="s_poindagaterepstate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poindagaterepbasic.poindagaterepstep" />:</td>
						<td><html:text property="s_poindagaterepstep" /> </td>
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

			<ec:table action="poindagaterepbasic.do" items="poindagaterepbasics" var="poindagaterepbasic"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="poindagaterepbasics.xls" ></ec:exportXls>
			<ec:exportPdf fileName="poindagaterepbasics.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>

				<c:set var="tpunishobjectid"><bean:message bundle='punishRes' key='poindagaterepbasic.punishobjectid' /></c:set>	
				<ec:column property="punishobjectid" title="${tpunishobjectid}" style="text-align:center" />


				<c:set var="tconfirmtruth"><bean:message bundle='punishRes' key='poindagaterepbasic.confirmtruth' /></c:set>	
				<ec:column property="confirmtruth" title="${tconfirmtruth}" style="text-align:center" />

				<c:set var="tunconfirmtruth"><bean:message bundle='punishRes' key='poindagaterepbasic.unconfirmtruth' /></c:set>	
				<ec:column property="unconfirmtruth" title="${tunconfirmtruth}" style="text-align:center" />

				<c:set var="tpoindagatereppassage"><bean:message bundle='punishRes' key='poindagaterepbasic.poindagatereppassage' /></c:set>	
				<ec:column property="poindagatereppassage" title="${tpoindagatereppassage}" style="text-align:center" />

				<c:set var="tdisobeyitem"><bean:message bundle='punishRes' key='poindagaterepbasic.disobeyitem' /></c:set>	
				<ec:column property="disobeyitem" title="${tdisobeyitem}" style="text-align:center" />

				<c:set var="tpoindagaterepresult"><bean:message bundle='punishRes' key='poindagaterepbasic.poindagaterepresult' /></c:set>	
				<ec:column property="poindagaterepresult" title="${tpoindagaterepresult}" style="text-align:center" />

				<c:set var="tisdiscuss"><bean:message bundle='punishRes' key='poindagaterepbasic.isdiscuss' /></c:set>	
				<ec:column property="isdiscuss" title="${tisdiscuss}" style="text-align:center" />

				<c:set var="tpoindagaterepreportdoc"><bean:message bundle='punishRes' key='poindagaterepbasic.poindagaterepreportdoc' /></c:set>	
				<ec:column property="poindagaterepreportdoc" title="${tpoindagaterepreportdoc}" style="text-align:center" />

				<c:set var="tpoindagaterepreportdocname"><bean:message bundle='punishRes' key='poindagaterepbasic.poindagaterepreportdocname' /></c:set>	
				<ec:column property="poindagaterepreportdocname" title="${tpoindagaterepreportdocname}" style="text-align:center" />

				<c:set var="tpoindagaterepstate"><bean:message bundle='punishRes' key='poindagaterepbasic.poindagaterepstate' /></c:set>	
				<ec:column property="poindagaterepstate" title="${tpoindagaterepstate}" style="text-align:center" />

				<c:set var="tpoindagaterepstep"><bean:message bundle='punishRes' key='poindagaterepbasic.poindagaterepstep' /></c:set>	
				<ec:column property="poindagaterepstep" title="${tpoindagaterepstep}" style="text-align:center" />
		
				<c:set var="optlabel"><bean:message key="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><bean:message key="label.delete.confirm"/></c:set>
					<a href='poindagaterepbasic.do?punishobjectid=${poindagaterepbasic.punishobjectid}&method=view'><bean:message key="opt.btn.view" /></a>
					<a href='poindagaterepbasic.do?punishobjectid=${poindagaterepbasic.punishobjectid}&method=edit'><bean:message key="opt.btn.edit" /></a>
					<a href='poindagaterepbasic.do?punishobjectid=${poindagaterepbasic.punishobjectid}&method=delete' 
							onclick='return confirm("${deletecofirm}poindagaterepbasic?");'><bean:message key="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
