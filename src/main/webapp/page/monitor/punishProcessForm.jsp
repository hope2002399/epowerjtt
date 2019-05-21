<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>



<div class="pageContent">
	<s:form action="/monitor/punishProcess!save.do" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">

		<div class="pageFormContent" layoutH="56">
		
			
			<p>
				<label><c:out value="punishProcess.no" />：</label>
				 
				 
				<input name="no" type="text" class="required" <c:if test="${!empty object.no }">readonly="readonly"</c:if> size="40" value="${object.no }" />
				
			</p>

			
			<p>
				<label><c:out value="punishProcess.noOrd" />：</label>
				 
				 
				<input name="noOrd" type="text" <c:if test="${!empty punishProcessForm.map.noOrd }">readonly="readonly"</c:if> size="40" value="${object.noOrd }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishProcess.orgId" />：</label>
				 
				 
				<input name="orgId" type="text" <c:if test="${!empty punishProcessForm.map.orgId }">readonly="readonly"</c:if> size="40" value="${object.orgId }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishProcess.internalNo" />：</label>
				 
				 
				<input name="internalNo" type="text" <c:if test="${!empty punishProcessForm.map.internalNo }">readonly="readonly"</c:if> size="40" value="${object.internalNo }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishProcess.itemId" />：</label>
				 
				 
				<input name="itemId" type="text" <c:if test="${!empty punishProcessForm.map.itemId }">readonly="readonly"</c:if> size="40" value="${object.itemId }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishProcess.tacheId" />：</label>
				 
				 
				<input name="tacheId" type="text" <c:if test="${!empty punishProcessForm.map.tacheId }">readonly="readonly"</c:if> size="40" value="${object.tacheId }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishProcess.tacheName" />：</label>
				 
				 
				<input name="tacheName" type="text" <c:if test="${!empty punishProcessForm.map.tacheName }">readonly="readonly"</c:if> size="40" value="${object.tacheName }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishProcess.tacheInteNo" />：</label>
				 
				 
				<input name="tacheInteNo" type="text" <c:if test="${!empty punishProcessForm.map.tacheInteNo }">readonly="readonly"</c:if> size="40" value="${object.tacheInteNo }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishProcess.tachePrevIntNo" />：</label>
				 
				 
				<input name="tachePrevIntNo" type="text" <c:if test="${!empty punishProcessForm.map.tachePrevIntNo }">readonly="readonly"</c:if> size="40" value="${object.tachePrevIntNo }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishProcess.department" />：</label>
				 
				 
				<input name="department" type="text" <c:if test="${!empty punishProcessForm.map.department }">readonly="readonly"</c:if> size="40" value="${object.department }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishProcess.userName" />：</label>
				 
				 
				<input name="userName" type="text" <c:if test="${!empty punishProcessForm.map.userName }">readonly="readonly"</c:if> size="40" value="${object.userName }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishProcess.status" />：</label>
				 
				 
				<input name="status" type="text" <c:if test="${!empty punishProcessForm.map.status }">readonly="readonly"</c:if> size="40" value="${object.status }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishProcess.promise" />：</label>
				 
				 
				<input name="promise" type="text" <c:if test="${!empty punishProcessForm.map.promise }">readonly="readonly"</c:if> size="40" value="${object.promise }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishProcess.promiseType" />：</label>
				 
				 
				<input name="promiseType" type="text" <c:if test="${!empty punishProcessForm.map.promiseType }">readonly="readonly"</c:if> size="40" value="${object.promiseType }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishProcess.promiseStartSign" />：</label>
				 
				 
				<input name="promiseStartSign" type="text" <c:if test="${!empty punishProcessForm.map.promiseStartSign }">readonly="readonly"</c:if> size="40" value="${object.promiseStartSign }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishProcess.isrisk" />：</label>
				 
				 
				<input name="isrisk" type="text" <c:if test="${!empty punishProcessForm.map.isrisk }">readonly="readonly"</c:if> size="40" value="${object.isrisk }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishProcess.risktype" />：</label>
				 
				 
				<input name="risktype" type="text" <c:if test="${!empty punishProcessForm.map.risktype }">readonly="readonly"</c:if> size="40" value="${object.risktype }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishProcess.riskdescription" />：</label>
				 
				 
				<input name="riskdescription" type="text" <c:if test="${!empty punishProcessForm.map.riskdescription }">readonly="readonly"</c:if> size="40" value="${object.riskdescription }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishProcess.riskresult" />：</label>
				 
				 
				<input name="riskresult" type="text" <c:if test="${!empty punishProcessForm.map.riskresult }">readonly="readonly"</c:if> size="40" value="${object.riskresult }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishProcess.note" />：</label>
				 
				 
				<input name="note" type="text" <c:if test="${!empty punishProcessForm.map.note }">readonly="readonly"</c:if> size="40" value="${object.note }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishProcess.attachment" />：</label>
				 
				 
				<input name="attachment" type="text" <c:if test="${!empty punishProcessForm.map.attachment }">readonly="readonly"</c:if> size="40" value="${object.attachment }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishProcess.evidence" />：</label>
				 
				 
				<input name="evidence" type="text" <c:if test="${!empty punishProcessForm.map.evidence }">readonly="readonly"</c:if> size="40" value="${object.evidence }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishProcess.processDate" />：</label>
				 
				 
				<input name="processDate" type="text" <c:if test="${!empty punishProcessForm.map.processDate }">readonly="readonly"</c:if> size="40" value="${object.processDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishProcess.nodeId" />：</label>
				 
				 
				<input name="nodeId" type="text" <c:if test="${!empty punishProcessForm.map.nodeId }">readonly="readonly"</c:if> size="40" value="${object.nodeId }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishProcess.nodeAttribute" />：</label>
				 
				 
				<input name="nodeAttribute" type="text" <c:if test="${!empty punishProcessForm.map.nodeAttribute }">readonly="readonly"</c:if> size="40" value="${object.nodeAttribute }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishProcess.createDate" />：</label>
				 
				 
				<input name="createDate" type="text" <c:if test="${!empty punishProcessForm.map.createDate }">readonly="readonly"</c:if> size="40" value="${object.createDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishProcess.updateDate" />：</label>
				 
				 
				<input name="updateDate" type="text" <c:if test="${!empty punishProcessForm.map.updateDate }">readonly="readonly"</c:if> size="40" value="${object.updateDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishProcess.syncDate" />：</label>
				 
				 
				<input name="syncDate" type="text" <c:if test="${!empty punishProcessForm.map.syncDate }">readonly="readonly"</c:if> size="40" value="${object.syncDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishProcess.syncSign" />：</label>
				 
				 
				<input name="syncSign" type="text" <c:if test="${!empty punishProcessForm.map.syncSign }">readonly="readonly"</c:if> size="40" value="${object.syncSign }"/>
				
			</p>
			
			<p>
				<label><c:out value="punishProcess.syncErrorDesc" />：</label>
				 
				 
				<input name="syncErrorDesc" type="text" <c:if test="${!empty punishProcessForm.map.syncErrorDesc }">readonly="readonly"</c:if> size="40" value="${object.syncErrorDesc }"/>
				
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
