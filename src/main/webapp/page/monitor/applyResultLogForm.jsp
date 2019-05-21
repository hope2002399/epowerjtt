<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>



<div class="pageContent">
	<s:form action="/monitor/applyResultLog!save.do" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">

		<div class="pageFormContent" layoutH="56">
		
			
			<p>
				<label><c:out value="applyResultLog.no" />：</label>
				 
				 
				<input name="no" type="text" class="required" <c:if test="${!empty object.no }">readonly="readonly"</c:if> size="40" value="${object.no }" />
				
			</p>

			
			<p>
				<label><c:out value="applyResultLog.orgId" />：</label>
				 
				 
				<input name="orgId" type="text" <c:if test="${!empty applyResultLogForm.map.orgId }">readonly="readonly"</c:if> size="40" value="${object.orgId }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyResultLog.internalNo" />：</label>
				 
				 
				<input name="internalNo" type="text" <c:if test="${!empty applyResultLogForm.map.internalNo }">readonly="readonly"</c:if> size="40" value="${object.internalNo }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyResultLog.itemId" />：</label>
				 
				 
				<input name="itemId" type="text" <c:if test="${!empty applyResultLogForm.map.itemId }">readonly="readonly"</c:if> size="40" value="${object.itemId }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyResultLog.status" />：</label>
				 
				 
				<input name="status" type="text" <c:if test="${!empty applyResultLogForm.map.status }">readonly="readonly"</c:if> size="40" value="${object.status }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyResultLog.note" />：</label>
				 
				 
				<input name="note" type="text" <c:if test="${!empty applyResultLogForm.map.note }">readonly="readonly"</c:if> size="40" value="${object.note }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyResultLog.attachment" />：</label>
				 
				 
				<input name="attachment" type="text" <c:if test="${!empty applyResultLogForm.map.attachment }">readonly="readonly"</c:if> size="40" value="${object.attachment }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyResultLog.finishTime" />：</label>
				 
				 
				<input name="finishTime" type="text" <c:if test="${!empty applyResultLogForm.map.finishTime }">readonly="readonly"</c:if> size="40" value="${object.finishTime }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyResultLog.receivable" />：</label>
				 
				 
				<input name="receivable" type="text" <c:if test="${!empty applyResultLogForm.map.receivable }">readonly="readonly"</c:if> size="40" value="${object.receivable }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyResultLog.paid" />：</label>
				 
				 
				<input name="paid" type="text" <c:if test="${!empty applyResultLogForm.map.paid }">readonly="readonly"</c:if> size="40" value="${object.paid }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyResultLog.reliefReasons" />：</label>
				 
				 
				<input name="reliefReasons" type="text" <c:if test="${!empty applyResultLogForm.map.reliefReasons }">readonly="readonly"</c:if> size="40" value="${object.reliefReasons }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyResultLog.createDate" />：</label>
				 
				 
				<input name="createDate" type="text" <c:if test="${!empty applyResultLogForm.map.createDate }">readonly="readonly"</c:if> size="40" value="${object.createDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyResultLog.updateDate" />：</label>
				 
				 
				<input name="updateDate" type="text" <c:if test="${!empty applyResultLogForm.map.updateDate }">readonly="readonly"</c:if> size="40" value="${object.updateDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyResultLog.syncDate" />：</label>
				 
				 
				<input name="syncDate" type="text" <c:if test="${!empty applyResultLogForm.map.syncDate }">readonly="readonly"</c:if> size="40" value="${object.syncDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyResultLog.syncSign" />：</label>
				 
				 
				<input name="syncSign" type="text" <c:if test="${!empty applyResultLogForm.map.syncSign }">readonly="readonly"</c:if> size="40" value="${object.syncSign }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyResultLog.syncErrorDesc" />：</label>
				 
				 
				<input name="syncErrorDesc" type="text" <c:if test="${!empty applyResultLogForm.map.syncErrorDesc }">readonly="readonly"</c:if> size="40" value="${object.syncErrorDesc }"/>
				
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
				<label><c:out value="applyResultLog.changNo" />：</label>
				 
				 
				<input name="changNo" type="text" class="required" <c:if test="${!empty object.changNo }">readonly="readonly"</c:if> size="40" value="${object.changNo }" />
				
			</p>

			
			<p>
				<label><c:out value="applyResultLog.orgId" />：</label>
				 
				 
				<input name="orgId" type="text" <c:if test="${!empty applyResultLogForm.map.orgId }">readonly="readonly"</c:if> size="40" value="${object.orgId }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyResultLog.internalNo" />：</label>
				 
				 
				<input name="internalNo" type="text" <c:if test="${!empty applyResultLogForm.map.internalNo }">readonly="readonly"</c:if> size="40" value="${object.internalNo }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyResultLog.itemId" />：</label>
				 
				 
				<input name="itemId" type="text" <c:if test="${!empty applyResultLogForm.map.itemId }">readonly="readonly"</c:if> size="40" value="${object.itemId }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyResultLog.status" />：</label>
				 
				 
				<input name="status" type="text" <c:if test="${!empty applyResultLogForm.map.status }">readonly="readonly"</c:if> size="40" value="${object.status }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyResultLog.note" />：</label>
				 
				 
				<input name="note" type="text" <c:if test="${!empty applyResultLogForm.map.note }">readonly="readonly"</c:if> size="40" value="${object.note }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyResultLog.attachment" />：</label>
				 
				 
				<input name="attachment" type="text" <c:if test="${!empty applyResultLogForm.map.attachment }">readonly="readonly"</c:if> size="40" value="${object.attachment }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyResultLog.finishTime" />：</label>
				 
				 
				<input name="finishTime" type="text" <c:if test="${!empty applyResultLogForm.map.finishTime }">readonly="readonly"</c:if> size="40" value="${object.finishTime }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyResultLog.receivable" />：</label>
				 
				 
				<input name="receivable" type="text" <c:if test="${!empty applyResultLogForm.map.receivable }">readonly="readonly"</c:if> size="40" value="${object.receivable }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyResultLog.paid" />：</label>
				 
				 
				<input name="paid" type="text" <c:if test="${!empty applyResultLogForm.map.paid }">readonly="readonly"</c:if> size="40" value="${object.paid }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyResultLog.reliefReasons" />：</label>
				 
				 
				<input name="reliefReasons" type="text" <c:if test="${!empty applyResultLogForm.map.reliefReasons }">readonly="readonly"</c:if> size="40" value="${object.reliefReasons }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyResultLog.createDate" />：</label>
				 
				 
				<input name="createDate" type="text" <c:if test="${!empty applyResultLogForm.map.createDate }">readonly="readonly"</c:if> size="40" value="${object.createDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyResultLog.updateDate" />：</label>
				 
				 
				<input name="updateDate" type="text" <c:if test="${!empty applyResultLogForm.map.updateDate }">readonly="readonly"</c:if> size="40" value="${object.updateDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyResultLog.syncDate" />：</label>
				 
				 
				<input name="syncDate" type="text" <c:if test="${!empty applyResultLogForm.map.syncDate }">readonly="readonly"</c:if> size="40" value="${object.syncDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyResultLog.syncSign" />：</label>
				 
				 
				<input name="syncSign" type="text" <c:if test="${!empty applyResultLogForm.map.syncSign }">readonly="readonly"</c:if> size="40" value="${object.syncSign }"/>
				
			</p>
			
			<p>
				<label><c:out value="applyResultLog.syncErrorDesc" />：</label>
				 
				 
				<input name="syncErrorDesc" type="text" <c:if test="${!empty applyResultLogForm.map.syncErrorDesc }">readonly="readonly"</c:if> size="40" value="${object.syncErrorDesc }"/>
				
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
