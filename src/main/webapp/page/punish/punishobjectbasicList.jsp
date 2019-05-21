<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title></title>
<script type="text/javascript">
		  function resetForm(){
			  $('#orgName').val('');
			  $('#s_managedepid').val('');
			  $('#s_pooccuradress').val('');
			  $('#orgName').val('');
			  $('#s_orgcode').val('');
			  document.forms[0].s_queryUnderUnit.checked=false;
		  }
		</script>
<sj:head locale="zh_CN" />
<script
	src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js"
	type="text/javascript"></script>
<link
	href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css"
	rel="stylesheet" type="text/css" />

</head>
<body>
	<%@ include file="/page/common/messages.jsp"%>
	<div class="search">
			<div class="crumbs">
				归档查询
			</div>
		<s:form action="punishobjectbasic" namespace="/punish"
			style="margin-top:0;margin-bottom:5">


			<table cellpadding="0" cellspacing="0" align="center">
				<%-- <tr height="22">
					<td align="left">案件登记部门: <input type="text" id="orgName"
						name="orgName" style="width: 20%; height: 25px;"
						value="${cp:MAPVALUE('unitcode',param.s_managedepid)}" /> <input
						type="hidden" id="s_managedepid" name="s_managedepid"
						value="${param.s_managedepid}" /> <s:checkbox label="包含下属机构"
							name="s_queryUnderUnit" value="#parameters['s_queryUnderUnit']"
							fieldValue="true" />包含下属机构
					</td>
				</tr>
				<tr>
					<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;案发地点:<s:textfield
							 name="s_pooccuradress" id="s_pooccuradress" cssStyle="width:20%;height:25px;"
							value="%{#parameters['s_pooccuradress']}"></s:textfield> <s:submit
							method="list" key="opt.btn.query" cssClass="btn" />
							&nbsp;&nbsp;
							<input type="button" name="reset" value="重置" class="btn" onclick="resetForm();"/></td>
				</tr> --%>
				<tr>
					<td class="addTd">案件登记部门：</td>
					<td width="270"><input type="text" id="orgName" name="orgName" value="${cp:MAPVALUE('unitcode',param.s_managedepid)}" />
						<input type="hidden" id="s_managedepid" name="s_managedepid" value="${param.s_managedepid}" />
						 <s:checkbox label="包含下属机构" name="s_queryUnderUnit" value="#parameters['s_queryUnderUnit']"
							fieldValue="true" />包含下属机构
					</td>
					<td class="addTd">案发地点：</td>
					<td><s:textfield name="s_pooccuradress" id="s_pooccuradress" value="%{#parameters['s_pooccuradress']}"></s:textfield>
					</td>
					<td align="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:submit method="list" key="opt.btn.query" cssClass="btn" />
					<input type="button" name="reset" value="重置" class="btn" onclick="resetForm();"/>
					</td>
				</tr> 

			</table>
		</s:form>
	</div>

	<ec:table action="punish/punishobjectbasic!list.do" items="objList"
		var="punishobjectbasic"
		imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif"
		retrieveRowsCallback="limit">
		<ec:row>

			<ec:column property="punishobjectid" title="案件流水号"
				style="text-align:center"/>
			<ec:column property="punishobjectno" title="案件编号"
				style="text-align:center"/>
				<ec:column property="pooccurdate" title="案发时间" style="text-align:center" format="yyyy-MM-dd HH:mm:ss" cell="date" sortable="true"/>
			<ec:column property="pooccuradress" title="案发地点"
				style="text-align:center">
				<c:choose>
					<c:when test="${fn:length(punishobjectbasic.pooccuradress) > 30}">
						<c:out
							value="${fn:substring(punishobjectbasic.pooccuradress, 0, 30)}..." />
					</c:when>
					<c:otherwise>
						<c:out value="${punishobjectbasic.pooccuradress}" />
					</c:otherwise>
				</c:choose>
			</ec:column>


			<ec:column property="managedepid" title="案件登记部门"
				style="text-align:center">
				${cp:MAPVALUE("unitcode",punishobjectbasic.managedepid)}
				</ec:column>
			<ec:column property="poregistedate" title="登记日期" style="text-align:center" format="yyyy-MM-dd HH:mm:ss" cell="date" sortable="true"/>

			<ec:column property="opt" title="操作" sortable="false"
				style="text-align:center">
				<c:set var="deletecofirm">
					<bean:message key="label.delete.confirm" />
				</c:set>
				<c:if test="${ punishobjectbasic.punishobjecttype eq '0'}">
					<a href='punish/punishobjectbasic!viewItem.do?punishobjectid=${punishobjectbasic.punishobjectid}&nodeInstId=0'>查看</a>
				</c:if>
				<c:if test="${ punishobjectbasic.punishobjecttype eq '1'}">
					<a href='punish/punishobjectbasic!punishInfo.do?punishobjectid=${punishobjectbasic.punishobjectid}'>查看</a>
				</c:if>
				<c:if test="${punishobjectbasic.biztype  eq 'F' }">
					<a
						href='punish/punishobjectbasic!editold.do?punishobjectid=${punishobjectbasic.punishobjectid}'>编辑</a>
					<a href='#'
						onclick="confirm_check('${punishobjectbasic.punishobjectid}');">删除</a>

				</c:if>
			</ec:column>
		</ec:row>
	</ec:table>
</body>
<script type="text/javascript">
	function confirm_check(punishobjectid) {
		if (window.confirm("确实删除此[" + punishobjectid + "]案件?")) {
			document.location.href = 'punish/punishobjectbasic!delete.do?punishobjectid='
					+ punishobjectid;
		}
	}
	function bindEvent(o1, o2, $this) {
		o1.val($this.html());
		o2.val($this.attr("rel"));
		if (getID("shadow")) {
			$("#shadow").hide();
			$("#boxContent").hide();
		}
	}
	$("#orgName")
			.bind('click',
					function() {
						var menuList = ${unitsJson};
						var shadow = "<div id='shadow'></div><div id='boxContent'><div class='listShadow'></div><div id='lists' class='getTree'>Loader</div><div id='close'>×</div></div>";
						if (getID("shadow")) {
							$("#shadow").show();
							$("#boxContent").show();
						} else {
							$("body").append(shadow);
							$("#shadow").height(document.body.scrollHeight);
							setTimeout(function() {
								menuDisplay(menuList, "${parentunit}");
							}, 0);
						}
						;
						$("#lists span").live('click',
								function() {
									var $this = $(this);
									bindEvent($("#orgName"),$("#s_managedepid"), $this);
									$("#lists span").die("click");
								});
					});
</script>

</html>
