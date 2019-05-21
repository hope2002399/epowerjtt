<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>

<html>
<head>
<title></title>
<%@ include file="/page/common/messages.jsp"%>
</head>
<body>
	<s:form id="lkmform" action="punishobjectbasic" namespace="/punish"	style="margin-top:0;margin-bottom:5">
	<input type="hidden" name="selfreeumpire">
	<input type="hidden" name="documentTemplateIds" value="${documentTemplateIds}">
	<input type="hidden" name="isJD" value="${isJD}">
			<table border="0" cellpadding="0" cellspacing="0" id="tb"
				class="viewTable" style="margin-top: 20px;">
				
				<%-- <tr>
					<td class="addTd">案由<font color="red">*</font></td>
					<td align="left">
						<select name="punishobjectbrief" id="popunishObjectBrief">
							<option value="">--请选择--</option>
							<c:forEach var="row" items="${cp:DICTIONARY('anyou')}">
								<option value="${row.key}" label="${row.value}" <c:if test="${object.punishobjectbrief eq row.key}"> selected = "selected" </c:if>>
									<c:out value="${row.value}" />
								</option>
							</c:forEach>
						</select>
					</td>
				</tr> --%>
				
				<tr id="punishClassName">
					<td class="addTd">处罚项目名称<font color="red">*</font>
					</td>
					<td align="left"><s:textfield id="itemName" value="%{object.vorgsuppower.itemName}" name="vorgsuppower.itemName"
							cssStyle="width:380px" readonly="true"></s:textfield>
						<input type="button" class='btn' onclick="choseQL();" value="选择"/>
						<input type="hidden" id="itemId"  name="item_id" value="${object.vorgsuppower.itemId}"/>
						<input type="hidden" id="version" name="version" value="${object.vorgsuppower.version}">
						<input type="hidden"  name="issurpass" value="${object.issurpass}"/>
				</tr>

				<tr id="poRegisterBas">
					<td class="addTd">相关的法律依据</td>
					<td align="left"><s:textarea id="poRegisterBasis"
							value="%{object.vorgsuppower.punishbasis}" style="width:60%;"
							name="object.vorgsuppower.punishbasis" readonly="true" /></td>
				</tr>
				<c:if test="${fn:length(degreelist)>0}">
				<tr>
				<td class="addTd">
				违法程度选择<font color="red">*</font>
				<input type="hidden"  name="punishobjectid" value="${object.punishobjectid}"/>
				</td><td align="left">
					<select id="degreeno" name="degreeNo" onchange="selDegree();">
				       <option value="-1">--请选择违法程度--</option>
				        <c:forEach var="degree" items="${degreelist}">
						<option value="${degree.cid.degreeno}" <c:if test="${degreeno eq degree.cid.degreeno}"> selected = "selected" </c:if> >
						<c:out value="${degree.punishfactgrade}" /></option>							
					</c:forEach>
					
			</select>
			</td>
			</tr>
				</c:if>
										<tr>
						<td class="addTd">
							处罚决定<font color="red">*</font>
						</td>
					
						<td colspan="3">
						<c:if test="${object.issurpass eq 1}">
							 <input  style="color:#FF0000" size="100" name="discussresult" value="${discussresult}">
						</c:if>
						<c:if test="${object.issurpass ne 1}">
						   <input size="100" name="discussresult" value="${discussresult}">
						</c:if>
							&nbsp;&nbsp;
						<input type="button" class="btn" value="..." onClick="showFreeUmpireList();"  />
						</td>					
						</tr>
						<tr>
						<td class="addTd">处罚金额</td>
			<td colspan="3"><input size="50" name="punishamout" value="${punishamout}"> 元</td>
			</tr>
			<%-- <tr><td class="addTd">其他处罚项目</td>
			<td colspan="3"><input size="50" name="otherpunish" value="${otherpunish}"></td>
		</tr> --%>	
		<c:if test="${templateFromNode eq 'TRUE'}">
		<input type="hidden" id="curTemplateId" name="curTemplateId"  value="" />
		<input type="hidden" id="archiveType" name="archiveType"  value="" />
					<tr>
						<td class="addTd" width="140">办理文书<font color="red">*</font></td>
						<td align="left">			
							<c:forEach var="temp" items="${templateFileList}">
							<div id="${temp.tempType}">
							<a href="javascript:void(0);" onclick="openDocNodeEdit('${temp.recordId}','${temp.tempType}');" class="btnA">
								<span id="${temp.tempType}" class="btn">
								<c:choose>
									<c:when test="${fn:length(temp.descript) > 8}">
										<c:out value="${fn:substring(temp.descript, 0, 8)}..." />
									</c:when>
									<c:otherwise>
										<c:out value="${temp.descript}" />
									</c:otherwise>
								</c:choose>
								</span></a>
								</div>
							</c:forEach>
					   </td>
					</tr>
				</c:if>
				</table>
	</s:form>
