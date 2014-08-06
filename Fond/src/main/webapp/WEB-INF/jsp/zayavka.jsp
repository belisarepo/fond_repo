<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<portlet:defineObjects />
<c:set var="ns">
	<portlet:namespace />
</c:set>
<portlet:actionURL var="sendForm">
</portlet:actionURL>
<form:form modelAttribute='${ns}zayavka' method="POST"
	action="${sendForm}" name="zayavka">
	<form:label path="konkursNameR">Название конкурса</form:label>
	<form:input path="konkursNameR" value="${konkurs.nameR}"
		disabled="true" />
	<form:label path="sectionFondId">Секция фонда</form:label>
	<form:select path="sectionFondId" items="${sectionFondList}"
		itemValue="id" itemLabel="nameR"></form:select>
	<form:label path="otraslNaukaId"></form:label>
	<form:select path="otraslNaukaId" items="${otraslNaukaList}"
		itemLabel="name" itemValue="id"></form:select>
	<aui:button-row>
		<div align="left">
			<aui:button type="submit" />
		</div>
	</aui:button-row>
</form:form>
