<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<table border="1">
    <tr><th>Key</th><th>value</th></tr>
    <c:forEach var="entry" items="${dogovor.calculationMap}" varStatus="status">
    <tr>      
      <td>${entry.key.code} ${entry.key.name}</td>
      <c:set var="yearList" value="${entry.value}"/>
      <c:forEach var="i" items="${yearList}">
      		<td>${i.sum}</td>
      </c:forEach>
      
    </tr>
    </c:forEach>
</table>