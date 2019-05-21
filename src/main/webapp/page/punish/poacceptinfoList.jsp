<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
	<head>
		<title>
			<s:text name="poacceptinfo.list.title" />
		</title>
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset
			style="border: hidden 1px #000000; ">
			<legend>
				 <s:text name="label.list.filter" />
			</legend>
			
			<s:form action="poacceptinfo" namespace="/punish" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr >
						<td><s:text name="poacceptinfo.punishobjectid" />:</td>
						<td><s:textfield name="s_punishobjectid" /> </td>
					</tr>	


					<tr >
						<td><s:text name="poacceptinfo.jbrSl" />:</td>
						<td><s:textfield name="s_jbrSl" /> </td>
					</tr>	

					<tr >
						<td><s:text name="poacceptinfo.ksrSl" />:</td>
						<td><s:textfield name="s_ksrSl" /> </td>
					</tr>	

					<tr >
						<td><s:text name="poacceptinfo.fzrSl" />:</td>
						<td><s:textfield name="s_fzrSl" /> </td>
					</tr>	

					<tr >
						<td><s:text name="poacceptinfo.jbroptionSl" />:</td>
						<td><s:textfield name="s_jbroptionSl" /> </td>
					</tr>	

					<tr >
						<td><s:text name="poacceptinfo.ksoptionSl" />:</td>
						<td><s:textfield name="s_ksoptionSl" /> </td>
					</tr>	

					<tr >
						<td><s:text name="poacceptinfo.fzroptionSl" />:</td>
						<td><s:textfield name="s_fzroptionSl" /> </td>
					</tr>	

					<tr >
						<td><s:text name="poacceptinfo.jbroptionSltime" />:</td>
						<td><s:textfield name="s_jbroptionSltime" /> </td>
					</tr>	

					<tr >
						<td><s:text name="poacceptinfo.ksoptionSltime" />:</td>
						<td><s:textfield name="s_ksoptionSltime" /> </td>
					</tr>	

					<tr >
						<td><s:text name="poacceptinfo.fzroptionSltime" />:</td>
						<td><s:textfield name="s_fzroptionSltime" /> </td>
					</tr>	

					<tr>
						<td>
							<s:submit method="list"  key="opt.btn.query" cssClass="btn"/>
						</td>
						<td>
							<s:submit method="built"  key="opt.btn.new" cssClass="btn"/>
						</td>
					</tr>
				</table>
			</s:form>
		</fieldset>

		<ec:table action="punish/poacceptinfo!list.do" items="objList" var="poacceptinfo"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="poacceptinfos.xls" ></ec:exportXls>
			<ec:exportPdf fileName="poacceptinfos.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>

				<c:set var="tpunishobjectid"><s:text name='poacceptinfo.punishobjectid' /></c:set>	
				<ec:column property="punishobjectid" title="${tpunishobjectid}" style="text-align:center" />


				<c:set var="tjbrSl"><s:text name='poacceptinfo.jbrSl' /></c:set>	
				<ec:column property="jbrSl" title="${tjbrSl}" style="text-align:center" />

				<c:set var="tksrSl"><s:text name='poacceptinfo.ksrSl' /></c:set>	
				<ec:column property="ksrSl" title="${tksrSl}" style="text-align:center" />

				<c:set var="tfzrSl"><s:text name='poacceptinfo.fzrSl' /></c:set>	
				<ec:column property="fzrSl" title="${tfzrSl}" style="text-align:center" />

				<c:set var="tjbroptionSl"><s:text name='poacceptinfo.jbroptionSl' /></c:set>	
				<ec:column property="jbroptionSl" title="${tjbroptionSl}" style="text-align:center" />

				<c:set var="tksoptionSl"><s:text name='poacceptinfo.ksoptionSl' /></c:set>	
				<ec:column property="ksoptionSl" title="${tksoptionSl}" style="text-align:center" />

				<c:set var="tfzroptionSl"><s:text name='poacceptinfo.fzroptionSl' /></c:set>	
				<ec:column property="fzroptionSl" title="${tfzroptionSl}" style="text-align:center" />

				<c:set var="tjbroptionSltime"><s:text name='poacceptinfo.jbroptionSltime' /></c:set>	
				<ec:column property="jbroptionSltime" title="${tjbroptionSltime}" style="text-align:center" />

				<c:set var="tksoptionSltime"><s:text name='poacceptinfo.ksoptionSltime' /></c:set>	
				<ec:column property="ksoptionSltime" title="${tksoptionSltime}" style="text-align:center" />

				<c:set var="tfzroptionSltime"><s:text name='poacceptinfo.fzroptionSltime' /></c:set>	
				<ec:column property="fzroptionSltime" title="${tfzroptionSltime}" style="text-align:center" />
		
				<c:set var="optlabel"><s:text name="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><s:text name="label.delete.confirm"/></c:set>
					<a href='punish/poacceptinfo!view.do?punishobjectid=${poacceptinfo.punishobjectid}&ec_p=${ec_p}&ec_crd=${ec_crd}'><s:text name="opt.btn.view" /></a>
					<a href='punish/poacceptinfo!edit.do?punishobjectid=${poacceptinfo.punishobjectid}'><s:text name="opt.btn.edit" /></a>
					<a href='punish/poacceptinfo!delete.do?punishobjectid=${poacceptinfo.punishobjectid}' 
							onclick='return confirm("${deletecofirm}poacceptinfo?");'><s:text name="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
