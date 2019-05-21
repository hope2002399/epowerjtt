<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>



<div class="pageContent">
	<s:form action="/monitor/punishLog!save.do" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">

		<div class="pageFormContent" layoutH="56">
		
			
			<p>
				<label><c:out value="punishLog.no" />：</label>
				 
				 
				<input name="no" type="text" class="required" <c:if test="${!empty object.no }">readonly="readonly"</c:if> size="40" value="${object.no }" />
				
			</p>

			
			<p>
				<label><c:out value="punishLog.orgId" />：</label>
				 
				 
				<input name="orgId" type="text" <c:if test="${!empty punishLogForm.map.orgId }">readonly="readonly"</c:if> size="40" value="${object.orgId }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.internalNo" />：</label>
				 
				 
				<input name="internalNo" type="text" <c:if test="${!empty punishLogForm.map.internalNo }">readonly="readonly"</c:if> size="40" value="${object.internalNo }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.itemId" />：</label>
				 
				 
				<input name="itemId" type="text" <c:if test="${!empty punishLogForm.map.itemId }">readonly="readonly"</c:if> size="40" value="${object.itemId }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.department" />：</label>
				 
				 
				<input name="department" type="text" <c:if test="${!empty punishLogForm.map.department }">readonly="readonly"</c:if> size="40" value="${object.department }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.ajAddr" />：</label>
				 
				 
				<input name="ajAddr" type="text" <c:if test="${!empty punishLogForm.map.ajAddr }">readonly="readonly"</c:if> size="40" value="${object.ajAddr }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.ajOccurDate" />：</label>
				 
				 
				<input name="ajOccurDate" type="text" <c:if test="${!empty punishLogForm.map.ajOccurDate }">readonly="readonly"</c:if> size="40" value="${object.ajOccurDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.source" />：</label>
				 
				 
				<input name="source" type="text" <c:if test="${!empty punishLogForm.map.source }">readonly="readonly"</c:if> size="40" value="${object.source }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.fact" />：</label>
				 
				 
				<input name="fact" type="text" <c:if test="${!empty punishLogForm.map.fact }">readonly="readonly"</c:if> size="40" value="${object.fact }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.targetType" />：</label>
				 
				 
				<input name="targetType" type="text" <c:if test="${!empty punishLogForm.map.targetType }">readonly="readonly"</c:if> size="40" value="${object.targetType }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.punishTarget" />：</label>
				 
				 
				<input name="punishTarget" type="text" <c:if test="${!empty punishLogForm.map.punishTarget }">readonly="readonly"</c:if> size="40" value="${object.punishTarget }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.targetCode" />：</label>
				 
				 
				<input name="targetCode" type="text" <c:if test="${!empty punishLogForm.map.targetCode }">readonly="readonly"</c:if> size="40" value="${object.targetCode }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.targetPaperType" />：</label>
				 
				 
				<input name="targetPaperType" type="text" <c:if test="${!empty punishLogForm.map.targetPaperType }">readonly="readonly"</c:if> size="40" value="${object.targetPaperType }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.targetPaperNumber" />：</label>
				 
				 
				<input name="targetPaperNumber" type="text" <c:if test="${!empty punishLogForm.map.targetPaperNumber }">readonly="readonly"</c:if> size="40" value="${object.targetPaperNumber }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.targetPhone" />：</label>
				 
				 
				<input name="targetPhone" type="text" <c:if test="${!empty punishLogForm.map.targetPhone }">readonly="readonly"</c:if> size="40" value="${object.targetPhone }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.targetMobile" />：</label>
				 
				 
				<input name="targetMobile" type="text" <c:if test="${!empty punishLogForm.map.targetMobile }">readonly="readonly"</c:if> size="40" value="${object.targetMobile }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.targetAddress" />：</label>
				 
				 
				<input name="targetAddress" type="text" <c:if test="${!empty punishLogForm.map.targetAddress }">readonly="readonly"</c:if> size="40" value="${object.targetAddress }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.targetZipCode" />：</label>
				 
				 
				<input name="targetZipCode" type="text" <c:if test="${!empty punishLogForm.map.targetZipCode }">readonly="readonly"</c:if> size="40" value="${object.targetZipCode }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.targetEmail" />：</label>
				 
				 
				<input name="targetEmail" type="text" <c:if test="${!empty punishLogForm.map.targetEmail }">readonly="readonly"</c:if> size="40" value="${object.targetEmail }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.reporter" />：</label>
				 
				 
				<input name="reporter" type="text" <c:if test="${!empty punishLogForm.map.reporter }">readonly="readonly"</c:if> size="40" value="${object.reporter }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.reporterDate" />：</label>
				 
				 
				<input name="reporterDate" type="text" <c:if test="${!empty punishLogForm.map.reporterDate }">readonly="readonly"</c:if> size="40" value="${object.reporterDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.reporterPaperType" />：</label>
				 
				 
				<input name="reporterPaperType" type="text" <c:if test="${!empty punishLogForm.map.reporterPaperType }">readonly="readonly"</c:if> size="40" value="${object.reporterPaperType }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.reporterAperCode" />：</label>
				 
				 
				<input name="reporterAperCode" type="text" <c:if test="${!empty punishLogForm.map.reporterAperCode }">readonly="readonly"</c:if> size="40" value="${object.reporterAperCode }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.reporterPhone" />：</label>
				 
				 
				<input name="reporterPhone" type="text" <c:if test="${!empty punishLogForm.map.reporterPhone }">readonly="readonly"</c:if> size="40" value="${object.reporterPhone }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.reporterMobile" />：</label>
				 
				 
				<input name="reporterMobile" type="text" <c:if test="${!empty punishLogForm.map.reporterMobile }">readonly="readonly"</c:if> size="40" value="${object.reporterMobile }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.reporterAddress" />：</label>
				 
				 
				<input name="reporterAddress" type="text" <c:if test="${!empty punishLogForm.map.reporterAddress }">readonly="readonly"</c:if> size="40" value="${object.reporterAddress }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.reporterZipcode" />：</label>
				 
				 
				<input name="reporterZipcode" type="text" <c:if test="${!empty punishLogForm.map.reporterZipcode }">readonly="readonly"</c:if> size="40" value="${object.reporterZipcode }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.reporterEmail" />：</label>
				 
				 
				<input name="reporterEmail" type="text" <c:if test="${!empty punishLogForm.map.reporterEmail }">readonly="readonly"</c:if> size="40" value="${object.reporterEmail }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.content" />：</label>
				 
				 
				<input name="content" type="text" <c:if test="${!empty punishLogForm.map.content }">readonly="readonly"</c:if> size="40" value="${object.content }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.form" />：</label>
				 
				 
				<input name="form" type="text" <c:if test="${!empty punishLogForm.map.form }">readonly="readonly"</c:if> size="40" value="${object.form }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.promise" />：</label>
				 
				 
				<input name="promise" type="text" <c:if test="${!empty punishLogForm.map.promise }">readonly="readonly"</c:if> size="40" value="${object.promise }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.promiseType" />：</label>
				 
				 
				<input name="promiseType" type="text" <c:if test="${!empty punishLogForm.map.promiseType }">readonly="readonly"</c:if> size="40" value="${object.promiseType }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.isrisk" />：</label>
				 
				 
				<input name="isrisk" type="text" <c:if test="${!empty punishLogForm.map.isrisk }">readonly="readonly"</c:if> size="40" value="${object.isrisk }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.risktype" />：</label>
				 
				 
				<input name="risktype" type="text" <c:if test="${!empty punishLogForm.map.risktype }">readonly="readonly"</c:if> size="40" value="${object.risktype }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.riskdescription" />：</label>
				 
				 
				<input name="riskdescription" type="text" <c:if test="${!empty punishLogForm.map.riskdescription }">readonly="readonly"</c:if> size="40" value="${object.riskdescription }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.riskresult" />：</label>
				 
				 
				<input name="riskresult" type="text" <c:if test="${!empty punishLogForm.map.riskresult }">readonly="readonly"</c:if> size="40" value="${object.riskresult }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.createDate" />：</label>
				 
				 
				<input name="createDate" type="text" <c:if test="${!empty punishLogForm.map.createDate }">readonly="readonly"</c:if> size="40" value="${object.createDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.updateDate" />：</label>
				 
				 
				<input name="updateDate" type="text" <c:if test="${!empty punishLogForm.map.updateDate }">readonly="readonly"</c:if> size="40" value="${object.updateDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.syncDate" />：</label>
				 
				 
				<input name="syncDate" type="text" <c:if test="${!empty punishLogForm.map.syncDate }">readonly="readonly"</c:if> size="40" value="${object.syncDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.syncSign" />：</label>
				 
				 
				<input name="syncSign" type="text" <c:if test="${!empty punishLogForm.map.syncSign }">readonly="readonly"</c:if> size="40" value="${object.syncSign }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.syncErrorDesc" />：</label>
				 
				 
				<input name="syncErrorDesc" type="text" <c:if test="${!empty punishLogForm.map.syncErrorDesc }">readonly="readonly"</c:if> size="40" value="${object.syncErrorDesc }"/>
				
			</p>
			
			
			
			
		</div>


		<div class="formBar">
			<ul>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">保存</button>
						</div>
					</div></li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="button" class="close">取消</button>
						</div>
					</div>
				</li>
			</ul>
		</div>

	</s:form>
