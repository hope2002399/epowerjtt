<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="" /></title>
<sj:head locale="zh_CN" />
<script src="${pageContext.request.contextPath}/scripts/common.js" type="text/javascript"></script>

</head>

<body>



	<%-- <%@ include file="/page/common/messages.jsp"%> --%>
	<s:form method="post" action="dispatchDoc!saveTransDispatch.do" namespace="/dispatchdoc"
		name="dispatchDocForm" id="dispatchDocForm" target="_self">
		
		<input type="hidden" name="s_biztype" value="F">
		
		<%-- <input type="hidden" id="djId" name="djId"  value="${object.djId}" />
		<input type="text" id="powerid" name="optBaseInfo.transAffairNo" value="${object.optBaseInfo.transAffairNo}">
		<input type="text" id="orgcode" name="optBaseInfo.transaffairname" value="${object.optBaseInfo.transaffairname}">
		
		<input type="text" id="powerid" name="optBaseInfo.powerid" value="${object.optBaseInfo.powerid}">
		<input type="text" id="content" name="optBaseInfo.content" value="${object.optBaseInfo.content}">
		<input type="text" id="transAffairQueryKey" name="optBaseInfo.transAffairQueryKey" value="${object.optBaseInfo.transAffairQueryKey}">
		<input type="text" id="flowCode" name="flowCode"  value="${flowCode}" /> --%>
		
		
		<center>
			<input type="button" class="btn" id="save" value="保存" /> <input
				type="button" class="btn" id="saveAndSubmit" value="保存并提交" /> <input
				type="button" value="返回" Class="btn" onclick="window.history.back()" />

		</center>
		
 <%@ include file="/page/powerruntime/optcommon/optBaseInfoForm.jsp"%>
