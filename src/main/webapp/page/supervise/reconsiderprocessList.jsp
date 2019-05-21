<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
	<head>
		<title>
			<s:text name="reconsiderprocess.list.title" />
		</title>
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset
			style="border: hidden 1px #000000; ">
			<legend>
				 <s:text name="label.list.filter" />
			</legend>
			
			<s:form action="reconsiderprocess" namespace="/supervise" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr >
						<td><s:text name="reconsiderprocess.processno" />:</td>
						<td><s:textfield name="s_processno" /> </td>
					</tr>	


					<tr >
						<td><s:text name="reconsiderprocess.nodeinstid" />:</td>
						<td><s:textfield name="s_nodeinstid" /> </td>
					</tr>	

					<tr >
						<td><s:text name="reconsiderprocess.reconsiderId" />:</td>
						<td><s:textfield name="s_reconsiderId" /> </td>
					</tr>	

					<tr >
						<td><s:text name="reconsiderprocess.processCode" />:</td>
						<td><s:textfield name="s_processCode" /> </td>
					</tr>	

					<tr >
						<td><s:text name="reconsiderprocess.processName" />:</td>
						<td><s:textfield name="s_processName" /> </td>
					</tr>	

					<tr >
						<td><s:text name="reconsiderprocess.processDate" />:</td>
						<td><s:textfield name="s_processDate" /> </td>
					</tr>	

					<tr >
						<td><s:text name="reconsiderprocess.operatorId" />:</td>
						<td><s:textfield name="s_operatorId" /> </td>
					</tr>	

					<tr >
						<td><s:text name="reconsiderprocess.operatorName" />:</td>
						<td><s:textfield name="s_operatorName" /> </td>
					</tr>	

					<tr >
						<td><s:text name="reconsiderprocess.operatorResult" />:</td>
						<td><s:textfield name="s_operatorResult" /> </td>
					</tr>	

					<tr >
						<td><s:text name="reconsiderprocess.operatorOpinion" />:</td>
						<td><s:textfield name="s_operatorOpinion" /> </td>
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

		<ec:table action="supervise/reconsiderprocess!list.do" items="objList" var="reconsiderprocess"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="reconsiderprocesss.xls" ></ec:exportXls>
			<ec:exportPdf fileName="reconsiderprocesss.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>

				<c:set var="tprocessno"><s:text name='reconsiderprocess.processno' /></c:set>	
				<ec:column property="processno" title="${tprocessno}" style="text-align:center" />


				<c:set var="tnodeinstid"><s:text name='reconsiderprocess.nodeinstid' /></c:set>	
				<ec:column property="nodeinstid" title="${tnodeinstid}" style="text-align:center" />

				<c:set var="treconsiderId"><s:text name='reconsiderprocess.reconsiderId' /></c:set>	
				<ec:column property="reconsiderId" title="${treconsiderId}" style="text-align:center" />

				<c:set var="tprocessCode"><s:text name='reconsiderprocess.processCode' /></c:set>	
				<ec:column property="processCode" title="${tprocessCode}" style="text-align:center" />

				<c:set var="tprocessName"><s:text name='reconsiderprocess.processName' /></c:set>	
				<ec:column property="processName" title="${tprocessName}" style="text-align:center" />

				<c:set var="tprocessDate"><s:text name='reconsiderprocess.processDate' /></c:set>	
				<ec:column property="processDate" title="${tprocessDate}" style="text-align:center" />

				<c:set var="toperatorId"><s:text name='reconsiderprocess.operatorId' /></c:set>	
				<ec:column property="operatorId" title="${toperatorId}" style="text-align:center" />

				<c:set var="toperatorName"><s:text name='reconsiderprocess.operatorName' /></c:set>	
				<ec:column property="operatorName" title="${toperatorName}" style="text-align:center" />

				<c:set var="toperatorResult"><s:text name='reconsiderprocess.operatorResult' /></c:set>	
				<ec:column property="operatorResult" title="${toperatorResult}" style="text-align:center" />

				<c:set var="toperatorOpinion"><s:text name='reconsiderprocess.operatorOpinion' /></c:set>	
				<ec:column property="operatorOpinion" title="${toperatorOpinion}" style="text-align:center" />
		
				<c:set var="optlabel"><s:text name="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><s:text name="label.delete.confirm"/></c:set>
					<a href='supervise/reconsiderprocess!view.do?processno=${reconsiderprocess.processno}&ec_p=${ec_p}&ec_crd=${ec_crd}'><s:text name="opt.btn.view" /></a>
					<a href='supervise/reconsiderprocess!edit.do?processno=${reconsiderprocess.processno}'><s:text name="opt.btn.edit" /></a>
					<a href='supervise/reconsiderprocess!delete.do?processno=${reconsiderprocess.processno}' 
							onclick='return confirm("${deletecofirm}reconsiderprocess?");'><s:text name="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
