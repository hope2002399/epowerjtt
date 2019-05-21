<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>

<html>
<head>
<title>督办发起${object.bjType}</title>
<sj:head locale="zh_CN" />
<script src="<s:url value='/scripts/centit_validator.js'/>"
	type="text/javascript"></script>
<link href="<s:url value="/scripts/autocomplete/autocomplete.css"/>"
	type="text/css" rel="stylesheet">
<script language="javascript"
	src="<s:url value="/scripts/autocomplete/autocomplete.js"/>"
	type="text/javascript"></script>
<script language="javascript"
	src="<s:url value="/scripts/selectUser.js"/>" type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js"
	type="text/javascript"></script>
<link
	href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css"
	rel="stylesheet" type="text/css" />

</head>
<body>
	<s:form action="superviseBasic" namespace="/supervise" theme="simple"
		validator="true">
		<s:hidden name="optId" value="%{object.optId}" />
		<input type="hidden" name="bjtypestring" value="${bjtypestring}" />
		<input type="hidden" name="intno" value="${intno}" />
		<input type="hidden" name="itemid" value="${itemid}" />
		<input type="hidden" name="forwardurl" value="${forwardurl}" />
		<input type="hidden" name="outwayid" value="${object.outwayid}" />
		<input type="hidden" name="monitorSource" value="${object.monitorSource}" />

		<!-- <s:submit method="save" id="save" cssClass="btn" value="保存" /> -->
		<s:submit method="saveAndSubmit" id="saveAndSubmit" cssClass="btn"
			value="提交" />
		<input type="button" value="返回" Class="btn"
			onclick="window.history.back()" />
		<c:if
			test="${empty object.outwayid&&!empty object.bjNo&&5 ne object.bjType&&6 ne object.bjType&&7 ne object.bjType&&4 ne object.bjType}">
			<iframe id="viewFrame" name="viewFrame"
				src="../supervise/superviseBasic!viewBizInfo.do?&superviseNo=${object.superviseNo}&bjNo=${object.bjNo}&bjType=${object.bjType}&fromsup=${requestScope.fromsup}"
				width="100%" style="margin-bottom: 10px;" frameborder="no"
				scrolling="false" border="0" marginwidth="0"
				onload="this.height=window.frames['viewFrame'].document.body.scrollHeight"></iframe>
		</c:if>
		<c:if
			test="${!empty object.bjNo&&(5 eq object.bjType||6 eq object.bjType||7 eq object.bjType||4 eq object.bjType)}">
			<iframe id="viewFrame" name="viewFrame"
				src="../monitor/outway!view.do?noback=T&outwayno=${object.outwayid}&fromsup=${requestScope.fromsup}"
				width="100%" style="margin-bottom: 10px;" frameborder="no"
				scrolling="false" border="0" marginwidth="0"
				onload="this.height=window.frames['viewFrame'].document.body.scrollHeight"></iframe>
		</c:if>
		<c:if
			test="${not(empty object.outwayid)&&(1 eq object.bjType||2 eq object.bjType)}">
			<iframe id="viewFrame" name="viewFrame"
				src="../supervise/superviseBasic!viewBizInfo.do?&superviseNo=${object.superviseNo}&bjNo=${object.bjNo}&outwayid=${object.outwayid}&bjType=${object.bjType}&fromsup=${requestScope.fromsup}"
				width="100%" style="margin-bottom: 10px;" frameborder="no"
				scrolling="false" border="0" marginwidth="0"
				onload="this.height=window.frames['viewFrame'].document.body.scrollHeight"></iframe>
		</c:if>
		<table cellpadding="0" cellspacing="0" class="viewTable">
			<td class="addTd">办件编号<span style="color: red">*</span></td>
			<c:if test="${empty  fromsup}">
				<td align="left" colspan="3"><input type="text" name="bjNo"
					id="bjNo" value="${object.bjNo}"> <input type="button"
					valign="center" class='btn' name="listsup"
					onclick="openNewWindow('<%=request.getContextPath()%>/supervise/superviseBasic!listsup.do?optId=${optId }','powerWindow',null);"
					value="选择办件">
			</c:if>

			<c:if test="${!empty  fromsup}">
				<td align="left" colspan="3"><input type="hidden" name="bjNo"
					value="${object.bjNo}">${object.bjNo}</td>
			</c:if>
		</table>

		<table cellpadding="0" cellspacing="0" class="viewTable">
			<!-- 
			<tr>
				<td class="addTd">督办反馈时限<span style="color: red">*</span></td>
				<td align="left" colspan="3"><sj:datepicker id="promisedate"
						name="promisedate" style="width:140px" yearRange="2000:2020"
						timepickerFormat="hh:mm:ss" displayFormat="yy-mm-dd"
						changeYear="true" timepicker="true" validator="input" min="1"
						errorshow="请选择督办反馈时限" value="%{object.promisedate}" /></td>
			</tr>
			 -->
			<tr>
				<td class="addTd">督办意见<span style="color: red">*</span></td>
				<td align="left" colspan="3"><s:textarea
						cssStyle="overflow:visible" name="superviseOption"
						validator="input" min="1" errorshow="请输入督办意见"
						value="%{object.superviseOption}"></s:textarea></td>
			</tr>
			<tr>
				<td class="addTd">督办对象<span style="color: red">*</span></td>
				<td align="left">
