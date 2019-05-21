<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
	<head>
	</head>

	<body>
		<%@ include file="/page/common/messages.jsp"%>
		
			 <fieldset style="padding:10px;display:block;margin-bottom:10px;">
	<legend style="padding:4px 8px 3px;"><b>处罚种类信息</b></legend>
	 <input  type="button" value="添加"  Class="btn" onclick="doAddType('${object.punishclassid}');"   />
	<ec:table action="punsih/pcdef!list.do" items="pctypesList" var="pctype"
			imagePath="${STYLE_PATH}/images/table/*.gif" showPagination="false" showStatusBar="false" showTitle="false">
			<ec:row>
				<c:set var="tpunishtypeid">处罚种类</c:set>	
				   <c:forEach var="row" items="${cp:DICTIONARY('punishType')}">
						<c:if test="${pctype.punishtypeid eq row.key}">
						<c:set var="punishtypename" value="${row.value}" />  
						</c:if>
					</c:forEach>
				<ec:column property="punishtypeid" title="${tpunishtypeid}" style="text-align:center" sortable="false">
				  <a href='#' onclick="editPcType('${pctype.punishclassid}','${pctype.punishtypeid}');">
                 <c:out value="${punishtypename}"/>
                  </a>
                </ec:column>
				<c:set var="tisinuse">是否使用</c:set>	
				<ec:column property="opt" title="${tisinuse}" style="text-align:center" sortable="false">
				   <c:if test="${pctype.isinuse==1}">正在使用</c:if>
				   <c:if test="${pctype.isinuse==0}">停止使用</c:if>
				</ec:column>
				<c:set var="tpunishmin">处罚下限</c:set>	
				<ec:column property="punishmin" title="${tpunishmin}" style="text-align:center" sortable="false">
				</ec:column>
				<c:set var="tpunishmax">处罚上限</c:set>	
				<ec:column property="punishmax" title="${tpunishmax}" style="text-align:center" sortable="false">
				</ec:column>
				<c:set var="tremark">备注</c:set>	
				<ec:column property="opt" title="${tremark}" style="text-align:center" sortable="false">
				<c:if test="${pctype.israte==1}">按比例计算</c:if>
				</ec:column>
		
				<c:set var="optlabel">操作</c:set>	
				<ec:column property="opt" title="${optlabel}" sortable="false" style="text-align:center">
					<a href='#'  onclick="IsInUse('${pctype.punishclassid}','${pctype.punishtypeid}','${pctype.isinuse}');">
					  <c:if test="${pctype.isinuse==1}">禁止</c:if>
				      <c:if test="${pctype.isinuse==0}">启用</c:if>
					</a>
				<a href='#' onclick="listfreeumpiretype('${pctype.punishclassid}','${pctype.punishtypeid}')">
					 设置自由裁量
					</a>
				</ec:column>
			</ec:row>
		</ec:table>
	</fieldset>			
		

	</body>
	<script type="text/javascript">
	    
     
    	function doAddType(punishclassid) {
			var url = "punish/pctype!edit.do?punishclassid=" + punishclassid ;
			window.parent.location.href=url;
		}
    /* 	function doFreeUmpire(punishclassid){
    		var url="punish/pcfreeumpiredegree!list.do?punishclassid="+ punishclassid;
    		window.parent.location.href=url;
    		
    	}    */
    	function IsInUse(punishclassid,punishtypeid,isinuse){
    		   var id;
    		   var url;
    		   if( isinuse=="1"){
    		     id="禁用";
    		   }else{
    		     id="启用";
    		   }
    		 if(window.confirm("是否要将相应的自由裁量"+id)){
    	         url="punish/pctype!editFreeumpireTypeIsInUse.do?punishclassid="+punishclassid+"&punishtypeid="+punishtypeid;
    	         document.location.href = url;
    		   }else{
    		      url="punish/pctype!editIsInUse.do?punishclassid="+punishclassid+"&punishtypeid="+punishtypeid;
    	     	  document.location.href = url;
    		   }
    	}
    	function listfreeumpiretype(punishclassid,punishtypeid){
    		var url = "punish/pcfreeumpiretype!list.do?punishclassid=" + punishclassid +"&punishtypeid="+punishtypeid;
    		window.parent.location.href = url;
    	} 
    	function editPcType(punishclassid,punishtypeid){
    		var url="punish/pctype!edit.do?punishclassid=" + punishclassid +"&punishtypeid="+punishtypeid;
    		parent.location.href = url;
    	}
    	
    	
    </script>	
</html>
