<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>



<div class="pageContent">
	<s:form action="/monitor/dispatchDoc!save.do" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">

		<div class="pageFormContent" layoutH="56">
		
			
			<p>
				<label><c:out value="dispatchDoc.no" />：</label>
				 
				 
				<input name="no" type="text" class="required" <c:if test="${!empty object.no }">readonly="readonly"</c:if> size="40" value="${object.no }" />
				
			</p>

			
			<p>
				<label><c:out value="dispatchDoc.internalNo" />：</label>
				 
				 
				<input name="internalNo" type="text" <c:if test="${!empty dispatchDocForm.map.internalNo }">readonly="readonly"</c:if> size="40" value="${object.internalNo }"/>
				
			</p>
			
			<p>
				<label><c:out value="dispatchDoc.itemId" />：</label>
				 
				 
				<input name="itemId" type="text" <c:if test="${!empty dispatchDocForm.map.itemId }">readonly="readonly"</c:if> size="40" value="${object.itemId }"/>
				
			</p>
			
			<p>
				<label><c:out value="dispatchDoc.dispatchDocNo" />：</label>
				 
				 
				<input name="dispatchDocNo" type="text" <c:if test="${!empty dispatchDocForm.map.dispatchDocNo }">readonly="readonly"</c:if> size="40" value="${object.dispatchDocNo }"/>
				
			</p>
			
			<p>
				<label><c:out value="dispatchDoc.dispatchDocTitle" />：</label>
				 
				 
				<input name="dispatchDocTitle" type="text" <c:if test="${!empty dispatchDocForm.map.dispatchDocTitle }">readonly="readonly"</c:if> size="40" value="${object.dispatchDocTitle }"/>
				
			</p>
			
			<p>
				<label><c:out value="dispatchDoc.dispatchFileType" />：</label>
				 
				 
				<input name="dispatchFileType" type="text" <c:if test="${!empty dispatchDocForm.map.dispatchFileType }">readonly="readonly"</c:if> size="40" value="${object.dispatchFileType }"/>
				
			</p>
			
			<p>
				<label><c:out value="dispatchDoc.dispatchDocType" />：</label>
				 
				 
				<input name="dispatchDocType" type="text" <c:if test="${!empty dispatchDocForm.map.dispatchDocType }">readonly="readonly"</c:if> size="40" value="${object.dispatchDocType }"/>
				
			</p>
			
			<p>
				<label><c:out value="dispatchDoc.dispatchCanOpen" />：</label>
				 
				 
				<input name="dispatchCanOpen" type="text" <c:if test="${!empty dispatchDocForm.map.dispatchCanOpen }">readonly="readonly"</c:if> size="40" value="${object.dispatchCanOpen }"/>
				
			</p>
			
			<p>
				<label><c:out value="dispatchDoc.dispatchOpenType" />：</label>
				 
				 
				<input name="dispatchOpenType" type="text" <c:if test="${!empty dispatchDocForm.map.dispatchOpenType }">readonly="readonly"</c:if> size="40" value="${object.dispatchOpenType }"/>
				
			</p>
			
			<p>
				<label><c:out value="dispatchDoc.notOpenReason" />：</label>
				 
				 
				<input name="notOpenReason" type="text" <c:if test="${!empty dispatchDocForm.map.notOpenReason }">readonly="readonly"</c:if> size="40" value="${object.notOpenReason }"/>
				
			</p>
			
			<p>
				<label><c:out value="dispatchDoc.isUnionDispatch" />：</label>
				 
				 
				<input name="isUnionDispatch" type="text" <c:if test="${!empty dispatchDocForm.map.isUnionDispatch }">readonly="readonly"</c:if> size="40" value="${object.isUnionDispatch }"/>
				
			</p>
			
			<p>
				<label><c:out value="dispatchDoc.unionOthers" />：</label>
				 
				 
				<input name="unionOthers" type="text" <c:if test="${!empty dispatchDocForm.map.unionOthers }">readonly="readonly"</c:if> size="40" value="${object.unionOthers }"/>
				
			</p>
			
			<p>
				<label><c:out value="dispatchDoc.isCountersign" />：</label>
				 
				 
				<input name="isCountersign" type="text" <c:if test="${!empty dispatchDocForm.map.isCountersign }">readonly="readonly"</c:if> size="40" value="${object.isCountersign }"/>
				
			</p>
			
			<p>
				<label><c:out value="dispatchDoc.dispatchDocSummary" />：</label>
				 
				 
				<input name="dispatchDocSummary" type="text" <c:if test="${!empty dispatchDocForm.map.dispatchDocSummary }">readonly="readonly"</c:if> size="40" value="${object.dispatchDocSummary }"/>
				
			</p>
			
			<p>
				<label><c:out value="dispatchDoc.draftDate" />：</label>
				 
				 
				<input name="draftDate" type="text" <c:if test="${!empty dispatchDocForm.map.draftDate }">readonly="readonly"</c:if> size="40" value="${object.draftDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="dispatchDoc.optUnitName" />：</label>
				 
				 
				<input name="optUnitName" type="text" <c:if test="${!empty dispatchDocForm.map.optUnitName }">readonly="readonly"</c:if> size="40" value="${object.optUnitName }"/>
				
			</p>
			
			<p>
				<label><c:out value="dispatchDoc.draftUserName" />：</label>
				 
				 
				<input name="draftUserName" type="text" <c:if test="${!empty dispatchDocForm.map.draftUserName }">readonly="readonly"</c:if> size="40" value="${object.draftUserName }"/>
				
			</p>
			
			<p>
				<label><c:out value="dispatchDoc.secretsDegree" />：</label>
				 
				 
				<input name="secretsDegree" type="text" <c:if test="${!empty dispatchDocForm.map.secretsDegree }">readonly="readonly"</c:if> size="40" value="${object.secretsDegree }"/>
				
			</p>
			
			<p>
				<label><c:out value="dispatchDoc.copies" />：</label>
				 
				 
				<input name="copies" type="text" <c:if test="${!empty dispatchDocForm.map.copies }">readonly="readonly"</c:if> size="40" value="${object.copies }"/>
				
			</p>
			
			<p>
				<label><c:out value="dispatchDoc.mainNotifyUnit" />：</label>
				 
				 
				<input name="mainNotifyUnit" type="text" <c:if test="${!empty dispatchDocForm.map.mainNotifyUnit }">readonly="readonly"</c:if> size="40" value="${object.mainNotifyUnit }"/>
				
			</p>
			
			<p>
				<label><c:out value="dispatchDoc.otherUnits" />：</label>
				 
				 
				<input name="otherUnits" type="text" <c:if test="${!empty dispatchDocForm.map.otherUnits }">readonly="readonly"</c:if> size="40" value="${object.otherUnits }"/>
				
			</p>
			
			<p>
				<label><c:out value="dispatchDoc.retentionPeriod" />：</label>
				 
				 
				<input name="retentionPeriod" type="text" <c:if test="${!empty dispatchDocForm.map.retentionPeriod }">readonly="readonly"</c:if> size="40" value="${object.retentionPeriod }"/>
				
			</p>
			
			<p>
				<label><c:out value="dispatchDoc.checkUserName" />：</label>
				 
				 
				<input name="checkUserName" type="text" <c:if test="${!empty dispatchDocForm.map.checkUserName }">readonly="readonly"</c:if> size="40" value="${object.checkUserName }"/>
				
			</p>
			
			<p>
				<label><c:out value="dispatchDoc.dispatchDoc" />：</label>
				 
				 
				<input name="dispatchDoc" type="text" <c:if test="${!empty dispatchDocForm.map.dispatchDoc }">readonly="readonly"</c:if> size="40" value="${object.dispatchDoc }"/>
				
			</p>
			
			<p>
				<label><c:out value="dispatchDoc.createDate" />：</label>
				 
				 
				<input name="createDate" type="text" <c:if test="${!empty dispatchDocForm.map.createDate }">readonly="readonly"</c:if> size="40" value="${object.createDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="dispatchDoc.updateDate" />：</label>
				 
				 
				<input name="updateDate" type="text" <c:if test="${!empty dispatchDocForm.map.updateDate }">readonly="readonly"</c:if> size="40" value="${object.updateDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="dispatchDoc.syncDate" />：</label>
				 
				 
				<input name="syncDate" type="text" <c:if test="${!empty dispatchDocForm.map.syncDate }">readonly="readonly"</c:if> size="40" value="${object.syncDate }"/>
				
			</p>
			
			<p>
				<label><c:out value="dispatchDoc.syncSign" />：</label>
				 
				 
				<input name="syncSign" type="text" <c:if test="${!empty dispatchDocForm.map.syncSign }">readonly="readonly"</c:if> size="40" value="${object.syncSign }"/>
				
			</p>
			
			<p>
				<label><c:out value="dispatchDoc.syncErrorDesc" />：</label>
				 
				 
				<input name="syncErrorDesc" type="text" <c:if test="${!empty dispatchDocForm.map.syncErrorDesc }">readonly="readonly"</c:if> size="40" value="${object.syncErrorDesc }"/>
				
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
