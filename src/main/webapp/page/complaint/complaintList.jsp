<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%> 
<html>
	<head>
		<title>
		投诉查看
		</title>
		<script type="text/javascript">
		function resetForm(){
		 $('#s_complaintid').val('');
		 $('#s_internalNo').val('');
		 $('#s_complaintsType').val('');
		 $('#s_complaintsSource').val('');
		}
		</script>
<style type="text/css">
		.search td{padding:0px 10px 0px 10px;}
</style>
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<div class="search">
			<div class="crumbs">
				投诉查看
			</div>
			
			<s:form action="complaint" namespace="/complaint" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center" >

					<tr >
						<td width="20%" align="right">投诉编号:</td>
						<td><input type="text" name="s_complaintid" id="s_complaintid "value="${param.s_complaintid}" ></td>
						<td width="25%" align="right">办件类型:</td><td>
        <s:radio value="%{#parameters['s_bjType']}" listKey="key" listValue="value" id="s_bjType" name="s_bjType" list="#{'':'全部','1':'许可','2':'处罚'}"  />
						 </td>
					</tr>	

					<tr>
						<td align="right">办件编号:</td><td><s:textfield name="s_internalNo" id="s_internalNo" value="%{#parameters['s_internalNo']}"/> </td>
					
						<td align="right">投诉类型:</td><td>
						<select name="s_complaintsType"  id="s_complaintsType" style="width:140px">
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
						<td align="right">投诉来源:</td><td>
						<select name="s_complaintsSource" id="s_complaintsSource" style="width:160px">
						<option VALUE="" >---请选择---</option>
							<c:forEach var="row" items="${cp:DICTIONARY('TS_SOURCE')}">
								<option value="${row.key}" label="${row.value}" <c:if test="${param.s_complaintsSource==row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
						</select>
						
						</td>
				
						<td align="right">状态:</td><td>
						<select name="s_biztype" style="width:140px">
						<option VALUE="" >---请选择---</option>
							<c:forEach var="row" items="${cp:DICTIONARY('bizType')}">
								<option value="${row.key}" label="${row.value}" <c:if test="${param.s_biztype==row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
						</select>
						</td>
					</tr>
					<tr>
					<td colspan="2"></td>
						<td colspan="2" align="left">						
							<s:submit method="edit"  cssClass="btn" value="投诉登记"/>
							<s:submit method="list"  key="opt.btn.query" cssClass="btn"/>
							<s:reset cssClass="btn" value="重置"></s:reset>
						</td>
					</tr>
				</table>
			</s:form>
		</div>

		<ec:table action="complaint/complaint!list.do" items="objList" var="complaint"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif"  retrieveRowsCallback="limit">
			<ec:row>

				<ec:column property="complaintid" title="投诉编号" style="text-align:center" />

				<ec:column property="bjType" title="办件类型" style="text-align:center" >
				${cp:MAPVALUE("bjType",complaint.bjType)}
				</ec:column>

				<ec:column property="internalNo" title="办件编号" style="text-align:center" >
				<c:if test="${complaint.bjType eq '1'}">
					<a href="../monitor/apply!view.do?internalNo=${complaint.internalNo}&itemId=${complaint.itemId }">${complaint.internalNo}</a>
				</c:if>
				<c:if test="${complaint.bjType eq '2'}">
					<a href="../monitor/punish!view.do?no=${complaint.internalNo}">${complaint.internalNo}</a>
				</c:if>
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
				${cp:MAPVALUE("bizType",complaint.biztype)}
				</ec:column>

				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm">
						<bean:message key="label.delete.confirm" />
					</c:set>
					<a href='complaint/complaint!view.do?complaintid=${complaint.complaintid}&flowInstId=${complaint.flowInstId}&ec_p=${ec_p}&ec_crd=${ec_crd}'><s:text name="opt.btn.view" /></a>
					<a href='#' onclick="openNewWindow('${pageContext.request.contextPath}/sampleflow/sampleFlowManager!viewxml.do?flowInstId=${complaint.flowInstId}','powerWindow',null);">查看流程图</a>
					<c:if test="${complaint.biztype  eq 'F' }">
						<a
							href='complaint/complaint!edit.do?complaintid=${complaint.complaintid}'>编辑</a>
						<a href='#'	onclick="confirm_check('${complaint.complaintid}');">删除</a>

					</c:if>
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

function openNewWindow(winUrl,winName,winProps){
	if(winProps =='' || winProps == null){
		winProps = 'height=800px,width=700px,directories=false,location=false,top=100,left=500,menubar=false,Resizable=yes,scrollbars=yes,toolbar=false';
	}
	window.open(winUrl, winName, winProps);
}
</script>
</html>
