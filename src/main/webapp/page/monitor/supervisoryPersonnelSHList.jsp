<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html>
	<head>
		<title>
			监察人员审核
		</title>
		<script type="text/javascript">
		 function resetForm(){
			 $('#s_updateType').val('');
			 $('#s_state').val('');
			 $('#orgName').val('');
		 }
		
		</script>
<style type="text/css">
		.search td{padding:0px 10px 0px 10px;}
</style>
		<sj:head locale="zh_CN" />
		<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<div class="search">
			<div class="crumbs">
				监管人员管理
			</div>
			
			<s:form action="supervisorypersonnel" namespace="/monitor" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">
				<tr>
					<td class="addTd">部门名称:</td>
					<td>
					<input type="text" id="orgName" name="orgName"  value="${cp:MAPVALUE('unitcode',param.s_orgcode)}"/>
					<input type="hidden" id="s_orgcode" name="s_orgcode" value="${param.s_orgcode}"/>
					<s:checkbox label="包含下属机构" name="s_queryUnderUnit" value="#parameters['s_queryUnderUnit']" fieldValue="true" />包含下属机构
					</td>
				
					<td class="addTd">人员状态:</td>
					<td>
							<select name="s_updateType" id="s_updateType" style="width: 180px" >
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('jcry_type')}">
								<option value="${row.key}"
									<c:if test="${parameters.s_updateType[0] eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="addTd">审核状态:</td>
					<td>
							<select name="s_state" id="s_state" style="width: 160px" >
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('STATE')}">
								<option value="${row.key}"
									<c:if test="${parameters.s_state[0] eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
						<td colspan="2" align="center">
							<s:submit method="supervisorypersonnelSHList"  key="opt.btn.query" cssClass="btn"/>
							<input type="button" class="btn" name="reset" value="重置" onclick="resetForm();"/>
						</td>
					</tr>
				</table>
			</s:form>
		</div>

		<ec:table action="supervisorypersonnel!supervisorypersonnelSHList.do" items="supervisorypersonneList" var="supervisorypersonnel" 
		          imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="no" title="编号" style="text-align:center">
						${supervisorypersonnel.no}
				</ec:column>
				<ec:column property="userName" title="姓名" style="text-align:center">
						${supervisorypersonnel.userName}
				</ec:column>
				<ec:column property="deptcode" title="所属部门" style="text-align:center" >
					${cp:MAPVALUE("depno",supervisorypersonnel.deptcode)}
				</ec:column>
				<ec:column property="sex" title="性别" style="text-align:center" >
					${cp:MAPVALUE("sex",supervisorypersonnel.sex)}
				</ec:column>
				<ec:column property="updateType" title="人员状态" style="text-align:center" >
					${cp:MAPVALUE("jcry_type",supervisorypersonnel.updateType)}
				</ec:column>
				<ec:column property="state" title="审核状态" style="text-align:center" >
					${cp:MAPVALUE("STATE",supervisorypersonnel.state)}
				</ec:column>
				<ec:column property="opt" title="操作" style="text-align:center" sortable="false">
					<c:if test="${supervisorypersonnel.state eq '1'}">
					<a href='monitor/supervisorypersonnel!updateState.do?no=${supervisorypersonnel.no}&userId=${supervisorypersonnel.userId}&flag=2' >审核</a>
					</c:if>
					<a href='monitor/supervisorypersonnel!xgEdit.do?no=${supervisorypersonnel.no}&userId=${supervisorypersonnel.userId}&flag=2' >修改</a>
					<a href='monitor/supervisorypersonnel!scDelete.do?no=${supervisorypersonnel.no}&userId=${supervisorypersonnel.userId}&flag=2' onclick='return confirm("确定注销该检查人员?");'>注销</a>
				</ec:column>
			</ec:row>
		</ec:table>
	</body>
	<script type="text/javascript">
		function openNewWindow(winUrl, winName, winProps) {
		if (winProps == '' || winProps == null) {
			winProps = 'height=500px,width=790px,directories=false,location=false,top=100,left=500,menubar=false,Resizable=yes,scrollbars=yes,toolbar=false';
		}
		window.open(winUrl, winName, winProps);
	}
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
				bindEvent($("#orgName"),$("#s_orgcode"),$this);
				$("#lists span").die("click");
			});
		});
	</script>
</html>
