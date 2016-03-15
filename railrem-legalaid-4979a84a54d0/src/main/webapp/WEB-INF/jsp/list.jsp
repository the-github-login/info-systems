<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8" %>
<jsp:include page="layouts/header.jsp"></jsp:include>

<div class="panel panel-default">
    <div class="panel-heading"><h1>Cписок пользователей</h1></div>
    <div class="panel-body">
        <ul class="list-group">
            <c:forEach items="${users}" var="item">
            <li class="list-group-item">

                    <spring:escapeBody>${item.fullName}</spring:escapeBody>
                <a href='/delete/<spring:escapeBody>${item.id}</spring:escapeBody>'>
                    <div>
                        <span class="glyphicon glyphicon-trash"></span>
                        <span class="glyphicon-class">Delete</span>
                    </div>
               </a>

                            <c:set var="isAdmin" value="false"/>

                        <c:forEach items="${item.getAuthorities()}" var="auth">
                        <c:choose>
                        <c:when test="${auth.getAuthority() =='ROLE_ADMIN'}">
                            <c:set var="isAdmin" value="true"/>
                        </c:when>
                        </c:choose>

                        </c:forEach>

                        <c:if test="${not isAdmin}">
                        <a href='/isus/<spring:escapeBody>${item.id}</spring:escapeBody>'>
                            <div>
                                <span class="glyphicon glyphicon-home"></span>
                                <span class="glyphicon-class">Cделать админом</span>
                            </div>
                        </a>
                        </c:if>

                        </c:forEach>
        </ul>
    </div>
</div>


<jsp:include page="layouts/footer.jsp"></jsp:include>