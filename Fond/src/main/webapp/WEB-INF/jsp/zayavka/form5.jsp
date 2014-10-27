<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<aui:form action="${saveForm5}" method="POST" name="form5">
	<aui:input name="id" bean="zayavkaModel" type="hidden" value="${zayavkaModel.id}" />
	<aui:input name="konkursId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.konkursId}" />
	<aui:input name="userId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.userId}" />

	<aui:button-row>
		<div align="left">
			<aui:button type="submit" value="Сохранить" />
		</div>

	</aui:button-row>
	<hr/>
	

	<spring:message code="zayavka.orgZNr" var='orgZNrLabel' />
	<c:choose>
	<c:when test="${not empty zayavkaModel.konkursOrgNrId }">
		<aui:select name="orgNrId" bean="zayavkaModel" label='${orgZNrLabel}' id="orgNrSelect">
		
			<aui:option value="${zayavkaModel.konkursOrgNrId}" label="${zayavkaModel.konkursOrgNrName}" selected="true" />
		
	</aui:select>
	</c:when>
	<c:otherwise>
		<aui:select name="orgNrId" bean="zayavkaModel" label='${orgZNrLabel}' id="orgNrSelect">
		<option value="" />
		<c:forEach var="i" items="${orgNrList}">
			<aui:option value="${i.id}" label="${i.fullName}" selected="${i.id==zayavkaModel.orgNrId}" />
		</c:forEach>
	</aui:select>
	</c:otherwise>
	
	</c:choose>
	<spring:message code='zayavka.email' var='emailOrgNrLabel' />
	<aui:input id="orgNrEmail" disabled="true" name="orgNrEmail" value="${zayavkaModel.orgNrEmail}" label='${emailOrgNrLabel}'
		bean="zayavkaModel"></aui:input>

	<spring:message code='zayavka.addressOrg' var='addressOrgLabel' />
	<aui:input id="orgNrAddress" disabled="true" name="orgNrAddress" value="${zayavkaModel.orgNrAddress}" label='${addressOrgLabel}'
		bean="zayavkaModel"></aui:input>
		
	<portlet:renderURL var="addOrgNrUrl" windowState='<%=LiferayWindowState.POP_UP.toString()%>'><portlet:param name="action" value="addOrgNr" /><portlet:param name="konkursId" value="${zayavkaModel.konkursId}"/></portlet:renderURL>
	<c:set var="strAddOrgNrUrl"><%=addOrgNrUrl.toString()%></c:set>
	<c:if test="${empty zayavkaModel.konkursOrgNrId }">
		<p>Если вы не нашли в списке нужную организацию, добавьте ее <a id="addOrgNr" href="#" class="btn deleteLink">Добавить организацию</a></p>
	</c:if>					
	
	

	
</aui:form>
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<aui:script>
$('#addOrgNr').on('click', function(event){

											showPopup('Добавить организацию',null,'${strAddOrgNrUrl}');
										 }
			);
$('#${ns}orgNrSelect').on('change', function(evt, params) {
		var orgId = $(evt.target).val();
		$.ajax({
			dataType : 'json',
			url : '<portlet:resourceURL id="getOrgNrById" />',
			data : {
				<portlet:namespace />orgId : orgId
			},
			success : function(jsondata) {
				$('#${ns}orgNrEmail').val(jsondata.email);
				$('#${ns}orgNrAddress').val(jsondata.address);
			}
		});
	});
</aui:script>