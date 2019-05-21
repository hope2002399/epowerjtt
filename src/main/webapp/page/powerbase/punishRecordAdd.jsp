<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>新增</title>
<script src="<s:url value='/scripts/centit_validator.js'/>" type="text/javascript" />		
<script type="text/javascript"
	src="<s:url value="/scripts/colorbox/jquery.colorbox.js"/>"
	charset="utf-8"></script>
<link
	href="${pageContext.request.contextPath}/scripts/colorbox/colorbox.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/scripts/jquery-ui/jquery-ui-1.9.2.custom.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<s:url value="/scripts/addressBook.js"/>" charset="utf-8"></script>
<script type="text/javascript" src="<s:url value="/scripts/centit.js"/>"
	charset="utf-8"></script>
<script type="text/javascript"
	src="<s:url value="/scripts/jquery-ui/jquery-ui-1.9.2.custom.js"/>"
	charset="utf-8"></script>
<script type="text/javascript"
	src="<s:url value="/scripts/opendiv_Win.js"/>" charset="utf-8"></script>
<script
	src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js"
	type="text/javascript"></script>
<link
	href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
<fieldset style="padding: 10px;">
		<legend class="ctitle" style="width: auto; margin-bottom: 5px;">
			<s:text name="新增备案" />
		</legend>
	<s:form action="punishRecord" method="post"  theme="simple" validator="true" > 
		<table cellpadding="0" cellspacing="0" align="center" class="viewTable">
			<tr>
				<td class="addTd">*部门名称</td>
				<td>
				<input type="text" name="s_orgName" id="s_orgName" value="${cp:MAPVALUE('depno',param.org_id)}" validator="input" min="1" errorshow="请选择部门名称" />
				<input type="hidden" name="org_id" id="org_id" value="${param.org_id}"/>
			</tr>
			<tr>
				<td class="addTd">*部门类型:</td>
				<td><select name="depKind" id="depKind" validator="input" min="4" errorshow="请选择部门类型">
								<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('BMLX')}">
									<option value="${row.key}"
										<c:if test="${parameters.s_depKind[0] eq row.key}">selected="selected"</c:if>>
										<c:out value="${row.value}" />
									</option>
								</c:forEach>
						</select></td>
				</td>
			</tr>
			<tr><td class="addTd">*个人罚款限额</td><td><input type="text" name="personNum" size="20" validator="input" min="1" errorshow="请输入个人罚款限额" />(元)
			</td></tr>
			<tr><td class="addTd">*组织机构限额</td><td><input type="text"  id="corpNum" name="corpNum" validator="input" min="1" errorshow="请输入组织机构限额" />(元)</span></td></tr>
			<tr><td class="addTd">法律依据</td><td><textarea rows="2" cols="7" id="lawbasic" name="lawbasic"></textarea></td></tr>
			<tr><td class="addTd">备注</td><td><textarea rows="2" cols="7" id="remark" name="remark"></textarea></td></tr>
		</table>
		<s:submit  method="savePunishRecord"  cssClass="btn" key="opt.btn.save" />
		<input type="button" class="btn" value="返回" onclick="javascript:history.go(-1);" />
	</s:form>
	</fieldset>
	
	<script type="text/javascript">
		var menuList = ${unitsJson};
		function bindEvent(o1, o2, $this) {
			o1.val($this.html());
			var key = $this.attr("rel");
			for ( var i = 0; i < menuList.length; i++) {
				if (key == menuList[i].MID) {
					o2.val(menuList[i].depno);
				}
			}
			if (getID("shadow")) {
				$("#shadow").hide();
				$("#boxContent").hide();
			}
		}
		$("#s_orgName")
				.bind(
						'click',
						function() {
							var menuList = ${unitsJson};
							var shadow = "<div id='shadow'></div><div id='boxContent'><div class='listShadow'></div><div id='lists' class='getTree'>Loader</div><div id='close'>×</div></div>";
							if (getID("shadow")) {
								$("#shadow").show();
								$("#boxContent").show();
							} else {
								$("body").append(shadow);
								$("#shadow").height(document.body.scrollHeight);
								setTimeout(function() {
									menuDisplay(menuList, "${parentUnit}");
								}, 0);
							}
							;
						   $("#lists span").live(
									'click',
									function() {
										var $this = $(this);
										bindEvent($("#s_orgName"),
												$("#org_id"), $this);
										$("#lists span").die("click");
									}); 
						});
		
		
	</script>
</body>

</html>