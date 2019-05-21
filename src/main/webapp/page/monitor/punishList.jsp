<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>案件列表</title>
<sj:head locale="zh_CN" />
<script
	src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js"
	type="text/javascript"></script>
<link
	href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function resetForm() {
		$('#s_internalNo').val('');
		$('#s_punishTarget').val('');
		$('#s_orgId').val('');
		$('#orgName').val('');
		$('#s_itemId').val('');
		$('#s_begTime').val('');
		$('#s_endTime').val('');
		$('#s_punishDeside').val('');
		$('#powername').val('');
		$('#s_queryUnderUnit').attr("checked",false);

		$('#s_endFinishTime').val('');
		$('#s_begFinishTime').val('');

		$('#__checkbox_s_queryUnderUnit').val('');
		
	}

	function doCompare() {
		var itemId = "";
		var items = $('.delWarn:checkbox:checked');
		for (var i = 0; i < items.length; i++) {
			itemId = itemId + items.get(i).value + ',';
		}

		if (items.length >= 2) {
			itemId = itemId.substring(0, itemId.length - 1);
			if (confirm("确定对选择的案件进行对比 ？")) {
				window.location.href = "punish!compare.do?itemId=" + itemId
						+ "&${cxparam}";
			}
		} else {
			alert("请选择两个以上的案件进行对比！");
		}
	}
</script>
<style type="text/css">
.search td {
	padding: 0px 10px 0px 10px;
}
</style>
</head>

