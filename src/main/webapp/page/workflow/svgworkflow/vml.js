//==============================
//--本程序由许剑伟开发
//--名称：VML作图工具包
//--功能：实现IE作图及动画
//--于莆田十中
//--最后修改原因:优化
//--2006.11
//==============================
//document.write('<html xmlns:v="urn:schemas-microsoft-com:vml">');//定义名称空间
//document.write('<div style="display:none">a</div>'); //用户的网页可能什么元素都没有,这时IE5不会显示画布(最少要有body标记),所以加入隐藏数据
//document.createStyleSheet().cssText="v\\:*{behavior:url(#default#VML)}"; //连接样式表
var m_pi=3.1415926535897932384;
var ht= { //画图
  cname: "",           //当前要画的对象的名称
  speed:1,             //速度控制,speed大速度小
  qb:{fillcolor:"#FF0000",filled:"true",stroked:"true",strokecolor:"#00cc00",strokeweight:"1px",strokestyle:"solid"}, //默认铅笔
  setzbx:function(el,cd,sx,sy){ //复制坐标系参数,用于shape和group容器等,标fx和fy为坐放缩比例
    el.coordsize=cd; //coordsize指网格数(网格密度)
    this.resize(el,sx,sy);
  },
  setzbxP:function(el){ //使用与父坐标系相同的坐标系
    var cd=this.canvas.coordsize;
    var cs=String(cd).split(",");
    this.setzbx(el,cd,cs[0],cs[1]);
  },
  Vel:function(s){return document.createElement('<v:'+s+'/>');}, //创建一个vml元素
  ABSel:function(s){return this.Vel(s+' style="position:absolute"');}, //创建一个绝对定位的vml元素
  INSel:function(el,el2,name){ //在el中内插元素el2并取名为name
    el.insertBefore(el2); //XML的方法
    el2.style.zIndex--; el2.style.zIndex++; //多画布中el插入后,当前容器(画布)不一定收到refresh()事件,主动改变显示层让它刷新
    if(!el.els) el.els=new Array();
    if(name==""){ el.els[el.els.length]=el2; }
    else el.els[name]=el2;
  },
  Ael:function(el,name){//给el增加一个指定类型的元素
    var s;
    if(el.els){ if(el.els[name]) return el.els[name]; }
    if(name=="xx"||"arr") s='stroke'; //线类型元素或箭头
    if(name=="txt") s='textBox  inset="5px,5px,5px,5px" style="font-size:12px"'; //文本;position:absolute
    if(name=="sh")  s='shadow on="T" type="single" color="#b3b3b3" offset="5px,5px"'; //阴影
    if(name=="ext") s='extrusion on="True" color="red" rotationangle="0,0"'; //立体图形
    if(name=="fill")s="fill";
    var el2=this.Vel(s); this.INSel(el,el2,name); return el2;
  },
  getchild:function(el,ind){ var c=el.els; if(c&&ind&&c[ind]) return c[ind]; return 0;}, //子元素是否存在,存在则取出
  getch:function(){return this.getchild(this.canvas,this.cname);},
  clsg:function(lq){if(!lq) return; lq.innerHTML=""; lq.els=new Array();}, //清空容器
  cls:function(){ this.clsg(this.canvas); },//清空当前画布内容
  //以下几个是元素位置控制
  getpos:function(el){ //取元素的位置及大小信息
    var z=Array();
    z.x=String(el.style.left).replace(/[^0-9]/g,"")-0;
    z.y=String(el.style.top).replace(/[^0-9]/g,"")-0;
    z.w=String(el.style.width).replace(/[^0-9]/g,"")-0;
    z.h=String(el.style.height).replace(/[^0-9]/g,"")-0;
    return z;
  },
  zindex:function(el,index){ el.style.zIndex=index; }, //改变叠放次序
  setopa:function(el,b)    { var c=ht.Ael(el,"fill"); c.opacity=b;}, //改变对象透明度
  setcol:function(el,c1,c2){ var c=ht.Ael(el,"fill"); c.color=c1,c.color2=c2;}, //改变对象透明度
  resize:function(el,w,h)  { el.style.width=Math.round(w)+'px', el.style.height=Math.round(h)+'px'; }, //改变对象大小
  moveto:function(el,x,y)  { el.style.left=Math.round(x)+'px',  el.style.top=Math.round(y)+'px'; },    //移动对象到x,y
  movedx:function(el,dx,dy){ var z=ht.getpos(el); ht.moveto(el,z.x+dx,z.y+dy); }, //移动对象,移动距离为dx,dy
  //以下几个push_...函数为push专用
  push_Ael:   function(name) {return ht.Ael(this,name);},
  push_moveto:function(x,y)  {ht.moveto(this,x,y);},
  push_resize:function(w,h)  {ht.resize(this,w,h);},
  push_zindex:function(z)    {ht.zindex(this,z);},
  push_cls   :function()     {ht.clsg(this);},
  //以下几个是作图函数
  push:function(el,f,can,cm){ //在容器中创建元素,f为1则设置画笔
    if(f){ //设置元素铅笔
      el.fillColor   =this.qb.fillcolor;   //填充色
      el.filled      =this.qb.filled;      //是否填充
      el.stroked     =this.qb.stroked;     //是否有线条
      el.strokeColor =this.qb.strokecolor; //线颜色
      el.strokeWeight=this.qb.strokeweight;//线宽度
      this.Ael(el,"xx").dashstyle=this.qb.strokestyle; //插入线类型元素
    }
    el.Ael=ht.push_Ael; el.moveto=ht.push_moveto; el.resize=ht.push_resize;
    el.cls=ht.push_cls; el.zindex=ht.push_zindex;
    if(!can) can=this.canvas,cm=this.cname,this.cname="";
    if(can!="none") this.INSel(can,el,cm);
  },
  initgp:function(can,posi,cd,w,h){ //初始化画布
    this.setzbx(can,cd,w,h);
    can.style.position=posi;
    this.push(can,0,"none"); return can;
  },
  group:function(x,y){//创建容器，参数:位置
    var el=this.ABSel('group');
    this.moveto(el,x,y);
    this.setzbxP(el);
    this.push(el,0); return el;
  },
  line:function(x1,y1,x2,y2){ //画线
    var el=this.ABSel('line');
    el.from=Math.round(x1)+","+Math.round(y1);
    el.to  =Math.round(x2)+","+Math.round(y2);
    this.push(el,1); return el;
  },
  polyLine:function(points) { //画折线
    var el=this.ABSel('polyline');
    el.points=points;
    this.push(el,1); return el;
  },
  //p_..几个函数为shape中路径处理专用函数
  p_cls:function(){this.phs=new Array();}, //清空路径缓存
  p_moveto:function(x,y){var c=this.phs,n=c.length; c[n++]="=m=",c[n++]=Math.round(x),c[n++]=Math.round(y);},
  p_lineto:function(x,y){var c=this.phs,n=c.length; c[n++]="=l=",c[n++]=Math.round(x),c[n++]=Math.round(y);},
  p_arc:function(x,y,sx,sy,jd1,jd2){ //圆弧
    jd1=Math.round(jd1*65536),jd2=Math.round(jd2*65536); sx=Math.round(sx/2),sy=Math.round(sy/2);
    var c=this.phs,n=c.length; c[n++]="=al=";
    c[n++]=Math.round(x+sx),c[n++]=Math.round(y+sy); //中心
    c[n++]=sx,c[n++]=sy; //半径
    c[n++]=jd1; c[n++]=jd2; //角度
  },
  p_oval:function(x,y,sx,sy){this.p_arc(x,y,sx,sy,0,360);}, //圆
  p_cmd:function(s,x,y,fw,fh,jd){ //s为命令串或数组,参数s必须,其它参数是一组参数,可选
    var i,k,c=this.phs,n=c.length;
    var k1=0; if(ht.isdef(x)) k1=1;
    var cos,sin; if(jd){jd*=m_pi/180; cos=Math.cos(jd); sin=Math.sin(jd);} //旋转
    s=ht.toarr(s);
    for(i=0,k=0;i<s.length;i++){
      if(ht.isphcmd(s[i])) s[i]="="+s[i]+"=";
      else {
        if(k) k=0; else k=1;
        if(k1){ //位置及放缩
          if(k&&jd) { var vx=s[i]*cos-s[i+1]*sin; s[i+1]=s[i]*sin+s[i+1]*cos,s[i]=vx; }//旋转
          if(k) s[i]=s[i]*fw+x; else s[i]=s[i]*fh+y;
        }
        s[i]=Math.round(s[i]);
      }
      c[n++]=s[i];
    }
  },
  p_save:function(){ //保存路径
    var s=this.phs.toString();
    s=s.replace(/,=|=,/g," ");
    s=s.replace(/=/g,"")+" e";
    this.path=s; return s;
  },
  shape:function(path){ //画任意图形
    var el=this.ABSel('shape');
    this.setzbxP(el); //此行必须,否则不显示
    el.path=path;

    el.phs=this.toarr(path); if(!path) el.phs.length=0;
    el.p_moveto=ht.p_moveto;
    el.p_lineto=ht.p_lineto;
    el.p_arc=ht.p_arc;
    el.p_oval=ht.p_oval;
    el.p_cmd=ht.p_cmd;
    el.p_save=ht.p_save;
    el.p_cls=ht.p_cls;

    this.push(el,1); return el;
  },
  rect0:function(x,y,sx,sy,na){//创建(画)矩形,na为RoundRect时画圆角矩形
    var el=this.ABSel(na);
    if(sx<0) x+=sx,sx=-sx; if(sy<0) y+=sy,sy=-sy; //检查参数
    this.moveto(el,x,y); this.resize(el,sx,sy);//设置矩形位及大小
    this.push(el,1); return el;
  },
  text:function(x,y,sx,sy,txt){ //输出文本
    var el=this.ABSel('shape');
    this.setzbx(el,"1,1",1,1);
    var el2=this.ABSel('textBox inset="0px,0px,0px,0px" style="font-size:12px"');
    this.INSel(el,el2,"txt");
    this.push(el,0);
    el.set=function(x,y,sx,sy,txt){ this.moveto(x,y); this.resize(sx,sy); this.els.txt.innerHTML=txt; };
    el.set(x,y,sx,sy,txt);
    return el;
  },
  rect: function(x,y,sx,sy)     { return this.rect0(x,y,sx,sy,"rect"); }, //画矩形
  oval: function(x,y,sx,sy)     { return this.rect0(x,y,sx,sy,"oval"); }, //画圆形
  img:  function(x,y,sx,sy,src) { return this.rect0(x,y,sx,sy,'image src="'+src+'"'); }, //载入图片
  rrect:function(x,y,sx,sy,arc) { return this.rect0(x,y,sx,sy,"roundrect arcsize="+arc); },    //画圆角矩形,arcsize为圆角半径
  arc:  function(x,y,sx,sy,a,b) { return this.rect0(x,y,sx,sy,'arc startAngle="'+a+'" endAngle="'+b+'"'); }, //圆弧
  point:function(x,y,s){ var el=this.oval(x-s/2,y-s/2,s,s); el.fillcolor=this.qb.strokecolor; return el; },//画点
  //以下几个是组合作图
  bse:function(points)  { return this.shape(this.toqx(points,'q')); }, //二阶贝赛尔曲线
  curve:function(points){ return this.shape(this.toqx(points,'c')); }, //三点曲线法6n个参数
  pLine:function(points){ return this.shape(this.toqx(points,'z')); }, //折线
  textbox:function(x,y,sx,sy,txt){ //文本框
    var el=this.rect(x,y,sx,sy); //先画矩
    this.Ael(el,"txt").innerHTML=txt;
    return el;
  },
  axis:function(x0,y0,tx,ty,h,z,as){ //画坐标轴(当坐标被重画时不创建新对象)
    if(!z.en){
      var c=this.canvas.els,sn=as.length;
      for(var na in c){ if(na.substr(0,sn)==as) c[na].style.display="none"; }
      return;
    }
    z.r1tg=-z.r1*z.tg; z.r2tg=z.r2*z.tg;//坐标数值尺度,画坐标时用不上
    var i,jd=m_pi/180*z.jd,sin=Math.sin(jd),cos=Math.cos(jd);
    var n1=Math.floor(z.r1),n2=Math.floor(z.r2);
    var g=z.g,r1=z.r1*g,r2=z.r2*g;
    var gx=g*cos,gy=g*sin,hx=h*sin,hy=h*cos;
    var x =x0-n1*gx, y =y0-n1*gy;  //第一描点坐标
    var x1=x0-r1*cos,y1=y0-r1*sin; //起点
    var x2=x0+r2*cos,y2=y0+r2*sin; //终点
    var x3=x2-hy,y3=y2-hx; //箭头点1
    var x4=x3-hy,y4=y3-hx; //箭头点2

    var wb,sh;
    this.cname=as+'sh'; sh=this.getch(); if(!sh) sh=this.shape(""); //创建坐标shape对象
    sh.p_cls(); sh.fillcolor=sh.strokecolor; //设置填充色
    sh.p_moveto(x1,y1); sh.p_lineto(x2,y2); //画轴
    sh.p_lineto(x4+hx,y4-hy); sh.p_lineto(x3,y3); //画箭头
    sh.p_lineto(x4-hx,y4+hy); sh.p_lineto(x2,y2); //画箭头
    for(i=-n1;i<=n2;i++,x+=gx,y+=gy){
      if(i||z.to) { sh.p_moveto(x+hx,y-hy); sh.p_lineto(x-hx,y+hy); }
      this.cname=as+i; wb=this.getch(); if(!wb) wb=this.text(0,0,0,0,"");
      if(z.t) wb.set(x+tx,y+ty,g,g,i*z.tg); //写刻点
      else wb.set(0,0,0,0,"");
    }
    this.cname=as+'ts'; wb=this.getch(); if(!wb) wb=this.text(0,0,0,0,"");
    wb=wb.set(x2+tx,y2+ty,g,g,z.ts);
    sh.p_save(); //保存到path
  },
  axisXYZ:function(c){//创建直角坐标系
    var gr=this.group(0,0); //创建容器
    if(!c){ //读默认数学坐标
      c={x0:0,y0:0,h:20,tx:20,ty:20, //描述直角坐标系
         x:{g:1,r1:4.2,r2:4.5,tg:1,ts:"x",t:1,en:1,to:0,jd:0},//to=1强制画o点的刻线,en=0禁用该轴
         y:{g:1,r1:4.2,r2:4.5,tg:1,ts:"y",t:1,en:1,to:0,jd:-90},
         z:{g:1,r1:4.2,r2:4.5,tg:1,ts:"z",t:1,en:0,to:0,jd:135}};
      var cd=this.canvas.coordsize; cd=String(cd).split(",");
      c.x.g=cd[0]/10; c.y.g=cd[1]/10; c.z.g=(c.x.g+c.y.g)/2; c.x0=cd[0]/2; c.y0=cd[1]/2;
    } 
    gr.zb=c;
    gr.zb_show=function(){
      var bcan=ht.canvas; ht.canvas=this;
      ht.axis(c.x0,c.y0,c.tx,c.ty,c.h,c.x,"zbx");
      ht.axis(c.x0,c.y0,c.tx,c.ty,c.h,c.y,"zby");
      ht.axis(c.x0,c.y0,c.tx,c.ty,c.h,c.z,"zbz");
      ht.canvas=bcan;
    };
    gr.zb_topm=function(x,y,z){return ht.topm(c,x,y,z);};
    gr.zb_show(); return gr;
  },
  topm:function(zb,x,y,z){//转为平面原始坐标
    if(!x) x=0; if(!y) y=0; if(!z) z=0;
    var i,jd,r,c,J=m_pi/180,v=new Array('x','y','z');
    var b={x:zb.x0,y:zb.y0,'0':x,'1':y,'2':z};
    for(i=0;i<3;i++){
      c=zb[v[i]]; if(!c||!c.en) continue;
      jd=c.jd*J; r=b[i]*c.g/c.tg;
      b.x+=r*Math.cos(jd); b.y+=r*Math.sin(jd);
    }
    b.x=Math.round(b.x); b.y=Math.round(b.y);
    zb.pm=b; return b;
  },
  //根据序列移动到序列中的下一点
  val12:function(v1,v2,bl,z){ v1-=0; v1+=(v2-v1)*bl; if(z) v1=Math.round(v1); return v1;},
  col12:function(c1,c2,bl){ //取二颜色间bl处的颜色
    c1=String(c1).replace(/[^0-9a-fA-F]/g,"");
    c2=String(c2).replace(/[^0-9a-fA-F]/g,"");
    var i,v1,v2,v,c="#";
    for(i=0;i<3;i++){
      v1=("0x"+c1.substr(i*2,2))-0, v2=("0x"+c2.substr(i*2,2))-0;
      v=Math.round(v1+(v2-v1)*bl);
      v=v.toString(16);
      if(v.length<2) c+="0"+v; else c+=v;
    }
    return c;
  },
  path12:function(s1,s2,bl){//取二路径间bl处的路径
    var s3=new Array(); //路径数组
    var i,v1,v2,jo=1,mx=Math.max(s1.length,s2.length);
    if(this.isphcmd(s1[0])){
      var s4="",s0="";
      for(i=0;i<mx;i++){
        if(this.isphcmd(s1[i])) v1=s1[i];
        else v1=this.val12(s1[i],s2[i],bl,1);
        if(i) s0+=" "+v1; else s0+=v1;
        if(i%15==1) s4+=s0,s0="";
      }
      return s4+s0;
    }
    for(i=0;i<mx;i++){
      if(jo==1) jo=2; else jo=1;
      if(i<s1.length) v1=s1[i]-0; else v1=s1[s1.length-jo];
      if(i<s2.length) v2=s2[i]-0; else v2=s2[s2.length-jo];
      s3[i]=this.val12(v1,v2,bl,1);
    }
    return s3.toString();
  },
  path12b:function(s,p,p2,bl){ //画线动画
    var i,c,s2=new Array();
    for(i=0;i<p+2;i++) s2[i]=s[i];
    for(i=0;i<2;i++) s2[p+i+2]=this.val12(s[p+i],s[p2+i],bl,1);
    return s2.toString();
  },
  p12:function(rs,na,k,lx){ //计算p1,p2在bl处的插值点的值,k为坐标参数的个数
    var i,c,r=rs[na],z=new Array(); z.n=0;
    if(!r) return z; 
    if(this.isstr(r)){if(na=="sh") r=this.toarr(r,';'); else r=this.toarr(r); rs[na]=r; }//串转数组
    if(!rs.n) rs.n=Math.round(r.length/k);  //关键点个数

    var p=rs.p*k,p2=p+k,bl=rs.cur/rs.cn;
    p%=r.length; p2%=r.length; //p1,p2越界则循环
    if(lx==0){ for(i=0;i<k;i++) z[i]=this.val12(r[p+i],r[p2+i],bl,0); } //计算插入点的值
    if(lx==1){ //路径,用于改变形状
      if(this.isstr(r[p]))  r[p]=this.toarr(r[p]);
      if(this.isstr(r[p2])) r[p2]=this.toarr(r[p2]);
      z[0]=this.path12(r[p],r[p2],bl);
    }
    if(lx==2) z[0]=this.col12(r[p],r[p2],bl); //填充色或线条色
    if(lx==3) { //填充属性
      z[0]=this.col12(r[p],r[p2],bl); //第一填充色
      z[1]=this.col12(r[p+1],r[p2+1],bl); //第二填色
    }
    if(lx==4) z[0]=this.path12b(r,p,p2,bl);
    z.n=z.length; return z;
  },
  setrp:function(r,p){ //设置指针
    r.p=p; if(r.p>=r.n) r.p=0; if(r.p<0) r.p=r.n-1;
    r.cn=1;  if(r.ext&&r.ext[r.p]) r.cn=r.ext[r.p]-0; //设置扩展点数
    r.cn2=1; if(r.rpn&&r.rpn[r.p]) r.cn=r.rpn[r.p]-0; //设置停止帧数
    if(r.mf==1) { r.cur=0, r.cur2=0; return; }
    r.cur=r.cn-1, r.cur2=r.cn2-1;
  },
  moverp:function(r){
    if(!r.cur){ r.cur2+=r.mf; if(r.cur2>=0&&r.cur2<r.cn2) return; }
    r.cur+=r.mf;
    if(r.cur>=r.cn||r.cur<0){
      this.setrp(r,r.p+r.mf);
      if(r.p==0) r.js+=r.mf; //重复运动次数计数
    }
  },
  movenext:function(el){ //移动到下一点
    var i,h,c,r=el.Rm; if(!r) return;
    if(!r.init){
       r.init=1,r.js=0,r.cur2=0,r.cur=0,r.tot=0; //r.js重复次数计数
       if(!r.offs) r.offs=0; //起始运动点
       if(!r.n) r.n=r.offs;
       if(!r.mf) r.mf=1; //播放方向
       if(!r.count) r.count=100000000; //表示重复数次数
       if(this.isstr(r.ext))   r.ext=this.toarr(r.ext);  //串转数组,扩展点数,含本点
       if(this.isstr(r.rpn))   r.rpn=this.toarr(r.rpn);  //串转数组,各点重复m帧
       this.setrp(r,r.offs);
    }
    if(Math.abs(r.js)>=r.count) return 0;
    r.tot+=r.mf; if(r.tot%this.speed) return 1; //速度控制
    if(r.mth) {
      var mre=r.mth(el);
      if(mre==1) return 1; //mth返回1表示独占动画,Rm中其它动画不运行
      if(mre=="end") return 0; //结束动画
    }
    h=this.p12(r,'ph',2,0);  if(h.n) this.moveto(el,h[0],h[1]);  //移动到下一点
    h=this.p12(r,'sh2',2,4); if(h.n) el.path=this.toqx(h[0],r.shx);//改变形状,对shape有效(曲线或折线),画线动画
    h=this.p12(r,'sz',2,0);  if(h.n) this.resize(el,h[0],h[1]);  //改变大小
    h=this.p12(r,'rt',1,0);  if(h.n) el.rotation=h[0];           //改变(旋转)角度
    h=this.p12(r,'sh',1,1);  if(h.n) el.path=this.toqx(h[0],r.shx);//改变形状,对shape有效(曲线或折线)
    h=this.p12(r,'fcol',1,2);if(h.n) el.fillcolor=h[0];          //改变填充色
    h=this.p12(r,'scol',1,2);if(h.n) el.strokecolor=h[0];        //改变线色
    h=this.p12(r,'swei',1,0);if(h.n) el.strokeweight=h[0];       //改变线宽
    h=this.p12(r,'opac',1,0);if(h.n) this.setopa(el,h[0]);       //改变透明度
    h=this.p12(r,'fill',2,3);if(h.n) this.setcol(el,h[0],h[1]);  //改变渐变填充色
    this.moverp(r);
    return 1;
  },
  //动画控制
  cm:new Array(),
  setmov:function(name,mth,sec){ //设置时钟参数:时钟名称,时间中断调用的函数名,中断调用间隔间(毫秒)
    this.stop(name);
    this.cm[name]=new Array();
    var c=this.cm[name]; c.name=name,c.mth=mth,c.sec=sec,c.on=0; return c;
  },
  start:function(name){ var c=this.cm[name]; if(!c||c.gr|| c.on)return; c.on=1; c.id=window.setInterval(c.mth,c.sec); },//启动时钟
  stop: function(name){ var c=this.cm[name]; if(!c||c.gr||!c.on)return; c.on=0; window.clearInterval(c.id);}, //停止时钟
  mov1mth:function(){ if(!ht.movenext(this.el)) ht.stop(this.name); }, //第1类动画方法,该方法不能用ht.mov1mth()调用,因为ht中没有定义所需的参数
  mov1:function(name,el,add){ //创建第1类组动画
    var c0=this.cm[name];
    if(!add){
      this.mov1delete(name); c0=new Array();
      c0.gr=1; c0.n=0; this.cm[name]=c0;
    }
    if(el.Rm&&!el.moved){
      var name2=name+"_"+c0.n;
      var sec=100; if(el.Rm.sec) sec=el.Rm.sec;
      var c=this.setmov(name2,'ht.cm.'+name2+'.mov()',sec);
      c.el=el; c.mov=this.mov1mth;
      c0.n++; el.moved=1;
    }
    if(!el.els) return;
    for(var na in el.els) this.mov1(name,el.els[na],1);
  },
  mov1delete:function(name){ this.mov1ctrl(name,"delete"); this.cm[name]=""; }, //移除动画
  mov1ctrl:function(name,cmd,gn){
    var c=this.cm[name]; if(!c) return; c.n-=0;
    for(var i=0;i<c.n;i++) {
      var na2=name+"_"+i;
      if(cmd=="start")  this.start(na2);
      if(cmd=="stop")   this.stop(na2);
      var c2=this.cm[na2]; if(!c2) continue;
      var el=c2.el; if(!el) continue;
      if(cmd=="delete"){ this.stop(na2); el.moved=0; this.cm[na2]="";}
      if(cmd=="reset") { el.Rm.init=0; el.Rm.offs=0; this.movenext(el); }
      if(cmd=="goto")  { el.Rm.init=0; el.Rm.offs=gn;this.movenext(el); }
      if(cmd=="next")  { this.movenext(el); }
      if(cmd=="pre")   { el.Rm.mf=-el.Rm.mf; this.movenext(c2.el); el.Rm.mf=-el.Rm.mf; }
    }
  },
  mov1start:function(name) { this.mov1ctrl(name,"start"); },//启动动画组
  mov1stop:function(name)  { this.mov1ctrl(name,"stop");  },//停止动画组
  mov1reset:function(name) { this.mov1ctrl(name,"reset"); },//复位
  mov1next:function(name)  { this.mov1ctrl(name,"next");  },//下一帧
  mov1pre:function(name)   { this.mov1ctrl(name,"pre");   },//上一帧
  mov1goto:function(name,n){ this.mov1ctrl(name,"goto",n);},//帧定位,请先确定r.n(总帧数)否则可能定位在第一点
  //工具函数
 clone:function(ob){ //对象复制
   var obj = new Object();
   for(var ns in ob){ //复制子对象
    if(typeof(ob[ns])=="object") obj[ns] = ht.clone(ob[ns]);
    else obj[ns]=ob[ns];
   }
   return obj;
 },
 isphcmd:function(cmd){
    var c=String(cmd).substr(0,1);
    if(c>="a"&&c<="z") return 1; else return 0;
  },
  isstr:function(s){if(s&&typeof(s)=="string") return 1; return 0;}, //判断是否为串
  isdef:function(s){if(typeof(s)=="undefined") return 0; return 1;}, //判断是定义
  toqx:function(points,qz){ //点序列转标准的曲线或折线序列,应用于shape
    if(!qz) qz='q';
    var s=String(points); s=s.replace(/[, ]+/g,",");
    var st=s.indexOf(",");st=s.indexOf(",",st+1);
    s=s.substr(0,st);
    if(qz=='q') return 'm '+s+' qb '+points+'r 0,0 e'; //qb内的坐标数应有奇数才可用e结束画线,否则以x结束(但返回到原点)
    if(qz=='z') return 'm '+s+' l '+points+' e'; //折线
    if(qz=='c') return 'm '+s+' c '+points+' e';
  },
  toarr:function(s,sp){ //序列转为数组
    if(sp) return String(s).split(sp);
    var s2=String(s).replace(/[ ,]+/g,",");
    if(s2.substr(0,1)==",") s2=s2.substr(1,s2.length-1); //去前导分隔符
    return s2.split(",");
  },
  tostr:function(arr){ return arr.toString(); } //序列数组转为串
};
/******************************************
范例：略
******************************************/

