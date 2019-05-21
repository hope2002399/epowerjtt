<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>

<html>
	<head>
		<title>
			${jspInfo.title}
		</title>
		<SCRIPT type="text/javascript" src="${pageContext.request.contextPath}/scripts/scrolltop.js"></SCRIPT>
		<LINK rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/default/css/lrtk.css">
		<link href="${pageContext.request.contextPath}/themes/css/alertDiv.css"
			rel="stylesheet" type="text/css" />
		<script src="${pageContext.request.contextPath}/scripts/alertDiv.js"
			type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/scripts/arrow.js"
			type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/scripts/kjyj.js"
			type="text/javascript"></script>
		<script type="text/javascript" src="jquery-1.6.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/dtree.js"></script>
		<link href="${pageContext.request.contextPath}/workflow/css/dtree.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/themes/css/arrow.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<s:url value="/scripts/colorbox/jquery.colorbox.js"/>" charset="utf-8"></script>
		<link href="${pageContext.request.contextPath}/scripts/colorbox/colorbox.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/scripts/jquery-ui/jquery-ui-1.9.2.custom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<s:url value="/scripts/addressBook.js"/>" charset="utf-8"></script>
		<script type="text/javascript" src="<s:url value="/scripts/centit.js"/>" charset="utf-8"></script>
		<script type="text/javascript" src="<s:url value="/scripts/jquery-ui/jquery-ui-1.9.2.custom.js"/>" charset="utf-8"></script>
		<script type="text/javascript" src="<s:url value="/scripts/opendiv_Win.js"/>" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/themes/css/arrow.css" rel="stylesheet" type="text/css" />		
	</head>
<body>
	<!-- 返回顶部浮层 -->
	<div id="myDiv" class="tt" style="display: none">
		<A HREF="javascript: window.scrollTo(0, 0); void 0"
			ONMOUSEOVER="window.status = 'top'; return true;"
			ONMOUSEOUT="window.status = ''; return true;"> <img
			align="middle" alt="返回顶部"
			src="${pageContext.request.contextPath}/styles/default/images/lanren_top.jpg"
			border="0" />
		</A>
	</div>
	<!-- 流程操作 -->
<table>
	<tr>
	<td align="right">
		<input type="button" name="backFrame" class="btn" onclick="backEvent();" value="返 回" style="">
		<input type="button" name="backFrame" class="btn" onclick="showFlow('${flowInstId}');" value="查看流程图">