<body>
	<%@ include file="/page/common/messages.jsp"%>
	<div class="search">
		<div class="crumbs">${param['title']}</div>
		<%
			String type = request.getParameter("type");
			String s_NP_result = request.getParameter("s_NP_result");
			String s_NP_process = request.getParameter("s_NP_process");
			String opt = request.getParameter("opt");
		%>
		<s:form action="punish" namespace="/monitor"
			style="margin-top:0;margin-bottom:5" id="applyForm" method="post">
			<input type="hidden" id="title" name="title"
				value="${param['title']}" />
			<input type="hidden" id="type" name="type" value="<%=type%>" />
			<input type="hidden" id="s_NP_result" name="s_NP_result"
				value="<%=s_NP_result%>" />
			<input type="hidden" id="s_NP_process" name="s_NP_process"
				value="<%=s_NP_process%>" />
			<input type="hidden" id="opt" name="opt" value="<%=opt%>" />
			<table cellpadding="0" cellspacing="0" align="center">

				<tr height="22">
					<td>案件编号:</td>
					<td><s:textfield name="s_internalNo" id="s_internalNo"
							value="%{#parameters['s_internalNo']}" /></td>
					<td>处罚当事人:</td>
					<td><s:textfield name="s_punishTarget" id="s_punishTarget"
							value="%{#parameters['s_punishTarget']}" /></td>
				</tr>
				<tr height="22">
					<td>部门名称:</td>
					<td><input type="text" id="orgName" name="orgName"
						value="${cp:MAPVALUE('depno',param.s_orgId)}" /> <input
						type="hidden" id="s_orgId" name="s_orgId" value="${param.s_orgId}" />
						<s:checkbox label="包含下属机构" name="s_queryUnderUnit"
							id="s_queryUnderUnit" value="#parameters['s_queryUnderUnit']"
							fieldValue="true" />包含下属机构</td>

					<td>权力名称:</td>
					<td><input type="hidden" id="powerid" name="s_itemId"
						value="${param.powerid}"> <input type="text"
						id="powername" name="s_transactAffairName"
						value="${param.s_transactAffairName}" style="width: 160px;">
						<input type="button" class='btn' name="powerBtn"
						onClick="openSuppowerSelectWnd();" value="选择"></td>
				</tr>
						<%
					if ("result".equals(type)) {
				%>
				<tr height="22">
					<td>办结起始时间:</td>
					<td><sj:datepicker name="s_begFinishTime" id="s_begFinishTime"
							readonly="true" value="%{#parameters['s_begFinishTime']}"
							yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" />
					</td>
					<td>办结截止时间:</td>
					<td><sj:datepicker name="s_endFinishTime" id="s_endFinishTime"
							readonly="true" value="%{#parameters['s_endFinishTime']}"
							yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" />
					</td>
				</tr>
				<%
					} else {
				%>
				<tr height="22">
					<td>开始时间:</td>
					<td><sj:datepicker name="s_begTime" id="s_begTime"
							readonly="true" value="%{#parameters['s_begTime']}"
							yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" />
					</td>
					<td>结束时间:</td>
					<td><sj:datepicker name="s_endTime" id="s_endTime"
							readonly="true" value="%{#parameters['s_endTime']}"
							yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" />
					</td>
				</tr>
				<%
					}
				%>
				
	

				<tr height="22">
					<td>处罚决定:</td>
					<td><select name="s_punishDeside" id="s_punishDeside"
						style="width: 160px">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('PUNISH_DESIDE')}">
								<option
									<c:if test="${param.s_punishDeside == row.key}">selected="selected"</c:if>
									value="${row.key}" label="${row.value}">
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
					<td colspan="2" align="center"><s:submit method="list"
							key="opt.btn.query" cssClass="btn" /> <input type="button"
						name="reset" class="btn" value="重置" onclick="resetForm();">
						<c:if test="${opt eq 'compare'}">
							<input type="button" class="btn" value="对比" name="compare"
								id="compare" onclick="doCompare();" />
						</c:if></td>
				</tr>
			</table>
		</s:form>
	</div>
	<ec:table action="punish!list.do" items="punishList"
		var="punish"
		imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif"
		retrieveRowsCallback="limit">

		<ec:row>
			<c:if test="${opt eq 'compare'}">
				<ec:column property="aj" title='对比' style="text-align:center"
					sortable="false">
					<input type="checkbox" class="delWarn" name="delWarn"
						value="${punish.internalNo };${punish.orgId}" />
				</ec:column>
			</c:if>

			<ec:column property="isrisk" title="风险" style="text-align:center;"
				width="4%">
				<c:if test="${punish.isrisk eq 1}">
					<img align="middle" alt="重要权力"
						src="${pageContext.request.contextPath}/images/risk_point.gif" />
				</c:if>
				<c:if test='${ punish.isrisk  eq 2}'>
					<img align="middle" alt="关键环节"
						src="${pageContext.request.contextPath}/images/risk.gif" />
				</c:if>
				<c:if test='${ punish.isrisk eq 0}'>&nbsp;</c:if>
			</ec:column>
			<ec:column property="monitorStyle" title="预警"
				style="text-align:center" width="4%">
				<c:if test="${punish.monitorStyle eq 1}">
					<img align="middle" alt="预警"
						src="${pageContext.request.contextPath}/images/yellow.gif" />
				</c:if>
				<c:if test='${ punish.monitorStyle  eq 2}'>
					<img align="middle" alt="报警"
						src="${pageContext.request.contextPath}/images/red.gif" />
				</c:if>
				<c:if test='${ punish.monitorStyle eq 3}'>
					<img align="middle" alt="提醒"
						src="${pageContext.request.contextPath}/images/green.gif" />
				</c:if>
			</ec:column>
			<ec:column property="internalNo" title="案件编号"
				style="text-align:center" width="17%">
				<a
					href='punish!view.do?internalNo=${punish.internalNo}&orgId=${punish.orgId}'>${punish.internalNo }</a>
			</ec:column>
			<ec:column property="itemId" title="办件名称" style="text-align:center"
				width="15%">
					${cp:MAPVALUE("suppowerId",punish.itemId)}
					</ec:column>
			<ec:column property="orgId" title="主办部门" style="text-align:center"
				width="15%">
					${cp:MAPVALUE("depno",punish.orgId)}
					</ec:column>
			<ec:column property="department" title="业务科室"
				style="text-align:center" width="15%" />
			<ec:column property="punishTarget" title="当事人"
				style="text-align:center" width="15%" />
			<%
					if ("result".equals(type)) {
				%>	
				<ec:column property="finishDate" title="办结时间"
				style="text-align:center" width="8%">
				<fmt:formatDate value='${punish.finishDate}'
					pattern='yyyy-MM-dd HH:mm:ss' />
					
			</ec:column>
					<%
					} else {
				%>
			<ec:column property="createDate" title="登记时间"
				style="text-align:center" width="8%">
				<fmt:formatDate value='${punish.createDate}'
					pattern='yyyy-MM-dd HH:mm:ss' />
					
			</ec:column>
				<%
					} 
				%>

			<c:if test="${opt ne 'compare'}">
				<ec:column property="ss" title="操作" style="text-align:center"
					width="10%">
					<a
						href="<%=request.getContextPath()%>/complaint/complaint!edit.do?bjNo=${punish.no}&bjType=2&object.optId=complaint">投诉</a>
					<a
						href="<%=request.getContextPath()%>/supervise/superviseBasic!superviseinitiate.do?bjNo=${punish.no}&bjType=2&object.optId=supervise&fromsup=1&object.isOrg=T&object.monitorOrgId=${punish.orgId}">督办</a>
				</ec:column>
			</c:if>



		</ec:row>
	</ec:table>

