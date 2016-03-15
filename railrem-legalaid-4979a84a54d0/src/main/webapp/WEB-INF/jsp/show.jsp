<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8" %>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:include page="layouts/header.jsp"></jsp:include>
<c:if test="${not empty cityList}">

    <div class="panel panel-default">
        <div class="panel-heading"><h1>список городов</h1></div>
        <div class="panel-body">
            <ul class="list-group">
                <c:forEach items="${cityList}" var="item">
                    <li class="list-group-item"><spring:escapeBody>${item.name}</spring:escapeBody></li>
                </c:forEach>
            </ul>
        </div>
    </div>

</c:if>
</body>
</html>
