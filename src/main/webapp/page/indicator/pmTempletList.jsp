<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title><c:out value="ecProject.list.title" /></title>
		<sj:head locale="zh_CN" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript">
		function resetForm(){
			$(".discript").val("");
			$("#s_templetName").val("");
			$("#s_year").val("");
			$("#s_templetType").val("");
			$("#s_releaseFlag").val("");
		}
		function templetEdit1(){
			window.location.href="${pageContext.request.contextPath}/page/indicator/pmTempletForm.jsp?templetId=";
		}
		function toStartOrStop(temp){
			var consoleStr=temp.id=="T"?"禁用？":"启用？启用后该类型下已启用模版将被禁用！";
			if(confirm("确认"+consoleStr)){
				return true;
			}else{
				return false;
			}
			
		}
		function init() {
			var orgId = document.getElementById("s_orgId").value;
			var html='<select class="discript1" name="templetType" id="s_templetType"><option value="">请选择</option>';
			$.ajax({
				   type : 'get',
				   url: "${pageContext.request.contextPath}/indicator/pmTemplet!temType.do?orgId="+orgId,
				   dataType:"json",
				   async:false,
				   success: function(data){		
					   //$("#templetType").val('${typelist}');
					   var suppowers =data;
					   if(suppowers!=null&&suppowers.length>0){
						   for(var i=0;i<suppowers.length;i++){
							   //alert(powlist[i].itemName.length);
							   if(suppowers[i].itemName.length>17){
								   html+='<option type="radio"  value="'+suppowers[i].itemId+'" >'+suppowers[i].itemName.substring(0,16)+'...</option>'; 
							   }else{
							   	   html+='<option type="radio"  value="'+suppowers[i].itemId+'" >'+suppowers[i].itemName+'</option>'; 
							   }
						   }
						   html+='</select>';
						   $('#suppowers').html(html); 
					   }
				   }
				});
		}
		</script>
		<style type="text/css">
		select {width: 200px;border-color: #CCC;}
		input {width: 200px;border-color: #CCC;}
	</style>
	</head>
	<body onload="init()">
		<s:form action="pmTemplet" namespace="/indicator" style="margin-top:0;margin-bottom:5">
			<fieldset style=" display: block; padding: 10px; " >
				<legend class="new_legend">
				 	动态业务模版管理
				</legend>
				<table cellpadding="0" cellspacing="0" align="center">
					<tr height="22">
						<td align="right">模版名称:</td>
						<td>
							<input class="discript1" type="text" id="s_templetName" name="s_templetName" value="${param.s_templetName }">
						</td>
						<td align="right">年度:</td>
						<td>
							<input class="discript1" type="text" name="s_year"  id="s_year" value="${param.s_year}" class="Wdate" onClick="WdatePicker({maxDate:'#F{$dp.$D(\'maxnd\')}',dateFmt:'yyyy'})" readonly="readonly"/>
							<input type="hidden" id="maxnd" name="maxnd" value="${cp:MAPVALUE('provinceAnnual','sbAnnual') }">
					 	</td>
					</tr>	
					<tr height="22">
						<td align="right">模版类型:</td>
						<td id="suppowers"> 
						<input type="hidden" id="s_orgId" value="${session.SPRING_SECURITY_CONTEXT.authentication.principal.primaryUnit}">
						</td>
						<%-- <td align="right">模版类型:</td>
						<td>
							<select class="discript1" name="s_templetType" id="s_templetType">
								<option value="">请选择</option>
								<c:forEach var="row" items="${cp:DICTIONARY('PM_TEMPLETTYPE')}">
									<option type="radio" <c:if test="${param.s_templetType eq row.key}">selected="selected"</c:if> value="${row.key }" >
										${row.value}
									</option>
								</c:forEach>
							</select>
						</td> --%>
						<td align="right">状态:</td>
						<td>
							<select class="discript1" name="s_releaseFlag" id="s_releaseFlag">
								<option value="">请选择</option>
								<c:forEach var="row" items="${cp:DICTIONARY('PM_IS_VALID')}">
									<option type="radio" <c:if test="${param.s_releaseFlag eq row.key}">selected="selected"</c:if> value="${row.key }" >
										${row.value}
									</option>
								</c:forEach>
							</select>
						</td>
					</tr>
				</table>
				<div align="center" style="margin-top: 10">
					<s:submit method="templetList" id="searchBtn" cssClass="btn" key="查询" />
					<input type="button" class="btn" name="reset" value="重置" onclick="resetForm();"/>
					<input type="button" onclick="templetEdit1();" class="btn" value="新增" />
				</div>
			</fieldset>
		</s:form>
		<ec:table action="pmTemplet!templetList.do" items="objList" var="pro"
			imagePath="${STYLE_PATH}/images/table/*.gif" retrieveRowsCallback="limit" tableId="po">
			<ec:exportXls fileName="pmProvinceProject.xls" ></ec:exportXls>
			<ec:row>
				<ec:column property="version" title="版本" style="text-align:center" />
				<ec:column property="year" title="年度" style="text-align:center" />
				<ec:column property="templetName" title="模板名称" style="text-align:center" />
				<ec:column property="templetType" title="模版类型" style="text-align:center" >
					${cp:MAPVALUE("PM_TEMPLETTYPE",pro.templetType) }
				</ec:column>
				<ec:column property="releaseFlag" title="模版状态" style="text-align:center" >
					${pro.releaseFlag=="X"?"未启用":"" }
					${pro.releaseFlag=="T"?"已启用":"" }
					${pro.releaseFlag=="F"?"已禁用":"" }
				</ec:column>
				<ec:column property="opt" title="操作" sortable="false" viewsDenied="xls" style="text-align:center">
					<a onclick="return toStartOrStop(this);" id="${pro.releaseFlag }" href="${pageContext.request.contextPath}/indicator/pmTemplet!startOrStop.do?templetId=${pro.templetId }">${pro.releaseFlag=="T"?"禁用":"启用" }</a>
					<a href="${pageContext.request.contextPath}/page/indicator/pmTempletForm.jsp?templetId=${pro.templetId }&releaseFlag=${pro.releaseFlag}">${pro.releaseFlag=="X"?"修改":"复制" }</a>
					<a href="${pageContext.request.contextPath}/page/indicator/pmTempletView.jsp?templetId=${pro.templetId }">查看</a>
					<%-- <a href="${pageContext.request.contextPath}/page/indicator/pmIndexExpressionForm.jsp?templetId=${pro.templetId }">指标测评公式</a> --%>
				</ec:column>
			</ec:row>
		</ec:table>
	</body>
</html>