//============================
//--函数求值类(表达式解析)
//--2006.12.2—2006.12.3
//--许剑伟于莆田十中
//============================
function fxparse(s){
  var th=new Array();
  var m_kh=new Array("w",0,0); //插号的type,优先级,左右优先级
  var m_ch=new Array("s",3,0); //乘号的
  //开头三个字符为运算类型(目数)、优先级及左右优先次序,第二个字符不是数字说明该名称为别名
  var m_a="d51acot,arccot,actan,arcctan,actg,arcctg,  d51atan,arctan,arctg,atg,  d51asin,arcsin,d51acos,arccos,\
           d51sin,d51cos,d51sec,d51csc,d51tan,tg,d51ctan,ctg,cot,\
           d51sqrt,d51exp,d51log,ln,d51lg,d51abs,  s20+,s20-,s30*,s30/,s41^,\  w00(,[,{,w00),],}";
  m_a=m_a.replace(/ /g,"").split(",");
  //===============中间函数(过程)===============
  function islat(c){ if(c>="a"&&c<="z"||c>="A"&&c<="A") return 1; else return 0; } //是不字母
  function isnum(c){ if(c>="0"&&c<="9") return 1; else return 0; } //是不数字
  function isval(c){ if(isnum(c)||c==".") return 1; else return 0; } //判断某字符是否数值
  function push(th,k,name,v,lx,y,cs){ //压入,lx为类型,y为优先级,cs为左右优先顺序
    var b=new Array();
    if(k==-1) k=th.length;
    for(var i=th.length;i>k;i--) th[i]=th[i-1];
    th[k]=b; b.name=name,b.value=v-0,b.lx=lx,b.yxj=y-0,b.cs=cs-0;
  }
  function push2(th,k,name,p){ push(th,k,name,0,p[0],p[1],p[2]);} //压入,参数为数组
  function inskh(th,k,fx){ //插左或右括号,fx为正插入右括号,fx为负插入左括号
   var c,d=th[k],i,j,m;
   var k1=")",k2="(",dp=1,len=-1,cs; if(fx>0) k1="(",k2=")",dp=0,len=th.length;
   for(i=k+fx,m=0;i!=len;i+=fx){
     c=th[i];
     if(c.name==k1) m--;
     if(c.name==k2) m++;
     if(m<0) continue; if(m>0) break;
     if(c.lx=="val"||c.yxj>d.yxj||c.lx=='w') continue;
     cs=d.cs; if(fx<0) cs=!d.cs;
     if(c.yxj==d.yxj&&cs) continue; //左优先、右优先
     break;
   } push2(th,i+dp,k2,m_kh); //插入插号
  }
  function emys(v1,v2,ys){ //二目运算
   if(ys=="+") return v1+v2;
   if(ys=="-") return v1-v2;
   if(ys=="*") return v1*v2;
   if(ys=="/") return v1/v2;
   if(ys=="^") {//指数及幂函数
     if(v1>=0) return Math.pow(v1,v2);
     v1=-v1; if(v2<0) v2=-v2,v1=1/v1;
     var i,c,c1,cz,cy;
     var v=Math.pow(v1,v2); if(Math.floor(v2)%2>0.1) v=-v;
     var ys=v2%1; if(ys<1e-15) return v;
     for(i=0,c=1,c1=ys;i<10;i++){
       cz=Math.floor(c/c1+1e-15),cy=c-cz*c1; //整除运算
       if(cy<1e-15){ c1=Math.round(1/c1); c=Math.round(ys*c1); break; } //已整除
       c=c1,c1=cy;//余数是下一次的除数,除数是下一次的被除数
     }
     if(c%2<0.1) return v;
     if(c1%2>0.1) return -v;
   }
   return NaN;
  }
  function dmys(v,ys){ //单目运算
   if(ys=="sin")  return Math.sin(v);    if(ys=="cos")  return Math.cos(v);
   if(ys=="tan")  return Math.tan(v);    if(ys=="ctan") return 1/Math.tan(v);
   if(ys=="asin") return Math.asin(v);   if(ys=="acos") return Math.acos(v);
   if(ys=="atan") return Math.atan(v);   if(ys=="acot") return Math.atan(1/v);
   if(ys=="sec")  return 1/Math.sin(v);  if(ys=="csc")  return 1/Math.cos(v);
   if(ys=="sqrt") return Math.sqrt(v);   if(ys=="exp")  return Math.exp(v);
   if(ys=="log")  return Math.log(v);    if(ys=="lg")   return Math.log(v)/Math.log(10);
   if(ys=="abs")  return Math.abs(v);
   if(ys=='+') return v; //特殊单目
   if(ys=='*') return v;
   if(ys=='-') return -v;
   if(ys=='/') return 1/v;
   if(ys=='^') return 1;
   return 0;
  }
  //===========初始化函数=================
  th.setfx=function(s){
   var i,j,d,f,f1,f2,f3,c,c2;
   if(th.s==s) return;
   th.s=s; th.length=0;
   for(i=0;i<s.length;){ //基本运算符判断
    for(j=0;j<m_a.length;j++){ //识别运算符
     d=m_a[j];
     if(isnum(d.substr(1,1))){f1=d.substr(0,1); f2=d.substr(1,1); f3=d.substr(2,1); f=d.substr(3,d.length-3); d=f;}
     if(s.indexOf(d,i)==i)   {push(th,-1,f,0,f1,f2,f3); i+=d.length; break;} //运算符及目数
    } if(j<m_a.length) continue;
    c=s.substr(i,1);
    if(isval(c)){ //识别数字
     for(i++;i<s.length;i++){ c2=s.substr(i,1); if(isval(c2)) c+=c2; else break; }
     push(th,-1,"_",c,"val",0,0); continue;
    }
    if(islat(c)){ //识别变量
     for(i++;i<s.length;i++){ c2=s.substr(i,1); if(islat(c2)||isnum(c2)) c+=c2; else break; }
     push(th,-1,c,0,"val",0,0);   continue;
    }
    i++;
   }
   for(i=0;i<th.length-1;i++){ //给两个连续的变量或常量加上乘号
    if(th[i].name==")"||th[i].lx=="val")
      if(th[i+1].name=="("||th[i+1].lx=="val"||th[i+1].lx=="d") push2(th,i+1,"*",m_ch);
   }
   for(i=0;i<th.length;i++){ //给每个运算加上一对括号
    if(th[i].lx=="val"||th[i].lx=="w") continue;
    inskh(th,i,1); 
    inskh(th,i,-1); i++; //插左时,i应加1
   }
   th.setvar("pi",3.1415926535897932384);
   th.setvar("e", 2.7182818284590452353);
  };
  //==========求值方法(成员函数)================
  th.setvar=function(name,value){ //设置变量
   if(typeof(value)=="undefined") return;
   if(value=="none"||value+""=="") return;
   for(var i=0,c;i<th.length;i++)
    {c=th[i]; if(c.name==name&&c.lx=="val") c.value=value-0;}
  };
  th.js=function(n,n2){ //求值函数
   if(typeof(n)=="undefined") n=0,n2=th.length-1;
   var dn=n2-n; if(dn<0) return 0;
   var i,v,c=th[n]; if(!c) return 0;
   if(!dn) return c.value;
   if(c.lx=='w'){ //括号
     for(i=n,v=0;i<=n2;i++){ //去括号并算出v
       if(th[i].name=="(") v++;
       if(th[i].name==")") v--;
       if(!v) break;
     } v=th.js(n+1,i-1);
     if(n2-i<2) return v;
     return emys(v,th.js(i+2,n2),th[i+1].name);
   }
   if(c.lx=="val"){ //值(常量或变量),进行二目运算
     if(dn<2) return c.value;
     return emys(c.value,th.js(n+2,n2),th[n+1].name);
   }
   if(c.lx=='d'||c.lx=='s') return dmys(th.js(n+1,n2),c.name);//进行单目运算
   return 0;
  };
  th.f=function(x,y,z){ th.setvar("x",x); th.setvar("y",y); th.setvar("z",z); return th.js(); };
  th.getjx=function(){ //取解析串(非必要函数)
   var i,c,s="",s2;
   for(i=0;i<th.length;i++) {
    c=th[i];
    if(c.name=="_") s2=c.value; else s2=c.name;
    if(c.lx=="d") s+="<b><i>"+s2+"</i></b>"; else s+=s2;
   } return s;
  };
  //===========对象返回=================
  th.setfx(s);
  return th;
}
//================范例:==========================
//a=new fxy("2log(x)+4"); //创建函数
//a.setvar("x",2);        //设置变量的值
//c=a.js();  if(isNaN(c)) c="计算错误！"; //计算函数值
//document.write(c+"<br>"+a.getjx()); //输出
//a.f(x);//也是函数求值
//===============================================

function Ym(){ //取页面模板
  var ob=Ym.arguments;//用arguments函数属性处理变参
  var i,s,s2,erg,ret;
  var mb=document.all.muban; if(!mb||!ob.length) return;
  if(!mb.Yms){ //导入模板
    mb.Yms=new Array();
    s=String(mb.innerHTML).split("###");
    for(i=0;i<s.length;i++){
     if(!s[i]) continue;
     s2=s[i].split("::");
     mb.Yms[s2[0]]=s2[1];
    }
  }
  ret=mb.Yms[ob[0]];
  for(i=1;i<ob.length;i++){
    erg=new RegExp("\\$s"+i+"\\$",["g"]); //即/\$s1\$/g
    ret=ret.replace(erg,ob[i]);
  }
  return ret;
}

