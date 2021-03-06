var getID = function( id ){
	return document.getElementById(id);	
}
String.prototype.trim = function(){
	return this.replace(/(^\s*)|(\s*$)/g,"");	
}
var Menu = {};
Menu.menuDate = {
	//判断对象是否为空
	isEmptyObject:function(jsonList){
		for( var name in jsonList ){
			return false;
		}
		return true;
	},
	
	//得到规定的以及菜单
	getHeadList:function(list,pID){
		var hArr = new Array(),len,gID;
		if(pID){ gID = pID; }
		else{ gID = "0"; }
		for(var i=0,len=list.length;i<len;i++){
			if( list[i]["ParentID"]==gID ){
				hArr.push(list[i]);
			}
		}
		return hArr;
	},
	
	//动态判断nodeName 是否存在
	haveNode:function(json,nodeName){
		if( json[nodeName] === undefined ){
			return false;
		}
		return true;
	},
	
	//固定的json格式，不管命名的变化
	getFirstNode:function( json ){
		var firstNode = new Array;
		for( var name in json ){
			firstNode.push(name);
		}
		return firstNode;
	},
	
	//获取菜单列表
	getList:function(json,nodeName){
		return json[nodeName];
	},
	
	getFlag:function(list,flag){
		var v = new Array;
		for( var i=0,len=list.length;i<len;i++ ){
			if( parseInt(list[i][flag])===1 ){
				v.push(list[i]);	
			}
		}
		return v;
	},
	
	//得到nodeName 数组
	getNodeNameList:function(list,nodeName){
		var n = new Array;
		for( var i=0,len=list.length;i<len;i++ ){
			n.push(list[i][nodeName]);
		}
		return n;
	},
	
	//通过id 得到 nodeName
	getNodeName:function(id,list){
		for( var i=0,len=list.length;i<len;i++ ){
			if(list[i]["MID"]==id){
				return list[i]["MText"];
			}
		}
		return "";
	},
	
	requireList:function(list,headArr){
		var len = list.length,
			arr = new Array(),
			key = new Array(),
			nList = new Array(),
			index,h=1,id,reg;
		while( h ){
			for( var i=0;i<len;i++ ){
				id = list[i]["ParentID"].trim();
				if(id=="0") continue;
				reg = new RegExp("\\b("+id+")\\b");
				index = reg.test(headArr);
				if(index){
					arr.push(list[i]);
					key.push(list[i]["MID"]);
				}
			}
			if(key.length==0) break;
			nList = nList.concat(arr);
			headArr = key.join(",");
			key.length = 0;
			arr.length = 0;
			h++;
		}
		return nList;
	}
};

Menu.menuView = {
	//生成菜单类
	headList:function(list,nodeID,nodeText){
		var menuView = new Array;
		for( var i=0,len=list.length;i<len;i++ ){
			menuView.push("<div class='accordionHeader' id='head_"+list[i][nodeID]+"'><h2><span>Folder</span>"+list[i][nodeText]+"</h2></div>");
			menuView.push("<div class='accordionContent' id='menu_"+list[i][nodeID]+"'></div>");
		}
		return menuView;
	},
	//生成横向大类
	mainHead:function(list,nodeID,nodeText){
		var head = new Array;
		/*head.push("<div id='navMenu'><ul>");
		head.push("<li><a href='javascript:void(0);' class='menuHead' setId=''>主菜单</a></li>");
		for( var i=0,len=list.length;i<len;i++ ){		
			head.push("<li><a href='javascript:void(0);' class='menuHead' setId='"+list[i][nodeID]+"'>"+list[i][nodeText]+"</a></li>");
		}
		head.push("</ul></div>");*/
		return head;	
	},
	
	//子菜单 二级/三级
	menuList:function(list,projectName){
		var menuView = new Array;
		for( var i=0,len=list.length;i<len;i++ ){
			if( !!list[i]["MUrl"] && list[i]["MUrl"].trim()!="..." ){
				if(list[i]["MType"]!="D"){
					menuView.push("<li id='menu_"+list[i]["MID"]+"' parentId='"+list[i]["ParentID"]+"'><a href='"+projectName+list[i]["MUrl"]+"' target='navTab' rel='external_"+list[i]["MID"]+"' external='true' >"+list[i]["MText"]+"</a></li>");
				}else{
					menuView.push("<li id='menu_"+list[i]["MID"]+"' parentId='"+list[i]["ParentID"]+"'><a href='"+projectName+list[i]["MUrl"]+"' target='navTab' rel='external_"+list[i]["MID"]+"' >"+list[i]["MText"]+"</a></li>");
				}
			}else{
				menuView.push("<li id='menu_"+list[i]["MID"]+"' parentId='"+list[i]["ParentID"]+"'><a rel='external_"+list[i]["MID"]+"' >"+list[i]["MText"]+"</a></li>");
			}
		}
		return menuView;
	},
	
	addUL:function( id,liView ){
		var ulDom = getID("ul_"+id),menuDom = getID("menu_"+id);
		if( ulDom === null ){
			menuDom.innerHTML += "<ul id='ul_"+id+"'>"+liView+"</ul>";
			var ulDom = getID("ul_"+id);
			if( ulDom.parentNode.nodeName.toLowerCase() != "li" ){
				ulDom.className = "tree treeFolder";
			}
		}else{
			ulDom.innerHTML += liView;	
		}
	},
	
	otherView:function(nodeName){
		var menuView,mName;
		if(nodeName) mName = nodeName;
		else mName = "主菜单";
		menuView = "<div class='toggleCollapse'><h2>"+mName+"</h2><div>主菜单</div></div><div class='accordion' fillSpace='sidebar' id='menuContent'></div>";
		return menuView;
	}
};

function setHeight(){
	var j=0;
	var parent = $("#sidebar");
	for(var i=0,len=$(".accordionHeader", parent).size();i<len;i++){
		$this = $(".accordionHeader", parent).eq(i);
		if($this.css("display")!="none"){
			j++;
		}
	};
	var height = parent.height() - (j * ($(".accordionHeader:first-child", parent).outerHeight()));
	$(".accordionContent",parent).height(height-$(".toggleCollapse:first-child").outerHeight()-3);
}

function menuDisplay(menuList,projectName,setID){
	var mv = Menu.menuView,md = Menu.menuDate,list = md.getList(menuList,"menuList");
	if(  md.haveNode(menuList,"menuList") && !md.isEmptyObject(menuList) ){
		var headList = md.getHeadList(list),
			singleList = md.getHeadList(list,setID),
		    c = mv.headList(singleList,"MID","MText").join(""),
			mainHead = mv.mainHead(headList,"MID","MText").join(""),
			headArr = md.getNodeNameList(singleList,"MID").join(","),
			d = mv.menuList( md.requireList( list,headArr ),projectName ),
			len=d.length;
		
		if(getID("navMenu")==undefined)getID("header").innerHTML += mainHead;
		getID("sidebar").innerHTML = mv.otherView( md.getNodeName(setID,list) );
		getID("menuContent").innerHTML = c;
		
		for( i=0;i<len;i++ ){
			var id = d[i].match(/(.*)parentId='(.*)'><a(.*)/)[2];
			mv.addUL( id,d[i] );
		};
		setHeight();
	}
};
