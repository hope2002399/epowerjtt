<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>

<style>
	.container1 {padding:5px; box-sizing: border-box; overflow: hidden;}
	
	.container1 .box {border: 1px solid #ddd; margin-bottom: 10px; box-sizing: border-box; }
	.container1 .box h1 {height: 25px; line-height: 25px; padding-left: 10px; color: #fff; font-size: 14px; 
		background: url(${pageContext.request.contextPath}/themes/default/images/zhong.gif) repeat-x;
	}
</style>


<div class="container1"> 

	<div class="box">
		<h1>行政权力分类统计</h1>
		<iframe id="xzqlhyfb" name="xzqlhyfb"  src="${contextPath }/stat/twodimenform!doStat.do?modelName=xzqlhyfb"
				frameborder="no" scrolling="auto" border="0" onload="autoHeight(this);" marginwidth="0" style="width:99%; height:315px;"></iframe>
	</div>
	
	<div class="box" style="width:49%; float:left">
		<h1>办件数量统计</h1>		
		<iframe id="bjlqstj-home" name="bjlqstj-home"  src="${contextPath }/stat/twodimenform!doStat.do?modelName=bjlsltj-home"
			frameborder="no" scrolling="auto" border="0" onload="autoHeight(this);" marginwidth="0" style="width:100%; height:300px; float:left;"></iframe>
	</div>
	
	<div class="box" style="width:49%; float:right">
		<h1>办件量趋势</h1>
		<iframe id="bjlqstj-home" name="bjlqstj-home"  src="${contextPath }/stat/twodimenform!doStat.do?modelName=bjlqstj-home"
			frameborder="no" scrolling="auto" border="0" onload="autoHeight(this);" marginwidth="0" style="width:100%; height:300px;" ></iframe>
	</div>
	

</div>

<script>
function autoHeight(iframe) {
	setTimeout(function() {
		if (!iframe) {
	    	return false;
	    }
	    
	    if(iframe.Document){//ie自有属性
	    	var h = iframe.Document.body.scrollHeight;
	    	if (h) {
	    		//$(iframe).height(h);
		        //iframe.height = iframe.Document.body.scrollHeight;
	    	}
	    }else if(iframe.contentDocument){//ie,firefox,chrome,opera,safari
	    	var h = iframe.contentDocument.body.offsetHeight;
	    	if (h) {
	    		//$(iframe).height(h);
		        //iframe.height = iframe.contentDocument.body.offsetHeight;
	    	}
	    }
	}, 100);
}
</script>