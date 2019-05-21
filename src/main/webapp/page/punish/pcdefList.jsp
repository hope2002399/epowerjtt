<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<html>
	<head>
		<title><c:out value="pcdef.list.title" /></title>
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
			<html:form action="/punish/pcdef.do" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr height="22">
						<td><c:out value="pcdef.punishclassid" />:</td>
						<td><html:text property="s_punishclassid" /> </td>
					</tr>	


					<tr height="22">
						<td><c:out value="pcdef.punishclassname" />:</td>
						<td><html:text property="s_punishclassname" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="pcdef.depid" />:</td>
						<td><html:text property="s_depid" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="pcdef.punishclasscode" />:</td>
						<td><html:text property="s_punishclasscode" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="pcdef.punishobject" />:</td>
						<td><html:text property="s_punishobject" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="pcdef.isinuse" />:</td>
						<td><html:text property="s_isinuse" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="pcdef.punishbasiscontent" />:</td>
						<td><html:text property="s_punishbasiscontent" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="pcdef.punishbasis" />:</td>
						<td><html:text property="s_punishbasis" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="pcdef.remark" />:</td>
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

			<ec:table action="pcdef.do" items="pcdefs" var="pcdef"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="pcdefs.xls" ></ec:exportXls>
			<ec:exportPdf fileName="pcdefs.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>

				<c:set var="tpunishclassid"><bean:message bundle='punishRes' key='pcdef.punishclassid' /></c:set>	
				<ec:column property="punishclassid" title="${tpunishclassid}" style="text-align:center" />


				<c:set var="tpunishclassname"><bean:message bundle='punishRes' key='pcdef.punishclassname' /></c:set>	
				<ec:column property="punishclassname" title="${tpunishclassname}" style="text-align:center" />

				<c:set var="tdepid"><bean:message bundle='punishRes' key='pcdef.depid' /></c:set>	
				<ec:column property="depid" title="${tdepid}" style="text-align:center" />

				<c:set var="tpunishclasscode"><bean:message bundle='punishRes' key='pcdef.punishclasscode' /></c:set>	
				<ec:column property="punishclasscode" title="${tpunishclasscode}" style="text-align:center" />

				<c:set var="tpunishobject"><bean:message bundle='punishRes' key='pcdef.punishobject' /></c:set>	
				<ec:column property="punishobject" title="${tpunishobject}" style="text-align:center" />

				<c:set var="tisinuse"><bean:message bundle='punishRes' key='pcdef.isinuse' /></c:set>	
				<ec:column property="isinuse" title="${tisinuse}" style="text-align:center" />

				<c:set var="tpunishbasiscontent"><bean:message bundle='punishRes' key='pcdef.punishbasiscontent' /></c:set>	
				<ec:column property="punishbasiscontent" title="${tpunishbasiscontent}" style="text-align:center" />

				<c:set var="tpunishbasis"><bean:message bundle='punishRes' key='pcdef.punishbasis' /></c:set>	
				<ec:column property="punishbasis" title="${tpunishbasis}" style="text-align:center" />

				<c:set var="tremark"><bean:message bundle='punishRes' key='pcdef.remark' /></c:set>	
				<ec:column property="remark" title="${tremark}" style="text-align:center" />
		
				<c:set var="optlabel"><bean:message key="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><bean:message key="label.delete.confirm"/></c:set>
					<a href='pcdef.do?punishclassid=${pcdef.punishclassid}&method=view'><bean:message key="opt.btn.view" /></a>
					<a href='pcdef.do?punishclassid=${pcdef.punishclassid}&method=edit'><bean:message key="opt.btn.edit" /></a>
					<a href='pcdef.do?punishclassid=${pcdef.punishclassid}&method=delete' 
							onclick='return confirm("${deletecofirm}pcdef?");'><bean:message key="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
