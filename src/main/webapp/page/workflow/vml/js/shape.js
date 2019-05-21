/*--------------------------------------------------|
| 本作品取得原作者授权修改自 support@tops.com.cn    |
| 的作品topflow                                     |
|                                                   |
| 保存流程图中用到的图形，包括预定义与自定义        |
|                                                   |
| 版权归上海雪线信息技术有限公司所有，              |
| 技术支持：sales@shcommit.com （仅对付费用户）     |
| 网    站：www.shcommit.com                        |
|                                                   |
| 请勿私自拷贝、修改或用于商业用途                  |
| 敬请保留本注释.                                   |
|                                                   |
| Updated: 20090620                                 |
|--------------------------------------------------*/

//定义目前可使用的各种图形及标识ID，其中demo表示是演示中使用，val是实际对象
var _SHAPE = [];
_SHAPE["roundrect"] = [];
_SHAPE["rect"] = [];
_SHAPE["oval"] = [];
_SHAPE["diamond"] = [];
_SHAPE["line"] = [];
_SHAPE["polyline"] = [];
_SHAPE["polylinenolabel"] = [];
_SHAPE["bing"] = [];
_SHAPE["ju"] = [];
_SHAPE["multi"] = [];
_SHAPE["r"] = [];
//圆形
_SHAPE["oval"]["demo"] = 
              '<v:Oval id="demoOval" title="圆形" style="position:relative;left:0px;top:0px;width:100px;height:40px;z-index:9" strokecolor="red" strokeweight="1">' +
                '<v:shadow id="demoOvalShadow" on="T" type="single" color="#b3b3b3" offset="5px,5px"/>' + 
                '<v:extrusion id="demoOvalExt" on="false" backdepth="20" />' +
                '<v:fill id="demoOvalFill" type="gradient" color="white" color2="white" />' +
                '<v:TextBox id="demoOvalText" inset="2pt,5pt,2pt,5pt" style="text-align:center; color:red; font-size:9pt;">示例</v:TextBox>' +
              '</v:Oval>';
_SHAPE["oval"]["val"] = 
              '<v:Oval id="{id}" title="{title}" sc="{sc}" fsc="{fsc}" st="{st}" typ="Proc" style="position:absolute;left:{l};top:{t};width:{w};height:{h};z-index:{z}"" strokecolor="{sc}" strokeweight="{sw}" ondblclick=\'editProc(this.id);\' >' +
                '<v:shadow on="{shadowenable}" type="single" color="{shadowcolor}" offset="5px,5px"/>' + 
                '<v:extrusion on="{3denable}" backdepth="{3ddepth}" />' +
                '<v:fill type="gradient" color="{sc1}" color2="{sc2}" />' +
                '<v:TextBox id="{id}Text" inset="2pt,5pt,2pt,5pt" style="text-align:center; color:{tc}; font-size:{fs};">{text}</v:TextBox>' +
              '</v:Oval>';
//方形
_SHAPE["rect"]["demo"] = 
              '<v:rect id="demoRect" title="方形" style="backgroup-color:#f0f0f0;z-index:0;position:relative;width:100px;height:40px;left:0px;top:0px;" strokecolor="blue" strokeweight="1">' +
              '  <v:shadow on="T" type="single" color="#b3b3b3" offset="5px,5px"/>' +
              '  <v:extrusion on="false" backdepth="20" />' +
              '  <v:fill type="gradient" color="white" color2="white" />' +
              '  <v:TextBox inset="2pt,5pt,2pt,5pt" style="text-align:center; color:blue; font-size:9pt;">示例</v:TextBox>' +
              '</v:rect>';
