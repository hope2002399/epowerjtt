<%@page import="com.goldgrid.weboffice.TemplateService"%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>

<html>
<head>

<title>案件处罚信息</title>
<base target="_self">
</head>
<body>
<s:form  onsubmit="return checkForm();" action="podiscussbasic" method="post" enctype="multipart/form-data" styleId="frmDiscuss"  >
		<input type="hidden" name="selFreeUmpire" >
					<input type="hidden" name="punishobjectid" value="${object.punishobjectid}">
			<input type="hidden" name="item_id" value="${item_id}">
			<input type="hidden" name="podiscusstype" value="${discusstype}">
				<input type="hidden" name="degreeNo" value="${degreeno}">
		<table cellpadding="0" cellspacing="0" align="center" class="table_b">
			<tr height="20">
				<td width="20%" class="ftitle">处罚项目</td>
				<td>${vorgsuppower.itemName}</td>
			</tr>
			<tr height="20">
				<td width="20%" class="ftitle">项目处罚方式</td>
				<td>${punishway}&nbsp;</td>
			</tr>

			<c:if test="${listfreeumprie!=null}">
				<tr height="20">
					<td colspan="2">
						<table cellpadding="5" cellspacing="0">
							<tr>
								<td colspan="2" class="ftitle">自由裁量标准参考</td>
							</tr>
							<c:forEach var="pcfreeumprietype" items="${listfreeumprie}" varStatus="status">
								<tr>
									<td width="50%" align="center"><c:if
											test="${pcfreeumprietype.isinuse eq 1}">
											<font color="blue">
										</c:if>${pcfreeumprietype.punishfactgrade}</td>
									<td width="50%" align="left"><c:if
											test="${pcfreeumprietype.isinuse eq 1}">
											<font color="blue">
										</c:if>${pcfreeumprietype.remark}</td>
								</tr>
							</c:forEach>
							<tr>
								<td align="right
					" colspan="2"><font color="blue">说明：蓝色代表已选定的自由裁量以及参考标准</font></td>
							</tr>
						</table>


			</c:if>
			<tr>
			<td colspan="2">
			<table cellpadding="0" cellspacing="0">
			<c:forEach var="pctype" items="${listpctype}" varStatus="status">
			<tr>
				<input type="hidden" name="PunishType" value="${pctype.punishtypeid}" />
			    <input type="hidden" name="Punishmax" value="${pctype.toplimit}" />
			    <input type="hidden" name="Punishmin" value="${pctype.lowlimit}" />
				<input type="hidden" name="PunishName" value="${cp:MAPVALUE('punishType',pctype.punishtypeid)}" />
				<input type="hidden" name="chargeMax" value="${pctype.baseToplimit}" />
			    <input type="hidden" name="chargeMin" value="${pctype.baseLowlimit}" />
			    <input type="hidden" name="punishtype" value="${pctype.punishtype}" />
			    
			
			<td width="2%">
	        <input type="checkbox" name="select" onclick="javascript:selectd('${status.index}');" <c:if test="${!empty pctype.popunishbasic}">checked</c:if>/>
	            
           </td>
           <td width="45%" align="center">${cp:MAPVALUE("punishType",pctype.punishtypeid)}<c:if test="${pctype.punishtype!=null and pctype.israte eq '1'}"> (${pctype.baseName})</c:if></td>
           	<td width="45%" align="center">
      	<c:if test="${empty pctype.popunishbasic}"> 
           		<c:choose>         	
           	  <c:when test="${pctype.israte eq '1'}">
           	    <input type="hidden" name="isRate" value="1"/>
				<input type="text" name="radix" size="5%" value="${pctype.poradixbasic.radix}" onBlur="javascript:updatevlaue('${status.index}')"> *  <input type="text" name="multiple" size="5%" value="${pctype.poradixbasic.multiple}" onBlur="javascript:updatevlaue('${status.index}')"> 倍 = <input type="text" name="Punishvlaue" size="8%" value="${pctype.popunishbasic.punishvalue}"  readonly>
           	  </c:when>
           	  
           	    <c:otherwise>
           	    <input type="hidden" name="isRate" value="0"/>
				<input type="hidden" name="radix">
				<input type="hidden" name="multiple">
           	<input type="text" name="Punishvlaue" size="40%" onBlur="javascript:checkValue('${status.index}');" disabled>
           	</c:otherwise>
           	</c:choose>
           	</c:if>
       <c:if test="${!empty pctype.popunishbasic}">   
       	<c:choose>         	
           	  <c:when test="${pctype.israte eq '1'}">
           	    <input type="hidden" name="isRate" value="1"/>
				<input type="text" name="radix" size="5%" value="${pctype.poradixbasic.radix}" onBlur="javascript:updatevlaue('${status.index}')">*<input type="text" name="multiple" size="5%" value="${pctype.poradixbasic.multiple}" onBlur="javascript:updatevlaue('${status.index}')"> 倍 = <input type="text" name="Punishvlaue" size="8%" value="${pctype.popunishbasic.punishvalue}"  readonly>
           	  </c:when>
           	  
           	    <c:otherwise> 
           	     <input type="hidden" name="isRate" value="0"/>
				<input type="hidden" name="radix">
				<input type="hidden" name="multiple">   
				<input type="text" name="Punishvlaue" size="40%" value="${pctype.popunishbasic.punishvalue}" onBlur="javascript:checkValue('${status.index}');">   
       			</c:otherwise>
           	</c:choose>
       </c:if>
   </td>
   						<td width="8%">
   						<c:choose>
   						<c:when test="${pctype.punishtypeid eq amercecode}">
   						元
   						</c:when>
   						<c:when test="${pctype.punishtypeid eq shutoutcode}">
   						天
   						</c:when>
   						<c:when test="${pctype.punishtypeid eq detentioncode}">
   						天
   						</c:when>
   						</c:choose>
   					
   						</td>
   </tr>
   
           </tr>
			</c:forEach>
							<tr>
					<td colspan="4" align="center">		<s:submit name="saveAndSubmit" method="savepunishInfo" cssClass="btn" value="提 交" /></td>
				</tr>
			</table>

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
function selectd(i){
  if(!document.forms[0].select.length){
    if(document.forms[0].select.checked){
    if("-"!=document.forms[0].Punishmin.value){
            if(document.forms[0].isRate.value=="1"){
           document.forms[0].radix.disabled=false;
           document.forms[0].multiple.disabled=false;
         }else{ 
           document.forms[0].Punishvlaue.disabled=false;
           document.forms[0].Punishvlaue.value="0";
          } 
      }
    }else{
    	
      if("-"!=document.forms[0].Punishmin.value){
         if(document.forms[0].isRate.value=="1"){
           document.forms[0].radix.disabled=true;
           document.forms[0].multiple.disabled=true;
           document.forms[0].radix.value="";
           document.forms[0].multiple.value="";
           document.forms[0].Punishvlaue.value="";
         }else{ 
           document.forms[0].Punishvlaue.disabled=true;
           document.forms[0].Punishvlaue.value="";
          } 
      }
    }
  }else{

    if(document.forms[0].select[i].checked){
    if("-"!=document.forms[0].Punishmin[i].value){
           if(document.forms[0].isRate[i].value=="1"){
           document.forms[0].radix[i].disabled=false;
           document.forms[0].multiple[i].disabled=false;
         }else{ 
           document.forms[0].Punishvlaue[i].disabled=false;
           document.forms[0].Punishvlaue[i].value="0";
          } 
      }
    }
    else{
      if("-"!=document.forms[0].Punishmin[i].value){
        if(document.forms[0].isRate[i].value=="1"){
           document.forms[0].radix[i].disabled=true;
           document.forms[0].multiple[i].disabled=true;
           document.forms[0].radix[i].value="";
           document.forms[0].multiple[i].value="";
           document.forms[0].Punishvlaue[i].value="";
         }else{
           document.forms[0].Punishvlaue[i].disabled=true;
           document.forms[0].Punishvlaue[i].value="";
         }
      }
    }
  }  
}
function updatevlaue(i){
	
   var radix="";
   var multiple="";
   var Punishvlaue="";
   if(!document.forms[0].select.length){
     radix=document.forms[0].radix.value;
     multiple=document.forms[0].multiple.value;
     if(radix!=""&&multiple!=""){
       if(!isNumber(radix)){
         alert("此项为数字数据");
         document.forms[0].radix.value="";
         document.forms[0].radix.focus();
         return;
       }
       if(Number(radix)<=0){
         alert("值为大于0的数");
         document.forms[0].radix.value="";
         document.forms[0].radix.focus();
         return;
       }
       if(!isNumber(multiple)){
         alert("倍数为数字数据");
         document.forms[0].multiple.value="";
         document.forms[0].multiple.focus();
         return;
       }
       if(Number(document.forms[0].Punishmax.value)!=0&&(Number(document.forms[0].Punishmin.value)>multiple||Number(document.forms[0].Punishmax.value)<multiple)){
         alert(document.forms[0].PunishName.value+"超越相应法定处罚内容,请重新填写");
         document.forms[0].multiple.value="";
         document.forms[0].Punishvlaue.value="";
         document.forms[0].multiple.focus();
         return;
        }else if(Number(document.forms[0].Punishmax.value)==0&&multiple<0){
         alert(document.forms[0].PunishName.value+"超越相应法定处罚内容,请重新填写");
         document.forms[0].multiple.value="";
         document.forms[0].Punishvlaue.value="";
         document.forms[0].multiple.focus();
         return;
        }
       Punishvlaue=Number(radix)*Number(multiple);
       if(document.forms[0].chargeMax.value!="" && document.forms[0].chargeMax[i].value!="-"){
          if(Number(document.forms[0].chargeMax.value)<multiple){
            alert("经计算"+document.forms[0].PunishName.value+"数额为"+multiple+",超越最大数额,请重新填写");
            Punishvlaue="";
          }
       }
        if(document.forms[0].chargeMin[i].value!="" && document.forms[0].chargeMin[i].value!="-"){
          if(Number(document.forms[0].chargeMin[i].value)>multiple){
            alert("经计算"+document.forms[0].PunishName[i].value+"数额为"+multiple+",低于最小数额,请重新填写");
            Punishvlaue="";
          }
       }
       document.forms[0].Punishvlaue.value=Punishvlaue;
     }else{
       return;
     }
   }else{
     radix=document.forms[0].radix[i].value;
     multiple=document.forms[0].multiple[i].value;
     if(radix!=""&&multiple!=""){
       if(!isNumber(radix)){
         alert("此项为数字数据");
         document.forms[0].radix[i].value="";
         document.forms[0].radix[i].focus();
         return;
       }
       if(Number(radix)<=0){
         alert("值为大于0的数");
         document.forms[0].radix[i].value="";
         document.forms[0].radix[i].focus();
         return;
       }
       if(!isNumber(multiple)){
         alert("倍数为数字数据");
         document.forms[0].multiple[i].value="";
         document.forms[0].multiple[i].focus();
         return;
       }
        if(document.forms[0].punishtype[i].value=='1'){
       if(Number(document.forms[0].Punishmax[i].value)!=0&&(Number(document.forms[0].Punishmin[i].value)>multiple||Number(document.forms[0].Punishmax[i].value)<multiple)){
         alert(document.forms[0].PunishName[i].value+"超越相应法定处罚内容,请重新填写");
         document.forms[0].multiple[i].value="";
         document.forms[0].Punishvlaue[i].value="";
         document.forms[0].multiple[i].focus();
         return;
       }else if(Number(document.forms[0].Punishmax[i].value)==0&&multiple<0){
         alert(document.forms[0].PunishName[i].value+"超越相应法定处罚内容,请重新填写");
         document.forms[0].multiple[i].value="";
         document.forms[0].Punishvlaue[i].value="";
         document.forms[0].multiple[i].focus();
         return;
       }
       }
       Punishvlaue=Number(radix)*Number(multiple);
       if(document.forms[0].chargeMax[i].value!="" && document.forms[0].chargeMax[i].value!="-"){
          if(Number(document.forms[0].chargeMax[i].value)<multiple){
            alert("经计算"+document.forms[0].PunishName[i].value+"数额为"+multiple+",超越最大数额,请重新填写");
            Punishvlaue="";
          }
       }
        if(document.forms[0].chargeMin[i].value!="" && document.forms[0].chargeMin[i].value!="-"){
          if(Number(document.forms[0].chargeMin[i].value)>multiple){
            alert("经计算"+document.forms[0].PunishName[i].value+"数额倍数为"+multiple+",低于最小数额,请重新填写");
            Punishvlaue="";
          }
       }
       document.forms[0].Punishvlaue[i].value=Punishvlaue;
     }else{
       return;
     }
   }
}


