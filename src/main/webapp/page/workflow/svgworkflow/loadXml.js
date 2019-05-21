//x(attrValue(getShape[i],"title","x")).y(attrValue(getShape[i],"title","y")).attr({dx:attrValue(getShape[i],"title","dx")})
function nodeValue(o,nodeName){
	if(o.getElementsByTagName(nodeName)[0]){
		if(o.getElementsByTagName(nodeName)[0].textContent){
			return o.getElementsByTagName(nodeName)[0].textContent;
		}else{
			return o.getElementsByTagName(nodeName)[0].text;	
		}
	}
}

function attrValue(o,nodeName,attrName){
	return o.getElementsByTagName(nodeName)[0].getAttribute(attrName);	
}



var g = function(id){ return document.getElementById(id); }
//obj:{"a":"11","b":22}
var addStyle = function(o,obj){
	if(!o) return false;
	if( (typeof obj) != "object" ) return false;
	for( var able in obj ){
		o.style[able] = obj[able];
	}
	
}

var addNode = function(o,obj){
	if(!o) return false;
	if( (typeof obj) != "object" ) return false;
	for( var able in obj ){
		o.setAttribute(able,obj[able]);
	}
	
}

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



function getPoint(pro){
	var x,y,w,h,left,right,top,bottom,pointArray = new Array, points;
	if(pro.type=="rect"){
		x = pro.x(),y=pro.y(),
		w = pro.attr("width"),
		h = pro.attr("height"),
		left = [x,y+h/2];
		right = [x+w,y+h/2];
		top = [x+w/2,y];
		bottom = [x+w/2,y+h];
	}else if(pro.type=="polygon"){
		points = pro.attr("points").split(" ");
		
		for( var i=0,len=points.length;i<len;i++ ){
			var cp = points[i].split(",");
			pointArray.push([cp[0],cp[1]]);	
		}
		top = pointArray[2];
		right = pointArray[1];
		bottom = pointArray[0];
		left = pointArray[3];
	}else{
		x = pro.x(),y=pro.y();
		w = h = parseInt(pro.attr("rx"))*2;
		left = [x,y+h/2];
		right = [x+w,y+h/2];
		top = [x+w/2,y];
		bottom = [x+w/2,y+h];
	}
	return {L:left,T:top,R:right,B:bottom};
}

function getEndPoint(pro){
	var x,y,w,h,left,right,top,bottom,pointArray = new Array, points;
	if(pro.type=="rect"){
		x = pro.x(),y=pro.y(),
		w = pro.attr("width"),
		h = pro.attr("height"),
		left = [x-9,y+h/2],
		right = [x+w+9,y+h/2],
		top = [x+w/2,y-9],
		bottom = [x+w/2,y+h+9];
	}else if( pro.type=="polygon" ){
		points = pro.attr("points").split(" ");
		
		for( var i=0,len=points.length;i<len;i++ ){
			var cp = points[i].split(",");
			pointArray.push([cp[0],cp[1]]);	
		}
		top = pointArray[2];
		right = pointArray[1];
		bottom = pointArray[0];
		left = pointArray[3];
	}else{
		x = pro.x(),y=pro.y();
		w = h = parseInt(pro.attr("rx"))*2;
		left = [x-9,y+h/2],
		right = [x+w+9,y+h/2],
		top = [x+w/2,y-9],
		bottom = [x+w/2,y+h+9];	
	}
	return {L:left,T:top,R:right,B:bottom};
}

//矩形中心点
function getRectCenter(o){
	var x,y,w,h;
	x = o.x();
	y = o.y();
	w = parseInt(o.attr("width"));
	h = parseInt(o.attr("height"));
	return {x:x+(w/2),y:y+(h/2)};
}