<!-- 关联的收文frame -->
		<iframe id="docRelativeFrame" name="docRelativeFrame" src="${pageContext.request.contextPath}/dispatchdoc/dispatchDoc!docRelativeList.do?dispatchNo=${object.djId}&docRelativeFrameType=edit" width="100%" style="margin-bottom:10px;"
			frameborder="no" scrolling="false" border="0" marginwidth="0" onload="this.height=window.frames['docRelativeFrame'].document.body.scrollHeight"></iframe>
		

		 
		<fieldset style="padding: 10px; display: block; margin-bottom: 10px;">
			<legend style="padding: 4px 8px 3px;">
				<b>发文信息</b>
			</legend>
			<table border="0" cellpadding="0" cellspacing="0" class="viewTable">


				<%-- <tr>
					<td>部门内部事项编号</td>
					<td><input type="text" id="internalNo" name="internalNo" size="40"
						value="${object.internalNo}" /><span style="color: red">*</span></td>
					<td>权力编码</td>
					<td><input type="text" id="itemId" name="itemId" size="40"
						value="${object.itemId}" /> <span style="color: red">*</span></td>
				</tr> --%>

				<tr>
					<td>发文号</td>
					<td><input type="text" name="dispatchDocNo" size="40"
						value="${object.optBaseInfo.sendArchiveNo}" disabled="disabled" /></td>
					<td>发文标题</td>
					<td><input type="text" name="dispatchDocTitle" size="40"
						value="${object.optBaseInfo.transaffairname}" disabled="disabled" /></td>
				</tr>				

				<tr>
					<td width="130">文件类型</td>
					<td><select name="dispatchFileType" style="width: 180px">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('FW_FILE_TYPE')}">
								<option value="${row.key}"
									<c:if test="${object.dispatchFileType eq row.key}"> selected = "selected" </c:if>
									<c:if test="${empty object.dispatchFileType and row.key eq '0'}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
					<td width="130">公文种类</td>
					<td><select name="dispatchDocType" style="width: 180px">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('FW_DOC_TYPE')}">
								<option value="${row.key}"
									<c:if test="${object.dispatchDocType eq row.key}"> selected = "selected" </c:if>
									<c:if test="${empty object.dispatchDocType and row.key eq '0'}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
				</tr>

				<tr>
					<td width="130">文件公开</td>
					<td><select name="dispatchCanOpen" style="width: 180px">
							<option value="">--请选择--</option>
							<option value="1"
								<c:if test="${object.dispatchCanOpen eq 1}"> selected = "selected" </c:if>>是</option>
							<option value="2"
								<c:if test="${object.dispatchCanOpen eq 2}"> selected = "selected" </c:if>>否</option>
					</select></td>
					<td width="130">文件公开类型</td>
					<td><select name="dispatchOpenType" style="width: 180px">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('FW_OPEN_TYPE')}">
								<option value="${row.key}"
									<c:if test="${object.dispatchOpenType eq row.key}"> selected = "selected" </c:if>
									<c:if test="${empty object.dispatchOpenType and row.key eq '0'}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
				</tr>

				<tr>
					<td>不能公开原因</td>
					<td colspan="3"><input type="text" name="notOpenReason"
							style="width:100%;height:40px;" value="${object.notOpenReason}"/>
					</td>
				</tr>

				<tr>
					<td width="130">联合发文</td>
					<td><select name="isUnionDispatch" style="width: 180px">
							<option value="">--请选择--</option>
							<option value="1"
								<c:if test="${object.isUnionDispatch eq 1}"> selected = "selected" </c:if>>是</option>
							<option value="2"
								<c:if test="${object.isUnionDispatch eq 2}"> selected = "selected" </c:if>>否</option>
					</select></td>
					<td width="130">会签发文</td>
					<td><select name="isCountersign" style="width: 180px">
							<option value="">--请选择--</option>
							<option value="1"
								<c:if test="${object.isCountersign eq 1}"> selected = "selected" </c:if>>是</option>
							<option value="2"
								<c:if test="${object.isCountersign eq 2}"> selected = "selected" </c:if>>否</option>
					</select></td>
				</tr>
				<tr>
					<td width="130">关联其他公文</td>
					<td colspan="3"><input type="text" name="unionOthers"
						value="${object.unionOthers}" style="width: 100%; height: 40px;" />（动态添加，“,”号分割）</td>
				</tr>
				<tr>
					<td width="130">文件摘要</td>
					<td colspan="3"><input type="text"  name="dispatchDocSummary"
							style="width:100%;height:40px;" value="${object.dispatchDocSummary}" /> <%-- <s:textarea
							name="dispatchDocSummary" style="width:100%;height:40px;"
							value="${object.dispatchDocSummary}" />  --%></td>
				</tr>

				<tr>
					<td width="130">拟文日期</td>
					<td><sj:datepicker id="draftDate" value="%{object.draftDate}"
							name="draftDate" style="width:180px" yearRange="2000:2020"
							displayFormat="yy-mm-dd" changeYear="true" readonly="true" /></td>

					<td width="130">承办处室</td>
					<td><input type="text" name="optUnitName" size="40"
						value="${object.optUnitName}" /></td>
				</tr>

				<tr>
					<td width="130">拟稿人</td>
					<td><input type="text" name="draftUserName" size="40"
						value="${object.draftUserName}" /></td>

					<td width="130">密级</td>
					<td><select name="secretsDegree" style="width: 180px">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('FW_SECRETS_LEVEL')}">
								<option value="${row.key}"
									<c:if test="${object.secretsDegree eq row.key}"> selected = "selected" </c:if>
									<c:if test="${empty object.secretsDegree and row.key eq '0'}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td width="130">份数</td>
					<td><input type="text" name="dispatchCopies" size="40"
						value="${object.dispatchCopies}" /></td>
					<td width="130">保管期限</td>
					<td><sj:datepicker id="retentionPeriod"
							value="%{object.retentionPeriod}" name="retentionPeriod"
							style="width:180px" yearRange="2000:2020"
							displayFormat="yy-mm-dd" changeYear="true" readonly="true" /></td>
				</tr>

				<tr>
					<td width="130">主送单位</td>
					<td colspan="3"><input type="text" name="mainNotifyUnit"
						style="width: 100%; height: 40px;"
						value="${object.mainNotifyUnit}" /> （多个单位','分开）</td>
				</tr>
				<tr>
					<td width="130">抄送单位</td>
					<td colspan="3"><input type="text" name="otherUnits"
						style="width: 100%; height: 40px;" value="${object.otherUnits}" />
						（多个单位','分开）</td>
				</tr>


			</table>

		</fieldset>
	</s:form>

	<%-- <fieldset>
		<legend>材料上传</legend>
		<iframe id="basicsj" name="sjfj" width="100%" height=""
			frameborder="no" scrolling="false" border="0" marginwidth="0"
			marginheight="0"
			src="<%=request.getContextPath()%>/powerruntime/generalOperator!gotosqcl.do?stuffInfo.djId=${object.djId}&stuffInfo.nodeInstId=0&stuffInfo.groupid=155">
		</iframe>
	</fieldset> --%>
</body>
<script type="text/javascript">
	function doCheck() {
		/* if (StringUtils.isBlank($('#internalNo').val())) {
			alert('请输入部门内部事项编号');
			return false;
		}
		if (StringUtils.isBlank($('#itemId').val())) {
			alert('请输入权力编码');
			return false;
		} */
		
		return true;
	}

	function getStringLen(Str) {
		var i, len, code;
		if (Str == null || Str == "")
			return 0;
		len = Str.length;
		for (i = 0; i < Str.length; i++) {
			code = Str.charCodeAt(i);
			if (code > 255) {
				len++;
			}
		}
		return len;
	}

	$(document)
			.ready(
					function() {
						$('#save,#saveAndSubmit')
								.click(
										function() {
											var id = $(this).attr('id');
											if ('save' == id) { // 保存
												$('#dispatchDocForm')
														.attr('action',
																'dispatchDoc!saveDispatchDoc.do');
											} else if ('saveAndSubmit' == id) { // 提交
												if (doCheck()) { // 校验通过
													$('#dispatchDocForm')
															.attr('action',
																	'dispatchDoc!saveAndSubmitDispatchDoc.do');
												}
											}
											$('#dispatchDocForm').submit();
											return false;
										});
					});
</script>


</html>

























