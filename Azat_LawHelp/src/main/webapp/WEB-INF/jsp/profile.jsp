<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page pageEncoding="UTF-8" %>
<jsp:include page="layouts/header.jsp"></jsp:include>


<table class="table">


    <tr>
        <td>ФИО</td>
        <td><security:authentication property="principal.fullName"/></td>
    </tr>
    <tr>
        <td>e-mail</td>
        <td><security:authentication property="principal.username"/></td>
    </tr>
    <tr>
        <td>Роли</td>
        <td><security:authentication property="authorities" var="roles"/>
            <c:forEach var="authority" items="${roles}" varStatus="authoritiesLoop">
                ${authority}<c:if test="${!authoritiesLoop.last}">, </c:if>
            </c:forEach></td>
    </tr>


    <!--  <p class="list-group-item">Имя <security:authentication property="principal.fullName"/></p>

        <p class="list-group-item">почта <security:authentication property="principal.username"/></p>

        <p class="list-group-item">Роли <%-- Authorities or principal.authorities - see documentation --%>
            <security:authentication property="authorities" var="roles"/>
            <c:forEach var="authority" items="${roles}" varStatus="authoritiesLoop">
                ${authority}<c:if test="${!authoritiesLoop.last}">, </c:if>
            </c:forEach></p>

-->
</table>


<jsp:include page="layouts/footer.jsp"></jsp:include>
