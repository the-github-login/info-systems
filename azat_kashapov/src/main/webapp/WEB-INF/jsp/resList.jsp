<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8" %>
<jsp:include page="layouts/header.jsp"></jsp:include>

<div class="panel panel-default">
  <div class="panel-heading"><h1>Вопросы на утверждение</h1></div>
  <div class="panel-body">
    <ul class="list-group">

      <c:choose>
        <c:when test="${not empty topics}">
        <c:forEach items="${topics}" var="item">

        <li class="list-group-item">

          <spring:escapeBody>Вопрос: ${item.theme} <br>  Пользователь: ${item.user.fullName}  <br> </spring:escapeBody>
          <a href='/acsess/<spring:escapeBody>${item.id}</spring:escapeBody>'>
            <div>
              <span class="glyphicon glyphicon-plus"></span>
              <span class="glyphicon-class">Разрешить</span>
            </div>
          </a>

          </c:forEach>
        </c:when>
        <c:otherwise>
          Вопросов на утверждение нет
        </c:otherwise>
      </c:choose>






    </ul>
  </div>
</div>


<jsp:include page="layouts/footer.jsp"></jsp:include>