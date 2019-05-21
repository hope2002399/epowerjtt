<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html>
	<head>
	<base target='_self'>
	   <sj:head locale="zh_CN"/>
		<title>
			复议
		</title>
	</head>
	<body >
	
		<%@ include file="/page/common/messages.jsp"%>
		<div class="search">
			<div class="crumbs">
				复议
			</div>	
			<s:form id="thisform" action="reconsider" namespace="/supervise" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">
				<tr>
	<td class="addTd">办件编号:</td><td><s:textfield name="s_internalNo" /> </td>
	
	<td class="addTd">权力编码:</td><td><s:textfield name="s_itemId" /> </td>	
	<td class="addTd">办件类型:</td><td>
	<s:radio theme="simple" value="%{object.suptype}" listKey="key" listValue="value"  id="suptype2" name="suptype"  list="#{'apply':'许可','punish':'处罚'}" /> </td>
					</tr>
					<tr>
					<td class="addTd">开始时间:</td><td>
			<sj:datepicker 
				name="s_begFinishTime"  style="width:160px;"
				yearRange="2000:2020"  displayFormat="yy-mm-dd" changeYear="true"  timepicker="false" /></td>
				<td class="addTd">结束时间:</td><td>
			  <sj:datepicker 
				name="s_endFinishTime"  style="width:160px;"
				yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true"  timepicker="false" /></td>
				<td align="right" class="addTd">
							<s:submit method="listsup"  key="opt.btn.query" cssClass="btn"/>
						</td>
				</tr>
				</table>
</s:form></div>
	<c:if test="${suptype=='apply'}">
		<ec:table action="supervise/reconsider!listsup.do" items="vapplyforList" var="apply"  
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
		<ec:column property="internalNo" title="办件编号" style="text-align:center" />
		
			<ec:column property="transactAffairName" title="办件名称" style="text-align:center;width:40%" >
				<c:choose>
					<c:when test="${fn:length(apply.transactAffairName) > 30}">
						<c:out value="${fn:substring(apply.transactAffairName, 0, 30)}..." />
					</c:when>
					<c:otherwise>
						<c:out value="${apply.transactAffairName}" />
					</c:otherwise>
				</c:choose>
			</ec:column>
			<ec:column property="itemId" title="权力编码" style="text-align:center" />
				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">
					<input type="radio" onclick="addlist2('${apply.no}','1','${apply.internalNo}')">
				</ec:column>
			</ec:row>
		</ec:table>
</c:if>
		<c:if test="${suptype=='punish'}">
		<ec:table  action="supervise/reconsider!listsup.do" items="punishresultlist" var="punish" 
					imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>		
				<ec:column property="internalNo" title="办件编号" style="text-align:center" />
				<ec:column property="content" title="处罚名称" style="text-align:center;width:40%" />
				<ec:column property="itemId" title="权力编码" style="text-align:center" />
				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">
<input type="radio" onclick="addlist2('${punish.no}','2','${punish.internalNo}')">
				</ec:column>

			</ec:row>
		</ec:table>
		</c:if>
	</body>
	<script type="text/javascript">	
	function addlist(no,orgid,content,itemid){
		var bjType="${suptype}";
		if(bjType=="apply"){
			bjType="1";
		}else if(bjType=="punish"){		
			bjType="2";
		}
		var parentDocument = window.opener.document;	
	    var contextpath="${pageContext.request.contextPath}";
	    var id=document.getElementById("reconsiderid").value;
		var href=contextpath+"/supervise/reconsider!edit.do?bjType="+bjType+"&bjNo="+no+"&optId=reconsider&reconsiderid="+id;
		//alert(href);
		window.close();
		parentDocument.location.href=href;
	
	}
	function addlist2(bjno,type,internalno){
		 var id=bjno+"@"+type+"@"+internalno;
		 window.returnValue = id;
		 var parentDocument = window.opener.document;
		 parentDocument.getElementById("bjNo").value = bjno;
		 parentDocument.getElementById("bjType").value = type;
		 parentDocument.getElementById("internalNo").value = internalno;
		 window.close();
	}
	</script>
</html>
