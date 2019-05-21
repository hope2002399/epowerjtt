<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="com.centit.monitor.po.PunishProcess"%>
<%@ page import="com.centit.monitor.po.PunishDoc"%>
<%@ page import="com.centit.monitor.po.PunishResult"%>
<html>
<head>
<SCRIPT type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/scrolltop.js"></SCRIPT>
<LINK rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/default/css/lrtk.css">
<sj:head locale="zh_CN" />
<title>处罚案件明细</title>
<style type="text/css">
#infoTab {
	position: relative;
	height: 24px;
	line-height: 24px;
	border-bottom: 1px solid #bbb;
}

#infoTab li {
	cursor: pointer;
	position: relative;
	float: left;
	padding: 0 15px;
	border: 1px solid #bbb;
	margin-right: 6px;
	border-bottom: none;
	background: #fff;
}

#infoView {
	border: 1px solid #bbb;
	border-top: none;
	padding: 10px 10px 10px;
}

#infoTab .select {
	top: 1px;
	font-weight: bold;
	cursor: default;
}

#infoTab .current {
	border: 1px solid #ff0000;
	border-bottom: none;
	color: #ff0000;
}

#infoTab .disable {
	cursor: default;
	border: 1px solid #ddd;
	border-bottom: none;
	color: #ddd;
}

#infoView fieldset {
	display: none;
}

.tab {
	position: relative;
	height: 24px;
	line-height: 24px;
	border-bottom: 1px solid #bbb;
}

.tab li {
	cursor: pointer;
	position: relative;
	float: left;
	padding: 0 15px;
	border: 1px solid #bbb;
	margin-right: 6px;
	border-bottom: none;
	background: #fff;
}

.tabView {
	border: 1px solid #bbb;
	border-top: none;
	padding: 0px 10px 10px;
}

.tab .select {
	top: 1px;
	font-weight: bold;
	cursor: default;
}

.tab .current {
	border: 1px solid #ff0000;
	border-bottom: none;
	color: #ff0000;
}

.tab .disable {
	cursor: default;
	border: 1px solid #ddd;
	border-bottom: none;
	color: #ddd;
}

.tabView {
	display: none;
}
</style>
</head>