</td>
</tr>
</table>
	<!-- 办件名称、办件标题显示 -->
	<div class="flowTitle" align="right">
		<%-- <span style="padding-right:20px;">本环节已用时间:${worktime}</span> --%>
		<span style="font-size:18pt;color: red;float:center;padding-right:300px;" ><b>${affairTitle }</b>&nbsp;&nbsp;</span><br>
		<span>${nodeName}&nbsp;&nbsp;</span>
		
		<c:if test="${not empty nodePromiseTime}">
			<span>环节总时限：${nodePromiseTime} &nbsp;&nbsp;</span>
		</c:if>
		<c:if test="${not empty nodeTime}">
			<span 
			<c:if test="${nodeTimeLimit<0}">
			style="color: red;"
			</c:if>
			<c:if test="${nodeTimeLimit<=480 and nodeTimeLimit>0}">
			style="color: #ff8c31;"
			</c:if>
		
			>剩余期限：${nodeTime}&nbsp;&nbsp;</span>
		</c:if>
		<c:if test="${not empty flowDefTime}">
			<span>办件总时限：${flowDefTime}&nbsp;&nbsp;</span>
		</c:if>
		<c:if test="${not empty flowTime}">
			<span
			<c:if test="${flowTimeLimit<0}">
			style="color: red;"
			</c:if>
			<c:if test="${flowTimeLimit<=480 and flowTimeLimit>0}">
			style="color: #ff8c31;"
			</c:if>
			
			>办件整体剩余时限：${flowTime}&nbsp;&nbsp;</span>
		</c:if>
		
	</div>
	<div id="alertRole" class="alert" style="position:absolute;top:20px;left:20%;overflow: hidden;width: 300px;height: 100px;">
				<s:form name="nodeForm" method="post" action="ioDocTasksExcute!assignWorkGroup.do" target="transFrame" namespace="/dispatchdoc" style="margin-top:0;margin-bottom:5">
					<s:hidden id="djId" name="djId" value="%{djId}" />
					<s:hidden id="flowInstId" name="flowInstId" value="%{flowInstId}" />
					<s:hidden id="nodeInstId" name="nodeInstId" value="%{nodeInstId}" />
					<h4><span>小组</span><span id="close3" class="close"  onclick="closeAlert('alertRole');" >关闭</span></h4>
					<tr>
						<td class="addTd">办件角色：</td>
						<td>
							<select name="roleCode">   
								<option value="">   
										<c:out value="-- 请选择 --"/>   
								</option>    
								<c:forEach var="row" items="${cp:DICTIONARY('WFTeamRole')}">     
										<option value="${row.key}" <c:if test="${param.roleCode==row.key}">selected="selected"</c:if>><c:out value="${row.value}" /></option>
								</c:forEach> 
							</select>
						</td>
					</tr>
					<br/>
					<tr>
						<td class="addTd">添加人员：</td>
						<td>
							<input size="32" type="text" name="userName" id="userName" >
							<s:hidden name="userCode" id="userCode"  />
						</td>
					</tr>
					<br>
					<tr>
						<td align="center">
							<input type="submit" id="sub" value="确定" class="sub" onclick="javascript:hideDiv('#alertRole')"/>
								&nbsp;&nbsp;<span id="errorInfo" style="color:red"></span>
						</td>
					</tr>
				</s:form>
		</div>
		<!-- 选择人员的模块 -->
		<div id="attAlert" class="alert"
			style="width: 600px; height: 330px; position:absolute;top:20px;left:20%;overflow: hidden;">
			<h4>
				<span>选择人员</span><span id="close2"
					style="float: right; margin-right: 8px;" class="close"
					onclick="closeAlert('attAlert');">关闭</span>
			</h4>
			<div class="fix">
				<div id="leftSide"></div>
				<div id="l-r-arrow">
					<div class="lb"></div>
					<div class="rb"></div>
				</div>
				<div id="rightSide">
					<ul></ul>
				</div>
				<div id="t-b-arrow">
					<!-- <div class="tb"></div>
		            <div class="bb"></div> -->
					<b class="btns"><input id="save" class="btn" type="button"
						value="保存" /><input id="clear" class="btn" type="button"
						value="取消" style="margin-top: 5px;" /></b>
				</div>
			</div>
		</div>
		<!-- 选择机构模块 -->
		<div id="alertOrg" class="alert" style="width: 300px;height: 100px;">
				<s:form name="nodeForm" method="post" action="ioDocTasksExcute!assignFlowOrganize.do" target="transFrame" namespace="/dispatchdoc" style="margin-top:0;margin-bottom:5">
					<s:hidden id="djId" name="djId" value="%{djId}" />
					<s:hidden id="flowInstId" name="flowInstId" value="%{flowInstId}" />
					<s:hidden id="nodeInstId" name="nodeInstId" value="%{nodeInstId}" />
					<h4><span>机构成员</span><span id="close1" class="close"  onclick="closeAlert('alertOrg');" >关闭</span></h4>
						<tr>
						<td class="addTd">办件角色：</td>
						<td>
						<select name="roleCode">   
							<option value="">   
									<c:out value="-- 请选择 --"/>   
							</option>    
							<c:forEach var="row" items="${cp:DICTIONARY('WFTeamRole')}">     
									<option value="${row.key}" <c:if test="${param.roleCode==row.key}">selected="selected"</c:if>><c:out value="${row.value}" /></option>
							</c:forEach> 
						</select>
						</td>
						</tr>
					<tr>
					<br>
					<td class="addTd">添加机构：</td>
					<td>
					<input size="32" type="text" name="orgName" id="orgName" >
					<s:hidden name="orgCode" id="orgCode"  />
					</td>
					</tr>
					<br>
					<tr>
					<td align="center">
					<input type="submit" id="sub" value="确定" class="sub"  onclick="javascript:hideDiv('#alertOrg')" />
						&nbsp;&nbsp;<span id="errorInfo" style="color:red"></span></td></tr>
				</s:form>
		</div>
		<input type="hidden" id="unitsJson" name="unitsJson" value='${unitsJson}'>
			<!-- 动态框架整合区 -->
	<c:forEach var="fInfo" items="${jspInfo.frameList}" >
		<iframe id="${fInfo.frameId}" name="${fInfo.frameId}" src="<c:url value='${fInfo.frameSrc}'/>" width="100%" style="margin-bottom:10px;"
			frameborder="no" scrolling="false" border="0" marginwidth="0" onload="iframeAutoFit(this);"></iframe>
	</c:forEach>
	<br>
	<!-- 流程操作 -->
	<table>
	<tr>
	<td align="center">
			<input type="button" name="subFrame" class="btn" onclick="submitEvent();" value="发 送">
		<span id="saveSpan">
			<input type="button" name="saveFrame" class="btn"  onclick="saveEvent();" value="保 存">
		</span>
		<c:if test="${moduleParam.canDefer eq 'T' }">
				<input type="button" name="subFrame" class="btn" onclick="suspendEvent();" value="暂 缓" />
			</c:if>
			<c:if test="${moduleParam.canRollback eq 'T' }">
				<input type="button" name="subFrame" class="btn" onclick="rollBackEvent();"  value="回 退" />
			</c:if>
			<c:if test="${moduleParam.canClose eq 'T' }">
				<input type="button" name="endFlow" class="btn" onclick="endFlowEvent();" value="办 结" />
			</c:if>
		

	</td>
	</tr>
	</table>
	
