<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<%@page import="java.util.ArrayList"%>
<html>
	<head>
		<title>
			<s:text name="superviselog.list.title" />
		</title>
		<script type="text/javascript">
		 function resetForm(){
			 $('#s_begTime').val('');
			 $('#s_endTime').val('');
			 $('#s_optid').val('');
			 //$('#s_NP_jclog').val('');
			 //$('#s_NP_fzlog').val('');
			 $('#s_usercode').val('');
			 $('#s_bjType').val('');
		 }
		
		</script>
		<sj:head locale="zh_CN" />
		    <link href="<s:url value="/scripts/autocomplete/autocomplete.css"/>" type="text/css" rel="stylesheet">
    <script language="javascript" src="<s:url value="/scripts/autocomplete/autocomplete.js"/>" type="text/javascript"></script>
    <script language="javascript" src="<s:url value="/scripts/selectUser.js"/>" type="text/javascript"></script>
		 <script type="text/javascript" >
	        var list = [];
	        <c:forEach var="userinfo" varStatus="status" items="${cp:ALLUSER('T')}">
	            list[${status.index}] = { username:'<c:out value="${userinfo.username}"/>', loginname:'<c:out value="${userinfo.loginname}"/>', usercode:'<c:out value="${userinfo.usercode}"/>',pinyin:'<c:out value="${userinfo.usernamepinyin}"/>'  };
	        </c:forEach>
        function selectUser(obj) {
               userInfo.choose(obj, {dataList:list,userName:$('#userName')});
        }
        
        $(function(){$("tbody td").mouseover(function()
        		{
        		var inControl=$(this).children("a");
        		if (inControl.length==1 && inControl.html().replace(/& nbsp;/g, "")!="")
        		{
        		$(this).attr("title",inControl.html());
        		}
        		else if($(this).children().length==0 && $(this).html().replace(/& nbsp;/g, "")!="")
        		{
        		$(this).attr("title",$(this).html());
        		}
        		});
        		});   
        
    </script>
<style type="text/css">
		.search td{padding:0px 10px 0px 10px;}
		#ui-datepicker-div {z-index:25000 !important;}
</style>
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		
		<div class="search">
			<div class="crumbs">
				监察操作日志
			</div>
			
			<s:form action="superviselog" namespace="/monitor" style="margin-top:0;margin-bottom:5">
			<s:hidden name="s_NP_jclog" id="s_NP_jclog" value="%{#parameters['s_NP_jclog']}"></s:hidden>
		<s:hidden name="s_NP_fzlog" id="s_NP_fzlog" value="%{#parameters['s_NP_fzlog']}"></s:hidden>
				<table cellpadding="0" cellspacing="0" align="center">
				    <TR>
				       <td class="addTd">开始时间：</td>
				       <td><sj:datepicker name="s_begTime" id="s_begTime" readonly="true" value="%{#parameters['s_begTime']}" 
				       	yearRange="2010:2030" changeYear="true"  displayFormat="yy-mm-dd"/></td>
				       <td class="addTd">结束时间：</td>
				       <td><sj:datepicker name="s_endTime" id="s_endTime" readonly="true" value="%{#parameters['s_endTime']}"
				        yearRange="2010:2030" changeYear="true" displayFormat="yy-mm-dd"/></td>
				    </TR>
					<tr>
						<td class="addTd">操作人员：</td>
						<td><s:textfield name="s_usercode" id="s_usercode"onclick="selectUser(this);" value="%{#parameters['s_usercode']}"/> </td>
						<td class="addTd">项目模块：</td>
						<td>
							<select name="s_optid" id="s_optid">
							<option value="">全部</option>
							<c:forEach var="opt" items="${optIds }">
								<option value="${opt }" <c:if test="${opt eq param['s_optid'] }">selected="selected"</c:if>>${cp:MAPVALUE('optid',opt)}</option>
							</c:forEach>
						</select> 
					</td>
				    </tr>
				    <tr>
						<td class="addTd">日志类型：</td>
						<td><select name="s_bjType" id="s_bjType">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('bjType')}">
								<option value="${row.key}"
									<c:if test="${parameters.s_bjType[0] eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
					</select></td>
					<td colspan="2" align="center">
							<s:submit method="list"  key="opt.btn.query" cssClass="btn"/>
							<input type="button" name="reset" value="重置" class="btn" onclick="resetForm();"/>
						</td>
					
					</tr>
				</table>
			</s:form>
		</div>

		<ec:table action="monitor/superviselog!list.do" items="objList" var="superviselog"
			imagePath="${contextPath}/themes/css/images/table/*.gif" retrieveRowsCallback="limit">
			<ec:row >
				<ec:column property="rowCount" cell="rowCount" sortable="false" 
					title="序号" style="text-align:center"  width="5%"/>

				<ec:column property="usercode" title="操作人员" style="text-align:center" width="10%">
				${superviselog.usercode}[<c:out value="${cp:MAPVALUE('usercode',superviselog.usercode)}" />]</ec:column>
	
				<ec:column property="opttime" title="操作时间" style="text-align:center">
 					<fmt:formatDate value="${superviselog.opttime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</ec:column>

				<ec:column property="optid" title="项目模块" style="text-align:center"  width="10%">
					<c:out value="${cp:MAPVALUE('optid',superviselog.optid)}"></c:out>
				</ec:column>

				<ec:column property="optcontent" title="操作内容" style="text-align:center"/>
	
				<ec:column property="oldvalue" title="更改前原值" style="text-align:center"/>

				<ec:column property="bjType" title="日志类型" style="text-align:center" width="6%">
					${cp:MAPVALUE("bjType",superviselog.bjType)}
				</ec:column>
		
				<ec:column property="opt" title="操作" sortable="false"
					style="text-align:center"  width="5%">
					<a href='monitor/superviselog!view.do?logid=${superviselog.logid}&ec_p=${ec_p}&ec_crd=${ec_crd}'><s:text name="查看" /></a>
				</ec:column>
			</ec:row>
		</ec:table>
	</body>
</html>