</body>
<script>
function selDegree(){
	var degreeno=document.getElementById("degreeno").value;
	var form=document.getElementById("lkmform");
	form.action="punishobjectbasic!seldegreefacilitydes.do?degreeno="+degreeno;     
    form.submit();
}
function IsInUse(punishclassid,punishtypeid,degreeno,isPctype){
	var url="punish/pcfreeumpiretype!editIsInUse.do?punishclassid="+ punishclassid+"&punishtypeid="+punishtypeid+"&degreeno="+degreeno+"&isPctype="+isPctype;
	   document.location.href = url;
}   
function choseQL(){
<%-- var punishobjectbrief_=lkmform.punishobjectbrief.value;
	if(punishobjectbrief_==''){
	alert("请选择案由!");
	}else{
		openNewWindow_("<%=request.getContextPath()%>/powerbase/supPower!listSupPower_CF_faci.do?documentTemplateIds=${documentTemplateIds}&isJD=${isJD}&punishobjectid=${object.punishobjectid}&itemType=CF&s_itemType=CF&s_orgId=${session.SPRING_SECURITY_CONTEXT.authentication.principal.primaryUnit}&s_subitemtype="+lkmform.punishobjectbrief.value+"&subitemtype="+lkmform.punishobjectbrief.value+"",
							"powerWindow",null);
			} --%>
	openNewWindow_("<%=request.getContextPath()%>/powerbase/supPower!listSupPower_CF_faci.do?documentTemplateIds=${documentTemplateIds}&isJD=${isJD}&punishobjectid=${object.punishobjectid}&itemType=CF&s_itemType=CF&s_orgId=${session.SPRING_SECURITY_CONTEXT.authentication.principal.primaryUnit}"+"",
						"powerWindow",null);
}

function showFreeUmpireList(){
	  var punishobjectid ="${object.punishobjectid}";
	  var punishclassid ="${object.item_id}";
	  var degreeno ="${degreeno}";
	  
	  /* var punishobjectbrief_=lkmform.punishobjectbrief.value;
	  if(punishobjectbrief_==""){
		  alert("请选择案由!");
		  return;
	  } */
	  if(punishclassid==null||punishclassid==""){
		  alert("请先选择处罚项目");
		  return;
	  }
	  /* if(degreeno==null||degreeno==""){
		  alert("请先选择自由裁量");
		  return;
	  } */
	  var contextpath="${pageContext.request.contextPath}";

      //var url=contextpath+"/punish/poindagaterepbasic!showPunishOpinion.do?punishobjectid="+punishobjectid+"&punishclassid="+punishclassid+"&degreeno="+degreeno
      var url2=contextpath+"/punish/poindagaterepbasic!showPunishOpinion2.do?punishobjectid="+punishobjectid+"&punishclassid="+punishclassid+"&degreeno="+degreeno+"&item_id="+punishclassid;	
      id = window.showModalDialog(url2,window,"dialogHeight:450px;dialogWidth:850px;center:yes;help:no;scroll:yes;status:no;edge:raised");
      //window.open(url2);
	  if (id != undefined && id!=""){
	    //document.lkmform.selfreeumpire.value = id;
	     var form=document.getElementById("lkmform");
	    //document.lkmform.action="punishobjectbasic!savefreeumpire.do?punishobjectid="+punishobjectid+"&degreeno="+degreeno;     
	    document.lkmform.action="punishobjectbasic!savefreeumpire.do?degreeno="+degreeno;
	    form.submit();  
	   /*  alert(id);
	    var selfreeumpire_=encodeURI(id);  
	    alert(selfreeumpire_);
	    var url_="punishobjectbasic!savefreeumpire.do?punishobjectid="+punishobjectid+"&degreeno="+degreeno+"&selfreeumpire="+selfreeumpire_+"&item_id="+punishclassid;
	   document.location.href = url_; */
	  }
	}
/* function returnEdit(){
	   window.parent.frames['edit'].document.forms[0].submit();
 } */
$(document).ready(function() {
var isJD='${isJD}'
if ('T' != isJD) {
	$("#cf_dccf").hide();
	}

});
function openDocNodeEdit(val,documentType){
	var archiveType =documentType;
	var uri = "<%=request.getContextPath()%>/iWebOffice/DocumentEdit.jsp";
	var param = "flowStep=ZW_EDIT&RecordID=${object.punishobjectid}&Template=" + val +"&archiveType="+archiveType
	 			+"&NeedBookMark=1";	
	openNewWindow(uri + "?"+ param,'editForm','');
}

function openNewWindow_(winUrl,winName,winProps){
		if(winProps =='' || winProps == null){
			winProps = 'height=700px,width=800px,directories=false,location=false,top=100,left=500,menubar=false,Resizable=yes,scrollbars=yes,toolbar=false';
		}
		
		window.open(winUrl, winName, winProps);
	}
</script>
<script type="text/javascript">

function getOptBaseInfoJson(){	
	return getOptCommonBizJson();
}

function getOptCommonBizJson(){
	return ${optCommonBizJson};
}
</script>
</html>

