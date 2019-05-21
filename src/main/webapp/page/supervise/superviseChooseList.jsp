<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>督办</title>
<script type="text/javascript">
</script>
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

		<s:form action="superviseBasic" namespace="/supervise"
			style="margin-top:0;margin-bottom:5">

			<table cellpadding="0" cellspacing="0" align="center">
				<tr>
				
					<td colspan="2" align="right">办件类型:&nbsp;&nbsp; <s:radio theme="simple"
							value="%{suptype}" listKey="key" listValue="value" id="suptype"
							name="suptype" onclick="chsuptype(this.value)"
							list="#{'apply':'许可','punish':'处罚'}" />
					</td>

					<td align="left" colspan="2">&nbsp;&nbsp;<s:submit method="listsup"
							key="opt.btn.query" cssClass="btn" /></td>
				</tr>
									<tr>
										<td class="addTd">流水号:</td>
										<td>
										<s:textfield name="s_no" />
					</td>
						<%-- <td class="addTd"><c:if test="${suptype=='apply'}">办件编号</c:if><c:if test="${suptype=='punish'}">案件编号</c:if></td>
						<td><s:textfield name="s_internalNo" value="%{#parameters['s_internalNo']}" /></td> --%>
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
			</table>
	</div>
	<s:hidden name="optId" value="supervise" />
	</s:form>
	<c:if test="${suptype=='apply'}">
		<ec:table action="supervise/superviseBasic!listsup.do" items="applylist" var="apply" tableId="apply"
			imagePath="${STYLE_PATH}/images/table/*.gif"
			retrieveRowsCallback="limit">
			<ec:row>


				<ec:column property="no" title="流水号" style="text-align:center" />
				<ec:column property="content" title="办件摘要" style="text-align:center" />
				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm">
						<s:text name="label.delete.confirm" />
					</c:set>

					<input type="radio"
						onclick="addlist('${apply.no}','${apply.orgId}','${apply.content}','${apply.itemId}','${optId}')">

				</ec:column>

			</ec:row>
		</ec:table>
	</c:if>
	<c:if test="${suptype=='punish'}">
		<ec:table action="supervise/superviseBasic!listsup.do" items="punishlist" var="punish" tableId="punish"
			imagePath="${STYLE_PATH}/images/table/*.gif"
			retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="no" title="流水号" style="text-align:center" />
				<ec:column property="content" title="处罚名称" style="text-align:center" />
				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">
					<input type="radio"
						onclick="addlist('${punish.no}','${punish.orgId}','${punish.content}','${punish.itemId}','${optId}')">
				</ec:column>

			</ec:row>
		</ec:table>
	</c:if>
	
</body>
<script type="text/javascript">
	//function addlist(no,orgid,content,itemid){
	//var parentDocument = window.opener.document;	
	//parentDocument.getElementById("bjNo").value=no;
	//parentDocument.getElementById("orgid").innerText=orgid; 
	//parentDocument.getElementById("content").innerText=content; 
	//parentDocument.getElementById("itemid").innerText=itemid; 
	//parentDocument.getElementById("supinfo").style.display="block";
	//var bjType="${suptype}";
	//if(bjType=="apply"){
	//parentDocument.getElementById("bjType").value="1";
	//}else if(bjType=="punish"){

	//parentDocument.getElementById("bjType").value="2";
	//}
	// window.close();

	//}
	function addlist(no, orgid, content, itemid, optId) {
		var bjType = "${suptype}";
		if (bjType == "apply") {
			bjType = "1";
		} else if (bjType == "punish") {
			bjType = "2";
		}
		var parentDocument = window.opener.document;
		var contextpath = "${pageContext.request.contextPath}";
		var href = contextpath
				+ "/supervise/superviseBasic!superviseinitiate.do?bjType="
				+ bjType + "&bjNo=" + no + "&optId=" + optId;
		window.close();
		parentDocument.location.href = href;

	}
	function chsuptype(value) {
		var contextpath = "${pageContext.request.contextPath}";
		var href = contextpath
				+ "/supervise/superviseBasic!listsup.do?suptype=" + value;

		window.location.href = href;
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
