<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 

<html>
	<head>
		<title>
			绩效考核
		</title>
		<sj:head locale="zh_CN" />
<style type="text/css">
		.search td{padding:0px 10px 0px 10px;}
</style>
	</head>
<script type="text/javascript">


</script>
	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<div class="search"">
			<div class="crumbs">
				参数设定
			</div>
			
			<s:form action="pacheckupparam"  namespace="/monitor" id="pacheckupparamForm" style="margin-top:0;margin-bottom:5">
				<input type="hidden" id="paramType" name="paramType"  value="${param.paramType}" />
				 <input type="hidden" id="canDefer" name="canDefer"  value="" />
				  <input type="hidden" id="canRollback" name="canRollback"  value="" />
				   <input type="hidden" id="canClose" name="canClose"  value="" />
				<table >
				<tr>
					<td class="addTd">参数类别：</td>
					<td><select name="s_paramType" onchange="checkType();">
							<option value="">--请选择--</option>
					<c:forEach var="row" items="${cp:DICTIONARY('ParaType')}">
								<option value="${row.key}"
									<c:if test="${parameters.s_paramType[0] eq row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
					
		
				</tr>
				
					<tr>
						<td></td>
					<%-- 	<td>
							<s:submit method="checkupxz"  key="opt.btn.new" cssClass="btn"/>
						</td> --%>
					</tr>
				</table>
			</s:form>
		</div>

		<ec:table action="pacheckupparam!list.do" items="pacheckupparamList" var="pacheckupparam"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="paramNo" title="参数代码" style="text-align:center">
                    ${pacheckupparam.paramNo}
				</ec:column>
				<ec:column property="paramName" title="参数名称" style="text-align:center" >
					${pacheckupparam.paramName}
				</ec:column>
				<ec:column property="defaultValue" title="参数默认值" style="text-align:center" >
					${pacheckupparam.defaultValue}
				</ec:column>
				<ec:column property="paramType" title="参数类别"  style="text-align:center" >
					${cp:MAPVALUE("ParaType",pacheckupparam.paramType)}
				</ec:column>
		       <ec:column property="paramValue" title="用户设定值" style="text-align:center" >
				<input type="text" name="paramValue" id="${pacheckupparam.paramNo}" value="${pacheckupparam.paramValue}" onchange="updateParamValue('${pacheckupparam.paramNo}');"/>
		       <a href='monitor/pacheckupparam!paramSave.do?paramNo=${pacheckupparam.paramNo}&paramValue=${pacheckupparam.defaultValue}'>设置为默认值</a>
				</ec:column>
<%-- 				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">
					<a href='monitor/pacheckupparam!Edit.do?paramNo=${pacheckupparam.paramNo}'>修改</a>
					<a
					href='monitor/pacheckupparam!delete.do?paramNo=${pacheckupparam.paramNo}'
					onclick='return confirm("是否删除该参数代码：${pacheckupparam.paramNo}?");'>删除 </a>
				</ec:column> --%>
			</ec:row>
		</ec:table>
		
		<div class="search"">
			<div class="crumbs">
				绩效计算
			</div>
			<s:form action="pacheckupparam"  namespace="/monitor" style="margin-top:0;margin-bottom:5">
			<table cellpadding="0" cellspacing="0" align="center">
                   <tr>
                     <td class="addTd">年：</td>
                   					<td align="left">
					<select name="s_countYear" >
					<option value="">--请选择--</option>
					<s:iterator value="yearList" id="Id"> 
								<option value="${Id}" <c:if test="${parameters.s_countYear[0] eq Id}">selected="selected"</c:if>>
									<c:out value="${Id}" />
								</option>
					</s:iterator>
               	</select>
				<td class="addTd">月：</td>
					<td><select name="s_countMonth">
							<option value="">--请选择--</option>
					<c:forEach var="row" items="${cp:DICTIONARY('monthList')}">
								<option value="${row.key}"
									<c:if test="${parameters.s_countMonth[0] eq row.key}">selected="selected"</c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
								
				<td class="addTd" >计算操作：</td>
				<td >			
				<input type="checkbox"  name="s_onlyCalcSun" value="#parameters['s_onlyCalcSun']"
				 fieldValue="true"/>重算
				<input type="checkbox"  name="s_deleteOld" value="#parameters['s_onlyCalcSun']"
				fieldValue="true"  />仅计算总分
				</td>
				</tr>
				<tr >
					<td align="right">
							<s:submit method="jsperformance"  key="计算" cssClass="btn" align="right"/>	
						</td>
			</tr>

				</table>
				</s:form>		
				</div>	
	</body>
	<script type="text/javascript">
	function checkType() {
		 var form=document.getElementById("pacheckupparamForm");
	     form.action="pacheckupparam!list.do";     
	     form.submit();
	}
	function updateParamValue(paramNo) { 
		 var form=document.getElementById("pacheckupparamForm");
		 var paramValue=document.getElementById(paramNo);
	     form.action="pacheckupparam!paramSave.do?paramNo="+paramNo+"&paramValue="+paramValue.value;     
	     form.submit();
	}	
	</script>
</html>
