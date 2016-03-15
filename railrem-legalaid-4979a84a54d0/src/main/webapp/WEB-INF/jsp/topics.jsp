<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@page pageEncoding="UTF-8"%>
<jsp:include page="layouts/header.jsp"></jsp:include>
<div class="panel panel-default">
    <div class="panel-heading"><h1>Обсуждения</h1></div>
    <div class="panel-body">

<c:forEach items="${topics}" var="item">
<div class="container">
    <div class="panel panel-default">


       <div class="panel-heading">
                ${item.user.fullName}
           </div>
        <div class="panel-body">
            <c:set var="string2" value="${fn:substring(item.theme, 0, 50)}" />

            ${string2}...
<br>
            <a href='/topic/<spring:escapeBody>${item.id}</spring:escapeBody>'>
                <div>
                    <span class="glyphicon glyphicon-share-alt"></span>
                    <span class="glyphicon-class">Открыть</span>
                </div>
            </a>

            <security:authorize access="hasRole('ADMIN')">
                <a href='/deleteTopic/<spring:escapeBody>${item.id}</spring:escapeBody>'>
                    <div>
                        <span class="glyphicon glyphicon-trash"></span>
                        <span class="glyphicon-class"></span>
                    </div>
                </a>
            </security:authorize>

        </div>
    </div>
</div>

</c:forEach>

    </div>
</div>
<jsp:include page="layouts/footer.jsp"></jsp:include>