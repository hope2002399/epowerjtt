<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title>
			<s:text name="wfTaskMove.list.title" />
		</title>
		<script src="${pageContext.request.contextPath}/scripts/suggest.js" type="text/javascript"></script>
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset>
			<legend>
				 <s:text name="label.list.filter" />
			</legend>
			
			<s:form action="flowUserTask" namespace="/sampleflow" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr >
						<td><s:text name="wfTaskMove.olduser" />:</td>
						<td>
							<div class="userDiv" style="z-index:1000000000;">
								<input type="text" name="userName" size="40" value=""/>
								<input type="hidden" id="olduser" name="s_olduser" />
								<ul id="list" class="ulList"></ul>
							</div>
							<script type="text/javascript">
							$(function(){
								initValue($("input[name=userName]"),$("#list"),"${pageContext.request.contextPath}/sys/userDef!getUsers.do",$("#olduser"));
							})
							</script>
						</td>
					</tr>	
					<tr >
						<td><s:text name="wfTaskMove.newuser" />:</td>
						<td>						
						<div class="userDiv">
						<input type="text" name="userName1" size="40" value=""/>
						<input type="hidden" id="newuser" name="s_newuser" />
						<ul id="list1" class="ulList"></ul>
					</div>
						<script type="text/javascript">
						$(function(){
							initValue($("input[name=userName1]"),$("#list1"),"${pageContext.request.contextPath}/sys/userDef!getUsers.do",$("#newuser"));
						})
						</script>
						</td>
					</tr>	
					<tr>
						<td>
							<s:submit method="listTaskMove"  key="opt.btn.query" cssClass="btn"/>
							&nbsp;&nbsp;
							<input type="button" name= "create" class="btn" onclick ="javascript:window.location.href='${pageContext.request.contextPath}/page/sampleflow/wfTaskMoveForm.jsp'" value="创建">
						</td>
					</tr>
				</table>
			</s:form>
		</fieldset>

		<ec:table action="sampleflow/flowUserTask!listTaskMove.do" items="moveTaskList" var="wfTaskMove"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>

				<c:set var="tolduser"><s:text name='wfTaskMove.olduser' /></c:set>	
				<ec:column property="olduser" title="${tolduser}" style="text-align:center" >
					${cp:MAPVALUE("usercode",wfTaskMove.olduser)}
				</ec:column>

				<c:set var="tnewuser"><s:text name='wfTaskMove.newuser' /></c:set>	
				<ec:column property="newuser" title="${tnewuser}" style="text-align:center" >
					${cp:MAPVALUE("usercode",wfTaskMove.newuser)}
				</ec:column>

				<c:set var="tdesc"><s:text name='wfTaskMove.desc' /></c:set>	
				<ec:column property="moveDesc" title="${tdesc}" style="text-align:center" />

				<c:set var="toperuser"><s:text name='wfTaskMove.operuser' /></c:set>	
				<ec:column property="operuser" title="${toperuser}" style="text-align:center" >
				${cp:MAPVALUE("usercode",wfTaskMove.operuser)}
				</ec:column>

				<c:set var="toperdate"><s:text name='wfTaskMove.operdate' /></c:set>	
				<ec:column property="operdate" title="${toperdate}" style="text-align:center" >
				<fmt:formatDate value="${wfTaskMove.operdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</ec:column>
			
				<%--
				<c:set var="optlabel"><s:text name="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><s:text name="label.delete.confirm"/></c:set>
					<a href='sampleflow/wfTaskMove!view.do?moveno=${wfTaskMove.moveno}&ec_p=${ec_p}&ec_crd=${ec_crd}'><s:text name="opt.btn.view" /></a>
					<a href='sampleflow/wfTaskMove!edit.do?moveno=${wfTaskMove.moveno}'><s:text name="opt.btn.edit" /></a>
					<a href='sampleflow/wfTaskMove!delete.do?moveno=${wfTaskMove.moveno}' 
							onclick='return confirm("${deletecofirm}wfTaskMove?");'><s:text name="opt.btn.delete" /></a>
				</ec:column>
				--%>
			</ec:row>
		</ec:table>

	</body>
</html>
