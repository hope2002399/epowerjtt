<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
	<head>
		<title>
			<s:text name="trPunishReg.list.title" />
		</title>
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset
			style="border: hidden 1px #000000; ">
			<legend>
				 <s:text name="label.list.filter" />
			</legend>
			
			<s:form action="trPunishReg" namespace="/dofc" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr >
						<td><s:text name="trPunishReg.djId" />:</td>
						<td><s:textfield name="s_djId" /> </td>
					</tr>	


					<tr >
						<td><s:text name="trPunishReg.caseDate" />:</td>
						<td><s:textfield name="s_caseDate" /> </td>
					</tr>	

					<tr >
						<td><s:text name="trPunishReg.caseAddress" />:</td>
						<td><s:textfield name="s_caseAddress" /> </td>
					</tr>	

					<tr >
						<td><s:text name="trPunishReg.caseSource" />:</td>
						<td><s:textfield name="s_caseSource" /> </td>
					</tr>	

					<tr >
						<td><s:text name="trPunishReg.caseFact" />:</td>
						<td><s:textfield name="s_caseFact" /> </td>
					</tr>	

					<tr >
						<td><s:text name="trPunishReg.targetType" />:</td>
						<td><s:textfield name="s_targetType" /> </td>
					</tr>	

					<tr >
						<td><s:text name="trPunishReg.targetName" />:</td>
						<td><s:textfield name="s_targetName" /> </td>
					</tr>	

					<tr >
						<td><s:text name="trPunishReg.targetPaperType" />:</td>
						<td><s:textfield name="s_targetPaperType" /> </td>
					</tr>	

					<tr >
						<td><s:text name="trPunishReg.targetPaperCode" />:</td>
						<td><s:textfield name="s_targetPaperCode" /> </td>
					</tr>	

					<tr >
						<td><s:text name="trPunishReg.targetUnitcode" />:</td>
						<td><s:textfield name="s_targetUnitcode" /> </td>
					</tr>	

					<tr >
						<td><s:text name="trPunishReg.targetPhone" />:</td>
						<td><s:textfield name="s_targetPhone" /> </td>
					</tr>	

					<tr >
						<td><s:text name="trPunishReg.targetMobile" />:</td>
						<td><s:textfield name="s_targetMobile" /> </td>
					</tr>	

					<tr >
						<td><s:text name="trPunishReg.targetAddress" />:</td>
						<td><s:textfield name="s_targetAddress" /> </td>
					</tr>	

					<tr >
						<td><s:text name="trPunishReg.reporterName" />:</td>
						<td><s:textfield name="s_reporterName" /> </td>
					</tr>	

					<tr >
						<td><s:text name="trPunishReg.reporterDate" />:</td>
						<td><s:textfield name="s_reporterDate" /> </td>
					</tr>	

					<tr >
						<td><s:text name="trPunishReg.reporterPaperType" />:</td>
						<td><s:textfield name="s_reporterPaperType" /> </td>
					</tr>	

					<tr >
						<td><s:text name="trPunishReg.reporterPaperCode" />:</td>
						<td><s:textfield name="s_reporterPaperCode" /> </td>
					</tr>	

					<tr >
						<td><s:text name="trPunishReg.reporterPhone" />:</td>
						<td><s:textfield name="s_reporterPhone" /> </td>
					</tr>	

					<tr >
						<td><s:text name="trPunishReg.reporterMobile" />:</td>
						<td><s:textfield name="s_reporterMobile" /> </td>
					</tr>	

					<tr >
						<td><s:text name="trPunishReg.reporterAddress" />:</td>
						<td><s:textfield name="s_reporterAddress" /> </td>
					</tr>	

					<tr >
						<td><s:text name="trPunishReg.caseRegDate" />:</td>
						<td><s:textfield name="s_caseRegDate" /> </td>
					</tr>	

					<tr >
						<td><s:text name="trPunishReg.caseRegUsercode" />:</td>
						<td><s:textfield name="s_caseRegUsercode" /> </td>
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

		<ec:table action="dofc/trPunishReg!list.do" items="objList" var="trPunishReg"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="trPunishRegs.xls" ></ec:exportXls>
			<ec:exportPdf fileName="trPunishRegs.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>

				<c:set var="tdjId"><s:text name='trPunishReg.djId' /></c:set>	
				<ec:column property="djId" title="${tdjId}" style="text-align:center" />


				<c:set var="tcaseDate"><s:text name='trPunishReg.caseDate' /></c:set>	
				<ec:column property="caseDate" title="${tcaseDate}" style="text-align:center" />

				<c:set var="tcaseAddress"><s:text name='trPunishReg.caseAddress' /></c:set>	
				<ec:column property="caseAddress" title="${tcaseAddress}" style="text-align:center" />

				<c:set var="tcaseSource"><s:text name='trPunishReg.caseSource' /></c:set>	
				<ec:column property="caseSource" title="${tcaseSource}" style="text-align:center" />

				<c:set var="tcaseFact"><s:text name='trPunishReg.caseFact' /></c:set>	
				<ec:column property="caseFact" title="${tcaseFact}" style="text-align:center" />

				<c:set var="ttargetType"><s:text name='trPunishReg.targetType' /></c:set>	
				<ec:column property="targetType" title="${ttargetType}" style="text-align:center" />

				<c:set var="ttargetName"><s:text name='trPunishReg.targetName' /></c:set>	
				<ec:column property="targetName" title="${ttargetName}" style="text-align:center" />

				<c:set var="ttargetPaperType"><s:text name='trPunishReg.targetPaperType' /></c:set>	
				<ec:column property="targetPaperType" title="${ttargetPaperType}" style="text-align:center" />

				<c:set var="ttargetPaperCode"><s:text name='trPunishReg.targetPaperCode' /></c:set>	
				<ec:column property="targetPaperCode" title="${ttargetPaperCode}" style="text-align:center" />

				<c:set var="ttargetUnitcode"><s:text name='trPunishReg.targetUnitcode' /></c:set>	
				<ec:column property="targetUnitcode" title="${ttargetUnitcode}" style="text-align:center" />

				<c:set var="ttargetPhone"><s:text name='trPunishReg.targetPhone' /></c:set>	
				<ec:column property="targetPhone" title="${ttargetPhone}" style="text-align:center" />

				<c:set var="ttargetMobile"><s:text name='trPunishReg.targetMobile' /></c:set>	
				<ec:column property="targetMobile" title="${ttargetMobile}" style="text-align:center" />

				<c:set var="ttargetAddress"><s:text name='trPunishReg.targetAddress' /></c:set>	
				<ec:column property="targetAddress" title="${ttargetAddress}" style="text-align:center" />

				<c:set var="treporterName"><s:text name='trPunishReg.reporterName' /></c:set>	
				<ec:column property="reporterName" title="${treporterName}" style="text-align:center" />

				<c:set var="treporterDate"><s:text name='trPunishReg.reporterDate' /></c:set>	
				<ec:column property="reporterDate" title="${treporterDate}" style="text-align:center" />

				<c:set var="treporterPaperType"><s:text name='trPunishReg.reporterPaperType' /></c:set>	
				<ec:column property="reporterPaperType" title="${treporterPaperType}" style="text-align:center" />

				<c:set var="treporterPaperCode"><s:text name='trPunishReg.reporterPaperCode' /></c:set>	
				<ec:column property="reporterPaperCode" title="${treporterPaperCode}" style="text-align:center" />

				<c:set var="treporterPhone"><s:text name='trPunishReg.reporterPhone' /></c:set>	
				<ec:column property="reporterPhone" title="${treporterPhone}" style="text-align:center" />

				<c:set var="treporterMobile"><s:text name='trPunishReg.reporterMobile' /></c:set>	
				<ec:column property="reporterMobile" title="${treporterMobile}" style="text-align:center" />

				<c:set var="treporterAddress"><s:text name='trPunishReg.reporterAddress' /></c:set>	
				<ec:column property="reporterAddress" title="${treporterAddress}" style="text-align:center" />

				<c:set var="tcaseRegDate"><s:text name='trPunishReg.caseRegDate' /></c:set>	
				<ec:column property="caseRegDate" title="${tcaseRegDate}" style="text-align:center" />

				<c:set var="tcaseRegUsercode"><s:text name='trPunishReg.caseRegUsercode' /></c:set>	
				<ec:column property="caseRegUsercode" title="${tcaseRegUsercode}" style="text-align:center" />
		
				<c:set var="optlabel"><s:text name="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><s:text name="label.delete.confirm"/></c:set>
					<a href='dofc/trPunishReg!view.do?djId=${trPunishReg.djId}&ec_p=${ec_p}&ec_crd=${ec_crd}'><s:text name="opt.btn.view" /></a>
					<a href='dofc/trPunishReg!edit.do?djId=${trPunishReg.djId}'><s:text name="opt.btn.edit" /></a>
					<a href='dofc/trPunishReg!delete.do?djId=${trPunishReg.djId}' 
							onclick='return confirm("${deletecofirm}trPunishReg?");'><s:text name="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
