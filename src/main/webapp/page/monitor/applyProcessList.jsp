<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<form id="pagerForm" method="post" action="applyProcess.do">
	<input type="hidden" name="pageNum" value="1" /> <input type="hidden" name="numPerPage" value="${pageDesc.pageSize}" /> <input type="hidden" name="orderField"
		value="${s_orderField}" />
</form>



<div class="pageHeader">
	<s:form id="pagerForm" onsubmit="return navTabSearch(this);" action="/monitor/applyProcess.do" method="post">
		<div class="searchBar">
			<ul class="searchContent">
				
					<li><label><c:out value="applyProcess.no" />:</label> <s:textfield name="s_no" value="%{#parameters['s_no']}" /></li>
				
				
					<li><label><c:out value="applyProcess.noOrd" />:</label> <s:textfield name="s_noOrd" value="%{#parameters['s_noOrd']}" /></li>
				
					<li><label><c:out value="applyProcess.orgId" />:</label> <s:textfield name="s_orgId" value="%{#parameters['s_orgId']}" /></li>
				
					<li><label><c:out value="applyProcess.internalNo" />:</label> <s:textfield name="s_internalNo" value="%{#parameters['s_internalNo']}" /></li>
				
					<li><label><c:out value="applyProcess.itemId" />:</label> <s:textfield name="s_itemId" value="%{#parameters['s_itemId']}" /></li>
				
					<li><label><c:out value="applyProcess.tacheId" />:</label> <s:textfield name="s_tacheId" value="%{#parameters['s_tacheId']}" /></li>
				
					<li><label><c:out value="applyProcess.tacheName" />:</label> <s:textfield name="s_tacheName" value="%{#parameters['s_tacheName']}" /></li>
				
					<li><label><c:out value="applyProcess.tacheInteNo" />:</label> <s:textfield name="s_tacheInteNo" value="%{#parameters['s_tacheInteNo']}" /></li>
				
					<li><label><c:out value="applyProcess.tachePrevIntNo" />:</label> <s:textfield name="s_tachePrevIntNo" value="%{#parameters['s_tachePrevIntNo']}" /></li>
				
					<li><label><c:out value="applyProcess.department" />:</label> <s:textfield name="s_department" value="%{#parameters['s_department']}" /></li>
				
					<li><label><c:out value="applyProcess.userStaffCode" />:</label> <s:textfield name="s_userStaffCode" value="%{#parameters['s_userStaffCode']}" /></li>
				
					<li><label><c:out value="applyProcess.userName" />:</label> <s:textfield name="s_userName" value="%{#parameters['s_userName']}" /></li>
				
					<li><label><c:out value="applyProcess.status" />:</label> <s:textfield name="s_status" value="%{#parameters['s_status']}" /></li>
				
					<li><label><c:out value="applyProcess.promise" />:</label> <s:textfield name="s_promise" value="%{#parameters['s_promise']}" /></li>
				
					<li><label><c:out value="applyProcess.promiseType" />:</label> <s:textfield name="s_promiseType" value="%{#parameters['s_promiseType']}" /></li>
				
					<li><label><c:out value="applyProcess.promiseStartSign" />:</label> <s:textfield name="s_promiseStartSign" value="%{#parameters['s_promiseStartSign']}" /></li>
				
					<li><label><c:out value="applyProcess.isrisk" />:</label> <s:textfield name="s_isrisk" value="%{#parameters['s_isrisk']}" /></li>
				
					<li><label><c:out value="applyProcess.risktype" />:</label> <s:textfield name="s_risktype" value="%{#parameters['s_risktype']}" /></li>
				
					<li><label><c:out value="applyProcess.riskdescription" />:</label> <s:textfield name="s_riskdescription" value="%{#parameters['s_riskdescription']}" /></li>
				
					<li><label><c:out value="applyProcess.riskresult" />:</label> <s:textfield name="s_riskresult" value="%{#parameters['s_riskresult']}" /></li>
				
					<li><label><c:out value="applyProcess.note" />:</label> <s:textfield name="s_note" value="%{#parameters['s_note']}" /></li>
				
					<li><label><c:out value="applyProcess.attachment" />:</label> <s:textfield name="s_attachment" value="%{#parameters['s_attachment']}" /></li>
				
					<li><label><c:out value="applyProcess.processDate" />:</label> <s:textfield name="s_processDate" value="%{#parameters['s_processDate']}" /></li>
				
					<li><label><c:out value="applyProcess.nodeId" />:</label> <s:textfield name="s_nodeId" value="%{#parameters['s_nodeId']}" /></li>
				
					<li><label><c:out value="applyProcess.nodeAttribute" />:</label> <s:textfield name="s_nodeAttribute" value="%{#parameters['s_nodeAttribute']}" /></li>
				
					<li><label><c:out value="applyProcess.createDate" />:</label> <s:textfield name="s_createDate" value="%{#parameters['s_createDate']}" /></li>
				
					<li><label><c:out value="applyProcess.updateDate" />:</label> <s:textfield name="s_updateDate" value="%{#parameters['s_updateDate']}" /></li>
				
					<li><label><c:out value="applyProcess.syncDate" />:</label> <s:textfield name="s_syncDate" value="%{#parameters['s_syncDate']}" /></li>
				
					<li><label><c:out value="applyProcess.syncSign" />:</label> <s:textfield name="s_syncSign" value="%{#parameters['s_syncSign']}" /></li>
				
					<li><label><c:out value="applyProcess.syncErrorDesc" />:</label> <s:textfield name="s_syncErrorDesc" value="%{#parameters['s_syncErrorDesc']}" /></li>
				
			</ul>
			<div class="subBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<s:submit method="list"><bean:message key="opt.btn.query" /></s:submit>
							</div>
						</div>
					</li>
					<li>
						<div class="buttonActive">
							<div class="buttonContent">
								<!-- 参数 navTabId 根据实际情况填写 -->
								<button type="button" onclick="javascript:navTabAjaxDone({'statusCode' : 200, 'callbackType' : 'closeCurrent', 'navTabId' : ''});">返回</button>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</s:form>
