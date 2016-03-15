<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@page pageEncoding="UTF-8" %>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Юридическая клинника</title>

    <script type="text/javascript" src="<c:url value="resources/js/bootstrap.min.js" />"></script>
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap-theme.min.css" />" rel="stylesheet">

</head>


<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">

        <div class="navbar-header">

            <a class="navbar-brand" href="/"><img alt="Brand" src="<c:url value="/resources/img/logo.png" />" height="50"
                                                  width="50"></a>

            <p class="navbar-text-lg" width="100"><h4>Юридическая клинника</h4> </p>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="/ask">Задать Вопрос</a></li>
                <li><a href="/about">О нас</a></li>


                <security:authorize access="hasRole('ADMIN')">
                    <li><a href="${spring:mvcUrl('AC#list').build()}">Список</a></li>
                </security:authorize>
                <security:authorize access="hasRole('ADMIN')">
                    <li><a href="${spring:mvcUrl('AC#resList').build()}">Вопросы</a></li>
                </security:authorize>
                <li><a href="${spring:mvcUrl('TC#list').build()}">Обсуждения</a></li>
            </ul>
          <!--  <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Поиск</button>
            </form>-->
            <ul class="nav navbar-nav navbar-right">

                <security:authorize access="isAuthenticated()">
                    <li><a href="${spring:mvcUrl('SC#profile').build()}">Профиль</a></li>
                    <li><a href="<spring:url value="/logout" />">Выйти</a></li>
                </security:authorize>
                <security:authorize access="isAnonymous()">
                    <li><a href="${spring:mvcUrl('SC#register').build()}">Регистрация</a></li>
                    <li><a href="<spring:url value="/login"/>">Войти</a></li>
                </security:authorize>


            </ul>
        </div>

    </div>
    <!-- /.container-fluid -->
</nav>