</div>

			<p>
				<label><c:out value="punishLog.changNo" />：</label>
				 
				 
				<input name="changNo" type="text" class="required" <c:if test="${!empty object.changNo }">readonly="readonly"</c:if> size="40" value="${object.changNo }" />
				
			</p>

			
			<p>
				<label><c:out value="punishLog.orgId" />：</label>
				 
				 
				<input name="orgId" type="text" <c:if test="${!empty punishLogForm.map.orgId }">readonly="readonly"</c:if> size="40" value="${object.orgId }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.internalNo" />：</label>
				 
				 
				<input name="internalNo" type="text" <c:if test="${!empty punishLogForm.map.internalNo }">readonly="readonly"</c:if> size="40" value="${object.internalNo }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.itemId" />：</label>
				 
				 
				<input name="itemId" type="text" <c:if test="${!empty punishLogForm.map.itemId }">readonly="readonly"</c:if> size="40" value="${object.itemId }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.department" />：</label>
				 
				 
				<input name="department" type="text" <c:if test="${!empty punishLogForm.map.department }">readonly="readonly"</c:if> size="40" value="${object.department }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.ajAddr" />：</label>
				 
				 
				<input name="ajAddr" type="text" <c:if test="${!empty punishLogForm.map.ajAddr }">readonly="readonly"</c:if> size="40" value="${object.ajAddr }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.ajOccurDate" />：</label>
				 
				 
				<input name="ajOccurDate" type="text" <c:if test="${!empty punishLogForm.map.ajOccurDate }">readonly="readonly"</c:if> size="40" value="${object.ajOccurDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.source" />：</label>
				 
				 
				<input name="source" type="text" <c:if test="${!empty punishLogForm.map.source }">readonly="readonly"</c:if> size="40" value="${object.source }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.fact" />：</label>
				 
				 
				<input name="fact" type="text" <c:if test="${!empty punishLogForm.map.fact }">readonly="readonly"</c:if> size="40" value="${object.fact }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.targetType" />：</label>
				 
				 
				<input name="targetType" type="text" <c:if test="${!empty punishLogForm.map.targetType }">readonly="readonly"</c:if> size="40" value="${object.targetType }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.punishTarget" />：</label>
				 
				 
				<input name="punishTarget" type="text" <c:if test="${!empty punishLogForm.map.punishTarget }">readonly="readonly"</c:if> size="40" value="${object.punishTarget }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.targetCode" />：</label>
				 
				 
				<input name="targetCode" type="text" <c:if test="${!empty punishLogForm.map.targetCode }">readonly="readonly"</c:if> size="40" value="${object.targetCode }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.targetPaperType" />：</label>
				 
				 
				<input name="targetPaperType" type="text" <c:if test="${!empty punishLogForm.map.targetPaperType }">readonly="readonly"</c:if> size="40" value="${object.targetPaperType }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.targetPaperNumber" />：</label>
				 
				 
				<input name="targetPaperNumber" type="text" <c:if test="${!empty punishLogForm.map.targetPaperNumber }">readonly="readonly"</c:if> size="40" value="${object.targetPaperNumber }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.targetPhone" />：</label>
				 
				 
				<input name="targetPhone" type="text" <c:if test="${!empty punishLogForm.map.targetPhone }">readonly="readonly"</c:if> size="40" value="${object.targetPhone }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.targetMobile" />：</label>
				 
				 
				<input name="targetMobile" type="text" <c:if test="${!empty punishLogForm.map.targetMobile }">readonly="readonly"</c:if> size="40" value="${object.targetMobile }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.targetAddress" />：</label>
				 
				 
				<input name="targetAddress" type="text" <c:if test="${!empty punishLogForm.map.targetAddress }">readonly="readonly"</c:if> size="40" value="${object.targetAddress }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.targetZipCode" />：</label>
				 
				 
				<input name="targetZipCode" type="text" <c:if test="${!empty punishLogForm.map.targetZipCode }">readonly="readonly"</c:if> size="40" value="${object.targetZipCode }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.targetEmail" />：</label>
				 
				 
				<input name="targetEmail" type="text" <c:if test="${!empty punishLogForm.map.targetEmail }">readonly="readonly"</c:if> size="40" value="${object.targetEmail }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.reporter" />：</label>
				 
				 
				<input name="reporter" type="text" <c:if test="${!empty punishLogForm.map.reporter }">readonly="readonly"</c:if> size="40" value="${object.reporter }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.reporterDate" />：</label>
				 
				 
				<input name="reporterDate" type="text" <c:if test="${!empty punishLogForm.map.reporterDate }">readonly="readonly"</c:if> size="40" value="${object.reporterDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.reporterPaperType" />：</label>
				 
				 
				<input name="reporterPaperType" type="text" <c:if test="${!empty punishLogForm.map.reporterPaperType }">readonly="readonly"</c:if> size="40" value="${object.reporterPaperType }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.reporterAperCode" />：</label>
				 
				 
				<input name="reporterAperCode" type="text" <c:if test="${!empty punishLogForm.map.reporterAperCode }">readonly="readonly"</c:if> size="40" value="${object.reporterAperCode }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.reporterPhone" />：</label>
				 
				 
				<input name="reporterPhone" type="text" <c:if test="${!empty punishLogForm.map.reporterPhone }">readonly="readonly"</c:if> size="40" value="${object.reporterPhone }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.reporterMobile" />：</label>
				 
				 
				<input name="reporterMobile" type="text" <c:if test="${!empty punishLogForm.map.reporterMobile }">readonly="readonly"</c:if> size="40" value="${object.reporterMobile }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.reporterAddress" />：</label>
				 
				 
				<input name="reporterAddress" type="text" <c:if test="${!empty punishLogForm.map.reporterAddress }">readonly="readonly"</c:if> size="40" value="${object.reporterAddress }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.reporterZipcode" />：</label>
				 
				 
				<input name="reporterZipcode" type="text" <c:if test="${!empty punishLogForm.map.reporterZipcode }">readonly="readonly"</c:if> size="40" value="${object.reporterZipcode }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.reporterEmail" />：</label>
				 
				 
				<input name="reporterEmail" type="text" <c:if test="${!empty punishLogForm.map.reporterEmail }">readonly="readonly"</c:if> size="40" value="${object.reporterEmail }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.content" />：</label>
				 
				 
				<input name="content" type="text" <c:if test="${!empty punishLogForm.map.content }">readonly="readonly"</c:if> size="40" value="${object.content }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.form" />：</label>
				 
				 
				<input name="form" type="text" <c:if test="${!empty punishLogForm.map.form }">readonly="readonly"</c:if> size="40" value="${object.form }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.promise" />：</label>
				 
				 
				<input name="promise" type="text" <c:if test="${!empty punishLogForm.map.promise }">readonly="readonly"</c:if> size="40" value="${object.promise }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.promiseType" />：</label>
				 
				 
				<input name="promiseType" type="text" <c:if test="${!empty punishLogForm.map.promiseType }">readonly="readonly"</c:if> size="40" value="${object.promiseType }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.isrisk" />：</label>
				 
				 
				<input name="isrisk" type="text" <c:if test="${!empty punishLogForm.map.isrisk }">readonly="readonly"</c:if> size="40" value="${object.isrisk }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.risktype" />：</label>
				 
				 
				<input name="risktype" type="text" <c:if test="${!empty punishLogForm.map.risktype }">readonly="readonly"</c:if> size="40" value="${object.risktype }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.riskdescription" />：</label>
				 
				 
				<input name="riskdescription" type="text" <c:if test="${!empty punishLogForm.map.riskdescription }">readonly="readonly"</c:if> size="40" value="${object.riskdescription }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.riskresult" />：</label>
				 
				 
				<input name="riskresult" type="text" <c:if test="${!empty punishLogForm.map.riskresult }">readonly="readonly"</c:if> size="40" value="${object.riskresult }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.createDate" />：</label>
				 
				 
				<input name="createDate" type="text" <c:if test="${!empty punishLogForm.map.createDate }">readonly="readonly"</c:if> size="40" value="${object.createDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.updateDate" />：</label>
				 
				 
				<input name="updateDate" type="text" <c:if test="${!empty punishLogForm.map.updateDate }">readonly="readonly"</c:if> size="40" value="${object.updateDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.syncDate" />：</label>
				 
				 
				<input name="syncDate" type="text" <c:if test="${!empty punishLogForm.map.syncDate }">readonly="readonly"</c:if> size="40" value="${object.syncDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.syncSign" />：</label>
				 
				 
				<input name="syncSign" type="text" <c:if test="${!empty punishLogForm.map.syncSign }">readonly="readonly"</c:if> size="40" value="${object.syncSign }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishLog.syncErrorDesc" />：</label>
				 
				 
				<input name="syncErrorDesc" type="text" <c:if test="${!empty punishLogForm.map.syncErrorDesc }">readonly="readonly"</c:if> size="40" value="${object.syncErrorDesc }"/>
				
			</p>
			
			
			
			
		</div>


		<div class="formBar">
			<ul>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">保存</button>
						</div>
					</div></li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="button" class="close">取消</button>
						</div>
					</div>
				</li>
			</ul>
		</div>

	</s:form>
</div>
