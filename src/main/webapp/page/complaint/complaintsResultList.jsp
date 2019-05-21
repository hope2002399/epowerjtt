<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
	<head>
		<title>
			<s:text name="complaintsResult.list.title" />
		</title>
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset
			style="border: hidden 1px #000000; ">
			<legend>
				 <s:text name="label.list.filter" />
			</legend>
			
			<s:form action="complaintsResult" namespace="/complaint" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr >
						<td><s:text name="complaintsResult.no" />:</td>
						<td><s:textfield name="s_no" /> </td>
					</tr>	


					<tr >
						<td><s:text name="complaintsResult.complaintid" />:</td>
						<td><s:textfield name="s_complaintid" /> </td>
					</tr>	

					<tr >
						<td><s:text name="complaintsResult.type" />:</td>
						<td><s:textfield name="s_type" /> </td>
					</tr>	

					<tr >
						<td><s:text name="complaintsResult.detail" />:</td>
						<td><s:textfield name="s_detail" /> </td>
					</tr>	

					<tr >
						<td><s:text name="complaintsResult.operatorId" />:</td>
						<td><s:textfield name="s_operatorId" /> </td>
					</tr>	

					<tr >
						<td><s:text name="complaintsResult.operatorName" />:</td>
						<td><s:textfield name="s_operatorName" /> </td>
					</tr>	

					<tr >
						<td><s:text name="complaintsResult.resultDate" />:</td>
						<td><s:textfield name="s_resultDate" /> </td>
					</tr>	

					<tr >
						<td><s:text name="complaintsResult.opinion" />:</td>
						<td><s:textfield name="s_opinion" /> </td>
					</tr>	

					<tr >
						<td><s:text name="complaintsResult.updateDate" />:</td>
						<td><s:textfield name="s_updateDate" /> </td>
					</tr>	

					<tr >
						<td><s:text name="complaintsResult.syncDate" />:</td>
						<td><s:textfield name="s_syncDate" /> </td>
					</tr>	

					<tr >
						<td><s:text name="complaintsResult.syncSign" />:</td>
						<td><s:textfield name="s_syncSign" /> </td>
					</tr>	

					<tr >
						<td><s:text name="complaintsResult.syncErrorDesc" />:</td>
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

		<ec:table action="complaint/complaintsResult!list.do" items="objList" var="complaintsResult"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="complaintsResults.xls" ></ec:exportXls>
			<ec:exportPdf fileName="complaintsResults.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>

				<c:set var="tno"><s:text name='complaintsResult.no' /></c:set>	
				<ec:column property="no" title="${tno}" style="text-align:center" />


				<c:set var="tcomplaintid"><s:text name='complaintsResult.complaintid' /></c:set>	
				<ec:column property="complaintid" title="${tcomplaintid}" style="text-align:center" />

				<c:set var="ttype"><s:text name='complaintsResult.type' /></c:set>	
				<ec:column property="type" title="${ttype}" style="text-align:center" />

				<c:set var="tdetail"><s:text name='complaintsResult.detail' /></c:set>	
				<ec:column property="detail" title="${tdetail}" style="text-align:center" />

				<c:set var="toperatorId"><s:text name='complaintsResult.operatorId' /></c:set>	
				<ec:column property="operatorId" title="${toperatorId}" style="text-align:center" />

				<c:set var="toperatorName"><s:text name='complaintsResult.operatorName' /></c:set>	
				<ec:column property="operatorName" title="${toperatorName}" style="text-align:center" />

				<c:set var="tresultDate"><s:text name='complaintsResult.resultDate' /></c:set>	
				<ec:column property="resultDate" title="${tresultDate}" style="text-align:center" />

				<c:set var="topinion"><s:text name='complaintsResult.opinion' /></c:set>	
				<ec:column property="opinion" title="${topinion}" style="text-align:center" />

				<c:set var="tupdateDate"><s:text name='complaintsResult.updateDate' /></c:set>	
				<ec:column property="updateDate" title="${tupdateDate}" style="text-align:center" />

				<c:set var="tsyncDate"><s:text name='complaintsResult.syncDate' /></c:set>	
				<ec:column property="syncDate" title="${tsyncDate}" style="text-align:center" />

				<c:set var="tsyncSign"><s:text name='complaintsResult.syncSign' /></c:set>	
				<ec:column property="syncSign" title="${tsyncSign}" style="text-align:center" />

				<c:set var="tsyncErrorDesc"><s:text name='complaintsResult.syncErrorDesc' /></c:set>	
				<ec:column property="syncErrorDesc" title="${tsyncErrorDesc}" style="text-align:center" />
		
				<c:set var="optlabel"><s:text name="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><s:text name="label.delete.confirm"/></c:set>
					<a href='complaint/complaintsResult!view.do?no=${complaintsResult.no}&ec_p=${ec_p}&ec_crd=${ec_crd}'><s:text name="opt.btn.view" /></a>
					<a href='complaint/complaintsResult!edit.do?no=${complaintsResult.no}'><s:text name="opt.btn.edit" /></a>
					<a href='complaint/complaintsResult!delete.do?no=${complaintsResult.no}' 
							onclick='return confirm("${deletecofirm}complaintsResult?");'><s:text name="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