<c:if test="${object.monitorSource != 'B'}">
				<c:if
						test="${empty  fromsup||1 eq object.bjType||2 eq object.bjType||7 eq object.bjType||4 eq object.bjType}">
						<s:radio value="%{object.isOrg}" id="dbtarget" name="isOrg"
							list="#{'F':'人员','T':'单位'}" listKey="key" listValue="value"
							onclick="changestate(this.value)" />
					</c:if> <c:if
						test="${!empty  fromsup&&1 ne object.bjType&&2 ne object.bjType&&7 ne object.bjType&&4 ne object.bjType}">
						<c:if test="${object.isOrg eq 'T'}">
	    组织
		</c:if>
						<c:if test="${object.isOrg eq 'F'}">
	    个人
		</c:if>
					</c:if>
					
</c:if>
<c:if test="${object.monitorSource == 'B'}">
					<input type="hidden" name="isOrg" value="T"/>
					单位
</c:if>
					</td>
			</tr>
<c:if test="${object.monitorSource != 'B'}">			
			<c:if
				test="${empty  fromsup||1 eq object.bjType||2 eq object.bjType||7 eq object.bjType||4 eq object.bjType}">
				<tr id="monitorOperatorNametr1">
					<td class="addTd">督办人员代码</td>
					<td align="left"><s:textfield name="monitorOperatorId"
							onclick="selectUser(this)" id="userCode" style="width:140px;" />
					</td>
				</tr>
				<tr id="monitorOperatorNametr2">
					<td class="addTd">督办人员用户名</td>
					<td align="left" id="un">
						<div id="userName"></div> <input type="hidden"
						id="monitorOperatorName" name="monitorOperatorName"
						value="${cp:MAPVALUE('usercode',param.s_usercode)}" />
					</td>
				</tr>

				<tr id="monitorOrgNametr">
					<td class="addTd">督办单位名称</td>
					<td align="left"><input type="text" id="orgName"
						name="monitorOrgName" style="width: 58%; height: 25px;"
						value="${object.monitorOrgName }" /> <input type="hidden"
						id="s_orgcode" name="monitorOrgId" value="${object.monitorOrgId }" />
					</td>
				</tr>

			</c:if>
			<c:if
				test="${!empty  fromsup&&1 ne object.bjType&&2 ne object.bjType&&7 ne object.bjType&&4 ne object.bjType}">
				<c:if test="${object.isOrg eq 'F'}">
					<tr>
						<td class="addTd">被督办人员工号</td>
						<input type="hidden" name="monitorOperatorId"
							value="${object.monitorOperatorId}">
						<input type="hidden" name="monitorOrgId"
							value="${object.monitorOrgId}">
						<input type="hidden" name="monitorOrgName"
							value="${object.monitorOrgName}">
						<td align="left">${object.monitorOperatorId}
					<tr>
						<td class="addTd">被督办人员姓名</td>
						<td align="left"><input type="hidden"
							name="monitorOperatorName" value="${object.monitorOperatorName}">
							${object.monitorOperatorName}
							</div></td>
					</tr>
				</c:if>
				<c:if test="${object.isOrg eq 'T'}">
					<tr>
						<td class="addTd">被督办单位名称</td>
						<input type="hidden" name="monitorOrgId"
							value="${object.monitorOrgId}">
						<input type="hidden" name="monitorOrgName"
							value="${cp:MAPVALUE('depno',monitorOrgId)}">
						<td align="left">${cp:MAPVALUE("depno",monitorOrgId)}</td>
					</tr>
				</c:if>
			</c:if>
			
