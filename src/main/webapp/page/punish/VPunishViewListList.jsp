<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title>		
		</title>
		<script type="text/javascript">
		function doAdd(){
			var href="punish/punishobjectbasic!edit.do?optId=PUNISH";
			window.location.href=href;			
		}
		
		</script>
		<sj:head locale="zh_CN" />
		<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
		
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset
			style="border: hidden 1px #000000; ">
			<legend>
				查询条件
			</legend>
			
			<s:form action="VPunishViewList" namespace="/punish" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr >
						<td>案件流水号:</td>
						<td><s:textfield name="s_punishobjectid" value="%{#parameters['s_punishobjectid']}"/> </td>
					
						<td>案件状态:</td>
						<td><s:textfield name="s_nodeName" value="%{#parameters['s_nodeName']}"/> </td>
					</tr>	
					<tr >
						<td>案件编号:</td>
						<td><s:textfield name="s_punishobjectno" value="%{#parameters['s_punishobjectno']}"/> </td>
					
						<td>案件性质:</td>
						<td>
						<s:radio value="#parameters['s_punishobjecttype']"  listKey="key" listValue="value" id="s_punishobjecttype" name="s_punishobjecttype"	 list="#{'0':'一般流程','1':'简易流程'}" />
						 </td>
					</tr>	
					<tr >
						<td>案件登记部门:</td>
						<td colspan="3">
						<input type="text" id="orgName" name="orgName" style="width:20%;height:25px;" value="${cp:MAPVALUE('unitcode',param.s_managedepid)}"/>
				<input type="hidden" id="s_managedepid" name="s_managedepid" value="${param.s_managedepid}"/>						
					<s:checkbox label="包含下属机构" name="s_queryUnderUnit" value="#parameters['s_queryUnderUnit']" fieldValue="true" />包含下属机构 </td>
					
						</td>
					</tr>		

					<tr>
						<td>
							<s:submit method="list"  key="opt.btn.query" cssClass="btn"/>						
							<input type="button" class="btn" onclick="doAdd();"  value="处罚登记" />						
						</td>
					</tr>
				</table>
			</s:form>
		</fieldset>

		<ec:table action="punish/VPunishViewList!list.do" items="objList" var="VPunishViewList"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>

				<ec:column property="punishobjectid" title="案件流水号" style="text-align:center" />				
				<ec:column property="punishobjectno" title="案件编号" style="text-align:center" />
				<ec:column property="punishobjecttype" title="案件性质" style="text-align:center">
				<c:if test="${VPunishViewList.punishobjecttype=='0' }">一般流程</c:if>
				<c:if test="${VPunishViewList.punishobjecttype=='1' }">简易流程</c:if>
				</ec:column>
				<ec:column property="managedepid" title="案件登记部门" style="text-align:center" >
				${cp:MAPVALUE("unitcode",VPunishViewList.managedepid)}
				</ec:column>
				<ec:column property="poregistedate" title="登记日期" style="text-align:center" >
				<s:date name="poregistedate" format="yyyy-MM-dd HH:mm:ss"/>
					</ec:column>
				<ec:column property="nodeName" title="案件状态" style="text-align:center" />
				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">
						<c:set var="deletecofirm">
						<bean:message key="label.delete.confirm" />
					</c:set>
					<a
						href='punish/punishobjectbasic!viewItem.do?punishobjectid=${VPunishViewList.punishobjectid}&nodeInstId=0'>查看</a>
					<c:if test="${VPunishViewList.biztype  eq 'F' }">
						<a
							href='punish/punishobjectbasic!editold.do?punishobjectid=${VPunishViewList.punishobjectid}'>编辑</a>
						<a href='#'	onclick="confirm_check('${VPunishViewList.punishobjectid}');">删除</a>

					</c:if></ec:column>

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
			menuDisplay(menuList,'${parentunit}');	
		},0);
	};
	$("#lists span").live('click',function(){
		var $this = $(this);
		bindEvent($("#orgName"),$("#s_managedepid"),$this);
		$("#lists span").die("click");
	});
});


</script>
</html>
