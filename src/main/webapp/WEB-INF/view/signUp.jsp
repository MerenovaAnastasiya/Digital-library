<%--
  Created by IntelliJ IDEA.
  User: merenaas
  Date: 03.11.18
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <title>Title</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
    <link rel="stylesheet" href="/style/style.css">
</head>
<body class="align">


<div class="grid">
    <%--<form method="post" class="form login">--%>
    <form:form method="post" cssClass="form login" modelAttribute="user">
        <header class="login__header">
        </header>
        <div class="login__body">
            <div class="form__field">
                <form:input path="login"></form:input>
                <%--<input type="text" name="login" placeholder="<c:if test="${login == null}">Логин</c:if>" value="${login}" required>--%>
            </div>
            <%--<div class="error-message">--%>
                <%--<c:if test="${chekLogin == false}">--%>
                    <%--Неверный формат логина--%>
                <%--</c:if>--%>
                <%--<c:if test="${checkLoginForAvailability == false}">--%>
                    <%--Пользователь с таким логином уже существует--%>
                <%--</c:if>--%>
            <%--</div>--%>
            <div class="form__field">
                <form:input path="email"/>
                <%--<input type="email" name="email" placeholder="<c:if test="${email == null}">Email</c:if>" value="${email}" required>--%>
            </div>
            <%--<div class="error-message">--%>
                <%--<c:if test="${chekEmail == false}">--%>
                    <%--Неверный формат Email--%>
                <%--</c:if>--%>
                <%--<c:if test="${checkEmailForAvailability == false}">--%>
                    <%--Пользователь с таким Email уже существует--%>
                <%--</c:if>--%>
            <%--</div>--%>
            <div class="form__field">
                <form:password path="password"/>
                <%--<input type="password" name="password" placeholder="Пароль" required style="margin-bottom: 20px">--%>
            </div>
            <%--<div class="error-message">--%>
                <%--<c:if test="${chekPassword == false}">--%>
                    <%--Неверный формат пароля--%>
                <%--</c:if>--%>
            <%--</div>--%>
            <div class="form__field">
                <span>Запомнить меня </span>
                <form:checkbox path="checkbox"/>
                <%--<input type="checkbox" name="checkbox">--%>
            </div>
        </div>
        <footer class="login__footer">
            <input type="submit" value="Регистрация">
            <p><a href="/signIn">Вход</a></p>
        </footer>
    </form>
    </form:form>
</div>
</body>
</html>
