<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<aui:form action="${saveForm1}" method="POST" name="form1">
	<aui:input name="id" bean="dogovor" type="hidden" value="${dogovor.id}" />
	

	<aui:button-row>
		<div align="left">
			<aui:button type="submit" value="Сохранить" />
		</div>

	</aui:button-row>
	<hr />


	<spring:message code="dogovor.orgIspl" var='orgIsplLabel' />
	<aui:select name="orgId" bean="dogovor" label='${orgIsplLabel}' id="orgSelect">
		<option value="" />
		<c:forEach var="i" items="${orgList}">
			<aui:option value="${i.id}" label="${i.fullNameR}" selected="${i.id==dogovor.orgId}" />
		</c:forEach>
	</aui:select>
</aui:form>
