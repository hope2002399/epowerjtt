<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%> 
<html>
	<head>
		<title>
			复议办理
		</title>
		<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
		<sj:head locale="zh_CN" />
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<div class="search">
			<div class="crumbs">
				 查询条件
			</div>
			
			<s:form action="VUserTaskListReconsider" namespace="/supervise" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">
					<tr >						
					<td class="addTd">复议编号：</td><td><s:textfield name="s_reconsiderid" value="%{#parameters['s_reconsiderid']}"/> </td>
					<td class="addTd">申请复议单位：</td><td><s:textfield name="s_reconsiderApply" value="%{#parameters['s_reconsiderapply']}"/> </td>
				</tr><tr>
				<td class="addTd">办件编号：</td><td><s:textfield name="s_internalNo" value="%{#parameters['s_internalNo']}"/> </td>
			 <td class="addTd">复议办理单位：</td><td><input type="text" id="orgName" name="orgName"  value="${cp:MAPVALUE('depno',param.s_reconsiderDep)}"/>
					<input type="hidden" id="s_reconsiderDep" name="s_reconsiderDep" value="${param.s_reconsiderDep}"/>
					</td>
					<td>&nbsp;&nbsp;
							<s:submit method="list"  key="opt.btn.query" cssClass="btn"/>
						</td>	
					</tr>
				</table>
			</s:form>
		</div>

		<ec:table action="supervise/VUserTaskListReconsider!list.do" items="objList" var="VUserTaskListReconsider"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="reconsiderid" title="复议编号"	style="text-align:center" sortable="true"/>
                <ec:column property="reconsiderapply" title="申请复议单位"	style="text-align:center" sortable="true">
               ${cp:MAPVALUE("depno",VUserTaskListReconsider.reconsiderapply)}
                </ec:column>
                 <ec:column property="internalNo" title="办件编号"	style="text-align:center" sortable="true"/>
                <ec:column property="reconsiderdep" title="复议办理单位"	style="text-align:center" sortable="true">
                  ${cp:MAPVALUE("unitCode",VUserTaskListReconsider.reconsiderdep)}
                </ec:column>
                <ec:column property="nodeCreateTime" title="更新时间"
						style="text-align:center" format="yyyy-MM-dd HH:mm:ss" cell="date" />
                <ec:column property="nodeName" title="状态"	style="text-align:center" sortable="true"/>
				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">
					<a href="<%=request.getContextPath() %>${VUserTaskListReconsider.nodeOptUrl}">办理</a>
					<a href='<%=request.getContextPath()%>/sampleflow/sampleFlowManager!viewxml.do?flowInstId=${VUserTaskListReconsider.flowInstId}'>查看流程图</a>
				</ec:column>
				
				</ec:row>
		</ec:table>

	</body>
	<script type="text/javascript">
	var menuList = ${unitsJson};
	function bindEvent(o1,o2,$this){
		o1.val($this.html());
		var key = $this.attr("rel");
		for (var i=0; i<menuList.length; i++) {
			if (key == menuList[i].MID) {
				o2.val(menuList[i].depno);
			}
		}
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
	bindEvent($("#orgName"),$("#s_reconsiderDep"),$this);
	$("#lists span").die("click");
});
});
	</script>
</html>
