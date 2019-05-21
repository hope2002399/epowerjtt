<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%> 
<html>
	<head>
		<title>
		投诉查看
		</title>
		<sj:head locale="zh_CN" />
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset
			style="border: hidden 1px #000000; ">
			<legend>
				查询
			</legend>
			
			<s:form action="complaint" namespace="/complaint" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr >
						<td align="right">投诉编号:</td>
						<td><s:textfield name="s_complaintid" value="%{#parameters['s_complaintid']}"/> </td>
					
						<td align="right">办结类型:</td>
						<td>	
        <select name="s_type" style="width:140px">
						<option VALUE="" >---请选择---</option>
							<c:forEach var="row" items="${cp:DICTIONARY('TSDCJG')}">
								<option value="${row.key}" label="${row.value}" <c:if test="${param.s_type==row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
						</select>
						 </td>
					</tr>	

					<tr>
						<td align="right">受理部门:</td>
						<td><select name="s_orgId">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${unitList }">
								<option value="${row.depno}"
									<c:if test="${parameters.s_orgId[0] eq row.depno}">selected="selected"</c:if>>
									<c:out value="${row.unitname}" />
								</option>
							</c:forEach>
					</select></td>
					
						<td align="right">投诉类型:</td>
						<td>
						<select name="s_complaintsType" style="width:140px">
						<option VALUE="" >---请选择---</option>
							<c:forEach var="row" items="${cp:DICTIONARY('COMPLAINTS_TYPE')}">
								<option value="${row.key}" label="${row.value}" <c:if test="${param.s_complaintsType==row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
						</select>
						</td>
					</tr>	

					<tr >
						<td align="right">投诉来源:</td>
						<td> 
						<select name="s_complaintsSource" style="width:153px">
						<option VALUE="" >---请选择---</option>
							<c:forEach var="row" items="${cp:DICTIONARY('TS_SOURCE')}">
								<option value="${row.key}" label="${row.value}" <c:if test="${param.s_complaintsSource==row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
						</select>
						
						</td>
				
						<td align="right">状态:</td>
						<td>
						<select name="s_state" style="width:140px">
						<option VALUE="" >---请选择---</option>
							<c:forEach var="row" items="${cp:DICTIONARY('complaintState')}">
								<option value="${row.key}" label="${row.value}" <c:if test="${param.s_state==row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
						</select>
						</td>
					</tr>
					<tr height="22">
						<td align="right">开始时间:</td>
						<td><sj:datepicker name="s_begTime" readonly="true" value="%{#parameters['s_begTime']}" yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" /> </td>
					<td align="right">结束时间:</td>
						<td><sj:datepicker name="s_endTime" readonly="true" value="%{#parameters['s_endTime']}" yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" /> </td>
					</tr>	
					<tr align="center">
						<td align="center" colspan="4">						
							
							<s:submit method="listFg"  key="opt.btn.query" cssClass="btn"/>
<!-- 						    <input type="button" name="reset" value="重置" class="btn" onclick="resetForm();"/> -->
						</td>
					</tr>
				</table>
			</s:form>
		</fieldset>

		<ec:table action="complaint/complaint!listFg.do" items="fgList" var="complaint"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif"  retrieveRowsCallback="limit">
			<ec:row>

				<ec:column property="complaintid" title="投诉编号" style="text-align:center" />

				

				<ec:column property="complaintremark" title="投诉内容" style="text-align:center">
				${fn:length(complaint.complaintremark) > 20 ?fn:substring(complaint.complaintremark, 0 , 20):complaint.complaintremark }
				</ec:column>
				
				<ec:column property="complaintsType" title="投诉类型" style="text-align:center" >
				${cp:MAPVALUE("COMPLAINTS_TYPE",complaint.complaintsType)}
				</ec:column>

				<ec:column property="complaintsSource" title="投诉来源" style="text-align:center" >
				${cp:MAPVALUE("TS_SOURCE",complaint.complaintsSource)}
				</ec:column>
				<ec:column property="complaintman" title="投诉人" style="text-align:center" />

				<ec:column property="createDate" title="投诉登记时间" style="text-align:center" format="yyyy-MM-dd HH:mm" cell="date" />
					
				<ec:column property="biztype" title="状态" style="text-align:center" >
				${cp:MAPVALUE("complaintState",complaint.state)}
				</ec:column>

				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">
					
					<a href='complaint/complaint!view.do?complaintid=${complaint.complaintid}&flowInstId=${complaint.flowInstId}&ec_p=${ec_p}&ec_crd=${ec_crd}'><s:text name="opt.btn.view" /></a>
				
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
	<script type="text/javascript">
function confirm_check(complaintid){
	if(window.confirm("确实删除此["+complaintid+"]投诉项?")){
		document.location.href ='complaint/complaint!delete.do?complaintid='+complaintid;
	}	
}
</script>
</html>
