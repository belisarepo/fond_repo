<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<portlet:defineObjects />
<portlet:actionURL var="sendForm">
</portlet:actionURL>
<c:set var="ns">
	<portlet:namespace />
</c:set>
<center><div id="successMessageContainer" /></center>
<form:form modelAttribute='${ns}anketa' method="POST"
	action="${sendForm}" name="anketa">
	<form:label path="fio">ФИО краткое</form:label>
	<form:input path="fio" />
	<br />
	<form:label path="fullFio">ФИО полное</form:label>
	<form:input path="fullFio" />
	<br />
	<form:label path="orgId">Организация</form:label>
	<form:select path="orgId"  class="chosen">
		<form:options items="${orgList}" itemLabel="name" itemValue="id" />
	</form:select>
	<form:label path="uchStepenId">Ученая степень</form:label>
	<form:select path="uchStepenId">
		<form:options items="${uchStepeniList}" itemLabel="fullName"
			itemValue="id" />
	</form:select>
	<form:label path="uchZvaniyId">Ученое звание</form:label>
	<form:select path="uchZvaniyId" class="chosen">
		<form:options items="${uchZvaniyList}" itemLabel="fullName"
			itemValue="id" />
	</form:select>
	<form:label path="post">Должность</form:label>
	<form:input path="post" />
	<br />
	<form:label path="lab">Кафедра</form:label>
	<form:input path="lab" />
	<br />

	<form:label path="birthday" placeholder="dd-MM-yyyy">Дата рождения</form:label>
	
		<form:input path="birthday" class="datepicker" id="xxx"/>
		<br />


	<form:label path="homePhone">Тел домашний</form:label>
	<form:input path="homePhone" />
	<br />
	<form:label path="jobPhone">Тел рабочий</form:label>
	<form:input path="jobPhone" />
	<br />
	<form:label path="mobilePhone">Тел мобильный</form:label>
	<form:input path="mobilePhone" />
	<br />
	<form:label path="address">Адрес</form:label>
	<form:input path="address" />
	<br />
	<form:label path="email">Email</form:label>
	<form:input path="email" />
	<br />
	
	<input type="submit" value="Save" />
</form:form>

<aui:script>
YUI().use(
  function(Y) {
  	var save_result = '${save_result}';
  	if (save_result){
  		showSuccess();
  	}
  }
);

function showSuccess(){
	AUI().use('liferay-notice', function(A){
		var successMessageContainer = A.one('#successMessageContainer');
		var banner = new Liferay.Notice(
			{
				animationConfig:
					{
						duration: 0.1,
						top: '50%',
						left: '50%'
						
					},
				content: '<div class="alert alert-success">Сохранено</div>',
				closeText: false,
				node: '#successMessageContainer',
				type: 'notice',
				toggleText: false,
				timeout: 1000,
				useAnimation: false
				
			}
		);

		banner.show();
	});	
}
</aui:script>