<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<aui:form action="${saveForm13}" method="POST" name="form13">
	<aui:input name="id" bean="zayavkaModel" type="hidden" value="${zayavkaModel.id}" />
	<aui:input name="konkursId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.konkursId}" />
	<aui:input name="userId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.userId}" />
	
	<table class="table table-bordered table-condensed">

		<tr>
			<th style="background-color: white;"></th>
			<th style="background-color: #F0EFEF"><spring:message code="zayavka.scopus" /></th>
			<th style="background-color: #F0EFEF"><spring:message code="zayavka.isi" /></th>
			<th style="background-color: #F0EFEF"><spring:message code="zayavka.rinc" /></th>
		</tr>


		<tr>
			<th style="background-color: #F0EFEF"><spring:message code="zayavka.countPublication" /></th>
			<td><aui:input name="countPublicationScopus" value="${zayavkaModel.countPublicationScopus}" bean="zayavkaModel" label=""/></td>
			<td><aui:input name="countPublicationISI" value="${zayavkaModel.countPublicationISI}" bean="zayavkaModel" label=""/></td>
			<td><aui:input name="countPublicationRINC" value="${zayavkaModel.countPublicationRINC}" bean="zayavkaModel" label=""/></td>
		</tr>
		<tr>
			<th style="background-color: #F0EFEF"><spring:message code="zayavka.citationIndex" /></th>
			<td><aui:input name="citationIndexScopus" value="${zayavkaModel.citationIndexScopus}" bean="zayavkaModel" label=""/></td>
			<td><aui:input name="citationIndexISI" value="${zayavkaModel.citationIndexISI}" bean="zayavkaModel" label=""/></td>
			<td><aui:input name="citationIndexRINC" value="${zayavkaModel.citationIndexRINC}" bean="zayavkaModel" label=""/></td>
		</tr>
		<tr>
			<th style="background-color: #F0EFEF"><spring:message code="zayavka.indexWithoutSelf" /></th>
			<td><aui:input name="indexWithoutSelfScopus" value="${zayavkaModel.indexWithoutSelfScopus}" bean="zayavkaModel" label=""/></td>
			<td><aui:input name="indexWithoutSelfISI" value="${zayavkaModel.indexWithoutSelfISI}" bean="zayavkaModel" label=""/></td>
			<td><aui:input name="indexWithoutSelfRINC" value="${zayavkaModel.indexWithoutSelfRINC}" bean="zayavkaModel" label=""/></td>
		</tr>
		<tr>
			<th style="background-color: #F0EFEF"><spring:message code="zayavka.indexHirsha" /></th>
			<td><aui:input name="indexHirshaScopus" value="${zayavkaModel.indexHirshaScopus}" bean="zayavkaModel" label=""/></td>
			<td><aui:input name="indexHirshaISI" value="${zayavkaModel.indexHirshaISI}" bean="zayavkaModel" label=""/></td>
			<td><aui:input name="indexHirshaRINC" value="${zayavkaModel.indexHirshaRINC}" bean="zayavkaModel" label=""/></td>
		</tr>
	</table>
	<aui:button-row>
		<div align="left">
			<aui:button type="submit" value="Сохранить" />
			<a class="btn" href="${sendZayavka}">Подать</a>
		</div>
	</aui:button-row>
</aui:form>
