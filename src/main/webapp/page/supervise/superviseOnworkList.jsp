<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%> 
<html>
	<head>
		<title>
			待办结督办
		</title>
		<script type="text/javascript">
		  function resetForm(){
			  $('#s_superviseNo').val('');
			  $('#s_bjname').val('');
			  $('#s_bjType').val('');
			  $('#s_orgId').val('');
			  $('#orgName').val('');
			  $('#s_superviseDate').val('');
			  $('#s_internalNo').val('');
		  }
		</script>
		<sj:head locale="zh_CN" />
		<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
<style type="text/css">
		.search td{padding:0px 10px 0px 10px;}
</style>
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<div class="search">
			<div class="crumbs">
				待办结的督办
			</div>
			
			<s:form action="superviseOnwork" namespace="/supervise" style="margin-top:0;margin-bottom:5">
				<input type="hidden" name="s_NP_monitorSource" value="${param.s_NP_monitorSource}" />
				<table cellpadding="0" cellspacing="0" align="center">

					<tr >
						<td>督察督办编号:</td>
						<td><input type="text" name="s_superviseNo" id="s_superviseNo "value="${param.s_superviseNo}" ></td>
					
						<td>办件名称:</td>
						<td><input type="text" name="s_bjname" id="s_bjname "value="${param.s_bjname}" ></td>
					</tr>	

					<tr >
						<td>督办目标类型:</td>
						<td><select name="s_bjType" id="s_bjType" style="width:160px">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('bjType')}">
								<option
									<c:if test="${param.s_bjType == row.key}">selected="selected"</c:if>
									value="${row.key}" label="${row.value}">
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
							</select>
						</td>
				
						<td>督办发起部门:</td>
						<td>
						<input type="text" id="orgName" name="orgName"  value="${cp:MAPVALUE('depno',param.s_orgId)}"/>
						<input type="hidden" id="s_orgId" name="s_orgId" value="${param.s_orgId}"/>
							<s:checkbox class="checkbox" label="包含下属机构" name="s_queryUnderUnit"
							value="#parameters['s_queryUnderUnit']" fieldValue="true" />包含下属机构
						</td>
					</tr>	

						

					<tr >
						<td><s:text name="superviseOnwork.superviseDate" />:</td>
						<td><sj:datepicker
							name="s_superviseDate" id="s_superviseDate" readonly="true"
							value="%{#parameters['s_superviseDate']}"
							yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" /></td>
			
						<td><s:text name="superviseOnwork.internalNo" />:</td>
						<td><input type="text" name="s_internalNo" id="s_internalNo "value="${param.s_internalNo}" ></td>
					</tr>	

					<tr>
						<td colspan="4" align="center">
							<s:submit method="list"  key="opt.btn.query" cssClass="btn"/>
						   <input type="button" name="reset" value="重置" class="btn" onclick="resetForm();"/>
						</td>					
					</tr>
				</table>
			</s:form>
		</div>

		<ec:table action="supervise/superviseOnwork!list.do" items="objList" var="superviseOnwork"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif"  retrieveRowsCallback="limit">
			<ec:row>

				<c:set var="tsuperviseNo"><s:text name='superviseOnwork.superviseNo' /></c:set>	
				<ec:column property="superviseNo" title="督查督办编号" style="text-align:center" width="10%" />

				<c:set var="tinternalNo"><s:text name='superviseOnwork.internalNo' /></c:set>	
				<ec:column property="internalNo" title="办件编号" style="text-align:center" width="20%"/>

				<c:set var="tbjname"><s:text name='superviseOnwork.bjname' /></c:set>	
				<ec:column property="bjname" title="办件名称" style="text-align:center" width="25%"/>

				<ec:column property="bjType" title="督办目标类型" style="text-align:center" width="10%">
				${cp:MAPVALUE("bjType",superviseOnwork.bjType)}
				</ec:column>

			
				<ec:column property="orgId" title="督办发起部门" style="text-align:center" width="15%">
				${cp:MAPVALUE("depno",superviseOnwork.orgId)}
				</ec:column>

			
				<c:set var="tsuperviseDate"><s:text name='superviseOnwork.superviseDate' /></c:set>	
				<ec:column property="superviseDate" title="发起督办时间" format="yyyy-MM-dd HH:mm:ss" cell="date" style="text-align:center" width="6%"/>

			
				<c:set var="tpromiseDate"><s:text name='superviseOnwork.promiseDate' /></c:set>	
				<ec:column property="promiseDate" title="督办反馈时限" format="yyyy-MM-dd HH:mm:ss" cell="date" style="text-align:center" width="6%"/>

				<ec:column property="opt" title="操作" sortable="false" style="text-align:center" width="8%">
					<a href='supervise/superviseBasic!view.do?superviseNo=${superviseOnwork.superviseNo}&isworkflowFlag=F&ec_p=${ec_p}&ec_crd=${ec_crd}'>查看</a>
					
					<a href='supervise/superviseOnwork!edit.do?superviseNo=${superviseOnwork.superviseNo}'>办理</a>
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
			menuDisplay(menuList,"${parentunit}");	
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
