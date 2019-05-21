<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<form id="pagerForm" method="post" action="incomeDoc.do">
	<input type="hidden" name="pageNum" value="1" /> <input type="hidden" name="numPerPage" value="${pageDesc.pageSize}" /> <input type="hidden" name="orderField"
		value="${s_orderField}" />
</form>



<div class="pageHeader">
	<s:form id="pagerForm" onsubmit="return navTabSearch(this);" action="/monitor/incomeDoc.do" method="post">
		<div class="searchBar">
			<ul class="searchContent">
				
					<li><label><c:out value="incomeDoc.no" />:</label> <s:textfield name="s_no" value="%{#parameters['s_no']}" /></li>
				
				
					<li><label><c:out value="incomeDoc.internalNo" />:</label> <s:textfield name="s_internalNo" value="%{#parameters['s_internalNo']}" /></li>
				
					<li><label><c:out value="incomeDoc.itemId" />:</label> <s:textfield name="s_itemId" value="%{#parameters['s_itemId']}" /></li>
				
					<li><label><c:out value="incomeDoc.acceptNo" />:</label> <s:textfield name="s_acceptNo" value="%{#parameters['s_acceptNo']}" /></li>
				
					<li><label><c:out value="incomeDoc.incomeDocNo" />:</label> <s:textfield name="s_incomeDocNo" value="%{#parameters['s_incomeDocNo']}" /></li>
				
					<li><label><c:out value="incomeDoc.incomeDocTitle" />:</label> <s:textfield name="s_incomeDocTitle" value="%{#parameters['s_incomeDocTitle']}" /></li>
				
					<li><label><c:out value="incomeDoc.incomeDeptName" />:</label> <s:textfield name="s_incomeDeptName" value="%{#parameters['s_incomeDeptName']}" /></li>
				
					<li><label><c:out value="incomeDoc.incomeDoc" />:</label> <s:textfield name="s_incomeDoc" value="%{#parameters['s_incomeDoc']}" /></li>
				
					<li><label><c:out value="incomeDoc.syncErrorDesc" />:</label> <s:textfield name="s_syncErrorDesc" value="%{#parameters['s_syncErrorDesc']}" /></li>
				
					<li><label><c:out value="incomeDoc.createDate" />:</label> <s:textfield name="s_createDate" value="%{#parameters['s_createDate']}" /></li>
				
					<li><label><c:out value="incomeDoc.updateDate" />:</label> <s:textfield name="s_updateDate" value="%{#parameters['s_updateDate']}" /></li>
				
					<li><label><c:out value="incomeDoc.syncDate" />:</label> <s:textfield name="s_syncDate" value="%{#parameters['s_syncDate']}" /></li>
				
					<li><label><c:out value="incomeDoc.syncSign" />:</label> <s:textfield name="s_syncSign" value="%{#parameters['s_syncSign']}" /></li>
				
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
			<li><a class="add" href="${contextPath }/monitor/incomeDoc!edit.do" rel="" target='dialog'><span>添加</span></a></li>
			<li><a class="edit" href="${contextPath }/monitor/incomeDoc!edit.do?no={pk}" warn="请选择一条记录" rel="" target='dialog'><span>编辑</span></a></li>
			<li><a class="delete" href="${contextPath }/monitor/incomeDoc!delete.do?no={pk}" warn="请选择一条记录" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</ul>
	</div>

	<div layoutH="116">
		<table class="list" width="98%" targetType="navTab" asc="asc" desc="desc">
			<thead align="center">

				<tr>
					
						<c:set var="tno"><bean:message bundle='monitorRes' key='incomeDoc.no' /></c:set>	
						<th>${tno}</th>
					
					
						<c:set var="tinternalNo"><bean:message bundle='monitorRes' key='incomeDoc.internalNo' /></c:set>	
						<th>${tinternalNo}</th>
					
						<c:set var="titemId"><bean:message bundle='monitorRes' key='incomeDoc.itemId' /></c:set>	
						<th>${titemId}</th>
					
						<c:set var="tacceptNo"><bean:message bundle='monitorRes' key='incomeDoc.acceptNo' /></c:set>	
						<th>${tacceptNo}</th>
					
						<c:set var="tincomeDocNo"><bean:message bundle='monitorRes' key='incomeDoc.incomeDocNo' /></c:set>	
						<th>${tincomeDocNo}</th>
					
						<c:set var="tincomeDocTitle"><bean:message bundle='monitorRes' key='incomeDoc.incomeDocTitle' /></c:set>	
						<th>${tincomeDocTitle}</th>
					
						<c:set var="tincomeDeptName"><bean:message bundle='monitorRes' key='incomeDoc.incomeDeptName' /></c:set>	
						<th>${tincomeDeptName}</th>
					
						<c:set var="tincomeDoc"><bean:message bundle='monitorRes' key='incomeDoc.incomeDoc' /></c:set>	
						<th>${tincomeDoc}</th>
					
						<c:set var="tsyncErrorDesc"><bean:message bundle='monitorRes' key='incomeDoc.syncErrorDesc' /></c:set>	
						<th>${tsyncErrorDesc}</th>
					
						<c:set var="tcreateDate"><bean:message bundle='monitorRes' key='incomeDoc.createDate' /></c:set>	
						<th>${tcreateDate}</th>
					
						<c:set var="tupdateDate"><bean:message bundle='monitorRes' key='incomeDoc.updateDate' /></c:set>	
						<th>${tupdateDate}</th>
					
						<c:set var="tsyncDate"><bean:message bundle='monitorRes' key='incomeDoc.syncDate' /></c:set>	
						<th>${tsyncDate}</th>
					
						<c:set var="tsyncSign"><bean:message bundle='monitorRes' key='incomeDoc.syncSign' /></c:set>	
						<th>${tsyncSign}</th>
					
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach items="${objList }" var="incomeDoc">
						<tr target="pk" rel="${incomeDoc.no}">
							
								<td>${incomeDoc.no}</td>
							
							
								<td>${incomeDoc.internalNo}</td>
							
								<td>${incomeDoc.itemId}</td>
							
								<td>${incomeDoc.acceptNo}</td>
							
								<td>${incomeDoc.incomeDocNo}</td>
							
								<td>${incomeDoc.incomeDocTitle}</td>
							
								<td>${incomeDoc.incomeDeptName}</td>
							
								<td>${incomeDoc.incomeDoc}</td>
							
								<td>${incomeDoc.syncErrorDesc}</td>
							
								<td>${incomeDoc.createDate}</td>
							
								<td>${incomeDoc.updateDate}</td>
							
								<td>${incomeDoc.syncDate}</td>
							
								<td>${incomeDoc.syncSign}</td>
							
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
		<title><c:out value="incomeDoc.list.title" /></title>
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
			<html:form action="/monitor/incomeDoc.do" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr height="22">
						<td><c:out value="incomeDoc.no" />:</td>
						<td><html:text property="s_no" /> </td>
					</tr>	


					<tr height="22">
						<td><c:out value="incomeDoc.internalNo" />:</td>
						<td><html:text property="s_internalNo" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="incomeDoc.itemId" />:</td>
						<td><html:text property="s_itemId" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="incomeDoc.acceptNo" />:</td>
						<td><html:text property="s_acceptNo" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="incomeDoc.incomeDocNo" />:</td>
						<td><html:text property="s_incomeDocNo" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="incomeDoc.incomeDocTitle" />:</td>
						<td><html:text property="s_incomeDocTitle" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="incomeDoc.incomeDeptName" />:</td>
						<td><html:text property="s_incomeDeptName" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="incomeDoc.incomeDoc" />:</td>
						<td><html:text property="s_incomeDoc" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="incomeDoc.syncErrorDesc" />:</td>
						<td><html:text property="s_syncErrorDesc" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="incomeDoc.createDate" />:</td>
						<td><html:text property="s_createDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="incomeDoc.updateDate" />:</td>
						<td><html:text property="s_updateDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="incomeDoc.syncDate" />:</td>
						<td><html:text property="s_syncDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="incomeDoc.syncSign" />:</td>
						<td><html:text property="s_syncSign" /> </td>
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

			<ec:table action="incomeDoc.do" items="incomeDocs" var="incomeDoc"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="incomeDocs.xls" ></ec:exportXls>
			<ec:exportPdf fileName="incomeDocs.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>
				
					<c:set var="tno"><bean:message bundle='monitorRes' key='incomeDoc.no' /></c:set>	
					<ec:column property="no" title="${tno}" style="text-align:center" />
				
				
					<c:set var="tinternalNo"><bean:message bundle='monitorRes' key='incomeDoc.internalNo' /></c:set>	
					<ec:column property="internalNo" title="${tinternalNo}" style="text-align:center" />
				
					<c:set var="titemId"><bean:message bundle='monitorRes' key='incomeDoc.itemId' /></c:set>	
					<ec:column property="itemId" title="${titemId}" style="text-align:center" />
				
					<c:set var="tacceptNo"><bean:message bundle='monitorRes' key='incomeDoc.acceptNo' /></c:set>	
					<ec:column property="acceptNo" title="${tacceptNo}" style="text-align:center" />
				
					<c:set var="tincomeDocNo"><bean:message bundle='monitorRes' key='incomeDoc.incomeDocNo' /></c:set>	
					<ec:column property="incomeDocNo" title="${tincomeDocNo}" style="text-align:center" />
				
					<c:set var="tincomeDocTitle"><bean:message bundle='monitorRes' key='incomeDoc.incomeDocTitle' /></c:set>	
					<ec:column property="incomeDocTitle" title="${tincomeDocTitle}" style="text-align:center" />
				
					<c:set var="tincomeDeptName"><bean:message bundle='monitorRes' key='incomeDoc.incomeDeptName' /></c:set>	
					<ec:column property="incomeDeptName" title="${tincomeDeptName}" style="text-align:center" />
				
					<c:set var="tincomeDoc"><bean:message bundle='monitorRes' key='incomeDoc.incomeDoc' /></c:set>	
					<ec:column property="incomeDoc" title="${tincomeDoc}" style="text-align:center" />
				
					<c:set var="tsyncErrorDesc"><bean:message bundle='monitorRes' key='incomeDoc.syncErrorDesc' /></c:set>	
					<ec:column property="syncErrorDesc" title="${tsyncErrorDesc}" style="text-align:center" />
				
					<c:set var="tcreateDate"><bean:message bundle='monitorRes' key='incomeDoc.createDate' /></c:set>	
					<ec:column property="createDate" title="${tcreateDate}" style="text-align:center" />
				
					<c:set var="tupdateDate"><bean:message bundle='monitorRes' key='incomeDoc.updateDate' /></c:set>	
					<ec:column property="updateDate" title="${tupdateDate}" style="text-align:center" />
				
					<c:set var="tsyncDate"><bean:message bundle='monitorRes' key='incomeDoc.syncDate' /></c:set>	
					<ec:column property="syncDate" title="${tsyncDate}" style="text-align:center" />
				
					<c:set var="tsyncSign"><bean:message bundle='monitorRes' key='incomeDoc.syncSign' /></c:set>	
					<ec:column property="syncSign" title="${tsyncSign}" style="text-align:center" />
						
				<c:set var="optlabel"><bean:message key="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><bean:message key="label.delete.confirm"/></c:set>
					<a href='incomeDoc.do?no=${incomeDoc.no}&method=view'><bean:message key="opt.btn.view" /></a>
					<a href='incomeDoc.do?no=${incomeDoc.no}&method=edit'><bean:message key="opt.btn.edit" /></a>
					<a href='incomeDoc.do?no=${incomeDoc.no}&method=delete' 
							onclick='return confirm("${deletecofirm}incomeDoc?");'><bean:message key="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
 --%>