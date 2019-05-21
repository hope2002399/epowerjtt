<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>



<div class="pageContent">
	<s:form action="/monitor/applyProcess!save.do" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">

		<div class="pageFormContent" layoutH="56">
		
			
			<p>
				<label><c:out value="applyProcess.no" />：</label>
				 
				 
				<input name="no" type="text" class="required" <c:if test="${!empty object.no }">readonly="readonly"</c:if> size="40" value="${object.no }" />
				
			</p>

			
			<p>
				<label><c:out value="applyProcess.noOrd" />：</label>
				 
				 
				<input name="noOrd" type="text" <c:if test="${!empty applyProcessForm.map.noOrd }">readonly="readonly"</c:if> size="40" value="${object.noOrd }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyProcess.orgId" />：</label>
				 
				 
				<input name="orgId" type="text" <c:if test="${!empty applyProcessForm.map.orgId }">readonly="readonly"</c:if> size="40" value="${object.orgId }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyProcess.internalNo" />：</label>
				 
				 
				<input name="internalNo" type="text" <c:if test="${!empty applyProcessForm.map.internalNo }">readonly="readonly"</c:if> size="40" value="${object.internalNo }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyProcess.itemId" />：</label>
				 
				 
				<input name="itemId" type="text" <c:if test="${!empty applyProcessForm.map.itemId }">readonly="readonly"</c:if> size="40" value="${object.itemId }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyProcess.tacheId" />：</label>
				 
				 
				<input name="tacheId" type="text" <c:if test="${!empty applyProcessForm.map.tacheId }">readonly="readonly"</c:if> size="40" value="${object.tacheId }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyProcess.tacheName" />：</label>
				 
				 
				<input name="tacheName" type="text" <c:if test="${!empty applyProcessForm.map.tacheName }">readonly="readonly"</c:if> size="40" value="${object.tacheName }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyProcess.tacheInteNo" />：</label>
				 
				 
				<input name="tacheInteNo" type="text" <c:if test="${!empty applyProcessForm.map.tacheInteNo }">readonly="readonly"</c:if> size="40" value="${object.tacheInteNo }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyProcess.tachePrevIntNo" />：</label>
				 
				 
				<input name="tachePrevIntNo" type="text" <c:if test="${!empty applyProcessForm.map.tachePrevIntNo }">readonly="readonly"</c:if> size="40" value="${object.tachePrevIntNo }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyProcess.department" />：</label>
				 
				 
				<input name="department" type="text" <c:if test="${!empty applyProcessForm.map.department }">readonly="readonly"</c:if> size="40" value="${object.department }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyProcess.userStaffCode" />：</label>
				 
				 
				<input name="userStaffCode" type="text" <c:if test="${!empty applyProcessForm.map.userStaffCode }">readonly="readonly"</c:if> size="40" value="${object.userStaffCode }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyProcess.userName" />：</label>
				 
				 
				<input name="userName" type="text" <c:if test="${!empty applyProcessForm.map.userName }">readonly="readonly"</c:if> size="40" value="${object.userName }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyProcess.status" />：</label>
				 
				 
				<input name="status" type="text" <c:if test="${!empty applyProcessForm.map.status }">readonly="readonly"</c:if> size="40" value="${object.status }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyProcess.promise" />：</label>
				 
				 
				<input name="promise" type="text" <c:if test="${!empty applyProcessForm.map.promise }">readonly="readonly"</c:if> size="40" value="${object.promise }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyProcess.promiseType" />：</label>
				 
				 
				<input name="promiseType" type="text" <c:if test="${!empty applyProcessForm.map.promiseType }">readonly="readonly"</c:if> size="40" value="${object.promiseType }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyProcess.promiseStartSign" />：</label>
				 
				 
				<input name="promiseStartSign" type="text" <c:if test="${!empty applyProcessForm.map.promiseStartSign }">readonly="readonly"</c:if> size="40" value="${object.promiseStartSign }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyProcess.isrisk" />：</label>
				 
				 
				<input name="isrisk" type="text" <c:if test="${!empty applyProcessForm.map.isrisk }">readonly="readonly"</c:if> size="40" value="${object.isrisk }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyProcess.risktype" />：</label>
				 
				 
				<input name="risktype" type="text" <c:if test="${!empty applyProcessForm.map.risktype }">readonly="readonly"</c:if> size="40" value="${object.risktype }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyProcess.riskdescription" />：</label>
				 
				 
				<input name="riskdescription" type="text" <c:if test="${!empty applyProcessForm.map.riskdescription }">readonly="readonly"</c:if> size="40" value="${object.riskdescription }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyProcess.riskresult" />：</label>
				 
				 
				<input name="riskresult" type="text" <c:if test="${!empty applyProcessForm.map.riskresult }">readonly="readonly"</c:if> size="40" value="${object.riskresult }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyProcess.note" />：</label>
				 
				 
				<input name="note" type="text" <c:if test="${!empty applyProcessForm.map.note }">readonly="readonly"</c:if> size="40" value="${object.note }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyProcess.attachment" />：</label>
				 
				 
				<input name="attachment" type="text" <c:if test="${!empty applyProcessForm.map.attachment }">readonly="readonly"</c:if> size="40" value="${object.attachment }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyProcess.processDate" />：</label>
				 
				 
				<input name="processDate" type="text" <c:if test="${!empty applyProcessForm.map.processDate }">readonly="readonly"</c:if> size="40" value="${object.processDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyProcess.nodeId" />：</label>
				 
				 
				<input name="nodeId" type="text" <c:if test="${!empty applyProcessForm.map.nodeId }">readonly="readonly"</c:if> size="40" value="${object.nodeId }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyProcess.nodeAttribute" />：</label>
				 
				 
				<input name="nodeAttribute" type="text" <c:if test="${!empty applyProcessForm.map.nodeAttribute }">readonly="readonly"</c:if> size="40" value="${object.nodeAttribute }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyProcess.createDate" />：</label>
				 
				 
				<input name="createDate" type="text" <c:if test="${!empty applyProcessForm.map.createDate }">readonly="readonly"</c:if> size="40" value="${object.createDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyProcess.updateDate" />：</label>
				 
				 
				<input name="updateDate" type="text" <c:if test="${!empty applyProcessForm.map.updateDate }">readonly="readonly"</c:if> size="40" value="${object.updateDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyProcess.syncDate" />：</label>
				 
				 
				<input name="syncDate" type="text" <c:if test="${!empty applyProcessForm.map.syncDate }">readonly="readonly"</c:if> size="40" value="${object.syncDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyProcess.syncSign" />：</label>
				 
				 
				<input name="syncSign" type="text" <c:if test="${!empty applyProcessForm.map.syncSign }">readonly="readonly"</c:if> size="40" value="${object.syncSign }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyProcess.syncErrorDesc" />：</label>
				 
				 
				<input name="syncErrorDesc" type="text" <c:if test="${!empty applyProcessForm.map.syncErrorDesc }">readonly="readonly"</c:if> size="40" value="${object.syncErrorDesc }"/>
				
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
