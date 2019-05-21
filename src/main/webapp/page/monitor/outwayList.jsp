<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="outway.list.title" /></title>
<script type="text/javascript">
 function resetForm(){
	 $('#s_orgId').val('');
	 $('#s_queryUnderUnit').val('');
	 $('#s_internalNo').val('');
	 $('#s_bjType').val('');
	 $('#s_monitorStyle').val('');
	 $('#s_monitorType').val('');
	 $('#s_begTime').val('');
	 $('#s_endTime').val('');
	 
 }
	function changemonitortype(){
		
		var wlist=${owlist};
		//var wlist="";
		var ops="<option value=''> </option>";
		if($("#s_monitorType").val()!=''){
			for(var i=0; i<wlist.length; i++){
				if($("#s_monitorType").val()==wlist[i].wpTypeNo){
					ops+="<option value=\""+wlist[i].wpNo+"\">"+wlist[i].wpName+"</option>";
					
				}
			}
			$("#s_warningCode").html(ops);
		}
		
	}
 
</script>
<style type="text/css">
		.search td{padding:0px 10px 0px 10px;}
</style>

<sj:head locale="zh_CN" />
<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
	<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
	
	<%-- <script src="${pageContext.request.contextPath}/scripts/jquery_dialog.js" type="text/javascript"></script>
	<link href="${pageContext.request.contextPath}/styles/default/css/jquery_dialog.css" rel="stylesheet" type="text/css" />		 --%>
