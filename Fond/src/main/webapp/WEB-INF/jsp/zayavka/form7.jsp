<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<c:if test="${not empty zayavkaModel.soOrg}">
	<table class="table table-condensed table-bordered" style="width: auto">
		<thead>
			<tr>
				<th><spring:message code="zayavka.naim" /></th>
				<th><spring:message code="zayavka.okogu" /></th>
				<th><spring:message code="zayavka.adr" /></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${zayavkaModel.soOrg}" var="i">
				<tr>
					<td>${i.name}</td>
					<td>${i.okoguName}</td>
					<td>${i.address}</td>
					<td><a
						href="<portlet:actionURL><portlet:param name="action" value="deleteSoOrg"/><portlet:param name="soOrgId" value="${i.id}"/><portlet:param name="konkursId" value="${zayavkaModel.konkursId}" /><portlet:param name="zayavkaId" value="${zayavkaModel.id}" /></portlet:actionURL>">Удалить</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</c:if>
<aui:form action="${addSoOrgAction}" method="POST" name="form7">
	<aui:input name="id" bean="zayavkaModel" type="hidden" value="${zayavkaModel.id}" />
	<aui:input name="konkursId" type="hidden" value="${zayavkaModel.konkursId}" />
	<aui:input name="userId" type="hidden" value="${zayavkaModel.userId}" />

	<spring:message code="zayavka.naim" var='orgNaimLabel' />
	<aui:select name="soOrgId" label='${orgNaimLabel}' id="soOrgSelect">
		<option value="" />
		<c:forEach var="i" items="${listOrg}">
			<aui:option value="${i.id}" label="${i.name}" />
		</c:forEach>
	</aui:select>

	<spring:message code='zayavka.okogu' var='okoguLabel' />
	<aui:input id="soOrgOkogu" disabled="true" name="" label='${okoguLabel}'></aui:input>

	<spring:message code='zayavka.addressOrg' var='addressOrgLabel' />
	<aui:input id="soOrgAddress" disabled="true" name="" label='${addressOrgLabel}'></aui:input>

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
<aui:script>
$('#${ns}soOrgSelect').on('change', function(evt, params) {
		var orgId = $(evt.target).val();

		$.ajax({
			dataType : 'json',
			url : '<portlet:resourceURL id="getOrgById" />',
			data : {
				<portlet:namespace />orgId : orgId
			},
			success : function(jsondata) {
				$('#${ns}soOrgAddress').val(jsondata.address);
				$('#${ns}soOrgOkogu').val(jsondata.okoguName);

			}
		});
	});
</aui:script>