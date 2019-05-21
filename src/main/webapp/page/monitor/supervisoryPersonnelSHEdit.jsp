<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<sj:head locale="zh_CN" />
<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" />
<title>添加监察人员</title>
    <c:out value="${cp:MAPVALUE('unitcode',unitForm.map.unitcode)}"/>
    <c:out value="${cp:MAPVALUE('usercode',unitForm.map.usercode)}"/>
    <link href="<s:url value="/scripts/autocomplete/autocomplete.css"/>" type="text/css" rel="stylesheet">
    <script language="javascript" src="<s:url value="/scripts/autocomplete/autocomplete.js"/>" type="text/javascript"></script>
    <script language="javascript" src="<s:url value="/scripts/selectUser.js"/>" type="text/javascript"></script>
	<script language="JavaScript" src="${pageContext.request.contextPath}/page/powerbase/lhgdialog/lhgcore.min.js" type="text/JavaScript"></script>
    <script language="JavaScript" src="${pageContext.request.contextPath}/page/powerbase/lhgdialog/lhgdialog.js" type="text/JavaScript"></script>
    <script type="text/javascript" >
        var list = [];
        <c:forEach var="userinfo" varStatus="status" items="${userlist}">
            list[${status.index}]= { username:'<c:out value="${userinfo.username}"/>', loginname:'<c:out value="${userinfo.loginname}"/>', usercode:'<c:out value="${userinfo.usercode}"/>',pinyin:'<c:out value="${userinfo.usernamepinyin}"/>'  };
        </c:forEach>
        function selectUser(obj) {
               userInfo.choose(obj, {dataList:list,userName:$('#userName')});
        }
    </script>
<style type="text/css">
	.viewTable td { width:37%; }
	.viewTable td.addTd { width:13%; }
</style>
	
