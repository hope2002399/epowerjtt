<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>

<html>
<head>
<title></title>
</head>

<body>

<%@ include file="/page/common/messages.jsp"%>
 <input id="isPctype" type="hidden" name="isPctype" value="${isPctype}" >
 
<c:if test="${isPctype eq 1}">	
	
<ec:table action="pcfreeumpiretype!list.do" items="PcfreeumpiretypeList" var="pcfreeumpiretype"
			imagePath="${STYLE_PATH}/images/table/*.gif" showPagination="false" showStatusBar="false" showTitle="false">
			
			<ec:row>
               <c:set var="tpunishtypeid">处罚种类</c:set>	
				   <c:forEach var="row" items="${cp:DICTIONARY('punishType')}">
						<c:if test="${pcfreeumpiretype.punishtypeid eq row.key}">
						<c:set var="punishtypename" value="${row.value}" />
						</c:if>
					</c:forEach>
				<ec:column property="punishtypeid" title="${tpunishtypeid}" style="text-align:center" sortable="false" >
				<a href='#' onclick="parent.frames['edit'].location='pcfreeumpiretype!edit.do?punishclassid=${pcfreeumpiretype.punishclassid}&punishtypeid=${pcfreeumpiretype.punishtypeid}&degreeno=${pcfreeumpiretype.degreeno}&isPctype=1&isEdit=1'">
			
                 <c:out value="${punishtypename}"/>
                  </a>
                </ec:column>
		
				<c:set var="tpunishmin">处罚下限</c:set>	
				<ec:column property="punishmin" title="${tpunishmin}" style="text-align:center" sortable="false"/>

				<c:set var="tpunishmax">处罚上限</c:set>	
				<ec:column property="punishmax" title="${tpunishmax}" style="text-align:center" sortable="false" />


				<c:set var="tpunishcontent">处罚内容 </c:set>	
				<ec:column property="punishcontent" title="${tpunishcontent}" style="text-align:center" sortable="false"/>

				<c:set var="tpunishmax">备注</c:set>	
				<ec:column property="opt" title="${tpunishmax}" style="text-align:center" sortable="false">
				     <c:if test="${pcfreeumpiretype.israte==1}">按比例计算</c:if>
				</ec:column>

				<c:set var="optlabel">操作</c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false" style="text-align:center">
					<a href='#'  onclick="IsInUse('${pcfreeumpiretype.punishclassid}','${pcfreeumpiretype.punishtypeid}','${pcfreeumpiretype.degreeno}','${isPctype}');">
					  <c:if test="${pcfreeumpiretype.isinuse==1}">禁止</c:if>
				      <c:if test="${pcfreeumpiretype.isinuse==0}">启用</c:if>
					</a>
					<a href='pcfreeumpiretype!delete.do?punishclassid=${pcfreeumpiretype.punishclassid}&punishtypeid=${pcfreeumpiretype.punishtypeid}&degreeno=${pcfreeumpiretype.degreeno}&isPctype=1'>
					删除</a>
				</ec:column>

			</ec:row>
		</ec:table>
	
</c:if>
<c:if test="${isPctype eq 0}">	
	<ec:table action="pcfreeumpiretype!list.do" items="PcfreeumpiretypeList" var="pcfreeumpiretype"
			imagePath="${STYLE_PATH}/images/table/*.gif" showPagination="false" showStatusBar="false" showTitle="false">
			<ec:row>
                
				<c:set var="tdegreeNo">编号</c:set>	
				<ec:column property="degreeno" title="${tdegreeNo}" style="text-align:center" sortable="false" />

				<c:set var="tpunishfactgrade">违法事实程度 </c:set>	
				<ec:column property="punishfactgrade" title="${tpunishfactgrade}" style="text-align:center" sortable="false" >
	            <a href='#' onclick="parent.frames['edit'].location='pcfreeumpiretype!edit.do?punishclassid=${pcfreeumpiretype.punishclassid}&punishtypeid=${pcfreeumpiretype.punishtypeid}&degreeno=${pcfreeumpiretype.degreeno}&isPctype=0&isEdit=1'">
				<c:out value="${pcfreeumpiretype.punishfactgrade}" />
				</a>
				</ec:column>
				
				<c:set var="optlabel">操作</c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"  style="text-align:center">
				<a href='#' onclick="IsInUse('${pcfreeumpiretype.punishclassid}','${pcfreeumpiretype.punishtypeid}','${pcfreeumpiretype.degreeno}','${isPctype}');">
				  <c:if test="${pcfreeumpiretype.isinuse==1}">禁止</c:if>
				  <c:if test="${pcfreeumpiretype.isinuse==0}">启用</c:if>
				</a>
					<a href='pcfreeumpiretype!delete.do?punishclassid=${pcfreeumpiretype.punishclassid}&punishtypeid=${pcfreeumpiretype.punishtypeid}&degreeno=${pcfreeumpiretype.degreeno}&isPctype=0'>
					删除</a>
				</ec:column>

			</ec:row>
		</ec:table>
</c:if>
</body>

<script>

function IsInUse(punishclassid,punishtypeid,degreeno,isPctype){
	var url="punish/pcfreeumpiretype!editIsInUse.do?punishclassid="+ punishclassid+"&punishtypeid="+punishtypeid+"&degreeno="+degreeno+"&isPctype="+isPctype;
	   document.location.href = url;
}   

/* function returnEdit(){
	   window.parent.frames['edit'].document.forms[0].submit();
 } */

</script>
</html>