//格式化线的位置 此方法适合于只有两个点的直线，如果是多点就不合适
function formatLine(pocBegin,pocEnd){
	var F1 = getPoint(pocBegin),
		F2 = getEndPoint(pocEnd),
		w = 100,
		h = 50,
		p1,p2,x1,x2,y1,y2;
	
	if( pocBegin.type=="rect" || pocBegin.type=="ellipse" ){
		x1 = pocBegin.x();
		y1 = pocBegin.y();
	}else if( pocBegin.type=="polygon" ){
		x1 = parseInt(pocBegin.attr("getX"))-50;
		y1 = parseInt(pocBegin.attr("getY"))-25;
	}
	
	if( pocEnd.type=="rect" || pocEnd.type=="ellipse" ){
		x2 = pocEnd.x();
		y2 = pocEnd.y();
	}else if( pocEnd.type=="polygon" ){
		x2 = parseInt(pocEnd.attr("getX"))-50;
		y2 = parseInt(pocEnd.attr("getY"))-25;
	}
		
	if(x1+w+50<x2){
		if(y1+h+50<y2){
			p1 = F1.R;
			p2 = F2.T;
		}else if(y1-h-50>y2){
			p1 = F1.R;
			p2 = F2.B;
		}else{
			p1 = F1.R;
			p2 = F2.L;
		}
	}else if(x1-w-50>x2){
		if(y1+h+50<y2){
			p1 = F1.L;
			p2 = F2.T;
		}else if(y1-h-50>y2){
			p1 = F1.L;
			p2 = F2.B;
		}else{
			p1 = F1.L;
			p2 = F2.R;
		}
	}else{
		if(y1+h<y2){
			p1 = F1.B;
			p2 = F2.T;
		}else if(y1-h>y2){
			p1 = F1.T;
			p2 = F2.B;
		}
	}
	return {p1:p1,p2:p2};
}

function VMLgetPoint(pro){
	var x,y,w,h,left,right,top,bottom,pointArray = new Array, points;
	if(pro.tagName=="RoundRect"){
		x = parseInt(pro.style.left),
		y = parseInt(pro.style.top),
		w = parseInt(pro.style.width),
		h = parseInt(pro.style.height),
		left = [x,y+h/2];
		right = [x+w,y+h/2];
		top = [x+w/2,y];
		bottom = [x+w/2,y+h];
	}else if(pro.tagName=="Shape"){
		/*points = pro.attr("points").split(" ");
		
		for( var i=0,len=points.length;i<len;i++ ){
			var cp = points[i].split(",");
			pointArray.push([cp[0],cp[1]]);	
		}
		top = pointArray[2];
		right = pointArray[1];
		bottom = pointArray[0];
		left = pointArray[3];*/
		x = parseInt(pro.style.left),
		y = parseInt(pro.style.top),
		w = parseInt(pro.style.width),
		h = parseInt(pro.style.height),
		left = [x-w/2,y+h/2];
		right = [x+w/2,y+h/2];
		top = [x,y];
		bottom = [x,y+h];
	}else{
		x = parseInt(pro.style.left),
		y = parseInt(pro.style.top),
		w = h = parseInt(parseInt(pro.style.width));
		left = [x,y+h/2];
		right = [x+w,y+h/2];
		top = [x+w/2,y];
		bottom = [x+w/2,y+h];
	}
	return {L:left,T:top,R:right,B:bottom};
}

//VML格式化线的位置 此方法适合于只有两个点的直线，如果是多点就不合适
function VMLformatLine(pocBegin,pocEnd){
	var F1 = VMLgetPoint(pocBegin),
		F2 = VMLgetPoint(pocEnd),
		w = 100,
		h = 50,
		p1,p2,x1,x2,y1,y2,p=new Array;
	
	if( pocBegin.tagName=="RoundRect" || pocBegin.tagName=="Oval" ){
		x1 = parseInt(pocBegin.style.left);
		y1 = parseInt(pocBegin.style.top);
	}else if( pocBegin.tagName=="Shape" ){
		x1 = parseInt(pocBegin.style.left)-w/2;
		y1 = parseInt(pocBegin.style.top);
	}
	
	if( pocEnd.tagName=="RoundRect" || pocEnd.tagName=="Oval" ){
		x2 = parseInt(pocEnd.style.left);
		y2 = parseInt(pocEnd.style.top);
	}else if( pocEnd.tagName=="Shape" ){
		x2 = parseInt(pocEnd.style.left)-w/2;
		y2 = parseInt(pocEnd.style.top);
	}
		
	if(x1+w+50<x2){
		if(y1+h+50<y2){
			p1 = F1.R;
			p2 = F2.T;
		}else if(y1-h-50>y2){
			p1 = F1.R;
			p2 = F2.B;
		}else{
			p1 = F1.R;
			p2 = F2.L;
		}
	}else if(x1-w-50>x2){
		if(y1+h+50<y2){
			p1 = F1.L;
			p2 = F2.T;
		}else if(y1-h-50>y2){
			p1 = F1.L;
			p2 = F2.B;
		}else{
			p1 = F1.L;
			p2 = F2.R;
		}
	}else{
		if(y1+h<y2){
			p1 = F1.B;
			p2 = F2.T;
		}else if(y1-h>y2){
			p1 = F1.T;
			p2 = F2.B;
		}
	}
	p.push(p1[0]+"px");
	p.push(p1[1]+"px");
	p.push(p2[0]+"px");
	p.push(p2[1]+"px");
	return p;
}

