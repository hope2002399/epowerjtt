<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>



<div class="pageContent">
	<s:form action="/monitor/punish!save.do" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">

		<div class="pageFormContent" layoutH="56">
		
			
			<p>
				<label><c:out value="punish.no" />：</label>
				 
				 
				<input name="no" type="text" class="required" <c:if test="${!empty object.no }">readonly="readonly"</c:if> size="40" value="${object.no }" />
				
			</p>

			
			<p>
				<label><c:out value="punish.changNo" />：</label>
				 
				 
				<input name="changNo" type="text" <c:if test="${!empty punishForm.map.changNo }">readonly="readonly"</c:if> size="40" value="${object.changNo }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.orgId" />：</label>
				 
				 
				<input name="orgId" type="text" <c:if test="${!empty punishForm.map.orgId }">readonly="readonly"</c:if> size="40" value="${object.orgId }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.internalNo" />：</label>
				 
				 
				<input name="internalNo" type="text" <c:if test="${!empty punishForm.map.internalNo }">readonly="readonly"</c:if> size="40" value="${object.internalNo }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.itemId" />：</label>
				 
				 
				<input name="itemId" type="text" <c:if test="${!empty punishForm.map.itemId }">readonly="readonly"</c:if> size="40" value="${object.itemId }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.department" />：</label>
				 
				 
				<input name="department" type="text" <c:if test="${!empty punishForm.map.department }">readonly="readonly"</c:if> size="40" value="${object.department }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.ajAddr" />：</label>
				 
				 
				<input name="ajAddr" type="text" <c:if test="${!empty punishForm.map.ajAddr }">readonly="readonly"</c:if> size="40" value="${object.ajAddr }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.ajOccurDate" />：</label>
				 
				 
				<input name="ajOccurDate" type="text" <c:if test="${!empty punishForm.map.ajOccurDate }">readonly="readonly"</c:if> size="40" value="${object.ajOccurDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.source" />：</label>
				 
				 
				<input name="source" type="text" <c:if test="${!empty punishForm.map.source }">readonly="readonly"</c:if> size="40" value="${object.source }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.fact" />：</label>
				 
				 
				<input name="fact" type="text" <c:if test="${!empty punishForm.map.fact }">readonly="readonly"</c:if> size="40" value="${object.fact }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.targetType" />：</label>
				 
				 
				<input name="targetType" type="text" <c:if test="${!empty punishForm.map.targetType }">readonly="readonly"</c:if> size="40" value="${object.targetType }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.punishTarget" />：</label>
				 
				 
				<input name="punishTarget" type="text" <c:if test="${!empty punishForm.map.punishTarget }">readonly="readonly"</c:if> size="40" value="${object.punishTarget }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.targetCode" />：</label>
				 
				 
				<input name="targetCode" type="text" <c:if test="${!empty punishForm.map.targetCode }">readonly="readonly"</c:if> size="40" value="${object.targetCode }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.targetPaperType" />：</label>
				 
				 
				<input name="targetPaperType" type="text" <c:if test="${!empty punishForm.map.targetPaperType }">readonly="readonly"</c:if> size="40" value="${object.targetPaperType }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.targetPaperNumber" />：</label>
				 
				 
				<input name="targetPaperNumber" type="text" <c:if test="${!empty punishForm.map.targetPaperNumber }">readonly="readonly"</c:if> size="40" value="${object.targetPaperNumber }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.targetPhone" />：</label>
				 
				 
				<input name="targetPhone" type="text" <c:if test="${!empty punishForm.map.targetPhone }">readonly="readonly"</c:if> size="40" value="${object.targetPhone }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.targetMobile" />：</label>
				 
				 
				<input name="targetMobile" type="text" <c:if test="${!empty punishForm.map.targetMobile }">readonly="readonly"</c:if> size="40" value="${object.targetMobile }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.targetAddress" />：</label>
				 
				 
				<input name="targetAddress" type="text" <c:if test="${!empty punishForm.map.targetAddress }">readonly="readonly"</c:if> size="40" value="${object.targetAddress }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.targetZipCode" />：</label>
				 
				 
				<input name="targetZipCode" type="text" <c:if test="${!empty punishForm.map.targetZipCode }">readonly="readonly"</c:if> size="40" value="${object.targetZipCode }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.targetEmail" />：</label>
				 
				 
				<input name="targetEmail" type="text" <c:if test="${!empty punishForm.map.targetEmail }">readonly="readonly"</c:if> size="40" value="${object.targetEmail }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.reporter" />：</label>
				 
				 
				<input name="reporter" type="text" <c:if test="${!empty punishForm.map.reporter }">readonly="readonly"</c:if> size="40" value="${object.reporter }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.reporterDate" />：</label>
				 
				 
				<input name="reporterDate" type="text" <c:if test="${!empty punishForm.map.reporterDate }">readonly="readonly"</c:if> size="40" value="${object.reporterDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.reporterPaperType" />：</label>
				 
				 
				<input name="reporterPaperType" type="text" <c:if test="${!empty punishForm.map.reporterPaperType }">readonly="readonly"</c:if> size="40" value="${object.reporterPaperType }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.reporterAperCode" />：</label>
				 
				 
				<input name="reporterAperCode" type="text" <c:if test="${!empty punishForm.map.reporterAperCode }">readonly="readonly"</c:if> size="40" value="${object.reporterAperCode }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.reporterPhone" />：</label>
				 
				 
				<input name="reporterPhone" type="text" <c:if test="${!empty punishForm.map.reporterPhone }">readonly="readonly"</c:if> size="40" value="${object.reporterPhone }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.reporterMobile" />：</label>
				 
				 
				<input name="reporterMobile" type="text" <c:if test="${!empty punishForm.map.reporterMobile }">readonly="readonly"</c:if> size="40" value="${object.reporterMobile }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.reporterAddress" />：</label>
				 
				 
				<input name="reporterAddress" type="text" <c:if test="${!empty punishForm.map.reporterAddress }">readonly="readonly"</c:if> size="40" value="${object.reporterAddress }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.reporterZipcode" />：</label>
				 
				 
				<input name="reporterZipcode" type="text" <c:if test="${!empty punishForm.map.reporterZipcode }">readonly="readonly"</c:if> size="40" value="${object.reporterZipcode }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.reporterEmail" />：</label>
				 
				 
				<input name="reporterEmail" type="text" <c:if test="${!empty punishForm.map.reporterEmail }">readonly="readonly"</c:if> size="40" value="${object.reporterEmail }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.content" />：</label>
				 
				 
				<input name="content" type="text" <c:if test="${!empty punishForm.map.content }">readonly="readonly"</c:if> size="40" value="${object.content }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.form" />：</label>
				 
				 
				<input name="form" type="text" <c:if test="${!empty punishForm.map.form }">readonly="readonly"</c:if> size="40" value="${object.form }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.promise" />：</label>
				 
				 
				<input name="promise" type="text" <c:if test="${!empty punishForm.map.promise }">readonly="readonly"</c:if> size="40" value="${object.promise }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.promiseType" />：</label>
				 
				 
				<input name="promiseType" type="text" <c:if test="${!empty punishForm.map.promiseType }">readonly="readonly"</c:if> size="40" value="${object.promiseType }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.isrisk" />：</label>
				 
				 
				<input name="isrisk" type="text" <c:if test="${!empty punishForm.map.isrisk }">readonly="readonly"</c:if> size="40" value="${object.isrisk }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.risktype" />：</label>
				 
				 
				<input name="risktype" type="text" <c:if test="${!empty punishForm.map.risktype }">readonly="readonly"</c:if> size="40" value="${object.risktype }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.riskdescription" />：</label>
				 
				 
				<input name="riskdescription" type="text" <c:if test="${!empty punishForm.map.riskdescription }">readonly="readonly"</c:if> size="40" value="${object.riskdescription }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.riskresult" />：</label>
				 
				 
				<input name="riskresult" type="text" <c:if test="${!empty punishForm.map.riskresult }">readonly="readonly"</c:if> size="40" value="${object.riskresult }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.createDate" />：</label>
				 
				 
				<input name="createDate" type="text" <c:if test="${!empty punishForm.map.createDate }">readonly="readonly"</c:if> size="40" value="${object.createDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.updateDate" />：</label>
				 
				 
				<input name="updateDate" type="text" <c:if test="${!empty punishForm.map.updateDate }">readonly="readonly"</c:if> size="40" value="${object.updateDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.syncDate" />：</label>
				 
				 
				<input name="syncDate" type="text" <c:if test="${!empty punishForm.map.syncDate }">readonly="readonly"</c:if> size="40" value="${object.syncDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.syncSign" />：</label>
				 
				 
				<input name="syncSign" type="text" <c:if test="${!empty punishForm.map.syncSign }">readonly="readonly"</c:if> size="40" value="${object.syncSign }"/>
				
			</p>
			
			<p>
				<label><c:out value="punish.syncErrorDesc" />：</label>
				 
				 
				<input name="syncErrorDesc" type="text" <c:if test="${!empty punishForm.map.syncErrorDesc }">readonly="readonly"</c:if> size="40" value="${object.syncErrorDesc }"/>
				
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
