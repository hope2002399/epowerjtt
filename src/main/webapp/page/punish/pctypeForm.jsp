<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>


<html>
<head>
<title></title>
<meta name="decorator" content='${LAYOUT}'/>
<sj:head locale="zh_CN" />
<script src="${pageContext.request.contextPath}/scripts/suggest.js" type="text/javascript"></script>
</head>

 <body onload="changPaperType();doChange();">
<p class="ctitle"></p>

<%@ include file="/page/common/messages.jsp"%>

<s:form action="pctype"  method="post" namespace="/punish"  styleId="pctypeForm" >
	<s:submit method="save" cssClass="btn" key="opt.btn.save"></s:submit>
	<input type="button" Class="btn" onclick="window.history.back()" value="返回"/> 
		 <input id="punishclassid" type="hidden" name="punishclassid" value="${object.punishclassid}"/>
    <fieldset style="padding:10px;display:block;margin-bottom:10px;">
	<legend style="padding:4px 8px 3px;"><b>处罚项目编辑</b></legend>
			<table border="0" cellpadding="0" cellspacing="0" class="viewTable">	
			       
              <tr >
				<td class="addTd">
					处罚项目名称
				</td>
				<td align="left" colspan="3">
					${punishclassname}
				</td>
                      
              <tr>
				<td class="addTd">处罚种类选择</td>
				<td align="left">
			 <c:if test="${ empty object.punishtypeid  }">
				<select name="punishtypeid" onchange="changPaperType();" >
						<option value="">--请选择--</option>
						<c:forEach var="row" items="${cp:DICTIONARY('punishType')}">
							<option value="${row.key}"
								<c:if test="${object.punishtypeid eq row.value}">selected="selected"</c:if>>
								<c:out value="${row.value}" />
							</option>
						</c:forEach>
				     </select><span style="color: red">*</span>  
				     </c:if>	
				   	 <c:if test="${not empty object.punishtypeid }">
				   	 <c:forEach var="row" items="${cp:DICTIONARY('punishType')}">
						<c:if test="${object.punishtypeid eq row.key}">
						<c:set var="punishtypename" value="${row.value}" />
						</c:if>
					</c:forEach>
				   	 ${punishtypename }
				   	 <input type="hidden"  name="punishtypeid"  id="punishtypeid"  value="${object.punishtypeid}" />
				   	 </c:if>
					<div id="israteDiv"  style="display:none;">
				   <s:checkbox name="rate" onclick="doChange();" id="israte"  >按比例计算 </s:checkbox> 
			      </div>	
                 </td>
              </tr> 
                           
				<tr id="punishmin_tr">
				        <td class="addTd">
						处罚下限
				       </td>
					<td align="left" >
						<s:textfield name="punishmin" value="%{object.punishmin}"/>
					</td>
				</tr>
				<tr id="punishmax_tr">
					 <td class="addTd">
						处罚上限
					</td>
					<td align="left" >
						<s:textfield name="punishmax"  value="%{object.punishmax}" />
					</td>
				</tr>
                 
                  
                
				<tr id="chargemax_tr">
					<td class="addTd">
						最大数额
					</td>
					<td align="left" >
						<s:textfield name="chargemax" value="%{object.chargemax}"/>
					</td>
				</tr>
				<tr id="radixname_tr">
					<td class="addTd">
						基数名称
					</td>
					<td align="left" >
						<s:textfield name="radixname"  value="%{object.radixname}"/>
					</td>
				</tr>
				<tr id="radixunit_tr">
					<td class="addTd">
						基数单位
					</td>
					<td class="addTd">
						<s:textfield name="radixunit" value="%{object.radixunit}" />
					</td>
				</tr>
			
                
                         <tr>
				<td class="addTd">
					处罚内容
				</td>
				<td align="left" colspan="3">
					<s:textarea name="punishcontent"  value="%{object.punishcontent}" />
				</td>
			</tr>
		</table>
		</fieldset>

</s:form>

	<script type="text/javascript">
	    
        var _get = function (id) {
        	return document.getElementById(id);
        };
      
    	//对不同的处罚种类对应不同的文本框
     	function changPaperType() {
    	
    		var punishtypeid = document.getElementById("punishtypeid");
 
    		    		if (punishtypeid.value=="0000000037" || punishtypeid.value=="0000000038" 
    				|| punishtypeid.value=="0000000040"  ) { //处罚。。
    			/* document.getElementById("punishDiv").style.display = 'block'; */
    			_get("punishmin_tr").style.display = "block";
    			_get("punishmax_tr").style.display = "block";
    			/* _get("israte").style.display = 'none'; */
    			_get("chargemax_tr").style.display = "none";	
    			_get("radixname_tr").style.display = "none";
    			 _get("radixunit_tr").style.display = "none"; 
    			if(punishtypeid.value =="0000000037" ){
    				_get("israteDiv").style.display = "block";
    			}
    			if(punishtypeid.value !="0000000037" ){
    				_get("israteDiv").style.display = "none";
    			}
    		} else {
    			_get("punishmax_tr").style.display = "none";	
    			_get("punishmin_tr").style.display = "none";
    			_get("chargemax_tr").style.display = "none";	
    			_get("radixname_tr").style.display = "none";
    			 _get("radixunit_tr").style.display = "none"; 
    			 _get("israteDiv").style.display = "none";
    			/* _get("punishmax_tr").style.display = 'none'; */
    		}
    	}	
     	function doChange(){

      		if(_get('israte').value==1){
      			_get('israte').checked="checked";
      		}
     		if(_get('israte').checked){
     			
     			_get("chargemax_tr").style.display = "block";	
    			_get("radixname_tr").style.display = "block";
    			 _get("radixunit_tr").style.display = 'block'; 
     		}
     		else {
     			
     			_get("chargemax_tr").style.display = "none";	
    			_get("radixname_tr").style.display = "none";
    			 _get("radixunit_tr").style.display = 'none'; 
     		}
     	}
     	
     	

     			function ready(){
     				if("${object.israte}"==1){
     					_get("israte").checked=true;
     				}}
     	ready();
    </script>	
</body>
</html>
