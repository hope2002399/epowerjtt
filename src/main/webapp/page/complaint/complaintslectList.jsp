<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html>
	<head>
		<title></title>
		<sj:head locale="zh_CN" />
			<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<div class="search">
			<div class="crumbs">
				办件编号列表
			</div>
		
			<s:form action="complaint"  namespace="/complaint" method="post" id="complaintForm" enctype="multipart/form-data">
					<table cellpadding="0" cellspacing="0" align="center">
					<tr>
						<td class="addTd">权力类型</td>
						<td colspan="3">
						 <s:radio name="flag" id="flag" list="#{'1':'办件','2':'案件'}" value="%{flag}" listKey="key" listValue="value" onclick="checkVersion()" /></td>
					</tr>
					<tr>
						<td class="addTd"><c:if test="${flag==1}">办件编号</c:if><c:if test="${flag==2}">案件编号</c:if></td>
						<td><s:textfield name="s_internalNo" value="%{#parameters['s_internalNo']}" /></td>
						<td class="addTd">部门名称</td>
								<td>						
				<input type="text" id="orgName" name="orgName"  value="${cp:MAPVALUE('unitcode',param.s_unitcode)}"/>
				<input type="hidden" id="s_unitcode" name="s_unitcode" value="${param.s_unitcode}"/><s:checkbox label="包含下属机构" name="s_queryUnderUnit" value="#parameters['s_queryUnderUnit']" fieldValue="true" />包含下属机构	
						</td>	
					</tr>
					
				<tr>
					<td class="addTd">开始时间</td>
					<td><sj:datepicker name="s_begTime" readonly="true" id="s_begTime"
							value="%{#parameters['s_begTime']}" yearRange="2010:2030"
							changeYear="true" displayFormat="yy-mm-dd" />
					</td>
					<td class="addTd">结束时间</td>
					<td><sj:datepicker
							name="s_endTime" readonly="true" id="s_endTime"
							value="%{#parameters['s_endTime']}" yearRange="2010:2030"
							changeYear="true" displayFormat="yy-mm-dd" />
					</td>
				</tr>
					
					<tr>
					<td>
						<s:submit method="selectList" key="opt.btn.query" cssClass="btn" />
					</td>
					</tr>
				</table>
			</s:form>
		</div>
<c:if test="${flag==1}">
			<ec:table action="complaint/complaint!selectList.do" items="applyList" var="apply" imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">

		 <input type="hidden" id="internalNo${apply.internalNo}" name="internalNo${apply.internalNo}" value="${apply.internalNo}">
		 <input type="hidden" id="itemId${apply.internalNo}" name="itemId${apply.internalNo}" value="${apply.itemId}">
		 <input type="hidden" id="orgId${apply.internalNo}" name="orgId${apply.internalNo}" value="${apply.orgId}">
		 
			<ec:row>
					<ec:column property="apply.internalNo" title="办件编号" style="text-align:center">
					${apply.internalNo }
					</ec:column>
				<ec:column property="apply.itemId" title="办件名称" style="text-align:center">
					${cp:MAPVALUE("suppowerId",apply.itemId)}
					</ec:column>
					<ec:column property="apply.orgId" title="主办部门" style="text-align:center">
					${cp:MAPVALUE("depno",apply.orgId)}
					</ec:column>
					<ec:column property="apply.applyDate" title="申请时间" style="text-align:center">
					<fmt:formatDate value='${apply.applyDate}' pattern='yyyy-MM-dd HH:mm:ss' />
					</ec:column>
				  <ec:column property="opt" title="选择" sortable="false"
				style="text-align:center">
				<input type="radio" name="itemId"
					onclick="setParentVal('${apply.internalNo}','${flag }','${apply.orgId }','${cp:MAPVALUE("depno",apply.orgId)}')">
			</ec:column>
			</ec:row>
		</ec:table>
		</c:if>
	<c:if test="${flag==2}">
			<ec:table action="complaint/complaint!selectList.do" items="punishList" var="punish" imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">

		<input type="hidden" id="internalNo${punish.internalNo}" name="internalNo${punish.internalNo}" value="${punish.internalNo}">
		 <input type="hidden" id="itemId${punish.internalNo}" name="itemId${punish.internalNo}" value="${punish.itemId}">
		 <input type="hidden" id="orgId${punish.internalNo}" name="orgId${punish.internalNo}" value="${punish.orgId}">
			<ec:row>
					<ec:column property="internalNo" title="案件编号" style="text-align:center">
					${punish.internalNo }
					</ec:column>
				<ec:column property="itemId" title="案件名称" style="text-align:center">
					${cp:MAPVALUE("suppowerId",punish.itemId)}
					</ec:column>
					<ec:column property="orgId" title="主办部门" style="text-align:center">
					${cp:MAPVALUE("depno",punish.orgId)}
					</ec:column>
			  <ec:column property="opt" title="选择" sortable="false"
				style="text-align:center">
				<input type="radio" name="internalNo"
					onclick="setParentVal('${punish.internalNo}','${flag }','${punish.orgId }','${cp:MAPVALUE("depno",punish.orgId)}')">
			</ec:column>
			</ec:row>
		</ec:table>
		</c:if>

	</body>
	<script type="text/javascript">
	//获取父页面对象
	var parentDocument = window.opener.document;
	//设置返回值
	function setParentVal(internalNo,flag,orgId,orgName) {
		if (window.confirm("确认选择吗")) {		
			parentDocument.getElementById('internalNo').value = document
			.getElementById('internalNo' + internalNo).value;
			parentDocument.getElementById('bjType').value =flag;
			parentDocument.getElementById('graentOrgId').value =orgId;
			//parentDocument.getElementById('orgName').innerHTML =orgName;
			window.close();
		}
	}
	function checkVersion() {
		 var form=document.getElementById("complaintForm");
	     form.action="complaint/complaint!selectList.do";     
	     form.submit();
	}
	

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
			$("body").append(shadow);
			$("#shadow").height(document.body.scrollHeight);
			setTimeout(function(){
				menuDisplay(menuList,"${parentUnit}");	
			},0);
		};
		$("#lists span").live('click',function(){
			var $this = $(this);
			bindEvent($("#orgName"),$("#s_unitcode"),$this);
			$("#lists span").die("click");
		});
	});
</script>
</html>
