<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
	<head>
		<title>
			<s:text name="superviseResult.list.title" />
		</title>
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset
			style="border: hidden 1px #000000; ">
			<legend>
				 <s:text name="label.list.filter" />
			</legend>
			
			<s:form action="superviseResult" namespace="/supervise" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr >
						<td><s:text name="superviseResult.no" />:</td>
						<td><s:textfield name="s_no" /> </td>
					</tr>	


					<tr >
						<td><s:text name="superviseResult.superviseNo" />:</td>
						<td><s:textfield name="s_superviseNo" /> </td>
					</tr>	

					<tr >
						<td><s:text name="superviseResult.monitorNo" />:</td>
						<td><s:textfield name="s_monitorNo" /> </td>
					</tr>	

					<tr >
						<td><s:text name="superviseResult.endDate" />:</td>
						<td><s:textfield name="s_endDate" /> </td>
					</tr>	

					<tr >
						<td><s:text name="superviseResult.backOperatorId" />:</td>
						<td><s:textfield name="s_backOperatorId" /> </td>
					</tr>	

					<tr >
						<td><s:text name="superviseResult.backOperatorName" />:</td>
						<td><s:textfield name="s_backOperatorName" /> </td>
					</tr>	

					<tr >
						<td><s:text name="superviseResult.receiptDate" />:</td>
						<td><s:textfield name="s_receiptDate" /> </td>
					</tr>	

					<tr >
						<td><s:text name="superviseResult.superviseBack" />:</td>
						<td><s:textfield name="s_superviseBack" /> </td>
					</tr>	

					<tr >
						<td><s:text name="superviseResult.confirm" />:</td>
						<td><s:textfield name="s_confirm" /> </td>
					</tr>	

					<tr >
						<td><s:text name="superviseResult.isExternal" />:</td>
						<td><s:textfield name="s_isExternal" /> </td>
					</tr>	

					<tr >
						<td><s:text name="superviseResult.superviseResult" />:</td>
						<td><s:textfield name="s_superviseResult" /> </td>
					</tr>	

					<tr >
						<td><s:text name="superviseResult.endoperatorid" />:</td>
						<td><s:textfield name="s_endoperatorid" /> </td>
					</tr>	

					<tr >
						<td><s:text name="superviseResult.endOpinion" />:</td>
						<td><s:textfield name="s_endOpinion" /> </td>
					</tr>	

					<tr >
						<td><s:text name="superviseResult.updateDate" />:</td>
						<td><s:textfield name="s_updateDate" /> </td>
					</tr>	

					<tr >
						<td><s:text name="superviseResult.syncDate" />:</td>
						<td><s:textfield name="s_syncDate" /> </td>
					</tr>	

					<tr >
						<td><s:text name="superviseResult.syncSign" />:</td>
						<td><s:textfield name="s_syncSign" /> </td>
					</tr>	

					<tr >
						<td><s:text name="superviseResult.syncErrorDesc" />:</td>
						<td><s:textfield name="s_syncErrorDesc" /> </td>
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

		<ec:table action="supervise/superviseResult!list.do" items="objList" var="superviseResult"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="superviseResults.xls" ></ec:exportXls>
			<ec:exportPdf fileName="superviseResults.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>

				<c:set var="tno"><s:text name='superviseResult.no' /></c:set>	
				<ec:column property="no" title="${tno}" style="text-align:center" />


				<c:set var="tsuperviseNo"><s:text name='superviseResult.superviseNo' /></c:set>	
				<ec:column property="superviseNo" title="${tsuperviseNo}" style="text-align:center" />

				<c:set var="tmonitorNo"><s:text name='superviseResult.monitorNo' /></c:set>	
				<ec:column property="monitorNo" title="${tmonitorNo}" style="text-align:center" />

				<c:set var="tendDate"><s:text name='superviseResult.endDate' /></c:set>	
				<ec:column property="endDate" title="${tendDate}" style="text-align:center" />

				<c:set var="tbackOperatorId"><s:text name='superviseResult.backOperatorId' /></c:set>	
				<ec:column property="backOperatorId" title="${tbackOperatorId}" style="text-align:center" />

				<c:set var="tbackOperatorName"><s:text name='superviseResult.backOperatorName' /></c:set>	
				<ec:column property="backOperatorName" title="${tbackOperatorName}" style="text-align:center" />

				<c:set var="treceiptDate"><s:text name='superviseResult.receiptDate' /></c:set>	
				<ec:column property="receiptDate" title="${treceiptDate}" style="text-align:center" />

				<c:set var="tsuperviseBack"><s:text name='superviseResult.superviseBack' /></c:set>	
				<ec:column property="superviseBack" title="${tsuperviseBack}" style="text-align:center" />

				<c:set var="tconfirm"><s:text name='superviseResult.confirm' /></c:set>	
				<ec:column property="confirm" title="${tconfirm}" style="text-align:center" />

				<c:set var="tisExternal"><s:text name='superviseResult.isExternal' /></c:set>	
				<ec:column property="isExternal" title="${tisExternal}" style="text-align:center" />

				<c:set var="tsuperviseResult"><s:text name='superviseResult.superviseResult' /></c:set>	
				<ec:column property="superviseResult" title="${tsuperviseResult}" style="text-align:center" />

				<c:set var="tendoperatorid"><s:text name='superviseResult.endoperatorid' /></c:set>	
				<ec:column property="endoperatorid" title="${tendoperatorid}" style="text-align:center" />

				<c:set var="tendOpinion"><s:text name='superviseResult.endOpinion' /></c:set>	
				<ec:column property="endOpinion" title="${tendOpinion}" style="text-align:center" />

				<c:set var="tupdateDate"><s:text name='superviseResult.updateDate' /></c:set>	
				<ec:column property="updateDate" title="${tupdateDate}" style="text-align:center" />

				<c:set var="tsyncDate"><s:text name='superviseResult.syncDate' /></c:set>	
				<ec:column property="syncDate" title="${tsyncDate}" style="text-align:center" />

				<c:set var="tsyncSign"><s:text name='superviseResult.syncSign' /></c:set>	
				<ec:column property="syncSign" title="${tsyncSign}" style="text-align:center" />

				<c:set var="tsyncErrorDesc"><s:text name='superviseResult.syncErrorDesc' /></c:set>	
				<ec:column property="syncErrorDesc" title="${tsyncErrorDesc}" style="text-align:center" />
		
				<c:set var="optlabel"><s:text name="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><s:text name="label.delete.confirm"/></c:set>
					<a href='supervise/superviseResult!view.do?no=${superviseResult.no}&ec_p=${ec_p}&ec_crd=${ec_crd}'><s:text name="opt.btn.view" /></a>
					<a href='supervise/superviseResult!edit.do?no=${superviseResult.no}'><s:text name="opt.btn.edit" /></a>
					<a href='supervise/superviseResult!delete.do?no=${superviseResult.no}' 
							onclick='return confirm("${deletecofirm}superviseResult?");'><s:text name="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
