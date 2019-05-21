<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<form id="pagerForm" method="post" action="paPerformanceResult.do">
	<input type="hidden" name="pageNum" value="1" /> <input type="hidden" name="numPerPage" value="${pageDesc.pageSize}" /> <input type="hidden" name="orderField"
		value="${s_orderField}" />
</form>



<div class="pageHeader">
	<s:form id="pagerForm" onsubmit="return navTabSearch(this);" action="/monitor/paPerformanceResult.do" method="post">
		<div class="searchBar">
			<ul class="searchContent">
				
					<li><label><c:out value="paPerformanceResult.checkNo" />:</label> <s:textfield name="s_checkNo" value="%{#parameters['s_checkNo']}" /></li>
				
				
					<li><label><c:out value="paPerformanceResult.checkType" />:</label> <s:textfield name="s_checkType" value="%{#parameters['s_checkType']}" /></li>
				
					<li><label><c:out value="paPerformanceResult.userCode" />:</label> <s:textfield name="s_userCode" value="%{#parameters['s_userCode']}" /></li>
				
					<li><label><c:out value="paPerformanceResult.orgId" />:</label> <s:textfield name="s_orgId" value="%{#parameters['s_orgId']}" /></li>
				
					<li><label><c:out value="paPerformanceResult.countYear" />:</label> <s:textfield name="s_countYear" value="%{#parameters['s_countYear']}" /></li>
				
					<li><label><c:out value="paPerformanceResult.countMonth" />:</label> <s:textfield name="s_countMonth" value="%{#parameters['s_countMonth']}" /></li>
				
					<li><label><c:out value="paPerformanceResult.createDate" />:</label> <s:textfield name="s_createDate" value="%{#parameters['s_createDate']}" /></li>
				
					<li><label><c:out value="paPerformanceResult.allNum" />:</label> <s:textfield name="s_allNum" value="%{#parameters['s_allNum']}" /></li>
				
					<li><label><c:out value="paPerformanceResult.zsScore" />:</label> <s:textfield name="s_zsScore" value="%{#parameters['s_zsScore']}" /></li>
				
					<li><label><c:out value="paPerformanceResult.auditDesc" />:</label> <s:textfield name="s_auditDesc" value="%{#parameters['s_auditDesc']}" /></li>
				
					<li><label><c:out value="paPerformanceResult.auditor" />:</label> <s:textfield name="s_auditor" value="%{#parameters['s_auditor']}" /></li>
				
					<li><label><c:out value="paPerformanceResult.auditDate" />:</label> <s:textfield name="s_auditDate" value="%{#parameters['s_auditDate']}" /></li>
				
					<li><label><c:out value="paPerformanceResult.auditResult" />:</label> <s:textfield name="s_auditResult" value="%{#parameters['s_auditResult']}" /></li>
				
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
			<li><a class="add" href="${contextPath }/monitor/paPerformanceResult!edit.do" rel="" target='dialog'><span>添加</span></a></li>
			<li><a class="edit" href="${contextPath }/monitor/paPerformanceResult!edit.do?checkNo={pk}" warn="请�?择一条记�? rel="" target='dialog'><span>编辑</span></a></li>
			<li><a class="delete" href="${contextPath }/monitor/paPerformanceResult!delete.do?checkNo={pk}" warn="请�?择一条记�? target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</ul>
	</div>

	<div layoutH="116">
		<table class="list" width="98%" targetType="navTab" asc="asc" desc="desc">
			<thead align="center">

				<tr>
					
						<c:set var="tcheckNo"><bean:message bundle='monitorRes' key='paPerformanceResult.checkNo' /></c:set>	
						<th>${tcheckNo}</th>
					
					
						<c:set var="tcheckType"><bean:message bundle='monitorRes' key='paPerformanceResult.checkType' /></c:set>	
						<th>${tcheckType}</th>
					
						<c:set var="tuserCode"><bean:message bundle='monitorRes' key='paPerformanceResult.userCode' /></c:set>	
						<th>${tuserCode}</th>
					
						<c:set var="torgId"><bean:message bundle='monitorRes' key='paPerformanceResult.orgId' /></c:set>	
						<th>${torgId}</th>
					
						<c:set var="tcountYear"><bean:message bundle='monitorRes' key='paPerformanceResult.countYear' /></c:set>	
						<th>${tcountYear}</th>
					
						<c:set var="tcountMonth"><bean:message bundle='monitorRes' key='paPerformanceResult.countMonth' /></c:set>	
						<th>${tcountMonth}</th>
					
						<c:set var="tcreateDate"><bean:message bundle='monitorRes' key='paPerformanceResult.createDate' /></c:set>	
						<th>${tcreateDate}</th>
					
						<c:set var="tallNum"><bean:message bundle='monitorRes' key='paPerformanceResult.allNum' /></c:set>	
						<th>${tallNum}</th>
					
						<c:set var="tzsScore"><bean:message bundle='monitorRes' key='paPerformanceResult.zsScore' /></c:set>	
						<th>${tzsScore}</th>
					
						<c:set var="tauditDesc"><bean:message bundle='monitorRes' key='paPerformanceResult.auditDesc' /></c:set>	
						<th>${tauditDesc}</th>
					
						<c:set var="tauditor"><bean:message bundle='monitorRes' key='paPerformanceResult.auditor' /></c:set>	
						<th>${tauditor}</th>
					
						<c:set var="tauditDate"><bean:message bundle='monitorRes' key='paPerformanceResult.auditDate' /></c:set>	
						<th>${tauditDate}</th>
					
						<c:set var="tauditResult"><bean:message bundle='monitorRes' key='paPerformanceResult.auditResult' /></c:set>	
						<th>${tauditResult}</th>
					
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach items="${objList }" var="paPerformanceResult">
						<tr target="pk" rel="${paPerformanceResult.checkNo}">
							
								<td>${paPerformanceResult.checkNo}</td>
							
							
								<td>${paPerformanceResult.checkType}</td>
							
								<td>${paPerformanceResult.userCode}</td>
							
								<td>${paPerformanceResult.orgId}</td>
							
								<td>${paPerformanceResult.countYear}</td>
							
								<td>${paPerformanceResult.countMonth}</td>
							
								<td>${paPerformanceResult.createDate}</td>
							
								<td>${paPerformanceResult.allNum}</td>
							
								<td>${paPerformanceResult.zsScore}</td>
							
								<td>${paPerformanceResult.auditDesc}</td>
							
								<td>${paPerformanceResult.auditor}</td>
							
								<td>${paPerformanceResult.auditDate}</td>
							
								<td>${paPerformanceResult.auditResult}</td>
							
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
		<title><c:out value="paPerformanceResult.list.title" /></title>
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
			<html:form action="/monitor/paPerformanceResult.do" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr height="22">
						<td><c:out value="paPerformanceResult.checkNo" />:</td>
						<td><html:text property="s_checkNo" /> </td>
					</tr>	


					<tr height="22">
						<td><c:out value="paPerformanceResult.checkType" />:</td>
						<td><html:text property="s_checkType" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="paPerformanceResult.userCode" />:</td>
						<td><html:text property="s_userCode" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="paPerformanceResult.orgId" />:</td>
						<td><html:text property="s_orgId" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="paPerformanceResult.countYear" />:</td>
						<td><html:text property="s_countYear" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="paPerformanceResult.countMonth" />:</td>
						<td><html:text property="s_countMonth" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="paPerformanceResult.createDate" />:</td>
						<td><html:text property="s_createDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="paPerformanceResult.allNum" />:</td>
						<td><html:text property="s_allNum" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="paPerformanceResult.zsScore" />:</td>
						<td><html:text property="s_zsScore" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="paPerformanceResult.auditDesc" />:</td>
						<td><html:text property="s_auditDesc" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="paPerformanceResult.auditor" />:</td>
						<td><html:text property="s_auditor" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="paPerformanceResult.auditDate" />:</td>
						<td><html:text property="s_auditDate" /> </td>
					</tr>	

					<tr height="22">
						<td><c:out value="paPerformanceResult.auditResult" />:</td>
						<td><html:text property="s_auditResult" /> </td>
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

			<ec:table action="paPerformanceResult.do" items="paPerformanceResults" var="paPerformanceResult"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:exportXls fileName="paPerformanceResults.xls" ></ec:exportXls>
			<ec:exportPdf fileName="paPerformanceResults.pdf" headerColor="blue" headerBackgroundColor="white" ></ec:exportPdf>
			<ec:row>
				
					<c:set var="tcheckNo"><bean:message bundle='monitorRes' key='paPerformanceResult.checkNo' /></c:set>	
					<ec:column property="checkNo" title="${tcheckNo}" style="text-align:center" />
				
				
					<c:set var="tcheckType"><bean:message bundle='monitorRes' key='paPerformanceResult.checkType' /></c:set>	
					<ec:column property="checkType" title="${tcheckType}" style="text-align:center" />
				
					<c:set var="tuserCode"><bean:message bundle='monitorRes' key='paPerformanceResult.userCode' /></c:set>	
					<ec:column property="userCode" title="${tuserCode}" style="text-align:center" />
				
					<c:set var="torgId"><bean:message bundle='monitorRes' key='paPerformanceResult.orgId' /></c:set>	
					<ec:column property="orgId" title="${torgId}" style="text-align:center" />
				
					<c:set var="tcountYear"><bean:message bundle='monitorRes' key='paPerformanceResult.countYear' /></c:set>	
					<ec:column property="countYear" title="${tcountYear}" style="text-align:center" />
				
					<c:set var="tcountMonth"><bean:message bundle='monitorRes' key='paPerformanceResult.countMonth' /></c:set>	
					<ec:column property="countMonth" title="${tcountMonth}" style="text-align:center" />
				
					<c:set var="tcreateDate"><bean:message bundle='monitorRes' key='paPerformanceResult.createDate' /></c:set>	
					<ec:column property="createDate" title="${tcreateDate}" style="text-align:center" />
				
					<c:set var="tallNum"><bean:message bundle='monitorRes' key='paPerformanceResult.allNum' /></c:set>	
					<ec:column property="allNum" title="${tallNum}" style="text-align:center" />
				
					<c:set var="tzsScore"><bean:message bundle='monitorRes' key='paPerformanceResult.zsScore' /></c:set>	
					<ec:column property="zsScore" title="${tzsScore}" style="text-align:center" />
				
					<c:set var="tauditDesc"><bean:message bundle='monitorRes' key='paPerformanceResult.auditDesc' /></c:set>	
					<ec:column property="auditDesc" title="${tauditDesc}" style="text-align:center" />
				
					<c:set var="tauditor"><bean:message bundle='monitorRes' key='paPerformanceResult.auditor' /></c:set>	
					<ec:column property="auditor" title="${tauditor}" style="text-align:center" />
				
					<c:set var="tauditDate"><bean:message bundle='monitorRes' key='paPerformanceResult.auditDate' /></c:set>	
					<ec:column property="auditDate" title="${tauditDate}" style="text-align:center" />
				
					<c:set var="tauditResult"><bean:message bundle='monitorRes' key='paPerformanceResult.auditResult' /></c:set>	
					<ec:column property="auditResult" title="${tauditResult}" style="text-align:center" />
						
				<c:set var="optlabel"><bean:message key="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><bean:message key="label.delete.confirm"/></c:set>
					<a href='paPerformanceResult.do?checkNo=${paPerformanceResult.checkNo}&method=view'><bean:message key="opt.btn.view" /></a>
					<a href='paPerformanceResult.do?checkNo=${paPerformanceResult.checkNo}&method=edit'><bean:message key="opt.btn.edit" /></a>
					<a href='paPerformanceResult.do?checkNo=${paPerformanceResult.checkNo}&method=delete' 
							onclick='return confirm("${deletecofirm}paPerformanceResult?");'><bean:message key="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
</html>
 --%>