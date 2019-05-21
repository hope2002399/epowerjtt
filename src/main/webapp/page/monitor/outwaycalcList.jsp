<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html>
	<head>
		<title>
			预报警计算日志查看
		</title>
		<script type="text/javascript">
      function resetForm(){
	 $('#s_begincalcTime').val('');
	 $('#s_endcalcTime').val('');
	 
 }
      </script>
		<sj:head locale="zh_CN" />
		<script src="${pageContext.request.contextPath}/scripts/suggest.js" type="text/javascript"></script>
	</head>
<script type="text/javascript">
</script>
	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<div class="search">
			<div class="crumbs">
				预报警计算日志查看
			</div>
			<s:form action="outwaycalc"  namespace="/monitor" id="outwaycalcForm" style="margin-top:0;margin-bottom:5">
				<table >
				<tr height="22">
						<td  width="25%" align="right">计算时间:</td>
						<td><sj:datepicker name="s_begincalcTime" id="s_begincalcTime" readonly="true"
								value="%{#parameters['s_begincalcTime']}" yearRange="2010:2030"
								displayFormat="yy-mm-dd" changeYear="true" />&nbsp;&nbsp;至&nbsp;&nbsp;<sj:datepicker name="s_endcalcTime" id="s_endcalcTime" readonly="true"
								value="%{#parameters['s_endcalcTime']}" yearRange="2010:2030"
								displayFormat="yy-mm-dd" changeYear="true" />
								<s:submit method="list" key="opt.btn.query" cssClass="btn" />
						<input type="button" name="reset" value="重置" class="btn" onclick="resetForm();"/></td> 
					</tr>
					
				</table>
			</s:form>
		</div>
		<ec:table action="outwaycalc!list.do" items="outwaycalcList" var="outwaycalc"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="calcNo" title="计算序列号" style="text-align:center">
                    ${outwaycalc.calcNo}
				</ec:column>
				<ec:column property="calcTime" title="计算时间" style="text-align:center" >
					<fmt:formatDate value='${outwaycalc.calcTime}' pattern='yyyy-MM-dd' />
				</ec:column>
				<ec:column property="callType" title="调用方式" style="text-align:center" >
					${cp:MAPVALUE("call_type",outwaycalc.callType)}
				</ec:column>
				 <ec:column property="caller" title="调用人员"  style="text-align:center" >
					${cp:MAPVALUE("usercode",outwaycalc.caller)}
				</ec:column>
				<ec:column property="scopeBegin" title="计算范围起始日期" style="text-align:center" >
				<fmt:formatDate value='${outwaycalc.scopeBegin}' pattern='yyyy-MM-dd' />
				</ec:column>
				<ec:column property="scopeEnd" title="计算范围终止日期"  style="text-align:center" >
				<fmt:formatDate value='${outwaycalc.scopeEnd}' pattern='yyyy-MM-dd' />
				</ec:column>
				<ec:column property="alertPieces" title="预警条数" style="text-align:center" >
				<a href="outwaycalc!outwaylist.do?s_calcNo=${outwaycalc.calcNo}">${outwaycalc.alertPieces}</a>
				</ec:column>
				<ec:column property="alarmPieces" title="报警条数" style="text-align:center" >
					<a href='outwaycalc!outwaylist.do?s_calcNo=${outwaycalc.calcNo}'>${outwaycalc.alarmPieces}</a>
				</ec:column> 
			</ec:row>
		</ec:table>
	</body>
	<script type="text/javascript">
	function updateParamValue(paramNo) {
		 var form=document.getElementById("outwayparamForm");
		 var paramValue=document.getElementById("paramValueT");
		/*  alert(paramValue.value); */
	     form.action="outwayparam!outwayparamSave.do?paramNo="+paramNo+"&paramValue="+paramValue.value;     
	     form.submit();
	}
	</script>
</html>
