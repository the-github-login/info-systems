<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags/form" %>
<%@page pageEncoding="UTF-8"%>
<jsp:include page="layouts/header.jsp"></jsp:include>

<div class="center" align="center" >

    <%--
      Creating own form tags as spring form tags wrappers: http://duckranger.com/2012/07/spring-mvc-and-twitter-bootstrap-customizing-the-input-fields/
    --%>

      <form:form class="form-vertical" method="POST" commandName="user">
      <p>  <t:input label="E-mail" path="username" required="true"  placeholder="e-mail" /></p>
        <p> <t:input label="Name" path="fullName" required="true"  placeholder="ФИО" /></p>
        <p><t:password label="Password" path="password" required="true"  placeholder="Пароль" /></p>
        <p><t:password label="Password Repeat" path="passwordRepeat" required="true" placeholder="Повторите пароль" /></p>

        <button type="submit" class="btn btn-success">Регистрация</button>
      </form:form>



</div>
<jsp:include page="layouts/footer.jsp"></jsp:include>