<body>
	<div id="myDiv" class="tt" style="display: none">

		<A HREF="javascript: window.scrollTo(0, 0); void 0"
			ONMOUSEOVER="window.status = 'top'; return true;"
			ONMOUSEOUT="window.status = ''; return true;"> <img
			align="middle" alt="返回顶部"
			src="${pageContext.request.contextPath}/styles/default/images/lanren_top.jpg"
			border="0" />
		</A>
	</div>
	<div align="right">
		<input type="button" class="btn" value="打印"
			onclick="javascript:doPrint();" /><input type="button" class="btn"
			value="投诉" onclick="doComolant('${punish.no}','2');" />
		<c:if test="${'1' ne punish.isTrack}">
			<input type="button" class="btn" value="跟踪"
				onclick="trackLogSet('${punish.no}','2');" />
		</c:if>
		<input type="button" class="btn" value="返回"
			onclick="javascript:history.go(-1);" />
	</div>

	<p align="center" class="title">
		<c:out value="${punish.content}" />
	</p>

	<div id="tabs">
		<ul id="basicTab" class="tab">
			<li class="select" onclick="setTab(this);" id="basic">基本信息</li>

			<li class="select" onclick="setTab(this);" id="process">过程信息</li>

			<c:if test="${!empty result.finishDate}">
				<li class="select" onclick="setTab(this);" id="result">结果信息</li>
			</c:if>


			<c:if test="${fn:length(outwayList)>0}">
				<li class="select" onclick="setTab(this);" id="outway">案件预报警信息</li>
			</c:if>

			<c:if test="${fn:length(complaintList)>0}">
				<li class="select" onclick="setTab(this);" id="complaint">案件投诉信息</li>
			</c:if>

			<c:if test="${fn:length(superviseList)>0}">
				<li class="select" onclick="setTab(this);" id="supervise">案件督办信息</li>
			</c:if>
		</ul>

		<div id="basic_view" class="tabView">
			<c:if test="${empty punishVersionList }">
				<c:set var="borderCss" value="border:none;"></c:set>

				<c:set var="displayCss" value="display:none;"></c:set>
			</c:if>

			<ul id="infoTab" style="${borderCss} ${displayCss}">
				<c:forEach items="${punishVersionList }" varStatus="i" var="ver">
					<li
						url="${pageContext.request.contextPath}/monitor/punishLog!view.do?internalNo=${punish.internalNo}&orgId=${punish.orgId }&changNo=${ver}">版本${ver}</li>
				</c:forEach>
			</ul>

			<div id="infoView" style="${borderCss}">
				<iframe id="iframe" name="info"
					src="${pageContext.request.contextPath}/monitor/punish!punishView.do?internalNo=${punish.internalNo}&orgId=${punish.orgId }"
					width="100%" style="margin-bottom: 10px;" frameborder="no"
					scrolling="false" border="0" marginwidth="0"
					onload="this.height=window.frames['info'].document.body.scrollHeight"></iframe>
			</div>
		</div>

		<div id="process_view" class="tabView">
			<input class="btn" type="button" name="btnblc" value="流程对比"
				onclick="openFlowChart();" />

			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				class="viewTable">
				<tr class="b_darkblue">
					<td style="text-align: center" title="是否关键环节" width="3%"></td>
					<td style="text-align: center" title="是否包含附件" width="3%"></td>
					<td style="text-align: center" width="3%"></td>
					<td style="text-align: center">环节名称</td>
					<td style="text-align: center">办理科室</td>
					<td style="text-align: center">办理人员姓名</td>
					<td style="text-align: center">办理时间</td>
					<td style="text-align: center">办理意见及内容</td>
					<td style="text-align: center">操作</td>
				</tr>
				<c:forEach items="${processList }" varStatus="i" var="process">

					<tr class="b_gray">
						<td style="text-align: center"><c:if
								test='${ process.isrisk  eq 1}'>
								<img align="middle" alt="关键环节"
									src="${pageContext.request.contextPath}/images/risk.gif" />
							</c:if></td>
						<td style="text-align: center"><c:if
								test='${fn:length(process.attachment)> 500}'>
								<img align="middle" alt="该步骤有附件"
									src="${pageContext.request.contextPath}/images/affix.gif" />
							</c:if></td>
						<td style="text-align: center">${process.noOrd }</td>
						<td style="text-align: center">${process.tacheName}</td>
						<td style="text-align: center">${process.department}</td>
						<td style="text-align: center">${process.userName}</td>
						<td style="text-align: center"><fmt:formatDate
								value='${process.processDate}' pattern='yyyy-MM-dd HH:mm:ss' /></td>
						<td style="text-align: center">${process.note}</td>
						<td style="text-align: center" width="10%"><a
							href="javascript:void(0);"
							onclick="openProcessView('${process.no}');">查看</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<c:if test="${!empty result.finishDate}">
			<div id="result_view" class="tabView">
				<iframe id="resultIframe" name="resultInfo"
					src="${pageContext.request.contextPath}/monitor/punishResult!view.do?internalNo=${punish.internalNo}&orgId=${punish.orgId }"
					width="100%" style="margin-bottom: 10px;" frameborder="no"
					scrolling="false" border="0" marginwidth="0" height="380px;"></iframe>
			</div>
		</c:if>
		<c:if test="${fn:length(outwayList)>0}">
			<div id="outway_view" class="tabView">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					class="viewTable">
					<tr class="b_darkblue">
						<td style="text-align: center"><s:text
								name='outway.monitorStyle' /></td>
						<td style="text-align: center"><s:text
								name='outway.monitorLogo' /></td>
						<td style="text-align: center"><s:text name='outway.intime' /></td>
						<td style="text-align: center"><s:text name='outway.outtime' /></td>
						<td style="text-align: center">操作</td>
					</tr>
					<c:forEach items="${outwayList }" varStatus="i" var="outway">

						<tr class="b_gray">
							<td style="text-align: center"><c:if
									test="${outway.monitorStyle eq 1}">
									<img align="middle" alt="预警"
										src="${pageContext.request.contextPath}/images/yellow.gif" />
								</c:if> <c:if test='${ outway.monitorStyle  eq 2}'>
									<img align="middle" alt="报警"
										src="${pageContext.request.contextPath}/images/red.gif" />
								</c:if> <c:if test='${ outway.monitorStyle eq 3}'>
									<img align="middle" alt="提醒"
										src="${pageContext.request.contextPath}/images/green.gif" />
								</c:if></td>
							<td style="text-align: center">${outway.monitorLogo}</td>
							<td style="text-align: center"><fmt:formatDate
									value='${outway.intime}' pattern='yyyy-MM-dd HH:mm:ss' /></td>
							<td style="text-align: center"><fmt:formatDate
									value='${outway.outtime}' pattern='yyyy-MM-dd HH:mm:ss' /></td>
							<td style="text-align: center"><a
								href='monitor/outway!view.do?outwayno=${outway.outwayno}&ec_p=${ec_p}&ec_crd=${ec_crd}'>查看</a>
							</td>
						</tr>
					</c:forEach>
				</table>

			</div>
		</c:if>

		<c:if test="${fn:length(complaintList)>0}">
			<div id="complaint_view" class="tabView">

				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					class="viewTable">
					<tr class="b_darkblue">
						<td style="text-align: center"><s:text
								name='complaint.complaintman' /></td>
						<td style="text-align: center"><s:text
								name='complaint.complaintreason' /></td>
						<td style="text-align: center"><s:text
								name='complaint.complaintdate' /></td>
						<td style="text-align: center"><s:text
								name='complaint.complaintresult' /></td>
						<td style="text-align: center">操作</td>
					</tr>
					<c:forEach items="${complaintList }" varStatus="i" var="complaint">

						<tr class="b_gray">
							<td style="text-align: center">${complaint.complaintman}</td>
							<td style="text-align: center">${complaint.complaintreason}</td>
							<td style="text-align: center"><fmt:formatDate
									value='${complaint.complaintdate}'
									pattern='yyyy-MM-dd HH:mm:ss' /></td>
							<td style="text-align: center">${cp:MAPVALUE("TSDCJG",complaint.complaintresult)}</td>
							<td style="text-align: center"><a
								href='${pageContext.request.contextPath}/complaint/complaint!view.do?complaintid=${complaint.complaintid}&ec_p=${ec_p}&ec_crd=${ec_crd}'><s:text
										name="opt.btn.view" /></a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</c:if>

		<c:if test="${fn:length(superviseList)>0}">
			<div id="supervise_view" class="tabView">

				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					class="viewTable">
					<tr class="b_darkblue">
						<td style="text-align: center">督办流水号</td>
						<td style="text-align: center">督办类别</td>
						<td style="text-align: center">督办发起时间</td>
						<td style="text-align: center">主办部门</td>

						<td style="text-align: center">操作</td>
					</tr>
					<c:forEach items="${superviseList }" varStatus="i" var="supervise">

						<tr class="b_gray">
							<td style="text-align: center">${supervise.superviseNo}</td>
							<td style="text-align: center">${cp:MAPVALUE("DBTYPE",supervise.bjType)}</td>
							<td style="text-align: center"><fmt:formatDate
									value='${supervise.superviseDate}'
									pattern='yyyy-MM-dd HH:mm:ss' /></td>
							<td style="text-align: center">${cp:MAPVALUE("unitCode",supervise.orgId)}</td>
							<td style="text-align: center"><a
								href='${pageContext.request.contextPath}/supervise/superviseBasic!view.do?superviseNo=${supervise.superviseNo}&flowInstId=${supervise.flowInstId}&ec_p=${ec_p}&ec_crd=${ec_crd}'>查看</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</c:if>
	</div>

	<script type="text/javascript">
		function setTab(tab) {
			var id = $(tab).attr('id');
			$("li").removeClass("select");
			$(tab).addClass("select");
			$("div.tabView").hide();
			$("#"+id+"_view").show();
		}
		
		setTab($('#basic'));
