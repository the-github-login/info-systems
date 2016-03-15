<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@page pageEncoding="UTF-8" %>
<jsp:include page="layouts/header.jsp"></jsp:include>

<div class="container">
    <div class="panel panel-default">


        <div class="panel-heading">
            <c:if test="${not empty topic.user}">
                ${topic.user.fullName}
            </c:if>
            <c:if test="${ empty topic.user}">
                Удаленный пользователь
            </c:if>
        </div>
        <div class="panel-body">
            ${topic.theme}
        </div>
    </div>
</div>
<br>
<br>
<br>
<security:authorize access="isAuthenticated()">
    <security:authentication property="principal.id" var="id"/>
</security:authorize>
<c:if test="${not empty messages}">
<c:forEach items="${messages}" var="item">
    <div class="container">
        <div class="panel panel-default">


            <div class="panel-heading">
                <c:if test="${not empty item.user}">
                    ${item.user.fullName}
                </c:if>
                <c:if test="${ empty item.user}">
                    Удаленный пользователь
                </c:if>
            </div>
            <div class="panel-body">
                    ${item.message}
                <br>
                <security:authorize access="isAuthenticated()">
                    <c:if test="${not empty item.user}">
                    <c:choose>
                           <c:when test="${item.user.id eq id}">
                                <a href='/deleteMessage/<spring:escapeBody>${item.id}</spring:escapeBody>'>
                                    <div>
                                        <span class="glyphicon glyphicon-trash"></span>
                                        <span class="glyphicon-class"></span>
                                    </div>
                                </a>

                            </c:when>
                        <c:otherwise>
                            <security:authorize access="hasRole('ADMIN')">
                                <a href='/deleteMessage/<spring:escapeBody>${item.id}</spring:escapeBody>'>
                                    <div>
                                        <span class="glyphicon glyphicon-trash"></span>
                                        <span class="glyphicon-class"></span>
                                    </div>
                                </a>
                            </security:authorize>
                        </c:otherwise>
                    </c:choose>
                    </c:if>
                </security:authorize>
            </div>
        </div>
    </div>

</c:forEach>
</c:if>
<security:authorize access="isAuthenticated()">
    <div align="center">
        <div class="container">
            <div class="input-group">
                <form:form action="/send/${topic.id}" class="form" role="form" method="post">

                    <p><textarea rows="10" cols="50" path="content" required="true" NAME="content"
                                 style="width: 700px;height: 50px;"></textarea></p>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Отправить</button>


                </form:form>
            </div>
        </div>
    </div>
</security:authorize>
<jsp:include page="layouts/footer.jsp"></jsp:include>