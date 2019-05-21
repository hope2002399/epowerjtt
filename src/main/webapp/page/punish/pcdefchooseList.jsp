<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html>
<head>
<title></title>
<sj:head locale="zh_CN" />
</head>
<body>
<s:form name="poindagaterepbasicForm" action="poindagaterepbasic" method="post" namespace="/punish" id="poindagaterepbasicForm" target="_parent" onsubmit="return checkForm();">
<input type="hidden" id="flowInstId" name="flowInstId" value="${flowInstId}" />
<input type="hidden" id="djId" name="djId"  value="${object.punishobjectid}" />
<input type="hidden" id="nodeInstId" name="nodeInstId" value="${nodeInstId}">
<input type="hidden" id="punishobjectid" name="punishobjectid" value="${object.punishobjectid}">
<input type="hidden" name="s_orgId" value="${session.SPRING_SECURITY_CONTEXT.authentication.principal.primaryUnit}">
<input type="hidden" name="s_itemType" value="${itemType}">	
<input type="hidden" name="itemType" value="${itemType}">
<%@ include file="/page/common/messages.jsp"%>		
<fieldset style="border: hidden 1px #000000;">
		<legend>
			查询条件
		</legend>
			<table cellpadding="0" cellspacing="0" align="center">
				<tr>
					<td class="addTd">权力编码:</td>
					<td>
					<s:textfield name="s_itemId" style="width:180px"  /></td>
				</tr>
				<tr>
					<td class="addTd">权力名称:</td>
					<td>
					<s:textfield name="s_itemName" style="width:180px" /></td>
				</tr>

				<tr>
					<td align="center" colspan="2">
					<s:submit method="addpunishlist" key="opt.btn.query" cssClass="btn" /> 
					<input type="button" class="btn" value="关闭" onclick="window.close();">
					</td>
				</tr>
			</table>

	</fieldset>
		
						</s:form>
				
				<ec:table action="punish/poindagaterepbasic!addpunishlist.do" items="selectPowerList" var="pcdef"
		imagePath="${STYLE_PATH}/images/table/*.gif"
		retrieveRowsCallback="limit">	
		<ec:row>			
			<ec:column property="itemId" title="权力编码"	style="text-align:center" sortable="false"/>
			<ec:column property="itemName" title="权力名称"	style="text-align:center" sortable="false">	
				<c:choose>
					<c:when test="${fn:length(pcdef.itemName) > 20}">
						<c:out value="${fn:substring(pcdef.itemName, 0, 20)}..." />
					</c:when>
					<c:otherwise>
						<c:out value="${pcdef.itemName}" />
					</c:otherwise>
				</c:choose>
			</ec:column>
			<ec:column property="punishbasis" title="法律依据" style="text-align:center" sortable="false">
			<c:choose>
					<c:when test="${fn:length(pcdef.punishbasis) > 20}">
						<c:out value="${fn:substring(pcdef.punishbasis, 0, 20)}..." />
					</c:when>
					<c:otherwise>
						<c:out value="${pcdef.punishbasis}" />
					</c:otherwise>
				</c:choose>
			</ec:column>
			<ec:column property="punishobject" title="处罚对象"	style="text-align:center" sortable="false">
			 <c:if test="${pcdef.punishobject==0}">个人</c:if>
		     <c:if test="${pcdef.punishobject==1}">机构</c:if>
		     <c:if test="${pcdef.punishobject==2}">个人、机构</c:if>
			</ec:column>
			<ec:column property="opt" title="操作" sortable="false"
				style="text-align:center">
				<input type="radio" onclick="addlist('${pcdef.itemId}')">

			</ec:column>
		</ec:row>
	</ec:table>
		
				
				
</body>

<script type="text/javascript">

function confirm_check(punishobjectid){
	if(window.confirm("确实删除此["+punishobjectid+"]案件?")){
		document.location.href ='punish/punishobjectbasic!delete.do?punishobjectid='+punishobjectid;
	}	
}
function addlist(itemid){
	var parentDocument = window.opener.document;
	var nodeinstid="${nodeInstId}";
	var flowinstid="${flowInstId}";
	var punishobjectid="${object.punishobjectid}";
	if(window.confirm("确实添加"+itemid+"?")){
		var href="punish/poindagaterepbasic!saveTransLaw.do?optProcInfo.ideacode=T&punishobjectid="+punishobjectid+"&item_id="+itemid+"&nodeInstId="+nodeinstid+"&flowInstId="+flowinstid+"&poindagaterepstate=0";
		window.close();
		parentDocument.location.href =href;
	}
}

var _get = function (id) {
	return document.getElementById(id);
};



</script>

</html>
