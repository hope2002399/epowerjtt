<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>



<div class="pageContent">
	<s:form action="/monitor/incomeDoc!save.do" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">

		<div class="pageFormContent" layoutH="56">
		
			
			<p>
				<label><c:out value="incomeDoc.no" />：</label>
				 
				 
				<input name="no" type="text" class="required" <c:if test="${!empty object.no }">readonly="readonly"</c:if> size="40" value="${object.no }" />
				
			</p>

			
			<p>
				<label><c:out value="incomeDoc.internalNo" />：</label>
				 
				 
				<input name="internalNo" type="text" <c:if test="${!empty incomeDocForm.map.internalNo }">readonly="readonly"</c:if> size="40" value="${object.internalNo }"/>
				
			</p>
			
			<p>
				<label><c:out value="incomeDoc.itemId" />：</label>
				 
				 
				<input name="itemId" type="text" <c:if test="${!empty incomeDocForm.map.itemId }">readonly="readonly"</c:if> size="40" value="${object.itemId }"/>
				
			</p>
			
			<p>
				<label><c:out value="incomeDoc.acceptNo" />：</label>
				 
				 
				<input name="acceptNo" type="text" <c:if test="${!empty incomeDocForm.map.acceptNo }">readonly="readonly"</c:if> size="40" value="${object.acceptNo }"/>
				
			</p>
			
			<p>
				<label><c:out value="incomeDoc.incomeDocNo" />：</label>
				 
				 
				<input name="incomeDocNo" type="text" <c:if test="${!empty incomeDocForm.map.incomeDocNo }">readonly="readonly"</c:if> size="40" value="${object.incomeDocNo }"/>
				
			</p>
			
			<p>
				<label><c:out value="incomeDoc.incomeDocTitle" />：</label>
				 
				 
				<input name="incomeDocTitle" type="text" <c:if test="${!empty incomeDocForm.map.incomeDocTitle }">readonly="readonly"</c:if> size="40" value="${object.incomeDocTitle }"/>
				
			</p>
			
			<p>
				<label><c:out value="incomeDoc.incomeDeptName" />：</label>
				 
				 
				<input name="incomeDeptName" type="text" <c:if test="${!empty incomeDocForm.map.incomeDeptName }">readonly="readonly"</c:if> size="40" value="${object.incomeDeptName }"/>
				
			</p>
			
			<p>
				<label><c:out value="incomeDoc.incomeDoc" />：</label>
				 
				 
				<input name="incomeDoc" type="text" <c:if test="${!empty incomeDocForm.map.incomeDoc }">readonly="readonly"</c:if> size="40" value="${object.incomeDoc }"/>
				
			</p>
			
			<p>
				<label><c:out value="incomeDoc.syncErrorDesc" />：</label>
				 
				 
				<input name="syncErrorDesc" type="text" <c:if test="${!empty incomeDocForm.map.syncErrorDesc }">readonly="readonly"</c:if> size="40" value="${object.syncErrorDesc }"/>
				
			</p>
			
			<p>
				<label><c:out value="incomeDoc.createDate" />：</label>
				 
				 
				<input name="createDate" type="text" <c:if test="${!empty incomeDocForm.map.createDate }">readonly="readonly"</c:if> size="40" value="${object.createDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="incomeDoc.updateDate" />：</label>
				 
				 
				<input name="updateDate" type="text" <c:if test="${!empty incomeDocForm.map.updateDate }">readonly="readonly"</c:if> size="40" value="${object.updateDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="incomeDoc.syncDate" />：</label>
				 
				 
				<input name="syncDate" type="text" <c:if test="${!empty incomeDocForm.map.syncDate }">readonly="readonly"</c:if> size="40" value="${object.syncDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="incomeDoc.syncSign" />：</label>
				 
				 
				<input name="syncSign" type="text" <c:if test="${!empty incomeDocForm.map.syncSign }">readonly="readonly"</c:if> size="40" value="${object.syncSign }"/>
				
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
