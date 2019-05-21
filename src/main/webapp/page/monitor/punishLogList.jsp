<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<form id="pagerForm" method="post" action="punishLog.do">
	<input type="hidden" name="pageNum" value="1" /> <input type="hidden" name="numPerPage" value="${pageDesc.pageSize}" /> <input type="hidden" name="orderField"
		value="${s_orderField}" />
</form>



<div class="pageHeader">
	<s:form id="pagerForm" onsubmit="return navTabSearch(this);" action="/monitor/punishLog.do" method="post">
		<div class="searchBar">
			<ul class="searchContent">
				
					<li><label><c:out value="punishLog.no" />:</label> <s:textfield name="s_no" value="%{#parameters['s_no']}" /></li>
				
					<li><label><c:out value="punishLog.changNo" />:</label> <s:textfield name="s_changNo" value="%{#parameters['s_changNo']}" /></li>
				
				
					<li><label><c:out value="punishLog.orgId" />:</label> <s:textfield name="s_orgId" value="%{#parameters['s_orgId']}" /></li>
				
					<li><label><c:out value="punishLog.internalNo" />:</label> <s:textfield name="s_internalNo" value="%{#parameters['s_internalNo']}" /></li>
				
					<li><label><c:out value="punishLog.itemId" />:</label> <s:textfield name="s_itemId" value="%{#parameters['s_itemId']}" /></li>
				
					<li><label><c:out value="punishLog.department" />:</label> <s:textfield name="s_department" value="%{#parameters['s_department']}" /></li>
				
					<li><label><c:out value="punishLog.ajAddr" />:</label> <s:textfield name="s_ajAddr" value="%{#parameters['s_ajAddr']}" /></li>
				
					<li><label><c:out value="punishLog.ajOccurDate" />:</label> <s:textfield name="s_ajOccurDate" value="%{#parameters['s_ajOccurDate']}" /></li>
				
					<li><label><c:out value="punishLog.source" />:</label> <s:textfield name="s_source" value="%{#parameters['s_source']}" /></li>
				
					<li><label><c:out value="punishLog.fact" />:</label> <s:textfield name="s_fact" value="%{#parameters['s_fact']}" /></li>
				
					<li><label><c:out value="punishLog.targetType" />:</label> <s:textfield name="s_targetType" value="%{#parameters['s_targetType']}" /></li>
				
					<li><label><c:out value="punishLog.punishTarget" />:</label> <s:textfield name="s_punishTarget" value="%{#parameters['s_punishTarget']}" /></li>
				
					<li><label><c:out value="punishLog.targetCode" />:</label> <s:textfield name="s_targetCode" value="%{#parameters['s_targetCode']}" /></li>
				
					<li><label><c:out value="punishLog.targetPaperType" />:</label> <s:textfield name="s_targetPaperType" value="%{#parameters['s_targetPaperType']}" /></li>
				
					<li><label><c:out value="punishLog.targetPaperNumber" />:</label> <s:textfield name="s_targetPaperNumber" value="%{#parameters['s_targetPaperNumber']}" /></li>
				
					<li><label><c:out value="punishLog.targetPhone" />:</label> <s:textfield name="s_targetPhone" value="%{#parameters['s_targetPhone']}" /></li>
				
					<li><label><c:out value="punishLog.targetMobile" />:</label> <s:textfield name="s_targetMobile" value="%{#parameters['s_targetMobile']}" /></li>
				
					<li><label><c:out value="punishLog.targetAddress" />:</label> <s:textfield name="s_targetAddress" value="%{#parameters['s_targetAddress']}" /></li>
				
					<li><label><c:out value="punishLog.targetZipCode" />:</label> <s:textfield name="s_targetZipCode" value="%{#parameters['s_targetZipCode']}" /></li>
				
					<li><label><c:out value="punishLog.targetEmail" />:</label> <s:textfield name="s_targetEmail" value="%{#parameters['s_targetEmail']}" /></li>
				
					<li><label><c:out value="punishLog.reporter" />:</label> <s:textfield name="s_reporter" value="%{#parameters['s_reporter']}" /></li>
				
					<li><label><c:out value="punishLog.reporterDate" />:</label> <s:textfield name="s_reporterDate" value="%{#parameters['s_reporterDate']}" /></li>
				
					<li><label><c:out value="punishLog.reporterPaperType" />:</label> <s:textfield name="s_reporterPaperType" value="%{#parameters['s_reporterPaperType']}" /></li>
				
					<li><label><c:out value="punishLog.reporterAperCode" />:</label> <s:textfield name="s_reporterAperCode" value="%{#parameters['s_reporterAperCode']}" /></li>
				
					<li><label><c:out value="punishLog.reporterPhone" />:</label> <s:textfield name="s_reporterPhone" value="%{#parameters['s_reporterPhone']}" /></li>
				
					<li><label><c:out value="punishLog.reporterMobile" />:</label> <s:textfield name="s_reporterMobile" value="%{#parameters['s_reporterMobile']}" /></li>
				
					<li><label><c:out value="punishLog.reporterAddress" />:</label> <s:textfield name="s_reporterAddress" value="%{#parameters['s_reporterAddress']}" /></li>
				
					<li><label><c:out value="punishLog.reporterZipcode" />:</label> <s:textfield name="s_reporterZipcode" value="%{#parameters['s_reporterZipcode']}" /></li>
				
					<li><label><c:out value="punishLog.reporterEmail" />:</label> <s:textfield name="s_reporterEmail" value="%{#parameters['s_reporterEmail']}" /></li>
				
					<li><label><c:out value="punishLog.content" />:</label> <s:textfield name="s_content" value="%{#parameters['s_content']}" /></li>
				
					<li><label><c:out value="punishLog.form" />:</label> <s:textfield name="s_form" value="%{#parameters['s_form']}" /></li>
				
					<li><label><c:out value="punishLog.promise" />:</label> <s:textfield name="s_promise" value="%{#parameters['s_promise']}" /></li>
				
					<li><label><c:out value="punishLog.promiseType" />:</label> <s:textfield name="s_promiseType" value="%{#parameters['s_promiseType']}" /></li>
				
					<li><label><c:out value="punishLog.isrisk" />:</label> <s:textfield name="s_isrisk" value="%{#parameters['s_isrisk']}" /></li>
				
					<li><label><c:out value="punishLog.risktype" />:</label> <s:textfield name="s_risktype" value="%{#parameters['s_risktype']}" /></li>
				
					<li><label><c:out value="punishLog.riskdescription" />:</label> <s:textfield name="s_riskdescription" value="%{#parameters['s_riskdescription']}" /></li>
				
					<li><label><c:out value="punishLog.riskresult" />:</label> <s:textfield name="s_riskresult" value="%{#parameters['s_riskresult']}" /></li>
				
					<li><label><c:out value="punishLog.createDate" />:</label> <s:textfield name="s_createDate" value="%{#parameters['s_createDate']}" /></li>
				
					<li><label><c:out value="punishLog.updateDate" />:</label> <s:textfield name="s_updateDate" value="%{#parameters['s_updateDate']}" /></li>
				
					<li><label><c:out value="punishLog.syncDate" />:</label> <s:textfield name="s_syncDate" value="%{#parameters['s_syncDate']}" /></li>
				
					<li><label><c:out value="punishLog.syncSign" />:</label> <s:textfield name="s_syncSign" value="%{#parameters['s_syncSign']}" /></li>
				
					<li><label><c:out value="punishLog.syncErrorDesc" />:</label> <s:textfield name="s_syncErrorDesc" value="%{#parameters['s_syncErrorDesc']}" /></li>
				
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
			<li><a class="add" href="${contextPath }/monitor/punishLog!edit.do" rel="" target='dialog'><span>添加</span></a></li>
			<li><a class="edit" href="${contextPath }/monitor/punishLog!edit.do?nochangNo={pk}" warn="请选择一条记录" rel="" target='dialog'><span>编辑</span></a></li>
			<li><a class="delete" href="${contextPath }/monitor/punishLog!delete.do?nochangNo={pk}" warn="请选择一条记录" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</ul>
	</div>

	<div layoutH="116">
		<table class="list" width="98%" targetType="navTab" asc="asc" desc="desc">
			<thead align="center">

				<tr>
					
						<c:set var="tno"><bean:message bundle='monitorRes' key='punishLog.no' /></c:set>	
						<th>${tno}</th>
					
						<c:set var="tchangNo"><bean:message bundle='monitorRes' key='punishLog.changNo' /></c:set>	
						<th>${tchangNo}</th>
					
					
						<c:set var="torgId"><bean:message bundle='monitorRes' key='punishLog.orgId' /></c:set>	
						<th>${torgId}</th>
					
						<c:set var="tinternalNo"><bean:message bundle='monitorRes' key='punishLog.internalNo' /></c:set>	
						<th>${tinternalNo}</th>
					
						<c:set var="titemId"><bean:message bundle='monitorRes' key='punishLog.itemId' /></c:set>	
						<th>${titemId}</th>
					
						<c:set var="tdepartment"><bean:message bundle='monitorRes' key='punishLog.department' /></c:set>	
						<th>${tdepartment}</th>
					
						<c:set var="tajAddr"><bean:message bundle='monitorRes' key='punishLog.ajAddr' /></c:set>	
						<th>${tajAddr}</th>
					
						<c:set var="tajOccurDate"><bean:message bundle='monitorRes' key='punishLog.ajOccurDate' /></c:set>	
						<th>${tajOccurDate}</th>
					
						<c:set var="tsource"><bean:message bundle='monitorRes' key='punishLog.source' /></c:set>	
						<th>${tsource}</th>
					
						<c:set var="tfact"><bean:message bundle='monitorRes' key='punishLog.fact' /></c:set>	
						<th>${tfact}</th>
					
						<c:set var="ttargetType"><bean:message bundle='monitorRes' key='punishLog.targetType' /></c:set>	
						<th>${ttargetType}</th>
					
						<c:set var="tpunishTarget"><bean:message bundle='monitorRes' key='punishLog.punishTarget' /></c:set>	
						<th>${tpunishTarget}</th>
					
						<c:set var="ttargetCode"><bean:message bundle='monitorRes' key='punishLog.targetCode' /></c:set>	
						<th>${ttargetCode}</th>
					
						<c:set var="ttargetPaperType"><bean:message bundle='monitorRes' key='punishLog.targetPaperType' /></c:set>	
						<th>${ttargetPaperType}</th>
					
						<c:set var="ttargetPaperNumber"><bean:message bundle='monitorRes' key='punishLog.targetPaperNumber' /></c:set>	
						<th>${ttargetPaperNumber}</th>
					
						<c:set var="ttargetPhone"><bean:message bundle='monitorRes' key='punishLog.targetPhone' /></c:set>	
						<th>${ttargetPhone}</th>
					
						<c:set var="ttargetMobile"><bean:message bundle='monitorRes' key='punishLog.targetMobile' /></c:set>	
						<th>${ttargetMobile}</th>
					
						<c:set var="ttargetAddress"><bean:message bundle='monitorRes' key='punishLog.targetAddress' /></c:set>	
						<th>${ttargetAddress}</th>
					
						<c:set var="ttargetZipCode"><bean:message bundle='monitorRes' key='punishLog.targetZipCode' /></c:set>	
						<th>${ttargetZipCode}</th>
					
						<c:set var="ttargetEmail"><bean:message bundle='monitorRes' key='punishLog.targetEmail' /></c:set>	
						<th>${ttargetEmail}</th>
					
						<c:set var="treporter"><bean:message bundle='monitorRes' key='punishLog.reporter' /></c:set>	
						<th>${treporter}</th>
					
						<c:set var="treporterDate"><bean:message bundle='monitorRes' key='punishLog.reporterDate' /></c:set>	
						<th>${treporterDate}</th>
					
						<c:set var="treporterPaperType"><bean:message bundle='monitorRes' key='punishLog.reporterPaperType' /></c:set>	
						<th>${treporterPaperType}</th>
					
						<c:set var="treporterAperCode"><bean:message bundle='monitorRes' key='punishLog.reporterAperCode' /></c:set>	
						<th>${treporterAperCode}</th>
					
						<c:set var="treporterPhone"><bean:message bundle='monitorRes' key='punishLog.reporterPhone' /></c:set>	
						<th>${treporterPhone}</th>
					
						<c:set var="treporterMobile"><bean:message bundle='monitorRes' key='punishLog.reporterMobile' /></c:set>	
						<th>${treporterMobile}</th>
					
						<c:set var="treporterAddress"><bean:message bundle='monitorRes' key='punishLog.reporterAddress' /></c:set>	
						<th>${treporterAddress}</th>
					
						<c:set var="treporterZipcode"><bean:message bundle='monitorRes' key='punishLog.reporterZipcode' /></c:set>	
						<th>${treporterZipcode}</th>
					
						<c:set var="treporterEmail"><bean:message bundle='monitorRes' key='punishLog.reporterEmail' /></c:set>	
						<th>${treporterEmail}</th>
					
						<c:set var="tcontent"><bean:message bundle='monitorRes' key='punishLog.content' /></c:set>	
						<th>${tcontent}</th>
					
						<c:set var="tform"><bean:message bundle='monitorRes' key='punishLog.form' /></c:set>	
						<th>${tform}</th>
					
						<c:set var="tpromise"><bean:message bundle='monitorRes' key='punishLog.promise' /></c:set>	
						<th>${tpromise}</th>
					
						<c:set var="tpromiseType"><bean:message bundle='monitorRes' key='punishLog.promiseType' /></c:set>	
						<th>${tpromiseType}</th>
					
						<c:set var="tisrisk"><bean:message bundle='monitorRes' key='punishLog.isrisk' /></c:set>	
						<th>${tisrisk}</th>
					
						<c:set var="trisktype"><bean:message bundle='monitorRes' key='punishLog.risktype' /></c:set>	
						<th>${trisktype}</th>
					
						<c:set var="triskdescription"><bean:message bundle='monitorRes' key='punishLog.riskdescription' /></c:set>	
						<th>${triskdescription}</th>
					
						<c:set var="triskresult"><bean:message bundle='monitorRes' key='punishLog.riskresult' /></c:set>	
						<th>${triskresult}</th>
					
						<c:set var="tcreateDate"><bean:message bundle='monitorRes' key='punishLog.createDate' /></c:set>	
						<th>${tcreateDate}</th>
					
						<c:set var="tupdateDate"><bean:message bundle='monitorRes' key='punishLog.updateDate' /></c:set>	
						<th>${tupdateDate}</th>
					
						<c:set var="tsyncDate"><bean:message bundle='monitorRes' key='punishLog.syncDate' /></c:set>	
						<th>${tsyncDate}</th>
					
						<c:set var="tsyncSign"><bean:message bundle='monitorRes' key='punishLog.syncSign' /></c:set>	
						<th>${tsyncSign}</th>
					
						<c:set var="tsyncErrorDesc"><bean:message bundle='monitorRes' key='punishLog.syncErrorDesc' /></c:set>	
						<th>${tsyncErrorDesc}</th>
					
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach items="${objList }" var="punishLog">
						<tr target="pk" rel="${punishLog.no}">
							
								<td>${punishLog.no}</td>
							
								<td>${punishLog.changNo}</td>
							
							
								<td>${punishLog.orgId}</td>
							
								<td>${punishLog.internalNo}</td>
							
								<td>${punishLog.itemId}</td>
							
								<td>${punishLog.department}</td>
							
								<td>${punishLog.ajAddr}</td>
							
								<td>${punishLog.ajOccurDate}</td>
							
								<td>${punishLog.source}</td>
							
								<td>${punishLog.fact}</td>
							
								<td>${punishLog.targetType}</td>
							
								<td>${punishLog.punishTarget}</td>
							
								<td>${punishLog.targetCode}</td>
							
								<td>${punishLog.targetPaperType}</td>
							
								<td>${punishLog.targetPaperNumber}</td>
							
								<td>${punishLog.targetPhone}</td>
							
								<td>${punishLog.targetMobile}</td>
							
								<td>${punishLog.targetAddress}</td>
							
								<td>${punishLog.targetZipCode}</td>
							
								<td>${punishLog.targetEmail}</td>
							
								<td>${punishLog.reporter}</td>
							
								<td>${punishLog.reporterDate}</td>
							
								<td>${punishLog.reporterPaperType}</td>
							
								<td>${punishLog.reporterAperCode}</td>
							
								<td>${punishLog.reporterPhone}</td>
							
								<td>${punishLog.reporterMobile}</td>
							
								<td>${punishLog.reporterAddress}</td>
							
								<td>${punishLog.reporterZipcode}</td>
							
								<td>${punishLog.reporterEmail}</td>
							
								<td>${punishLog.content}</td>
							
								<td>${punishLog.form}</td>
							
								<td>${punishLog.promise}</td>
							
								<td>${punishLog.promiseType}</td>
							
								<td>${punishLog.isrisk}</td>
							
								<td>${punishLog.risktype}</td>
							
								<td>${punishLog.riskdescription}</td>
							
								<td>${punishLog.riskresult}</td>
							
								<td>${punishLog.createDate}</td>
							
								<td>${punishLog.updateDate}</td>
							
								<td>${punishLog.syncDate}</td>
							
								<td>${punishLog.syncSign}</td>
							
								<td>${punishLog.syncErrorDesc}</td>
							
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
		<title><c:out value="punishLog.list.title" /></title>
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
			<html:form action="/monitor/punishLog.do" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr height="22">
						<td><c:out value="punishLog.no" />:</td>
						<td><html:text property="s_no" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.changNo" />:</td>
						<td><html:text property="s_changNo" /> </td>
					</tr>	


					<tr height="22">
						<td><c:out value="punishLog.orgId" />:</td>
						<td><html:text property="s_orgId" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.internalNo" />:</td>
						<td><html:text property="s_internalNo" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.itemId" />:</td>
						<td><html:text property="s_itemId" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.department" />:</td>
						<td><html:text property="s_department" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.ajAddr" />:</td>
						<td><html:text property="s_ajAddr" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.ajOccurDate" />:</td>
						<td><html:text property="s_ajOccurDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.source" />:</td>
						<td><html:text property="s_source" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.fact" />:</td>
						<td><html:text property="s_fact" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.targetType" />:</td>
						<td><html:text property="s_targetType" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.punishTarget" />:</td>
						<td><html:text property="s_punishTarget" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.targetCode" />:</td>
						<td><html:text property="s_targetCode" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.targetPaperType" />:</td>
						<td><html:text property="s_targetPaperType" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.targetPaperNumber" />:</td>
						<td><html:text property="s_targetPaperNumber" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.targetPhone" />:</td>
						<td><html:text property="s_targetPhone" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.targetMobile" />:</td>
						<td><html:text property="s_targetMobile" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.targetAddress" />:</td>
						<td><html:text property="s_targetAddress" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.targetZipCode" />:</td>
						<td><html:text property="s_targetZipCode" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.targetEmail" />:</td>
						<td><html:text property="s_targetEmail" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.reporter" />:</td>
						<td><html:text property="s_reporter" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.reporterDate" />:</td>
						<td><html:text property="s_reporterDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.reporterPaperType" />:</td>
						<td><html:text property="s_reporterPaperType" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.reporterAperCode" />:</td>
						<td><html:text property="s_reporterAperCode" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.reporterPhone" />:</td>
						<td><html:text property="s_reporterPhone" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.reporterMobile" />:</td>
						<td><html:text property="s_reporterMobile" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.reporterAddress" />:</td>
						<td><html:text property="s_reporterAddress" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.reporterZipcode" />:</td>
						<td><html:text property="s_reporterZipcode" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.reporterEmail" />:</td>
						<td><html:text property="s_reporterEmail" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.content" />:</td>
						<td><html:text property="s_content" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.form" />:</td>
						<td><html:text property="s_form" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.promise" />:</td>
						<td><html:text property="s_promise" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.promiseType" />:</td>
						<td><html:text property="s_promiseType" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.isrisk" />:</td>
						<td><html:text property="s_isrisk" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.risktype" />:</td>
						<td><html:text property="s_risktype" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.riskdescription" />:</td>
						<td><html:text property="s_riskdescription" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.riskresult" />:</td>
						<td><html:text property="s_riskresult" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.createDate" />:</td>
						<td><html:text property="s_createDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.updateDate" />:</td>
						<td><html:text property="s_updateDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.syncDate" />:</td>
						<td><html:text property="s_syncDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.syncSign" />:</td>
						<td><html:text property="s_syncSign" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="punishLog.syncErrorDesc" />:</td>
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

			<ec:table action="punishLog.do" items="punishLogs" var="punishLog"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="punishLogs.xls" ></ec:exportXls>
			<ec:exportPdf fileName="punishLogs.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>
				
					<c:set var="tno"><bean:message bundle='monitorRes' key='punishLog.no' /></c:set>	
					<ec:column property="no" title="${tno}" style="text-align:center" />
				
					<c:set var="tchangNo"><bean:message bundle='monitorRes' key='punishLog.changNo' /></c:set>	
					<ec:column property="changNo" title="${tchangNo}" style="text-align:center" />
				
				
					<c:set var="torgId"><bean:message bundle='monitorRes' key='punishLog.orgId' /></c:set>	
					<ec:column property="orgId" title="${torgId}" style="text-align:center" />
				
					<c:set var="tinternalNo"><bean:message bundle='monitorRes' key='punishLog.internalNo' /></c:set>	
					<ec:column property="internalNo" title="${tinternalNo}" style="text-align:center" />
				
					<c:set var="titemId"><bean:message bundle='monitorRes' key='punishLog.itemId' /></c:set>	
					<ec:column property="itemId" title="${titemId}" style="text-align:center" />
				
					<c:set var="tdepartment"><bean:message bundle='monitorRes' key='punishLog.department' /></c:set>	
					<ec:column property="department" title="${tdepartment}" style="text-align:center" />
				
					<c:set var="tajAddr"><bean:message bundle='monitorRes' key='punishLog.ajAddr' /></c:set>	
					<ec:column property="ajAddr" title="${tajAddr}" style="text-align:center" />
				
					<c:set var="tajOccurDate"><bean:message bundle='monitorRes' key='punishLog.ajOccurDate' /></c:set>	
					<ec:column property="ajOccurDate" title="${tajOccurDate}" style="text-align:center" />
				
					<c:set var="tsource"><bean:message bundle='monitorRes' key='punishLog.source' /></c:set>	
					<ec:column property="source" title="${tsource}" style="text-align:center" />
				
					<c:set var="tfact"><bean:message bundle='monitorRes' key='punishLog.fact' /></c:set>	
					<ec:column property="fact" title="${tfact}" style="text-align:center" />
				
					<c:set var="ttargetType"><bean:message bundle='monitorRes' key='punishLog.targetType' /></c:set>	
					<ec:column property="targetType" title="${ttargetType}" style="text-align:center" />
				
					<c:set var="tpunishTarget"><bean:message bundle='monitorRes' key='punishLog.punishTarget' /></c:set>	
					<ec:column property="punishTarget" title="${tpunishTarget}" style="text-align:center" />
				
					<c:set var="ttargetCode"><bean:message bundle='monitorRes' key='punishLog.targetCode' /></c:set>	
					<ec:column property="targetCode" title="${ttargetCode}" style="text-align:center" />
				
					<c:set var="ttargetPaperType"><bean:message bundle='monitorRes' key='punishLog.targetPaperType' /></c:set>	
					<ec:column property="targetPaperType" title="${ttargetPaperType}" style="text-align:center" />
				
					<c:set var="ttargetPaperNumber"><bean:message bundle='monitorRes' key='punishLog.targetPaperNumber' /></c:set>	
					<ec:column property="targetPaperNumber" title="${ttargetPaperNumber}" style="text-align:center" />
				
					<c:set var="ttargetPhone"><bean:message bundle='monitorRes' key='punishLog.targetPhone' /></c:set>	
					<ec:column property="targetPhone" title="${ttargetPhone}" style="text-align:center" />
				
					<c:set var="ttargetMobile"><bean:message bundle='monitorRes' key='punishLog.targetMobile' /></c:set>	
					<ec:column property="targetMobile" title="${ttargetMobile}" style="text-align:center" />
				
					<c:set var="ttargetAddress"><bean:message bundle='monitorRes' key='punishLog.targetAddress' /></c:set>	
					<ec:column property="targetAddress" title="${ttargetAddress}" style="text-align:center" />
				
					<c:set var="ttargetZipCode"><bean:message bundle='monitorRes' key='punishLog.targetZipCode' /></c:set>	
					<ec:column property="targetZipCode" title="${ttargetZipCode}" style="text-align:center" />
				
					<c:set var="ttargetEmail"><bean:message bundle='monitorRes' key='punishLog.targetEmail' /></c:set>	
					<ec:column property="targetEmail" title="${ttargetEmail}" style="text-align:center" />
				
					<c:set var="treporter"><bean:message bundle='monitorRes' key='punishLog.reporter' /></c:set>	
					<ec:column property="reporter" title="${treporter}" style="text-align:center" />
				
					<c:set var="treporterDate"><bean:message bundle='monitorRes' key='punishLog.reporterDate' /></c:set>	
					<ec:column property="reporterDate" title="${treporterDate}" style="text-align:center" />
				
					<c:set var="treporterPaperType"><bean:message bundle='monitorRes' key='punishLog.reporterPaperType' /></c:set>	
					<ec:column property="reporterPaperType" title="${treporterPaperType}" style="text-align:center" />
				
					<c:set var="treporterAperCode"><bean:message bundle='monitorRes' key='punishLog.reporterAperCode' /></c:set>	
					<ec:column property="reporterAperCode" title="${treporterAperCode}" style="text-align:center" />
				
					<c:set var="treporterPhone"><bean:message bundle='monitorRes' key='punishLog.reporterPhone' /></c:set>	
					<ec:column property="reporterPhone" title="${treporterPhone}" style="text-align:center" />
				
					<c:set var="treporterMobile"><bean:message bundle='monitorRes' key='punishLog.reporterMobile' /></c:set>	
					<ec:column property="reporterMobile" title="${treporterMobile}" style="text-align:center" />
				
					<c:set var="treporterAddress"><bean:message bundle='monitorRes' key='punishLog.reporterAddress' /></c:set>	
					<ec:column property="reporterAddress" title="${treporterAddress}" style="text-align:center" />
				
					<c:set var="treporterZipcode"><bean:message bundle='monitorRes' key='punishLog.reporterZipcode' /></c:set>	
					<ec:column property="reporterZipcode" title="${treporterZipcode}" style="text-align:center" />
				
					<c:set var="treporterEmail"><bean:message bundle='monitorRes' key='punishLog.reporterEmail' /></c:set>	
					<ec:column property="reporterEmail" title="${treporterEmail}" style="text-align:center" />
				
					<c:set var="tcontent"><bean:message bundle='monitorRes' key='punishLog.content' /></c:set>	
					<ec:column property="content" title="${tcontent}" style="text-align:center" />
				
					<c:set var="tform"><bean:message bundle='monitorRes' key='punishLog.form' /></c:set>	
					<ec:column property="form" title="${tform}" style="text-align:center" />
				
					<c:set var="tpromise"><bean:message bundle='monitorRes' key='punishLog.promise' /></c:set>	
					<ec:column property="promise" title="${tpromise}" style="text-align:center" />
				
					<c:set var="tpromiseType"><bean:message bundle='monitorRes' key='punishLog.promiseType' /></c:set>	
					<ec:column property="promiseType" title="${tpromiseType}" style="text-align:center" />
				
					<c:set var="tisrisk"><bean:message bundle='monitorRes' key='punishLog.isrisk' /></c:set>	
					<ec:column property="isrisk" title="${tisrisk}" style="text-align:center" />
				
					<c:set var="trisktype"><bean:message bundle='monitorRes' key='punishLog.risktype' /></c:set>	
					<ec:column property="risktype" title="${trisktype}" style="text-align:center" />
				
					<c:set var="triskdescription"><bean:message bundle='monitorRes' key='punishLog.riskdescription' /></c:set>	
					<ec:column property="riskdescription" title="${triskdescription}" style="text-align:center" />
				
					<c:set var="triskresult"><bean:message bundle='monitorRes' key='punishLog.riskresult' /></c:set>	
					<ec:column property="riskresult" title="${triskresult}" style="text-align:center" />
				
					<c:set var="tcreateDate"><bean:message bundle='monitorRes' key='punishLog.createDate' /></c:set>	
					<ec:column property="createDate" title="${tcreateDate}" style="text-align:center" />
				
					<c:set var="tupdateDate"><bean:message bundle='monitorRes' key='punishLog.updateDate' /></c:set>	
					<ec:column property="updateDate" title="${tupdateDate}" style="text-align:center" />
				
					<c:set var="tsyncDate"><bean:message bundle='monitorRes' key='punishLog.syncDate' /></c:set>	
					<ec:column property="syncDate" title="${tsyncDate}" style="text-align:center" />
				
					<c:set var="tsyncSign"><bean:message bundle='monitorRes' key='punishLog.syncSign' /></c:set>	
					<ec:column property="syncSign" title="${tsyncSign}" style="text-align:center" />
				
					<c:set var="tsyncErrorDesc"><bean:message bundle='monitorRes' key='punishLog.syncErrorDesc' /></c:set>	
					<ec:column property="syncErrorDesc" title="${tsyncErrorDesc}" style="text-align:center" />
						
				<c:set var="optlabel"><bean:message key="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><bean:message key="label.delete.confirm"/></c:set>
					<a href='punishLog.do?no=${punishLog.no}&changNo=${punishLog.changNo}&method=view'><bean:message key="opt.btn.view" /></a>
					<a href='punishLog.do?no=${punishLog.no}&changNo=${punishLog.changNo}&method=edit'><bean:message key="opt.btn.edit" /></a>
					<a href='punishLog.do?no=${punishLog.no}&changNo=${punishLog.changNo}&method=delete' 
							onclick='return confirm("${deletecofirm}punishLog?");'><bean:message key="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
 --%>