//处理字串方法
String.prototype.trim = function(){
	return this.replace(/(^\s*)|(\s*$)/g,"");	
}
//截取多余的字串
function dealStr(str,length){
	if(!length) var length = 6;
	if(str.length==0){ return ""; }
	else{
		if(str.trim().length>length){
			return str.substr(0,length)+"...";
		}else{
			return 	str;
		}
	}
}

// 画菱形的4个点
function drawPolygon(point){
	var p = new Array;
	p[0] = [point[0],point[1]+25];
	p[1] = [point[0]+55,point[1]];
	p[2] = [point[0],point[1]-25];
	p[3] = [point[0]-55,point[1]];
	return p.join(" ");
}

function loadXml(xml,canvas){
	var c = SVG(canvas),
		gLine = c.group().attr({"x":0,"y":0}),
		gText = c.group().attr({"x":0,"y":0}),
		gShape = c.group().attr({"x":0,"y":0}),
		marker = c.marker(),
		markerBlue = c.marker(),
		markerYellow = c.marker();
		
	marker.attr({"viewBox":"0 0 8 8","refX":0,"refY":4,"markerUnits":"strokeWidth","markerWidth":5,"markerHeight":5,"orient":"auto"});
	marker.path().attr({"d":"M 0 0 L 7 4 L 0 7 z"}).fill("#000");
		
	markerBlue.attr({"viewBox":"0 0 8 8","refX":0,"refY":4,"markerUnits":"strokeWidth","markerWidth":5,"markerHeight":5,"orient":"auto"});
	markerBlue.path().attr({"d":"M 0 0 L 7 4 L 0 7 z"}).fill("blue");
	
	markerYellow.attr({"viewBox":"0 0 8 8","refX":0,"refY":4,"markerUnits":"strokeWidth","markerWidth":5,"markerHeight":5,"orient":"auto"});
	markerYellow.path().attr({"d":"M 0 0 L 7 4 L 0 7 z"}).fill("#999");
	
	var xmlDoc;
	if(window.ActiveXObject){
		xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.loadXML(xml);
	}else if(window.DOMParser){
		parser=new DOMParser();
		xmlDoc=parser.parseFromString(xml,"text/xml");
	}  
	
	var getShape = xmlDoc.getElementsByTagName("Node"),
		getLine = xmlDoc.getElementsByTagName("Transition");
		for( var i=0,len=getShape.length;i<len;i++ ){
			var shap = attrValue(getShape[i],"VMLProperties","shapetype");
			switch( shap ){
				case "Oval":
					var c = gShape.circle(50).cx(parseInt(attrValue(getShape[i],"VMLProperties","x"))).cy(parseInt(attrValue(getShape[i],"VMLProperties","y")))
					 .attr({"id":attrValue(getShape[i],"BaseProperties","id"),
						    "type":"circle",
							"shapetype":"Oval",
							"title":attrValue(getShape[i],"BaseProperties","name"),
							"flowphase":attrValue(getShape[i],"BaseProperties","flowphase"),
							"nodedesc":attrValue(getShape[i],"BaseProperties","nodedesc"),
							"nodetype":attrValue(getShape[i],"BaseProperties","nodetype"),
							"opttype":attrValue(getShape[i],"BaseProperties","opttype"),
							"optcode":attrValue(getShape[i],"BaseProperties","optcode"),
							"optbean":attrValue(getShape[i],"BaseProperties","optbean"),
							"optparam":attrValue(getShape[i],"BaseProperties","optparam"),
							"subwfcode":attrValue(getShape[i],"BaseProperties","subwfcode"),
							"roletype":attrValue(getShape[i],"BaseProperties","roletype"),
							"rolecode":attrValue(getShape[i],"BaseProperties","rolecode"),
							"isaccounttime":attrValue(getShape[i],"BaseProperties","isaccounttime"),
							"timeLimitType":attrValue(getShape[i],"BaseProperties","timeLimitType"),
							"timelimit":attrValue(getShape[i],"BaseProperties","timelimit"),
							"isTrunkLine":attrValue(getShape[i],"BaseProperties","isTrunkLine"),
							"unitexp":attrValue(getShape[i],"BaseProperties","unitexp"),
							"powerexp":attrValue(getShape[i],"BaseProperties","powerexp"),
							"expireopt":attrValue(getShape[i],"BaseProperties","expireopt"),
							"desc":attrValue(getShape[i],"BaseProperties","desc")
							 
					  }).stroke({width:2,color:"#000"}).fill("#fff").style({"fill-opacity":0});
				
					var t = gText.text( dealStr(attrValue(getShape[i],"BaseProperties","name")) )
						 .x(parseInt(attrValue(getShape[i],"VMLProperties","x")))
						 .y(parseInt(attrValue(getShape[i],"VMLProperties","y"))+6)
						 .attr({dx:parseInt(attrValue(getShape[i],"VMLProperties","x"))})
						 .font({family:"Arial",size:14,"text-anchor":"middle"});
					c.attr({"textID":t.attr("id")});
					break;
					
				case "roundrect":
					var r = gShape.rect(100,50).x(parseInt(attrValue(getShape[i],"VMLProperties","x"))).y(parseInt(attrValue(getShape[i],"VMLProperties","y")))
						  .stroke({color:"#000",width:2}).fill("#fff").style({"fill-opacity":0})
						  .attr({rx:6,ry:6, "shapetype":"roundrect",
										    "id":attrValue(getShape[i],"BaseProperties","id"),
										    "title":attrValue(getShape[i],"BaseProperties","name"),
											"flowphase":attrValue(getShape[i],"BaseProperties","flowphase"),
											"nodedesc":attrValue(getShape[i],"BaseProperties","nodedesc"),
											"nodetype":attrValue(getShape[i],"BaseProperties","nodetype"),
											"opttype":attrValue(getShape[i],"BaseProperties","opttype"),
											"optcode":attrValue(getShape[i],"BaseProperties","optcode"),
											"optbean":attrValue(getShape[i],"BaseProperties","optbean"),
											"optparam":attrValue(getShape[i],"BaseProperties","optparam"),
											"subwfcode":attrValue(getShape[i],"BaseProperties","subwfcode"),
											"roletype":attrValue(getShape[i],"BaseProperties","roletype"),
											"rolecode":attrValue(getShape[i],"BaseProperties","rolecode"),
											"isaccounttime":attrValue(getShape[i],"BaseProperties","isaccounttime"),
											"timeLimitType":attrValue(getShape[i],"BaseProperties","timeLimitType"),
											"timelimit":attrValue(getShape[i],"BaseProperties","timelimit"),
											"isTrunkLine":attrValue(getShape[i],"BaseProperties","isTrunkLine"),
											"unitexp":attrValue(getShape[i],"BaseProperties","unitexp"),
											"powerexp":attrValue(getShape[i],"BaseProperties","powerexp"),
											"expireopt":attrValue(getShape[i],"BaseProperties","expireopt"),
											"desc":attrValue(getShape[i],"BaseProperties","desc")
								});
	
					var t = gText.text( dealStr(attrValue(getShape[i],"BaseProperties","name")) )
						 .x(parseInt(attrValue(getShape[i],"VMLProperties","x"))+5)
						 .y(parseInt(attrValue(getShape[i],"VMLProperties","y"))+32)
						 .attr({dx:parseInt(attrValue(getShape[i],"VMLProperties","x"))+50})
						 .font({family:"Arial",size:14,"text-anchor":"middle"});
					r.attr({"textID":t.attr("id")});
					break;
					
				case "diamond":
					var p = gShape.polygon(drawPolygon([parseInt(attrValue(getShape[i],"VMLProperties","x")),parseInt(attrValue(getShape[i],"VMLProperties","y"))])).fill("#fff")
						  .stroke({color:"#000",width:2}).style({"fill-opacity":0})
						  .attr({'transform':"","shapetype":"diamond",
												"id":attrValue(getShape[i],"BaseProperties","id"),
												"title":attrValue(getShape[i],"BaseProperties","name"),
												"flowphase":attrValue(getShape[i],"BaseProperties","flowphase"),
												"nodedesc":attrValue(getShape[i],"BaseProperties","nodedesc"),
												"nodetype":attrValue(getShape[i],"BaseProperties","nodetype"),
												"opttype":attrValue(getShape[i],"BaseProperties","opttype"),
												"optcode":attrValue(getShape[i],"BaseProperties","optcode"),
												"optbean":attrValue(getShape[i],"BaseProperties","optbean"),
												"optparam":attrValue(getShape[i],"BaseProperties","optparam"),
												"subwfcode":attrValue(getShape[i],"BaseProperties","subwfcode"),
												"roletype":attrValue(getShape[i],"BaseProperties","roletype"),
												"rolecode":attrValue(getShape[i],"BaseProperties","rolecode"),
												"isaccounttime":attrValue(getShape[i],"BaseProperties","isaccounttime"),
												"timeLimitType":attrValue(getShape[i],"BaseProperties","timeLimitType"),
												"timelimit":attrValue(getShape[i],"BaseProperties","timelimit"),
												"isTrunkLine":attrValue(getShape[i],"BaseProperties","isTrunkLine"),
												"unitexp":attrValue(getShape[i],"BaseProperties","unitexp"),
												"powerexp":attrValue(getShape[i],"BaseProperties","powerexp"),
												"expireopt":attrValue(getShape[i],"BaseProperties","expireopt"),
												"desc":attrValue(getShape[i],"BaseProperties","desc"),
												"getX":parseInt(attrValue(getShape[i],"VMLProperties","x")),
												"getY":parseInt(attrValue(getShape[i],"VMLProperties","y"))
						  });
					var t = gText.text( dealStr(attrValue(getShape[i],"BaseProperties","name")) )
						 .x(parseInt(attrValue(getShape[i],"VMLProperties","x")))
						 .y(parseInt(attrValue(getShape[i],"VMLProperties","y"))+6)
						 .attr({dx:parseInt(attrValue(getShape[i],"VMLProperties","x"))})
						 .font({family:"Arial",size:14,"text-anchor":"middle"});
					p.attr({"textID":t.attr("id")});
					break;
			}
		}
		
		for( var j=0,jLen=getLine.length;j<jLen;j++ ){
			var line = gLine.polyline().stroke({ color:"#000",width: 2 }).fill("#fff")
							.attr({'transform':"","marker-end":"url(#"+marker.attr("id")+")",
									"id":attrValue(getLine[j],"BaseProperties","id"),
									"title":attrValue(getLine[j],"BaseProperties","name"),
									"timeLimitType":attrValue(getLine[j],"BaseProperties","timeLimitType"),
									"timelimit":attrValue(getLine[j],"BaseProperties","timelimit"),
									"cond":attrValue(getLine[j],"BaseProperties","cond"),
									"desc":attrValue(getLine[j],"BaseProperties","desc"),
									"shapetype":"PolyLine",
									"points":attrValue(getLine[j],"VMLProperties","points")
								  });
			g("lineCon").innerHTML+=("<div class='step' style='left:"+attrValue(getLine[j],"LabelProperties","x")+";top:"+attrValue(getLine[j],"LabelProperties","y")+";' id='"+attrValue(getLine[j],"LabelProperties","id")+"'>"+attrValue(getLine[j],"BaseProperties","name")+"</div>");
		}
	
	/*SVG.get("s5").attr({"flow_id":xmlDoc.getElementsByTagName("flow_id")[0].textContent,
						"flow_code":xmlDoc.getElementsByTagName("flow_code")[0].textContent,
						"flow_title":xmlDoc.getElementsByTagName("flow_title")[0].textContent});*/
		
}

function tip(o){
	
	if(g("tip")){
			
	}
}