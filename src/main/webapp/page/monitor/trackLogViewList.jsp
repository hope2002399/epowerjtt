<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title>案件或办件列表</title>
		<sj:head locale="zh_CN" />
    <script type="text/javascript" src="<s:url value="/scripts/colorbox/jquery.colorbox.js"/>" charset="utf-8"></script>
        <link href="${pageContext.request.contextPath}/scripts/colorbox/colorbox.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="<s:url value="/scripts/addressBook.js"/>" charset="utf-8"></script>
		<script type="text/javascript" src="<s:url value="/scripts/centit.js"/>" charset="utf-8"></script>
	
	<script type="text/javascript">
		var path="${pageContext.request.contextPath}";				
	 $(document).ready(function() {  
		 centit.ajax.initAjax({urlPrefix:path});  
		 }); 
	</script>
	<script type="text/javascript">
	 function resetForm(){
		 $('#s_tracktype').val('');
		 $('#s_begTrackTime').val('');
		 $('#s_begUnTrackTime').val('');
		 $('#s_endTrackTime').val('');
	 }
	
	</script>
	</head>
	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<div class="search">
			<div class="crumbs">
				跟踪日志
			</div>
			<s:form action="trackLog" namespace="/monitor" style="margin-top:0;margin-bottom:5" id="trackLogForm" method="post" >
				<table cellpadding="0" cellspacing="0" align="center">
					<tr>
						<td class="addTd">跟踪类型：</td>
						<td><select name="s_tracktype" id="s_tracktype">
								<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('track_type')}">
									<option value="${row.key}"
										<c:if test="${parameters.s_tracktype[0] eq row.key}">selected="selected"</c:if>>
										<c:out value="${row.value}" />
									</option>
								</c:forEach>
						</select>
						 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;权力类型：&nbsp;&nbsp;<s:radio name="flag" list="#{'1':'办件','2':'案件'}" value="%{flag}" listKey="key" listValue="value" onclick="checkVersion()" />
						</td>
					</tr>
					<tr>
					<c:if test="${switch_time==1}">
					
						<td class="addTd">跟踪时间：</td>
						<td colspan=""><sj:datepicker name="s_begTrackTime" id ="s_begTrackTime"readonly="true"
								value="%{#parameters['s_begTrackTime']}" yearRange="2000:2020"
								displayFormat="yy-mm-dd " changeYear="true" />&nbsp;&nbsp;至&nbsp;&nbsp;<sj:datepicker name="s_endTrackTime" id="s_endTrackTime"readonly="true"
								value="%{#parameters['s_endTrackTime']}" yearRange="2000:2020"
								displayFormat="yy-mm-dd" changeYear="true" /></td> 
				</c:if>
				<c:if test="${switch_time==2}">
						<td class="addTd">取消时间</td>
						<td colspan="3"><sj:datepicker name="s_begUnTrackTime" id="s_begUnTrackTime" readonly="true"
								value="%{#parameters['s_begUnTrackTime']}" yearRange="2000:2020"
								displayFormat="yy-mm-dd" changeYear="true" />&nbsp;&nbsp;至&nbsp;&nbsp;<sj:datepicker name="s_endUnTrackTime" readonly="true"
								value="%{#parameters['s_endUnTrackTime']}" yearRange="2000:2020"
								displayFormat="yy-mm-dd" changeYear="true" /></td> 
					
				</c:if>
				</tr>
					<tr><td></td>
					<td>
						<s:submit method="trackLogViewList" key="opt.btn.query" cssClass="btn" />
						<input type="button" name="reset" value="重置" class="btn" onclick="resetForm();"/>
					</td>
					</tr>
				</table>
			</s:form>
		</div>
		<c:if test="${flag==1}">
			<ec:table action="trackLog!trackLogViewList.do" items="trackLogList" var="trackLog"  imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="trackno" title="跟踪编号" style="text-align:center">
					<a href='<%=request.getContextPath()%>/monitor/trackLog!view.do?trackno=${trackLog.trackno}'>${trackLog.trackno }</a> 
				</ec:column>
				<ec:column property="internalNoBj" title="办件编号" style="text-align:center">
					<a href="monitor/apply!view.do?internalNo=${trackLog.internalNoBj}&itemId=${trackLog.itemIdBj}">${trackLog.internalNoBj}</a> 
				</ec:column>
				<ec:column property="trackoperator" title="设置人" style="text-align:center">
					 ${cp:MAPVALUE("usercode",trackLog.trackoperator)}
				</ec:column>
				<ec:column property="tracktime" title="设置时间" style="text-align:center">
				<fmt:formatDate value='${trackLog.tracktime}' pattern='yyyy-MM-dd hh:mm:ss' />
				</ec:column>
				<ec:column property="untrackoperator" title="取消人" style="text-align:center">
					 ${cp:MAPVALUE("usercode",trackLog.untrackoperator)}
				</ec:column>
				<ec:column property="untracktime" title="取消时间" style="text-align:center">
				<fmt:formatDate value='${trackLog.untracktime}' pattern='yyyy-MM-dd hh:mm:ss' />
				</ec:column>
			</ec:row>
		</ec:table>
		</c:if>
		<c:if test="${flag==2}">
		<ec:table action="trackLog!trackLogViewList.do" items="trackLogList" var="trackLog" imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
				<ec:column property="trackLog.trackno" title="跟踪编号" style="text-align:center">
					<a href='<%=request.getContextPath()%>/monitor/trackLog!view.do?trackno=${trackLog.trackno}'>${trackLog.trackno }</a> 
				</ec:column>
				<ec:column property="trackLog.internalNoAj" title="案件编号" style="text-align:center">
					<a href='monitor/punish!view.do?internalNo=${trackLog.internalNoAj}&orgId=${trackLog.orgIdAj}&flag=1"'>${trackLog.internalNoAj }</a> 
				</ec:column>
				<ec:column property="trackLog.trackoperator" title="设置人" style="text-align:center">
					 ${cp:MAPVALUE("usercode",trackLog.trackoperator)}
				</ec:column>
				<ec:column property="trackLog.tracktime" title="设置时间" style="text-align:center">
				<fmt:formatDate value='${trackLog.tracktime}' pattern='yyyy-MM-dd hh:mm:ss' />
				</ec:column>
				<ec:column property="trackLog.untrackoperator" title="取消人" style="text-align:center">
					 ${cp:MAPVALUE("usercode",trackLog.untrackoperator)}
				</ec:column>
				<ec:column property="trackLog.untracktime" title="取消时间" style="text-align:center">
				<fmt:formatDate value='${trackLog.untracktime}' pattern='yyyy-MM-dd hh:mm:ss' />
				</ec:column>
			</ec:row>
		</ec:table>
		</c:if>
	</body>
	<script type="text/javascript">
	function checkVersion() {
		 var form=document.getElementById("trackLogForm");
	     form.action="trackLog!trackLogViewList.do";     
	     form.submit();
	}
</script>
</html>
