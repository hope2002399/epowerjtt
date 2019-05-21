<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0022)http://www.becron.com/ -->
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE>Cron表达式生成器</TITLE>
<META content="text/html; charset=UTF-8" http-equiv=Content-Type>
<LINK rel="shortcut icon" href="favicon.ico">
<META name=description content=通过这个生成器,您可以生成任务调度比如Quartz的Cron表达式>
<LINK rel=stylesheet type=text/css href="cron_files/style.css">
<LINK rel=stylesheet type=text/css href="cron_files/easyui.css">
<LINK rel=stylesheet type=text/css href="cron_files/icon.css">
<SCRIPT src="cron_files/jquery.min.js"></SCRIPT>

<SCRIPT type=text/javascript src="cron_files/jquery.easyui.min.js"></SCRIPT>

<META name=GENERATOR content="MSHTML 8.00.6001.18702">
</HEAD>
<BODY>
	<DIV id=cronContainer>
		<DIV id=tt>
			<H3>Cron表达式生成器</H3>
		</DIV>
		<DIV id=cChoice>
			<DIV style="WIDTH: 700px; HEIGHT: 250px" class=easyui-tabs>
				<DIV
					style="PADDING-BOTTOM: 10px; PADDING-LEFT: 10px; PADDING-RIGHT: 10px; PADDING-TOP: 10px"
					title=分钟>
					<UL>
						<LI><INPUT value=* CHECKED type=radio name=rMin>周期 从
							<INPUT style="WIDTH: 80px" id=minStart class=easyui-numberspinner
							value=0 data-options="min:0,max:60">分钟开始,每<INPUT
							style="WIDTH: 80px" id=minEnd class=easyui-numberspinner value=0
							data-options="min:1,max:60"></INPUT>分钟执行一次</LI>
						<LI><INPUT value=c type=radio name=rMin>指定
							<DIV id=minPanel></DIV></LI>
					</UL>
				</DIV>
				<DIV
					style="PADDING-BOTTOM: 10px; PADDING-LEFT: 10px; PADDING-RIGHT: 10px; PADDING-TOP: 10px"
					title=小时>
					<UL>
						<LI><INPUT id=hourId value=* CHECKED type=radio name=rHour>每小时
						
						<LI><INPUT id=hourId2 value=c type=radio name=rHour>指定
							<DIV id=hourPanel></DIV></LI>
					</UL>
				</DIV>
				<DIV
					style="PADDING-BOTTOM: 10px; PADDING-LEFT: 10px; PADDING-RIGHT: 10px; PADDING-TOP: 10px"
					title=日>
					<UL>
						<LI><INPUT id=dayId value=* CHECKED type=radio name=rDay>每日
						
						<LI><INPUT id=dayId2 value=c type=radio name=rDay>指定
							<DIV id=dayPanel></DIV></LI>
					</UL>
				</DIV>
				<DIV
					style="PADDING-BOTTOM: 10px; PADDING-LEFT: 10px; PADDING-RIGHT: 10px; PADDING-TOP: 10px"
					title=月>
					<UL>
						<LI><INPUT id=monId value=? CHECKED type=radio name=rMon>每月
						
						<LI><INPUT id=monId2 value=c type=radio name=rMon>指定
							<DIV id=monPanel></DIV></LI>
					</UL>
				</DIV>
				<DIV
					style="PADDING-BOTTOM: 10px; PADDING-LEFT: 10px; PADDING-RIGHT: 10px; PADDING-TOP: 10px"
					title=星期>
					<UL>
						<LI><INPUT id=weekId value=? CHECKED type=radio name=rWeek>每星期
						
						<LI><INPUT id=weekId2 value=c type=radio name=rWeek>指定
							<DIV id=weekPanel></DIV></LI>
					</UL>
				</DIV>
			</DIV>
		</DIV>
		<DIV id=Cres>
			<FIELDSET>
				<LEGEND>表达式</LEGEND>
				<DIV>
					<TABLE>
						<TBODY>
							<TR>
								<TD></TD>
								<TD>秒</TD>
								<TD>分钟</TD>
								<TD>小时</TD>
								<TD>日</TD>
								<TD>月</TD>
								<TD>星期</TD>
							</TR>
							<TR>
								<TD>表达式字段:</TD>
								<TD><INPUT id=exSec></TD>
								<TD><INPUT id=exMin></TD>
								<TD><INPUT id=exHour></TD>
								<TD><INPUT id=exDay></TD>
								<TD><INPUT id=exMon></TD>
								<TD><INPUT id=exWeek></TD>
							</TR>
							<TR>
								<TD>Cron 表达式:</TD>
								<TD colSpan=5><INPUT style="WIDTH: 100%" id=txtCron ></TD>
								<TD><INPUT id=btnFan value="反解析到UI " type="hidden" alt="功能有问题不启用"></TD>
							</TR>
						</TBODY>
					</TABLE>
				</DIV>
			</FIELDSET>
		</DIV>
		<DIV id=Cbuttons>
			<INPUT id=btnGen value="生成 cron表达式" type=button icon="icon-search">
			<INPUT id=btnCopy value="保存"  type=button 
				onclick="window.opener.document.getElementById('<%=request.getParameter("txtCallback")%>').value = $('#txtCron').val();window.close();">
		</DIV>
	</DIV>
	<SCRIPT src="cron_files/common.js"></SCRIPT>
</BODY>
</HTML>
