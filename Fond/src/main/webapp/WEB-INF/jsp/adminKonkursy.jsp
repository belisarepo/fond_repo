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
 		<tr><th>Статус</th><th>Наименование</th><th>Тип конкурса</th><th></th></tr>
 	</thead>
 	<tbody>
 		<c:forEach var="i" items="${konkursyList}">
 			<tr>
 				<td>${i.konkursStatusName}</td>
 				<td>${i.nameR}</td>
 				<td>${i.tipKonkursaName}</td>
 				<td><a href="<portlet:renderURL><portlet:param name="view" value="zayavki"/><portlet:param name="konkursId" value="${i.id}"/></portlet:renderURL>">Заявки</a></td>
 				
 			</tr>
 		</c:forEach>
 	</tbody>
 </table>
<div class="paging"></div>
<aui:script>
$('#example-table').datatable({
    pageSize: 6,
    sort: [true, true, true,false],
    filters: ['select', true, 'select',false ],
    filterText: 'Type to filter... ',
    sortKey: 0,
    sortDir: 'asc'
}) ;
</aui:script>

<%-- <div id="content">Dynamic Content goes here</div>
<div id="page-selection">Pagination goes here</div>
<aui:script>
$('#page-selection').bootpag({
            total: 10
        }).on("page", function(event, /* page number here */ num){
             $("#content").html("Insert content"); // some ajax content loading...
        });
</aui:script> --%>