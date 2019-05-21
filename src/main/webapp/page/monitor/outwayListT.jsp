<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<sj:head locale="zh_CN" />
<title><s:text name="outway.list.title" /></title>
<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
	<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />	
</head>
<body>
	<%@ include file="/page/common/messages.jsp"%>
	<div class="search">
			<div class="crumbs">
				预报警日志查看
			</div>
		<s:form action="outwaycalc" namespace="/monitor" style="margin-top:0;margin-bottom:5" id="outwaycalcForm">
		<input  type="hidden" name="s_calcNo" id="s_calcNo" value="${param.s_calcNo}"/>
			<table cellpadding="0" cellspacing="0" align="center">
			<tr>
				<td>主办部门:<input type="text" id="orgName" name="orgName" style="width:100px;height:20px;" value="${cp:MAPVALUE('unitcode',param.s_orgId)}"/>
							<input type="hidden" id="s_orgId" name="s_orgId" value="${param.s_orgId}"/>	
					 		<s:checkbox label="包含下属机构" name="s_queryUnderUnit" value="#parameters['s_queryUnderUnit']" fieldValue="true" />包含下属机构	 
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;办件编号: <s:textfield name="s_internalNo"  value="%{#parameters['s_internalNo']}"/>
					</td>
				</tr>
				<tr>
					<td><s:text name="outway.bjType" />: <select name="s_bjType"
						style="width: 180px" >
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('bjType')}">
								<option value="${row.key}"
									<c:if test="${parameters.s_bjType[0] eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:text
							name="outway.monitorStyle" />: <select name="s_monitorStyle"
						style="width: 180px" >
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('MONITOR_STYLE')}">
								<option value="${row.key}"
									<c:if test="${parameters.s_monitorStyle[0] eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
								</select>
				</td></tr>
				<tr>
				<td>
				<s:text name="outway.monitorType" />: <select name="s_monitorType"
						style="width: 180px">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('MONITOR_TYPE')}">
								<option value="${row.key}"
									<c:if test="${parameters.s_monitorType[0] eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select>&nbsp;&nbsp;<input type="button" class="btn" value="查询" onclick="checkType();"/></td>
				</tr>
			</table>
		</s:form>
	</div>
	<c:set var="cxparam"
		value="s_bjType=${s_bjType }&s_orgId=${s_orgId }&s_internalNo=${s_internalNo }&s_monitorStyle=${s_monitorStyle }&s_monitorType=${s_monitorType }"></c:set>
	<ec:table action="monitor/outwaycalc!outwaylist.do" items="outwayList" var="outway"
		imagePath="${contextPath}/themes/css/images/table/*.gif"
		retrieveRowsCallback="limit">
		<ec:row>
			<ec:column property="bjType" title="办件类型"
				style="text-align:center">
				<c:out value="${cp:MAPVALUE('bjType',outway.bjType)}"></c:out>
			</ec:column>

			<ec:column property="orgId" title="主办部门" style="text-align:center">
				<c:out value="${cp:MAPVALUE('depno',outway.orgId)}"></c:out>
			</ec:column>

			<ec:column property="internalNo" title="办件编号"
				style="text-align:center" />

			<c:set var="tmonitorStyle">
				<s:text name='outway.monitorStyle' />
			</c:set>
			<ec:column property="monitorStyle" title="${tmonitorStyle}"
				style="text-align:center">
				<c:out value="${cp:MAPVALUE('MONITOR_STYLE',outway.monitorStyle)}"></c:out>
			</ec:column>

			<c:set var="tmonitorType">
				<s:text name='outway.monitorType' />
			</c:set>
			<ec:column property="monitorType" title="${tmonitorType}"
				style="text-align:center">
				<c:out value="${cp:MAPVALUE('MONITOR_TYPE',outway.monitorType)}"></c:out>
			</ec:column>

			<c:set var="tmonitorLogo">
				<s:text name='outway.monitorLogo' />
			</c:set>
			<ec:column property="monitorLogo" title="${tmonitorLogo}" style="text-align:center" />

			<c:set var="tintime">
				<s:text name='outway.intime' />
			</c:set>
			<ec:column property="intime" title="${tintime}"
				style="text-align:center">
				<fmt:formatDate value="${outway.intime}"
					pattern="yyyy-MM-dd HH:mm:ss" />
			</ec:column>

			<c:set var="optlabel">
				<s:text name="opt.btn.collection" />
			</c:set>
			<ec:column property="opt" title="${optlabel}" sortable="false"
				style="text-align:center">
				<a href='monitor/outway!view.do?outwayno=${outway.outwayno}&ec_p=${ec_p}&ec_crd=${ec_crd}'>查看</a>
		
			</ec:column>

		</ec:row>
	</ec:table>
</body>
<script type="text/javascript">
function checkType() {
	 var form=document.getElementById("outwaycalcForm");
    form.action="outwaycalc!outwaylist.do";     
    form.submit();
}
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
							window.location.href = "monitor/outway!editPLZP.do?warnNos="
									+ warnNos + "&${cxparam}";
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
</script>
</html>