</head>
<body>
	<%@ include file="/page/common/messages.jsp"%>
	<div class="search">
			<div class="crumbs">
				预警报警
			</div>

		<s:form action="outway" namespace="/monitor"
			style="margin-top:0;margin-bottom:5" id="outwayForm">
			<s:hidden name="s_NP_outWayZC"
				value="%{#parameters['s_NP_outWayZC']}"></s:hidden>
			<s:hidden name="s_NP_outWayQX"
				value="%{#parameters['s_NP_outWayQX']}"></s:hidden>
		<%-- 	<s:hidden name="s_warningCode"
				value="%{#parameters['s_warningCode']}"></s:hidden> --%>
			<table cellpadding="0" cellspacing="0">
				<tr>
					<td width="80px">主办部门：</td><td width="45%">
					<input type="text" id="orgName" name="orgName"  value="${cp:MAPVALUE('depno',param.s_orgId)}"/>
					<input type="hidden" id="s_orgId" name="s_orgId" value="${param.s_orgId}"/>
					 		<s:checkbox class="checkbox" label="包含下属机构" name="s_queryUnderUnit" id="s_queryUnderUnit" value="#parameters['s_queryUnderUnit']" fieldValue="true" />包含下属机构	 
					<%-- <select name="s_orgId" style="width: 180px">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${unitList}">
								<option value="<c:out value='${row.depno}'/>"
									<c:if test="${row.depno==parameters.s_orgId[0]}">selected="selected"</c:if>>
									<c:out value="${row.unitname}" />
								</option>
							</c:forEach>
					</select> --%>
					</td>
					<td width="80px">异常发起源：</td><td><select name="s_monitorSource" id="s_monitorSource" style="width: 160px">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('OutwaySource')}">
								<option value="${row.key}"
									<c:if test="${parameters.s_monitorSource[0] eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td width="80px">办件编号：</td><td><s:textfield
							name="s_internalNo" id="s_internalNo" style="width: 160px" />
					</td>
					<td>
						<s:text name="outway.bjType" />：</td><td><select name="s_bjType" id="s_bjType" style="width: 160px">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('bjType')}">
								<option value="${row.key}"
									<c:if test="${parameters.s_bjType[0] eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>

				<tr>
					<td width="80px">
						<s:text name="outway.monitorStyle" />：</td><td><select name="s_monitorStyle" id="s_monitorStyle" style="width: 160px">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('MONITOR_STYLE')}">
								<option value="${row.key}"
									<c:if test="${parameters.s_monitorStyle[0] eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
						</select>
					</td>
					<td>
						<s:text name="outway.monitorType" />：</td><td><select name="s_monitorType" id="s_monitorType" style="width: 160px" onchange="changemonitortype();">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('MONITOR_TYPE')}">
								<option value="${row.key}"
										<c:if test="${parameters.s_monitorType[0] eq row.key}"> selected = "selected" </c:if>>
										<c:out value="${row.value}" />
								</option>
							</c:forEach>
						</select>
						
						
						
					</td>
				</tr>
				<tr>
					<td width="80px">开始时间：</td><td><sj:datepicker name="s_begTime" readonly="true" id="s_begTime"
							value="%{#parameters['s_begTime']}" yearRange="2010:2030"
							changeYear="true" displayFormat="yy-mm-dd" style="width: 160px"/>
					</td>
					<td>结束时间：</td><td><sj:datepicker
							name="s_endTime" readonly="true" id="s_endTime"
							value="%{#parameters['s_endTime']}" yearRange="2010:2030"
							changeYear="true" displayFormat="yy-mm-dd" style="width: 160px"/>
					</td>
				</tr>
				<tr>
				<td>
				异常信息：
				</td>
				<td>
				<select name="s_warningCode" id="s_warningCode" style="width: 160px">
							
						</select>
				</td>
				<td colspan='2'></td>
				</tr>
				<tr>
				
				
					<td colspan="4" align="center">
						<c:if test="${cp:CHECKUSEROPTPOWER('YJBJ', 'edit') }">
							<c:if test="${parameters.s_NP_outWayZC[0]=='1' }">
								<input type="button" class="btn" value="摘牌" name="doZP" id="doZP" />
							</c:if>
						</c:if>
						<s:submit method="list" key="opt.btn.query" cssClass="btn" />
						<input type="button" name="reset" value="重置" class="btn" onclick="resetForm();"/>
					</td>
				</tr>
			</table>
		</s:form>
	</div>
	<c:set var="cxparam"
		value="s_NP_outWayZC=${s_NP_outWayZC }&s_NP_outWayQX=${s_NP_outWayQX }&s_bjType=${s_bjType }&s_orgId=${s_orgId }&s_internalNo=${s_internalNo }&s_monitorStyle=${s_monitorStyle }&s_monitorType=${s_monitorType }&s_begTime=${s_begTime }&s_endTime=${s_endTime }&s_queryUnderUnit=${s_queryUnderUnit}"></c:set>
	<ec:table action="outway!list.do" items="objList" var="outway"
		imagePath="${contextPath}/themes/css/images/table/*.gif"
		retrieveRowsCallback="limit">
		<ec:row>
		<c:if test="${cp:CHECKUSEROPTPOWER('YJBJ', 'edit') }">
			<c:if test="${parameters.s_NP_outWayZC[0]=='1' }">
				<ec:column property="bj"
					title='<button name="quanxuan" target="false" id="btnXZ">全选</button>'
					style="text-align:center" sortable="false">
					<input type="checkbox" class="delWarn" name="delWarn"
						value="${outway.outwayno }" />
				</ec:column>
			</c:if>
			</c:if>
			
			<ec:column property="monitorStyle" title="&nbsp;" style="text-align:center" sortable="false">
				<c:if test="${outway.monitorStyle eq 1}"><img align="middle" alt="预警" src="${pageContext.request.contextPath}/images/yellow.gif" /></c:if>
				<c:if test='${outway.monitorStyle eq 2}'><img align="middle" alt="报警" src="${pageContext.request.contextPath}/images/red.gif" /></c:if>
				<c:if test='${outway.monitorStyle eq 3}'><img align="middle" alt="提醒" src="${pageContext.request.contextPath}/images/green.gif" /></c:if>
			</ec:column>

			<ec:column property="internalNo" title="办件编号" style="text-align:center">
				<c:choose>
				<c:when test="${outway.bjType eq '1'}">
				<a href="apply!view.do?internalNo=${outway.internalNo}&itemId=${outway.itemId }" target="_self"><c:out value="${outway.internalNo }"></c:out></a>
				</c:when>
				<c:when test="${outway.bjType eq '2'}">
				<a href="punish!view.do?internalNo=${outway.internalNo}&orgId=${outway.orgId}" target="_self"><c:out value="${outway.internalNo }"></c:out></a>
				</c:when>
				<c:when test="${outway.bjType eq '6'}">
				<c:out value="${cp:MAPVALUE('depno',outway.orgId)}"></c:out>
				</c:when>
				<c:when test="${outway.bjType eq '4'}">
				<a href="../supervise/superviseBasic!view.do?superviseNo=${outway.bjNo}" target="_self"><c:out value="${outway.bjNo }"></c:out></a>
				</c:when>
				<c:when test="${outway.bjType eq '7'}">
				<a href="outway!view.do?outwayno=${outway.bjNo}" target="_self"><c:out value="${outway.bjNo }"></c:out></a>
				</c:when>
				<c:otherwise><c:out value="${outway.internalNo }"></c:out> </c:otherwise>
				</c:choose>
			</ec:column>

			<ec:column property="orgId" title="主办部门" style="text-align:center">
				<c:out value="${cp:MAPVALUE('depno',outway.orgId)}"></c:out>
			</ec:column>
			
			<ec:column property="bjType" title="办件类型"
				style="text-align:center">
				<c:out value="${cp:MAPVALUE('bjType',outway.bjType)}"></c:out>
			</ec:column>

			<%-- <c:set var="tmonitorType">
				<s:text name='outway.monitorType' />
			</c:set>
			<ec:column property="monitorType" title="${tmonitorType}"
				style="text-align:center">
				<c:out value="${cp:MAPVALUE('MONITOR_TYPE',outway.monitorType)}"></c:out>
			</ec:column> --%>

			<c:set var="tmonitorLogo">
				<s:text name='outway.monitorLogo' />
			</c:set>
			<ec:column property="monitorLogo" title="${tmonitorLogo}"
				style="text-align:center" />

			<c:set var="tintime">
				<s:text name='outway.intime' />
			</c:set>
			<ec:column property="intime" title="${tintime}"
				style="text-align:center">
				<fmt:formatDate value="${outway.intime}"
					pattern="yyyy-MM-dd HH:mm:ss" />
			</ec:column>

			<c:set var="optlabel">
				<s:text name="opt.btn.collection" />
			</c:set>
			<ec:column property="opt" title="${optlabel}" sortable="false"
				style="text-align:center">
				<a
					href='../monitor/outway!view.do?outwayno=${outway.outwayno}&ec_p=${ec_p}&ec_crd=${ec_crd}'>查看</a>
				<c:if test="${outway.outWayState=='1'}">
				<c:if test="${cp:CHECKUSEROPTPOWER('YJBJ', 'edit') }">
					<a
						href='../monitor/outway!edit.do?outwayno=${outway.outwayno}&ec_p=${ec_p}&ec_crd=${ec_crd}&${cxparam}'>摘牌</a></c:if>
				</c:if>
				<c:if test="${cp:CHECKUSEROPTPOWER('DBFQ', 'superviseinitiate') }"><a href="#" onclick="dbfq('${outway.monitorSource}','${outway.outwayno}','${outway.bjType}','${outway.bjNo}')">督办</a></c:if>
			</ec:column>

		</ec:row>
	</ec:table>
