<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<c:if test="${not empty zayavkaModel.calcTripSet}">
	<table class="table table-condensed table-bordered" style="width: auto">
		<thead>
			<tr>
				<th><spring:message code="zayavka.calcTrip.tripGoal" /></th>
				<th><spring:message code="zayavka.calcTrip.tripPoint" /></th>
				<th><spring:message code="zayavka.calcTrip.count" /></th>
				<th><spring:message code="zayavka.calcTrip.duration" /></th>
				<th><spring:message code="zayavka.calcTrip.costs" /></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${zayavkaModel.calcTripSet}" var="i">
				<tr>
					<td>${i.tripGoal}</td>
					<td>${i.tripPoint}</td>
					<td>${i.count}</td>
					<td>${i.duration}</td>
					<td class="calcTripSum">${i.costs}</td>
					<td><a
						href="<portlet:actionURL><portlet:param name="action" value="deleteCalcTrip"/><portlet:param name="calcTripId" value="${i.id}"/><portlet:param name="konkursId" value="${zayavkaModel.konkursId}" /></portlet:actionURL>">Удалить</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="4"><spring:message code="zayavka.calc.all" /></td>
				<td id="calcTripSumAll"></td>
			</tr>
		</tbody>
	</table>
</c:if>


<aui:form action="${addCalcTripAction}" method="POST" name="form18">
	<aui:input name="konkursId" type="hidden" value="${zayavkaModel.konkursId}" />
	<aui:input name="userId" type="hidden" value="${zayavkaModel.userId}" />
	<aui:input name="zayavkaId" type="hidden" value="${zayavkaModel.id}" />

	<spring:message code="zayavka.calcTrip.tripGoal" var='calcTripTripGoalLabel' />
	<aui:input name="tripGoal" label='${calcTripTripGoalLabel}' bean="calcTripModel">
		<aui:validator name="required" />
	</aui:input>

	<spring:message code="zayavka.calcTrip.tripPoint" var='calcTripTripPointLabel' />
	<aui:input name="tripPoint" label='${calcTripTripPointLabel}' bean="calcTripModel">
		<aui:validator name="required" />
	</aui:input>

	<spring:message code="zayavka.calcTrip.count" var='calcTripCountLabel' />
	<aui:input name="count" label='${calcTripCountLabel}' bean="calcTripModel">
		<aui:validator name="required" />
		<aui:validator name="digits" />
	</aui:input>

	<spring:message code="zayavka.calcTrip.duration" var='calcTripDurationLabel' />
	<aui:input name="duration" label='${calcTripDurationLabel}' bean="calcTripModel">
		<aui:validator name="required" />
		<aui:validator name="digits" />
	</aui:input>

	<spring:message code="zayavka.calcTrip.costs" var='calcTripCostsZpLabel' />
	<aui:input name="costs" label='${calcTripCostsZpLabel}' bean="calcTripModel">
		<aui:validator name="required" />
		<aui:validator name="digits" />
	</aui:input>
	
	
	<aui:button-row>
		<div align="left">
			<aui:button type="submit" value="Добавить" />
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

<aui:script>
var calcTripSumAll = 0;
$('.calcTripSum').each(function(){
	calcTripSumAll += parseInt($(this).text(),10);
});
$('#calcTripSumAll').text(calcTripSumAll);
</aui:script>