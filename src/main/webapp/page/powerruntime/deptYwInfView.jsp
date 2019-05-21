<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
<title><s:text name="业务信息查看" /></title>
<style type="text/css">
.section-content {
    width: 890px;
    float: left;
}
.section-contentsdyj {
    width: 1069px;
    float: left;
}
.section_02 {
    width: 890px;
}
.section_22_01 span {
    float: left;
    width: 358px;
    height: 54px;
    background: #edf7ff url(js_wzy_16.png) left center;
    border: 1px solid #9cf;
    line-height: 54px;
    text-align: center;
    font-size: 17px;
    color: #333;
    transition: background-color 0.5s;
}
.section-content {
    width: 890px;
    float: left;
}
a{
text-decoration:none;
}
.section_41 {
    float: left;
    width: 100%;
    line-height: 57px;
    background: url(js_wzy_09.png) left center no-repeat;
    border-bottom: 1px solid #e4e6eb;
    color: #4178be;
    font-size: 21px;
    padding-left: -1px;
    margin-bottom: 20px;
}
.section_42 {
    /* float: left; */
    border-top: 1px solid #99ccff;
   /*  border-left: 1px solid #99ccff; */
}
.adColpan {
	background: #edf7ff url(js_wzy_16.png) left center;
}
.table td{border:solid 5px #99ccff;}

table{ width:100px; height:100px; border-left: solid 1px #99ccff; border-top: solid 1px #99ccff;}
td{ border-right: solid 1px #99ccff; border-bottom: solid 1px #99ccff;}
</style>

</head>
<body>
	<input type="button" name="reset" value="返回" class="btn"
		onclick="goback();" />
	<fieldset style="padding: 10px; display: block; margin-bottom: 10px;">
		<legend>
			基本信息
		</legend>
		<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
			<tr>
				<td colspan="3" class="addTd" style="width: 15%"><h4>行使层级：</h4></td>
				<td colspan="3" align="left"><c:out value="${userLevelValue }"></c:out></td>
				<td colspan="3" class="addTd" style="width: 15%"><h4>办件类型：</h4></td>
				<td colspan="3" align="left"><c:out value="${deptYwInf.ywType=='C'?'承诺件':'即办件'}"></c:out></td>
			</tr>
			<tr>
				<td colspan="3" class="addTd" style="width: 15%"><h4>决定机构：</h4></td>
				<td colspan="3" align="left"><c:out value="${deptYwInf.decisionDep==null?'无':deptYwInf.decisionDep}" /></td>
				<td colspan="3" class="addTd" style="width: 15%"><h4>办理结果送达方式：</h4></td>
				<td colspan="3" align="left"><c:out value="${deptYwInf.resultSendMode==null?'无':deptYwInf.resultSendMode}" /></td>
			</tr>
			<tr>
				<td colspan="3" class="addTd" style="width: 15%"><h4>法定办结时限：</h4></td>
				<td colspan="3" align="left">
					<c:if test="${deptYwInf.anticipateDay!=null }">
						<c:out value="${deptYwInf.anticipateDay }个工作日" />
					</c:if>
					<c:if test="${deptYwInf.anticipateDay==null }">
						<c:out value="无法定办结时限" />
					</c:if>
				</td>
				<td colspan="3" class="addTd" style="width: 15%"><h4>承诺办结时限：</h4></td>
				<td colspan="3" align="left">
					<c:if test="${deptYwInf.promiseDay!=null }">
						<c:out value="${deptYwInf.promiseDay }个工作日" />
					</c:if>
					<c:if test="${deptYwInf.promiseDay==null }">
						<c:out value="无承诺办结时限" />
					</c:if>
				</td>
			</tr>
			<!-- 隐藏 -->
			<tr>
				<td colspan="3" class="addTd" style="width: 15%"><h4>办理结果形式：</h4></td>
				<td colspan="9" align="left" colspan="3">
				<h4 onmouseover="this.style.cursor='hand'" onclick="xzsfr('${deptYwInf.resultFileUrl }')">${deptYwInf.resultFileName }</h4>
				</td>
			</tr>
			<tr>
				<td colspan="3" class="addTd" style="width: 15%"><h4>表格下载服务：</h4></td>
				<td colspan="9" align="left">
					<c:forEach items="${sfr }" var="sfr" varStatus="status">
						<h4 onmouseover="this.style.cursor='hand'" onclick="xzsfr('${sfr.sfrurl }')">${sfr.sfrname }</h4>
						<%-- <c:out value="${sfr.sfrname }" ><a onclick="xzsfr('${sfr.sfrurl }')">${sfr.sfrname }</a></c:out>&nbsp;&nbsp; --%>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td colspan="3" class="addTd" style="width: 15%"><h4>咨询方式：</h4></td>
				<td colspan="9" align="left"><c:out value="${deptYwInf.linkTel}" /></td>
			</tr>
			<tr>
				<td colspan="3" class="addTd" style="width: 15%"><h4>监督及投诉渠道：</h4></td>
				<td colspan="9" align="left" colspan="3"><c:out value="${deptYwInf.superviseTel}" /></td>
			</tr>
			<tr>
				<td colspan="3" class="addTd" style="width: 15%"><h4>其他共同办理部门：</h4></td>
				<td colspan="3" align="left"><c:out value="${deptYwInf.otherTogetdept==null?'无其他共同办理部门':deptYwInf.otherTogetdept}" /></td>
				<td colspan="3" class="addTd" style="width: 15%"><h4>其他共同办理处室：</h4></td>
				<td colspan="3" align="left"><c:out value="${deptYwInf.otherTogetoffice==null?'无其他共同办理处室':deptYwInf.otherTogetoffice}" /></td>
			</tr>
			<tr>
				<td colspan="3" class="addTd" style="width: 15%"><h4>涉及的中介机构：</h4></td>
				<td colspan="3" align="left"><c:out value="${deptYwInf.serviceDept==null?'此事项无中介服务机构':deptYwInf.serviceDept}" /></td>
				<td colspan="3" class="addTd" style="width: 15%"><h4>是否委托行使：</h4></td>
				<td colspan="3" align="left"><c:out value="${deptYwInf.ifEntrust==false?'否':'是'}" /></td>
			</tr>
			<tr>
				<td colspan="3" class="addTd" style="width: 15%"><h4>委托书： </h4></td>
				<td colspan="9" align="left" colspan="3"><c:out value="${deptYwInf.entrustFileUrl==null?'暂无':deptYwInf.entrustFileUrl}" /></td>
			</tr>
			<tr>
				<td colspan="3" class="addTd" style="width: 15%"><h4>需要到现场次数：</h4></td>
				<td colspan="9" align="left" colspan="3">
				<c:if test="${deptYwInf.daoXcNum eq '99' }">
					<c:out value="大于两次" />
				</c:if>
				<c:if test="${deptYwInf.daoXcNum ne '99' }">
					<c:out value="${deptYwInf.daoXcNum}次" />
				</c:if>
				</td>
			</tr>
		</table>
	</fieldset>
	<fieldset>
		<legend>
			流程图
		</legend>
		<div class="section-content" >
           <div class="section section_02">
              <div class="section_22_01"><span>
              <c:if test="${!empty actFileUrl }">
              	<a href="${actFileUrl }" target="_blank">点击查看流程图详情</a>
              </c:if>
              <c:if test="${empty actFileUrl }">
              	<a href="javascript:alert('暂无流程图');">点击查看流程图详情</a>
              </c:if>
              </span></div>
            </div>
        </div>
	</fieldset>
	<fieldset>
		<legend>
			办理材料目录
		</legend>
		<div class="section_41">
              <table class="section_42">
						<tbody><tr>
								<td class="adColpan" width="210" align="center">材料名称</td>
                    			<td class="adColpan" align="center">材料填写样本</td>
                    			<td class="adColpan" width="90" align="center">来源渠道</td>
                    			<td class="adColpan" width="90" align="center">纸质材料</td>
                    			<td class="adColpan" width="90" align="center">是否需要电子材料</td>
                    			<td class="adColpan" width="90" align="center">材料必要性</td>
                    			<td class="adColpan" width="90" align="center">填报须知</td>
							</tr>
							 <c:forEach items="${deptYwInf.ywFiles }" var="yf" varStatus="status">
            					   <tr>
										<td align="center">${yf.fileName }</td>
										<td align="center"><a style="cursor: pointer;" onclick="downloadClyb('${yf.sourceFileUrl }','${yf.sourceFileName }');">
												${yf.sourceFileName } </a></td>
										<td align="center">${yf.fileSourceName } </td>
										<td align="center">${yf.pageNum }份</td>
										<td align="center">${yf.ifEcPage=='true'?'是':'否' }</td>
										<td align="center">${yf.ifNeed=='true'?'是':'否' }</td>
										<td align="center">${yf.fileExplian==null?'无':yf.fileExplian }</td>
								   </tr>
              				 </c:forEach>
                		</tbody>
                </table>
                  
            </div>
	</fieldset>
	<fieldset>
		<legend>
			设定依据
		</legend>
		<div id="section4" class="section-contentsdyj">
           <div class="section">
              <div class="section_52" id="sdyj" style=" text-indent: 24px;margin-left: 1%;">
              		<c:choose>
					<c:when test="${fn:length(deptYwInf.ywByLaw ) > 250}">
							<c:out value="${fn:substring(deptYwInf.ywByLaw, 0, 250)}..." />
							<span onclick="shedingyiju()" class="section_52_01" style="white-space:nowrap;color: #628fc9;cursor: pointer;padding-left: 15px;">[点击展开]</span>
					</c:when>
					<c:otherwise>
							<c:out value="${deptYwInf.ywByLaw}" />
					</c:otherwise>
					</c:choose>
              </div>
              <div class="section_52" id="sdyj2" style="display: none;text-indent: 24px;margin-left: 1%;">
					<c:out value="${deptYwInf.ywByLaw}" />
					<span onclick="shedingyijusq()" class="section_52_01" style="white-space:nowrap;color: #628fc9;cursor: pointer;padding-left: 15px;">[点击收起]</span>
              </div>
            </div>
        </div>
	</fieldset>
	<fieldset>
		<legend>
			办理条件
		</legend>
	<div id="section5" class="section-content">
           <div class="section">
              <div class="section_52" id="sdyjcon" style="text-indent: 24px;margin-left: 1%;width: 119%;">
              		<c:choose>
					<c:when test="${fn:length(deptYwInf.condition ) > 250}">
							<c:out value="${fn:substring(deptYwInf.condition, 0, 250)}..." />
							<span onclick="shedingyijuco()" class="section_52_01" style="white-space:nowrap;color: #628fc9;cursor: pointer;padding-left: 15px;">[点击展开]</span>
					</c:when>
					<c:otherwise>
							<c:out value="${deptYwInf.condition}" />
					</c:otherwise>
					</c:choose>
              </div>
              <div class="section_52" id="sdyjcon2" style="display: none;text-indent: 24px;margin-left: 1%;width: 119%;">
					<c:out value="${deptYwInf.condition}" />
					<span onclick="shedingyijuco2()" class="section_52_01" style="white-space:nowrap;color: #628fc9;cursor: pointer;padding-left: 15px;">[点击收起]</span>
              </div>
            </div>
        </div>
	</fieldset>
	<fieldset>
		<legend>
			收费标准
		</legend>
	<div id="section6" class="section-content">
           <div class="section">
				<div class="section_52" id="sdyjex" style="text-indent: 11px;margin-left: 1%;">
              		<c:choose>
              		<c:when test="${fn:length(deptYwInf.expressFee ) < 1}">
							<c:out value="无" />
					</c:when>
					<c:when test="${fn:length(deptYwInf.expressFee ) > 250}">
							<c:out value="${fn:substring(deptYwInf.expressFee, 0, 250)}..." />
							<span onclick="shedingyijuex()" class="section_52_01" style="white-space:nowrap;color: #628fc9;cursor: pointer;padding-left: 15px;">[点击展开]</span>
					</c:when>
					<c:otherwise>
							<c:out value="${deptYwInf.expressFee}" />
					</c:otherwise>
					</c:choose>
              </div>
              <div class="section_52" id="sdyjex2" style="display: none;text-indent: 11px;margin-left: 1%;">
					<c:out value="${deptYwInf.expressFee}" />
					<span onclick="shedingyijuex2()" class="section_52_01" style="white-space:nowrap;color: #628fc9;cursor: pointer;padding-left: 15px;">[点击收起]</span>
              </div>
            </div>
        </div>
	</fieldset>
	<fieldset>
		<legend>
			常见问题
		</legend>
	<div id="section7" class="section-content" style="text-indent: 20px">
           <div class="section">
              
              		 无
              
              
            </div>
        </div>
	</fieldset>
</body>
<script type="text/javascript">
	function downloadClyb(url,name){
		window.open(url,'_blank');
	}
	function xzsfr(url){
		window.open(url,'_blank');
	}
	function goback() {
		return history.go(-1);
	}
	function shedingyiju(){
		$("#sdyj").hide();
		$("#sdyj2").show()
	}
	function shedingyijusq(){
		$("#sdyj").show();
		$("#sdyj2").hide();
	}
	function shedingyijuex(){
		$("#sdyjex").hide();
		$("#sdyjex2").show()
	}
	function shedingyijuex2(){
		$("#sdyjex").show();
		$("#sdyjex2").hide();
	}
	function shedingyijuco(){
		$("#sdyjcon").hide();
		$("#sdyjcon2").show()
	}
	function shedingyijuco2(){
		$("#sdyjcon").show();
		$("#sdyjcon2").hide();
	}
</script>
</html>