<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="outwaycjjc.list.title" /></title>
<script type="text/javascript">
 function resetForm(){
	 $('#s_orgId').val('');
	 $('#s_queryUnderUnit').val('');
	 $('#s_internalNo').val('');
	 $('#s_bjType').val('');
	 $('#s_monitorStyle').val('');
	 $('#s_monitorType').val('');
	 $('#s_begTime').val('');
	 $('#s_endTime').val('');
	 
 }

</script>

<sj:head locale="zh_CN" />
<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
	<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
	
	<%-- <script src="${pageContext.request.contextPath}/scripts/jquery_dialog.js" type="text/javascript"></script>
	<link href="${pageContext.request.contextPath}/styles/default/css/jquery_dialog.css" rel="stylesheet" type="text/css" />		 --%>
</head>
<body>
	<%@ include file="/page/common/messages.jsp"%>
	<div class="search">
			<div class="crumbs">
				查看
			</div>

		<s:form action="outwayCJJC" namespace="/monitor"
			style="margin-top:0;margin-bottom:5" id="outwayCJJCForm">
			<s:hidden name="s_NP_outWayZC"
				value="%{#parameters['s_NP_outWayZC']}"></s:hidden>
			<s:hidden name="s_NP_outWayQX"
				value="%{#parameters['s_NP_outWayQX']}"></s:hidden>
			<table cellpadding="0" cellspacing="0" align="center">
				<tr>
					<td>主办部门:&nbsp;<select name="s_orgId" id="s_orgId" style="width: 180px">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${unitList}">
								<option value="<c:out value='${row.depno}'/>"
									<c:if test="${row.depno==parameters.s_orgId[0]}">selected="selected"</c:if>>
									<c:out value="${row.unitname}" />
								</option>
							</c:forEach>
					</select>
					 		<s:checkbox label="包含下属机构" name="s_queryUnderUnit" id="s_queryUnderUnit" value="#parameters['s_queryUnderUnit']" fieldValue="true" />包含下属机构	 

					</td>
				</tr>

				<tr>
					<td><s:text
							name="outway.monitorStyle" />: <select name="s_warnpointno" id="s_warnpointno"
						style="width: 180px">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('warnpointno_cj')}">
								<option value="${row.key}"
									<c:if test="${parameters.s_warnpointno[0] eq row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;权力类型: <select name="s_oldoutwaytype" id="s_oldoutwaytype"
						style="width: 180px">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('OUTWAY_OLD')}">
								<option value="${row.key}"
									<c:if test="${parameters.s_oldoutwaytype[0] eq row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>开始时间:&nbsp;<sj:datepicker name="s_begTime" readonly="true"
							id="s_begTime" value="%{#parameters['s_begTime']}"
							yearRange="2010:2030" changeYear="true" displayFormat="yy-mm-dd" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;结束时间: <sj:datepicker
							name="s_endTime" readonly="true" id="s_endTime"
							value="%{#parameters['s_endTime']}" yearRange="2010:2030"
							changeYear="true" displayFormat="yy-mm-dd" />
						<c:if test="${cp:CHECKUSEROPTPOWER('YJBJ', 'edit') }">
							<c:if test="${parameters.s_NP_outWayZC[0]=='1' }">&nbsp;&nbsp;&nbsp;
				        &nbsp;&nbsp;&nbsp;<input type="button" class="btn"
									value="摘牌" name="doZP" id="doZP" />

							</c:if>
						</c:if>
					</td>
				</tr>
				<tr><td>
					<s:submit method="list" key="opt.btn.query" cssClass="btn" />
					<input type="button" name="reset" value="重置" class="btn" onclick="resetForm();"/>
				</td></tr>
			</table>
		</s:form>
	</div>
	<c:set var="cxparam"
		value="s_NP_outWayZC=${s_NP_outWayZC }&s_NP_outWayQX=${s_NP_outWayQX }&s_bjType=${s_bjType }&s_orgId=${s_orgId }&s_internalNo=${s_internalNo }&s_monitorStyle=${s_monitorStyle }&s_monitorType=${s_monitorType }&s_begTime=${s_begTime }&s_endTime=${s_endTime }"></c:set>
	<ec:table action="outwayCJJC!list.do" items="objList" var="outwaycjjc"
		imagePath="${contextPath}/themes/css/images/table/*.gif"
		retrieveRowsCallback="limit">
		<ec:row>
			<c:if test="${cp:CHECKUSEROPTPOWER('YJBJ', 'edit') }">
				<c:if test="${parameters.s_NP_outWayZC[0]=='1' }">
					<ec:column property="bj"
						title='<button name="quanxuan" target="false" id="btnXZ">全选</button>'
						style="text-align:center" sortable="false">
						<input type="checkbox" class="delWarn" name="delWarn"
							value="${outway.outwayid }" />
					</ec:column>
				</c:if>
			</c:if>
			
			<ec:column property="outwayType" title="&nbsp;" style="text-align:center" sortable="false">
				<c:if test="${outwaycjjc.outwaytype eq 1}"><img align="middle" alt="预警" src="${pageContext.request.contextPath}/images/yellow.gif" /></c:if>
				<c:if test='${outwaycjjc.outwaytype  eq 2}'><img align="middle" alt="报警" src="${pageContext.request.contextPath}/images/red.gif" /></c:if>
				<c:if test='${outwaycjjc.outwaytype eq 6}'><img align="middle" alt="提醒" src="${pageContext.request.contextPath}/images/green.gif" /></c:if>
			</ec:column>
			
			<c:set var="toutwayid">
				<s:text name='outwaycjjc.outwayid' />
			</c:set>
			<ec:column property="outwayid" title="${toutwayid}" style="text-align:center">
				<c:out value="${outwaycjjc.outwayid}"></c:out>
			</ec:column>

			<ec:column property="orgId" title="主办部门" style="text-align:center">
				<c:out value="${cp:MAPVALUE('depno',outwaycjjc.orgId)}"></c:out>
			</ec:column>
			
			<c:set var="twarnpoint">
				<s:text name='outwaycjjc.warnpoint' />
			</c:set>
			<ec:column property="warnpointno" title="${twarnpoint}" style="text-align:center">
				${cp:MAPVALUE('warnpointno_cj',outwaycjjc.warnpointno)}
			</ec:column>
			
			<ec:column property="oldOutwayId" title="办件编号" style="text-align:center">
				<c:choose>
				<c:when test="${outwaycjjc.oldOutwayType eq 1}">
				<a href="/../jttsunzw/Apply.do?action=warn&doSearch=showInfo&item_id=${outwaycjjc.itemId}&internal_no=${outwaycjjc.internalNo}&usercode=0" target="_BLANK">
				<c:out value="${outwaycjjc.internalNo}"></c:out>
				</a>
				</c:when>
				<c:when test="${outwaycjjc.oldOutwayType eq 2}">
				<a href="/../jttsunzw/Punish.do?action=warn&doSearch=showInfo&org_id=${outwaycjjc.orgId}&internal_no=${outwaycjjc.internalNo}&usercode=0" target="_BLANK">
				<c:out value="${outwaycjjc.internalNo}"></c:out>
				</a>
				</c:when>
				</c:choose>
			</ec:column>

			<c:set var="tintime">
				<s:text name='outway.intime' />
			</c:set>
			<ec:column property="intime" title="${tintime}"
				style="text-align:center">
				<fmt:formatDate value="${outwaycjjc.intime}"
					pattern="yyyy-MM-dd HH:mm:ss" />
			</ec:column>

			<c:set var="optlabel">
				<s:text name="opt.btn.collection" />
			</c:set>
			<ec:column property="opt" title="${optlabel}" sortable="false"
				style="text-align:center">
				<a href='outwayCJJC!view.do?outwayid=${outwaycjjc.outwayid}'>督办</a>

				<a href='#'>摘牌</a>
			</ec:column>

		</ec:row>
	</ec:table>
