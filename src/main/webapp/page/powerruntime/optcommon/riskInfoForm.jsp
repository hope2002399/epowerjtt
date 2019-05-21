<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="riskInfo.edit.title" /></title>
</head>

<body>
<p class="ctitle"><s:text name="riskInfo.edit.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<s:form action="riskInfo"  method="post" namespace="/powerruntime" id="riskInfoForm" >
	<s:submit name="save"  method="save" cssClass="btn" key="opt.btn.save" />
	<s:submit name="back" method="list" cssClass="btn" key="opt.btn.back"/>
	<input type="hidden" id="riskid" name="riskid"  value="${object.riskid}" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="viewTable">		
 
							<tr>
					<td class="TDTITLE">
						<s:text name="riskInfo.risktype" />
					</td>
					<td align="left">  					
						<select name="risktype" style="width:180px">
							 	<option value="">--请选择--</option>
								<c:forEach var="row" items="${cp:DICTIONARY('RISKTYPE')}">
									<option value="${row.key}"
									 <c:if test="${object.risktype eq row.key}"> selected = "selected" </c:if> 
									<c:if test="${empty object.risktype and row.key eq '0'}"> selected = "selected" </c:if>
									>
									<c:out value="${row.value}" /></option>
								</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TDTITLE">
						<s:text name="riskInfo.riskdes" />
					</td>
					<td align="left">
  
						<s:textarea name="riskdes" style="width:100%;height:40px;"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="riskInfo.riskdeal" />
					</td>
					<td align="left">
  
						<s:textarea name="riskdeal"  style="width:100%;height:40px;"/>
	
	
					</td>
				</tr>
</table>

<!--  
<p/>
<div class="eXtremeTable" >
	<table id="t_powerOptInfo"  border="0"  cellspacing="0"  cellpadding="0"  class="tableRegion"  width="100%" >

		<thead>
			<tr>
  
				<td class="tableHeader">
					<s:text name="powerOptInfo.itemId" />
				</td>	
  
				<td class="tableHeader">
					<s:text name="powerOptInfo.wfcode" />
				</td>	

	

				<td class="tableHeader">
					<s:text name="powerOptInfo.setoperator" />
				</td>	

				<td class="tableHeader">
					<s:text name="powerOptInfo.setime" />
				</td>	
		
				<td class="tableHeader">
					<a href='javascript:void(0)' onclick='addPowerOptInfoItem(this);'><s:text name="opt.btn.new" /></a>
				</td>
			</tr>  
		</thead>
		
		<tbody class="tableBody" >
		<c:set value="odd" var="rownum" />
		 <s:iterator value="powerOptInfos" status="status" >    
			<tr class="${rownum}"  onmouseover="this.className='highlight'"  onmouseout="this.className='${rownum}'" >
    
				<td><s:textfield name="itemId" /> </td>   
    
				<td><s:textfield name="wfcode" /> </td>   

  
				<td><s:textfield name="setoperator" /> </td>   
  
				<td><s:textfield name="setime" /> </td>   
		
				<td>
					<a href='javascript:void(0)' onclick='delPowerOptInfoItem(this);'><s:text name='opt.btn.delete' /></a>
				</td>
			</tr>  
            <c:set value="${rownum eq 'odd'? 'even': 'odd'}" var="rownum" />
		</s:iterator> 
		</tbody>        
	</table>
</div>
-->
</s:form>

	<script type="text/javascript">
	    
		var t_powerOptInfoRowCount; // 行数

	    $(function()
	    {
	
			t_powerOptInfoRowCount = $("table#t_powerOptInfo tr").length - 1; // 除去标题�?  
	    	var powerOptInfoColName = 
	    	          ["itemId","wfcode",
                      "setoperator","setime","guard"];
	    	
			
	        $("input[name='method:save']").bind("click", function()
	        {
	            $("table#t_powerOptInfo tr").each(function(i)
	            {
	                $(this).attr("id", "tr_powerOptInfo" + i);
	                $("#tr_powerOptInfo" + i + "  input[type='text']").each(function(j)
	                {
	                    $(this).attr("name", "newPowerOptInfos["+(i-1)+"]." + powerOptInfoColName[j]);
	                });
	            });
	            
	        });
	    });    
	    
        function addPowerOptInfoItem()
        {
             var htmlItem = '<tr>';
  
			htmlItem += '<td><input type="text" name="newPowerOptInfos['+t_powerOptInfoRowCount+'].itemId" /></td>'; 
  
			htmlItem += '<td><input type="text" name="newPowerOptInfos['+t_powerOptInfoRowCount+'].wfcode" /></td>'; 


			htmlItem += '<td><input type="text" name="newPowerOptInfos['+t_powerOptInfoRowCount+'].setoperator" /></td>'; 

			htmlItem += '<td><input type="text" name="newPowerOptInfos['+t_powerOptInfoRowCount+'].setime" /></td>'; 
            
            t_powerOptInfoRowCount++;
            htmlItem += "<td> <a href='javascript:void(0)' onclick='delPowerOptInfoItem(this);'><s:text name='opt.btn.delete' /></a></td></tr>";
            $("table#t_powerOptInfo").append(htmlItem);

   		    $('table#t_powerOptInfo.tableRegion tr:odd').attr('class','odd')
   		    .hover(function(){
       		    	$(this).addClass("highlight");
       		    },function(){
       		    	$(this).removeClass("highlight");
       		});
   		    $('table#t_powerOptInfo.tableRegion tr:even').attr('class','even')
   		    .hover(function(){
	   		    	$(this).addClass("highlight");
	   		    },function(){
	   		    	$(this).removeClass("highlight");
   		    });
     	}
        
        function delPowerOptInfoItem(varBtn)
        {
            $(varBtn).parent().parent().remove();
            t_powerOptInfoRowCount--;
   		    $('table#t_powerOptInfo.tableRegion tr:odd').attr('class','odd');
   		    $('table#t_powerOptInfo.tableRegion tr:even').attr('class','even');
        }

    </script>	


</body>
</html>