_SHAPE["rect"]["val"] =
              '<v:rect id="{id}" title="{title}" sc="{sc}" fsc="{fsc}" st="{st}" typ="Proc" style="z-index:{z};position:absolute;width:{w};height:{h};left:{l};top:{t};" strokecolor="{sc}" strokeweight="{sw}" ondblclick=\'editProc(this.id);\'>' +
              '  <v:shadow on="{shadowenable}" type="single" color="{shadowcolor}" offset="5px,5px"/>' +
              '  <v:extrusion on="{3denable}" backdepth="{3ddepth}" />' +
              '  <v:fill type="gradient" color="#dddddd" color2="#dddddd" />' +
              '  <v:TextBox id="{id}Text" inset="2pt,5pt,2pt,5pt" style="text-align:center; color:{tc}; font-size:{fs};">{text}</v:TextBox>' +
              '</v:rect>';

_SHAPE["bing"]["val"] =
	'<v:RoundRect id="{id}" title="{title}" sc="{sc}" fsc="{fsc}" st="{st}" typ="Proc" style="position:absolute;left:{l};top:{t};width:{w};height:{h};z-index:{z}"" strokecolor="{sc}" ondblclick=\'editProc(this.id);\'>' +
    '<v:shadow on="{shadowenable}" type="single" color="{shadowcolor}" offset="5px,5px"/>' + 
    '<v:extrusion on="{3denable}" backdepth="{3ddepth}" />' +
    '<v:fill type="gradient" color="{sc1}" color2="{sc2}" />' +
    '<v:TextBox id="{id}Text" inset="2pt,5pt,2pt,5pt" style="text-align:center; color:{tc}; font-size:{fs};">{text}</v:TextBox>' +
    '<hr id="h-{id}" style="width:93%;position:absolute;bottom:15px;left:2px;right:10px;color:{sc};height:1px;" />'+
  '</v:RoundRect>';

_SHAPE["ju"]["val"] =
	'<v:RoundRect id="{id}" title="{title}" sc="{sc}" fsc="{fsc}" st="{st}" typ="Proc" style="position:absolute;left:{l};top:{t};width:{w};height:{h};z-index:{z}"" strokecolor="{sc}" ondblclick=\'editProc(this.id);\'>' +
    '<v:shadow on="{shadowenable}" type="single" color="{shadowcolor}" offset="5px,5px"/>' + 
    '<v:extrusion on="{3denable}" backdepth="{3ddepth}" />' +
    '<v:fill type="gradient" color="{sc1}" color2="{sc2}" />' +
    '<v:TextBox id="{id}Text" inset="2pt,5pt,2pt,5pt" style="text-align:center; color:{tc}; font-size:{fs};">{text}</v:TextBox>' +
    '<hr id="h-{id}" style="width:95%;margin:2px 5px 10px 0px;color:{sc};height:1px;" />'+
  '</v:RoundRect>';

//圆角形
_SHAPE["roundrect"]["demo"] = 
              '<v:RoundRect id="demoRoundRect" title="圆角形" style="position:relative;left:0px;top:0px;width:100px;height:40px;z-index:9"" strokecolor="blue" strokeweight="1">' +
                '<v:shadow id="demoRoundRectShadow" on="T" type="single" color="#b3b3b3" offset="5px,5px"/>' + 
                '<v:extrusion id="demoRoundRectExt" on="false" backdepth="20" />' +
                '<v:fill id="demoRoundRectFill" type="gradient" color="white" color2="white" />' +
                '<v:TextBox id="demoRoundRectText" inset="2pt,5pt,2pt,5pt" style="text-align:center; color:blue; font-size:9pt;">示例</v:TextBox>' +
              '</v:RoundRect>';
_SHAPE["roundrect"]["val"] = 
              '<v:RoundRect id="{id}" title="{title}" sc="{sc}" fsc="{fsc}" st="{st}" typ="Proc" style="position:absolute;left:{l};top:{t};width:{w};height:{h};z-index:{z}"" strokecolor="{sc}" ondblclick=\'editProc(this.id);\'>' +
                '<v:shadow on="{shadowenable}" type="single" color="{shadowcolor}" offset="5px,5px"/>' + 
                '<v:extrusion on="{3denable}" backdepth="{3ddepth}" />' +
                '<v:fill type="gradient" color="{sc1}" color2="{sc2}" />' +
                '<v:TextBox id="{id}Text" inset="2pt,5pt,2pt,5pt" style="text-align:center; color:{tc}; font-size:{fs};">{text}</v:TextBox>' +
              '</v:RoundRect>';

