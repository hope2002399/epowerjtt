<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<html>
	<head>
		<title><c:out value="podiscussbasic.list.title" /></title>
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
			<html:form action="/punish/podiscussbasic.do" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr height="22">
						<td><c:out value="podiscussbasic.punishobjectid" />:</td>
						<td><html:text property="s_punishobjectid" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="podiscussbasic.podiscusstype" />:</td>
						<td><html:text property="s_podiscusstype" /> </td>
					</tr>	


					<tr height="22">
						<td><c:out value="podiscussbasic.podiscussbegintime" />:</td>
						<td><html:text property="s_podiscussbegintime" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="podiscussbasic.podiscussendtime" />:</td>
						<td><html:text property="s_podiscussendtime" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="podiscussbasic.podiscussemcee" />:</td>
						<td><html:text property="s_podiscussemcee" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="podiscussbasic.podiscussnoter" />:</td>
						<td><html:text property="s_podiscussnoter" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="podiscussbasic.podiscussattendname" />:</td>
						<td><html:text property="s_podiscussattendname" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="podiscussbasic.podiscussattendeename" />:</td>
						<td><html:text property="s_podiscussattendeename" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="podiscussbasic.podiscussaffixname" />:</td>
						<td><html:text property="s_podiscussaffixname" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="podiscussbasic.podiscussrecored" />:</td>
						<td><html:text property="s_podiscussrecored" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="podiscussbasic.disobeyitem" />:</td>
						<td><html:text property="s_disobeyitem" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="podiscussbasic.confirmtruth" />:</td>
						<td><html:text property="s_confirmtruth" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="podiscussbasic.podiscussadress" />:</td>
						<td><html:text property="s_podiscussadress" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="podiscussbasic.podiscussresult" />:</td>
						<td><html:text property="s_podiscussresult" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="podiscussbasic.enregisterdate" />:</td>
						<td><html:text property="s_enregisterdate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="podiscussbasic.podiscussstep" />:</td>
						<td><html:text property="s_podiscussstep" /> </td>
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

			<ec:table action="podiscussbasic.do" items="podiscussbasics" var="podiscussbasic"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="podiscussbasics.xls" ></ec:exportXls>
			<ec:exportPdf fileName="podiscussbasics.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>

				<c:set var="tpunishobjectid"><bean:message bundle='punishRes' key='podiscussbasic.punishobjectid' /></c:set>	
				<ec:column property="punishobjectid" title="${tpunishobjectid}" style="text-align:center" />

				<c:set var="tpodiscusstype"><bean:message bundle='punishRes' key='podiscussbasic.podiscusstype' /></c:set>	
				<ec:column property="podiscusstype" title="${tpodiscusstype}" style="text-align:center" />


				<c:set var="tpodiscussbegintime"><bean:message bundle='punishRes' key='podiscussbasic.podiscussbegintime' /></c:set>	
				<ec:column property="podiscussbegintime" title="${tpodiscussbegintime}" style="text-align:center" />

				<c:set var="tpodiscussendtime"><bean:message bundle='punishRes' key='podiscussbasic.podiscussendtime' /></c:set>	
				<ec:column property="podiscussendtime" title="${tpodiscussendtime}" style="text-align:center" />

				<c:set var="tpodiscussemcee"><bean:message bundle='punishRes' key='podiscussbasic.podiscussemcee' /></c:set>	
				<ec:column property="podiscussemcee" title="${tpodiscussemcee}" style="text-align:center" />

				<c:set var="tpodiscussnoter"><bean:message bundle='punishRes' key='podiscussbasic.podiscussnoter' /></c:set>	
				<ec:column property="podiscussnoter" title="${tpodiscussnoter}" style="text-align:center" />

				<c:set var="tpodiscussattendname"><bean:message bundle='punishRes' key='podiscussbasic.podiscussattendname' /></c:set>	
				<ec:column property="podiscussattendname" title="${tpodiscussattendname}" style="text-align:center" />

				<c:set var="tpodiscussattendeename"><bean:message bundle='punishRes' key='podiscussbasic.podiscussattendeename' /></c:set>	
				<ec:column property="podiscussattendeename" title="${tpodiscussattendeename}" style="text-align:center" />

				<c:set var="tpodiscussaffixname"><bean:message bundle='punishRes' key='podiscussbasic.podiscussaffixname' /></c:set>	
				<ec:column property="podiscussaffixname" title="${tpodiscussaffixname}" style="text-align:center" />

				<c:set var="tpodiscussrecored"><bean:message bundle='punishRes' key='podiscussbasic.podiscussrecored' /></c:set>	
				<ec:column property="podiscussrecored" title="${tpodiscussrecored}" style="text-align:center" />

				<c:set var="tdisobeyitem"><bean:message bundle='punishRes' key='podiscussbasic.disobeyitem' /></c:set>	
				<ec:column property="disobeyitem" title="${tdisobeyitem}" style="text-align:center" />

				<c:set var="tconfirmtruth"><bean:message bundle='punishRes' key='podiscussbasic.confirmtruth' /></c:set>	
				<ec:column property="confirmtruth" title="${tconfirmtruth}" style="text-align:center" />

				<c:set var="tpodiscussadress"><bean:message bundle='punishRes' key='podiscussbasic.podiscussadress' /></c:set>	
				<ec:column property="podiscussadress" title="${tpodiscussadress}" style="text-align:center" />

				<c:set var="tpodiscussresult"><bean:message bundle='punishRes' key='podiscussbasic.podiscussresult' /></c:set>	
				<ec:column property="podiscussresult" title="${tpodiscussresult}" style="text-align:center" />

				<c:set var="tenregisterdate"><bean:message bundle='punishRes' key='podiscussbasic.enregisterdate' /></c:set>	
				<ec:column property="enregisterdate" title="${tenregisterdate}" style="text-align:center" />

				<c:set var="tpodiscussstep"><bean:message bundle='punishRes' key='podiscussbasic.podiscussstep' /></c:set>	
				<ec:column property="podiscussstep" title="${tpodiscussstep}" style="text-align:center" />
		
				<c:set var="optlabel"><bean:message key="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><bean:message key="label.delete.confirm"/></c:set>
					<a href='podiscussbasic.do?punishobjectid=${podiscussbasic.punishobjectid}&podiscusstype=${podiscussbasic.podiscusstype}&method=view'><bean:message key="opt.btn.view" /></a>
					<a href='podiscussbasic.do?punishobjectid=${podiscussbasic.punishobjectid}&podiscusstype=${podiscussbasic.podiscusstype}&method=edit'><bean:message key="opt.btn.edit" /></a>
					<a href='podiscussbasic.do?punishobjectid=${podiscussbasic.punishobjectid}&podiscusstype=${podiscussbasic.podiscusstype}&method=delete' 
							onclick='return confirm("${deletecofirm}podiscussbasic?");'><bean:message key="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
