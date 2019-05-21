/*
 * 恢复上一次操作与撤销上一次恢复动作js文件
 */

var _DOLOG=[];
var _DOLOGINDEX=-1;

function pushLog(act,obj) {
	var newLog=_DOLOG.slice(0,_DOLOGINDEX+1);
	_DOLOG=newLog;
	_DOLOGINDEX=_DOLOG.push({
		"act":act,"val":obj
	})-1;
}
function getLog() {
	return _DOLOG[_DOLOGINDEX];
}
function undoLog() {
	if(_DOLOGINDEX==-1) {
		alert("没有操作记录可以撤消.");
		return ;
	}
	if(doLog("undo")) {
		_DOLOGINDEX--;
	}
}
function redoLog() {
	if(_DOLOGINDEX==_DOLOG.length-1) {
		alert("没有操作记录可以恢复.");
		return ;
	}
	_DOLOGINDEX++;
	doLog("redo");
}

function doLog(act) {
	var log=getLog();
	switch(log.act) {
		case "addproc":
		act=="undo"?delPro(log.val.ID):addPro(log.val);
		break;
		case "delproc":
		act=="undo"?addPro(log.val):delPro(log.val.ID);
		break;
		case "moveproc":
		act=="undo"?movePro(log.val,'undo'):movePro(log.val,'redo');
		break;
		case "editproc":
		act=="undo"?editPro(log.val,'undo'):editPro(log.val,'redo');
		break;
		case "delCircle":
		act=="undo"?delCircle(log.val,'undo'):delCircle(log.val,'redo');
		break;
		case "scaleproc":
		act=="undo"?scalePro(log.val,'undo'):scalePro(log.val,'redo');
		break;
		default:break;
	}
	return true;
}
  function addPro(obj){
	  switch(obj.shapetype){
		case "roundrect":
				var rect = gShape.rect(obj.width,obj.height).attr({rx:2,ry:2,id:obj.ID,"filter":"url(#filter)","shapetype":obj.shapetype,"flowphase":obj.flowphase,"nodedesc":obj.nodedesc, "nodetype":obj.nodetype, "opttype":obj.opttype, "optcode":obj.optcode, "optbean":obj.optbean, "optparam":obj.optparam, "subwfcode":obj.subwfcode, "roletype":obj.roletype, "rolecode":obj.rolecode, "isaccounttime":obj.isaccounttime, "timeLimitType":obj.timeLimitType,"inheritType":obj.inheritType,"inheritNodeCode":obj.inheritNodeCode,"timelimit":obj.timelimit,"isTrunkLine":obj.isTrunkLine, "unitexp":obj.unitexp, "powerexp":obj.powerexp, "expireopt":obj.expireopt, "desc":obj.desc,"width":obj.width,"height":obj.height}).stroke({color:"#0000ff",width:1.3}).fill("#fff").x(obj.X).y(obj.Y);
				var text = gText.text(obj.title).x(rect.x()+5).y(rect.y()+(rectHeight/2)+6).attr({id:obj.textID,dx:rect.x()+(rectWidth/2),"title":obj.title,"textWeight":"9pt", "strokeWeight":"1", "zIndex":"1","shapeID":obj.ID}).font({family:"Arial",size:14,"text-anchor":"middle"}).fill("#00f");
				rect.attr({"textID":obj.textID,"title":obj.title});
			break;
		case "R":
			var rect = gShape.rect(obj.width,obj.height).attr({rx:10,ry:10,id:obj.ID,"filter":"url(#filter)","shapetype":obj.shapetype,"flowphase":obj.flowphase,"nodedesc":obj.nodedesc, "nodetype":obj.nodetype, "opttype":obj.opttype, "optcode":obj.optcode, "optbean":obj.optbean, "optparam":obj.optparam, "subwfcode":obj.subwfcode, "roletype":obj.roletype, "rolecode":obj.rolecode, "isaccounttime":obj.isaccounttime, "timeLimitType":obj.timeLimitType,"inheritType":obj.inheritType,"inheritNodeCode":obj.inheritNodeCode,"timelimit":obj.timelimit,"isTrunkLine":obj.isTrunkLine, "unitexp":obj.unitexp, "powerexp":obj.powerexp, "expireopt":obj.expireopt, "desc":obj.desc,"width":obj.width,"height":obj.height}).stroke({color:"#0000ff",width:1.3}).fill("skyblue").x(obj.X).y(obj.Y);
			var text = gText.text(obj.title).x(rect.x()+5).y(rect.y()+(rectHeight/2)+6).attr({id:obj.textID,dx:rect.x()+(rectWidth/2),"title":obj.title,"textWeight":"9pt", "strokeWeight":"1", "zIndex":"1","shapeID":obj.ID}).font({family:"Arial",size:14,"text-anchor":"middle"}).fill("#00f");
			rect.attr({"textID":obj.textID,"title":obj.title});
		break;	
		case "multi":
			var rect = gShape.rect(obj.width,obj.height).attr({rx:2,ry:2,id:obj.ID,"filter":"url(#filter)","shapetype":obj.shapetype,"flowphase":obj.flowphase,"nodedesc":obj.nodedesc, "nodetype":obj.nodetype, "opttype":obj.opttype, "optcode":obj.optcode, "optbean":obj.optbean, "optparam":obj.optparam, "subwfcode":obj.subwfcode, "roletype":obj.roletype, "rolecode":obj.rolecode, "isaccounttime":obj.isaccounttime, "timeLimitType":obj.timeLimitType,"inheritType":obj.inheritType,"inheritNodeCode":obj.inheritNodeCode, "timelimit":obj.timelimit,"isTrunkLine":obj.isTrunkLine, "unitexp":obj.unitexp, "powerexp":obj.powerexp, "expireopt":obj.expireopt, "desc":obj.desc,"lineID":obj.lineID,"width":obj.width,"height":obj.height}).stroke({color:"#0000ff",width:1.3}).fill("#fff").x(obj.X).y(obj.Y);
			var text = gText.text(obj.title).x(rect.x()+5).y(rect.y()+(rectHeight/2)+6).attr({id:obj.textID,dx:rect.x()+(rectWidth/2),"title":obj.title,"textWeight":"9pt", "strokeWeight":"1", "zIndex":"1","shapeID":obj.ID}).font({family:"Arial",size:14,"text-anchor":"middle"}).fill("#00f");
			rect.attr({"textID":obj.textID,"title":obj.title});
			var bingLine = gInnerLine.polyline().stroke({ color:"#0000ff",width: 1.3 }).fill("none")
            .attr({"points":obj.linePoints,
            	    'transform':"",
            	    'stroke-dasharray':4,
            	    "shapetype":"PolyLine",
            	    "id":obj.lineID});
		break;
		case "ju":case "bing":
			var rect = gShape.rect(obj.width,obj.height).attr({rx:2,ry:2,id:obj.ID,"filter":"url(#filter)","shapetype":obj.shapetype,"flowphase":obj.flowphase,"nodedesc":obj.nodedesc, "nodetype":obj.nodetype, "opttype":obj.opttype, "optcode":obj.optcode, "optbean":obj.optbean, "optparam":obj.optparam, "subwfcode":obj.subwfcode, "roletype":obj.roletype, "rolecode":obj.rolecode, "isaccounttime":obj.isaccounttime, "timeLimitType":obj.timeLimitType,"inheritType":obj.inheritType,"inheritNodeCode":obj.inheritNodeCode, "timelimit":obj.timelimit,"isTrunkLine":obj.isTrunkLine, "unitexp":obj.unitexp, "powerexp":obj.powerexp, "expireopt":obj.expireopt, "desc":obj.desc,"lineID":obj.lineID,"width":obj.width,"height":obj.height}).stroke({color:"#0000ff",width:1.3}).fill("#fff").x(obj.X).y(obj.Y);
			var text = gText.text(obj.title).x(rect.x()+5).y(rect.y()+(rectHeight/2)+6).attr({id:obj.textID,dx:rect.x()+(rectWidth/2),"title":obj.title,"textWeight":"9pt", "strokeWeight":"1", "zIndex":"1","shapeID":obj.ID}).font({family:"Arial",size:14,"text-anchor":"middle"}).fill("#00f");
			rect.attr({"textID":obj.textID,"title":obj.title});
			var bingLine = gInnerLine.polyline().stroke({ color:"#0000ff",width: 1.3 }).fill("none")
            .attr({"points":obj.linePoints,
            	    'transform':"",
            	    "shapetype":"PolyLine",
            	    "id":obj.lineID});
		break;
		case "diamond":
			var polygon = gShape.polygon(drawPolygon([parseInt(obj.getX),parseInt(obj.getY)])).attr({'transform':"",id:obj.ID,"filter":"url(#filter)","shapetype":obj.shapetype,"flowphase":obj.flowphase,"nodedesc":obj.nodedesc, "nodetype":obj.nodetype, "opttype":obj.opttype, "optcode":obj.optcode, "optbean":obj.optbean, "optparam":obj.optparam, "subwfcode":obj.subwfcode, "roletype":obj.roletype, "rolecode":obj.rolecode, "isaccounttime":obj.isaccounttime, "timeLimitType":obj.timeLimitType,"inheritType":obj.inheritType,"inheritNodeCode":obj.inheritNodeCode, "timelimit":obj.timelimit,"isTrunkLine":obj.isTrunkLine, "unitexp":obj.unitexp, "powerexp":obj.powerexp, "expireopt":obj.expireopt, "desc":obj.desc,"getX":obj.getX,"getY":obj.getY,"width":obj.width,"height":obj.height}).stroke({color:"#0000ff",width:1.3}).fill("#fff");
			var text = gText.text(obj.title).x(parseInt(obj.getX)-obj.width/2).y(parseInt(obj.getY)+6).attr({id:obj.textID,dx:obj.getX,"title":obj.title,"textWeight":"9pt", "strokeWeight":"1", "zIndex":"1","shapeID":obj.ID}).font({family:"Arial",size:14,"text-anchor":"middle"}).fill("#00f");
			polygon.attr({"textID":obj.textID,"title":obj.title});
		break;
		case "polyline":
			   var line = gLine.polyline().stroke({ color:"#0000ff",width: 1.3 }).fill("none")
			              .attr({'transform':"","id":obj.ID,
			            	     "points":obj.points,
			            	     "marker-end":"url(#"+marker.attr("id")+")",
			            	     "title":obj.title,"cond":obj.cond,"desc":obj.desc,"timeLimit":obj.timeLimit,
			            	     "timeLimitType":obj.timeLimitType,"shapetype":"polyline",
			            	     "inheritType":obj.inheritType,"inheritNodeCode":obj.inheritNodeCode,
			            	     "from":obj.from,"to":obj.to,
			            	     "ladID":obj.ID});
			   if(SVG.get(obj.from).attr("from")){
					SVG.get(obj.from).attr({"from":SVG.get(obj.from).attr("from")+','+obj.ID});
				}else{
					SVG.get(obj.from).attr({"from":obj.ID});
				}
				if(SVG.get(obj.to).attr("to")){
					SVG.get(obj.to).attr({"to":SVG.get(obj.to).attr("to")+','+obj.ID});
				}else{
					SVG.get(obj.to).attr({"to":obj.ID});
				}
			   g("lineCon").innerHTML+=("<div class='step' style='left:"+obj.left+"px;top:"+obj.top+"px;' id='"+obj.labID+"'>"+obj.title+"</div>");
			   break;
			   default:break;
     }
  }
  
  function delPro(id){
	  if(!id){ return false; }
		else{ var pro = g(id); }
		if(pro){
			switch(pro.nodeName){
				case "rect":
						SVG.get(id).remove();
						if(pro.getAttribute("lineID")){
							SVG.get(pro.getAttribute("lineID")).remove();
						}
						SVG.get(pro.getAttribute("textID")).remove();						
					break;
					
				case "polygon":
						SVG.get(id).remove();
						SVG.get(pro.getAttribute("textID")).remove();
					break;
				
				case "polyline":
					var fromPro = g( pro.getAttribute("from") ),
						toPro = g( pro.getAttribute("to") ),
						lenFrom = fromPro.getAttribute("from").split(","),
						lenTo = toPro.getAttribute("to").split(","),
						fromArray = new Array,toArray = new Array;					
					for(var i=0,len=lenFrom.length;i<len;i++){
						if( lenFrom[i]!=id ){
							fromArray.push(lenFrom[i]);
						}
					}
					fromPro.setAttribute("from",fromArray.join(","));
					
					for(var i=0,len=lenTo.length;i<len;i++){
						if( lenTo[i]!=id ){
							toArray.push(lenTo[i]);
						}
					}
					toPro.setAttribute("to",toArray.join(","));
					SVG.get(id).remove();
					g("lineCon").removeChild(g("lab"+id));
					break;				
				default:break;
			}
			g("ispro").style.display = "none";
			g("isline").style.display = "none";
		}
  }
  
  function movePro(obj,act){
	  if(!obj.ID){ return false; }
		else{ var pro = g(obj.ID); }
	  if(pro){
		  switch(pro.nodeName){
		  case "polyline":
			  if(act=="undo"){
				  if(obj.type=="change"){
					  dragPolylinePoint(pro,[obj.beginX,obj.beginY],obj.nPoint,obj.linePoints);					 
					  if(pro.getAttribute("marker-end")&& pro.getAttribute("marker-end").indexOf("s10")>0){
                    	  pro.setAttribute("marker-end","url(#"+markerGreenElse.attr("id")+")");                   	  
                      }else{
                    	  pro.setAttribute("marker-end","url(#"+markerGreen.attr("id")+")");
                      }
					  if($.browser.mozilla && $.browser.version=="11.0"){
						  pro.removeAttribute("marker-end");						  
					  }
				  }
				  else if(obj.type=="add"){
					  deletePoint(pro,obj.nPoint);
					  if(pro.getAttribute("marker-end")&& pro.getAttribute("marker-end").indexOf("s10")>0){
                    	  pro.setAttribute("marker-end","url(#"+markerGreenElse.attr("id")+")");                   	  
                      }else{
                    	  pro.setAttribute("marker-end","url(#"+markerGreen.attr("id")+")");
                      }
				  }
				  else{
					  changePolylinePoint(pro,[obj.beginX,obj.beginY],obj.nPoint,pro.getAttribute("points"));
					  if(pro.getAttribute("marker-end")&& pro.getAttribute("marker-end").indexOf("s10")>0){
                    	  pro.setAttribute("marker-end","url(#"+markerGreenElse.attr("id")+")");                   	  
                      }else{
                    	  pro.setAttribute("marker-end","url(#"+markerGreen.attr("id")+")");
                      }
				  }
				  //SVG.get(obj.circleID).remove();  
			  
			  }
			  else{
				  /*changePolylinePoint(pro,[obj.toX,obj.toY],obj.nPoint,pro.getAttribute("points"));
				  var circle = gCircle.circle(8).cx(obj.toX).cy(obj.toY).stroke({color:"#f00"}).fill("#f00").attr({"lineID":obj.ID,"id":obj.circleID});
				  if(pro.getAttribute("cricleID")){
						var cricleID = pro.getAttribute("cricleID");
						pro.setAttribute("cricleID",cricleID+","+circle.attr("id"));
					}else{
						pro.setAttribute("cricleID",circle.attr("id"));
					}*/
				  if(obj.type=="change"){
					  dragPolylinePoint(pro,[obj.endX,obj.endY],obj.nPoint,obj.linePoints);	  
					  if(pro.getAttribute("marker-end")&& pro.getAttribute("marker-end").indexOf("s10")>0){
                    	  pro.setAttribute("marker-end","url(#"+markerGreenElse.attr("id")+")");                   	  
                      }else{
                    	  pro.setAttribute("marker-end","url(#"+markerGreen.attr("id")+")");
                      }
					  if($.browser.mozilla && $.browser.version=="11.0"){
						  pro.removeAttribute("marker-end");						  
					  }
				  }
				  else if(obj.type=="add"){
					  changePolylinePoint(pro,[obj.beginX,obj.beginY],obj.nPoint,pro.getAttribute("points"));
					  if(pro.getAttribute("marker-end")&& pro.getAttribute("marker-end").indexOf("s10")>0){
                    	  pro.setAttribute("marker-end","url(#"+markerGreenElse.attr("id")+")");                   	  
                      }else{
                    	  pro.setAttribute("marker-end","url(#"+markerGreen.attr("id")+")");
                      }
				  }
				  else{
					  deletePoint(pro,obj.nPoint);
					  if(pro.getAttribute("marker-end")&& pro.getAttribute("marker-end").indexOf("s10")>0){
                    	  pro.setAttribute("marker-end","url(#"+markerGreenElse.attr("id")+")");                   	  
                      }else{
                    	  pro.setAttribute("marker-end","url(#"+markerGreen.attr("id")+")");
                      }
				  }
			  }
			  break;
		  case "polygon":
			  var text = pro.getAttribute("textID");
			  if(act=="undo"){
				  var pp = drawPolygon([parseInt(obj.beginX),parseInt(obj.beginY)]);				  
				  pro.setAttribute("points",pp);
				  pro.setAttribute("getX",obj.beginX);
				  pro.setAttribute("getY",obj.beginY);
				  g(text).setAttribute("x",parseInt(pro.getAttribute("getX")));
				  g(text).setAttribute("y",parseInt(pro.getAttribute("getY"))+6);				
				  g(text).setAttribute("dx",parseInt(pro.getAttribute("getX")));
				  if(pro.getAttribute("to")){
					  var line2 = pro.getAttribute("to").split(",");
					  for(var i=0,len=line2.length;i<len;i++){
						  SVG.get(line2[i]).attr({points:(obj.beginTo)[i]});
						  if(g(line2[i]).getAttribute("marker-end")&& g(line2[i]).getAttribute("marker-end").indexOf("s7")>0){
							  g(line2[i]).setAttribute("marker-end","url(#"+markerBlue.attr("id")+")");							  
						  }
						  else{
							  g(line2[i]).setAttribute("marker-end","url(#"+marker.attr("id")+")");							   
						  }
					  }
				  }
				  if(pro.getAttribute("from")){
					  var line1 = pro.getAttribute("from").split(",");
					  for(var i=0,len=line1.length;i<len;i++){
						  SVG.get(line1[i]).attr({points:(obj.beginFrom)[i]});
						  if(g(line1[i]).getAttribute("marker-end") && g(line1[i]).getAttribute("marker-end").indexOf("s7")>0){
							  g(line1[i]).setAttribute("marker-end","url(#"+markerBlue.attr("id")+")");							  
						  }
						  else{
							  g(line1[i]).setAttribute("marker-end","url(#"+marker.attr("id")+")");							   
						  }
					  }
				  }
			  }
			  else{
				  var pp = drawPolygon([parseInt(obj.endX),parseInt(obj.endY)]);
				  pro.setAttribute("points",pp);
				  pro.setAttribute("getX",obj.endX);
				  pro.setAttribute("getY",obj.endY);
				  g(text).setAttribute("x",parseInt(pro.getAttribute("getX")));
				  g(text).setAttribute("y",parseInt(pro.getAttribute("getY"))+6);				
				  g(text).setAttribute("dx",parseInt(pro.getAttribute("getX")));
				  if(pro.getAttribute("to")){
					  var line2 = pro.getAttribute("to").split(",");
					  for(var i=0,len=line2.length;i<len;i++){
						  SVG.get(line2[i]).attr({points:(obj.endTo)[i]});
						  if(g(line2[i]).getAttribute("marker-end") && g(line2[i]).getAttribute("marker-end").indexOf("s7")>0){
							  g(line2[i]).setAttribute("marker-end","url(#"+markerBlue.attr("id")+")");							  
						  }
						  else{
							  g(line2[i]).setAttribute("marker-end","url(#"+marker.attr("id")+")");							   
						  }
					  }
				  }
				  if(pro.getAttribute("from")){
					  var line1 = pro.getAttribute("from").split(",");
					  for(var i=0,len=line1.length;i<len;i++){
						  SVG.get(line1[i]).attr({points:(obj.endFrom)[i]});
						  if(g(line1[i]).getAttribute("marker-end") && g(line1[i]).getAttribute("marker-end").indexOf("s7")>0){
							  g(line1[i]).setAttribute("marker-end","url(#"+markerBlue.attr("id")+")");							  
						  }
						  else{
							  g(line1[i]).setAttribute("marker-end","url(#"+marker.attr("id")+")");							   
						  }
					  }
				  }
			  }
			  break;
		  case "ellipse":
			  var text = pro.getAttribute("textID");
			  if(act=="undo"){
				  pro.setAttribute("cx",obj.beginX);
				  pro.setAttribute("cy",obj.beginY);
				  /*if(pro.getAttribute("lineID")){
					  g(pro.getAttribute("lineID")).setAttribute("points",obj.beginLinePoints);
				  }*/
				  //else{					  
					  g(text).setAttribute("x",parseInt(pro.getAttribute("cx")));
					  g(text).setAttribute("y",parseInt(pro.getAttribute("cy"))+3);
					  g(text).setAttribute("dx",parseInt(pro.getAttribute("cx")));
					  if(pro.getAttribute("to")){
						  var line2 = pro.getAttribute("to").split(",");
						  for(var i=0,len=line2.length;i<len;i++){
							  SVG.get(line2[i]).attr({points:(obj.beginTo)[i]});
							  if(g(line2[i]).getAttribute("marker-end") && g(line2[i]).getAttribute("marker-end").indexOf("s7")>0){
								  g(line2[i]).setAttribute("marker-end","url(#"+markerBlue.attr("id")+")");							  
							  }
							  else{
								  g(line2[i]).setAttribute("marker-end","url(#"+marker.attr("id")+")");							   
							  }
						  }
					  }
					  if(pro.getAttribute("from")){
						  var line1 = pro.getAttribute("from").split(",");
						  for(var i=0,len=line1.length;i<len;i++){
							  SVG.get(line1[i]).attr({points:(obj.beginFrom)[i]});
							  if(g(line1[i]).getAttribute("marker-end") && g(line1[i]).getAttribute("marker-end").indexOf("s7")>0){
								  g(line1[i]).setAttribute("marker-end","url(#"+markerBlue.attr("id")+")");							  
							  }
							  else{
								  g(line1[i]).setAttribute("marker-end","url(#"+marker.attr("id")+")");							   
							  }
						  }
					  } 
				  //}				 
			  }
			  else{
					pro.setAttribute("cx",obj.endX);
				    pro.setAttribute("cy",obj.endY);
				  /*if(pro.getAttribute("lineID")){
					  g(pro.getAttribute("lineID")).setAttribute("points",obj.linePoints);
				  }*/
				  //else{
					  g(text).setAttribute("x",parseInt(pro.getAttribute("cx")));
					  g(text).setAttribute("y",parseInt(pro.getAttribute("cy"))+3);
					  g(text).setAttribute("dx",parseInt(pro.getAttribute("cx")));
					  if(pro.getAttribute("to")){
						  var line2 = pro.getAttribute("to").split(",");
						  for(var i=0,len=line2.length;i<len;i++){
							  SVG.get(line2[i]).attr({points:(obj.endTo)[i]});
							  if(g(line2[i]).getAttribute("marker-end") && g(line2[i]).getAttribute("marker-end").indexOf("s7")>0){
								  g(line2[i]).setAttribute("marker-end","url(#"+markerBlue.attr("id")+")");							  
							  }
							  else{
								  g(line2[i]).setAttribute("marker-end","url(#"+marker.attr("id")+")");							   
							  }
						  }
					  }
					  if(pro.getAttribute("from")){
						  var line1 = pro.getAttribute("from").split(",");
						  for(var i=0,len=line1.length;i<len;i++){
							  SVG.get(line1[i]).attr({points:(obj.endFrom)[i]});
							  if(g(line1[i]).getAttribute("marker-end") && g(line1[i]).getAttribute("marker-end").indexOf("s7")>0){
								  g(line1[i]).setAttribute("marker-end","url(#"+markerBlue.attr("id")+")");							  
							  }
							  else{
								  g(line1[i]).setAttribute("marker-end","url(#"+marker.attr("id")+")");							   
							  }
						  }
					  }  
				  //}				  
			  }
			  break;
		  case "rect":
			  var text = pro.getAttribute("textID");
			  var proWidth = parseInt(pro.getAttribute("width"));
			  var proHeight = parseInt(pro.getAttribute("height"));
			  if(act=="undo"){				  
				  pro.setAttribute("x",obj.beginX);
				  pro.setAttribute("y",obj.beginY);
				  g(text).setAttribute("x",parseInt(pro.getAttribute("x"))+5);
				  g(text).setAttribute("y",parseInt(pro.getAttribute("y"))+(proHeight/2)+6);
				  g(text).setAttribute("dx",parseInt(pro.getAttribute("x"))+(proWidth/2));
				  if(pro.getAttribute("lineID")){
					  g(pro.getAttribute("lineID")).setAttribute("points",obj.beginLinePoints);
				  }
				  if(pro.getAttribute("to")){
					  var line2 = pro.getAttribute("to").split(",");
					  for(var i=0,len=line2.length;i<len;i++){
						  g(line2[i]).setAttribute("points",(obj.beginTo)[i]);
						  if(g(line2[i]).getAttribute("marker-end") && g(line2[i]).getAttribute("marker-end").indexOf("s7")>0){
							  g(line2[i]).setAttribute("marker-end","url(#"+markerBlue.attr("id")+")");							  
						  }
						  else{
							  g(line2[i]).setAttribute("marker-end","url(#"+marker.attr("id")+")");							   
						  }
					  }
				  }
				  if(pro.getAttribute("from")){
					  var line1 = pro.getAttribute("from").split(",");
					  for(var i=0,len=line1.length;i<len;i++){
						  g(line1[i]).setAttribute("points",(obj.beginFrom)[i]);
						  if(g(line1[i]).getAttribute("marker-end") && g(line1[i]).getAttribute("marker-end").indexOf("s7")>0){
							  g(line1[i]).setAttribute("marker-end","url(#"+markerBlue.attr("id")+")");							  
						  }
						  else{
							  g(line1[i]).setAttribute("marker-end","url(#"+marker.attr("id")+")");							   
						  }
					  }
				  }

			  }
			  else{
				  pro.setAttribute("x",obj.endX);
				  pro.setAttribute("y",obj.endY);
				  g(text).setAttribute("x",parseInt(pro.getAttribute("x"))+5);
				  g(text).setAttribute("y",parseInt(pro.getAttribute("y"))+(proHeight/2)+6);
				  g(text).setAttribute("dx",parseInt(pro.getAttribute("x"))+(proWidth/2));
				  if(pro.getAttribute("lineID")){
					  g(pro.getAttribute("lineID")).setAttribute("points",obj.linePoints);
				  }
				  if(pro.getAttribute("to")){
					  var line2 = pro.getAttribute("to").split(",");
					  for(var i=0,len=line2.length;i<len;i++){
						  SVG.get(line2[i]).attr({points:(obj.endTo)[i]});
						  if(g(line2[i]).getAttribute("marker-end") && g(line2[i]).getAttribute("marker-end").indexOf("s7")>0){
							  g(line2[i]).setAttribute("marker-end","url(#"+markerBlue.attr("id")+")");							  
						  }
						  else{
							  g(line2[i]).setAttribute("marker-end","url(#"+marker.attr("id")+")");							   
						  }
					  }
				  }
				  if(pro.getAttribute("from")){
					  var line1 = pro.getAttribute("from").split(",");
					  for(var i=0,len=line1.length;i<len;i++){
						  SVG.get(line1[i]).attr({points:(obj.endFrom)[i]});
						  if(g(line1[i]).getAttribute("marker-end") && g(line1[i]).getAttribute("marker-end").indexOf("s7")>0){
							  g(line1[i]).setAttribute("marker-end","url(#"+markerBlue.attr("id")+")");							  
						  }
						  else{
							  g(line1[i]).setAttribute("marker-end","url(#"+marker.attr("id")+")");							   
						  }
					  }
				  }
			  }
			  break;
		  default:break;
		  } 
	  }
  }
  
   function editPro(obj,act){
	   if(!obj.ID){ return false; }
		else{ var pro = g(obj.ID); }
	   if(pro){
		   if(act=="undo"){
			   if(obj.param=="nodename"){
				   SVG.get(obj.ID).attr({"title":obj._old});
					setValue(g(SVG.get(obj.ID).attr("textID")),dealStr(SVG.get(obj.ID).attr("title")));
					pro.setAttribute("title",SVG.get(obj.ID).attr("title"));
			   }
			   else if(obj.param=="linename"){
				   g("lab"+obj.ID).innerHTML = obj._old;
					pro.setAttribute("title",obj._old);
			   }
			   else{
				   pro.setAttribute(obj.param,obj._old);  
			   }			   
			   if(pro.nodeName=="polyline"&&(obj.param=="timeLimitType"||obj.param=="timeLimit"||obj.param=="desc"||obj.param=="inheritType"||obj.param=="inheritNodeCode")){
				   g("line"+obj.param).value = obj._old;
				   if(obj.param=="inheritType"&&obj._old=="2"){
					   $("#lineinheritCode").show();
				   }
				   if(obj.param=="inheritType"&&obj._old!="2"){
					   $("#lineinheritCode").hide();
				   }
			   }
			   else{
				   g(obj.param).value = obj._old;
				   if(obj.param=="inheritType"&&obj._old=="2"){
					   $("#inheritCode").show();
				   }
				   if(obj.param=="inheritType"&&obj._old!="2"){
					   $("#inheritCode").hide();
				   }
			   }
			   if(obj.param=="roletype"){
				   $("#rolecode").empty();
				   if(obj._old!="en"){
					   
						$("#roleName").replaceWith("<div id='roleName'>角色代码</div>");
						$("#PowerExp").replaceWith('<select id="rolecode"  onchange="changeValue(this,\'rolecode\');"  style="width:86%;">');
						$("#rolecode").append($("<option  value='0' selected='selected'>请选择</option>"));
					if(obj._old=="gw"){
						for(var k in Data.gw)
						{	
							$("#rolecode").append($("<option  value='"+k+"'>"+Data.gw[k]+"</option>"));	
						}
					}
					if(obj._old=="xz"){
						for(var k in Data.xz)
						{	
							$("#rolecode").append($("<option  value='"+k+"'>"+Data.xz[k]+"</option>"));	
						}
					}
				   if(obj._old=="bj"){
						for(var k in Data.bj)
						{	
							$("#rolecode").append($("<option  value='"+k+"'>"+Data.bj[k]+"</option>"));	
						}
					}
				   pro.setAttribute("rolecode","0");   
				  }
					else{
						$("#roleName").replaceWith("<div id='roleName'>权限表达式</div>");
						$("#rolecode").replaceWith('<input type="text" id="PowerExp" onchange="changeValue(this,\'powerexp\');" value="'+SVG.get(obj.ID).attr("powerexp")+'"style="width:86%;" >');
					}
			   }
			   if(obj.param=="opttype"){
				   if(obj._old=="D"){//自动流程节点的时候
						$("#business").hide();
						$("#childNode").hide();
						//$("#nodeEvent").show();
					}
					else if(obj._old=="S"){//子流程节点的时候
						$("#business").hide();
						//$("#nodeEvent").hide();
						$("#childNode").show();
					}
					else{//正常的时候
						$("#business").show();
						//$("#nodeEvent").hide();
						$("#childNode").hide();
					}
			   }
		   }
		   else{
			   if(obj.param=="nodename"){
				   SVG.get(obj.ID).attr({"title":obj._new});
					setValue(g(SVG.get(obj.ID).attr("textID")),dealStr(SVG.get(obj.ID).attr("title")));
					pro.setAttribute("title",SVG.get(obj.ID).attr("title"));
			   }
			   else if(obj.param=="linename"){
				   g("lab"+obj.ID).innerHTML = obj._new;
					pro.setAttribute("title",obj._new);
			   }
			   else{
				   pro.setAttribute(obj.param,obj._new); 
			   }	   
			   if(pro.nodeName=="polyline"&&(obj.param=="timeLimitType"||obj.param=="timeLimit"||obj.param=="desc"||obj.param=="inheritType"||obj.param=="inheritNodeCode")){
				   g("line"+obj.param).value = obj._new;
				   if(obj.param=="inheritType"&&obj._new=="2"){
					   $("#lineinheritCode").show();
				   }
				   if(obj.param=="inheritType"&&obj._new!="2"){
					   $("#lineinheritCode").hide();
				   }
			   }
			   else{
				   g(obj.param).value = obj._new;
				   if(obj.param=="inheritType"&&obj._new=="2"){
					   $("#inheritCode").show();
				   }
				   if(obj.param=="inheritType"&&obj._new!="2"){
					   $("#inheritCode").hide();
				   }
			   }
			   if(obj.param=="roletype"){
				   $("#rolecode").empty();
				   if(obj._new!="en"){
					   
						$("#roleName").replaceWith("<div id='roleName'>角色代码</div>");
						$("#PowerExp").replaceWith('<select id="rolecode"  onchange="changeValue(this,\'rolecode\');"  style="width:86%;">');
						$("#rolecode").append($("<option  value='0' selected='selected'>请选择</option>"));
					if(obj._new=="gw"){
						for(var k in Data.gw)
						{	
							$("#rolecode").append($("<option  value='"+k+"'>"+Data.gw[k]+"</option>"));	
						}
					}
					if(obj._new=="xz"){
						for(var k in Data.xz)
						{	
							$("#rolecode").append($("<option  value='"+k+"'>"+Data.xz[k]+"</option>"));	
						}
					}
				   if(obj._new=="bj"){
						for(var k in Data.bj)
						{	
							$("#rolecode").append($("<option  value='"+k+"'>"+Data.bj[k]+"</option>"));	
						}
					}
				   pro.setAttribute("rolecode","0");   
				  }
					else{
						$("#roleName").replaceWith("<div id='roleName'>权限表达式</div>");
						$("#rolecode").replaceWith('<input type="text" id="PowerExp" onchange="changeValue(this,\'powerexp\');" value="'+SVG.get(obj.ID).attr("powerexp")+'"style="width:86%;" >');
					}
			   }
			   if(obj.param=="opttype"){
				   if(obj._new=="D"){//自动流程节点的时候
						$("#business").hide();
						$("#childNode").hide();
						//$("#nodeEvent").show();
					}
					else if(obj._new=="S"){//子流程节点的时候
						$("#business").hide();
						//$("#nodeEvent").hide();
						$("#childNode").show();
					}
					else{//正常的时候
						$("#business").show();
						//$("#nodeEvent").hide();
						$("#childNode").hide();
					}
			   }
		   }
	   }
   }
   
     function delCircle(obj,act){
    	 if(act=="undo"){
    		 g(obj.lineID).setAttribute("points",obj._old);
    	 }
    	 else{
    		 g(obj.lineID).setAttribute("points",obj._new);
    	 }
     }
     
     function scalePro(obj,act){
    	 if(!obj.ID){ return false; }
 		else{ var pro = g(obj.ID); }
    	 if(pro){
    		 var text = pro.getAttribute("textID");
    		 if(act=="undo"){
    			 SVG.get(obj.ID).attr({"width":obj.oldWidth});
    			 SVG.get(obj.ID).attr({"height":obj.oldHeight});
    			 g(text).setAttribute("x",parseInt(pro.getAttribute("x"))+5);
				 g(text).setAttribute("y",parseInt(pro.getAttribute("y"))+(obj.oldHeight/2)+6);
				 g(text).setAttribute("dx",parseInt(pro.getAttribute("x"))+(obj.oldWidth/2));
				 setValue(g(text),dealStr(pro.getAttribute("title"),obj.oldWidth));
    			 if(pro.getAttribute("lineID")){
    				 g(pro.getAttribute("lineID")).setAttribute("points",obj.beginLinePoints);
    			 }
    			 if(pro.getAttribute("to")){
    				 var line2 = pro.getAttribute("to").split(",");
    				 for(var i=0,len=line2.length;i<len;i++){
    					 SVG.get(line2[i]).attr({points:(obj.beginTo)[i]});
    					 if(g(line2[i]).getAttribute("marker-end").indexOf("s7")>0){
							  g(line2[i]).setAttribute("marker-end","url(#"+markerBlue.attr("id")+")");							  
						  }
						  else{
							  g(line2[i]).setAttribute("marker-end","url(#"+marker.attr("id")+")");							   
						  }
    				 }
    			 }
    			 if(pro.getAttribute("from")){
    				 var line1 = pro.getAttribute("from").split(",");
    				 for(var i=0,len=line1.length;i<len;i++){
    					 SVG.get(line1[i]).attr({points:(obj.beginFrom)[i]});
    					 if(g(line1[i]).getAttribute("marker-end").indexOf("s7")>0){
							  g(line1[i]).setAttribute("marker-end","url(#"+markerBlue.attr("id")+")");							  
						  }
						  else{
							  g(line1[i]).setAttribute("marker-end","url(#"+marker.attr("id")+")");							   
						  }
    				 }
    			 }
    		 } 
    		 else{
    			 SVG.get(obj.ID).attr({"width":obj.newWidth});
    			 SVG.get(obj.ID).attr({"height":obj.newHeight});
    			 g(text).setAttribute("x",parseInt(pro.getAttribute("x"))+5);
				 g(text).setAttribute("y",parseInt(pro.getAttribute("y"))+(obj.newHeight/2)+6);
				 g(text).setAttribute("dx",parseInt(pro.getAttribute("x"))+(obj.newWidth/2));
				 setValue(g(text),dealStr(pro.getAttribute("title"),obj.newWidth));
    			 if(pro.getAttribute("lineID")){
    				 g(pro.getAttribute("lineID")).setAttribute("points",obj.linePoints);
    			 }
    			 if(pro.getAttribute("to")){
    				 var line2 = pro.getAttribute("to").split(",");
    				 for(var i=0,len=line2.length;i<len;i++){
    					 SVG.get(line2[i]).attr({points:(obj.endTo)[i]});
    					 if(g(line2[i]).getAttribute("marker-end").indexOf("s7")>0){
							  g(line2[i]).setAttribute("marker-end","url(#"+markerBlue.attr("id")+")");							  
						  }
						  else{
							  g(line2[i]).setAttribute("marker-end","url(#"+marker.attr("id")+")");							   
						  }
    				 }
    			 }
    			 if(pro.getAttribute("from")){
    				 var line1 = pro.getAttribute("from").split(",");
    				 for(var i=0,len=line1.length;i<len;i++){
    					 SVG.get(line1[i]).attr({points:(obj.endFrom)[i]});
    					 if(g(line1[i]).getAttribute("marker-end").indexOf("s7")>0){
							  g(line1[i]).setAttribute("marker-end","url(#"+markerBlue.attr("id")+")");							  
						  }
						  else{
							  g(line1[i]).setAttribute("marker-end","url(#"+marker.attr("id")+")");							   
						  }
    				 }
    			 }
    		 }
    	 }
     }