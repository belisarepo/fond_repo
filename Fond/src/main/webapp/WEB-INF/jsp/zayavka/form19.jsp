<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<c:if test="${not empty zayavkaModel.calcOtherCostsSet}">
	<table class="table table-condensed table-bordered" style="width: auto">
		<thead>
			<tr>
				<th><spring:message code="zayavka.calcOtherCosts.pn" /></th>
				<th><spring:message code="zayavka.calcOtherCosts.name" /></th>
				<th><spring:message code="zayavka.calcOtherCosts.sum" /></th>
				<th><spring:message code="zayavka.calcOtherCosts.note" /></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${zayavkaModel.calcOtherCostsSet}" var="i" varStatus="n">
				<tr id="calcOtherCosts${i.id}">
					<td>${n.index+1}</td>
					<td>${i.name}</td>
					<td class="calcOtherCostsSum">${i.sum}</td>
					<td>${i.note}</td>
					<portlet:renderURL var="editCalcOtherCostsUrl" windowState='<%=LiferayWindowState.POP_UP.toString()%>'><portlet:param name="action" value="editCalcOtherCosts" /><portlet:param name="calcOtherCostsId" value="${i.id}" /><portlet:param name="zayavkaId" value="${zayavkaModel.id}"/></portlet:renderURL>
					<c:set var="strCalcOtherCostsUrl"><%=editCalcOtherCostsUrl.toString()%></c:set>
					<aui:script>
						$('#editCalcOtherCosts${n.index+1}').on('click', function(event){
  					 		showPopup('Редактировать затраты по статье "Прочие прямые расходы"',null,'${strCalcOtherCostsUrl}');
						});
					</aui:script>
					<td><a id="editCalcOtherCosts${n.index+1}" class='deleteLink' href="#">Редактировать</a></td>
					<td><a
						class='deleteLink' href="<portlet:actionURL><portlet:param name="action" value="deleteCalcOtherCosts"/><portlet:param name="calcOtherCostsId" value="${i.id}"/><portlet:param name="konkursId" value="${zayavkaModel.konkursId}" /><portlet:param name="zayavkaId" value="${zayavkaModel.id}" /></portlet:actionURL>">Удалить</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="2"><spring:message code="zayavka.calc.all" /></td>
				<td id="calcOtherCostsAllSum"></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</c:if>


<aui:form action="${addCalcOtherCostsAction}" method="POST" name="form19">
	<aui:input name="konkursId" type="hidden" value="${zayavkaModel.konkursId}" />
	<aui:input name="userId" type="hidden" value="${zayavkaModel.userId}" />
	<aui:input name="zayavkaId" type="hidden" value="${zayavkaModel.id}" />

	
	<spring:message code="zayavka.calcOtherCosts.name" var='calcOtherCostsNameLabel' />
	<aui:input name="name" label='${calcOtherCostsNameLabel}' bean="calcOtherCostsModel" showRequiredLabel="">
		<aui:validator name="required" />
	</aui:input>

	<spring:message code="zayavka.calcOtherCosts.sum" var='calcOtherCostsSumLabel' />
	<aui:input name="sum" label='${calcOtherCostsSumLabel}' bean="calcOtherCostsModel" showRequiredLabel="">
		<aui:validator name="required" />
		<aui:validator name="number" />
	</aui:input>

	<spring:message code="zayavka.calcOtherCosts.note" var='calcOtherCostsNoteLabel' />
	<aui:input name="note" label='${calcOtherCostsNoteLabel}' bean="calcOtherCostsModel" type="textarea">
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
function resumCalcOtherCosts(){
	var calcOtherCostsAllSum = 0;
	$('.calcOtherCostsSum').each(function(){
		calcOtherCostsAllSum += parseFloat($(this).text());
	});
	$('#calcOtherCostsAllSum').text(calcOtherCostsAllSum);
}
resumCalcOtherCosts();
</aui:script>