</body>
<script type="text/javascript">
	$("#btnXZ").bind('click', function() {
		if ($("#btnXZ").attr("target") == "false") {
			$("#btnXZ").attr("target", "true");
			$(".delWarn").attr("checked", "true");
			$("#btnXZ").text("取消");
		} else {
			$("#btnXZ").attr("target", "false");
			$(".delWarn").removeAttr("checked");
			$("#btnXZ").text("全选");
		}
	});

	$("#doZP")
			.bind(
					'click',
					function() {
						var warnNos = "";
						var items = $('.delWarn:checkbox:checked');
						for ( var i = 0; i < items.length; i++) {
							warnNos = warnNos + items.get(i).value + ',';
						}
						if (warnNos != "") {
							if (confirm("确定对选择的预报警进行摘牌 ？")) {
								window.location.href = "monitor/outway!editPLZP.do?warnNos=" + warnNos + "&${cxparam}";
							}
						} else {
							alert("请选择需要进行摘牌操作的预报警信息！");
						}
					});
	
	//部门选择
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
			bindEvent($("#orgName"),$("#s_orgId"),$this);
			$("#lists span").die("click");
		});
	});	
	function dbfq(monitorsource,outwayno,bjtype,bjno){
		var url;
		if (monitorsource=='B'){  //发起层级督办
			url = "<%=request.getContextPath()%>/supervise/superviseBasic!superviseinitiate.do?bjNo="+bjno+"&bjType="+bjtype+"&outwayid="+outwayno+"&object.optId=DCDB_CJJC_LC&fromsup=1&isOrg=T";
		}
		else {
			if("6"!=bjtype){
				url = "<%=request.getContextPath()%>/supervise/superviseBasic!superviseinitiate.do?bjNo="+bjno+"&bjType="+bjtype+"&outwayid="+outwayno+"&object.optId=supervise&fromsup=1&isOrg=F";
			}else{
				url="${pageContext.request.contextPath}/supervise/superviseBasic!DlfxInfo.do?s_orgId=${info.orgId}&s_outwayNo="+outwayno+"&optId=DLFXDBLC&bjType=6"
			}
			
		}
		document.location.href = url;
	}
	
	
 	$(function(){
		var monitortype="${parameters.s_monitorType[0]}";
		var warningcode="${parameters.s_warningCode[0]}";
		//alert(monitortype);
		if(monitortype!=''){
			var wlist=${owlist};
			//var wlist="";
			var ops="<option value=''> </option>";
				for(var i=0; i<wlist.length; i++){
					if(monitortype==wlist[i].wpTypeNo){
						ops+="<option value=\""+wlist[i].wpNo+"\"";
						if(warningcode!=''&&warningcode==wlist[i].wpNo){
							ops+=" selected = \"selected\" ";
						}
						ops+=">"+wlist[i].wpName+"</option>";
						
					}
				
				
			}
				//alert(ops);
				$("#s_warningCode").html(ops);
		}
	});
</script>
</html>
