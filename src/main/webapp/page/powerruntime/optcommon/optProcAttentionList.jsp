<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html>
	<head>
		<title>
			<s:text name="optProcAttention.list.title" />
		</title>
		<script type="text/javascript">
		  function resetForm(){
			  $('#s_attsettime').val('');
			  $('#userCode').val('');
			  document.forms[0].s_isAtt.checked=false;
		  }
		</script>
		<script type="text/javascript" src="<s:url value="/scripts/opendiv_Win.js"/>" charset="utf-8"></script>
		<sj:head locale="zh_CN" />
   		<script type="text/javascript" src="<s:url value="/scripts/colorbox/jquery.colorbox.js"/>" charset="utf-8"></script>
        <link href="${pageContext.request.contextPath}/scripts/colorbox/colorbox.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/scripts/jquery-ui/jquery-ui-1.9.2.custom.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="<s:url value="/scripts/addressBook.js"/>" charset="utf-8"></script>
         <link href="<s:url value="/scripts/autocomplete/autocomplete.css"/>" type="text/css" rel="stylesheet">
    <script language="javascript" src="<s:url value="/scripts/autocomplete/autocomplete.js"/>" type="text/javascript"></script>
         <script language="javascript" src="<s:url value="/scripts/selectUser.js"/>" type="text/javascript"></script>
		<script type="text/javascript" src="<s:url value="/scripts/centit.js"/>" charset="utf-8"></script>
		<script type="text/javascript" src="<s:url value="/scripts/jquery-ui/jquery-ui-1.9.2.custom.js"/>" charset="utf-8"></script>
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<div class="search">
			<div class="crumbs">
				 办件跟踪
			</div>
			
			<s:form action="optProcAttention!listAtt.do" namespace="/powerruntime" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">
					<tr >
						<td class="addTd">关注设置时间:</td>
						<td><sj:datepicker name="s_attsettime" id="s_attsettime"  value="%{#parameters['s_attsettime']}" yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" /> </td>
						<td class="addTd">关注设置人员:</td>
						<td><s:textfield name="s_attsetuser" onclick="selectUser(this)" id="userCode"/> </td>
						<td class="addTd" align="right" style="text-align: right">已关注:</td>
						<td width="50"><s:checkbox name="s_isAtt" id="s_isAtt" value="T" cssClass="checkbox" /> </td>
						<td>
							<s:submit method="listAtt"  key="opt.btn.query" cssClass="btn"/>
							<input type="button" name="reset" value="重置" class="btn" onclick="resetForm();"/>
						</td>
					</tr>
					<tr>
						
						
					</tr>
				</table>
			</s:form>
		</div>

		<ec:table action="powerruntime/optProcAttention!listAtt.do" items="attentionList" var="optProcAttention"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="transaffairname" title="办件名称" style="text-align:center" >
				${optProcAttention.transaffairname}
				</ec:column>
				<ec:column property="userCode" title="审阅人" style="text-align:center" >
				${cp:MAPVALUE("usercode",optProcAttention.userCode)}
				</ec:column>
				<ec:column property="attSetTime" title="关注设置时间" style="text-align:center" />

				<ec:column property="attSetUser" title="关注设置人员" style="text-align:center" >
				${cp:MAPVALUE("usercode",optProcAttention.attSetUser)}
				</ec:column>
				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><s:text name="label.delete.confirm"/></c:set><!--
					<a href='powerruntime/optProcAttention!view.do?djId=${optProcAttention.djId}&usercode=${optProcAttention.userCode}&ec_p=${ec_p}&ec_crd=${ec_crd}'><s:text name="opt.btn.view" /></a>
					-->
					<c:if test="${optProcAttention.isAtt ne '1'}">
					<a href='powerruntime/optProcAttention!edit.do?cid.djId=${optProcAttention.djId}&cid.userCode=${optProcAttention.userCode}'>关注</a>
					</c:if>
					&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/powerruntime/optApply!generalOptView.do?djId=${optProcAttention.djId}">办件查看</a>
					<!--<a href='powerruntime/optProcAttention!delete.do?djId=${optProcAttention.djId}&usercode=${optProcAttention.userCode}' 
							onclick='return confirm("${deletecofirm}optProcAttention?");'><s:text name="opt.btn.delete" /></a>-->
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
	<script type="text/javascript">
      var list = [];
      var i;
      <c:forEach var="userinfo" varStatus="status" items="${userlist}">
          list[${status.index}] = { username:'<c:out value="${userinfo.username}"/>', loginname:'<c:out value="${userinfo.loginname}"/>', usercode:'<c:out value="${userinfo.loginname}"/>',pinyin:'<c:out value="${userinfo.usernamepinyin}"/>'  };
      </c:forEach>
      function selectUser(obj) {
             userInfo.choose(obj, {dataList:list,userName:$('#userName')});
      }
		

	</script>
</html>
