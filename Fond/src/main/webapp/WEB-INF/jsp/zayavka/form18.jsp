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
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${zayavkaModel.calcTripSet}" var="i" varStatus="n">
				<tr id="calcTrip${i.id}">
					<td>${i.tripGoal}</td>
					<td>${i.tripPoint}</td>
					<td>${i.count}</td>
					<td>${i.duration}</td>
					<td class="calcTripSum">${i.costs}</td>
					<portlet:renderURL var="editCalcTripUrl" windowState='<%=LiferayWindowState.POP_UP.toString()%>'><portlet:param name="action" value="editCalcTrip" /><portlet:param name="calcTripId" value="${i.id}" /><portlet:param name="zayavkaId" value="${zayavkaModel.id}"/></portlet:renderURL>
					<c:set var="strCalcTripUrl"><%=editCalcTripUrl.toString()%></c:set>
					<aui:script>
						$('#editCalcTrip${n.index+1}').on('click', function(event){
  					 		showPopup('Редактировать затраты на командировки',null,'${strCalcTripUrl}');
						});
					</aui:script>
					<td><a id="editCalcTrip${n.index+1}" class='deleteLink' href="#">Редактировать</a></td>
					
					<td><a
						class='deleteLink' href="<portlet:actionURL><portlet:param name="action" value="deleteCalcTrip"/><portlet:param name="calcTripId" value="${i.id}"/><portlet:param name="konkursId" value="${zayavkaModel.konkursId}" /><portlet:param name="zayavkaId" value="${zayavkaModel.id}" /></portlet:actionURL>">Удалить</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="4"><spring:message code="zayavka.calc.all" /></td>
				<td id="calcTripSumAll"></td>
				<td></td><td></td>
			</tr>
		</tbody>
	</table>
</c:if>


<aui:form action="${addCalcTripAction}" method="POST" name="form18">
	<aui:input name="konkursId" type="hidden" value="${zayavkaModel.konkursId}" />
	<aui:input name="userId" type="hidden" value="${zayavkaModel.userId}" />
	<aui:input name="zayavkaId" type="hidden" value="${zayavkaModel.id}" />

	<spring:message code="zayavka.calcTrip.tripGoal" var='calcTripTripGoalLabel' />
	<aui:input name="tripGoal" label='${calcTripTripGoalLabel}' bean="calcTripModel" showRequiredLabel="">
		<aui:validator name="required" />
	</aui:input>

	<spring:message code="zayavka.calcTrip.tripPoint" var='calcTripTripPointLabel' />
	<aui:input name="tripPoint" label='${calcTripTripPointLabel}' bean="calcTripModel" showRequiredLabel="">
		<aui:validator name="required" />
	</aui:input>

	<spring:message code="zayavka.calcTrip.count" var='calcTripCountLabel' />
	<aui:input name="count" label='${calcTripCountLabel}' bean="calcTripModel" showRequiredLabel="">
		<aui:validator name="required" />
		<aui:validator name="number" />
	</aui:input>

	<spring:message code="zayavka.calcTrip.duration" var='calcTripDurationLabel' />
	<aui:input name="duration" label='${calcTripDurationLabel}' bean="calcTripModel" showRequiredLabel="">
		<aui:validator name="required" />
		<aui:validator name="number" />
	</aui:input>

	<spring:message code="zayavka.calcTrip.costs" var='calcTripCostsZpLabel' />
	<aui:input name="costs" label='${calcTripCostsZpLabel}' bean="calcTripModel" showRequiredLabel="">
		<aui:validator name="required" />
		<aui:validator name="number" />
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
function resumCalcTrip(){
	var calcTripSumAll = 0;
	$('.calcTripSum').each(function(){
		calcTripSumAll += parseFloat($(this).text());
	});
	$('#calcTripSumAll').text(calcTripSumAll);
}
resumCalcTrip();
</aui:script>