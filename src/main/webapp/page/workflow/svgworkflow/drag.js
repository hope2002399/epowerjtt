/*
 * 矩形移动、小圆移动改变线折线点位置JS文件
 */

function isbrowser(){
	var userAgent = navigator.userAgent,
	    isOpera = userAgent.indexOf("Opera") > -1;
	
	if (userAgent.indexOf("Opera") > -1){ return "Opera"; }
	if (userAgent.indexOf("Firefox") > -1){ return "FF"; }
	if (userAgent.indexOf("Safari") > -1){ return "Safari"; }
	if (userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1 && !isOpera){ return "IE"; }
}
var g = function(id){ return document.getElementById(id); }

var addEvent = function(o,eventType,fn){
	if(document.addEventListener){
  		o.addEventListener(eventType,fn,true);
 	}else if(document.attachEvent){
  		o.attachEvent('on'+eventType,fn);
 	}else{
  		o['on'+eventType] = fn;
 	}
}
var removeEvent = function(o,eventType,fn){
	if(document.removeEventListener){
  		document.removeEventListener(eventType,fn,true);
 	}else if(document.detachEvent){
  		o.detachEvent('on'+eventType,fn);
 	}
}

function drag(o){
	var defaultOptions = {
			moveObject:o
		},
		deltaX = 0, deltaY = 0, initX = 0, initY = 0, pointArray1 = new Array,pointArray2 = new Array,p1_1=new Array,p1_2=new Array,beginLinePoints,isMove = 0,oldWidth,oldHeight,
		p2_1=new Array,p2_2=new Array,undoX,undoY,redoX,redoY,lineArray1=new Array,lineArray2=new Array,nPoint,line_points,fromArray = new Array,toArray = new Array,
		action = {
			move:function(e){
				var e = e || window.event,
					MouseX = e.clientX/_ZOOM,
					MouseY = e.clientY/_ZOOM,
					o = defaultOptions.moveObject;
				switch(o.nodeName){
					case "rect":
						var text = o.getAttribute("textID");
						o.setAttribute("x",MouseX-deltaX);
						o.setAttribute("y",MouseY-deltaY);
						redoX = o.getAttribute("x");
						redoY = o.getAttribute("y");
						g(text).setAttribute("x",parseInt(o.getAttribute("x"))+5);
						g(text).setAttribute("y",parseInt(o.getAttribute("y"))+(rectHeight/2)+6);
						g(text).setAttribute("dx",parseInt(o.getAttribute("x"))+(rectWidth/2));							
						if(o.getAttribute("lineID")){
							if(o.getAttribute("shapetype")=="ju"){
								var points = parseInt(o.getAttribute("x"))+","+(parseInt(o.getAttribute("y"))+rectHeight/6)+" "+(parseInt(o.getAttribute("x"))+parseInt(o.getAttribute("width")))+","+(parseInt(o.getAttribute("y"))+rectHeight/6);
								g(o.getAttribute("lineID")).setAttribute("points",points);
							}
							else if(o.getAttribute("shapetype")=="bing"){
								var points = parseInt(o.getAttribute("x"))+","+(parseInt(o.getAttribute("y"))+parseInt(o.getAttribute("height"))-rectHeight/6)+" "+(parseInt(o.getAttribute("x"))+parseInt(o.getAttribute("width")))+","+(parseInt(o.getAttribute("y"))+parseInt(o.getAttribute("height"))-rectHeight/6);
								g(o.getAttribute("lineID")).setAttribute("points",points);
							}
							else if(o.getAttribute("shapetype")=="multi"){
								var points = parseInt(o.getAttribute("x"))+","+(parseInt(o.getAttribute("y"))+parseInt(o.getAttribute("height"))-rectHeight/6)+" "+(parseInt(o.getAttribute("x"))+parseInt(o.getAttribute("width")))+","+(parseInt(o.getAttribute("y"))+parseInt(o.getAttribute("height"))-rectHeight/6);
								g(o.getAttribute("lineID")).setAttribute("points",points);
							}
							
						}
						//g(text).getElementsByTagName("tspan")[0].setAttribute("x",g(text).getAttribute("x"));
						break;
					case "ellipse":
						o.setAttribute("cx",MouseX-deltaX);
						o.setAttribute("cy",MouseY-deltaY);
						redoX = Number(o.getAttribute("cx"))+6;
						redoY = Number(o.getAttribute("cy"))+6;
						dragPolylinePoint(g(o.getAttribute("lineID")),[MouseX-deltaX,MouseY-deltaY],nPoint,line_points);
						break;
					default:break;
				}
				if(o.getAttribute("from")){
					for(var i=0,len=lineArray1.length;i<len;i++){
						pointArray1[i][0] = (p1_1[i] + MouseX-initX) +","+ (p1_2[i] + MouseY-initY);
						g(lineArray1[i]).setAttribute("points",pointArray1[i].join(" "));
						g(lineArray1[i]).removeAttribute("marker-end");
					}
					
				}
				if(o.getAttribute("to")){
					for(var i=0,len=lineArray2.length;i<len;i++){
						pointArray2[i][pointArray2[i].length-1] = (p2_1[i] + MouseX-initX) +","+ (p2_2[i] + MouseY-initY);
						//g("getContent2").innerHTML = p2_1[i] + MouseX-initX;
						g(lineArray2[i]).setAttribute("points",pointArray2[i].join(" "));
						g(lineArray2[i]).removeAttribute("marker-end");
					}
					
				}
				isMove = 1;
				if(e.stopPropagation){
					e.stopPropagation();
				}else{
					e.cancleBubble = true;
				}
			},
			stop:function(e){
				var e = e || window.event;
				var fromEndArray = new Array,toEndArray = new Array,linePoints;
				removeEvent(document,"losecapture",action.stop);
				removeEvent(document,"mouseup",action.stop);
				removeEvent(document,"mousemove",action.move);
				if(document.releaseCapture) document.releaseCapture();
				if(isMove){
					if(o.nodeName=="rect"){
						if(o.getAttribute("from")){
							var line1 = o.getAttribute("from").split(",");
							for(var i=0,len=line1.length;i<len;i++){
								var clen = SVG.get(line1[i]).attr("points").split(" ").length;
								g(line1[i]).setAttribute("marker-end","url(#"+marker.attr("id")+")");
								if(clen<=2 ){
									var FP = formatLine(SVG.get(SVG.get(line1[i]).attr("from")),SVG.get(SVG.get(line1[i]).attr("to")));
									if(FP["p1"]){
										g(line1[i]).setAttribute("points",FP["p1"][0]+","+FP["p1"][1]+" "+FP["p2"][0]+","+FP["p2"][1]);										
									}
									fromEndArray[i] = SVG.get(line1[i]).attr("points");
								}else{
									fromEndArray[i] = SVG.get(line1[i]).attr("points");
								}
							}
							
						}
						if(o.getAttribute("to")){
							var line2 = o.getAttribute("to").split(",");
							for(var i=0,len=line2.length;i<len;i++){
								var clen = SVG.get(line2[i]).attr("points").split(" ").length;
								g(line2[i]).setAttribute("marker-end","url(#"+marker.attr("id")+")");
								if(clen<=2 ){
									var FP = formatLine(SVG.get(SVG.get(line2[i]).attr("from")),SVG.get(SVG.get(line2[i]).attr("to")));
									if(FP["p1"]){
										g(line2[i]).setAttribute("points",FP["p1"][0]+","+FP["p1"][1]+" "+FP["p2"][0]+","+FP["p2"][1]);										
									}
									toEndArray[i] = SVG.get(line2[i]).attr("points");
								}else{
									toEndArray[i] = SVG.get(line2[i]).attr("points");
								}
							}
						}
						if(o.getAttribute("lineID")){
							linePoints = g(o.getAttribute("lineID")).getAttribute("points");
						}
						else{
							linePoints = "";
						}
						if(o.getAttribute("from")&&!o.getAttribute("to")){
							pushLog("moveproc",{"ID":o.id,"beginLinePoints":beginLinePoints,"linePoints":linePoints,"beginX":undoX,"beginY":undoY,"endX":redoX,"endY":redoY,"beginFrom":fromArray,"endFrom":fromEndArray});
						}
						else if(!o.getAttribute("from")&&o.getAttribute("to")){
							pushLog("moveproc",{"ID":o.id,"beginLinePoints":beginLinePoints,"linePoints":linePoints,"beginX":undoX,"beginY":undoY,"endX":redoX,"endY":redoY,"beginTo":toArray,"endTo":toEndArray});
						}
						else if(o.getAttribute("from")&&o.getAttribute("to")){
							pushLog("moveproc",{"ID":o.id,"beginLinePoints":beginLinePoints,"linePoints":linePoints,"beginX":undoX,"beginY":undoY,"endX":redoX,"endY":redoY,"beginFrom":fromArray,"endFrom":fromEndArray,"beginTo":toArray,"endTo":toEndArray});
						}
						else{
							pushLog("moveproc",{"ID":o.id,"beginLinePoints":beginLinePoints,"linePoints":linePoints,"beginX":undoX,"beginY":undoY,"endX":redoX,"endY":redoY});
						}
					}
					if(o.nodeName=="ellipse"){
						g(o.getAttribute("lineID")).setAttribute("marker-end","url(#"+markerGreen.attr("id")+")");
						pushLog("moveproc",{"ID":o.getAttribute("lineID"),"beginX":undoX,"beginY":undoY,"endX":redoX,"endY":redoY,"linePoints":g(o.getAttribute("lineID")).getAttribute("points"),"nPoint":nPoint,"type":"change"});
						SVG.get(o.id).remove();
					}					
				}
				else{
					if(o.nodeName=="ellipse"){
						SVG.get(o.id).remove();
					}
				}
				if(e.stopPropagation){
					e.stopPropagation();
				}else{
					e.cancleBubble = true;
				}
			},
			
			moveScale:function(e){
				var e = e || window.event;
				MouseX = e.clientX/_ZOOM,
				MouseY = e.clientY/_ZOOM,
				o = defaultOptions.moveObject;
				  if(o.style.cursor=="e-resize"){
					  var scaleWidth = (e.clientX+document.body.scrollLeft)/_ZOOM-parseInt(SVG.get(o.id).attr("x"));
					  if(scaleWidth>=40){
						  SVG.get(o.id).attr({"width":scaleWidth});
					  }
				  }
				  else if(o.style.cursor=="n-resize"){
					  var scaleHeight = (e.clientY+document.body.scrollTop)/_ZOOM-parseInt(SVG.get(o.id).attr("y"));
					  if(scaleHeight>=40){
						  SVG.get(o.id).attr({"height":scaleHeight});
					  }
				  }
				  else{
					  var scaleWidth = (e.clientX+document.body.scrollLeft)/_ZOOM-parseInt(SVG.get(o.id).attr("x"));
					  var scaleHeight = (e.clientY+document.body.scrollTop)/_ZOOM-parseInt(SVG.get(o.id).attr("y"));
					  if(scaleWidth>=40){
						  SVG.get(o.id).attr({"width":scaleWidth});						  
					  }
					  if(scaleHeight>=40){
						  SVG.get(o.id).attr({"height":scaleHeight});						  
					  }
				  }
				  rectWidth = parseInt(SVG.get(o.id).attr("width"));
				  rectHeight = parseInt(SVG.get(o.id).attr("height"));
				  var text = o.getAttribute("textID");
				  g(text).setAttribute("x",parseInt(o.getAttribute("x"))+5);
				  g(text).setAttribute("y",parseInt(o.getAttribute("y"))+(rectHeight/2)+6);
				  g(text).setAttribute("dx",parseInt(o.getAttribute("x"))+(rectWidth/2));
				  setValue(g(text),dealStr(o.getAttribute("title"),rectWidth));
				  if(o.getAttribute("lineID")){
						if(o.getAttribute("shapetype")=="ju"){
							var points = parseInt(o.getAttribute("x"))+","+(parseInt(o.getAttribute("y"))+rectHeight/6)+" "+(parseInt(o.getAttribute("x"))+parseInt(o.getAttribute("width")))+","+(parseInt(o.getAttribute("y"))+rectHeight/6);
							g(o.getAttribute("lineID")).setAttribute("points",points);
						}
						else if(o.getAttribute("shapetype")=="bing"){
							var points = parseInt(o.getAttribute("x"))+","+(parseInt(o.getAttribute("y"))+parseInt(o.getAttribute("height"))-rectHeight/6)+" "+(parseInt(o.getAttribute("x"))+parseInt(o.getAttribute("width")))+","+(parseInt(o.getAttribute("y"))+parseInt(o.getAttribute("height"))-rectHeight/6);
							g(o.getAttribute("lineID")).setAttribute("points",points);
						}
						else if(o.getAttribute("shapetype")=="multi"){
							var points = parseInt(o.getAttribute("x"))+","+(parseInt(o.getAttribute("y"))+parseInt(o.getAttribute("height"))-rectHeight/6)+" "+(parseInt(o.getAttribute("x"))+parseInt(o.getAttribute("width")))+","+(parseInt(o.getAttribute("y"))+parseInt(o.getAttribute("height"))-rectHeight/6);
							g(o.getAttribute("lineID")).setAttribute("points",points);
						}
						
					}
				  if(o.getAttribute("from")){
						for(var i=0,len=lineArray1.length;i<len;i++){
							var _X = parseInt(o.getAttribute("x")),_Y = parseInt(o.getAttribute("y")),_W = parseInt(o.getAttribute("width")),_H = parseInt(o.getAttribute("height"));
							var topBoolean = (p1_1[i]>(_X+_W/4)&&p1_1[i]<(_X+_W*0.75)&&p1_2[i]<(_Y+_H/4));
							var rightBoolean = (p1_2[i]>(_Y+_H/4)&&p1_2[i]<(_Y+_H*0.75)&&p1_1[i]>(_X+_W*0.75));
							var bottomBoolean = (p1_1[i]>(_X+_W/4)&&p1_1[i]<(_X+_W*0.75)&&p1_2[i]>(_Y+_H*0.75));
							var new_points = p1_1[i]+","+p1_2[i];
							if(topBoolean){
								new_points = (_X+_W/2)+","+_Y;
							}
							else if(rightBoolean){
								new_points = (_X+_W)+","+(_Y+_H/2);
							}
							else if(bottomBoolean){
								new_points = (_X+_W/2)+","+(_Y+_H);
							}
							else{
								new_points = (_X)+","+(_Y+_H/2);
							}
							pointArray1[i][0] = new_points;							
							g(lineArray1[i]).setAttribute("points",pointArray1[i].join(" "));
							g(lineArray1[i]).removeAttribute("marker-end");
							p1_1[i] = new_points.split(",")[0];
							p1_2[i] = new_points.split(",")[1];
						}						
					}
					if(o.getAttribute("to")){
						for(var i=0,len=lineArray2.length;i<len;i++){
							var _X = parseInt(o.getAttribute("x")),_Y = parseInt(o.getAttribute("y")),_W = parseInt(o.getAttribute("width")),_H = parseInt(o.getAttribute("height"));
							var topBoolean = (p2_1[i]>(_X+_W/4)&&p2_1[i]<(_X+_W*0.75)&&p2_2[i]<(_Y+_H/4));
							var rightBoolean = (p2_2[i]>(_Y+_H/4)&&p2_2[i]<(_Y+_H*0.75)&&p2_1[i]>(_X+_W*0.75));
							var bottomBoolean = (p2_1[i]>(_X+_W/4)&&p2_1[i]<(_X+_W*0.75)&&p2_2[i]>(_Y+_H*0.75));
							var new_points = p2_1[i]+","+p2_2[i];
							if(topBoolean){
								new_points = (_X+_W/2)+","+_Y;
							}
							else if(rightBoolean){
								new_points = (_X+_W)+","+(_Y+_H/2);
							}
							else if(bottomBoolean){
								new_points = (_X+_W/2)+","+(_Y+_H);
							}
							else{
								new_points = (_X)+","+(_Y+_H/2);
							}
							pointArray2[i][pointArray2[i].length-1] = new_points;
							g(lineArray2[i]).setAttribute("points",pointArray2[i].join(" "));
							g(lineArray2[i]).removeAttribute("marker-end");
							p2_1[i] = new_points.split(",")[0];
							p2_2[i] = new_points.split(",")[1];
						}						
					}
				  if(e.stopPropagation){
						e.stopPropagation();
					}else{
						e.cancleBubble = true;
					}
			},
			stopScale:function(e){
				var e = e || window.event;
				var fromEndArray = new Array,toEndArray = new Array,linePoints;
				   removeEvent(document,"losecapture",action.stopScale);
				   removeEvent(document,"mouseup",action.stopScale);
				   removeEvent(document,"mousemove",action.moveScale);
					if(document.releaseCapture) document.releaseCapture();
					if(o.getAttribute("from")){
						var line1 = o.getAttribute("from").split(",");
						for(var i=0,len=line1.length;i<len;i++){
							var clen = SVG.get(line1[i]).attr("points").split(" ").length;
							g(line1[i]).setAttribute("marker-end","url(#"+marker.attr("id")+")");
							if(clen<=2){
								var FP = formatLine(SVG.get(SVG.get(line1[i]).attr("from")),SVG.get(SVG.get(line1[i]).attr("to")));
								if(FP["p1"]){
									SVG.get(line1[i]).attr({points:FP["p1"][0]+","+FP["p1"][1]+" "+FP["p2"][0]+","+FP["p2"][1]});									
								}
								fromEndArray[i] = SVG.get(line1[i]).attr("points");
							}
							else{
								fromEndArray[i] = SVG.get(line1[i]).attr("points");
							}
						}
						
					}
					if(o.getAttribute("to")){
						var line2 = o.getAttribute("to").split(",");
						for(var i=0,len=line2.length;i<len;i++){
							var clen = SVG.get(line2[i]).attr("points").split(" ").length;
							g(line2[i]).setAttribute("marker-end","url(#"+marker.attr("id")+")");
							if(clen<=2){
								var FP = formatLine(SVG.get(SVG.get(line2[i]).attr("from")),SVG.get(SVG.get(line2[i]).attr("to")));
								if(FP["p1"]){
									SVG.get(line2[i]).attr({points:FP["p1"][0]+","+FP["p1"][1]+" "+FP["p2"][0]+","+FP["p2"][1]});								
								}
								toEndArray[i] = SVG.get(line2[i]).attr("points");
							}
							else{
								toEndArray[i] = SVG.get(line2[i]).attr("points");
							}
						}
					}
					if(o.getAttribute("lineID")){
						linePoints = g(o.getAttribute("lineID")).getAttribute("points");
					}
					else{
						linePoints = "";
					}
					if(o.getAttribute("from")&&!o.getAttribute("to")){
						pushLog("scaleproc",{"ID":o.id,"beginLinePoints":beginLinePoints,"linePoints":linePoints,"beginFrom":fromArray,"endFrom":fromEndArray,"oldWidth":oldWidth,"oldHeight":oldHeight,"newWidth":parseInt(o.getAttribute("width")),"newHeight":parseInt(o.getAttribute("height"))});
					}
					else if(!o.getAttribute("from")&&o.getAttribute("to")){
						pushLog("scaleproc",{"ID":o.id,"beginLinePoints":beginLinePoints,"linePoints":linePoints,"beginTo":toArray,"endTo":toEndArray,"oldWidth":oldWidth,"oldHeight":oldHeight,"newWidth":parseInt(o.getAttribute("width")),"newHeight":parseInt(o.getAttribute("height"))});
					}
					else if(o.getAttribute("from")&&o.getAttribute("to")){
						pushLog("scaleproc",{"ID":o.id,"beginLinePoints":beginLinePoints,"linePoints":linePoints,"beginFrom":fromArray,"endFrom":fromEndArray,"beginTo":toArray,"endTo":toEndArray,"oldWidth":oldWidth,"oldHeight":oldHeight,"newWidth":parseInt(o.getAttribute("width")),"newHeight":parseInt(o.getAttribute("height"))});
					}
					else{
						pushLog("scaleproc",{"ID":o.id,"beginLinePoints":beginLinePoints,"linePoints":linePoints,"oldWidth":oldWidth,"oldHeight":oldHeight,"newWidth":parseInt(o.getAttribute("width")),"newHeight":parseInt(o.getAttribute("height"))});
					}
					moveflag = 1;
					if(e.stopPropagation){
						e.stopPropagation();
					}else{
						e.cancleBubble = true;
					}
			}
		};
	function init(){
		var	o = defaultOptions.moveObject;		
			o.onmousedown = function(e){
				var e = e || window.event;
				if(flag==1){
					initX = e.clientX/_ZOOM;
					initY = e.clientY/_ZOOM;
					if(o.getAttribute("cx")){
						deltaX = e.clientX - o.getAttribute("cx");
						deltaY = e.clientY - o.getAttribute("cy");
						line_points = g(o.getAttribute("lineID")).getAttribute("points");
						nPoint = getcurPoint(g(o.getAttribute("lineID")),[o.getAttribute("cx"),o.getAttribute("cy")],line_points);
						undoX = o.getAttribute("cx");
						undoY = o.getAttribute("cy");
					}else{
						deltaX = e.clientX/_ZOOM - o.getAttribute("x");
						deltaY = e.clientY/_ZOOM - o.getAttribute("y");
						undoX = o.getAttribute("x");
						undoY = o.getAttribute("y");
						if(o.getAttribute("lineID")){
							beginLinePoints = g(o.getAttribute("lineID")).getAttribute("points");
						}
						else{
							beginLinePoints = "";
						}
					}
					if(o.getAttribute("from") && o.getAttribute("from")!=""){
						lineArray1 = o.getAttribute("from").split(",");
						for(var i=0,len=lineArray1.length;i<len;i++){
							pointArray1[i] = g(lineArray1[i]).getAttribute("points").split(" ");
							fromArray[i] = g(lineArray1[i]).getAttribute("points");
							var np = pointArray1[i][0].split(",");
							p1_1[i] = parseInt(np[0]);
							p1_2[i] = parseInt(np[1]);
						}
					}
					if(o.getAttribute("to") && o.getAttribute("to")!=""){
						lineArray2 = o.getAttribute("to").split(",");
						for(var i=0,len=lineArray2.length;i<len;i++){
							pointArray2[i] = g(lineArray2[i]).getAttribute("points").split(" ");
							toArray[i] = g(lineArray2[i]).getAttribute("points");
							var np = pointArray2[i][pointArray2[i].length-1].split(",");
							p2_1[i] = parseInt(np[0]);
							p2_2[i] = parseInt(np[1]);
						}
					}			
					if(document.setCapture) o.setCapture();
					if(moveflag){
						addEvent(document,"mousemove",action.move);
						addEvent(document,"mouseup",action.stop);
						addEvent(document,"losecapture",action.stop);				
					}
					else if(!moveflag&&o.nodeName=="rect"){
						oldWidth = parseInt(o.getAttribute("width"));
						oldHeight = parseInt(o.getAttribute("height"));
						addEvent(document,"mousemove",action.moveScale);
						addEvent(document,"mouseup",action.stopScale);
						addEvent(document,"losecapture",action.stopScale);
					}
				}
				
				if(e.preventDefault){
					e.preventDefault();
				}else{
					return false;	
				}
			};
			if(g(o.getAttribute("textID"))){
				g(o.getAttribute("textID")).onmousedown = o.onmousedown;				
			}
			if(o.nodeName=="ellipse" && g(o.getAttribute("lineID"))){
				var e = e || window.event;
				if(flag==1){
					initX = e.clientX/_ZOOM;
					initY = e.clientY/_ZOOM;
					if(o.getAttribute("cx")){
						deltaX = e.clientX/_ZOOM - o.getAttribute("cx");
						deltaY = e.clientY/_ZOOM - o.getAttribute("cy");
						line_points = g(o.getAttribute("lineID")).getAttribute("points");
						nPoint = getcurPoint(g(o.getAttribute("lineID")),[Number(o.getAttribute("cx"))+6,Number(o.getAttribute("cy"))+6],line_points);
						undoX = Number(o.getAttribute("cx"))+6;
						undoY = Number(o.getAttribute("cy"))+6;
					}else{
						deltaX = e.clientX/_ZOOM - o.getAttribute("x");
						deltaY = e.clientY/_ZOOM - o.getAttribute("y");
						undoX = o.getAttribute("x");
						undoY = o.getAttribute("y");
						if(o.getAttribute("lineID")){
							beginLinePoints = g(o.getAttribute("lineID")).getAttribute("points");
						}
						else{
							beginLinePoints = "";
						}
					}
					if(document.setCapture) o.setCapture();
					if(moveflag){
						addEvent(document,"mousemove",action.move);
						addEvent(document,"mouseup",action.stop);
						addEvent(document,"losecapture",action.stop);				
					}
				}
			}
	};
	return init();
}