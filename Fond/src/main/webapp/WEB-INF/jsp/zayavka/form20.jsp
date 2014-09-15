<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<div id="publRuk">
	<h3>Список публикаций руководителя проекта ${zayavkaModel.fioRk}</h3>
	<c:if test="${not empty zayavkaModel.fizInfoDTO.publications}">
		<table class="table table-condensed table-bordered" style="width: auto">

			<thead>
				<tr>
					<th><spring:message code="zayavka.pn" /></th>
					<th><spring:message code="zayavka.publType" /></th>
					<th><spring:message code="zayavka.publName" /></th>
					<th><spring:message code="zayavka.publIzdanie" /></th>
					<th><spring:message code="zayavka.pages" /></th>
					<th><spring:message code="zayavka.soauthors" /></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${zayavkaModel.fizInfoDTO.publications}" var="i" varStatus="n">
					<tr>
						<td>${n.index+1}</td>
						<td>${i.publicationTypeName}</td>
						<td>${i.name}</td>
						<td>${i.edition}</td>
						<td>${i.pages}</td>
						<td>${i.authors}</td>
						<td><a
							href="<portlet:actionURL><portlet:param name="action" value="deletePublicationM"/><portlet:param name="publicationId" value="${i.id}"/><portlet:param name="konkursId" value="${zayavkaModel.konkursId}" /></portlet:actionURL>">Удалить</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<portlet:actionURL var="addPublicationMAction">
		<portlet:param name="action" value="addPublicationM" />
		<%-- <portlet:param name="fizInfoId" value="${zayavkaModel.fizInfoDTO.id}"/> --%>
	</portlet:actionURL>
	<aui:form action="${addPublicationMAction}" method="POST" name="form20/1">
		<aui:input name="konkursId" type="hidden" value="${zayavkaModel.konkursId}" />
		<aui:input name="userId" type="hidden" value="${zayavkaModel.userId}" />
		<aui:input name="zayavkaId" type="hidden" value="${zayavkaModel.id}" />

		<%-- <spring:message code="zayavka.pn" var='pnLabel' />
		<aui:input name="pn" label='${pnLabel}' bean="publicationMModel">
			<aui:validator name="required" />
		</aui:input> --%>
		<c:forEach items="${publicationTypes}" var="i" varStatus="n">
			<c:if test="${zayavkaModel.molod}">
				<aui:input type="radio" name="publicationTypeId" bean="publicationMModel" label="${i.name}" value="${i.id}" checked="${i.id==1}"></aui:input>
			</c:if>
			<c:if test="${!zayavkaModel.molod}">
				<c:if test="${n.index<3}">
					<aui:input type="radio" name="publicationTypeId" bean="publicationMModel" label="${i.name}" value="${i.id}" checked="${i.id==1}"></aui:input>
				</c:if>

			</c:if>
		</c:forEach>

		<spring:message code="zayavka.publName" var='publNameLabel' />
		<aui:input name="name" label='${publNameLabel}' bean="publicationMModel" showRequiredLabel="">
			<aui:validator name="required" />
		</aui:input>

		<spring:message code="zayavka.publIzdanie" var='publIzdanieLabel' />
		<aui:input name="edition" label='${publIzdanieLabel}' bean="publicationMModel" showRequiredLabel="">
			<aui:validator name="required" />
		</aui:input>

		<spring:message code="zayavka.pages" var='pagesLabel' />
		<aui:input name="pages" label='${pagesLabel}' bean="publicationMModel" showRequiredLabel="">
			<aui:validator name="required" />
		</aui:input>

		<spring:message code="zayavka.soauthors" var='soauthorsLabel' />
		<aui:input name="authors" label='${soauthorsLabel}' bean="publicationMModel" showRequiredLabel="">
			<aui:validator name="required" />
		</aui:input>

		<aui:button-row>
			<div align="left">
				<aui:button type="submit" value="Добавить" />
			</div>
		</aui:button-row>

	</aui:form>
</div>
<c:if test="${zayavkaModel.molod}">
	<c:forEach items="${zayavkaModel.ispolniteliDTO}" var="ispl" varStatus="n">
		<div id="publIsp${n}">
			<h3>Список публикаций ${ispl.surname} ${ispl.name} ${ispl.patronymic}</h3>
			<c:if test="${not empty ispl.fizInfo.publications}">
				<table class="table table-condensed table-bordered" style="width: auto">

					<thead>
						<tr>
							<th><spring:message code="zayavka.pn" /></th>
							<th><spring:message code="zayavka.publType" /></th>
							<th><spring:message code="zayavka.publName" /></th>
							<th><spring:message code="zayavka.publIzdanie" /></th>
							<th><spring:message code="zayavka.pages" /></th>
							<th><spring:message code="zayavka.soauthors" /></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ispl.fizInfo.publications}" var="i" varStatus="n">
							<tr>
								<td>${n.index+1}</td>
								<td>${i.publicationTypeName}</td>
								<td>${i.name}</td>
								<td>${i.edition}</td>
								<td>${i.pages}</td>
								<td>${i.authors}</td>
								<td><a
									href="<portlet:actionURL><portlet:param name="action" value="deletePublicationM"/><portlet:param name="publicationId" value="${i.id}"/><portlet:param name="konkursId" value="${zayavkaModel.konkursId}" /></portlet:actionURL>">Удалить</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>

			<aui:form action="${addPublicationMAction}" method="POST" name="form20/1">
				<aui:input name="konkursId" type="hidden" value="${zayavkaModel.konkursId}" />
				<aui:input name="userId" type="hidden" value="${zayavkaModel.userId}" />
				<aui:input name="zayavkaId" type="hidden" value="${zayavkaModel.id}" />
				<aui:input name="fizInfoId" type="hidden" value="${ispl.fizInfo.id}" />

				<%-- <spring:message code="zayavka.pn" var='pnLabel' />
			<aui:input name="pn" label='${pnLabel}' bean="publicationMModel">
				<aui:validator name="required" />
			</aui:input> --%>
				<c:forEach items="${publicationTypes}" var="i">
					<aui:input type="radio" name="publicationTypeId" bean="publicationMModel" label="${i.name}" value="${i.id}" checked="${i.id==1}"></aui:input>
				</c:forEach>

				<spring:message code="zayavka.publName" var='publNameLabel' />
				<aui:input name="name" label='${publNameLabel}' bean="publicationMModel" showRequiredLabel="">
					<aui:validator name="required" />
				</aui:input>

				<spring:message code="zayavka.publIzdanie" var='publIzdanieLabel' />
				<aui:input name="edition" label='${publIzdanieLabel}' bean="publicationMModel" showRequiredLabel="">
					<aui:validator name="required" />
				</aui:input>

				<spring:message code="zayavka.pages" var='pagesLabel' />
				<aui:input name="pages" label='${pagesLabel}' bean="publicationMModel" showRequiredLabel="">
					<aui:validator name="required" />
				</aui:input>

				<spring:message code="zayavka.soauthors" var='soauthorsLabel' />
				<aui:input name="authors" label='${soauthorsLabel}' bean="publicationMModel" showRequiredLabel="">
					<aui:validator name="required" />
				</aui:input>

				<aui:button-row>
					<div align="left">
						<aui:button type="submit" value="Добавить" />
					</div>
				</aui:button-row>

			</aui:form>
		</div>
	</c:forEach>
</c:if>



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