</c:if>

<c:if test="${object.monitorSource == 'B'}">
<tr>
						<td class="addTd">被督办单位名称</td>
						<input type="hidden" name="monitorOrgId"
							value="${object.monitorOrgId}">
						<input type="hidden" name="monitorOrgName"
							value="${cp:MAPVALUE('depno',monitorOrgId)}">
						<td align="left">${cp:MAPVALUE("depno",monitorOrgId)}</td>
					</tr>

</c:if>
<tr>
				<td class="addTd">督办类别</td>
				<td align="left"><c:if test="${empty  fromsup}">
						<select id="bjType" name="bjType">
							<option VALUE="">---请选择---</option>
							<c:forEach var="row" items="${cp:LVB('bjType')}">
								<option value="${row.value}" label="${row.label}"
									<c:if test="${object.bjType==row.value}">selected="selected"</c:if>>
									<c:out value="${row.label}" />
								</option>
							</c:forEach>
						</select>
					</c:if> <c:if test="${!empty  fromsup}">
						<input type="hidden" name="bjType" value="${object.bjType}">
							${cp:MAPVALUE("bjType",object.bjType)}
		</c:if></td>

			</tr>
			<tr>
				<td class="addTd">督办详细描述</td>
				<td align="left" colspan="3"><s:textarea
						cssStyle="overflow:visible" name="superviseDetail"
						value="%{object.superviseDetail}"></s:textarea></td>
			</tr>
		</table>
	</s:form>
</body>
<script type="text/javascript">
    function lkm(){
    	var contextpath="${pageContext.request.contextPath}";
    	var url=contextpath+"/supervise/superviseBasic!listsup.do?";
    	window.showModalDialog(url,window,"dialogHeight:450px;dialogWidth:850px;center:yes;help:no;scroll:yes;status:no;edge:raised");
    }
    $(document).ready(
    	function(){
    	$("#monitorOrgNametr").attr("style","display:none");
    	$('input[name=isOrg][value=F]').attr("checked","checked");
    	changestate("F");
    }
);
	
	$("#monitorOperatorName").click(
		function(){
	    var d = '${userjson}';
	    if(d.trim().length){
		window.parent.selectPopWin(jQuery.parseJSON(d),$("#bjUserNames"),$("#bjCodes"));
		};
	}
);
	function changestate(value){
		if(value=="F"){
		$("#monitorOperatorNametr1").attr("style","");
		$("#monitorOperatorNametr2").attr("style","");
		$("#monitorOrgNametr").attr("style","display:none");
		}
		
		if(value=="T"){
		$("#monitorOperatorNametr1").attr("style","display:none");
		$("#monitorOperatorNametr2").attr("style","display:none");
		$("#monitorOrgNametr").attr("style","");
		}
	}

      var list = [];
      var i;
      <c:forEach var="userinfo" varStatus="status" items="${userlist}">
          list[${status.index}] = { username:'<c:out value="${userinfo.username}"/>', loginname:'<c:out value="${userinfo.loginname}"/>', usercode:'<c:out value="${userinfo.loginname}"/>',pinyin:'<c:out value="${userinfo.usernamepinyin}"/>'  };
      </c:forEach>
      function selectUser(obj) {
             userInfo.choose(obj, {dataList:list,userName:$('#userName')});
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
		function bindEvent(o1,o2,$this){
			o1.val($this.html());
			o2.val($this.attr("rel"));
			if(getID("shadow")){
				$("#shadow").hide();
				$("#boxContent").hide();
			}
		}

	</script>
</html>