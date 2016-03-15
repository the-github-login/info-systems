<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags/form" %>

<%@page pageEncoding="UTF-8" %>
<jsp:include page="layouts/header.jsp"></jsp:include>

<div class="center" align="center">

    <%--
      Creating own form tags as spring form tags wrappers: http://duckranger.com/2012/07/spring-mvc-and-twitter-bootstrap-customizing-the-input-fields/
    --%>
    <div class="row">

        <div class="col-md-4 col-md-offset-4">
            <c:if test="${error != null}">
                <div class="text-danger">
                    Wrong email-password.
                </div>
            </c:if>
            <form:form class="form-signin" role="form" method="POST" commandName="loginForm">
                <h2 class="form-signin-heading">Авторизация</h2>
                <t:input class="form-control" placeholder="Email address" label="E-mail" path="username"
                         required="true"/>
                <t:password class="form-control" placeholder="Password" label="Password" path="password"
                            required="true"/>

                <button type="submit" class="bbtn btn-lg btn-primary btn-block">Войти</button>
            </form:form></div>
    </div>


</div>
<jsp:include page="layouts/footer.jsp"></jsp:include>