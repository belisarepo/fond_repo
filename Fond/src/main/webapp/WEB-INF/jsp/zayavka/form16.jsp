<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<c:if test="${not empty zayavkaModel.calcZpSet}">
	<table class="table table-condensed table-bordered" style="width: auto">
		<thead>
			<tr>
				<th><spring:message code="zayavka.calcZp.name" /></th>
				<th><spring:message code="zayavka.calcZp.salary" /></th>
				<th><spring:message code="zayavka.calcZp.rate" /></th>
				<th><spring:message code="zayavka.calcZp.duration" /></th>
				<th><spring:message code="zayavka.calcZp.fondZp" /></th>
				<th><spring:message code="zayavka.calcZp.note" /></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${zayavkaModel.calcZpSet}" var="i">
				<tr>
					<td>${i.name}</td>
					<td>${i.salary}</td>
					<td>${i.rate}</td>
					<td>${i.duration}</td>
					<td class="calcZpSum">${i.fondZp}</td>
					<td>${i.note}</td>
					<td><a
						href="<portlet:actionURL><portlet:param name="action" value="deleteCalcZp"/><portlet:param name="calcZpId" value="${i.id}"/><portlet:param name="konkursId" value="${zayavkaModel.konkursId}" /></portlet:actionURL>">Удалить</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="4"><spring:message code="zayavka.calc.all" /></td>
				<td id="calcZpSumAll"></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</c:if>


<aui:form action="${addCalcZpAction}" method="POST" name="form16">
	<aui:input name="konkursId" type="hidden" value="${zayavkaModel.konkursId}" />
	<aui:input name="userId" type="hidden" value="${zayavkaModel.userId}" />
	<aui:input name="zayavkaId" type="hidden" value="${zayavkaModel.id}" />

	<spring:message code="zayavka.calcZp.name" var='calcZpNameLabel' />
	<aui:input name="name" label='${calcZpNameLabel}' bean="calcZpModel" showRequiredLabel="">
		<aui:validator name="required" />
	</aui:input>

	<spring:message code="zayavka.calcZp.salary" var='calcZpSalaryLabel' />
	<aui:input name="salary" label='${calcZpSalaryLabel}' bean="calcZpModel" showRequiredLabel="">
		<aui:validator name="required" />
		<aui:validator name="number" />
	</aui:input>

	<spring:message code="zayavka.calcZp.rate" var='calcZpRateLabel' />
	<aui:input name="rate" label='${calcZpRateLabel}' bean="calcZpModel" showRequiredLabel="">
		<aui:validator name="required" />
		<aui:validator name="number" />
	</aui:input>

	<spring:message code="zayavka.calcZp.duration" var='calcZpDurationLabel' />
	<aui:input name="duration" label='${calcZpDurationLabel}' bean="calcZpModel" showRequiredLabel="">
		<aui:validator name="required" />
		<aui:validator name="number" />
	</aui:input>

	<spring:message code="zayavka.calcZp.fondZp" var='calcZpFondZpLabel' />
	<aui:input name="fondZp" label='${calcZpFondZpLabel}' bean="calcZpModel" showRequiredLabel="">
		<aui:validator name="required" />
		<aui:validator name="number" />
	</aui:input>
	
	<spring:message code="zayavka.calcZp.note" var='calcZpNoteLabel' />
	<aui:input name="note" label='${calcZpNoteLabel}' bean="calcZpModel">
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

<aui:script>
var calcZpSumAll = 0;
$('.calcZpSum').each(function(){
	calcZpSumAll += parseFloat($(this).text());
});
$('#calcZpSumAll').text(calcZpSumAll);
</aui:script>