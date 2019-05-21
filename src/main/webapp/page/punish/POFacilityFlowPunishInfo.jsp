<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%> 
<%@ include file="/page/common/css.jsp"%>
<html>
<head>
	<meta name="decorator" content='${LAYOUT}'/>
	<title>现场处罚查看 </title>
	<style type="text/css">
		.viewTable td { width:37%; }
		.viewTable td.addTd { width:13%; }
	</style>
	<script type="text/javascript" src="jquery-1.6.min.js"></script>
	<sj:head locale="zh_CN" />
	<script type="text/javascript">
	function getId(id){
		return document.getElementById(id);
	}
	
	$(document).ready(
		function (){ 
	         if(getId("occurstate").value!=""&&getId("occurstate").value!=null){
				if(getId("occurstate").value==0){
					document.getElementById('individual').style.display = 'block';
					document.getElementById('enterprise').style.display = 'none';
				}
				if(getId("occurstate").value==1){
					document.getElementById('individual').style.display = 'none';
					document.getElementById('enterprise').style.display = 'block';
				}
	         } else {
				document.getElementById('enterprise').style.display = 'none';
			}
		}
	);	
	</script>
</head>
<body>
	<s:form id="basicform" action="punishobjectbasic"  method="post" namespace="/punish"  styleId="punishobjectbasicForm" >
		<input type="hidden" id="flowCode" name="flowCode"  value="${flowCode}" />
		<input type="hidden" id="occurstate" value="${object.pooccurstate}"/>
		<input type="hidden" id="impeachstate" value="${object.poimpeachstate}"/>
		<input type="hidden" id="originstate" value="${object.pooriginstate}"/>
		<input type="hidden" name="managedepid" value="${object.managedepid}"/>
		<input type="hidden" name="operatorid" value="${object.operatorid}"/>
		<input type="hidden" id="optId" name="optId"  value="${object.optId}" />
		<input type="hidden" id="punishobjectid" name="punishobjectid"  value="${object.punishobjectid}" />
		<input type="hidden" id="item_id" name="item_id">
		<input type="hidden" id="popunishObjectBrief" name="popunishObjectBrief">
		<input type="hidden" id="punishamout" name="punishamout">
		<input type="hidden" id="otherpunish" name="otherpunish">
		<input type="hidden" id="discussresult" name="discussresult">
		<input type="hidden" id="issurpass" name="issurpass">
		<input type="hidden" name="disobeyitem" value="">

		<fieldset style="padding:10px;display:block;margin-bottom:10px;">
			<legend style="padding:4px 8px 3px;"><b>简易流程案件信息</b></legend>

			<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
				<tr>
					<td class="addTd" >受理单位</td><td align="left">${cp:MAPVALUE("unitcode",object.managedepid)}</td>
					<td class="addTd" >登记人员</td><td align="left">${cp:MAPVALUE("usercode",object.operatorid)}</td>
				</tr>
				<tr>
					<td class="addTd" >现场执法人员</td>	
					<td align="left">
						${object.poundertaker }
					</td>
					<td class="addTd" >案发时间</td>	
					<td align="left">
						${object.pooccurdate }
					</td>
				</tr>
				<tr>
					<td class="addTd" >案发地点</td>	
					<td align="left" >
						${object.pooccuradress }
					</td>
					<td class="addTd" >当事人性质</td>	
					<td align="left">
				        <c:if test="${object.pooccurstate eq '0'}"> 
				       		个人
				        </c:if>
				        <c:if test="${object.pooccurstate eq '1'}"> 
				       		组织结构
				        </c:if>
					</td>
				</tr>
			</table>
		</fieldset>
		<div id="individual">
			<fieldset style="padding:10px;display:block;margin-bottom:10px;">
				<legend style="padding:4px 8px 3px;"><b>当事人信息-个人</b></legend>
			
				<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
					<tr>
						<td class="addTd">当事人</td>
						<td align="left">
			  				${object.poindividual.individualname }
						</td>
						<td class="addTd">性别</td>
						<td align="left">
							${cp:MAPVALUE("sex",object.poindividual.sex)}
						</td>
					</tr>
					<tr>
						<td class="addTd">证件号码</td>
						<td align="left">
						  ${object.poindividual.individualcode }
						</td>
						<td class="addTd">电话</td>
						<td align="left">
						  ${object.poindividual.phone }
						</td>
					</tr>
					<tr>
						<td class="addTd">邮政编码</td>
						<td align="left">
						  ${object.poindividual.postcode }
						</td>
						<td class="addTd">地址</td>
						<td align="left">
						  ${object.poindividual.individualadress }
						</td>
					</tr>
					<tr>
						<td class="addTd">工作单位</td>
						<td align="left" colspan="3">
						  ${object.poindividual.workunit }
						</td>
					</tr>
				</table>
			</fieldset>
		</div>

		<div id="enterprise">
			<fieldset style="padding:10px;display:block;margin-bottom:10px;">
				<legend style="padding:4px 8px 3px;"><b>当事人信息-组织机构</b></legend>
				
				<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
					<tr>
						<td class="addTd" >单位名称</td>
						<td align="left" >
							${object.poenterprise.enterprisename }
						</td>
						<td class="addTd" >机构代码 </td>
						<td align="left"  >
		  					${object.poenterprise.enterprisecode }
						</td>
					</tr>
					<tr>
						<td class="addTd" >负责人</td>
						<td align="left"  >
							${object.poenterprise.mastername }
						</td>
						<td class="addTd" >机构性质</td>
						<td align="left"  >
							${cp:MAPVALUE("UnitType4CF",object.poenterprise.unittype)}
						</td>
					</tr>
					<tr>
						<td class="addTd" >企业地址  </td>
						<td align="left"  colspan="3">
							${object.poenterprise.enterpriseaddress }
						</td>
					</tr>
					<tr>
						<td class="addTd" >传真 </td>
						<td align="left"  >
		  					${object.poenterprise.fax }
						</td>
						<td class="addTd" >联系人 </td>
						<td align="left"  >
		 	 				${object.poenterprise.linker }
						</td>
					</tr>
					<tr>
						<td class="addTd" >联系电话 </td>
						<td align="left"  >
		  					${object.poenterprise.phone }
						</td>
						<td class="addTd" >邮政编码</td>
						<td align="left"  >
						  ${object.poenterprise.postcode }
						</td>
					</tr>
				</table>
			</fieldset>
		</div>

		<div id="punishInfoDiv">
			<fieldset style="padding:10px;display:block;margin-bottom:10px;">
				<legend style="padding:4px 8px 3px;"><b>处罚信息</b></legend>
				
				<table border="0" cellpadding="0" cellspacing="0" class="viewTable">
					<tr>
						<%-- <td class="addTd">案由</td>
						<td align="left">
							${cp:MAPVALUE("anyou",object.punishobjectbrief)}
						</td> --%>
						<td class="addTd">处罚项目名称
						</td>
						<td align="left">
							${finishBasic.confirmtruth}
						</td>
						<td class="addTd">违法程度选择</td>
						<td align="left">
							${freeUmpireDegree.punishfactgrade }
						</td>
					</tr>
					
					<%-- <tr id="punishClassName">
						<td class="addTd">处罚项目名称
						</td>
						<td align="left" colspan="3">
							${finishBasic.confirmtruth}
						</td>
					</tr> --%>
	
					<tr id="poRegisterBas">
						<td class="addTd">相关的法律依据</td>
						<td align="left" colspan="3">
							${finishBasic.disobeyitem}
						</td>
					</tr>
					
					<tr>
						<td class="addTd">
							处罚决定
						</td>
						<td colspan="3">
							${finishBasic.podiscussresult}
						</td>					
					</tr>
					<tr>
						<td class="addTd">处罚金额</td>
						<td colspan="3">${finishBasic.punishamout} 元</td>
					</tr>
					<%-- <tr>
						<td class="addTd">其他处罚项目</td>
						<td colspan="3">${finishBasic.otherpunish}</td>
					</tr>	 --%>
				</table>
			</fieldset>
		</div>
		<div align="center">
			<!-- 附件上传-->
			<iframe  name="stuffsFrame" src="<%=request.getContextPath()%>/powerruntime/generalOperator!listStuffs.do?djId=${object.punishobjectid}&stuffInfo.nodeInstId=99999&suppowerstuffinfo.groupId=103" width="100%"
							frameborder="no" scrolling="false" border="0" marginwidth="0"
							marginheight="0" onload="this.height=window.frames['stuffsFrame'].document.body.scrollHeight"></iframe>	
			<!-- 附件上传-->	
		</div>
		<div align="center">
			<input type="button" class="btn"  onClick="window.history.back()"  value="返回"/>
		</div>
	</s:form>
</body>

<script>
	function addFile(data)
	{
		var newFile = "<input type='hidden' name='fileCodes' value='"+data.id+"' >" + data.name;
		var oper = "&nbsp;&nbsp;<a href='###' onclick=\"deleteRow(this)\">[删除]</a>"; 
		var tblObj = _get("filetab");
		var len =  tblObj.rows.length; 
	    var newRow = tblObj.insertRow(len);//插入行对象 
	    var fileCell = newRow.insertCell(0); 
	    fileCell.innerHTML = newFile + oper;
	};
</script>


</html>