</body>
<script type="text/javascript">
	$("#btnXZ").bind('click', function() {
		if ($("#btnXZ").attr("target") == "false") {
			$("#btnXZ").attr("target", "true");
			$(".delWarn").attr("checked", "true");
			$("#btnXZ").text("取消");
		} else {
			$("#btnXZ").attr("target", "false");
			$(".delWarn").removeAttr("checked");
			$("#btnXZ").text("全选");
		}
	});

	$("#doZP")
			.bind(
					'click',
					function() {
						var warnNos = "";
						var items = $('.delWarn:checkbox:checked');
						for ( var i = 0; i < items.length; i++) {
							warnNos = warnNos + items.get(i).value + ',';
						}
						if (warnNos != "") {
							if (confirm("确定对选择的预报警进行摘牌 ？")) {
								/* var form = document.getElementById("outwayForm");
								form.action = "monitor/outway!editPLZP.do?outwayno="+warnNos;
								form.outwayno = warnNos;
								form.submit(); */
								window.location.href = "monitor/outway!editPLZP.do?warnNos=" + warnNos + "&${cxparam}";
								
								//JqueryDialog.Open('预报警批量摘牌 ', "monitor/outway!editPLZP.do?warnNos=" + warnNos + "&${cxparam}", 500, 200);
								
								//$.pdialog.open("monitor/outway!edit.do?outwarnno=37", "zpDialog", "预报警摘牌");
							}
						} else {
							alert("请选择需要进行摘牌操作的预报警信息！");
						}
					});
	
	//部门选择
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
				menuDisplay(menuList,"${parentunit}");	
			},0);
		};
		$("#lists span").live('click',function(){
			var $this = $(this);
			bindEvent($("#orgName"),$("#s_orgId"),$this);
			$("#lists span").die("click");
		});
	});	
	function dbfq(outwayno,bjtype){
		var dbtype=0;
		if(bjtype==1){
			dbtype=5;
		}else if(bjtype==2){
			dbtype=6;
		}
		var url = "<%=request.getContextPath()%>/supervise/superviseBasic!superviseinitiate.do?bjNo="+outwayno+"&bjType="+dbtype+"&object.optId=supervise&fromsup=1&isOrg=F";
		document.location.href = url;
	}
</script>
</html>
