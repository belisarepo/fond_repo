<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<portlet:renderURL var="popupBiographyURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="action" value="popup" />
	<portlet:param name="input_id" value="biography" />
</portlet:renderURL>
<c:set var="strPopupBiographyURL"><%=popupBiographyURL.toString()%></c:set>

<aui:form action="${saveForm12}" method="POST" name="form12">

	<aui:input name="id" bean="zayavkaModel" type="hidden" value="${zayavkaModel.id}" />
	<aui:input name="konkursId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.konkursId}" />
	<aui:input name="userId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.userId}" />

	<spring:message code="zayavka.biography" var='biographyLabel' />
	<aui:input name="biographyRk" value="${zayavkaModel.biographyRk}" id="biography" label="${biographyLabel}" bean="zayavkaModel" type="textarea"/>

	<aui:button-row>
		<div align="left">
			<aui:button type="submit" value="Сохранить" />
			<a class="btn" href="${sendZayavka}">Подать</a>
		</div>
	</aui:button-row>
</aui:form>