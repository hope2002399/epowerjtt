<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html>
	<head>
		<title>	
		</title>
		<script type="text/javascript">
		 function resetForm(){
			 $('#s_complaintId').val('');
			 $('#s_complaintMan').val('');
			 $('#s_grantOrgId').val('');
			 $('#s_internalNo').val('');
			 $('#orgName').val('');
		 }
		
		</script>
<style type="text/css">
		.search td{padding:0px 10px 0px 10px;}
</style>
	<sj:head locale="zh_CN" />
		<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<div class="search">
			<div class="crumbs">
				投诉办理
			</div>
			
			<s:form action="vusertasklistcomplaint" namespace="/complaint" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr >						
					<td>投诉编号:</td><td><input type="text" name="s_complaintid" id="s_complaintid "value="${param.s_complaintid}" ></td>
					<td>投诉人:</td><td><input type="text" name="s_complaintMan" id="s_complaintMan "value="${param.s_complaintMan}" ></td>
				</tr><tr>
				<td>办件编号:</td><td><input type="text" name="s_internalNo" id="s_internalNo "value="${param.s_internalNo}" ></td>
			 <td>主办部门:</td><td>
			 <input type="text" id="orgName" name="orgName"  value="${cp:MAPVALUE('depno',param.s_grantOrgId)}"/>
					<input type="hidden" id="s_grantOrgId" name="s_grantOrgId" value="${param.s_grantOrgId}"/>
						</td></tr><tr>
						<td colspan="4" align="center">
							<s:submit method="list"  key="opt.btn.query" cssClass="btn"/>
							<input type="button" class="btn" name="reset" value="重置" onclick="resetForm();" />
						</td>						
					</tr>
				</table>
			</s:form>
		</div>

		<ec:table action="complaint/vusertasklistcomplaint!list.do" items="objList" var="VUserTaskListComplaint"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
			<ec:column property="complaintId" title="投诉编号"	 style="text-align:center" sortable="true"/>
                <ec:column property="complaintMan" title="投诉人" 	style="text-align:center" sortable="true"/>
                 <ec:column property="internalNo" title="办件编号"	style="text-align:center" sortable="true"/>
                <ec:column property="grantOrgId" title="主办部门"	style="text-align:center" sortable="true">
                ${cp:MAPVALUE("depno",VUserTaskListComplaint.grantOrgId)}
                </ec:column>
                <ec:column property="nodeCreateTime" title="更新时间"
						style="text-align:center" format="yyyy-MM-dd HH:mm:ss" cell="date" />
                <ec:column property="nodeName" title="状态"	style="text-align:center" sortable="true"/>
				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">
					<a href="<%=request.getContextPath() %>${VUserTaskListComplaint.nodeOptUrl}">办理</a>
					<a href='<%=request.getContextPath()%>/sampleflow/sampleFlowManager!viewxml.do?flowInstId=${VUserTaskListComplaint.flowInstId}'>查看流程图</a>
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
	bindEvent($("#orgName"),$("#s_grantOrgId"),$this);
	$("#lists span").die("click");
});
});
</script>
	</html>
