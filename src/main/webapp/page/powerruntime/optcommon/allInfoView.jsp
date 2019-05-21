<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html>
<head>
<title></title>
<style type="text/css">
#infoTab { position:relative; height:24px; line-height:24px; border-bottom:1px solid #bbb; }
#infoTab li { cursor:pointer; position:relative; float:left; padding:0 15px; border:1px solid #bbb; margin-right:6px; border-bottom:none; background:#fff; }
#infoView { border:1px solid #bbb; border-top:none; padding:0px 10px 10px; }
#infoTab .select { top:1px; font-weight:bold; cursor:default; }
#infoTab .current { border:1px solid #ff0000; border-bottom:none; color:#ff0000; }
#infoTab .disable { cursor:default; border:1px solid #ddd; border-bottom:none; color:#ddd; font-weight:bold;}
#infoView fieldset { display:none; }
</style>
</head>

<body>
<s:form   action="punishobjectbasic"  method="post" namespace="/punish"  styleId="punishobjectbasicForm" >
<ul id="infoTab">
<c:forEach var="temp" items="${optNewlyIdeaList}">	
<li url="<%=request.getContextPath()%>${temp.url}"<c:if test="${temp.nodeid==nodeId}">class="current"</c:if> >${temp.nodename}</li>
</c:forEach>
	<li url="<%=request.getContextPath()%>/powerruntime/generalOperator!listIdeaLogs.do?djId=${object.punishobjectid}">办件过程信息</li>
	<li url="<%=request.getContextPath()%>/powerruntime/generalOperator!listStuffs.do?djId=${object.punishobjectid}">已上传材料列表</li>
	<li url="<%=request.getContextPath()%>/sampleflow/sampleFlowManager!viewxml.do?flowInstId=${object.flowInstId}" <c:if test="${object.flowInstId ==9999999}">class="disable"</c:if>>查看流程图</li>
</ul>
<div id="infoView">
	<iframe id="iframe" name="iframe" src="<%=request.getContextPath()%>${curUrl}" width="100%" style="margin-bottom:10px;"
			frameborder="no" scrolling="auto" border="0" marginwidth="0" onload="this.height=window.frames['iframe'].document.body.scrollHeight"></iframe>
</div>
<script type="text/javascript">
	function sNav(){
		$("#infoTab li.current").addClass("select");
		$("#infoTab").click(function(e){
			var e = e || window.event;
			var target = e.srcElement || e.target;
			if( target.tagName.toLowerCase()=="li" && $(target).attr("class") != "disable" ){
				if( !$(target).hasClass("select") ){
					$("#infoTab li").removeClass("select");
					$(target).addClass("select");
					$("#iframe").attr("src",$(target).attr("url"));
					
					setTimeout(function(){
						if($("#iframe")[0].attachEvent){
							$("#iframe")[0].attachEvent("onload",function(){
								$("#iframe")[0].height=window.frames['iframe'].document.body.scrollHeight;
								var h = parseInt($("#iframe")[0].height)+50;
								
								window.parent.sh(h);
							});
						}else{
							$("#iframe")[0].onload=function(){
								$("#iframe")[0].height=window.frames['iframe'].document.body.scrollHeight;
								var h = parseInt($("#iframe")[0].height)+50;
								window.parent.sh(h);
							};
						}
					},0);
				}
			}
		});
	}
	sNav();
</script>
</s:form>
</body>


</html>