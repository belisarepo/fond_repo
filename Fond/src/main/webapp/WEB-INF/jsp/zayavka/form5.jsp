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


	<spring:message code="zayavka.orgZNr" var='orgZNrLabel' />
	<aui:select name="orgNrId" bean="zayavkaModel" label='${orgZNrLabel}' id="orgNrSelect">
		<option value="" />
		<c:forEach var="i" items="${orgNrList}">
			<aui:option value="${i.id}" label="${i.nameR}" selected="${i.id==zayavkaModel.orgNrId}" />
		</c:forEach>
	</aui:select>
	<spring:message code='zayavka.email' var='emailOrgNrLabel' />
	<aui:input id="orgNrEmail" disabled="true" name="orgNrEmail" value="${zayavkaModel.orgNrEmail}" label='${emailOrgNrLabel}'
		bean="zayavkaModel"></aui:input>

	<spring:message code='zayavka.addressOrg' var='addressOrgLabel' />
	<aui:input id="orgNrAddress" disabled="true" name="orgNrAddress" value="${zayavkaModel.orgNrAddress}" label='${addressOrgLabel}'
		bean="zayavkaModel"></aui:input>

	<aui:button-row>
		<div align="left">
			<aui:button type="submit" value="Сохранить" />
			<a class="btn" href="${sendZayavka}">Подать</a>
		</div>
	</aui:button-row>
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