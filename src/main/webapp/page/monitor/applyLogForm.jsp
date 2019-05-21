<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>



<div class="pageContent">
	<s:form action="/monitor/applyLog!save.do" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">

		<div class="pageFormContent" layoutH="56">
		
			
			<p>
				<label><c:out value="applyLog.no" />：</label>
				 
				 
				<input name="no" type="text" class="required" <c:if test="${!empty object.no }">readonly="readonly"</c:if> size="40" value="${object.no }" />
				
			</p>

			
			<p>
				<label><c:out value="applyLog.orgId" />：</label>
				 
				 
				<input name="orgId" type="text" <c:if test="${!empty applyLogForm.map.orgId }">readonly="readonly"</c:if> size="40" value="${object.orgId }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.internalNo" />：</label>
				 
				 
				<input name="internalNo" type="text" <c:if test="${!empty applyLogForm.map.internalNo }">readonly="readonly"</c:if> size="40" value="${object.internalNo }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.itemId" />：</label>
				 
				 
				<input name="itemId" type="text" <c:if test="${!empty applyLogForm.map.itemId }">readonly="readonly"</c:if> size="40" value="${object.itemId }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.department" />：</label>
				 
				 
				<input name="department" type="text" <c:if test="${!empty applyLogForm.map.department }">readonly="readonly"</c:if> size="40" value="${object.department }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.transactAffairName" />：</label>
				 
				 
				<input name="transactAffairName" type="text" <c:if test="${!empty applyLogForm.map.transactAffairName }">readonly="readonly"</c:if> size="40" value="${object.transactAffairName }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.content" />：</label>
				 
				 
				<input name="content" type="text" <c:if test="${!empty applyLogForm.map.content }">readonly="readonly"</c:if> size="40" value="${object.content }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.applyWay" />：</label>
				 
				 
				<input name="applyWay" type="text" <c:if test="${!empty applyLogForm.map.applyWay }">readonly="readonly"</c:if> size="40" value="${object.applyWay }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.form" />：</label>
				 
				 
				<input name="form" type="text" <c:if test="${!empty applyLogForm.map.form }">readonly="readonly"</c:if> size="40" value="${object.form }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.stuff" />：</label>
				 
				 
				<input name="stuff" type="text" <c:if test="${!empty applyLogForm.map.stuff }">readonly="readonly"</c:if> size="40" value="${object.stuff }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.applicantCode" />：</label>
				 
				 
				<input name="applicantCode" type="text" <c:if test="${!empty applyLogForm.map.applicantCode }">readonly="readonly"</c:if> size="40" value="${object.applicantCode }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.applicantType" />：</label>
				 
				 
				<input name="applicantType" type="text" <c:if test="${!empty applyLogForm.map.applicantType }">readonly="readonly"</c:if> size="40" value="${object.applicantType }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.applicantName" />：</label>
				 
				 
				<input name="applicantName" type="text" <c:if test="${!empty applyLogForm.map.applicantName }">readonly="readonly"</c:if> size="40" value="${object.applicantName }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.applicantPaperType" />：</label>
				 
				 
				<input name="applicantPaperType" type="text" <c:if test="${!empty applyLogForm.map.applicantPaperType }">readonly="readonly"</c:if> size="40" value="${object.applicantPaperType }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.applicantPaperCode" />：</label>
				 
				 
				<input name="applicantPaperCode" type="text" <c:if test="${!empty applyLogForm.map.applicantPaperCode }">readonly="readonly"</c:if> size="40" value="${object.applicantPaperCode }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.applicantPhone" />：</label>
				 
				 
				<input name="applicantPhone" type="text" <c:if test="${!empty applyLogForm.map.applicantPhone }">readonly="readonly"</c:if> size="40" value="${object.applicantPhone }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.applicantMobile" />：</label>
				 
				 
				<input name="applicantMobile" type="text" <c:if test="${!empty applyLogForm.map.applicantMobile }">readonly="readonly"</c:if> size="40" value="${object.applicantMobile }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.applicantAddress" />：</label>
				 
				 
				<input name="applicantAddress" type="text" <c:if test="${!empty applyLogForm.map.applicantAddress }">readonly="readonly"</c:if> size="40" value="${object.applicantAddress }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.applicantZipcode" />：</label>
				 
				 
				<input name="applicantZipcode" type="text" <c:if test="${!empty applyLogForm.map.applicantZipcode }">readonly="readonly"</c:if> size="40" value="${object.applicantZipcode }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.applicantEmail" />：</label>
				 
				 
				<input name="applicantEmail" type="text" <c:if test="${!empty applyLogForm.map.applicantEmail }">readonly="readonly"</c:if> size="40" value="${object.applicantEmail }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.linkman" />：</label>
				 
				 
				<input name="linkman" type="text" <c:if test="${!empty applyLogForm.map.linkman }">readonly="readonly"</c:if> size="40" value="${object.linkman }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.linkmanName" />：</label>
				 
				 
				<input name="linkmanName" type="text" <c:if test="${!empty applyLogForm.map.linkmanName }">readonly="readonly"</c:if> size="40" value="${object.linkmanName }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.linkmanPaperType" />：</label>
				 
				 
				<input name="linkmanPaperType" type="text" <c:if test="${!empty applyLogForm.map.linkmanPaperType }">readonly="readonly"</c:if> size="40" value="${object.linkmanPaperType }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.linkmanPaperCode" />：</label>
				 
				 
				<input name="linkmanPaperCode" type="text" <c:if test="${!empty applyLogForm.map.linkmanPaperCode }">readonly="readonly"</c:if> size="40" value="${object.linkmanPaperCode }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.linkmanPhone" />：</label>
				 
				 
				<input name="linkmanPhone" type="text" <c:if test="${!empty applyLogForm.map.linkmanPhone }">readonly="readonly"</c:if> size="40" value="${object.linkmanPhone }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.linkmanMobile" />：</label>
				 
				 
				<input name="linkmanMobile" type="text" <c:if test="${!empty applyLogForm.map.linkmanMobile }">readonly="readonly"</c:if> size="40" value="${object.linkmanMobile }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.linkmanAddress" />：</label>
				 
				 
				<input name="linkmanAddress" type="text" <c:if test="${!empty applyLogForm.map.linkmanAddress }">readonly="readonly"</c:if> size="40" value="${object.linkmanAddress }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.linkmanZipcode" />：</label>
				 
				 
				<input name="linkmanZipcode" type="text" <c:if test="${!empty applyLogForm.map.linkmanZipcode }">readonly="readonly"</c:if> size="40" value="${object.linkmanZipcode }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.linkmanEmail" />：</label>
				 
				 
				<input name="linkmanEmail" type="text" <c:if test="${!empty applyLogForm.map.linkmanEmail }">readonly="readonly"</c:if> size="40" value="${object.linkmanEmail }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.promise" />：</label>
				 
				 
				<input name="promise" type="text" <c:if test="${!empty applyLogForm.map.promise }">readonly="readonly"</c:if> size="40" value="${object.promise }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.promiseType" />：</label>
				 
				 
				<input name="promiseType" type="text" <c:if test="${!empty applyLogForm.map.promiseType }">readonly="readonly"</c:if> size="40" value="${object.promiseType }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.isrisk" />：</label>
				 
				 
				<input name="isrisk" type="text" <c:if test="${!empty applyLogForm.map.isrisk }">readonly="readonly"</c:if> size="40" value="${object.isrisk }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.risktype" />：</label>
				 
				 
				<input name="risktype" type="text" <c:if test="${!empty applyLogForm.map.risktype }">readonly="readonly"</c:if> size="40" value="${object.risktype }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.riskdescription" />：</label>
				 
				 
				<input name="riskdescription" type="text" <c:if test="${!empty applyLogForm.map.riskdescription }">readonly="readonly"</c:if> size="40" value="${object.riskdescription }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.riskresult" />：</label>
				 
				 
				<input name="riskresult" type="text" <c:if test="${!empty applyLogForm.map.riskresult }">readonly="readonly"</c:if> size="40" value="${object.riskresult }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.applyDate" />：</label>
				 
				 
				<input name="applyDate" type="text" <c:if test="${!empty applyLogForm.map.applyDate }">readonly="readonly"</c:if> size="40" value="${object.applyDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.createDate" />：</label>
				 
				 
				<input name="createDate" type="text" <c:if test="${!empty applyLogForm.map.createDate }">readonly="readonly"</c:if> size="40" value="${object.createDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.updateDate" />：</label>
				 
				 
				<input name="updateDate" type="text" <c:if test="${!empty applyLogForm.map.updateDate }">readonly="readonly"</c:if> size="40" value="${object.updateDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.syncDate" />：</label>
				 
				 
				<input name="syncDate" type="text" <c:if test="${!empty applyLogForm.map.syncDate }">readonly="readonly"</c:if> size="40" value="${object.syncDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.syncSign" />：</label>
				 
				 
				<input name="syncSign" type="text" <c:if test="${!empty applyLogForm.map.syncSign }">readonly="readonly"</c:if> size="40" value="${object.syncSign }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.syncErrorDesc" />：</label>
				 
				 
				<input name="syncErrorDesc" type="text" <c:if test="${!empty applyLogForm.map.syncErrorDesc }">readonly="readonly"</c:if> size="40" value="${object.syncErrorDesc }"/>
				
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
				<label><c:out value="applyLog.changNo" />：</label>
				 
				 
				<input name="changNo" type="text" class="required" <c:if test="${!empty object.changNo }">readonly="readonly"</c:if> size="40" value="${object.changNo }" />
				
			</p>

			
			<p>
				<label><c:out value="applyLog.orgId" />：</label>
				 
				 
				<input name="orgId" type="text" <c:if test="${!empty applyLogForm.map.orgId }">readonly="readonly"</c:if> size="40" value="${object.orgId }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.internalNo" />：</label>
				 
				 
				<input name="internalNo" type="text" <c:if test="${!empty applyLogForm.map.internalNo }">readonly="readonly"</c:if> size="40" value="${object.internalNo }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.itemId" />：</label>
				 
				 
				<input name="itemId" type="text" <c:if test="${!empty applyLogForm.map.itemId }">readonly="readonly"</c:if> size="40" value="${object.itemId }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.department" />：</label>
				 
				 
				<input name="department" type="text" <c:if test="${!empty applyLogForm.map.department }">readonly="readonly"</c:if> size="40" value="${object.department }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.transactAffairName" />：</label>
				 
				 
				<input name="transactAffairName" type="text" <c:if test="${!empty applyLogForm.map.transactAffairName }">readonly="readonly"</c:if> size="40" value="${object.transactAffairName }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.content" />：</label>
				 
				 
				<input name="content" type="text" <c:if test="${!empty applyLogForm.map.content }">readonly="readonly"</c:if> size="40" value="${object.content }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.applyWay" />：</label>
				 
				 
				<input name="applyWay" type="text" <c:if test="${!empty applyLogForm.map.applyWay }">readonly="readonly"</c:if> size="40" value="${object.applyWay }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.form" />：</label>
				 
				 
				<input name="form" type="text" <c:if test="${!empty applyLogForm.map.form }">readonly="readonly"</c:if> size="40" value="${object.form }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.stuff" />：</label>
				 
				 
				<input name="stuff" type="text" <c:if test="${!empty applyLogForm.map.stuff }">readonly="readonly"</c:if> size="40" value="${object.stuff }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.applicantCode" />：</label>
				 
				 
				<input name="applicantCode" type="text" <c:if test="${!empty applyLogForm.map.applicantCode }">readonly="readonly"</c:if> size="40" value="${object.applicantCode }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.applicantType" />：</label>
				 
				 
				<input name="applicantType" type="text" <c:if test="${!empty applyLogForm.map.applicantType }">readonly="readonly"</c:if> size="40" value="${object.applicantType }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.applicantName" />：</label>
				 
				 
				<input name="applicantName" type="text" <c:if test="${!empty applyLogForm.map.applicantName }">readonly="readonly"</c:if> size="40" value="${object.applicantName }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.applicantPaperType" />：</label>
				 
				 
				<input name="applicantPaperType" type="text" <c:if test="${!empty applyLogForm.map.applicantPaperType }">readonly="readonly"</c:if> size="40" value="${object.applicantPaperType }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.applicantPaperCode" />：</label>
				 
				 
				<input name="applicantPaperCode" type="text" <c:if test="${!empty applyLogForm.map.applicantPaperCode }">readonly="readonly"</c:if> size="40" value="${object.applicantPaperCode }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.applicantPhone" />：</label>
				 
				 
				<input name="applicantPhone" type="text" <c:if test="${!empty applyLogForm.map.applicantPhone }">readonly="readonly"</c:if> size="40" value="${object.applicantPhone }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.applicantMobile" />：</label>
				 
				 
				<input name="applicantMobile" type="text" <c:if test="${!empty applyLogForm.map.applicantMobile }">readonly="readonly"</c:if> size="40" value="${object.applicantMobile }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.applicantAddress" />：</label>
				 
				 
				<input name="applicantAddress" type="text" <c:if test="${!empty applyLogForm.map.applicantAddress }">readonly="readonly"</c:if> size="40" value="${object.applicantAddress }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.applicantZipcode" />：</label>
				 
				 
				<input name="applicantZipcode" type="text" <c:if test="${!empty applyLogForm.map.applicantZipcode }">readonly="readonly"</c:if> size="40" value="${object.applicantZipcode }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.applicantEmail" />：</label>
				 
				 
				<input name="applicantEmail" type="text" <c:if test="${!empty applyLogForm.map.applicantEmail }">readonly="readonly"</c:if> size="40" value="${object.applicantEmail }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.linkman" />：</label>
				 
				 
				<input name="linkman" type="text" <c:if test="${!empty applyLogForm.map.linkman }">readonly="readonly"</c:if> size="40" value="${object.linkman }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.linkmanName" />：</label>
				 
				 
				<input name="linkmanName" type="text" <c:if test="${!empty applyLogForm.map.linkmanName }">readonly="readonly"</c:if> size="40" value="${object.linkmanName }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.linkmanPaperType" />：</label>
				 
				 
				<input name="linkmanPaperType" type="text" <c:if test="${!empty applyLogForm.map.linkmanPaperType }">readonly="readonly"</c:if> size="40" value="${object.linkmanPaperType }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.linkmanPaperCode" />：</label>
				 
				 
				<input name="linkmanPaperCode" type="text" <c:if test="${!empty applyLogForm.map.linkmanPaperCode }">readonly="readonly"</c:if> size="40" value="${object.linkmanPaperCode }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.linkmanPhone" />：</label>
				 
				 
				<input name="linkmanPhone" type="text" <c:if test="${!empty applyLogForm.map.linkmanPhone }">readonly="readonly"</c:if> size="40" value="${object.linkmanPhone }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.linkmanMobile" />：</label>
				 
				 
				<input name="linkmanMobile" type="text" <c:if test="${!empty applyLogForm.map.linkmanMobile }">readonly="readonly"</c:if> size="40" value="${object.linkmanMobile }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.linkmanAddress" />：</label>
				 
				 
				<input name="linkmanAddress" type="text" <c:if test="${!empty applyLogForm.map.linkmanAddress }">readonly="readonly"</c:if> size="40" value="${object.linkmanAddress }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.linkmanZipcode" />：</label>
				 
				 
				<input name="linkmanZipcode" type="text" <c:if test="${!empty applyLogForm.map.linkmanZipcode }">readonly="readonly"</c:if> size="40" value="${object.linkmanZipcode }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.linkmanEmail" />：</label>
				 
				 
				<input name="linkmanEmail" type="text" <c:if test="${!empty applyLogForm.map.linkmanEmail }">readonly="readonly"</c:if> size="40" value="${object.linkmanEmail }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.promise" />：</label>
				 
				 
				<input name="promise" type="text" <c:if test="${!empty applyLogForm.map.promise }">readonly="readonly"</c:if> size="40" value="${object.promise }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.promiseType" />：</label>
				 
				 
				<input name="promiseType" type="text" <c:if test="${!empty applyLogForm.map.promiseType }">readonly="readonly"</c:if> size="40" value="${object.promiseType }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.isrisk" />：</label>
				 
				 
				<input name="isrisk" type="text" <c:if test="${!empty applyLogForm.map.isrisk }">readonly="readonly"</c:if> size="40" value="${object.isrisk }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.risktype" />：</label>
				 
				 
				<input name="risktype" type="text" <c:if test="${!empty applyLogForm.map.risktype }">readonly="readonly"</c:if> size="40" value="${object.risktype }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.riskdescription" />：</label>
				 
				 
				<input name="riskdescription" type="text" <c:if test="${!empty applyLogForm.map.riskdescription }">readonly="readonly"</c:if> size="40" value="${object.riskdescription }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.riskresult" />：</label>
				 
				 
				<input name="riskresult" type="text" <c:if test="${!empty applyLogForm.map.riskresult }">readonly="readonly"</c:if> size="40" value="${object.riskresult }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.applyDate" />：</label>
				 
				 
				<input name="applyDate" type="text" <c:if test="${!empty applyLogForm.map.applyDate }">readonly="readonly"</c:if> size="40" value="${object.applyDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.createDate" />：</label>
				 
				 
				<input name="createDate" type="text" <c:if test="${!empty applyLogForm.map.createDate }">readonly="readonly"</c:if> size="40" value="${object.createDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.updateDate" />：</label>
				 
				 
				<input name="updateDate" type="text" <c:if test="${!empty applyLogForm.map.updateDate }">readonly="readonly"</c:if> size="40" value="${object.updateDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.syncDate" />：</label>
				 
				 
				<input name="syncDate" type="text" <c:if test="${!empty applyLogForm.map.syncDate }">readonly="readonly"</c:if> size="40" value="${object.syncDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.syncSign" />：</label>
				 
				 
				<input name="syncSign" type="text" <c:if test="${!empty applyLogForm.map.syncSign }">readonly="readonly"</c:if> size="40" value="${object.syncSign }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyLog.syncErrorDesc" />：</label>
				 
				 
				<input name="syncErrorDesc" type="text" <c:if test="${!empty applyLogForm.map.syncErrorDesc }">readonly="readonly"</c:if> size="40" value="${object.syncErrorDesc }"/>
				
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
