<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<sj:head locale="zh_CN" />
</head>
<body>
<%@ include file="/page/common/messages.jsp"%>
<s:form name="podetainwptransinfoForm" action="podetainwptransinfo" method="post" namespace="/punish" id="podetainwptransinfoForm" target="_self">
		<s:submit name="back" method="list" cssClass="btn" key="返回"/>
		<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
	<tr>
		<td class="addTd" width="130">物品名称</td>
		<td align="left"><s:text  name="object.wpname" /></td>
	</tr>
	<tr>
		<td class="addTd" width="130">所属办件</td>
		<td align="left"><s:text  name="object.punishobjectid" /></td>
	</tr>
	
	<tr>
		<td class="addTd" width="130">当前位置</td>
		<td align="left">${object.wpcurrentlocation}</td>
	</tr>
	
	<tr>
		<td class="addTd" width="130">物品类型</td>
		<td align="left">${cp:MAPVALUE("wptype",object.wptype)} </td>
	</tr>
	
		<tr>
		<td class="addTd" width="130">物品状态 </td>
		<td align="left">${cp:MAPVALUE("wpstate",object.wptype)} </td>
	</tr>
	    
	<c:forEach var="transobj" items="${podetainwptransinfosforshow}" varStatus="status">
	<tr>			                  
		<td id="id1" class="addTd" width="130">流转信息</td>
		

		
			
		<td align="left" title="操作人:${cp:MAPVALUE('usercode',transobj.optperson)}--操作时间:${transobj.optdate}">
		<c:choose>
		<c:when test="${transobj.opttype==0}">
		新增
		</c:when>
		<c:when test="${transobj.opttype==1}">
		移交
		</c:when>
		<c:when test="${transobj.opttype==2}">
		<font color="red">归还</font>
		</c:when>
		<c:when test="${transobj.opttype==3}">
		<font color="red">遗失</font>
		</c:when>
		<c:when test="${transobj.opttype==4}">
		<font color="red">销毁</font>
		</c:when>
		</c:choose>
		(${status.index+1}):${transobj.receivedate} 
		
		<c:if test="${transobj.opttype==0}">
		<Strong>新增${cp:MAPVALUE("wptype",object.wptype)}:</Strong>${object.wpname};<Strong>接收人员:</Strong>${transobj.receiveperson};<Strong>对方确认人:</Strong>${transobj.transperson};
		<c:if test="${transobj.remark ne null}">
		(备注:${transobj.remark});
		</c:if>
		<Strong>接收地点:</Strong>:${object.receivelocation};
		<Strong>移交至</Strong>:${transobj.translocation};
		</c:if>
		
		<c:if test="${transobj.opttype==1}">
		<Strong>移交人员:</Strong>${transobj.transperson};<Strong>接收人员:</Strong>${transobj.receiveperson};
		<c:if test="${transobj.remark ne null}">
		(备注:${transobj.remark});
		</c:if>
		<Strong>移交至:</Strong>${transobj.translocation};
		</c:if>
		
		<c:if test="${transobj.opttype==2}">
		<Strong>归还人员:</Strong>${transobj.transperson};<Strong>接收人员:</Strong>${transobj.receiveperson};
		<c:if test="${transobj.remark ne null}">
		(备注:${transobj.remark});
		</c:if>
		<Strong>归还至:</Strong>${transobj.translocation};
		</c:if>
		
		<c:if test="${transobj.opttype==3}">
        <c:if test="${transobj.transperson ne null}">
		<Strong>遗失人员</Strong>:${transobj.transperson};
		</c:if>
		<c:if test="${transobj.translocation ne null}">
		<Strong>于</Strong>:${transobj.translocation};
		</c:if>
		<c:if test="${transobj.remark ne null}">
		(备注:${transobj.remark});
		</c:if>
		遗失
		</c:if>
		
		<c:if test="${transobj.opttype==4}">
		<c:if test="${transobj.transperson ne null}">
		由<Strong>销毁人员</Strong>:${transobj.transperson};
		</c:if>
		<c:if test="${transobj.translocation ne null}">
		<Strong>于</Strong>:${transobj.translocation});
		</c:if>
		<c:if test="${transobj.remark ne null}">
		(备注:${transobj.remark});
		</c:if>
		销毁
		</c:if>

		</td>
	</tr>
	</c:forEach>
	
		</table>
</s:form>
</body>
<script language="JavaScript" type="text/JavaScript">
coalesce_row(document.all.id1,1,0, 'null');
function   coalesce_row(obj,s,n,text){ 
var   text;
table=obj; 
for   (i=n;i <table.length;i++){ 
if (table(i).innerHTML==text){ 
s =s+1; 
table(i-1).rowSpan=s;
table(i).removeNode(true); 
coalesce_row(obj,s,i,table(i-1).innerHTML); 
return   this; 
}else{ 
s=1;
} 
text=table(i).innerHTML; 
} 
} 
</script>
</html>