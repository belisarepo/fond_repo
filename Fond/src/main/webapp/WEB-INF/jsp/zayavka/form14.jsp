<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<c:if test="${not empty zayavkaModel.publications}">
	<table class="table table-condensed table-bordered" style="width: auto">
		<thead>
			<tr>
				<th><spring:message code="zayavka.publName" /></th>
				<th><spring:message code="zayavka.publIzdanie" /></th>
				<th><spring:message code="zayavka.fullListAutors" /></th>
				<th><spring:message code="zayavka.publIndex" /></th>
				<th><spring:message code="zayavka.publDB" /></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${zayavkaModel.publications}" var="i" varStatus="n">
				<tr id="${i.id}">
					<td>${i.name}</td>
					<td>${i.edition}</td>
					<td>${i.authors}</td>
					<td>${i.citationIndex}</td>
					<td>${i.database}</td>
					<portlet:renderURL var="editPublUrl" windowState='<%=LiferayWindowState.POP_UP.toString()%>'><portlet:param name="action" value="editPublication" /><portlet:param name="publId" value="${i.id}" /></portlet:renderURL>
					<c:set var="strEditPublUrl"><%=editPublUrl.toString()%></c:set>
					<aui:script>
						$('#editPubl${n.index+1}').on('click', function(event){
  					 		showPopup('Редактировать публикацию',null,'${strEditPublUrl}');
						});
					</aui:script>
					<td><a id="editPubl${n.index+1}" class='deleteLink' href="#">Редактировать</a></td>
					<td><a class='deleteLink' href="<portlet:actionURL><portlet:param name="action" value="deletePublication"/><portlet:param name="publicationId" value="${i.id}"/><portlet:param name="konkursId" value="${zayavkaModel.konkursId}" /><portlet:param name="zayavkaId" value="${zayavkaModel.id}" /></portlet:actionURL>">Удалить</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>


<aui:form action="${addPublicationAction}" method="POST" name="form14">
	<aui:input name="konkursId" type="hidden" value="${zayavkaModel.konkursId}" />
	<aui:input name="userId" type="hidden" value="${zayavkaModel.userId}" />
	<aui:input name="zayavkaId" type="hidden" value="${zayavkaModel.id}" />

	<spring:message code="zayavka.publName" var='publNameLabel' />
	<aui:input name="name" label='${publNameLabel}' bean="publicationModel" showRequiredLabel="" type="textarea">
		<aui:validator name="required" />
	</aui:input>

	<spring:message code="zayavka.publIzdanie" var='publIzdanieLabel' />
	<aui:input name="edition" label='${publIzdanieLabel}' bean="publicationModel" showRequiredLabel="" type="textarea">
		<aui:validator name="required" />
	</aui:input>

	<spring:message code="zayavka.fullListAutors" var='fullListAutorsLabel' />
	<aui:input name="authors" label='${fullListAutorsLabel}' bean="publicationModel" showRequiredLabel="" type="textarea">
		<aui:validator name="required" />
	</aui:input>

	<spring:message code="zayavka.publIndex" var='publIndexLabel' />
	<aui:input name="citationIndex" label='${publIndexLabel}' bean="publicationModel">
	</aui:input>

	<spring:message code="zayavka.publDB" var='publDBLabel' />
	<aui:input name="database" label='${publDBLabel}' bean="publicationModel">
	</aui:input>


	<aui:button-row>
		<div align="left">
			<aui:button type="submit" value="Добавить" />
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
