<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html>
<head>
		<title>案件许可备案登记查看</title>
		<script type="text/javascript">
		  function resetForm(){
			  $('#orgName').val('');
			  $('#s_orgId').val('');
			  $('#s_itemName').val('');
			  $('#s_itemId').val('');
		  }
		</script>
		<sj:head locale="zh_CN" />
		<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
	
</head>
<body>
<%@ include file="/page/common/messages.jsp"%>
		<div class="search">
			<div class="crumbs">
				 <b>查询条件</b>
			</div>
			
			<s:form action="powerRisk" namespace="/powerbase" style="margin-top:0;margin-bottom:5" method="post">
				<table>
				<tr>
					<td width="25%" align="right">权力名称：</td>
					<td width="250"> <s:textfield name="s_itemName" id="s_itemName" style="width:180px" value="%{#parameters['s_itemName']}"/>
					</td>
					<td class="addTd">权力编码：</td>
					<td> <s:textfield name="s_itemId" id="s_itemId" style="width:180px" value="%{#parameters['s_itemId']}"/>
					</td>
					</tr>
					<tr>
					<td align="right">部门名称：</td>
					<td width="250"> 
					<input type="text" id="orgName" name="orgName"  value="${cp:MAPVALUE('depno',param.s_orgId)}" style="width: 180px"/>
					<input type="hidden" id="s_orgId" name="s_orgId" value="${param.s_orgId}"/>
					</td>
				<td colspan="2" align="center">
							<s:submit method="xkList"  key="opt.btn.query" cssClass="btn"/>	
							<input type="button" value="重置" Class="btn" onclick="resetForm()"/>
							<s:submit method="powerRiskAdd"  key="opt.btn.new" cssClass="btn"/>
						</td>
				</tr>
				</table>
			</s:form>
		</div>
		<ec:table action="powerbase/powerRisk!xkList.do" items="list" var="vpowerrisk"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="orgId" title="主办部门" style="text-align:center">
				${cp:MAPVALUE("depno",vpowerrisk.orgId)}
				</ec:column>
				
				<ec:column property="itmeName" title="权力事项名称" style="text-align:center">
				<a href='powerbase/suppowerchglog!listVersion.do?itemId=${vpowerrisk.itemId}&version=${vpowerrisk.version}' >${vpowerrisk.itemName}</a>
			<!--  	${cp:MAPVALUE("suppowerId",powerRisk.itemId)}  -->
				</ec:column>

				<ec:column property="itemType" title="权力类型" style="text-align:center" >
				${cp:MAPVALUE("ITEM_TYPE",vpowerrisk.itemType)}
				</ec:column>
				
				<ec:column property="opt" title="操作" style="text-align:center" sortable="false">
					<a href='powerbase/powerRisk!powerRiskUpdate.do?itemId=${vpowerrisk.itemId}' >修改</a>
					<a href='powerbase/powerRisk!delete.do?itemId=${vpowerrisk.itemId}' onclick='return confirm("是否删除该权力事项?");'>删除</a>
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
			menuDisplay(menuList,"${parentUnit}");	
		},0);
	};
	$("#lists span").live('click',function(){
		var $this = $(this);
		bindEvent($("#orgName"),$("#s_orgId"),$this);
		$("#lists span").die("click");
	});
});
</script>
</html>