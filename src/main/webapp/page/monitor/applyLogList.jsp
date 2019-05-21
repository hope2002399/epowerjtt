<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<form id="pagerForm" method="post" action="applyLog.do">
	<input type="hidden" name="pageNum" value="1" /> <input type="hidden" name="numPerPage" value="${pageDesc.pageSize}" /> <input type="hidden" name="orderField"
		value="${s_orderField}" />
</form>



<div class="pageHeader">
	<s:form id="pagerForm" onsubmit="return navTabSearch(this);" action="/monitor/applyLog.do" method="post">
		<div class="searchBar">
			<ul class="searchContent">
				
					<li><label><c:out value="applyLog.no" />:</label> <s:textfield name="s_no" value="%{#parameters['s_no']}" /></li>
				
					<li><label><c:out value="applyLog.changNo" />:</label> <s:textfield name="s_changNo" value="%{#parameters['s_changNo']}" /></li>
				
				
					<li><label><c:out value="applyLog.orgId" />:</label> <s:textfield name="s_orgId" value="%{#parameters['s_orgId']}" /></li>
				
					<li><label><c:out value="applyLog.internalNo" />:</label> <s:textfield name="s_internalNo" value="%{#parameters['s_internalNo']}" /></li>
				
					<li><label><c:out value="applyLog.itemId" />:</label> <s:textfield name="s_itemId" value="%{#parameters['s_itemId']}" /></li>
				
					<li><label><c:out value="applyLog.department" />:</label> <s:textfield name="s_department" value="%{#parameters['s_department']}" /></li>
				
					<li><label><c:out value="applyLog.transactAffairName" />:</label> <s:textfield name="s_transactAffairName" value="%{#parameters['s_transactAffairName']}" /></li>
				
					<li><label><c:out value="applyLog.content" />:</label> <s:textfield name="s_content" value="%{#parameters['s_content']}" /></li>
				
					<li><label><c:out value="applyLog.applyWay" />:</label> <s:textfield name="s_applyWay" value="%{#parameters['s_applyWay']}" /></li>
				
					<li><label><c:out value="applyLog.form" />:</label> <s:textfield name="s_form" value="%{#parameters['s_form']}" /></li>
				
					<li><label><c:out value="applyLog.stuff" />:</label> <s:textfield name="s_stuff" value="%{#parameters['s_stuff']}" /></li>
				
					<li><label><c:out value="applyLog.applicantCode" />:</label> <s:textfield name="s_applicantCode" value="%{#parameters['s_applicantCode']}" /></li>
				
					<li><label><c:out value="applyLog.applicantType" />:</label> <s:textfield name="s_applicantType" value="%{#parameters['s_applicantType']}" /></li>
				
					<li><label><c:out value="applyLog.applicantName" />:</label> <s:textfield name="s_applicantName" value="%{#parameters['s_applicantName']}" /></li>
				
					<li><label><c:out value="applyLog.applicantPaperType" />:</label> <s:textfield name="s_applicantPaperType" value="%{#parameters['s_applicantPaperType']}" /></li>
				
					<li><label><c:out value="applyLog.applicantPaperCode" />:</label> <s:textfield name="s_applicantPaperCode" value="%{#parameters['s_applicantPaperCode']}" /></li>
				
					<li><label><c:out value="applyLog.applicantPhone" />:</label> <s:textfield name="s_applicantPhone" value="%{#parameters['s_applicantPhone']}" /></li>
				
					<li><label><c:out value="applyLog.applicantMobile" />:</label> <s:textfield name="s_applicantMobile" value="%{#parameters['s_applicantMobile']}" /></li>
				
					<li><label><c:out value="applyLog.applicantAddress" />:</label> <s:textfield name="s_applicantAddress" value="%{#parameters['s_applicantAddress']}" /></li>
				
					<li><label><c:out value="applyLog.applicantZipcode" />:</label> <s:textfield name="s_applicantZipcode" value="%{#parameters['s_applicantZipcode']}" /></li>
				
					<li><label><c:out value="applyLog.applicantEmail" />:</label> <s:textfield name="s_applicantEmail" value="%{#parameters['s_applicantEmail']}" /></li>
				
					<li><label><c:out value="applyLog.linkman" />:</label> <s:textfield name="s_linkman" value="%{#parameters['s_linkman']}" /></li>
				
					<li><label><c:out value="applyLog.linkmanName" />:</label> <s:textfield name="s_linkmanName" value="%{#parameters['s_linkmanName']}" /></li>
				
					<li><label><c:out value="applyLog.linkmanPaperType" />:</label> <s:textfield name="s_linkmanPaperType" value="%{#parameters['s_linkmanPaperType']}" /></li>
				
					<li><label><c:out value="applyLog.linkmanPaperCode" />:</label> <s:textfield name="s_linkmanPaperCode" value="%{#parameters['s_linkmanPaperCode']}" /></li>
				
					<li><label><c:out value="applyLog.linkmanPhone" />:</label> <s:textfield name="s_linkmanPhone" value="%{#parameters['s_linkmanPhone']}" /></li>
				
					<li><label><c:out value="applyLog.linkmanMobile" />:</label> <s:textfield name="s_linkmanMobile" value="%{#parameters['s_linkmanMobile']}" /></li>
				
					<li><label><c:out value="applyLog.linkmanAddress" />:</label> <s:textfield name="s_linkmanAddress" value="%{#parameters['s_linkmanAddress']}" /></li>
				
					<li><label><c:out value="applyLog.linkmanZipcode" />:</label> <s:textfield name="s_linkmanZipcode" value="%{#parameters['s_linkmanZipcode']}" /></li>
				
					<li><label><c:out value="applyLog.linkmanEmail" />:</label> <s:textfield name="s_linkmanEmail" value="%{#parameters['s_linkmanEmail']}" /></li>
				
					<li><label><c:out value="applyLog.promise" />:</label> <s:textfield name="s_promise" value="%{#parameters['s_promise']}" /></li>
				
					<li><label><c:out value="applyLog.promiseType" />:</label> <s:textfield name="s_promiseType" value="%{#parameters['s_promiseType']}" /></li>
				
					<li><label><c:out value="applyLog.isrisk" />:</label> <s:textfield name="s_isrisk" value="%{#parameters['s_isrisk']}" /></li>
				
					<li><label><c:out value="applyLog.risktype" />:</label> <s:textfield name="s_risktype" value="%{#parameters['s_risktype']}" /></li>
				
					<li><label><c:out value="applyLog.riskdescription" />:</label> <s:textfield name="s_riskdescription" value="%{#parameters['s_riskdescription']}" /></li>
				
					<li><label><c:out value="applyLog.riskresult" />:</label> <s:textfield name="s_riskresult" value="%{#parameters['s_riskresult']}" /></li>
				
					<li><label><c:out value="applyLog.applyDate" />:</label> <s:textfield name="s_applyDate" value="%{#parameters['s_applyDate']}" /></li>
				
					<li><label><c:out value="applyLog.createDate" />:</label> <s:textfield name="s_createDate" value="%{#parameters['s_createDate']}" /></li>
				
					<li><label><c:out value="applyLog.updateDate" />:</label> <s:textfield name="s_updateDate" value="%{#parameters['s_updateDate']}" /></li>
				
					<li><label><c:out value="applyLog.syncDate" />:</label> <s:textfield name="s_syncDate" value="%{#parameters['s_syncDate']}" /></li>
				
					<li><label><c:out value="applyLog.syncSign" />:</label> <s:textfield name="s_syncSign" value="%{#parameters['s_syncSign']}" /></li>
				
					<li><label><c:out value="applyLog.syncErrorDesc" />:</label> <s:textfield name="s_syncErrorDesc" value="%{#parameters['s_syncErrorDesc']}" /></li>
				
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
			<li><a class="add" href="${contextPath }/monitor/applyLog!edit.do" rel="" target='dialog'><span>添加</span></a></li>
			<li><a class="edit" href="${contextPath }/monitor/applyLog!edit.do?nochangNo={pk}" warn="请选择一条记录" rel="" target='dialog'><span>编辑</span></a></li>
			<li><a class="delete" href="${contextPath }/monitor/applyLog!delete.do?nochangNo={pk}" warn="请选择一条记录" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</ul>
	</div>

	<div layoutH="116">
		<table class="list" width="98%" targetType="navTab" asc="asc" desc="desc">
			<thead align="center">

				<tr>
					
						<c:set var="tno"><bean:message bundle='monitorRes' key='applyLog.no' /></c:set>	
						<th>${tno}</th>
					
						<c:set var="tchangNo"><bean:message bundle='monitorRes' key='applyLog.changNo' /></c:set>	
						<th>${tchangNo}</th>
					
					
						<c:set var="torgId"><bean:message bundle='monitorRes' key='applyLog.orgId' /></c:set>	
						<th>${torgId}</th>
					
						<c:set var="tinternalNo"><bean:message bundle='monitorRes' key='applyLog.internalNo' /></c:set>	
						<th>${tinternalNo}</th>
					
						<c:set var="titemId"><bean:message bundle='monitorRes' key='applyLog.itemId' /></c:set>	
						<th>${titemId}</th>
					
						<c:set var="tdepartment"><bean:message bundle='monitorRes' key='applyLog.department' /></c:set>	
						<th>${tdepartment}</th>
					
						<c:set var="ttransactAffairName"><bean:message bundle='monitorRes' key='applyLog.transactAffairName' /></c:set>	
						<th>${ttransactAffairName}</th>
					
						<c:set var="tcontent"><bean:message bundle='monitorRes' key='applyLog.content' /></c:set>	
						<th>${tcontent}</th>
					
						<c:set var="tapplyWay"><bean:message bundle='monitorRes' key='applyLog.applyWay' /></c:set>	
						<th>${tapplyWay}</th>
					
						<c:set var="tform"><bean:message bundle='monitorRes' key='applyLog.form' /></c:set>	
						<th>${tform}</th>
					
						<c:set var="tstuff"><bean:message bundle='monitorRes' key='applyLog.stuff' /></c:set>	
						<th>${tstuff}</th>
					
						<c:set var="tapplicantCode"><bean:message bundle='monitorRes' key='applyLog.applicantCode' /></c:set>	
						<th>${tapplicantCode}</th>
					
						<c:set var="tapplicantType"><bean:message bundle='monitorRes' key='applyLog.applicantType' /></c:set>	
						<th>${tapplicantType}</th>
					
						<c:set var="tapplicantName"><bean:message bundle='monitorRes' key='applyLog.applicantName' /></c:set>	
						<th>${tapplicantName}</th>
					
						<c:set var="tapplicantPaperType"><bean:message bundle='monitorRes' key='applyLog.applicantPaperType' /></c:set>	
						<th>${tapplicantPaperType}</th>
					
						<c:set var="tapplicantPaperCode"><bean:message bundle='monitorRes' key='applyLog.applicantPaperCode' /></c:set>	
						<th>${tapplicantPaperCode}</th>
					
						<c:set var="tapplicantPhone"><bean:message bundle='monitorRes' key='applyLog.applicantPhone' /></c:set>	
						<th>${tapplicantPhone}</th>
					
						<c:set var="tapplicantMobile"><bean:message bundle='monitorRes' key='applyLog.applicantMobile' /></c:set>	
						<th>${tapplicantMobile}</th>
					
						<c:set var="tapplicantAddress"><bean:message bundle='monitorRes' key='applyLog.applicantAddress' /></c:set>	
						<th>${tapplicantAddress}</th>
					
						<c:set var="tapplicantZipcode"><bean:message bundle='monitorRes' key='applyLog.applicantZipcode' /></c:set>	
						<th>${tapplicantZipcode}</th>
					
						<c:set var="tapplicantEmail"><bean:message bundle='monitorRes' key='applyLog.applicantEmail' /></c:set>	
						<th>${tapplicantEmail}</th>
					
						<c:set var="tlinkman"><bean:message bundle='monitorRes' key='applyLog.linkman' /></c:set>	
						<th>${tlinkman}</th>
					
						<c:set var="tlinkmanName"><bean:message bundle='monitorRes' key='applyLog.linkmanName' /></c:set>	
						<th>${tlinkmanName}</th>
					
						<c:set var="tlinkmanPaperType"><bean:message bundle='monitorRes' key='applyLog.linkmanPaperType' /></c:set>	
						<th>${tlinkmanPaperType}</th>
					
						<c:set var="tlinkmanPaperCode"><bean:message bundle='monitorRes' key='applyLog.linkmanPaperCode' /></c:set>	
						<th>${tlinkmanPaperCode}</th>
					
						<c:set var="tlinkmanPhone"><bean:message bundle='monitorRes' key='applyLog.linkmanPhone' /></c:set>	
						<th>${tlinkmanPhone}</th>
					
						<c:set var="tlinkmanMobile"><bean:message bundle='monitorRes' key='applyLog.linkmanMobile' /></c:set>	
						<th>${tlinkmanMobile}</th>
					
						<c:set var="tlinkmanAddress"><bean:message bundle='monitorRes' key='applyLog.linkmanAddress' /></c:set>	
						<th>${tlinkmanAddress}</th>
					
						<c:set var="tlinkmanZipcode"><bean:message bundle='monitorRes' key='applyLog.linkmanZipcode' /></c:set>	
						<th>${tlinkmanZipcode}</th>
					
						<c:set var="tlinkmanEmail"><bean:message bundle='monitorRes' key='applyLog.linkmanEmail' /></c:set>	
						<th>${tlinkmanEmail}</th>
					
						<c:set var="tpromise"><bean:message bundle='monitorRes' key='applyLog.promise' /></c:set>	
						<th>${tpromise}</th>
					
						<c:set var="tpromiseType"><bean:message bundle='monitorRes' key='applyLog.promiseType' /></c:set>	
						<th>${tpromiseType}</th>
					
						<c:set var="tisrisk"><bean:message bundle='monitorRes' key='applyLog.isrisk' /></c:set>	
						<th>${tisrisk}</th>
					
						<c:set var="trisktype"><bean:message bundle='monitorRes' key='applyLog.risktype' /></c:set>	
						<th>${trisktype}</th>
					
						<c:set var="triskdescription"><bean:message bundle='monitorRes' key='applyLog.riskdescription' /></c:set>	
						<th>${triskdescription}</th>
					
						<c:set var="triskresult"><bean:message bundle='monitorRes' key='applyLog.riskresult' /></c:set>	
						<th>${triskresult}</th>
					
						<c:set var="tapplyDate"><bean:message bundle='monitorRes' key='applyLog.applyDate' /></c:set>	
						<th>${tapplyDate}</th>
					
						<c:set var="tcreateDate"><bean:message bundle='monitorRes' key='applyLog.createDate' /></c:set>	
						<th>${tcreateDate}</th>
					
						<c:set var="tupdateDate"><bean:message bundle='monitorRes' key='applyLog.updateDate' /></c:set>	
						<th>${tupdateDate}</th>
					
						<c:set var="tsyncDate"><bean:message bundle='monitorRes' key='applyLog.syncDate' /></c:set>	
						<th>${tsyncDate}</th>
					
						<c:set var="tsyncSign"><bean:message bundle='monitorRes' key='applyLog.syncSign' /></c:set>	
						<th>${tsyncSign}</th>
					
						<c:set var="tsyncErrorDesc"><bean:message bundle='monitorRes' key='applyLog.syncErrorDesc' /></c:set>	
						<th>${tsyncErrorDesc}</th>
					
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach items="${objList }" var="applyLog">
						<tr target="pk" rel="${applyLog.no}">
							
								<td>${applyLog.no}</td>
							
								<td>${applyLog.changNo}</td>
							
							
								<td>${applyLog.orgId}</td>
							
								<td>${applyLog.internalNo}</td>
							
								<td>${applyLog.itemId}</td>
							
								<td>${applyLog.department}</td>
							
								<td>${applyLog.transactAffairName}</td>
							
								<td>${applyLog.content}</td>
							
								<td>${applyLog.applyWay}</td>
							
								<td>${applyLog.form}</td>
							
								<td>${applyLog.stuff}</td>
							
								<td>${applyLog.applicantCode}</td>
							
								<td>${applyLog.applicantType}</td>
							
								<td>${applyLog.applicantName}</td>
							
								<td>${applyLog.applicantPaperType}</td>
							
								<td>${applyLog.applicantPaperCode}</td>
							
								<td>${applyLog.applicantPhone}</td>
							
								<td>${applyLog.applicantMobile}</td>
							
								<td>${applyLog.applicantAddress}</td>
							
								<td>${applyLog.applicantZipcode}</td>
							
								<td>${applyLog.applicantEmail}</td>
							
								<td>${applyLog.linkman}</td>
							
								<td>${applyLog.linkmanName}</td>
							
								<td>${applyLog.linkmanPaperType}</td>
							
								<td>${applyLog.linkmanPaperCode}</td>
							
								<td>${applyLog.linkmanPhone}</td>
							
								<td>${applyLog.linkmanMobile}</td>
							
								<td>${applyLog.linkmanAddress}</td>
							
								<td>${applyLog.linkmanZipcode}</td>
							
								<td>${applyLog.linkmanEmail}</td>
							
								<td>${applyLog.promise}</td>
							
								<td>${applyLog.promiseType}</td>
							
								<td>${applyLog.isrisk}</td>
							
								<td>${applyLog.risktype}</td>
							
								<td>${applyLog.riskdescription}</td>
							
								<td>${applyLog.riskresult}</td>
							
								<td>${applyLog.applyDate}</td>
							
								<td>${applyLog.createDate}</td>
							
								<td>${applyLog.updateDate}</td>
							
								<td>${applyLog.syncDate}</td>
							
								<td>${applyLog.syncSign}</td>
							
								<td>${applyLog.syncErrorDesc}</td>
							
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
		<title><c:out value="applyLog.list.title" /></title>
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
			<html:form action="/monitor/applyLog.do" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr height="22">
						<td><c:out value="applyLog.no" />:</td>
						<td><html:text property="s_no" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.changNo" />:</td>
						<td><html:text property="s_changNo" /> </td>
					</tr>	


					<tr height="22">
						<td><c:out value="applyLog.orgId" />:</td>
						<td><html:text property="s_orgId" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.internalNo" />:</td>
						<td><html:text property="s_internalNo" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.itemId" />:</td>
						<td><html:text property="s_itemId" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.department" />:</td>
						<td><html:text property="s_department" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.transactAffairName" />:</td>
						<td><html:text property="s_transactAffairName" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.content" />:</td>
						<td><html:text property="s_content" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.applyWay" />:</td>
						<td><html:text property="s_applyWay" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.form" />:</td>
						<td><html:text property="s_form" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.stuff" />:</td>
						<td><html:text property="s_stuff" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.applicantCode" />:</td>
						<td><html:text property="s_applicantCode" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.applicantType" />:</td>
						<td><html:text property="s_applicantType" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.applicantName" />:</td>
						<td><html:text property="s_applicantName" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.applicantPaperType" />:</td>
						<td><html:text property="s_applicantPaperType" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.applicantPaperCode" />:</td>
						<td><html:text property="s_applicantPaperCode" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.applicantPhone" />:</td>
						<td><html:text property="s_applicantPhone" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.applicantMobile" />:</td>
						<td><html:text property="s_applicantMobile" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.applicantAddress" />:</td>
						<td><html:text property="s_applicantAddress" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.applicantZipcode" />:</td>
						<td><html:text property="s_applicantZipcode" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.applicantEmail" />:</td>
						<td><html:text property="s_applicantEmail" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.linkman" />:</td>
						<td><html:text property="s_linkman" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.linkmanName" />:</td>
						<td><html:text property="s_linkmanName" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.linkmanPaperType" />:</td>
						<td><html:text property="s_linkmanPaperType" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.linkmanPaperCode" />:</td>
						<td><html:text property="s_linkmanPaperCode" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.linkmanPhone" />:</td>
						<td><html:text property="s_linkmanPhone" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.linkmanMobile" />:</td>
						<td><html:text property="s_linkmanMobile" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.linkmanAddress" />:</td>
						<td><html:text property="s_linkmanAddress" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.linkmanZipcode" />:</td>
						<td><html:text property="s_linkmanZipcode" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.linkmanEmail" />:</td>
						<td><html:text property="s_linkmanEmail" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.promise" />:</td>
						<td><html:text property="s_promise" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.promiseType" />:</td>
						<td><html:text property="s_promiseType" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.isrisk" />:</td>
						<td><html:text property="s_isrisk" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.risktype" />:</td>
						<td><html:text property="s_risktype" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.riskdescription" />:</td>
						<td><html:text property="s_riskdescription" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.riskresult" />:</td>
						<td><html:text property="s_riskresult" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.applyDate" />:</td>
						<td><html:text property="s_applyDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.createDate" />:</td>
						<td><html:text property="s_createDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.updateDate" />:</td>
						<td><html:text property="s_updateDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.syncDate" />:</td>
						<td><html:text property="s_syncDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.syncSign" />:</td>
						<td><html:text property="s_syncSign" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="applyLog.syncErrorDesc" />:</td>
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

			<ec:table action="applyLog.do" items="applyLogs" var="applyLog"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="applyLogs.xls" ></ec:exportXls>
			<ec:exportPdf fileName="applyLogs.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>
				
					<c:set var="tno"><bean:message bundle='monitorRes' key='applyLog.no' /></c:set>	
					<ec:column property="no" title="${tno}" style="text-align:center" />
				
					<c:set var="tchangNo"><bean:message bundle='monitorRes' key='applyLog.changNo' /></c:set>	
					<ec:column property="changNo" title="${tchangNo}" style="text-align:center" />
				
				
					<c:set var="torgId"><bean:message bundle='monitorRes' key='applyLog.orgId' /></c:set>	
					<ec:column property="orgId" title="${torgId}" style="text-align:center" />
				
					<c:set var="tinternalNo"><bean:message bundle='monitorRes' key='applyLog.internalNo' /></c:set>	
					<ec:column property="internalNo" title="${tinternalNo}" style="text-align:center" />
				
					<c:set var="titemId"><bean:message bundle='monitorRes' key='applyLog.itemId' /></c:set>	
					<ec:column property="itemId" title="${titemId}" style="text-align:center" />
				
					<c:set var="tdepartment"><bean:message bundle='monitorRes' key='applyLog.department' /></c:set>	
					<ec:column property="department" title="${tdepartment}" style="text-align:center" />
				
					<c:set var="ttransactAffairName"><bean:message bundle='monitorRes' key='applyLog.transactAffairName' /></c:set>	
					<ec:column property="transactAffairName" title="${ttransactAffairName}" style="text-align:center" />
				
					<c:set var="tcontent"><bean:message bundle='monitorRes' key='applyLog.content' /></c:set>	
					<ec:column property="content" title="${tcontent}" style="text-align:center" />
				
					<c:set var="tapplyWay"><bean:message bundle='monitorRes' key='applyLog.applyWay' /></c:set>	
					<ec:column property="applyWay" title="${tapplyWay}" style="text-align:center" />
				
					<c:set var="tform"><bean:message bundle='monitorRes' key='applyLog.form' /></c:set>	
					<ec:column property="form" title="${tform}" style="text-align:center" />
				
					<c:set var="tstuff"><bean:message bundle='monitorRes' key='applyLog.stuff' /></c:set>	
					<ec:column property="stuff" title="${tstuff}" style="text-align:center" />
				
					<c:set var="tapplicantCode"><bean:message bundle='monitorRes' key='applyLog.applicantCode' /></c:set>	
					<ec:column property="applicantCode" title="${tapplicantCode}" style="text-align:center" />
				
					<c:set var="tapplicantType"><bean:message bundle='monitorRes' key='applyLog.applicantType' /></c:set>	
					<ec:column property="applicantType" title="${tapplicantType}" style="text-align:center" />
				
					<c:set var="tapplicantName"><bean:message bundle='monitorRes' key='applyLog.applicantName' /></c:set>	
					<ec:column property="applicantName" title="${tapplicantName}" style="text-align:center" />
				
					<c:set var="tapplicantPaperType"><bean:message bundle='monitorRes' key='applyLog.applicantPaperType' /></c:set>	
					<ec:column property="applicantPaperType" title="${tapplicantPaperType}" style="text-align:center" />
				
					<c:set var="tapplicantPaperCode"><bean:message bundle='monitorRes' key='applyLog.applicantPaperCode' /></c:set>	
					<ec:column property="applicantPaperCode" title="${tapplicantPaperCode}" style="text-align:center" />
				
					<c:set var="tapplicantPhone"><bean:message bundle='monitorRes' key='applyLog.applicantPhone' /></c:set>	
					<ec:column property="applicantPhone" title="${tapplicantPhone}" style="text-align:center" />
				
					<c:set var="tapplicantMobile"><bean:message bundle='monitorRes' key='applyLog.applicantMobile' /></c:set>	
					<ec:column property="applicantMobile" title="${tapplicantMobile}" style="text-align:center" />
				
					<c:set var="tapplicantAddress"><bean:message bundle='monitorRes' key='applyLog.applicantAddress' /></c:set>	
					<ec:column property="applicantAddress" title="${tapplicantAddress}" style="text-align:center" />
				
					<c:set var="tapplicantZipcode"><bean:message bundle='monitorRes' key='applyLog.applicantZipcode' /></c:set>	
					<ec:column property="applicantZipcode" title="${tapplicantZipcode}" style="text-align:center" />
				
					<c:set var="tapplicantEmail"><bean:message bundle='monitorRes' key='applyLog.applicantEmail' /></c:set>	
					<ec:column property="applicantEmail" title="${tapplicantEmail}" style="text-align:center" />
				
					<c:set var="tlinkman"><bean:message bundle='monitorRes' key='applyLog.linkman' /></c:set>	
					<ec:column property="linkman" title="${tlinkman}" style="text-align:center" />
				
					<c:set var="tlinkmanName"><bean:message bundle='monitorRes' key='applyLog.linkmanName' /></c:set>	
					<ec:column property="linkmanName" title="${tlinkmanName}" style="text-align:center" />
				
					<c:set var="tlinkmanPaperType"><bean:message bundle='monitorRes' key='applyLog.linkmanPaperType' /></c:set>	
					<ec:column property="linkmanPaperType" title="${tlinkmanPaperType}" style="text-align:center" />
				
					<c:set var="tlinkmanPaperCode"><bean:message bundle='monitorRes' key='applyLog.linkmanPaperCode' /></c:set>	
					<ec:column property="linkmanPaperCode" title="${tlinkmanPaperCode}" style="text-align:center" />
				
					<c:set var="tlinkmanPhone"><bean:message bundle='monitorRes' key='applyLog.linkmanPhone' /></c:set>	
					<ec:column property="linkmanPhone" title="${tlinkmanPhone}" style="text-align:center" />
				
					<c:set var="tlinkmanMobile"><bean:message bundle='monitorRes' key='applyLog.linkmanMobile' /></c:set>	
					<ec:column property="linkmanMobile" title="${tlinkmanMobile}" style="text-align:center" />
				
					<c:set var="tlinkmanAddress"><bean:message bundle='monitorRes' key='applyLog.linkmanAddress' /></c:set>	
					<ec:column property="linkmanAddress" title="${tlinkmanAddress}" style="text-align:center" />
				
					<c:set var="tlinkmanZipcode"><bean:message bundle='monitorRes' key='applyLog.linkmanZipcode' /></c:set>	
					<ec:column property="linkmanZipcode" title="${tlinkmanZipcode}" style="text-align:center" />
				
					<c:set var="tlinkmanEmail"><bean:message bundle='monitorRes' key='applyLog.linkmanEmail' /></c:set>	
					<ec:column property="linkmanEmail" title="${tlinkmanEmail}" style="text-align:center" />
				
					<c:set var="tpromise"><bean:message bundle='monitorRes' key='applyLog.promise' /></c:set>	
					<ec:column property="promise" title="${tpromise}" style="text-align:center" />
				
					<c:set var="tpromiseType"><bean:message bundle='monitorRes' key='applyLog.promiseType' /></c:set>	
					<ec:column property="promiseType" title="${tpromiseType}" style="text-align:center" />
				
					<c:set var="tisrisk"><bean:message bundle='monitorRes' key='applyLog.isrisk' /></c:set>	
					<ec:column property="isrisk" title="${tisrisk}" style="text-align:center" />
				
					<c:set var="trisktype"><bean:message bundle='monitorRes' key='applyLog.risktype' /></c:set>	
					<ec:column property="risktype" title="${trisktype}" style="text-align:center" />
				
					<c:set var="triskdescription"><bean:message bundle='monitorRes' key='applyLog.riskdescription' /></c:set>	
					<ec:column property="riskdescription" title="${triskdescription}" style="text-align:center" />
				
					<c:set var="triskresult"><bean:message bundle='monitorRes' key='applyLog.riskresult' /></c:set>	
					<ec:column property="riskresult" title="${triskresult}" style="text-align:center" />
				
					<c:set var="tapplyDate"><bean:message bundle='monitorRes' key='applyLog.applyDate' /></c:set>	
					<ec:column property="applyDate" title="${tapplyDate}" style="text-align:center" />
				
					<c:set var="tcreateDate"><bean:message bundle='monitorRes' key='applyLog.createDate' /></c:set>	
					<ec:column property="createDate" title="${tcreateDate}" style="text-align:center" />
				
					<c:set var="tupdateDate"><bean:message bundle='monitorRes' key='applyLog.updateDate' /></c:set>	
					<ec:column property="updateDate" title="${tupdateDate}" style="text-align:center" />
				
					<c:set var="tsyncDate"><bean:message bundle='monitorRes' key='applyLog.syncDate' /></c:set>	
					<ec:column property="syncDate" title="${tsyncDate}" style="text-align:center" />
				
					<c:set var="tsyncSign"><bean:message bundle='monitorRes' key='applyLog.syncSign' /></c:set>	
					<ec:column property="syncSign" title="${tsyncSign}" style="text-align:center" />
				
					<c:set var="tsyncErrorDesc"><bean:message bundle='monitorRes' key='applyLog.syncErrorDesc' /></c:set>	
					<ec:column property="syncErrorDesc" title="${tsyncErrorDesc}" style="text-align:center" />
						
				<c:set var="optlabel"><bean:message key="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><bean:message key="label.delete.confirm"/></c:set>
					<a href='applyLog.do?no=${applyLog.no}&changNo=${applyLog.changNo}&method=view'><bean:message key="opt.btn.view" /></a>
					<a href='applyLog.do?no=${applyLog.no}&changNo=${applyLog.changNo}&method=edit'><bean:message key="opt.btn.edit" /></a>
					<a href='applyLog.do?no=${applyLog.no}&changNo=${applyLog.changNo}&method=delete' 
							onclick='return confirm("${deletecofirm}applyLog?");'><bean:message key="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
 --%>