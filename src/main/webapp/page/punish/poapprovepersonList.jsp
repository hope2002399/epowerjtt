<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<html>
	<head>
		<title><c:out value="poapproveperson.list.title" /></title>
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
			<html:form action="/punish/poapproveperson.do" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr height="22">
						<td><c:out value="poapproveperson.operatorid" />:</td>
						<td><html:text property="s_operatorid" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poapproveperson.stepworkid" />:</td>
						<td><html:text property="s_stepworkid" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poapproveperson.tachestepid" />:</td>
						<td><html:text property="s_tachestepid" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poapproveperson.punishobjectid" />:</td>
						<td><html:text property="s_punishobjectid" /> </td>
					</tr>	


					<tr height="22">
						<td><c:out value="poapproveperson.depid" />:</td>
						<td><html:text property="s_depid" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="poapproveperson.isappoint" />:</td>
						<td><html:text property="s_isappoint" /> </td>
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

			<ec:table action="poapproveperson.do" items="poapprovepersons" var="poapproveperson"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="poapprovepersons.xls" ></ec:exportXls>
			<ec:exportPdf fileName="poapprovepersons.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>

				<c:set var="toperatorid"><bean:message bundle='punishRes' key='poapproveperson.operatorid' /></c:set>	
				<ec:column property="operatorid" title="${toperatorid}" style="text-align:center" />

				<c:set var="tstepworkid"><bean:message bundle='punishRes' key='poapproveperson.stepworkid' /></c:set>	
				<ec:column property="stepworkid" title="${tstepworkid}" style="text-align:center" />

				<c:set var="ttachestepid"><bean:message bundle='punishRes' key='poapproveperson.tachestepid' /></c:set>	
				<ec:column property="tachestepid" title="${ttachestepid}" style="text-align:center" />

				<c:set var="tpunishobjectid"><bean:message bundle='punishRes' key='poapproveperson.punishobjectid' /></c:set>	
				<ec:column property="punishobjectid" title="${tpunishobjectid}" style="text-align:center" />


				<c:set var="tdepid"><bean:message bundle='punishRes' key='poapproveperson.depid' /></c:set>	
				<ec:column property="depid" title="${tdepid}" style="text-align:center" />

				<c:set var="tisappoint"><bean:message bundle='punishRes' key='poapproveperson.isappoint' /></c:set>	
				<ec:column property="isappoint" title="${tisappoint}" style="text-align:center" />
		
				<c:set var="optlabel"><bean:message key="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><bean:message key="label.delete.confirm"/></c:set>
					<a href='poapproveperson.do?operatorid=${poapproveperson.operatorid}&stepworkid=${poapproveperson.stepworkid}&tachestepid=${poapproveperson.tachestepid}&punishobjectid=${poapproveperson.punishobjectid}&method=view'><bean:message key="opt.btn.view" /></a>
					<a href='poapproveperson.do?operatorid=${poapproveperson.operatorid}&stepworkid=${poapproveperson.stepworkid}&tachestepid=${poapproveperson.tachestepid}&punishobjectid=${poapproveperson.punishobjectid}&method=edit'><bean:message key="opt.btn.edit" /></a>
					<a href='poapproveperson.do?operatorid=${poapproveperson.operatorid}&stepworkid=${poapproveperson.stepworkid}&tachestepid=${poapproveperson.tachestepid}&punishobjectid=${poapproveperson.punishobjectid}&method=delete' 
							onclick='return confirm("${deletecofirm}poapproveperson?");'><bean:message key="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
