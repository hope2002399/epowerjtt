<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>



<div class="pageContent">
	<s:form action="/monitor/apply!save.do" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">

		<div class="pageFormContent" layoutH="56">
		
			
			<p>
				<label><c:out value="apply.no" />：</label>
				 
				 
				<input name="no" type="text" class="required" <c:if test="${!empty object.no }">readonly="readonly"</c:if> size="40" value="${object.no }" />
				
			</p>

			
			<p>
				<label><c:out value="apply.changNo" />：</label>
				 
				 
				<input name="changNo" type="text" <c:if test="${!empty applyForm.map.changNo }">readonly="readonly"</c:if> size="40" value="${object.changNo }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.orgId" />：</label>
				 
				 
				<input name="orgId" type="text" <c:if test="${!empty applyForm.map.orgId }">readonly="readonly"</c:if> size="40" value="${object.orgId }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.internalNo" />：</label>
				 
				 
				<input name="internalNo" type="text" <c:if test="${!empty applyForm.map.internalNo }">readonly="readonly"</c:if> size="40" value="${object.internalNo }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.itemId" />：</label>
				 
				 
				<input name="itemId" type="text" <c:if test="${!empty applyForm.map.itemId }">readonly="readonly"</c:if> size="40" value="${object.itemId }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.department" />：</label>
				 
				 
				<input name="department" type="text" <c:if test="${!empty applyForm.map.department }">readonly="readonly"</c:if> size="40" value="${object.department }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.transactAffairName" />：</label>
				 
				 
				<input name="transactAffairName" type="text" <c:if test="${!empty applyForm.map.transactAffairName }">readonly="readonly"</c:if> size="40" value="${object.transactAffairName }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.content" />：</label>
				 
				 
				<input name="content" type="text" <c:if test="${!empty applyForm.map.content }">readonly="readonly"</c:if> size="40" value="${object.content }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.applyWay" />：</label>
				 
				 
				<input name="applyWay" type="text" <c:if test="${!empty applyForm.map.applyWay }">readonly="readonly"</c:if> size="40" value="${object.applyWay }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.form" />：</label>
				 
				 
				<input name="form" type="text" <c:if test="${!empty applyForm.map.form }">readonly="readonly"</c:if> size="40" value="${object.form }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.stuff" />：</label>
				 
				 
				<input name="stuff" type="text" <c:if test="${!empty applyForm.map.stuff }">readonly="readonly"</c:if> size="40" value="${object.stuff }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.applicantCode" />：</label>
				 
				 
				<input name="applicantCode" type="text" <c:if test="${!empty applyForm.map.applicantCode }">readonly="readonly"</c:if> size="40" value="${object.applicantCode }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.applicantType" />：</label>
				 
				 
				<input name="applicantType" type="text" <c:if test="${!empty applyForm.map.applicantType }">readonly="readonly"</c:if> size="40" value="${object.applicantType }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.applicantName" />：</label>
				 
				 
				<input name="applicantName" type="text" <c:if test="${!empty applyForm.map.applicantName }">readonly="readonly"</c:if> size="40" value="${object.applicantName }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.applicantPaperType" />：</label>
				 
				 
				<input name="applicantPaperType" type="text" <c:if test="${!empty applyForm.map.applicantPaperType }">readonly="readonly"</c:if> size="40" value="${object.applicantPaperType }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.applicantPaperCode" />：</label>
				 
				 
				<input name="applicantPaperCode" type="text" <c:if test="${!empty applyForm.map.applicantPaperCode }">readonly="readonly"</c:if> size="40" value="${object.applicantPaperCode }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.applicantPhone" />：</label>
				 
				 
				<input name="applicantPhone" type="text" <c:if test="${!empty applyForm.map.applicantPhone }">readonly="readonly"</c:if> size="40" value="${object.applicantPhone }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.applicantMobile" />：</label>
				 
				 
				<input name="applicantMobile" type="text" <c:if test="${!empty applyForm.map.applicantMobile }">readonly="readonly"</c:if> size="40" value="${object.applicantMobile }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.applicantAddress" />：</label>
				 
				 
				<input name="applicantAddress" type="text" <c:if test="${!empty applyForm.map.applicantAddress }">readonly="readonly"</c:if> size="40" value="${object.applicantAddress }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.applicantZipcode" />：</label>
				 
				 
				<input name="applicantZipcode" type="text" <c:if test="${!empty applyForm.map.applicantZipcode }">readonly="readonly"</c:if> size="40" value="${object.applicantZipcode }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.applicantEmail" />：</label>
				 
				 
				<input name="applicantEmail" type="text" <c:if test="${!empty applyForm.map.applicantEmail }">readonly="readonly"</c:if> size="40" value="${object.applicantEmail }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.linkman" />：</label>
				 
				 
				<input name="linkman" type="text" <c:if test="${!empty applyForm.map.linkman }">readonly="readonly"</c:if> size="40" value="${object.linkman }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.linkmanName" />：</label>
				 
				 
				<input name="linkmanName" type="text" <c:if test="${!empty applyForm.map.linkmanName }">readonly="readonly"</c:if> size="40" value="${object.linkmanName }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.linkmanPaperType" />：</label>
				 
				 
				<input name="linkmanPaperType" type="text" <c:if test="${!empty applyForm.map.linkmanPaperType }">readonly="readonly"</c:if> size="40" value="${object.linkmanPaperType }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.linkmanPaperCode" />：</label>
				 
				 
				<input name="linkmanPaperCode" type="text" <c:if test="${!empty applyForm.map.linkmanPaperCode }">readonly="readonly"</c:if> size="40" value="${object.linkmanPaperCode }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.linkmanPhone" />：</label>
				 
				 
				<input name="linkmanPhone" type="text" <c:if test="${!empty applyForm.map.linkmanPhone }">readonly="readonly"</c:if> size="40" value="${object.linkmanPhone }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.linkmanMobile" />：</label>
				 
				 
				<input name="linkmanMobile" type="text" <c:if test="${!empty applyForm.map.linkmanMobile }">readonly="readonly"</c:if> size="40" value="${object.linkmanMobile }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.linkmanAddress" />：</label>
				 
				 
				<input name="linkmanAddress" type="text" <c:if test="${!empty applyForm.map.linkmanAddress }">readonly="readonly"</c:if> size="40" value="${object.linkmanAddress }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.linkmanZipcode" />：</label>
				 
				 
				<input name="linkmanZipcode" type="text" <c:if test="${!empty applyForm.map.linkmanZipcode }">readonly="readonly"</c:if> size="40" value="${object.linkmanZipcode }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.linkmanEmail" />：</label>
				 
				 
				<input name="linkmanEmail" type="text" <c:if test="${!empty applyForm.map.linkmanEmail }">readonly="readonly"</c:if> size="40" value="${object.linkmanEmail }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.promise" />：</label>
				 
				 
				<input name="promise" type="text" <c:if test="${!empty applyForm.map.promise }">readonly="readonly"</c:if> size="40" value="${object.promise }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.promiseType" />：</label>
				 
				 
				<input name="promiseType" type="text" <c:if test="${!empty applyForm.map.promiseType }">readonly="readonly"</c:if> size="40" value="${object.promiseType }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.isrisk" />：</label>
				 
				 
				<input name="isrisk" type="text" <c:if test="${!empty applyForm.map.isrisk }">readonly="readonly"</c:if> size="40" value="${object.isrisk }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.risktype" />：</label>
				 
				 
				<input name="risktype" type="text" <c:if test="${!empty applyForm.map.risktype }">readonly="readonly"</c:if> size="40" value="${object.risktype }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.riskdescription" />：</label>
				 
				 
				<input name="riskdescription" type="text" <c:if test="${!empty applyForm.map.riskdescription }">readonly="readonly"</c:if> size="40" value="${object.riskdescription }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.riskresult" />：</label>
				 
				 
				<input name="riskresult" type="text" <c:if test="${!empty applyForm.map.riskresult }">readonly="readonly"</c:if> size="40" value="${object.riskresult }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.applyDate" />：</label>
				 
				 
				<input name="applyDate" type="text" <c:if test="${!empty applyForm.map.applyDate }">readonly="readonly"</c:if> size="40" value="${object.applyDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.createDate" />：</label>
				 
				 
				<input name="createDate" type="text" <c:if test="${!empty applyForm.map.createDate }">readonly="readonly"</c:if> size="40" value="${object.createDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.updateDate" />：</label>
				 
				 
				<input name="updateDate" type="text" <c:if test="${!empty applyForm.map.updateDate }">readonly="readonly"</c:if> size="40" value="${object.updateDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.syncDate" />：</label>
				 
				 
				<input name="syncDate" type="text" <c:if test="${!empty applyForm.map.syncDate }">readonly="readonly"</c:if> size="40" value="${object.syncDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.syncSign" />：</label>
				 
				 
				<input name="syncSign" type="text" <c:if test="${!empty applyForm.map.syncSign }">readonly="readonly"</c:if> size="40" value="${object.syncSign }"/>
				
			</p>
			
			<p>
				<label><c:out value="apply.syncErrorDesc" />：</label>
				 
				 
				<input name="syncErrorDesc" type="text" <c:if test="${!empty applyForm.map.syncErrorDesc }">readonly="readonly"</c:if> size="40" value="${object.syncErrorDesc }"/>
				
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
