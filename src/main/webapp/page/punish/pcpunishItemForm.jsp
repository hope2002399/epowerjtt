<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%> 
<html>
<head>
<title><s:text name="pcpunishItem.edit.title" /></title>
</head>

<body>
<p class="ctitle"><s:text name="pcpunishItem.edit.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<s:form action="pcpunishItem"  method="post" namespace="/punish" id="pcpunishItemForm" onsubmit="return validatepcpunishItemForm(this);" >
	<s:submit name="save"  method="save" cssClass="btn" key="opt.btn.save" />
		<input type="button" Class="btn"  onclick="window.history.back()" value="返回" />  
		<input type="hidden"  name="punishclasscode"  id="punishclasscode"  value="${object.punishclasscode}" />
		<input type="hidden"  name="version"  id="version"  value="${object.version}" />
    <fieldset style="padding:10px;display:block;margin-bottom:10px;">
	<legend style="padding:4px 8px 3px;"><b>处罚项目类别基本信息</b></legend>
			<table border="0" cellpadding="0" cellspacing="0" class="viewTable">	
                <tr>
					<td class="addTd" >
						类别名称
					</td>
	             <td align="left" colspan="3">
	                     <s:textfield name="punishclassname" value="%{object.punishclassname}" />  
	               
					</td>
					
				</tr>
				<tr>
					<td class="addTd" width="130">主办部门</td>
				   <td align="left" colspan="3"><select name="depid">
						<option value="">--请选择--</option>
						<c:forEach var="row" items="${cp:LVB('unitcode')}">
							<option value="${row.value}"
								<c:if test="${object.depid eq row.value}">selected="selected"</c:if>>
								<c:out value="${row.label}" />
							</option>
						</c:forEach>
				     </select><span style="color: red">*</span>
				   </td>
				</tr>

				<tr>
					<td class="addTd">
						处罚对象
					</td>
					<td align="left">
					<%--  <s:checkboxlist list="#{0:'个人',1:'组织机构'}"   name="punishobject" value="%{object.punishobject}"></s:checkboxlist> --%>
					 <s:checkboxlist list="#{'0':'个人','1':'组织机构'}"   name="punishobjectList" value="%{punishobjectList}"></s:checkboxlist> 
					
					</td>
					<td class="addTd">
						 是否使用中
					</td>
					<td align="left"><s:radio name="isinuse"
						list="#{'1':'是','0':'否'}" value="%{object.isinuse}" listKey="key" listValue="value"/>
					</td>
					</tr>
				<tr>
					<td class="addTd">
						 是否诉讼
					</td>
					<td align="left"><s:radio name="islawsuit"
						list="#{'1':'是','0':'否'}" value="%{object.islawsuit}" listKey="key" listValue="value"/>
					</td>
						<td class="addTd">
				                是否复议
					</td>
					<td align="left"><s:radio name="isreconsider"
						list="#{'1':'是','0':'否'}" value="%{object.isreconsider}" listKey="key" listValue="value"/>
					</td>
				</tr>
				<tr>
					<td class="addTd">
					    法律依据
					</td>
					<td align="left" colspan="3">
		                  <s:textarea name="punishbasis" value="%{object.punishbasis}" style="width:100%;height:40px;"/>
					</td>
				</tr>
                <tr>
					<td class="addTd">
					    法律条文
					</td>
					<td align="left" colspan="3">
		                  <s:textarea name="punishbasiscontent" value="%{object.punishbasiscontent}" style="width:100%;height:40px;"/>
					</td>
				</tr>
                <tr>
					<td class="addTd">
					    备注
					</td>
					<td align="left" colspan="3">
		                  <s:textarea name="remark" value="%{object.remark}" style="width:100%;height:40px;"/>
					</td>
				</tr>
				</table>
  </fieldset>
  <c:if test="${not empty object.punishclassid }" >
  <div>
 	<iframe id="itemFrame_pcTYpe" src="punish/pcpunishStandard!listPcType.do?punishclassid=${object.punishclassid}"   frameborder="0" width="100%" scrolling="no" 
		 onload="this.height=window.frames['itemFrame_pcTYpe'].document.body.scrollHeight"></iframe>
	
</div>
<div>
 	<iframe id="itemFrame_pcFreeumpireDegree" src="punish/pcfreeumpiredegree!list.do?punishclassid=${object.punishclassid}"   frameborder="0" width="100%" scrolling="no" 
		 onload="this.height=window.frames['itemFrame_pcFreeumpireDegree'].document.body.scrollHeight"></iframe>

</div>
</c:if>
</s:form>




	<script type="text/javascript">
	    
     
    	function doAddType(punishclassid) {
			var url = "punish/pcpunishStandard!edit.do?punishclassid=" + punishclassid ;
			document.location.href = url;
		}
    	function doFreeUmpire(punishclassid){
    		var url="punish/pcfreeumpiredegree!list.do?punishclassid="+ punishclassid;
     	   document.location.href = url;
    		
    	}   
    	function IsInUse(punishclassid,punishtypeid,isinuse){
    		   var id;
    		   var url;
    		   if( isinuse=="1"){
    		     id="禁用";
    		   }else{
    		     id="启用";
    		   }
    		 if(window.confirm("是否要将相应的自由裁量"+id)){
    	         url="punish/pcpunishStandard!editFreeumpireTypeIsInUse.do?punishclassid="+punishclassid+"&punishtypeid="+punishtypeid;
    	         document.location.href = url;
    		   }else{
    		      url="punish/pcpunishStandard!editIsInUse.do?punishclassid="+punishclassid+"&punishtypeid="+punishtypeid;
    	     	  document.location.href = url;
    		   }
    	}
    </script>	


</body>
</html>
