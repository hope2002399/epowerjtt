<%@ page contentType="text/html;charset=UTF-8"  import="java.util.*" %>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title>办理信息</title>
</head>
<body>
<s:form action="" method="post" namespace="/punish" id="generalOperatorForm" target="_parent">

<fieldset style=" display: block; padding: 10px;">
			<legend>
				<b>案件基本信息</b>
			</legend>
			<table border="0" cellpadding="0" cellspacing="0" id="tb" class="viewTable" style="margin-top: 20px;">			
					<tr>
					<td class="addTd" width="140">案件编号</td>
					<td align="left">
					${object.punishobjectno}
					</td>
			
					<td class="addTd">当事人</td>
					<td align="left">${object.pocaseimpeachname}</td>
					</tr>		
				<tr>
					<td class="addTd">初核时间</td>
					<td align="left">
					<s:date name="poregisterdate" format="yyyy-MM-dd HH:mm:ss"/>
					</td>			
					<td class="addTd">案由</td>
					<td align="left">
					${cp:MAPVALUE("anyou",object.punishobjectbrief)}
					</td>
				</tr>
				
		<c:if test="${not empty  object.item_id}">
			<tr>
			<td class="addTd">处罚项目</td>
					<td align="left" colspan="3">${object.itemName}
					</td>	
					
			</tr>
			</c:if>
			
				<c:if test="${not empty  object.poIndagateRepResult }">
			<tr>
			<td class="addTd">
			<c:if test="${not empty flagFrame}">初步处罚意见</c:if>
			<c:if test="${empty flagFrame}">最终处罚意见</c:if>
			</td>
					<td align="left" colspan="3">${object.poIndagateRepResult}
					</td>	
					
			</tr>
			</c:if>	
		       		
			</table>
		</fieldset>
		</s:form>		
</body>
</html>