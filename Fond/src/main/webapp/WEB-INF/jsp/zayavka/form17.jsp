<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<c:if test="${not empty zayavkaModel.calcMaterialsSet}">
	<table class="table table-condensed table-bordered" style="width: auto">
		<thead>
			<tr>
				<th><spring:message code="zayavka.calcMaterials.pn" /></th>
				<th><spring:message code="zayavka.calcMaterials.name" /></th>
				<th><spring:message code="zayavka.calcMaterials.unit" /></th>
				<th><spring:message code="zayavka.calcMaterials.count" /></th>
				<th><spring:message code="zayavka.calcMaterials.sum" /></th>
				<th></th><th></th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${zayavkaModel.calcMaterialsSet}" var="i"
				varStatus="n">
				<tr id="${i.id}">
					<td>${n.index+1}</td>
					<td>${i.name}</td>
					<td>${i.unit}</td>
					<td>${i.count}</td>
					<td class="calcMaterialsSum">${i.sum}</td>
					<portlet:renderURL var="editCalcMaterialsUrl"
						windowState='<%=LiferayWindowState.POP_UP.toString()%>'>
						<portlet:param name="action" value="editCalcMaterials" /> 
						<portlet:param name="CalcMaterialsId" value="${i.id}" />
						<portlet:param name="zayavkaId" value="${zayavkaModel.id}" />
					</portlet:renderURL>
					<c:set var="strCalcMaterialsUrl"><%=editCalcMaterialsUrl.toString()%></c:set>
					<aui:script>
						$('#editCalcMaterials${n.index+1}').on('click', function(event){
  					 		showPopup('Редактировать затраты на материалы',null,'${strCalcMaterialsUrl}');
						});
					</aui:script>
					<td><a id="editCalcMaterials${n.index+1}" class='deleteLink' href="#">Редактировать</a></td>
					<td><a class='deleteLink'
						href="<portlet:actionURL><portlet:param name="action" value="deleteCalcMaterials"/><portlet:param name="calcMaterialsId" value="${i.id}"/><portlet:param name="konkursId" value="${zayavkaModel.konkursId}" /><portlet:param name="zayavkaId" value="${zayavkaModel.id}" /></portlet:actionURL>">Удалить</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="4"><spring:message code="zayavka.calc.all" /></td>
				<td id="calcMaterialsSumAll"></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</c:if>


<aui:form action="${addCalcMaterialsAction}" method="POST" name="form17">
	<aui:input name="konkursId" type="hidden"
		value="${zayavkaModel.konkursId}" />
	<aui:input name="userId" type="hidden" value="${zayavkaModel.userId}" />
	<aui:input name="zayavkaId" type="hidden" value="${zayavkaModel.id}" />

	<spring:message code="zayavka.calcMaterials.name"
		var='calcMaterialsNameLabel' />
	<aui:input name="name" label='${calcMaterialsNameLabel}'
		bean="calcMaterialsModel" showRequiredLabel="">
		<aui:validator name="required" />
	</aui:input>

	<spring:message code="zayavka.calcMaterials.unit"
		var='calcMaterialsUnitLabel' />
	<aui:input name="unit" label='${calcMaterialsUnitLabel}'
		bean="calcMaterialsModel" showRequiredLabel="">
		<aui:validator name="required" />
	</aui:input>

	<spring:message code="zayavka.calcMaterials.count"
		var='calcMaterialsCountLabel' />
	<aui:input name="count" label='${calcMaterialsCountLabel}'
		bean="calcMaterialsModel" showRequiredLabel="">
		<aui:validator name="required" />
		<aui:validator name="number" />
	</aui:input>

	<spring:message code="zayavka.calcMaterials.sum"
		var='calcMaterialsSumZpLabel' />
	<aui:input name="sum" label='${calcMaterialsSumZpLabel}'
		bean="calcMaterialsModel" showRequiredLabel="">
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
var calcMaterialsSumAll = 0;
$('.calcMaterialsSum').each(function(){
	calcMaterialsSumAll += parseFloat($(this).text());
});
$('#calcMaterialsSumAll').text(calcMaterialsSumAll);
</aui:script>