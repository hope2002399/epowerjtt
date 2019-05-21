<%@page import="com.centit.sys.util.SysTypeUtils"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="com.centit.monitor.po.ApplyProcess"%>
<%@ page import="com.centit.monitor.po.ApplyDoc"%>
<%@ page import="com.centit.monitor.po.ApplyResult"%>
<html>

<head>
<sj:head locale="zh_CN" />
<title>办件明细</title>
<SCRIPT type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/scrolltop.js"></SCRIPT>
<LINK rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/default/css/lrtk.css">
<style type="text/css">
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

.tabView fieldset {
	display: none;
}
</style>
<script type="text/javascript">
		function setTab(tab) {
			var id = tab.id;
			var view=new Array("basic","process","docfile","complaint","docInfo","result","Infoform");
			$("li").removeClass("select");
			$(tab).addClass("select");
			for (var i=0;i<view.length;i++) 
			{ 
				$("#"+view[i]+"view").hide();
			} 
			$("#"+id+"view").show();
		}
		///setTab($('#basic'));
		function display() {
			var view=new Array("process","docfile","complaint","docInfo","result","Infoform");
			for (var i=0;i<view.length;i++) 
			{ 
				$("#"+view[i]+"view").hide();
			} 
		}
	</script>
</head>

<body onload="display();">
     <!--startprint-->                                                                                


	<div id="myDiv" class="tt" style="display: none">

		<A HREF="javascript: window.scrollTo(0, 0); void 0"
			ONMOUSEOVER="window.status = 'top'; return true;"
			ONMOUSEOUT="window.status = ''; return true;"> <img
			align="middle" alt="返回顶部"
			src="${pageContext.request.contextPath}/styles/default/images/lanren_top.jpg"
			border="0" />
		</A>
	</div>
	<br />
	<div align="right">
		<input type="button" class="btn" value="打印"
			onclick="javascript:doPrint();" />
		<%
			if (SysTypeUtils.sysType != 1) {
		%>
		<c:if test="${cp:CHECKUSEROPTPOWER('TSDJ', 'edit') }">
			<input type="button" class="btn" value="投诉"
				onclick="doComolant('${apply.no}','1');" />
		</c:if>
		<%
			}
		%>
		<c:if test="${cp:CHECKUSEROPTPOWER('GZSZ', 'trackLogTrack') }">
			<c:if test="${'1' ne apply.isTrack}">
				<input type="button" class="btn" value="跟踪"
					onclick="trackLogSet('${apply.no}','1');" />
			</c:if>
		</c:if>
		<input type="button" class="btn" value="返回"
			onclick="javascript:history.go(-1);" />
	</div>
	<p align="center" class="title">
		<c:out value="${apply.transactAffairName}" />
	</p>
	<c:if test="${fn:length(superviseList)>0}">
		<fieldset>
			<a name="supervise"></a>
			<legend>
				<b>督办信息</b>
			</legend>

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
								value='${supervise.superviseDate}' pattern='yyyy-MM-dd HH:mm:ss' /></td>
						<td style="text-align: center">${cp:MAPVALUE("depno",supervise.orgId)}</td>
						<td style="text-align: center"><a
							href='${pageContext.request.contextPath}/supervise/superviseBasic!view.do?superviseNo=${supervise.superviseNo}&flowInstId=${supervise.flowInstId}&ec_p=${ec_p}&ec_crd=${ec_crd}'>查看</a></td>
					</tr>
				</c:forEach>
			</table>

		</fieldset>
	</c:if>

	<c:if test="${fn:length(outwayList)>0}">
		<fieldset>
			<a name="outway"></a>
			<legend>
				<b>预报警信息</b>
			</legend>

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
							</c:if>
						<td style="text-align: center">${outway.monitorLogo}</td>
						<td style="text-align: center"><fmt:formatDate
								value='${outway.intime}' pattern='yyyy-MM-dd HH:mm:ss' /></td>
						<td style="text-align: center"><fmt:formatDate
								value='${outway.outtime}' pattern='yyyy-MM-dd HH:mm:ss' /></td>
						<td style="text-align: center"><a
							href='monitor/outway!view.do?outwayno=${outway.outwayno}&ec_p=${ec_p}&ec_crd=${ec_crd}'>查看</a>
							<c:if test="${outway.outWayState=='1'}">
								<a href="#"
									onclick="dbfq('${outway.monitorSource}','${outway.outwayno}','${outway.bjType}','${outway.bjNo}')">督办</a>
							</c:if></td>
					</tr>
				</c:forEach>
			</table>
		</fieldset>
	</c:if>

	<br />
	<div id="tabs">
		<ul id="basicTab" class="tab">
			<li class="select" onclick="setTab(this);" id="basic">基本信息</li>
			<li onclick="setTab(this);" id="process">办件过程信息</li>
			<c:if test="${!empty result.status}">
				<li onclick="setTab(this);" id="result">办件结果信息</li>
			</c:if>

			<c:if test="${fn:length(complaintList)>0}">
				<li onclick="setTab(this);" id="complaint">办件投诉信息</li>
			</c:if>
			<c:if
				test="${!empty incomeDoc.acceptNo || !empty dispatchDoc.dispatchDocNo }">
				<li onclick="setTab(this);" id="docInfo">办件收发文信息</li>
			</c:if>
		</ul>

		<div id="basicview" class="tabView">
			<c:if test="${not empty applyVersionList }">
				<ul id="infoTab" class="tab">
					<li class="select"
						url="${pageContext.request.contextPath}/monitor/apply!applyView.do?internalNo=${apply.internalNo}&itemId=${apply.itemId }">基本信息</li>
					<c:forEach items="${applyVersionList }" varStatus="i" var="ver">
						<li
							url="${pageContext.request.contextPath}/monitor/applyLog!view.do?internalNo=${apply.internalNo}&itemId=${apply.itemId }&changNo=${ver}">版本${ver}</li>
					</c:forEach>
				</ul>
				<div id="infoView" class="tabView">
					<iframe id="iframe" name="info"
						src="${pageContext.request.contextPath}/monitor/apply!applyView.do?internalNo=${apply.internalNo}&itemId=${apply.itemId }"
						width="100%" style="margin-bottom: 10px;" frameborder="no"
						scrolling="false" border="0" marginwidth="0"
						onload="this.height=window.frames['info'].document.body.scrollHeight"></iframe>
				</div>
			</c:if>
			<c:if test="${empty applyVersionList }">
				<div id="infoView" class="tabView"
					style="border: none; padding-top: 10px;">
					<iframe id="iframe" name="info"
						src="${pageContext.request.contextPath}/monitor/apply!applyView.do?internalNo=${apply.internalNo}&itemId=${apply.itemId }"
						width="100%" style="margin-bottom: 10px;" frameborder="no"
						scrolling="false" border="0" marginwidth="0"
						onload="this.height=window.frames['info'].document.body.scrollHeight"></iframe>
				</div>
			</c:if>
		</div>



		<div id="docInfoview" class="tabView" style="display: none;">
			<c:if
				test="${!empty incomeDoc.acceptNo || !empty dispatchDoc.dispatchDocNo }">
				<a name="docInfo"></a>
				<ul id="docTab" class="tab">

					<c:if test="${!empty incomeDoc.acceptNo }">
						<li
							url="${pageContext.request.contextPath}/monitor/incomeDoc!view.do?internalNo=${apply.internalNo}&itemId=${apply.itemId }">收文信息</li>
					</c:if>
					<c:if test="${!empty dispatchDoc.dispatchDocNo }">
						<li
							url="${pageContext.request.contextPath}/monitor/dispatchDoc!view.do?internalNo=${apply.internalNo}&itemId=${apply.itemId }">发文信息</li>
					</c:if>

				</ul>
				<div id="docView" class="tabView" style="display: none;">
					<c:choose>
						<c:when test="${!empty incomeDoc.acceptNo }">
							<iframe id="docIframe" name="docInfo"
								src="${pageContext.request.contextPath}/monitor/incomeDoc!view.do?internalNo=${apply.internalNo}&itemId=${apply.itemId }"
								width="100%" style="margin-bottom: 10px;" frameborder="no"
								scrolling="false" border="0" marginwidth="0"
								onload="this.height=window.frames['docInfo'].document.body.scrollHeight"></iframe>
						</c:when>
						<c:otherwise>
							<iframe id="docIframe" name="docInfo"
								src="${pageContext.request.contextPath}/monitor/dispatchDoc!view.do?internalNo=${apply.internalNo}&itemId=${apply.itemId }"
								width="100%" style="margin-bottom: 10px;" frameborder="no"
								scrolling="false" border="0" marginwidth="0"
								onload="this.height=window.frames['docInfo'].document.body.scrollHeight"></iframe>
						</c:otherwise>
					</c:choose>
				</div>
			</c:if>
		</div>
		<div id="processview" class="tabView">
			<input class="btn" type="button" name="btnblc" value="流程对比"
				onclick="openFlowChart();" />
			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				class="viewTable">
				<tr class="b_darkblue">
					<td style="text-align: center" title="是否关键环节" width="3%"></td>
					<td style="text-align: center" title="是否包含附件" width="3%"></td>
					<td style="text-align: center" title="是否预报警" width="3%"></td>
					<td style="text-align: center"></td>
					<td style="text-align: center">环节名称</td>
					<td style="text-align: center">办理科室</td>
					<td style="text-align: center">办理人员</td>
					<td style="text-align: center">办理时间</td>
					<td style="text-align: center">岗位状态</td>
					<td style="text-align: center">办理意见</td>
					<td style="text-align: center">承诺时限</td>
					<td style="text-align: center">操作</td>
				</tr>
				<c:forEach items="${processList}" varStatus="i" var="process">

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
						<td style="text-align: center"><c:if
								test="${outway.monitorStyle eq 1}">
								<img align="middle" alt="预警"
									src="${pageContext.request.contextPath}/images/yellow.gif" />
							</c:if> <c:if test='${process.outway.monitorStyle eq 2}'>
								<img align="middle" alt="报警"
									src="${pageContext.request.contextPath}/images/red.gif" />
							</c:if> <c:if test='${process.outway.monitorStyle eq 0}'>
								<img align="middle" alt="提醒"
									src="${pageContext.request.contextPath}/images/green.gif" />
							</c:if> <br></td>
						<td style="text-align: center">${process.noOrd }</td>
						<td style="text-align: center">${process.tacheName}</td>
						<td style="text-align: center">${process.department}</td>
						<td style="text-align: center">${process.userName}</td>
						<td style="text-align: center"><fmt:formatDate
								value='${process.processDate}' pattern='yyyy-MM-dd HH:mm:ss' /></td>
						<td style="text-align: center">${cp:MAPVALUE("APPLYSTATUS",process.status)}</td>
						<td style="text-align: center">${process.note}</td>
						<td style="text-align: center"><c:if
								test="${process.promiseStartSign ne 1}">
								<font color="blue">
							</c:if> <c:if test="${not('0' eq process.promise)}">${process.promise}${cp:MAPVALUE("Promise_Type",process.promiseType)}</c:if></td>
						<td width="10%" style="text-align: center" width="10%"><a
							href="javascript:void(0);"
							onclick="openProcessView('${process.no}');">查看</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div id="resultview" class="tabView">
			<c:if test="${!empty result.status}">
				<a name="result"></a>
				<ul id="resultInfoTab" class="tab">
					<li class="select"
						url="${pageContext.request.contextPath}/monitor/applyResult!view.do?internalNo=${apply.internalNo}&itemId=${apply.itemId }">结果信息</li>
					<c:forEach items="${applyResultVersionList }" varStatus="i"
						var="ver">
						<li
							url="${pageContext.request.contextPath}/monitor/applyResultLog!view.do?internalNo=${apply.internalNo}&itemId=${apply.itemId }&changNo=${ver}">版本${ver}</li>
					</c:forEach>

				</ul>
				<div id="resultInfoView">
					<iframe id="resultIframe" name="resultInfo"
						src="${pageContext.request.contextPath}/monitor/applyResult!view.do?internalNo=${apply.internalNo}&itemId=${apply.itemId }"
						width="100%" style="margin-bottom: 10px;" frameborder="no"
						scrolling="false" border="0" marginwidth="0"
						onload="this.height=window.frames['resultInfo'].document.body.scrollHeight"></iframe>
				</div>
			</c:if>
		</div>
		<div id="complaintview" class="tabView">
			<c:if test="${fn:length(complaintList)>0}">
				<a name="complaint"></a>
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
			</c:if>
		</div>
	</div>
	<!--endprint-->
	<script type="text/javascript" charset="gbk">
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
	function sResultNav(){
		$("#resultInfoTab li.current").addClass("select");
		$("#resultInfoTab").click(function(e){
			var e = e || window.event;
			var target = e.srcElement || e.target;
			if( target.tagName.toLowerCase()=="li" && $(target).attr("class") != "disable" ){
				if( !$(target).hasClass("select") ){
					$("#resultInfoTab li").removeClass("select");
					$(target).addClass("select");
					$("#resultIframe").attr("src",$(target).attr("url"));
				}
			}
		});
	}
	sResultNav();
	
	function sFormNav(){
		$("#formTab li.current").addClass("select");
		$("#formTab").click(function(e){
			var e = e || window.event;
			var target = e.srcElement || e.target;
			if( target.tagName.toLowerCase()=="li" && $(target).attr("class") != "disable" ){
				if( !$(target).hasClass("select") ){
					$("#formTab li").removeClass("select");
					$(target).addClass("select");
					$("#formIframe").attr("src",$(target).attr("url"));
				}
			}
		});
	}
	sFormNav();
	
	function sDocNav(){
		$("#docTab li.current").addClass("select");
		$("#docTab").click(function(e){
			var e = e || window.event;
			var target = e.srcElement || e.target;
			if( target.tagName.toLowerCase()=="li" && $(target).attr("class") != "disable" ){
				if( !$(target).hasClass("select") ){
					$("#docTab li").removeClass("select");
					$(target).addClass("select");
					$("#docIframe").attr("src",$(target).attr("url"));
				}
			}
		});
	}
	sDocNav();
	function trackLogSet(no, flag) {
		var url = "monitor/trackLog!trackLogTrack.do?no="+no+"&fromsup=1&flag="+flag;
		document.location.href = url;
	}
	
	function doComolant(no, flag) {
		var url = "<%=request.getContextPath()%>/complaint/complaint!edit.do?object.bjNo="+no+"&object.bjType="+flag+"&object.optId=complaint";
		document.location.href = url;
	}
	function openProcessView(no) {
		openNewWindow('<%=request.getContextPath()%>/monitor/applyProcess!view.do?no='+no);
	}

	function dbfq(monitorsource,outwayno,bjtype,bjno){
		var url;
		if (monitorsource=='B'){  //发起层级督办
			url = "<%=request.getContextPath()%>/supervise/superviseBasic!superviseinitiate.do?bjNo="+bjno+"&bjType="+bjtype+"&outwayid="+outwayno+"&object.optId=DCDB_CJJC_LC&fromsup=1&isOrg=T";
		}
		else {
			url = "<%=request.getContextPath()%>/supervise/superviseBasic!superviseinitiate.do?bjNo="+bjno+"&bjType="+bjtype+"&outwayid="+outwayno+"&object.optId=supervise&fromsup=1&isOrg=F";
		}
		document.location.href = url;
	}
	function openFlowChart(){
		var url = "<%=request.getContextPath()%>/monitor/apply!flowchart.do?item_id=${apply.itemId}&internal_no=${apply.internalNo}&org_id=${apply.orgId}";
			window.open(url);
		}
	</script>
</body>
</html>
