<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
	<head>
		<title>
			<s:text name="podecisioninfo.list.title" />
		</title>
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset
			style="border: hidden 1px #000000; ">
			<legend>
				 <s:text name="label.list.filter" />
			</legend>
			
			<s:form action="podecisioninfo" namespace="/punish" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr >
						<td><s:text name="podecisioninfo.punishobjectid" />:</td>
						<td><s:textfield name="s_punishobjectid" /> </td>
					</tr>	


					<tr >
						<td><s:text name="podecisioninfo.jbrCfjd" />:</td>
						<td><s:textfield name="s_jbrCfjd" /> </td>
					</tr>	

					<tr >
						<td><s:text name="podecisioninfo.ksrCfjd" />:</td>
						<td><s:textfield name="s_ksrCfjd" /> </td>
					</tr>	

					<tr >
						<td><s:text name="podecisioninfo.fzrCfjd" />:</td>
						<td><s:textfield name="s_fzrCfjd" /> </td>
					</tr>	

					<tr >
						<td><s:text name="podecisioninfo.jbroptionCfjd" />:</td>
						<td><s:textfield name="s_jbroptionCfjd" /> </td>
					</tr>	

					<tr >
						<td><s:text name="podecisioninfo.ksoptionCfjd" />:</td>
						<td><s:textfield name="s_ksoptionCfjd" /> </td>
					</tr>	

					<tr >
						<td><s:text name="podecisioninfo.fzroptionCfjd" />:</td>
						<td><s:textfield name="s_fzroptionCfjd" /> </td>
					</tr>	

					<tr >
						<td><s:text name="podecisioninfo.jbroptionCfjdtime" />:</td>
						<td><s:textfield name="s_jbroptionCfjdtime" /> </td>
					</tr>	

					<tr >
						<td><s:text name="podecisioninfo.ksoptionCfjdtime" />:</td>
						<td><s:textfield name="s_ksoptionCfjdtime" /> </td>
					</tr>	

					<tr >
						<td><s:text name="podecisioninfo.fzroptionCfjdtime" />:</td>
						<td><s:textfield name="s_fzroptionCfjdtime" /> </td>
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

		<ec:table action="punish/podecisioninfo!list.do" items="objList" var="podecisioninfo"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="podecisioninfos.xls" ></ec:exportXls>
			<ec:exportPdf fileName="podecisioninfos.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>

				<c:set var="tpunishobjectid"><s:text name='podecisioninfo.punishobjectid' /></c:set>	
				<ec:column property="punishobjectid" title="${tpunishobjectid}" style="text-align:center" />


				<c:set var="tjbrCfjd"><s:text name='podecisioninfo.jbrCfjd' /></c:set>	
				<ec:column property="jbrCfjd" title="${tjbrCfjd}" style="text-align:center" />

				<c:set var="tksrCfjd"><s:text name='podecisioninfo.ksrCfjd' /></c:set>	
				<ec:column property="ksrCfjd" title="${tksrCfjd}" style="text-align:center" />

				<c:set var="tfzrCfjd"><s:text name='podecisioninfo.fzrCfjd' /></c:set>	
				<ec:column property="fzrCfjd" title="${tfzrCfjd}" style="text-align:center" />

				<c:set var="tjbroptionCfjd"><s:text name='podecisioninfo.jbroptionCfjd' /></c:set>	
				<ec:column property="jbroptionCfjd" title="${tjbroptionCfjd}" style="text-align:center" />

				<c:set var="tksoptionCfjd"><s:text name='podecisioninfo.ksoptionCfjd' /></c:set>	
				<ec:column property="ksoptionCfjd" title="${tksoptionCfjd}" style="text-align:center" />

				<c:set var="tfzroptionCfjd"><s:text name='podecisioninfo.fzroptionCfjd' /></c:set>	
				<ec:column property="fzroptionCfjd" title="${tfzroptionCfjd}" style="text-align:center" />

				<c:set var="tjbroptionCfjdtime"><s:text name='podecisioninfo.jbroptionCfjdtime' /></c:set>	
				<ec:column property="jbroptionCfjdtime" title="${tjbroptionCfjdtime}" style="text-align:center" />

				<c:set var="tksoptionCfjdtime"><s:text name='podecisioninfo.ksoptionCfjdtime' /></c:set>	
				<ec:column property="ksoptionCfjdtime" title="${tksoptionCfjdtime}" style="text-align:center" />

				<c:set var="tfzroptionCfjdtime"><s:text name='podecisioninfo.fzroptionCfjdtime' /></c:set>	
				<ec:column property="fzroptionCfjdtime" title="${tfzroptionCfjdtime}" style="text-align:center" />
		
				<c:set var="optlabel"><s:text name="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><s:text name="label.delete.confirm"/></c:set>
					<a href='punish/podecisioninfo!view.do?punishobjectid=${podecisioninfo.punishobjectid}&ec_p=${ec_p}&ec_crd=${ec_crd}'><s:text name="opt.btn.view" /></a>
					<a href='punish/podecisioninfo!edit.do?punishobjectid=${podecisioninfo.punishobjectid}'><s:text name="opt.btn.edit" /></a>
					<a href='punish/podecisioninfo!delete.do?punishobjectid=${podecisioninfo.punishobjectid}' 
							onclick='return confirm("${deletecofirm}podecisioninfo?");'><s:text name="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
