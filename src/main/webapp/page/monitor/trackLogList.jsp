<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title>案件或办件列表</title>
		<sj:head locale="zh_CN" />
		<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<s:url value="/scripts/colorbox/jquery.colorbox.js"/>" charset="utf-8"></script>
        <link href="${pageContext.request.contextPath}/scripts/colorbox/colorbox.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="<s:url value="/scripts/addressBook.js"/>" charset="utf-8"></script>
		<script type="text/javascript" src="<s:url value="/scripts/centit.js"/>" charset="utf-8"></script>
	
	<script type="text/javascript">
		var path="${pageContext.request.contextPath}";				
	 $(document).ready(function() {  
		 centit.ajax.initAjax({urlPrefix:path});  
		 }); 
	</script>
	<script type="text/javascript">
	  function resetForm(){
		  $('#s_internalNo').val('');
		  $('#orgName').val('');
		  $('#s_orgcode').val('');
		  $('#s_begTrackTime').val('');
		  $('#s_endTrackTime').val('');
		 
	  }
	
	</script>
	</head>
	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<div class="search">
			<div class="crumbs">
				办件跟踪查看
			</div>
			<s:form action="trackLog" namespace="/monitor" style="margin-top:0;margin-bottom:5" id="trackLogForm" method="post" >
				<input type="hidden" id="flag" name="flag" value="${param.flag}"/>	
				<input type="hidden" id="s_itemtype" name="s_itemtype" value="${param.s_itemtype}"/>	
				<table cellpadding="0" cellspacing="0" align="center">
					<tr>
						<td class="addTd"><c:if test="${flag==1}">办件编号</c:if><c:if test="${flag==2}">案件编号</c:if></td>
						<td><s:textfield name="s_internalNo" id="s_internalNo" value="%{#parameters['s_internalNo']}" /></td>
						<td class="addTd">部门名称</td>
							<td>						
				<input type="text" id="orgName" name="orgName" id="orgName" value="${cp:MAPVALUE('unitcode',param.s_orgcode)}"/>
				<input type="hidden" id="s_orgcode" name="s_orgcode" value="${param.s_orgcode}"/>	
				<s:checkbox label="包含下属机构" name="s_queryUnderUnit" value="#parameters['s_queryUnderUnit']" fieldValue="true" />包含下属机构		
						</td>	
					</tr>
					<tr height="22">
						<td class="addTd">跟踪时间</td>
						<td colspan="3"><sj:datepicker name="s_begTrackTime" id="s_begTrackTime" readonly="true"
								value="%{#parameters['s_begTrackTime']}" yearRange="2000:2020"
								displayFormat="yy-mm-dd" changeYear="true" />&nbsp;&nbsp;至&nbsp;&nbsp;
						<sj:datepicker name="s_endTrackTime" id="s_endTrackTime" readonly="true"
								value="%{#parameters['s_endTrackTime']}" yearRange="2000:2020"
								displayFormat="yy-mm-dd" changeYear="true" /></td> 
					</tr>
					<tr>
					<td colspan="4" align="center">
						<s:submit method="trackLogList" key="opt.btn.query" cssClass="btn" />
						<input type="button" name="reset" value="重置" class="btn" onclick="resetForm();"/>
					</td>
					</tr>
				</table>
			</s:form>
		</div>
		<c:if test="${flag==1}">
			<ec:table action="trackLog!trackLogList.do" items="trackLogList" var="apply"  imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit" >
			<ec:row>
			<ec:column property="apply.no" title='<input type="button" class="btn" value="全选" name="quanxuan" /><input type="button" class="btn" value="批量取消" name="czpw" />' sortable="false"  style="width:170px">		
					<input type="checkbox" id="${apply.no}" class="ecbox"  value="${apply.no}">
			</ec:column>
				 <ec:column property="isRiskBj" title="异常" style="text-align:center">
				<c:if test="${apply.isRiskBj eq 1}"><img align="middle" alt="重要权力" src="${pageContext.request.contextPath}/images/risk_point.gif" /></c:if><c:if
					test='${ apply.isRiskBj  eq 2}'><img align="middle" alt="关键环节" src="${pageContext.request.contextPath}/images/risk.gif" /></c:if>
				<c:if test='${ apply.isRiskBj eq 0}'>&nbsp;</c:if>
					</ec:column> 
					<ec:column property="apply.internalNoBj" title="办件编号" style="text-align:center">
					<a href='monitor/apply!view.do?internalNo=${apply.internalNoBj}&itemId=${apply.itemIdBj}'>${apply.internalNoBj }</a> 
					</ec:column>
				<ec:column property="apply.itemId" title="权力名称" style="width:15%">
					${cp:MAPVALUE("suppowerId",apply.itemIdBj)}
					</ec:column>
					<ec:column property="apply.transactAffairName" title="事项名称" style="text-align:center">
					${apply.transactAffairName}
					</ec:column>
					<ec:column property="apply.orgIdBj" title="主办部门" style="text-align:center">
					${cp:MAPVALUE("depno",apply.orgIdBj)}
					</ec:column>

				<ec:column property="opt" title="操作" style="text-align:center" sortable="false">
				<a href='monitor/trackLog!trackLogCancel.do?no=${apply.no}&flag=${flag}&trackno=${apply.trackno}'>取消</a>
				</ec:column>
			</ec:row>
		</ec:table>
		</c:if>
		<c:if test="${flag==2}">
			<ec:table action="trackLog!trackLogList.do" items="trackLogList" var="punish"  imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
			<ec:column property="punish.no" title='<input type="button" class="btn" value="全选" name="quanxuan" /><input type="button" class="btn" value="批量取消" name="czpw" />' sortable="false"  style="width:170px">		
					<input type="checkbox" id="${punish.no}" class="ecbox"  value="${punish.no}">
			</ec:column>
				<ec:column property="isRiskAj" title="异常" style="text-align:center">
				<c:if test="${punish.isRiskAj eq 1}"><img align="middle" alt="重要权力" src="${pageContext.request.contextPath}/images/risk_point.gif" /></c:if><c:if
					test='${ punish.isRiskAj  eq 2}'><img align="middle" alt="关键环节" src="${pageContext.request.contextPath}/images/risk.gif" /></c:if>
				<c:if test='${ punish.isRiskAj eq 0}'>&nbsp;</c:if>
				</ec:column> 
				
					<ec:column property="internalNoAj" title="案件编号" style="text-align:center">
					<a href='monitor/punish!view.do?internalNo=${punish.internalNoAj}&orgId=${punish.orgIdAj}'>${punish.internalNoAj }</a> 
					</ec:column>
					<ec:column property="orgIdAj" title="主办部门" style="text-align:center">
					${cp:MAPVALUE("depno",punish.orgIdAj)}
					</ec:column>
					<ec:column property="punishTarget" title="当事人" style="text-align:center">
					${punish.punishTarget}
					</ec:column>
					
				<ec:column property="opt" title="操作" style="text-align:center" sortable="false">
				<a href='monitor/trackLog!trackLogCancel.do?no=${punish.no}&flag=${flag}&trackno=${punish.trackno}'>取消</a>
				</ec:column>
			</ec:row>
		</ec:table>
		</c:if>
	</body>
	<script type="text/javascript">
	function checkVersion() {
		 var form=document.getElementById("trackLogForm");
	     form.action="trackLog!trackLogList.do";     
	     form.submit();
	}
	$("[name='quanxuan']").bind('click',function(){
		if($("[name='quanxuan']").attr("target")=="false"){
		$("[name='quanxuan']").attr("target","true");
		$("input[class='ecbox']").attr("checked","true"); 
		}
		else{
			$("[name='quanxuan']").attr("target","false");
			$("input[class='ecbox']").removeAttr("checked");
		}	
	});

	$("[name='czpw']").bind('click',function(){
		var vfstring = "";
		var items = $('[class = "ecbox"]:checkbox:checked');
		
		for (var i = 0; i < items.length; i++) {
		     // 如果i+1等于选项长度则取值后添加空字符串，否则为逗号
		      //alert(items.get(i).value);
		     vfstring = (vfstring + items.get(i).value + ','); 
		    
		}
		if(vfstring!=""){
		if(confirm("是否取消选择的跟踪办件")){
				  location.href="<%=request.getContextPath()%>/monitor/trackLog!trackLogCancels.do?flag=${flag}&bjNos="+vfstring;
		}
		}
		else{
			alert("没有选中的办件");
		}
			
	}); 
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
