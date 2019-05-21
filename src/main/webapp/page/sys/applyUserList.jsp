<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html lang="en">
	<head><meta name="decorator" content='${LAYOUT}'/>
		<title>外网人员列表</title>
		 <script type="text/javascript" src="<s:url value="/scripts/colorbox/jquery.colorbox.js"/>" charset="utf-8"></script>
        <link href="${pageContext.request.contextPath}/scripts/colorbox/colorbox.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/scripts/jquery-ui/jquery-ui-1.9.2.custom.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="<s:url value="/scripts/addressBook.js"/>" charset="utf-8"></script>
		<script type="text/javascript" src="<s:url value="/scripts/centit.js"/>" charset="utf-8"></script>
		<script type="text/javascript" src="<s:url value="/scripts/jquery-ui/jquery-ui-1.9.2.custom.js"/>" charset="utf-8"></script>
		<script type="text/javascript" src="<s:url value="/scripts/opendiv_Win.js"/>" charset="utf-8"></script>
		
		<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript">
		var path="${pageContext.request.contextPath}";				
	 $(document).ready(function() {  
		 centit.ajax.initAjax({urlPrefix:path});  
		 }); 
	
	 /* $(function() {
	   $( "#dialog-modal" ).dialog({
	     height: 240,
	     modal: true
	   }); */
/* 	 }); */

	</script>
	</head>
	<body>
		<div class="search">
			<div class="crumbs">
				用户管理
			</div>
			<s:form action="applyUser" theme="simple">			
				<table cellpadding="0" cellspacing="0" align="center">
					<tr>
						<td class="addTd">用户名：</td>
						<td><s:textfield name="s_USERNAME"  value="%{#parameters['s_USERNAME']}" />	
						</td>
						<td class="addTd">状态：</td>
						<td><select name="s_ISINUSE"  >
							<option value="1" <c:if test="${param.s_ISINUSE==1}"> selected="true" </c:if> >在用</option>
							<option value="2" <c:if test="${param.s_ISINUSE==2}"> selected="true" </c:if> >审核未通过</option>
							<option value="0" <c:if test="${param.s_ISINUSE==0}"> selected="true" </c:if> >已停用</option>
							<option value="3" <c:if test="${param.s_ISINUSE==3}"> selected="true" </c:if> >未审核</option>
						</select>	
						</td>
					</tr>
					<tr>
						
						<td colspan="4" align="center">
							<s:submit method="list" cssClass="btn" value="查询" ></s:submit>
								</td>				
					</tr>
				</table>
		
			</s:form>
		</div>
			<ec:table action="applyUser!list.do" items="objList" var="fUserinfo"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" 
			rowsDisplayed="15" 
			filterRowsCallback="limit" 
			retrieveRowsCallback="limit"
			sortRowsCallback="limit"
			>
			<ec:row>
				<ec:column property="userID" title="用户ID" style="text-align:center" />
			
				<ec:column property="userName" title="用户登录名" style="text-align:center" />

				<ec:column property="depName" title="公司" style="text-align:center" />
				<ec:column property="telephone" title="电话" sortable="false" style="text-align:center">
				</ec:column>
				<ec:column property="isInUse" title="状态" style="text-align:center">
				<c:if test="${fUserinfo.isInUse eq '1'}">
					在用
				</c:if>
				<c:if test="${fUserinfo.isInUse eq '2'}">
					审核未通过
				</c:if>
				<c:if test="${fUserinfo.isInUse eq '3'}">
					未审核
				</c:if>
				<c:if test="${fUserinfo.isInUse eq '0'}">
					已停用
				</c:if>
				</ec:column>
				<ec:column property="isInUse"  title="操作" sortable="false"
					style="text-align:center">
					<c:if test="${fUserinfo.isInUse eq '0'}">
						<a href='applyUser!view.do?userID=${fUserinfo.userID}'>查看</a>
						<a href='applyUser!renew.do?userID=${fUserinfo.userID}'>启用</a>
					</c:if>
					
					<c:if test="${fUserinfo.isInUse eq '1'}">
						<a href='applyUser!view.do?userID=${fUserinfo.userID}'>查看</a>
						<a href='applyUser!delete.do?userID=${fUserinfo.userID}'
							onclick='return confirm("是否禁用该用户?");'>禁用</a>
					</c:if>
					<c:if test="${fUserinfo.isInUse eq '2'}">
						<a href='applyUser!view.do?userID=${fUserinfo.userID}'>查看</a>
					</c:if>
					<c:if test="${fUserinfo.isInUse eq '3'}">
					<a href='applyUser!edit.do?userID=${fUserinfo.userID}'>审核</a>
					</c:if>
				</ec:column>

			</ec:row>
		</ec:table>



 


 
	</body>

		
</html>
