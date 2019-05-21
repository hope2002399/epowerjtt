<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>增减分录入</title>
	<script language="JavaScript" src="${pageContext.request.contextPath}/page/powerbase/lhgdialog/lhgcore.min.js" type="text/JavaScript"></script>
    <script language="JavaScript" src="${pageContext.request.contextPath}/page/powerbase/lhgdialog/lhgdialog.js" type="text/JavaScript"></script>
</head>

<body >

	<%@ include file="/page/common/messages.jsp"%>
	<fieldset style="padding: 10px;">
		<legend class="ctitle" style="width: auto; margin-bottom: 5px;">
			增减分录入
		</legend>
		<s:form action="pamonthpunish" method="post" namespace="/monitor" id="pamonthpunishForm" enctype="multipart/form-data">
			<s:submit name="save" method="pamonthpunishSave" cssClass="btn" key="opt.btn.save" />
			<input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" /> 
				<input id="test2" type="hidden" name="test2" value=""/>	
				<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
				<tr>
				<td class="addTd" width="130">评测年度：</td>
					<td><select name="countYear">
							<option value="">--请选择--</option>
					<c:forEach var="row" items="${cp:DICTIONARY('yearList')}">
								<option value="${row.value}"
									<c:if test="${parameters.countYear[0] eq row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>  
				<td class="addTd" width="130">评测月份：</td>
					<td><select name="countMonth">
							<option value="">--请选择--</option>
					<c:forEach var="row" items="${cp:DICTIONARY('monthList')}">
								<option value="${row.value}"
									<c:if test="${parameters.countMonth[0] eq row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
					</tr>
				<tr>
				<td class="addTd" width="130">增减分类别:</td>
					
						<td ><select name="punishType" style="width: 180px" onchange="checkItemType()">
							<option value="">--请选择--</option>
					<c:forEach var="row" items="${cp:DICTIONARY('statType')}">
								<option value="${row.extracode}&${row.datatag}&${row.key}"
									<c:if test="${parameters.statType[0] eq row.extracode}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								
								</option>
	
							</c:forEach>
					</select><span style="color: red">*</span></td>
					<td class="addTd" width="130">部门名称：</td>
					<td align="left" colspan="3"><select name="orgId" style="width: 180px">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${unitList }">
								<option value="${row.depno}"
									<c:if test="${object.orgId eq row.depno}"> selected="selected"</c:if>>
									<c:out value="${row.unitname}" />
								</option>
							</c:forEach>
					</select></td>
					</tr>
			
			<%-- 	<tr id="charge_tr">
				<td class="addTd" width="130">用户名称：</td>
					<td align="left" colspan="3"><s:textfield name="userCode"
							size="40" value="%{object.userCode}" /></td>
				</tr> --%>
				
						<tr >
					<td class="addTd" width="130">增减分单项值</td>
					<td align="left" colspan="3" >
							<s:textfield name="punishUnit" size="40" id="punishUnit" onmouseout="javascript:dodisplay(this);"/>
						<span style="color: red">(根据选择的增减项类别自动获取增减分单项默认值)</span>	
						 </td>
						 </tr>
						 <tr id="tb2" >
						<td class="addTd" width="130">增减分数量</td>
					<td align="left" colspan="3">

				 <s:textfield name="punishCount"  size="40" id="punishCount" value="%{object.punishCount}" onmouseout="javascript:viewdisplay(this);"/>
                           <span style="color: red">(增减分数量初始值为1可改)</span>	


				</tr>
			
				 <tr id="tb1" style="display: none">
						<td class="addTd" width="130">增减分数量</td>
					<td align="left" colspan="3">
					<s:textfield  name="" size="40" value="1.0" disabled="true"/>
					                       
							<span style="color: red">(增减分数量初始值为1不可改)</span>	
					 </td>	 
				</tr> 
				 
				<tr>
					<td class="addTd" "width="130">增减分总值</td>
					<td align="left" colspan="3" ><s:textfield name="punishSum"
							size="40" id="punishSum" value="%{object.punishSum}" readonly="true"/>
						
				</tr>


				<tr>
					<td class="addTd" width="130">增减分原因说明</td>
					<td align="left" colspan="3"><s:textarea name="punishResion"
							value="%{object.punishResion}"/>
				</tr>
				<tr>
					<td class="addTd" width="130"><s:text
							name="pamonthpunish.recorder" /></td>
					<td align="left" ><input type="hidden" id="recorder" name="recorder"
								value="${object.recorder}" />
								<s:property value="%{object.recorder}" /></td>
					<td class="addTd" width="130"><s:text
							name="pamonthpunish.recordDate" /></td>
					<td align="left" colspan="3"><s:date name="recordDate"
							format="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>
				
			</table>

		</s:form>
	</fieldset>
	<script type="text/javascript">
	function checkItemType() {
		var statType = document.getElementById("punishType").value;
		var values=statType.split("&");//取type值 分割字符串
		var typevalue=values[0];//单项值
		var isinuse=values[1];//是否按项计算
		var num = document.getElementById("punishCount").value;
		var tb1= document.getElementById("tb1");
		var tb2= document.getElementById("tb2");
		if(isinuse=="T"){
			tb1.style.display = "none";
			tb2.style.display = "block";
		}else{
			tb1.style.display = "block";
			tb2.style.display = "none";
		} 

		if(statType != null){
			if(isinuse==""){//当为按项计算时punishCount默认为1
		        document.getElementById("punishCount").value=1;
		        document.getElementById("punishUnit").value=typevalue;
		        document.getElementById("punishSum").value=typevalue*1;
			}else{
				 document.getElementById("punishCount").value=num;
				 document.getElementById("punishUnit").value=typevalue;	
			     document.getElementById("punishSum").value=typevalue*num;
			}
		}
	}
	function viewdisplay(tt){
	//	var statType = document.getElementById("punishType").value;
	//	var values=statType.split("&");//取type值 分割字符串
	//	var typevalue=values[0];//单项值
		var value = document.getElementById("punishUnit").value;
 		var num = document.getElementById("punishCount").value;
	
	  document.getElementById("punishSum").value=value*num;//把值传到页面
	}
	function dodisplay(tt){
			var statType = document.getElementById("punishType").value;
			var values=statType.split("&");//取type值 分割字符串
			var isinuse=values[1];//是否按项计算
	 		var num = document.getElementById("punishCount").value;
			var value=document.getElementById("punishUnit").value;
	 		if(statType != null){
				if(isinuse==""){//当为按项计算时punishCount默认为1
			        document.getElementById("punishCount").value=1;
			        document.getElementById("punishUnit").value=value;
			        document.getElementById("punishSum").value=value*1;
				}else{
					 document.getElementById("punishCount").value=num;
				     document.getElementById("punishSum").value=value*num;
				}
			}
		
		}
	</script>
</body>
</html>
