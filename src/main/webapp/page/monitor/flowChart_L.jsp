<%@ include file="/page/common/taglibs.jsp"%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.centit.sys.util.*" %>
<%@ page import="com.centit.monitor.service.ApplyManager,com.centit.monitor.service.PunishManager" %>
<%@ page import="com.centit.monitor.po.ApplyProcess,com.centit.monitor.po.PunishProcess" %>
<%@ page import="com.centit.monitor.po.ApplyResult,com.centit.monitor.po.PunishResult" %>
<%@ page import="com.centit.monitor.po.Apply,com.centit.monitor.po.Punish" %>
<%@ page import="java.util.*"%>
<%@ page import="com.centit.support.utils.StringBaseOpt"%>
<%@ page import="com.centit.support.utils.DatetimeOpt"%>
<%@ page import="com.centit.sys.service.CodeRepositoryUtil"%>


<html:html>
<head>
<%
	String item_id = request.getParameter("item_id");
	String internal_no = request.getParameter("internal_no");
	String systemType = request.getParameter("systemType");
	String org_id = request.getParameter("org_id");
	System.out.println("org_id:"+org_id);

	ApplyManager service;
	PunishManager pservice;
%>

<title>�ڲ������������̶Ա�ͼ</title>
<style>

.btnbegin {
	background-image: url(../images/bebackground.gif);
	height: 56px;
	width: 136px;
	padding-left: 1px;
	padding-right: 1px;
	padding-top: 2px;
	padding-bottom: 1px;
	font-size: 14px;
	font-weight: bold;
	border: 0px solid #666666;
	cursor: hand;
}
.hjcq{
  width:150px;cursor:hand;FONT-SIZE: 12px;COLOR: #000;LINE-HEIGHT: 21px;HEIGHT: 50px;background-color: #ff6969 ;border: 1px solid #000000;
}
.risknoresult{
 width:150px; cursor:hand; FONT-SIZE: 12px; COLOR: #000; LINE-HEIGHT: 21px; HEIGHT: 50px; background-color: #ffa100 ; border: 1px solid #000000;
}
.riskwithresult{
 width:150px; cursor:hand; FONT-SIZE: 12px; COLOR: #000; LINE-HEIGHT: 21px; HEIGHT: 50px; background-color: #ffffa6 ; border: 1px solid #000000;
}
.processid{
 width:150px; cursor:hand; FONT-SIZE: 12px; COLOR: #000; LINE-HEIGHT: 21px; HEIGHT: 50px; background-color: #FF0000 ; border: 1px solid #000000;
}
.standardProTime{
 width:150px; cursor:hand; FONT-SIZE: 12px; COLOR: #000; LINE-HEIGHT: 21px; HEIGHT: 50px; background-color: #ADADAD ; border: 1px solid #000000;
}
.accept_name{
 width:150px; cursor:hand; FONT-SIZE: 12px; COLOR: #000; LINE-HEIGHT: 21px; HEIGHT: 50px; background-color: #0099FF ; border: 1px solid #000000;
}
.normal{
 width:150px; cursor:hand; FONT-SIZE: 12px; COLOR: #000; LINE-HEIGHT: 21px; HEIGHT: 50px; background-color: #d2ebff ; border: 1px solid #000000;
}
.hjcqbj{
 FONT-SIZE: 12px;background-color:#fbf4f7;
}
.risknoresultbj{
 FONT-SIZE: 12px;background-color:#fbfaf1;
}
.riskwithresultbj{
 FONT-SIZE: 12px;background-color:#fbfaf1;
}
.normalbj{
 FONT-SIZE: 12px;background-color:#f0f8ff;
}
.processidbj{
 FONT-SIZE: 12px;background-color:#f0f8ff;
}
.accept_namebj{
 FONT-SIZE: 12px;background-color:#f0f8ff;
}
.standardProTimebj{
 FONT-SIZE: 12px;background-color:#f0f8ff;
}

