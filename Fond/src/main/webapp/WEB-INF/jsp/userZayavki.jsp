<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="ns">
	<portlet:namespace />
</c:set>

<portlet:defineObjects />

<table class="table table-bordered table-striped table-hover">
	<thead>
		<tr>
			<th>Конкурс</th>
			<th>Статус заявки</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="entry" items="${zayavkiMap}">
			<tr>
				<c:set var="arr" value="${entry.value}" />
				<c:forEach var="i" items="${arr}">
					<td><c:out value="${i}" /></td>
				</c:forEach>
				<td><a href="<portlet:renderURL><portlet:param name="view" value="zayavka"/><portlet:param name="zayavkaId" value="${entry.key}"/></portlet:renderURL>">К заявке</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>