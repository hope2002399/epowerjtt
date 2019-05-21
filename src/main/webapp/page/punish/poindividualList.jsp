<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html>
	<head>
		<title></title>
		<sj:head locale="zh_CN" />
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
				<div class="search">
		<div class="crumbs">办件处理</div>
			<s:form action="poindividual"  namespace="/punish" method="post" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">
				<tr>
					<td class="addTd"><c:out value="案件编号" />：<td>
						<s:textfield name="s_punishobjectid" /> </td>
					<td class="addTd"><c:out value="当事人姓名" />：<td>
						<s:textfield name="s_individualname" /> </td>

                     <td style="width: 5%">
                       <s:submit method="listvidual" key="opt.btn.query" value="查询" cssClass="btn" /> 
					</tr>
				</table>
			</s:form>
		</div>

			<ec:table action="poindividual.do" items="objList" var="poindividual"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
		 <input type="hidden" id="Name${poindividual.punishobjectid}" name="Name${poindividual.punishobjectid}" value="${poindividual.individualname}">
		 <input type="hidden" id="Sex${poindividual.punishobjectid}" name="Sex${poindividual.punishobjectid}" value="${poindividual.sex}">
		 <input type="hidden" id="Code${poindividual.punishobjectid}" name="Code${poindividual.punishobjectid}" value="${poindividual.individualcode}">
		 <input type="hidden" id="Phone${poindividual.punishobjectid}" name="Phone${poindividual.punishobjectid}" value="${poindividual.phone}">
		 <input type="hidden" id="Post${poindividual.punishobjectid}" name="Post${poindividual.punishobjectid}" value="${poindividual.postcode}">
		 <input type="hidden" id="Address${poindividual.punishobjectid}" name="Address${poindividual.punishobjectid}" value="${poindividual.individualadress}">
		 <input type="hidden" id="Workunit${poindividual.punishobjectid}" name="Workunit${poindividual.punishobjectid}" value="${poindividual.workunit}">

	
			<ec:row>

				<c:set var="tpunishobjectid">案件编号</c:set>	
				<ec:column property="punishobjectid" title="${tpunishobjectid}" style="text-align:center" sortable="false"/>

				<c:set var="tindividualid">人员编号</c:set>	
				<ec:column property="individualid" title="${tindividualid}" style="text-align:center" sortable="false"/>


				<c:set var="tindividualname">人员姓名</c:set>	
				<ec:column property="individualname" title="${tindividualname}" style="text-align:center" sortable="false"/>

				<c:set var="tsex">人员性别</c:set>	
				<ec:column  property="sex" title="${tsex}" style="text-align:center" sortable="false">
 ${cp:MAPVALUE("sex",poindividual.sex)}
				</ec:column>

				<c:set var="tage">人员年龄</c:set>	
				<ec:column property="age" title="${tage}" style="text-align:center" sortable="false"/>

				<c:set var="tphone">联系电话</c:set>	
				<ec:column property="phone" title="${tphone}" style="text-align:center" sortable="false"/>
                <ec:column property="opt" title="选择" sortable="false"
				style="text-align:center">
				<input type="radio" name="itemId"
					onclick="setParentVal('${poindividual.punishobjectid}')">
			</ec:column>
			</ec:row>
		</ec:table>

	</body>
	<script type="text/javascript">
	//获取父页面对象
	var parentDocument = window.opener.document;
	
	
	//设置返回值
	function setParentVal(punishobjectid) {
		if (window.confirm("确认选择此当事人吗")) {		
				parentDocument.getElementById('indname').value = document
						.getElementById('Name' + punishobjectid).value;
				parentDocument.getElementById('indsex').value = document
				.getElementById('Sex' + punishobjectid).value;	
				parentDocument.getElementById('indcode').value = document
				.getElementById('Code' + punishobjectid).value;	
				parentDocument.getElementById('indphone').value = document
				.getElementById('Phone' + punishobjectid).value;	
				parentDocument.getElementById('indpost').value = document
				.getElementById('Post' + punishobjectid).value;	
				parentDocument.getElementById('indaddress').value = document
				.getElementById('Address' + punishobjectid).value;	
				parentDocument.getElementById('indworkunit').value = document
				.getElementById('Workunit' + punishobjectid).value;	
			window.close();
		}
	}
</script>
</html>
