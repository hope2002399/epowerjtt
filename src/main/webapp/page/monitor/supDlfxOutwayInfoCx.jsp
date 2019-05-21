<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title>部门督办查询</title>
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
		<fieldset>
		<legend class="ctitle" style="width:auto;font:·16px">预报警信息</legend>
			<ec:table  items="infoList" var="info" showPagination="false" imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif"  retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="outwayType" title="&nbsp;" style="text-align:center" sortable="false">
					<c:if test="${info.outwayType eq 1}"><img align="middle" alt="预警" src="${pageContext.request.contextPath}/images/yellow.gif" /></c:if>
					<c:if test='${info.outwayType  eq 2}'><img align="middle" alt="报警" src="${pageContext.request.contextPath}/images/red.gif" /></c:if>
					<c:if test='${info.outwayType eq 6}'><img align="middle" alt="提醒" src="${pageContext.request.contextPath}/images/green.gif" /></c:if>
				</ec:column>
				<ec:column property="warnPointNo" title="报警类别" style="text-align:center" sortable="false">
					${cp:MAPVALUE("Warnpointno",info.warnPointNo)}
				</ec:column>
					<ec:column property="desc1" title="说明"  style="text-align:center" sortable="false">
						${info.desc1}
				</ec:column>
				<ec:column property="inTime" title="预报警时间" style="text-align:center">
					<fmt:formatDate value='${info.inTime}' pattern='yyyy-MM-dd' />
				</ec:column>
				<ec:column property="outTime" title="摘牌时间" style="text-align:center">
					<fmt:formatDate value='${info.outTime}' pattern='yyyy-MM-dd' />
				</ec:column>
				<ec:column property="ss" title="操作" style="text-align:center" sortable="false">
					<c:if test="${info.isCheck eq 1}">&nbsp;</c:if>
					<c:if test="${info.isCheck eq 0}"><a href="#">摘牌</a></c:if>
				</ec:column>
			</ec:row>
		</ec:table> 
		</fieldset>
		<fieldset>
		<c:if test="${supInfo.superviseCode ne null}">
		<fieldset >
		<legend class="ctitle" style="width:auto;font:·16px">督查督办基本信息</legend>
			<table border="0" cellpadding="1" cellspacing="1" class="viewTable">
				<tr>
					<td class="addTd" width="20%">督办流水号</td>
					<td align="left">${supInfo.superviseCode}&nbsp;</td>
					<td class="addTd" width="20%">督办发起人</td>
					<td align="left">${cp:MAPVALUE("usercode",supInfo.operatorId)}&nbsp;</td>
				</tr>
				<tr>
				<td class="addTd" width="20%">督办意见</td>
					<td align="left">${supInfo.superviseOption}&nbsp;</td>
				<td class="addTd" width="20%">被督办部门</td>
					<td align="left">${cp:MAPVALUE("depno",supInfo.orgId)}&nbsp;</td>
				</tr>
				<tr>
					<td class="addTd" width="20%">督办时间</td>
					<td colspan="3"><fmt:formatDate value='${supInfo.superDate}' pattern='yyyy-MM-dd hh:mm:dd' />&nbsp;</td>
				</tr>
			</table>	
			</fieldset>
			</c:if>
			<c:if test="${supInfo.backOperatorName ne null}">
			<fieldset >
		<legend class="ctitle" style="width:auto;font:·16px">督查督办过程信息</legend>
			<table border="0" cellpadding="1" cellspacing="1" class="viewTable">
				<tr>
				<td class="addTd" width="20%">经办人意见</td>
					<td align="left">${supInfo.superviseBack}&nbsp;</td>
					<td class="addTd" width="20%">经办人</td>
					<td align="left">${cp:MAPVALUE("usercode",supInfo.backOperatorName)}&nbsp;</td>
					
				</tr>
				<tr>
					<td class="addTd" width="20%">反馈时间</td>
					<td align="left" colspan="3"><fmt:formatDate value="${supInfo.receiptDate}" pattern="yyyy-MM-dd hh:mm:dd"/> &nbsp;</td>
					<%-- <td class="addTd" width="20%">督办反馈</td>
					<td align="left">${cp:MAPVALUE("usercode",supInfo.superviseOption)}</td> --%>
				</tr>
			</table>	
			</fieldset>
			</c:if>
			<c:if test="${supInfo.endOperatorId ne null}">
			<fieldset >
			<legend class="ctitle" style="width:auto;font:·16px">督查督办结果信息</legend>
			<table border="0" cellpadding="1" cellspacing="1" class="viewTable">
				<tr>
					<td class="addTd" width="20%">督办人员</td>
					<td align="left">${cp:MAPVALUE("usercode",supInfo.endOperatorId)}&nbsp;</td>
					<td class="addTd" width="20%">是否有客观原因</td>
					<td align="left"><c:if test="${supInfo.isExternal eq 1}">有客观原因</c:if><c:if test="${supInfo.isExternal eq 0}">没有客观原因</c:if></td> 
					
				</tr>
				<tr>
					<td class="addTd" width="20%">督办结论</td>
					<td align="left">${supInfo.superviseResult}&nbsp;</td>
					<td class="addTd" width="20%">办结时间</td>
					<td align="left"><fmt:formatDate value="${supInfo.endDate}" pattern="yyyy-MM-dd hh:mm:dd"/> &nbsp;</td>
				</tr>
			</table>	
			</fieldset>
			</c:if><table border="0" cellpadding="1" cellspacing="1" class="viewTable">
				<tr><td align="center">
			<input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" />
			</td></tr>
	</body>
	<script type="text/javascript">
	function save(){
		var superviseOption=document.getElementById("superviseOption").value;
		if(""==superviseOption){
			alert("督办意见不能为空");
			document.forms[0].superviseOption.focus();
			return;
		}
		  var form=document.getElementById("supInfoBasicDlfxForm");
		     form.action="supInfoBasicDlfx!saveSupervise.do";     
		     form.submit();
	}
</script>
</html>
