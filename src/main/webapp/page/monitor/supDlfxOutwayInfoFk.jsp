<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title>部门督办发起</title>
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
			<fieldset style="padding:10px">
		
		<legend class="ctitle" style="width:auto;font:·16px">督查督办基本信息</legend>
			<table border="0" cellpadding="1" cellspacing="1" class="viewTable">
				<tr>
					<td class="addTd" width="20%">督办流水号</td>
					<td align="left">${supInfo.superviseCode}</td>
					<td class="addTd" width="20%">被督办部门</td>
					<td align="left">${cp:MAPVALUE("depno",supInfo.orgId)}</td>
				</tr>
				<tr>
					<td class="addTd" width="20%">督办意见</td>
					<td align="left">${supInfo.superviseOption}</td>
					<td class="addTd" width="20%">督办发起人</td>
					<td align="left">${cp:MAPVALUE("usercode",supInfo.operatorId)}</td>
					
				</tr>
				<tr>
					<td class="addTd" width="20%">督办时间</td>
					<td align="left"><fmt:formatDate value='${supInfo.superDate}' pattern='yyyy-MM-dd hh:mm:dd' /></td>
				</tr>
			</table>	
			</fieldset>
			<fieldset >
			<legend class="ctitle" style="width:auto;">督办反馈信息</legend>
		 <s:form  action="supInfoBasicDlfx" namespace="/supervise" style="margin-top:0;margin-bottom:5" id="supInfoBasicDlfxForm" method="post">
			<input type="hidden" name="superviseCode" value="${supInfo.superviseCode}"/>
			<s:textfield name="supervisionYear" value="%{supInfo.supervisionYear}" type="hidden"/>
			<s:textfield name="no" value="%{supInfo.no}" type="hidden"/>
			<s:textfield name="supervisionMonth" value="%{supInfo.supervisionMonth}" type="hidden"/>
			<s:textfield name="orgId" value="%{object.orgId}" type="hidden"/>
			<table cellpadding="0" cellspacing="0" class="viewTable">
				<tr height="22">
					<td class="addTd">*督办反馈:</td>
					<td><s:textarea name="superviseBack" id="superviseBack"/></td>
				</tr>
				<tr height="22">
					<td align="center" colspan="2"><input type="button" class="btn" value="督办反馈" onclick="save();"/>
				<input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" /></td>
				</tr>
			</table>
		</s:form> 
			</fieldset>
	</body>
	<script type="text/javascript">
	function save(){
		var superviseBack=document.getElementById("superviseBack").value;
		if(""==superviseBack){
			alert("反馈意见不能为空");
			document.forms[0].superviseBack.focus();
			return;
		}
		  var form=document.getElementById("supInfoBasicDlfxForm");
		     form.action="supInfoBasicDlfx!saveSuperviseFk.do"; 
		     form.submit();
	}
</script>
</html>
