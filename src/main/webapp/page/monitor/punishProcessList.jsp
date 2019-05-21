<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<form id="pagerForm" method="post" action="punishProcess.do">
	<input type="hidden" name="pageNum" value="1" /> <input type="hidden" name="numPerPage" value="${pageDesc.pageSize}" /> <input type="hidden" name="orderField"
		value="${s_orderField}" />
</form>



<div class="pageHeader">
	<s:form id="pagerForm" onsubmit="return navTabSearch(this);" action="/monitor/punishProcess.do" method="post">
		<div class="searchBar">
			<ul class="searchContent">
				
					<li><label><c:out value="punishProcess.no" />:</label> <s:textfield name="s_no" value="%{#parameters['s_no']}" /></li>
				
				
					<li><label><c:out value="punishProcess.noOrd" />:</label> <s:textfield name="s_noOrd" value="%{#parameters['s_noOrd']}" /></li>
				
					<li><label><c:out value="punishProcess.orgId" />:</label> <s:textfield name="s_orgId" value="%{#parameters['s_orgId']}" /></li>
				
					<li><label><c:out value="punishProcess.internalNo" />:</label> <s:textfield name="s_internalNo" value="%{#parameters['s_internalNo']}" /></li>
				
					<li><label><c:out value="punishProcess.itemId" />:</label> <s:textfield name="s_itemId" value="%{#parameters['s_itemId']}" /></li>
				
					<li><label><c:out value="punishProcess.tacheId" />:</label> <s:textfield name="s_tacheId" value="%{#parameters['s_tacheId']}" /></li>
				
					<li><label><c:out value="punishProcess.tacheName" />:</label> <s:textfield name="s_tacheName" value="%{#parameters['s_tacheName']}" /></li>
				
					<li><label><c:out value="punishProcess.tacheInteNo" />:</label> <s:textfield name="s_tacheInteNo" value="%{#parameters['s_tacheInteNo']}" /></li>
				
					<li><label><c:out value="punishProcess.tachePrevIntNo" />:</label> <s:textfield name="s_tachePrevIntNo" value="%{#parameters['s_tachePrevIntNo']}" /></li>
				
					<li><label><c:out value="punishProcess.department" />:</label> <s:textfield name="s_department" value="%{#parameters['s_department']}" /></li>
				
					<li><label><c:out value="punishProcess.userName" />:</label> <s:textfield name="s_userName" value="%{#parameters['s_userName']}" /></li>
				
					<li><label><c:out value="punishProcess.status" />:</label> <s:textfield name="s_status" value="%{#parameters['s_status']}" /></li>
				
					<li><label><c:out value="punishProcess.promise" />:</label> <s:textfield name="s_promise" value="%{#parameters['s_promise']}" /></li>
				
					<li><label><c:out value="punishProcess.promiseType" />:</label> <s:textfield name="s_promiseType" value="%{#parameters['s_promiseType']}" /></li>
				
					<li><label><c:out value="punishProcess.promiseStartSign" />:</label> <s:textfield name="s_promiseStartSign" value="%{#parameters['s_promiseStartSign']}" /></li>
				
					<li><label><c:out value="punishProcess.isrisk" />:</label> <s:textfield name="s_isrisk" value="%{#parameters['s_isrisk']}" /></li>
				
					<li><label><c:out value="punishProcess.risktype" />:</label> <s:textfield name="s_risktype" value="%{#parameters['s_risktype']}" /></li>
				
					<li><label><c:out value="punishProcess.riskdescription" />:</label> <s:textfield name="s_riskdescription" value="%{#parameters['s_riskdescription']}" /></li>
				
					<li><label><c:out value="punishProcess.riskresult" />:</label> <s:textfield name="s_riskresult" value="%{#parameters['s_riskresult']}" /></li>
				
					<li><label><c:out value="punishProcess.note" />:</label> <s:textfield name="s_note" value="%{#parameters['s_note']}" /></li>
				
					<li><label><c:out value="punishProcess.attachment" />:</label> <s:textfield name="s_attachment" value="%{#parameters['s_attachment']}" /></li>
				
					<li><label><c:out value="punishProcess.evidence" />:</label> <s:textfield name="s_evidence" value="%{#parameters['s_evidence']}" /></li>
				
					<li><label><c:out value="punishProcess.processDate" />:</label> <s:textfield name="s_processDate" value="%{#parameters['s_processDate']}" /></li>
				
					<li><label><c:out value="punishProcess.nodeId" />:</label> <s:textfield name="s_nodeId" value="%{#parameters['s_nodeId']}" /></li>
				
					<li><label><c:out value="punishProcess.nodeAttribute" />:</label> <s:textfield name="s_nodeAttribute" value="%{#parameters['s_nodeAttribute']}" /></li>
				
					<li><label><c:out value="punishProcess.createDate" />:</label> <s:textfield name="s_createDate" value="%{#parameters['s_createDate']}" /></li>
				
					<li><label><c:out value="punishProcess.updateDate" />:</label> <s:textfield name="s_updateDate" value="%{#parameters['s_updateDate']}" /></li>
				
					<li><label><c:out value="punishProcess.syncDate" />:</label> <s:textfield name="s_syncDate" value="%{#parameters['s_syncDate']}" /></li>
				
					<li><label><c:out value="punishProcess.syncSign" />:</label> <s:textfield name="s_syncSign" value="%{#parameters['s_syncSign']}" /></li>
				
					<li><label><c:out value="punishProcess.syncErrorDesc" />:</label> <s:textfield name="s_syncErrorDesc" value="%{#parameters['s_syncErrorDesc']}" /></li>
				
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
			<li><a class="add" href="${contextPath }/monitor/punishProcess!edit.do" rel="" target='dialog'><span>添加</span></a></li>
			<li><a class="edit" href="${contextPath }/monitor/punishProcess!edit.do?no={pk}" warn="请选择一条记录" rel="" target='dialog'><span>编辑</span></a></li>
			<li><a class="delete" href="${contextPath }/monitor/punishProcess!delete.do?no={pk}" warn="请选择一条记录" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</ul>
	</div>

	<div layoutH="116">
		<table class="list" width="98%" targetType="navTab" asc="asc" desc="desc">
			<thead align="center">

				<tr>
					
						<c:set var="tno"><bean:message bundle='monitorRes' key='punishProcess.no' /></c:set>	
						<th>${tno}</th>
					
					
						<c:set var="tnoOrd"><bean:message bundle='monitorRes' key='punishProcess.noOrd' /></c:set>	
						<th>${tnoOrd}</th>
					
						<c:set var="torgId"><bean:message bundle='monitorRes' key='punishProcess.orgId' /></c:set>	
						<th>${torgId}</th>
					
						<c:set var="tinternalNo"><bean:message bundle='monitorRes' key='punishProcess.internalNo' /></c:set>	
						<th>${tinternalNo}</th>
					
						<c:set var="titemId"><bean:message bundle='monitorRes' key='punishProcess.itemId' /></c:set>	
						<th>${titemId}</th>
					
						<c:set var="ttacheId"><bean:message bundle='monitorRes' key='punishProcess.tacheId' /></c:set>	
						<th>${ttacheId}</th>
					
						<c:set var="ttacheName"><bean:message bundle='monitorRes' key='punishProcess.tacheName' /></c:set>	
						<th>${ttacheName}</th>
					
						<c:set var="ttacheInteNo"><bean:message bundle='monitorRes' key='punishProcess.tacheInteNo' /></c:set>	
						<th>${ttacheInteNo}</th>
					
						<c:set var="ttachePrevIntNo"><bean:message bundle='monitorRes' key='punishProcess.tachePrevIntNo' /></c:set>	
						<th>${ttachePrevIntNo}</th>
					
						<c:set var="tdepartment"><bean:message bundle='monitorRes' key='punishProcess.department' /></c:set>	
						<th>${tdepartment}</th>
					
						<c:set var="tuserName"><bean:message bundle='monitorRes' key='punishProcess.userName' /></c:set>	
						<th>${tuserName}</th>
					
						<c:set var="tstatus"><bean:message bundle='monitorRes' key='punishProcess.status' /></c:set>	
						<th>${tstatus}</th>
					
						<c:set var="tpromise"><bean:message bundle='monitorRes' key='punishProcess.promise' /></c:set>	
						<th>${tpromise}</th>
					
						<c:set var="tpromiseType"><bean:message bundle='monitorRes' key='punishProcess.promiseType' /></c:set>	
						<th>${tpromiseType}</th>
					
						<c:set var="tpromiseStartSign"><bean:message bundle='monitorRes' key='punishProcess.promiseStartSign' /></c:set>	
						<th>${tpromiseStartSign}</th>
					
						<c:set var="tisrisk"><bean:message bundle='monitorRes' key='punishProcess.isrisk' /></c:set>	
						<th>${tisrisk}</th>
					
						<c:set var="trisktype"><bean:message bundle='monitorRes' key='punishProcess.risktype' /></c:set>	
						<th>${trisktype}</th>
					
						<c:set var="triskdescription"><bean:message bundle='monitorRes' key='punishProcess.riskdescription' /></c:set>	
						<th>${triskdescription}</th>
					
						<c:set var="triskresult"><bean:message bundle='monitorRes' key='punishProcess.riskresult' /></c:set>	
						<th>${triskresult}</th>
					
						<c:set var="tnote"><bean:message bundle='monitorRes' key='punishProcess.note' /></c:set>	
						<th>${tnote}</th>
					
						<c:set var="tattachment"><bean:message bundle='monitorRes' key='punishProcess.attachment' /></c:set>	
						<th>${tattachment}</th>
					
						<c:set var="tevidence"><bean:message bundle='monitorRes' key='punishProcess.evidence' /></c:set>	
						<th>${tevidence}</th>
					
						<c:set var="tprocessDate"><bean:message bundle='monitorRes' key='punishProcess.processDate' /></c:set>	
						<th>${tprocessDate}</th>
					
						<c:set var="tnodeId"><bean:message bundle='monitorRes' key='punishProcess.nodeId' /></c:set>	
						<th>${tnodeId}</th>
					
						<c:set var="tnodeAttribute"><bean:message bundle='monitorRes' key='punishProcess.nodeAttribute' /></c:set>	
						<th>${tnodeAttribute}</th>
					
						<c:set var="tcreateDate"><bean:message bundle='monitorRes' key='punishProcess.createDate' /></c:set>	
						<th>${tcreateDate}</th>
					
						<c:set var="tupdateDate"><bean:message bundle='monitorRes' key='punishProcess.updateDate' /></c:set>	
						<th>${tupdateDate}</th>
					
						<c:set var="tsyncDate"><bean:message bundle='monitorRes' key='punishProcess.syncDate' /></c:set>	
						<th>${tsyncDate}</th>
					
						<c:set var="tsyncSign"><bean:message bundle='monitorRes' key='punishProcess.syncSign' /></c:set>	
						<th>${tsyncSign}</th>
					
						<c:set var="tsyncErrorDesc"><bean:message bundle='monitorRes' key='punishProcess.syncErrorDesc' /></c:set>	
						<th>${tsyncErrorDesc}</th>
					
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach items="${objList }" var="punishProcess">
						<tr target="pk" rel="${punishProcess.no}">
							
								<td>${punishProcess.no}</td>
							
							
								<td>${punishProcess.noOrd}</td>
							
								<td>${punishProcess.orgId}</td>
							
								<td>${punishProcess.internalNo}</td>
							
								<td>${punishProcess.itemId}</td>
							
								<td>${punishProcess.tacheId}</td>
							
								<td>${punishProcess.tacheName}</td>
							
								<td>${punishProcess.tacheInteNo}</td>
							
								<td>${punishProcess.tachePrevIntNo}</td>
							
								<td>${punishProcess.department}</td>
							
								<td>${punishProcess.userName}</td>
							
								<td>${punishProcess.status}</td>
							
								<td>${punishProcess.promise}</td>
							
								<td>${punishProcess.promiseType}</td>
							
								<td>${punishProcess.promiseStartSign}</td>
							
								<td>${punishProcess.isrisk}</td>
							
								<td>${punishProcess.risktype}</td>
							
								<td>${punishProcess.riskdescription}</td>
							
								<td>${punishProcess.riskresult}</td>
							
								<td>${punishProcess.note}</td>
							
								<td>${punishProcess.attachment}</td>
							
								<td>${punishProcess.evidence}</td>
							
								<td>${punishProcess.processDate}</td>
							
								<td>${punishProcess.nodeId}</td>
							
								<td>${punishProcess.nodeAttribute}</td>
							
								<td>${punishProcess.createDate}</td>
							
								<td>${punishProcess.updateDate}</td>
							
								<td>${punishProcess.syncDate}</td>
							
								<td>${punishProcess.syncSign}</td>
							
								<td>${punishProcess.syncErrorDesc}</td>
							
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
		<title><c:out value="punishProcess.list.title" /></title>
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
			<html:form action="/monitor/punishProcess.do" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr height="22">
						<td><c:out value="punishProcess.no" />:</td>
						<td><html:text property="s_no" /> </td>
					</tr>	


					<tr height="22">
						<td><c:out value="punishProcess.noOrd" />:</td>
						<td><html:text property="s_noOrd" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishProcess.orgId" />:</td>
						<td><html:text property="s_orgId" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishProcess.internalNo" />:</td>
						<td><html:text property="s_internalNo" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishProcess.itemId" />:</td>
						<td><html:text property="s_itemId" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishProcess.tacheId" />:</td>
						<td><html:text property="s_tacheId" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishProcess.tacheName" />:</td>
						<td><html:text property="s_tacheName" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishProcess.tacheInteNo" />:</td>
						<td><html:text property="s_tacheInteNo" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishProcess.tachePrevIntNo" />:</td>
						<td><html:text property="s_tachePrevIntNo" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishProcess.department" />:</td>
						<td><html:text property="s_department" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishProcess.userName" />:</td>
						<td><html:text property="s_userName" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishProcess.status" />:</td>
						<td><html:text property="s_status" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishProcess.promise" />:</td>
						<td><html:text property="s_promise" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishProcess.promiseType" />:</td>
						<td><html:text property="s_promiseType" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishProcess.promiseStartSign" />:</td>
						<td><html:text property="s_promiseStartSign" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishProcess.isrisk" />:</td>
						<td><html:text property="s_isrisk" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishProcess.risktype" />:</td>
						<td><html:text property="s_risktype" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishProcess.riskdescription" />:</td>
						<td><html:text property="s_riskdescription" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishProcess.riskresult" />:</td>
						<td><html:text property="s_riskresult" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishProcess.note" />:</td>
						<td><html:text property="s_note" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishProcess.attachment" />:</td>
						<td><html:text property="s_attachment" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishProcess.evidence" />:</td>
						<td><html:text property="s_evidence" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishProcess.processDate" />:</td>
						<td><html:text property="s_processDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishProcess.nodeId" />:</td>
						<td><html:text property="s_nodeId" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishProcess.nodeAttribute" />:</td>
						<td><html:text property="s_nodeAttribute" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishProcess.createDate" />:</td>
						<td><html:text property="s_createDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishProcess.updateDate" />:</td>
						<td><html:text property="s_updateDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishProcess.syncDate" />:</td>
						<td><html:text property="s_syncDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishProcess.syncSign" />:</td>
						<td><html:text property="s_syncSign" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishProcess.syncErrorDesc" />:</td>
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

			<ec:table action="punishProcess.do" items="punishProcesss" var="punishProcess"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="punishProcesss.xls" ></ec:exportXls>
			<ec:exportPdf fileName="punishProcesss.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>
				
					<c:set var="tno"><bean:message bundle='monitorRes' key='punishProcess.no' /></c:set>	
					<ec:column property="no" title="${tno}" style="text-align:center" />
				
				
					<c:set var="tnoOrd"><bean:message bundle='monitorRes' key='punishProcess.noOrd' /></c:set>	
					<ec:column property="noOrd" title="${tnoOrd}" style="text-align:center" />
				
					<c:set var="torgId"><bean:message bundle='monitorRes' key='punishProcess.orgId' /></c:set>	
					<ec:column property="orgId" title="${torgId}" style="text-align:center" />
				
					<c:set var="tinternalNo"><bean:message bundle='monitorRes' key='punishProcess.internalNo' /></c:set>	
					<ec:column property="internalNo" title="${tinternalNo}" style="text-align:center" />
				
					<c:set var="titemId"><bean:message bundle='monitorRes' key='punishProcess.itemId' /></c:set>	
					<ec:column property="itemId" title="${titemId}" style="text-align:center" />
				
					<c:set var="ttacheId"><bean:message bundle='monitorRes' key='punishProcess.tacheId' /></c:set>	
					<ec:column property="tacheId" title="${ttacheId}" style="text-align:center" />
				
					<c:set var="ttacheName"><bean:message bundle='monitorRes' key='punishProcess.tacheName' /></c:set>	
					<ec:column property="tacheName" title="${ttacheName}" style="text-align:center" />
				
					<c:set var="ttacheInteNo"><bean:message bundle='monitorRes' key='punishProcess.tacheInteNo' /></c:set>	
					<ec:column property="tacheInteNo" title="${ttacheInteNo}" style="text-align:center" />
				
					<c:set var="ttachePrevIntNo"><bean:message bundle='monitorRes' key='punishProcess.tachePrevIntNo' /></c:set>	
					<ec:column property="tachePrevIntNo" title="${ttachePrevIntNo}" style="text-align:center" />
				
					<c:set var="tdepartment"><bean:message bundle='monitorRes' key='punishProcess.department' /></c:set>	
					<ec:column property="department" title="${tdepartment}" style="text-align:center" />
				
					<c:set var="tuserName"><bean:message bundle='monitorRes' key='punishProcess.userName' /></c:set>	
					<ec:column property="userName" title="${tuserName}" style="text-align:center" />
				
					<c:set var="tstatus"><bean:message bundle='monitorRes' key='punishProcess.status' /></c:set>	
					<ec:column property="status" title="${tstatus}" style="text-align:center" />
				
					<c:set var="tpromise"><bean:message bundle='monitorRes' key='punishProcess.promise' /></c:set>	
					<ec:column property="promise" title="${tpromise}" style="text-align:center" />
				
					<c:set var="tpromiseType"><bean:message bundle='monitorRes' key='punishProcess.promiseType' /></c:set>	
					<ec:column property="promiseType" title="${tpromiseType}" style="text-align:center" />
				
					<c:set var="tpromiseStartSign"><bean:message bundle='monitorRes' key='punishProcess.promiseStartSign' /></c:set>	
					<ec:column property="promiseStartSign" title="${tpromiseStartSign}" style="text-align:center" />
				
					<c:set var="tisrisk"><bean:message bundle='monitorRes' key='punishProcess.isrisk' /></c:set>	
					<ec:column property="isrisk" title="${tisrisk}" style="text-align:center" />
				
					<c:set var="trisktype"><bean:message bundle='monitorRes' key='punishProcess.risktype' /></c:set>	
					<ec:column property="risktype" title="${trisktype}" style="text-align:center" />
				
					<c:set var="triskdescription"><bean:message bundle='monitorRes' key='punishProcess.riskdescription' /></c:set>	
					<ec:column property="riskdescription" title="${triskdescription}" style="text-align:center" />
				
					<c:set var="triskresult"><bean:message bundle='monitorRes' key='punishProcess.riskresult' /></c:set>	
					<ec:column property="riskresult" title="${triskresult}" style="text-align:center" />
				
					<c:set var="tnote"><bean:message bundle='monitorRes' key='punishProcess.note' /></c:set>	
					<ec:column property="note" title="${tnote}" style="text-align:center" />
				
					<c:set var="tattachment"><bean:message bundle='monitorRes' key='punishProcess.attachment' /></c:set>	
					<ec:column property="attachment" title="${tattachment}" style="text-align:center" />
				
					<c:set var="tevidence"><bean:message bundle='monitorRes' key='punishProcess.evidence' /></c:set>	
					<ec:column property="evidence" title="${tevidence}" style="text-align:center" />
				
					<c:set var="tprocessDate"><bean:message bundle='monitorRes' key='punishProcess.processDate' /></c:set>	
					<ec:column property="processDate" title="${tprocessDate}" style="text-align:center" />
				
					<c:set var="tnodeId"><bean:message bundle='monitorRes' key='punishProcess.nodeId' /></c:set>	
					<ec:column property="nodeId" title="${tnodeId}" style="text-align:center" />
				
					<c:set var="tnodeAttribute"><bean:message bundle='monitorRes' key='punishProcess.nodeAttribute' /></c:set>	
					<ec:column property="nodeAttribute" title="${tnodeAttribute}" style="text-align:center" />
				
					<c:set var="tcreateDate"><bean:message bundle='monitorRes' key='punishProcess.createDate' /></c:set>	
					<ec:column property="createDate" title="${tcreateDate}" style="text-align:center" />
				
					<c:set var="tupdateDate"><bean:message bundle='monitorRes' key='punishProcess.updateDate' /></c:set>	
					<ec:column property="updateDate" title="${tupdateDate}" style="text-align:center" />
				
					<c:set var="tsyncDate"><bean:message bundle='monitorRes' key='punishProcess.syncDate' /></c:set>	
					<ec:column property="syncDate" title="${tsyncDate}" style="text-align:center" />
				
					<c:set var="tsyncSign"><bean:message bundle='monitorRes' key='punishProcess.syncSign' /></c:set>	
					<ec:column property="syncSign" title="${tsyncSign}" style="text-align:center" />
				
					<c:set var="tsyncErrorDesc"><bean:message bundle='monitorRes' key='punishProcess.syncErrorDesc' /></c:set>	
					<ec:column property="syncErrorDesc" title="${tsyncErrorDesc}" style="text-align:center" />
						
				<c:set var="optlabel"><bean:message key="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><bean:message key="label.delete.confirm"/></c:set>
					<a href='punishProcess.do?no=${punishProcess.no}&method=view'><bean:message key="opt.btn.view" /></a>
					<a href='punishProcess.do?no=${punishProcess.no}&method=edit'><bean:message key="opt.btn.edit" /></a>
					<a href='punishProcess.do?no=${punishProcess.no}&method=delete' 
							onclick='return confirm("${deletecofirm}punishProcess?");'><bean:message key="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
 --%>