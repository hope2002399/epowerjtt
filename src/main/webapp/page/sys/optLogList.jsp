<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>系统日志</title>
	<sj:head locale="zh_CN" />
    <link href="<s:url value="/scripts/autocomplete/autocomplete.css"/>" type="text/css" rel="stylesheet">
    <script language="javascript" src="<s:url value="/scripts/autocomplete/autocomplete.js"/>" type="text/javascript"></script>
    <script language="javascript" src="<s:url value="/scripts/selectUser.js"/>" type="text/javascript"></script>

    <script type="text/javascript" >
        var list = [];
        <c:forEach var="userinfo" varStatus="status" items="${cp:ALLUSER('T')}">
            list[${status.index}] = { username:'<c:out value="${userinfo.username}"/>', loginname:'<c:out value="${userinfo.loginname}"/>', usercode:'<c:out value="${userinfo.usercode}"/>',pinyin:'<c:out value="${userinfo.usernamepinyin}"/>'  };
        </c:forEach>
        function selectUser(obj) {
               userInfo.choose(obj, {dataList:list,userName:$('#userName')});
        }
        function checkDate(){
        	var sDate = new Date(document.getElementById("s_begopttime").value.replace(/\-/g, "\/"));
            var eDate = new Date(document.getElementById("s_endopttime").value.replace(/\-/g, "\/"));
            if(sDate > eDate)
            {
             alert("结束时间不能小于开始时间");
             return false;
            }
            return true;
           }

    </script>

</head>

<body>
	<%@ include file="/page/common/messages.jsp"%>

	<div class="search">
		<div class="crumbs">系统日志</div>
		<s:form action="optLog" namespace="/sys" onsubmit="return checkDate(this);" theme="simple">
			<table cellpadding="0" cellspacing="0">
				<tr>
					<td class="addTd">起始时间：</td>
					<td><sj:datepicker name="s_begopttime" readonly="true" value="%{#parameters['s_begopttime']}" yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" /></td>
					<td class="addTd">结束时间：</td>
					<td><sj:datepicker name="s_endopttime" readonly="true" value="%{#parameters['s_endopttime']}" yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" /></td>
				</tr>
				<tr>
					<td class="addTd">操作人员：</td>
					<td><s:textfield onclick="selectUser(this);" id="userCode" name="s_usercode" value="%{#parameters['s_usercode']}" /></td>
					

					<td class="addTd">项目模块：</td>
					<td><select name="s_optid" class="combox" style="width: 160px">
							<option value="">全部</option>
							<c:forEach var="opt" items="${optIds }">
								<option value="${opt }" <c:if test="${opt eq param['s_optid'] }">selected="selected"</c:if>>${cp:MAPVALUE('optid',opt)}</option>
							</c:forEach>
					</select></td></tr><tr>
        
					<td colspan="4" align="center"><s:submit method="list" cssClass="btn" value="查询" /></td>
				</tr>
			</table>

		</s:form>
	</div>

	<ec:table action="sys/optLog!list.do" items="objList" var="optLog" 
		imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
		<%-- <ec:exportXls fileName="optLogs.xls"></ec:exportXls>
		<ec:exportPdf fileName="optLogs.pdf" headerColor="blue" headerBackgroundColor="white"></ec:exportPdf> --%>
		<ec:row>
			<ec:column property="rowCount" cell="rowCount" sortable="false" title="序号" style="text-align:center" />
			<ec:column property="usercode" title="操作人员" style="text-align:center">
				${optLog.usercode }[<c:out value="${cp:MAPVALUE('usercode',optLog.usercode)}"/>]
			</ec:column>

			<ec:column property="opttime" title="操作时间" style="text-align:center">
				<fmt:formatDate value="${optLog.opttime }" pattern="yyyy-MM-dd HH:mm:ss" />
			</ec:column>

			<ec:column property="optid" title="项目模块" style="text-align:center">
				<c:out value="${cp:MAPVALUE('optid',optLog.optid)}"></c:out>
			</ec:column>

			<ec:column property="optcontent" title="操作内容" style="text-align:center">
				<c:choose>
					<c:when test="${fn:length(optLog.optcontent) gt 18 }">${fn:substring(optLog.optcontent, 0, 18) }...</c:when>
					<c:otherwise>${optLog.optcontent }</c:otherwise>
				</c:choose>
			</ec:column>

			<ec:column property="oldvalue" title="更改前原值" style="text-align:center">
				<c:choose>
					<c:when test="${fn:length(optLog.oldvalue) gt 18 }">${fn:substring(optLog.oldvalue, 0, 18) }...</c:when>
					<c:otherwise>${optLog.oldvalue }</c:otherwise>
				</c:choose>
			</ec:column>

			<ec:column property="opt" title="操作" sortable="false" style="text-align:center">
				<a href='sys/optLog!view.do?logid=${optLog.logid}&ec_p=${ec_p}&ec_crd=${ec_crd}'>查看</a>
			</ec:column>

		</ec:row>
	</ec:table>

</body>
</html>
