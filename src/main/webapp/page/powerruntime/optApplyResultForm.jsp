<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title></title>
<sj:head locale="zh_CN" />
<script src="${pageContext.request.contextPath}/scripts/suggest.js"
	type="text/javascript"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/scripts/city-picker.data.js" />
<body>
	<%@ include file="/page/common/messages.jsp"%>
	<s:form action="optRelevancyResult" method="post" namespace="/powerruntime" name="optRelevancyResultForm"
		id="optRelevancyResultForm">
		<%-- <input type="hidden" name="internalNo" value="${object.internalNo}" id="internalNo" /> --%>
		<fieldset style="padding: 10px; display: block; margin-bottom: 10px;">
			<legend style="padding: 4px 8px 3px;">
				<b>寄送方式编辑</b>
			</legend>
			<input type="button" class="btn" onclick="submitItemFrame('SAVE','${object.internalNo}');" value="保存"/>
			<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
				<tr>
					<td class="addTd" style="width: 15%"><h4>
							<span style="color: red">*</span>发送方式
						</h4></td>
					<td align="left"><select name="sendway" id="sendway">
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('SDFS')}">
									<option value="${row.key}" <c:if test="${object.sendway eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" /></option>
								</c:forEach>
							</select></td>
					<td class="addTd" style="width: 15%"><h4>
							<span style="color: red">*</span>记录人
						</h4></td>
						<td align="left"><input type="text" name="username" value="${object.username}" id="username" /></td>
					
				</tr>
				<tr>
					<td class="addTd" style="width: 15%"><h4>备注</h4></td>					
					<td align="left" colspan="3"><s:textarea name="memo" maxlength="1000"
						id="memo" value="%{object.memo}" style="width:95%;height: 60px;"></s:textarea></td>
					<td align="left" colspan="3">
				</tr>
			</table>
		</fieldset>
	</s:form>
</body>
<script type="text/javascript">
	function submitItemFrame(subType,internalNo){
		if ($("#sendway").val() == "") {
			alert("请选择发送方式");
			return false;
		}else{
			saveAndSubmits(subType,internalNo);
		}
	}
	function saveAndSubmits(subType,internalNo){
		$.ajax({
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "${pageContext.request.contextPath}/powerruntime/optRelevancyResult!save.do?internalNo="+internalNo ,//url
            data: $('#optRelevancyResultForm').serialize(),
            success: function (result) {
            	window.opener.location.reload();
                window.close();
            },
            error : function() {
                window.opener.location.reload();
                window.close();
            }
        });
	}
	
	
</script>
</html>