<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>



<div class="pageContent">
	<s:form action="/monitor/outwaycalc!save.do" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">

		<div class="pageFormContent" layoutH="56">
		
			
			<p>
				<label><c:out value="outwaycalc.calcNo" />ï¼?/label>
				 
				 
				<input name="calcNo" type="text" class="required" <c:if test="${!empty object.calcNo }">readonly="readonly"</c:if> size="40" value="${object.calcNo }" />
				
			</p>

			
			<p>
				<label><c:out value="outwaycalc.calcTime" />ï¼?/label>
				 
				 
				<input name="calcTime" type="text" <c:if test="${!empty outwaycalcForm.map.calcTime }">readonly="readonly"</c:if> size="40" value="${object.calcTime }"/>
				
			</p>
			
			<p>
				<label><c:out value="outwaycalc.callType" />ï¼?/label>
				 
				 
				<input name="callType" type="text" <c:if test="${!empty outwaycalcForm.map.callType }">readonly="readonly"</c:if> size="40" value="${object.callType }"/>
				
			</p>
			
			<p>
				<label><c:out value="outwaycalc.caller" />ï¼?/label>
				 
				 
				<input name="caller" type="text" <c:if test="${!empty outwaycalcForm.map.caller }">readonly="readonly"</c:if> size="40" value="${object.caller }"/>
				
			</p>
			
			<p>
				<label><c:out value="outwaycalc.scopeBegin" />ï¼?/label>
				 
				 
				<input name="scopeBegin" type="text" <c:if test="${!empty outwaycalcForm.map.scopeBegin }">readonly="readonly"</c:if> size="40" value="${object.scopeBegin }"/>
				
			</p>
			
			<p>
				<label><c:out value="outwaycalc.scopeEnd" />ï¼?/label>
				 
				 
				<input name="scopeEnd" type="text" <c:if test="${!empty outwaycalcForm.map.scopeEnd }">readonly="readonly"</c:if> size="40" value="${object.scopeEnd }"/>
				
			</p>
			
			<p>
				<label><c:out value="outwaycalc.alertPieces" />ï¼?/label>
				 
				 
				<input name="alertPieces" type="text" <c:if test="${!empty outwaycalcForm.map.alertPieces }">readonly="readonly"</c:if> size="40" value="${object.alertPieces }"/>
				
			</p>
			
			<p>
				<label><c:out value="outwaycalc.alarmPieces" />ï¼?/label>
				 
				 
				<input name="alarmPieces" type="text" <c:if test="${!empty outwaycalcForm.map.alarmPieces }">readonly="readonly"</c:if> size="40" value="${object.alarmPieces }"/>
				
			</p>
			
			
			
			
		</div>


		<div class="formBar">
			<ul>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">ä¿å­˜</button>
						</div>
					</div></li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="button" class="close">å–æ¶ˆ</button>
						</div>
					</div>
				</li>
			</ul>
		</div>

	</s:form>
</div>
