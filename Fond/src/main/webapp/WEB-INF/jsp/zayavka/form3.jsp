<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<aui:form action="${saveForm3}" method="POST" name="form3">
	<aui:input name="id" bean="zayavkaModel" type="hidden" value="${zayavkaModel.id}" />
	<aui:input name="konkursId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.konkursId}" />
	<aui:input name="userId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.userId}" />


	<spring:message code="zayavka.orgZRB" var='orgZRBLabel' />
	<aui:select name="orgId" bean="zayavkaModel" label='${orgZRBLabel}' id="orgSelect">
		<option value="" />
		<c:forEach var="i" items="${listOrg}">
			<aui:option value="${i.id}" label="${i.name}" selected="${i.id==zayavkaModel.orgId}" />
		</c:forEach>
	</aui:select>
	<spring:message code='zayavka.email' var='emailLabel' />
	<aui:input id="orgEmailRb" disabled="true" name="orgEmail" value="${zayavkaModel.orgEmail}" label='${emailLabel}' bean="zayavkaModel"></aui:input>

	<spring:message code='zayavka.okogu' var='okoguLabel' />
	<aui:input id="okoguRb" disabled="true" name="okoguName" value="${zayavkaModel.okoguName}" label='${okoguLabel}' bean="zayavkaModel"></aui:input>

	<spring:message code='zayavka.addressOrg' var='addressOrgLabel' />
	<aui:input id="orgAddressRb" disabled="true" name="orgAddress" value="${zayavkaModel.orgAddress}" label='${addressOrgLabel}'
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