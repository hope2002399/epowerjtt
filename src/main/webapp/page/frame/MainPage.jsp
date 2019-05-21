<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<% response.addHeader("P3P", "CP=CAO PSA OUR");%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- <meta http-equiv="X-UA-Compatible" content="IE=7" /> -->
<title><c:out value="${cp:MAPVALUE('SYSPARAM','SysName')}" /></title>

<link href="${pageContext.request.contextPath}/themes/css/core.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/themes/css/core-custom.css" rel="stylesheet" type="text/css" media="screen" />
<link href="${pageContext.request.contextPath}/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/themes/css/smart_wizard/smart_wizard.css" rel="stylesheet" type="text/css" media="screen" />

<!--[if IE]>
<link href="themes/css/ieHack.css" rel="stylesheet" type="text/css" />
<![endif]-->

<script src="${pageContext.request.contextPath}/scripts/jquery-1.7.2.min.js" type="text/javascript"></script>
<%-- <script src="${pageContext.request.contextPath}/scripts/jquery-1.6.min.js" type="text/javascript"></script> --%>
<script src="${pageContext.request.contextPath}/scripts/speedup.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/jquery.validate.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/jquery.cookie.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/jquery.bgiframe.js" type="text/javascript"></script>
<!-- <script src="${pageContext.request.contextPath}/xheditor/xheditor-1.1.9-zh-cn.min.js" type="text/javascript"></script> -->
<script src="${pageContext.request.contextPath}/uploadify/scripts/swfobject.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/uploadify/scripts/jquery.uploadify.v2.1.0.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/coolMenu.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/scripts/centitui/core.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/centitui/util.date.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/centitui/validate.method.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/centitui/regional.zh.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/centitui/barDrag.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/centitui/drag.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/centitui/tree.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/scripts/centitui/ui.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/centitui/theme.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/centitui/switchEnv.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/centitui/alertMsg.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/centitui/contextmenu.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/centitui/navTab.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/centitui/tab.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/centitui/resize.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/centitui/dialog.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/centitui/dialogDrag.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/centitui/cssTable.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/centitui/stable.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/centitui/taskBar.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/centitui/ajax.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/centitui/pagination.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/centitui/database.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/centitui/effects.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/centitui/panel.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/centitui/checkbox.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/centitui/history.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/centitui/combox.js" type="text/javascript"></script>
<!-- 上传文件的js -->
<script src="${pageContext.request.contextPath}/scripts/ajaxfileupload.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/centitUntil.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/highcharts.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/centit.charts.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/scripts/smart_wizard/jquery.smartWizard-2.0.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath}/scripts/jquery.json-2.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/jquery-ui/jquery-ui-1.8.19.custom.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/centitui/datepicker.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/centitui/accordion.js" type="text/javascript"></script>

<script type="text/javascript" src="${contextPath }/scripts/Mztreeview1.0/MzTreeView10.js"></script>
<script src="${pageContext.request.contextPath}/scripts/jquery/jquery.treetable/jquery.treetable.js" type="text/javascript"></script>

<script type="text/javascript">
$(function(){
	CentitUI.init("${pageContext.request.contextPath}/page/frame/centitui.frag.xml", {
		loginUrl:"${pageContext.request.contextPath}/logindialog.jsp", loginTitle:"登录",	// 弹出登录对话框
//		loginUrl:"login.html",	// 跳到登录页面
		statusCode:{ok:200, error:300, timeout:301},
		pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"},
		debug:false,	
		callback:function(){
			initEnv();
			menuDisplay(jQuery.parseJSON('${OA_MENUS}'),'${pageContext.request.contextPath}','${superFunctionId}');
		
			setTimeout(function(){$("#firstPage1").click();},200);
			$("#themeList").theme({themeBase:"${pageContext.request.contextPath}/themes"}); // themeBase 相对于dashboard页面的主题base路径
			
			
			openTab();
		}
	});
});

</script>
</head>

