<%@ include file="/page/common/taglibs.jsp"%> 
<style type="text/css">
#errorMessages,#successMessages,#errorMessage{ position:absolute; width:300px; left:50%; margin-left:-170px; padding:30px 20px; text-align:center; border:2px solid #86a5ad; color:#ff0000; background:#f8f8f8; }
</style>
     <script type="text/javascript">
     $(document).ready(function(){
    	 //var h = document.documentElement.offsetHeight;
    	 //var boxH = parseInt(h/2)-parseInt($("#errorMessages").outerHeight()/2);
    	 //$("#errorMessages,#successMessages").css({"top":boxH+"px"});
         window.setTimeout("$('#errorMessages,#successMessages,#errorMessage).fadeOut('slow');", 3000);
       });


	</script>
<%-- Error Messages --%>
<c:if test="${not empty eorroMessage }">
   <div class="errors" id="errorMessages">
      <s:property value="%{eorroMessage}"/>
   </div>
</c:if>
<c:if test="${not empty error }">
   <div class="errors" id="errorMessage">
     <font color="red"><c:out value="${error }"></c:out></font>
   </div>
</c:if>
<%-- Success Messages --%>
<s:if test="hasActionMessages()">
   <div class="message" id="successMessages">
     <s:actionmessage/>
   </div>

</s:if>

