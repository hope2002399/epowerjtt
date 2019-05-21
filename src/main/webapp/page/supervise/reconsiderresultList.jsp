<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
	<head>
		<title>
			<s:text name="reconsiderresult.list.title" />
		</title>
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset
			style="border: hidden 1px #000000; ">
			<legend>
				 <s:text name="label.list.filter" />
			</legend>
			
			<s:form action="reconsiderresult" namespace="/supervise" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr >
						<td><s:text name="reconsiderresult.reconsiderId" />:</td>
						<td><s:textfield name="s_reconsiderId" /> </td>
					</tr>	


					<tr >
						<td><s:text name="reconsiderresult.reconsiderenddate" />:</td>
						<td><s:textfield name="s_reconsiderenddate" /> </td>
					</tr>	

					<tr >
						<td><s:text name="reconsiderresult.reconsiderresult" />:</td>
						<td><s:textfield name="s_reconsiderresult" /> </td>
					</tr>	

					<tr >
						<td><s:text name="reconsiderresult.reconsiderremark" />:</td>
						<td><s:textfield name="s_reconsiderremark" /> </td>
					</tr>	

					<tr >
						<td><s:text name="reconsiderresult.operatorId" />:</td>
						<td><s:textfield name="s_operatorId" /> </td>
					</tr>	

					<tr >
						<td><s:text name="reconsiderresult.operatorName" />:</td>
						<td><s:textfield name="s_operatorName" /> </td>
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

		<ec:table action="supervise/reconsiderresult!list.do" items="objList" var="reconsiderresult"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="reconsiderresults.xls" ></ec:exportXls>
			<ec:exportPdf fileName="reconsiderresults.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>

				<c:set var="treconsiderId"><s:text name='reconsiderresult.reconsiderId' /></c:set>	
				<ec:column property="reconsiderId" title="${treconsiderId}" style="text-align:center" />


				<c:set var="treconsiderenddate"><s:text name='reconsiderresult.reconsiderenddate' /></c:set>	
				<ec:column property="reconsiderenddate" title="${treconsiderenddate}" style="text-align:center" />

				<c:set var="treconsiderresult"><s:text name='reconsiderresult.reconsiderresult' /></c:set>	
				<ec:column property="reconsiderresult" title="${treconsiderresult}" style="text-align:center" />

				<c:set var="treconsiderremark"><s:text name='reconsiderresult.reconsiderremark' /></c:set>	
				<ec:column property="reconsiderremark" title="${treconsiderremark}" style="text-align:center" />

				<c:set var="toperatorId"><s:text name='reconsiderresult.operatorId' /></c:set>	
				<ec:column property="operatorId" title="${toperatorId}" style="text-align:center" />

				<c:set var="toperatorName"><s:text name='reconsiderresult.operatorName' /></c:set>	
				<ec:column property="operatorName" title="${toperatorName}" style="text-align:center" />
		
				<c:set var="optlabel"><s:text name="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><s:text name="label.delete.confirm"/></c:set>
					<a href='supervise/reconsiderresult!view.do?reconsiderId=${reconsiderresult.reconsiderId}&ec_p=${ec_p}&ec_crd=${ec_crd}'><s:text name="opt.btn.view" /></a>
					<a href='supervise/reconsiderresult!edit.do?reconsiderId=${reconsiderresult.reconsiderId}'><s:text name="opt.btn.edit" /></a>
					<a href='supervise/reconsiderresult!delete.do?reconsiderId=${reconsiderresult.reconsiderId}' 
							onclick='return confirm("${deletecofirm}reconsiderresult?");'><s:text name="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
