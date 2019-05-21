/*
 * 线条移动JS文件
 */

function addPointMove(o){
	var defaultOptions = {
			moveObject:o
		},
		deltaX = 0, deltaY = 0, initX = 0, initY = 0,MouseX = 0,MouseY = 0,
		nPoint,points,isMove=0,addFlag,
		action = {
			move:function(e){
				MouseX = (e.clientX+document.body.scrollLeft)/_ZOOM;
				MouseY = (e.clientY+document.body.scrollTop)/_ZOOM;
				var e = e || window.event,
					o = defaultOptions.moveObject;
				if(Math.abs(MouseX-initX)>5 || Math.abs(MouseY-initY)>5){
					if(addFlag){
						points = o.getAttribute("points");
						var newPoints = addPolylinePoint(o,[initX,initY]);
						nPoint = getcurPoint(o,[initX,initY],newPoints);
						addFlag = false;
					}
					changePolylinePoint(o,[MouseX-deltaX,MouseY-deltaY],nPoint,points);				
					if(nPoint){
						isMove=1;
					}					
				}		
				if(e.stopPropagation){
					e.stopPropagation();
				}else{
					e.cancleBubble = true;
				}
			},
			stop:function(e){
				var e = e || window.event;
				removeEvent(document,"losecapture",action.stop);
				removeEvent(document,"mouseup",action.stop);
				removeEvent(document,"mousemove",action.move);
				if(document.releaseCapture) document.releaseCapture();
				
				if(isMove){
					//var circle = gCircle.circle(8).cx(e.clientX+document.body.scrollLeft).cy(e.clientY+document.body.scrollTop).stroke({color:"#000"}).fill("#fff").attr({"lineID":o.getAttribute("id")});
					pushLog("moveproc",{"ID":o.id,"beginX":MouseX-deltaX,"beginY":MouseY-deltaY,"nPoint":nPoint,"type":"add"});
					/*if(o.getAttribute("cricleID")){
						var cricleID = o.getAttribute("cricleID");
						o.setAttribute("cricleID",cricleID+","+circle.attr("id"));
					}else{
						o.setAttribute("cricleID",circle.attr("id"));
					}*/
					o.setAttribute("marker-end","url(#"+markerGreen.attr("id")+")");						
				}
				isMove=0;
				if(e.stopPropagation){
					e.stopPropagation();
				}else{
					e.cancleBubble = true;
				}
			}	
		};
	function init(){
		var	o = defaultOptions.moveObject;	
		//addEvent(o,"mousedown",function(e){
		o.onmousedown = function(e){
			var e = e || window.event;
			if(flag==1){//flag 是全局变量
				initX = (e.clientX+document.body.scrollLeft)/_ZOOM;
				initY = (e.clientY+document.body.scrollTop)/_ZOOM;
				if(deleteP(o,[initX,initY])){
					addFlag = true;
					if(document.setCapture) o.setCapture();
					addEvent(document,"mousemove",action.move);
					addEvent(document,"mouseup",action.stop);
					addEvent(document,"losecapture",action.stop);
				}
				else{
					drag(g(o.getAttribute("cricleID")));
				}
			}
			if(e.preventDefault){
				e.preventDefault();
			}else{
				return false;	
			}
			
		};
	};
	return init();
}