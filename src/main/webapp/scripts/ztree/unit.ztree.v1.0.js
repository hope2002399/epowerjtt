/**
 * 选择单位TREE
 */
;
(function($) {
	$.fn.extend({
		openUnit : function(paraId,paraName) {
			$(this).dblclick(function(){      
	               $.dialog({
	            	lock: true,
	  		        width:400,
	  		        height:320,
	  		        title: '单位选择',
	  		        content: "url:${pageContext.request.contextPath}/sys/unit!initztreelist.do?paraId="+paraId+"&paraName="+paraName
	  		       
	  		    });
	          });       
		}
	});   
})(jQuery);