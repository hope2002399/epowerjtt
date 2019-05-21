<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>


<body>


	<div class="box" >
		<h3 align="center">交通行政权力运行办件量统计表（按权力） </h3>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
			<iframe
				src='${pageContext.request.contextPath}/stat/twodimenform!doStat.do?modelName=qlblqkfb_analysis&begDate=${yearmonthfirst}&endDate=${yearmonthlast}'
				border="0" frameBorder="no" marginWidth="0" scrolling="no"
				width="60%" onload="parent.autoHeight(this);" ></iframe> 
		
		
	</div>



</body>



