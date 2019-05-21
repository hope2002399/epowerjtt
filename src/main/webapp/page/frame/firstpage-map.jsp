<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<!DOCTYPE html>

<!-- 

Template Name: Metronic - Responsive Admin Dashboard Template build with Twitter Bootstrap 2.3.1

Version: 1.3

Author: KeenThemes

Website: http://www.keenthemes.com/preview/?theme=metronic

Purchase: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469

-->

<!--[if IE 8]> <html lang="zh-cn" class="ie8 no-js"> <![endif]-->

<!--[if IE 9]> <html lang="zh-cn" class="ie9 no-js"> <![endif]-->

<!--[if !IE]><!--> <!-- <html lang="zh-cn" class="no-js"> --> <!--<![endif]-->

<!-- BEGIN HEAD -->
<html>
<head>

<!-- 	<meta charset="gb2312" />
 -->
	<!--  <title>江苏省交通厅</title>-->

	<!-- <meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" /> -->

	<!-- BEGIN GLOBAL MANDATORY STYLES -->

	<link href="${pageContext.request.contextPath}/media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

	<link href="${pageContext.request.contextPath}/media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>

	<link href="${pageContext.request.contextPath}/media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

	<link href="${pageContext.request.contextPath}/media/css/style-metro.css" rel="stylesheet" type="text/css"/>

	<link href="${pageContext.request.contextPath}/media/css/style.css" rel="stylesheet" type="text/css"/>

	<link href="${pageContext.request.contextPath}/media/css/style-responsive.css" rel="stylesheet" type="text/css"/>

	<link href="${pageContext.request.contextPath}/media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>

	<link href="${pageContext.request.contextPath}/media/css/uniform.default.css" rel="stylesheet" type="text/css"/>

	<!-- END GLOBAL MANDATORY STYLES -->

	<!-- BEGIN PAGE LEVEL STYLES --> 

	<link href="${pageContext.request.contextPath}/media/css/jquery.gritter.css" rel="stylesheet" type="text/css"/>

	<link href="${pageContext.request.contextPath}/media/css/daterangepicker.css" rel="stylesheet" type="text/css" />

	<link href="${pageContext.request.contextPath}/media/css/fullcalendar.css" rel="stylesheet" type="text/css"/>

	<link href="${pageContext.request.contextPath}/media/css/jqvmap.css" rel="stylesheet" type="text/css" media="screen"/>

	<link href="${pageContext.request.contextPath}/media/css/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>

	<!-- END PAGE LEVEL STYLES -->

	<link rel="shortcut icon" href="${pageContext.request.contextPath}/media/image/favicon.ico" />
<style>
	.chart{height:150px;}
	.portlet.solid.bordered .portlet-title {margin-bottom: 0px;}
	.mini{padding: 4px 5px;}
	.portlet-title .caption {margin-bottom: 0px;}
	.banner { position: relative; overflow: auto; }
    .banner li { list-style: none; }
    .banner ul li { float: left; }
    
</style>
</head>



<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="page-header-fixed" >



	<!-- BEGIN CONTAINER<div class="page-container"> -->

	



		<!-- BEGIN PAGE -->


	
									<div class="portlet solid bordered light-grey" >
				                       <div class="banner">
		                                
										<div class="portlet-title">
		
											<div class="caption" style="font-size:20px;font-weight:700;">
											全省交通运输行政权力运行情况（按地区分布）</div>
											<div class="tools">
		
											</div>
		
										</div>
		
					
										<div id="emapAcjjy" style="width:100%;height:780px;overflow:hidden;"></div>

										
		
										</div>
															
									</div>
							


</body>
	<script src="${pageContext.request.contextPath}/media/js/jquery-1.11.1.min.js" type="text/javascript"></script>

	<script src="${pageContext.request.contextPath}/media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>

	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->

	<script src="${pageContext.request.contextPath}/media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>      

	<script src="${pageContext.request.contextPath}/media/js/bootstrap.min.js" type="text/javascript"></script>



	<script src="${pageContext.request.contextPath}/media/js/jquery.slimscroll.min.js" type="text/javascript"></script>

	<script src="${pageContext.request.contextPath}/media/js/jquery.blockui.min.js" type="text/javascript"></script>  

	<script src="${pageContext.request.contextPath}/media/js/jquery.cookie.min.js" type="text/javascript"></script>

	<script src="${pageContext.request.contextPath}/media/js/jquery.uniform.min.js" type="text/javascript" ></script>

	<!-- END CORE PLUGINS -->

	<!-- BEGIN PAGE LEVEL PLUGINS -->

 

	<script src="${pageContext.request.contextPath}/media/js/jquery.flot.js" type="text/javascript"></script>

	<script src="${pageContext.request.contextPath}/media/js/jquery.flot.resize.js" type="text/javascript"></script>
	
	<script src="${pageContext.request.contextPath}/media/js/jquery.gritter.js" type="text/javascript"></script>
	 <script src="<s:url value="/scripts/echarts-plain-map.js"/>"></script>
	 <script src="<s:url value="/scripts/unslider.min.js"/>"></script>	


	<script src="${pageContext.request.contextPath}/media/js/app.js" type="text/javascript"></script>

	<%-- <script src="${pageContext.request.contextPath}/media/js/index.js" type="text/javascript"></script>        
    <script src="<s:url value="/scripts/echarts-plain.js"/>"></script> --%>
	<!-- END PAGE LEVEL SCRIPTS -->  
	<%-- <script src="${pageContext.request.contextPath}/media/firstpagemap.js" type="text/javascript"></script> --%>
	<script>
		
	var date=new Date;
	 var year=date.getFullYear(); 
	 var month=date.getMonth()+1;
	 month =(month<10 ? "0"+month:month); 
	 var mydate = (year.toString()+'-'+month.toString());

       $(function(){
         refreshMap('emapAcjjy','地区办件量');
         }
       );
		function refreshMap( id,serisename) {
			var mapData = ${list};						
			var minvalue=${minvalue};
			var maxvalue=${maxvalue};
			var rootcity='${rootcity}';
			var mapChart = echarts.init(document.getElementById(id));
   	        var mapOption = {
   	        		title: {
   	        	        text : mydate,
   	        	
   	        	        textStyle: {
        		            fontSize: 18 // 用 legend.textStyle.fontSize 更改示例大小
       		         }
   	        	    },
   	    	    tooltip : {
   	    	        trigger: 'item',
   	    	     formatter:function(a,b,c,d){
	   	              var cityName = a[1] ;
	   	              //var num=(a[2]=='00'?'0':a[2]);
	   	           var num=parseInt(a[2],10);
	   	              return  '地市：'+cityName + '<br/>' +'办件量：'+ num ;
   	          		}
   	    	    },
  	    	    dataRange: {
  	    	        min:minvalue,
  	    	        max:maxvalue,
  	    	        color:['red','yellow'],
  	    	        text:['高','低'] ,         // 文本，默认为数值文本
  	    	        calculable : true,
  	    	      formatter:function(v){
	   	           var num=parseInt(v,10);
	   	              return   num ;
   	          		}

  	    	    },
   	    	    series : [
   	    	        {
   	    	            name: serisename,
   	    	            type: 'map',
   	    	            mapType: rootcity,
   	    	            itemStyle:{
   	    	                normal:{label:{show:true}},
   	    	                emphasis:{
   	    	                	label:{show:true},
   	    	                	color: 'green'

   	    	                }
   	    	            },
   	    	            data: mapData
   	    	        }
   	    	    ]
   	    	}; 

   	        mapChart.setOption(mapOption);
		}
		
	
	</script>



</html>