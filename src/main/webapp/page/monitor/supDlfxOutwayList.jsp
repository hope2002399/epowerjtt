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
			  $('#s_supervisionType').val('');
			  $('#s_outwayType').val('');
			  $('#s_warnPointNo').val('');
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
			<s:form action="supDlfxOutway" namespace="/monitor" style="margin-top:0;margin-bottom:5" id="supDlfxOutwayForm" method="post" >
				<table cellpadding="0" cellspacing="0" class="viewTable">
					 <tr height="22">
					<td class="addTd">部门名称:</td>
					<td>
					<input type="text" id="orgName" name="orgName"  value="${cp:MAPVALUE('depno',param.s_orgId)}"/>
					<input type="hidden" id="s_orgId" name="s_orgId" value="${param.s_orgId}"/>
					<s:checkbox label="包含下属机构" name="s_queryUnderUnit" id="s_queryUnderUnit" value="#parameters['s_queryUnderUnit']" fieldValue="true" />包含下属机构
					</td>
					<td class="addTd">分析类别:</td>
					<td width="300"><select name="s_analysisType">
					<option value="">-----请选择-------</option>
					<c:forEach var="row" items="${cp:DICTIONARY('Warnpointname')}">
								<option value="${row.key}"
									<c:if test="${parameters.s_analysisType[0] eq row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select>
					</td>
					 </tr>
					 <tr height="22">
					 <td class="addTd">报警类别:</td>
						<td width="300"><select name="s_warnPointNo">
							<option value="">-----------------请选择-----------------</option>
							<c:forEach var="row" items="${cp:DICTIONARY('Warnpointno')}">
								<option value="${row.key}"
									<c:if test="${parameters.s_warnPointNo[0] eq row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select>
					 </td>
					<td class="addTd">报警类型:</td>
					<td width="300"><select name="s_outwayType">
					<option value="">-----请选择-------</option>
					<c:forEach var="row" items="${cp:DICTIONARY('outwayType')}">
								<option value="${row.key}"
									<c:if test="${parameters.s_outwayType[0] eq row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
						
					 </tr>
					<tr>
					<td colspan="4"><s:submit method="list" key="opt.btn.query" cssClass="btn" ></s:submit></td>
					</tr>
				</table>
			</s:form>
		</fieldset>

			<ec:table action="monitor/supDlfxOutway!list.do" items="ybjList" var="info" imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif"  retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="outwayType" title="&nbsp;" style="text-align:center" sortable="false">
					<c:if test="${info.outwayType eq 1}"><img align="middle" alt="预警" src="${pageContext.request.contextPath}/images/yellow.gif" /></c:if>
					<c:if test='${info.outwayType  eq 2}'><img align="middle" alt="报警" src="${pageContext.request.contextPath}/images/red.gif" /></c:if>
					<c:if test='${info.outwayType eq 3}'><img align="middle" alt="提醒" src="${pageContext.request.contextPath}/images/green.gif" /></c:if>
				</ec:column>
				<ec:column property="warnPointNo" title="报警类别" style="text-align:center" sortable="false">
					${cp:MAPVALUE("Warnpointno",info.warnPointNo)}
				</ec:column>
				<ec:column property="desc1" title="说明"  style="text-align:center" sortable="false">
					 <c:choose>
					<c:when test="${fn:length(info.desc1) > 30}">
						<c:out value="${fn:substring(info.desc1, 0, 30)}..." />
					</c:when>
					<c:otherwise>
						<c:out value="${info.desc1}" />
					</c:otherwise>
				</c:choose> 
				</ec:column>
				<ec:column property="orgId" title="部门名称" style="text-align:center" sortable="false">
					<a href="${pageContext.request.contextPath}/supervise/superviseBasic!DlfxInfo.do?s_orgId=${info.orgId}&s_outwayNo=${info.outwayId}">${cp:MAPVALUE("depno",info.orgId)}</a>
				</ec:column>
				<ec:column property="inTime" title="预报警时间" style="text-align:center">
					<fmt:formatDate value='${info.inTime}' pattern='yyyy-MM-dd' />
				</ec:column>
				<ec:column property="supervisionType" title="督办状态" style="text-align:center" sortable="false">
					${cp:MAPVALUE("supervisionType2",info.supervisionType)}
				</ec:column>
				<ec:column property="ss" title="操作" style="text-align:center" sortable="false">
					<c:if test="${info.supervisionType eq null}"><a href="${pageContext.request.contextPath}/supervise/superviseBasic!DlfxInfo.do?s_orgId=${info.orgId}&s_outwayNo=${info.outwayId}&optId=DLFXDBLC">督办</a></c:if>
					<c:if test="${info.isCheck eq 1}">&nbsp;</c:if>
					<c:if test="${info.isCheck eq 0}"><a href="#">摘牌</a></c:if>
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
			menuDisplay(menuList,"${parentUnit}");	
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