<body scroll="no">


	<div id="layout">
		<div id="header">
			<div class="headerNav">				
				
				<authz:authentication var="username" property="name" />
				
				<%-- <img src="${pageContext.request.contextPath}/themes/default/images/top_01_l.jpg"> --%>
				<img src="${pageContext.request.contextPath}/themes/default/images/top_01_new.png">
				
				<div id="navbox">
					<div class="username"><div class="user">欢迎你,
						<c:if test="${username=='noname'}">匿名用户</c:if>
						<c:if test="${username!='noname'}"><span usercode="${session.SPRING_SECURITY_CONTEXT.authentication.principal.usercode}">${username}</span>
						</c:if></div>
						<%-- <div class="help"><a href="javascript:word(0)" onclick= "navTab.openTab('operate', '${pageContext.request.contextPath}/page/frame/operate.jsp', {title:'操作手册', external:true});" style="color:#ff0">操作手册</a></div> --%>
						<div class="help"><a href="${pageContext.request.contextPath}/upload/江苏省交通厅三级联网操作手册.rar" style="color:#ff0">操作手册</a></div>
						</div>

					<ul class="nav">
						<%-- <li><a id="home-page" class="home" href="<s:url value='/sys/mainFrame!showMain.do'/>">首页</a></li> --%>			
						<c:if test="${username=='noname'}">
							<c:if test="${cp:MAPSTATE('SYSPARAM','CAS') eq 'T'}" >							
								<li><a class="login" href="<s:url value='/sys/mainFrame!logincas.do'/>" target="dialog" width="400" height="200" >登录</a></li>
							</c:if>
							<c:if test="${not (cp:MAPSTATE('SYSPARAM','CAS') eq 'T')}" >
								<li><a class="login" href="<s:url value='/sys/mainFrame!login.do?inDialog=true'/>" target="dialog" width="400" height="200" >登录</a></li>							
							</c:if>	
							<c:if test="${cp:MAPSTATE('SYSPARAM','EnableWebUsr') eq 'T'}" >
				           		<li ><a class="reg" href="<s:url value='/sys/userDef!registerpage.do' />" target="dialog" width="550" height="350">注册</a></li>
				           	</c:if>
						</c:if>
						<c:if test="${not(username=='noname')}" >
							<c:if test="${cp:MAPSTATE('SYSPARAM','CAS') eq 'T'}" >
								<li><a class="logout" href="<s:url value='https://codefanpc:8443/cas/logout'/>" onclick='return confirm("确定注销当前用户？")'>注销</a></li>
							</c:if>
							<c:if test="${not (cp:MAPSTATE('SYSPARAM','CAS') eq 'T')}" >
								<li ><a class="logout" href="<s:url value='/j_spring_security_logout'/>" onclick='return confirm("确定注销当前用户？")'>注销</a></li>
							</c:if>
							<li ><a class="changeps" href="<s:url value='/sys/userDef!modifyPwdPage.do' />" target="dialog" width="550" height="350">更改密码</a></li>
						</c:if>
						<!-- <li><a class="logout" href="#" onclick="doBackHome();">返回主页</a></li> -->
				     </ul>
			     </div>
				<!-- <ul class="themeList" id="themeList">
					<li theme="gray"><div class="selected">蓝色</div></li>
					<li theme="green"><div>绿色</div></li>
					<li theme="red"><div>红色</div></li>
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul> -->
			</div>

			<!-- navMenu -->
			
		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<c:if test="${username=='noname'}" >
					<c:set var="funcs" value="${session.USERDETAIL.userFuncs}" />
				</c:if>
				<c:if test="${not(username=='noname')}" >
					<c:set var="funcs" value="${session.SPRING_SECURITY_CONTEXT.authentication.principal.userFuncs}" />
				</c:if>
			<div class="accordionContent" style="display:none" >
					<ul class="tree treeFolder">
						<c:if test="${not(username=='noname')}" >						
						<li><a id='firstPage1' href='<c:url value='${firstPage}' />' target="navTab" rel='main'>我的首页</a></li>
						</c:if>
					</ul>
				</div>
			<c:set var="topdepno">${cp:MAPVALUE('stat_info','topdepno')}</c:set>
			<div id="sidebar">
				<!-- 左边菜单 --></div>
		</div>
		
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">我的首页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<div class="tabsMoreList" style="display: none;">
					<ul>	
						<li class="selected"><a href="javascript:;">我的主页</a></li>
					</ul>
				</div>
				<div id="firstPage" class="navTab-panel tabsPageContent layoutBox"> 
					<div class="page unitBox" style="overflow:hidden;">
						<div class="pageFormContent" layoutH="10" ></div>
					</div>
				</div>
			</div>
		</div>
		<!-- 拖动条 -->
		<div id="hiddenFrame"></div>
		<div id="splitBar"></div>
		<div id="splitBarProxy"></div>
		<div id="footer"><a href="#" onclick="window.open('http://www.centit.com');">技术支持：江苏南大先腾信息产业股份有限公司 &copy;2017</a></div>
		
	</div>
	<script language="JavaScript" >
function doBackHome(){
	window.location.href ="<%=request.getContextPath()%>/page/frame/index.jsp";
}



</script>
<script>
	function openTab(a,b,c) {
		navTab.openTab(a, b, {external: true, title:c});
	}
	</script>

<c:if test="${not empty url }">
	<script>
	function openTab() {
		navTab.openTab('test', '${contextPath/url}', {external: true, title:"123"});
	}
	</script>
</c:if>

<c:if test="${empty url }">
	<script>
	function openTab() {
	}
	</script>
</c:if>
<c:if test="${isstartpwd=='1' }">
	<script>
	$(tishi());
	
	function tishi(){
		alert("您的密码为初始密码，请您修改密码！");
	}
	</script>
</c:if>
<!-- <script type="text/javascript">
$(function() {
    layout();
    $(window).resize(resizeCallback);
});

function layout() {
    var divheight= $("#firstPage");
    var iframeheight=divheight.height()-2;
    $('#firstPage .page iframe').height(iframeheight);

}

// 延迟，防止窗口大小改变事件重复执行
var resizeHandle = null;
function resizeCallback() {
    clearTimeout(resizeHandle);
    resizeHandle = setTimeout(function() {
        layout();
    }, 10);
}
</script> -->



	</body>
	
</html>
