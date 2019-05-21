<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
	<head>
		<title>
			<s:text name="optNewlyIdea.list.title" />
		</title>
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset
			style="border: hidden 1px #000000; ">
			<legend>
				 <s:text name="label.list.filter" />
			</legend>
			
			<s:form action="optNewlyIdea" namespace="/punish" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr >
						<td><s:text name="optNewlyIdea.punishobjectid" />:</td>
						<td><s:textfield name="s_punishobjectid" /> </td>
					</tr>	

					<tr >
						<td><s:text name="optNewlyIdea.nodeid" />:</td>
						<td><s:textfield name="s_nodeid" /> </td>
					</tr>	


					<tr >
						<td><s:text name="optNewlyIdea.nodeinstid" />:</td>
						<td><s:textfield name="s_nodeinstid" /> </td>
					</tr>	

					<tr >
						<td><s:text name="optNewlyIdea.nodename" />:</td>
						<td><s:textfield name="s_nodename" /> </td>
					</tr>	

					<tr >
						<td><s:text name="optNewlyIdea.isdisplay" />:</td>
						<td><s:textfield name="s_isdisplay" /> </td>
					</tr>	

					<tr >
						<td><s:text name="optNewlyIdea.orderno" />:</td>
						<td><s:textfield name="s_orderno" /> </td>
					</tr>	

					<tr >
						<td><s:text name="optNewlyIdea.url" />:</td>
						<td><s:textfield name="s_url" /> </td>
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

		<ec:table action="punish/optNewlyIdea!list.do" items="objList" var="optNewlyIdea"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="optNewlyIdeas.xls" ></ec:exportXls>
			<ec:exportPdf fileName="optNewlyIdeas.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>

				<c:set var="tpunishobjectid"><s:text name='optNewlyIdea.punishobjectid' /></c:set>	
				<ec:column property="punishobjectid" title="${tpunishobjectid}" style="text-align:center" />

				<c:set var="tnodeid"><s:text name='optNewlyIdea.nodeid' /></c:set>	
				<ec:column property="nodeid" title="${tnodeid}" style="text-align:center" />


				<c:set var="tnodeinstid"><s:text name='optNewlyIdea.nodeinstid' /></c:set>	
				<ec:column property="nodeinstid" title="${tnodeinstid}" style="text-align:center" />

				<c:set var="tnodename"><s:text name='optNewlyIdea.nodename' /></c:set>	
				<ec:column property="nodename" title="${tnodename}" style="text-align:center" />

				<c:set var="tisdisplay"><s:text name='optNewlyIdea.isdisplay' /></c:set>	
				<ec:column property="isdisplay" title="${tisdisplay}" style="text-align:center" />

				<c:set var="torderno"><s:text name='optNewlyIdea.orderno' /></c:set>	
				<ec:column property="orderno" title="${torderno}" style="text-align:center" />

				<c:set var="turl"><s:text name='optNewlyIdea.url' /></c:set>	
				<ec:column property="url" title="${turl}" style="text-align:center" />
		
				<c:set var="optlabel"><s:text name="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><s:text name="label.delete.confirm"/></c:set>
					<a href='punish/optNewlyIdea!view.do?punishobjectid=${optNewlyIdea.punishobjectid}&nodeid=${optNewlyIdea.nodeid}&ec_p=${ec_p}&ec_crd=${ec_crd}'><s:text name="opt.btn.view" /></a>
					<a href='punish/optNewlyIdea!edit.do?punishobjectid=${optNewlyIdea.punishobjectid}&nodeid=${optNewlyIdea.nodeid}'><s:text name="opt.btn.edit" /></a>
					<a href='punish/optNewlyIdea!delete.do?punishobjectid=${optNewlyIdea.punishobjectid}&nodeid=${optNewlyIdea.nodeid}' 
							onclick='return confirm("${deletecofirm}optNewlyIdea?");'><s:text name="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