.FixedTitleRow {
	position: relative;
	top: expression(this . offsetParent . scrollTop);
	z-index: 10;
	background-color: #2D80D2;
	color: #fff;
	font-size: 12pt;
	text-align: center;
	font-weight: bold;
}

.FixedTitleColumn {
	position: relative;
	left: expression(this . parentElement . offsetParent . scrollLeft);
}

.FixedDataColumn {
	position: relative;
	left: expression(this . parentElement . offsetParent . parentElement .
		scrollLeft);
	background-color: #E6ECF0;
}
</style>
	<link rel="stylesheet" type="text/css" 	href="<%=session.getAttribute("css")%>/css/index.css">
	<link href="../styles/default/css/lightbox.css"	type="text/css" rel="stylesheet" media="screen">
	<script type="text/javascript" src="../js/prototype.js"></script>
	<script src="../js/lightbox.js" type="text/javascript"></script>
    <script type="text/javascript" src="../js/scriptaculous.js?load=effects"></script>
    <body>
	<br>
	<div id="scrollDiv" style="width: 100%; overflow: auto; cursor: default; display: inline;
         position: absolute; height: 95%">
<%if(systemType.equals("apply")) {%>
            <%
            	Apply appinfo = (Apply) request.getAttribute("apply");                      	
				//List appRocessList = service.getApplyProcessWithJXList(item_id,internal_no,org_id);
				//ApplyResult appResult = service.getApplyResultInfo_(item_id,internal_no);
            %>
        <table id="DataTable" width="100%" cellpadding="0" cellspacing="0"  rules="cols"  style="margin-left: 5px;line-height: 20px;padding: 5px;width: 98%;text-align: center;font-size: 12px;border: 0px solid #CCCCCC;">
		<tr>
            <TD  style="color: #ff6699;padding:0px" valign="top">
            <div>
            <br>           
            <table width="100%"  border="0" cellpadding="0" cellspacing="0">
				<tr >
					<td align="right" width="17%" style="FONT-SIZE: 12px;">
					&nbsp;����״̬:
					</td>
					<td align="left" colspan=3 style="FONT-SIZE: 12px;">
					     <!-- 
					    <font color="#ff6969">��</font>�����ѳ���
					     -->
					    <font color="#ffa100">��</font>���ڷ��յ������ڿش�ʩ
						<font color="#ffffa6">��</font>���ڴ��ڷ��յ�
						<font color="#d2ebff">��</font>��������
					<br>
					</tr>
					<tr >
					<td align="right" width="10%" style="FONT-SIZE: 12px;">
					&nbsp;����״̬:
					</td>
					<td align="left" colspan=3 style="FONT-SIZE: 12px;">
                      <font color="#196831">��</font>ͬ��ͨ��
                      <font color="#652899">��</font>����
                      <font color="#c8b805">��</font>��ͣ
                      <font color="#ff7200">��</font>����
                      <font color="#2040ab">��</font>���ڴ���
                      <font color="#000000">��</font>�˻�
                      <font color="#a51c1c">��</font>��ֹ
					</td>
				</tr>
					<tr >
					<td align="right" width="10%" style="FONT-SIZE: 12px;">
					&nbsp;�����쳣:
					</td>
					<td align="left" colspan=3 style="FONT-SIZE: 12px;">
                      <font color="#FF0000">��</font>�����ڷǷ�
                      <font color="#ADADAD">��</font>����ʱ�޲���ȷ
                      <font color="#0099FF">��</font>���ڰ�����Ա����ȷ
              
					</td>
				</tr>
				<tr ALIGN="CENTER">
				<td colspan=4 ><br><font color="red">ÿ�����ڿ��Ե���鿴��ϸ��Ϣ</font><br><br></td>
				</tr>	
				<tr ALIGN="CENTER">
				  <td width="10%"></td>
					<td>
						<input type="button"  class="btnbegin"  value="      ��ʼ      " />
					</td>
					 <td width="8%"></td>
					<td width="50%" align="left" style="FONT-SIZE: 12px;">���������ƣ�${punish.punishTarget}<br>
					����ʱ�䣺<fmt:formatDate value='${punish.ajOccurDate}' pattern='yyyy-MM-dd HH:mm:ss' />
					<br><div title="${punish.content}">������ƣ�${punish.content}</div>
					</td>
				</tr>
				<tr ALIGN="CENTER">
				<td width="10%">
					<td><img src="${pageContext.request.contextPath}/images/jt1.gif" alt="">
					</td>
				</tr>
				<%
					List<ApplyProcess> applyProcessList = (List<ApplyProcess>) request.getAttribute("processList");
					ApplyProcess appRocess = new ApplyProcess();
					ApplyProcess appNextRocess = new ApplyProcess();
					Date processDate[] = new Date[applyProcessList.size()];
					
					for (int i = 0; i < applyProcessList.size(); i++) {
						appRocess = (ApplyProcess) applyProcessList.get(i);
						if(i-1 > 0 && i-1<applyProcessList.size())
						   appNextRocess = (ApplyProcess) applyProcessList.get(i-1);
						
						processDate[i] = appNextRocess.getProcessDate();
						
						String sqlCondition = "no=" + appRocess.getNo();
						String hotspotUrl = "applyProcess!view.do?" + sqlCondition;

				   int day = 0;
			
				   if(processDate[i] == null){
					   processDate[i] = appinfo.getApplyDate();
				   }
				
				   day = DatetimeOpt.calcSpanDays(processDate[i], appRocess.getProcessDate());
				   
				 	String className="";                 //��λ��ʾ��ʽ
				 	if(StringBaseOpt.isNvl(appRocess.getProcessID())){
				 		className="processid";
				 	}else if(!StringBaseOpt.isNvl(appRocess.getStandardProTime())&&appRocess.getPromise()!=null
				 	&& !appRocess.getStandardProTime().equals(appRocess.getPromise())){
				 		//System.out.println("test"+appRocess.getStandardProTime()+"----getPromise="+appRocess.getPromise());
				 		className="standardProTime";
				 	}else if(StringBaseOpt.isNvl(appRocess.getAcceptName())||(!StringBaseOpt.isNvl(appRocess.getAcceptName()) && appRocess.getAcceptName().indexOf(appRocess.getUserName()) < 0)){
				 		className="accept_name";
				 	}
//				 	else if (btday > 0) {      
//				 	   className="hjcq";
//				 	}
				 	else if(appRocess.getIsRisk()!=null && appRocess.getIsRisk().equals("1") && StringBaseOpt.isNvl(appRocess.getRiskResult())){
				 	   className="risknoresult";
				 	}else if (appRocess.getIsRisk()!=null && appRocess.getIsRisk().equals("1") && !StringBaseOpt.isNvl(appRocess.getRiskResult())) {
				 	   className="riskwithresult";
				 	}else {
				 	   className="normal";
				 	}
				   //System.out.println("day: "+day+" btday: "+btday+" standerd: "+String.valueOf(stardardTime) +" className= "+className);
				 %>
				<tr ALIGN="CENTER">
				 <td width="10%"></td>
					<td>
						<input type="button" class="<%=className%>"   value="   <%=appRocess.getTacheName()%>   "  onclick="shownDetail('<%=hotspotUrl%>')"/>
					</td>
					
					<td width="15%" class="<%=className%>bj" ></td>
					<td align="left" class="<%=className%>bj">
					<%if(StringBaseOpt.isNvl(appRocess.getTitle())){%>
					<font color="red">���������Ʋ�����</font>
					<%} %>
					<br>������Ա��<%=appRocess.getUserName()%>
					<br>����ʱ�䣺<%=appRocess.getProcessDate().toLocaleString() %>
					<%
					String type = CodeRepositoryUtil.getDataPiece("Promise_Type",appRocess.getPromiseType()) == null ? "" :CodeRepositoryUtil.getDataPiece("Promise_Type",appRocess.getPromiseType()).getDatavalue();
					%>
					<br>����ʱ����<%=day<=0?"һ��֮��":day+type %>
					<br>��ŵ����:
					

					
					<%=appRocess.getPromise()%>������
				
					
			
					</td>
				</tr>
				

				<tr  >
				 <td width="10%"></td>
					<td  style="FONT-SIZE: 12px;" >
	                <div>
	                <%
	                    String jtGif="jt"+appRocess.getStatus()+".gif";       //��ͷ��ʾ��ʽ
	                   	                 %>
					<table  width="100%"><tr ><td width="56%" align="right">
						<img src="${pageContext.request.contextPath}/images/<%=jtGif %>" alt="">
					</td>
					<td width="15%"></td>
					<td align="left"></td>
					</tr>
					</table>
		         	</div>
					</td>
				</tr>
				<%
				}
				%>
              <%
              ApplyResult appResult = (ApplyResult) request.getAttribute("result");
              if (appResult != null) {
              %>

				<tr ALIGN="CENTER">
				 <td width="10%"></td>
					<td>
						<input type="button"  class="btnbegin"  value="      ����      " />
					</td>
				 <td width="10%"></td>
					<td align="left" style="FONT-SIZE: 12px;">				
						��������<%=appResult.getStatusText()%><br>
						��������<%=appResult.getNote()%>
					</td>
				</tr>
				<%
				}
				%>
			  </table>
			  </div>
			</TD>
			</tr>
		</table>
		<%}else{ %>
		<table id="DataTable" width="100%" cellpadding="0" cellspacing="0"  rules="cols"  style="margin-left: 5px;line-height: 20px;padding: 5px;width: 98%;text-align: center;font-size: 12px;">
		 <tr ALIGN="CENTER">
            <TD  style="color: #ff6699;padding:0px" valign="top">
            <div>
            <br>
		     <table width="100%"  border="0" cellpadding="0" cellspacing="0">
				<tr >
					<td align="right" width="17%" style="FONT-SIZE: 12px;">
					&nbsp;��λ״̬:
					</td>
					<td align="left" colspan=3 style="FONT-SIZE: 12px;">
					    <font color="#ffa100">��</font>���ڷ��յ������ڿش�ʩ
						<font color="#ffffa6">��</font>���ڴ��ڷ��յ�
						<font color="#d2ebff">��</font>��������
					<br>
					</tr>
					<tr >
					<td align="right" width="10%" style="FONT-SIZE: 12px;">
					&nbsp;����״̬:
					</td>
					<td align="left" colspan=3 style="FONT-SIZE: 12px;">
                      <font color="#196831">��</font>ͨ��
                      <font color="#c8b805">��</font>��ͣ
                      <font color="#2040ab">��</font>���ڴ���
                      <font color="#000000">��</font>�˻�
                      <font color="#a51c1c">��</font>��ֹ
					</td>
				</tr>
				<tr >
					<td align="right" width="10%" style="FONT-SIZE: 12px;">
					&nbsp;�����쳣:
					</td>
					<td align="left" colspan=3 style="FONT-SIZE: 12px;">
                      <font color="#FF0000">��</font>�����ڷǷ�
                      <font color="#ADADAD">��</font>����ʱ�޲���ȷ
                      <font color="#0099FF">��</font>���ڰ�����Ա����ȷ
              
					</td>
				</tr>
				<tr ALIGN="CENTER">
				<td colspan=4 ><br><br><br></td>
				</tr>	
				<tr ALIGN="CENTER">
				<td width="10%"></td>
					<td>
						<input type="button"  class="btnbegin"  value="      ��ʼ      " />
					</td>
					<td width="15%"></td>
					<td width="50%" align="left" style="FONT-SIZE: 12px;">���������ˣ�${punish.punishTarget}<br>
					����ʱ�䣺<fmt:formatDate value='${punish.ajOccurDate}' pattern='yyyy-MM-dd HH:mm:ss' />
					<br>������ƣ�${punish.content}
					</td>
				</tr>
				<tr ALIGN="CENTER">
				<td width="10%"></td>
					<td><img src="${pageContext.request.contextPath}/images/jt1.gif" alt=""></td>
				<td width="15%"></td>	
				</tr>
				
				<%
					List<PunishProcess> punRocessList = (List<PunishProcess>) request.getAttribute("processList");
					PunishProcess punRocess = new PunishProcess();
					String data[] = new String[punRocessList.size()];
					for (int i = 0; i < punRocessList.size(); i++) {
						punRocess = (PunishProcess) punRocessList.get(i);
						data[i] = punRocess.getProcessDate().toLocaleString();
						
						String sqlCondition = "no=" + punRocess.getNo();
						String hotspotUrl = "punishProcess!view.do?" + sqlCondition;
						String className="";
						if(StringBaseOpt.isNvl(punRocess.getProcessID())){
					 		className="processid";
					 	}else if(StringBaseOpt.isNvl(punRocess.getAcceptName())||(!StringBaseOpt.isNvl(punRocess.getAcceptName()) && punRocess.getAcceptName().indexOf(punRocess.getUserName()) < 0)){
					 		className="accept_name";
					 	}else if(!StringBaseOpt.isNvl(punRocess.getStandardProTime())&& punRocess.getPromise()!=null
					 	&&(!punRocess.getStandardProTime().equals(punRocess.getPromise()))){
					 		className="standardProTime";
					 	}else  if(punRocess.getIsRisk()!=null && punRocess.getIsRisk().equals("1") && StringBaseOpt.isNvl(punRocess.getRiskResult())){
					 	   className="risknoresult";
					 	}else if (punRocess.getIsRisk()!=null && punRocess.getIsRisk().equals("1") && !StringBaseOpt.isNvl(punRocess.getRiskResult())) {
					 	   className="riskwithresult";
					 	}else{
					 	   className="normal";
					 	}
				%>
				
				<tr ALIGN="CENTER">
				<td width="10%"></td>
				  
					<td>
						<input type="button" class="<%=className %>" title="<%=punRocess.getTacheName() %>"  value="<%=punRocess.getTacheName() %>"  onclick="shownDetail('<%=hotspotUrl %>')"/>
					</td>
					<td width="15%" class="<%=className%>bj" ></td>
					<td align="left" class="<%=className%>bj" width="30%" >
					<%if(StringBaseOpt.isNvl(punRocess.getTitle())){%>
					<font color="red">���������Ʋ�����</font>
					<%} %>
					<br>�����Ա��<%=punRocess.getUserName()%><br>����ʱ�䣺<%=punRocess.getProcessDate().toLocaleString() %>
					</td>
				</tr>
				
				
				<tr >
				<td width="10%"></td>
					<td>
					<div>
					<%
	                    String status=punRocess.getStatus();
	             
	                    String jtGif="jt"+status+".gif";
	                 %>
					<table  width="100%"><tr ><td width="56%" align="right">
						<img src="${pageContext.request.contextPath}/images/<%=jtGif %>" alt="">
					</td>
					<td width="15%"></td>
					<td align="left">	
					
					</td>
					</tr>
					</table>
		         	</div>
					</td>
				</tr>
				
			  <%}%>
              <%PunishResult punishResult = (PunishResult) request.getAttribute("result");
                if ( punishResult != null ) {%>
              
				<tr ALIGN="CENTER">
				<td width="10%"></td>
					<td>
						<input type="button"  class="btnbegin"  value="      ����      " />
					</td>
					<td width="15%"></td>
					<td align="left" style="FONT-SIZE: 12px;">�������ࣺ${cp:MAPEXPRESSION("punishType", result.punishClass)}<br>
					����ִ�н����${result.punishResult}
					</td>
				</tr>
				<%
				}
				%>
				
			  </table>
			  </div>
			</TD>
			</tr>
		</table>
		<%} %>
	</div>
</body>
<script language="JavaScript" type="text/JavaScript">
function shownDetail(HotspotUrl){
   if(HotspotUrl==''){
    return;
  }else{
	
	window.open(HotspotUrl);
  }
}
</script>

</html:html>