<script type="text/javascript">
function showFlow(flowInstId){
	window.open("<%=request.getContextPath()%>/sampleflow/sampleFlowManager!viewxml.do?flowInstId="+flowInstId);
	
	
}
function selectPopWin(json,o1,o2 ){
	new person(json,o1,o2).init();
	setAlertStyle("attAlert");
}
function selectPopWinTemp(json,o1,o2 ){
	new person(json,o1,o2).init();
	setAlertStyle("attAlert");
}

function selRole(css){
	setAlertStyleTemp('alertRole', css);;
}

function selOrg(css){
	setAlertStyleTemp('alertOrg', css);;
}

$("#userName").click(function(){
	var d = '${userjson}';
	$('#attAlert').show();
	if(d.trim().length){
		selectPopWinTemp(jQuery.parseJSON(d),$("#userName"),$("#userCode"));
	};
});

$("#_userName").click(function(){
	var d = '${userjson}';
	$('#attAlert').show();
	if(d.trim().length){
		selectPopWinTemp(jQuery.parseJSON(d),$("#_userName"),$("#_userCode"));
	};
});
$("#orgName").bind('click',function(){
	var menuList = jQuery.parseJSON($("#unitsJson").val());
	var shadow = "<div id='boxContent' style='z-index:1000;'><div class='listShadow' style='left:45%;'><h4>选择机构</h4></div><div id='lists' class='getTree' style='left:45%;top:176px;width:404px;margin-left:-177px;border:1px solid #369;'>Loader</div><div id='close' onclick='dohide()' style='left:45%;'>×</div></div>";
	if(getID("boxContent")){
		//$("#shadow").show();
		$("#boxContent").show();
	}else{
		$("body").append(shadow);
		//$("#shadow").height(document.body.scrollHeight);
		 setTimeout(function(){
			menuDisplay(menuList,"1");	
		},0);
	};
	$("#lists span").live('click',function(){
		var $this = $(this);
		bindEvent($("#orgName"),$("#orgCode"),$this);
		$("#lists span").die("click");
	});
});

function dohide(){
	if(getID("boxContent"))
		$("#boxContent").hide();
		
}

function bindEvent(o1,o2,$this){
	o1.val($this.html());
	o2.val($this.attr("rel"));
		//$("#shadow").hide();
		$("#boxContent").hide();
}
function  hideDiv(o){
	$(o).hide();
}
</script>

<!-- 上面是选择人员的模块 -->

<script type="text/javascript">
function getOptBaseInfoJson(){
	return ${optBaseInfoJson};
}

function getOptCommonBizJson(){
	return ${optCommonBizJson};
}

function getHeight(height){
	$("#transFrame").height(height);
}

/********************框架主控事件****************************/
//事件按钮ID统一使用:流程提交-submitBtn、业务保存-saveBtn、暂缓-suspendBtn、回退-rollBackBtn、办结-endFlowBtn
function submitEvent(){
	if(window.frames['editFrame'] != undefined){
		getFormByFrame('editFrame').submitBtn.click();
	}
	
	getFormByFrame('transFrame').submitBtn.click();
	
}
//保存事件
function saveEvent(){
	getFormByFrame('transFrame').saveBtn.click();
}
//暂缓事件
function suspendEvent(){
	getFormByFrame('transFrame').suspendBtn.click();
}

//回退事件
function rollBackEvent(){
	getFormByFrame('transFrame').rollBackBtn.click();
}
//办件事件
function endFlowEvent(){
	getFormByFrame('transFrame').endFlowBtn.click();
}

//返回事件
function backEvent(){
	getFormByFrame('transFrame').backBtn.click();
}

function getFormByFrame(frameName){
	
	var frmObj = window.frames[frameName];
	var formObj = null;
	var forms = frmObj.document.forms;
	for(var i = 0 ; i <forms.length;i++ ){
		if(!forms[i].disabled){
			formObj = forms[i];
			break;
		}
	}
	return formObj;
}

//部分业务界面不需要保存按钮，可以调用此方法
function hiddSaveBtn(){
	document.getElementById("saveSpan").style.display = 'none';
}
//iframe自适应高度
function iframeAutoFit(iframeObj){ 
    setTimeout(function(){if(!iframeObj) return;iframeObj.height=(iframeObj.Document?iframeObj.Document.body.scrollHeight:iframeObj.contentDocument.body.offsetHeight)+10;},200) 
}



/********************框架主控事件****************************/
</script>
<script type="text/javascript">
	var sh = function(h){
		
		if(document.getElementById("viewStuffsFrame")){
			var t = document.getElementById("viewStuffsFrame");
			t.height = h;
		};
		if(document.getElementById("AllPunishOptInfoFrame")){
			document.getElementById("AllPunishOptInfoFrame").height = h;
		};
	};
	
	/* document.onmousewheel = test;
	function test(e){
		var scrollHeight = document.body.scrollTop;alert(scrollHeight);
		document.getElementById("toolBar").style.top = scrollHeight+"px";
	} */
</script>


</body>
</html>