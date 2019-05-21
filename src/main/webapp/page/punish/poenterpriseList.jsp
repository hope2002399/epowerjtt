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
		<fieldset
			style="border: hidden 1px #000000; ">
			<legend>
				 <s:text name="label.list.filter" />
			</legend>
			<s:form  action="poenterprise" namespace="/punish" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">

					<tr height="22">
						<td><c:out value="案件编号" />:</td>
						<td><s:textfield name="s_punishobjectid" /> </td>
					</tr>	
					<tr height="22">
						<td><c:out value="机构名称" />:</td>
						<td><s:textfield name="s_enterprisename" /> </td>
						 <td><s:submit method="list"  key="查询" cssClass="btn"/></td>
						 <td align="center" colspan="2"><input type="button"
						class="btn" value="关闭" onclick="window.close();"></td>
					</tr>	

					
				</table>
			</s:form>
		</fieldset>

			<ec:table action="poenterprise.do" items="objList" var="poenterprise"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
		 <input type="hidden" id="Name${poenterprise.punishobjectid}" name="Name${poenterprise.punishobjectid}" value="${poenterprise.enterprisename}">
		 <input type="hidden" id="Code${poenterprise.punishobjectid}" name="Code${poenterprise.punishobjectid}" value="${poenterprise.enterprisecode}">
		 <input type="hidden" id="Master${poenterprise.punishobjectid}" name="Master${poenterprise.punishobjectid}" value="${poenterprise.mastername}">
		 <input type="hidden" id="Unittype${poenterprise.punishobjectid}" name="Unittype${poenterprise.punishobjectid}" value="${poenterprise.unittype}">
		 <input type="hidden" id="Address${poenterprise.punishobjectid}" name="Address${poenterprise.punishobjectid}" value="${poenterprise.enterpriseaddress}">
		 <input type="hidden" id="Fax${poenterprise.punishobjectid}" name="Fax${poenterprise.punishobjectid}" value="${poenterprise.fax}">
		 <input type="hidden" id="Linker${poenterprise.punishobjectid}" name="Linker${poenterprise.punishobjectid}" value="${poenterprise.linker}">
		 <input type="hidden" id="Phone${poenterprise.punishobjectid}" name="Phone${poenterprise.punishobjectid}" value="${poenterprise.phone}">
		 <input type="hidden" id="Post${poenterprise.punishobjectid}" name="Post${poenterprise.punishobjectid}" value="${poenterprise.postcode}">
	
			<ec:row>

				<c:set var="tpunishobjectid">案件编号</c:set>	
				<ec:column property="punishobjectid" title="${tpunishobjectid}" style="text-align:center" />

				<c:set var="tenterpriseid">机构代码</c:set>	
				<ec:column property="enterpriseid" title="${tenterpriseid}" style="text-align:center" />

				<c:set var="tenterprisename">机构名称</c:set>	
				<ec:column property="enterprisename" title="${tenterprisename}" style="text-align:center" />

				<c:set var="tmastername">负责人名称</c:set>	
				<ec:column property="mastername" title="${tmastername}" style="text-align:center" />

				<c:set var="tphone">联系电话</c:set>	
				<ec:column property="phone" title="${tphone}" style="text-align:center" />
	
                <ec:column property="opt" title="选择" sortable="false"
				style="text-align:center">
				<input type="radio" name="itemId"
					onclick="setParentVal('${poenterprise.punishobjectid}')">
					</ec:column>

			</ec:row>
		</ec:table>

	</body>
		<script type="text/javascript">
	//获取父页面对象
	var parentDocument = window.opener.document;
	//设置返回值
	function setParentVal(punishobjectid) {
		if (window.confirm("确认选择此组织机构吗")) {		
				parentDocument.getElementById('entname').value = document
				.getElementById('Name' + punishobjectid).value;
				parentDocument.getElementById('entcode').value = document
				.getElementById('Code' + punishobjectid).value;	
				parentDocument.getElementById('entmaster').value = document
				.getElementById('Master' + punishobjectid).value;	
				parentDocument.getElementById('entunittype').value = document
				.getElementById('Unittype' + punishobjectid).value;	
				parentDocument.getElementById('entaddress').value = document
				.getElementById('Address' + punishobjectid).value;	
				parentDocument.getElementById('entfax').value = document
				.getElementById('Fax' + punishobjectid).value;	
				parentDocument.getElementById('entlinker').value = document
				.getElementById('Linker' + punishobjectid).value;
				parentDocument.getElementById('entphone').value = document
				.getElementById('Phone' + punishobjectid).value;	
				parentDocument.getElementById('entpost').value = document
				.getElementById('Post' + punishobjectid).value;	
			window.close();
		}
	}
</script>
</html>
