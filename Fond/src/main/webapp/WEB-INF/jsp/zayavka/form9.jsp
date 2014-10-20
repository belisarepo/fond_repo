<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<aui:form action="${saveForm9}" method="POST" name="form9">
	<aui:input name="id" bean="zayavkaModel" type="hidden" value="${zayavkaModel.id}" />
	<aui:input name="konkursId" type="hidden" value="${zayavkaModel.konkursId}" />
	<aui:input name="userId" type="hidden" value="${zayavkaModel.userId}" />

	<aui:button-row>
		<div align="left">
			<aui:button type="submit" value="Сохранить" />
		</div>

	</aui:button-row>
	<hr/>
	

	<spring:message code='zayavka.costAll' var='costAllLabel' />
	<aui:input name="costAll" value="${zayavkaModel.costAll}" label="${costAllLabel}" bean="zayavkaModel">
		<aui:validator name="required" />
		<aui:validator name="number" />
	</aui:input>

	<spring:message code='zayavka.costFirstYear' var='costFirstYearLabel' />
	<aui:input name="costFirstYear" value="${zayavkaModel.costFirstYear}" label="${costFirstYearLabel}" bean="zayavkaModel">
		<aui:validator name="required" />
		<aui:validator name="number" />
	</aui:input>
	
</aui:form>