_SHAPE["multi"]["val"] = 
    '<v:RoundRect id="{id}" title="{title}" sc="{sc}" fsc="{fsc}" st="{st}" typ="Proc" style="position:absolute;left:{l};top:{t};width:{w};height:{h};z-index:{z}"" strokecolor="{sc}" ondblclick=\'editProc(this.id);\'>' +
      '<v:shadow on="{shadowenable}" type="single" color="{shadowcolor}" offset="5px,5px"/>' + 
      '<v:extrusion on="{3denable}" backdepth="{3ddepth}" />' +
      '<v:fill type="gradient" color="{sc1}" color2="{sc2}" />' +
      '<v:TextBox id="{id}Text" inset="2pt,5pt,2pt,5pt" style="text-align:center; color:{tc}; font-size:{fs};">{text}</v:TextBox>' +
      '<hr id="h-{id}" style="width:93%;position:absolute;left:2px;bottom:15px;right:10px;color:{sc};height:1px;border:1 dashed {sc};" />'+
    '</v:RoundRect>';

_SHAPE["r"]["val"] = 
	'<v:RoundRect id="{id}" title="{title}" sc="{sc}" fsc="{fsc}" st="{st}" typ="Proc" style="position:absolute;left:{l};top:{t};width:{w};height:{h};z-index:{z}"" strokecolor="{sc}" ondblclick=\'editProc(this.id);\'>' +
    '<v:shadow on="{shadowenable}" type="single" color="{shadowcolor}" offset="5px,5px"/>' + 
    '<v:extrusion on="{3denable}" backdepth="{3ddepth}" />' +
    '<v:fill color=" #87CEEB" />' +
    '<v:TextBox id="{id}Text" inset="2pt,5pt,2pt,5pt" style="text-align:center; color:{tc}; font-size:{fs};">{text}</v:TextBox>' +
  '</v:RoundRect>';

//菱形
_SHAPE["diamond"]["demo"] = 
              '<v:shape id="demoDiamond" title="菱形" type="#diamond" style="position:relative;left:0px;top:0px;width:100px;height:50px;z-index:9" strokecolor="blue" strokeweight="1">' +
                '<v:shadow on="T" type="single" color="#b3b3b3" offset="5px,5px"/>' +
                '<v:extrusion on="false" backdepth="20" />' +
                '<v:fill type="gradient" color="white" color2="white" />' +
                '<v:TextBox inset="5pt,10pt,5pt,5pt" style="text-align:center; color:blue; font-size:9pt;">示例</v:TextBox>' +
              '</v:shape>';
_SHAPE["diamond"]["val"] =
              '<v:shape type="#diamond" id="{id}" title="{title}" sc="{sc}" fsc="{fsc}" st="{st}" typ="Proc" style="position:absolute;width:{w};height:{h};left:{l};top:{t};z-index:{z}" strokecolor="{sc}" strokeweight="{sw}" ondblclick=\'editProc(this.id);\'>' +
              '  <v:shadow on="{shadowenable}" type="single" color="{shadowcolor}" offset="5px,5px"/>' +
              '  <v:extrusion on="{3denable}" backdepth="{3ddepth}" />' +
              '  <v:fill type="gradient" color="{sc1}" color2="{sc2}" />' +
              '  <v:TextBox id="{id}Text" inset="2pt,10pt,2pt,5pt" style="text-align:center; color:{tc}; font-size:{fs};">{text}</v:TextBox>' +
              '</v:shape>';

