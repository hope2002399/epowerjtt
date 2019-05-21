<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 

<html>
	<head>
		<title>
			绩效考核
		</title>
		<script type="text/javascript">
		  function resetForm(){
			  $('#s_countYear').val('');
			  $('#s_countMonth').val('');
			  $('#orgName').val('');
			  $('#s_orgId').val('');
		  }
		</script>
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
				人工录入增减分
			</div>
			
			<s:form action="pamonthpunish"  namespace="/monitor" style="margin-top:0;margin-bottom:5">
			<table cellpadding="0" cellspacing="0" align="center">
				<tr>
				<td class="addTd">年：</td>
                   	<td align="left">
					<select name="s_countYear" id="s_countYear">
					<option value="">--请选择--</option>
					<s:iterator value="yearList" id="Id"> 
								<option value="${Id}" <c:if test="${parameters.s_countYear[0] eq Id}">selected="selected"</c:if>>
									<c:out value="${Id}" />
								</option>
					</s:iterator>
					</td>  
				<td class="addTd">月：</td>
					<td><select name="s_countMonth" id="s_countMonth" >
							<option value="">--请选择--</option>
					<c:forEach var="row" items="${cp:DICTIONARY('monthList')}">
								<option value="${row.key}"
									<c:if test="${parameters.s_countMonth[0] eq row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
				
				
					<td class="addTd">部门名称：</td>
					<td><input type="text" id="orgName" name="orgName" style="width:120px;height:20px;" value="${cp:MAPVALUE('unitcode',param.s_orgId)}"/>
							<input type="hidden" id="s_orgId" name="s_orgId" value="${param.s_orgId}"/>	
					 		<%-- <s:checkbox label="包含下属机构" name="s_queryUnderUnit" value="#parameters['s_queryUnderUnit']" fieldValue="true" />包含下属机构	 --%>
					 </td></tr><tr>
						<td colspan="6" align="center">
							<s:submit method="list"  key="opt.btn.query" cssClass="btn"/>&nbsp;&nbsp;&nbsp;
							<input type="button" name="reset" value="重置" class="btn" onclick="resetForm();"/>
							<s:submit method="addscore"  key="增减分录入" cssClass="btn"/>
						</td>
						<td></td>
					</tr>
				</table>
			</s:form>
		</div>

		<ec:table action="pamonthpunish!list.do" items="pamonthpunishList" var="pamonthpunish"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="orgId" title="部门名称" style="text-align:center" >
					${cp:MAPVALUE("unitcode",pamonthpunish.orgId)}
				</ec:column>
				<ec:column property="countYear" title="评测年月" style="text-align:center" >
					${pamonthpunish.countYear}年${pamonthpunish.countMonth}月
				</ec:column>
				<%-- <ec:column property="countMonth" title="评测月份" style="text-align:center" >
					${pamonthpunish.countMonth}	${pamonthpunish.countYear}
				</ec:column> --%>
				<ec:column property="punishType" title="增减分类别"  style="text-align:center" >
			        ${cp:MAPEXPRESSION("statType",pamonthpunish.punishType)} 
			        
				</ec:column>	
				<ec:column property="punishResion" title="增减分说明"  style="text-align:center" >
			         ${pamonthpunish.punishResion}
				</ec:column>
				<ec:column property="punishSum" title="增减分总值"  style="text-align:center" >
			         ${pamonthpunish.punishSum}
					
				</ec:column>
				<ec:column property="auditResult" title="审核结果 "style="text-align:center" >
					${cp:MAPVALUE("auditResult",pamonthpunish.auditResult)}
					
				</ec:column>
				<ec:column property="recordDate" title="录入时间" style="text-align:center" >
					${pamonthpunish.recordDate}
				</ec:column>
				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">
					<c:if test="${pamonthpunish.auditResult eq null}">
					<a href='monitor/pamonthpunish!auditsh.do?punishNo=${pamonthpunish.punishNo}'>审核</a>
					</c:if>
					<a
					href='monitor/pamonthpunish!phview.do?punishNo=${pamonthpunish.punishNo}'>增减分明细查看 </a>
				</ec:column>
			</ec:row>
		</ec:table>
		
		<div class="search">
			<div class="crumbs">
				绩效计算
			</div>
			<s:form action="pacheckupparam"  namespace="/monitor" style="margin-top:0;margin-bottom:5">
			<table cellpadding="0" cellspacing="0" align="center">
                   <tr>
                 <td class="addTd">年：</td>
                   	<td align="left">
					<select name="s_countYear" >
					<option value="">--请选择--</option>
					<s:iterator value="yearList" id="Id"> 
								<option value="${Id}" <c:if test="${parameters.s_countYear[0] eq Id}">selected="selected"</c:if>>
									<c:out value="${Id}" />
								</option>
					</s:iterator></td>  
				
				<td class="addTd">月：</td>
					<td><select name="s_countMonth">
							<option value="">--请选择--</option>
					<c:forEach var="row" items="${cp:DICTIONARY('monthList')}">
								<option value="${row.value}"
									<c:if test="${parameters.s_countMonth[0] eq row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
				
					<td>
						<s:submit method="jsperformance"  key="计算" cssClass="btn"/>	
						</td>
					</tr>
					
					
				</table>
				</s:form>		
				</div>	
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