function checkValue(index){
  var max,min,value,item;
  if(!document.forms[0].select.length) {
      max=document.forms[0].Punishmax.value;
      min=document.forms[0].Punishmin.value;
      value=document.forms[0].Punishvlaue.value;
      item=document.forms[0].PunishName.value;
      if(!isNumber(value)){
       alert("输入的\""+document.forms[0].PunishName.value+"\"应为数字类型");
       document.forms[0].Punishvlaue.value="0";
       document.forms[0].Punishvlaue.focus();
       return;
      }
   }else{
      max=document.forms[0].Punishmax[index].value;
      min=document.forms[0].Punishmin[index].value;
      value=document.forms[0].Punishvlaue[index].value;
      item=document.forms[0].PunishName[index].value;
      if(!isNumber(value)){
       alert("输入的\""+document.forms[0].PunishName[index].value+"\"应为数字类型");
       document.forms[0].Punishvlaue[index].value="0";
       document.forms[0].Punishvlaue[index].focus();
       return;
      }
   }
   if(max!="∞"&&max!=0){
   if(Number(value)<Number(min)||Number(value)>Number(max)){
     alert(item+"超越相应法定处罚内容,请重新填写");
   if(!document.forms[0].select.length) {
      document.forms[0].Punishvlaue.value="0";
      document.forms[0].Punishvlaue.focus();
   }else{
      document.forms[0].Punishvlaue[index].value="0";
      document.forms[0].Punishvlaue[index].focus();
   }
   return;
   }
   }else{
    if(Number(value)<Number(min)){
     if(max==0){
        alert(item+"不能为负数,请重新填写");
     }else{
        alert(item+"超越相应法定处罚内容,请重新填写");
     }
   if(!document.forms[0].select.length) {
      document.forms[0].Punishvlaue.value="0";
      document.forms[0].Punishvlaue.focus();
   }else{
      document.forms[0].Punishvlaue[index].value="0";
      document.forms[0].Punishvlaue[index].focus();
   }
   return;
   }
   }
   return;
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
function savelkm(){
  if(!IfChecked()){
    alert("请选择处罚类型");
    return;
  }
  var id="";
  var isRate="";
  if(!document.forms[0].select.length){
     if(document.forms[0].Punishmin.value=="-"){
       id=document.forms[0].PunishType.value+"&-";
     }else{
       if(document.forms[0].isRate.value=="1"){
         if(document.forms[0].multiple.value!=""&&document.forms[0].radix.value!=""){
           id=document.forms[0].PunishType.value+"&"+document.forms[0].multiple.value+"*"+document.forms[0].radix.value;
         }else{
           if(document.forms[0].radix.value==""){
             alert(document.forms[0].PunishName.value+"基数计算中的基数不能为空");
             document.forms[0].radix.focus();
             return;
           }
           if(document.forms[0].multiple.value==""){
             alert(document.forms[0].PunishName.value+"基数计算中的倍数不能为空");
             document.forms[0].multiple.focus();
             return;
           }
         }
       }else{
         if(document.forms[0].Punishvlaue.value==""){
           alert("请输入"+document.forms[0].PunishName.value+"数值");
           document.forms[0].Punishvlaue.focus();
           return;
         }else{
           if(!isNumber(document.forms[0].Punishvlaue.value)){
             alert("输入的\""+document.forms[0].PunishName.value+"\"数据为数字型数据");
             return;
           }else{
             id=document.forms[0].PunishType.value+"&"+document.forms[0].Punishvlaue.value;
           }
         }
       }
     }
  }else{
     for(nIndex=0; nIndex<document.forms[0].select.length; nIndex++) {
       if(document.forms[0].select[nIndex].checked){
         var tmp="";
         if(document.forms[0].Punishmin[nIndex].value=="-"){
           tmp=document.forms[0].PunishType[nIndex].value+"&-";
         }else{
           if(document.forms[0].isRate[nIndex].value=="1"){
             if(document.forms[0].multiple[nIndex].value!=""&&document.forms[0].radix[nIndex].value!=""){
               tmp=document.forms[0].PunishType[nIndex].value+"&"+document.forms[0].multiple[nIndex].value+"*"+document.forms[0].radix[nIndex].value;
             }else{
               if(document.forms[0].radix[nIndex].value==""){
                  alert(document.forms[0].PunishName[nIndex].value+"基数计算中的基数不能为空");
                  document.forms[0].radix[nIndex].focus();
                  return;
                }
              if(document.forms[0].multiple[nIndex].value==""){
                 alert(document.forms[0].PunishName[nIndex].value+"基数计算中的倍数不能为空");
                 document.forms[0].multiple[nIndex].focus();
                 return;
               }
             }
           }else{
             if(document.forms[0].Punishvlaue[nIndex].value!=""){
                if(!isNumber(document.forms[0].Punishvlaue[nIndex].value)){
                  alert("输入的\""+document.forms[0].PunishName[nIndex].value+"\"数据为数字型数据");
                  return;
                }else{
                  tmp=document.forms[0].PunishType[nIndex].value+"&"+document.forms[0].Punishvlaue[nIndex].value;
                }
                
             }else{
                alert("请输入"+document.forms[0].PunishName[nIndex].value+"数值");
                document.forms[0].Punishvlaue[nIndex].focus();
                return;
             }
           }
         }

         if(id==""){
           id=tmp;
         }else{
           id=id+","+tmp;
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
	  var isRate="";
	  if(!document.forms[0].select.length){
	     if(document.forms[0].Punishmin.value=="-"){
	       id=document.forms[0].PunishType.value+"&-";
	     }else{
	       if(document.forms[0].isRate.value=="1"){
	         if(document.forms[0].multiple.value!=""&&document.forms[0].radix.value!=""){
	           id=document.forms[0].PunishType.value+"&"+document.forms[0].multiple.value+"*"+document.forms[0].radix.value;
	         }else{
	           if(document.forms[0].radix.value==""){
	             alert(document.forms[0].PunishName.value+"基数计算中的基数不能为空");
	             document.forms[0].radix.focus();
	             return false;
	           }
	           if(document.forms[0].multiple.value==""){
	             alert(document.forms[0].PunishName.value+"基数计算中的倍数不能为空");
	             document.forms[0].multiple.focus();
	             return false;
	           }
	         }
	       }else{ 
	         if(document.forms[0].Punishvlaue.value==""){
	           alert("请输入"+document.forms[0].PunishName.value+"数值");
	           document.forms[0].Punishvlaue.focus();
	           return false;
	         }else{
	           if(!isNumber(document.forms[0].Punishvlaue.value)){
	             alert("输入的\""+document.forms[0].PunishName.value+"\"数据为数字型数据");
	             return false;
	           }else{
	             id=document.forms[0].PunishType.value+"&"+document.forms[0].Punishvlaue.value;
	           }
	         }
	        } 
	     }
	  }else{
	     for(nIndex=0; nIndex<document.forms[0].select.length; nIndex++) {
	       if(document.forms[0].select[nIndex].checked){
	         var tmp="";
	         if(document.forms[0].Punishmin[nIndex].value=="-"){
	           tmp=document.forms[0].PunishType[nIndex].value+"&-";
	         }else{
	           if(document.forms[0].isRate[nIndex].value=="1"){
	             if(document.forms[0].multiple[nIndex].value!=""&&document.forms[0].radix[nIndex].value!=""){
	               tmp=document.forms[0].PunishType[nIndex].value+"&"+document.forms[0].multiple[nIndex].value+"*"+document.forms[0].radix[nIndex].value;
	             }else{
	               if(document.forms[0].radix[nIndex].value==""){
	                  alert(document.forms[0].PunishName[nIndex].value+"基数计算中的基数不能为空");
	                  document.forms[0].radix[nIndex].focus();
	                  return false;
	                }
	              if(document.forms[0].multiple[nIndex].value==""){
	                 alert(document.forms[0].PunishName[nIndex].value+"基数计算中的倍数不能为空");
	                 document.forms[0].multiple[nIndex].focus();
	                 return false;
	               }
	             }
	           }else{ 
	             if(document.forms[0].Punishvlaue[nIndex].value!=""){
	                if(!isNumber(document.forms[0].Punishvlaue[nIndex].value)){
	                  alert("输入的\""+document.forms[0].PunishName[nIndex].value+"\"数据为数字型数据");
	                  return false;
	                }else{
	                  tmp=document.forms[0].PunishType[nIndex].value+"&"+document.forms[0].Punishvlaue[nIndex].value;
	                }
	                
	             }else{
	                alert("请输入"+document.forms[0].PunishName[nIndex].value+"数值");
	                document.forms[0].Punishvlaue[nIndex].focus();
	                return false;
	             }
	            } 
	         }

	         if(id==""){
	           id=tmp;
	         }else{
	           id=id+","+tmp;
	         }
	       }
	     }
	  }
	  document.forms[0].selFreeUmpire.value=id;
	  window.dialogArguments.document.forms[0].selfreeumpire.value=id;
	  return true;
	}
</script>
</html>