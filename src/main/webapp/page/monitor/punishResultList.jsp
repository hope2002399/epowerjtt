<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title>办结案件列表</title>
		<sj:head locale="zh_CN" />
    <link href="<s:url value="/scripts/autocomplete/autocomplete.css"/>" type="text/css" rel="stylesheet">
    <script language="javascript" src="<s:url value="/scripts/autocomplete/autocomplete.js"/>" type="text/javascript"></script>
    <script language="javascript" src="<s:url value="/scripts/selectUser.js"/>" type="text/javascript"></script>
		
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset
			style="border: hidden 1px #000000; ">
			<legend>
				 <s:text name="label.list.filter" />
			</legend>
			<s:form action="punish" namespace="/monitor" style="margin-top:0;margin-bottom:5" id="applyForm" method="post" >
				<table cellpadding="0" cellspacing="0" align="center">

					<tr height="22">
						<td>案件编号:</td>
						<td><s:textfield property="s_internalNo"  value="%{#parameters['s_internalNo']}"/> </td>
						<td>处罚当事人:</td>
						<td><s:textfield property="s_punishTarget"  value="%{#parameters['s_punishTarget']}"/> </td>
						
					</tr>	
					

					
					<tr height="22">
						<td>部门名称:</td>
						<td><select name="s_orgId">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${unitList }">
								<option value="${row.depno}"
									<c:if test="${parameters.s_orgId[0] eq row.depno}">selected="selected"</c:if>>
									<c:out value="${row.unitname}" />
								</option>
							</c:forEach>
					</select> </td>
					<td>权力名称:</td>
						<td>
						<select name="s_itemId" style="width: 180px">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${itemList }">
								<option value="${row.itemId}"
									<c:if test="${parameters.s_itemId[0] eq row.itemId}">selected="selected"</c:if>>
									<c:out value="${row.itemName}" />
								</option>
							</c:forEach>
					</select>
					</td>
					</tr>
					
					<tr height="22">
						<td>开始时间:</td>
						<td><sj:datepicker name="s_begFinishTime" readonly="true" value="%{#parameters['s_begFinishTime']}" yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" /> </td>
					<td>结束时间:</td>
						<td><sj:datepicker name="s_endFinishTime" readonly="true" value="%{#parameters['s_endFinishTime']}" yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" /> </td>
					</tr>	

					

					<tr>
						<td>
							<s:submit method="listResult" key="opt.btn.query" cssClass="btn" />
						</td>
						
					</tr>
				</table>
			</s:form>
		</fieldset>

			<ec:table action="monitor/punish!listResult.do" items="punishList" var="punish"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			
			<ec:row>
				
					<ec:column property="isrisk" title="风险" style="text-align:center">
				<c:if test="${punish.isrisk eq 1}"><img align="middle" alt="重要权力" src="${pageContext.request.contextPath}/images/risk_point.gif" /></c:if><c:if
						test='${ punish.isrisk  eq 2}'><img align="middle" alt="关键环节" src="${pageContext.request.contextPath}/images/risk.gif" /></c:if>
						<c:if
						test='${ punish.isrisk eq 0}'>&nbsp;</c:if>
					</ec:column>
				
					<ec:column property="internalNo" title="案件编号" style="text-align:center">
					<a href='punish!view.do?internalNo=${punish.internalNo}&orgId=${punish.orgId}'>${punish.internalNo }</a>
					</ec:column>
				<ec:column property="itemId" title="办件名称" style="text-align:center">
					${cp:MAPVALUE("suppowerId",punish.itemId)}
					</ec:column>
					<ec:column property="orgId" title="主办部门" style="text-align:center">
					${cp:MAPVALUE("depno",punish.orgId)}
					</ec:column>
				<ec:column property="department" title="业务科室" style="text-align:center" />
				<ec:column property="punishTarget" title="当事人" style="text-align:center" />
					<ec:column property="createDate" title="登记时间" style="text-align:center">
				<fmt:formatDate value='${punish.createDate}' pattern='yyyy-MM-dd HH:mm:ss' />
				</ec:column>
					
				
				

			</ec:row>
		</ec:table>

	</body>
	<script type="text/javascript">
	//function doEditOpt(){
	//$("showMessage").show();	
	//}
	function checkItemType() {
		
		 var form=document.getElementById("punishForm");
	     form.action="punish!listResult.do";     
	     form.submit();
	}
</script>
</html>