</body>
<script type="text/javascript">
	//function doEditOpt(){
	//$("showMessage").show();	
	//}
	function checkItemType() {

		var form = document.getElementById("punishForm");
		form.action = "punish!list.do";
		form.submit();
	}
	var menuList = ${unitsJson};
	function bindEvent(o1, o2, $this) {
		o1.val($this.html());
		var key = $this.attr("rel");
		for (var i = 0; i < menuList.length; i++) {
			if (key == menuList[i].MID) {
				o2.val(menuList[i].depno);
			}
		}
		if (getID("shadow")) {
			$("#shadow").hide();
			$("#boxContent").hide();
		}
	}
	$("#orgName")
			.bind(
					'click',
					function() {
						var menuList = ${unitsJson};
						var shadow = "<div id='shadow'></div><div id='boxContent'><div class='listShadow'></div><div id='lists' class='getTree'>Loader</div><div id='close'>×</div></div>";
						if (getID("shadow")) {
							$("#shadow").show();
							$("#boxContent").show();
						} else {
							$("body").append(shadow);
							$("#shadow").height(document.body.scrollHeight);
							setTimeout(function() {
								menuDisplay(menuList, "${parentunit}");
							}, 0);
						}
						;
						$("#lists span").live('click', function() {
							var $this = $(this);
							bindEvent($("#orgName"), $("#s_orgId"), $this);
							$("#lists span").die("click");
						});
					});
	/**
	 * common window dialogs
	 */
	function openNewWindow(winUrl, winName, winProps) {
		if (winProps == '' || winProps == null) {
			winProps = 'height=680px,width=860px,directories=false,location=false,top=100,left=500,menubar=false,Resizable=yes,scrollbars=yes,toolbar=false';
		}
		window.open(winUrl, winName, winProps);
	}

	function openSuppowerSelectWnd() {
		var itemType = 'CF';
		var orgId = document.getElementById('s_orgId').value;
		var queryUnderUnit = document.getElementById('s_queryUnderUnit').value;
		openNewWindow('../powerbase/supPower!listSupPower.do?s_itemType='
				+ itemType + '&s_orgId=' + orgId + '&s_queryUnderUnit='
				+ queryUnderUnit + '&s_qlState=A', 'powerWindow', null);
	}
	$(function (){
		var time1='${s_begFinishTime}';
		var time2='${s_begTime}';
		//alert(time1);
		if(time1!=""){
			$("#s_begFinishTime").val(time1);
		}
		if(time2!=""){
			$("#s_begTime").val(time2);
		}
		
	});
</script>
</html>
