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

<!--[if !IE]><!--> <!-- <html lang="zh-cn" class="no-js">  --><!--<![endif]-->

<!-- BEGIN HEAD -->
<html>
<head>

	<!-- <meta charset="gb2312" />

	<title>江苏省交通厅</title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

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

<body class="page-header-fixed" style="background-color:white;">



		                                
										<div class="portlet-title">
		
											<div class="caption" style="font-size:20px;font-weight:700;"><%-- ${firstTotal.firstyear} --%><span><!-- 月度办件量趋势 -->
											全省交通运输行政权力运行情况（按地市结案率统计）<!-- （绿色:<span id="thisyear" ></span>年，蓝色：<span id="lastyear"></span>年） -->
											</span></div>
											<div class="tools">
		
											</div>
		
										</div>
		
					
										<div id="emapAcjjy1" style="width:100%;height:370px;"></div>

										
		
									
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

	<%-- <script src="${pageContext.request.contextPath}/media/js/index.js" type="text/javascript"></script>     --%>    
<%--     <script src="<s:url value="/scripts/echarts-plain.js"/>"></script> --%>
	<!-- END PAGE LEVEL SCRIPTS -->  
	<script src="${pageContext.request.contextPath}/media/firstpageline2.js" type="text/javascript"></script>
	
	<script>
		
	var date=new Date;
	 var year=date.getFullYear(); 
	 var month=date.getMonth()+1;
	 month =(month<10 ? "0"+month:month); 
	 var mydate = (year.toString()+'-'+month.toString());

       $(function(){
    	   inityear();
         refreshTable1();
         }
       );
		function inityear(){
			//alert($('#thisyear').val());
			//$('#thisyear').html(thisyear);
			//alert($('#thisyear').val());
			//$('#lastyear').html(lastyear);
		}
		
		function refreshTable1(){
 			var title="";
 			
		/* 	var listthis=${listthis};
			var listlast=${listlast};
			var thisyear=${thisyear};
			var lastyear=${lastyear}; */
			
			var yuedu=new Array();
			 yuedu.push('南京');
			 yuedu.push('无锡');
			 yuedu.push('徐州');
			 yuedu.push('常州');
			 yuedu.push('苏州');
			 yuedu.push('南通');
			 yuedu.push('连云港');
			 yuedu.push('淮安');
			 yuedu.push('盐城');
			 yuedu.push('扬州');
			 yuedu.push('镇江');
			 yuedu.push('泰州');
			 yuedu.push('宿迁');
			
			/* 	avg.push(1);
				avg.push(1);
				avg.push(1);
				avg.push(1);
				avg.push(1);
				avg.push(1);
				avg.push(1);
				avg.push(1);
				avg.push(1); */
			



	        	var myChart1 = echarts.init(document.getElementById('emapAcjjy1')); 
			
	        	var option = {
	        			title: {
	   	        	        text : mydate,
	   	        	
	   	        	        textStyle: {
	        		            fontSize: 18 // 用 legend.textStyle.fontSize 更改示例大小
	       		         }
	   	        	    },
	        			  tooltip : {
		        		        trigger: 'axis',
		        		        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
		        		            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
		        		        }
		        		        
		        		    },
		        		    toolbox : {
		        		        show : false,
		        		        
		        		    },
		        		    legend: {
		        		        data:['许可','处罚'],
			        		    textStyle: {
		        		            fontSize: 18 // 用 legend.textStyle.fontSize 更改示例大小
		        		         }
		        		    },
		        		    calculable : true,
		        		   grid: {x:0, y: '10%', y2:'10%', x2:20}, 
		        		    yAxis : [
		        		        {
		        		            type : 'value',
		        		        	axisLabel : {
			        		        	formatter: function(v){
		        	                    	return v;
		        	                	}
		        		        	}
		        		        }
		        		    ],
		        		    xAxis : [
		        		             {  
	        		            	 name :'aaa',
	        		            	 axisTick:{show :false}, 
		        		             axisLine : {show : false},
			        		         axisLabel:{  show : true},
	        		                 type : 'category',
	        		                 data : yuedu,
	        		                 axisLabel:{   textStyle: {
	        	        		            fontSize: 12 // 用 legend.textStyle.fontSize 更改示例大小
	        	        		         }
	        		                 }
	        		             }
		        		         ],
		        		    series :[{
		        		    	name:'许可',
		        	            type:'line',
		        	            itemStyle: {
		        	                normal: {
		        	                	label : {
		        	                        show: true, position: 'insideBottom'
		        	                        
		        	                       
		        	                    },
		        	                    color: function(params) {
		        	                        // build a color map as your need.
		        	                        var colorList = [
											'#228B22','#1E90FF'
		        	                        ];
		        	                        return colorList[0]
		        	                    }
		        	                }
		        	            },
		        	            data: listthis
		        	        },
		        	        {
		        	        	name:'处罚',
		        	            type:'line',
		        	            itemStyle: {
		        	                normal: {
		        	                	label : {
		        	                        show: true, position: 'insideBottom'
		        	                        
		        	                       
		        	                    },
		        	                    color: function(params) {
		        	                        // build a color map as your need.
		        	                        var colorList = [
											'#228B22','#1E90FF'
		        	                        ];
		        	                        return colorList[1]
		        	                    }
		        	                }
		        	            },
		        	            data: listlast
		        	        }
		        	        ]
	        		};
	        	myChart1.setOption(option);
	        	
	        	
           
		} 

	
	</script>



</html>