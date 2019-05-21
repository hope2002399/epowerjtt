<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="ECharts">
    <title></title>

    <link rel="shortcut icon" href="${pageContext.request.contextPath}/echarts/doc/asset/ico/favicon.png">
<!-- 
    <link href="../asset/css/font-awesome.min.css" rel="stylesheet">
    <link href="../asset/css/bootstrap.css" rel="stylesheet">
    <link href="../asset/css/carousel.css" rel="stylesheet">
    <link href="../asset/css/echartsHome.css" rel="stylesheet"> -->
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <script src="${pageContext.request.contextPath}/echarts/doc/example/www/js/echarts.js"></script>
    <script src="${pageContext.request.contextPath}/echarts/doc/asset/js/codemirror.js"></script>
    <script src="${pageContext.request.contextPath}/echarts/doc/asset/js/javascript.js"></script>
	<script src="${pageContext.request.contextPath}/echarts/doc/example/geoJson/china-main-city/china-main-city-map.js"></script>
	<script src="${pageContext.request.contextPath}/media/firstpagemap.js" type="text/javascript"></script>
	

  <!--   <link href="../asset/css/codemirror.css" rel="stylesheet">
    <link href="../asset/css/monokai.css" rel="stylesheet"> -->
	<style type="text/css">
        .CodeMirror {
            height: 0px;
        }
    </style>
</head>

<body>
    <!-- Fixed navbar -->
<!--     <div class="navbar navbar-default navbar-fixed-top" role="navigation" id="head" ></div> -->


  
            <div id="sidebar-code"  style="width:0px; overflow:hidden;">
                <div >
                  <!--   <div class="nav-header"><a href="#" onclick="autoResize()" class="glyphicon glyphicon-resize-full" id ="icon-resize" ></a>option</div>
                   -->  <textarea id="code" name="code">
var rootcity='${rootcity}';
var curIndx = 0;
var mapType = [];
var mapGeoData = require('echarts/util/mapData/params');
//console.log(mapGeoData)
for (var city in cityMap) {
    mapType.push(city);
    // 自定义扩展图表类型
    mapGeoData.params[city] = {
        getGeoJson: (function (c) {
            var geoJsonName = cityMap[c];
            return function (callback) {
                $.getJSON('${pageContext.request.contextPath}/echarts/doc/example/geoJson/china-main-city/' + geoJsonName + '.json', callback);
            }
        })(city)
    }
}



option = {
    title: {
        text : '当月地区办件量',
   
        subtext : rootcity
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
            name: '地区办件量',
            type: 'map',
            mapType: rootcity,
            itemStyle:{
                normal:{label:{show:true}},
                emphasis:{
   	    	                	label:{show:true},
   	    	                	color: 'green'

   	    	                }
            },
            data:mapData
        }
    ]
};
                    
                    </textarea>
              </div><!--/.well -->
            </div><!--/span-->
            <div id="graphic" class="col-md-8">
                <div id="main" class="main" style="width:100%;height:552px;overflow:hidden;"></div>
                
                <div style="height:0px;overflow:hidden;">
                    <button type="button" class="btn btn-sm btn-success" onclick="refresh(true)">刷 新</button>
                    <span class="text-primary">切换主题</span>
                    <select id="theme-select"></select>

                    <span id='wrong-message' style="color:red"></span>
                </div>
                
            </div><!--/span-->
       <!--/row-->
        
        <!--/.fluid-container-->

<!--     <footer id="footer"></footer> -->
    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath}/echarts/doc/asset/js/jquery.min.js"></script>
   <!--  <script type="text/javascript" src="../asset/js/echartsHome.js"></script> -->
   <!--  <script src="../asset/js/bootstrap.min.js"></script> -->
    <script src="${pageContext.request.contextPath}/echarts/doc/asset/js/echartsExample.js"></script>
</body>
</html>
