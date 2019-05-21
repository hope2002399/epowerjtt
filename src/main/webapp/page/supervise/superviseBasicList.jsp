<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>督办</title>
<sj:head locale="zh_CN" />
<script type="text/javascript">
	function resetForm() {
		$('#s_superviseNo').val('');
		$('#s_bjNo').val('');
		$('#s_endsupervisedate').val('');
		$('#s_begsupervisedate').val('');
		$('#s_state').val('');
		$('#s_orgId').val('');
		$('#orgName').val('');
	}
</script>
<style type="text/css">
		.search td{padding:0px 10px 0px 10px;}
	
#ui-datepicker-div {z-index:25000 !important;}
</style>
<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<%@ include file="/page/common/messages.jsp"%>
	<div class="search">
			<div class="crumbs">
				督办查看
			</div>

		<s:form action="superviseBasic" namespace="/supervise"
			style="margin-top:0;margin-bottom:5">
			<input type="hidden" name="isfromfq" value="${param.isfromfq}" />
			<input type="hidden" name="s_bizType" value="${param.s_bizType}" />
			<input type="hidden" name="s_monitorSource" value="${param.s_monitorSource}" />
			<input type="hidden" name="s_optId" value="${param.s_optId}" />
			<input type="hidden" name="s_NP_monitorSource" value="${param.s_NP_monitorSource}" />
			<table cellpadding="0" cellspacing="0" align="center">
				<tr>
					<td width="100px">督办流水号：</td>
					<td><input type="text" name="s_superviseNo" id="s_superviseNo "value="${param.s_superviseNo}" ></td>
					
					<td>办件流水号：</td>
					<td><input type="text" name="s_bjNo" id="s_bjNo "value="${param.s_bjNo}" ></td>
					
				<tr height="22">
					<td>开始时间：</td><td> <sj:datepicker
							name="s_begsupervisedate" id="s_begsupervisedate" readonly="true"
							value="%{#parameters['s_begsupervisedate']}"
							yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" />
					</td>
					<td>结束时间：</td><td><sj:datepicker
							name="s_endsupervisedate" id="s_endsupervisedate" readonly="true"
							value="%{#parameters['s_endsupervisedate']}"
							yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" />
					</td>
				<tr>
					<td>督办状态：</td><td><select
						name="s_state" id="s_state" style="width: 160px">

							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('superviseState')}">
								<option
									<c:if test="${param.s_state == row.key}">selected="selected"</c:if>
									value="${row.key}" label="${row.value}">
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select>
					<%-- <td>部门名称:&nbsp;&nbsp;&nbsp; 
					<input type="text" id="orgName" name="orgName"  value="${cp:MAPVALUE('depno',param.s_monitorOrgId)}"/>
					<input type="hidden" id="s_monitorOrgId" name="s_monitorOrgId" value="${param.s_monitorOrgId}"/>
					 <s:checkbox label="包含下属机构" name="s_queryUnderUnit"
							value="#parameters['s_queryUnderUnit']" fieldValue="true" />包含下属机构
					</td> --%>
					<td>主办部门：</td><td>
					<input type="text" id="orgName" name="orgName"  value="${cp:MAPVALUE('depno',param.s_orgId)}"/>
					<input type="hidden" id="s_orgId" name="s_orgId" value="${param.s_orgId}"/>
					 <s:checkbox label="包含下属机构" name="s_queryUnderUnit"
							value="#parameters['s_queryUnderUnit']" fieldValue="true" />包含下属机构
					</td>

				</tr>
				<tr>
					<td>
						督办件类别：</td><td>
						<select name="s_bjType" id="s_bjType" style="width: 160px">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('bjType')}">
								<option
									<c:if test="${param.s_bjType == row.key}">selected="selected"</c:if>
									value="${row.key}" label="${row.value}">
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
						</select>
					</td>
					<td>
						是否客观：</td><td> <select
						name="s_isexternal" style="width: 160px">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('isExternal')}">

								<option value="${row.key}" label="${row.value}"
									<c:if test="${param.s_isexternal == row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
                    
					<td align="center" colspan="4"><s:submit method="list" key="opt.btn.query"
							cssClass="btn" />
						<c:if test="${cp:CHECKUSEROPTPOWER('DBFQ', 'superviseinitiate') }">
							<c:if test="${param.isfromfq=='F'||param.s_bizType=='F'}">
								<input type="button" class="btn" value="督办发起"
									onclick="initailDB();">&nbsp;&nbsp;&nbsp;
						</c:if>
						</c:if> <input type="button" name="reset" value="重置" class="btn"
						onclick="resetForm();" /></td>
				</tr>
				<tr>

				</tr>
			</table>
	</s:form>
	</div>
	<ec:table action="supervise/superviseBasic!list.do" items="vsuplist"
		var="superviseBasic"
		imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif"
		retrieveRowsCallback="limit">
		<ec:row>
			<ec:column property="superviseNo" title="督办流水号" style="text-align:center" sortable="true" />
			<ec:column property="bjType" title="督办件类别" style="text-align:center"sortable="true">
				${cp:MAPVALUE("bjType",superviseBasic.bjType)}
			</ec:column>
			<c:if test="${superviseBasic.monitorSource ne c }">
			<ec:column property="bjNo" title="办件编号" style="text-align:center"sortable="true" />
				</c:if>
			<ec:column property="orgId" title="主办部门" style="text-align:center"
				sortable="true">
				${cp:MAPVALUE("depno",superviseBasic.orgId)}&nbsp;
			</ec:column>
			<ec:column property="state" title="状态" style="text-align:center"
				sortable="true">
				${cp:MAPVALUE("superviseState",superviseBasic.state)}
			</ec:column>
			<ec:column property="isexternal" title="是否客观"
				style="text-align:center" sortable="true">
				${cp:MAPVALUE("isExternal",superviseBasic.isexternal)}
			</ec:column>
			<ec:column property="opt" title="操作" sortable="false"
				style="text-align:center">
				<a
					href='supervise/superviseBasic!view.do?superviseNo=${superviseBasic.superviseNo}&flowInstId=${superviseBasic.flowInstId}'>查看</a>
				<c:if test="${superviseBasic.bizType=='F'}">
					<a
						href='supervise/superviseBasic!edit.do?superviseNo=${superviseBasic.superviseNo}'>编辑</a>
					<a href='#'
						onclick="confirm_check('${superviseBasic.superviseNo}');">删除</a>
				</c:if>
			</ec:column>
		</ec:row>
	</ec:table>

</body>
<script type="text/javascript">
	function initailDB() {
		var href = "supervise/superviseBasic!superviseinitiate.do?optId=supervise&fromsup=&bjNo=";
		window.location.href = href;
	}
</script>

<script type="text/javascript">
	function confirm_check(superviseNo) {
		if (window.confirm("确实删除此[" + superviseNo + "]督办项?")) {
			document.location.href = 'supervise/superviseBasic!delete.do?superviseNo='
					+ superviseNo;
		}
	}
	 var menuList = ${unitsJson};
		function bindEvent(o1,o2,$this){
			o1.val($this.html());
			var key = $this.attr("rel");
			for (var i=0; i<menuList.length; i++) {
				if (key == menuList[i].MID) {
					o2.val(menuList[i].depno);
				}
			}
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
