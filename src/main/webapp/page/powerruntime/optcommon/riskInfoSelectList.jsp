<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title>
			风险点管理
		</title>
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<div class="search">
			<div class="crumbs">
				风险点管理
			</div>
			
			<s:form action="riskInfo" namespace="/powerruntime" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">
	<tr >
						<td class="addTd">风险点类别:</td>
						<td>
						<select name="s_risktype" style="width:180px">
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('RISKTYPE')}">
									<option value="${row.key}"
									>
									<c:out value="${row.value}" /></option>
								</c:forEach>
						</select>
						</td>
					</tr>
					<tr >
						<td class="addTd">风险点描述:</td>
						<td class="addTd"><s:textfield name="s_riskdes" style="width:180px"/></td>
					    <td class="addTd">
							<s:submit method="listSelect"  key="opt.btn.query" cssClass="btn"/>
						<input type="button" class="btn" value="关闭" onclick="window.close();">
						</td>
					</tr>	
				</table>
			</s:form>
		</div>
		<ec:table action="powerruntime/riskInfo!listSelect.do" items="objList" var="riskInfo"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit">
			<input type="hidden" id="riskid${riskInfo.riskid}" name="itemId${riskInfo.riskid}" value="${riskInfo.riskid}" >
			<input type="hidden" id="riskdes${riskInfo.riskid}" name="riskdes${riskInfo.riskid}" value="${riskInfo.riskdes}" >
			
			<ec:row>			

				<c:set var="trisktype" >风险点类别</c:set>	
				<ec:column property="risktype" title="${trisktype}" style="text-align:center" width="10%">
				 ${cp:MAPVALUE("RISKTYPE",riskInfo.risktype)}
				</ec:column>

				<c:set var="triskdes">风险点描述</c:set>	
				<ec:column property="riskdes" title="${triskdes}" style="text-align:center" width="70%"/>
				
					
				<c:set var="optlabel">操作</c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center" width="6%">
					<c:if test="${fromjs=='1'}">
					<input type="radio" name="riskid" onclick="setRiskid('${riskInfo.riskid}')" <c:if test="${riskid eq riskInfo.riskid}">checked="checked"</c:if>>
					</c:if>
					<c:if test="${fromjs!='1'}">
					<input type="radio" name="riskid" onclick="setParentVal('${riskInfo.riskid}')" <c:if test="${riskid eq riskInfo.riskid}">checked="checked"</c:if>>
					</c:if>
				</ec:column>
				

			</ec:row>
		</ec:table>

	</body>
		<script type="text/javascript">
		//获取父页面对象
	
		
		//设置返回值
		function setParentVal(riskid){
			var parentDocument = window.opener.document;
			if(window.confirm("确认选择此项风险点吗？选择后窗口将自动关闭。")){
			
				parentDocument.getElementById('riskId').value = document.getElementById('riskid'+riskid).value;
				parentDocument.getElementById('riskdes').value = document.getElementById('riskdes'+riskid).value;
			
				
				
				window.close();
			}
	
		}
		
		function setRiskid(riskid){
			
			parent.window.returnValue={riskid:riskid};
			window.close();
		
		}
	</script>
</html>
