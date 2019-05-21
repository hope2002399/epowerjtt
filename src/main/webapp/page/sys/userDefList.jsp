<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html lang="en">
	<head><meta name="decorator" content='${LAYOUT}'/>
		<title>人员列表</title>
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
			<s:form action="userDef" theme="simple">			
				<table cellpadding="0" cellspacing="0" align="center">
					<tr>
						<td class="addTd">用户名：</td>
						<td><s:textfield name="s_USERNAME" value="%{#parameters['s_USERNAME']}" />	
						</td>
						<td class="addTd">
							登录名：</td>
						<td><s:textfield name="s_LOGINNAME"  ></s:textfield>							
						</td>
					</tr>
					<tr>
						<td class="addTd">				
								所属机构：</td>
						<td>
							<input type="hidden" id="s_queryByUnit" name="s_queryByUnit" value="${param.s_queryByUnit }">
							<input type="text" id="orgName" name="orgName" value="${cp:MAPVALUE('unitcode',param.s_queryByUnit)}">
							<s:checkbox label="包含禁用" name="s_isAll" value="#parameters['s_isAll']" fieldValue="true" />包含禁用	
						</td>
						<td colspan="4" align="center">
							<s:submit method="list" cssClass="btn" value="查询" ></s:submit>
							<s:submit method="built" cssClass="btn" value="新增" ></s:submit>
							<%-- <a class="btnA"><s:submit method="pwdlist" cssClass="btn" style="width:100px;" value="批量重置密码" ></s:submit></a> --%>
							<s:submit method="pwdlist" cssClass="btn" style="width:100px;" value="批量重置密码" ></s:submit>
						</td>				
					</tr>
				</table>
		
			</s:form>
		</div>
			<ec:table action="userDef!list.do" items="objList" var="fUserinfo"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" 
			rowsDisplayed="15" 
			filterRowsCallback="limit" 
			retrieveRowsCallback="limit"
			sortRowsCallback="limit"
			>
			<ec:row>
				<ec:column property="usercode" title="用户代码" style="text-align:center" />
			
				<ec:column property="username" title="用户名" style="text-align:center" />

				<ec:column property="loginname" title="登录名" style="text-align:center" />
				<ec:column property="Isvalid" title="状态" sortable="false" style="text-align:center">
					${USE_STATE[fUserinfo.isvalid]}
				</ec:column>
				<ec:column property="userdesc" title="用户描述" style="text-align:center"></ec:column>
				<ec:column property="userOpt" title="操作" sortable="false"
					style="text-align:center">
					<a href='userDef!view.do?usercode=${fUserinfo.usercode}&ec_p=${ec_p}&ec_crd=${ec_crd}'>查看明细</a>
					<a href='userDef!edit.do?usercode=${fUserinfo.usercode}'>编辑</a>
					<c:if test="${fUserinfo.isvalid eq 'F'}">
						<a href='userDef!renew.do?usercode=${fUserinfo.usercode}'>启用</a>
					</c:if>
					<c:if test="${fUserinfo.isvalid eq 'T' && fUserinfo.loginname != 'admin'}">
					
						<a href='userDef!delete.do?usercode=${fUserinfo.usercode}'
							onclick='return confirm("是否禁用该用户?");'>禁用</a>
					</c:if>
					<c:if test="${fUserinfo.addrbookid gt 0}">
						<a href='#' onclick="addressBook.showDetail('${fUserinfo.addrbookid}')">查看通讯信息</a>
					</c:if>
				</ec:column>

			</ec:row>
		</ec:table>



 
<!-- 
<div id="dialog-modal" title="Basic modal dialog" style="display: none">
  <p>Adding the modal overlay screen makes the dialog look more prominent because it dims out the page content.</p>
</div>
  -->

 
	</body>
	<script type="text/javascript">
		function bindEvent(o1,o2,$this){
			o1.val($this.html());
			o2.val($this.attr("rel"));
			if(getID("shadow")){
				$("#shadow").hide();
				$("#boxContent").hide();
			}
		}
		$("#orgName").bind('click',function(){
			var menuList = ${unitsJson};
			var shadow = "<div id='shadow'></div><div id='boxContent'><div class='listShadow'></div><div id='lists' class='getTree'>Loader</div><div id='close'>×</div></div>";
			if(getID("shadow")){
				$("#shadow").show();
				$("#boxContent").show();
			}else{
				//alert(menuList);
				$("body").append(shadow);
				$("#shadow").height(document.body.scrollHeight);
				setTimeout(function(){
					menuDisplay(menuList,"1");	
				},0);
			};
			$("#lists span").live('click',function(){
				var $this = $(this);
				bindEvent($("#orgName"),$("#s_queryByUnit"),$this);
				$("#lists span").die("click");
			});
		});

	</script>
</html>
