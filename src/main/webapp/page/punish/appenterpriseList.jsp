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
			<s:form  action="appenterprise" namespace="/punish" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">
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

			<ec:table action="appenterprise.do" items="objList" var="appenterprise"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
		 <input type="hidden" id="Entid${appenterprise.enterpriseid}" name="Entid${appenterprise.enterpriseid}" value="${appenterprise.enterpriseid}">
		 <input type="hidden" id="Name${appenterprise.enterpriseid}" name="Name${appenterprise.enterpriseid}" value="${appenterprise.enterprisename}">
		 <input type="hidden" id="Code${appenterprise.enterpriseid}" name="Code${appenterprise.enterpriseid}" value="${appenterprise.enterprisecode}">
		 <input type="hidden" id="Master${appenterprise.enterpriseid}" name="Master${appenterprise.enterpriseid}" value="${appenterprise.mastername}">
		 <input type="hidden" id="Unittype${appenterprise.enterpriseid}" name="Unittype${appenterprise.enterpriseid}" value="${appenterprise.unittype}">
		 <input type="hidden" id="Address${appenterprise.enterpriseid}" name="Address${appenterprise.enterpriseid}" value="${appenterprise.enterpriseaddress}">
		 <input type="hidden" id="Fax${appenterprise.enterpriseid}" name="Fax${appenterprise.enterpriseid}" value="${appenterprise.fax}">
		 <input type="hidden" id="Linker${appenterprise.enterpriseid}" name="Linker${appenterprise.enterpriseid}" value="${appenterprise.linker}">
		 <input type="hidden" id="Phone${appenterprise.enterpriseid}" name="Phone${appenterprise.enterpriseid}" value="${appenterprise.phone}">
		 <input type="hidden" id="Post${appenterprise.enterpriseid}" name="Post${appenterprise.enterpriseid}" value="${appenterprise.postcode}">
	
			<ec:row>
				<c:set var="tenterpriseid">机构代码</c:set>	
				<ec:column property="enterpriseid" title="${tenterpriseid}" style="text-align:center" />

				<c:set var="tenterprisename">机构名称</c:set>	
				<ec:column property="enterprisename" title="${tenterprisename}" style="text-align:center" />
				
				<c:set var="tunittype">机构性质${appenterprise.enterpriseid}</c:set>	
				<ec:column property="unittype" title="${tunittype}" style="text-align:center" >${cp:MAPVALUE("UnitType4CF",appenterprise.unittype)}</ec:column>

				<c:set var="tmastername">负责人名称</c:set>	
				<ec:column property="mastername" title="${tmastername}" style="text-align:center" />

				<c:set var="tphone">联系电话</c:set>	
				<ec:column property="phone" title="${tphone}" style="text-align:center" />
	
                <ec:column property="opt" title="选择" sortable="false"
				style="text-align:center">
				<input type="radio" name="itemId"
					onclick="setParentVal('${appenterprise.enterpriseid}')">
					</ec:column>

			</ec:row>
		</ec:table>

	</body>
		<script type="text/javascript">
	//获取父页面对象
	var parentDocument = window.opener.document;
	//设置返回值
	function setParentVal(enterpriseid) {
		if (window.confirm("确认选择此组织机构吗")) {
			parentDocument.getElementById('entid').value = document
			.getElementById('Entid' + enterpriseid).value;

				parentDocument.getElementById('entname').value = document
				.getElementById('Name' + enterpriseid).value;
		
				parentDocument.getElementById('entcode').value = document
				.getElementById('Code' + enterpriseid).value;	

				parentDocument.getElementById('entmaster').value = document
				.getElementById('Master' + enterpriseid).value;	
	
				parentDocument.getElementById('entunittype').value = document
				.getElementById('Unittype' + enterpriseid).value;	
	
				parentDocument.getElementById('entaddress').value = document
				.getElementById('Address' + enterpriseid).value;	

				parentDocument.getElementById('entfax').value = document
				.getElementById('Fax' + enterpriseid).value;	
				parentDocument.getElementById('entlinker').value = document
				.getElementById('Linker' + enterpriseid).value;
				parentDocument.getElementById('entphone').value = document
				.getElementById('Phone' + enterpriseid).value;	
				parentDocument.getElementById('entpost').value = document
				.getElementById('Post' + enterpriseid).value;	
		
			window.close();
		}
	}
</script>
</html>
