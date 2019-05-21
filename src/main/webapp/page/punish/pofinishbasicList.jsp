<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<html>
	<head>
		<title><c:out value="pofinishbasic.list.title" /></title>
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
			<html:form action="/punish/pofinishbasic.do" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr height="22">
						<td><c:out value="pofinishbasic.punishobjectid" />:</td>
						<td><html:text property="s_punishobjectid" /> </td>
					</tr>	


					<tr height="22">
						<td><c:out value="pofinishbasic.disobeyitem" />:</td>
						<td><html:text property="s_disobeyitem" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="pofinishbasic.confirmtruth" />:</td>
						<td><html:text property="s_confirmtruth" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="pofinishbasic.podiscussresult" />:</td>
						<td><html:text property="s_podiscussresult" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="pofinishbasic.punishamout" />:</td>
						<td><html:text property="s_punishamout" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="pofinishbasic.otherpunish" />:</td>
						<td><html:text property="s_otherpunish" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="pofinishbasic.punishamoutpeople" />:</td>
						<td><html:text property="s_punishamoutpeople" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="pofinishbasic.punishseizure" />:</td>
						<td><html:text property="s_punishseizure" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="pofinishbasic.punishseizurevalue" />:</td>
						<td><html:text property="s_punishseizurevalue" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="pofinishbasic.punishshoutont" />:</td>
						<td><html:text property="s_punishshoutont" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="pofinishbasic.punishdetentionpeople" />:</td>
						<td><html:text property="s_punishdetentionpeople" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="pofinishbasic.punishdetention" />:</td>
						<td><html:text property="s_punishdetention" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="pofinishbasic.isfinish" />:</td>
						<td><html:text property="s_isfinish" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="pofinishbasic.punishaffixname" />:</td>
						<td><html:text property="s_punishaffixname" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="pofinishbasic.punishaffixdoc" />:</td>
						<td><html:text property="s_punishaffixdoc" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="pofinishbasic.punishaffixcode" />:</td>
						<td><html:text property="s_punishaffixcode" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="pofinishbasic.pofinishstep" />:</td>
						<td><html:text property="s_pofinishstep" /> </td>
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

			<ec:table action="pofinishbasic.do" items="pofinishbasics" var="pofinishbasic"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="pofinishbasics.xls" ></ec:exportXls>
			<ec:exportPdf fileName="pofinishbasics.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>

				<c:set var="tpunishobjectid"><bean:message bundle='punishRes' key='pofinishbasic.punishobjectid' /></c:set>	
				<ec:column property="punishobjectid" title="${tpunishobjectid}" style="text-align:center" />


				<c:set var="tdisobeyitem"><bean:message bundle='punishRes' key='pofinishbasic.disobeyitem' /></c:set>	
				<ec:column property="disobeyitem" title="${tdisobeyitem}" style="text-align:center" />

				<c:set var="tconfirmtruth"><bean:message bundle='punishRes' key='pofinishbasic.confirmtruth' /></c:set>	
				<ec:column property="confirmtruth" title="${tconfirmtruth}" style="text-align:center" />

				<c:set var="tpodiscussresult"><bean:message bundle='punishRes' key='pofinishbasic.podiscussresult' /></c:set>	
				<ec:column property="podiscussresult" title="${tpodiscussresult}" style="text-align:center" />

				<c:set var="tpunishamout"><bean:message bundle='punishRes' key='pofinishbasic.punishamout' /></c:set>	
				<ec:column property="punishamout" title="${tpunishamout}" style="text-align:center" />

				<c:set var="totherpunish"><bean:message bundle='punishRes' key='pofinishbasic.otherpunish' /></c:set>	
				<ec:column property="otherpunish" title="${totherpunish}" style="text-align:center" />

				<c:set var="tpunishamoutpeople"><bean:message bundle='punishRes' key='pofinishbasic.punishamoutpeople' /></c:set>	
				<ec:column property="punishamoutpeople" title="${tpunishamoutpeople}" style="text-align:center" />

				<c:set var="tpunishseizure"><bean:message bundle='punishRes' key='pofinishbasic.punishseizure' /></c:set>	
				<ec:column property="punishseizure" title="${tpunishseizure}" style="text-align:center" />

				<c:set var="tpunishseizurevalue"><bean:message bundle='punishRes' key='pofinishbasic.punishseizurevalue' /></c:set>	
				<ec:column property="punishseizurevalue" title="${tpunishseizurevalue}" style="text-align:center" />

				<c:set var="tpunishshoutont"><bean:message bundle='punishRes' key='pofinishbasic.punishshoutont' /></c:set>	
				<ec:column property="punishshoutont" title="${tpunishshoutont}" style="text-align:center" />

				<c:set var="tpunishdetentionpeople"><bean:message bundle='punishRes' key='pofinishbasic.punishdetentionpeople' /></c:set>	
				<ec:column property="punishdetentionpeople" title="${tpunishdetentionpeople}" style="text-align:center" />

				<c:set var="tpunishdetention"><bean:message bundle='punishRes' key='pofinishbasic.punishdetention' /></c:set>	
				<ec:column property="punishdetention" title="${tpunishdetention}" style="text-align:center" />

				<c:set var="tisfinish"><bean:message bundle='punishRes' key='pofinishbasic.isfinish' /></c:set>	
				<ec:column property="isfinish" title="${tisfinish}" style="text-align:center" />

				<c:set var="tpunishaffixname"><bean:message bundle='punishRes' key='pofinishbasic.punishaffixname' /></c:set>	
				<ec:column property="punishaffixname" title="${tpunishaffixname}" style="text-align:center" />

				<c:set var="tpunishaffixdoc"><bean:message bundle='punishRes' key='pofinishbasic.punishaffixdoc' /></c:set>	
				<ec:column property="punishaffixdoc" title="${tpunishaffixdoc}" style="text-align:center" />

				<c:set var="tpunishaffixcode"><bean:message bundle='punishRes' key='pofinishbasic.punishaffixcode' /></c:set>	
				<ec:column property="punishaffixcode" title="${tpunishaffixcode}" style="text-align:center" />

				<c:set var="tpofinishstep"><bean:message bundle='punishRes' key='pofinishbasic.pofinishstep' /></c:set>	
				<ec:column property="pofinishstep" title="${tpofinishstep}" style="text-align:center" />
		
				<c:set var="optlabel"><bean:message key="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><bean:message key="label.delete.confirm"/></c:set>
					<a href='pofinishbasic.do?punishobjectid=${pofinishbasic.punishobjectid}&method=view'><bean:message key="opt.btn.view" /></a>
					<a href='pofinishbasic.do?punishobjectid=${pofinishbasic.punishobjectid}&method=edit'><bean:message key="opt.btn.edit" /></a>
					<a href='pofinishbasic.do?punishobjectid=${pofinishbasic.punishobjectid}&method=delete' 
							onclick='return confirm("${deletecofirm}pofinishbasic?");'><bean:message key="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
