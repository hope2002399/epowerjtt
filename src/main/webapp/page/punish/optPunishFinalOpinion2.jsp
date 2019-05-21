<%@page import="com.goldgrid.weboffice.TemplateService"%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>

<html>
<head>

<style>
.VIPTITLE
{
	FONT-FAMILY: "宋体";
	FONT-SIZE: 12px;
	COLOR: #FF0000
}
</style>
<title>案件处罚信息</title>
<base target="_self">
</head>
<body>
<s:form onsubmit="return checkForm();"   action="podiscussbasic" method="post"  enctype="multipart/form-data"   >
			<input type="hidden" name="selFreeUmpire">
			<input type="hidden" name="punishobjectid" value="${object.punishobjectid}">
			<input type="hidden" name="item_id" value="${item_id}">
			<input type="hidden" name="podiscusstype" value="${discusstype}">
			
		
		<table cellpadding="0" cellspacing="0" align="center" class="table_b">
		<tr class="b_darkblue">
			<td width="5%">序号</td>
			<td>处罚项目名称</td>
			<td>项目代码</td>
			<td>处罚意见</td>
		</tr>
		<c:if test="${punishlist!=null}">
			<c:forEach var="potranslawbasic" items="${punishlist}" varStatus="status">
			<tr class="b_gray">
				<td align="center" width="5%">${status.index+1}</td>
				<td align="center">${potranslawbasic.pcdef.punishclassname}</td>
				<td align="center">${potranslawbasic.pcdef.punishclasscode}</td>
				<td align="center" <c:if test="${potranslawbasic.issurpass eq 1}">class="VIPTITLE" </c:if>>${potranslawbasic.result}</td>
			</tr>
			</c:forEach>
	   </c:if>
			</table>
				<table cellpadding="0" cellspacing="0" align="center" class="table_b">
							<%int i = 0;%>
			<c:forEach var="dic" items="${punishalllist}" varStatus="status">
				<tr>
					    <input type="hidden" name="PunishType" value="${dic.id.datacode}"/>
					    <input type="hidden" name="PunishCode" value="${dic.extracode}"/>
						<input type="hidden" name="PunishName" value="${dic.datavalue}"/>
						<td width="2%"><input type="checkbox" name="select" onclick="javascript:selectd('${status.index}');" <c:if test="${dic.popunishbasic!=null}">checked </c:if>/></td>
						<td width="45%" align="center">${dic.datavalue}</td>
						<td width="45%" align="center">
						<c:if test="${dic.popunishbasic==null}">
						<input type="text" name="Punishvlaue" disabled onchange="javascript:checkValue('<%=i++ %>');">
						</c:if>
						<c:if test="${dic.popunishbasic!=null}">
						<input type="text" name="Punishvlaue" <c:if test="${dic.popunishbasic.punishvalue ne ''}"> value='${dic.popunishbasic.punishvalue}'</c:if>  onchange="javascript:checkValue('<%=i++ %>');"/>
						</c:if>
						</td>
						<td width="8%">
						<c:choose>
						<c:when test="${dic.extracode eq '3'}">
						元
						</c:when>
						<c:when test="${dic.extracode eq '6'}">
						天
						</c:when>
						<c:when test="${dic.extracode eq '7'}">
						天
						</c:when>
						<c:otherwise>
						&nbsp;
						</c:otherwise>
						</c:choose>
						</td>
			</tr>
			</c:forEach>
				<tr>
					<td colspan="4" align="center"><s:submit  name="saveAndSubmit" method="savepunishInfo" cssClass="btn" value="提 交" /></td>
				</tr>
			</table>


	</s:form>

