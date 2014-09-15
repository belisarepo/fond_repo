<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<aui:form action="${saveForm15}" method="POST" name="form15">
	<aui:input name="id" bean="zayavkaModel" type="hidden" value="${zayavkaModel.id}" />
	<aui:input name="konkursId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.konkursId}" />
	<aui:input name="userId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.userId}" />
	<aui:input name="calcId" bean="zayavkaModel" type="hidden" value="${zayavkaModel.calcId}" />

	<table id="calcTable" class="table table-bordered table-condensed">
		<thead>
			<tr>
				<th><spring:message code="zayavka.calcName" /></th>
				<th><spring:message code="zayavka.calcFull" /></th>
				<th><spring:message code="zayavka.calcFirstYear" /></th>
			</tr>

		</thead>
		<tbody>
			<tr>
				<td><spring:message code="zayavka.zp" /></td>
				<td><aui:input cssClass="full" name="zpFull" value="${zayavkaModel.zpFull}" bean="zayavkaModel" label="" showRequiredLabel="">
						<aui:validator name="required" />
						<aui:validator name="number" />
					</aui:input></td>
				<td><aui:input cssClass="firstYear" name="zpFirstYear" value="${zayavkaModel.zpFirstYear}" bean="zayavkaModel" label="" showRequiredLabel="">
						<aui:validator name="required" />
						<aui:validator name="number" />
					</aui:input></td>
			</tr>
			<tr>
				<td><spring:message code="zayavka.fszn" /></td>
				<td><aui:input cssClass="full" name="fsznFull" value="${zayavkaModel.fsznFull}" bean="zayavkaModel" label="" showRequiredLabel="">
						<aui:validator name="required" />
						<aui:validator name="number" />
					</aui:input></td>
				<td><aui:input cssClass="firstYear" name="fsznFirstYear" value="${zayavkaModel.fsznFirstYear}" bean="zayavkaModel" label="" showRequiredLabel="">
						<aui:validator name="required" />
						<aui:validator name="number" />
					</aui:input></td>
			</tr>
			<tr>
				<td><spring:message code="zayavka.insurance" /></td>
				<td><aui:input cssClass="full" name="insuranceFull" value="${zayavkaModel.insuranceFull}" bean="zayavkaModel" label="" showRequiredLabel="">
						<aui:validator name="required" />
						<aui:validator name="number" />
					</aui:input></td>
				<td><aui:input cssClass="firstYear" name="insuranceFirstYear" value="${zayavkaModel.insuranceFirstYear}" bean="zayavkaModel"
						label="" showRequiredLabel="">
						<aui:validator name="required" />
						<aui:validator name="number" />
					</aui:input></td>
			</tr>
			<tr>
				<td><spring:message code="zayavka.hardware" /></td>
				<td><aui:input cssClass="full" name="hardwareFull" value="${zayavkaModel.hardwareFull}" bean="zayavkaModel" label="" showRequiredLabel="">
						<aui:validator name="required" />
						<aui:validator name="number" />
					</aui:input></td>
				<td><aui:input cssClass="firstYear" name="hardwareFirstYear" value="${zayavkaModel.hardwareFirstYear}" bean="zayavkaModel" label="" showRequiredLabel="">
						<aui:validator name="required" />
						<aui:validator name="number" />
					</aui:input></td>
			</tr>
			<tr>
				<td><spring:message code="zayavka.fuel" /></td>
				<td><aui:input cssClass="full" name="fuelFull" value="${zayavkaModel.fuelFull}" bean="zayavkaModel" label="" showRequiredLabel="">
						<aui:validator name="required" />
						<aui:validator name="number" />
					</aui:input></td>
				<td><aui:input cssClass="firstYear" name="fuelFirstYear" value="${zayavkaModel.fuelFirstYear}" bean="zayavkaModel" label="" showRequiredLabel="">
						<aui:validator name="required" />
						<aui:validator name="number" />
					</aui:input></td>
			</tr>
			<tr>
				<td><spring:message code="zayavka.equipment" /></td>
				<td><aui:input cssClass="full" name="equipmentFull" value="${zayavkaModel.equipmentFull}" bean="zayavkaModel" label="" showRequiredLabel="">
						<aui:validator name="required" />
						<aui:validator name="number" />
					</aui:input></td>
				<td><aui:input cssClass="firstYear" name="equipmentFirstYear" value="${zayavkaModel.equipmentFirstYear}" bean="zayavkaModel"
						label="" showRequiredLabel="">
						<aui:validator name="required" />
						<aui:validator name="number" />
					</aui:input></td>
			</tr>
			<tr>
				<td><spring:message code="zayavka.businessTrip" /></td>
				<td><aui:input cssClass="full" name="businessTripFull" value="${zayavkaModel.businessTripFull}" bean="zayavkaModel" label="" showRequiredLabel="">
						<aui:validator name="required" />
						<aui:validator name="number" />
					</aui:input></td>
				<td><aui:input cssClass="firstYear" name="businessTripFirstYear" value="${zayavkaModel.businessTripFirstYear}" bean="zayavkaModel"
						label="" showRequiredLabel="">
						<aui:validator name="required" />
						<aui:validator name="number" />
					</aui:input></td>
			</tr>
			<tr>
				<td><spring:message code="zayavka.thirdPartyServices" /></td>
				<td><aui:input cssClass="full" name="thirdPartyServicesFull" value="${zayavkaModel.thirdPartyServicesFull}" bean="zayavkaModel"
						label="" showRequiredLabel="">
						<aui:validator name="required" />
						<aui:validator name="number" />
					</aui:input></td>
				<td><aui:input cssClass="firstYear" name="thirdPartyServicesFirstYear" value="${zayavkaModel.thirdPartyServicesFirstYear}"
						bean="zayavkaModel" label="" showRequiredLabel="">
						<aui:validator name="required" />
						<aui:validator name="number" />
					</aui:input></td>
			</tr>
			<tr>
				<td><spring:message code="zayavka.other" /></td>
				<td><aui:input cssClass="full" name="otherFull" value="${zayavkaModel.otherFull}" bean="zayavkaModel" label="" showRequiredLabel="">
						<aui:validator name="required" />
						<aui:validator name="number" />
					</aui:input></td>
				<td><aui:input cssClass="firstYear" name="otherFirstYear" value="${zayavkaModel.otherFirstYear}" bean="zayavkaModel" label="" showRequiredLabel="">
						<aui:validator name="required" />
						<aui:validator name="number" />
					</aui:input></td>
			</tr>
			<tr>
				<td><spring:message code="zayavka.overhead" /></td>
				<td><aui:input cssClass="full" name="overheadFull" value="${zayavkaModel.overheadFull}" bean="zayavkaModel" label="" showRequiredLabel="">
						<aui:validator name="required" />
						<aui:validator name="number" />
					</aui:input></td>
				<td><aui:input cssClass="firstYear" name="overheadFirstYear" value="${zayavkaModel.overheadFirstYear}" bean="zayavkaModel" label="" showRequiredLabel="">
						<aui:validator name="required" />
						<aui:validator name="number" />
					</aui:input></td>
			</tr>
			<tr>
				<td><spring:message code="zayavka.innovationFond" /></td>
				<td><aui:input cssClass="full" name="innovationFondFull" value="${zayavkaModel.innovationFondFull}" bean="zayavkaModel" label="" showRequiredLabel="">
						<aui:validator name="required" />
						<aui:validator name="number" />
					</aui:input></td>
				<td><aui:input cssClass="firstYear" name="innovationFondFirstYear" value="${zayavkaModel.innovationFondFirstYear}"
						bean="zayavkaModel" label="" showRequiredLabel="">
						<aui:validator name="required" />
						<aui:validator name="number" />
					</aui:input></td>
			</tr>
			<tr>
				<td><spring:message code="zayavka.plannedCost" /></td>
				<td><aui:input cssClass="full" name="plannedCostFull" value="${zayavkaModel.plannedCostFull}" bean="zayavkaModel" label="" showRequiredLabel="">
						<aui:validator name="required" />
						<aui:validator name="number" />
					</aui:input></td>
				<td><aui:input cssClass="firstYear" name="plannedCostFirstYear" value="${zayavkaModel.plannedCostFirstYear}" bean="zayavkaModel"
						label="">
						<aui:validator name="required" />
						<aui:validator name="number" />
					</aui:input></td>
			</tr>
			<tr>
				<td><spring:message code="zayavka.profit" /></td>
				<td><aui:input cssClass="full" name="profitFull" value="${zayavkaModel.profitFull}" bean="zayavkaModel" label="" showRequiredLabel="">
						<aui:validator name="required" />
						<aui:validator name="number" />
					</aui:input></td>
				<td><aui:input cssClass="firstYear" name="profitFirstYear" value="${zayavkaModel.profitFirstYear}" bean="zayavkaModel" label="" showRequiredLabel="">
						<aui:validator name="required" />
						<aui:validator name="number" />
					</aui:input></td>
			</tr>
			<tr>
				<td><spring:message code="zayavka.all" /></td>
				<td>
					<aui:input id="allFull" disabled="true" name="allFull" value="${zayavkaModel.allFull}" bean="zayavkaModel" label="" /> 
					<aui:input id="allFullHidden" name="allFull" bean="zayavkaModel" type="hidden" value="${zayavkaModel.allFull}" />
				</td>
				<td>
					<aui:input id="allFirstYear" disabled="true" name="allFirstYear" value="${zayavkaModel.allFirstYear}" bean="zayavkaModel" label="" /> 
					<aui:input id="allFirstYearHidden" name="allFirstYear" bean="zayavkaModel" type="hidden" value="${zayavkaModel.allFirstYear}" />
				</td>
			</tr>

		</tbody>


	</table>
	<aui:button-row>
		<div align="left">
			<aui:button type="submit" value="Сохранить" />
			<a class="btn" href="${sendZayavka}">Подать</a>
		</div>
	</aui:button-row>
</aui:form>

<aui:script>

$('#calcTable .full').on('change',function() { 
	var fullSum = 0;
	$('.full').each(function(){
		
		fullSum += parseFloat($(this).val());
	});  
	$('#${ns}allFull').val(fullSum);
	$('#${ns}allFullHidden').val(fullSum);
}); 

$('#calcTable .firstYear').on('change',function() { 
	var firstYearSum = 0;
	$('.firstYear').each(function(){
		
		firstYearSum += parseFloat($(this).val());
	});  
	$('#${ns}allFirstYear').val(firstYearSum);
	$('#${ns}allFirstYearHidden').val(firstYearSum);
}); 
</aui:script>