//直线
_SHAPE["line"]["demo"] = 
              '<v:line id="demoLine" title="直线" style="z-index:0;position:relative;" from="0,0" to="100,0" strokecolor="blue" strokeweight="1">' +
                '<v:stroke id="demoLineArrow" StartArrow="" EndArrow="Classic"/>' +
                '<v:TextBox inset="5pt,1pt,5pt,5pt" style="text-align:center; color:blue; font-size:9pt;"></v:TextBox>' +
              '</v:line>';
_SHAPE["line"]["val"] = 
              '<v:line id="{id}" title="{title}" sc="{sc}" fsc="{fsc}" typ="Step" style="z-index:{z};position:absolute;" {pt} strokecolor="{sc}" strokeweight="{sw}" onmousedown=\'objFocusedOn(this.id);\' ondblclick=\'editStep(this.id);\'>' +
                '<v:stroke id="{id}Arrow" StartArrow="{sa}" EndArrow="{ea}"/>' +
                '<v:TextBox id="{id}Text" inset="5pt,1pt,5pt,5pt" style="text-align:center; color:blue; font-size:9pt;">{cond}</v:TextBox>' +
              '</v:line>';
//折线
_SHAPE["polyline"]["demo"] = 
              '<v:PolyLine id="demoPolyLine" title="折角线" filled="false" Points="0,20 50,0 100,20" style="z-index:0;position:relative;" strokecolor="blue" strokeweight="1">' +
                '<v:stroke id="demoPolyLineArrow" StartArrow="" EndArrow="Classic"/>' +
                '<v:TextBox inset="5pt,1pt,5pt,5pt" style="text-align:center; color:blue; font-size:9pt;"></v:TextBox>' +
              '</v:PolyLine>';

//带标签的折线
_SHAPE["polyline"]["val"] =
              '<v:PolyLine id="{id}" title="{title}" sc="{sc}" fsc="{fsc}" typ="Step" filled="false" Points="{pt}" style="z-index:{z};position:absolute;" strokecolor="{sc}" strokeweight="{sw}" onmousedown=\'objFocusedOn(this.id);\' ondblclick=\'editStep(this.id);\'>' + 
              '<v:stroke id="{id}Arrow" StartArrow="{sa}" EndArrow="{ea}"/>' + 
               // '<v:TextBox id="{id}Text" inset="5pt,1pt,5pt,5pt" style="text-align:center; color:blue; font-size:9pt;"></v:TextBox>' +
              '</v:PolyLine>'+
			  '<div id={lid} title="{desc}" style="width:{w};height:{h};overflow:hidden;position:absolute;top:{y};left:{x};font-size:12px;z-index:1;" onmousedown="objFocusedOn(\'{id}\');">{text}</div>';
//不带标签的折线 用于拖动联线(防止重复生成标签)
_SHAPE["polylinenolabel"]["val"] =
              '<v:PolyLine id="{id}" title="{title}" sc="{sc}" fsc="{fsc}" typ="Step" filled="false" Points="{pt}" style="z-index:{z};position:absolute;" strokecolor="{sc}" strokeweight="{sw}" onmousedown=\'objFocusedOn(this.id);\' ondblclick=\'editStep(this.id);\'>' + 
              '<v:stroke id="{id}Arrow" StartArrow="{sa}" EndArrow="{ea}"/>' + 
               // '<v:TextBox id="{id}Text" inset="5pt,1pt,5pt,5pt" style="text-align:center; color:blue; font-size:9pt;"></v:TextBox>' +
              '</v:PolyLine>';

//处理函数
function getShapeDemo(AName){
  return _SHAPE[AName.toLowerCase()]["demo"];
}

function getShapeVal(AName){
  return _SHAPE[AName.toLowerCase()]["val"];
}

function stuffShape(AStr, arr){
  var re = /\{(\w+)\}/g;
  return AStr.replace(re, function(a,b){return arr[b];}); 
}

//输出自定义图形
document.write('<v:shapetype id="diamond" coordsize="12,12" path="m 6,0 l 0,6,6,12,12,6 x e"/>');
