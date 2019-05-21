var Index = function () {
	var jytype = "";

    return {

        //main function to initiate the module
        init: function () {

//            App.addResponsiveHandler(function () {
//                Index.initCalendar();
//                jQuery('.vmaps').each(function () {
//                    var map = jQuery(this);
//                    map.width(map.parent().width());
//                });
//            });
        },




        initCharts: function () {
            if (!jQuery.plot) {
                return;
            }

            var data = [];
            var totalPoints = 250;

            // random data generator for plot charts

            function getRandomData() {
                if (data.length > 0) data = data.slice(1);
                // do a random walk
                while (data.length < totalPoints) {
                    var prev = data.length > 0 ? data[data.length - 1] : 50;
                    var y = prev + Math.random() * 10 - 5;
                    if (y < 0) y = 0;
                    if (y > 100) y = 100;
                    data.push(y);
                }
                // zip the generated y values with the x values
                var res = [];
                for (var i = 0; i < data.length; ++i) res.push([i, data[i]])
                return res;
            }

            function showTooltip(title, x, y, contents) {
                $('<div id="tooltip" class="chart-tooltip"><div class="date">' + title + '<\/div><div class="label label-success">' + contents + '<\/div>').css({
                    position: 'absolute',
                    display: 'none',
                    top: y - 100,
                    width: 100,
                    left: x - 40,
                    border: '0px solid #ccc',	
                    padding: '2px 6px',
                    'background-color': '#fff'
                }).appendTo("body").fadeIn(200);
            }

            function randValue() {
                return (Math.floor(Math.random() * (1 + 50 - 20))) + 10;
            }
            
            if ($('#site_punishments').size() != 0) {

                $('#site_punishments_loading').hide();
                $('#site_punishments_content').show();
                  
                var plot_punishments = $.plot($("#site_punishments"), [{
//                        data: thisYearXzcfbData[maxIndex[2]],
                        data: thisYearXzcfbData[0]
                        /*label: firstyear*/
                    }, {
//                        data: passYearXzcfbData[maxIndex[2]],
                        data: passYearXzcfbData[0]
                        /*label: secondyear*/
                    }
                ], {
                    series: {
                        lines: {
                            show: true,
                            lineWidth: 2
//                            ,
//                            fill: true,
////                            fillColor: {
//                                colors: [{
//                                        opacity: 0.05
//                                    }, {
//                                        opacity: 0.01
//                                    }
//                                ]
//                            }
                        },
                        points: {
                            show: true
                        },
                        shadowSize: 2
                    },
                    grid: {
                        hoverable: true,
                        clickable: true,
                        tickColor: "#eee",
                        borderWidth: 0
                    },
                    //colors: ["#37b7f3", "#d12610"],
                    colors: ["#d12610", "#37b7f3"],
                    xaxis: {
                    	min: 1,
                    	max:12,
                        ticks: 11,
                        tickDecimals: 0,
                        tickFormatter: function (v) {
                            return v + "月";
                        }
                    },
                    yaxis: {
                        min: 0,                       
                    	ticks:2,                     
                        tickLength: 15,
                        tickDecimals: 0
                    },
                    legend: {
                        noColumns: 0,
                        labelBoxBorderColor: "#000000",
                        margin: 0,
                        position: "ne"
                    }
                });
                /*
                $("button[id$='punishments']").each(function(index,element){
                	if(element.id.replace("punishments","") != maxIndex[2]){
                		$("#"+element.id).attr("class", "btn green mini");
                	}else{
                		$('#punishment_title').html(this.innerHTML);
                		$("#"+element.id).attr("class", "btn green mini active");
                	}
                });*/

                
                $("button[id$='punishments']").bind("click", function () {
                	var id = this.id;
                    $("button[id$='punishments']").each(function(index,element){
                    	if(element.id != id){
                    		$("#"+element.id).attr("class", "btn green mini");
                    	}else{
                    		$("#"+element.id).attr("class", "btn green mini active");
                    	}
                    });
                    var cityId = id.replace("punishments","");
                    initPunishments(cityId);
                });
                
                
                function initPunishments(cityId) {
                	var thisYear = 0;
                	var lastYear = 0;
                	var percent = 0;
                	var str = "";
                	var indexNum = cities[cityId][0];
                	$('#site_punishments_content').hide();
                    $('#site_punishments_loading').show();
                	for(var i=0;i<thisYearXzcfbData[indexNum].length;i++){
                		if(thisYearXzcfbData[indexNum][i][0]<=lastMonth){
                			thisYear = thisYear + thisYearXzcfbData[indexNum][i][1];
                		}
            		}
            		for(var i=0;i<passYearXzcfbData[indexNum].length;i++){
            			if(passYearXzcfbData[indexNum][i][0]<=lastMonth){
            				lastYear = lastYear + passYearXzcfbData[indexNum][i][1];
            			}
            		}
                    if(thisYear / lastYear > 1){
            			percent = thisYear / lastYear * 100 - 100;
            			str = "增加";
            		}else{
            			percent = 100 - thisYear / lastYear * 100;
            			str = "减少";
            		}
                    if(lastMonth>1){
                    	$('#site_punishments_desc').html(firstyear+'年1-'+lastMonth+'月:<span style="color: red;">'+thisYear
                        		+'</span>件;'+secondyear+'年同期:<span style="color: red;">'+lastYear
                        		+'</span>件;'+str+'<span style="color: red;">'+ percent.toFixed(2) +'%</span>');
                    }else if(lastMonth==1){
                    	$('#site_punishments_desc').html(firstyear+'年1月:<span style="color: red;">'+thisYear
                        		+'</span>件;'+secondyear+'年同期:<span style="color: red;">'+lastYear
                        		+'</span>件;'+str+'<span style="color: red;">'+ percent.toFixed(2) +'%</span>');
                    }
                    
                    plot_punishments.setData( [{
                        data: thisYearXzcfbData[indexNum]
                       /* label: firstyear*/
                    }, {
                        data: passYearXzcfbData[indexNum]
                        /*label: secondyear*/
                    }]);
                    plot_punishments.setupGrid();
                    plot_punishments.draw();
                    $("#site_punishments > .flot-text > .y1Axis > div").css("left", "0px");
                    
                	$('#punishment_title').html(cities[cityId][1]);          	
                    $('#site_punishments_loading').hide();
                    $('#site_punishments_content').show();
                };
                
                var previousPointPunish = null;
                $("#site_punishments").bind("plothover", function (event, pos, item) {
                    $("#x").text(pos.x.toFixed(2));
                    $("#y").text(pos.y.toFixed(2));
                    if (item) {
                        if (previousPointPunish != item.dataIndex) {
                        	previousPointPunish = item.dataIndex;

                            $("#tooltip").remove();
                            var x = item.datapoint[0].toFixed(2),
                                y = item.datapoint[1].toFixed(2);

                            showTooltip($('#punishment_title').html()+parseInt(x)+'月', item.pageX, item.pageY,  parseInt(y));
                        }
                    } else {
                        $("#tooltip").remove();
                        previousPointPunish = null;
                    }
                });
            } 
            
            if ($('#site_portfee').size() != 0) {

                $('#site_portfee_loading').hide();
                $('#site_portfee_content').show();
                  
                var plot_portfees = $.plot($("#site_portfee"), [{
                        data: thisYearCbgwfData[maxIndex[3]],
                        data: thisYearCbgwfData[0]
                        /*label: firstyear*/
                    }, {
                        data: passYearCbgwfData[0]
                        /*label: secondyear*/
                    }
                ], {
                    series: {
                        lines: {
                            show: true,
                            lineWidth: 2
//                            ,
//                            fill: true,
//                            fillColor: {
//                                colors: [{
//                                        opacity: 0.05
//                                    }, {
//                                        opacity: 0.01
//                                    }
//                                ]
//                            }
                        },
                        points: {
                            show: true
                        },
                        shadowSize: 2
                    },
                    grid: {
                        hoverable: true,
                        clickable: true,
                        tickColor: "#eee",
                        borderWidth: 0
                    },
                    //colors: ["#37b7f3", "#d12610"],
                    colors: ["#d12610", "#37b7f3"],
                    xaxis: {
                    	min: 1,
                    	max:12,
                        ticks: 11,
                        tickDecimals: 0,
                        tickFormatter: function (v) {
                            return v + "月";
                        }
                    },
                    yaxis: {
                        min: 0,                       
                    	ticks:2,                     
                        tickLength: 15,
                        tickDecimals: 00
                    },
                    legend: {
                        noColumns: 0,
                        labelBoxBorderColor: "#000000",
                        margin: 0,
                        position: "ne"
                    }
                });
                /*
                $("button[id$='portfee']").each(function(index,element){
                	if(element.id.replace("portfee","") != maxIndex[3]){
                		$("#"+element.id).attr("class", "btn green mini");
                	}else{
                		$("#"+element.id).attr("class", "btn green mini active");
                		$('#portfee_title').html(this.innerHTML);
                	}
                });*/
                
                
                $("button[id$='portfee']").bind("click", function () {
                	var id = this.id;
                    $("button[id$='portfee']").each(function(index,element){
                    	if(element.id != id){
                    		$("#"+element.id).attr("class", "btn green mini");
                    	}else{
                    		$("#"+element.id).attr("class", "btn green mini active");
                    	}
                    });
                    var cityId = id.replace("portfee","");
                    initPortfee(cityId);
                });
                
               function initPortfee(cityId) {
                	var thisYear = 0;
                	var lastYear = 0;
                	var percent = 0;
                	var str = "";
                	var indexNum = cities[cityId][0];
                	$('#site_portfee_content').hide();
                    $('#site_portfee_loading').show();
                    plot_portfees.setData( [{
                        data: thisYearCbgwfData[indexNum]
                        /*label: firstyear*/
                    }, {
                        data: passYearCbgwfData[indexNum]
                        /*label: secondyear*/
                    }]);
                    plot_portfees.setupGrid();
                    plot_portfees.draw();
                    $("#site_portfee > .flot-text > .y1Axis > div").css("left", "0px");
                	$('#portfee_title').html(cities[cityId][1]);               	
                    $('#site_portfee_loading').hide();
                    $('#site_portfee_content').show();
                	for(var i=0;i<thisYearCbgwfData[indexNum].length;i++){
                		if(thisYearCbgwfData[indexNum][i][0]<=lastMonth){
                			thisYear = thisYear + thisYearCbgwfData[indexNum][i][1];
                		}
            		}
            		for(var i=0;i<passYearCbgwfData[indexNum].length;i++){
            			if(passYearCbgwfData[indexNum][i][0]<=lastMonth){
            				lastYear = lastYear + passYearCbgwfData[indexNum][i][1];
            			}
            		}
                    if(thisYear / lastYear > 1){
            			percent = thisYear / lastYear * 100 - 100;
            			str = "增加";
            		}else{
            			percent = 100 - thisYear / lastYear * 100;
            			str = "减少";
            		}
                    if(lastMonth>1){
	                    $('#site_portfee_desc').html(firstyear+'年1-'+lastMonth+'月:<span style="color: red;">'+thisYear.toFixed(2)
	                    		+'</span>万元;'+secondyear+'年同期:<span style="color: red;">'+lastYear.toFixed(2)
	                    		+'</span>万元;'+str+'<span style="color: red;">'+ percent.toFixed(2) +'%</span>');
                    }else if(lastMonth==1){
                    	$('#site_portfee_desc').html(firstyear+'年1月:<span style="color: red;">'+thisYear.toFixed(2)
	                    		+'</span>万元;'+secondyear+'年同期:<span style="color: red;">'+lastYear.toFixed(2)
	                    		+'</span>万元;'+str+'<span style="color: red;">'+ percent.toFixed(2) +'%</span>');
                    }
                };

                var previousPointPortfee = null;
                $("#site_portfee").bind("plothover", function (event, pos, item) {
                    $("#x").text(pos.x.toFixed(2));
                    $("#y").text(pos.y.toFixed(2));
                    if (item) {
                        if (previousPointPortfee != item.dataIndex) {
                        	previousPointPortfee = item.dataIndex;

                            $("#tooltip").remove();
                            var x = item.datapoint[0].toFixed(2),
                                y = item.datapoint[1].toFixed(2);

                            showTooltip($('#portfee_title').html()+parseInt(x)+'月', item.pageX, item.pageY,  y);
                        }
                    } else {
                        $("#tooltip").remove();
                        previousPointPortfee = null;
                    }
                });
            } 
            
            if ($('#site_security').size() != 0) {

                $('#site_security_loading').hide();
                $('#site_security_content').show();
                  
                var plot_security = $.plot($("#site_security"), [{
//                        data: thisYearAqjccsData[maxIndex[4]],
                        data: thisYearAqjccsData[0]
                        /*label: firstyear*/
                    }, {
                        data: passYearAqjccsData[0]
                        /*label: secondyear*/
                    }
                ], {
                    series: {
                        lines: {
                            show: true,
                            lineWidth: 2
//                            ,
//                            fill: true,
//                            fillColor: {
//                                colors: [{
//                                        opacity: 0.05
//                                    }, {
//                                        opacity: 0.01
//                                    }
//                                ]
//                            }
                        },
                        points: {
                            show: true
                        },
                        shadowSize: 2
                    },
                    grid: {
                        hoverable: true,
                        clickable: true,
                        tickColor: "#eee",
                        borderWidth: 0
                    },
                    //colors: ["#37b7f3", "#d12610"],
                    colors: ["#d12610", "#37b7f3"],
                    xaxis: {
                    	min: 1,
                    	max:12,
                        ticks: 11,
                        tickDecimals: 0,
                        tickFormatter: function (v) {
                            return v + "月";
                        }
                    },
                    yaxis: {
                        min: 0,                       
                    	ticks:2,                     
                        tickLength: 15,
                        tickDecimals: 0
                    },
                    legend: {
                        noColumns: 0,
                        labelBoxBorderColor: "#000000",
                        margin: 0,
                        position: "ne"
                    }
                });
                /*
                $("button[id$='security']").each(function(index,element){
                	if(element.id.replace("security","") != maxIndex[4]){
                		$("#"+element.id).attr("class", "btn green mini");
                	}else{
                		$("#"+element.id).attr("class", "btn green mini active");
                		$('#security_title').html(this.innerHTML);
                	}
                });*/
                
                
                $("button[id$='security']").bind("click", function () {
                	var id = this.id;
                    $("button[id$='security']").each(function(index,element){
                    	if(element.id != id){
                    		$("#"+element.id).attr("class", "btn green mini");
                    	}else{
                    		$("#"+element.id).attr("class", "btn green mini active");
                    	}
                    });
                    var cityId = id.replace("security","");
                    initSecurity(cityId);
                });
                
                function initSecurity(cityId) {
                	var thisYear = 0;
                	var lastYear = 0;
                	var percent = 0;
                	var str = "";
                	var indexNum = cities[cityId][0];
                	$('#site_security_content').hide();
                    $('#site_security_loading').show();
                    plot_security.setData( [{
                        data: thisYearAqjccsData[indexNum]
                        /*label: firstyear*/
                    }, {
                        data: passYearAqjccsData[indexNum]
                        /*label: secondyear*/
                    }]);
                    plot_security.setupGrid();
                    plot_security.draw();
                    $("#site_security > .flot-text > .y1Axis > div").css("left", "0px");
                	$('#security_title').html(cities[cityId][1]);
                    $('#site_security_loading').hide();
                    $('#site_security_content').show();
                	for(var i=0;i<thisYearAqjccsData[indexNum].length;i++){
                		if(thisYearAqjccsData[indexNum][i][0]<=lastMonth){
                			thisYear = thisYear + thisYearAqjccsData[indexNum][i][1];
                		}
            		}
            		for(var i=0;i<passYearAqjccsData[indexNum].length;i++){
            			if(passYearAqjccsData[indexNum][i][0]<=lastMonth){
            				lastYear = lastYear + passYearAqjccsData[indexNum][i][1];
            			}
            		}
                    if(thisYear / lastYear > 1){
            			percent = thisYear / lastYear * 100 - 100;
            			str = "增加";
            		}else{
            			percent = 100 - thisYear / lastYear * 100;
            			str = "减少";
            		}
                    if(lastMonth>1){
	                    $('#site_security_desc').html(firstyear+'年1-'+lastMonth+'月:<span style="color: red;">'+thisYear
	                    		+'</span>艘次;'+secondyear+'年同期:<span style="color: red;">'+lastYear
	                    		+'</span>艘次;'+str+'<span style="color: red;">'+ percent.toFixed(2) +'%</span>');
                    }else if(lastMonth==1){
                    	$('#site_security_desc').html(firstyear+'年1月:<span style="color: red;">'+thisYear
	                    		+'</span>艘次;'+secondyear+'年同期:<span style="color: red;">'+lastYear
	                    		+'</span>艘次;'+str+'<span style="color: red;">'+ percent.toFixed(2) +'%</span>');
                    }
                };
                
                var previousPointSecurity = null;
                $("#site_security").bind("plothover", function (event, pos, item) {
                    $("#x").text(pos.x.toFixed(2));
                    $("#y").text(pos.y.toFixed(2));
                    if (item) {
                        if (previousPointSecurity != item.dataIndex) {
                        	previousPointSecurity = item.dataIndex;

                            $("#tooltip").remove();
                            var x = item.datapoint[0].toFixed(2),
                                y = item.datapoint[1].toFixed(2);

                            showTooltip($('#security_title').html()+parseInt(x)+'月', item.pageX, item.pageY,  parseInt(y));
                        }
                    } else {
                        $("#tooltip").remove();
                        previousPointSecurity = null;
                    }
                });
            } 

            if ($('#site_statistics').size() != 0) {

                $('#site_statistics_loading').hide();
                $('#site_statistics_content').show();
                  
                var plot_statistics = $.plot($("#site_statistics"), [{
                        data: sgs
                        /*label: "事故起数"*/
                    }, {
                        data: swrs
                        /*label: "死亡人数"*/
                    }
                ], {
                    series: {
                        lines: {
                            show: true,
                            lineWidth: 2
//                            ,
//                            fill: true,
//                            fillColor: {
//                                colors: [{
//                                        opacity: 0.05
//                                    }, {
//                                        opacity: 0.01
//                                    }
//                                ]
//                            }
                        },
                        points: {
                            show: true
                        },
                        shadowSize: 2
                    },
                    grid: {
                        hoverable: true,
                        clickable: true,
                        tickColor: "#eee",
                        borderWidth: 0
                    },
                    colors: ["#37b7f3", "#d12610"],
                    xaxis: {
                    	min: 1,
                    	max:12,
                        ticks: 11,
                        tickDecimals: 0,
                        tickFormatter: function (v) {
                            return v + "月";
                        }
                    },
                    yaxis: {
                         min: 0,                       
                    	ticks:2,                     
                        tickLength: 15,
                        tickDecimals: 0
                    },
                    legend: {
                        noColumns: 0,
                        labelBoxBorderColor: "#000000",
                        margin: 0,
                        position: "ne"
                    }
                });
                
                var accident = 0;
                var death = 0;
                for(var i=0;i<sgs.length;i++){
                	if(sgs[i][0]<=lastMonth){
                		accident = accident + sgs[i][1];
                	}
                }
                for(var i=0;i<swrs.length;i++){
                	if(swrs[i][0]<=lastMonth){
                		death = death + swrs[i][1];
                	}
                }
                if(curmonth>1){
                	$('#site_statistics_desc').html('今年1-'+curmonth+'月事故起数为<span style="color: red;">'+accident
                    		+'</span>起，死亡人数为<span style="color: red;">'+death +'</span>人。');
                }else if(curmonth==1){
                	$('#site_statistics_desc').html('今年1月事故起数为<span style="color: red;">'+accident
                    		+'</span>起，死亡人数为<span style="color: red;">'+death +'</span>人。');
                }
                
                
                $("button[id$='site_statistics']").bind("click", function () {
                	var id = this.id;
                	$('#site_statistics_content').hide();
                    $('#site_statistics_loading').show();
                    $("button[id$='site_statistics']").each(function(index,element){
                    	if(element.id != id){
                    		$("#"+element.id).attr("class", "btn green mini");
                    	}else{
                    		$("#"+element.id).attr("class", "btn green mini active");
                    	}
                    });
                    plot_statistics.setData( [{
                        data: sgsFullYear[id.replace("site_statistics","")]
                        /*label: "事故起数"*/
                    }, {
                        data: swrsFullYear[id.replace("site_statistics","")]
                        /*label: "死亡人数"*/
                    }]);
                    plot_statistics.setupGrid();
                    plot_statistics.draw();
                    $("#statistics > .flot-text > .y1Axis > div").css("left", "0px");
                    $('#statistics_title').html(this.innerHTML);
                    $('#site_statistics_loading').hide();
                    $('#site_statistics_content').show();
                });
                var previousPoint = null;
                $("#site_statistics").bind("plothover", function (event, pos, item) {
                    $("#x").text(pos.x.toFixed(2));
                    $("#y").text(pos.y.toFixed(2));
                    if (item) {
                        if (previousPoint != item.dataIndex) {
                            previousPoint = item.dataIndex;

                            $("#tooltip").remove();
                            var x = item.datapoint[0].toFixed(2),
                                y = item.datapoint[1].toFixed(2);

                            showTooltip($('#statistics_title').html()+parseInt(x)+'月', item.pageX, item.pageY,  parseInt(y));
                        }
                    } else {
                        $("#tooltip").remove();
                        previousPoint = null;
                    }
                });
            } 
            
            

            if ($('#load_check').size() != 0) {
                 //server load
                $('#check_activities_loading').hide();
                $('#load_check_content').show();
        
               // var updateInterval = 30;
                var plot_check = $.plot($("#load_check"), [{
//                    	data: buildCount[maxIndex[1]],
                    	data: buildCount[0]
                    	/*label: firstyear*/
                    }, {
                        data: buildCountLastYear[0]
                        /*label: secondyear*/
                    }
                ], {
                series: {
                    points: {
                        show: true
                    },
                    shadowSize: 2
                },
                lines: {
                    show: true,
                    lineWidth: 2
//                    ,
//                    fill: true,
//                    fillColor: {
//                        colors: [{
//                                opacity: 0.05
//                            }, {
//                                opacity: 0.01
//                            }
//                        ]
//                    }
                },
                yaxis: {
                        min: 0,                       
                    	ticks:2,                     
                        tickLength: 15,
                        tickDecimals: 0,
                    tickFormatter: function (v) {
                        return v + "";
                    }
                },
                xaxis: {
                	min:1,
                	max:12,
                	ticks: 11,
                	tickDecimals: 0,
                    tickFormatter: function (v) {
                        return v + "月";
                    }
                },
                //colors: ["#37b7f3", "#d12610"],
                colors: ["#d12610", "#37b7f3"],
                grid: {
                    show: true,
                    hoverable: true,
                    clickable: false,
                    autoHighlight: true,
                    borderWidth: 0
                },
                legend: {
                    noColumns: 0,
                    labelBoxBorderColor: "#000000",
                    margin: 0,
                    position: "ne"
                }
                });
                
               /* $("button[id$='load_check']").each(function(index,element){
                	if(element.id.replace("load_check","") != maxIndex[1]){
                		$("#"+element.id).attr("class", "btn green mini");
                	}else{
                		$("#"+element.id).attr("class", "btn green mini active");
                		$('#check_title').html(this.innerHTML + "船舶建造检验量");
                	}
                });*/
                
                
                $("button[id$='load_check']").bind("click", function () {
                	var id = this.id;
                    $("button[id$='load_check']").each(function(index,element){
                    	if(element.id != id){
                    		$("#"+element.id).attr("class", "btn green mini");
                    	}else{
                    		$("#"+element.id).attr("class", "btn green mini active");
                    	}
                    });
                    var cityId = id.replace("load_check","");
                    initLoad_check(cityId);
                });
                
                function initLoad_check(cityId) {
                	var thisYear = 0;
                	var lastYear = 0;
                	var percent = 0;
                	var str = "";
                	var indexNum = cities2[cityId][0];
                	$('#load_check_content').hide();
                    $('#check_activities_loading').show();
                    if(jytype == "acjjy"){
                    	
                    	$("#98").attr("class", "btn green mini"); 
                    	$("#99").attr("class", "btn green mini hidden");
                    	
                    	$("#acjjy").attr("class", "btn purple mini active"); 
                    	$("#ayyjy").attr("class", "btn blue mini");
                    	plot_check.setData( [{
                    		data: buildCount[indexNum]
                    		/*label: firstyear*/
                    	}, {
                    		data: buildCountLastYear[indexNum]
                    		/*label: secondyear*/
                    	}]);
                    	for(var i=0;i<buildCount[indexNum].length;i++){
                    		if(buildCount[indexNum][i][0]<=lastMonth){
                    			thisYear = thisYear + buildCount[indexNum][i][1];
                    		}
                		}
                    	for(var i=0;i<buildCountLastYear[indexNum].length;i++){
                    		if(buildCountLastYear[indexNum][i][0]<=lastMonth){
                    			lastYear = lastYear + buildCountLastYear[indexNum][i][1];
                    		}
                    	}
                    	$('#check_title').html(cities2[cityId][1] + "船舶建造检验");
                    }
                    if(jytype == "ayyjy"){
                    	
                    	$("#99").attr("class", "btn green mini"); 
                    	$("#98").attr("class", "btn green mini hidden");
                    	
                    	$("#acjjy").attr("class", "btn purple mini"); 
                    	$("#ayyjy").attr("class", "btn blue mini active");
                    	plot_check.setData( [{
                    		data: runCount[indexNum]
                    		/*label: firstyear*/
                    	}, {
                    		data: runCountLastYear[indexNum]
                    		/*label: secondyear*/
                    	}]);
                    	for(var i=0;i<runCount[indexNum].length;i++){
                    		if(runCount[indexNum][i][0]<=lastMonth){
                    			thisYear = thisYear + runCount[indexNum][i][1];
                    		}
                		}
                    	for(var i=0;i<runCountLastYear[indexNum].length;i++){
                    		if(runCountLastYear[indexNum][i][0]<=lastMonth){
                    			lastYear = lastYear + runCountLastYear[indexNum][i][1];
                    		}
                    	}
                    	$('#check_title').html(cities2[cityId][1] + "船舶营运检验"); 
                    }
                    if(thisYear / lastYear > 1){
            			percent = thisYear / lastYear * 100 - 100;
            			str = "增加";
            		}else{
            			percent = 100 - thisYear / lastYear * 100;
            			str = "减少";
            		}
                	plot_check.setupGrid();
                	plot_check.draw();
                	$("#load_check > .flot-text > .y1Axis > div").css("left", "0px");
                    $('#check_activities_loading').hide();
                    if(lastMonth>1){
                    	$('#load_check_desc').html(firstyear+'年1-'+lastMonth+'月:<span style="color: red;">'+thisYear
                        		+'</span>艘次;'+secondyear+'年同期:<span style="color: red;">'+lastYear
                        		+'</span>艘次;'+str+'<span style="color: red;">'+ percent.toFixed(2) +'%</span>');
                    }else if(lastMonth==1){
                    	$('#load_check_desc').html(firstyear+'年1月:<span style="color: red;">'+thisYear
                        		+'</span>艘次;'+secondyear+'年同期:<span style="color: red;">'+lastYear
                        		+'</span>艘次;'+str+'<span style="color: red;">'+ percent.toFixed(2) +'%</span>');
                    }
                    
                    $('#load_check_content').show();
                };
                
                $("#acjjy").bind("click", function () {
                	
                	$("#98").attr("class", "btn green mini"); 
                	$("#99").attr("class", "btn green mini hidden");
                	
                    $('#load_check_content').hide();
                    $('#check_activities_loading').show();
                	$("#acjjy").attr("class", "btn purple mini active"); 
                	$("#ayyjy").attr("class", "btn blue mini");
                	var cityId = cityCode2;
                	var indexNum = cities2[cityId][0];
                	var thisYear = 0;
                	var lastYear = 0;
                	var percent = 0;
                	var str = "";
                	var flag = true;
                	$("button[id$='load_check']").each(function(index,element){
                    	if($("#"+element.id).attr("class") == "btn green mini active"){
                    		flag = false;
                    		cityId = element.id.replace("load_check","");
                    		indexNum = cities2[cityId][0];
                    		for(var i=0;i<buildCount[indexNum].length;i++){
                        		if(buildCount[indexNum][i][0]<=lastMonth){
                        			thisYear = thisYear + buildCount[indexNum][i][1];
                        		}
                    		}
                        	for(var i=0;i<buildCountLastYear[indexNum].length;i++){
                        		if(buildCountLastYear[indexNum][i][0]<=lastMonth){
                        			lastYear = lastYear + buildCountLastYear[indexNum][i][1];
                        		}
                        	}
                    		if(thisYear / lastYear > 1){
                    			percent = thisYear / lastYear * 100 - 100;
                    			str = "增加";
                    		}else{
                    			percent = 100 - thisYear / lastYear * 100;
                    			str = "减少";
                    		}
                    	}
                    });
                	if(flag){
                		for(var i=0;i<buildCount[indexNum].length;i++){
                    		if(buildCount[indexNum][i][0]<=lastMonth){
                    			thisYear = thisYear + buildCount[indexNum][i][1];
                    		}
                		}
                    	for(var i=0;i<buildCountLastYear[indexNum].length;i++){
                    		if(buildCountLastYear[indexNum][i][0]<=lastMonth){
                    			lastYear = lastYear + buildCountLastYear[indexNum][i][1];
                    		}
                    	}
                		if(thisYear / lastYear > 1){
                			percent = thisYear / lastYear * 100 - 100;
                			str = "增加";
                		}else{
                			percent = 100 - thisYear / lastYear * 100;
                			str = "减少";
                		}
                	}
                	plot_check.setData( [{
                        data: buildCount[indexNum]
                        /*label: firstyear*/
                    }, {
                        data: buildCountLastYear[indexNum]
                       /* label: secondyear*/
                    }]);
                	plot_check.setupGrid();
                	plot_check.draw();
                	$("#load_check > .flot-text > .y1Axis > div").css("left", "0px");
                	$('#check_title').html(cities2[cityId][1]+"船舶建造检验"); 
                    $('#check_activities_loading').hide();
                    if(lastMonth>1){
	                    $('#load_check_desc').html(firstyear+'年1-'+lastMonth+'月:<span style="color: red;">'+thisYear
	                    		+'</span>艘次;'+secondyear+'年同期:<span style="color: red;">'+lastYear
	                    		+'</span>艘次;'+str+'<span style="color: red;">'+ percent.toFixed(2) +'%</span>');
                    }else {
                    	$('#load_check_desc').html(firstyear+'年1月:<span style="color: red;">'+thisYear
	                    		+'</span>艘次;'+secondyear+'年同期:<span style="color: red;">'+lastYear
	                    		+'</span>艘次;'+str+'<span style="color: red;">'+ percent.toFixed(2) +'%</span>');
                    }
                    $('#load_check_content').show();
                    jytype = "acjjy";
                });
                $("#ayyjy").bind("click", function () {
                	
                	$("#99").attr("class", "btn green mini "); 
                	$("#98").attr("class", "btn green mini hidden");
                	
                    $('#load_check_content').hide();
                    $('#check_activities_loading').show();
                	$("#acjjy").attr("class", "btn purple mini"); 
                	$("#ayyjy").attr("class", "btn blue mini active");
                	var cityId = cityCode2;
                	var indexNum = cities2[cityId][0];
                	var thisYear = 0;
                	var lastYear = 0;
                	var percent = 0;
                	var str = "";
                	var flag=true;
                	$("button[id$='load_check']").each(function(index,element){
                    	if($("#"+element.id).attr("class") == "btn green mini active"){
                    		flag=false;
                    		cityId = element.id.replace("load_check","");
                    		indexNum = cities2[cityId][0];
                    		for(var i=0;i<runCount[indexNum].length;i++){
                        		if(runCount[indexNum][i][0]<=lastMonth){
                        			thisYear = thisYear + runCount[indexNum][i][1];
                        		}
                    		}
                        	for(var i=0;i<runCountLastYear[indexNum].length;i++){
                        		if(runCountLastYear[indexNum][i][0]<=lastMonth){
                        			lastYear = lastYear + runCountLastYear[indexNum][i][1];
                        		}
                        	}
                    		if(thisYear / lastYear > 1){
                    			percent = thisYear / lastYear * 100 - 100;
                    			str = "增加";
                    		}else{
                    			percent = 100 - thisYear / lastYear * 100;
                    			str = "减少";
                    		}
                    	}
                    });
                	if(flag){
                    		for(var i=0;i<runCount[indexNum].length;i++){
                        		if(runCount[indexNum][i][0]<=lastMonth){
                        			thisYear = thisYear + runCount[indexNum][i][1];
                        		}
                    		}
                        	for(var i=0;i<runCountLastYear[indexNum].length;i++){
                        		if(runCountLastYear[indexNum][i][0]<=lastMonth){
                        			lastYear = lastYear + runCountLastYear[indexNum][i][1];
                        		}
                        	}
                    		if(thisYear / lastYear > 1){
                    			percent = thisYear / lastYear * 100 - 100;
                    			str = "增加";
                    		}else{
                    			percent = 100 - thisYear / lastYear * 100;
                    			str = "减少";
                    		}
                	}
                	plot_check.setData( [{
                        data: runCount[indexNum]
                        /*label: firstyear*/
                    }, {
                        data: runCountLastYear[indexNum]
                        /*label: secondyear*/
                    }]);
                	plot_check.setupGrid();
                	plot_check.draw();
                	
                	$('#check_title').html(cities2[cityId][1] + "船舶营运检验"); 
                    $('#check_activities_loading').hide();
                    if(lastMonth>1){
                    	$('#load_check_desc').html(firstyear+'年1-'+lastMonth+'月:<span style="color: red;">'+thisYear
                        		+'</span>艘次;'+secondyear+'年同期:<span style="color: red;">'+lastYear
                        		+'</span>艘次;'+str+'<span style="color: red;">'+ percent.toFixed(2) +'%</span>');
                    }else {
                    	$('#load_check_desc').html(firstyear+'年1月:<span style="color: red;">'+thisYear
                        		+'</span>艘次;'+secondyear+'年同期:<span style="color: red;">'+lastYear
                        		+'</span>艘次;'+str+'<span style="color: red;">'+ percent.toFixed(2) +'%</span>');
                    }
                    
                    $('#load_check_content').show();
                    jytype = "ayyjy";
                });  
                

//                function statisticsUpdate() {
//                plot_statistics.setData([getRandomData()]);
//                plot_statistics.draw();
//                setTimeout(statisticsUpdate, updateInterval);
//                
//                }
//                
//                statisticsUpdate();
                var previousPointcheck = null;
                $("#load_check").bind("plothover", function (event, pos, item) {
                    $("#x").text(pos.x.toFixed(2));
                    $("#y").text(pos.y.toFixed(2));
                    if (item) {
                        if (previousPointcheck != item.dataIndex) {
                        	previousPointcheck = item.dataIndex;
                            $("#tooltip").remove();
                            var x = item.datapoint[0].toFixed(2),
                                y = item.datapoint[1].toFixed(2);
                            showTooltip($('#check_title').html()+parseInt(x)+'月', item.pageX, item.pageY, parseInt(y));
                        }
                    } else {
                        $("#tooltip").remove();
                        previousPointcheck = null;
                    }
                });


            }

            /*if ($('#site_activities').size() != 0) {
                //site activities
                var previousPoint2 = null;
                $('#load_statistics_loading').hide();
                $('#site_activities_content').show();

                
                previousPoint2 = $.plot(
                        $("#site_activities"), [{
                            data: goodnum,
                            color: "rgba(107,207,123, 0.9)",
                            shadowSize: 0,
                            bars: {
                                show: true,
                                lineWidth: 0,
                                fill: true,
                                fillColor: {
                                    colors: [{
                                            opacity: 1
                                        }, {
                                            opacity: 1
                                        }
                                    ]
                                }
                            }
                        }
                    ], {
                            series: {
                                bars: {
                                    show: true,
                                    barWidth: 0.9
                                }
                            },
                            grid: {
                                show: true,
                                hoverable: true,
                                clickable: false,
                                autoHighlight: true,
                                borderWidth: 0
                            },
                            yaxis: {
                        min: 0,                       
                    	ticks:2,                     
                        tickLength: 15,
                        tickDecimals: 0
                            },
                            xaxis: {          
                            	  ticks: goodticek,
                            	  show: false
                            	}
                        });

                $("#site_activities").bind("plothover", function (event, pos, item) {
                    $("#x").text(pos.x.toFixed(2));
                    $("#y").text(pos.y.toFixed(2));
                    if (item) {
                        if (previousPoint2 != item.dataIndex) {
                            previousPoint2 = item.dataIndex;
                            $("#tooltip").remove();
                            var x = item.datapoint[0].toFixed(2),
                                y = item.datapoint[1].toFixed(2);
                            showTooltip(goodticek[previousPoint2][1], item.pageX, item.pageY, goodnum[previousPoint2][1]);
                        }
                    }
                });

                $('#site_activities').bind("mouseleave", function () {
                    $("#tooltip").remove();
                });
            }*/
            
            if ($('#certificate').size() != 0) {
                $('#certificate_loading').hide();
                $('#certificate_content').show();
                  
                var plot_certificate = $.plot($("#certificate"), [{
//                        data: certificate[maxIndex[5]],
                        data: certificate[0]
                       /* label: firstyear*/
                    }, {
                        data: certificateLastYear[0]
                       /* label: secondyear*/
                    }
                ], {
                    series: {
                        lines: {
                            show: true,
                            lineWidth: 2
//                            ,
//                            fill: true,
//                            fillColor: {
//                                colors: [{
//                                        opacity: 0.05
//                                    }, {
//                                        opacity: 0.01
//                                    }
//                                ]
//                            }
                        },
                        points: {
                            show: true
                        },
                        shadowSize: 2
                    },
                    grid: {
                        hoverable: true,
                        clickable: true,
                        tickColor: "#eee",
                        borderWidth: 0
                    },
                    //colors: ["#37b7f3", "#d12610"],
                    colors: ["#d12610", "#37b7f3"],
                    xaxis: {
                    	min: 1,
                    	max:12,
                        ticks: 11,
                        tickDecimals: 0,
                        tickFormatter: function (v) {
                            return v + "月";
                        }
                    },
                    yaxis: {
                        min: 0,                       
                    	ticks:2,                     
                        tickLength: 15,
                        tickDecimals: 0
                    },
                    legend: {
                        noColumns: 0,
                        labelBoxBorderColor: "#000000",
                        margin: 0,
                        position: "ne"
                    }
                });
                
                /*$("button[id$='certificate']").each(function(index,element){
                	if(element.id.replace("certificate","") != maxIndex[5]){
                		$("#"+element.id).attr("class", "btn green mini");
                	}else{
                		$("#"+element.id).attr("class", "btn green mini active");
                		$('#certificate_title').html(this.innerHTML);
                	}
                });*/
                
                
                $("button[id$='certificate']").bind("click", function () {
                	var id = this.id;
                    $("button[id$='certificate']").each(function(index,element){
                    	if(element.id != id){
                    		$("#"+element.id).attr("class", "btn green mini");
                    	}else{
                    		$("#"+element.id).attr("class", "btn green mini active");
                    	}
                    });
                    var cityId = id.replace("certificate","");
                    initCertificate(cityId);
                });
                
               function initCertificate(cityId) {
                	var thisYear = 0;
                	var lastYear = 0;
                	var percent = 0;
                	var str = "";
                	var indexNum = cities[cityId][0];
                	$('#certificate_content').hide();
                    $('#certificate_loading').show();
                    plot_certificate.setData( [{
                        data: certificate[indexNum]
                        /*label: firstyear*/
                    }, {
                        data: certificateLastYear[indexNum]
                        /*label: secondyear*/
                    }]);
                    plot_certificate.setupGrid();
                    plot_certificate.draw();
                    $("#certificate > .flot-text > .y1Axis > div").css("left", "0px");
                    $('#certificate_title').html(cities[cityId][1]);
                    $('#certificate_loading').hide();
                    $('#certificate_content').show();
                	for(var i=0;i<certificate[indexNum].length;i++){
                		if(certificate[indexNum][i][0]<=lastMonth){
                			thisYear = thisYear + certificate[indexNum][i][1];
                		}
            		}
            		for(var i=0;i<certificateLastYear[indexNum].length;i++){
            			if(certificateLastYear[indexNum][i][0]<=lastMonth){
            				lastYear = lastYear + certificateLastYear[indexNum][i][1];
            			}
            		}
                    if(thisYear / lastYear > 1){
            			percent = thisYear / lastYear * 100 - 100;
            			str = "增加";
            		}else{
            			percent = 100 - thisYear / lastYear * 100;
            			str = "减少";
            		}
                    if(lastMonth>1){
                    	 $('#site_certificate_desc').html(firstyear+'年1-'+lastMonth+'月:<span style="color: red;">'+thisYear
                         		+'</span>本;'+secondyear+'年同期:<span style="color: red;">'+lastYear
                         		+'</span>本;'+str+'<span style="color: red;">'+ percent.toFixed(2) +'%</span>');
                    }else{
                    	 $('#site_certificate_desc').html(firstyear+'年1月:<span style="color: red;">'+thisYear
                         		+'</span>本;'+secondyear+'年同期:<span style="color: red;">'+lastYear
                         		+'</span>本;'+str+'<span style="color: red;">'+ percent.toFixed(2) +'%</span>');
                    }
                   
                };
                
                var previousPoint = null;
                $("#certificate").bind("plothover", function (event, pos, item) {
                    $("#x").text(pos.x.toFixed(2));
                    $("#y").text(pos.y.toFixed(2));
                    if (item) {
                        if (previousPoint != item.dataIndex) {
                            previousPoint = item.dataIndex;

                            $("#tooltip").remove();
                            var x = item.datapoint[0].toFixed(2),
                                y = item.datapoint[1].toFixed(2);

                            showTooltip($('#certificate_title').html()+parseInt(x)+'月', item.pageX, item.pageY,  parseInt(y));
                        }
                    } else {
                        $("#tooltip").remove();
                        previousPoint = null;
                    }
                });
            } 
           
            
         /*   if ($('#pieChart').size() != 0) {
        	myChart = echarts.init($('#pieChart')[0]);
        	option = {
        	    title: {
        	        text : curmonth+'月船舶签证货物',
        				x: 'left'
        	    },
        	    tooltip : {
        	        trigger: 'item'
        	    },
        	    legend: {
        	        orient: 'vertical',
        	        x:'right',
        	        data:eval('('+type+')')
        	    },

        	    series : [
        	            {
        	            	name:'装载总量（吨）',
        	                type:'pie',
        	                tooltip: {
        	                    trigger: 'item',
        	                    formatter: "{a} <br/>{b} : {c} ({d}%)"
        	                },
        	                mapLocation: {
        		                x: 'right'
        		            },
        	                //center: [document.getElementById('chart').offsetWidth - 250, 225],
        	                radius: [30, 60],
        	                itemStyle : {
        	                    normal : {
        	                        label : {
        	                            show : false
        	                        },
        	                        labelLine : {
        	                            show : false
        	                        }
        	                    }
        	                },	                
        	                data: series	                
        	            } 
        	    ]
        	};  
        	myChart.setOption(option);
            }*/
            
            initLoad_check(cityCode2);
            initPunishments(cityCode);
            initPortfee(cityCode);
            initSecurity(cityCode);
            initCertificate(cityCode);

            
            refreshMap(buildCount, "emapAcjjy",1,'检验次数');
            refreshMap(runCount, "emapAyyjy",1,'检验次数');
            refreshMap(thisYearXzcfbData, "emapPunishments",2,'行政处罚案件数');
            refreshMap(thisYearCbgwfData, "emapPortfee",2,'船舶港务费（万元）');
            refreshMap(thisYearAqjccsData, "emapSecurity",2,'安全检查艘次'); 
            refreshMap(certificate, "emapCertificate",1,'适任证发放本数');

            refreshTable(buildCount,"Acjjy",1,'检验次数',numC);
            
            $("button[id='btnemapAcjjy']").bind("click",function(){
            	changeBtnClass();
            	$("button[id='btnemapAcjjy']").attr("class","btn green mini active");
            	data = slidey.data('unslider');
            	data.move(0, function() {});  
            	refreshTable(buildCount, "Acjjy",1,'检验次数',numC);
            });
            $("button[id='btnemapAyyjy']").bind("click",function(){
            	changeBtnClass();
            	$("button[id='btnemapAyyjy']").attr("class","btn green mini active");
            	data = slidey.data('unslider');
            	data.move(1, function() {}); 
            	refreshTable(runCount, "Ayyjy",1,'检验次数',numC);
            });
            $("button[id='btnemapPunishments']").bind("click",function(){
            	changeBtnClass();
            	$("button[id='btnemapPunishments']").attr("class","btn green mini active");
            	data = slidey.data('unslider');
            	data.move(2, function() {}); 
            	refreshTable(thisYearXzcfbData, "Punishments",2,'行政处罚案件数',numA);
            });
            $("button[id='btnemapPortfee']").bind("click",function(){
            	changeBtnClass();
            	$("button[id='btnemapPortfee']").attr("class","btn green mini active");
            	data = slidey.data('unslider');
            	data.move(3, function() {}); 
            	refreshTable(thisYearCbgwfData, "Portfee",2,'船舶港务费（万元）',numA);
            });
            $("button[id='btnemapSecurity']").bind("click",function(){
            	changeBtnClass();
            	$("button[id='btnemapSecurity']").attr("class","btn green mini active");
            	data = slidey.data('unslider');
            	data.move(4, function() {}); 
            	refreshTable(thisYearAqjccsData, "Security",2,'安全检查艘次',numA);
            });
            $("button[id='btnemapCertificate']").bind("click",function(){
            	changeBtnClass();
            	$("button[id='btnemapCertificate']").attr("class","btn green mini active");
            	data = slidey.data('unslider');
            	data.move(5, function() {});
            	refreshTable(certificate, "Certificate",2,'适任证发放本数',numB);
            });
            
            function changeBtnClass(){
            	 $("button[id='btnemapAcjjy']").attr("class","btn green mini");
            	 $("button[id='btnemapAyyjy']").attr("class","btn green mini");
            	 $("button[id='btnemapPunishments']").attr("class","btn green mini");
            	 $("button[id='btnemapPortfee']").attr("class","btn green mini");
            	 $("button[id='btnemapSecurity']").attr("class","btn green mini");
            	 $("button[id='btnemapCertificate']").attr("class","btn green mini");
            }

        },

        initIntro: function () {
        	return;

        }

    };

}();