</div>

<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="${contextPath }/monitor/applyProcess!edit.do" rel="" target='dialog'><span>添加</span></a></li>
			<li><a class="edit" href="${contextPath }/monitor/applyProcess!edit.do?no={pk}" warn="请选择一条记录" rel="" target='dialog'><span>编辑</span></a></li>
			<li><a class="delete" href="${contextPath }/monitor/applyProcess!delete.do?no={pk}" warn="请选择一条记录" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</ul>
	</div>

	<div layoutH="116">
		<table class="list" width="98%" targetType="navTab" asc="asc" desc="desc">
			<thead align="center">

				<tr>
					
						<c:set var="tno"><bean:message bundle='monitorRes' key='applyProcess.no' /></c:set>	
						<th>${tno}</th>
					
					
						<c:set var="tnoOrd"><bean:message bundle='monitorRes' key='applyProcess.noOrd' /></c:set>	
						<th>${tnoOrd}</th>
					
						<c:set var="torgId"><bean:message bundle='monitorRes' key='applyProcess.orgId' /></c:set>	
						<th>${torgId}</th>
					
						<c:set var="tinternalNo"><bean:message bundle='monitorRes' key='applyProcess.internalNo' /></c:set>	
						<th>${tinternalNo}</th>
					
						<c:set var="titemId"><bean:message bundle='monitorRes' key='applyProcess.itemId' /></c:set>	
						<th>${titemId}</th>
					
						<c:set var="ttacheId"><bean:message bundle='monitorRes' key='applyProcess.tacheId' /></c:set>	
						<th>${ttacheId}</th>
					
						<c:set var="ttacheName"><bean:message bundle='monitorRes' key='applyProcess.tacheName' /></c:set>	
						<th>${ttacheName}</th>
					
						<c:set var="ttacheInteNo"><bean:message bundle='monitorRes' key='applyProcess.tacheInteNo' /></c:set>	
						<th>${ttacheInteNo}</th>
					
						<c:set var="ttachePrevIntNo"><bean:message bundle='monitorRes' key='applyProcess.tachePrevIntNo' /></c:set>	
						<th>${ttachePrevIntNo}</th>
					
						<c:set var="tdepartment"><bean:message bundle='monitorRes' key='applyProcess.department' /></c:set>	
						<th>${tdepartment}</th>
					
						<c:set var="tuserStaffCode"><bean:message bundle='monitorRes' key='applyProcess.userStaffCode' /></c:set>	
						<th>${tuserStaffCode}</th>
					
						<c:set var="tuserName"><bean:message bundle='monitorRes' key='applyProcess.userName' /></c:set>	
						<th>${tuserName}</th>
					
						<c:set var="tstatus"><bean:message bundle='monitorRes' key='applyProcess.status' /></c:set>	
						<th>${tstatus}</th>
					
						<c:set var="tpromise"><bean:message bundle='monitorRes' key='applyProcess.promise' /></c:set>	
						<th>${tpromise}</th>
					
						<c:set var="tpromiseType"><bean:message bundle='monitorRes' key='applyProcess.promiseType' /></c:set>	
						<th>${tpromiseType}</th>
					
						<c:set var="tpromiseStartSign"><bean:message bundle='monitorRes' key='applyProcess.promiseStartSign' /></c:set>	
						<th>${tpromiseStartSign}</th>
					
						<c:set var="tisrisk"><bean:message bundle='monitorRes' key='applyProcess.isrisk' /></c:set>	
						<th>${tisrisk}</th>
					
						<c:set var="trisktype"><bean:message bundle='monitorRes' key='applyProcess.risktype' /></c:set>	
						<th>${trisktype}</th>
					
						<c:set var="triskdescription"><bean:message bundle='monitorRes' key='applyProcess.riskdescription' /></c:set>	
						<th>${triskdescription}</th>
					
						<c:set var="triskresult"><bean:message bundle='monitorRes' key='applyProcess.riskresult' /></c:set>	
						<th>${triskresult}</th>
					
						<c:set var="tnote"><bean:message bundle='monitorRes' key='applyProcess.note' /></c:set>	
						<th>${tnote}</th>
					
						<c:set var="tattachment"><bean:message bundle='monitorRes' key='applyProcess.attachment' /></c:set>	
						<th>${tattachment}</th>
					
						<c:set var="tprocessDate"><bean:message bundle='monitorRes' key='applyProcess.processDate' /></c:set>	
						<th>${tprocessDate}</th>
					
						<c:set var="tnodeId"><bean:message bundle='monitorRes' key='applyProcess.nodeId' /></c:set>	
						<th>${tnodeId}</th>
					
						<c:set var="tnodeAttribute"><bean:message bundle='monitorRes' key='applyProcess.nodeAttribute' /></c:set>	
						<th>${tnodeAttribute}</th>
					
						<c:set var="tcreateDate"><bean:message bundle='monitorRes' key='applyProcess.createDate' /></c:set>	
						<th>${tcreateDate}</th>
					
						<c:set var="tupdateDate"><bean:message bundle='monitorRes' key='applyProcess.updateDate' /></c:set>	
						<th>${tupdateDate}</th>
					
						<c:set var="tsyncDate"><bean:message bundle='monitorRes' key='applyProcess.syncDate' /></c:set>	
						<th>${tsyncDate}</th>
					
						<c:set var="tsyncSign"><bean:message bundle='monitorRes' key='applyProcess.syncSign' /></c:set>	
						<th>${tsyncSign}</th>
					
						<c:set var="tsyncErrorDesc"><bean:message bundle='monitorRes' key='applyProcess.syncErrorDesc' /></c:set>	
						<th>${tsyncErrorDesc}</th>
					
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach items="${objList }" var="applyProcess">
						<tr target="pk" rel="${applyProcess.no}">
							
								<td>${applyProcess.no}</td>
							
							
								<td>${applyProcess.noOrd}</td>
							
								<td>${applyProcess.orgId}</td>
							
								<td>${applyProcess.internalNo}</td>
							
								<td>${applyProcess.itemId}</td>
							
								<td>${applyProcess.tacheId}</td>
							
								<td>${applyProcess.tacheName}</td>
							
								<td>${applyProcess.tacheInteNo}</td>
							
								<td>${applyProcess.tachePrevIntNo}</td>
							
								<td>${applyProcess.department}</td>
							
								<td>${applyProcess.userStaffCode}</td>
							
								<td>${applyProcess.userName}</td>
							
								<td>${applyProcess.status}</td>
							
								<td>${applyProcess.promise}</td>
							
								<td>${applyProcess.promiseType}</td>
							
								<td>${applyProcess.promiseStartSign}</td>
							
								<td>${applyProcess.isrisk}</td>
							
								<td>${applyProcess.risktype}</td>
							
								<td>${applyProcess.riskdescription}</td>
							
								<td>${applyProcess.riskresult}</td>
							
								<td>${applyProcess.note}</td>
							
								<td>${applyProcess.attachment}</td>
							
								<td>${applyProcess.processDate}</td>
							
								<td>${applyProcess.nodeId}</td>
							
								<td>${applyProcess.nodeAttribute}</td>
							
								<td>${applyProcess.createDate}</td>
							
								<td>${applyProcess.updateDate}</td>
							
								<td>${applyProcess.syncDate}</td>
							
								<td>${applyProcess.syncSign}</td>
							
								<td>${applyProcess.syncErrorDesc}</td>
							
						</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<jsp:include page="../common/panelBar.jsp"></jsp:include>

