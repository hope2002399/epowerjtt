<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<form id="pagerForm" method="post" action="dispatchDoc.do">
	<input type="hidden" name="pageNum" value="1" /> <input type="hidden" name="numPerPage" value="${pageDesc.pageSize}" /> <input type="hidden" name="orderField"
		value="${s_orderField}" />
</form>



<div class="pageHeader">
	<s:form id="pagerForm" onsubmit="return navTabSearch(this);" action="/monitor/dispatchDoc.do" method="post">
		<div class="searchBar">
			<ul class="searchContent">
				
					<li><label><c:out value="dispatchDoc.no" />:</label> <s:textfield name="s_no" value="%{#parameters['s_no']}" /></li>
				
				
					<li><label><c:out value="dispatchDoc.internalNo" />:</label> <s:textfield name="s_internalNo" value="%{#parameters['s_internalNo']}" /></li>
				
					<li><label><c:out value="dispatchDoc.itemId" />:</label> <s:textfield name="s_itemId" value="%{#parameters['s_itemId']}" /></li>
				
					<li><label><c:out value="dispatchDoc.dispatchDocNo" />:</label> <s:textfield name="s_dispatchDocNo" value="%{#parameters['s_dispatchDocNo']}" /></li>
				
					<li><label><c:out value="dispatchDoc.dispatchDocTitle" />:</label> <s:textfield name="s_dispatchDocTitle" value="%{#parameters['s_dispatchDocTitle']}" /></li>
				
					<li><label><c:out value="dispatchDoc.dispatchFileType" />:</label> <s:textfield name="s_dispatchFileType" value="%{#parameters['s_dispatchFileType']}" /></li>
				
					<li><label><c:out value="dispatchDoc.dispatchDocType" />:</label> <s:textfield name="s_dispatchDocType" value="%{#parameters['s_dispatchDocType']}" /></li>
				
					<li><label><c:out value="dispatchDoc.dispatchCanOpen" />:</label> <s:textfield name="s_dispatchCanOpen" value="%{#parameters['s_dispatchCanOpen']}" /></li>
				
					<li><label><c:out value="dispatchDoc.dispatchOpenType" />:</label> <s:textfield name="s_dispatchOpenType" value="%{#parameters['s_dispatchOpenType']}" /></li>
				
					<li><label><c:out value="dispatchDoc.notOpenReason" />:</label> <s:textfield name="s_notOpenReason" value="%{#parameters['s_notOpenReason']}" /></li>
				
					<li><label><c:out value="dispatchDoc.isUnionDispatch" />:</label> <s:textfield name="s_isUnionDispatch" value="%{#parameters['s_isUnionDispatch']}" /></li>
				
					<li><label><c:out value="dispatchDoc.unionOthers" />:</label> <s:textfield name="s_unionOthers" value="%{#parameters['s_unionOthers']}" /></li>
				
					<li><label><c:out value="dispatchDoc.isCountersign" />:</label> <s:textfield name="s_isCountersign" value="%{#parameters['s_isCountersign']}" /></li>
				
					<li><label><c:out value="dispatchDoc.dispatchDocSummary" />:</label> <s:textfield name="s_dispatchDocSummary" value="%{#parameters['s_dispatchDocSummary']}" /></li>
				
					<li><label><c:out value="dispatchDoc.draftDate" />:</label> <s:textfield name="s_draftDate" value="%{#parameters['s_draftDate']}" /></li>
				
					<li><label><c:out value="dispatchDoc.optUnitName" />:</label> <s:textfield name="s_optUnitName" value="%{#parameters['s_optUnitName']}" /></li>
				
					<li><label><c:out value="dispatchDoc.draftUserName" />:</label> <s:textfield name="s_draftUserName" value="%{#parameters['s_draftUserName']}" /></li>
				
					<li><label><c:out value="dispatchDoc.secretsDegree" />:</label> <s:textfield name="s_secretsDegree" value="%{#parameters['s_secretsDegree']}" /></li>
				
					<li><label><c:out value="dispatchDoc.copies" />:</label> <s:textfield name="s_copies" value="%{#parameters['s_copies']}" /></li>
				
					<li><label><c:out value="dispatchDoc.mainNotifyUnit" />:</label> <s:textfield name="s_mainNotifyUnit" value="%{#parameters['s_mainNotifyUnit']}" /></li>
				
					<li><label><c:out value="dispatchDoc.otherUnits" />:</label> <s:textfield name="s_otherUnits" value="%{#parameters['s_otherUnits']}" /></li>
				
					<li><label><c:out value="dispatchDoc.retentionPeriod" />:</label> <s:textfield name="s_retentionPeriod" value="%{#parameters['s_retentionPeriod']}" /></li>
				
					<li><label><c:out value="dispatchDoc.checkUserName" />:</label> <s:textfield name="s_checkUserName" value="%{#parameters['s_checkUserName']}" /></li>
				
					<li><label><c:out value="dispatchDoc.dispatchDoc" />:</label> <s:textfield name="s_dispatchDoc" value="%{#parameters['s_dispatchDoc']}" /></li>
				
					<li><label><c:out value="dispatchDoc.createDate" />:</label> <s:textfield name="s_createDate" value="%{#parameters['s_createDate']}" /></li>
				
					<li><label><c:out value="dispatchDoc.updateDate" />:</label> <s:textfield name="s_updateDate" value="%{#parameters['s_updateDate']}" /></li>
				
					<li><label><c:out value="dispatchDoc.syncDate" />:</label> <s:textfield name="s_syncDate" value="%{#parameters['s_syncDate']}" /></li>
				
					<li><label><c:out value="dispatchDoc.syncSign" />:</label> <s:textfield name="s_syncSign" value="%{#parameters['s_syncSign']}" /></li>
				
					<li><label><c:out value="dispatchDoc.syncErrorDesc" />:</label> <s:textfield name="s_syncErrorDesc" value="%{#parameters['s_syncErrorDesc']}" /></li>
				
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
			<li><a class="add" href="${contextPath }/monitor/dispatchDoc!edit.do" rel="" target='dialog'><span>添加</span></a></li>
			<li><a class="edit" href="${contextPath }/monitor/dispatchDoc!edit.do?no={pk}" warn="请选择一条记录" rel="" target='dialog'><span>编辑</span></a></li>
			<li><a class="delete" href="${contextPath }/monitor/dispatchDoc!delete.do?no={pk}" warn="请选择一条记录" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</ul>
	</div>

	<div layoutH="116">
		<table class="list" width="98%" targetType="navTab" asc="asc" desc="desc">
			<thead align="center">

				<tr>
					
						<c:set var="tno"><bean:message bundle='monitorRes' key='dispatchDoc.no' /></c:set>	
						<th>${tno}</th>
					
					
						<c:set var="tinternalNo"><bean:message bundle='monitorRes' key='dispatchDoc.internalNo' /></c:set>	
						<th>${tinternalNo}</th>
					
						<c:set var="titemId"><bean:message bundle='monitorRes' key='dispatchDoc.itemId' /></c:set>	
						<th>${titemId}</th>
					
						<c:set var="tdispatchDocNo"><bean:message bundle='monitorRes' key='dispatchDoc.dispatchDocNo' /></c:set>	
						<th>${tdispatchDocNo}</th>
					
						<c:set var="tdispatchDocTitle"><bean:message bundle='monitorRes' key='dispatchDoc.dispatchDocTitle' /></c:set>	
						<th>${tdispatchDocTitle}</th>
					
						<c:set var="tdispatchFileType"><bean:message bundle='monitorRes' key='dispatchDoc.dispatchFileType' /></c:set>	
						<th>${tdispatchFileType}</th>
					
						<c:set var="tdispatchDocType"><bean:message bundle='monitorRes' key='dispatchDoc.dispatchDocType' /></c:set>	
						<th>${tdispatchDocType}</th>
					
						<c:set var="tdispatchCanOpen"><bean:message bundle='monitorRes' key='dispatchDoc.dispatchCanOpen' /></c:set>	
						<th>${tdispatchCanOpen}</th>
					
						<c:set var="tdispatchOpenType"><bean:message bundle='monitorRes' key='dispatchDoc.dispatchOpenType' /></c:set>	
						<th>${tdispatchOpenType}</th>
					
						<c:set var="tnotOpenReason"><bean:message bundle='monitorRes' key='dispatchDoc.notOpenReason' /></c:set>	
						<th>${tnotOpenReason}</th>
					
						<c:set var="tisUnionDispatch"><bean:message bundle='monitorRes' key='dispatchDoc.isUnionDispatch' /></c:set>	
						<th>${tisUnionDispatch}</th>
					
						<c:set var="tunionOthers"><bean:message bundle='monitorRes' key='dispatchDoc.unionOthers' /></c:set>	
						<th>${tunionOthers}</th>
					
						<c:set var="tisCountersign"><bean:message bundle='monitorRes' key='dispatchDoc.isCountersign' /></c:set>	
						<th>${tisCountersign}</th>
					
						<c:set var="tdispatchDocSummary"><bean:message bundle='monitorRes' key='dispatchDoc.dispatchDocSummary' /></c:set>	
						<th>${tdispatchDocSummary}</th>
					
						<c:set var="tdraftDate"><bean:message bundle='monitorRes' key='dispatchDoc.draftDate' /></c:set>	
						<th>${tdraftDate}</th>
					
						<c:set var="toptUnitName"><bean:message bundle='monitorRes' key='dispatchDoc.optUnitName' /></c:set>	
						<th>${toptUnitName}</th>
					
						<c:set var="tdraftUserName"><bean:message bundle='monitorRes' key='dispatchDoc.draftUserName' /></c:set>	
						<th>${tdraftUserName}</th>
					
						<c:set var="tsecretsDegree"><bean:message bundle='monitorRes' key='dispatchDoc.secretsDegree' /></c:set>	
						<th>${tsecretsDegree}</th>
					
						<c:set var="tcopies"><bean:message bundle='monitorRes' key='dispatchDoc.copies' /></c:set>	
						<th>${tcopies}</th>
					
						<c:set var="tmainNotifyUnit"><bean:message bundle='monitorRes' key='dispatchDoc.mainNotifyUnit' /></c:set>	
						<th>${tmainNotifyUnit}</th>
					
						<c:set var="totherUnits"><bean:message bundle='monitorRes' key='dispatchDoc.otherUnits' /></c:set>	
						<th>${totherUnits}</th>
					
						<c:set var="tretentionPeriod"><bean:message bundle='monitorRes' key='dispatchDoc.retentionPeriod' /></c:set>	
						<th>${tretentionPeriod}</th>
					
						<c:set var="tcheckUserName"><bean:message bundle='monitorRes' key='dispatchDoc.checkUserName' /></c:set>	
						<th>${tcheckUserName}</th>
					
						<c:set var="tdispatchDoc"><bean:message bundle='monitorRes' key='dispatchDoc.dispatchDoc' /></c:set>	
						<th>${tdispatchDoc}</th>
					
						<c:set var="tcreateDate"><bean:message bundle='monitorRes' key='dispatchDoc.createDate' /></c:set>	
						<th>${tcreateDate}</th>
					
						<c:set var="tupdateDate"><bean:message bundle='monitorRes' key='dispatchDoc.updateDate' /></c:set>	
						<th>${tupdateDate}</th>
					
						<c:set var="tsyncDate"><bean:message bundle='monitorRes' key='dispatchDoc.syncDate' /></c:set>	
						<th>${tsyncDate}</th>
					
						<c:set var="tsyncSign"><bean:message bundle='monitorRes' key='dispatchDoc.syncSign' /></c:set>	
						<th>${tsyncSign}</th>
					
						<c:set var="tsyncErrorDesc"><bean:message bundle='monitorRes' key='dispatchDoc.syncErrorDesc' /></c:set>	
						<th>${tsyncErrorDesc}</th>
					
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach items="${objList }" var="dispatchDoc">
						<tr target="pk" rel="${dispatchDoc.no}">
							
								<td>${dispatchDoc.no}</td>
							
							
								<td>${dispatchDoc.internalNo}</td>
							
								<td>${dispatchDoc.itemId}</td>
							
								<td>${dispatchDoc.dispatchDocNo}</td>
							
								<td>${dispatchDoc.dispatchDocTitle}</td>
							
								<td>${dispatchDoc.dispatchFileType}</td>
							
								<td>${dispatchDoc.dispatchDocType}</td>
							
								<td>${dispatchDoc.dispatchCanOpen}</td>
							
								<td>${dispatchDoc.dispatchOpenType}</td>
							
								<td>${dispatchDoc.notOpenReason}</td>
							
								<td>${dispatchDoc.isUnionDispatch}</td>
							
								<td>${dispatchDoc.unionOthers}</td>
							
								<td>${dispatchDoc.isCountersign}</td>
							
								<td>${dispatchDoc.dispatchDocSummary}</td>
							
								<td>${dispatchDoc.draftDate}</td>
							
								<td>${dispatchDoc.optUnitName}</td>
							
								<td>${dispatchDoc.draftUserName}</td>
							
								<td>${dispatchDoc.secretsDegree}</td>
							
								<td>${dispatchDoc.copies}</td>
							
								<td>${dispatchDoc.mainNotifyUnit}</td>
							
								<td>${dispatchDoc.otherUnits}</td>
							
								<td>${dispatchDoc.retentionPeriod}</td>
							
								<td>${dispatchDoc.checkUserName}</td>
							
								<td>${dispatchDoc.dispatchDoc}</td>
							
								<td>${dispatchDoc.createDate}</td>
							
								<td>${dispatchDoc.updateDate}</td>
							
								<td>${dispatchDoc.syncDate}</td>
							
								<td>${dispatchDoc.syncSign}</td>
							
								<td>${dispatchDoc.syncErrorDesc}</td>
							
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
		<title><c:out value="dispatchDoc.list.title" /></title>
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
			<html:form action="/monitor/dispatchDoc.do" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr height="22">
						<td><c:out value="dispatchDoc.no" />:</td>
						<td><html:text property="s_no" /> </td>
					</tr>	


					<tr height="22">
						<td><c:out value="dispatchDoc.internalNo" />:</td>
						<td><html:text property="s_internalNo" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="dispatchDoc.itemId" />:</td>
						<td><html:text property="s_itemId" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="dispatchDoc.dispatchDocNo" />:</td>
						<td><html:text property="s_dispatchDocNo" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="dispatchDoc.dispatchDocTitle" />:</td>
						<td><html:text property="s_dispatchDocTitle" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="dispatchDoc.dispatchFileType" />:</td>
						<td><html:text property="s_dispatchFileType" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="dispatchDoc.dispatchDocType" />:</td>
						<td><html:text property="s_dispatchDocType" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="dispatchDoc.dispatchCanOpen" />:</td>
						<td><html:text property="s_dispatchCanOpen" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="dispatchDoc.dispatchOpenType" />:</td>
						<td><html:text property="s_dispatchOpenType" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="dispatchDoc.notOpenReason" />:</td>
						<td><html:text property="s_notOpenReason" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="dispatchDoc.isUnionDispatch" />:</td>
						<td><html:text property="s_isUnionDispatch" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="dispatchDoc.unionOthers" />:</td>
						<td><html:text property="s_unionOthers" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="dispatchDoc.isCountersign" />:</td>
						<td><html:text property="s_isCountersign" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="dispatchDoc.dispatchDocSummary" />:</td>
						<td><html:text property="s_dispatchDocSummary" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="dispatchDoc.draftDate" />:</td>
						<td><html:text property="s_draftDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="dispatchDoc.optUnitName" />:</td>
						<td><html:text property="s_optUnitName" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="dispatchDoc.draftUserName" />:</td>
						<td><html:text property="s_draftUserName" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="dispatchDoc.secretsDegree" />:</td>
						<td><html:text property="s_secretsDegree" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="dispatchDoc.copies" />:</td>
						<td><html:text property="s_copies" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="dispatchDoc.mainNotifyUnit" />:</td>
						<td><html:text property="s_mainNotifyUnit" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="dispatchDoc.otherUnits" />:</td>
						<td><html:text property="s_otherUnits" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="dispatchDoc.retentionPeriod" />:</td>
						<td><html:text property="s_retentionPeriod" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="dispatchDoc.checkUserName" />:</td>
						<td><html:text property="s_checkUserName" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="dispatchDoc.dispatchDoc" />:</td>
						<td><html:text property="s_dispatchDoc" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="dispatchDoc.createDate" />:</td>
						<td><html:text property="s_createDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="dispatchDoc.updateDate" />:</td>
						<td><html:text property="s_updateDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="dispatchDoc.syncDate" />:</td>
						<td><html:text property="s_syncDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="dispatchDoc.syncSign" />:</td>
						<td><html:text property="s_syncSign" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="dispatchDoc.syncErrorDesc" />:</td>
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

			<ec:table action="dispatchDoc.do" items="dispatchDocs" var="dispatchDoc"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="dispatchDocs.xls" ></ec:exportXls>
			<ec:exportPdf fileName="dispatchDocs.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>
				
					<c:set var="tno"><bean:message bundle='monitorRes' key='dispatchDoc.no' /></c:set>	
					<ec:column property="no" title="${tno}" style="text-align:center" />
				
				
					<c:set var="tinternalNo"><bean:message bundle='monitorRes' key='dispatchDoc.internalNo' /></c:set>	
					<ec:column property="internalNo" title="${tinternalNo}" style="text-align:center" />
				
					<c:set var="titemId"><bean:message bundle='monitorRes' key='dispatchDoc.itemId' /></c:set>	
					<ec:column property="itemId" title="${titemId}" style="text-align:center" />
				
					<c:set var="tdispatchDocNo"><bean:message bundle='monitorRes' key='dispatchDoc.dispatchDocNo' /></c:set>	
					<ec:column property="dispatchDocNo" title="${tdispatchDocNo}" style="text-align:center" />
				
					<c:set var="tdispatchDocTitle"><bean:message bundle='monitorRes' key='dispatchDoc.dispatchDocTitle' /></c:set>	
					<ec:column property="dispatchDocTitle" title="${tdispatchDocTitle}" style="text-align:center" />
				
					<c:set var="tdispatchFileType"><bean:message bundle='monitorRes' key='dispatchDoc.dispatchFileType' /></c:set>	
					<ec:column property="dispatchFileType" title="${tdispatchFileType}" style="text-align:center" />
				
					<c:set var="tdispatchDocType"><bean:message bundle='monitorRes' key='dispatchDoc.dispatchDocType' /></c:set>	
					<ec:column property="dispatchDocType" title="${tdispatchDocType}" style="text-align:center" />
				
					<c:set var="tdispatchCanOpen"><bean:message bundle='monitorRes' key='dispatchDoc.dispatchCanOpen' /></c:set>	
					<ec:column property="dispatchCanOpen" title="${tdispatchCanOpen}" style="text-align:center" />
				
					<c:set var="tdispatchOpenType"><bean:message bundle='monitorRes' key='dispatchDoc.dispatchOpenType' /></c:set>	
					<ec:column property="dispatchOpenType" title="${tdispatchOpenType}" style="text-align:center" />
				
					<c:set var="tnotOpenReason"><bean:message bundle='monitorRes' key='dispatchDoc.notOpenReason' /></c:set>	
					<ec:column property="notOpenReason" title="${tnotOpenReason}" style="text-align:center" />
				
					<c:set var="tisUnionDispatch"><bean:message bundle='monitorRes' key='dispatchDoc.isUnionDispatch' /></c:set>	
					<ec:column property="isUnionDispatch" title="${tisUnionDispatch}" style="text-align:center" />
				
					<c:set var="tunionOthers"><bean:message bundle='monitorRes' key='dispatchDoc.unionOthers' /></c:set>	
					<ec:column property="unionOthers" title="${tunionOthers}" style="text-align:center" />
				
					<c:set var="tisCountersign"><bean:message bundle='monitorRes' key='dispatchDoc.isCountersign' /></c:set>	
					<ec:column property="isCountersign" title="${tisCountersign}" style="text-align:center" />
				
					<c:set var="tdispatchDocSummary"><bean:message bundle='monitorRes' key='dispatchDoc.dispatchDocSummary' /></c:set>	
					<ec:column property="dispatchDocSummary" title="${tdispatchDocSummary}" style="text-align:center" />
				
					<c:set var="tdraftDate"><bean:message bundle='monitorRes' key='dispatchDoc.draftDate' /></c:set>	
					<ec:column property="draftDate" title="${tdraftDate}" style="text-align:center" />
				
					<c:set var="toptUnitName"><bean:message bundle='monitorRes' key='dispatchDoc.optUnitName' /></c:set>	
					<ec:column property="optUnitName" title="${toptUnitName}" style="text-align:center" />
				
					<c:set var="tdraftUserName"><bean:message bundle='monitorRes' key='dispatchDoc.draftUserName' /></c:set>	
					<ec:column property="draftUserName" title="${tdraftUserName}" style="text-align:center" />
				
					<c:set var="tsecretsDegree"><bean:message bundle='monitorRes' key='dispatchDoc.secretsDegree' /></c:set>	
					<ec:column property="secretsDegree" title="${tsecretsDegree}" style="text-align:center" />
				
					<c:set var="tcopies"><bean:message bundle='monitorRes' key='dispatchDoc.copies' /></c:set>	
					<ec:column property="copies" title="${tcopies}" style="text-align:center" />
				
					<c:set var="tmainNotifyUnit"><bean:message bundle='monitorRes' key='dispatchDoc.mainNotifyUnit' /></c:set>	
					<ec:column property="mainNotifyUnit" title="${tmainNotifyUnit}" style="text-align:center" />
				
					<c:set var="totherUnits"><bean:message bundle='monitorRes' key='dispatchDoc.otherUnits' /></c:set>	
					<ec:column property="otherUnits" title="${totherUnits}" style="text-align:center" />
				
					<c:set var="tretentionPeriod"><bean:message bundle='monitorRes' key='dispatchDoc.retentionPeriod' /></c:set>	
					<ec:column property="retentionPeriod" title="${tretentionPeriod}" style="text-align:center" />
				
					<c:set var="tcheckUserName"><bean:message bundle='monitorRes' key='dispatchDoc.checkUserName' /></c:set>	
					<ec:column property="checkUserName" title="${tcheckUserName}" style="text-align:center" />
				
					<c:set var="tdispatchDoc"><bean:message bundle='monitorRes' key='dispatchDoc.dispatchDoc' /></c:set>	
					<ec:column property="dispatchDoc" title="${tdispatchDoc}" style="text-align:center" />
				
					<c:set var="tcreateDate"><bean:message bundle='monitorRes' key='dispatchDoc.createDate' /></c:set>	
					<ec:column property="createDate" title="${tcreateDate}" style="text-align:center" />
				
					<c:set var="tupdateDate"><bean:message bundle='monitorRes' key='dispatchDoc.updateDate' /></c:set>	
					<ec:column property="updateDate" title="${tupdateDate}" style="text-align:center" />
				
					<c:set var="tsyncDate"><bean:message bundle='monitorRes' key='dispatchDoc.syncDate' /></c:set>	
					<ec:column property="syncDate" title="${tsyncDate}" style="text-align:center" />
				
					<c:set var="tsyncSign"><bean:message bundle='monitorRes' key='dispatchDoc.syncSign' /></c:set>	
					<ec:column property="syncSign" title="${tsyncSign}" style="text-align:center" />
				
					<c:set var="tsyncErrorDesc"><bean:message bundle='monitorRes' key='dispatchDoc.syncErrorDesc' /></c:set>	
					<ec:column property="syncErrorDesc" title="${tsyncErrorDesc}" style="text-align:center" />
						
				<c:set var="optlabel"><bean:message key="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><bean:message key="label.delete.confirm"/></c:set>
					<a href='dispatchDoc.do?no=${dispatchDoc.no}&method=view'><bean:message key="opt.btn.view" /></a>
					<a href='dispatchDoc.do?no=${dispatchDoc.no}&method=edit'><bean:message key="opt.btn.edit" /></a>
					<a href='dispatchDoc.do?no=${dispatchDoc.no}&method=delete' 
							onclick='return confirm("${deletecofirm}dispatchDoc?");'><bean:message key="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
 --%>