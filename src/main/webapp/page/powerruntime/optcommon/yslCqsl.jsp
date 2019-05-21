<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<style type="text/css">
.viewTable {
	color: #000;
}

.viewTable th {
	text-align: left;
	text-indent: 10px;
	border: 1px solid #cdcdcd;
	height: 30px;
}
</style>
</head>
<body style="width: 98%; padding-left: 5px;">
<s:hidden id="isAllsc" value="%{isAllsc}"></s:hidden>
<script type="text/javascript">
	var is = $("#isAllsc").attr("value");
	var bt1 = window.parent.document.getElementById('shouli');
	var bt2 = window.parent.document.getElementById('saveAndSubmit');

	if (is == "0") {
		if (bt1 != null)
			bt1.disabled = "true";
		else if (bt2 != null) {
			bt2.disabled = "true";
		}
	}
	if (is == "1") {
		if (bt1 != null)
			bt1.disabled = undefined;
		else if(bt2 != null){
			bt2.disabled = undefined;
		}
	}
	//	parentDocument.getElementById('itemFrameDiv').style.display = "";
</script>
<s:form action="generalOperator!saveYslStuff.do" method="POST"
	enctype="multipart/form-data" name="form1" target="">
	<input type="hidden" name="optStuffInfoNet.netId" value="${optStuffInfoNet.netId}" />
	<input type="hidden" name="optStuffInfoNet.nodeInstId" value="${optStuffInfoNet.nodeInstId}" />
	<s:hidden id="stuffname" name="optStuffInfoNet.stuffname"></s:hidden>
	<s:hidden id="sortId" name="optStuffInfoNet.sortId"></s:hidden>
	<input type="hidden" name="optStuffInfoNet.groupid" value="${optStuffInfoNet.groupid}" />
	<input type="hidden" id="filetype" name="optStuffInfoNet.filetype" />
	<input type="hidden" id="archivetype" name="optStuffInfoNet.archivetype" />

	<table border="0" class="viewTable">
		<tr>
			<th>材料名称</th>
			<th width="70" align="center">是否纸质</th>
			<th width="70" align="center">是否必须</th>
			<th>已上传文件</th>
			<th>文件上传</th>
		</tr>
		<!-- ×××××××××××××××××××新的××××××××××××××××××××××××××××× -->
		<c:forEach var="obj" items="${suppowerstuffinfos}">
			<tr>
				<td>${obj.stuffName}</td>
				<td align="center">
					<input type="checkbox" class="${obj.sortId}" id="${obj.sortId}" target="${obj.stuffName}" iszhiname="optStuffInfoNet.iszhi" onclick="beforeSubmit2(this,'${obj.stuffType}','')" value="1" />
				</td>
				<td align="center">
					<c:if test="${obj.isNeed == '1'}">
						<p style="color: red">是</p>
					</c:if>
					<c:if test="${obj.isNeed == '0'}">
						<p style="color: red">否</p>
					</c:if>
				</td>
				<td>
					<c:if test="${optStuffInfoNets != null}">
						<c:forEach var="info" items="${optStuffInfoNets}">
						<p>
							<c:if test="${info.sortId == obj.sortId}">
								<a style="text-decoration: none; color: blue;"
									href="<%=request.getContextPath()%>/powerruntime/optApplyNet!downStuffInfo.do?stuffid=${info.stuffid}">${info.filename}</a>
								<c:if test="${info.iszhi != '1'}">
									<a href="<%=request.getContextPath()%>/powerruntime/generalOperator!deleteYslStuffInfo.do?optStuffInfoNet.stuffid=${info.stuffid}">删除</a>
								
							 <script type="text/javascript">
													if($(".${obj.sortId}").attr("disabled")!="disabled"){
													$(".${obj.sortId}").attr(
															"disabled",
															"disabled");
													}
												</script>
								</c:if>
							</c:if>
							</p>
						
						</c:forEach>
					</c:if>
				</td>
				<td width="50px">
					<input type="file" target="${obj.sortId}" stuffname="${obj.stuffName}" onchange="beforeSubmit(this,'${obj.stuffType}','');" />
				</td>
			</tr>
			<c:if test="${optStuffInfoNets != null}">
				<c:forEach var="info" items="${optStuffInfoNets}">
					<c:if test="${info.sortId == obj.sortId}">
						<c:if test="${info.iszhi == '1'}">
							<script type="text/javascript">
								var id = '${obj.sortId}';
								$("#" + id + "").attr("checked", "true");
								$("input[target='" + id + "']").attr("disabled", "true");
							</script>
						</c:if>
					</c:if>
				</c:forEach>
			</c:if>
		</c:forEach>
	</table>
</s:form>
<script type="text/javascript">
var init = null;
$(document).ready(function() {
	init = setInterval("FrameUtils.initialize_stuff(window, init)", MyConstant.initTimeForAdjustHeight);
});

/*控件上传*/
function beforeSubmit(file, filetype, archivetype) {
	$("#stuffname").attr("value", file.attributes.stuffname.nodeValue);
	$("#sortId").attr("value", file.attributes.target.nodeValue);
	file.name = "stuffFile";
	$("#filetype").val(filetype);
	/* $("#archivetype").val(archivetype); */
	form1.submit();
}
/*纸质文件触发事件*/
function beforeSubmit2(che, filetype, archivetype) {
	if (che.checked) {
		$("#stuffname").attr("value", che.target);
		$("#sortId").attr("value", che.id);
		che.name = "optStuffInfoNet.iszhi";
		$("#filetype").val(filetype);
		/* $("#archivetype").val(archivetype); */
		form1.submit();
	} else {
		$("#sortId").attr("value", che.id);
		che.name = "optStuffInfoNet.iszhi";
		$("input[target='" + che.id + "']").removeAttr("disabled");
		$("#filetype").val(filetype);
		/* $("#archivetype").val(archivetype); */
		form1.submit();
	}
}
</script>
</body>
</html>
