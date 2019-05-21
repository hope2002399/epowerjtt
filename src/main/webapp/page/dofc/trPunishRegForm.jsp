<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<html>
<head>
<title><s:text name="trPunishReg.edit.title" /></title>
</head>

<body>
<p class="ctitle"><s:text name="trPunishReg.edit.title" /></p>

<%@ include file="/page/common/messages.jsp"%>

<s:form action="trPunishReg"  method="post" namespace="/dofc" id="trPunishRegForm" >
	<s:submit name="save"  method="save" cssClass="btn" key="opt.btn.save" />
	<s:submit type="button" name="back" cssClass="btn" key="opt.btn.back"/>
		
<table width="200" border="0" cellpadding="1" cellspacing="1">		
 
				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.djId" />
					</td>
					<td align="left">
	
  
							<s:textfield name="djId" size="40" />
	
					</td>
				</tr>


				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.caseDate" />
					</td>
					<td align="left">
	
  
						<s:textfield name="caseDate"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.caseAddress" />
					</td>
					<td align="left">
  
						<s:textarea name="caseAddress" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.caseSource" />
					</td>
					<td align="left">
	
  
						<s:textfield name="caseSource"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.caseFact" />
					</td>
					<td align="left">
  
						<s:textarea name="caseFact" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.targetType" />
					</td>
					<td align="left">
	
  
						<s:textfield name="targetType"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.targetName" />
					</td>
					<td align="left">
	
  
						<s:textfield name="targetName"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.targetPaperType" />
					</td>
					<td align="left">
	
  
						<s:textfield name="targetPaperType"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.targetPaperCode" />
					</td>
					<td align="left">
	
  
						<s:textfield name="targetPaperCode"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.targetUnitcode" />
					</td>
					<td align="left">
	
  
						<s:textfield name="targetUnitcode"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.targetPhone" />
					</td>
					<td align="left">
	
  
						<s:textfield name="targetPhone"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.targetMobile" />
					</td>
					<td align="left">
	
  
						<s:textfield name="targetMobile"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.targetAddress" />
					</td>
					<td align="left">
  
						<s:textarea name="targetAddress" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.reporterName" />
					</td>
					<td align="left">
	
  
						<s:textfield name="reporterName"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.reporterDate" />
					</td>
					<td align="left">
	
  
						<s:textfield name="reporterDate"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.reporterPaperType" />
					</td>
					<td align="left">
	
  
						<s:textfield name="reporterPaperType"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.reporterPaperCode" />
					</td>
					<td align="left">
	
  
						<s:textfield name="reporterPaperCode"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.reporterPhone" />
					</td>
					<td align="left">
	
  
						<s:textfield name="reporterPhone"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.reporterMobile" />
					</td>
					<td align="left">
	
  
						<s:textfield name="reporterMobile"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.reporterAddress" />
					</td>
					<td align="left">
  
						<s:textarea name="reporterAddress" cols="40" rows="2"/>
	
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.caseRegDate" />
					</td>
					<td align="left">
	
  
						<s:textfield name="caseRegDate"  size="40"/>
	
					</td>
				</tr>

				<tr>
					<td class="TDTITLE">
						<s:text name="trPunishReg.caseRegUsercode" />
					</td>
					<td align="left">
	
  
						<s:textfield name="caseRegUsercode"  size="40"/>
	
					</td>
				</tr>

</table>


<p/>
<div class="eXtremeTable" >
	<table id="t_trPunishDetail"  border="0"  cellspacing="0"  cellpadding="0"  class="tableRegion"  width="100%" >

		<thead>
			<tr>
  
				<td class="tableHeader">
					<s:text name="trPunishDetail.djId" />
				</td>	
  
				<td class="tableHeader">
					<s:text name="trPunishDetail.punishItem" />
				</td>	


				<td class="tableHeader">
					<s:text name="trPunishDetail.punishName" />
				</td>	

				<td class="tableHeader">
					<s:text name="trPunishDetail.isreal" />
				</td>	
		
				<td class="tableHeader">
					<a href='javascript:void(0)' onclick='addTrPunishDetailItem(this);'><s:text name="opt.btn.new" /></a>
				</td>
			</tr>  
		</thead>
		
		<tbody class="tableBody" >
		<c:set value="odd" var="rownum" />
		 <s:iterator value="trPunishDetails" status="status" >    
			<tr class="${rownum}"  onmouseover="this.className='highlight'"  onmouseout="this.className='${rownum}'" >
    
				<td><s:textfield name="djId" /> </td>   
    
				<td><s:textfield name="punishItem" /> </td>   

  
				<td><s:textfield name="punishName" /> </td>   
  
				<td><s:textfield name="isreal" /> </td>   
		
				<td>
					<a href='javascript:void(0)' onclick='delTrPunishDetailItem(this);'><s:text name='opt.btn.delete' /></a>
				</td>
			</tr>  
            <c:set value="${rownum eq 'odd'? 'even': 'odd'}" var="rownum" />
		</s:iterator> 
		</tbody>        
	</table>
</div>

</s:form>

	<script type="text/javascript">
	    
		var t_trPunishDetailRowCount; // 行数

	    $(function()
	    {
	
			t_trPunishDetailRowCount = $("table#t_trPunishDetail tr").length - 1; // 除去标题行   
	    	var trPunishDetailColName = 
	    	          ["djId","punishItem",
                      "punishName","isreal","guard"];
	    	
			
	        $("input[name='method:save']").bind("click", function()
	        {
	            $("table#t_trPunishDetail tr").each(function(i)
	            {
	                $(this).attr("id", "tr_trPunishDetail" + i);
	                $("#tr_trPunishDetail" + i + "  input[type='text']").each(function(j)
	                {
	                    $(this).attr("name", "newTrPunishDetails["+(i-1)+"]." + trPunishDetailColName[j]);
	                });
	            });
	            
	        });
	    });    
	    
        function addTrPunishDetailItem()
        {
             var htmlItem = '<tr>';
  
			htmlItem += '<td><input type="text" name="newTrPunishDetails['+t_trPunishDetailRowCount+'].djId" /></td>'; 
  
			htmlItem += '<td><input type="text" name="newTrPunishDetails['+t_trPunishDetailRowCount+'].punishItem" /></td>'; 


			htmlItem += '<td><input type="text" name="newTrPunishDetails['+t_trPunishDetailRowCount+'].punishName" /></td>'; 

			htmlItem += '<td><input type="text" name="newTrPunishDetails['+t_trPunishDetailRowCount+'].isreal" /></td>'; 
            
            t_trPunishDetailRowCount++;
            htmlItem += "<td> <a href='javascript:void(0)' onclick='delTrPunishDetailItem(this);'><s:text name='opt.btn.delete' /></a></td></tr>";
            $("table#t_trPunishDetail").append(htmlItem);

   		    $('table#t_trPunishDetail.tableRegion tr:odd').attr('class','odd')
   		    .hover(function(){
       		    	$(this).addClass("highlight");
       		    },function(){
       		    	$(this).removeClass("highlight");
       		});
   		    $('table#t_trPunishDetail.tableRegion tr:even').attr('class','even')
   		    .hover(function(){
	   		    	$(this).addClass("highlight");
	   		    },function(){
	   		    	$(this).removeClass("highlight");
   		    });
     	}
        
        function delTrPunishDetailItem(varBtn)
        {
            $(varBtn).parent().parent().remove();
            t_trPunishDetailRowCount--;
   		    $('table#t_trPunishDetail.tableRegion tr:odd').attr('class','odd');
   		    $('table#t_trPunishDetail.tableRegion tr:even').attr('class','even');
        }

    </script>	


</body>
</html>
