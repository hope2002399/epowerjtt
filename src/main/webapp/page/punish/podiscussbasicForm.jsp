<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>

<html>
<meta name="decorator" content='${LAYOUT}'/>
<head>
<title>案件讨论与预先告知</title>
<sj:head locale="zh_CN" />
<script src="${pageContext.request.contextPath}/scripts/suggest.js" type="text/javascript"></script>
</head>

<body>
<%@ include file="/page/common/messages.jsp"%>

<s:form action="/punish/podiscussbasic"  styleId="podiscussbasicForm" onsubmit="return validatepodiscussbasicForm(this);">
	<input type="hidden" id="flowInstId" name="flowInstId" value="${flowInstId}" />
    <input type="hidden" id="djId" name="djId"  value="${djId}" />
    <input type="hidden" id="nodeInstId" name="nodeInstId" value="${nodeInstId}">  
<fieldset style=" display: block; padding: 10px;">
			<legend>
				<b>案件基本信息</b>
			</legend>	
	<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
	<tr>
		<td class="addTd"  width="20%" >案件编号</td>  <td align="left">
			<s:textfield name="punishobjectno" value="%{punishobjectbasic.punishobjectno}" /></td>
	    <td class="addTd" width="20%" >当事人</td> <td align="left">
			<%-- <s:textfield name="podiscussnoter" value="%{punishobjectbasic.podiscussnoter}" /></td> --%>
	</tr>
	<tr>
		<td class="addTd"  width="20%" >初核时间</td>  <td align="left">
			<s:textfield name="poregisterdate" value="%{punishobjectbasic.poregisterdate}" /></td>
	    <td class="addTd" width="20%" >案由</td> <td align="left">
			<s:textfield name="punishobjectbrief" value="%{punishobjectbasic.punishobjectbrief}" /></td>
	</tr>
	<tr>
		<td class="addTd" width="20%">处罚项目</td>	   
		<td align="left" colspan="3">
	<%-- <s:textarea value="%{punishobjectbasic.confirmtruth}" name="confirmtruth" style="width:60%;height:60px;"  />	 --%>
	<div align="right"><a
			href="<%=request.getContextPath() %>/POBasicList.do?action=showPunish&punishObjectID=${punishobjectbasic.punishobjectid}"
			target="_blank"><font color="blue">法律法规条款及自由裁量&gt;&gt;</font></a></div>
		</td>       
	</tr>
	</table>		
</fieldset>	
			
<fieldset style="padding:10px;display:block;margin-bottom:10px;">
   <legend style="padding:4px 8px 3px;"><b>案件讨论信息</b></legend>
<table border="0" cellpadding="0" cellspacing="0" class="viewTable">	
     <tr>
		<td class="addTd" width="20%" >开始时间</td>  <td align="left">
			<sj:datepicker id="podiscussbegintime" 
			name="podiscussbegintime"  style="width:140px"
			yearRange="2000:2020" timepickerFormat="hh:mm:ss" displayFormat="yy-mm-dd" changeYear="true"  timepicker="true"
			value="%{object.podiscussbegintime}"/></td>
	    <td class="addTd" width="20%" >结束时间</td> <td align="left"><sj:datepicker id="podiscussendtime" 
			name="podiscussendtime"  style="width:140px"
			yearRange="2000:2020" timepickerFormat="hh:mm:ss" displayFormat="yy-mm-dd" changeYear="true"  timepicker="true"
			value="%{object.podiscussendtime}"/></td>
	</tr>
 	<tr>
		<td class="addTd" width="20%"><font color="red"><strong>*&nbsp;</strong></font>讨论地点</td>	
		<td align="left" colspan="3">
	     <s:textarea value="%{object.podiscussadress}" name="podiscussadress" style="width:60%;height:20px;" />	
	</tr>
	<tr>
		<td class="addTd"  width="20%" >主持人</td>  <td align="left">
			<s:textfield name="podiscussemcee" value="%{object.podiscussemcee}" /></td>
	    <td class="addTd" width="20%" >记录人</td> <td align="left">
			<s:textfield name="podiscussnoter" value="%{object.podiscussnoter}" /></td>
	</tr>
	<tr>
		<td class="addTd" width="20%">参加人员</td>	
		<td align="left" colspan="3">
	<s:textarea value="%{object.podiscussattendname}" name="podiscussattendname" style="width:60%;height:20px;" />	
	</tr>
	<tr>
		<td class="addTd" width="20%">列席人员</td>	
		<td align="left" colspan="3">
	<s:textarea value="%{object.podiscussattendeename}" name="podiscussattendeename" style="width:60%;height:20px;" />	
	</tr>
	<tr>
		<td class="addTd" width="20%">认定违法事实</td>	
		<td align="left" colspan="3">
	<s:textarea value="%{object.confirmtruth}" name="confirmtruth" style="width:60%;height:60px;"  />	
	</tr>
	<tr>
		<td class="addTd" width="20%">其他违法条款</td>	
		<td align="left" colspan="3">
	<s:textarea value="%{object.disobeyitem}" name="disobeyitem" style="width:60%;height:60px;"  />	
	</tr>
	<tr>
		<td class="addTd" width="20%">处罚结论</td>	
		<td align="left" colspan="3">
	<s:textarea value="%{object.podiscussresult}" name="podiscussresult" style="width:60%;height:20px;"  />	
	</tr>
	<tr>
		<td class="addTd" width="20%">讨论记录</td>	
		<td align="left" colspan="3">
	<s:textarea value="%{object.podiscussrecored}" name="podiscussrecored" style="width:60%;height:20px;" />	
	</tr>
 	<tr>
 	     <td class="addTd" width="20%">是否风险点</td>
					<td align="left">  <s:radio   name="isriskbtn" id="isriskbtn" value="0" listKey="key" listValue="value"   list="#{'0':'否','1':'是'}" /></td> 
 
 
          <td class="addTd" width="20%">风险点类别</td>
					<td align="left">
					<s:textfield value="%{object.podiscussadress}" name="podiscussadress" style="width:60%;height:20px;" />	</td> 
 	</tr>
	<tr>
		<td class="addTd" width="20%">风险点描述</td>	
		<td align="left" colspan="3">
	        <s:textarea value="%{object.podiscussadress}" name="podiscussadress" style="width:60%;height:60px;" />	 
	</tr>
	<tr>
		<td class="addTd" width="20%">风险内控的<br>手段与结果</td>	
		   <td align="left" colspan="3">
	            <s:textarea value="%{object.podiscussadress}" name="podiscussadress" style="width:60%;height:60px;"  />	 
    </tr>
   
</table>
</fieldset>
	    <center style="margin-top: 10px;">
			<s:submit name="saveAndSubmit" method="submitOpt" cssClass="btn" value="提 交" />
			<s:submit name="save" method="saveOpt" cssClass="btn" value="保 存" />
			<input type="button" value="返回" class="btn"  onclick="window.history.go(-1);"/>	
		</center>
</s:form>
