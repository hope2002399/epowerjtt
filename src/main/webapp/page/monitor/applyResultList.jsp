<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title>办结办件列表</title>
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
			<s:form action="apply" namespace="/monitor" style="margin-top:0;margin-bottom:5" id="applyForm" method="post" >
				<table cellpadding="0" cellspacing="0" align="center">

					<tr height="22">
						<td>办件编号:</td>
						<td><s:textfield property="s_internalNo"  value="%{#parameters['s_internalNo']}"/> </td>
						<td>当事人:</td>
						<td><s:textfield property="s_applicantName"  value="%{#parameters['s_applicantName']}"/> </td>
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
					</tr>	
					

					
					<tr height="22">
						<td>权力类型:</td>
						<td>
					<select name="item_type" style="width: 180px"
						onchange="checkItemType();">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('ITEM_TYPE')}">
								<option value="${row.key}"
									<c:if test="${parameters.item_type[0] eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select>
					</td>
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

			<ec:table action="monitor/apply!listResult.do" items="applyList" var="apply"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			
			<ec:row>
				
					<ec:column property="isrisk" title="风险" style="text-align:center">
				<c:if test="${apply.isrisk eq 1}"><img align="middle" alt="重要权力" src="${pageContext.request.contextPath}/images/risk_point.gif" /></c:if><c:if
						test='${ apply.isrisk  eq 2}'><img align="middle" alt="关键环节" src="${pageContext.request.contextPath}/images/risk.gif" /></c:if>
						<c:if
						test='${ apply.isrisk eq 0}'>&nbsp;</c:if>
					</ec:column>
				
					<ec:column property="internalNo" title="办件编号" style="text-align:center">
					<a href='apply!view.do?internalNo=${apply.internalNo}&itemId=${apply.itemId }'>${apply.internalNo }</a>
					</ec:column>
				
					<ec:column property="orgId" title="主办部门" style="text-align:center">
					${cp:MAPVALUE("depno",apply.orgId)}
					</ec:column>
				<ec:column property="department" title="业务科室" style="text-align:center" />
				
					
					
					
					
					<ec:column property="itemId" title="办件名称" style="text-align:center">
					${cp:MAPVALUE("suppowerId",apply.itemId)}
					</ec:column>
				
					
				
					
					<ec:column property="applyDate" title="登记时间" style="text-align:center">
				<fmt:formatDate value='${apply.applyDate}' pattern='yyyy-MM-dd HH:mm:ss' />
				</ec:column>
					
				
				

			</ec:row>
		</ec:table>

	</body>
	<script type="text/javascript">
	//function doEditOpt(){
	//$("showMessage").show();	
	//}
	function checkItemType() {
		
		 var form=document.getElementById("applyForm");
	     form.action="apply!listResult.do";     
	     form.submit();
	}
</script>
</html>
