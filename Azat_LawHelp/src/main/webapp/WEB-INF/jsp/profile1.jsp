<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8"%>
<jsp:include page="layouts/header.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <div class="col-md-9 col-md-push-3">
            <div class="list-group">
                <a href="#" class="list-group-item active">
                    <h3>Мои Обсуждения</h3>
                </a>
                <a href="#" class="list-group-item">обсуждение 1</a>
                <a href="#" class="list-group-item">обсуждение 1</a>
            </div>
        </div>
        <div class="col-md-3 col-md-pull-9">
            <div class="list-group">
                <a href="#" class="list-group-item active">
                    <h3>Мой профиль</h3>
                </a>

                <p class="list-group-item">имя</p>

                <p class="list-group-item">фамилия</p>

                <p class="list-group-item">почта</p>

                <p class="list-group-item">Страна</p>

                <p class="list-group-item">Город</p>

                <p class="list-group-item">социалный статус</p>

                <p>
                    <button type="button" class="btn btn-info">Редактировать</button>
                </p>


            </div>


        </div>

    </div>
</div>

<jsp:include page="layouts/footer.jsp"></jsp:include>