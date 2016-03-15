<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/jsp/layouts/header.jsp"></jsp:include>
<div class="container" align="center">

  <div class="starter-template">
    <div class="jumbotron jumbotron-center" >
      <img src="<c:url value="resources/img/jurist.jpg" />" class="img-responsive" alt="Responsive image">
      <p><a href="/ask" class="btn btn-primary btn-lg" role="button">Задать вопрос</a></p>
    </div>

  </div>

</div>
<jsp:include page="/WEB-INF/jsp/layouts/footer.jsp"></jsp:include>
