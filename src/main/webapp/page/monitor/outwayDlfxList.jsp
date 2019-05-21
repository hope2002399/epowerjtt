<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title>定量分析办理</title>
		<script type="text/javascript">
		  function resetForm(){
			  $('#orgName').val('');
			  $('#s_orgId').val('');
			  $('#s_queryUnderUnit').val('');
		  }
		</script>
		<sj:head locale="zh_CN" />
   		<script type="text/javascript" src="<s:url value="/scripts/colorbox/jquery.colorbox.js"/>" charset="utf-8"></script>
        <link href="${pageContext.request.contextPath}/scripts/colorbox/colorbox.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/scripts/jquery-ui/jquery-ui-1.9.2.custom.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="<s:url value="/scripts/addressBook.js"/>" charset="utf-8"></script>
		<script type="text/javascript" src="<s:url value="/scripts/centit.js"/>" charset="utf-8"></script>
		<script type="text/javascript" src="<s:url value="/scripts/jquery-ui/jquery-ui-1.9.2.custom.js"/>" charset="utf-8"></script>
		<script type="text/javascript" src="<s:url value="/scripts/opendiv_Win.js"/>" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset
			style="border: hidden 1px #000000; ">
			<legend class="ctitle" style="width:auto;">
				 <s:text name="label.list.filter" />
			</legend>
			<s:form action="outway" namespace="/monitor" style="margin-top:0;margin-bottom:5" id="outwayForm" method="post" >
			<input type="hidden" name="s_monitorSource" value="${object.monitorSource}"/>
				<table cellpadding="0" cellspacing="0" class="viewTable">
					 <tr height="22">
					<td class="addTd">部门名称:</td>
					<td>
					<input type="text" id="orgName" name="orgName"  value="${cp:MAPVALUE('depno',param.s_orgId)}"/>
					<input type="hidden" id="s_orgId" name="s_orgId" value="${param.s_orgId}"/>
					<s:checkbox label="包含下属机构" name="s_queryUnderUnit" id="s_queryUnderUnit" value="#parameters['s_queryUnderUnit']" fieldValue="true" />包含下属机构
					</td>
				 	<td class="addTd">报警类别:</td>
					<td width="300"><select name="s_monitorType">
					<option value="">-----请选择-------</option>
					<c:forEach var="row" items="${cp:DICTIONARY('Warnpointname')}">
								<option value="${row.key}"
									<c:if test="${parameters.s_monitorType[0] eq row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select>
					</td>
					 </tr>
					<tr><td class="addTd">预警时间</td>
					<td ><sj:datepicker name="s_begTime" readonly="true" id="s_begTime"
							value="%{#parameters['s_begTime']}" yearRange="2010:2030"
							changeYear="true" displayFormat="yy-mm-dd" />
					至<sj:datepicker
							name="s_endTime" readonly="true" id="s_endTime"
							value="%{#parameters['s_endTime']}" yearRange="2010:2030"
							changeYear="true" displayFormat="yy-mm-dd" />
					</td>
					<td class="addTd">异常类别:</td>
					<td width="300"><select name="s_monitorStyle">
					<option value="">-----请选择-------</option>
					<c:forEach var="row" items="${cp:DICTIONARY('MONITOR_STYLE')}">
								<option value="${row.key}"
									<c:if test="${parameters.s_monitorStyle[0] eq row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
					 </tr>
					 <tr><td colspan="4"><s:submit method="DlfxList" key="opt.btn.query" cssClass="btn" ></s:submit></td></tr>
				</table>
			</s:form>
		</fieldset>

			<ec:table action="monitor/outway!DlfxList.do" items="objList" var="info" imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif"  retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="monitorStyle" title="&nbsp;" style="text-align:center" sortable="false">
					<c:if test="${info.monitorStyle eq 1}"><img align="middle" alt="预警" src="${pageContext.request.contextPath}/images/yellow.gif" /></c:if>
					<c:if test='${info.monitorStyle  eq 2}'><img align="middle" alt="报警" src="${pageContext.request.contextPath}/images/red.gif" /></c:if>
					<c:if test='${info.monitorStyle eq 3}'><img align="middle" alt="提醒" src="${pageContext.request.contextPath}/images/green.gif" /></c:if>
				</ec:column>
				<ec:column property="monitorType" title="报警类别" style="text-align:center" sortable="false">
					${cp:MAPVALUE("Warnpointname",info.monitorType)}
				</ec:column>
				<ec:column property="monitorDesc" title="说明"  style="text-align:center" sortable="false">
					 <c:choose>
					<c:when test="${fn:length(info.monitorDesc) > 30}">
						<c:out value="${fn:substring(info.monitorDesc, 0, 30)}..." />
					</c:when>
					<c:otherwise>
						<c:out value="${info.monitorDesc}" />
					</c:otherwise>
				</c:choose> 
				</ec:column>
				<ec:column property="orgId" title="部门名称" style="text-align:center" sortable="false">
					<a href="${pageContext.request.contextPath}/supervise/superviseBasic!DlfxInfo.do?s_orgId=${info.orgId}&s_outwayNo=${info.outwayno}&optId=DLFXDBLC">${cp:MAPVALUE("depno",info.orgId)}</a>
				</ec:column>
				<ec:column property="intime" title="预报警时间" style="text-align:center">
					<fmt:formatDate value='${info.intime}' pattern='yyyy-MM-dd' />
				</ec:column>
				<%-- <ec:column property="supervisionType" title="督办状态" style="text-align:center" sortable="false">
					${cp:MAPVALUE("supervisionType2",info.supervisionType)}
				</ec:column> --%>
				<ec:column property="ss" title="操作" style="text-align:center" sortable="false">
					<%-- <c:if test="${info.supervisionType eq null}"> --%><a href="${pageContext.request.contextPath}/supervise/superviseBasic!DlfxInfo.do?s_orgId=${info.orgId}&s_outwayNo=${info.outwayno}&optId=DLFXDBLC&bjType=${info.bjType}">督办</a><%-- </c:if> --%>
					<c:if test="${info.outtime ne null}">&nbsp;</c:if>
					<c:if test="${info.outtime eq null}">
					<a href='monitor/outway!DlfxEdit.do?outwayno=${info.outwayno}&s_begTime=${param.s_begTime}&s_endTime=${param.s_endTime}&s_orgId=${param.s_orgId}&s_monitorType=${param.s_monitorType}&s_monitorStyle=${param.s_monitorStyle}&s_queryUnderUnit=${param.s_queryUnderUnit}'>摘牌</a></c:if> 
				</ec:column>
			</ec:row>
		</ec:table> 
	</body>
	<script type="text/javascript">
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
