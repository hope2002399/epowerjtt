<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%> 
<html>
	<head>
	<meta name="decorator" content='${LAYOUT}'/>
		<title>
			流程查询
		</title>
		<script type="text/javascript">
		function resetForm(){
			$('#s_flowOptName').val('');
			$('#s_flowOptTag').val('');
			$('#s_inststate').val('');
			$('#s_unitcode').val('');
			$('#s_createtime').val('');
			$('#lastUpdateTime').val('');
		}
		</script>
		<sj:head locale="zh_CN" />
		<script src="${pageContext.request.contextPath}/scripts/suggest.js" type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/themes/css/alertDiv.css" rel="stylesheet" type="text/css" />
		<script src="${pageContext.request.contextPath}/scripts/alertDiv.js"  type="text/javascript" />
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		<div class="search">
		<div class="crumbs">流程实例管理</div>
			
			<s:form action="sampleFlowManager" namespace="/sampleflow">
				<table cellpadding="0" cellspacing="0" >
					<tr >
						<td class="addTd">办件名称：</td>
						<td width="300">
						<s:textfield name="s_flowOptName" id="s_flowOptName" value="%{#parameters['s_flowOptName']}" style="width:180px" />
						 </td>
						<td class="addTd">收（发）文号：</td>
						<td>
							<s:textfield name="s_flowOptTag" id="s_flowOptTag" value="%{#parameters['s_flowOptTag']}" style="width:180px" />
						</td>
					</tr>
					<tr >
						<td class="addTd">流程状态：</td>
						<td width="300">
							<select name="s_inststate" id="s_inststate" style="width:180px">
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('WFInstType')}">
									<option value="${row.key}" <c:if test="${param.s_inststate==row.key}">selected="selected"</c:if>>
									
									<c:out value="${row.value}" /></option>
								</c:forEach>
							</select>
						</td>
						<td  class="addTd">主办处室：</td>
						<td>
							  <select name="s_unitcode" id="s_unitcode" style="width:180px">
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:LVB('unitcode')}">
									<option value="${row.value}"  <c:if test="${param.s_unitcode==row.value}">selected="selected"</c:if>>
									<c:out value="${row.label}" />
									</option>
								</c:forEach>
							</select>

						</td>
					</tr>
					<tr >
						<td class="addTd" >创建时间：</td>
						<td>
						<sj:datepicker id="s_createtime"
							name="s_createtime" value="%{#parameters['s_createtime']}" style="width:162px"
							yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" />
						
						 </td>
						<td class="addTd">完成时间：</td>
						<td>
						<sj:datepicker id="lastUpdateTime" style="width:162px"
							name="s_lastUpdateTime" value="%{#parameters['s_lastUpdateTime']}"
							yearRange="2000:2020" displayFormat="yy-mm-dd" changeYear="true" />
						
						 </td>
					</tr>
					<%--
					<tr>
						<td class="addTd">创建用户:</td>
						<td>
						<div id="userDiv">
						<input type="text" name="userName" value="${cp:MAPVALUE('usercode',param.s_usercode)}" style="width:180px"/>
						<s:hidden name="s_usercode" value="%{#parameters['s_usercode']}"/>
						<ul id="list"></ul>
						</div>
						<script type="text/javascript">
						$(function(){
							initValue($("input[name=userName]"),$("#list"),"${pageContext.request.contextPath}/sys/userDef!getUsers.do",$("input[name=s_usercode]"));
						})
						</script>
						</td>
						  
						<td class="addTd">操作方法:</td>
						<td>
						<select name="s_optcode" style="width:180px">   
							<option value="">   
									<c:out value="-- 请选择 --"/>   
							</option>    
							<c:forEach var="opt" items="${cp:IS_FLOWOPTDEF('T')}">
								<option value="${opt.optcode}" <c:if test="${param.s_optcode==opt.optcode}">selected="selected"</c:if> >   
									<c:out value="${opt.optname}"/>   
								</option>
							</c:forEach> 
						</select>
					</td>
					</tr>
 					<tr>
						<td class="addTd">包含节点:</td>
						<td><s:textfield name="s_nodeid" style="width:180px"/> </td>
						<!--<td class="addTd">包含完成:</td>
						<td>
							<s:checkbox name="s_isAll" value="#parameters['s_isAll']" fieldValue="true" />
						</td>
					--></tr>
 --%>					<tr>
 						<td></td>
						<td colspan="3" align="center">
							<s:submit method="list"  value="查询" cssClass="btn"/>
							<input type="button" name="reset"  class="btn" value="重置" onclick="resetForm();" />
						</td>
					</tr>
				</table>
			</s:form>
		</div>

		<ec:table action="sampleFlowManager!list.do" items="objList" var="wfFlowInstance"
			imagePath="${pageContext.request.contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row>
				<%--<ec:column property="flowInstId" title="流程实例编号" style="text-align:center" />
				<ec:column property="flowName" title="流程名称" style="text-align:left"/>
				<ec:column property="version" title="流程版本" style="text-align:center"/>
				--%>
				<ec:column property="flowOptName" title="文件标题" style="text-align:left" />
				<ec:column property="flowOptTag" title="收（发）文号" style="text-align:center" />
				<ec:column property="createTime" title="创建时间" style="text-align:center" >
					<fmt:formatDate value="${wfFlowInstance.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</ec:column>
				<ec:column property="instState" title="办件状态" style="text-align:center">
				${cp:MAPVALUE("WFInstType",wfFlowInstance.instState)}
				</ec:column>
				<ec:column property="timeLimitStr" title="剩余时间" style="text-align:center" />
				<%--
				<ec:column property="subFlow" title="是否是子流程" style="text-align:center" />
				--%>
				<ec:column property="unitCode" title="主办处室" style="text-align:center">
					${cp:MAPVALUE("unitcode",wfFlowInstance.unitCode)}
				</ec:column>
				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center">
					<a href="javascript:showDivAlert('${wfFlowInstance.flowInstId}')">更改机构</a>
					<a href='sampleFlowManager!listFlowInstNodes.do?flowInstId=${wfFlowInstance.flowInstId}'>流程管理</a>
					<a href='#' onclick="openNewWindow('<%=request.getContextPath()%>/sampleflow/sampleFlowManager!viewxml.do?flowInstId=${wfFlowInstance.flowInstId}','powerWindow',null);">查看流程图</a>
				</ec:column>

			</ec:row>
		</ec:table>
		<div id="alert" class="alert" style="width: 300px;height: 100px;">
				<s:form name="nodeForm" method="post" onsubmit="return checkUnit();" action="sampleFlowManager!modifyFlowInst.do" namespace="/sampleflow" style="margin-top:0;margin-bottom:5">
				<input type="hidden" id="flowInstId" name="flowInstId" value="">
					<h4><span>机构选择</span><span id="close" class="close"  onclick="closeAlert('alert');" >关闭</span></h4>
					<p>
						<select name="unitCode">   
							<option value="">   
									<c:out value="-- 请选择 --"/>   
							</option>    
							<c:forEach var="row" items="${cp:LVB('unitcode')}">     
									<option value="${row.value}">   
										<c:out value="${row.label}"/>   
									</option>
							</c:forEach> 
						</select>
					&nbsp;&nbsp;<input type="submit" id="sub" value="确定" class="sub" />
					<br>
						&nbsp;&nbsp;<span id="errorInfo" style="color:red"></span>
					</p>
				</s:form>
		</div>
	
	</body>
		<script type="text/javascript">
		function showDivAlert(val)
		{
			document.getElementById("flowInstId").value = val;
			document.getElementById("errorInfo").innerHTML="";
			setAlertStyle('alert');;
		}
		
		function checkUnit(){
			if(document.getElementById("unitCode").value.length == 0){
				document.getElementById("errorInfo").innerHTML="* 请选择机构";
				return false;
			}
			return true;
		}

		function openNewWindow(winUrl,winName,winProps){
    		if(winProps =='' || winProps == null){
    			winProps = 'height=800px,width=700px,directories=false,location=false,top=100,left=500,menubar=false,Resizable=yes,scrollbars=yes,toolbar=false';
    		}
    		window.open(winUrl, winName, winProps);
    	}
	</script>
</html>
