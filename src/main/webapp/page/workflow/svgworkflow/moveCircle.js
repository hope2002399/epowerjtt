/*
 * 菱形和圆形移动JS文件
 */

function moveCircle(o){
	var defaultOptions = {
			moveObject:o
		},
		deltaX = 0, deltaY = 0, initX = 0, initY = 0, pointArray1 = new Array,pointArray2 = new Array,p1_1=new Array,p1_2=new Array,ismove=0,
		p2_1=new Array,p2_2=new Array,undoX,undoY,redoX,redoY,lineArray1=new Array,lineArray2=new Array,fromArray = new Array,toArray = new Array,
		action = {
			move:function(e){
				var e = e || window.event,
					MouseX = e.clientX/_ZOOM,
					MouseY = e.clientY/_ZOOM,
					o = defaultOptions.moveObject;
					
				var text = o.getAttribute("textID");
				
				if(o.getAttribute("cx") && o.getAttribute("type")){
					o.setAttribute("cx",MouseX-deltaX);
					o.setAttribute("cy",MouseY-deltaY);
					redoX = o.getAttribute("cx");
					redoY = o.getAttribute("cy");
					g(text).setAttribute("x",parseInt(o.getAttribute("cx")));
					g(text).setAttribute("y",parseInt(o.getAttribute("cy"))+3);
					g(text).setAttribute("dx",parseInt(o.getAttribute("cx")));	
				}
				if(o.nodeName=="polygon"){
					var pp = drawPolygon([MouseX-deltaX,MouseY-deltaY]);
					o.setAttribute("points",pp);
					o.setAttribute("getX",MouseX-deltaX);
					o.setAttribute("getY",MouseY-deltaY);
					redoX = o.getAttribute("getX");
					redoY = o.getAttribute("getY");
					g(text).setAttribute("x",parseInt(o.getAttribute("getX")));
					g(text).setAttribute("y",parseInt(o.getAttribute("getY"))+6);				
					g(text).setAttribute("dx",parseInt(o.getAttribute("getX")));	
				}
				
				if(o.getAttribute("from")){
					for(var i=0,len=lineArray1.length;i<len;i++){
						pointArray1[i][0] = (p1_1[i] + MouseX-initX) +","+ (p1_2[i] + MouseY-initY);
						g(lineArray1[i]).setAttribute("points",pointArray1[i].join(" "));//固定节点变化线
						g(lineArray1[i]).removeAttribute("marker-end");
					}
					
				}
				if(o.getAttribute("to")){
					for(var i=0,len=lineArray2.length;i<len;i++){
						pointArray2[i][pointArray2[i].length-1] = (p2_1[i] + MouseX-initX) +","+ (p2_2[i] + MouseY-initY);
						g(lineArray2[i]).setAttribute("points",pointArray2[i].join(" "));
						g(lineArray2[i]).removeAttribute("marker-end");
					}
					
				}
				ismove = 1;
				if(e.stopPropagation){
					e.stopPropagation();
				}else{
					e.cancleBubble = true;
				}
			},
			stop:function(e){
				var e = e || window.event;
				var fromEndArray = new Array,toEndArray = new Array;
				removeEvent(document,"losecapture",action.stop);
				removeEvent(document,"mouseup",action.stop);
				removeEvent(document,"mousemove",action.move);
				if(document.releaseCapture) document.releaseCapture();
				if(ismove){
					if(o.nodeName=="polygon" || o.nodeName=="ellipse"){
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
								if(clen<=2){
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
						if(o.getAttribute("from")&&!o.getAttribute("to")){
							pushLog("moveproc",{"ID":o.id,"beginX":undoX,"beginY":undoY,"endX":redoX,"endY":redoY,"beginFrom":fromArray,"endFrom":fromEndArray});
						}
						else if(!o.getAttribute("from")&&o.getAttribute("to")){
							pushLog("moveproc",{"ID":o.id,"beginX":undoX,"beginY":undoY,"endX":redoX,"endY":redoY,"beginTo":toArray,"endTo":toEndArray});
						}
						else if(o.getAttribute("from")&&o.getAttribute("to")){
							pushLog("moveproc",{"ID":o.id,"beginX":undoX,"beginY":undoY,"endX":redoX,"endY":redoY,"beginFrom":fromArray,"endFrom":fromEndArray,"beginTo":toArray,"endTo":toEndArray});
						}
						else{
							pushLog("moveproc",{"ID":o.id,"beginX":undoX,"beginY":undoY,"endX":redoX,"endY":redoY});
						}
					}					
				}
				ismove = 0;
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
			if(flag==1){//flag 是全局变量
				var e = e || window.event;
				initX = e.clientX/_ZOOM;
				initY = e.clientY/_ZOOM;
				if(o.getAttribute("cx") && o.getAttribute("type")){
					deltaX = e.clientX/_ZOOM - o.getAttribute("cx");
					deltaY = e.clientY/_ZOOM - o.getAttribute("cy");
					undoX = o.getAttribute("cx");
					undoY = o.getAttribute("cy");
				}
				if(o.nodeName=="polygon"){
					deltaX = e.clientX/_ZOOM - o.getAttribute("getX");
					deltaY = e.clientY/_ZOOM - o.getAttribute("getY");
					undoX = o.getAttribute("getX");
					undoY = o.getAttribute("getY");
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
				addEvent(document,"mousemove",action.move);
				addEvent(document,"mouseup",action.stop);
				addEvent(document,"losecapture",action.stop);
			}
			if(e.preventDefault){
				e.preventDefault();
			}else{
				return false;	
			}
		};
		g(o.getAttribute("textID")).onmousedown = o.onmousedown;
	};
	return init();
}