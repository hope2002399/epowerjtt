<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<form id="pagerForm" method="post" action="punishResultLog.do">
	<input type="hidden" name="pageNum" value="1" /> <input type="hidden" name="numPerPage" value="${pageDesc.pageSize}" /> <input type="hidden" name="orderField"
		value="${s_orderField}" />
</form>



<div class="pageHeader">
	<s:form id="pagerForm" onsubmit="return navTabSearch(this);" action="/monitor/punishResultLog.do" method="post">
		<div class="searchBar">
			<ul class="searchContent">
				
					<li><label><c:out value="punishResultLog.no" />:</label> <s:textfield name="s_no" value="%{#parameters['s_no']}" /></li>
				
					<li><label><c:out value="punishResultLog.changNo" />:</label> <s:textfield name="s_changNo" value="%{#parameters['s_changNo']}" /></li>
				
				
					<li><label><c:out value="punishResultLog.orgId" />:</label> <s:textfield name="s_orgId" value="%{#parameters['s_orgId']}" /></li>
				
					<li><label><c:out value="punishResultLog.internalNo" />:</label> <s:textfield name="s_internalNo" value="%{#parameters['s_internalNo']}" /></li>
				
					<li><label><c:out value="punishResultLog.itemId" />:</label> <s:textfield name="s_itemId" value="%{#parameters['s_itemId']}" /></li>
				
					<li><label><c:out value="punishResultLog.program" />:</label> <s:textfield name="s_program" value="%{#parameters['s_program']}" /></li>
				
					<li><label><c:out value="punishResultLog.punishSort" />:</label> <s:textfield name="s_punishSort" value="%{#parameters['s_punishSort']}" /></li>
				
					<li><label><c:out value="punishResultLog.accordance" />:</label> <s:textfield name="s_accordance" value="%{#parameters['s_accordance']}" /></li>
				
					<li><label><c:out value="punishResultLog.standard" />:</label> <s:textfield name="s_standard" value="%{#parameters['s_standard']}" /></li>
				
					<li><label><c:out value="punishResultLog.punishDeside" />:</label> <s:textfield name="s_punishDeside" value="%{#parameters['s_punishDeside']}" /></li>
				
					<li><label><c:out value="punishResultLog.punishClass" />:</label> <s:textfield name="s_punishClass" value="%{#parameters['s_punishClass']}" /></li>
				
					<li><label><c:out value="punishResultLog.punishResult" />:</label> <s:textfield name="s_punishResult" value="%{#parameters['s_punishResult']}" /></li>
				
					<li><label><c:out value="punishResultLog.punishResultFine" />:</label> <s:textfield name="s_punishResultFine" value="%{#parameters['s_punishResultFine']}" /></li>
				
					<li><label><c:out value="punishResultLog.punishResultFinePeople" />:</label> <s:textfield name="s_punishResultFinePeople" value="%{#parameters['s_punishResultFinePeople']}" /></li>
				
					<li><label><c:out value="punishResultLog.punishResultExpropriation" />:</label> <s:textfield name="s_punishResultExpropriation" value="%{#parameters['s_punishResultExpropriation']}" /></li>
				
					<li><label><c:out value="punishResultLog.punishResultExpropriationV" />:</label> <s:textfield name="s_punishResultExpropriationV" value="%{#parameters['s_punishResultExpropriationV']}" /></li>
				
					<li><label><c:out value="punishResultLog.punishResultBusiness" />:</label> <s:textfield name="s_punishResultBusiness" value="%{#parameters['s_punishResultBusiness']}" /></li>
				
					<li><label><c:out value="punishResultLog.punishResultPeople" />:</label> <s:textfield name="s_punishResultPeople" value="%{#parameters['s_punishResultPeople']}" /></li>
				
					<li><label><c:out value="punishResultLog.punishResultDetain" />:</label> <s:textfield name="s_punishResultDetain" value="%{#parameters['s_punishResultDetain']}" /></li>
				
					<li><label><c:out value="punishResultLog.attachment" />:</label> <s:textfield name="s_attachment" value="%{#parameters['s_attachment']}" /></li>
				
					<li><label><c:out value="punishResultLog.finishDate" />:</label> <s:textfield name="s_finishDate" value="%{#parameters['s_finishDate']}" /></li>
				
					<li><label><c:out value="punishResultLog.resultStandard" />:</label> <s:textfield name="s_resultStandard" value="%{#parameters['s_resultStandard']}" /></li>
				
					<li><label><c:out value="punishResultLog.createDate" />:</label> <s:textfield name="s_createDate" value="%{#parameters['s_createDate']}" /></li>
				
					<li><label><c:out value="punishResultLog.updateDate" />:</label> <s:textfield name="s_updateDate" value="%{#parameters['s_updateDate']}" /></li>
				
					<li><label><c:out value="punishResultLog.syncDate" />:</label> <s:textfield name="s_syncDate" value="%{#parameters['s_syncDate']}" /></li>
				
					<li><label><c:out value="punishResultLog.syncSign" />:</label> <s:textfield name="s_syncSign" value="%{#parameters['s_syncSign']}" /></li>
				
					<li><label><c:out value="punishResultLog.syncErrorDesc" />:</label> <s:textfield name="s_syncErrorDesc" value="%{#parameters['s_syncErrorDesc']}" /></li>
				
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
			<li><a class="add" href="${contextPath }/monitor/punishResultLog!edit.do" rel="" target='dialog'><span>添加</span></a></li>
			<li><a class="edit" href="${contextPath }/monitor/punishResultLog!edit.do?nochangNo={pk}" warn="请选择一条记录" rel="" target='dialog'><span>编辑</span></a></li>
			<li><a class="delete" href="${contextPath }/monitor/punishResultLog!delete.do?nochangNo={pk}" warn="请选择一条记录" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</ul>
	</div>

	<div layoutH="116">
		<table class="list" width="98%" targetType="navTab" asc="asc" desc="desc">
			<thead align="center">

				<tr>
					
						<c:set var="tno"><bean:message bundle='monitorRes' key='punishResultLog.no' /></c:set>	
						<th>${tno}</th>
					
						<c:set var="tchangNo"><bean:message bundle='monitorRes' key='punishResultLog.changNo' /></c:set>	
						<th>${tchangNo}</th>
					
					
						<c:set var="torgId"><bean:message bundle='monitorRes' key='punishResultLog.orgId' /></c:set>	
						<th>${torgId}</th>
					
						<c:set var="tinternalNo"><bean:message bundle='monitorRes' key='punishResultLog.internalNo' /></c:set>	
						<th>${tinternalNo}</th>
					
						<c:set var="titemId"><bean:message bundle='monitorRes' key='punishResultLog.itemId' /></c:set>	
						<th>${titemId}</th>
					
						<c:set var="tprogram"><bean:message bundle='monitorRes' key='punishResultLog.program' /></c:set>	
						<th>${tprogram}</th>
					
						<c:set var="tpunishSort"><bean:message bundle='monitorRes' key='punishResultLog.punishSort' /></c:set>	
						<th>${tpunishSort}</th>
					
						<c:set var="taccordance"><bean:message bundle='monitorRes' key='punishResultLog.accordance' /></c:set>	
						<th>${taccordance}</th>
					
						<c:set var="tstandard"><bean:message bundle='monitorRes' key='punishResultLog.standard' /></c:set>	
						<th>${tstandard}</th>
					
						<c:set var="tpunishDeside"><bean:message bundle='monitorRes' key='punishResultLog.punishDeside' /></c:set>	
						<th>${tpunishDeside}</th>
					
						<c:set var="tpunishClass"><bean:message bundle='monitorRes' key='punishResultLog.punishClass' /></c:set>	
						<th>${tpunishClass}</th>
					
						<c:set var="tpunishResult"><bean:message bundle='monitorRes' key='punishResultLog.punishResult' /></c:set>	
						<th>${tpunishResult}</th>
					
						<c:set var="tpunishResultFine"><bean:message bundle='monitorRes' key='punishResultLog.punishResultFine' /></c:set>	
						<th>${tpunishResultFine}</th>
					
						<c:set var="tpunishResultFinePeople"><bean:message bundle='monitorRes' key='punishResultLog.punishResultFinePeople' /></c:set>	
						<th>${tpunishResultFinePeople}</th>
					
						<c:set var="tpunishResultExpropriation"><bean:message bundle='monitorRes' key='punishResultLog.punishResultExpropriation' /></c:set>	
						<th>${tpunishResultExpropriation}</th>
					
						<c:set var="tpunishResultExpropriationV"><bean:message bundle='monitorRes' key='punishResultLog.punishResultExpropriationV' /></c:set>	
						<th>${tpunishResultExpropriationV}</th>
					
						<c:set var="tpunishResultBusiness"><bean:message bundle='monitorRes' key='punishResultLog.punishResultBusiness' /></c:set>	
						<th>${tpunishResultBusiness}</th>
					
						<c:set var="tpunishResultPeople"><bean:message bundle='monitorRes' key='punishResultLog.punishResultPeople' /></c:set>	
						<th>${tpunishResultPeople}</th>
					
						<c:set var="tpunishResultDetain"><bean:message bundle='monitorRes' key='punishResultLog.punishResultDetain' /></c:set>	
						<th>${tpunishResultDetain}</th>
					
						<c:set var="tattachment"><bean:message bundle='monitorRes' key='punishResultLog.attachment' /></c:set>	
						<th>${tattachment}</th>
					
						<c:set var="tfinishDate"><bean:message bundle='monitorRes' key='punishResultLog.finishDate' /></c:set>	
						<th>${tfinishDate}</th>
					
						<c:set var="tresultStandard"><bean:message bundle='monitorRes' key='punishResultLog.resultStandard' /></c:set>	
						<th>${tresultStandard}</th>
					
						<c:set var="tcreateDate"><bean:message bundle='monitorRes' key='punishResultLog.createDate' /></c:set>	
						<th>${tcreateDate}</th>
					
						<c:set var="tupdateDate"><bean:message bundle='monitorRes' key='punishResultLog.updateDate' /></c:set>	
						<th>${tupdateDate}</th>
					
						<c:set var="tsyncDate"><bean:message bundle='monitorRes' key='punishResultLog.syncDate' /></c:set>	
						<th>${tsyncDate}</th>
					
						<c:set var="tsyncSign"><bean:message bundle='monitorRes' key='punishResultLog.syncSign' /></c:set>	
						<th>${tsyncSign}</th>
					
						<c:set var="tsyncErrorDesc"><bean:message bundle='monitorRes' key='punishResultLog.syncErrorDesc' /></c:set>	
						<th>${tsyncErrorDesc}</th>
					
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach items="${objList }" var="punishResultLog">
						<tr target="pk" rel="${punishResultLog.no}">
							
								<td>${punishResultLog.no}</td>
							
								<td>${punishResultLog.changNo}</td>
							
							
								<td>${punishResultLog.orgId}</td>
							
								<td>${punishResultLog.internalNo}</td>
							
								<td>${punishResultLog.itemId}</td>
							
								<td>${punishResultLog.program}</td>
							
								<td>${punishResultLog.punishSort}</td>
							
								<td>${punishResultLog.accordance}</td>
							
								<td>${punishResultLog.standard}</td>
							
								<td>${punishResultLog.punishDeside}</td>
							
								<td>${punishResultLog.punishClass}</td>
							
								<td>${punishResultLog.punishResult}</td>
							
								<td>${punishResultLog.punishResultFine}</td>
							
								<td>${punishResultLog.punishResultFinePeople}</td>
							
								<td>${punishResultLog.punishResultExpropriation}</td>
							
								<td>${punishResultLog.punishResultExpropriationV}</td>
							
								<td>${punishResultLog.punishResultBusiness}</td>
							
								<td>${punishResultLog.punishResultPeople}</td>
							
								<td>${punishResultLog.punishResultDetain}</td>
							
								<td>${punishResultLog.attachment}</td>
							
								<td>${punishResultLog.finishDate}</td>
							
								<td>${punishResultLog.resultStandard}</td>
							
								<td>${punishResultLog.createDate}</td>
							
								<td>${punishResultLog.updateDate}</td>
							
								<td>${punishResultLog.syncDate}</td>
							
								<td>${punishResultLog.syncSign}</td>
							
								<td>${punishResultLog.syncErrorDesc}</td>
							
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
		<title><c:out value="punishResultLog.list.title" /></title>
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
			<html:form action="/monitor/punishResultLog.do" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr height="22">
						<td><c:out value="punishResultLog.no" />:</td>
						<td><html:text property="s_no" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishResultLog.changNo" />:</td>
						<td><html:text property="s_changNo" /> </td>
					</tr>	


					<tr height="22">
						<td><c:out value="punishResultLog.orgId" />:</td>
						<td><html:text property="s_orgId" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishResultLog.internalNo" />:</td>
						<td><html:text property="s_internalNo" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishResultLog.itemId" />:</td>
						<td><html:text property="s_itemId" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishResultLog.program" />:</td>
						<td><html:text property="s_program" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishResultLog.punishSort" />:</td>
						<td><html:text property="s_punishSort" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishResultLog.accordance" />:</td>
						<td><html:text property="s_accordance" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishResultLog.standard" />:</td>
						<td><html:text property="s_standard" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishResultLog.punishDeside" />:</td>
						<td><html:text property="s_punishDeside" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishResultLog.punishClass" />:</td>
						<td><html:text property="s_punishClass" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishResultLog.punishResult" />:</td>
						<td><html:text property="s_punishResult" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishResultLog.punishResultFine" />:</td>
						<td><html:text property="s_punishResultFine" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishResultLog.punishResultFinePeople" />:</td>
						<td><html:text property="s_punishResultFinePeople" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishResultLog.punishResultExpropriation" />:</td>
						<td><html:text property="s_punishResultExpropriation" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishResultLog.punishResultExpropriationV" />:</td>
						<td><html:text property="s_punishResultExpropriationV" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishResultLog.punishResultBusiness" />:</td>
						<td><html:text property="s_punishResultBusiness" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishResultLog.punishResultPeople" />:</td>
						<td><html:text property="s_punishResultPeople" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishResultLog.punishResultDetain" />:</td>
						<td><html:text property="s_punishResultDetain" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishResultLog.attachment" />:</td>
						<td><html:text property="s_attachment" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishResultLog.finishDate" />:</td>
						<td><html:text property="s_finishDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishResultLog.resultStandard" />:</td>
						<td><html:text property="s_resultStandard" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishResultLog.createDate" />:</td>
						<td><html:text property="s_createDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishResultLog.updateDate" />:</td>
						<td><html:text property="s_updateDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishResultLog.syncDate" />:</td>
						<td><html:text property="s_syncDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishResultLog.syncSign" />:</td>
						<td><html:text property="s_syncSign" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishResultLog.syncErrorDesc" />:</td>
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

			<ec:table action="punishResultLog.do" items="punishResultLogs" var="punishResultLog"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="punishResultLogs.xls" ></ec:exportXls>
			<ec:exportPdf fileName="punishResultLogs.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>
				
					<c:set var="tno"><bean:message bundle='monitorRes' key='punishResultLog.no' /></c:set>	
					<ec:column property="no" title="${tno}" style="text-align:center" />
				
					<c:set var="tchangNo"><bean:message bundle='monitorRes' key='punishResultLog.changNo' /></c:set>	
					<ec:column property="changNo" title="${tchangNo}" style="text-align:center" />
				
				
					<c:set var="torgId"><bean:message bundle='monitorRes' key='punishResultLog.orgId' /></c:set>	
					<ec:column property="orgId" title="${torgId}" style="text-align:center" />
				
					<c:set var="tinternalNo"><bean:message bundle='monitorRes' key='punishResultLog.internalNo' /></c:set>	
					<ec:column property="internalNo" title="${tinternalNo}" style="text-align:center" />
				
					<c:set var="titemId"><bean:message bundle='monitorRes' key='punishResultLog.itemId' /></c:set>	
					<ec:column property="itemId" title="${titemId}" style="text-align:center" />
				
					<c:set var="tprogram"><bean:message bundle='monitorRes' key='punishResultLog.program' /></c:set>	
					<ec:column property="program" title="${tprogram}" style="text-align:center" />
				
					<c:set var="tpunishSort"><bean:message bundle='monitorRes' key='punishResultLog.punishSort' /></c:set>	
					<ec:column property="punishSort" title="${tpunishSort}" style="text-align:center" />
				
					<c:set var="taccordance"><bean:message bundle='monitorRes' key='punishResultLog.accordance' /></c:set>	
					<ec:column property="accordance" title="${taccordance}" style="text-align:center" />
				
					<c:set var="tstandard"><bean:message bundle='monitorRes' key='punishResultLog.standard' /></c:set>	
					<ec:column property="standard" title="${tstandard}" style="text-align:center" />
				
					<c:set var="tpunishDeside"><bean:message bundle='monitorRes' key='punishResultLog.punishDeside' /></c:set>	
					<ec:column property="punishDeside" title="${tpunishDeside}" style="text-align:center" />
				
					<c:set var="tpunishClass"><bean:message bundle='monitorRes' key='punishResultLog.punishClass' /></c:set>	
					<ec:column property="punishClass" title="${tpunishClass}" style="text-align:center" />
				
					<c:set var="tpunishResult"><bean:message bundle='monitorRes' key='punishResultLog.punishResult' /></c:set>	
					<ec:column property="punishResult" title="${tpunishResult}" style="text-align:center" />
				
					<c:set var="tpunishResultFine"><bean:message bundle='monitorRes' key='punishResultLog.punishResultFine' /></c:set>	
					<ec:column property="punishResultFine" title="${tpunishResultFine}" style="text-align:center" />
				
					<c:set var="tpunishResultFinePeople"><bean:message bundle='monitorRes' key='punishResultLog.punishResultFinePeople' /></c:set>	
					<ec:column property="punishResultFinePeople" title="${tpunishResultFinePeople}" style="text-align:center" />
				
					<c:set var="tpunishResultExpropriation"><bean:message bundle='monitorRes' key='punishResultLog.punishResultExpropriation' /></c:set>	
					<ec:column property="punishResultExpropriation" title="${tpunishResultExpropriation}" style="text-align:center" />
				
					<c:set var="tpunishResultExpropriationV"><bean:message bundle='monitorRes' key='punishResultLog.punishResultExpropriationV' /></c:set>	
					<ec:column property="punishResultExpropriationV" title="${tpunishResultExpropriationV}" style="text-align:center" />
				
					<c:set var="tpunishResultBusiness"><bean:message bundle='monitorRes' key='punishResultLog.punishResultBusiness' /></c:set>	
					<ec:column property="punishResultBusiness" title="${tpunishResultBusiness}" style="text-align:center" />
				
					<c:set var="tpunishResultPeople"><bean:message bundle='monitorRes' key='punishResultLog.punishResultPeople' /></c:set>	
					<ec:column property="punishResultPeople" title="${tpunishResultPeople}" style="text-align:center" />
				
					<c:set var="tpunishResultDetain"><bean:message bundle='monitorRes' key='punishResultLog.punishResultDetain' /></c:set>	
					<ec:column property="punishResultDetain" title="${tpunishResultDetain}" style="text-align:center" />
				
					<c:set var="tattachment"><bean:message bundle='monitorRes' key='punishResultLog.attachment' /></c:set>	
					<ec:column property="attachment" title="${tattachment}" style="text-align:center" />
				
					<c:set var="tfinishDate"><bean:message bundle='monitorRes' key='punishResultLog.finishDate' /></c:set>	
					<ec:column property="finishDate" title="${tfinishDate}" style="text-align:center" />
				
					<c:set var="tresultStandard"><bean:message bundle='monitorRes' key='punishResultLog.resultStandard' /></c:set>	
					<ec:column property="resultStandard" title="${tresultStandard}" style="text-align:center" />
				
					<c:set var="tcreateDate"><bean:message bundle='monitorRes' key='punishResultLog.createDate' /></c:set>	
					<ec:column property="createDate" title="${tcreateDate}" style="text-align:center" />
				
					<c:set var="tupdateDate"><bean:message bundle='monitorRes' key='punishResultLog.updateDate' /></c:set>	
					<ec:column property="updateDate" title="${tupdateDate}" style="text-align:center" />
				
					<c:set var="tsyncDate"><bean:message bundle='monitorRes' key='punishResultLog.syncDate' /></c:set>	
					<ec:column property="syncDate" title="${tsyncDate}" style="text-align:center" />
				
					<c:set var="tsyncSign"><bean:message bundle='monitorRes' key='punishResultLog.syncSign' /></c:set>	
					<ec:column property="syncSign" title="${tsyncSign}" style="text-align:center" />
				
					<c:set var="tsyncErrorDesc"><bean:message bundle='monitorRes' key='punishResultLog.syncErrorDesc' /></c:set>	
					<ec:column property="syncErrorDesc" title="${tsyncErrorDesc}" style="text-align:center" />
						
				<c:set var="optlabel"><bean:message key="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><bean:message key="label.delete.confirm"/></c:set>
					<a href='punishResultLog.do?no=${punishResultLog.no}&changNo=${punishResultLog.changNo}&method=view'><bean:message key="opt.btn.view" /></a>
					<a href='punishResultLog.do?no=${punishResultLog.no}&changNo=${punishResultLog.changNo}&method=edit'><bean:message key="opt.btn.edit" /></a>
					<a href='punishResultLog.do?no=${punishResultLog.no}&changNo=${punishResultLog.changNo}&method=delete' 
							onclick='return confirm("${deletecofirm}punishResultLog?");'><bean:message key="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
 --%>