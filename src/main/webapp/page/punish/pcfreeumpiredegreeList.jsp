<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
		<title><c:out value="pcfreeumpiredegree.list.title" /></title>
	
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		
	 <fieldset style="padding:10px;display:block;margin-bottom:10px;">
	      <legend style="padding:4px 8px 3px;"><b>违法事实程度</b></legend>
			 <input  type="button" value="添加"  Class="btn" onclick="doAdd('${pcdef.punishclassid}');"   />	
				
			<ec:table action="pcfreeumpiredegree!list.do" items="pcfreeumpiretypesList" var="pcfreeumpiredegree"
			imagePath="${STYLE_PATH}/images/table/*.gif" showPagination="false" showStatusBar="false" showTitle="false">
			<ec:row>
                
				<c:set var="tdegreeNo">编号</c:set>	
				<ec:column property="degreeno" title="${tdegreeNo}" style="text-align:center" sortable="false" />

				<c:set var="tpunishfactgrade">违法事实程度 </c:set>	
				<ec:column property="opt" title="${tpunishfactgrade}" style="text-align:center" sortable="false" >
	            <a href='#' onclick="parent.location.href='pcfreeumpiredegree!edit.do?punishclassid=${pcfreeumpiredegree.punishclassid}&degreeno=${pcfreeumpiredegree.cid.degreeno}'">
				<c:out value="${pcfreeumpiredegree.punishfactgrade}" />
				</a>
				</ec:column>
				
				<c:set var="optlabel">操作</c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false"  style="text-align:center">
				<a href='#' onclick="IsInUse('${pcfreeumpiredegree.punishclassid}','${pcfreeumpiredegree.degreeno}');">
				  <c:if test="${pcfreeumpiredegree.isinuse==1}">禁止</c:if>
				  <c:if test="${pcfreeumpiredegree.isinuse==0}">启用</c:if>
				</a>
				<a href='#' onclick="dopcfreeumpiretype('${pcfreeumpiredegree.punishclassid}','${pcfreeumpiredegree.degreeno}');">
				  设置自由裁量
				</a>
				</ec:column>

			</ec:row>
		</ec:table>
	</fieldset>

	  <script>	
	function doAdd(punishclassid){
			var url = "punish/pcfreeumpiredegree!edit.do?punishclassid=" + punishclassid ;
			window.parent.location.href = url;
		}
	function IsInUse(punishclassid,degreeno){
		var url = "punish/pcfreeumpiredegree!editIsInUse.do?punishclassid=" + punishclassid +"&degreeno="+degreeno;
		document.location.href = url;
	}
	/* function toRerurn(punishclasscode){
		var url = "punish/pcdef!edit.do?punishclasscode=" + punishclasscode ;
		document.location.href = url;
	} */
	function dopcfreeumpiretype(punishclassid,degreeno){
		var url = "pcfreeumpiretype!list.do?punishclassid="+punishclassid+ "&degreeno="+degreeno;
		window.parent.location.href = url;
	}
     
    </script>	
	</body>
</html>
