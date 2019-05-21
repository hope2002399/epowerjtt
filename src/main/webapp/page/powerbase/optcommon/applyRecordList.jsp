<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 

<html>
<head>
		<title>备案办件列表</title>
		<script type="text/javascript">
		  function resetForm(){
			  $('#orgName').val('');
			  $('#s_ownerDepID').val('');
			  $('#s_internalNo').val('');
			  $('#s_applicant').val('');
			  $('#s_begTime').val('');
			  $('#s_itemName').val('');
			  $('#s_endTime').val('');
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
			<s:form action="applyRecord" namespace="/powerbase" style="margin-top:0;margin-bottom:5" method="post">
			<table >
				<tr>
					<td class="addTd">办件编号：</td>
					<td> 
						<s:textfield name="s_internalNo" id="s_internalNo" style="width:180px" value="%{#parameters['s_internalNo']}"/>
					</td>
					<td class="addTd">当事人：</td>
					<td> 
						<s:textfield name="s_applicant" id="s_applicant" style="width:180px" value="%{#parameters['s_applicant']}"/>
					</td>
					
				</tr>
				<tr>
					<td class="addTd">部门名称：</td>
					<td> <%-- <s:select   style="width:300px"/> --%>
						<input type="text" id="orgName" name="orgName"  value="${cp:MAPVALUE('depno',param.s_orgId)}" style="width: 180px"/>
						<input type="hidden" id="s_orgId" name="s_orgId" value="${param.s_orgId}"/>
					</td>
					<td class="addTd">权力名称：</td>
						<%-- <s:select  style="width:300px"/> --%>	
					<td >
						<s:textfield name="s_itemName" id="s_itemName" style="width:180px" value="%{#parameters['s_itemName']}"/>
					</td>
					
				</tr>
				<tr>
					<td class="addTd">时间范围：</td>
					<td colspan="2">
							<sj:datepicker name="s_begTime" id="s_begTime" readonly="true" value="%{#parameters['s_begTime']}" yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" style="width: 180px"/>
							&nbsp;至 &nbsp;
							<sj:datepicker name="s_endTime" id="s_endTime" readonly="true" value="%{#parameters['s_endTime']}" yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" style="width: 180px"/>
					</td>
					<td>&nbsp;&nbsp;
						<s:submit method="getList"  key="opt.btn.query" cssClass="btn"/>
						<input type="button" value="重置" Class="btn" onclick="resetForm()"/>	
					</td>
				</tr>
				<tr>
					
				</tr>
			</table>
			</s:form>
		</div>

		<ec:table action="powerbase/applyRecord!getList.do" items="recordlist" var="record"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit" >
			<ec:row>
				<%-- <ec:column  title=" " style="text-align:center">
	       			<input type="radio" name="ids"  values="">
	      	 	</ec:column>  --%>
	      	 	
	      	 	
				<ec:column property="internalNo" title="办件编号" style="text-align:center">
				<a href='${pageContext.request.contextPath}/monitor/apply!view.do?internalNo=${record.internalNo}&itemId=${record.itemId}&no=${record.no }'>${record.internalNo}</a>
				</ec:column>
				
				<ec:column property="orgId" title="主办部门" style="text-align:center">
					${cp:MAPVALUE("depno",record.orgId)}
				</ec:column>
				
				
				
				<ec:column property="transactAffairName" title="办件名称" style="text-align:center">
				</ec:column>
				
				<ec:column property="applyDate" title="登记时间" style="text-align:center">
				<fmt:formatDate value="${record.applyDate}" pattern="yyyy-MM-dd"/>
				</ec:column>
				<ec:column property="opt" title="操作" sortable="false" style="text-align:center">
	      	 		<a href='powerbase/applyRecord!form.do?no=${record.no}'>备案</a>
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
