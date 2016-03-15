<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags/form" %>
<%@page pageEncoding="UTF-8"%>
<jsp:include page="layouts/header.jsp"></jsp:include>
<div align="center">
  <div class="container">
    <div class="input-group">

        <c:if test="${not empty message}">
        <h4>Ваш вопрос отправлен,ожидайте потверждения администратора</h4>
        </c:if>

        <form:form action="/ask" class="form" role="form" method="post">

            <p>  <textarea rows="10" cols="50" path="theme" required="true"   placeholder="Подробно опишите о своей проблеме: причины,последствия,стороны участия"  NAME="theme"  style="width: 700px;height: 250px;" ></textarea></p>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Отправить</button>


        </form:form>

    </div>
  </div>
</div>
<jsp:include page="layouts/footer.jsp"></jsp:include>