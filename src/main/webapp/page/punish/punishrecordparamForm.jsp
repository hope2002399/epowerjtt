<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%> 
<html>
<sj:head locale="zh_CN" />
<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
<head>
<title>添加处罚备案参数</title>
 <c:out value="${cp:MAPVALUE('unitcode',unitForm.map.unitcode)}"/>
    <c:out value="${cp:MAPVALUE('usercode',unitForm.map.usercode)}"/>
    <link href="<s:url value="/scripts/autocomplete/autocomplete.css"/>" type="text/css" rel="stylesheet">
    <script language="javascript" src="<s:url value="/scripts/autocomplete/autocomplete.js"/>" type="text/javascript"></script>
    <script language="javascript" src="<s:url value="/scripts/selectUser.js"/>" type="text/javascript"></script>
	<script language="JavaScript" src="${pageContext.request.contextPath}/page/powerbase/lhgdialog/lhgcore.min.js" type="text/JavaScript"></script>
    <script language="JavaScript" src="${pageContext.request.contextPath}/page/powerbase/lhgdialog/lhgdialog.js" type="text/JavaScript"></script>
<style type="text/css">
	.viewTable td { width:37%; }
	.viewTable td.addTd { width:13%; }
</style>
	
</head>

<body>

<%@ include file="/page/common/messages.jsp"%>
		<fieldset style="padding: 10px;">
			<legend class="ctitle" style="width: auto; margin-bottom: 5px;">
				添加处罚备案参数
			</legend>

			<s:form action="punishrecordparam"  method="post" namespace="/punish" id="punishrecordparamForm" enctype="multipart/form-data">
				<input type="button" onclick="save()"  class="btn" value="保存"/>
				<input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" />
				
			<table border="0" cellpadding="0" cellspacing="0" class="viewTable">		
 				
				<tr>
					<td class="addTd" width="130"><span style="color: red">*</span>工作单位</td>
					<td align="left" ><input type="text" id="orgName" name="orgName"  value="${cp:MAPVALUE('unitcode',param.orgId)}"/>
					<input type="hidden" id="orgId" name="orgId" value="${param.orgId}"/></td>
				</tr>
				<tr>
					<td class="addTd" width="130%">
						<span style="color: red">*</span>部门性质
					</td>
					<td align="left">
						<select name="depkind" >
							<option value="">-----------请选择----------</option>
							<c:forEach var="row" items="${cp:DICTIONARY('depkind')}">
								<option value="${row.key}"
									<c:if test="${object.depkind eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td class="addTd">
						<span style="color: red">*</span>个人罚款限额
					</td>
					<td align="left">
						<s:textfield name="personnum"  value="%{object.personnum}"/>（元）
					</td>
				</tr>
				<tr>
					<td class="addTd">
						<span style="color: red">*</span>组织机构限额
					</td>
					<td align="left">
						<s:textfield name="corpnum"  value="%{object.corpnum}"/>（元）
					</td>
				</tr>


				<tr>
					<td class="addTd">
						法律依据
					</td>
					<td align="left">
						<s:textarea name="lawbasic" value="%{object.lawbasic}" cols="40" rows="2"/>
					</td>
				</tr>

				<tr>
					<td class="addTd">
						备注 
					</td>
					<td align="left">
						<s:textarea name="remark" value="%{object.remark}" cols="40" rows="2"/>
					</td>
				</tr>

			</table>


		</s:form>
	</fieldset>
</body>
<script type="text/javascript">
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
			bindEvent($("#orgName"),$("#orgId"),$this);
			$("#lists span").die("click");
		});
	});
	function save(){
		 var orgId=document.getElementById("orgId").value;
	     var depkind=document.getElementById("depkind").value;
	     var personnum=document.getElementById("personnum").value;
	     var corpnum=document.getElementById("corpnum").value;
	     if(""==orgId){
	    	 alert("请选择工作单位");
	    	 document.forms[0].orgName.focus();
	    	 return;
	     }
	     if(""==depkind){
	    	 alert("请选择部门性质");
	    	 document.forms[0].depkind.focus();
	    	 return;
	     }
	     if(""==personnum){
	    	 alert("请填写个人罚款限额");
	    	 document.forms[0].personnum.focus();
	    	 return;
	     }
	     if(""==corpnum){
	    	 alert("请填写组织机构限额");
	    	 document.forms[0].corpnum.focus();
	    	 return;
	     }
	    
	     var form=document.getElementById("punishrecordparamForm");
	     form.action="punishrecordparam!punishrecordparamSave.do";     
	     form.submit();
	     
	}
</script>
</html>
