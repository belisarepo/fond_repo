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


 
<div class="paging"></div>
<table id="example-table" class="table table-bordered table-striped table-hover">
    
 	<thead>
 		<tr><th>ФИО Руководителя</th><th>Статус</th><th></th></tr>
 	</thead>
 	<tbody>
 		<c:forEach var="i" items="${zayavkiList}">
 			<tr>
 				<td>${i.fullFioRk}</td>
 				<td>${i.statusZayavkaName}</td>
 				<td><a href='<portlet:renderURL><portlet:param name="view" value="zayavka"/><portlet:param name="zayavkaId" value="${i.id}"></portlet:param></portlet:renderURL>'>К заявке</a></td>
 			</tr>
 		</c:forEach>
 	</tbody>
 </table>
<div class="paging"></div>
<aui:script>
$('#example-table').datatable({
    pageSize: 6,
    sort: [true, true,false],
    filters: [true, 'select',false],
    filterText: 'Type to filter... ',
}) ;
</aui:script>

