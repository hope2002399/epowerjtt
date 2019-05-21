<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 

<html>
	<head>
		<title>
			绩效考核
		</title>
		<sj:head locale="zh_CN" />
<style type="text/css">
		.search td{padding:0px 10px 0px 10px;}
</style>
		<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
	<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />	
	</head>
<script type="text/javascript">


</script>
	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<div class="search">
			<div class="crumbs">
				绩效考核汇总
			</div>
			
			<s:form action="paPerformanceResult"  namespace="/monitor" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">
				<tr>
				<td class="addTd">年：</td>
					<td align="left">
						<jsp:useBean id="now" class="java.util.Date" />
				<fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy" var="thisyear"/>
				<select name="s_countYear" style="width: 152px" id="fileyear">
					<option value="">--请选择--</option>
					<c:forEach var="row" begin="${thisyear}" end="${thisyear+10}" varStatus="c">
					<option value="${thisyear+1-c.count}"
						<c:if test="${parameters.s_countYear[0] eq thisyear+1-c.count}"> selected = "selected" </c:if>>
						<c:out value="${thisyear+1-c.count}" />
					</option>
					</c:forEach>
				<lect>
					</td>
				
				<td class="addTd">月：</td>
					<td><select name="s_countMonth">
							<option value="">--请选择--</option>
					<c:forEach var="row" items="${cp:DICTIONARY('monthList')}">
								<option value="${row.key}"
									<c:if test="${parameters.s_countMonth[0] eq row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
					
			<td class="addTd">部门名称:</td>
					<td><input type="text" id="orgName" name="orgName" style="width:120px;height:20px;" value="${cp:MAPVALUE('unitcode',param.s_orgId)}"/>
							<input type="hidden" id="s_orgId" name="s_orgId" value="${param.s_orgId}"/>	
					 		<%-- <s:checkbox label="包含下属机构" name="s_queryUnderUnit" value="#parameters['s_queryUnderUnit']" fieldValue="true" />包含下属机构	 --%>
					 </td>
				
						<td>
							<s:submit method="list"  key="opt.btn.query" cssClass="btn"/>
						</td>
					</tr>
				</table>
			</s:form>
		</div>

		<ec:table action="paPerformanceResult!list.do" items="paPerformancneList" var="paPerformanceResult"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
<%-- 				<ec:column property="checkNo" title="考核序号" style="text-align:center">
                    ${paPerformanceResult.checkNo}
				</ec:column> --%>
				<ec:column property="orgId" title="部门名称" style="text-align:center" >
					${cp:MAPVALUE("unitcode",paPerformanceResult.orgId)}
				</ec:column>
			   <ec:column property="countYear" title="测评年月" style="text-align:center">
                    ${paPerformanceResult.countYear}年${paPerformanceResult.countMonth}月
				</ec:column> 
				<ec:column property="recordNum" title="人工录入得分" style="text-align:center" >
					${paPerformanceResult.recordNum}
				</ec:column>
				<ec:column property="calculateNum" title="计算得分" style="text-align:center" >
					${paPerformanceResult.calculateNum}
				</ec:column>
				<ec:column property="allNum" title="总得分" style="text-align:center" >
					${paPerformanceResult.allNum}
				</ec:column>
				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">
					<c:if test="${paPerformanceResult.auditResult eq 0}">
					<a href='monitor/paPerformanceResult!auditsh.do?checkNo=${paPerformanceResult.checkNo}'>审核</a>
					</c:if>
					<c:if test="${paPerformanceResult.auditResult eq 0}">
					<a href='monitor/paPerformanceResult!view.do?countYear=${paPerformanceResult.countYear}&countMonth=${paPerformanceResult.countMonth}&orgId=${paPerformanceResult.orgId}
					&recordNum=${paPerformanceResult.recordNum}&calculateNum=${ paPerformanceResult.calculateNum}&allNum=${paPerformanceResult.allNum}'>查看明细</a>
					</c:if>
					
				</ec:column>
			</ec:row>
		</ec:table>
	</body>
	<script type="text/javascript">
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
