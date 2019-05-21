<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>层级监察督查督办</title>
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
	<fieldset style="border: hidden 1px #000000;">
		<legend>
			<s:text name="label.list.filter" />
		</legend>

		<s:form action="superviseCJJC" namespace="/supervise"
			style="margin-top:0;margin-bottom:5" id="superviseCJJCForm">
			<table cellpadding="0" cellspacing="0" align="center">
				<tr>
					<td>主办部门:<select name="s_orgId" id="s_orgId" style="width: 180px">
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
					
					<%-- <td>督办状态:
						<select name="s_monitorStyle" id="s_monitorStyle"style="width: 180px">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('warnpointno_cj')}">
								<option value="${row.key}"
									<c:if test="${parameters.s_warnPointNo[0] eq row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td> --%>
				</tr>
				<tr>
					<td>发起时间:<sj:datepicker name="s_begTime" readonly="true" id="s_begTime"
							value="%{#parameters['s_begTime']}" yearRange="2010:2030"
							changeYear="true" displayFormat="yy-mm-dd" />
						&nbsp;——&nbsp; <sj:datepicker
							name="s_endTime" readonly="true" id="s_endTime"
							value="%{#parameters['s_endTime']}" yearRange="2010:2030"
							changeYear="true" displayFormat="yy-mm-dd" /><c:if test="${cp:CHECKUSEROPTPOWER('YJBJ', 'edit') }"> <c:if
							test="${parameters.s_NP_outWayZC[0]=='1' }">&nbsp;&nbsp;&nbsp;
				        &nbsp;&nbsp;&nbsp;<input type="button" class="btn"
								value="摘牌" name="doZP" id="doZP" />
								
						</c:if></c:if> 
					</td>
				</tr>
				<tr><td>
					<s:submit method="list" key="opt.btn.query" cssClass="btn" />
					<input type="button" name="reset" value="重置" class="btn" onclick="resetForm();"/>
				</td></tr>
			</table>
		</s:form>
	</fieldset>
	<c:set var="cxparam"
		value="s_NP_outWayZC=${s_NP_outWayZC }&s_NP_outWayQX=${s_NP_outWayQX }&s_bjType=${s_bjType }&s_orgId=${s_orgId }&s_internalNo=${s_internalNo }&s_monitorStyle=${s_monitorStyle }&s_monitorType=${s_monitorType }&s_begTime=${s_begTime }&s_endTime=${s_endTime }"></c:set>
	<ec:table action="supervisecjjc!list.do" items="objList" var="sup"
		imagePath="${contextPath}/themes/css/images/table/*.gif"
		retrieveRowsCallback="limit">
		<ec:row>
			<ec:column property="supervisecode" title="督办编码" style="text-align:center">
				<c:if test="${not empty param.step}">
				<a href="supervisecjjc!edit.do?outwayid=${sup.no}&supervisecode=${sup.supervisecode}&step=${param.step}"><c:out value="${sup.supervisecode}"></c:out></a>
				</c:if>
				<c:if test="${empty param.step}">
				<a href="supervisecjjc!view.do?outwayid=${sup.no}&supervisecode=${sup.supervisecode}"><c:out value="${sup.supervisecode}"></c:out></a>
				</c:if>
			</ec:column>
			<ec:column property="orgId" title="主办部门" style="text-align:center">
				<c:out value="${cp:MAPVALUE('depno',sup.orgId)}"></c:out>
			</ec:column>
			<ec:column property="orgId" title="发起时间" style="text-align:center">
				<fmt:formatDate value="${sup.superdate}" pattern="yyyy-MM-dd HH:mm:ss" />
			</ec:column>
			<ec:column property="orgId" title="状态" style="text-align:center">
				<c:if test="${sup.dealstep eq 2}">待反馈</c:if>
				<c:if test="${sup.dealstep eq 3}">待办结</c:if>
				<c:if test="${sup.dealstep eq 4}">已办结</c:if>
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