<%-- 
<html>
	<head>
		<title><c:out value="applyProcess.list.title" /></title>
		<link href="<c:out value='${STYLE_PATH}'/>/css/am.css" type="text/css"
			rel="stylesheet">
		<link href="<c:out value='${STYLE_PATH}'/>/css/extremecomponents.css"
			type="text/css" rel="stylesheet">
		<link href="<c:out value='${STYLE_PATH}'/>/css/messages.css"
			type="text/css" rel="stylesheet">
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset
			style="border: hidden 1px #000000; ">
			<legend>
				 <s:text name="label.list.filter" />
			</legend>
			<html:form action="/monitor/applyProcess.do" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr height="22">
						<td><c:out value="applyProcess.no" />:</td>
						<td><html:text property="s_no" /> </td>
					</tr>	


					<tr height="22">
						<td><c:out value="applyProcess.noOrd" />:</td>
						<td><html:text property="s_noOrd" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyProcess.orgId" />:</td>
						<td><html:text property="s_orgId" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyProcess.internalNo" />:</td>
						<td><html:text property="s_internalNo" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyProcess.itemId" />:</td>
						<td><html:text property="s_itemId" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyProcess.tacheId" />:</td>
						<td><html:text property="s_tacheId" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyProcess.tacheName" />:</td>
						<td><html:text property="s_tacheName" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyProcess.tacheInteNo" />:</td>
						<td><html:text property="s_tacheInteNo" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyProcess.tachePrevIntNo" />:</td>
						<td><html:text property="s_tachePrevIntNo" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyProcess.department" />:</td>
						<td><html:text property="s_department" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyProcess.userStaffCode" />:</td>
						<td><html:text property="s_userStaffCode" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyProcess.userName" />:</td>
						<td><html:text property="s_userName" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyProcess.status" />:</td>
						<td><html:text property="s_status" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyProcess.promise" />:</td>
						<td><html:text property="s_promise" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyProcess.promiseType" />:</td>
						<td><html:text property="s_promiseType" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyProcess.promiseStartSign" />:</td>
						<td><html:text property="s_promiseStartSign" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyProcess.isrisk" />:</td>
						<td><html:text property="s_isrisk" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyProcess.risktype" />:</td>
						<td><html:text property="s_risktype" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyProcess.riskdescription" />:</td>
						<td><html:text property="s_riskdescription" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyProcess.riskresult" />:</td>
						<td><html:text property="s_riskresult" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyProcess.note" />:</td>
						<td><html:text property="s_note" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyProcess.attachment" />:</td>
						<td><html:text property="s_attachment" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyProcess.processDate" />:</td>
						<td><html:text property="s_processDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyProcess.nodeId" />:</td>
						<td><html:text property="s_nodeId" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyProcess.nodeAttribute" />:</td>
						<td><html:text property="s_nodeAttribute" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyProcess.createDate" />:</td>
						<td><html:text property="s_createDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyProcess.updateDate" />:</td>
						<td><html:text property="s_updateDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyProcess.syncDate" />:</td>
						<td><html:text property="s_syncDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyProcess.syncSign" />:</td>
						<td><html:text property="s_syncSign" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyProcess.syncErrorDesc" />:</td>
						<td><html:text property="s_syncErrorDesc" /> </td>
					</tr>	

					<tr>
						<td>
							<html:submit property="method_list" styleClass="btn" > <bean:message key="opt.btn.query" /></html:submit>
						</td>
						<td>
							<html:submit property="method_edit" styleClass="btn" > <bean:message key="opt.btn.new" /> </html:submit>
						</td>
					</tr>
				</table>
			</html:form>
		</fieldset>

			<ec:table action="applyProcess.do" items="applyProcesss" var="applyProcess"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="applyProcesss.xls" ></ec:exportXls>
			<ec:exportPdf fileName="applyProcesss.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>
				
					<c:set var="tno"><bean:message bundle='monitorRes' key='applyProcess.no' /></c:set>	
					<ec:column property="no" title="${tno}" style="text-align:center" />
				
				
					<c:set var="tnoOrd"><bean:message bundle='monitorRes' key='applyProcess.noOrd' /></c:set>	
					<ec:column property="noOrd" title="${tnoOrd}" style="text-align:center" />
				
					<c:set var="torgId"><bean:message bundle='monitorRes' key='applyProcess.orgId' /></c:set>	
					<ec:column property="orgId" title="${torgId}" style="text-align:center" />
				
					<c:set var="tinternalNo"><bean:message bundle='monitorRes' key='applyProcess.internalNo' /></c:set>	
					<ec:column property="internalNo" title="${tinternalNo}" style="text-align:center" />
				
					<c:set var="titemId"><bean:message bundle='monitorRes' key='applyProcess.itemId' /></c:set>	
					<ec:column property="itemId" title="${titemId}" style="text-align:center" />
				
					<c:set var="ttacheId"><bean:message bundle='monitorRes' key='applyProcess.tacheId' /></c:set>	
					<ec:column property="tacheId" title="${ttacheId}" style="text-align:center" />
				
					<c:set var="ttacheName"><bean:message bundle='monitorRes' key='applyProcess.tacheName' /></c:set>	
					<ec:column property="tacheName" title="${ttacheName}" style="text-align:center" />
				
					<c:set var="ttacheInteNo"><bean:message bundle='monitorRes' key='applyProcess.tacheInteNo' /></c:set>	
					<ec:column property="tacheInteNo" title="${ttacheInteNo}" style="text-align:center" />
				
					<c:set var="ttachePrevIntNo"><bean:message bundle='monitorRes' key='applyProcess.tachePrevIntNo' /></c:set>	
					<ec:column property="tachePrevIntNo" title="${ttachePrevIntNo}" style="text-align:center" />
				
					<c:set var="tdepartment"><bean:message bundle='monitorRes' key='applyProcess.department' /></c:set>	
					<ec:column property="department" title="${tdepartment}" style="text-align:center" />
				
					<c:set var="tuserStaffCode"><bean:message bundle='monitorRes' key='applyProcess.userStaffCode' /></c:set>	
					<ec:column property="userStaffCode" title="${tuserStaffCode}" style="text-align:center" />
				
					<c:set var="tuserName"><bean:message bundle='monitorRes' key='applyProcess.userName' /></c:set>	
					<ec:column property="userName" title="${tuserName}" style="text-align:center" />
				
					<c:set var="tstatus"><bean:message bundle='monitorRes' key='applyProcess.status' /></c:set>	
					<ec:column property="status" title="${tstatus}" style="text-align:center" />
				
					<c:set var="tpromise"><bean:message bundle='monitorRes' key='applyProcess.promise' /></c:set>	
					<ec:column property="promise" title="${tpromise}" style="text-align:center" />
				
					<c:set var="tpromiseType"><bean:message bundle='monitorRes' key='applyProcess.promiseType' /></c:set>	
					<ec:column property="promiseType" title="${tpromiseType}" style="text-align:center" />
				
					<c:set var="tpromiseStartSign"><bean:message bundle='monitorRes' key='applyProcess.promiseStartSign' /></c:set>	
					<ec:column property="promiseStartSign" title="${tpromiseStartSign}" style="text-align:center" />
				
					<c:set var="tisrisk"><bean:message bundle='monitorRes' key='applyProcess.isrisk' /></c:set>	
					<ec:column property="isrisk" title="${tisrisk}" style="text-align:center" />
				
					<c:set var="trisktype"><bean:message bundle='monitorRes' key='applyProcess.risktype' /></c:set>	
					<ec:column property="risktype" title="${trisktype}" style="text-align:center" />
				
					<c:set var="triskdescription"><bean:message bundle='monitorRes' key='applyProcess.riskdescription' /></c:set>	
					<ec:column property="riskdescription" title="${triskdescription}" style="text-align:center" />
				
					<c:set var="triskresult"><bean:message bundle='monitorRes' key='applyProcess.riskresult' /></c:set>	
					<ec:column property="riskresult" title="${triskresult}" style="text-align:center" />
				
					<c:set var="tnote"><bean:message bundle='monitorRes' key='applyProcess.note' /></c:set>	
					<ec:column property="note" title="${tnote}" style="text-align:center" />
				
					<c:set var="tattachment"><bean:message bundle='monitorRes' key='applyProcess.attachment' /></c:set>	
					<ec:column property="attachment" title="${tattachment}" style="text-align:center" />
				
					<c:set var="tprocessDate"><bean:message bundle='monitorRes' key='applyProcess.processDate' /></c:set>	
					<ec:column property="processDate" title="${tprocessDate}" style="text-align:center" />
				
					<c:set var="tnodeId"><bean:message bundle='monitorRes' key='applyProcess.nodeId' /></c:set>	
					<ec:column property="nodeId" title="${tnodeId}" style="text-align:center" />
				
					<c:set var="tnodeAttribute"><bean:message bundle='monitorRes' key='applyProcess.nodeAttribute' /></c:set>	
					<ec:column property="nodeAttribute" title="${tnodeAttribute}" style="text-align:center" />
				
					<c:set var="tcreateDate"><bean:message bundle='monitorRes' key='applyProcess.createDate' /></c:set>	
					<ec:column property="createDate" title="${tcreateDate}" style="text-align:center" />
				
					<c:set var="tupdateDate"><bean:message bundle='monitorRes' key='applyProcess.updateDate' /></c:set>	
					<ec:column property="updateDate" title="${tupdateDate}" style="text-align:center" />
				
					<c:set var="tsyncDate"><bean:message bundle='monitorRes' key='applyProcess.syncDate' /></c:set>	
					<ec:column property="syncDate" title="${tsyncDate}" style="text-align:center" />
				
					<c:set var="tsyncSign"><bean:message bundle='monitorRes' key='applyProcess.syncSign' /></c:set>	
					<ec:column property="syncSign" title="${tsyncSign}" style="text-align:center" />
				
					<c:set var="tsyncErrorDesc"><bean:message bundle='monitorRes' key='applyProcess.syncErrorDesc' /></c:set>	
					<ec:column property="syncErrorDesc" title="${tsyncErrorDesc}" style="text-align:center" />
						
				<c:set var="optlabel"><bean:message key="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><bean:message key="label.delete.confirm"/></c:set>
					<a href='applyProcess.do?no=${applyProcess.no}&method=view'><bean:message key="opt.btn.view" /></a>
					<a href='applyProcess.do?no=${applyProcess.no}&method=edit'><bean:message key="opt.btn.edit" /></a>
					<a href='applyProcess.do?no=${applyProcess.no}&method=delete' 
							onclick='return confirm("${deletecofirm}applyProcess?");'><bean:message key="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
 --%>