</script>

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
				}
			}
		});
	}
	sNav();
	
	
	
	function trackLogSet(no, flag) {
		var url = "monitor/trackLog!trackLogTrack.do?fromsup=1&no="+no+"&flag="+flag;
		document.location.href = url;
	}
	
	function doComolant(no, flag) {
		var url = "<%=request.getContextPath()%>/complaint/complaint!edit.do?object.bjNo="+no+"&object.bjType="+flag+"&object.optId=complaint";
		document.location.href = url;
	}
	
	function openProcessView(no) {
		openNewWindow("<%=request.getContextPath()%>/monitor/punishProcess!view.do?no="+no);
	}
	function dbfq(userName,userStaffCode){
		var url = "<%=request.getContextPath()%>/supervise/superviseBasic!superviseinitiate.do?bjNo=${punish.no}&bjType=2&object.optId=supervise&fromsup=1&isOrg=F&monitorOperatorId="+userStaffCode+"&monitorOperatorName="+encodeURI(encodeURI(userName));
		document.location.href = url;
	}
	function openFlowChart(){
		var url = "<%=request.getContextPath()%>/monitor/punish!flowchart.do?item_id=${punish.itemId}&internal_no=${punish.internalNo}&org_id=${punish.orgId}";
			window.open(url);
		}
	</script>
</body>
</html>
