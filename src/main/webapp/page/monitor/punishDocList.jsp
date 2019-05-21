<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<form id="pagerForm" method="post" action="punishDoc.do">
	<input type="hidden" name="pageNum" value="1" /> <input type="hidden" name="numPerPage" value="${pageDesc.pageSize}" /> <input type="hidden" name="orderField"
		value="${s_orderField}" />
</form>



<div class="pageHeader">
	<s:form id="pagerForm" onsubmit="return navTabSearch(this);" action="/monitor/punishDoc.do" method="post">
		<div class="searchBar">
			<ul class="searchContent">
				
					<li><label><c:out value="punishDoc.no" />:</label> <s:textfield name="s_no" value="%{#parameters['s_no']}" /></li>
				
				
					<li><label><c:out value="punishDoc.updateDate" />:</label> <s:textfield name="s_updateDate" value="%{#parameters['s_updateDate']}" /></li>
				
					<li><label><c:out value="punishDoc.readDate" />:</label> <s:textfield name="s_readDate" value="%{#parameters['s_readDate']}" /></li>
				
					<li><label><c:out value="punishDoc.syncSign" />:</label> <s:textfield name="s_syncSign" value="%{#parameters['s_syncSign']}" /></li>
				
					<li><label><c:out value="punishDoc.errorDesc" />:</label> <s:textfield name="s_errorDesc" value="%{#parameters['s_errorDesc']}" /></li>
				
					<li><label><c:out value="punishDoc.orgId" />:</label> <s:textfield name="s_orgId" value="%{#parameters['s_orgId']}" /></li>
				
					<li><label><c:out value="punishDoc.internalNo" />:</label> <s:textfield name="s_internalNo" value="%{#parameters['s_internalNo']}" /></li>
				
					<li><label><c:out value="punishDoc.processNo" />:</label> <s:textfield name="s_processNo" value="%{#parameters['s_processNo']}" /></li>
				
					<li><label><c:out value="punishDoc.docNo" />:</label> <s:textfield name="s_docNo" value="%{#parameters['s_docNo']}" /></li>
				
					<li><label><c:out value="punishDoc.docType" />:</label> <s:textfield name="s_docType" value="%{#parameters['s_docType']}" /></li>
				
					<li><label><c:out value="punishDoc.docSort" />:</label> <s:textfield name="s_docSort" value="%{#parameters['s_docSort']}" /></li>
				
					<li><label><c:out value="punishDoc.docName" />:</label> <s:textfield name="s_docName" value="%{#parameters['s_docName']}" /></li>
				
					<li><label><c:out value="punishDoc.documentName" />:</label> <s:textfield name="s_documentName" value="%{#parameters['s_documentName']}" /></li>
				
					<li><label><c:out value="punishDoc.docFile" />:</label> <s:textfield name="s_docFile" value="%{#parameters['s_docFile']}" /></li>
				
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
			<li><a class="add" href="${contextPath }/monitor/punishDoc!edit.do" rel="" target='dialog'><span>添加</span></a></li>
			<li><a class="edit" href="${contextPath }/monitor/punishDoc!edit.do?no={pk}" warn="请选择一条记录" rel="" target='dialog'><span>编辑</span></a></li>
			<li><a class="delete" href="${contextPath }/monitor/punishDoc!delete.do?no={pk}" warn="请选择一条记录" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</ul>
	</div>

	<div layoutH="116">
		<table class="list" width="98%" targetType="navTab" asc="asc" desc="desc">
			<thead align="center">

				<tr>
					
						<c:set var="tno"><bean:message bundle='monitorRes' key='punishDoc.no' /></c:set>	
						<th>${tno}</th>
					
					
						<c:set var="tupdateDate"><bean:message bundle='monitorRes' key='punishDoc.updateDate' /></c:set>	
						<th>${tupdateDate}</th>
					
						<c:set var="treadDate"><bean:message bundle='monitorRes' key='punishDoc.readDate' /></c:set>	
						<th>${treadDate}</th>
					
						<c:set var="tsyncSign"><bean:message bundle='monitorRes' key='punishDoc.syncSign' /></c:set>	
						<th>${tsyncSign}</th>
					
						<c:set var="terrorDesc"><bean:message bundle='monitorRes' key='punishDoc.errorDesc' /></c:set>	
						<th>${terrorDesc}</th>
					
						<c:set var="torgId"><bean:message bundle='monitorRes' key='punishDoc.orgId' /></c:set>	
						<th>${torgId}</th>
					
						<c:set var="tinternalNo"><bean:message bundle='monitorRes' key='punishDoc.internalNo' /></c:set>	
						<th>${tinternalNo}</th>
					
						<c:set var="tprocessNo"><bean:message bundle='monitorRes' key='punishDoc.processNo' /></c:set>	
						<th>${tprocessNo}</th>
					
						<c:set var="tdocNo"><bean:message bundle='monitorRes' key='punishDoc.docNo' /></c:set>	
						<th>${tdocNo}</th>
					
						<c:set var="tdocType"><bean:message bundle='monitorRes' key='punishDoc.docType' /></c:set>	
						<th>${tdocType}</th>
					
						<c:set var="tdocSort"><bean:message bundle='monitorRes' key='punishDoc.docSort' /></c:set>	
						<th>${tdocSort}</th>
					
						<c:set var="tdocName"><bean:message bundle='monitorRes' key='punishDoc.docName' /></c:set>	
						<th>${tdocName}</th>
					
						<c:set var="tdocumentName"><bean:message bundle='monitorRes' key='punishDoc.documentName' /></c:set>	
						<th>${tdocumentName}</th>
					
						<c:set var="tdocFile"><bean:message bundle='monitorRes' key='punishDoc.docFile' /></c:set>	
						<th>${tdocFile}</th>
					
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach items="${objList }" var="punishDoc">
						<tr target="pk" rel="${punishDoc.no}">
							
								<td>${punishDoc.no}</td>
							
							
								<td>${punishDoc.updateDate}</td>
							
								<td>${punishDoc.readDate}</td>
							
								<td>${punishDoc.syncSign}</td>
							
								<td>${punishDoc.errorDesc}</td>
							
								<td>${punishDoc.orgId}</td>
							
								<td>${punishDoc.internalNo}</td>
							
								<td>${punishDoc.processNo}</td>
							
								<td>${punishDoc.docNo}</td>
							
								<td>${punishDoc.docType}</td>
							
								<td>${punishDoc.docSort}</td>
							
								<td>${punishDoc.docName}</td>
							
								<td>${punishDoc.documentName}</td>
							
								<td>${punishDoc.docFile}</td>
							
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
		<title><c:out value="punishDoc.list.title" /></title>
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
			<html:form action="/monitor/punishDoc.do" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr height="22">
						<td><c:out value="punishDoc.no" />:</td>
						<td><html:text property="s_no" /> </td>
					</tr>	


					<tr height="22">
						<td><c:out value="punishDoc.updateDate" />:</td>
						<td><html:text property="s_updateDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishDoc.readDate" />:</td>
						<td><html:text property="s_readDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishDoc.syncSign" />:</td>
						<td><html:text property="s_syncSign" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishDoc.errorDesc" />:</td>
						<td><html:text property="s_errorDesc" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishDoc.orgId" />:</td>
						<td><html:text property="s_orgId" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishDoc.internalNo" />:</td>
						<td><html:text property="s_internalNo" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishDoc.processNo" />:</td>
						<td><html:text property="s_processNo" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishDoc.docNo" />:</td>
						<td><html:text property="s_docNo" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishDoc.docType" />:</td>
						<td><html:text property="s_docType" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishDoc.docSort" />:</td>
						<td><html:text property="s_docSort" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishDoc.docName" />:</td>
						<td><html:text property="s_docName" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishDoc.documentName" />:</td>
						<td><html:text property="s_documentName" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishDoc.docFile" />:</td>
						<td><html:text property="s_docFile" /> </td>
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

			<ec:table action="punishDoc.do" items="punishDocs" var="punishDoc"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="punishDocs.xls" ></ec:exportXls>
			<ec:exportPdf fileName="punishDocs.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>
				
					<c:set var="tno"><bean:message bundle='monitorRes' key='punishDoc.no' /></c:set>	
					<ec:column property="no" title="${tno}" style="text-align:center" />
				
				
					<c:set var="tupdateDate"><bean:message bundle='monitorRes' key='punishDoc.updateDate' /></c:set>	
					<ec:column property="updateDate" title="${tupdateDate}" style="text-align:center" />
				
					<c:set var="treadDate"><bean:message bundle='monitorRes' key='punishDoc.readDate' /></c:set>	
					<ec:column property="readDate" title="${treadDate}" style="text-align:center" />
				
					<c:set var="tsyncSign"><bean:message bundle='monitorRes' key='punishDoc.syncSign' /></c:set>	
					<ec:column property="syncSign" title="${tsyncSign}" style="text-align:center" />
				
					<c:set var="terrorDesc"><bean:message bundle='monitorRes' key='punishDoc.errorDesc' /></c:set>	
					<ec:column property="errorDesc" title="${terrorDesc}" style="text-align:center" />
				
					<c:set var="torgId"><bean:message bundle='monitorRes' key='punishDoc.orgId' /></c:set>	
					<ec:column property="orgId" title="${torgId}" style="text-align:center" />
				
					<c:set var="tinternalNo"><bean:message bundle='monitorRes' key='punishDoc.internalNo' /></c:set>	
					<ec:column property="internalNo" title="${tinternalNo}" style="text-align:center" />
				
					<c:set var="tprocessNo"><bean:message bundle='monitorRes' key='punishDoc.processNo' /></c:set>	
					<ec:column property="processNo" title="${tprocessNo}" style="text-align:center" />
				
					<c:set var="tdocNo"><bean:message bundle='monitorRes' key='punishDoc.docNo' /></c:set>	
					<ec:column property="docNo" title="${tdocNo}" style="text-align:center" />
				
					<c:set var="tdocType"><bean:message bundle='monitorRes' key='punishDoc.docType' /></c:set>	
					<ec:column property="docType" title="${tdocType}" style="text-align:center" />
				
					<c:set var="tdocSort"><bean:message bundle='monitorRes' key='punishDoc.docSort' /></c:set>	
					<ec:column property="docSort" title="${tdocSort}" style="text-align:center" />
				
					<c:set var="tdocName"><bean:message bundle='monitorRes' key='punishDoc.docName' /></c:set>	
					<ec:column property="docName" title="${tdocName}" style="text-align:center" />
				
					<c:set var="tdocumentName"><bean:message bundle='monitorRes' key='punishDoc.documentName' /></c:set>	
					<ec:column property="documentName" title="${tdocumentName}" style="text-align:center" />
				
					<c:set var="tdocFile"><bean:message bundle='monitorRes' key='punishDoc.docFile' /></c:set>	
					<ec:column property="docFile" title="${tdocFile}" style="text-align:center" />
						
				<c:set var="optlabel"><bean:message key="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><bean:message key="label.delete.confirm"/></c:set>
					<a href='punishDoc.do?no=${punishDoc.no}&method=view'><bean:message key="opt.btn.view" /></a>
					<a href='punishDoc.do?no=${punishDoc.no}&method=edit'><bean:message key="opt.btn.edit" /></a>
					<a href='punishDoc.do?no=${punishDoc.no}&method=delete' 
							onclick='return confirm("${deletecofirm}punishDoc?");'><bean:message key="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
 --%>