<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<form id="pagerForm" method="post" action="applyResultLog.do">
	<input type="hidden" name="pageNum" value="1" /> <input type="hidden" name="numPerPage" value="${pageDesc.pageSize}" /> <input type="hidden" name="orderField"
		value="${s_orderField}" />
</form>



<div class="pageHeader">
	<s:form id="pagerForm" onsubmit="return navTabSearch(this);" action="/monitor/applyResultLog.do" method="post">
		<div class="searchBar">
			<ul class="searchContent">
				
					<li><label><c:out value="applyResultLog.no" />:</label> <s:textfield name="s_no" value="%{#parameters['s_no']}" /></li>
				
					<li><label><c:out value="applyResultLog.changNo" />:</label> <s:textfield name="s_changNo" value="%{#parameters['s_changNo']}" /></li>
				
				
					<li><label><c:out value="applyResultLog.orgId" />:</label> <s:textfield name="s_orgId" value="%{#parameters['s_orgId']}" /></li>
				
					<li><label><c:out value="applyResultLog.internalNo" />:</label> <s:textfield name="s_internalNo" value="%{#parameters['s_internalNo']}" /></li>
				
					<li><label><c:out value="applyResultLog.itemId" />:</label> <s:textfield name="s_itemId" value="%{#parameters['s_itemId']}" /></li>
				
					<li><label><c:out value="applyResultLog.status" />:</label> <s:textfield name="s_status" value="%{#parameters['s_status']}" /></li>
				
					<li><label><c:out value="applyResultLog.note" />:</label> <s:textfield name="s_note" value="%{#parameters['s_note']}" /></li>
				
					<li><label><c:out value="applyResultLog.attachment" />:</label> <s:textfield name="s_attachment" value="%{#parameters['s_attachment']}" /></li>
				
					<li><label><c:out value="applyResultLog.finishTime" />:</label> <s:textfield name="s_finishTime" value="%{#parameters['s_finishTime']}" /></li>
				
					<li><label><c:out value="applyResultLog.receivable" />:</label> <s:textfield name="s_receivable" value="%{#parameters['s_receivable']}" /></li>
				
					<li><label><c:out value="applyResultLog.paid" />:</label> <s:textfield name="s_paid" value="%{#parameters['s_paid']}" /></li>
				
					<li><label><c:out value="applyResultLog.reliefReasons" />:</label> <s:textfield name="s_reliefReasons" value="%{#parameters['s_reliefReasons']}" /></li>
				
					<li><label><c:out value="applyResultLog.createDate" />:</label> <s:textfield name="s_createDate" value="%{#parameters['s_createDate']}" /></li>
				
					<li><label><c:out value="applyResultLog.updateDate" />:</label> <s:textfield name="s_updateDate" value="%{#parameters['s_updateDate']}" /></li>
				
					<li><label><c:out value="applyResultLog.syncDate" />:</label> <s:textfield name="s_syncDate" value="%{#parameters['s_syncDate']}" /></li>
				
					<li><label><c:out value="applyResultLog.syncSign" />:</label> <s:textfield name="s_syncSign" value="%{#parameters['s_syncSign']}" /></li>
				
					<li><label><c:out value="applyResultLog.syncErrorDesc" />:</label> <s:textfield name="s_syncErrorDesc" value="%{#parameters['s_syncErrorDesc']}" /></li>
				
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
			<li><a class="add" href="${contextPath }/monitor/applyResultLog!edit.do" rel="" target='dialog'><span>添加</span></a></li>
			<li><a class="edit" href="${contextPath }/monitor/applyResultLog!edit.do?nochangNo={pk}" warn="请选择一条记录" rel="" target='dialog'><span>编辑</span></a></li>
			<li><a class="delete" href="${contextPath }/monitor/applyResultLog!delete.do?nochangNo={pk}" warn="请选择一条记录" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</ul>
	</div>

	<div layoutH="116">
		<table class="list" width="98%" targetType="navTab" asc="asc" desc="desc">
			<thead align="center">

				<tr>
					
						<c:set var="tno"><bean:message bundle='monitorRes' key='applyResultLog.no' /></c:set>	
						<th>${tno}</th>
					
						<c:set var="tchangNo"><bean:message bundle='monitorRes' key='applyResultLog.changNo' /></c:set>	
						<th>${tchangNo}</th>
					
					
						<c:set var="torgId"><bean:message bundle='monitorRes' key='applyResultLog.orgId' /></c:set>	
						<th>${torgId}</th>
					
						<c:set var="tinternalNo"><bean:message bundle='monitorRes' key='applyResultLog.internalNo' /></c:set>	
						<th>${tinternalNo}</th>
					
						<c:set var="titemId"><bean:message bundle='monitorRes' key='applyResultLog.itemId' /></c:set>	
						<th>${titemId}</th>
					
						<c:set var="tstatus"><bean:message bundle='monitorRes' key='applyResultLog.status' /></c:set>	
						<th>${tstatus}</th>
					
						<c:set var="tnote"><bean:message bundle='monitorRes' key='applyResultLog.note' /></c:set>	
						<th>${tnote}</th>
					
						<c:set var="tattachment"><bean:message bundle='monitorRes' key='applyResultLog.attachment' /></c:set>	
						<th>${tattachment}</th>
					
						<c:set var="tfinishTime"><bean:message bundle='monitorRes' key='applyResultLog.finishTime' /></c:set>	
						<th>${tfinishTime}</th>
					
						<c:set var="treceivable"><bean:message bundle='monitorRes' key='applyResultLog.receivable' /></c:set>	
						<th>${treceivable}</th>
					
						<c:set var="tpaid"><bean:message bundle='monitorRes' key='applyResultLog.paid' /></c:set>	
						<th>${tpaid}</th>
					
						<c:set var="treliefReasons"><bean:message bundle='monitorRes' key='applyResultLog.reliefReasons' /></c:set>	
						<th>${treliefReasons}</th>
					
						<c:set var="tcreateDate"><bean:message bundle='monitorRes' key='applyResultLog.createDate' /></c:set>	
						<th>${tcreateDate}</th>
					
						<c:set var="tupdateDate"><bean:message bundle='monitorRes' key='applyResultLog.updateDate' /></c:set>	
						<th>${tupdateDate}</th>
					
						<c:set var="tsyncDate"><bean:message bundle='monitorRes' key='applyResultLog.syncDate' /></c:set>	
						<th>${tsyncDate}</th>
					
						<c:set var="tsyncSign"><bean:message bundle='monitorRes' key='applyResultLog.syncSign' /></c:set>	
						<th>${tsyncSign}</th>
					
						<c:set var="tsyncErrorDesc"><bean:message bundle='monitorRes' key='applyResultLog.syncErrorDesc' /></c:set>	
						<th>${tsyncErrorDesc}</th>
					
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach items="${objList }" var="applyResultLog">
						<tr target="pk" rel="${applyResultLog.no}">
							
								<td>${applyResultLog.no}</td>
							
								<td>${applyResultLog.changNo}</td>
							
							
								<td>${applyResultLog.orgId}</td>
							
								<td>${applyResultLog.internalNo}</td>
							
								<td>${applyResultLog.itemId}</td>
							
								<td>${applyResultLog.status}</td>
							
								<td>${applyResultLog.note}</td>
							
								<td>${applyResultLog.attachment}</td>
							
								<td>${applyResultLog.finishTime}</td>
							
								<td>${applyResultLog.receivable}</td>
							
								<td>${applyResultLog.paid}</td>
							
								<td>${applyResultLog.reliefReasons}</td>
							
								<td>${applyResultLog.createDate}</td>
							
								<td>${applyResultLog.updateDate}</td>
							
								<td>${applyResultLog.syncDate}</td>
							
								<td>${applyResultLog.syncSign}</td>
							
								<td>${applyResultLog.syncErrorDesc}</td>
							
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
		<title><c:out value="applyResultLog.list.title" /></title>
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
			<html:form action="/monitor/applyResultLog.do" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr height="22">
						<td><c:out value="applyResultLog.no" />:</td>
						<td><html:text property="s_no" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyResultLog.changNo" />:</td>
						<td><html:text property="s_changNo" /> </td>
					</tr>	


					<tr height="22">
						<td><c:out value="applyResultLog.orgId" />:</td>
						<td><html:text property="s_orgId" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyResultLog.internalNo" />:</td>
						<td><html:text property="s_internalNo" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyResultLog.itemId" />:</td>
						<td><html:text property="s_itemId" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyResultLog.status" />:</td>
						<td><html:text property="s_status" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyResultLog.note" />:</td>
						<td><html:text property="s_note" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyResultLog.attachment" />:</td>
						<td><html:text property="s_attachment" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyResultLog.finishTime" />:</td>
						<td><html:text property="s_finishTime" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyResultLog.receivable" />:</td>
						<td><html:text property="s_receivable" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyResultLog.paid" />:</td>
						<td><html:text property="s_paid" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyResultLog.reliefReasons" />:</td>
						<td><html:text property="s_reliefReasons" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyResultLog.createDate" />:</td>
						<td><html:text property="s_createDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyResultLog.updateDate" />:</td>
						<td><html:text property="s_updateDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyResultLog.syncDate" />:</td>
						<td><html:text property="s_syncDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyResultLog.syncSign" />:</td>
						<td><html:text property="s_syncSign" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyResultLog.syncErrorDesc" />:</td>
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

			<ec:table action="applyResultLog.do" items="applyResultLogs" var="applyResultLog"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="applyResultLogs.xls" ></ec:exportXls>
			<ec:exportPdf fileName="applyResultLogs.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>
				
					<c:set var="tno"><bean:message bundle='monitorRes' key='applyResultLog.no' /></c:set>	
					<ec:column property="no" title="${tno}" style="text-align:center" />
				
					<c:set var="tchangNo"><bean:message bundle='monitorRes' key='applyResultLog.changNo' /></c:set>	
					<ec:column property="changNo" title="${tchangNo}" style="text-align:center" />
				
				
					<c:set var="torgId"><bean:message bundle='monitorRes' key='applyResultLog.orgId' /></c:set>	
					<ec:column property="orgId" title="${torgId}" style="text-align:center" />
				
					<c:set var="tinternalNo"><bean:message bundle='monitorRes' key='applyResultLog.internalNo' /></c:set>	
					<ec:column property="internalNo" title="${tinternalNo}" style="text-align:center" />
				
					<c:set var="titemId"><bean:message bundle='monitorRes' key='applyResultLog.itemId' /></c:set>	
					<ec:column property="itemId" title="${titemId}" style="text-align:center" />
				
					<c:set var="tstatus"><bean:message bundle='monitorRes' key='applyResultLog.status' /></c:set>	
					<ec:column property="status" title="${tstatus}" style="text-align:center" />
				
					<c:set var="tnote"><bean:message bundle='monitorRes' key='applyResultLog.note' /></c:set>	
					<ec:column property="note" title="${tnote}" style="text-align:center" />
				
					<c:set var="tattachment"><bean:message bundle='monitorRes' key='applyResultLog.attachment' /></c:set>	
					<ec:column property="attachment" title="${tattachment}" style="text-align:center" />
				
					<c:set var="tfinishTime"><bean:message bundle='monitorRes' key='applyResultLog.finishTime' /></c:set>	
					<ec:column property="finishTime" title="${tfinishTime}" style="text-align:center" />
				
					<c:set var="treceivable"><bean:message bundle='monitorRes' key='applyResultLog.receivable' /></c:set>	
					<ec:column property="receivable" title="${treceivable}" style="text-align:center" />
				
					<c:set var="tpaid"><bean:message bundle='monitorRes' key='applyResultLog.paid' /></c:set>	
					<ec:column property="paid" title="${tpaid}" style="text-align:center" />
				
					<c:set var="treliefReasons"><bean:message bundle='monitorRes' key='applyResultLog.reliefReasons' /></c:set>	
					<ec:column property="reliefReasons" title="${treliefReasons}" style="text-align:center" />
				
					<c:set var="tcreateDate"><bean:message bundle='monitorRes' key='applyResultLog.createDate' /></c:set>	
					<ec:column property="createDate" title="${tcreateDate}" style="text-align:center" />
				
					<c:set var="tupdateDate"><bean:message bundle='monitorRes' key='applyResultLog.updateDate' /></c:set>	
					<ec:column property="updateDate" title="${tupdateDate}" style="text-align:center" />
				
					<c:set var="tsyncDate"><bean:message bundle='monitorRes' key='applyResultLog.syncDate' /></c:set>	
					<ec:column property="syncDate" title="${tsyncDate}" style="text-align:center" />
				
					<c:set var="tsyncSign"><bean:message bundle='monitorRes' key='applyResultLog.syncSign' /></c:set>	
					<ec:column property="syncSign" title="${tsyncSign}" style="text-align:center" />
				
					<c:set var="tsyncErrorDesc"><bean:message bundle='monitorRes' key='applyResultLog.syncErrorDesc' /></c:set>	
					<ec:column property="syncErrorDesc" title="${tsyncErrorDesc}" style="text-align:center" />
						
				<c:set var="optlabel"><bean:message key="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><bean:message key="label.delete.confirm"/></c:set>
					<a href='applyResultLog.do?no=${applyResultLog.no}&changNo=${applyResultLog.changNo}&method=view'><bean:message key="opt.btn.view" /></a>
					<a href='applyResultLog.do?no=${applyResultLog.no}&changNo=${applyResultLog.changNo}&method=edit'><bean:message key="opt.btn.edit" /></a>
					<a href='applyResultLog.do?no=${applyResultLog.no}&changNo=${applyResultLog.changNo}&method=delete' 
							onclick='return confirm("${deletecofirm}applyResultLog?");'><bean:message key="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
 --%>