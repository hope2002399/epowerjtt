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
		<div class="crumbs">查询条件</div>
			<s:form action="/punish/appindividual!list.do" >
				<table>
					<tr>
						<td class="addTd"><c:out value="当事人姓名" />：<td>
					<s:textfield name="s_individualname" /> </td>
                        <td style="width:15%" align="left"><s:submit method="list"  key="opt.btn.query" cssClass="btn"/></td>
					</tr>
				</table>
			</s:form>
		</div>

			<ec:table action="appindividual!list.do" items="objList" var="appindividual"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
		 <input type="hidden" id="Indid${appenterprise.individualid}" name="Indid${appindividual.individualid}" value="${appindividual.individualid}">
		 <input type="hidden" id="Name${appindividual.individualid}" name="Name${appindividual.individualid}" value="${appindividual.individualname}">
		 <input type="hidden" id="Sex${appindividual.individualid}" name="Sex${appindividual.individualid}" value="${appindividual.sex}">
		 <input type="hidden" id="Code${appindividual.individualid}" name="Code${appindividual.individualid}" value="${appindividual.individualcode}">
		 <input type="hidden" id="Phone${appindividual.individualid}" name="Phone${appindividual.individualid}" value="${appindividual.phone}">
		 <input type="hidden" id="Post${appindividual.individualid}" name="Post${appindividual.individualid}" value="${appindividual.postcode}">
		 <input type="hidden" id="Address${appindividual.individualid}" name="Address${appindividual.individualid}" value="${appindividual.individualadress}">
		 <input type="hidden" id="Workunit${appindividual.individualid}" name="Workunit${appindividual.individualid}" value="${appindividual.workunit}">
		 <input type="hidden" id="Age${appindividual.individualid}" name="Age${appindividual.individualid}" value="${appindividual.age}">
	
			<ec:row>
				<c:set var="tindividualid">人员编号</c:set>	
				<ec:column property="individualid" title="${tindividualid}" style="text-align:center" sortable="false"/>


				<c:set var="tindividualname">人员姓名</c:set>	
				<ec:column property="individualname" title="${tindividualname}" style="text-align:center" sortable="false"/>

				<c:set var="tsex">人员性别</c:set>	
				<ec:column  property="sex" title="${tsex}" style="text-align:center" sortable="false">
					${cp:MAPVALUE("sex",appindividual.sex)}
				</ec:column>

				<c:set var="tage">人员年龄</c:set>	
				<ec:column property="age" title="${tage}" style="text-align:center" sortable="false"/>

				<c:set var="tphone">联系电话</c:set>	
				<ec:column property="phone" title="${tphone}" style="text-align:center" sortable="false"/>
                <ec:column property="opt" title="选择" sortable="false"
				style="text-align:center">
				<input type="radio" name="itemId"
					onclick="setParentVal('${appindividual.individualid}')">
			</ec:column>
			</ec:row>
		</ec:table>

	</body>
	<script type="text/javascript">
	//获取父页面对象
	var parentDocument = window.opener.document;
	//设置返回值
	function setParentVal(individualid) {
		if (window.confirm("确认选择此当事人吗")) {		
			parentDocument.getElementById('indid').value = document
			.getElementById('Indid' + individualid).value;

				parentDocument.getElementById('indname').value = document
						.getElementById('Name' + individualid).value;
				parentDocument.getElementById('indsex').value = document
				.getElementById('Sex' + individualid).value;	
				parentDocument.getElementById('indcode').value = document
				.getElementById('Code' + individualid).value;	
				parentDocument.getElementById('indphone').value = document
				.getElementById('Phone' + individualid).value;	
				parentDocument.getElementById('indpost').value = document
				.getElementById('Post' + individualid).value;	
				parentDocument.getElementById('indaddress').value = document
				.getElementById('Address' + individualid).value;	
				parentDocument.getElementById('indworkunit').value = document
				.getElementById('Workunit' + individualid).value;	
				parentDocument.getElementById('age').value = document
				.getElementById('Age' + individualid).value;	
			window.close();
		}
	}
</script>
</html>
