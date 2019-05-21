<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
	<script src="${pageContext.request.contextPath}/scripts/suggest.js" type="text/javascript"></script>
	<title>分配工作小组 </title>
</head>
<body>
	<%@ include file="/page/common/messages.jsp"%>
	<fieldset style="padding:10px;">
	<legend>分配工作小组</legend>
	<s:form name="workTeamForm" method="post" onsubmit="return checkWorkTeam();"
	 action="sampleFlowManager" namespace="/sampleflow" style="margin-top:0;margin-bottom:5">
	
	
	<input type="hidden" name="flowInstId" value="${flowInstId}">
	<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
		<tr class="xbcdep">
			<td class="addTd">办件角色：</td>
			<td align="left" >
				<select name="roleCode">   
					<option value="">   
							<c:out value="-- 请选择 --"/>   
					</option>    
					<c:forEach var="row" items="${cp:DICTIONARY('WFTeamRole')}">
						<option value="${row.key}" <c:if test="${param.roleCode==row.key}">selected="selected"</c:if>><c:out value="${row.value}" /></option>
					</c:forEach> 
				</select>
			</td>
		</tr>
		<tr class="xbcdep">
			<td class="addTd">添加人员：</td>
			<td align="left">
			<div id="userDiv">
			<s:textfield id="userName" name="userName" size="40"/>
			<input type="hidden" id="userCode" name="userCode" />
			<ul id="list"></ul>
			</div>
			<script type="text/javascript">
			$(function(){
				initValue($("input[name=userName]"),$("#list"),"${pageContext.request.contextPath}/sys/userDef!getUsers.do",$("input[name=userCode]"),null);
			})
			</script>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="button" value="添加" class="btn" onclick="addUser();" />
			<s:submit name="assign"  method="assignWorkTeam" cssClass="btn" key="opt.btn.save" />
			<input type="button"  value="返回" Class="btn"  onclick="window.history.back()"/>
			</td>
		</tr>
	</table>
	<table id="usertab">
	</table>
	</s:form>
	</fieldset>
	</body>
	
	<script type="text/javascript">
		//删除 
		function deleteRow(node,userName) { 
		    if (!window.confirm("确认删除"+userName+"?")) { 
		        return; 
		    } 
		    var tabObj = _get("usertab");//获取表格对象 
		    var rowObj = node.parentNode.parentNode; 
		    tabObj.deleteRow(rowObj.rowIndex); 
		} 
	
	
		function addUser()
		{
			userCode = document.getElementById('userCode').value;
			userName = document.getElementById('userName').value;
			if(userCode==''){
				alert('请选择人员');
				return;
			}
			if(!checkuser(userCode)){
				return;
			}
			var newHidden = "<input type='hidden' name='userCodes' value='"+userCode+"' >" + userName;
			var oper = "&nbsp;&nbsp;<a href='###' onclick=\"deleteRow(this,'"+userName+"')\">[删除]</a>"; 
			var tblObj = _get("usertab");
			var len =  tblObj.rows.length; 
		    var newRow = tblObj.insertRow(len);//插入行对象 
		    var fileCell = newRow.insertCell(0); 
		    fileCell.innerHTML = newHidden + oper;
		}
		function checkWorkTeam(){
			var users = document.getElementsByName('userCodes');
			
			if(users == null || users.length == 0 || users == 'undefine'){
				alert('请添加人员');
				return false;
			}
			if(_get('roleCode').value==''){
				alert('请选择办件角色');
				return false;
			}
			
			
		}
		function checkuser(user){
			
			var users = document.getElementsByName('userCodes');
			for(var i = 0 ; i < users.length;i++){
				if(user==users[i].value){
					alert(users[i].value+"此人员已经存在!请重新选择");
					return false;
				}
			}
			return true;
		}

		var _get = function (id) {
			return document.getElementById(id);
		};
	</script>
	</html>
	