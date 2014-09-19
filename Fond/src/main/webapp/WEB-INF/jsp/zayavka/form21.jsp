<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<c:if test="${not empty zayavkaModel.petitionSet}">
	<table class="table table-condensed table-bordered" style="width: auto">
		<thead>
			<tr>
				<th><spring:message code="zayavka.pn" /></th>
				<th><spring:message code="zayavka.naim" /></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${zayavkaModel.petitionSet}" var="i" varStatus="n">
				<tr>
					<td>${n.index+1}</td>
					<td>${i.name}</td>
					<td><a
						href="<portlet:actionURL><portlet:param name="action" value="deletePetition"/><portlet:param name="petitionId" value="${i.id}"/><portlet:param name="konkursId" value="${zayavkaModel.konkursId}" /></portlet:actionURL>">Удалить</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>


<aui:form action="${addPetitionAction}" method="POST" name="form21">
	<aui:input name="konkursId" type="hidden" value="${zayavkaModel.konkursId}" />
	<aui:input name="userId" type="hidden" value="${zayavkaModel.userId}" />
	<aui:input name="zayavkaId" type="hidden" value="${zayavkaModel.id}" />

	<spring:message code="zayavka.petition" var='nameLabel' />
	<aui:input name="petitionName" label='${nameLabel}' showRequiredLabel="">
		<aui:validator name="required" />
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