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
			<s:form action="supInfoBasicDlfx" namespace="/supervise" style="margin-top:0;margin-bottom:5" id="supInfoBasicDlfxForm" method="post" >
				<table cellpadding="0" cellspacing="0" class="viewTable">
					 <tr height="22">
					<td class="addTd">部门名称:</td>
					<td>
					<input type="text" id="orgName" name="orgName"  value="${cp:MAPVALUE('depno',param.s_orgId)}"/>
					<input type="hidden" id="s_orgId" name="s_orgId" value="${param.s_orgId}"/>
					<s:checkbox label="包含下属机构" name="s_queryUnderUnit" id="s_queryUnderUnit" value="#parameters['s_queryUnderUnit']" fieldValue="true" />包含下属机构
					
					<%--  <tr>
                     <td class="addTd">统计时间:</td>
                     <td align="left"> 年：
					<select name="s_year">
							<option value="">--请选择--</option>
					 <c:forEach var="row" items="${cp:DICTIONARY('yearList')}" >
								<option value="${row.key}"
									<c:if test="${parameters.s_year[0] eq row.key}">selected="selected"</c:if>>
									<c:out value="${row}" />
								</option>
							</c:forEach> 
					
					</select>
				月：
					<select name="s_month">
							<option value="">--请选择--</option>
					 <c:forEach var="row" items="${cp:DICTIONARY('monthList')}">
								<option value="${row.key}"
									<c:if test="${parameters.s_month[0] eq row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option> 
							</c:forEach> 
					</select></td> --%>
					<s:submit method="jlList" key="opt.btn.query" cssClass="btn" ></s:submit></td>
					</tr>
				</table>
			</s:form>
		</fieldset>

			<ec:table action="supervise/supInfoBasicDlfx!fkList.do" items="basicList" var="info" imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif"  retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="orgId" title="被督办部门名称" style="text-align:center" sortable="false">
					<a href="${pageContext.request.contextPath}/supervise/supInfoBasicDlfx!supDlfxJl.do??s_superviseCode=${info.superviseCode}&s_orgId=${info.orgId}&s_supervisionMonth=${info.supervisionMonth}&s_supervisionYear=${info.supervisionYear}&s_no=${info.no}">${cp:MAPVALUE("depno",info.orgId)}</a>
				</ec:column>
				<ec:column property="operatorId" title="督办发起人" style="text-align:center" sortable="false">
					${info.operatorId}
				</ec:column>
				<ec:column property="superviseOption" title="督办意见" style="text-align:center" sortable="false">
					${info.superviseOption}
				</ec:column>
				<ec:column property="superDate" title="督办时间" style="text-align:center" sortable="false">
					<fmt:formatDate value='${info.superDate}' pattern='yyyy-MM-dd' />
				</ec:column>
				<ec:column property="dealStep" title="督办状态" style="text-align:center" sortable="false">
					${cp:MAPVALUE("supervisionType2",info.dealStep)}
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
