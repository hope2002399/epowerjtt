<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="wfRoleRelegate.edit.title" /></title>
</head>
<sj:head locale="zh_CN" />
<script src="${pageContext.request.contextPath}/scripts/suggest.js" type="text/javascript"></script>
<body>
<p class="ctitle"><s:text name="wfRoleRelegate.edit.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<s:form action="sampleFlowRelegate"  method="post" namespace="/sampleflow" id="wfRoleRelegateForm" onsubmit="return checkForm();" >
	<s:submit name="save"  method="save" cssClass="btn" key="opt.btn.save" />
	<input type="button"  value="返回" Class="btn"  onclick="window.history.back()"/>
	<input type="hidden" name="grant" value="${grant}"/>
	<input type="hidden" name="relegateno" value="${object.relegateno}" />
	<table width="200" border="0" cellpadding="1" cellspacing="1">		
				<tr>
					<td class="TDTITLE">
						<s:text name="wfRoleRelegate.grantee" />
					</td>
					<td align="left">
					<div class="userDiv" style="z-index:1000000000;">
						<input type="text" name="userName" size="40" value="${cp:MAPVALUE('usercode',object.grantee)}"/>
						<input type="hidden" name="grantee" value="${object.grantee}" />
						<ul id="list" class="ulList"></ul>
					</div>
						<script type="text/javascript">
						$(function(){
							initValue($("input[name=userName]"),$("#list"),"${pageContext.request.contextPath}/sys/userDef!getUsers.do",$("input[name=grantee]"));
						})
						</script>
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<s:text name="wfRoleRelegate.unitcode" />
					</td>
					<td align="left">
						<select name="unitcode">   
							<option value="">   
									<c:out value="-- 请选择 --"/>   
							</option>    
							<c:forEach var="row" items="${SPRING_SECURITY_CONTEXT.authentication.principal.userUnits}">     
									<option value="${row.unitcode}" <c:if test="${object.unitcode eq row.unitcode}"> selected = "selected" </c:if> >   
										${cp:MAPVALUE("unitcode",row.unitcode)} 
									</option>
							</c:forEach> 
						</select>
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="wfRoleRelegate.roletype" />
					</td>
					<td align="left">
						<select name="roletype" onchange="showDivByType(this.value);">
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('WFRoleType')}">
									<option value="${row.key}" <c:if test="${object.roletype==row.key}">selected="selected"</c:if>>
									
									<c:out value="${row.value}" /></option>
								</c:forEach>
							</select>
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="wfRoleRelegate.rolecode" />
					</td>
					<td align="left">
					<input type="hidden" name="rolecode">
					<div id="no">
						<select name="no" onchange="setRoleCode(this.value);">
							<option value="">--请选择--</option>
						</select>
					</div>
					<div id="gw">
						<select name="gw" onchange="setRoleCode(this.value);">
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('StationType')}">
									<option value="${row.key}" <c:if test="${object.rolecode==row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" /></option>
								</c:forEach>
						</select>
					</div>
					<div id="bj">
						<select name="bj" onchange="setRoleCode(this.value);">
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('WFTeamRole')}">
									<option value="${row.key}" <c:if test="${object.rolecode==row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" /></option>
								</c:forEach>
						</select>
					</div>
					<div id="xz">
						<select name="xz" onchange="setRoleCode(this.value);">
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('RankType')}">
									<option value="${row.key}" <c:if test="${object.rolecode==row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" /></option>
								</c:forEach>
						</select>
					</div>
					</td>
				</tr>
				<tr>
					<td class="TDTITLE">
						<s:text name="wfRoleRelegate.grantor" />
					</td>
					<td align="left">
					<c:if test="${SPRING_SECURITY_CONTEXT.authentication.principal.usercode ne '99999999' && SPRING_SECURITY_CONTEXT.authentication.principal.loginname ne 'admin'}">
						<c:if test="${empty object.grantor}">
							<input type="text" name="grantor_label" readonly="readonly" size="40" value="${SPRING_SECURITY_CONTEXT.authentication.principal.username}"/>
							<input type="hidden" name="grantor" value="${SPRING_SECURITY_CONTEXT.authentication.principal.usercode}" />
						</c:if>
						<c:if test="${not empty object.grantor}">
							<input type="text" name="grantor_label" readonly="readonly" size="40" value="${cp:MAPVALUE('usercode',object.grantor)}"/>
							<input type="hidden" name="grantor" value="${object.grantor}" />
						</c:if>
					</c:if>
					
					<c:if test="${SPRING_SECURITY_CONTEXT.authentication.principal.usercode eq '99999999' && SPRING_SECURITY_CONTEXT.authentication.principal.loginname eq 'admin'}">
						<div class="userDiv">
							<input type="text" name="grantorLabel" size="40" value="${cp:MAPVALUE('usercode',object.grantor)}"/>
							<input type="hidden" id="grantor" name="grantor" value="${object.grantor}"/>
							<ul id="list1" class="ulList"></ul>
						</div>
						<script type="text/javascript">
							 $(function(){
								initValue($("input[name=grantorLabel]"),$("#list1"),"${pageContext.request.contextPath}/sys/userDef!getUsers.do",$("#grantor"));
							})
						 </script>
					</c:if>
					</td>
				</tr>
				<tr>
					<td class="TDTITLE">
						<s:text name="wfRoleRelegate.relegatetime" />
					</td>
					<td align="left">
						<sj:datepicker id="relegatetime"
							name="relegatetime" value="%{object.relegatetime}"
							yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" />
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="wfRoleRelegate.expiretime" />
					</td>
					<td align="left">
						<sj:datepicker id="expiretime"
							name="expiretime" value="%{object.expiretime}"
							yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" />
						
					</td>
				</tr>
				
				<tr>
					<td class="TDTITLE">
						<s:text name="wfRoleRelegate.grantdesc" />
					</td>
					<td align="left">
						<s:textarea name="grantdesc" cols="40" rows="2" value="%{object.grantdesc}"/>
					</td>
				</tr>

</table>

</s:form>
</body>
<script type="text/javascript">
	function init(){
		hiddenAllRoleDIv();
		if(trim(_get('roletype').value).length!=0){
			divHid(_get('no'));
			divShow(_get(_get('roletype').value));
		}
	}
	
	function hiddenAllRoleDIv(){
		divHid(_get('xz'));
		divHid(_get('bj'));
		divHid(_get('gw'));
	}
	function showDivByType(type){
		hiddenAllRoleDIv();
		if(type != ''&& type !=='en'){
			divShow(_get(type));
			divHid(_get('no'));
		}else{
			divShow(_get('no'));
		}
	}
	
	function setRoleCode(v){
		_get('rolecode').value=v;
	}
	
	function checkForm(){
		if(trim(_get('grantee').value).length==0){
			alert("受委托人不能为空");
			return false;
		}
		
		if(trim(_get('relegatetime').value).length==0){
			alert("请选择委托开始时间");
			return false;
		}
		
		if(trim(_get('grantor').value).length==0){
			alert("委托人不能为空");
			return false;
		}
		return true;
	}

	//节点对象获取
	var _get = function (id) {
		return document.getElementById(id);
	};
	
	//字符空格处理
	var trim = function (str) {
		return str.replace(/^\s+|\s+$/g, "");
	};
	
	//DIV控件显示
	var divShow = function (obj) {
		return obj.style.display = "";
	};
	//DIV控件隐藏
	var divHid = function (obj) {
		return obj.style.display = "none";
	};
	
	init();
</script>