<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<!-- WdatePicker -->
<script src="${pageContext.request.contextPath}/scripts/plugin/My97DatePicker/myWdatePicker.js"></script>
<c:if test="${fn:length(conditions)>0}">
<fieldset>
<legend>查询条件</legend>
<form action="${pageContext.request.contextPath}/stat/twodimenform!doStat.do" id="statForm" style="margin-top:0px;margin-bottom:5px;">
	<input type="hidden" name="modelName" value="${modelName}"> 
	<input type="hidden" name="resultName" value="${resultName}">
	<table cellpadding="0" cellspacing="0">
	<tr><td width="800px">
		<div style="margin:20px 10px 10px 10px;">
		
			<div>
			<%-- 查询条件 --%>	
			<c:forEach var="cond" items="${conditions}" varStatus="status">
				<c:choose>
					<%-- 隐藏属性 --%>
					<c:when test="${cond.condStyle =='H'}">
						<input type="hidden" name="${cond.condName}" value="${cond.condValue}">
					</c:when>
					
					<%-- 只读属性 --%>
					<c:when test="${cond.condStyle =='R'}">
						<div class="searchTd">
					  		${cond.condLabel}：
					  	</div>
					  	<div class="searchPt">
					  		<input type="text" readonly="readonly" class=""
					  			name="${cond.condName}" value="${cond.condValue}" />
					  	</div>
					</c:when>
					
					<%-- 选择年份 --%>
					<c:when test="${cond.condStyle =='Y'}">
						<div class="searchTd">
					  		${cond.condLabel}：
					  	</div> 
					  	<div class="searchPt">
					  		<input type="text" class="Wdate" style="height:28px;border-radius:3px;border: 1px solid #cccccc;" value="${cond.condValue}"
					  			name="${cond.condName}" onclick="WdatePicker({dateFmt:'yyyy'})" placeholder="选择年份">
					  	</div>
					</c:when>
					
					<%-- 选择年月 --%>
					<c:when test="${cond.condStyle =='M'}">
						<div class="searchTd">
					  		${cond.condLabel}：
					  	</div>
					  	<div class="searchPt">
					  		<input type="text" class="Wdate" style="height:28px;border-radius:3px;border: 1px solid #cccccc;" value="${cond.condValue}"
					  			name="${cond.condName}" onclick="WdatePicker({dateFmt:'yyyy-MM'})" placeholder="选择年、月">
					  	</div>
					</c:when>
					
					<%-- 选择日期 --%>
					<c:when test="${cond.condStyle =='D'}">
						<div class="searchTd">
					  		${cond.condLabel}：
					  	</div>
					  	<div class="searchPt">
					  		<input type="text" class="Wdate" style="height:28px;border-radius:3px;border: 1px solid #cccccc;" value="${cond.condValue}"
					  			name="${cond.condName}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="选择日期" />
					  	</div>
					</c:when>
					
					<%-- 选择部门 --%>
					<c:when test="${cond.condStyle =='U'}">
						<div class="searchTd">
					  		${cond.condLabel}：
					  	</div>
					  	<div class="searchPt">
					  		TODO: 选择部门1
					  	</div>
					</c:when>
					
					<%-- 数据字典 --%>
					<c:when test="${cond.condStyle =='P'}">
						<div class="searchTd">
					  		${cond.condLabel}：
					  	</div>
					  	<div class="searchPt">
					  		<select style="width:160px;" name="${cond.condName}">
					  			<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:LVB(cond.condType)}">
									<option value="${row.value}" title="${row.label}" <c:if test="${cond.condValue==row.value }">selected="selected"</c:if>>								
										<c:out value="${row.label}" />
									</option>
								</c:forEach>
					  		</select>
					  	</div>
					</c:when>
					
					<%-- SQL --%>
					<c:when test="${cond.condStyle =='S'}">
						<div class="searchTd">
					  		${cond.condLabel}：
					  	</div>
					  	<div class="searchPt">
					  		<select style="width:160px;" name="${cond.condName}">
					  			<option value="">--请选择--</option>
								<c:forEach var="op" items="${datas[cond.condName] }">
									<option value="${op[0] }" title="${op[1] }" <c:if test="${op[0] == cond.condValue }">selected="selected"</c:if>>${op[1] }</option>	
								</c:forEach>
					  		</select>
					  	</div>
					</c:when>
					
					<c:otherwise>
					
						<div class="searchTd" style="margin-left:30px ">
					  		${cond.condLabel}：
					  	</div>
					  	<div class="searchPt">
					  		<input type="text" class=""
					  			name="${cond.condName}" value="${cond.condValue}" />
					  	</div>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			
			</div>
		
		</div></td></tr>
		<tr><td align="center">
		<div  align="center">
			<input type="submit" class="btn" value="查询统计" />
			<input type="button" class="btn btn-success btn-sm excel" value="导出" title="导出Excel文件" onclick="exportTableToExcel()" />
			</div></td></tr></table>
</form>
</fieldset>

<form method="post" id="dataForm" action="twodimenform!doExport.do">
	<input name="formName" id="formName" value="${formName }" type="hidden" ></input>
	<input name="exportData" id="exportData" type="hidden" ></input>
</form>
</c:if>