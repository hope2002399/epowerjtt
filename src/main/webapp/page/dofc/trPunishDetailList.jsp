<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
	<head>
		<title>
			<s:text name="trPunishDetail.list.title" />
		</title>
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset
			style="border: hidden 1px #000000; ">
			<legend>
				 <s:text name="label.list.filter" />
			</legend>
			
			<s:form action="trPunishDetail" namespace="/dofc" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr >
						<td><s:text name="trPunishDetail.djId" />:</td>
						<td><s:textfield name="s_djId" /> </td>
					</tr>	

					<tr >
						<td><s:text name="trPunishDetail.punishItem" />:</td>
						<td><s:textfield name="s_punishItem" /> </td>
					</tr>	


					<tr >
						<td><s:text name="trPunishDetail.punishName" />:</td>
						<td><s:textfield name="s_punishName" /> </td>
					</tr>	

					<tr >
						<td><s:text name="trPunishDetail.isreal" />:</td>
						<td><s:textfield name="s_isreal" /> </td>
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

		<ec:table action="powerruntime/trPunishDetail!list.do" items="objList" var="trPunishDetail"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="trPunishDetails.xls" ></ec:exportXls>
			<ec:exportPdf fileName="trPunishDetails.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>

				<c:set var="tdjId"><s:text name='trPunishDetail.djId' /></c:set>	
				<ec:column property="djId" title="${tdjId}" style="text-align:center" />

				<c:set var="tpunishItem"><s:text name='trPunishDetail.punishItem' /></c:set>	
				<ec:column property="punishItem" title="${tpunishItem}" style="text-align:center" />


				<c:set var="tpunishName"><s:text name='trPunishDetail.punishName' /></c:set>	
				<ec:column property="punishName" title="${tpunishName}" style="text-align:center" />

				<c:set var="tisreal"><s:text name='trPunishDetail.isreal' /></c:set>	
				<ec:column property="isreal" title="${tisreal}" style="text-align:center" />
		
				<c:set var="optlabel"><s:text name="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><s:text name="label.delete.confirm"/></c:set>
					<a href='powerruntime/trPunishDetail!view.do?djId=${trPunishDetail.djId}&punishItem=${trPunishDetail.punishItem}&ec_p=${ec_p}&ec_crd=${ec_crd}'><s:text name="opt.btn.view" /></a>
					<a href='powerruntime/trPunishDetail!edit.do?djId=${trPunishDetail.djId}&punishItem=${trPunishDetail.punishItem}'><s:text name="opt.btn.edit" /></a>
					<a href='powerruntime/trPunishDetail!delete.do?djId=${trPunishDetail.djId}&punishItem=${trPunishDetail.punishItem}' 
							onclick='return confirm("${deletecofirm}trPunishDetail?");'><s:text name="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