</body>
<script language="JavaScript" type="text/JavaScript">
$(document).ready(
		function (){ 
      var result="${retresult}";
      if(result!=null&&result!=""){
    	  window.returnValue = result;
    	  window.close();
    	  }
      }
);
function selectd(){
	   if(!document.forms[0].select.length) {
	      if (document.forms[0].select.checked) {
	       if(document.forms[0].PunishCode.value=="3"||document.forms[0].PunishCode.value=="6"||document.forms[0].PunishCode.value=="7")
	        document.forms[0].Punishvlaue.disabled=false;
	      }else{
	         document.forms[0].Punishvlaue.vaue=="";
	         document.forms[0].Punishvlaue.disabled=true;
	      }
	   }else{
	       for(nIndex=0;nIndex<document.forms[0].select.length;nIndex++){
	         if (document.forms[0].select[nIndex].checked) {
	          if(document.forms[0].PunishCode[nIndex].value=="3"||document.forms[0].PunishCode[nIndex].value=="6"||document.forms[0].PunishCode[nIndex].value=="7")
	           document.forms[0].Punishvlaue[nIndex].disabled=false;
	         }else{
	            document.forms[0].Punishvlaue[nIndex].value=""
	            document.forms[0].Punishvlaue[nIndex].disabled=true;
	         }
	       }
	   }
	}