</head>
<body>
	<%@ include file="/page/common/messages.jsp"%>
	<fieldset style="padding: 10px;">
		<legend class="ctitle" style="width: auto; margin-bottom: 5px;">
			监察人员信息
		</legend>
		<s:form action="supervisorypersonnel" method="post" namespace="/monitor" id="supervisorypersonnelForm" enctype="multipart/form-data">
		<input type="button" class="btn" value="保存" onclick="save();"/>
		<input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" />
			<input id="flag" type="hidden" name="flag" value="2" />
			<input id="no" type="hidden" name="no" value="${object.no}" />
			<input id="datesource" type="hidden" name="datesource" value="${object.datesource}" />
			<input id="updateDate" type="hidden" name="updateDate" value="${object.updateDate}" />
			<input id="state" type="hidden" name="state" value="${object.state}" />
			<input id="auditDate" type="hidden" name="auditDate" value="${object.auditDate}" />
			<input id="auditor" type="hidden" name="auditor" value="${object.auditor}" />
			
				<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
				<tr>
					<td class="addTd" width="20%"><span style="color: red">*</span><s:text name="supervisorypersonnel.userName" /></td>
					<td align="left"><s:textfield name="userName"  value="%{object.userName}" /></td>
					<td class="addTd" width="20%"><span style="color: red">*</span><s:text name="supervisorypersonnel.userId" /></td>
					<td align="left"> <s:textfield name="userId" value="%{object.userId}" /></td>
				</tr>
				<tr>
					<td class="addTd" width="130"><span style="color: red">*</span>部门名称</td>
					<td align="left"><input type="text" id="orgName" name="orgName" style="width:58%;height:25px;" value="${cp:MAPVALUE('unitcode',object.deptcode)}"/>
					<input type="hidden" id="deptcode" name="deptcode" value="${object.deptcode}"/></td>
					<td class="addTd" width="20%"><span style="color: red">*</span>关联系统操作编号</td>
					<td align="left"> <s:textfield name="sysId" onclick="selectUser(this)" id="sysId"  style="width:140px;" /></td>
					</tr>
				<tr>
				<td class="addTd" ><font color="red"><strong>*&nbsp;</strong></font>出生年月</td>	
				<td align="left">
				<sj:datepicker id="birth" name="birth"  style="width:140px"
			      yearRange="2000:2020"  displayFormat="yy-mm-dd" changeYear="true"  
			    value="%{object.birth}"/>
		       </td>
					<td class="addTd" width="130"><span style="color: red">*</span><s:text name="supervisorypersonnel.sex" /></td>
					<td align="left">
					<select name="sex" >
							<c:forEach var="row" items="${cp:DICTIONARY('sex') }">
								<option value="${row.key}"
									<c:if test="${object.sex eq row.key}"> selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
							</select></td>
				</tr>
				<tr>
					<td class="addTd" width="130"><span style="color: red">*</span><s:text name="supervisorypersonnel.politicalLandscape" /></td>
					<td align="left"><select name="politicalLandscape" >
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('POLLANDSCAPE')}">
								<option value="${row.key}"
									<c:if test="${object.politicalLandscape eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
					<td class="addTd" width="130"><span style="color: red">*</span><s:text name="supervisorypersonnel.education" /></td>
					<td align="left"><select name="education" >
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('EDUCATION')}">
								<option value="${row.key}"
									<c:if test="${object.education eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
				<td class="addTd" ><span style="color: red">*</span><s:text name="supervisorypersonnel.tel" /></td>	
				<td class="left" ><s:textfield name="tel"  value="%{object.tel}" /></td>
				<td class="addTd" width="130"><span style="color: red">*</span><s:text name="supervisorypersonnel.position" /></td>
					<td align="left"><select name="position" >
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('POSITION')}">
								<option value="${row.key}"
									<c:if test="${object.position eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="addTd" width="130"><span style="color: red">*</span><s:text name="supervisorypersonnel.organization" /></td>
					<td align="left"><select name="organization" >
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('ORGANIZATION')}">
								<option value="${row.key}"
									<c:if test="${object.organization eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
					<td class="addTd" width="130"><span style="color: red">*</span><s:text name="supervisorypersonnel.updateType" /></td>
					<td align="left"><select name="updateType">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('jcry_type')}">
								<option value="${row.key}"
									<c:if test="${object.updateType eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
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
			bindEvent($("#orgName"),$("#deptcode"),$this);
			$("#lists span").die("click");
		});
	});
	function isNumber2(name) //数值检测
	{
		if (name.length == 0||name.length!=6)
			return false;
		for (i = 0; i < name.length; i++) {
			if (name.charAt(i) < "0" || name.charAt(i) > "9"){
				return false;
				}
			if(i==4&&name.charAt(i)!="0"){
			   if(name.charAt(i)!="1")
			       return false;
			}
			if(i==5){
			if(name.charAt(i-1)=="1"&&name.charAt(i)>"2")
				return false;
			}
		}
		return true;
	}
	function save(){
		 var userName=document.getElementById("userName").value;
	     var userId=document.getElementById("userId").value;
	     var deptcode=document.getElementById("deptcode").value;
	     var updateType=document.getElementById("updateType").value;
	     var birth=document.getElementById("birth").value;
	     var politicalLandscape=document.getElementById("politicalLandscape").value;
	     var education=document.getElementById("education").value;
	     var tel=document.getElementById("tel").value;
	     var position=document.getElementById("position").value;
	     var organization=document.getElementById("organization").value;
	     if(""==userName){
	    	 alert("请填写姓名");
	    	 document.forms[0].userName.focus();
	    	 return;
	     }
	     if(""==userId){
	    	 alert("请填写检查人员编号");
	    	 document.forms[0].userId.focus();
	    	 return;
	     }
	     if(/\D/.test(userId)){
	    	 alert("检查人员编号,输入格式不正确,请重新输入");
	    	 document.forms[0].userId.focus();
	    	 return;
	     }
	     if(""==deptcode){
	    	 alert("请选择部门");
	    	 document.forms[0].deptcode.focus();
	    	 return;
	     }
	     if(""==birth){
	    	 alert("请选择出生年月");
	    	 document.forms[0].birth.focus();
	    	 return;
	     }
	     if(""==politicalLandscape){
	    	 alert("请选择政治面貌");
	    	 document.forms[0].politicalLandscape.focus();
	    	 return;
	     }
	     if(""==education){
	    	 alert("请选择学历");
	    	 document.forms[0].education.focus();
	    	 return;
	     }
	     if(""==tel){
	    	 alert("请填写电话号码");
	    	 document.forms[0].tel.focus();
	    	 return;
	     }
	     if(/\D/.test(tel)||tel.length!=11){
	    	 alert("联系电话,输入格式不正确,请重新输入");
	    	 document.forms[0].userId.focus();
	    	 return;
	     }
	     if(""==position){
	    	 alert("请选择职务");
	    	 document.forms[0].position.focus();
	    	 return;
	     }
	     if(""==organization){
	    	 alert("请选择编制情况");
	    	 document.forms[0].organization.focus();
	    	 return;
	     }
	     if(""==updateType){
	    	 alert("请选择人员状态");
	    	 document.forms[0].updateType.focus();
	    	 return;
	     }
	     var form=document.getElementById("supervisorypersonnelForm");
	     form.action="supervisorypersonnel!supervisorypersonnelSave.do";     
	     form.submit();
	}
	</script>

</html>
