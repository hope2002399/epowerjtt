<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<%@ page import="java.util.List"%>
<%@page import="com.centit.monitor.po.PaMonthCheckup"%>
<%@page import="com.centit.monitor.po.Pamonthpunish"%>
<html>
	<head>
		<title>
			明细查看
		</title>
		<sj:head locale="zh_CN" />
	<LINK rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/default/css/lrtk.css">
		<SCRIPT type="text/javascript" src="${pageContext.request.contextPath}/scripts/scrolltop.js"></SCRIPT>
	</head>

	<body>
<%@ include file="/page/common/messages.jsp"%>

	<div id="myDiv" class="tt" style="display: none">

		<A HREF="javascript: window.scrollTo(0, 0); void 0"
			ONMOUSEOVER="window.status = 'top'; return true;"
			ONMOUSEOUT="window.status = ''; return true;"> <img
			align="middle" alt="返回顶部"
			src="${pageContext.request.contextPath}/styles/default/images/lanren_top.jpg"
			border="0" />
		</A>
	</div>
<fieldset>
	<s:form action="paPerformanceResult"  namespace="/monitor" style="margin-top:0;margin-bottom:5">
		<input id="countYear" type="hidden" name="countYear" value="${object.countYear}" />
		  	<input id="countMonth" type="hidden" name="countMonth" value="${object.countMonth}" />
		  	<input id="orgId" type="hidden" name="orgId" value="${object.orgId}" />
			<table cellpadding="0" cellspacing="0" align="center">
                   <tr>		
                   	<td>
				<input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" />
				<s:submit method="jsperformance"  key="计算" cssClass="btn"/>
			<!-- 	<input type="button" class="btn" value="计算" onclick="javascript:jsperformance();"  /> -->
						</td>	
				<td class="addTd" width="130">计算操作：</td>
				<td >			
				<input type="checkbox"  name="s_onlyCalcSun" value="#parameters['s_onlyCalcSun']"
				 fieldValue="true"/>重算
				<input type="checkbox"  name="s_deleteOld" value="#parameters['s_deleteOld']"
				fieldValue="true"  />仅计算总分
				</td>
			</tr>

				</table>
				</s:form>		
</fieldset>
<fieldset>
<legend><b>绩效汇总信息</b></legend>
 	<input id="countYear" type="hidden" name="countYear" value="${object.countYear}" />
		  	<input id="countMonth" type="hidden" name="countMonth" value="${object.countMonth}" />
		  	<input id="orgId" type="hidden" name="orgId" value="${object.orgId}" />
		  	<input id="allNum" type="hidden" name="allNum" value="${object.allNum}" />
		  	<input id="recordNum" type="hidden" name="recordNum" value="${object.recordNum}" />
		  	<input id="calculateNum" type="hidden" name="calculateNum" value="${object.calculateNum}" />
		  	<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
		  	<tr>
				<td class="addTd"><s:text name="部门名称" /></td>
				<td align="left" >${cp:MAPVALUE("unitcode",object.orgId)}</td>
				<td class="addTd"><s:text name="评测年月" /></td>
				<td align="left" colspan="3"><s:property value="%{countYear}" />年<s:property value="%{countMonth}" />月</td>
			</tr>
			<tr>	
				<td class="addTd"><s:text name="人工录入得分" /></td>
				<td align="left"><s:property value="%{recordNum}" /></td>
				<td class="addTd"><s:text name="计算得分" /></td>
				<td align="left" colspan="3"><s:property value="%{calculateNum}" /></td>
		</tr>	
				<tr>	
				<td class="addTd"><s:text name="总得分" /></td>
				<td align="left" ><s:property value="%{allNum}" /></td>
				
		</tr>		
</table>
</fieldset>

<fieldset>
<legend><b>自动计算明细</b></legend>
		
		<ec:table tableId="bt" action="monitor/paPerformanceResult!view.do" items="checklist" var="PaMonthCheckup" imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="org.extremecomponents.table.callback.LimitCallback">
			<ec:row>
				<ec:column property="itemName" title="项目名称" style="text-align:center" >
				          ${PaMonthCheckup.itemName} 
				</ec:column>
				<ec:column property="itemValue" title="项目结果" style="text-align:center" >
				          ${PaMonthCheckup.itemValue}
				</ec:column>
				<ec:column property="itemRule" title="计算公式" style="text-align:center" >
				          ${PaMonthCheckup.itemRule}
				</ec:column>
				<ec:column property="itemRuleDesc" title="计算说明" style="text-align:center" >
				<c:choose>
					<c:when test="${fn:length(PaMonthCheckup.itemRuleDesc) > 30}">
						<c:out value="${fn:substring(PaMonthCheckup.itemRuleDesc, 0, 30)}..." />
					</c:when>
					<c:otherwise>
						<c:out value="${PaMonthCheckup.itemRuleDesc}" />
					</c:otherwise>
				</c:choose>
				        
				</ec:column>
				
           </ec:row>
		</ec:table>
		
</fieldset>
<fieldset>
<legend><b>人工录入明细</b></legend>
	<table border="0" cellpadding="1" cellspacing="1" class="viewTable">
   		<tr class="b_darkblue">
			<td style="text-align:center">增减分类别</td>
			<td style="text-align:center">增减分单项值</td>
			<td style="text-align:center">增减分数量</td>
			<td style="text-align:center">增减分总值</td>
			<td style="text-align:center">增减分说明</td>
		    <td style="text-align:center">增减分录入人</td>
			<td style="text-align:center">增减分录入人时间</td>
		</tr>
		<c:forEach items="${rglrlist }" varStatus="i" var="rglr" >
		
		 <tr class="b_gray">
	   <td style="text-align:center">${cp:MAPEXPRESSION ("statType",rglr.punishType)}  </td>
	   <td style="text-align:center">${rglr.punishUnit}</td>
	   <td style="text-align:center">${rglr.punishCount}</td>
	   <td style="text-align:center">${rglr.punishSum}</td>
	   <td style="text-align:center">${rglr.punishResion}</td>
	   <td style="text-align:center">${rglr.recorder}</td>
	   <td style="text-align:center"><fmt:formatDate value='${rglr.recordDate}' pattern='yyyy-MM-dd HH:mm:ss' /></td>
	    </tr> 
	    </c:forEach>
		</table>
</fieldset>
	</body>
	<script type="text/javascript">
	//function jsperformance(){

	  //  var url='paPerformanceResult!jsperformance.do?countYear='+${object.countYear}+"&countMonth="+${object.countMonth}+"&orgId="+${object.orgId};
	   
		//parent.location.href = url;

	//} 
	</script>
</html>