function IfChecked() {
	   //判断用户是否选择，是: true; 否: false;
	   var nIndex = 0;
	   var IsCheck = false;
	   if (!document.forms[0].select.length) {
	      if (document.forms[0].select.checked) {
		     IsCheck = true;
		  }
	   }
	   else {
	      for(nIndex=0; nIndex<document.forms[0].select.length; nIndex++) {
		     if (document.forms[0].select[nIndex].checked) {
			     IsCheck = true;
				 break;
			 }
		  }
	   }
	   return IsCheck;
	}
	function checkValue(index){
	var max,min,value,item;
	  if(!document.forms[0].select.length) {      
	      value=document.forms[0].Punishvlaue.value;
	      item=document.forms[0].PunishName.value;
	   }else{
	      value=document.forms[0].Punishvlaue[index].value;
	      item=document.forms[0].PunishName[index].value;
	   }
	   if(parseInt(value)<parseInt(0)){
	     alert(item+"所填数值应为不小于0,请重新填写");
	   if(!document.forms[0].select.length) {
	      document.forms[0].Punishvlaue.value="";
	      document.forms[0].Punishvlaue.focus();
	   }else{
	      document.forms[0].Punishvlaue[index].value="";
	      document.forms[0].Punishvlaue[index].focus();
	   }
	   return;
	   }
	   return;
	}
	function savelkm(){
	   if(!IfChecked()){
	    alert("请选择处罚类型");
	    return;
	  }
	  var id="";
	  if(!document.forms[0].select.length){
	        if(document.forms[0].PunishCode.value=="3"||document.forms[0].PunishCode.value=="6"||document.forms[0].PunishCode.value=="7"){
	           if(document.forms[0].Punishvlaue.value==""){
	              alert("请输入"+document.forms[0].PunishName.value+"数值");
	              document.forms[0].Punishvlaue.focus();
	              return;
	           }else{
	              if(!isNumber(document.forms[0].Punishvlaue.value)){
	                alert("输入的\""+document.forms[0].PunishName.value+"\"数据为数字型数据");
	                return;
	              }
	           }
	           id=document.forms[0].PunishType.value+"&"+document.forms[0].Punishvlaue.value;
	        }else{
	          id=document.forms[0].PunishType.value+"&-";
	        }
	    }else{
	       for(nIndex=0;nIndex<document.forms[0].select.length;nIndex++){
	          if(document.forms[0].select[nIndex].checked){
	           if(id==""){
	             if(document.forms[0].PunishCode[nIndex].value=="3"||document.forms[0].PunishCode[nIndex].value=="6"||document.forms[0].PunishCode[nIndex].value=="7"){
	               
	               if(document.forms[0].Punishvlaue[nIndex].value==""){
	                  alert("请输入"+document.forms[0].PunishName[nIndex].value+"数值");
	                  document.forms[0].Punishvlaue[nIndex].focus();
	                  return;
	                }else{
	                  if(!isNumber(document.forms[0].Punishvlaue[nIndex].value)){
	               
	                    alert("输入的\""+document.forms[0].PunishName[nIndex].value+"\"数据为数字型数据");
	                    return;
	                   }
	                   
	                }
	               
	               id=document.forms[0].PunishType[nIndex].value+"&"+document.forms[0].Punishvlaue[nIndex].value;
	             }else {
	               id=document.forms[0].PunishType[nIndex].value+"&-";
	             }
	            }else{
	               if(document.forms[0].PunishCode[nIndex].value=="3"||document.forms[0].PunishCode[nIndex].value=="6"||document.forms[0].PunishCode[nIndex].value=="7"){
	               if(document.forms[0].Punishvlaue[nIndex].value==""){
	                   alert("请输入"+document.forms[0].PunishName[nIndex].value+"数值");
	                   document.forms[0].Punishvlaue[nIndex].focus();
	                   return;
	                }
	               id=id+","+document.forms[0].PunishType[nIndex].value+"&"+document.forms[0].Punishvlaue[nIndex].value;
	             }else {
	               id=id+","+document.forms[0].PunishType[nIndex].value+"&-";
	             }
	            }
	          }
	       }
	    }
	    window.returnValue = id;
	    window.close();
	}
	function isNumber(inputVal) {
		oneDecimal = false;
		if(inputVal=="")
		  return false;
		inputStr = inputVal.toString();
		for (var i = 0; i < inputStr.length; i++) {
			var oneChar = inputStr.charAt(i);
			if (i == 0 && oneChar == "-") {
				continue;
			}
			if (oneChar == "." && !oneDecimal) {
				oneDecimal = true;
				continue;
			}
			if (oneChar < "0" || oneChar > "9") {
				return false;
			}
		}
		return true;
	}
	
	
	function checkForm(){


		   if(!IfChecked()){
		    alert("请选择处罚类型");
		    return false;
		  }
		  var id="";
		  if(!document.forms[0].select.length){
		        if(document.forms[0].PunishCode.value=="3"||document.forms[0].PunishCode.value=="6"||document.forms[0].PunishCode.value=="7"){
		           if(document.forms[0].Punishvlaue.value==""){
		              alert("请输入"+document.forms[0].PunishName.value+"数值");
		              document.forms[0].Punishvlaue.focus();
		              return false;
		           }else{
		              if(!isNumber(document.forms[0].Punishvlaue.value)){
		                alert("输入的\""+document.forms[0].PunishName.value+"\"数据为数字型数据");
		                return false;
		              }
		           }
		           id=document.forms[0].PunishType.value+"&"+document.forms[0].Punishvlaue.value;
		        }else{
		          id=document.forms[0].PunishType.value+"&-";
		        }
		    }else{
		       for(nIndex=0;nIndex<document.forms[0].select.length;nIndex++){
		          if(document.forms[0].select[nIndex].checked){
		           if(id==""){
		             if(document.forms[0].PunishCode[nIndex].value=="3"||document.forms[0].PunishCode[nIndex].value=="6"||document.forms[0].PunishCode[nIndex].value=="7"){
		               
		               if(document.forms[0].Punishvlaue[nIndex].value==""){
		                  alert("请输入"+document.forms[0].PunishName[nIndex].value+"数值");
		                  document.forms[0].Punishvlaue[nIndex].focus();
		                  return false;
		                }else{
		                  if(!isNumber(document.forms[0].Punishvlaue[nIndex].value)){
		               
		                    alert("输入的\""+document.forms[0].PunishName[nIndex].value+"\"数据为数字型数据");
		                    return false;
		                   }
		                   
		                }
		               
		               id=document.forms[0].PunishType[nIndex].value+"&"+document.forms[0].Punishvlaue[nIndex].value;
		             }else {
		               id=document.forms[0].PunishType[nIndex].value+"&-";
		             }
		            }else{
		               if(document.forms[0].PunishCode[nIndex].value=="3"||document.forms[0].PunishCode[nIndex].value=="6"||document.forms[0].PunishCode[nIndex].value=="7"){
		               if(document.forms[0].Punishvlaue[nIndex].value==""){
		                   alert("请输入"+document.forms[0].PunishName[nIndex].value+"数值");
		                   document.forms[0].Punishvlaue[nIndex].focus();
		                   return false;
		                }
		               id=id+","+document.forms[0].PunishType[nIndex].value+"&"+document.forms[0].Punishvlaue[nIndex].value;
		             }else {
		               id=id+","+document.forms[0].PunishType[nIndex].value+"&-";
		             }
		            }
		          }
		       }
		    }
		  document.forms[0].selFreeUmpire.value=id;
		  return true;
		}
	
</script>
</html>