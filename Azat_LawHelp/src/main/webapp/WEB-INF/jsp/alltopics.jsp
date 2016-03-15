<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8"%>
<jsp:include page="layouts/header.jsp"></jsp:include>

<div class="container">


  <div class="list-group">
    <a href="#" class="list-group-item active">
      <h3>Обсуждения</h3>
    </a>
    <a href="#" class="list-group-item">обсуждение 1</a>
    <a href="#" class="list-group-item">обсуждение 1</a>

  </div>
</div>
<div class="container">
  <ul class="pagination">
    <li><a href="#">&laquo;</a></li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li><a href="#">&raquo;</a></li>
  </ul>
</div>
<jsp:include page="layouts/footer.jsp"></jsp:include>