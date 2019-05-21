<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%> 
<html>
	<head>
		<title>
			处罚备案参数管理
		</title>
		<sj:head locale="zh_CN" />
		<script src="${pageContext.request.contextPath}/scripts/SelectTree_V1.0.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/styles/default/css/SelectTree.css" rel="stylesheet" type="text/css" /
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<fieldset style="padding:10px;">
			<legend>
				  <b>查询条件</b>
			</legend>
			
			<s:form action="punishrecordparam" namespace="/punish" style="margin-top:0;margin-bottom:5">
				<table cellpadding="0" cellspacing="0" align="center">
					<tr >
						<td class="addTd" >部门名称:</td>
						<td>
						<input type="text" id="orgName" name="orgName" value="${cp:MAPVALUE('unitcode',param.s_orgcode)}"/>
						<input type="hidden" id="s_orgcode" name="s_orgcode" value="${param.s_orgcode}"/>
						<s:checkbox label="包含下属机构" name="s_queryUnderUnit" value="#parameters['s_queryUnderUnit']" fieldValue="true" />包含下属机构
						</td>
					</tr>	
					<tr>
						<td class="addTd">
							部门性质:
						</td>
						<td align="left">
							<select name="s_depkind" style="width: 180px">
								<option value=""> </option>
								<c:forEach var="row" items="${cp:DICTIONARY('depkind')}">
									<option value="${row.key}"
										<c:if test="${parameters.s_depkind[0] eq row.key}"> selected = "selected" </c:if>>
										<c:out value="${row.value}" />
									</option>
								</c:forEach>
						</select>
						</td>
					</tr>

					<tr><td></td>
						<td>
							<s:submit method="punishrecordparamList"  key="查询" cssClass="btn"/>
							<s:submit method="initalEdit"  key="新增" cssClass="btn"/>
							</td>
					</tr>
				</table>
			</s:form>
		</fieldset>

		<ec:table action="punish/punishrecordparam!punishrecordparamList.do" items="punishrecordparamList" var="punishrecordparam"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>

				<ec:column property="orgId" title="部门名称" style="text-align:center" >
					${cp:MAPVALUE("depno",punishrecordparam.orgId)}
				</ec:column>

				<ec:column property="bookoperatorid" title="登记人员" style="text-align:center" >
					${cp:MAPVALUE("usercode",punishrecordparam.bookoperatorid)}
				</ec:column>


				<ec:column property="modifydate" title="更新时间" style="text-align:center" >
					
					<fmt:formatDate value='${punishrecordparam.modifydate}' pattern='yyyy-MM-dd HH:mm:ss'/>
				</ec:column>

				<ec:column property="depkind" title="部门类型" style="text-align:center" >
					${cp:MAPVALUE("depkind",punishrecordparam.depkind)}
				</ec:column>

				<ec:column property="personnum" title="个人罚款限额" style="text-align:center" >
					${punishrecordparam.personnum}
				</ec:column>

				<ec:column property="corpnum" title="组织机构限额" style="text-align:center" >
					${punishrecordparam.corpnum}
				</ec:column>

		
				<c:set var="optlabel"><s:text name="opt.btn.collection"/></c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"
					style="text-align:center">
					<c:set var="deletecofirm"><s:text name="label.delete.confirm"/></c:set>
<%-- 					<a href='punish/punishrecordparam!view.do?orgId=${punishrecordparam.orgId}'><s:text name="opt.btn.view" /></a> --%>
					<a href='punish/punishrecordparam!update.do?orgId=${punishrecordparam.orgId}'><s:text name="opt.btn.edit" /></a>
					<a href='punish/punishrecordparam!delete.do?orgId=${punishrecordparam.orgId}' 
							onclick='return confirm("${deletecofirm}此条数据?");'><s:text name="opt.btn.delete" /></a>
				</ec:column>

			</ec:row>
		</ec:table>

	</body>
	<script type="text/javascript">
		function openNewWindow(winUrl, winName, winProps) {
		if (winProps == '' || winProps == null) {
			winProps = 'height=500px,width=790px,directories=false,location=false,top=100,left=500,menubar=false,Resizable=yes,scrollbars=yes,toolbar=false';
		}
		window.open(winUrl, winName, winProps);
		}
		function bindEvent(o1,o2,$this){
			o1.val($this.html());
			o2.val($this.attr("rel"));
			if(getID("shadow")){
				$("#shadow").hide();
				$("#boxContent").hide();
			}
		}
		$("#orgName").bind('click',function(){
			var menuList = ${unitsJson};
			var shadow = "<div id='shadow'></div><div id='boxContent'><div class='listShadow'></div><div id='lists' class='getTree'>Loader</div><div id='close'>×</div></div>";
			if(getID("shadow")){
				$("#shadow").show();
				$("#boxContent").show();
			}else{
				$("body").append(shadow);
				$("#shadow").height(document.body.scrollHeight);
				setTimeout(function(){
					menuDisplay(menuList,"${parentunit}");	
				},0);
			};
			$("#lists span").live('click',function(){
				var $this = $(this);
				bindEvent($("#orgName"),$("#s_orgcode"),$this);
				$("#lists span").die("click");
			});
		});
	</script>
</html>
